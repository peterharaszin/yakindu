/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.functionmodel.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipselabs.mscript.language.functionmodel.Equation;
import org.eclipselabs.mscript.language.functionmodel.EquationPart;
import org.eclipselabs.mscript.language.functionmodel.EquationSide;
import org.eclipselabs.mscript.language.functionmodel.Function;
import org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage;
import org.eclipselabs.mscript.language.functionmodel.VariableReference;
import org.eclipselabs.mscript.language.functionmodel.VariableReferenceKind;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage
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
	public static final String DIAGNOSTIC_SOURCE = "org.eclipselabs.mscript.language.functionmodel";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Equation Exists For Each Output' of 'Function'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FUNCTION__EQUATION_EXISTS_FOR_EACH_OUTPUT = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Equation Exists For Each Step' of 'Function'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FUNCTION__EQUATION_EXISTS_FOR_EACH_STEP = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has No Duplicate Equations' of 'Function'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FUNCTION__HAS_NO_DUPLICATE_EQUATIONS = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Left Hand Side Is Single Variable Reference' of 'Equation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EQUATION__LEFT_HAND_SIDE_IS_SINGLE_VARIABLE_REFERENCE = 4;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 4;

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
			case FunctionModelPackage.FUNCTION:
				return validateFunction((Function)value, diagnostics, context);
			case FunctionModelPackage.EQUATION:
				return validateEquation((Equation)value, diagnostics, context);
			case FunctionModelPackage.EQUATION_SIDE:
				return validateEquationSide((EquationSide)value, diagnostics, context);
			case FunctionModelPackage.EQUATION_PART:
				return validateEquationPart((EquationPart)value, diagnostics, context);
			case FunctionModelPackage.VARIABLE_REFERENCE:
				return validateVariableReference((VariableReference)value, diagnostics, context);
			case FunctionModelPackage.VARIABLE_REFERENCE_KIND:
				return validateVariableReferenceKind((VariableReferenceKind)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunction(Function function, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(function, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(function, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(function, diagnostics, context);
		if (result || diagnostics != null) result &= validateFunction_hasNoDuplicateEquations(function, diagnostics, context);
		if (result || diagnostics != null) result &= validateFunction_equationExistsForEachOutput(function, diagnostics, context);
		if (result || diagnostics != null) result &= validateFunction_equationExistsForEachStep(function, diagnostics, context);
		return result;
	}

	/**
	 * Validates the equationExistsForEachOutput constraint of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunction_equationExistsForEachOutput(Function function, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return function.equationExistsForEachOutput(diagnostics, context);
	}

	/**
	 * Validates the equationExistsForEachStep constraint of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunction_equationExistsForEachStep(Function function, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return function.equationExistsForEachStep(diagnostics, context);
	}

	/**
	 * Validates the hasNoDuplicateEquations constraint of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunction_hasNoDuplicateEquations(Function function, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return function.hasNoDuplicateEquations(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEquation(Equation equation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(equation, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(equation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(equation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(equation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(equation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(equation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(equation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(equation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(equation, diagnostics, context);
		if (result || diagnostics != null) result &= validateEquation_leftHandSideIsSingleVariableReference(equation, diagnostics, context);
		return result;
	}

	/**
	 * Validates the leftHandSideIsSingleVariableReference constraint of '<em>Equation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEquation_leftHandSideIsSingleVariableReference(Equation equation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return equation.leftHandSideIsSingleVariableReference(diagnostics, context);
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
	public boolean validateVariableReference(VariableReference variableReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(variableReference, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableReferenceKind(VariableReferenceKind variableReferenceKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
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
