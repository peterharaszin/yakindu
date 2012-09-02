/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dscript;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipselabs.damos.dml.DMLPackage;
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
 * @see org.eclipselabs.damos.dscript.DscriptFactory
 * @model kind="package"
 * @generated
 */
public interface DscriptPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dscript";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/damos/2011/Dscript";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dscript";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DscriptPackage eINSTANCE = org.eclipselabs.damos.dscript.impl.DscriptPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dscript.impl.RootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dscript.impl.RootImpl
	 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getRoot()
	 * @generated
	 */
	int ROOT = 0;

	/**
	 * The feature id for the '<em><b>Block Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__BLOCK_TYPES = 0;

	/**
	 * The feature id for the '<em><b>System Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__SYSTEM_INTERFACES = 1;

	/**
	 * The number of structural features of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dscript.impl.DscriptBlockTypeImpl <em>Block Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dscript.impl.DscriptBlockTypeImpl
	 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getDscriptBlockType()
	 * @generated
	 */
	int DSCRIPT_BLOCK_TYPE = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_BLOCK_TYPE__EANNOTATIONS = DMLPackage.BLOCK_TYPE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_BLOCK_TYPE__QUALIFIED_NAME = DMLPackage.BLOCK_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_BLOCK_TYPE__NAME = DMLPackage.BLOCK_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_BLOCK_TYPE__PACKAGE_NAME = DMLPackage.BLOCK_TYPE__PACKAGE_NAME;

	/**
	 * The feature id for the '<em><b>Belonging Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_BLOCK_TYPE__BELONGING_CATEGORIES = DMLPackage.BLOCK_TYPE__BELONGING_CATEGORIES;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_BLOCK_TYPE__PARAMETERS = DMLPackage.BLOCK_TYPE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Input Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_BLOCK_TYPE__INPUT_DEFINITIONS = DMLPackage.BLOCK_TYPE__INPUT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Output Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_BLOCK_TYPE__OUTPUT_DEFINITIONS = DMLPackage.BLOCK_TYPE__OUTPUT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Timing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_BLOCK_TYPE__TIMING = DMLPackage.BLOCK_TYPE__TIMING;

	/**
	 * The feature id for the '<em><b>Boundary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_BLOCK_TYPE__BOUNDARY = DMLPackage.BLOCK_TYPE__BOUNDARY;

	/**
	 * The feature id for the '<em><b>Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_BLOCK_TYPE__DECLARATIONS = DMLPackage.BLOCK_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Import Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_BLOCK_TYPE__IMPORT_DECLARATIONS = DMLPackage.BLOCK_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_BLOCK_TYPE__BEHAVIOR = DMLPackage.BLOCK_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Block Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_BLOCK_TYPE_FEATURE_COUNT = DMLPackage.BLOCK_TYPE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dscript.impl.DscriptInputDefinitionImpl <em>Input Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dscript.impl.DscriptInputDefinitionImpl
	 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getDscriptInputDefinition()
	 * @generated
	 */
	int DSCRIPT_INPUT_DEFINITION = 2;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_INPUT_DEFINITION__PARAMETERS = DMLPackage.INPUT_DEFINITION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Minimum Port Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_INPUT_DEFINITION__MINIMUM_PORT_COUNT = DMLPackage.INPUT_DEFINITION__MINIMUM_PORT_COUNT;

	/**
	 * The feature id for the '<em><b>Maximum Port Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_INPUT_DEFINITION__MAXIMUM_PORT_COUNT = DMLPackage.INPUT_DEFINITION__MAXIMUM_PORT_COUNT;

	/**
	 * The feature id for the '<em><b>Default Port Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_INPUT_DEFINITION__DEFAULT_PORT_COUNT = DMLPackage.INPUT_DEFINITION__DEFAULT_PORT_COUNT;

	/**
	 * The feature id for the '<em><b>Many Ports</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_INPUT_DEFINITION__MANY_PORTS = DMLPackage.INPUT_DEFINITION__MANY_PORTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_INPUT_DEFINITION__NAME = DMLPackage.INPUT_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Test Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_INPUT_DEFINITION__TEST_POINT = DMLPackage.INPUT_DEFINITION__TEST_POINT;

	/**
	 * The feature id for the '<em><b>Socket</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_INPUT_DEFINITION__SOCKET = DMLPackage.INPUT_DEFINITION__SOCKET;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_INPUT_DEFINITION__DATA_TYPE = DMLPackage.INPUT_DEFINITION__DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Direct Feedthrough Policy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_INPUT_DEFINITION__DIRECT_FEEDTHROUGH_POLICY = DMLPackage.INPUT_DEFINITION__DIRECT_FEEDTHROUGH_POLICY;

	/**
	 * The number of structural features of the '<em>Input Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_INPUT_DEFINITION_FEATURE_COUNT = DMLPackage.INPUT_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dscript.impl.DscriptOutputDefinitionImpl <em>Output Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dscript.impl.DscriptOutputDefinitionImpl
	 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getDscriptOutputDefinition()
	 * @generated
	 */
	int DSCRIPT_OUTPUT_DEFINITION = 3;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_OUTPUT_DEFINITION__PARAMETERS = DMLPackage.OUTPUT_DEFINITION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Minimum Port Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_OUTPUT_DEFINITION__MINIMUM_PORT_COUNT = DMLPackage.OUTPUT_DEFINITION__MINIMUM_PORT_COUNT;

	/**
	 * The feature id for the '<em><b>Maximum Port Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_OUTPUT_DEFINITION__MAXIMUM_PORT_COUNT = DMLPackage.OUTPUT_DEFINITION__MAXIMUM_PORT_COUNT;

	/**
	 * The feature id for the '<em><b>Default Port Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_OUTPUT_DEFINITION__DEFAULT_PORT_COUNT = DMLPackage.OUTPUT_DEFINITION__DEFAULT_PORT_COUNT;

	/**
	 * The feature id for the '<em><b>Many Ports</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_OUTPUT_DEFINITION__MANY_PORTS = DMLPackage.OUTPUT_DEFINITION__MANY_PORTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_OUTPUT_DEFINITION__NAME = DMLPackage.OUTPUT_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Test Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_OUTPUT_DEFINITION__TEST_POINT = DMLPackage.OUTPUT_DEFINITION__TEST_POINT;

	/**
	 * The feature id for the '<em><b>Socket</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_OUTPUT_DEFINITION__SOCKET = DMLPackage.OUTPUT_DEFINITION__SOCKET;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_OUTPUT_DEFINITION__DATA_TYPE = DMLPackage.OUTPUT_DEFINITION__DATA_TYPE;

	/**
	 * The number of structural features of the '<em>Output Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_OUTPUT_DEFINITION_FEATURE_COUNT = DMLPackage.OUTPUT_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dscript.impl.DscriptParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dscript.impl.DscriptParameterImpl
	 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getDscriptParameter()
	 * @generated
	 */
	int DSCRIPT_PARAMETER = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_PARAMETER__NAME = DMLPackage.PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_PARAMETER__DATA_TYPE = DMLPackage.PARAMETER__DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_PARAMETER__VISIBILITY = DMLPackage.PARAMETER__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Owned Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_PARAMETER__OWNED_DEFAULT_VALUE = DMLPackage.PARAMETER__OWNED_DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Predefined Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_PARAMETER__PREDEFINED_VALUES = DMLPackage.PARAMETER__PREDEFINED_VALUES;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_PARAMETER_FEATURE_COUNT = DMLPackage.PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dscript.impl.BehaviorDeclarationImpl <em>Behavior Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dscript.impl.BehaviorDeclarationImpl
	 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getBehaviorDeclaration()
	 * @generated
	 */
	int BEHAVIOR_DECLARATION = 5;

	/**
	 * The feature id for the '<em><b>Checks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_DECLARATION__CHECKS = MscriptPackage.FUNCTION_DECLARATION__CHECKS;

	/**
	 * The feature id for the '<em><b>Assertions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_DECLARATION__ASSERTIONS = MscriptPackage.FUNCTION_DECLARATION__ASSERTIONS;

	/**
	 * The feature id for the '<em><b>State Variable Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_DECLARATION__STATE_VARIABLE_DECLARATIONS = MscriptPackage.FUNCTION_DECLARATION__STATE_VARIABLE_DECLARATIONS;

	/**
	 * The feature id for the '<em><b>Constant Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_DECLARATION__CONSTANT_DECLARATIONS = MscriptPackage.FUNCTION_DECLARATION__CONSTANT_DECLARATIONS;

	/**
	 * The feature id for the '<em><b>Equations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_DECLARATION__EQUATIONS = MscriptPackage.FUNCTION_DECLARATION__EQUATIONS;

	/**
	 * The feature id for the '<em><b>All Implicit Variable Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_DECLARATION__ALL_IMPLICIT_VARIABLE_DECLARATIONS = MscriptPackage.FUNCTION_DECLARATION__ALL_IMPLICIT_VARIABLE_DECLARATIONS;

	/**
	 * The feature id for the '<em><b>Block Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_DECLARATION__BLOCK_TYPE = MscriptPackage.FUNCTION_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>All Implicit Input Parameter Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_DECLARATION__ALL_IMPLICIT_INPUT_PARAMETER_DECLARATIONS = MscriptPackage.FUNCTION_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>All Implicit Output Parameter Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_DECLARATION__ALL_IMPLICIT_OUTPUT_PARAMETER_DECLARATIONS = MscriptPackage.FUNCTION_DECLARATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Behavior Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_DECLARATION_FEATURE_COUNT = MscriptPackage.FUNCTION_DECLARATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dscript.impl.ImplicitInputParameterDeclarationImpl <em>Implicit Input Parameter Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dscript.impl.ImplicitInputParameterDeclarationImpl
	 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getImplicitInputParameterDeclaration()
	 * @generated
	 */
	int IMPLICIT_INPUT_PARAMETER_DECLARATION = 6;

	/**
	 * The number of structural features of the '<em>Implicit Input Parameter Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICIT_INPUT_PARAMETER_DECLARATION_FEATURE_COUNT = MscriptPackage.INPUT_PARAMETER_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dscript.impl.ImplicitOutputParameterDeclarationImpl <em>Implicit Output Parameter Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dscript.impl.ImplicitOutputParameterDeclarationImpl
	 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getImplicitOutputParameterDeclaration()
	 * @generated
	 */
	int IMPLICIT_OUTPUT_PARAMETER_DECLARATION = 7;

	/**
	 * The number of structural features of the '<em>Implicit Output Parameter Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICIT_OUTPUT_PARAMETER_DECLARATION_FEATURE_COUNT = MscriptPackage.OUTPUT_PARAMETER_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dscript.impl.InputMessageParameterDeclarationImpl <em>Input Message Parameter Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dscript.impl.InputMessageParameterDeclarationImpl
	 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getInputMessageParameterDeclaration()
	 * @generated
	 */
	int INPUT_MESSAGE_PARAMETER_DECLARATION = 8;

	/**
	 * The number of structural features of the '<em>Input Message Parameter Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_MESSAGE_PARAMETER_DECLARATION_FEATURE_COUNT = IMPLICIT_INPUT_PARAMETER_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dscript.impl.OutputMessageParameterDeclarationImpl <em>Output Message Parameter Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dscript.impl.OutputMessageParameterDeclarationImpl
	 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getOutputMessageParameterDeclaration()
	 * @generated
	 */
	int OUTPUT_MESSAGE_PARAMETER_DECLARATION = 9;

	/**
	 * The number of structural features of the '<em>Output Message Parameter Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_MESSAGE_PARAMETER_DECLARATION_FEATURE_COUNT = IMPLICIT_OUTPUT_PARAMETER_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dscript.impl.DscriptSystemInterfaceImpl <em>System Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dscript.impl.DscriptSystemInterfaceImpl
	 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getDscriptSystemInterface()
	 * @generated
	 */
	int DSCRIPT_SYSTEM_INTERFACE = 10;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_SYSTEM_INTERFACE__QUALIFIED_NAME = DMLPackage.SYSTEM_INTERFACE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_SYSTEM_INTERFACE__NAME = DMLPackage.SYSTEM_INTERFACE__NAME;

	/**
	 * The feature id for the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_SYSTEM_INTERFACE__PACKAGE_NAME = DMLPackage.SYSTEM_INTERFACE__PACKAGE_NAME;

	/**
	 * The feature id for the '<em><b>Inlets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_SYSTEM_INTERFACE__INLETS = DMLPackage.SYSTEM_INTERFACE__INLETS;

	/**
	 * The feature id for the '<em><b>Outlets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_SYSTEM_INTERFACE__OUTLETS = DMLPackage.SYSTEM_INTERFACE__OUTLETS;

	/**
	 * The feature id for the '<em><b>Import Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_SYSTEM_INTERFACE__IMPORT_DECLARATIONS = DMLPackage.SYSTEM_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>System Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_SYSTEM_INTERFACE_FEATURE_COUNT = DMLPackage.SYSTEM_INTERFACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dscript.impl.DscriptDataTypeSpecificationImpl <em>Data Type Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dscript.impl.DscriptDataTypeSpecificationImpl
	 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getDscriptDataTypeSpecification()
	 * @generated
	 */
	int DSCRIPT_DATA_TYPE_SPECIFICATION = 11;

	/**
	 * The feature id for the '<em><b>Type Specifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_DATA_TYPE_SPECIFICATION__TYPE_SPECIFIER = DMLPackage.DATA_TYPE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_DATA_TYPE_SPECIFICATION__TYPE = DMLPackage.DATA_TYPE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Data Type Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_DATA_TYPE_SPECIFICATION_FEATURE_COUNT = DMLPackage.DATA_TYPE_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dscript.impl.DscriptValueSpecificationImpl <em>Value Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dscript.impl.DscriptValueSpecificationImpl
	 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getDscriptValueSpecification()
	 * @generated
	 */
	int DSCRIPT_VALUE_SPECIFICATION = 12;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_VALUE_SPECIFICATION__EXPRESSION = DMLPackage.VALUE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Value Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSCRIPT_VALUE_SPECIFICATION_FEATURE_COUNT = DMLPackage.VALUE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dscript.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see org.eclipselabs.damos.dscript.Root
	 * @generated
	 */
	EClass getRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dscript.Root#getBlockTypes <em>Block Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Block Types</em>'.
	 * @see org.eclipselabs.damos.dscript.Root#getBlockTypes()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_BlockTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dscript.Root#getSystemInterfaces <em>System Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>System Interfaces</em>'.
	 * @see org.eclipselabs.damos.dscript.Root#getSystemInterfaces()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_SystemInterfaces();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dscript.DscriptBlockType <em>Block Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Type</em>'.
	 * @see org.eclipselabs.damos.dscript.DscriptBlockType
	 * @generated
	 */
	EClass getDscriptBlockType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dscript.DscriptBlockType#getImportDeclarations <em>Import Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Import Declarations</em>'.
	 * @see org.eclipselabs.damos.dscript.DscriptBlockType#getImportDeclarations()
	 * @see #getDscriptBlockType()
	 * @generated
	 */
	EReference getDscriptBlockType_ImportDeclarations();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dscript.DscriptBlockType#getBehavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Behavior</em>'.
	 * @see org.eclipselabs.damos.dscript.DscriptBlockType#getBehavior()
	 * @see #getDscriptBlockType()
	 * @generated
	 */
	EReference getDscriptBlockType_Behavior();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dscript.DscriptInputDefinition <em>Input Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Definition</em>'.
	 * @see org.eclipselabs.damos.dscript.DscriptInputDefinition
	 * @generated
	 */
	EClass getDscriptInputDefinition();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dscript.DscriptOutputDefinition <em>Output Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Definition</em>'.
	 * @see org.eclipselabs.damos.dscript.DscriptOutputDefinition
	 * @generated
	 */
	EClass getDscriptOutputDefinition();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dscript.DscriptParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.eclipselabs.damos.dscript.DscriptParameter
	 * @generated
	 */
	EClass getDscriptParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dscript.BehaviorDeclaration <em>Behavior Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Declaration</em>'.
	 * @see org.eclipselabs.damos.dscript.BehaviorDeclaration
	 * @generated
	 */
	EClass getBehaviorDeclaration();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.dscript.BehaviorDeclaration#getBlockType <em>Block Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Block Type</em>'.
	 * @see org.eclipselabs.damos.dscript.BehaviorDeclaration#getBlockType()
	 * @see #getBehaviorDeclaration()
	 * @generated
	 */
	EReference getBehaviorDeclaration_BlockType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dscript.BehaviorDeclaration#getAllImplicitInputParameterDeclarations <em>All Implicit Input Parameter Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>All Implicit Input Parameter Declarations</em>'.
	 * @see org.eclipselabs.damos.dscript.BehaviorDeclaration#getAllImplicitInputParameterDeclarations()
	 * @see #getBehaviorDeclaration()
	 * @generated
	 */
	EReference getBehaviorDeclaration_AllImplicitInputParameterDeclarations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dscript.BehaviorDeclaration#getAllImplicitOutputParameterDeclarations <em>All Implicit Output Parameter Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>All Implicit Output Parameter Declarations</em>'.
	 * @see org.eclipselabs.damos.dscript.BehaviorDeclaration#getAllImplicitOutputParameterDeclarations()
	 * @see #getBehaviorDeclaration()
	 * @generated
	 */
	EReference getBehaviorDeclaration_AllImplicitOutputParameterDeclarations();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dscript.ImplicitInputParameterDeclaration <em>Implicit Input Parameter Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implicit Input Parameter Declaration</em>'.
	 * @see org.eclipselabs.damos.dscript.ImplicitInputParameterDeclaration
	 * @generated
	 */
	EClass getImplicitInputParameterDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dscript.ImplicitOutputParameterDeclaration <em>Implicit Output Parameter Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implicit Output Parameter Declaration</em>'.
	 * @see org.eclipselabs.damos.dscript.ImplicitOutputParameterDeclaration
	 * @generated
	 */
	EClass getImplicitOutputParameterDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dscript.InputMessageParameterDeclaration <em>Input Message Parameter Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Message Parameter Declaration</em>'.
	 * @see org.eclipselabs.damos.dscript.InputMessageParameterDeclaration
	 * @generated
	 */
	EClass getInputMessageParameterDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dscript.OutputMessageParameterDeclaration <em>Output Message Parameter Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Message Parameter Declaration</em>'.
	 * @see org.eclipselabs.damos.dscript.OutputMessageParameterDeclaration
	 * @generated
	 */
	EClass getOutputMessageParameterDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dscript.DscriptSystemInterface <em>System Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Interface</em>'.
	 * @see org.eclipselabs.damos.dscript.DscriptSystemInterface
	 * @generated
	 */
	EClass getDscriptSystemInterface();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dscript.DscriptSystemInterface#getImportDeclarations <em>Import Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Import Declarations</em>'.
	 * @see org.eclipselabs.damos.dscript.DscriptSystemInterface#getImportDeclarations()
	 * @see #getDscriptSystemInterface()
	 * @generated
	 */
	EReference getDscriptSystemInterface_ImportDeclarations();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dscript.DscriptDataTypeSpecification <em>Data Type Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type Specification</em>'.
	 * @see org.eclipselabs.damos.dscript.DscriptDataTypeSpecification
	 * @generated
	 */
	EClass getDscriptDataTypeSpecification();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dscript.DscriptDataTypeSpecification#getTypeSpecifier <em>Type Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Specifier</em>'.
	 * @see org.eclipselabs.damos.dscript.DscriptDataTypeSpecification#getTypeSpecifier()
	 * @see #getDscriptDataTypeSpecification()
	 * @generated
	 */
	EReference getDscriptDataTypeSpecification_TypeSpecifier();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dscript.DscriptDataTypeSpecification#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipselabs.damos.dscript.DscriptDataTypeSpecification#getType()
	 * @see #getDscriptDataTypeSpecification()
	 * @generated
	 */
	EReference getDscriptDataTypeSpecification_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dscript.DscriptValueSpecification <em>Value Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Specification</em>'.
	 * @see org.eclipselabs.damos.dscript.DscriptValueSpecification
	 * @generated
	 */
	EClass getDscriptValueSpecification();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dscript.DscriptValueSpecification#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipselabs.damos.dscript.DscriptValueSpecification#getExpression()
	 * @see #getDscriptValueSpecification()
	 * @generated
	 */
	EReference getDscriptValueSpecification_Expression();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DscriptFactory getDscriptFactory();

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
		 * The meta object literal for the '{@link org.eclipselabs.damos.dscript.impl.RootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dscript.impl.RootImpl
		 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getRoot()
		 * @generated
		 */
		EClass ROOT = eINSTANCE.getRoot();

		/**
		 * The meta object literal for the '<em><b>Block Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__BLOCK_TYPES = eINSTANCE.getRoot_BlockTypes();

		/**
		 * The meta object literal for the '<em><b>System Interfaces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__SYSTEM_INTERFACES = eINSTANCE.getRoot_SystemInterfaces();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dscript.impl.DscriptBlockTypeImpl <em>Block Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dscript.impl.DscriptBlockTypeImpl
		 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getDscriptBlockType()
		 * @generated
		 */
		EClass DSCRIPT_BLOCK_TYPE = eINSTANCE.getDscriptBlockType();

		/**
		 * The meta object literal for the '<em><b>Import Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSCRIPT_BLOCK_TYPE__IMPORT_DECLARATIONS = eINSTANCE.getDscriptBlockType_ImportDeclarations();

		/**
		 * The meta object literal for the '<em><b>Behavior</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSCRIPT_BLOCK_TYPE__BEHAVIOR = eINSTANCE.getDscriptBlockType_Behavior();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dscript.impl.DscriptInputDefinitionImpl <em>Input Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dscript.impl.DscriptInputDefinitionImpl
		 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getDscriptInputDefinition()
		 * @generated
		 */
		EClass DSCRIPT_INPUT_DEFINITION = eINSTANCE.getDscriptInputDefinition();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dscript.impl.DscriptOutputDefinitionImpl <em>Output Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dscript.impl.DscriptOutputDefinitionImpl
		 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getDscriptOutputDefinition()
		 * @generated
		 */
		EClass DSCRIPT_OUTPUT_DEFINITION = eINSTANCE.getDscriptOutputDefinition();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dscript.impl.DscriptParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dscript.impl.DscriptParameterImpl
		 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getDscriptParameter()
		 * @generated
		 */
		EClass DSCRIPT_PARAMETER = eINSTANCE.getDscriptParameter();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dscript.impl.BehaviorDeclarationImpl <em>Behavior Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dscript.impl.BehaviorDeclarationImpl
		 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getBehaviorDeclaration()
		 * @generated
		 */
		EClass BEHAVIOR_DECLARATION = eINSTANCE.getBehaviorDeclaration();

		/**
		 * The meta object literal for the '<em><b>Block Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_DECLARATION__BLOCK_TYPE = eINSTANCE.getBehaviorDeclaration_BlockType();

		/**
		 * The meta object literal for the '<em><b>All Implicit Input Parameter Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_DECLARATION__ALL_IMPLICIT_INPUT_PARAMETER_DECLARATIONS = eINSTANCE.getBehaviorDeclaration_AllImplicitInputParameterDeclarations();

		/**
		 * The meta object literal for the '<em><b>All Implicit Output Parameter Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_DECLARATION__ALL_IMPLICIT_OUTPUT_PARAMETER_DECLARATIONS = eINSTANCE.getBehaviorDeclaration_AllImplicitOutputParameterDeclarations();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dscript.impl.ImplicitInputParameterDeclarationImpl <em>Implicit Input Parameter Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dscript.impl.ImplicitInputParameterDeclarationImpl
		 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getImplicitInputParameterDeclaration()
		 * @generated
		 */
		EClass IMPLICIT_INPUT_PARAMETER_DECLARATION = eINSTANCE.getImplicitInputParameterDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dscript.impl.ImplicitOutputParameterDeclarationImpl <em>Implicit Output Parameter Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dscript.impl.ImplicitOutputParameterDeclarationImpl
		 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getImplicitOutputParameterDeclaration()
		 * @generated
		 */
		EClass IMPLICIT_OUTPUT_PARAMETER_DECLARATION = eINSTANCE.getImplicitOutputParameterDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dscript.impl.InputMessageParameterDeclarationImpl <em>Input Message Parameter Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dscript.impl.InputMessageParameterDeclarationImpl
		 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getInputMessageParameterDeclaration()
		 * @generated
		 */
		EClass INPUT_MESSAGE_PARAMETER_DECLARATION = eINSTANCE.getInputMessageParameterDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dscript.impl.OutputMessageParameterDeclarationImpl <em>Output Message Parameter Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dscript.impl.OutputMessageParameterDeclarationImpl
		 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getOutputMessageParameterDeclaration()
		 * @generated
		 */
		EClass OUTPUT_MESSAGE_PARAMETER_DECLARATION = eINSTANCE.getOutputMessageParameterDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dscript.impl.DscriptSystemInterfaceImpl <em>System Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dscript.impl.DscriptSystemInterfaceImpl
		 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getDscriptSystemInterface()
		 * @generated
		 */
		EClass DSCRIPT_SYSTEM_INTERFACE = eINSTANCE.getDscriptSystemInterface();

		/**
		 * The meta object literal for the '<em><b>Import Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSCRIPT_SYSTEM_INTERFACE__IMPORT_DECLARATIONS = eINSTANCE.getDscriptSystemInterface_ImportDeclarations();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dscript.impl.DscriptDataTypeSpecificationImpl <em>Data Type Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dscript.impl.DscriptDataTypeSpecificationImpl
		 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getDscriptDataTypeSpecification()
		 * @generated
		 */
		EClass DSCRIPT_DATA_TYPE_SPECIFICATION = eINSTANCE.getDscriptDataTypeSpecification();

		/**
		 * The meta object literal for the '<em><b>Type Specifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSCRIPT_DATA_TYPE_SPECIFICATION__TYPE_SPECIFIER = eINSTANCE.getDscriptDataTypeSpecification_TypeSpecifier();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSCRIPT_DATA_TYPE_SPECIFICATION__TYPE = eINSTANCE.getDscriptDataTypeSpecification_Type();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dscript.impl.DscriptValueSpecificationImpl <em>Value Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dscript.impl.DscriptValueSpecificationImpl
		 * @see org.eclipselabs.damos.dscript.impl.DscriptPackageImpl#getDscriptValueSpecification()
		 * @generated
		 */
		EClass DSCRIPT_VALUE_SPECIFICATION = eINSTANCE.getDscriptValueSpecification();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSCRIPT_VALUE_SPECIFICATION__EXPRESSION = eINSTANCE.getDscriptValueSpecification_Expression();

	}

} //DscriptPackage
