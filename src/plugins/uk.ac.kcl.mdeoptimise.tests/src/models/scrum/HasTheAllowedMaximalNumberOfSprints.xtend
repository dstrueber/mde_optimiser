package models.scrum

import org.eclipse.emf.ecore.EObject
import uk.ac.kcl.interpreter.IGuidanceFunction
import org.eclipse.emf.common.util.EList

class HasTheAllowedMaximalNumberOfSprints implements IGuidanceFunction {
	
	override computeFitness(EObject model) {
		
		var workitems = ((model.getFeature("backlog") as EObject).getFeature("workitems") as EList<EObject>);
		
		var totalEffort = workitems.fold(0)[result, item | result + (item.getFeature("Effort") as Integer)];
		
		var desiredSprints = 0d;
		var maximumVelocity = 25;
		
		if(totalEffort > maximumVelocity){
		
			desiredSprints = Double.parseDouble(totalEffort.toString) / maximumVelocity;
		
			if(desiredSprints -  desiredSprints.intValue > 0.5d){
				desiredSprints = Math.ceil(desiredSprints)
			} else {
				desiredSprints = Math.floor(desiredSprints)
			}
		
		}
		
		var sprints = (model.getFeature("sprints") as EList<EObject>).filter[ 
			sprint | (sprint.getFeature("committedItem") as EList<EObject>).length > 0].toList
		
		
		println("Counted sprints: " + sprints.length)
		println("Counted maximal desired sprints: " + desiredSprints)
		
		//If we have less than the minimum number of desired sprints
		if(sprints.length > desiredSprints) {
			return  desiredSprints - sprints.length;
		}
		
		return 0
		
	}
	
	override getName() {
		return "Has the allowed maximal number of sprints"
	}
	
	/**
	 * Helper function getting the value of the named feature (if it exists) for the given EObject.
	 */
	def Object getFeature (EObject o, String feature) {
		
		if(o === null){
			println("Null object given")
		}
		
		o.eGet(o.eClass.getEStructuralFeature(feature))
		
	}	
}