/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.function;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipselabs.damos.mscript.MscriptPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.mscript.function.FunctionFactory
 * @model kind="package"
 * @generated
 */
public interface FunctionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "function";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/damos/mscript/2011/Function";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "function";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FunctionPackage eINSTANCE = org.eclipselabs.damos.mscript.function.impl.FunctionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.function.impl.FunctionDescriptionImpl <em>Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.function.impl.FunctionDescriptionImpl
	 * @see org.eclipselabs.damos.mscript.function.impl.FunctionPackageImpl#getFunctionDescription()
	 * @generated
	 */
	int FUNCTION_DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DESCRIPTION__DECLARATION = 0;

	/**
	 * The feature id for the '<em><b>Equation Descriptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DESCRIPTION__EQUATION_DESCRIPTIONS = 1;

	/**
	 * The feature id for the '<em><b>Variable Descriptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DESCRIPTION__VARIABLE_DESCRIPTIONS = 2;

	/**
	 * The feature id for the '<em><b>Stateful</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DESCRIPTION__STATEFUL = 3;

	/**
	 * The number of structural features of the '<em>Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DESCRIPTION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.function.impl.EquationDescriptionImpl <em>Equation Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.function.impl.EquationDescriptionImpl
	 * @see org.eclipselabs.damos.mscript.function.impl.FunctionPackageImpl#getEquationDescription()
	 * @generated
	 */
	int EQUATION_DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Function Description</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_DESCRIPTION__FUNCTION_DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Equation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_DESCRIPTION__EQUATION = 1;

	/**
	 * The feature id for the '<em><b>Sides</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_DESCRIPTION__SIDES = 2;

	/**
	 * The feature id for the '<em><b>Left Hand Side</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_DESCRIPTION__LEFT_HAND_SIDE = 3;

	/**
	 * The feature id for the '<em><b>Right Hand Side</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_DESCRIPTION__RIGHT_HAND_SIDE = 4;

	/**
	 * The number of structural features of the '<em>Equation Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_DESCRIPTION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.function.impl.EquationSideImpl <em>Equation Side</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.function.impl.EquationSideImpl
	 * @see org.eclipselabs.damos.mscript.function.impl.FunctionPackageImpl#getEquationSide()
	 * @generated
	 */
	int EQUATION_SIDE = 2;

	/**
	 * The feature id for the '<em><b>Equation Description</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_SIDE__EQUATION_DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_SIDE__EXPRESSION = 1;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_SIDE__PARTS = 2;

	/**
	 * The number of structural features of the '<em>Equation Side</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_SIDE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.function.impl.EquationPartImpl <em>Equation Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.function.impl.EquationPartImpl
	 * @see org.eclipselabs.damos.mscript.function.impl.FunctionPackageImpl#getEquationPart()
	 * @generated
	 */
	int EQUATION_PART = 3;

	/**
	 * The feature id for the '<em><b>Side</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_PART__SIDE = 0;

	/**
	 * The feature id for the '<em><b>Variable Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_PART__VARIABLE_REFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Variable Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_PART__VARIABLE_STEP = 2;

	/**
	 * The number of structural features of the '<em>Equation Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_PART_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.function.impl.VariableDescriptionImpl <em>Variable Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.function.impl.VariableDescriptionImpl
	 * @see org.eclipselabs.damos.mscript.function.impl.FunctionPackageImpl#getVariableDescription()
	 * @generated
	 */
	int VARIABLE_DESCRIPTION = 4;

	/**
	 * The feature id for the '<em><b>Function Description</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DESCRIPTION__FUNCTION_DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DESCRIPTION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DESCRIPTION__KIND = 2;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DESCRIPTION__STEPS = 3;

	/**
	 * The number of structural features of the '<em>Variable Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DESCRIPTION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.function.impl.VariableStepImpl <em>Variable Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.function.impl.VariableStepImpl
	 * @see org.eclipselabs.damos.mscript.function.impl.FunctionPackageImpl#getVariableStep()
	 * @generated
	 */
	int VARIABLE_STEP = 5;

	/**
	 * The feature id for the '<em><b>Variable Description</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STEP__VARIABLE_DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STEP__INDEX = 1;

	/**
	 * The feature id for the '<em><b>Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STEP__INITIAL = 2;

	/**
	 * The feature id for the '<em><b>Derivative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STEP__DERIVATIVE = 3;

	/**
	 * The feature id for the '<em><b>Using Equation Parts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STEP__USING_EQUATION_PARTS = 4;

	/**
	 * The number of structural features of the '<em>Variable Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STEP_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.function.impl.FunctionInstanceImpl <em>Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.function.impl.FunctionInstanceImpl
	 * @see org.eclipselabs.damos.mscript.function.impl.FunctionPackageImpl#getFunctionInstance()
	 * @generated
	 */
	int FUNCTION_INSTANCE = 6;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_INSTANCE__DECLARATION = 0;

	/**
	 * The feature id for the '<em><b>Initialization Compound</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_INSTANCE__INITIALIZATION_COMPOUND = 1;

	/**
	 * The feature id for the '<em><b>Computation Compounds</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_INSTANCE__COMPUTATION_COMPOUNDS = 2;

	/**
	 * The number of structural features of the '<em>Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_INSTANCE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.function.impl.ComputationCompoundImpl <em>Computation Compound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.function.impl.ComputationCompoundImpl
	 * @see org.eclipselabs.damos.mscript.function.impl.FunctionPackageImpl#getComputationCompound()
	 * @generated
	 */
	int COMPUTATION_COMPOUND = 7;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_COMPOUND__STATEMENTS = MscriptPackage.COMPOUND_STATEMENT__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_COMPOUND__INPUTS = MscriptPackage.COMPOUND_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_COMPOUND__OUTPUTS = MscriptPackage.COMPOUND_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Derivatives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_COMPOUND__DERIVATIVES = MscriptPackage.COMPOUND_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Computation Compound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_COMPOUND_FEATURE_COUNT = MscriptPackage.COMPOUND_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.function.VariableKind <em>Variable Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.function.VariableKind
	 * @see org.eclipselabs.damos.mscript.function.impl.FunctionPackageImpl#getVariableKind()
	 * @generated
	 */
	int VARIABLE_KIND = 8;


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.function.FunctionDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Description</em>'.
	 * @see org.eclipselabs.damos.mscript.function.FunctionDescription
	 * @generated
	 */
	EClass getFunctionDescription();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.mscript.function.FunctionDescription#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Declaration</em>'.
	 * @see org.eclipselabs.damos.mscript.function.FunctionDescription#getDeclaration()
	 * @see #getFunctionDescription()
	 * @generated
	 */
	EReference getFunctionDescription_Declaration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.mscript.function.FunctionDescription#getEquationDescriptions <em>Equation Descriptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Equation Descriptions</em>'.
	 * @see org.eclipselabs.damos.mscript.function.FunctionDescription#getEquationDescriptions()
	 * @see #getFunctionDescription()
	 * @generated
	 */
	EReference getFunctionDescription_EquationDescriptions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.mscript.function.FunctionDescription#getVariableDescriptions <em>Variable Descriptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable Descriptions</em>'.
	 * @see org.eclipselabs.damos.mscript.function.FunctionDescription#getVariableDescriptions()
	 * @see #getFunctionDescription()
	 * @generated
	 */
	EReference getFunctionDescription_VariableDescriptions();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.mscript.function.FunctionDescription#isStateful <em>Stateful</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stateful</em>'.
	 * @see org.eclipselabs.damos.mscript.function.FunctionDescription#isStateful()
	 * @see #getFunctionDescription()
	 * @generated
	 */
	EAttribute getFunctionDescription_Stateful();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.function.EquationDescription <em>Equation Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equation Description</em>'.
	 * @see org.eclipselabs.damos.mscript.function.EquationDescription
	 * @generated
	 */
	EClass getEquationDescription();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.mscript.function.EquationDescription#getFunctionDescription <em>Function Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Function Description</em>'.
	 * @see org.eclipselabs.damos.mscript.function.EquationDescription#getFunctionDescription()
	 * @see #getEquationDescription()
	 * @generated
	 */
	EReference getEquationDescription_FunctionDescription();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.mscript.function.EquationDescription#getEquation <em>Equation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Equation</em>'.
	 * @see org.eclipselabs.damos.mscript.function.EquationDescription#getEquation()
	 * @see #getEquationDescription()
	 * @generated
	 */
	EReference getEquationDescription_Equation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.mscript.function.EquationDescription#getSides <em>Sides</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sides</em>'.
	 * @see org.eclipselabs.damos.mscript.function.EquationDescription#getSides()
	 * @see #getEquationDescription()
	 * @generated
	 */
	EReference getEquationDescription_Sides();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.mscript.function.EquationDescription#getLeftHandSide <em>Left Hand Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left Hand Side</em>'.
	 * @see org.eclipselabs.damos.mscript.function.EquationDescription#getLeftHandSide()
	 * @see #getEquationDescription()
	 * @generated
	 */
	EReference getEquationDescription_LeftHandSide();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.mscript.function.EquationDescription#getRightHandSide <em>Right Hand Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right Hand Side</em>'.
	 * @see org.eclipselabs.damos.mscript.function.EquationDescription#getRightHandSide()
	 * @see #getEquationDescription()
	 * @generated
	 */
	EReference getEquationDescription_RightHandSide();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.function.EquationSide <em>Equation Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equation Side</em>'.
	 * @see org.eclipselabs.damos.mscript.function.EquationSide
	 * @generated
	 */
	EClass getEquationSide();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.mscript.function.EquationSide#getEquationDescription <em>Equation Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Equation Description</em>'.
	 * @see org.eclipselabs.damos.mscript.function.EquationSide#getEquationDescription()
	 * @see #getEquationSide()
	 * @generated
	 */
	EReference getEquationSide_EquationDescription();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.mscript.function.EquationSide#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expression</em>'.
	 * @see org.eclipselabs.damos.mscript.function.EquationSide#getExpression()
	 * @see #getEquationSide()
	 * @generated
	 */
	EReference getEquationSide_Expression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.mscript.function.EquationSide#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see org.eclipselabs.damos.mscript.function.EquationSide#getParts()
	 * @see #getEquationSide()
	 * @generated
	 */
	EReference getEquationSide_Parts();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.function.EquationPart <em>Equation Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equation Part</em>'.
	 * @see org.eclipselabs.damos.mscript.function.EquationPart
	 * @generated
	 */
	EClass getEquationPart();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.mscript.function.EquationPart#getSide <em>Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Side</em>'.
	 * @see org.eclipselabs.damos.mscript.function.EquationPart#getSide()
	 * @see #getEquationPart()
	 * @generated
	 */
	EReference getEquationPart_Side();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.mscript.function.EquationPart#getVariableReference <em>Variable Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable Reference</em>'.
	 * @see org.eclipselabs.damos.mscript.function.EquationPart#getVariableReference()
	 * @see #getEquationPart()
	 * @generated
	 */
	EReference getEquationPart_VariableReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.mscript.function.EquationPart#getVariableStep <em>Variable Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable Step</em>'.
	 * @see org.eclipselabs.damos.mscript.function.EquationPart#getVariableStep()
	 * @see #getEquationPart()
	 * @generated
	 */
	EReference getEquationPart_VariableStep();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.function.VariableDescription <em>Variable Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Description</em>'.
	 * @see org.eclipselabs.damos.mscript.function.VariableDescription
	 * @generated
	 */
	EClass getVariableDescription();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.mscript.function.VariableDescription#getFunctionDescription <em>Function Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Function Description</em>'.
	 * @see org.eclipselabs.damos.mscript.function.VariableDescription#getFunctionDescription()
	 * @see #getVariableDescription()
	 * @generated
	 */
	EReference getVariableDescription_FunctionDescription();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.mscript.function.VariableDescription#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.damos.mscript.function.VariableDescription#getName()
	 * @see #getVariableDescription()
	 * @generated
	 */
	EAttribute getVariableDescription_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.mscript.function.VariableDescription#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipselabs.damos.mscript.function.VariableDescription#getKind()
	 * @see #getVariableDescription()
	 * @generated
	 */
	EAttribute getVariableDescription_Kind();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.mscript.function.VariableDescription#getSteps <em>Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Steps</em>'.
	 * @see org.eclipselabs.damos.mscript.function.VariableDescription#getSteps()
	 * @see #getVariableDescription()
	 * @generated
	 */
	EReference getVariableDescription_Steps();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.function.VariableStep <em>Variable Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Step</em>'.
	 * @see org.eclipselabs.damos.mscript.function.VariableStep
	 * @generated
	 */
	EClass getVariableStep();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.mscript.function.VariableStep#getVariableDescription <em>Variable Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Variable Description</em>'.
	 * @see org.eclipselabs.damos.mscript.function.VariableStep#getVariableDescription()
	 * @see #getVariableStep()
	 * @generated
	 */
	EReference getVariableStep_VariableDescription();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.mscript.function.VariableStep#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipselabs.damos.mscript.function.VariableStep#getIndex()
	 * @see #getVariableStep()
	 * @generated
	 */
	EAttribute getVariableStep_Index();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.mscript.function.VariableStep#isInitial <em>Initial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial</em>'.
	 * @see org.eclipselabs.damos.mscript.function.VariableStep#isInitial()
	 * @see #getVariableStep()
	 * @generated
	 */
	EAttribute getVariableStep_Initial();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.mscript.function.VariableStep#isDerivative <em>Derivative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Derivative</em>'.
	 * @see org.eclipselabs.damos.mscript.function.VariableStep#isDerivative()
	 * @see #getVariableStep()
	 * @generated
	 */
	EAttribute getVariableStep_Derivative();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.mscript.function.VariableStep#getUsingEquationParts <em>Using Equation Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Using Equation Parts</em>'.
	 * @see org.eclipselabs.damos.mscript.function.VariableStep#getUsingEquationParts()
	 * @see #getVariableStep()
	 * @generated
	 */
	EReference getVariableStep_UsingEquationParts();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.function.FunctionInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance</em>'.
	 * @see org.eclipselabs.damos.mscript.function.FunctionInstance
	 * @generated
	 */
	EClass getFunctionInstance();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.mscript.function.FunctionInstance#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Declaration</em>'.
	 * @see org.eclipselabs.damos.mscript.function.FunctionInstance#getDeclaration()
	 * @see #getFunctionInstance()
	 * @generated
	 */
	EReference getFunctionInstance_Declaration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.mscript.function.FunctionInstance#getInitializationCompound <em>Initialization Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initialization Compound</em>'.
	 * @see org.eclipselabs.damos.mscript.function.FunctionInstance#getInitializationCompound()
	 * @see #getFunctionInstance()
	 * @generated
	 */
	EReference getFunctionInstance_InitializationCompound();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.mscript.function.FunctionInstance#getComputationCompounds <em>Computation Compounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Computation Compounds</em>'.
	 * @see org.eclipselabs.damos.mscript.function.FunctionInstance#getComputationCompounds()
	 * @see #getFunctionInstance()
	 * @generated
	 */
	EReference getFunctionInstance_ComputationCompounds();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.function.ComputationCompound <em>Computation Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computation Compound</em>'.
	 * @see org.eclipselabs.damos.mscript.function.ComputationCompound
	 * @generated
	 */
	EClass getComputationCompound();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.mscript.function.ComputationCompound#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inputs</em>'.
	 * @see org.eclipselabs.damos.mscript.function.ComputationCompound#getInputs()
	 * @see #getComputationCompound()
	 * @generated
	 */
	EReference getComputationCompound_Inputs();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.mscript.function.ComputationCompound#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outputs</em>'.
	 * @see org.eclipselabs.damos.mscript.function.ComputationCompound#getOutputs()
	 * @see #getComputationCompound()
	 * @generated
	 */
	EReference getComputationCompound_Outputs();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.mscript.function.ComputationCompound#getDerivatives <em>Derivatives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Derivatives</em>'.
	 * @see org.eclipselabs.damos.mscript.function.ComputationCompound#getDerivatives()
	 * @see #getComputationCompound()
	 * @generated
	 */
	EReference getComputationCompound_Derivatives();

	/**
	 * Returns the meta object for enum '{@link org.eclipselabs.damos.mscript.function.VariableKind <em>Variable Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variable Kind</em>'.
	 * @see org.eclipselabs.damos.mscript.function.VariableKind
	 * @generated
	 */
	EEnum getVariableKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FunctionFactory getFunctionFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.function.impl.FunctionDescriptionImpl <em>Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.function.impl.FunctionDescriptionImpl
		 * @see org.eclipselabs.damos.mscript.function.impl.FunctionPackageImpl#getFunctionDescription()
		 * @generated
		 */
		EClass FUNCTION_DESCRIPTION = eINSTANCE.getFunctionDescription();

		/**
		 * The meta object literal for the '<em><b>Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_DESCRIPTION__DECLARATION = eINSTANCE.getFunctionDescription_Declaration();

		/**
		 * The meta object literal for the '<em><b>Equation Descriptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_DESCRIPTION__EQUATION_DESCRIPTIONS = eINSTANCE.getFunctionDescription_EquationDescriptions();

		/**
		 * The meta object literal for the '<em><b>Variable Descriptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_DESCRIPTION__VARIABLE_DESCRIPTIONS = eINSTANCE.getFunctionDescription_VariableDescriptions();

		/**
		 * The meta object literal for the '<em><b>Stateful</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION_DESCRIPTION__STATEFUL = eINSTANCE.getFunctionDescription_Stateful();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.function.impl.EquationDescriptionImpl <em>Equation Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.function.impl.EquationDescriptionImpl
		 * @see org.eclipselabs.damos.mscript.function.impl.FunctionPackageImpl#getEquationDescription()
		 * @generated
		 */
		EClass EQUATION_DESCRIPTION = eINSTANCE.getEquationDescription();

		/**
		 * The meta object literal for the '<em><b>Function Description</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_DESCRIPTION__FUNCTION_DESCRIPTION = eINSTANCE.getEquationDescription_FunctionDescription();

		/**
		 * The meta object literal for the '<em><b>Equation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_DESCRIPTION__EQUATION = eINSTANCE.getEquationDescription_Equation();

		/**
		 * The meta object literal for the '<em><b>Sides</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_DESCRIPTION__SIDES = eINSTANCE.getEquationDescription_Sides();

		/**
		 * The meta object literal for the '<em><b>Left Hand Side</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_DESCRIPTION__LEFT_HAND_SIDE = eINSTANCE.getEquationDescription_LeftHandSide();

		/**
		 * The meta object literal for the '<em><b>Right Hand Side</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_DESCRIPTION__RIGHT_HAND_SIDE = eINSTANCE.getEquationDescription_RightHandSide();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.function.impl.EquationSideImpl <em>Equation Side</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.function.impl.EquationSideImpl
		 * @see org.eclipselabs.damos.mscript.function.impl.FunctionPackageImpl#getEquationSide()
		 * @generated
		 */
		EClass EQUATION_SIDE = eINSTANCE.getEquationSide();

		/**
		 * The meta object literal for the '<em><b>Equation Description</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_SIDE__EQUATION_DESCRIPTION = eINSTANCE.getEquationSide_EquationDescription();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_SIDE__EXPRESSION = eINSTANCE.getEquationSide_Expression();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_SIDE__PARTS = eINSTANCE.getEquationSide_Parts();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.function.impl.EquationPartImpl <em>Equation Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.function.impl.EquationPartImpl
		 * @see org.eclipselabs.damos.mscript.function.impl.FunctionPackageImpl#getEquationPart()
		 * @generated
		 */
		EClass EQUATION_PART = eINSTANCE.getEquationPart();

		/**
		 * The meta object literal for the '<em><b>Side</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_PART__SIDE = eINSTANCE.getEquationPart_Side();

		/**
		 * The meta object literal for the '<em><b>Variable Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_PART__VARIABLE_REFERENCE = eINSTANCE.getEquationPart_VariableReference();

		/**
		 * The meta object literal for the '<em><b>Variable Step</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_PART__VARIABLE_STEP = eINSTANCE.getEquationPart_VariableStep();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.function.impl.VariableDescriptionImpl <em>Variable Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.function.impl.VariableDescriptionImpl
		 * @see org.eclipselabs.damos.mscript.function.impl.FunctionPackageImpl#getVariableDescription()
		 * @generated
		 */
		EClass VARIABLE_DESCRIPTION = eINSTANCE.getVariableDescription();

		/**
		 * The meta object literal for the '<em><b>Function Description</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DESCRIPTION__FUNCTION_DESCRIPTION = eINSTANCE.getVariableDescription_FunctionDescription();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_DESCRIPTION__NAME = eINSTANCE.getVariableDescription_Name();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_DESCRIPTION__KIND = eINSTANCE.getVariableDescription_Kind();

		/**
		 * The meta object literal for the '<em><b>Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DESCRIPTION__STEPS = eINSTANCE.getVariableDescription_Steps();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.function.impl.VariableStepImpl <em>Variable Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.function.impl.VariableStepImpl
		 * @see org.eclipselabs.damos.mscript.function.impl.FunctionPackageImpl#getVariableStep()
		 * @generated
		 */
		EClass VARIABLE_STEP = eINSTANCE.getVariableStep();

		/**
		 * The meta object literal for the '<em><b>Variable Description</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_STEP__VARIABLE_DESCRIPTION = eINSTANCE.getVariableStep_VariableDescription();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_STEP__INDEX = eINSTANCE.getVariableStep_Index();

		/**
		 * The meta object literal for the '<em><b>Initial</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_STEP__INITIAL = eINSTANCE.getVariableStep_Initial();

		/**
		 * The meta object literal for the '<em><b>Derivative</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_STEP__DERIVATIVE = eINSTANCE.getVariableStep_Derivative();

		/**
		 * The meta object literal for the '<em><b>Using Equation Parts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_STEP__USING_EQUATION_PARTS = eINSTANCE.getVariableStep_UsingEquationParts();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.function.impl.FunctionInstanceImpl <em>Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.function.impl.FunctionInstanceImpl
		 * @see org.eclipselabs.damos.mscript.function.impl.FunctionPackageImpl#getFunctionInstance()
		 * @generated
		 */
		EClass FUNCTION_INSTANCE = eINSTANCE.getFunctionInstance();

		/**
		 * The meta object literal for the '<em><b>Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_INSTANCE__DECLARATION = eINSTANCE.getFunctionInstance_Declaration();

		/**
		 * The meta object literal for the '<em><b>Initialization Compound</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_INSTANCE__INITIALIZATION_COMPOUND = eINSTANCE.getFunctionInstance_InitializationCompound();

		/**
		 * The meta object literal for the '<em><b>Computation Compounds</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_INSTANCE__COMPUTATION_COMPOUNDS = eINSTANCE.getFunctionInstance_ComputationCompounds();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.function.impl.ComputationCompoundImpl <em>Computation Compound</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.function.impl.ComputationCompoundImpl
		 * @see org.eclipselabs.damos.mscript.function.impl.FunctionPackageImpl#getComputationCompound()
		 * @generated
		 */
		EClass COMPUTATION_COMPOUND = eINSTANCE.getComputationCompound();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTATION_COMPOUND__INPUTS = eINSTANCE.getComputationCompound_Inputs();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTATION_COMPOUND__OUTPUTS = eINSTANCE.getComputationCompound_Outputs();

		/**
		 * The meta object literal for the '<em><b>Derivatives</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTATION_COMPOUND__DERIVATIVES = eINSTANCE.getComputationCompound_Derivatives();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.function.VariableKind <em>Variable Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.function.VariableKind
		 * @see org.eclipselabs.damos.mscript.function.impl.FunctionPackageImpl#getVariableKind()
		 * @generated
		 */
		EEnum VARIABLE_KIND = eINSTANCE.getVariableKind();

	}

} //FunctionModelPackage
