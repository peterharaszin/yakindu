/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.DataTypeSpecification;
import org.eclipselabs.damos.dml.ExpressionParameter;
import org.eclipselabs.damos.dml.ExpressionSpecification;
import org.eclipselabs.damos.dml.PredefinedExpressionEntry;
import org.eclipselabs.damos.dml.ValueSpecification;
import org.eclipselabs.damos.dml.internal.operations.ExpressionParameterOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.impl.ExpressionParameterImpl#getDefaultExpression <em>Default Expression</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.ExpressionParameterImpl#getPredefinedExpressions <em>Predefined Expressions</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.ExpressionParameterImpl#getDataType <em>Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionParameterImpl extends ParameterImpl implements ExpressionParameter {
	/**
	 * The cached value of the '{@link #getDefaultExpression() <em>Default Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultExpression()
	 * @generated
	 * @ordered
	 */
	protected ExpressionSpecification defaultExpression;

	/**
	 * The cached value of the '{@link #getPredefinedExpressions() <em>Predefined Expressions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredefinedExpressions()
	 * @generated
	 * @ordered
	 */
	protected EList<PredefinedExpressionEntry> predefinedExpressions;
	/**
	 * The cached value of the '{@link #getDataType() <em>Data Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataType()
	 * @generated
	 * @ordered
	 */
	protected DataTypeSpecification dataType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.EXPRESSION_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionSpecification getDefaultExpression() {
		return defaultExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultExpression(ExpressionSpecification newDefaultExpression, NotificationChain msgs) {
		ExpressionSpecification oldDefaultExpression = defaultExpression;
		defaultExpression = newDefaultExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DMLPackage.EXPRESSION_PARAMETER__DEFAULT_EXPRESSION, oldDefaultExpression, newDefaultExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultExpression(ExpressionSpecification newDefaultExpression) {
		if (newDefaultExpression != defaultExpression) {
			NotificationChain msgs = null;
			if (defaultExpression != null)
				msgs = ((InternalEObject)defaultExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DMLPackage.EXPRESSION_PARAMETER__DEFAULT_EXPRESSION, null, msgs);
			if (newDefaultExpression != null)
				msgs = ((InternalEObject)newDefaultExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DMLPackage.EXPRESSION_PARAMETER__DEFAULT_EXPRESSION, null, msgs);
			msgs = basicSetDefaultExpression(newDefaultExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.EXPRESSION_PARAMETER__DEFAULT_EXPRESSION, newDefaultExpression, newDefaultExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PredefinedExpressionEntry> getPredefinedExpressions() {
		if (predefinedExpressions == null) {
			predefinedExpressions = new EObjectContainmentEList<PredefinedExpressionEntry>(PredefinedExpressionEntry.class, this, DMLPackage.EXPRESSION_PARAMETER__PREDEFINED_EXPRESSIONS);
		}
		return predefinedExpressions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeSpecification getDataType() {
		return dataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataType(DataTypeSpecification newDataType, NotificationChain msgs) {
		DataTypeSpecification oldDataType = dataType;
		dataType = newDataType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DMLPackage.EXPRESSION_PARAMETER__DATA_TYPE, oldDataType, newDataType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataType(DataTypeSpecification newDataType) {
		if (newDataType != dataType) {
			NotificationChain msgs = null;
			if (dataType != null)
				msgs = ((InternalEObject)dataType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DMLPackage.EXPRESSION_PARAMETER__DATA_TYPE, null, msgs);
			if (newDataType != null)
				msgs = ((InternalEObject)newDataType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DMLPackage.EXPRESSION_PARAMETER__DATA_TYPE, null, msgs);
			msgs = basicSetDataType(newDataType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.EXPRESSION_PARAMETER__DATA_TYPE, newDataType, newDataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PredefinedExpressionEntry getPredefinedExpression(String expression) {
		return ExpressionParameterOperations.getPredefinedExpression(this, expression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PredefinedExpressionEntry getPredefinedExpressionByAlias(String alias) {
		return ExpressionParameterOperations.getPredefinedExpressionByAlias(this, alias);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public ValueSpecification getDefaultValue() {
		return ExpressionParameterOperations.getDefaultValue(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DMLPackage.EXPRESSION_PARAMETER__DEFAULT_EXPRESSION:
				return basicSetDefaultExpression(null, msgs);
			case DMLPackage.EXPRESSION_PARAMETER__PREDEFINED_EXPRESSIONS:
				return ((InternalEList<?>)getPredefinedExpressions()).basicRemove(otherEnd, msgs);
			case DMLPackage.EXPRESSION_PARAMETER__DATA_TYPE:
				return basicSetDataType(null, msgs);
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
			case DMLPackage.EXPRESSION_PARAMETER__DEFAULT_EXPRESSION:
				return getDefaultExpression();
			case DMLPackage.EXPRESSION_PARAMETER__PREDEFINED_EXPRESSIONS:
				return getPredefinedExpressions();
			case DMLPackage.EXPRESSION_PARAMETER__DATA_TYPE:
				return getDataType();
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
			case DMLPackage.EXPRESSION_PARAMETER__DEFAULT_EXPRESSION:
				setDefaultExpression((ExpressionSpecification)newValue);
				return;
			case DMLPackage.EXPRESSION_PARAMETER__PREDEFINED_EXPRESSIONS:
				getPredefinedExpressions().clear();
				getPredefinedExpressions().addAll((Collection<? extends PredefinedExpressionEntry>)newValue);
				return;
			case DMLPackage.EXPRESSION_PARAMETER__DATA_TYPE:
				setDataType((DataTypeSpecification)newValue);
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
			case DMLPackage.EXPRESSION_PARAMETER__DEFAULT_EXPRESSION:
				setDefaultExpression((ExpressionSpecification)null);
				return;
			case DMLPackage.EXPRESSION_PARAMETER__PREDEFINED_EXPRESSIONS:
				getPredefinedExpressions().clear();
				return;
			case DMLPackage.EXPRESSION_PARAMETER__DATA_TYPE:
				setDataType((DataTypeSpecification)null);
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
			case DMLPackage.EXPRESSION_PARAMETER__DEFAULT_EXPRESSION:
				return defaultExpression != null;
			case DMLPackage.EXPRESSION_PARAMETER__PREDEFINED_EXPRESSIONS:
				return predefinedExpressions != null && !predefinedExpressions.isEmpty();
			case DMLPackage.EXPRESSION_PARAMETER__DATA_TYPE:
				return dataType != null;
		}
		return super.eIsSet(featureID);
	}

} //ExpressionParameterImpl
