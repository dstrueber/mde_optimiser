/**
 * generated by Xtext 2.12.0
 */
package org.xtext.example.mydsl.myDsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.example.mydsl.myDsl.Clause;
import org.xtext.example.mydsl.myDsl.ComponentRequirement;
import org.xtext.example.mydsl.myDsl.Implementation;
import org.xtext.example.mydsl.myDsl.MyDslPackage;
import org.xtext.example.mydsl.myDsl.ResourceRequirement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.ImplementationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.ImplementationImpl#getComponentRequirements <em>Component Requirements</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.ImplementationImpl#getResourceRequirements <em>Resource Requirements</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.ImplementationImpl#getClauses <em>Clauses</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImplementationImpl extends MinimalEObjectImpl.Container implements Implementation
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getComponentRequirements() <em>Component Requirements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComponentRequirements()
   * @generated
   * @ordered
   */
  protected EList<ComponentRequirement> componentRequirements;

  /**
   * The cached value of the '{@link #getResourceRequirements() <em>Resource Requirements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResourceRequirements()
   * @generated
   * @ordered
   */
  protected EList<ResourceRequirement> resourceRequirements;

  /**
   * The cached value of the '{@link #getClauses() <em>Clauses</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClauses()
   * @generated
   * @ordered
   */
  protected EList<Clause> clauses;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ImplementationImpl()
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
    return MyDslPackage.Literals.IMPLEMENTATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.IMPLEMENTATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ComponentRequirement> getComponentRequirements()
  {
    if (componentRequirements == null)
    {
      componentRequirements = new EObjectContainmentEList<ComponentRequirement>(ComponentRequirement.class, this, MyDslPackage.IMPLEMENTATION__COMPONENT_REQUIREMENTS);
    }
    return componentRequirements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ResourceRequirement> getResourceRequirements()
  {
    if (resourceRequirements == null)
    {
      resourceRequirements = new EObjectContainmentEList<ResourceRequirement>(ResourceRequirement.class, this, MyDslPackage.IMPLEMENTATION__RESOURCE_REQUIREMENTS);
    }
    return resourceRequirements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Clause> getClauses()
  {
    if (clauses == null)
    {
      clauses = new EObjectContainmentEList<Clause>(Clause.class, this, MyDslPackage.IMPLEMENTATION__CLAUSES);
    }
    return clauses;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MyDslPackage.IMPLEMENTATION__COMPONENT_REQUIREMENTS:
        return ((InternalEList<?>)getComponentRequirements()).basicRemove(otherEnd, msgs);
      case MyDslPackage.IMPLEMENTATION__RESOURCE_REQUIREMENTS:
        return ((InternalEList<?>)getResourceRequirements()).basicRemove(otherEnd, msgs);
      case MyDslPackage.IMPLEMENTATION__CLAUSES:
        return ((InternalEList<?>)getClauses()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case MyDslPackage.IMPLEMENTATION__NAME:
        return getName();
      case MyDslPackage.IMPLEMENTATION__COMPONENT_REQUIREMENTS:
        return getComponentRequirements();
      case MyDslPackage.IMPLEMENTATION__RESOURCE_REQUIREMENTS:
        return getResourceRequirements();
      case MyDslPackage.IMPLEMENTATION__CLAUSES:
        return getClauses();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MyDslPackage.IMPLEMENTATION__NAME:
        setName((String)newValue);
        return;
      case MyDslPackage.IMPLEMENTATION__COMPONENT_REQUIREMENTS:
        getComponentRequirements().clear();
        getComponentRequirements().addAll((Collection<? extends ComponentRequirement>)newValue);
        return;
      case MyDslPackage.IMPLEMENTATION__RESOURCE_REQUIREMENTS:
        getResourceRequirements().clear();
        getResourceRequirements().addAll((Collection<? extends ResourceRequirement>)newValue);
        return;
      case MyDslPackage.IMPLEMENTATION__CLAUSES:
        getClauses().clear();
        getClauses().addAll((Collection<? extends Clause>)newValue);
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
      case MyDslPackage.IMPLEMENTATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case MyDslPackage.IMPLEMENTATION__COMPONENT_REQUIREMENTS:
        getComponentRequirements().clear();
        return;
      case MyDslPackage.IMPLEMENTATION__RESOURCE_REQUIREMENTS:
        getResourceRequirements().clear();
        return;
      case MyDslPackage.IMPLEMENTATION__CLAUSES:
        getClauses().clear();
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
      case MyDslPackage.IMPLEMENTATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case MyDslPackage.IMPLEMENTATION__COMPONENT_REQUIREMENTS:
        return componentRequirements != null && !componentRequirements.isEmpty();
      case MyDslPackage.IMPLEMENTATION__RESOURCE_REQUIREMENTS:
        return resourceRequirements != null && !resourceRequirements.isEmpty();
      case MyDslPackage.IMPLEMENTATION__CLAUSES:
        return clauses != null && !clauses.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ImplementationImpl