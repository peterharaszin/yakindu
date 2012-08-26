/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.function.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipselabs.damos.mscript.function.ComputationCompound;
import org.eclipselabs.damos.mscript.function.EquationDescription;
import org.eclipselabs.damos.mscript.function.EquationPart;
import org.eclipselabs.damos.mscript.function.EquationSide;
import org.eclipselabs.damos.mscript.function.FunctionDescription;
import org.eclipselabs.damos.mscript.function.FunctionInstance;
import org.eclipselabs.damos.mscript.function.FunctionModelPackage;
import org.eclipselabs.damos.mscript.function.VariableDescription;
import org.eclipselabs.damos.mscript.function.VariableKind;
import org.eclipselabs.damos.mscript.function.VariableStep;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.mscript.function.FunctionModelPackage
 * @generated
 */
public class FunctionModelValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final FunctionModelValidator INSTANCE = new FunctionModelValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipselabs.damos.mscript.function";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has No Duplicate Equations' of 'Function Description'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FUNCTION_DESCRIPTION__HAS_NO_DUPLICATE_EQUATIONS = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has No Cyclic Equations' of 'Function Description'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FUNCTION_DESCRIPTION__HAS_NO_CYCLIC_EQUATIONS = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has Equations For Each Output' of 'Function Description'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FUNCTION_DESCRIPTION__HAS_EQUATIONS_FOR_EACH_OUTPUT = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has Equations For Each Variable Step' of 'Function Description'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FUNCTION_DESCRIPTION__HAS_EQUATIONS_FOR_EACH_VARIABLE_STEP = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Is Left Hand Side Valid' of 'Equation Description'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EQUATION_DESCRIPTION__IS_LEFT_HAND_SIDE_VALID = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Is Right Hand Side Valid' of 'Equation Description'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EQUATION_DESCRIPTION__IS_RIGHT_HAND_SIDE_VALID = 6;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 6;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionModelValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return FunctionModelPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case FunctionModelPackage.FUNCTION_DESCRIPTION:
				return validateFunctionDescription((FunctionDescription)value, diagnostics, context);
			case FunctionModelPackage.EQUATION_DESCRIPTION:
				return validateEquationDescription((EquationDescription)value, diagnostics, context);
			case FunctionModelPackage.EQUATION_SIDE:
				return validateEquationSide((EquationSide)value, diagnostics, context);
			case FunctionModelPackage.EQUATION_PART:
				return validateEquationPart((EquationPart)value, diagnostics, context);
			case FunctionModelPackage.VARIABLE_DESCRIPTION:
				return validateVariableDescription((VariableDescription)value, diagnostics, context);
			case FunctionModelPackage.VARIABLE_STEP:
				return validateVariableStep((VariableStep)value, diagnostics, context);
			case FunctionModelPackage.FUNCTION_INSTANCE:
				return validateFunctionInstance((FunctionInstance)value, diagnostics, context);
			case FunctionModelPackage.COMPUTATION_COMPOUND:
				return validateComputationCompound((ComputationCompound)value, diagnostics, context);
			case FunctionModelPackage.VARIABLE_KIND:
				return validateVariableKind((VariableKind)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionDescription(FunctionDescription functionDescription, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(functionDescription, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(functionDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(functionDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(functionDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(functionDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(functionDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(functionDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(functionDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(functionDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validateFunctionDescription_hasNoDuplicateEquations(functionDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validateFunctionDescription_hasNoCyclicEquations(functionDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validateFunctionDescription_hasEquationsForEachOutput(functionDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validateFunctionDescription_hasEquationsForEachVariableStep(functionDescription, diagnostics, context);
		return result;
	}

	/**
	 * Validates the hasNoDuplicateEquations constraint of '<em>Function Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionDescription_hasNoDuplicateEquations(FunctionDescription functionDescription, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return functionDescription.hasNoDuplicateEquations(diagnostics, context);
	}

	/**
	 * Validates the hasNoCyclicEquations constraint of '<em>Function Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionDescription_hasNoCyclicEquations(FunctionDescription functionDescription, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return functionDescription.hasNoCyclicEquations(diagnostics, context);
	}

	/**
	 * Validates the hasEquationsForEachOutput constraint of '<em>Function Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionDescription_hasEquationsForEachOutput(FunctionDescription functionDescription, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return functionDescription.hasEquationsForEachOutput(diagnostics, context);
	}

	/**
	 * Validates the hasEquationsForEachVariableStep constraint of '<em>Function Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionDescription_hasEquationsForEachVariableStep(FunctionDescription functionDescription, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return functionDescription.hasEquationsForEachVariableStep(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEquationDescription(EquationDescription equationDescription, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(equationDescription, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(equationDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(equationDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(equationDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(equationDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(equationDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(equationDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(equationDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(equationDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validateEquationDescription_isLeftHandSideValid(equationDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validateEquationDescription_isRightHandSideValid(equationDescription, diagnostics, context);
		return result;
	}

	/**
	 * Validates the isLeftHandSideValid constraint of '<em>Equation Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEquationDescription_isLeftHandSideValid(EquationDescription equationDescription, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return equationDescription.isLeftHandSideValid(diagnostics, context);
	}

	/**
	 * Validates the isRightHandSideValid constraint of '<em>Equation Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEquationDescription_isRightHandSideValid(EquationDescription equationDescription, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return equationDescription.isRightHandSideValid(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEquationSide(EquationSide equationSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(equationSide, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEquationPart(EquationPart equationPart, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(equationPart, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableDescription(VariableDescription variableDescription, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(variableDescription, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableStep(VariableStep variableStep, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(variableStep, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionInstance(FunctionInstance functionInstance, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(functionInstance, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComputationCompound(ComputationCompound computationCompound, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(computationCompound, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableKind(VariableKind variableKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //FunctionModelValidator
