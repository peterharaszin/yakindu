/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.mscript.impl;

import java.util.Collection;

import org.eclipse.damos.mscript.Assertion;
import org.eclipse.damos.mscript.Check;
import org.eclipse.damos.mscript.ConstantDeclaration;
import org.eclipse.damos.mscript.Equation;
import org.eclipse.damos.mscript.FunctionDeclaration;
import org.eclipse.damos.mscript.FunctionKind;
import org.eclipse.damos.mscript.ImplicitVariableDeclaration;
import org.eclipse.damos.mscript.InputParameterDeclaration;
import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.damos.mscript.OutputParameterDeclaration;
import org.eclipse.damos.mscript.StateVariableDeclaration;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.impl.FunctionDeclarationImpl#getChecks <em>Checks</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.impl.FunctionDeclarationImpl#getAssertions <em>Assertions</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.impl.FunctionDeclarationImpl#getStateVariableDeclarations <em>State Variable Declarations</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.impl.FunctionDeclarationImpl#getConstantDeclarations <em>Constant Declarations</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.impl.FunctionDeclarationImpl#getEquations <em>Equations</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.impl.FunctionDeclarationImpl#getAllImplicitVariableDeclarations <em>All Implicit Variable Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FunctionDeclarationImpl extends MinimalEObjectImpl.Container implements FunctionDeclaration {
	/**
	 * The cached value of the '{@link #getChecks() <em>Checks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChecks()
	 * @generated
	 * @ordered
	 */
	protected EList<Check> checks;

	/**
	 * The cached value of the '{@link #getAssertions() <em>Assertions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssertions()
	 * @generated
	 * @ordered
	 */
	protected EList<Assertion> assertions;

	/**
	 * The cached value of the '{@link #getStateVariableDeclarations() <em>State Variable Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateVariableDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<StateVariableDeclaration> stateVariableDeclarations;

	/**
	 * The cached value of the '{@link #getConstantDeclarations() <em>Constant Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstantDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstantDeclaration> constantDeclarations;

	/**
	 * The cached value of the '{@link #getEquations() <em>Equations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquations()
	 * @generated
	 * @ordered
	 */
	protected EList<Equation> equations;

	/**
	 * The cached value of the '{@link #getAllImplicitVariableDeclarations() <em>All Implicit Variable Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllImplicitVariableDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<ImplicitVariableDeclaration> allImplicitVariableDeclarations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.FUNCTION_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract FunctionKind getKind();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract EList<InputParameterDeclaration> getInputParameterDeclarations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<InputParameterDeclaration> getConstantInputParameterDeclarations() {
		EList<InputParameterDeclaration> result = new BasicEList<InputParameterDeclaration>();
		for (InputParameterDeclaration inputParameterDeclaration : getInputParameterDeclarations()) {
			if (inputParameterDeclaration.isConstant()) {
				result.add(inputParameterDeclaration);
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<InputParameterDeclaration> getNonConstantInputParameterDeclarations() {
		EList<InputParameterDeclaration> result = new BasicEList<InputParameterDeclaration>();
		for (InputParameterDeclaration inputParameterDeclaration : getInputParameterDeclarations()) {
			if (!inputParameterDeclaration.isConstant()) {
				result.add(inputParameterDeclaration);
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ImplicitVariableDeclaration> getImplicitVariableDeclarations() {
		EList<ImplicitVariableDeclaration> result = ECollections.emptyEList();
		switch (getKind()) {
		case SYNCHRONOUS:
			result = new BasicEList<ImplicitVariableDeclaration>();
			for (ImplicitVariableDeclaration variableDeclaration : getAllImplicitVariableDeclarations()) {
				String name = variableDeclaration.getName();
				if ("Ts".equals(name) || "fs".equals(name)) {
					result.add(variableDeclaration);
				}
			}
			break;
		case CONTINUOUS:
			result = new BasicEList<ImplicitVariableDeclaration>();
			for (ImplicitVariableDeclaration variableDeclaration : getAllImplicitVariableDeclarations()) {
				String name = variableDeclaration.getName();
				if ("t".equals(name)) {
					result.add(variableDeclaration);
				}
			}
			break;
		default:
			break;
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ImplicitVariableDeclaration getImplicitVariableDeclaration(String name) {
		for (ImplicitVariableDeclaration variableDeclaration : getImplicitVariableDeclarations()) {
			if (name.equals(variableDeclaration.getName())) {
				return variableDeclaration;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract EList<OutputParameterDeclaration> getOutputParameterDeclarations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Check> getChecks() {
		if (checks == null) {
			checks = new EObjectContainmentWithInverseEList<Check>(Check.class, this, MscriptPackage.FUNCTION_DECLARATION__CHECKS, MscriptPackage.CHECK__FUNCTION);
		}
		return checks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Assertion> getAssertions() {
		if (assertions == null) {
			assertions = new EObjectContainmentEList<Assertion>(Assertion.class, this, MscriptPackage.FUNCTION_DECLARATION__ASSERTIONS);
		}
		return assertions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StateVariableDeclaration> getStateVariableDeclarations() {
		if (stateVariableDeclarations == null) {
			stateVariableDeclarations = new EObjectContainmentEList<StateVariableDeclaration>(StateVariableDeclaration.class, this, MscriptPackage.FUNCTION_DECLARATION__STATE_VARIABLE_DECLARATIONS);
		}
		return stateVariableDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConstantDeclaration> getConstantDeclarations() {
		if (constantDeclarations == null) {
			constantDeclarations = new EObjectContainmentEList<ConstantDeclaration>(ConstantDeclaration.class, this, MscriptPackage.FUNCTION_DECLARATION__CONSTANT_DECLARATIONS);
		}
		return constantDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Equation> getEquations() {
		if (equations == null) {
			equations = new EObjectContainmentEList<Equation>(Equation.class, this, MscriptPackage.FUNCTION_DECLARATION__EQUATIONS);
		}
		return equations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ImplicitVariableDeclaration> getAllImplicitVariableDeclarations() {
		if (allImplicitVariableDeclarations == null) {
			allImplicitVariableDeclarations = new EObjectContainmentEList<ImplicitVariableDeclaration>(ImplicitVariableDeclaration.class, this, MscriptPackage.FUNCTION_DECLARATION__ALL_IMPLICIT_VARIABLE_DECLARATIONS);
		}
		return allImplicitVariableDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract String getName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getQualifiedName() {
		return getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MscriptPackage.FUNCTION_DECLARATION__CHECKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChecks()).basicAdd(otherEnd, msgs);
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
			case MscriptPackage.FUNCTION_DECLARATION__CHECKS:
				return ((InternalEList<?>)getChecks()).basicRemove(otherEnd, msgs);
			case MscriptPackage.FUNCTION_DECLARATION__ASSERTIONS:
				return ((InternalEList<?>)getAssertions()).basicRemove(otherEnd, msgs);
			case MscriptPackage.FUNCTION_DECLARATION__STATE_VARIABLE_DECLARATIONS:
				return ((InternalEList<?>)getStateVariableDeclarations()).basicRemove(otherEnd, msgs);
			case MscriptPackage.FUNCTION_DECLARATION__CONSTANT_DECLARATIONS:
				return ((InternalEList<?>)getConstantDeclarations()).basicRemove(otherEnd, msgs);
			case MscriptPackage.FUNCTION_DECLARATION__EQUATIONS:
				return ((InternalEList<?>)getEquations()).basicRemove(otherEnd, msgs);
			case MscriptPackage.FUNCTION_DECLARATION__ALL_IMPLICIT_VARIABLE_DECLARATIONS:
				return ((InternalEList<?>)getAllImplicitVariableDeclarations()).basicRemove(otherEnd, msgs);
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
			case MscriptPackage.FUNCTION_DECLARATION__CHECKS:
				return getChecks();
			case MscriptPackage.FUNCTION_DECLARATION__ASSERTIONS:
				return getAssertions();
			case MscriptPackage.FUNCTION_DECLARATION__STATE_VARIABLE_DECLARATIONS:
				return getStateVariableDeclarations();
			case MscriptPackage.FUNCTION_DECLARATION__CONSTANT_DECLARATIONS:
				return getConstantDeclarations();
			case MscriptPackage.FUNCTION_DECLARATION__EQUATIONS:
				return getEquations();
			case MscriptPackage.FUNCTION_DECLARATION__ALL_IMPLICIT_VARIABLE_DECLARATIONS:
				return getAllImplicitVariableDeclarations();
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
			case MscriptPackage.FUNCTION_DECLARATION__CHECKS:
				getChecks().clear();
				getChecks().addAll((Collection<? extends Check>)newValue);
				return;
			case MscriptPackage.FUNCTION_DECLARATION__ASSERTIONS:
				getAssertions().clear();
				getAssertions().addAll((Collection<? extends Assertion>)newValue);
				return;
			case MscriptPackage.FUNCTION_DECLARATION__STATE_VARIABLE_DECLARATIONS:
				getStateVariableDeclarations().clear();
				getStateVariableDeclarations().addAll((Collection<? extends StateVariableDeclaration>)newValue);
				return;
			case MscriptPackage.FUNCTION_DECLARATION__CONSTANT_DECLARATIONS:
				getConstantDeclarations().clear();
				getConstantDeclarations().addAll((Collection<? extends ConstantDeclaration>)newValue);
				return;
			case MscriptPackage.FUNCTION_DECLARATION__EQUATIONS:
				getEquations().clear();
				getEquations().addAll((Collection<? extends Equation>)newValue);
				return;
			case MscriptPackage.FUNCTION_DECLARATION__ALL_IMPLICIT_VARIABLE_DECLARATIONS:
				getAllImplicitVariableDeclarations().clear();
				getAllImplicitVariableDeclarations().addAll((Collection<? extends ImplicitVariableDeclaration>)newValue);
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
			case MscriptPackage.FUNCTION_DECLARATION__CHECKS:
				getChecks().clear();
				return;
			case MscriptPackage.FUNCTION_DECLARATION__ASSERTIONS:
				getAssertions().clear();
				return;
			case MscriptPackage.FUNCTION_DECLARATION__STATE_VARIABLE_DECLARATIONS:
				getStateVariableDeclarations().clear();
				return;
			case MscriptPackage.FUNCTION_DECLARATION__CONSTANT_DECLARATIONS:
				getConstantDeclarations().clear();
				return;
			case MscriptPackage.FUNCTION_DECLARATION__EQUATIONS:
				getEquations().clear();
				return;
			case MscriptPackage.FUNCTION_DECLARATION__ALL_IMPLICIT_VARIABLE_DECLARATIONS:
				getAllImplicitVariableDeclarations().clear();
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
			case MscriptPackage.FUNCTION_DECLARATION__CHECKS:
				return checks != null && !checks.isEmpty();
			case MscriptPackage.FUNCTION_DECLARATION__ASSERTIONS:
				return assertions != null && !assertions.isEmpty();
			case MscriptPackage.FUNCTION_DECLARATION__STATE_VARIABLE_DECLARATIONS:
				return stateVariableDeclarations != null && !stateVariableDeclarations.isEmpty();
			case MscriptPackage.FUNCTION_DECLARATION__CONSTANT_DECLARATIONS:
				return constantDeclarations != null && !constantDeclarations.isEmpty();
			case MscriptPackage.FUNCTION_DECLARATION__EQUATIONS:
				return equations != null && !equations.isEmpty();
			case MscriptPackage.FUNCTION_DECLARATION__ALL_IMPLICIT_VARIABLE_DECLARATIONS:
				return allImplicitVariableDeclarations != null && !allImplicitVariableDeclarations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FunctionDefinitionImpl
