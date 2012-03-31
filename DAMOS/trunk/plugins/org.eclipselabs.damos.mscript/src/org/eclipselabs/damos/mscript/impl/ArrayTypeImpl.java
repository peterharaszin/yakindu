/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.mscript.ArrayDimension;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.internal.operations.ArrayTypeOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Array Type Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.ArrayTypeImpl#getElementType <em>Element Type</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.ArrayTypeImpl#getAnonymousElementType <em>Anonymous Element Type</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.ArrayTypeImpl#getDimensions <em>Dimensions</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.ArrayTypeImpl#getDimensionality <em>Dimensionality</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.ArrayTypeImpl#isDimensional <em>Dimensional</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.ArrayTypeImpl#isMultidimensional <em>Multidimensional</em>}</li>
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
	 * The cached value of the '{@link #getAnonymousElementType() <em>Anonymous Element Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnonymousElementType()
	 * @generated
	 * @ordered
	 */
	protected DataType anonymousElementType;

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
		return MscriptPackage.Literals.ARRAY_TYPE;
	}

	public DataType getElementType() {
		DataType elementType = getElementTypeGen();
		if (elementType == null) {
			elementType = getAnonymousElementType();
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MscriptPackage.ARRAY_TYPE__ELEMENT_TYPE, oldElementType, elementType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.ARRAY_TYPE__ELEMENT_TYPE, oldElementType, elementType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getAnonymousElementType() {
		return anonymousElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnonymousElementType(DataType newAnonymousElementType, NotificationChain msgs) {
		DataType oldAnonymousElementType = anonymousElementType;
		anonymousElementType = newAnonymousElementType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MscriptPackage.ARRAY_TYPE__ANONYMOUS_ELEMENT_TYPE, oldAnonymousElementType, newAnonymousElementType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnonymousElementType(DataType newAnonymousElementType) {
		if (newAnonymousElementType != anonymousElementType) {
			NotificationChain msgs = null;
			if (anonymousElementType != null)
				msgs = ((InternalEObject)anonymousElementType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.ARRAY_TYPE__ANONYMOUS_ELEMENT_TYPE, null, msgs);
			if (newAnonymousElementType != null)
				msgs = ((InternalEObject)newAnonymousElementType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.ARRAY_TYPE__ANONYMOUS_ELEMENT_TYPE, null, msgs);
			msgs = basicSetAnonymousElementType(newAnonymousElementType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.ARRAY_TYPE__ANONYMOUS_ELEMENT_TYPE, newAnonymousElementType, newAnonymousElementType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArrayDimension> getDimensions() {
		if (dimensions == null) {
			dimensions = new EObjectContainmentEList<ArrayDimension>(ArrayDimension.class, this, MscriptPackage.ARRAY_TYPE__DIMENSIONS);
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
			case MscriptPackage.ARRAY_TYPE__ANONYMOUS_ELEMENT_TYPE:
				return basicSetAnonymousElementType(null, msgs);
			case MscriptPackage.ARRAY_TYPE__DIMENSIONS:
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
			case MscriptPackage.ARRAY_TYPE__ELEMENT_TYPE:
				if (resolve) return getElementType();
				return basicGetElementType();
			case MscriptPackage.ARRAY_TYPE__ANONYMOUS_ELEMENT_TYPE:
				return getAnonymousElementType();
			case MscriptPackage.ARRAY_TYPE__DIMENSIONS:
				return getDimensions();
			case MscriptPackage.ARRAY_TYPE__DIMENSIONALITY:
				return getDimensionality();
			case MscriptPackage.ARRAY_TYPE__DIMENSIONAL:
				return isDimensional();
			case MscriptPackage.ARRAY_TYPE__MULTIDIMENSIONAL:
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
			case MscriptPackage.ARRAY_TYPE__ELEMENT_TYPE:
				setElementType((DataType)newValue);
				return;
			case MscriptPackage.ARRAY_TYPE__ANONYMOUS_ELEMENT_TYPE:
				setAnonymousElementType((DataType)newValue);
				return;
			case MscriptPackage.ARRAY_TYPE__DIMENSIONS:
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
			case MscriptPackage.ARRAY_TYPE__ELEMENT_TYPE:
				setElementType((DataType)null);
				return;
			case MscriptPackage.ARRAY_TYPE__ANONYMOUS_ELEMENT_TYPE:
				setAnonymousElementType((DataType)null);
				return;
			case MscriptPackage.ARRAY_TYPE__DIMENSIONS:
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
			case MscriptPackage.ARRAY_TYPE__ELEMENT_TYPE:
				return elementType != null;
			case MscriptPackage.ARRAY_TYPE__ANONYMOUS_ELEMENT_TYPE:
				return anonymousElementType != null;
			case MscriptPackage.ARRAY_TYPE__DIMENSIONS:
				return dimensions != null && !dimensions.isEmpty();
			case MscriptPackage.ARRAY_TYPE__DIMENSIONALITY:
				return getDimensionality() != DIMENSIONALITY_EDEFAULT;
			case MscriptPackage.ARRAY_TYPE__DIMENSIONAL:
				return isDimensional() != DIMENSIONAL_EDEFAULT;
			case MscriptPackage.ARRAY_TYPE__MULTIDIMENSIONAL:
				return isMultidimensional() != MULTIDIMENSIONAL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //ArrayTypeSpecifierImpl
