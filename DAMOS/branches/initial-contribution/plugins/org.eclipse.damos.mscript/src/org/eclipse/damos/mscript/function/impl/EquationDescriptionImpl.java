/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.mscript.function.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.damos.mscript.Equation;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.OperatorKind;
import org.eclipse.damos.mscript.UnaryExpression;
import org.eclipse.damos.mscript.function.EquationDescription;
import org.eclipse.damos.mscript.function.EquationPart;
import org.eclipse.damos.mscript.function.EquationSide;
import org.eclipse.damos.mscript.function.FunctionDescription;
import org.eclipse.damos.mscript.function.FunctionPackage;
import org.eclipse.damos.mscript.function.util.FunctionValidator;
import org.eclipse.damos.mscript.util.MscriptUtil;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.function.impl.EquationDescriptionImpl#getFunctionDescription <em>Function Description</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.function.impl.EquationDescriptionImpl#getEquation <em>Equation</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.function.impl.EquationDescriptionImpl#getSides <em>Sides</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.function.impl.EquationDescriptionImpl#getLeftHandSide <em>Left Hand Side</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.function.impl.EquationDescriptionImpl#getRightHandSide <em>Right Hand Side</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EquationDescriptionImpl extends EObjectImpl implements EquationDescription {
	/**
	 * The cached value of the '{@link #getEquation() <em>Equation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquation()
	 * @generated
	 * @ordered
	 */
	protected Equation equation;

	/**
	 * The cached value of the '{@link #getSides() <em>Sides</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSides()
	 * @generated
	 * @ordered
	 */
	protected EList<EquationSide> sides;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EquationDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionPackage.Literals.EQUATION_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDescription getFunctionDescription() {
		if (eContainerFeatureID() != FunctionPackage.EQUATION_DESCRIPTION__FUNCTION_DESCRIPTION) return null;
		return (FunctionDescription)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFunctionDescription(FunctionDescription newFunctionDescription, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFunctionDescription, FunctionPackage.EQUATION_DESCRIPTION__FUNCTION_DESCRIPTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctionDescription(FunctionDescription newFunctionDescription) {
		if (newFunctionDescription != eInternalContainer() || (eContainerFeatureID() != FunctionPackage.EQUATION_DESCRIPTION__FUNCTION_DESCRIPTION && newFunctionDescription != null)) {
			if (EcoreUtil.isAncestor(this, newFunctionDescription))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFunctionDescription != null)
				msgs = ((InternalEObject)newFunctionDescription).eInverseAdd(this, FunctionPackage.FUNCTION_DESCRIPTION__EQUATION_DESCRIPTIONS, FunctionDescription.class, msgs);
			msgs = basicSetFunctionDescription(newFunctionDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionPackage.EQUATION_DESCRIPTION__FUNCTION_DESCRIPTION, newFunctionDescription, newFunctionDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equation getEquation() {
		if (equation != null && equation.eIsProxy()) {
			InternalEObject oldEquation = (InternalEObject)equation;
			equation = (Equation)eResolveProxy(oldEquation);
			if (equation != oldEquation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FunctionPackage.EQUATION_DESCRIPTION__EQUATION, oldEquation, equation));
			}
		}
		return equation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equation basicGetEquation() {
		return equation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEquation(Equation newEquation) {
		Equation oldEquation = equation;
		equation = newEquation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionPackage.EQUATION_DESCRIPTION__EQUATION, oldEquation, equation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EquationSide> getSides() {
		if (sides == null) {
			sides = new EObjectContainmentWithInverseEList<EquationSide>(EquationSide.class, this, FunctionPackage.EQUATION_DESCRIPTION__SIDES, FunctionPackage.EQUATION_SIDE__EQUATION_DESCRIPTION);
		}
		return sides;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquationSide getLeftHandSide() {
		EquationSide leftHandSide = basicGetLeftHandSide();
		return leftHandSide != null && leftHandSide.eIsProxy() ? (EquationSide)eResolveProxy((InternalEObject)leftHandSide) : leftHandSide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EquationSide basicGetLeftHandSide() {
		List<EquationSide> sides = getSides();
		return sides.size() > 0 ? sides.get(0) : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquationSide getRightHandSide() {
		EquationSide rightHandSide = basicGetRightHandSide();
		return rightHandSide != null && rightHandSide.eIsProxy() ? (EquationSide)eResolveProxy((InternalEObject)rightHandSide) : rightHandSide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EquationSide basicGetRightHandSide() {
		List<EquationSide> sides = getSides();
		return sides.size() > 1 ? sides.get(1) : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isLeftHandSideValid(DiagnosticChain diagnostics, Map<Object, Object> context) {
		Expression lhsExpression = getEquation().getLeftHandSide();
		String message = null;
		if (getLeftHandSide().getParts().size() == 1 && MscriptUtil.isVariableReference(lhsExpression)) {
			EquationPart part = getLeftHandSide().getParts().get(0);
			switch (part.getVariableStep().getVariableDescription().getKind()) {
			case CONSTANT_INPUT_PARAMETER:
				message = "Left-hand side must not reference a constant input parameter";
				break;
			case INPUT_PARAMETER:
				if (!part.getVariableStep().isInitial() || part.getVariableStep().getIndex() >= 0) {
					message = "Left-hand side input reference must be negative initial step";
				}
				break;
			case CONSTANT:
				message = "Left-hand side must not reference a constant";
				break;
			default:
				if (part.getVariableStep().getIndex() < 0 && !part.getVariableStep().isInitial()) {
					message = "Left-hand side must not reference a previous value";
				}
				break;
			}
		} else if (lhsExpression instanceof UnaryExpression && ((UnaryExpression) lhsExpression).getOperator() == OperatorKind.DERIVATIVE) {
			
		} else {
			message = "Left-hand side must be single variable reference";
		}
		if (message != null && diagnostics != null) {
			diagnostics.add(new BasicDiagnostic(
					Diagnostic.ERROR,
					FunctionValidator.DIAGNOSTIC_SOURCE,
					FunctionValidator.EQUATION_DESCRIPTION__IS_LEFT_HAND_SIDE_VALID,
					message,
					new Object [] { lhsExpression }));
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isRightHandSideValid(DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		for (EquationPart part : getRightHandSide().getParts()) {
			if (part.getVariableStep().isInitial()) {
				if (diagnostics != null) {
					diagnostics.add(new BasicDiagnostic(
							Diagnostic.ERROR,
							FunctionValidator.DIAGNOSTIC_SOURCE,
							FunctionValidator.EQUATION_DESCRIPTION__IS_RIGHT_HAND_SIDE_VALID,
							"Right-hand side must not reference initial value",
							new Object [] { part.getVariableReference() }));
				}
				result = false;
			}
		}
		return result;
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
			case FunctionPackage.EQUATION_DESCRIPTION__FUNCTION_DESCRIPTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFunctionDescription((FunctionDescription)otherEnd, msgs);
			case FunctionPackage.EQUATION_DESCRIPTION__SIDES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSides()).basicAdd(otherEnd, msgs);
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
			case FunctionPackage.EQUATION_DESCRIPTION__FUNCTION_DESCRIPTION:
				return basicSetFunctionDescription(null, msgs);
			case FunctionPackage.EQUATION_DESCRIPTION__SIDES:
				return ((InternalEList<?>)getSides()).basicRemove(otherEnd, msgs);
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
			case FunctionPackage.EQUATION_DESCRIPTION__FUNCTION_DESCRIPTION:
				return eInternalContainer().eInverseRemove(this, FunctionPackage.FUNCTION_DESCRIPTION__EQUATION_DESCRIPTIONS, FunctionDescription.class, msgs);
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
			case FunctionPackage.EQUATION_DESCRIPTION__FUNCTION_DESCRIPTION:
				return getFunctionDescription();
			case FunctionPackage.EQUATION_DESCRIPTION__EQUATION:
				if (resolve) return getEquation();
				return basicGetEquation();
			case FunctionPackage.EQUATION_DESCRIPTION__SIDES:
				return getSides();
			case FunctionPackage.EQUATION_DESCRIPTION__LEFT_HAND_SIDE:
				if (resolve) return getLeftHandSide();
				return basicGetLeftHandSide();
			case FunctionPackage.EQUATION_DESCRIPTION__RIGHT_HAND_SIDE:
				if (resolve) return getRightHandSide();
				return basicGetRightHandSide();
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
			case FunctionPackage.EQUATION_DESCRIPTION__FUNCTION_DESCRIPTION:
				setFunctionDescription((FunctionDescription)newValue);
				return;
			case FunctionPackage.EQUATION_DESCRIPTION__EQUATION:
				setEquation((Equation)newValue);
				return;
			case FunctionPackage.EQUATION_DESCRIPTION__SIDES:
				getSides().clear();
				getSides().addAll((Collection<? extends EquationSide>)newValue);
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
			case FunctionPackage.EQUATION_DESCRIPTION__FUNCTION_DESCRIPTION:
				setFunctionDescription((FunctionDescription)null);
				return;
			case FunctionPackage.EQUATION_DESCRIPTION__EQUATION:
				setEquation((Equation)null);
				return;
			case FunctionPackage.EQUATION_DESCRIPTION__SIDES:
				getSides().clear();
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
			case FunctionPackage.EQUATION_DESCRIPTION__FUNCTION_DESCRIPTION:
				return getFunctionDescription() != null;
			case FunctionPackage.EQUATION_DESCRIPTION__EQUATION:
				return equation != null;
			case FunctionPackage.EQUATION_DESCRIPTION__SIDES:
				return sides != null && !sides.isEmpty();
			case FunctionPackage.EQUATION_DESCRIPTION__LEFT_HAND_SIDE:
				return basicGetLeftHandSide() != null;
			case FunctionPackage.EQUATION_DESCRIPTION__RIGHT_HAND_SIDE:
				return basicGetRightHandSide() != null;
		}
		return super.eIsSet(featureID);
	}

} //EquationImpl
