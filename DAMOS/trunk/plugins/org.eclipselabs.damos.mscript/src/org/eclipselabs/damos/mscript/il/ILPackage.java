/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.il;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.eclipselabs.damos.mscript.il.ILFactory
 * @model kind="package"
 * @generated
 */
public interface ILPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "il";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/damos/mscript/2011/IL";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "il";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ILPackage eINSTANCE = org.eclipselabs.damos.mscript.il.impl.ILPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.il.impl.ILFunctionDefinitionImpl <em>Function Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.il.impl.ILFunctionDefinitionImpl
	 * @see org.eclipselabs.damos.mscript.il.impl.ILPackageImpl#getILFunctionDefinition()
	 * @generated
	 */
	int IL_FUNCTION_DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Function Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_FUNCTION_DEFINITION__FUNCTION_DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Stateful</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_FUNCTION_DEFINITION__STATEFUL = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_FUNCTION_DEFINITION__NAME = 2;

	/**
	 * The feature id for the '<em><b>Template Variable Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_FUNCTION_DEFINITION__TEMPLATE_VARIABLE_DECLARATIONS = 3;

	/**
	 * The feature id for the '<em><b>Input Variable Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_FUNCTION_DEFINITION__INPUT_VARIABLE_DECLARATIONS = 4;

	/**
	 * The feature id for the '<em><b>Output Variable Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_FUNCTION_DEFINITION__OUTPUT_VARIABLE_DECLARATIONS = 5;

	/**
	 * The feature id for the '<em><b>Instance Variable Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_FUNCTION_DEFINITION__INSTANCE_VARIABLE_DECLARATIONS = 6;

	/**
	 * The feature id for the '<em><b>Initialization Compound</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_FUNCTION_DEFINITION__INITIALIZATION_COMPOUND = 7;

	/**
	 * The feature id for the '<em><b>Computation Compounds</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_FUNCTION_DEFINITION__COMPUTATION_COMPOUNDS = 8;

	/**
	 * The number of structural features of the '<em>Function Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_FUNCTION_DEFINITION_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.il.impl.ComputationCompoundImpl <em>Computation Compound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.il.impl.ComputationCompoundImpl
	 * @see org.eclipselabs.damos.mscript.il.impl.ILPackageImpl#getComputationCompound()
	 * @generated
	 */
	int COMPUTATION_COMPOUND = 1;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_COMPOUND__STATEMENTS = MscriptPackage.COMPOUND__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_COMPOUND__INPUTS = MscriptPackage.COMPOUND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_COMPOUND__OUTPUTS = MscriptPackage.COMPOUND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Computation Compound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_COMPOUND_FEATURE_COUNT = MscriptPackage.COMPOUND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.il.impl.VariableDeclarationInfoImpl <em>Variable Declaration Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.il.impl.VariableDeclarationInfoImpl
	 * @see org.eclipselabs.damos.mscript.il.impl.ILPackageImpl#getVariableDeclarationInfo()
	 * @generated
	 */
	int VARIABLE_DECLARATION_INFO = 2;

	/**
	 * The feature id for the '<em><b>Variable Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_INFO__VARIABLE_DECLARATION = 0;

	/**
	 * The number of structural features of the '<em>Variable Declaration Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_INFO_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.il.impl.StatefulVariableDeclarationImpl <em>Stateful Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.il.impl.StatefulVariableDeclarationImpl
	 * @see org.eclipselabs.damos.mscript.il.impl.ILPackageImpl#getStatefulVariableDeclaration()
	 * @generated
	 */
	int STATEFUL_VARIABLE_DECLARATION = 3;

	/**
	 * The feature id for the '<em><b>Variable Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_VARIABLE_DECLARATION__VARIABLE_DECLARATION = VARIABLE_DECLARATION_INFO__VARIABLE_DECLARATION;

	/**
	 * The feature id for the '<em><b>Circular Buffer Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_SIZE = VARIABLE_DECLARATION_INFO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Stateful Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_VARIABLE_DECLARATION_FEATURE_COUNT = VARIABLE_DECLARATION_INFO_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.il.impl.TemplateVariableDeclarationImpl <em>Template Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.il.impl.TemplateVariableDeclarationImpl
	 * @see org.eclipselabs.damos.mscript.il.impl.ILPackageImpl#getTemplateVariableDeclaration()
	 * @generated
	 */
	int TEMPLATE_VARIABLE_DECLARATION = 4;

	/**
	 * The feature id for the '<em><b>Variable Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_DECLARATION__VARIABLE_DECLARATION = VARIABLE_DECLARATION_INFO__VARIABLE_DECLARATION;

	/**
	 * The number of structural features of the '<em>Template Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_DECLARATION_FEATURE_COUNT = VARIABLE_DECLARATION_INFO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.il.impl.InputVariableDeclarationImpl <em>Input Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.il.impl.InputVariableDeclarationImpl
	 * @see org.eclipselabs.damos.mscript.il.impl.ILPackageImpl#getInputVariableDeclaration()
	 * @generated
	 */
	int INPUT_VARIABLE_DECLARATION = 5;

	/**
	 * The feature id for the '<em><b>Variable Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_DECLARATION__VARIABLE_DECLARATION = STATEFUL_VARIABLE_DECLARATION__VARIABLE_DECLARATION;

	/**
	 * The feature id for the '<em><b>Circular Buffer Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_DECLARATION__CIRCULAR_BUFFER_SIZE = STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_SIZE;

	/**
	 * The number of structural features of the '<em>Input Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_DECLARATION_FEATURE_COUNT = STATEFUL_VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.il.impl.OutputVariableDeclarationImpl <em>Output Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.il.impl.OutputVariableDeclarationImpl
	 * @see org.eclipselabs.damos.mscript.il.impl.ILPackageImpl#getOutputVariableDeclaration()
	 * @generated
	 */
	int OUTPUT_VARIABLE_DECLARATION = 6;

	/**
	 * The feature id for the '<em><b>Variable Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VARIABLE_DECLARATION__VARIABLE_DECLARATION = STATEFUL_VARIABLE_DECLARATION__VARIABLE_DECLARATION;

	/**
	 * The feature id for the '<em><b>Circular Buffer Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VARIABLE_DECLARATION__CIRCULAR_BUFFER_SIZE = STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_SIZE;

	/**
	 * The number of structural features of the '<em>Output Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VARIABLE_DECLARATION_FEATURE_COUNT = STATEFUL_VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.il.impl.InstanceVariableDeclarationImpl <em>Instance Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.il.impl.InstanceVariableDeclarationImpl
	 * @see org.eclipselabs.damos.mscript.il.impl.ILPackageImpl#getInstanceVariableDeclaration()
	 * @generated
	 */
	int INSTANCE_VARIABLE_DECLARATION = 7;

	/**
	 * The feature id for the '<em><b>Variable Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_VARIABLE_DECLARATION__VARIABLE_DECLARATION = STATEFUL_VARIABLE_DECLARATION__VARIABLE_DECLARATION;

	/**
	 * The feature id for the '<em><b>Circular Buffer Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_VARIABLE_DECLARATION__CIRCULAR_BUFFER_SIZE = STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_SIZE;

	/**
	 * The number of structural features of the '<em>Instance Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_VARIABLE_DECLARATION_FEATURE_COUNT = STATEFUL_VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.il.impl.InvalidExpressionImpl <em>Invalid Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.il.impl.InvalidExpressionImpl
	 * @see org.eclipselabs.damos.mscript.il.impl.ILPackageImpl#getInvalidExpression()
	 * @generated
	 */
	int INVALID_EXPRESSION = 8;

	/**
	 * The number of structural features of the '<em>Invalid Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_EXPRESSION_FEATURE_COUNT = MscriptPackage.EXPRESSION_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.il.ILFunctionDefinition <em>Function Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Definition</em>'.
	 * @see org.eclipselabs.damos.mscript.il.ILFunctionDefinition
	 * @generated
	 */
	EClass getILFunctionDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.mscript.il.ILFunctionDefinition#getFunctionDefinition <em>Function Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function Definition</em>'.
	 * @see org.eclipselabs.damos.mscript.il.ILFunctionDefinition#getFunctionDefinition()
	 * @see #getILFunctionDefinition()
	 * @generated
	 */
	EReference getILFunctionDefinition_FunctionDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.mscript.il.ILFunctionDefinition#isStateful <em>Stateful</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stateful</em>'.
	 * @see org.eclipselabs.damos.mscript.il.ILFunctionDefinition#isStateful()
	 * @see #getILFunctionDefinition()
	 * @generated
	 */
	EAttribute getILFunctionDefinition_Stateful();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.mscript.il.ILFunctionDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.damos.mscript.il.ILFunctionDefinition#getName()
	 * @see #getILFunctionDefinition()
	 * @generated
	 */
	EAttribute getILFunctionDefinition_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.mscript.il.ILFunctionDefinition#getTemplateVariableDeclarations <em>Template Variable Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Template Variable Declarations</em>'.
	 * @see org.eclipselabs.damos.mscript.il.ILFunctionDefinition#getTemplateVariableDeclarations()
	 * @see #getILFunctionDefinition()
	 * @generated
	 */
	EReference getILFunctionDefinition_TemplateVariableDeclarations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.mscript.il.ILFunctionDefinition#getInputVariableDeclarations <em>Input Variable Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Variable Declarations</em>'.
	 * @see org.eclipselabs.damos.mscript.il.ILFunctionDefinition#getInputVariableDeclarations()
	 * @see #getILFunctionDefinition()
	 * @generated
	 */
	EReference getILFunctionDefinition_InputVariableDeclarations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.mscript.il.ILFunctionDefinition#getOutputVariableDeclarations <em>Output Variable Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Variable Declarations</em>'.
	 * @see org.eclipselabs.damos.mscript.il.ILFunctionDefinition#getOutputVariableDeclarations()
	 * @see #getILFunctionDefinition()
	 * @generated
	 */
	EReference getILFunctionDefinition_OutputVariableDeclarations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.mscript.il.ILFunctionDefinition#getInstanceVariableDeclarations <em>Instance Variable Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instance Variable Declarations</em>'.
	 * @see org.eclipselabs.damos.mscript.il.ILFunctionDefinition#getInstanceVariableDeclarations()
	 * @see #getILFunctionDefinition()
	 * @generated
	 */
	EReference getILFunctionDefinition_InstanceVariableDeclarations();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.mscript.il.ILFunctionDefinition#getInitializationCompound <em>Initialization Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initialization Compound</em>'.
	 * @see org.eclipselabs.damos.mscript.il.ILFunctionDefinition#getInitializationCompound()
	 * @see #getILFunctionDefinition()
	 * @generated
	 */
	EReference getILFunctionDefinition_InitializationCompound();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.mscript.il.ILFunctionDefinition#getComputationCompounds <em>Computation Compounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Computation Compounds</em>'.
	 * @see org.eclipselabs.damos.mscript.il.ILFunctionDefinition#getComputationCompounds()
	 * @see #getILFunctionDefinition()
	 * @generated
	 */
	EReference getILFunctionDefinition_ComputationCompounds();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.il.ComputationCompound <em>Computation Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computation Compound</em>'.
	 * @see org.eclipselabs.damos.mscript.il.ComputationCompound
	 * @generated
	 */
	EClass getComputationCompound();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.mscript.il.ComputationCompound#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inputs</em>'.
	 * @see org.eclipselabs.damos.mscript.il.ComputationCompound#getInputs()
	 * @see #getComputationCompound()
	 * @generated
	 */
	EReference getComputationCompound_Inputs();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.mscript.il.ComputationCompound#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outputs</em>'.
	 * @see org.eclipselabs.damos.mscript.il.ComputationCompound#getOutputs()
	 * @see #getComputationCompound()
	 * @generated
	 */
	EReference getComputationCompound_Outputs();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.il.VariableDeclarationInfo <em>Variable Declaration Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration Info</em>'.
	 * @see org.eclipselabs.damos.mscript.il.VariableDeclarationInfo
	 * @generated
	 */
	EClass getVariableDeclarationInfo();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.mscript.il.VariableDeclarationInfo#getVariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable Declaration</em>'.
	 * @see org.eclipselabs.damos.mscript.il.VariableDeclarationInfo#getVariableDeclaration()
	 * @see #getVariableDeclarationInfo()
	 * @generated
	 */
	EReference getVariableDeclarationInfo_VariableDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.il.StatefulVariableDeclaration <em>Stateful Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stateful Variable Declaration</em>'.
	 * @see org.eclipselabs.damos.mscript.il.StatefulVariableDeclaration
	 * @generated
	 */
	EClass getStatefulVariableDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.mscript.il.StatefulVariableDeclaration#getCircularBufferSize <em>Circular Buffer Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Circular Buffer Size</em>'.
	 * @see org.eclipselabs.damos.mscript.il.StatefulVariableDeclaration#getCircularBufferSize()
	 * @see #getStatefulVariableDeclaration()
	 * @generated
	 */
	EAttribute getStatefulVariableDeclaration_CircularBufferSize();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.il.TemplateVariableDeclaration <em>Template Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Variable Declaration</em>'.
	 * @see org.eclipselabs.damos.mscript.il.TemplateVariableDeclaration
	 * @generated
	 */
	EClass getTemplateVariableDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.il.InputVariableDeclaration <em>Input Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Variable Declaration</em>'.
	 * @see org.eclipselabs.damos.mscript.il.InputVariableDeclaration
	 * @generated
	 */
	EClass getInputVariableDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.il.OutputVariableDeclaration <em>Output Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Variable Declaration</em>'.
	 * @see org.eclipselabs.damos.mscript.il.OutputVariableDeclaration
	 * @generated
	 */
	EClass getOutputVariableDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.il.InstanceVariableDeclaration <em>Instance Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Variable Declaration</em>'.
	 * @see org.eclipselabs.damos.mscript.il.InstanceVariableDeclaration
	 * @generated
	 */
	EClass getInstanceVariableDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.il.InvalidExpression <em>Invalid Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invalid Expression</em>'.
	 * @see org.eclipselabs.damos.mscript.il.InvalidExpression
	 * @generated
	 */
	EClass getInvalidExpression();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ILFactory getILFactory();

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
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.il.impl.ILFunctionDefinitionImpl <em>Function Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.il.impl.ILFunctionDefinitionImpl
		 * @see org.eclipselabs.damos.mscript.il.impl.ILPackageImpl#getILFunctionDefinition()
		 * @generated
		 */
		EClass IL_FUNCTION_DEFINITION = eINSTANCE.getILFunctionDefinition();

		/**
		 * The meta object literal for the '<em><b>Function Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IL_FUNCTION_DEFINITION__FUNCTION_DEFINITION = eINSTANCE.getILFunctionDefinition_FunctionDefinition();

		/**
		 * The meta object literal for the '<em><b>Stateful</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IL_FUNCTION_DEFINITION__STATEFUL = eINSTANCE.getILFunctionDefinition_Stateful();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IL_FUNCTION_DEFINITION__NAME = eINSTANCE.getILFunctionDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Template Variable Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IL_FUNCTION_DEFINITION__TEMPLATE_VARIABLE_DECLARATIONS = eINSTANCE.getILFunctionDefinition_TemplateVariableDeclarations();

		/**
		 * The meta object literal for the '<em><b>Input Variable Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IL_FUNCTION_DEFINITION__INPUT_VARIABLE_DECLARATIONS = eINSTANCE.getILFunctionDefinition_InputVariableDeclarations();

		/**
		 * The meta object literal for the '<em><b>Output Variable Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IL_FUNCTION_DEFINITION__OUTPUT_VARIABLE_DECLARATIONS = eINSTANCE.getILFunctionDefinition_OutputVariableDeclarations();

		/**
		 * The meta object literal for the '<em><b>Instance Variable Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IL_FUNCTION_DEFINITION__INSTANCE_VARIABLE_DECLARATIONS = eINSTANCE.getILFunctionDefinition_InstanceVariableDeclarations();

		/**
		 * The meta object literal for the '<em><b>Initialization Compound</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IL_FUNCTION_DEFINITION__INITIALIZATION_COMPOUND = eINSTANCE.getILFunctionDefinition_InitializationCompound();

		/**
		 * The meta object literal for the '<em><b>Computation Compounds</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IL_FUNCTION_DEFINITION__COMPUTATION_COMPOUNDS = eINSTANCE.getILFunctionDefinition_ComputationCompounds();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.il.impl.ComputationCompoundImpl <em>Computation Compound</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.il.impl.ComputationCompoundImpl
		 * @see org.eclipselabs.damos.mscript.il.impl.ILPackageImpl#getComputationCompound()
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
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.il.impl.VariableDeclarationInfoImpl <em>Variable Declaration Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.il.impl.VariableDeclarationInfoImpl
		 * @see org.eclipselabs.damos.mscript.il.impl.ILPackageImpl#getVariableDeclarationInfo()
		 * @generated
		 */
		EClass VARIABLE_DECLARATION_INFO = eINSTANCE.getVariableDeclarationInfo();

		/**
		 * The meta object literal for the '<em><b>Variable Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DECLARATION_INFO__VARIABLE_DECLARATION = eINSTANCE.getVariableDeclarationInfo_VariableDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.il.impl.StatefulVariableDeclarationImpl <em>Stateful Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.il.impl.StatefulVariableDeclarationImpl
		 * @see org.eclipselabs.damos.mscript.il.impl.ILPackageImpl#getStatefulVariableDeclaration()
		 * @generated
		 */
		EClass STATEFUL_VARIABLE_DECLARATION = eINSTANCE.getStatefulVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Circular Buffer Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_SIZE = eINSTANCE.getStatefulVariableDeclaration_CircularBufferSize();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.il.impl.TemplateVariableDeclarationImpl <em>Template Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.il.impl.TemplateVariableDeclarationImpl
		 * @see org.eclipselabs.damos.mscript.il.impl.ILPackageImpl#getTemplateVariableDeclaration()
		 * @generated
		 */
		EClass TEMPLATE_VARIABLE_DECLARATION = eINSTANCE.getTemplateVariableDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.il.impl.InputVariableDeclarationImpl <em>Input Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.il.impl.InputVariableDeclarationImpl
		 * @see org.eclipselabs.damos.mscript.il.impl.ILPackageImpl#getInputVariableDeclaration()
		 * @generated
		 */
		EClass INPUT_VARIABLE_DECLARATION = eINSTANCE.getInputVariableDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.il.impl.OutputVariableDeclarationImpl <em>Output Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.il.impl.OutputVariableDeclarationImpl
		 * @see org.eclipselabs.damos.mscript.il.impl.ILPackageImpl#getOutputVariableDeclaration()
		 * @generated
		 */
		EClass OUTPUT_VARIABLE_DECLARATION = eINSTANCE.getOutputVariableDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.il.impl.InstanceVariableDeclarationImpl <em>Instance Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.il.impl.InstanceVariableDeclarationImpl
		 * @see org.eclipselabs.damos.mscript.il.impl.ILPackageImpl#getInstanceVariableDeclaration()
		 * @generated
		 */
		EClass INSTANCE_VARIABLE_DECLARATION = eINSTANCE.getInstanceVariableDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.il.impl.InvalidExpressionImpl <em>Invalid Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.il.impl.InvalidExpressionImpl
		 * @see org.eclipselabs.damos.mscript.il.impl.ILPackageImpl#getInvalidExpression()
		 * @generated
		 */
		EClass INVALID_EXPRESSION = eINSTANCE.getInvalidExpression();

	}

} //ILPackage
