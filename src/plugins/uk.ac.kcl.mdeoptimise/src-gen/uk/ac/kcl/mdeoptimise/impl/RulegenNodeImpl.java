/**
 * generated by Xtext 2.10.0
 */
package uk.ac.kcl.mdeoptimise.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import uk.ac.kcl.mdeoptimise.MdeoptimisePackage;
import uk.ac.kcl.mdeoptimise.RulegenNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rulegen Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uk.ac.kcl.mdeoptimise.impl.RulegenNodeImpl#getNode <em>Node</em>}</li>
 *   <li>{@link uk.ac.kcl.mdeoptimise.impl.RulegenNodeImpl#getGenerationRestriction <em>Generation Restriction</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RulegenNodeImpl extends MinimalEObjectImpl.Container implements RulegenNode
{
  /**
   * The default value of the '{@link #getNode() <em>Node</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNode()
   * @generated
   * @ordered
   */
  protected static final String NODE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNode() <em>Node</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNode()
   * @generated
   * @ordered
   */
  protected String node = NODE_EDEFAULT;

  /**
   * The default value of the '{@link #getGenerationRestriction() <em>Generation Restriction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGenerationRestriction()
   * @generated
   * @ordered
   */
  protected static final String GENERATION_RESTRICTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getGenerationRestriction() <em>Generation Restriction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGenerationRestriction()
   * @generated
   * @ordered
   */
  protected String generationRestriction = GENERATION_RESTRICTION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RulegenNodeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MdeoptimisePackage.Literals.RULEGEN_NODE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getNode()
  {
    return node;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNode(String newNode)
  {
    String oldNode = node;
    node = newNode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MdeoptimisePackage.RULEGEN_NODE__NODE, oldNode, node));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getGenerationRestriction()
  {
    return generationRestriction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGenerationRestriction(String newGenerationRestriction)
  {
    String oldGenerationRestriction = generationRestriction;
    generationRestriction = newGenerationRestriction;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MdeoptimisePackage.RULEGEN_NODE__GENERATION_RESTRICTION, oldGenerationRestriction, generationRestriction));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MdeoptimisePackage.RULEGEN_NODE__NODE:
        return getNode();
      case MdeoptimisePackage.RULEGEN_NODE__GENERATION_RESTRICTION:
        return getGenerationRestriction();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MdeoptimisePackage.RULEGEN_NODE__NODE:
        setNode((String)newValue);
        return;
      case MdeoptimisePackage.RULEGEN_NODE__GENERATION_RESTRICTION:
        setGenerationRestriction((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MdeoptimisePackage.RULEGEN_NODE__NODE:
        setNode(NODE_EDEFAULT);
        return;
      case MdeoptimisePackage.RULEGEN_NODE__GENERATION_RESTRICTION:
        setGenerationRestriction(GENERATION_RESTRICTION_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MdeoptimisePackage.RULEGEN_NODE__NODE:
        return NODE_EDEFAULT == null ? node != null : !NODE_EDEFAULT.equals(node);
      case MdeoptimisePackage.RULEGEN_NODE__GENERATION_RESTRICTION:
        return GENERATION_RESTRICTION_EDEFAULT == null ? generationRestriction != null : !GENERATION_RESTRICTION_EDEFAULT.equals(generationRestriction);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (node: ");
    result.append(node);
    result.append(", generationRestriction: ");
    result.append(generationRestriction);
    result.append(')');
    return result.toString();
  }

} //RulegenNodeImpl
