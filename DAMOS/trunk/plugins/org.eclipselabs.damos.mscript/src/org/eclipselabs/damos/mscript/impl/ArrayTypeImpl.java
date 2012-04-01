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
import org.eclipselabs.damos.mscript.DataTypeSpecifier;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.internal.operations.ArrayTypeOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Array Type Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.ArrayTypeImpl#getElementTypeSpecifier <em>Element Type Specifier</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.ArrayTypeImpl#isTensor <em>Tensor</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.ArrayTypeImpl#getDimensions <em>Dimensions</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.ArrayTypeImpl#getDimensionality <em>Dimensionality</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.ArrayTypeImpl#isDimensional <em>Dimensional</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.ArrayTypeImpl#isMultidimensional <em>Multidimensional</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.ArrayTypeImpl#isVector <em>Vector</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.ArrayTypeImpl#isMatrix <em>Matrix</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArrayTypeImpl extends DataTypeImpl implements ArrayType {
	/**
	 * The cached value of the '{@link #getElementTypeSpecifier() <em>Element Type Specifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementTypeSpecifier()
	 * @generated
	 * @ordered
	 */
	protected DataTypeSpecifier elementTypeSpecifier;

	/**
	 * The default value of the '{@link #isTensor() <em>Tensor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTensor()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TENSOR_EDEFAULT = false;

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
	 * The default value of the '{@link #isVector() <em>Vector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVector()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VECTOR_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isMatrix() <em>Matrix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMatrix()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MATRIX_EDEFAULT = false;

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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeSpecifier getElementTypeSpecifier() {
		return elementTypeSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElementTypeSpecifier(DataTypeSpecifier newElementTypeSpecifier, NotificationChain msgs) {
		DataTypeSpecifier oldElementTypeSpecifier = elementTypeSpecifier;
		elementTypeSpecifier = newElementTypeSpecifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MscriptPackage.ARRAY_TYPE__ELEMENT_TYPE_SPECIFIER, oldElementTypeSpecifier, newElementTypeSpecifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementTypeSpecifier(DataTypeSpecifier newElementTypeSpecifier) {
		if (newElementTypeSpecifier != elementTypeSpecifier) {
			NotificationChain msgs = null;
			if (elementTypeSpecifier != null)
				msgs = ((InternalEObject)elementTypeSpecifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.ARRAY_TYPE__ELEMENT_TYPE_SPECIFIER, null, msgs);
			if (newElementTypeSpecifier != null)
				msgs = ((InternalEObject)newElementTypeSpecifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.ARRAY_TYPE__ELEMENT_TYPE_SPECIFIER, null, msgs);
			msgs = basicSetElementTypeSpecifier(newElementTypeSpecifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.ARRAY_TYPE__ELEMENT_TYPE_SPECIFIER, newElementTypeSpecifier, newElementTypeSpecifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isTensor() {
		return getElementType() instanceof NumericType;
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
	 * @generated NOT
	 */
	public boolean isVector() {
		return isTensor() && getDimensions().size() == 1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isMatrix() {
		return isTensor() && getDimensions().size() == 2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DataType getElementType() {
		return ArrayTypeOperations.getElementType(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MscriptPackage.ARRAY_TYPE__ELEMENT_TYPE_SPECIFIER:
				return basicSetElementTypeSpecifier(null, msgs);
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
			case MscriptPackage.ARRAY_TYPE__ELEMENT_TYPE_SPECIFIER:
				return getElementTypeSpecifier();
			case MscriptPackage.ARRAY_TYPE__TENSOR:
				return isTensor();
			case MscriptPackage.ARRAY_TYPE__DIMENSIONS:
				return getDimensions();
			case MscriptPackage.ARRAY_TYPE__DIMENSIONALITY:
				return getDimensionality();
			case MscriptPackage.ARRAY_TYPE__DIMENSIONAL:
				return isDimensional();
			case MscriptPackage.ARRAY_TYPE__MULTIDIMENSIONAL:
				return isMultidimensional();
			case MscriptPackage.ARRAY_TYPE__VECTOR:
				return isVector();
			case MscriptPackage.ARRAY_TYPE__MATRIX:
				return isMatrix();
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
			case MscriptPackage.ARRAY_TYPE__ELEMENT_TYPE_SPECIFIER:
				setElementTypeSpecifier((DataTypeSpecifier)newValue);
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
			case MscriptPackage.ARRAY_TYPE__ELEMENT_TYPE_SPECIFIER:
				setElementTypeSpecifier((DataTypeSpecifier)null);
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
			case MscriptPackage.ARRAY_TYPE__ELEMENT_TYPE_SPECIFIER:
				return elementTypeSpecifier != null;
			case MscriptPackage.ARRAY_TYPE__TENSOR:
				return isTensor() != TENSOR_EDEFAULT;
			case MscriptPackage.ARRAY_TYPE__DIMENSIONS:
				return dimensions != null && !dimensions.isEmpty();
			case MscriptPackage.ARRAY_TYPE__DIMENSIONALITY:
				return getDimensionality() != DIMENSIONALITY_EDEFAULT;
			case MscriptPackage.ARRAY_TYPE__DIMENSIONAL:
				return isDimensional() != DIMENSIONAL_EDEFAULT;
			case MscriptPackage.ARRAY_TYPE__MULTIDIMENSIONAL:
				return isMultidimensional() != MULTIDIMENSIONAL_EDEFAULT;
			case MscriptPackage.ARRAY_TYPE__VECTOR:
				return isVector() != VECTOR_EDEFAULT;
			case MscriptPackage.ARRAY_TYPE__MATRIX:
				return isMatrix() != MATRIX_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //ArrayTypeSpecifierImpl
