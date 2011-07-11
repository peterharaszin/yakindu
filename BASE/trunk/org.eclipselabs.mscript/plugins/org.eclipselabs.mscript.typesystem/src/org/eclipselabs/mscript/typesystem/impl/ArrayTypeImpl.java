/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.typesystem.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.mscript.typesystem.ArrayDimension;
import org.eclipselabs.mscript.typesystem.ArrayType;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.OperatorKind;
import org.eclipselabs.mscript.typesystem.TypeSystemPackage;
import org.eclipselabs.mscript.typesystem.internal.operations.ArrayTypeOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Array Type Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.typesystem.impl.ArrayTypeImpl#getElementType <em>Element Type</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.impl.ArrayTypeImpl#getDefinedElementType <em>Defined Element Type</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.impl.ArrayTypeImpl#getDimensions <em>Dimensions</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.impl.ArrayTypeImpl#getDimensionality <em>Dimensionality</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.impl.ArrayTypeImpl#isDimensional <em>Dimensional</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.impl.ArrayTypeImpl#isMultidimensional <em>Multidimensional</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArrayTypeImpl extends DataTypeImpl implements ArrayType {
	/**
	 * The cached value of the '{@link #getElementType() <em>Element Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementType()
	 * @generated
	 * @ordered
	 */
	protected DataType elementType;

	/**
	 * The cached value of the '{@link #getDefinedElementType() <em>Defined Element Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinedElementType()
	 * @generated
	 * @ordered
	 */
	protected DataType definedElementType;

	/**
	 * The cached value of the '{@link #getDimensions() <em>Dimensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDimensions()
	 * @generated
	 * @ordered
	 */
	protected EList<ArrayDimension> dimensions;

	/**
	 * The default value of the '{@link #getDimensionality() <em>Dimensionality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDimensionality()
	 * @generated
	 * @ordered
	 */
	protected static final int DIMENSIONALITY_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #isDimensional() <em>Dimensional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDimensional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DIMENSIONAL_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isMultidimensional() <em>Multidimensional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultidimensional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MULTIDIMENSIONAL_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArrayTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypeSystemPackage.Literals.ARRAY_TYPE;
	}

	public DataType getElementType() {
		DataType elementType = getElementTypeGen();
		if (elementType == null) {
			elementType = getDefinedElementType();
		}
		return elementType;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getElementTypeGen() {
		if (elementType != null && elementType.eIsProxy()) {
			InternalEObject oldElementType = (InternalEObject)elementType;
			elementType = (DataType)eResolveProxy(oldElementType);
			if (elementType != oldElementType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TypeSystemPackage.ARRAY_TYPE__ELEMENT_TYPE, oldElementType, elementType));
			}
		}
		return elementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetElementType() {
		return elementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementType(DataType newElementType) {
		DataType oldElementType = elementType;
		elementType = newElementType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypeSystemPackage.ARRAY_TYPE__ELEMENT_TYPE, oldElementType, elementType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getDefinedElementType() {
		return definedElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefinedElementType(DataType newDefinedElementType, NotificationChain msgs) {
		DataType oldDefinedElementType = definedElementType;
		definedElementType = newDefinedElementType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypeSystemPackage.ARRAY_TYPE__DEFINED_ELEMENT_TYPE, oldDefinedElementType, newDefinedElementType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinedElementType(DataType newDefinedElementType) {
		if (newDefinedElementType != definedElementType) {
			NotificationChain msgs = null;
			if (definedElementType != null)
				msgs = ((InternalEObject)definedElementType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypeSystemPackage.ARRAY_TYPE__DEFINED_ELEMENT_TYPE, null, msgs);
			if (newDefinedElementType != null)
				msgs = ((InternalEObject)newDefinedElementType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypeSystemPackage.ARRAY_TYPE__DEFINED_ELEMENT_TYPE, null, msgs);
			msgs = basicSetDefinedElementType(newDefinedElementType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypeSystemPackage.ARRAY_TYPE__DEFINED_ELEMENT_TYPE, newDefinedElementType, newDefinedElementType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArrayDimension> getDimensions() {
		if (dimensions == null) {
			dimensions = new EObjectContainmentEList<ArrayDimension>(ArrayDimension.class, this, TypeSystemPackage.ARRAY_TYPE__DIMENSIONS);
		}
		return dimensions;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.typesystem.impl.DataTypeImpl#evaluate(org.eclipselabs.mscript.typesystem.OperatorKind, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	public DataType evaluate(OperatorKind operator, DataType other) {
		return ArrayTypeOperations.evaluate(this, operator, other);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.typesystem.impl.DataTypeImpl#evaluate(org.eclipselabs.mscript.typesystem.OperatorKind, int)
	 */
	@Override
	public DataType evaluate(OperatorKind operator, int n) {
		return ArrayTypeOperations.evaluate(this, operator, n);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.typesystem.impl.DataTypeImpl#isAssignableFrom(org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	public boolean isAssignableFrom(DataType other) {
		return ArrayTypeOperations.isAssignableFrom(this, other);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getDimensionality() {
		return getDimensions().size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isDimensional() {
		return getDimensions().size() > 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isMultidimensional() {
		return getDimensions().size() > 1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypeSystemPackage.ARRAY_TYPE__DEFINED_ELEMENT_TYPE:
				return basicSetDefinedElementType(null, msgs);
			case TypeSystemPackage.ARRAY_TYPE__DIMENSIONS:
				return ((InternalEList<?>)getDimensions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TypeSystemPackage.ARRAY_TYPE__ELEMENT_TYPE:
				if (resolve) return getElementType();
				return basicGetElementType();
			case TypeSystemPackage.ARRAY_TYPE__DEFINED_ELEMENT_TYPE:
				return getDefinedElementType();
			case TypeSystemPackage.ARRAY_TYPE__DIMENSIONS:
				return getDimensions();
			case TypeSystemPackage.ARRAY_TYPE__DIMENSIONALITY:
				return getDimensionality();
			case TypeSystemPackage.ARRAY_TYPE__DIMENSIONAL:
				return isDimensional();
			case TypeSystemPackage.ARRAY_TYPE__MULTIDIMENSIONAL:
				return isMultidimensional();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TypeSystemPackage.ARRAY_TYPE__ELEMENT_TYPE:
				setElementType((DataType)newValue);
				return;
			case TypeSystemPackage.ARRAY_TYPE__DEFINED_ELEMENT_TYPE:
				setDefinedElementType((DataType)newValue);
				return;
			case TypeSystemPackage.ARRAY_TYPE__DIMENSIONS:
				getDimensions().clear();
				getDimensions().addAll((Collection<? extends ArrayDimension>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case TypeSystemPackage.ARRAY_TYPE__ELEMENT_TYPE:
				setElementType((DataType)null);
				return;
			case TypeSystemPackage.ARRAY_TYPE__DEFINED_ELEMENT_TYPE:
				setDefinedElementType((DataType)null);
				return;
			case TypeSystemPackage.ARRAY_TYPE__DIMENSIONS:
				getDimensions().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TypeSystemPackage.ARRAY_TYPE__ELEMENT_TYPE:
				return elementType != null;
			case TypeSystemPackage.ARRAY_TYPE__DEFINED_ELEMENT_TYPE:
				return definedElementType != null;
			case TypeSystemPackage.ARRAY_TYPE__DIMENSIONS:
				return dimensions != null && !dimensions.isEmpty();
			case TypeSystemPackage.ARRAY_TYPE__DIMENSIONALITY:
				return getDimensionality() != DIMENSIONALITY_EDEFAULT;
			case TypeSystemPackage.ARRAY_TYPE__DIMENSIONAL:
				return isDimensional() != DIMENSIONAL_EDEFAULT;
			case TypeSystemPackage.ARRAY_TYPE__MULTIDIMENSIONAL:
				return isMultidimensional() != MULTIDIMENSIONAL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //ArrayTypeSpecifierImpl
