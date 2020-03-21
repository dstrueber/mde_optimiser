/**
 * generated by Xtext 2.17.0
 */
package uk.ac.kcl.inf.mdeoptimiser.languages.mopt;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicity Refinement Spec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.kcl.inf.mdeoptimiser.languages.mopt.MultiplicityRefinementSpec#getNode <em>Node</em>}</li>
 *   <li>{@link uk.ac.kcl.inf.mdeoptimiser.languages.mopt.MultiplicityRefinementSpec#getEdge <em>Edge</em>}</li>
 *   <li>{@link uk.ac.kcl.inf.mdeoptimiser.languages.mopt.MultiplicityRefinementSpec#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link uk.ac.kcl.inf.mdeoptimiser.languages.mopt.MultiplicityRefinementSpec#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 *
 * @see uk.ac.kcl.inf.mdeoptimiser.languages.mopt.MoptPackage#getMultiplicityRefinementSpec()
 * @model
 * @generated
 */
public interface MultiplicityRefinementSpec extends EObject
{
  /**
   * Returns the value of the '<em><b>Node</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Node</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Node</em>' attribute.
   * @see #setNode(String)
   * @see uk.ac.kcl.inf.mdeoptimiser.languages.mopt.MoptPackage#getMultiplicityRefinementSpec_Node()
   * @model
   * @generated
   */
  String getNode();

  /**
   * Sets the value of the '{@link uk.ac.kcl.inf.mdeoptimiser.languages.mopt.MultiplicityRefinementSpec#getNode <em>Node</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Node</em>' attribute.
   * @see #getNode()
   * @generated
   */
  void setNode(String value);

  /**
   * Returns the value of the '<em><b>Edge</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Edge</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Edge</em>' attribute.
   * @see #setEdge(String)
   * @see uk.ac.kcl.inf.mdeoptimiser.languages.mopt.MoptPackage#getMultiplicityRefinementSpec_Edge()
   * @model
   * @generated
   */
  String getEdge();

  /**
   * Sets the value of the '{@link uk.ac.kcl.inf.mdeoptimiser.languages.mopt.MultiplicityRefinementSpec#getEdge <em>Edge</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Edge</em>' attribute.
   * @see #getEdge()
   * @generated
   */
  void setEdge(String value);

  /**
   * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lower Bound</em>' attribute.
   * @see #setLowerBound(int)
   * @see uk.ac.kcl.inf.mdeoptimiser.languages.mopt.MoptPackage#getMultiplicityRefinementSpec_LowerBound()
   * @model
   * @generated
   */
  int getLowerBound();

  /**
   * Sets the value of the '{@link uk.ac.kcl.inf.mdeoptimiser.languages.mopt.MultiplicityRefinementSpec#getLowerBound <em>Lower Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lower Bound</em>' attribute.
   * @see #getLowerBound()
   * @generated
   */
  void setLowerBound(int value);

  /**
   * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Upper Bound</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Upper Bound</em>' attribute.
   * @see #setUpperBound(Integer)
   * @see uk.ac.kcl.inf.mdeoptimiser.languages.mopt.MoptPackage#getMultiplicityRefinementSpec_UpperBound()
   * @model
   * @generated
   */
  Integer getUpperBound();

  /**
   * Sets the value of the '{@link uk.ac.kcl.inf.mdeoptimiser.languages.mopt.MultiplicityRefinementSpec#getUpperBound <em>Upper Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Upper Bound</em>' attribute.
   * @see #getUpperBound()
   * @generated
   */
  void setUpperBound(Integer value);

} // MultiplicityRefinementSpec