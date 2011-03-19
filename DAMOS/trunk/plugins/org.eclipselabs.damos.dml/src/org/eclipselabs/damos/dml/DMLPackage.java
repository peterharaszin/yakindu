/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipselabs.damos.dml.DMLFactory
 * @model kind="package"
 * @generated
 */
public interface DMLPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dml";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/damos/DML/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dml";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DMLPackage eINSTANCE = org.eclipselabs.damos.dml.impl.DMLPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.FragmentImpl <em>Fragment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.FragmentImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getFragment()
	 * @generated
	 */
	int FRAGMENT = 0;

	/**
	 * The feature id for the '<em><b>Components</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT__COMPONENTS = 0;

	/**
	 * The feature id for the '<em><b>Fragment Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT__FRAGMENT_ELEMENTS = 1;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT__CONNECTIONS = 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT__PARENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT__NAME = 4;

	/**
	 * The number of structural features of the '<em>Fragment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.FragmentElementImpl <em>Fragment Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.FragmentElementImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getFragmentElement()
	 * @generated
	 */
	int FRAGMENT_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Owning Fragment</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_ELEMENT__OWNING_FRAGMENT = 0;

	/**
	 * The number of structural features of the '<em>Fragment Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.ComponentImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Owning Fragment</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__OWNING_FRAGMENT = FRAGMENT_ELEMENT__OWNING_FRAGMENT;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__INPUTS = FRAGMENT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__OUTPUTS = FRAGMENT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__NAME = FRAGMENT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = FRAGMENT_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.PortImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 10;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.InputPortImpl <em>Input Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.InputPortImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getInputPort()
	 * @generated
	 */
	int INPUT_PORT = 11;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.ConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.ConnectionImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getConnection()
	 * @generated
	 */
	int CONNECTION = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.OutputPortImpl <em>Output Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.OutputPortImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getOutputPort()
	 * @generated
	 */
	int OUTPUT_PORT = 12;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.InoutputImpl <em>Inoutput</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.InoutputImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getInoutput()
	 * @generated
	 */
	int INOUTPUT = 7;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.OutputImpl <em>Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.OutputImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getOutput()
	 * @generated
	 */
	int OUTPUT = 9;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.InputImpl <em>Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.InputImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getInput()
	 * @generated
	 */
	int INPUT = 8;

	/**
	 * The feature id for the '<em><b>Owning Fragment</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__OWNING_FRAGMENT = FRAGMENT_ELEMENT__OWNING_FRAGMENT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__SOURCE = FRAGMENT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__TARGET = FRAGMENT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int CONNECTION__SOURCE_PORT = FRAGMENT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	@Deprecated
	int CONNECTION__TARGET_PORT = FRAGMENT_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FEATURE_COUNT = FRAGMENT_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.ConnectorImpl <em>Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.ConnectorImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getConnector()
	 * @generated
	 */
	int CONNECTOR = 4;

	/**
	 * The number of structural features of the '<em>Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.InputConnectorImpl <em>Input Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.InputConnectorImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getInputConnector()
	 * @generated
	 */
	int INPUT_CONNECTOR = 5;

	/**
	 * The number of structural features of the '<em>Input Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_CONNECTOR_FEATURE_COUNT = CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.OutputConnectorImpl <em>Output Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.OutputConnectorImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getOutputConnector()
	 * @generated
	 */
	int OUTPUT_CONNECTOR = 6;

	/**
	 * The number of structural features of the '<em>Output Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_CONNECTOR_FEATURE_COUNT = CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Inoutput</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUTPUT_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT__PORTS = INOUTPUT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Component</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT__COMPONENT = INOUTPUT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_FEATURE_COUNT = INOUTPUT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Component</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__COMPONENT = INOUTPUT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__PORTS = INOUTPUT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_FEATURE_COUNT = INOUTPUT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Input</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__INPUT = PORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Input Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Output</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__OUTPUT = PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Signal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__SIGNAL = PORT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Output Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.SignalSpecificationImpl <em>Signal Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.SignalSpecificationImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getSignalSpecification()
	 * @generated
	 */
	int SIGNAL_SPECIFICATION = 13;

	/**
	 * The number of structural features of the '<em>Signal Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_SPECIFICATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.BlockInputImpl <em>Block Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.BlockInputImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getBlockInput()
	 * @generated
	 */
	int BLOCK_INPUT = 15;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.BlockInoutputImpl <em>Block Inoutput</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.BlockInoutputImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getBlockInoutput()
	 * @generated
	 */
	int BLOCK_INOUTPUT = 14;

	/**
	 * The number of structural features of the '<em>Block Inoutput</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_INOUTPUT_FEATURE_COUNT = INOUTPUT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_INPUT__PORTS = INPUT__PORTS;

	/**
	 * The feature id for the '<em><b>Component</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_INPUT__COMPONENT = INPUT__COMPONENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_INPUT__DEFINITION = INPUT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_INPUT_FEATURE_COUNT = INPUT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.InoutputDefinitionImpl <em>Inoutput Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.InoutputDefinitionImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getInoutputDefinition()
	 * @generated
	 */
	int INOUTPUT_DEFINITION = 17;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.InputDefinitionImpl <em>Input Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.InputDefinitionImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getInputDefinition()
	 * @generated
	 */
	int INPUT_DEFINITION = 18;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.OutputDefinitionImpl <em>Output Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.OutputDefinitionImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getOutputDefinition()
	 * @generated
	 */
	int OUTPUT_DEFINITION = 19;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.ParameterizedElementImpl <em>Parameterized Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.ParameterizedElementImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getParameterizedElement()
	 * @generated
	 */
	int PARAMETERIZED_ELEMENT = 25;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.ArgumentImpl <em>Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.ArgumentImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getArgument()
	 * @generated
	 */
	int ARGUMENT = 26;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.ExpressionParameterImpl <em>Expression Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.ExpressionParameterImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getExpressionParameter()
	 * @generated
	 */
	int EXPRESSION_PARAMETER = 27;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.ParameterableElementImpl <em>Parameterable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.ParameterableElementImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getParameterableElement()
	 * @generated
	 */
	int PARAMETERABLE_ELEMENT = 20;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.ParameterImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 21;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.ValueSpecificationImpl <em>Value Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.ValueSpecificationImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getValueSpecification()
	 * @generated
	 */
	int VALUE_SPECIFICATION = 22;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.DirectFeedthroughPolicyImpl <em>Direct Feedthrough Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.DirectFeedthroughPolicyImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getDirectFeedthroughPolicy()
	 * @generated
	 */
	int DIRECT_FEEDTHROUGH_POLICY = 24;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.BlockOutputImpl <em>Block Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.BlockOutputImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getBlockOutput()
	 * @generated
	 */
	int BLOCK_OUTPUT = 16;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.ExpressionSpecificationImpl <em>Expression Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.ExpressionSpecificationImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getExpressionSpecification()
	 * @generated
	 */
	int EXPRESSION_SPECIFICATION = 28;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.PredefinedExpressionEntryImpl <em>Predefined Expression Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.PredefinedExpressionEntryImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getPredefinedExpressionEntry()
	 * @generated
	 */
	int PREDEFINED_EXPRESSION_ENTRY = 29;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.DataTypeSpecificationImpl <em>Data Type Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.DataTypeSpecificationImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getDataTypeSpecification()
	 * @generated
	 */
	int DATA_TYPE_SPECIFICATION = 23;

	/**
	 * The feature id for the '<em><b>Component</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_OUTPUT__COMPONENT = OUTPUT__COMPONENT;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_OUTPUT__PORTS = OUTPUT__PORTS;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_OUTPUT__DEFINITION = OUTPUT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_OUTPUT_FEATURE_COUNT = OUTPUT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT__PARAMETERS = 0;

	/**
	 * The number of structural features of the '<em>Parameterable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERABLE_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUTPUT_DEFINITION__PARAMETERS = PARAMETERABLE_ELEMENT__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Minimum Port Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUTPUT_DEFINITION__MINIMUM_PORT_COUNT = PARAMETERABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Maximum Port Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUTPUT_DEFINITION__MAXIMUM_PORT_COUNT = PARAMETERABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default Port Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUTPUT_DEFINITION__DEFAULT_PORT_COUNT = PARAMETERABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Many Ports</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUTPUT_DEFINITION__MANY_PORTS = PARAMETERABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUTPUT_DEFINITION__NAME = PARAMETERABLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUTPUT_DEFINITION__DATA_TYPE = PARAMETERABLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Inoutput Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUTPUT_DEFINITION_FEATURE_COUNT = PARAMETERABLE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DEFINITION__PARAMETERS = INOUTPUT_DEFINITION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Minimum Port Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DEFINITION__MINIMUM_PORT_COUNT = INOUTPUT_DEFINITION__MINIMUM_PORT_COUNT;

	/**
	 * The feature id for the '<em><b>Maximum Port Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DEFINITION__MAXIMUM_PORT_COUNT = INOUTPUT_DEFINITION__MAXIMUM_PORT_COUNT;

	/**
	 * The feature id for the '<em><b>Default Port Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DEFINITION__DEFAULT_PORT_COUNT = INOUTPUT_DEFINITION__DEFAULT_PORT_COUNT;

	/**
	 * The feature id for the '<em><b>Many Ports</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DEFINITION__MANY_PORTS = INOUTPUT_DEFINITION__MANY_PORTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DEFINITION__NAME = INOUTPUT_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DEFINITION__DATA_TYPE = INOUTPUT_DEFINITION__DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Direct Feedthrough Policy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DEFINITION__DIRECT_FEEDTHROUGH_POLICY = INOUTPUT_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Input Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DEFINITION_FEATURE_COUNT = INOUTPUT_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_DEFINITION__PARAMETERS = INOUTPUT_DEFINITION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Minimum Port Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_DEFINITION__MINIMUM_PORT_COUNT = INOUTPUT_DEFINITION__MINIMUM_PORT_COUNT;

	/**
	 * The feature id for the '<em><b>Maximum Port Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_DEFINITION__MAXIMUM_PORT_COUNT = INOUTPUT_DEFINITION__MAXIMUM_PORT_COUNT;

	/**
	 * The feature id for the '<em><b>Default Port Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_DEFINITION__DEFAULT_PORT_COUNT = INOUTPUT_DEFINITION__DEFAULT_PORT_COUNT;

	/**
	 * The feature id for the '<em><b>Many Ports</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_DEFINITION__MANY_PORTS = INOUTPUT_DEFINITION__MANY_PORTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_DEFINITION__NAME = INOUTPUT_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_DEFINITION__DATA_TYPE = INOUTPUT_DEFINITION__DATA_TYPE;

	/**
	 * The number of structural features of the '<em>Output Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_DEFINITION_FEATURE_COUNT = INOUTPUT_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = 0;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 1;

	/**
	 * The number of structural features of the '<em>Value Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SPECIFICATION_FEATURE_COUNT = 0;

	/**
	 * The number of structural features of the '<em>Data Type Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_SPECIFICATION_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Input Definition</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_FEEDTHROUGH_POLICY__INPUT_DEFINITION = 0;

	/**
	 * The number of structural features of the '<em>Direct Feedthrough Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_FEEDTHROUGH_POLICY_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_ELEMENT__ARGUMENTS = 0;

	/**
	 * The number of structural features of the '<em>Parameterized Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__PARAMETER = 1;

	/**
	 * The number of structural features of the '<em>Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_PARAMETER__NAME = PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Default Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_PARAMETER__DEFAULT_EXPRESSION = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Predefined Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_PARAMETER__PREDEFINED_EXPRESSIONS = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_PARAMETER__DATA_TYPE = PARAMETER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Expression Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_SPECIFICATION__EXPRESSION = VALUE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expression Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_SPECIFICATION_FEATURE_COUNT = VALUE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDEFINED_EXPRESSION_ENTRY__ALIAS = 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDEFINED_EXPRESSION_ENTRY__EXPRESSION = 1;

	/**
	 * The number of structural features of the '<em>Predefined Expression Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDEFINED_EXPRESSION_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.QualifiedElementImpl <em>Qualified Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.QualifiedElementImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getQualifiedElement()
	 * @generated
	 */
	int QUALIFIED_ELEMENT = 31;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_ELEMENT__QUALIFIED_NAME = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_ELEMENT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_ELEMENT__QUALIFIER = 2;

	/**
	 * The number of structural features of the '<em>Qualified Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.CategorizedElementImpl <em>Categorized Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.CategorizedElementImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getCategorizedElement()
	 * @generated
	 */
	int CATEGORIZED_ELEMENT = 32;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.BlockTypeImpl <em>Block Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.BlockTypeImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getBlockType()
	 * @generated
	 */
	int BLOCK_TYPE = 30;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_TYPE__QUALIFIED_NAME = QUALIFIED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.CategoryImpl <em>Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.CategoryImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getCategory()
	 * @generated
	 */
	int CATEGORY = 33;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.ModelImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 36;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.SubsystemImpl <em>Subsystem</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.SubsystemImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getSubsystem()
	 * @generated
	 */
	int SUBSYSTEM = 41;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.InoutletImpl <em>Inoutlet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.InoutletImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getInoutlet()
	 * @generated
	 */
	int INOUTLET = 44;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.InletImpl <em>Inlet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.InletImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getInlet()
	 * @generated
	 */
	int INLET = 43;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.OutletImpl <em>Outlet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.OutletImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getOutlet()
	 * @generated
	 */
	int OUTLET = 45;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.InoutportImpl <em>Inoutport</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.InoutportImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getInoutport()
	 * @generated
	 */
	int INOUTPORT = 48;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.InportImpl <em>Inport</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.InportImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getInport()
	 * @generated
	 */
	int INPORT = 47;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.OutportImpl <em>Outport</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.OutportImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getOutport()
	 * @generated
	 */
	int OUTPORT = 49;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.SubsystemRealizationImpl <em>Subsystem Realization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.SubsystemRealizationImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getSubsystemRealization()
	 * @generated
	 */
	int SUBSYSTEM_REALIZATION = 46;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_TYPE__NAME = QUALIFIED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_TYPE__QUALIFIER = QUALIFIED_ELEMENT__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Belonging Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_TYPE__BELONGING_CATEGORIES = QUALIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_TYPE__PARAMETERS = QUALIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Input Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_TYPE__INPUT_DEFINITIONS = QUALIFIED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Output Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_TYPE__OUTPUT_DEFINITIONS = QUALIFIED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_TYPE__BEHAVIOR = QUALIFIED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Block Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_TYPE_FEATURE_COUNT = QUALIFIED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Belonging Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORIZED_ELEMENT__BELONGING_CATEGORIES = 0;

	/**
	 * The number of structural features of the '<em>Categorized Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORIZED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__QUALIFIED_NAME = QUALIFIED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__NAME = QUALIFIED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__QUALIFIER = QUALIFIED_ELEMENT__QUALIFIER;

	/**
	 * The feature id for the '<em><b>Belonging Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__BELONGING_CATEGORIES = QUALIFIED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__PARAMETERS = QUALIFIED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_FEATURE_COUNT = QUALIFIED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.BehaviorSpecificationImpl <em>Behavior Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.BehaviorSpecificationImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getBehaviorSpecification()
	 * @generated
	 */
	int BEHAVIOR_SPECIFICATION = 34;

	/**
	 * The number of structural features of the '<em>Behavior Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_SPECIFICATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.SystemImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 37;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.BlockImpl <em>Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.BlockImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getBlock()
	 * @generated
	 */
	int BLOCK = 35;

	/**
	 * The feature id for the '<em><b>Owning Fragment</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__OWNING_FRAGMENT = COMPONENT__OWNING_FRAGMENT;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__INPUTS = COMPONENT__INPUTS;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__OUTPUTS = COMPONENT__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__NAME = COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__ARGUMENTS = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__TYPE = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Components</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__COMPONENTS = FRAGMENT__COMPONENTS;

	/**
	 * The feature id for the '<em><b>Fragment Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__FRAGMENT_ELEMENTS = FRAGMENT__FRAGMENT_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__CONNECTIONS = FRAGMENT__CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__PARENT = FRAGMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__NAME = FRAGMENT__NAME;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = FRAGMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Components</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__COMPONENTS = SYSTEM__COMPONENTS;

	/**
	 * The feature id for the '<em><b>Fragment Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__FRAGMENT_ELEMENTS = SYSTEM__FRAGMENT_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__CONNECTIONS = SYSTEM__CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__PARENT = SYSTEM__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__NAME = SYSTEM__NAME;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.BlockPortImpl <em>Block Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.BlockPortImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getBlockPort()
	 * @generated
	 */
	int BLOCK_PORT = 38;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_PORT__ARGUMENTS = PARAMETERIZED_ELEMENT__ARGUMENTS;

	/**
	 * The number of structural features of the '<em>Block Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_PORT_FEATURE_COUNT = PARAMETERIZED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.BlockInputPortImpl <em>Block Input Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.BlockInputPortImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getBlockInputPort()
	 * @generated
	 */
	int BLOCK_INPUT_PORT = 39;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_INPUT_PORT__ARGUMENTS = BLOCK_PORT__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Input</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_INPUT_PORT__INPUT = BLOCK_PORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block Input Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_INPUT_PORT_FEATURE_COUNT = BLOCK_PORT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.BlockOutputPortImpl <em>Block Output Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.BlockOutputPortImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getBlockOutputPort()
	 * @generated
	 */
	int BLOCK_OUTPUT_PORT = 40;

	/**
	 * The feature id for the '<em><b>Output</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_OUTPUT_PORT__OUTPUT = OUTPUT_PORT__OUTPUT;

	/**
	 * The feature id for the '<em><b>Signal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_OUTPUT_PORT__SIGNAL = OUTPUT_PORT__SIGNAL;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_OUTPUT_PORT__ARGUMENTS = OUTPUT_PORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block Output Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_OUTPUT_PORT_FEATURE_COUNT = OUTPUT_PORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owning Fragment</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM__OWNING_FRAGMENT = COMPONENT__OWNING_FRAGMENT;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM__INPUTS = COMPONENT__INPUTS;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM__OUTPUTS = COMPONENT__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM__NAME = COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Provided Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM__PROVIDED_INTERFACE = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Subsystem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.SystemInterfaceImpl <em>System Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.SystemInterfaceImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getSystemInterface()
	 * @generated
	 */
	int SYSTEM_INTERFACE = 42;

	/**
	 * The feature id for the '<em><b>Inlets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INTERFACE__INLETS = 0;

	/**
	 * The feature id for the '<em><b>Outlets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INTERFACE__OUTLETS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INTERFACE__NAME = 2;

	/**
	 * The number of structural features of the '<em>System Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INTERFACE_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUTLET__DATA_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUTLET__NAME = 1;

	/**
	 * The number of structural features of the '<em>Inoutlet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUTLET_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INLET__DATA_TYPE = INOUTLET__DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INLET__NAME = INOUTLET__NAME;

	/**
	 * The number of structural features of the '<em>Inlet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INLET_FEATURE_COUNT = INOUTLET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTLET__DATA_TYPE = INOUTLET__DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTLET__NAME = INOUTLET__NAME;

	/**
	 * The number of structural features of the '<em>Outlet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTLET_FEATURE_COUNT = INOUTLET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Fragment</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_REALIZATION__OWNING_FRAGMENT = FRAGMENT_ELEMENT__OWNING_FRAGMENT;

	/**
	 * The feature id for the '<em><b>Realized Subsystem</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_REALIZATION__REALIZED_SUBSYSTEM = FRAGMENT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Realizing Fragment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_REALIZATION__REALIZING_FRAGMENT = FRAGMENT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Subsystem Realization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_REALIZATION_FEATURE_COUNT = FRAGMENT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owning Fragment</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUTPORT__OWNING_FRAGMENT = COMPONENT__OWNING_FRAGMENT;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUTPORT__INPUTS = COMPONENT__INPUTS;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUTPORT__OUTPUTS = COMPONENT__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUTPORT__NAME = COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUTPORT__DATA_TYPE = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Inoutport</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INOUTPORT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owning Fragment</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPORT__OWNING_FRAGMENT = INOUTPORT__OWNING_FRAGMENT;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPORT__INPUTS = INOUTPORT__INPUTS;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPORT__OUTPUTS = INOUTPORT__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPORT__NAME = INOUTPORT__NAME;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPORT__DATA_TYPE = INOUTPORT__DATA_TYPE;

	/**
	 * The number of structural features of the '<em>Inport</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPORT_FEATURE_COUNT = INOUTPORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Fragment</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPORT__OWNING_FRAGMENT = INOUTPORT__OWNING_FRAGMENT;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPORT__INPUTS = INOUTPORT__INPUTS;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPORT__OUTPUTS = INOUTPORT__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPORT__NAME = INOUTPORT__NAME;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPORT__DATA_TYPE = INOUTPORT__DATA_TYPE;

	/**
	 * The number of structural features of the '<em>Outport</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPORT_FEATURE_COUNT = INOUTPORT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.SubsystemInoutputImpl <em>Subsystem Inoutput</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.SubsystemInoutputImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getSubsystemInoutput()
	 * @generated
	 */
	int SUBSYSTEM_INOUTPUT = 50;

	/**
	 * The number of structural features of the '<em>Subsystem Inoutput</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_INOUTPUT_FEATURE_COUNT = INOUTPUT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.SubsystemInputImpl <em>Subsystem Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.SubsystemInputImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getSubsystemInput()
	 * @generated
	 */
	int SUBSYSTEM_INPUT = 51;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_INPUT__PORTS = INPUT__PORTS;

	/**
	 * The feature id for the '<em><b>Component</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_INPUT__COMPONENT = INPUT__COMPONENT;

	/**
	 * The feature id for the '<em><b>Inlet</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_INPUT__INLET = INPUT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Subsystem Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_INPUT_FEATURE_COUNT = INPUT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.SubsystemOutputImpl <em>Subsystem Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.SubsystemOutputImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getSubsystemOutput()
	 * @generated
	 */
	int SUBSYSTEM_OUTPUT = 52;

	/**
	 * The feature id for the '<em><b>Component</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_OUTPUT__COMPONENT = OUTPUT__COMPONENT;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_OUTPUT__PORTS = OUTPUT__PORTS;

	/**
	 * The feature id for the '<em><b>Outlet</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_OUTPUT__OUTLET = OUTPUT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Subsystem Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_OUTPUT_FEATURE_COUNT = OUTPUT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.BooleanDirectFeedthroughPolicyImpl <em>Boolean Direct Feedthrough Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.BooleanDirectFeedthroughPolicyImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getBooleanDirectFeedthroughPolicy()
	 * @generated
	 */
	int BOOLEAN_DIRECT_FEEDTHROUGH_POLICY = 53;

	/**
	 * The feature id for the '<em><b>Input Definition</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_DIRECT_FEEDTHROUGH_POLICY__INPUT_DEFINITION = DIRECT_FEEDTHROUGH_POLICY__INPUT_DEFINITION;

	/**
	 * The feature id for the '<em><b>Direct Feedthrough</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_DIRECT_FEEDTHROUGH_POLICY__DIRECT_FEEDTHROUGH = DIRECT_FEEDTHROUGH_POLICY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Direct Feedthrough Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_DIRECT_FEEDTHROUGH_POLICY_FEATURE_COUNT = DIRECT_FEEDTHROUGH_POLICY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.OpaqueDataTypeSpecificationImpl <em>Opaque Data Type Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.OpaqueDataTypeSpecificationImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getOpaqueDataTypeSpecification()
	 * @generated
	 */
	int OPAQUE_DATA_TYPE_SPECIFICATION = 54;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_DATA_TYPE_SPECIFICATION__DATA_TYPE = DATA_TYPE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Opaque Data Type Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_DATA_TYPE_SPECIFICATION_FEATURE_COUNT = DATA_TYPE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.OpaqueBehaviorSpecificationImpl <em>Opaque Behavior Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.OpaqueBehaviorSpecificationImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getOpaqueBehaviorSpecification()
	 * @generated
	 */
	int OPAQUE_BEHAVIOR_SPECIFICATION = 55;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_BEHAVIOR_SPECIFICATION__BEHAVIOR = BEHAVIOR_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Opaque Behavior Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_BEHAVIOR_SPECIFICATION_FEATURE_COUNT = BEHAVIOR_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.CompoundImpl <em>Compound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.CompoundImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getCompound()
	 * @generated
	 */
	int COMPOUND = 56;

	/**
	 * The feature id for the '<em><b>Owning Fragment</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__OWNING_FRAGMENT = FRAGMENT_ELEMENT__OWNING_FRAGMENT;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__MEMBERS = FRAGMENT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Compound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_FEATURE_COUNT = FRAGMENT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.CompoundMemberImpl <em>Compound Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.CompoundMemberImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getCompoundMember()
	 * @generated
	 */
	int COMPOUND_MEMBER = 57;

	/**
	 * The number of structural features of the '<em>Compound Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_MEMBER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.CompoundConnectorImpl <em>Compound Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.CompoundConnectorImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getCompoundConnector()
	 * @generated
	 */
	int COMPOUND_CONNECTOR = 58;

	/**
	 * The feature id for the '<em><b>Compound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_CONNECTOR__COMPOUND = CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Compound Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_CONNECTOR_FEATURE_COUNT = CONNECTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.CompoundInputConnectorImpl <em>Compound Input Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.CompoundInputConnectorImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getCompoundInputConnector()
	 * @generated
	 */
	int COMPOUND_INPUT_CONNECTOR = 59;

	/**
	 * The feature id for the '<em><b>Compound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_INPUT_CONNECTOR__COMPOUND = COMPOUND_CONNECTOR__COMPOUND;

	/**
	 * The number of structural features of the '<em>Compound Input Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_INPUT_CONNECTOR_FEATURE_COUNT = COMPOUND_CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.CompoundOutputConnectorImpl <em>Compound Output Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.CompoundOutputConnectorImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getCompoundOutputConnector()
	 * @generated
	 */
	int COMPOUND_OUTPUT_CONNECTOR = 60;

	/**
	 * The feature id for the '<em><b>Compound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_OUTPUT_CONNECTOR__COMPOUND = COMPOUND_CONNECTOR__COMPOUND;

	/**
	 * The number of structural features of the '<em>Compound Output Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_OUTPUT_CONNECTOR_FEATURE_COUNT = COMPOUND_CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.ConditionalCompoundImpl <em>Conditional Compound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.ConditionalCompoundImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getConditionalCompound()
	 * @generated
	 */
	int CONDITIONAL_COMPOUND = 61;

	/**
	 * The feature id for the '<em><b>Owning Fragment</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_COMPOUND__OWNING_FRAGMENT = COMPOUND__OWNING_FRAGMENT;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_COMPOUND__MEMBERS = COMPOUND__MEMBERS;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_COMPOUND__CONDITION = COMPOUND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Conditional Compound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_COMPOUND_FEATURE_COUNT = COMPOUND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.ConditionalCompoundConditionImpl <em>Conditional Compound Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.ConditionalCompoundConditionImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getConditionalCompoundCondition()
	 * @generated
	 */
	int CONDITIONAL_COMPOUND_CONDITION = 62;

	/**
	 * The feature id for the '<em><b>Compound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_COMPOUND_CONDITION__COMPOUND = COMPOUND_INPUT_CONNECTOR__COMPOUND;

	/**
	 * The number of structural features of the '<em>Conditional Compound Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_COMPOUND_CONDITION_FEATURE_COUNT = COMPOUND_INPUT_CONNECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dml.impl.JoinImpl <em>Join</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.impl.JoinImpl
	 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getJoin()
	 * @generated
	 */
	int JOIN = 63;

	/**
	 * The feature id for the '<em><b>Owning Fragment</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__OWNING_FRAGMENT = COMPONENT__OWNING_FRAGMENT;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__INPUTS = COMPONENT__INPUTS;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__OUTPUTS = COMPONENT__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__NAME = COMPONENT__NAME;

	/**
	 * The number of structural features of the '<em>Join</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.Fragment <em>Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fragment</em>'.
	 * @see org.eclipselabs.damos.dml.Fragment
	 * @generated
	 */
	EClass getFragment();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.dml.Fragment#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Components</em>'.
	 * @see org.eclipselabs.damos.dml.Fragment#getComponents()
	 * @see #getFragment()
	 * @generated
	 */
	EReference getFragment_Components();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dml.Fragment#getFragmentElements <em>Fragment Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fragment Elements</em>'.
	 * @see org.eclipselabs.damos.dml.Fragment#getFragmentElements()
	 * @see #getFragment()
	 * @generated
	 */
	EReference getFragment_FragmentElements();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.dml.Fragment#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connections</em>'.
	 * @see org.eclipselabs.damos.dml.Fragment#getConnections()
	 * @see #getFragment()
	 * @generated
	 */
	EReference getFragment_Connections();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dml.Fragment#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.eclipselabs.damos.dml.Fragment#getParent()
	 * @see #getFragment()
	 * @generated
	 */
	EReference getFragment_Parent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dml.Fragment#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.damos.dml.Fragment#getName()
	 * @see #getFragment()
	 * @generated
	 */
	EAttribute getFragment_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see org.eclipselabs.damos.dml.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dml.Component#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see org.eclipselabs.damos.dml.Component#getInputs()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Inputs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dml.Component#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outputs</em>'.
	 * @see org.eclipselabs.damos.dml.Component#getOutputs()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Outputs();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dml.Component#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.damos.dml.Component#getName()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.FragmentElement <em>Fragment Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fragment Element</em>'.
	 * @see org.eclipselabs.damos.dml.FragmentElement
	 * @generated
	 */
	EClass getFragmentElement();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.dml.FragmentElement#getOwningFragment <em>Owning Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Fragment</em>'.
	 * @see org.eclipselabs.damos.dml.FragmentElement#getOwningFragment()
	 * @see #getFragmentElement()
	 * @generated
	 */
	EReference getFragmentElement_OwningFragment();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.InputPort <em>Input Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Port</em>'.
	 * @see org.eclipselabs.damos.dml.InputPort
	 * @generated
	 */
	EClass getInputPort();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.dml.InputPort#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Input</em>'.
	 * @see org.eclipselabs.damos.dml.InputPort#getInput()
	 * @see #getInputPort()
	 * @generated
	 */
	EReference getInputPort_Input();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see org.eclipselabs.damos.dml.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see org.eclipselabs.damos.dml.Connection
	 * @generated
	 */
	EClass getConnection();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dml.Connection#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipselabs.damos.dml.Connection#getSource()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_Source();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dml.Connection#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipselabs.damos.dml.Connection#getTarget()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_Target();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dml.Connection#getSourcePort <em>Source Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Port</em>'.
	 * @see org.eclipselabs.damos.dml.Connection#getSourcePort()
	 * @see #getConnection()
	 * @generated
	 */
	@Deprecated
	EReference getConnection_SourcePort();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dml.Connection#getTargetPort <em>Target Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Port</em>'.
	 * @see org.eclipselabs.damos.dml.Connection#getTargetPort()
	 * @see #getConnection()
	 * @generated
	 */
	@Deprecated
	EReference getConnection_TargetPort();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.Connector <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector</em>'.
	 * @see org.eclipselabs.damos.dml.Connector
	 * @generated
	 */
	EClass getConnector();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.InputConnector <em>Input Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Connector</em>'.
	 * @see org.eclipselabs.damos.dml.InputConnector
	 * @generated
	 */
	EClass getInputConnector();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.OutputConnector <em>Output Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Connector</em>'.
	 * @see org.eclipselabs.damos.dml.OutputConnector
	 * @generated
	 */
	EClass getOutputConnector();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.OutputPort <em>Output Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Port</em>'.
	 * @see org.eclipselabs.damos.dml.OutputPort
	 * @generated
	 */
	EClass getOutputPort();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.dml.OutputPort#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Output</em>'.
	 * @see org.eclipselabs.damos.dml.OutputPort#getOutput()
	 * @see #getOutputPort()
	 * @generated
	 */
	EReference getOutputPort_Output();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dml.OutputPort#getSignal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Signal</em>'.
	 * @see org.eclipselabs.damos.dml.OutputPort#getSignal()
	 * @see #getOutputPort()
	 * @generated
	 */
	EReference getOutputPort_Signal();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.Output <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output</em>'.
	 * @see org.eclipselabs.damos.dml.Output
	 * @generated
	 */
	EClass getOutput();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.dml.Output#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Component</em>'.
	 * @see org.eclipselabs.damos.dml.Output#getComponent()
	 * @see #getOutput()
	 * @generated
	 */
	EReference getOutput_Component();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dml.Output#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ports</em>'.
	 * @see org.eclipselabs.damos.dml.Output#getPorts()
	 * @see #getOutput()
	 * @generated
	 */
	EReference getOutput_Ports();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.SignalSpecification <em>Signal Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Signal Specification</em>'.
	 * @see org.eclipselabs.damos.dml.SignalSpecification
	 * @generated
	 */
	EClass getSignalSpecification();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.Inoutput <em>Inoutput</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inoutput</em>'.
	 * @see org.eclipselabs.damos.dml.Inoutput
	 * @generated
	 */
	EClass getInoutput();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.Input <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input</em>'.
	 * @see org.eclipselabs.damos.dml.Input
	 * @generated
	 */
	EClass getInput();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dml.Input#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ports</em>'.
	 * @see org.eclipselabs.damos.dml.Input#getPorts()
	 * @see #getInput()
	 * @generated
	 */
	EReference getInput_Ports();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.dml.Input#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Component</em>'.
	 * @see org.eclipselabs.damos.dml.Input#getComponent()
	 * @see #getInput()
	 * @generated
	 */
	EReference getInput_Component();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.BlockInput <em>Block Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Input</em>'.
	 * @see org.eclipselabs.damos.dml.BlockInput
	 * @generated
	 */
	EClass getBlockInput();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dml.BlockInput#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see org.eclipselabs.damos.dml.BlockInput#getDefinition()
	 * @see #getBlockInput()
	 * @generated
	 */
	EReference getBlockInput_Definition();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.BlockInoutput <em>Block Inoutput</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Inoutput</em>'.
	 * @see org.eclipselabs.damos.dml.BlockInoutput
	 * @generated
	 */
	EClass getBlockInoutput();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.InputDefinition <em>Input Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Definition</em>'.
	 * @see org.eclipselabs.damos.dml.InputDefinition
	 * @generated
	 */
	EClass getInputDefinition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dml.InputDefinition#getDirectFeedthroughPolicy <em>Direct Feedthrough Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Direct Feedthrough Policy</em>'.
	 * @see org.eclipselabs.damos.dml.InputDefinition#getDirectFeedthroughPolicy()
	 * @see #getInputDefinition()
	 * @generated
	 */
	EReference getInputDefinition_DirectFeedthroughPolicy();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.InoutputDefinition <em>Inoutput Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inoutput Definition</em>'.
	 * @see org.eclipselabs.damos.dml.InoutputDefinition
	 * @generated
	 */
	EClass getInoutputDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dml.InoutputDefinition#getMinimumPortCount <em>Minimum Port Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum Port Count</em>'.
	 * @see org.eclipselabs.damos.dml.InoutputDefinition#getMinimumPortCount()
	 * @see #getInoutputDefinition()
	 * @generated
	 */
	EAttribute getInoutputDefinition_MinimumPortCount();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dml.InoutputDefinition#getMaximumPortCount <em>Maximum Port Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Port Count</em>'.
	 * @see org.eclipselabs.damos.dml.InoutputDefinition#getMaximumPortCount()
	 * @see #getInoutputDefinition()
	 * @generated
	 */
	EAttribute getInoutputDefinition_MaximumPortCount();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dml.InoutputDefinition#getDefaultPortCount <em>Default Port Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Port Count</em>'.
	 * @see org.eclipselabs.damos.dml.InoutputDefinition#getDefaultPortCount()
	 * @see #getInoutputDefinition()
	 * @generated
	 */
	EAttribute getInoutputDefinition_DefaultPortCount();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dml.InoutputDefinition#isManyPorts <em>Many Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Many Ports</em>'.
	 * @see org.eclipselabs.damos.dml.InoutputDefinition#isManyPorts()
	 * @see #getInoutputDefinition()
	 * @generated
	 */
	EAttribute getInoutputDefinition_ManyPorts();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dml.InoutputDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.damos.dml.InoutputDefinition#getName()
	 * @see #getInoutputDefinition()
	 * @generated
	 */
	EAttribute getInoutputDefinition_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dml.InoutputDefinition#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Type</em>'.
	 * @see org.eclipselabs.damos.dml.InoutputDefinition#getDataType()
	 * @see #getInoutputDefinition()
	 * @generated
	 */
	EReference getInoutputDefinition_DataType();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.OutputDefinition <em>Output Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Definition</em>'.
	 * @see org.eclipselabs.damos.dml.OutputDefinition
	 * @generated
	 */
	EClass getOutputDefinition();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.ParameterizedElement <em>Parameterized Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameterized Element</em>'.
	 * @see org.eclipselabs.damos.dml.ParameterizedElement
	 * @generated
	 */
	EClass getParameterizedElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dml.ParameterizedElement#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.eclipselabs.damos.dml.ParameterizedElement#getArguments()
	 * @see #getParameterizedElement()
	 * @generated
	 */
	EReference getParameterizedElement_Arguments();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.Argument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Argument</em>'.
	 * @see org.eclipselabs.damos.dml.Argument
	 * @generated
	 */
	EClass getArgument();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dml.Argument#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipselabs.damos.dml.Argument#getValue()
	 * @see #getArgument()
	 * @generated
	 */
	EReference getArgument_Value();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dml.Argument#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see org.eclipselabs.damos.dml.Argument#getParameter()
	 * @see #getArgument()
	 * @generated
	 */
	EReference getArgument_Parameter();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.ExpressionParameter <em>Expression Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Parameter</em>'.
	 * @see org.eclipselabs.damos.dml.ExpressionParameter
	 * @generated
	 */
	EClass getExpressionParameter();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dml.ExpressionParameter#getDefaultExpression <em>Default Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Expression</em>'.
	 * @see org.eclipselabs.damos.dml.ExpressionParameter#getDefaultExpression()
	 * @see #getExpressionParameter()
	 * @generated
	 */
	EReference getExpressionParameter_DefaultExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dml.ExpressionParameter#getPredefinedExpressions <em>Predefined Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Predefined Expressions</em>'.
	 * @see org.eclipselabs.damos.dml.ExpressionParameter#getPredefinedExpressions()
	 * @see #getExpressionParameter()
	 * @generated
	 */
	EReference getExpressionParameter_PredefinedExpressions();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dml.ExpressionParameter#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Type</em>'.
	 * @see org.eclipselabs.damos.dml.ExpressionParameter#getDataType()
	 * @see #getExpressionParameter()
	 * @generated
	 */
	EReference getExpressionParameter_DataType();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.ExpressionSpecification <em>Expression Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Specification</em>'.
	 * @see org.eclipselabs.damos.dml.ExpressionSpecification
	 * @generated
	 */
	EClass getExpressionSpecification();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dml.ExpressionSpecification#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see org.eclipselabs.damos.dml.ExpressionSpecification#getExpression()
	 * @see #getExpressionSpecification()
	 * @generated
	 */
	EAttribute getExpressionSpecification_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.PredefinedExpressionEntry <em>Predefined Expression Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predefined Expression Entry</em>'.
	 * @see org.eclipselabs.damos.dml.PredefinedExpressionEntry
	 * @generated
	 */
	EClass getPredefinedExpressionEntry();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dml.PredefinedExpressionEntry#getAlias <em>Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alias</em>'.
	 * @see org.eclipselabs.damos.dml.PredefinedExpressionEntry#getAlias()
	 * @see #getPredefinedExpressionEntry()
	 * @generated
	 */
	EAttribute getPredefinedExpressionEntry_Alias();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dml.PredefinedExpressionEntry#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipselabs.damos.dml.PredefinedExpressionEntry#getExpression()
	 * @see #getPredefinedExpressionEntry()
	 * @generated
	 */
	EReference getPredefinedExpressionEntry_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.DataTypeSpecification <em>Data Type Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type Specification</em>'.
	 * @see org.eclipselabs.damos.dml.DataTypeSpecification
	 * @generated
	 */
	EClass getDataTypeSpecification();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.ParameterableElement <em>Parameterable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameterable Element</em>'.
	 * @see org.eclipselabs.damos.dml.ParameterableElement
	 * @generated
	 */
	EClass getParameterableElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dml.ParameterableElement#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipselabs.damos.dml.ParameterableElement#getParameters()
	 * @see #getParameterableElement()
	 * @generated
	 */
	EReference getParameterableElement_Parameters();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.eclipselabs.damos.dml.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dml.Parameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.damos.dml.Parameter#getName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.ValueSpecification <em>Value Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Specification</em>'.
	 * @see org.eclipselabs.damos.dml.ValueSpecification
	 * @generated
	 */
	EClass getValueSpecification();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.DirectFeedthroughPolicy <em>Direct Feedthrough Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Direct Feedthrough Policy</em>'.
	 * @see org.eclipselabs.damos.dml.DirectFeedthroughPolicy
	 * @generated
	 */
	EClass getDirectFeedthroughPolicy();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.dml.DirectFeedthroughPolicy#getInputDefinition <em>Input Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Input Definition</em>'.
	 * @see org.eclipselabs.damos.dml.DirectFeedthroughPolicy#getInputDefinition()
	 * @see #getDirectFeedthroughPolicy()
	 * @generated
	 */
	EReference getDirectFeedthroughPolicy_InputDefinition();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.BlockOutput <em>Block Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Output</em>'.
	 * @see org.eclipselabs.damos.dml.BlockOutput
	 * @generated
	 */
	EClass getBlockOutput();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dml.BlockOutput#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see org.eclipselabs.damos.dml.BlockOutput#getDefinition()
	 * @see #getBlockOutput()
	 * @generated
	 */
	EReference getBlockOutput_Definition();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.BlockType <em>Block Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Type</em>'.
	 * @see org.eclipselabs.damos.dml.BlockType
	 * @generated
	 */
	EClass getBlockType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dml.BlockType#getInputDefinitions <em>Input Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Definitions</em>'.
	 * @see org.eclipselabs.damos.dml.BlockType#getInputDefinitions()
	 * @see #getBlockType()
	 * @generated
	 */
	EReference getBlockType_InputDefinitions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dml.BlockType#getOutputDefinitions <em>Output Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Definitions</em>'.
	 * @see org.eclipselabs.damos.dml.BlockType#getOutputDefinitions()
	 * @see #getBlockType()
	 * @generated
	 */
	EReference getBlockType_OutputDefinitions();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dml.BlockType#getBehavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Behavior</em>'.
	 * @see org.eclipselabs.damos.dml.BlockType#getBehavior()
	 * @see #getBlockType()
	 * @generated
	 */
	EReference getBlockType_Behavior();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.QualifiedElement <em>Qualified Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Qualified Element</em>'.
	 * @see org.eclipselabs.damos.dml.QualifiedElement
	 * @generated
	 */
	EClass getQualifiedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dml.QualifiedElement#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see org.eclipselabs.damos.dml.QualifiedElement#getQualifiedName()
	 * @see #getQualifiedElement()
	 * @generated
	 */
	EAttribute getQualifiedElement_QualifiedName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dml.QualifiedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.damos.dml.QualifiedElement#getName()
	 * @see #getQualifiedElement()
	 * @generated
	 */
	EAttribute getQualifiedElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dml.QualifiedElement#getQualifier <em>Qualifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualifier</em>'.
	 * @see org.eclipselabs.damos.dml.QualifiedElement#getQualifier()
	 * @see #getQualifiedElement()
	 * @generated
	 */
	EAttribute getQualifiedElement_Qualifier();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.CategorizedElement <em>Categorized Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Categorized Element</em>'.
	 * @see org.eclipselabs.damos.dml.CategorizedElement
	 * @generated
	 */
	EClass getCategorizedElement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.dml.CategorizedElement#getBelongingCategories <em>Belonging Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Belonging Categories</em>'.
	 * @see org.eclipselabs.damos.dml.CategorizedElement#getBelongingCategories()
	 * @see #getCategorizedElement()
	 * @generated
	 */
	EReference getCategorizedElement_BelongingCategories();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.Category <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category</em>'.
	 * @see org.eclipselabs.damos.dml.Category
	 * @generated
	 */
	EClass getCategory();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.BehaviorSpecification <em>Behavior Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Specification</em>'.
	 * @see org.eclipselabs.damos.dml.BehaviorSpecification
	 * @generated
	 */
	EClass getBehaviorSpecification();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see org.eclipselabs.damos.dml.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see org.eclipselabs.damos.dml.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.Block <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block</em>'.
	 * @see org.eclipselabs.damos.dml.Block
	 * @generated
	 */
	EClass getBlock();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dml.Block#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipselabs.damos.dml.Block#getType()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.BlockPort <em>Block Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Port</em>'.
	 * @see org.eclipselabs.damos.dml.BlockPort
	 * @generated
	 */
	EClass getBlockPort();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.BlockInputPort <em>Block Input Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Input Port</em>'.
	 * @see org.eclipselabs.damos.dml.BlockInputPort
	 * @generated
	 */
	EClass getBlockInputPort();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.BlockOutputPort <em>Block Output Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Output Port</em>'.
	 * @see org.eclipselabs.damos.dml.BlockOutputPort
	 * @generated
	 */
	EClass getBlockOutputPort();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.Subsystem <em>Subsystem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subsystem</em>'.
	 * @see org.eclipselabs.damos.dml.Subsystem
	 * @generated
	 */
	EClass getSubsystem();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dml.Subsystem#getProvidedInterface <em>Provided Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Provided Interface</em>'.
	 * @see org.eclipselabs.damos.dml.Subsystem#getProvidedInterface()
	 * @see #getSubsystem()
	 * @generated
	 */
	EReference getSubsystem_ProvidedInterface();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.SystemInterface <em>System Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Interface</em>'.
	 * @see org.eclipselabs.damos.dml.SystemInterface
	 * @generated
	 */
	EClass getSystemInterface();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dml.SystemInterface#getInlets <em>Inlets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inlets</em>'.
	 * @see org.eclipselabs.damos.dml.SystemInterface#getInlets()
	 * @see #getSystemInterface()
	 * @generated
	 */
	EReference getSystemInterface_Inlets();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dml.SystemInterface#getOutlets <em>Outlets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outlets</em>'.
	 * @see org.eclipselabs.damos.dml.SystemInterface#getOutlets()
	 * @see #getSystemInterface()
	 * @generated
	 */
	EReference getSystemInterface_Outlets();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dml.SystemInterface#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.damos.dml.SystemInterface#getName()
	 * @see #getSystemInterface()
	 * @generated
	 */
	EAttribute getSystemInterface_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.Inlet <em>Inlet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inlet</em>'.
	 * @see org.eclipselabs.damos.dml.Inlet
	 * @generated
	 */
	EClass getInlet();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.Inoutlet <em>Inoutlet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inoutlet</em>'.
	 * @see org.eclipselabs.damos.dml.Inoutlet
	 * @generated
	 */
	EClass getInoutlet();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dml.Inoutlet#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Type</em>'.
	 * @see org.eclipselabs.damos.dml.Inoutlet#getDataType()
	 * @see #getInoutlet()
	 * @generated
	 */
	EReference getInoutlet_DataType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dml.Inoutlet#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.damos.dml.Inoutlet#getName()
	 * @see #getInoutlet()
	 * @generated
	 */
	EAttribute getInoutlet_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.Outlet <em>Outlet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Outlet</em>'.
	 * @see org.eclipselabs.damos.dml.Outlet
	 * @generated
	 */
	EClass getOutlet();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.Inport <em>Inport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inport</em>'.
	 * @see org.eclipselabs.damos.dml.Inport
	 * @generated
	 */
	EClass getInport();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.Inoutport <em>Inoutport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inoutport</em>'.
	 * @see org.eclipselabs.damos.dml.Inoutport
	 * @generated
	 */
	EClass getInoutport();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dml.Inoutport#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Type</em>'.
	 * @see org.eclipselabs.damos.dml.Inoutport#getDataType()
	 * @see #getInoutport()
	 * @generated
	 */
	EReference getInoutport_DataType();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.Outport <em>Outport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Outport</em>'.
	 * @see org.eclipselabs.damos.dml.Outport
	 * @generated
	 */
	EClass getOutport();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.SubsystemInoutput <em>Subsystem Inoutput</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subsystem Inoutput</em>'.
	 * @see org.eclipselabs.damos.dml.SubsystemInoutput
	 * @generated
	 */
	EClass getSubsystemInoutput();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.SubsystemInput <em>Subsystem Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subsystem Input</em>'.
	 * @see org.eclipselabs.damos.dml.SubsystemInput
	 * @generated
	 */
	EClass getSubsystemInput();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dml.SubsystemInput#getInlet <em>Inlet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inlet</em>'.
	 * @see org.eclipselabs.damos.dml.SubsystemInput#getInlet()
	 * @see #getSubsystemInput()
	 * @generated
	 */
	EReference getSubsystemInput_Inlet();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.SubsystemOutput <em>Subsystem Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subsystem Output</em>'.
	 * @see org.eclipselabs.damos.dml.SubsystemOutput
	 * @generated
	 */
	EClass getSubsystemOutput();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dml.SubsystemOutput#getOutlet <em>Outlet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outlet</em>'.
	 * @see org.eclipselabs.damos.dml.SubsystemOutput#getOutlet()
	 * @see #getSubsystemOutput()
	 * @generated
	 */
	EReference getSubsystemOutput_Outlet();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.SubsystemRealization <em>Subsystem Realization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subsystem Realization</em>'.
	 * @see org.eclipselabs.damos.dml.SubsystemRealization
	 * @generated
	 */
	EClass getSubsystemRealization();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dml.SubsystemRealization#getRealizedSubsystem <em>Realized Subsystem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Realized Subsystem</em>'.
	 * @see org.eclipselabs.damos.dml.SubsystemRealization#getRealizedSubsystem()
	 * @see #getSubsystemRealization()
	 * @generated
	 */
	EReference getSubsystemRealization_RealizedSubsystem();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dml.SubsystemRealization#getRealizingFragment <em>Realizing Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Realizing Fragment</em>'.
	 * @see org.eclipselabs.damos.dml.SubsystemRealization#getRealizingFragment()
	 * @see #getSubsystemRealization()
	 * @generated
	 */
	EReference getSubsystemRealization_RealizingFragment();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.BooleanDirectFeedthroughPolicy <em>Boolean Direct Feedthrough Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Direct Feedthrough Policy</em>'.
	 * @see org.eclipselabs.damos.dml.BooleanDirectFeedthroughPolicy
	 * @generated
	 */
	EClass getBooleanDirectFeedthroughPolicy();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dml.BooleanDirectFeedthroughPolicy#isDirectFeedthrough <em>Direct Feedthrough</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direct Feedthrough</em>'.
	 * @see org.eclipselabs.damos.dml.BooleanDirectFeedthroughPolicy#isDirectFeedthrough()
	 * @see #getBooleanDirectFeedthroughPolicy()
	 * @generated
	 */
	EAttribute getBooleanDirectFeedthroughPolicy_DirectFeedthrough();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.OpaqueDataTypeSpecification <em>Opaque Data Type Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Opaque Data Type Specification</em>'.
	 * @see org.eclipselabs.damos.dml.OpaqueDataTypeSpecification
	 * @generated
	 */
	EClass getOpaqueDataTypeSpecification();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dml.OpaqueDataTypeSpecification#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Type</em>'.
	 * @see org.eclipselabs.damos.dml.OpaqueDataTypeSpecification#getDataType()
	 * @see #getOpaqueDataTypeSpecification()
	 * @generated
	 */
	EAttribute getOpaqueDataTypeSpecification_DataType();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.OpaqueBehaviorSpecification <em>Opaque Behavior Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Opaque Behavior Specification</em>'.
	 * @see org.eclipselabs.damos.dml.OpaqueBehaviorSpecification
	 * @generated
	 */
	EClass getOpaqueBehaviorSpecification();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dml.OpaqueBehaviorSpecification#getBehavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Behavior</em>'.
	 * @see org.eclipselabs.damos.dml.OpaqueBehaviorSpecification#getBehavior()
	 * @see #getOpaqueBehaviorSpecification()
	 * @generated
	 */
	EAttribute getOpaqueBehaviorSpecification_Behavior();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.Compound <em>Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compound</em>'.
	 * @see org.eclipselabs.damos.dml.Compound
	 * @generated
	 */
	EClass getCompound();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dml.Compound#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Members</em>'.
	 * @see org.eclipselabs.damos.dml.Compound#getMembers()
	 * @see #getCompound()
	 * @generated
	 */
	EReference getCompound_Members();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.CompoundMember <em>Compound Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compound Member</em>'.
	 * @see org.eclipselabs.damos.dml.CompoundMember
	 * @generated
	 */
	EClass getCompoundMember();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.CompoundConnector <em>Compound Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compound Connector</em>'.
	 * @see org.eclipselabs.damos.dml.CompoundConnector
	 * @generated
	 */
	EClass getCompoundConnector();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dml.CompoundConnector#getCompound <em>Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Compound</em>'.
	 * @see org.eclipselabs.damos.dml.CompoundConnector#getCompound()
	 * @see #getCompoundConnector()
	 * @generated
	 */
	EReference getCompoundConnector_Compound();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.CompoundInputConnector <em>Compound Input Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compound Input Connector</em>'.
	 * @see org.eclipselabs.damos.dml.CompoundInputConnector
	 * @generated
	 */
	EClass getCompoundInputConnector();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.CompoundOutputConnector <em>Compound Output Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compound Output Connector</em>'.
	 * @see org.eclipselabs.damos.dml.CompoundOutputConnector
	 * @generated
	 */
	EClass getCompoundOutputConnector();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.ConditionalCompound <em>Conditional Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditional Compound</em>'.
	 * @see org.eclipselabs.damos.dml.ConditionalCompound
	 * @generated
	 */
	EClass getConditionalCompound();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dml.ConditionalCompound#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipselabs.damos.dml.ConditionalCompound#getCondition()
	 * @see #getConditionalCompound()
	 * @generated
	 */
	EReference getConditionalCompound_Condition();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.ConditionalCompoundCondition <em>Conditional Compound Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditional Compound Condition</em>'.
	 * @see org.eclipselabs.damos.dml.ConditionalCompoundCondition
	 * @generated
	 */
	EClass getConditionalCompoundCondition();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dml.Join <em>Join</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Join</em>'.
	 * @see org.eclipselabs.damos.dml.Join
	 * @generated
	 */
	EClass getJoin();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DMLFactory getDMLFactory();

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
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.FragmentImpl <em>Fragment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.FragmentImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getFragment()
		 * @generated
		 */
		EClass FRAGMENT = eINSTANCE.getFragment();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FRAGMENT__COMPONENTS = eINSTANCE.getFragment_Components();

		/**
		 * The meta object literal for the '<em><b>Fragment Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FRAGMENT__FRAGMENT_ELEMENTS = eINSTANCE.getFragment_FragmentElements();

		/**
		 * The meta object literal for the '<em><b>Connections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FRAGMENT__CONNECTIONS = eINSTANCE.getFragment_Connections();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FRAGMENT__PARENT = eINSTANCE.getFragment_Parent();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FRAGMENT__NAME = eINSTANCE.getFragment_Name();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.ComponentImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__INPUTS = eINSTANCE.getComponent_Inputs();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__OUTPUTS = eINSTANCE.getComponent_Outputs();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__NAME = eINSTANCE.getComponent_Name();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.FragmentElementImpl <em>Fragment Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.FragmentElementImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getFragmentElement()
		 * @generated
		 */
		EClass FRAGMENT_ELEMENT = eINSTANCE.getFragmentElement();

		/**
		 * The meta object literal for the '<em><b>Owning Fragment</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FRAGMENT_ELEMENT__OWNING_FRAGMENT = eINSTANCE.getFragmentElement_OwningFragment();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.InputPortImpl <em>Input Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.InputPortImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getInputPort()
		 * @generated
		 */
		EClass INPUT_PORT = eINSTANCE.getInputPort();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_PORT__INPUT = eINSTANCE.getInputPort_Input();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.PortImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.ConnectionImpl <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.ConnectionImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getConnection()
		 * @generated
		 */
		EClass CONNECTION = eINSTANCE.getConnection();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__SOURCE = eINSTANCE.getConnection_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__TARGET = eINSTANCE.getConnection_Target();

		/**
		 * The meta object literal for the '<em><b>Source Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Deprecated
		EReference CONNECTION__SOURCE_PORT = eINSTANCE.getConnection_SourcePort();

		/**
		 * The meta object literal for the '<em><b>Target Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Deprecated
		EReference CONNECTION__TARGET_PORT = eINSTANCE.getConnection_TargetPort();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.ConnectorImpl <em>Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.ConnectorImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getConnector()
		 * @generated
		 */
		EClass CONNECTOR = eINSTANCE.getConnector();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.InputConnectorImpl <em>Input Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.InputConnectorImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getInputConnector()
		 * @generated
		 */
		EClass INPUT_CONNECTOR = eINSTANCE.getInputConnector();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.OutputConnectorImpl <em>Output Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.OutputConnectorImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getOutputConnector()
		 * @generated
		 */
		EClass OUTPUT_CONNECTOR = eINSTANCE.getOutputConnector();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.OutputPortImpl <em>Output Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.OutputPortImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getOutputPort()
		 * @generated
		 */
		EClass OUTPUT_PORT = eINSTANCE.getOutputPort();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_PORT__OUTPUT = eINSTANCE.getOutputPort_Output();

		/**
		 * The meta object literal for the '<em><b>Signal</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_PORT__SIGNAL = eINSTANCE.getOutputPort_Signal();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.OutputImpl <em>Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.OutputImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getOutput()
		 * @generated
		 */
		EClass OUTPUT = eINSTANCE.getOutput();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT__COMPONENT = eINSTANCE.getOutput_Component();

		/**
		 * The meta object literal for the '<em><b>Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT__PORTS = eINSTANCE.getOutput_Ports();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.SignalSpecificationImpl <em>Signal Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.SignalSpecificationImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getSignalSpecification()
		 * @generated
		 */
		EClass SIGNAL_SPECIFICATION = eINSTANCE.getSignalSpecification();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.InoutputImpl <em>Inoutput</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.InoutputImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getInoutput()
		 * @generated
		 */
		EClass INOUTPUT = eINSTANCE.getInoutput();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.InputImpl <em>Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.InputImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getInput()
		 * @generated
		 */
		EClass INPUT = eINSTANCE.getInput();

		/**
		 * The meta object literal for the '<em><b>Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT__PORTS = eINSTANCE.getInput_Ports();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT__COMPONENT = eINSTANCE.getInput_Component();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.BlockInputImpl <em>Block Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.BlockInputImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getBlockInput()
		 * @generated
		 */
		EClass BLOCK_INPUT = eINSTANCE.getBlockInput();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_INPUT__DEFINITION = eINSTANCE.getBlockInput_Definition();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.BlockInoutputImpl <em>Block Inoutput</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.BlockInoutputImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getBlockInoutput()
		 * @generated
		 */
		EClass BLOCK_INOUTPUT = eINSTANCE.getBlockInoutput();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.InputDefinitionImpl <em>Input Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.InputDefinitionImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getInputDefinition()
		 * @generated
		 */
		EClass INPUT_DEFINITION = eINSTANCE.getInputDefinition();

		/**
		 * The meta object literal for the '<em><b>Direct Feedthrough Policy</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_DEFINITION__DIRECT_FEEDTHROUGH_POLICY = eINSTANCE.getInputDefinition_DirectFeedthroughPolicy();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.InoutputDefinitionImpl <em>Inoutput Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.InoutputDefinitionImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getInoutputDefinition()
		 * @generated
		 */
		EClass INOUTPUT_DEFINITION = eINSTANCE.getInoutputDefinition();

		/**
		 * The meta object literal for the '<em><b>Minimum Port Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INOUTPUT_DEFINITION__MINIMUM_PORT_COUNT = eINSTANCE.getInoutputDefinition_MinimumPortCount();

		/**
		 * The meta object literal for the '<em><b>Maximum Port Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INOUTPUT_DEFINITION__MAXIMUM_PORT_COUNT = eINSTANCE.getInoutputDefinition_MaximumPortCount();

		/**
		 * The meta object literal for the '<em><b>Default Port Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INOUTPUT_DEFINITION__DEFAULT_PORT_COUNT = eINSTANCE.getInoutputDefinition_DefaultPortCount();

		/**
		 * The meta object literal for the '<em><b>Many Ports</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INOUTPUT_DEFINITION__MANY_PORTS = eINSTANCE.getInoutputDefinition_ManyPorts();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INOUTPUT_DEFINITION__NAME = eINSTANCE.getInoutputDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INOUTPUT_DEFINITION__DATA_TYPE = eINSTANCE.getInoutputDefinition_DataType();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.OutputDefinitionImpl <em>Output Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.OutputDefinitionImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getOutputDefinition()
		 * @generated
		 */
		EClass OUTPUT_DEFINITION = eINSTANCE.getOutputDefinition();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.ParameterizedElementImpl <em>Parameterized Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.ParameterizedElementImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getParameterizedElement()
		 * @generated
		 */
		EClass PARAMETERIZED_ELEMENT = eINSTANCE.getParameterizedElement();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETERIZED_ELEMENT__ARGUMENTS = eINSTANCE.getParameterizedElement_Arguments();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.ArgumentImpl <em>Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.ArgumentImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getArgument()
		 * @generated
		 */
		EClass ARGUMENT = eINSTANCE.getArgument();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARGUMENT__VALUE = eINSTANCE.getArgument_Value();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARGUMENT__PARAMETER = eINSTANCE.getArgument_Parameter();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.ExpressionParameterImpl <em>Expression Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.ExpressionParameterImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getExpressionParameter()
		 * @generated
		 */
		EClass EXPRESSION_PARAMETER = eINSTANCE.getExpressionParameter();

		/**
		 * The meta object literal for the '<em><b>Default Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_PARAMETER__DEFAULT_EXPRESSION = eINSTANCE.getExpressionParameter_DefaultExpression();

		/**
		 * The meta object literal for the '<em><b>Predefined Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_PARAMETER__PREDEFINED_EXPRESSIONS = eINSTANCE.getExpressionParameter_PredefinedExpressions();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_PARAMETER__DATA_TYPE = eINSTANCE.getExpressionParameter_DataType();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.ExpressionSpecificationImpl <em>Expression Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.ExpressionSpecificationImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getExpressionSpecification()
		 * @generated
		 */
		EClass EXPRESSION_SPECIFICATION = eINSTANCE.getExpressionSpecification();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION_SPECIFICATION__EXPRESSION = eINSTANCE.getExpressionSpecification_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.PredefinedExpressionEntryImpl <em>Predefined Expression Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.PredefinedExpressionEntryImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getPredefinedExpressionEntry()
		 * @generated
		 */
		EClass PREDEFINED_EXPRESSION_ENTRY = eINSTANCE.getPredefinedExpressionEntry();

		/**
		 * The meta object literal for the '<em><b>Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREDEFINED_EXPRESSION_ENTRY__ALIAS = eINSTANCE.getPredefinedExpressionEntry_Alias();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDEFINED_EXPRESSION_ENTRY__EXPRESSION = eINSTANCE.getPredefinedExpressionEntry_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.DataTypeSpecificationImpl <em>Data Type Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.DataTypeSpecificationImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getDataTypeSpecification()
		 * @generated
		 */
		EClass DATA_TYPE_SPECIFICATION = eINSTANCE.getDataTypeSpecification();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.ParameterableElementImpl <em>Parameterable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.ParameterableElementImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getParameterableElement()
		 * @generated
		 */
		EClass PARAMETERABLE_ELEMENT = eINSTANCE.getParameterableElement();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETERABLE_ELEMENT__PARAMETERS = eINSTANCE.getParameterableElement_Parameters();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.ParameterImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.ValueSpecificationImpl <em>Value Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.ValueSpecificationImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getValueSpecification()
		 * @generated
		 */
		EClass VALUE_SPECIFICATION = eINSTANCE.getValueSpecification();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.DirectFeedthroughPolicyImpl <em>Direct Feedthrough Policy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.DirectFeedthroughPolicyImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getDirectFeedthroughPolicy()
		 * @generated
		 */
		EClass DIRECT_FEEDTHROUGH_POLICY = eINSTANCE.getDirectFeedthroughPolicy();

		/**
		 * The meta object literal for the '<em><b>Input Definition</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECT_FEEDTHROUGH_POLICY__INPUT_DEFINITION = eINSTANCE.getDirectFeedthroughPolicy_InputDefinition();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.BlockOutputImpl <em>Block Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.BlockOutputImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getBlockOutput()
		 * @generated
		 */
		EClass BLOCK_OUTPUT = eINSTANCE.getBlockOutput();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_OUTPUT__DEFINITION = eINSTANCE.getBlockOutput_Definition();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.BlockTypeImpl <em>Block Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.BlockTypeImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getBlockType()
		 * @generated
		 */
		EClass BLOCK_TYPE = eINSTANCE.getBlockType();

		/**
		 * The meta object literal for the '<em><b>Input Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_TYPE__INPUT_DEFINITIONS = eINSTANCE.getBlockType_InputDefinitions();

		/**
		 * The meta object literal for the '<em><b>Output Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_TYPE__OUTPUT_DEFINITIONS = eINSTANCE.getBlockType_OutputDefinitions();

		/**
		 * The meta object literal for the '<em><b>Behavior</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_TYPE__BEHAVIOR = eINSTANCE.getBlockType_Behavior();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.QualifiedElementImpl <em>Qualified Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.QualifiedElementImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getQualifiedElement()
		 * @generated
		 */
		EClass QUALIFIED_ELEMENT = eINSTANCE.getQualifiedElement();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUALIFIED_ELEMENT__QUALIFIED_NAME = eINSTANCE.getQualifiedElement_QualifiedName();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUALIFIED_ELEMENT__NAME = eINSTANCE.getQualifiedElement_Name();

		/**
		 * The meta object literal for the '<em><b>Qualifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUALIFIED_ELEMENT__QUALIFIER = eINSTANCE.getQualifiedElement_Qualifier();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.CategorizedElementImpl <em>Categorized Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.CategorizedElementImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getCategorizedElement()
		 * @generated
		 */
		EClass CATEGORIZED_ELEMENT = eINSTANCE.getCategorizedElement();

		/**
		 * The meta object literal for the '<em><b>Belonging Categories</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATEGORIZED_ELEMENT__BELONGING_CATEGORIES = eINSTANCE.getCategorizedElement_BelongingCategories();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.CategoryImpl <em>Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.CategoryImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getCategory()
		 * @generated
		 */
		EClass CATEGORY = eINSTANCE.getCategory();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.BehaviorSpecificationImpl <em>Behavior Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.BehaviorSpecificationImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getBehaviorSpecification()
		 * @generated
		 */
		EClass BEHAVIOR_SPECIFICATION = eINSTANCE.getBehaviorSpecification();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.ModelImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.SystemImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.BlockImpl <em>Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.BlockImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getBlock()
		 * @generated
		 */
		EClass BLOCK = eINSTANCE.getBlock();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__TYPE = eINSTANCE.getBlock_Type();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.BlockPortImpl <em>Block Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.BlockPortImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getBlockPort()
		 * @generated
		 */
		EClass BLOCK_PORT = eINSTANCE.getBlockPort();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.BlockInputPortImpl <em>Block Input Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.BlockInputPortImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getBlockInputPort()
		 * @generated
		 */
		EClass BLOCK_INPUT_PORT = eINSTANCE.getBlockInputPort();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.BlockOutputPortImpl <em>Block Output Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.BlockOutputPortImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getBlockOutputPort()
		 * @generated
		 */
		EClass BLOCK_OUTPUT_PORT = eINSTANCE.getBlockOutputPort();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.SubsystemImpl <em>Subsystem</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.SubsystemImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getSubsystem()
		 * @generated
		 */
		EClass SUBSYSTEM = eINSTANCE.getSubsystem();

		/**
		 * The meta object literal for the '<em><b>Provided Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSYSTEM__PROVIDED_INTERFACE = eINSTANCE.getSubsystem_ProvidedInterface();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.SystemInterfaceImpl <em>System Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.SystemInterfaceImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getSystemInterface()
		 * @generated
		 */
		EClass SYSTEM_INTERFACE = eINSTANCE.getSystemInterface();

		/**
		 * The meta object literal for the '<em><b>Inlets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_INTERFACE__INLETS = eINSTANCE.getSystemInterface_Inlets();

		/**
		 * The meta object literal for the '<em><b>Outlets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_INTERFACE__OUTLETS = eINSTANCE.getSystemInterface_Outlets();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_INTERFACE__NAME = eINSTANCE.getSystemInterface_Name();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.InletImpl <em>Inlet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.InletImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getInlet()
		 * @generated
		 */
		EClass INLET = eINSTANCE.getInlet();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.InoutletImpl <em>Inoutlet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.InoutletImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getInoutlet()
		 * @generated
		 */
		EClass INOUTLET = eINSTANCE.getInoutlet();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INOUTLET__DATA_TYPE = eINSTANCE.getInoutlet_DataType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INOUTLET__NAME = eINSTANCE.getInoutlet_Name();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.OutletImpl <em>Outlet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.OutletImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getOutlet()
		 * @generated
		 */
		EClass OUTLET = eINSTANCE.getOutlet();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.InportImpl <em>Inport</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.InportImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getInport()
		 * @generated
		 */
		EClass INPORT = eINSTANCE.getInport();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.InoutportImpl <em>Inoutport</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.InoutportImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getInoutport()
		 * @generated
		 */
		EClass INOUTPORT = eINSTANCE.getInoutport();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INOUTPORT__DATA_TYPE = eINSTANCE.getInoutport_DataType();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.OutportImpl <em>Outport</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.OutportImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getOutport()
		 * @generated
		 */
		EClass OUTPORT = eINSTANCE.getOutport();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.SubsystemInoutputImpl <em>Subsystem Inoutput</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.SubsystemInoutputImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getSubsystemInoutput()
		 * @generated
		 */
		EClass SUBSYSTEM_INOUTPUT = eINSTANCE.getSubsystemInoutput();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.SubsystemInputImpl <em>Subsystem Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.SubsystemInputImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getSubsystemInput()
		 * @generated
		 */
		EClass SUBSYSTEM_INPUT = eINSTANCE.getSubsystemInput();

		/**
		 * The meta object literal for the '<em><b>Inlet</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSYSTEM_INPUT__INLET = eINSTANCE.getSubsystemInput_Inlet();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.SubsystemOutputImpl <em>Subsystem Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.SubsystemOutputImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getSubsystemOutput()
		 * @generated
		 */
		EClass SUBSYSTEM_OUTPUT = eINSTANCE.getSubsystemOutput();

		/**
		 * The meta object literal for the '<em><b>Outlet</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSYSTEM_OUTPUT__OUTLET = eINSTANCE.getSubsystemOutput_Outlet();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.SubsystemRealizationImpl <em>Subsystem Realization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.SubsystemRealizationImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getSubsystemRealization()
		 * @generated
		 */
		EClass SUBSYSTEM_REALIZATION = eINSTANCE.getSubsystemRealization();

		/**
		 * The meta object literal for the '<em><b>Realized Subsystem</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSYSTEM_REALIZATION__REALIZED_SUBSYSTEM = eINSTANCE.getSubsystemRealization_RealizedSubsystem();

		/**
		 * The meta object literal for the '<em><b>Realizing Fragment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSYSTEM_REALIZATION__REALIZING_FRAGMENT = eINSTANCE.getSubsystemRealization_RealizingFragment();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.BooleanDirectFeedthroughPolicyImpl <em>Boolean Direct Feedthrough Policy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.BooleanDirectFeedthroughPolicyImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getBooleanDirectFeedthroughPolicy()
		 * @generated
		 */
		EClass BOOLEAN_DIRECT_FEEDTHROUGH_POLICY = eINSTANCE.getBooleanDirectFeedthroughPolicy();

		/**
		 * The meta object literal for the '<em><b>Direct Feedthrough</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_DIRECT_FEEDTHROUGH_POLICY__DIRECT_FEEDTHROUGH = eINSTANCE.getBooleanDirectFeedthroughPolicy_DirectFeedthrough();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.OpaqueDataTypeSpecificationImpl <em>Opaque Data Type Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.OpaqueDataTypeSpecificationImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getOpaqueDataTypeSpecification()
		 * @generated
		 */
		EClass OPAQUE_DATA_TYPE_SPECIFICATION = eINSTANCE.getOpaqueDataTypeSpecification();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPAQUE_DATA_TYPE_SPECIFICATION__DATA_TYPE = eINSTANCE.getOpaqueDataTypeSpecification_DataType();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.OpaqueBehaviorSpecificationImpl <em>Opaque Behavior Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.OpaqueBehaviorSpecificationImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getOpaqueBehaviorSpecification()
		 * @generated
		 */
		EClass OPAQUE_BEHAVIOR_SPECIFICATION = eINSTANCE.getOpaqueBehaviorSpecification();

		/**
		 * The meta object literal for the '<em><b>Behavior</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPAQUE_BEHAVIOR_SPECIFICATION__BEHAVIOR = eINSTANCE.getOpaqueBehaviorSpecification_Behavior();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.CompoundImpl <em>Compound</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.CompoundImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getCompound()
		 * @generated
		 */
		EClass COMPOUND = eINSTANCE.getCompound();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOUND__MEMBERS = eINSTANCE.getCompound_Members();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.CompoundMemberImpl <em>Compound Member</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.CompoundMemberImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getCompoundMember()
		 * @generated
		 */
		EClass COMPOUND_MEMBER = eINSTANCE.getCompoundMember();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.CompoundConnectorImpl <em>Compound Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.CompoundConnectorImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getCompoundConnector()
		 * @generated
		 */
		EClass COMPOUND_CONNECTOR = eINSTANCE.getCompoundConnector();

		/**
		 * The meta object literal for the '<em><b>Compound</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOUND_CONNECTOR__COMPOUND = eINSTANCE.getCompoundConnector_Compound();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.CompoundInputConnectorImpl <em>Compound Input Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.CompoundInputConnectorImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getCompoundInputConnector()
		 * @generated
		 */
		EClass COMPOUND_INPUT_CONNECTOR = eINSTANCE.getCompoundInputConnector();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.CompoundOutputConnectorImpl <em>Compound Output Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.CompoundOutputConnectorImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getCompoundOutputConnector()
		 * @generated
		 */
		EClass COMPOUND_OUTPUT_CONNECTOR = eINSTANCE.getCompoundOutputConnector();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.ConditionalCompoundImpl <em>Conditional Compound</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.ConditionalCompoundImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getConditionalCompound()
		 * @generated
		 */
		EClass CONDITIONAL_COMPOUND = eINSTANCE.getConditionalCompound();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_COMPOUND__CONDITION = eINSTANCE.getConditionalCompound_Condition();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.ConditionalCompoundConditionImpl <em>Conditional Compound Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.ConditionalCompoundConditionImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getConditionalCompoundCondition()
		 * @generated
		 */
		EClass CONDITIONAL_COMPOUND_CONDITION = eINSTANCE.getConditionalCompoundCondition();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dml.impl.JoinImpl <em>Join</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.impl.JoinImpl
		 * @see org.eclipselabs.damos.dml.impl.DMLPackageImpl#getJoin()
		 * @generated
		 */
		EClass JOIN = eINSTANCE.getJoin();

	}

} //DMLPackage
