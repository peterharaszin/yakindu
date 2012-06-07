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
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FunctionAliasDeclaration;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.MscriptPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Alias Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.FunctionAliasDeclarationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.FunctionAliasDeclarationImpl#getFunctionDeclaration <em>Function Declaration</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.FunctionAliasDeclarationImpl#getTemplateArguments <em>Template Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionAliasDeclarationImpl extends CallableElementImpl implements FunctionAliasDeclaration {
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
	 * The cached value of the '{@link #getFunctionDeclaration() <em>Function Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionDeclaration()
	 * @generated
	 * @ordered
	 */
	protected FunctionDeclaration functionDeclaration;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionAliasDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.FUNCTION_ALIAS_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.FUNCTION_ALIAS_DECLARATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDeclaration getFunctionDeclaration() {
		if (functionDeclaration != null && functionDeclaration.eIsProxy()) {
			InternalEObject oldFunctionDeclaration = (InternalEObject)functionDeclaration;
			functionDeclaration = (FunctionDeclaration)eResolveProxy(oldFunctionDeclaration);
			if (functionDeclaration != oldFunctionDeclaration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MscriptPackage.FUNCTION_ALIAS_DECLARATION__FUNCTION_DECLARATION, oldFunctionDeclaration, functionDeclaration));
			}
		}
		return functionDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDeclaration basicGetFunctionDeclaration() {
		return functionDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctionDeclaration(FunctionDeclaration newFunctionDeclaration) {
		FunctionDeclaration oldFunctionDeclaration = functionDeclaration;
		functionDeclaration = newFunctionDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.FUNCTION_ALIAS_DECLARATION__FUNCTION_DECLARATION, oldFunctionDeclaration, functionDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getTemplateArguments() {
		if (templateArguments == null) {
			templateArguments = new EObjectContainmentEList<Expression>(Expression.class, this, MscriptPackage.FUNCTION_ALIAS_DECLARATION__TEMPLATE_ARGUMENTS);
		}
		return templateArguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MscriptPackage.FUNCTION_ALIAS_DECLARATION__TEMPLATE_ARGUMENTS:
				return ((InternalEList<?>)getTemplateArguments()).basicRemove(otherEnd, msgs);
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
			case MscriptPackage.FUNCTION_ALIAS_DECLARATION__NAME:
				return getName();
			case MscriptPackage.FUNCTION_ALIAS_DECLARATION__FUNCTION_DECLARATION:
				if (resolve) return getFunctionDeclaration();
				return basicGetFunctionDeclaration();
			case MscriptPackage.FUNCTION_ALIAS_DECLARATION__TEMPLATE_ARGUMENTS:
				return getTemplateArguments();
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
			case MscriptPackage.FUNCTION_ALIAS_DECLARATION__NAME:
				setName((String)newValue);
				return;
			case MscriptPackage.FUNCTION_ALIAS_DECLARATION__FUNCTION_DECLARATION:
				setFunctionDeclaration((FunctionDeclaration)newValue);
				return;
			case MscriptPackage.FUNCTION_ALIAS_DECLARATION__TEMPLATE_ARGUMENTS:
				getTemplateArguments().clear();
				getTemplateArguments().addAll((Collection<? extends Expression>)newValue);
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
			case MscriptPackage.FUNCTION_ALIAS_DECLARATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MscriptPackage.FUNCTION_ALIAS_DECLARATION__FUNCTION_DECLARATION:
				setFunctionDeclaration((FunctionDeclaration)null);
				return;
			case MscriptPackage.FUNCTION_ALIAS_DECLARATION__TEMPLATE_ARGUMENTS:
				getTemplateArguments().clear();
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
			case MscriptPackage.FUNCTION_ALIAS_DECLARATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MscriptPackage.FUNCTION_ALIAS_DECLARATION__FUNCTION_DECLARATION:
				return functionDeclaration != null;
			case MscriptPackage.FUNCTION_ALIAS_DECLARATION__TEMPLATE_ARGUMENTS:
				return templateArguments != null && !templateArguments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //FunctionAliasDeclarationImpl
