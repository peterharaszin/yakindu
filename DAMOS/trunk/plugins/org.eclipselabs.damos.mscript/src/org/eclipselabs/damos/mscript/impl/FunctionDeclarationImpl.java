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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.mscript.Assertion;
import org.eclipselabs.damos.mscript.Check;
import org.eclipselabs.damos.mscript.ConstantDeclaration;
import org.eclipselabs.damos.mscript.Equation;
import org.eclipselabs.damos.mscript.FunctionAliasDeclaration;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.FunctionKind;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.OutputParameterDeclaration;
import org.eclipselabs.damos.mscript.StateVariableDeclaration;
import org.eclipselabs.damos.mscript.StaticParameterDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.FunctionDeclarationImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.FunctionDeclarationImpl#getStaticParameterDeclarations <em>Static Parameter Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.FunctionDeclarationImpl#getInputParameterDeclarations <em>Input Parameter Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.FunctionDeclarationImpl#getOutputParameterDeclarations <em>Output Parameter Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.FunctionDeclarationImpl#getChecks <em>Checks</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.FunctionDeclarationImpl#getAssertions <em>Assertions</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.FunctionDeclarationImpl#getFunctionAliasDeclarations <em>Function Alias Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.FunctionDeclarationImpl#getStateVariableDeclarations <em>State Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.FunctionDeclarationImpl#getConstantDeclarations <em>Constant Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.FunctionDeclarationImpl#getEquations <em>Equations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionDeclarationImpl extends DeclarationImpl implements FunctionDeclaration {
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final FunctionKind KIND_EDEFAULT = FunctionKind.STATELESS;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected FunctionKind kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStaticParameterDeclarations() <em>Static Parameter Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStaticParameterDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<StaticParameterDeclaration> staticParameterDeclarations;

	/**
	 * The cached value of the '{@link #getInputParameterDeclarations() <em>Input Parameter Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputParameterDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<InputParameterDeclaration> inputParameterDeclarations;

	/**
	 * The cached value of the '{@link #getOutputParameterDeclarations() <em>Output Parameter Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputParameterDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputParameterDeclaration> outputParameterDeclarations;

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
	 * The cached value of the '{@link #getFunctionAliasDeclarations() <em>Function Alias Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionAliasDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionAliasDeclaration> functionAliasDeclarations;

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
	 * @generated
	 */
	public FunctionKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(FunctionKind newKind) {
		FunctionKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.FUNCTION_DECLARATION__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StaticParameterDeclaration> getStaticParameterDeclarations() {
		if (staticParameterDeclarations == null) {
			staticParameterDeclarations = new EObjectContainmentEList<StaticParameterDeclaration>(StaticParameterDeclaration.class, this, MscriptPackage.FUNCTION_DECLARATION__STATIC_PARAMETER_DECLARATIONS);
		}
		return staticParameterDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputParameterDeclaration> getInputParameterDeclarations() {
		if (inputParameterDeclarations == null) {
			inputParameterDeclarations = new EObjectContainmentEList<InputParameterDeclaration>(InputParameterDeclaration.class, this, MscriptPackage.FUNCTION_DECLARATION__INPUT_PARAMETER_DECLARATIONS);
		}
		return inputParameterDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputParameterDeclaration> getOutputParameterDeclarations() {
		if (outputParameterDeclarations == null) {
			outputParameterDeclarations = new EObjectContainmentEList<OutputParameterDeclaration>(OutputParameterDeclaration.class, this, MscriptPackage.FUNCTION_DECLARATION__OUTPUT_PARAMETER_DECLARATIONS);
		}
		return outputParameterDeclarations;
	}

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
	public EList<FunctionAliasDeclaration> getFunctionAliasDeclarations() {
		if (functionAliasDeclarations == null) {
			functionAliasDeclarations = new EObjectContainmentEList<FunctionAliasDeclaration>(FunctionAliasDeclaration.class, this, MscriptPackage.FUNCTION_DECLARATION__FUNCTION_ALIAS_DECLARATIONS);
		}
		return functionAliasDeclarations;
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
			case MscriptPackage.FUNCTION_DECLARATION__STATIC_PARAMETER_DECLARATIONS:
				return ((InternalEList<?>)getStaticParameterDeclarations()).basicRemove(otherEnd, msgs);
			case MscriptPackage.FUNCTION_DECLARATION__INPUT_PARAMETER_DECLARATIONS:
				return ((InternalEList<?>)getInputParameterDeclarations()).basicRemove(otherEnd, msgs);
			case MscriptPackage.FUNCTION_DECLARATION__OUTPUT_PARAMETER_DECLARATIONS:
				return ((InternalEList<?>)getOutputParameterDeclarations()).basicRemove(otherEnd, msgs);
			case MscriptPackage.FUNCTION_DECLARATION__CHECKS:
				return ((InternalEList<?>)getChecks()).basicRemove(otherEnd, msgs);
			case MscriptPackage.FUNCTION_DECLARATION__ASSERTIONS:
				return ((InternalEList<?>)getAssertions()).basicRemove(otherEnd, msgs);
			case MscriptPackage.FUNCTION_DECLARATION__FUNCTION_ALIAS_DECLARATIONS:
				return ((InternalEList<?>)getFunctionAliasDeclarations()).basicRemove(otherEnd, msgs);
			case MscriptPackage.FUNCTION_DECLARATION__STATE_VARIABLE_DECLARATIONS:
				return ((InternalEList<?>)getStateVariableDeclarations()).basicRemove(otherEnd, msgs);
			case MscriptPackage.FUNCTION_DECLARATION__CONSTANT_DECLARATIONS:
				return ((InternalEList<?>)getConstantDeclarations()).basicRemove(otherEnd, msgs);
			case MscriptPackage.FUNCTION_DECLARATION__EQUATIONS:
				return ((InternalEList<?>)getEquations()).basicRemove(otherEnd, msgs);
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
			case MscriptPackage.FUNCTION_DECLARATION__KIND:
				return getKind();
			case MscriptPackage.FUNCTION_DECLARATION__STATIC_PARAMETER_DECLARATIONS:
				return getStaticParameterDeclarations();
			case MscriptPackage.FUNCTION_DECLARATION__INPUT_PARAMETER_DECLARATIONS:
				return getInputParameterDeclarations();
			case MscriptPackage.FUNCTION_DECLARATION__OUTPUT_PARAMETER_DECLARATIONS:
				return getOutputParameterDeclarations();
			case MscriptPackage.FUNCTION_DECLARATION__CHECKS:
				return getChecks();
			case MscriptPackage.FUNCTION_DECLARATION__ASSERTIONS:
				return getAssertions();
			case MscriptPackage.FUNCTION_DECLARATION__FUNCTION_ALIAS_DECLARATIONS:
				return getFunctionAliasDeclarations();
			case MscriptPackage.FUNCTION_DECLARATION__STATE_VARIABLE_DECLARATIONS:
				return getStateVariableDeclarations();
			case MscriptPackage.FUNCTION_DECLARATION__CONSTANT_DECLARATIONS:
				return getConstantDeclarations();
			case MscriptPackage.FUNCTION_DECLARATION__EQUATIONS:
				return getEquations();
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
			case MscriptPackage.FUNCTION_DECLARATION__KIND:
				setKind((FunctionKind)newValue);
				return;
			case MscriptPackage.FUNCTION_DECLARATION__STATIC_PARAMETER_DECLARATIONS:
				getStaticParameterDeclarations().clear();
				getStaticParameterDeclarations().addAll((Collection<? extends StaticParameterDeclaration>)newValue);
				return;
			case MscriptPackage.FUNCTION_DECLARATION__INPUT_PARAMETER_DECLARATIONS:
				getInputParameterDeclarations().clear();
				getInputParameterDeclarations().addAll((Collection<? extends InputParameterDeclaration>)newValue);
				return;
			case MscriptPackage.FUNCTION_DECLARATION__OUTPUT_PARAMETER_DECLARATIONS:
				getOutputParameterDeclarations().clear();
				getOutputParameterDeclarations().addAll((Collection<? extends OutputParameterDeclaration>)newValue);
				return;
			case MscriptPackage.FUNCTION_DECLARATION__CHECKS:
				getChecks().clear();
				getChecks().addAll((Collection<? extends Check>)newValue);
				return;
			case MscriptPackage.FUNCTION_DECLARATION__ASSERTIONS:
				getAssertions().clear();
				getAssertions().addAll((Collection<? extends Assertion>)newValue);
				return;
			case MscriptPackage.FUNCTION_DECLARATION__FUNCTION_ALIAS_DECLARATIONS:
				getFunctionAliasDeclarations().clear();
				getFunctionAliasDeclarations().addAll((Collection<? extends FunctionAliasDeclaration>)newValue);
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
			case MscriptPackage.FUNCTION_DECLARATION__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case MscriptPackage.FUNCTION_DECLARATION__STATIC_PARAMETER_DECLARATIONS:
				getStaticParameterDeclarations().clear();
				return;
			case MscriptPackage.FUNCTION_DECLARATION__INPUT_PARAMETER_DECLARATIONS:
				getInputParameterDeclarations().clear();
				return;
			case MscriptPackage.FUNCTION_DECLARATION__OUTPUT_PARAMETER_DECLARATIONS:
				getOutputParameterDeclarations().clear();
				return;
			case MscriptPackage.FUNCTION_DECLARATION__CHECKS:
				getChecks().clear();
				return;
			case MscriptPackage.FUNCTION_DECLARATION__ASSERTIONS:
				getAssertions().clear();
				return;
			case MscriptPackage.FUNCTION_DECLARATION__FUNCTION_ALIAS_DECLARATIONS:
				getFunctionAliasDeclarations().clear();
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
			case MscriptPackage.FUNCTION_DECLARATION__KIND:
				return kind != KIND_EDEFAULT;
			case MscriptPackage.FUNCTION_DECLARATION__STATIC_PARAMETER_DECLARATIONS:
				return staticParameterDeclarations != null && !staticParameterDeclarations.isEmpty();
			case MscriptPackage.FUNCTION_DECLARATION__INPUT_PARAMETER_DECLARATIONS:
				return inputParameterDeclarations != null && !inputParameterDeclarations.isEmpty();
			case MscriptPackage.FUNCTION_DECLARATION__OUTPUT_PARAMETER_DECLARATIONS:
				return outputParameterDeclarations != null && !outputParameterDeclarations.isEmpty();
			case MscriptPackage.FUNCTION_DECLARATION__CHECKS:
				return checks != null && !checks.isEmpty();
			case MscriptPackage.FUNCTION_DECLARATION__ASSERTIONS:
				return assertions != null && !assertions.isEmpty();
			case MscriptPackage.FUNCTION_DECLARATION__FUNCTION_ALIAS_DECLARATIONS:
				return functionAliasDeclarations != null && !functionAliasDeclarations.isEmpty();
			case MscriptPackage.FUNCTION_DECLARATION__STATE_VARIABLE_DECLARATIONS:
				return stateVariableDeclarations != null && !stateVariableDeclarations.isEmpty();
			case MscriptPackage.FUNCTION_DECLARATION__CONSTANT_DECLARATIONS:
				return constantDeclarations != null && !constantDeclarations.isEmpty();
			case MscriptPackage.FUNCTION_DECLARATION__EQUATIONS:
				return equations != null && !equations.isEmpty();
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //FunctionDefinitionImpl
