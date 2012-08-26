/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.functionmodel.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.FunctionKind;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.ParameterDeclaration;
import org.eclipselabs.damos.mscript.functionmodel.EquationDescription;
import org.eclipselabs.damos.mscript.functionmodel.EquationPart;
import org.eclipselabs.damos.mscript.functionmodel.FunctionDescription;
import org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage;
import org.eclipselabs.damos.mscript.functionmodel.VariableDescription;
import org.eclipselabs.damos.mscript.functionmodel.VariableStep;
import org.eclipselabs.damos.mscript.functionmodel.util.FunctionModelValidator;
import org.eclipselabs.damos.mscript.internal.functionmodel.util.VariableDescriptorWrapper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.impl.FunctionDescriptionImpl#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.impl.FunctionDescriptionImpl#getEquationDescriptions <em>Equation Descriptions</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.impl.FunctionDescriptionImpl#getVariableDescriptions <em>Variable Descriptions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionDescriptionImpl extends EObjectImpl implements FunctionDescription {
	/**
	 * The cached value of the '{@link #getDeclaration() <em>Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaration()
	 * @generated
	 * @ordered
	 */
	protected FunctionDeclaration declaration;

	/**
	 * The cached value of the '{@link #getEquationDescriptions() <em>Equation Descriptions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquationDescriptions()
	 * @generated
	 * @ordered
	 */
	protected EList<EquationDescription> equationDescriptions;

	/**
	 * The cached value of the '{@link #getVariableDescriptions() <em>Variable Descriptions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableDescriptions()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableDescription> variableDescriptions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionModelPackage.Literals.FUNCTION_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDeclaration getDeclaration() {
		if (declaration != null && declaration.eIsProxy()) {
			InternalEObject oldDeclaration = (InternalEObject)declaration;
			declaration = (FunctionDeclaration)eResolveProxy(oldDeclaration);
			if (declaration != oldDeclaration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FunctionModelPackage.FUNCTION_DESCRIPTION__DECLARATION, oldDeclaration, declaration));
			}
		}
		return declaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDeclaration basicGetDeclaration() {
		return declaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaration(FunctionDeclaration newDeclaration) {
		FunctionDeclaration oldDeclaration = declaration;
		declaration = newDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionModelPackage.FUNCTION_DESCRIPTION__DECLARATION, oldDeclaration, declaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EquationDescription> getEquationDescriptions() {
		if (equationDescriptions == null) {
			equationDescriptions = new EObjectContainmentWithInverseEList<EquationDescription>(EquationDescription.class, this, FunctionModelPackage.FUNCTION_DESCRIPTION__EQUATION_DESCRIPTIONS, FunctionModelPackage.EQUATION_DESCRIPTION__FUNCTION_DESCRIPTION);
		}
		return equationDescriptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableDescription> getVariableDescriptions() {
		if (variableDescriptions == null) {
			variableDescriptions = new EObjectContainmentWithInverseEList<VariableDescription>(VariableDescription.class, this, FunctionModelPackage.FUNCTION_DESCRIPTION__VARIABLE_DESCRIPTIONS, FunctionModelPackage.VARIABLE_DESCRIPTION__FUNCTION_DESCRIPTION);
		}
		return variableDescriptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public VariableDescription getVariableDescription(String name) {
		for (VariableDescription variableDescription : getVariableDescriptions()) {
			if (name.equals(variableDescription.getName())) {
				return variableDescription;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasNoDuplicateEquations(DiagnosticChain diagnostics, Map<Object, Object> context) {
		Set<EquationPart> invalidEquationParts = new HashSet<EquationPart>();
		Map<VariableDescriptorWrapper, EquationPart> wrappers = new HashMap<VariableDescriptorWrapper, EquationPart>();
		
		for (EquationDescription equationDescription : getEquationDescriptions()) {
			if (!equationDescription.getLeftHandSide().getParts().isEmpty()) {
				EquationPart equationPart = equationDescription.getLeftHandSide().getParts().get(0);
				VariableStep variableStep = equationPart.getVariableStep();
				// If function is not continuous, we do not distinguish between initial and non-initial steps
				boolean initial = getDeclaration().getKind() == FunctionKind.CONTINUOUS ? variableStep.isInitial() : false;
				VariableDescriptorWrapper descriptor = new VariableDescriptorWrapper(variableStep.getVariableDescription().getName(), variableStep.getIndex(), initial, variableStep.isDerivative());
				EquationPart previousEquationPart = wrappers.put(descriptor, equationPart);
				if (previousEquationPart != null) {
					invalidEquationParts.add(equationPart);
					invalidEquationParts.add(previousEquationPart);
				}
			}
		}
		
		if (diagnostics != null) {
			for (EquationPart invalidEquationPart : invalidEquationParts) {
				VariableStep variableStep = invalidEquationPart.getVariableStep();

				StringBuilder message = new StringBuilder();
				message.append("Duplicate equation for ");
				message.append(variableStep.getVariableDescription().getName());
				if (variableStep.isDerivative()) {
					message.append("'");
				} else if (getDeclaration().getKind() == FunctionKind.STATEFUL) {
					message.append("{n");
					if (variableStep.getIndex() != 0) { 
						if (variableStep.getIndex() > 0) {
							message.append("+");
						}
						message.append(variableStep.getIndex());
					}
					message.append("}");
				}
				
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
						FunctionModelValidator.DIAGNOSTIC_SOURCE,
						FunctionModelValidator.FUNCTION_DESCRIPTION__HAS_NO_DUPLICATE_EQUATIONS,
						message.toString(),
						new Object[] { invalidEquationPart.getVariableReference() }));
			}
		}
		
		return invalidEquationParts.isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasNoCyclicEquations(DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		for (VariableDescription variableDescription : getVariableDescriptions()) {
			for (VariableStep variableStep : variableDescription.getSteps()) {
				if (hasCyclicEquations(new HashSet<VariableStep>(), variableStep)) {
					for (EquationPart equationPart : variableStep.getUsingEquationParts()) {
						String message;
						if (equationPart.getSide() == equationPart.getSide().getEquationDescription().getLeftHandSide()) {
							message = "Cyclic equation definition of '" + variableStep.getVariableDescription().getName() + "'";
						} else {
							message = "'" + variableStep.getVariableDescription().getName() + "' is part of a cyclic equation definition";
						}
						diagnostics.add(new BasicDiagnostic(
								Diagnostic.ERROR,
								FunctionModelValidator.DIAGNOSTIC_SOURCE,
								FunctionModelValidator.FUNCTION_DESCRIPTION__HAS_NO_CYCLIC_EQUATIONS,
								message,
								new Object[] { equationPart.getVariableReference() }));
					}
					result = false;
				}
			}
		}
		return result;
	}
	
	private boolean hasCyclicEquations(Set<VariableStep> dependents, VariableStep variableStep) {
		for (EquationPart usingEquationPart : variableStep.getUsingEquationParts()) {
			if (usingEquationPart.getSide() == usingEquationPart.getSide().getEquationDescription().getLeftHandSide()) {
				if (!dependents.add(variableStep)) {
					return true;
				}
				for (EquationPart rhsEquationPart : usingEquationPart.getSide().getEquationDescription().getRightHandSide().getParts()) {
					VariableStep rhsVariableStep = rhsEquationPart.getVariableStep();
					if (hasCyclicEquations(new HashSet<VariableStep>(dependents), rhsVariableStep)) {
						return true;
					}
				}
				break;
			}
		}
		return false;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasEquationsForEachOutput(DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		for (ParameterDeclaration parameterDeclaration : getDeclaration().getOutputParameterDeclarations()) {
			VariableDescription variableDescription = getVariableDescription(parameterDeclaration.getName());
			if (variableDescription != null) {
				hasPrecedentEquationsFor(variableDescription, 0, diagnostics);
			} else {
				if (diagnostics != null) {
					diagnostics.add(new BasicDiagnostic(
							Diagnostic.ERROR,
							FunctionModelValidator.DIAGNOSTIC_SOURCE,
							FunctionModelValidator.FUNCTION_DESCRIPTION__HAS_EQUATIONS_FOR_EACH_OUTPUT,
							"No equation specified for output '" + parameterDeclaration.getName() + "'",
							new Object[] { parameterDeclaration }));
				}
				result = false;
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasEquationsForEachVariableStep(DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		for (VariableDescription variableDescription : getVariableDescriptions()) {
			for (VariableStep variableStep : variableDescription.getSteps()) {
				for (EquationPart equationPart : variableStep.getUsingEquationParts()) {
					if (equationPart.getSide() == equationPart.getSide().getEquationDescription().getRightHandSide()) {
						if (!hasEquationsFor(equationPart.getVariableStep(), diagnostics)) {
							result = false;
						}
						break;
					}
				}
			}
		}
		return result;
	}
	
	private boolean hasEquationsFor(VariableStep variableStep, DiagnosticChain diagnostics) {
		int index = variableStep.getIndex();
		switch (variableStep.getVariableDescription().getKind()) {
		case INPUT_PARAMETER:
			// index == 0 => always ok
			// index > 0  => error: future input values cannot be referenced; checked by other validation
			if (index < 0) {
				return hasEquationForEachStep(variableStep.getVariableDescription(), -1, variableStep.getIndex(), true, diagnostics);
			}
			break;
		case OUTPUT_PARAMETER:
		case STATE_VARIABLE:
			return hasPrecedentEquationsFor(variableStep.getVariableDescription(), index, diagnostics);
		default:
			// Do nothing
			break;
		}
		return true;
	}
	
	private boolean hasPrecedentEquationsFor(VariableDescription variableDescription, int index, DiagnosticChain diagnostics) {
		boolean ok = false;
		for (VariableStep step : variableDescription.getSteps()) {
			if (!step.isInitial()) {
				for (EquationPart equationPart : step.getUsingEquationParts()) {
					if (equationPart.getSide() == equationPart.getSide().getEquationDescription().getLeftHandSide()) {
						if (step.getIndex() >= index) {
							ok = hasEquationForEachStep(variableDescription, step.getIndex(), index, false, diagnostics);
							if (!ok) {
								return ok;
							}
							break;
						}
					}
				}
			}
		}
		if (!ok && diagnostics != null) {
			String message = String.format(
					"No '%s{n+i} = ...' equation with i >= %d specified",
					variableDescription.getName(),
					index);
			diagnostics.add(new BasicDiagnostic(
					Diagnostic.ERROR,
					FunctionModelValidator.DIAGNOSTIC_SOURCE,
					FunctionModelValidator.FUNCTION_DESCRIPTION__HAS_EQUATIONS_FOR_EACH_VARIABLE_STEP,
					message,
					new Object[] { getDeclaration(), MscriptPackage.eINSTANCE.getFunctionDeclaration_Name() }));
		}
		return ok;
	}
	
	private boolean hasEquationForEachStep(VariableDescription variableDescription, int beginStepIndex, int endStepIndex, boolean initialOnly, DiagnosticChain diagnostics) {
		if (beginStepIndex > endStepIndex) {
			int temp = beginStepIndex;
			beginStepIndex = endStepIndex;
			endStepIndex = temp;
		}
		boolean result = true;
		for (int i = beginStepIndex; i <= endStepIndex; ++i) {
			if (!hasEquationForStep(variableDescription, i, initialOnly)) {
				if (diagnostics != null) {
					String message;
					if (initialOnly) {
						message = String.format(
								"No '%s{%d} = ...' equation specified",
								variableDescription.getName(),
								i);
					} else {
						message = String.format(
								"No '%s{%d} = ...' or '%s{n%s} = ...' equation specified",
								variableDescription.getName(),
								i,
								variableDescription.getName(),
								i == 0 ? "" : (i < 0 ? "" : "+") + Integer.toString(i));
					}
					diagnostics.add(new BasicDiagnostic(
							Diagnostic.ERROR,
							FunctionModelValidator.DIAGNOSTIC_SOURCE,
							FunctionModelValidator.FUNCTION_DESCRIPTION__HAS_EQUATIONS_FOR_EACH_VARIABLE_STEP,
							message,
							new Object[] { getDeclaration(), MscriptPackage.eINSTANCE.getFunctionDeclaration_Name() }));
				}
				result = false;
			}
		}
		return result;
	}

	private boolean hasEquationForStep(VariableDescription variableDescription, int stepIndex, boolean initialOnly) {
		for (VariableStep variableStep : variableDescription.getSteps()) {
			if (variableStep.getIndex() == stepIndex && (!initialOnly || variableStep.isInitial())) {
				for (EquationPart equationPart : variableStep.getUsingEquationParts()) {
					if (equationPart.getSide() == equationPart.getSide().getEquationDescription().getLeftHandSide()) {
						return true;
					}
				}
			}
		}
		return false;
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
			case FunctionModelPackage.FUNCTION_DESCRIPTION__EQUATION_DESCRIPTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEquationDescriptions()).basicAdd(otherEnd, msgs);
			case FunctionModelPackage.FUNCTION_DESCRIPTION__VARIABLE_DESCRIPTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getVariableDescriptions()).basicAdd(otherEnd, msgs);
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
			case FunctionModelPackage.FUNCTION_DESCRIPTION__EQUATION_DESCRIPTIONS:
				return ((InternalEList<?>)getEquationDescriptions()).basicRemove(otherEnd, msgs);
			case FunctionModelPackage.FUNCTION_DESCRIPTION__VARIABLE_DESCRIPTIONS:
				return ((InternalEList<?>)getVariableDescriptions()).basicRemove(otherEnd, msgs);
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
			case FunctionModelPackage.FUNCTION_DESCRIPTION__DECLARATION:
				if (resolve) return getDeclaration();
				return basicGetDeclaration();
			case FunctionModelPackage.FUNCTION_DESCRIPTION__EQUATION_DESCRIPTIONS:
				return getEquationDescriptions();
			case FunctionModelPackage.FUNCTION_DESCRIPTION__VARIABLE_DESCRIPTIONS:
				return getVariableDescriptions();
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
			case FunctionModelPackage.FUNCTION_DESCRIPTION__DECLARATION:
				setDeclaration((FunctionDeclaration)newValue);
				return;
			case FunctionModelPackage.FUNCTION_DESCRIPTION__EQUATION_DESCRIPTIONS:
				getEquationDescriptions().clear();
				getEquationDescriptions().addAll((Collection<? extends EquationDescription>)newValue);
				return;
			case FunctionModelPackage.FUNCTION_DESCRIPTION__VARIABLE_DESCRIPTIONS:
				getVariableDescriptions().clear();
				getVariableDescriptions().addAll((Collection<? extends VariableDescription>)newValue);
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
			case FunctionModelPackage.FUNCTION_DESCRIPTION__DECLARATION:
				setDeclaration((FunctionDeclaration)null);
				return;
			case FunctionModelPackage.FUNCTION_DESCRIPTION__EQUATION_DESCRIPTIONS:
				getEquationDescriptions().clear();
				return;
			case FunctionModelPackage.FUNCTION_DESCRIPTION__VARIABLE_DESCRIPTIONS:
				getVariableDescriptions().clear();
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
			case FunctionModelPackage.FUNCTION_DESCRIPTION__DECLARATION:
				return declaration != null;
			case FunctionModelPackage.FUNCTION_DESCRIPTION__EQUATION_DESCRIPTIONS:
				return equationDescriptions != null && !equationDescriptions.isEmpty();
			case FunctionModelPackage.FUNCTION_DESCRIPTION__VARIABLE_DESCRIPTIONS:
				return variableDescriptions != null && !variableDescriptions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FunctionImpl
