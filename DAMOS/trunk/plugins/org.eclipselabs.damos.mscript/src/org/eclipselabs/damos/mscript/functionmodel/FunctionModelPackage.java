/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.functionmodel;

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
 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelFactory
 * @model kind="package"
 * @generated
 */
public interface FunctionModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "functionmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/damos/mscript/2011/FunctionModel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "functionmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FunctionModelPackage eINSTANCE = org.eclipselabs.damos.mscript.functionmodel.impl.FunctionModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.functionmodel.impl.FunctionDescriptorImpl <em>Function Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.functionmodel.impl.FunctionDescriptorImpl
	 * @see org.eclipselabs.damos.mscript.functionmodel.impl.FunctionModelPackageImpl#getFunctionDescriptor()
	 * @generated
	 */
	int FUNCTION_DESCRIPTOR = 0;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DESCRIPTOR__DECLARATION = 0;

	/**
	 * The feature id for the '<em><b>Equation Descriptors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DESCRIPTOR__EQUATION_DESCRIPTORS = 1;

	/**
	 * The feature id for the '<em><b>Variable Descriptors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DESCRIPTOR__VARIABLE_DESCRIPTORS = 2;

	/**
	 * The number of structural features of the '<em>Function Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DESCRIPTOR_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.functionmodel.impl.EquationDescriptorImpl <em>Equation Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.functionmodel.impl.EquationDescriptorImpl
	 * @see org.eclipselabs.damos.mscript.functionmodel.impl.FunctionModelPackageImpl#getEquationDescriptor()
	 * @generated
	 */
	int EQUATION_DESCRIPTOR = 1;

	/**
	 * The feature id for the '<em><b>Function Descriptor</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_DESCRIPTOR__FUNCTION_DESCRIPTOR = 0;

	/**
	 * The feature id for the '<em><b>Equation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_DESCRIPTOR__EQUATION = 1;

	/**
	 * The feature id for the '<em><b>Sides</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_DESCRIPTOR__SIDES = 2;

	/**
	 * The feature id for the '<em><b>Left Hand Side</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_DESCRIPTOR__LEFT_HAND_SIDE = 3;

	/**
	 * The feature id for the '<em><b>Right Hand Side</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_DESCRIPTOR__RIGHT_HAND_SIDE = 4;

	/**
	 * The number of structural features of the '<em>Equation Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_DESCRIPTOR_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.functionmodel.impl.EquationSideImpl <em>Equation Side</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.functionmodel.impl.EquationSideImpl
	 * @see org.eclipselabs.damos.mscript.functionmodel.impl.FunctionModelPackageImpl#getEquationSide()
	 * @generated
	 */
	int EQUATION_SIDE = 2;

	/**
	 * The feature id for the '<em><b>Descriptor</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_SIDE__DESCRIPTOR = 0;

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
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.functionmodel.impl.EquationPartImpl <em>Equation Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.functionmodel.impl.EquationPartImpl
	 * @see org.eclipselabs.damos.mscript.functionmodel.impl.FunctionModelPackageImpl#getEquationPart()
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
	 * The feature id for the '<em><b>Variable Access</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_PART__VARIABLE_ACCESS = 1;

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
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.functionmodel.impl.VariableDescriptorImpl <em>Variable Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.functionmodel.impl.VariableDescriptorImpl
	 * @see org.eclipselabs.damos.mscript.functionmodel.impl.FunctionModelPackageImpl#getVariableDescriptor()
	 * @generated
	 */
	int VARIABLE_DESCRIPTOR = 4;

	/**
	 * The feature id for the '<em><b>Function Descriptor</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DESCRIPTOR__FUNCTION_DESCRIPTOR = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DESCRIPTOR__NAME = 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DESCRIPTOR__KIND = 2;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DESCRIPTOR__STEPS = 3;

	/**
	 * The number of structural features of the '<em>Variable Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DESCRIPTOR_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.functionmodel.impl.VariableStepImpl <em>Variable Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.functionmodel.impl.VariableStepImpl
	 * @see org.eclipselabs.damos.mscript.functionmodel.impl.FunctionModelPackageImpl#getVariableStep()
	 * @generated
	 */
	int VARIABLE_STEP = 5;

	/**
	 * The feature id for the '<em><b>Descriptor</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STEP__DESCRIPTOR = 0;

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
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.functionmodel.impl.FunctionInstanceImpl <em>Function Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.functionmodel.impl.FunctionInstanceImpl
	 * @see org.eclipselabs.damos.mscript.functionmodel.impl.FunctionModelPackageImpl#getFunctionInstance()
	 * @generated
	 */
	int FUNCTION_INSTANCE = 6;

	/**
	 * The feature id for the '<em><b>Function Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_INSTANCE__FUNCTION_DECLARATION = 0;

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
	 * The number of structural features of the '<em>Function Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_INSTANCE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.functionmodel.impl.ComputationCompoundImpl <em>Computation Compound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.functionmodel.impl.ComputationCompoundImpl
	 * @see org.eclipselabs.damos.mscript.functionmodel.impl.FunctionModelPackageImpl#getComputationCompound()
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
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.functionmodel.VariableKind <em>Variable Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.functionmodel.VariableKind
	 * @see org.eclipselabs.damos.mscript.functionmodel.impl.FunctionModelPackageImpl#getVariableKind()
	 * @generated
	 */
	int VARIABLE_KIND = 8;


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.functionmodel.FunctionDescriptor <em>Function Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Descriptor</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionDescriptor
	 * @generated
	 */
	EClass getFunctionDescriptor();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.mscript.functionmodel.FunctionDescriptor#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Declaration</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionDescriptor#getDeclaration()
	 * @see #getFunctionDescriptor()
	 * @generated
	 */
	EReference getFunctionDescriptor_Declaration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.mscript.functionmodel.FunctionDescriptor#getEquationDescriptors <em>Equation Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Equation Descriptors</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionDescriptor#getEquationDescriptors()
	 * @see #getFunctionDescriptor()
	 * @generated
	 */
	EReference getFunctionDescriptor_EquationDescriptors();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.mscript.functionmodel.FunctionDescriptor#getVariableDescriptors <em>Variable Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable Descriptors</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionDescriptor#getVariableDescriptors()
	 * @see #getFunctionDescriptor()
	 * @generated
	 */
	EReference getFunctionDescriptor_VariableDescriptors();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor <em>Equation Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equation Descriptor</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor
	 * @generated
	 */
	EClass getEquationDescriptor();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor#getFunctionDescriptor <em>Function Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Function Descriptor</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor#getFunctionDescriptor()
	 * @see #getEquationDescriptor()
	 * @generated
	 */
	EReference getEquationDescriptor_FunctionDescriptor();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor#getEquation <em>Equation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Equation</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor#getEquation()
	 * @see #getEquationDescriptor()
	 * @generated
	 */
	EReference getEquationDescriptor_Equation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor#getSides <em>Sides</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sides</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor#getSides()
	 * @see #getEquationDescriptor()
	 * @generated
	 */
	EReference getEquationDescriptor_Sides();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor#getLeftHandSide <em>Left Hand Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left Hand Side</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor#getLeftHandSide()
	 * @see #getEquationDescriptor()
	 * @generated
	 */
	EReference getEquationDescriptor_LeftHandSide();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor#getRightHandSide <em>Right Hand Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right Hand Side</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor#getRightHandSide()
	 * @see #getEquationDescriptor()
	 * @generated
	 */
	EReference getEquationDescriptor_RightHandSide();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.functionmodel.EquationSide <em>Equation Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equation Side</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.EquationSide
	 * @generated
	 */
	EClass getEquationSide();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.mscript.functionmodel.EquationSide#getDescriptor <em>Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Descriptor</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.EquationSide#getDescriptor()
	 * @see #getEquationSide()
	 * @generated
	 */
	EReference getEquationSide_Descriptor();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.mscript.functionmodel.EquationSide#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expression</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.EquationSide#getExpression()
	 * @see #getEquationSide()
	 * @generated
	 */
	EReference getEquationSide_Expression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.mscript.functionmodel.EquationSide#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.EquationSide#getParts()
	 * @see #getEquationSide()
	 * @generated
	 */
	EReference getEquationSide_Parts();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.functionmodel.EquationPart <em>Equation Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equation Part</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.EquationPart
	 * @generated
	 */
	EClass getEquationPart();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.mscript.functionmodel.EquationPart#getSide <em>Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Side</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.EquationPart#getSide()
	 * @see #getEquationPart()
	 * @generated
	 */
	EReference getEquationPart_Side();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.mscript.functionmodel.EquationPart#getVariableAccess <em>Variable Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable Access</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.EquationPart#getVariableAccess()
	 * @see #getEquationPart()
	 * @generated
	 */
	EReference getEquationPart_VariableAccess();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.mscript.functionmodel.EquationPart#getVariableStep <em>Variable Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable Step</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.EquationPart#getVariableStep()
	 * @see #getEquationPart()
	 * @generated
	 */
	EReference getEquationPart_VariableStep();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.functionmodel.VariableDescriptor <em>Variable Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Descriptor</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.VariableDescriptor
	 * @generated
	 */
	EClass getVariableDescriptor();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.mscript.functionmodel.VariableDescriptor#getFunctionDescriptor <em>Function Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Function Descriptor</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.VariableDescriptor#getFunctionDescriptor()
	 * @see #getVariableDescriptor()
	 * @generated
	 */
	EReference getVariableDescriptor_FunctionDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.mscript.functionmodel.VariableDescriptor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.VariableDescriptor#getName()
	 * @see #getVariableDescriptor()
	 * @generated
	 */
	EAttribute getVariableDescriptor_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.mscript.functionmodel.VariableDescriptor#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.VariableDescriptor#getKind()
	 * @see #getVariableDescriptor()
	 * @generated
	 */
	EAttribute getVariableDescriptor_Kind();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.mscript.functionmodel.VariableDescriptor#getSteps <em>Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Steps</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.VariableDescriptor#getSteps()
	 * @see #getVariableDescriptor()
	 * @generated
	 */
	EReference getVariableDescriptor_Steps();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.functionmodel.VariableStep <em>Variable Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Step</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.VariableStep
	 * @generated
	 */
	EClass getVariableStep();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.mscript.functionmodel.VariableStep#getDescriptor <em>Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Descriptor</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.VariableStep#getDescriptor()
	 * @see #getVariableStep()
	 * @generated
	 */
	EReference getVariableStep_Descriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.mscript.functionmodel.VariableStep#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.VariableStep#getIndex()
	 * @see #getVariableStep()
	 * @generated
	 */
	EAttribute getVariableStep_Index();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.mscript.functionmodel.VariableStep#isInitial <em>Initial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.VariableStep#isInitial()
	 * @see #getVariableStep()
	 * @generated
	 */
	EAttribute getVariableStep_Initial();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.mscript.functionmodel.VariableStep#isDerivative <em>Derivative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Derivative</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.VariableStep#isDerivative()
	 * @see #getVariableStep()
	 * @generated
	 */
	EAttribute getVariableStep_Derivative();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.mscript.functionmodel.VariableStep#getUsingEquationParts <em>Using Equation Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Using Equation Parts</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.VariableStep#getUsingEquationParts()
	 * @see #getVariableStep()
	 * @generated
	 */
	EReference getVariableStep_UsingEquationParts();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.functionmodel.FunctionInstance <em>Function Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Instance</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionInstance
	 * @generated
	 */
	EClass getFunctionInstance();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.mscript.functionmodel.FunctionInstance#getFunctionDeclaration <em>Function Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function Declaration</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionInstance#getFunctionDeclaration()
	 * @see #getFunctionInstance()
	 * @generated
	 */
	EReference getFunctionInstance_FunctionDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.mscript.functionmodel.FunctionInstance#getInitializationCompound <em>Initialization Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initialization Compound</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionInstance#getInitializationCompound()
	 * @see #getFunctionInstance()
	 * @generated
	 */
	EReference getFunctionInstance_InitializationCompound();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.mscript.functionmodel.FunctionInstance#getComputationCompounds <em>Computation Compounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Computation Compounds</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionInstance#getComputationCompounds()
	 * @see #getFunctionInstance()
	 * @generated
	 */
	EReference getFunctionInstance_ComputationCompounds();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.functionmodel.ComputationCompound <em>Computation Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computation Compound</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.ComputationCompound
	 * @generated
	 */
	EClass getComputationCompound();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.mscript.functionmodel.ComputationCompound#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inputs</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.ComputationCompound#getInputs()
	 * @see #getComputationCompound()
	 * @generated
	 */
	EReference getComputationCompound_Inputs();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.mscript.functionmodel.ComputationCompound#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outputs</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.ComputationCompound#getOutputs()
	 * @see #getComputationCompound()
	 * @generated
	 */
	EReference getComputationCompound_Outputs();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.mscript.functionmodel.ComputationCompound#getDerivatives <em>Derivatives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Derivatives</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.ComputationCompound#getDerivatives()
	 * @see #getComputationCompound()
	 * @generated
	 */
	EReference getComputationCompound_Derivatives();

	/**
	 * Returns the meta object for enum '{@link org.eclipselabs.damos.mscript.functionmodel.VariableKind <em>Variable Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variable Kind</em>'.
	 * @see org.eclipselabs.damos.mscript.functionmodel.VariableKind
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
	FunctionModelFactory getFunctionModelFactory();

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
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.functionmodel.impl.FunctionDescriptorImpl <em>Function Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.functionmodel.impl.FunctionDescriptorImpl
		 * @see org.eclipselabs.damos.mscript.functionmodel.impl.FunctionModelPackageImpl#getFunctionDescriptor()
		 * @generated
		 */
		EClass FUNCTION_DESCRIPTOR = eINSTANCE.getFunctionDescriptor();

		/**
		 * The meta object literal for the '<em><b>Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_DESCRIPTOR__DECLARATION = eINSTANCE.getFunctionDescriptor_Declaration();

		/**
		 * The meta object literal for the '<em><b>Equation Descriptors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_DESCRIPTOR__EQUATION_DESCRIPTORS = eINSTANCE.getFunctionDescriptor_EquationDescriptors();

		/**
		 * The meta object literal for the '<em><b>Variable Descriptors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_DESCRIPTOR__VARIABLE_DESCRIPTORS = eINSTANCE.getFunctionDescriptor_VariableDescriptors();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.functionmodel.impl.EquationDescriptorImpl <em>Equation Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.functionmodel.impl.EquationDescriptorImpl
		 * @see org.eclipselabs.damos.mscript.functionmodel.impl.FunctionModelPackageImpl#getEquationDescriptor()
		 * @generated
		 */
		EClass EQUATION_DESCRIPTOR = eINSTANCE.getEquationDescriptor();

		/**
		 * The meta object literal for the '<em><b>Function Descriptor</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_DESCRIPTOR__FUNCTION_DESCRIPTOR = eINSTANCE.getEquationDescriptor_FunctionDescriptor();

		/**
		 * The meta object literal for the '<em><b>Equation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_DESCRIPTOR__EQUATION = eINSTANCE.getEquationDescriptor_Equation();

		/**
		 * The meta object literal for the '<em><b>Sides</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_DESCRIPTOR__SIDES = eINSTANCE.getEquationDescriptor_Sides();

		/**
		 * The meta object literal for the '<em><b>Left Hand Side</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_DESCRIPTOR__LEFT_HAND_SIDE = eINSTANCE.getEquationDescriptor_LeftHandSide();

		/**
		 * The meta object literal for the '<em><b>Right Hand Side</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_DESCRIPTOR__RIGHT_HAND_SIDE = eINSTANCE.getEquationDescriptor_RightHandSide();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.functionmodel.impl.EquationSideImpl <em>Equation Side</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.functionmodel.impl.EquationSideImpl
		 * @see org.eclipselabs.damos.mscript.functionmodel.impl.FunctionModelPackageImpl#getEquationSide()
		 * @generated
		 */
		EClass EQUATION_SIDE = eINSTANCE.getEquationSide();

		/**
		 * The meta object literal for the '<em><b>Descriptor</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_SIDE__DESCRIPTOR = eINSTANCE.getEquationSide_Descriptor();

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
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.functionmodel.impl.EquationPartImpl <em>Equation Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.functionmodel.impl.EquationPartImpl
		 * @see org.eclipselabs.damos.mscript.functionmodel.impl.FunctionModelPackageImpl#getEquationPart()
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
		 * The meta object literal for the '<em><b>Variable Access</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_PART__VARIABLE_ACCESS = eINSTANCE.getEquationPart_VariableAccess();

		/**
		 * The meta object literal for the '<em><b>Variable Step</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_PART__VARIABLE_STEP = eINSTANCE.getEquationPart_VariableStep();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.functionmodel.impl.VariableDescriptorImpl <em>Variable Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.functionmodel.impl.VariableDescriptorImpl
		 * @see org.eclipselabs.damos.mscript.functionmodel.impl.FunctionModelPackageImpl#getVariableDescriptor()
		 * @generated
		 */
		EClass VARIABLE_DESCRIPTOR = eINSTANCE.getVariableDescriptor();

		/**
		 * The meta object literal for the '<em><b>Function Descriptor</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DESCRIPTOR__FUNCTION_DESCRIPTOR = eINSTANCE.getVariableDescriptor_FunctionDescriptor();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_DESCRIPTOR__NAME = eINSTANCE.getVariableDescriptor_Name();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_DESCRIPTOR__KIND = eINSTANCE.getVariableDescriptor_Kind();

		/**
		 * The meta object literal for the '<em><b>Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DESCRIPTOR__STEPS = eINSTANCE.getVariableDescriptor_Steps();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.functionmodel.impl.VariableStepImpl <em>Variable Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.functionmodel.impl.VariableStepImpl
		 * @see org.eclipselabs.damos.mscript.functionmodel.impl.FunctionModelPackageImpl#getVariableStep()
		 * @generated
		 */
		EClass VARIABLE_STEP = eINSTANCE.getVariableStep();

		/**
		 * The meta object literal for the '<em><b>Descriptor</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_STEP__DESCRIPTOR = eINSTANCE.getVariableStep_Descriptor();

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
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.functionmodel.impl.FunctionInstanceImpl <em>Function Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.functionmodel.impl.FunctionInstanceImpl
		 * @see org.eclipselabs.damos.mscript.functionmodel.impl.FunctionModelPackageImpl#getFunctionInstance()
		 * @generated
		 */
		EClass FUNCTION_INSTANCE = eINSTANCE.getFunctionInstance();

		/**
		 * The meta object literal for the '<em><b>Function Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_INSTANCE__FUNCTION_DECLARATION = eINSTANCE.getFunctionInstance_FunctionDeclaration();

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
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.functionmodel.impl.ComputationCompoundImpl <em>Computation Compound</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.functionmodel.impl.ComputationCompoundImpl
		 * @see org.eclipselabs.damos.mscript.functionmodel.impl.FunctionModelPackageImpl#getComputationCompound()
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
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.functionmodel.VariableKind <em>Variable Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.functionmodel.VariableKind
		 * @see org.eclipselabs.damos.mscript.functionmodel.impl.FunctionModelPackageImpl#getVariableKind()
		 * @generated
		 */
		EEnum VARIABLE_KIND = eINSTANCE.getVariableKind();

	}

} //FunctionModelPackage
