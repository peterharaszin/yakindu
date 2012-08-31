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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.mscript.Check;
import org.eclipselabs.damos.mscript.CheckArgument;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.ExpressionCheckArgument;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.TypeCheckArgument;
import org.eclipselabs.damos.mscript.TypeSpecifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Check</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.CheckImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.CheckImpl#getInputArguments <em>Input Arguments</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.CheckImpl#getOutputTypeSpecifiers <em>Output Type Specifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CheckImpl extends MinimalEObjectImpl.Container implements Check {
	/**
	 * The cached value of the '{@link #getInputArguments() <em>Input Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<CheckArgument> inputArguments;

	/**
	 * The cached value of the '{@link #getOutputTypeSpecifiers() <em>Output Type Specifiers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputTypeSpecifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeSpecifier> outputTypeSpecifiers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CheckImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.CHECK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDeclaration getFunction() {
		if (eContainerFeatureID() != MscriptPackage.CHECK__FUNCTION) return null;
		return (FunctionDeclaration)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFunction(FunctionDeclaration newFunction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFunction, MscriptPackage.CHECK__FUNCTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunction(FunctionDeclaration newFunction) {
		if (newFunction != eInternalContainer() || (eContainerFeatureID() != MscriptPackage.CHECK__FUNCTION && newFunction != null)) {
			if (EcoreUtil.isAncestor(this, newFunction))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFunction != null)
				msgs = ((InternalEObject)newFunction).eInverseAdd(this, MscriptPackage.FUNCTION_DECLARATION__CHECKS, FunctionDeclaration.class, msgs);
			msgs = basicSetFunction(newFunction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.CHECK__FUNCTION, newFunction, newFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CheckArgument> getInputArguments() {
		if (inputArguments == null) {
			inputArguments = new EObjectContainmentEList<CheckArgument>(CheckArgument.class, this, MscriptPackage.CHECK__INPUT_ARGUMENTS);
		}
		return inputArguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Expression> getExpressionArguments() {
		EList<Expression> result = new BasicEList<Expression>();
		for (CheckArgument argument : getInputArguments()) {
			if (argument instanceof ExpressionCheckArgument) {
				result.add(((ExpressionCheckArgument) argument).getExpression());
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<TypeSpecifier> getInputTypeSpecifiers() {
		EList<TypeSpecifier> result = new BasicEList<TypeSpecifier>();
		for (CheckArgument argument : getInputArguments()) {
			if (argument instanceof TypeCheckArgument) {
				result.add(((TypeCheckArgument) argument).getTypeSpecifier());
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeSpecifier> getOutputTypeSpecifiers() {
		if (outputTypeSpecifiers == null) {
			outputTypeSpecifiers = new EObjectContainmentEList<TypeSpecifier>(TypeSpecifier.class, this, MscriptPackage.CHECK__OUTPUT_TYPE_SPECIFIERS);
		}
		return outputTypeSpecifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MscriptPackage.CHECK__FUNCTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFunction((FunctionDeclaration)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MscriptPackage.CHECK__FUNCTION:
				return basicSetFunction(null, msgs);
			case MscriptPackage.CHECK__INPUT_ARGUMENTS:
				return ((InternalEList<?>)getInputArguments()).basicRemove(otherEnd, msgs);
			case MscriptPackage.CHECK__OUTPUT_TYPE_SPECIFIERS:
				return ((InternalEList<?>)getOutputTypeSpecifiers()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case MscriptPackage.CHECK__FUNCTION:
				return eInternalContainer().eInverseRemove(this, MscriptPackage.FUNCTION_DECLARATION__CHECKS, FunctionDeclaration.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MscriptPackage.CHECK__FUNCTION:
				return getFunction();
			case MscriptPackage.CHECK__INPUT_ARGUMENTS:
				return getInputArguments();
			case MscriptPackage.CHECK__OUTPUT_TYPE_SPECIFIERS:
				return getOutputTypeSpecifiers();
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
			case MscriptPackage.CHECK__FUNCTION:
				setFunction((FunctionDeclaration)newValue);
				return;
			case MscriptPackage.CHECK__INPUT_ARGUMENTS:
				getInputArguments().clear();
				getInputArguments().addAll((Collection<? extends CheckArgument>)newValue);
				return;
			case MscriptPackage.CHECK__OUTPUT_TYPE_SPECIFIERS:
				getOutputTypeSpecifiers().clear();
				getOutputTypeSpecifiers().addAll((Collection<? extends TypeSpecifier>)newValue);
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
			case MscriptPackage.CHECK__FUNCTION:
				setFunction((FunctionDeclaration)null);
				return;
			case MscriptPackage.CHECK__INPUT_ARGUMENTS:
				getInputArguments().clear();
				return;
			case MscriptPackage.CHECK__OUTPUT_TYPE_SPECIFIERS:
				getOutputTypeSpecifiers().clear();
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
			case MscriptPackage.CHECK__FUNCTION:
				return getFunction() != null;
			case MscriptPackage.CHECK__INPUT_ARGUMENTS:
				return inputArguments != null && !inputArguments.isEmpty();
			case MscriptPackage.CHECK__OUTPUT_TYPE_SPECIFIERS:
				return outputTypeSpecifiers != null && !outputTypeSpecifiers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CheckImpl
