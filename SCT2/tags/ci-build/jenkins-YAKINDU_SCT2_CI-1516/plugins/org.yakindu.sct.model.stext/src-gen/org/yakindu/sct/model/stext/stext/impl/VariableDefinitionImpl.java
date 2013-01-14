/**
 */
package org.yakindu.sct.model.stext.stext.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.yakindu.base.types.Feature;
import org.yakindu.base.types.Property;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypedElement;
import org.yakindu.base.types.TypesPackage;

import org.yakindu.sct.model.sgraph.impl.VariableImpl;

import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.StextPackage;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.VariableDefinitionImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.VariableDefinitionImpl#getOwningType <em>Owning Type</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.VariableDefinitionImpl#isReadonly <em>Readonly</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.VariableDefinitionImpl#isExternal <em>External</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.VariableDefinitionImpl#getInitialValue <em>Initial Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableDefinitionImpl extends VariableImpl implements VariableDefinition
{
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected Type type;

  /**
   * The default value of the '{@link #isReadonly() <em>Readonly</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isReadonly()
   * @generated
   * @ordered
   */
  protected static final boolean READONLY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isReadonly() <em>Readonly</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isReadonly()
   * @generated
   * @ordered
   */
  protected boolean readonly = READONLY_EDEFAULT;

  /**
   * The default value of the '{@link #isExternal() <em>External</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExternal()
   * @generated
   * @ordered
   */
  protected static final boolean EXTERNAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isExternal() <em>External</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExternal()
   * @generated
   * @ordered
   */
  protected boolean external = EXTERNAL_EDEFAULT;

  /**
   * The cached value of the '{@link #getInitialValue() <em>Initial Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitialValue()
   * @generated
   * @ordered
   */
  protected Expression initialValue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VariableDefinitionImpl()
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
    return StextPackage.Literals.VARIABLE_DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (Type)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, StextPackage.VARIABLE_DEFINITION__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(Type newType)
  {
    Type oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.VARIABLE_DEFINITION__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getOwningType()
  {
    if (eContainerFeatureID() != StextPackage.VARIABLE_DEFINITION__OWNING_TYPE) return null;
    return (Type)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOwningType(Type newOwningType, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newOwningType, StextPackage.VARIABLE_DEFINITION__OWNING_TYPE, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOwningType(Type newOwningType)
  {
    if (newOwningType != eInternalContainer() || (eContainerFeatureID() != StextPackage.VARIABLE_DEFINITION__OWNING_TYPE && newOwningType != null))
    {
      if (EcoreUtil.isAncestor(this, newOwningType))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newOwningType != null)
        msgs = ((InternalEObject)newOwningType).eInverseAdd(this, TypesPackage.TYPE__FEATURES, Type.class, msgs);
      msgs = basicSetOwningType(newOwningType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.VARIABLE_DEFINITION__OWNING_TYPE, newOwningType, newOwningType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isReadonly()
  {
    return readonly;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReadonly(boolean newReadonly)
  {
    boolean oldReadonly = readonly;
    readonly = newReadonly;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.VARIABLE_DEFINITION__READONLY, oldReadonly, readonly));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isExternal()
  {
    return external;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExternal(boolean newExternal)
  {
    boolean oldExternal = external;
    external = newExternal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.VARIABLE_DEFINITION__EXTERNAL, oldExternal, external));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getInitialValue()
  {
    return initialValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInitialValue(Expression newInitialValue, NotificationChain msgs)
  {
    Expression oldInitialValue = initialValue;
    initialValue = newInitialValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StextPackage.VARIABLE_DEFINITION__INITIAL_VALUE, oldInitialValue, newInitialValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInitialValue(Expression newInitialValue)
  {
    if (newInitialValue != initialValue)
    {
      NotificationChain msgs = null;
      if (initialValue != null)
        msgs = ((InternalEObject)initialValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StextPackage.VARIABLE_DEFINITION__INITIAL_VALUE, null, msgs);
      if (newInitialValue != null)
        msgs = ((InternalEObject)newInitialValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StextPackage.VARIABLE_DEFINITION__INITIAL_VALUE, null, msgs);
      msgs = basicSetInitialValue(newInitialValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.VARIABLE_DEFINITION__INITIAL_VALUE, newInitialValue, newInitialValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case StextPackage.VARIABLE_DEFINITION__OWNING_TYPE:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetOwningType((Type)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
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
      case StextPackage.VARIABLE_DEFINITION__OWNING_TYPE:
        return basicSetOwningType(null, msgs);
      case StextPackage.VARIABLE_DEFINITION__INITIAL_VALUE:
        return basicSetInitialValue(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
  {
    switch (eContainerFeatureID())
    {
      case StextPackage.VARIABLE_DEFINITION__OWNING_TYPE:
        return eInternalContainer().eInverseRemove(this, TypesPackage.TYPE__FEATURES, Type.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
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
      case StextPackage.VARIABLE_DEFINITION__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case StextPackage.VARIABLE_DEFINITION__OWNING_TYPE:
        return getOwningType();
      case StextPackage.VARIABLE_DEFINITION__READONLY:
        return isReadonly();
      case StextPackage.VARIABLE_DEFINITION__EXTERNAL:
        return isExternal();
      case StextPackage.VARIABLE_DEFINITION__INITIAL_VALUE:
        return getInitialValue();
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
      case StextPackage.VARIABLE_DEFINITION__TYPE:
        setType((Type)newValue);
        return;
      case StextPackage.VARIABLE_DEFINITION__OWNING_TYPE:
        setOwningType((Type)newValue);
        return;
      case StextPackage.VARIABLE_DEFINITION__READONLY:
        setReadonly((Boolean)newValue);
        return;
      case StextPackage.VARIABLE_DEFINITION__EXTERNAL:
        setExternal((Boolean)newValue);
        return;
      case StextPackage.VARIABLE_DEFINITION__INITIAL_VALUE:
        setInitialValue((Expression)newValue);
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
      case StextPackage.VARIABLE_DEFINITION__TYPE:
        setType((Type)null);
        return;
      case StextPackage.VARIABLE_DEFINITION__OWNING_TYPE:
        setOwningType((Type)null);
        return;
      case StextPackage.VARIABLE_DEFINITION__READONLY:
        setReadonly(READONLY_EDEFAULT);
        return;
      case StextPackage.VARIABLE_DEFINITION__EXTERNAL:
        setExternal(EXTERNAL_EDEFAULT);
        return;
      case StextPackage.VARIABLE_DEFINITION__INITIAL_VALUE:
        setInitialValue((Expression)null);
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
      case StextPackage.VARIABLE_DEFINITION__TYPE:
        return type != null;
      case StextPackage.VARIABLE_DEFINITION__OWNING_TYPE:
        return getOwningType() != null;
      case StextPackage.VARIABLE_DEFINITION__READONLY:
        return readonly != READONLY_EDEFAULT;
      case StextPackage.VARIABLE_DEFINITION__EXTERNAL:
        return external != EXTERNAL_EDEFAULT;
      case StextPackage.VARIABLE_DEFINITION__INITIAL_VALUE:
        return initialValue != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == TypedElement.class)
    {
      switch (derivedFeatureID)
      {
        case StextPackage.VARIABLE_DEFINITION__TYPE: return TypesPackage.TYPED_ELEMENT__TYPE;
        default: return -1;
      }
    }
    if (baseClass == Feature.class)
    {
      switch (derivedFeatureID)
      {
        case StextPackage.VARIABLE_DEFINITION__OWNING_TYPE: return TypesPackage.FEATURE__OWNING_TYPE;
        default: return -1;
      }
    }
    if (baseClass == Property.class)
    {
      switch (derivedFeatureID)
      {
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == TypedElement.class)
    {
      switch (baseFeatureID)
      {
        case TypesPackage.TYPED_ELEMENT__TYPE: return StextPackage.VARIABLE_DEFINITION__TYPE;
        default: return -1;
      }
    }
    if (baseClass == Feature.class)
    {
      switch (baseFeatureID)
      {
        case TypesPackage.FEATURE__OWNING_TYPE: return StextPackage.VARIABLE_DEFINITION__OWNING_TYPE;
        default: return -1;
      }
    }
    if (baseClass == Property.class)
    {
      switch (baseFeatureID)
      {
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
    result.append(" (readonly: ");
    result.append(readonly);
    result.append(", external: ");
    result.append(external);
    result.append(')');
    return result.toString();
  }

} //VariableDefinitionImpl
