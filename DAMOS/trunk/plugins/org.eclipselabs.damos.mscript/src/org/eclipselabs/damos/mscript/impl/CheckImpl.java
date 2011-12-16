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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.mscript.Check;
import org.eclipselabs.damos.mscript.DataTypeSpecifier;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.MscriptPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Check</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.CheckImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.CheckImpl#getTemplateArguments <em>Template Arguments</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.CheckImpl#getInputParameterTypes <em>Input Parameter Types</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.CheckImpl#getOutputParameterTypes <em>Output Parameter Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CheckImpl extends MinimalEObjectImpl.Container implements Check {
	/**
	 * The cached value of the '{@link #getTemplateArguments() <em>Template Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> templateArguments;

	/**
	 * The cached value of the '{@link #getInputParameterTypes() <em>Input Parameter Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputParameterTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<DataTypeSpecifier> inputParameterTypes;

	/**
	 * The cached value of the '{@link #getOutputParameterTypes() <em>Output Parameter Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputParameterTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<DataTypeSpecifier> outputParameterTypes;

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
	public EList<Expression> getTemplateArguments() {
		if (templateArguments == null) {
			templateArguments = new EObjectContainmentEList<Expression>(Expression.class, this, MscriptPackage.CHECK__TEMPLATE_ARGUMENTS);
		}
		return templateArguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataTypeSpecifier> getInputParameterTypes() {
		if (inputParameterTypes == null) {
			inputParameterTypes = new EObjectContainmentEList<DataTypeSpecifier>(DataTypeSpecifier.class, this, MscriptPackage.CHECK__INPUT_PARAMETER_TYPES);
		}
		return inputParameterTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataTypeSpecifier> getOutputParameterTypes() {
		if (outputParameterTypes == null) {
			outputParameterTypes = new EObjectContainmentEList<DataTypeSpecifier>(DataTypeSpecifier.class, this, MscriptPackage.CHECK__OUTPUT_PARAMETER_TYPES);
		}
		return outputParameterTypes;
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
			case MscriptPackage.CHECK__TEMPLATE_ARGUMENTS:
				return ((InternalEList<?>)getTemplateArguments()).basicRemove(otherEnd, msgs);
			case MscriptPackage.CHECK__INPUT_PARAMETER_TYPES:
				return ((InternalEList<?>)getInputParameterTypes()).basicRemove(otherEnd, msgs);
			case MscriptPackage.CHECK__OUTPUT_PARAMETER_TYPES:
				return ((InternalEList<?>)getOutputParameterTypes()).basicRemove(otherEnd, msgs);
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
			case MscriptPackage.CHECK__TEMPLATE_ARGUMENTS:
				return getTemplateArguments();
			case MscriptPackage.CHECK__INPUT_PARAMETER_TYPES:
				return getInputParameterTypes();
			case MscriptPackage.CHECK__OUTPUT_PARAMETER_TYPES:
				return getOutputParameterTypes();
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
			case MscriptPackage.CHECK__TEMPLATE_ARGUMENTS:
				getTemplateArguments().clear();
				getTemplateArguments().addAll((Collection<? extends Expression>)newValue);
				return;
			case MscriptPackage.CHECK__INPUT_PARAMETER_TYPES:
				getInputParameterTypes().clear();
				getInputParameterTypes().addAll((Collection<? extends DataTypeSpecifier>)newValue);
				return;
			case MscriptPackage.CHECK__OUTPUT_PARAMETER_TYPES:
				getOutputParameterTypes().clear();
				getOutputParameterTypes().addAll((Collection<? extends DataTypeSpecifier>)newValue);
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
			case MscriptPackage.CHECK__TEMPLATE_ARGUMENTS:
				getTemplateArguments().clear();
				return;
			case MscriptPackage.CHECK__INPUT_PARAMETER_TYPES:
				getInputParameterTypes().clear();
				return;
			case MscriptPackage.CHECK__OUTPUT_PARAMETER_TYPES:
				getOutputParameterTypes().clear();
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
			case MscriptPackage.CHECK__TEMPLATE_ARGUMENTS:
				return templateArguments != null && !templateArguments.isEmpty();
			case MscriptPackage.CHECK__INPUT_PARAMETER_TYPES:
				return inputParameterTypes != null && !inputParameterTypes.isEmpty();
			case MscriptPackage.CHECK__OUTPUT_PARAMETER_TYPES:
				return outputParameterTypes != null && !outputParameterTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CheckImpl
