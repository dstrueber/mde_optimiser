package uk.ac.kcl.ui.output

import java.util.Date
import java.util.List
import java.util.LinkedList
import org.eclipse.emf.ecore.resource.ResourceSet
import uk.ac.kcl.mdeoptimise.Optimisation
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.EObject
import java.util.Collections
import java.text.SimpleDateFormat
import uk.ac.kcl.optimisation.moea.MoeaOptimisationSolution
import java.io.PrintWriter
import java.io.File
import org.eclipse.emf.common.util.URI
import org.eclipse.core.runtime.IPath
import java.util.TimeZone
import java.util.HashMap
import com.google.common.io.Files
import java.nio.charset.Charset
import java.util.ArrayList
import uk.ac.kcl.mdeoptimise.EvolverType
import org.supercsv.io.CsvListWriter
import java.io.FileWriter
import org.supercsv.prefs.CsvPreference

class MDEOResultsOutput {
	
	private Date experimentStartTime;
	private List<MDEOBatch> batches;
	private ResourceSet resourceSet;
	private IPath projectRoot;
	private IPath moptFile;
	private Optimisation moptConfiguration;
	
	new(Date startTime, IPath projectRoot, IPath moptFile, Optimisation moptConfiguration){
		experimentStartTime = startTime
		//Store output of a batch experiment id, solutions set
		batches = new LinkedList<MDEOBatch>();
		this.resourceSet = new ResourceSetImpl();
		this.projectRoot = projectRoot;
		this.moptConfiguration = moptConfiguration;
		this.moptFile = moptFile;
	}
	
	def void logBatch(MDEOBatch batch){
		batches.add(batch);
	}
	
	def String outputBatchSummary(MDEOBatch batch, IPath outcomePath) {
		var batchOutputPath = outcomePath.append(String.format("batch-%s/", batch.id))
		var batchInfoPath = batchOutputPath.append("outcome.txt")
		
		var outputFile = new File(batchInfoPath.toPortableString)
		Files.createParentDirs(outputFile)
		
		val batchWriter = new PrintWriter(outputFile)
		
		writeModel(batch.initialModel, batchOutputPath + String.format("initial-model-%08X", batch.initialModel.hashCode) + ".xmi")
		
		var batchDuration = new Date(batch.duration.longValue);
		
		var formatter = new SimpleDateFormat("HH:mm:ss.SSS");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		batchWriter.println()
		batchWriter.println("============================================")
		batchWriter.println()
		batchWriter.println(String.format("Batch %s duration: %s", batch.id, formatter.format(batchDuration.getTime())))
		batchWriter.println()

		batchWriter.println("--------------------------------------------")
		
		for(var i = 0; i < batch.solutions.length; i++){
			
			val solution = batch.solutions.get(i);
			val modelPath = batchOutputPath + String.format("%08X", solution.model.hashCode) + ".xmi"
			
			solution.model.writeModel(modelPath)
			storeSolutionData(batchWriter, modelPath, solution)
		}
		
		batchWriter.println()
		batchWriter.println("============================================")
		batchWriter.println()
		batchWriter.close
		
		return Files.toString(outputFile, Charset.defaultCharset())
	}
	
	def void outputExperimentAsCsv(List<MDEOBatch> batches, IPath outcomePath, IPath moptFile, 
		Optimisation moptConfiguration, String experimentDate
	){
		
		val csvHeader = getCSVHeaders(moptConfiguration)		
		val csvRows = new ArrayList<LinkedList<Object>>();
		val formatter = new SimpleDateFormat("HH:mm:ss.SSS");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		batches.forEach[batch | 
			
			batch.solutions.forEach[solution |
			
				val csvRow = new LinkedList<Object>();
				csvRow.add(batch.id)
				csvRow.add(moptFile)
				csvRow.add(moptConfiguration.model.location)
				csvRow.add(outcomePath.append(String.format("batch-%s/", batch.id))
					.append(String.format("input-model-%08X", batch.initialModel.hashCode) + ".xmi")
				)				csvRow.add(outcomePath.append(String.format("batch-%s/", batch.id))
					.append(String.format("%08X", solution.model.hashCode) + ".xmi")
				)
				csvRow.add(formatter.format(new Date(batch.duration.longValue).getTime()))
				
				solution.formattedObjectives.forEach[p1, p2|
					csvRow.add(-1 * p2)
				]
				
				solution.formattedConstraints.forEach[p1, p2|
					csvRow.add(p2)
				]	
				
				moptConfiguration.evolvers.filter[evolver | evolver.evolverType == EvolverType.MUTATE]
					.forEach[evolver, index| csvRow.add(evolver.unit)]
		
				moptConfiguration.evolvers.filter[evolver | evolver.evolverType == EvolverType.BREED]
					.forEach[evolver, index| csvRow.add(evolver.unit)]
				
				csvRow.add(moptConfiguration.optimisation.algorithmName)
				
				if(moptConfiguration.optimisation.algorithmVariation.simpleVariation != null){ 
					csvRow.add(moptConfiguration.optimisation.algorithmVariation.simpleVariation)
					csvRow.add(100)
					csvRow.add(100)
				} else {
					csvRow.add(moptConfiguration.optimisation.algorithmVariation.probabilityVariation.type)
					csvRow.add(moptConfiguration.optimisation.algorithmVariation.probabilityVariation.mutation_rate)
					csvRow.add(moptConfiguration.optimisation.algorithmVariation.probabilityVariation.crossover_rate)	
				}
				
				csvRow.add(moptConfiguration.optimisation.algorithmPopulation)
				csvRow.add(moptConfiguration.optimisation.algorithmEvolutions)
				
				csvRows.add(csvRow)
			]
		]
	
        val listWriter = new CsvListWriter(new FileWriter(outcomePath.append(experimentDate + "-outcome.csv").toPortableString),
                CsvPreference.STANDARD_PREFERENCE);
        
        // write the header
        listWriter.writeHeader(csvHeader);
        
        // write the customer lists  
        csvRows.forEach[row | listWriter.write(row)]
        listWriter.close();
               
	}
	
	def List<String> getCSVHeaders(Optimisation moptConfiguration){
		val header = new ArrayList<String>();
		
		header.add("batch-id")
		header.add("mopt-file")
		header.add("input-model")
		header.add("initialized-input-model")
		header.add("outcome-path")
		header.add("duration")
		
		for(var i = 0; i < batches.get(0).solutions.get(0).formattedObjectives.size; i++){
			header.add("objective-" + i)
		}
		
		for(var i = 0; i < batches.get(0).solutions.get(0).formattedConstraints.size; i++){
			header.add("constraint-" + i)
		}
		
		moptConfiguration.evolvers.filter[evolver | evolver.evolverType == EvolverType.MUTATE]
			.forEach[evolver, index| header.add("mutation-operator-" + index)]
		
		moptConfiguration.evolvers.filter[evolver | evolver.evolverType == EvolverType.BREED]
			.forEach[evolver, index| header.add("crossover-operator-" + index)]
		
		header.add("algorithm")
		header.add("variation")
		header.add("mutation-probability")
		header.add("crossover-probability")
		header.add("population")
		header.add("evolutions")
		
		return header
	}
	
	def void outputExperimentSummary(List<MDEOBatch> batches, IPath outcomePath, IPath moptFile, StringBuilder batchesOutput){
		
		val averageTime = batches.fold(0.0, [acc, batch | acc + batch.duration])/batches.length
		val averageObjectiveValues = new HashMap<String, Double>();
		var formatter = new SimpleDateFormat("HH:mm:ss.SSS");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		for(var i = 0; i < batches.size; i++){

			val batch = batches.get(i);			
			val averageBatchObjectives = new HashMap<String, Double>();
			
			batch.solutions.forEach[solution | 
				solution.formattedObjectives.forEach[p1, p2| 
					if(averageBatchObjectives.containsKey(p1)) {
						averageBatchObjectives.put(p1, averageBatchObjectives.get(p1) + p2)
					} else {
						averageBatchObjectives.put(p1, p2)	
					}
				]
			]
			
			averageBatchObjectives.forEach[p1, p2 |
				if(averageObjectiveValues.containsKey(p1)){
					averageObjectiveValues.put(p1, averageObjectiveValues.get(p1) + p2)
				} else {
					averageObjectiveValues.put(p1, p2);	
				}
			]
		}
				
		val infoWriter = new PrintWriter(new File(outcomePath + "overall-results.txt"))
		
		infoWriter.println(String.format("Average experiment time: %s", formatter.format(averageTime)))
		infoWriter.println()
		averageObjectiveValues.forEach[p1, p2|
			infoWriter.println(String.format("Average value for %s objective: %s", p1, -1 * averageObjectiveValues.get(p1)/batches.size))
		]
		
		infoWriter.println(batchesOutput.toString)
		
		infoWriter.close
		
		if(!moptFile.empty){
			Files.copy(new File(moptFile.toPortableString), 
				new File(outcomePath.append(moptFile.lastSegment).toPortableString))
		}
	}
	
	def void saveOutcome(){
		
		val experimentDate = new SimpleDateFormat("yyMMdd-HHmmss").format(experimentStartTime);
		val outcomePath = projectRoot.append(String.format("mdeo-results/experiment-%s/", experimentDate));
		
		val batchesOutput = new StringBuilder();
		
		batches.forEach[ batch | batchesOutput.append(outputBatchSummary(batch, outcomePath))]
		
		outputExperimentSummary(batches, outcomePath, moptFile, batchesOutput)
		outputExperimentAsCsv(batches, outcomePath, moptFile, moptConfiguration, experimentDate)
	}
	
	def writeModel(EObject model, String path) {
		val resource = resourceSet.createResource(URI.createFileURI(path))
		if (resource.loaded) {
			resource.contents.clear
		}
		resource.contents.add(model)
		resource.save(Collections.EMPTY_MAP)
	}

	private def storeSolutionData(PrintWriter infoWriter, String modelPath, MoeaOptimisationSolution solution){
		
		infoWriter.println("Evaluation data for solution: " + modelPath)
		infoWriter.println()
		infoWriter.println("Objective values:")
		
		//Pretty print the objectives
		var objectives = solution.formattedObjectives
		objectives.forEach[key, value | 
			infoWriter.println(String.format("%s: %s", key, -1 * value))
		]
		infoWriter.println("")

		//Pretty print the constraints
		var constraints = solution.formattedConstraints
		if(constraints.size > 0) {
			
			infoWriter.println("Constraint values:")
			constraints.forEach[key, value | 
				infoWriter.println(String.format("%s: %s", key, value))
			]
		}
	}
}