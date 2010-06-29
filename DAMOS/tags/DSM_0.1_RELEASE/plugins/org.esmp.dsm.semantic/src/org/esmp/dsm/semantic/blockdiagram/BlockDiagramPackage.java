/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramFactory
 * @model kind="package"
 * @generated
 */
public interface BlockDiagramPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "blockdiagram";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.esmp.org/dsm/BlockDiagram/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "blockdiagram";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BlockDiagramPackage eINSTANCE = org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.NamedElementImpl
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramImpl <em>Block Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramImpl
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getBlockDiagram()
	 * @generated
	 */
	int BLOCK_DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_DIAGRAM__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Blocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_DIAGRAM__BLOCKS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_DIAGRAM__CONNECTIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Block Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_DIAGRAM_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.ParameterableElementImpl <em>Parameterable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.ParameterableElementImpl
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getParameterableElement()
	 * @generated
	 */
	int PARAMETERABLE_ELEMENT = 3;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockImpl <em>Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockImpl
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getBlock()
	 * @generated
	 */
	int BLOCK = 2;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.PortImpl
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 7;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.ConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.ConnectionImpl
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getConnection()
	 * @generated
	 */
	int CONNECTION = 8;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.InputPortImpl <em>Input Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.InputPortImpl
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getInputPort()
	 * @generated
	 */
	int INPUT_PORT = 6;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.OutputPortImpl <em>Output Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.OutputPortImpl
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getOutputPort()
	 * @generated
	 */
	int OUTPUT_PORT = 9;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.ParameterImpl
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 4;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.InputImpl <em>Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.InputImpl
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getInput()
	 * @generated
	 */
	int INPUT = 14;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.OutputImpl <em>Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.OutputImpl
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getOutput()
	 * @generated
	 */
	int OUTPUT = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__PARAMETERS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Input Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__INPUT_PORTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__OUTPUTS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__INPUTS = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Output Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__OUTPUT_PORTS = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Virtual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__VIRTUAL = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Block Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__BLOCK_DIAGRAM = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 8;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__VALUE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__DESCRIPTOR = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.ParameterDescriptorContainerImpl <em>Parameter Descriptor Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.ParameterDescriptorContainerImpl
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getParameterDescriptorContainer()
	 * @generated
	 */
	int PARAMETER_DESCRIPTOR_CONTAINER = 13;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.IOSpecificationImpl <em>IO Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.IOSpecificationImpl
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getIOSpecification()
	 * @generated
	 */
	int IO_SPECIFICATION = 12;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.OutputSpecificationImpl <em>Output Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.OutputSpecificationImpl
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getOutputSpecification()
	 * @generated
	 */
	int OUTPUT_SPECIFICATION = 11;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockTypeImpl <em>Block Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockTypeImpl
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getBlockType()
	 * @generated
	 */
	int BLOCK_TYPE = 16;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.ParameterDescriptorImpl <em>Parameter Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.ParameterDescriptorImpl
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getParameterDescriptor()
	 * @generated
	 */
	int PARAMETER_DESCRIPTOR = 5;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.InputSpecificationImpl <em>Input Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.InputSpecificationImpl
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getInputSpecification()
	 * @generated
	 */
	int INPUT_SPECIFICATION = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DESCRIPTOR__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Parameter Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DESCRIPTOR_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__PARAMETERS = PARAMETERABLE_ELEMENT__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__BLOCK = PARAMETERABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__INDEX = PARAMETERABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = PARAMETERABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__PARAMETERS = PORT__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__BLOCK = PORT__BLOCK;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__INDEX = PORT__INDEX;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__INCOMING_CONNECTION = PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Direct Feedthrough</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__DIRECT_FEEDTHROUGH = PORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Input</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__INPUT = PORT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Input Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Source Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__SOURCE_PORT = 0;

	/**
	 * The feature id for the '<em><b>Virtual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__VIRTUAL = 1;

	/**
	 * The feature id for the '<em><b>Target Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__TARGET_PORT = 2;

	/**
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__PARAMETERS = PORT__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__BLOCK = PORT__BLOCK;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__INDEX = PORT__INDEX;

	/**
	 * The feature id for the '<em><b>Output</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__OUTPUT = PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__OUTGOING_CONNECTIONS = PORT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Output Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__BLOCK = 1;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__PORTS = 2;

	/**
	 * The number of structural features of the '<em>Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_SPECIFICATION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_SPECIFICATION__PARAMETERS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Minimum Port Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_SPECIFICATION__MINIMUM_PORT_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Maximum Port Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_SPECIFICATION__MAXIMUM_PORT_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Many Ports</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_SPECIFICATION__MANY_PORTS = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Virtual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_SPECIFICATION__VIRTUAL = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_SPECIFICATION__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>IO Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IO_SPECIFICATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SPECIFICATION__NAME = IO_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SPECIFICATION__PARAMETERS = IO_SPECIFICATION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Minimum Port Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SPECIFICATION__MINIMUM_PORT_COUNT = IO_SPECIFICATION__MINIMUM_PORT_COUNT;

	/**
	 * The feature id for the '<em><b>Maximum Port Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SPECIFICATION__MAXIMUM_PORT_COUNT = IO_SPECIFICATION__MAXIMUM_PORT_COUNT;

	/**
	 * The feature id for the '<em><b>Many Ports</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SPECIFICATION__MANY_PORTS = IO_SPECIFICATION__MANY_PORTS;

	/**
	 * The feature id for the '<em><b>Virtual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SPECIFICATION__VIRTUAL = IO_SPECIFICATION__VIRTUAL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SPECIFICATION__TYPE = IO_SPECIFICATION__TYPE;

	/**
	 * The number of structural features of the '<em>Output Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SPECIFICATION_FEATURE_COUNT = IO_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DESCRIPTOR_CONTAINER__PARAMETERS = 0;

	/**
	 * The number of structural features of the '<em>Parameter Descriptor Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DESCRIPTOR_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT__SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Block</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT__BLOCK = 1;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT__PORTS = 2;

	/**
	 * The number of structural features of the '<em>Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SPECIFICATION__NAME = IO_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SPECIFICATION__PARAMETERS = IO_SPECIFICATION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Minimum Port Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SPECIFICATION__MINIMUM_PORT_COUNT = IO_SPECIFICATION__MINIMUM_PORT_COUNT;

	/**
	 * The feature id for the '<em><b>Maximum Port Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SPECIFICATION__MAXIMUM_PORT_COUNT = IO_SPECIFICATION__MAXIMUM_PORT_COUNT;

	/**
	 * The feature id for the '<em><b>Many Ports</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SPECIFICATION__MANY_PORTS = IO_SPECIFICATION__MANY_PORTS;

	/**
	 * The feature id for the '<em><b>Virtual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SPECIFICATION__VIRTUAL = IO_SPECIFICATION__VIRTUAL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SPECIFICATION__TYPE = IO_SPECIFICATION__TYPE;

	/**
	 * The feature id for the '<em><b>Direct Feedthrough Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SPECIFICATION__DIRECT_FEEDTHROUGH_EXPRESSION = IO_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Input Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SPECIFICATION_FEATURE_COUNT = IO_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_TYPE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_TYPE__PARAMETERS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_TYPE__INPUTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_TYPE__OUTPUTS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_TYPE__CATEGORIES = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_TYPE__URI = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Uri As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_TYPE__URI_AS_STRING = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Virtual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_TYPE__VIRTUAL = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Structural</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_TYPE__STRUCTURAL = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Block Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_TYPE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.ExpressionParameterDescriptorImpl <em>Expression Parameter Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.ExpressionParameterDescriptorImpl
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getExpressionParameterDescriptor()
	 * @generated
	 */
	int EXPRESSION_PARAMETER_DESCRIPTOR = 18;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.EnumerationParameterDescriptorImpl <em>Enumeration Parameter Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.EnumerationParameterDescriptorImpl
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getEnumerationParameterDescriptor()
	 * @generated
	 */
	int ENUMERATION_PARAMETER_DESCRIPTOR = 20;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.BooleanParameterDescriptorImpl <em>Boolean Parameter Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BooleanParameterDescriptorImpl
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getBooleanParameterDescriptor()
	 * @generated
	 */
	int BOOLEAN_PARAMETER_DESCRIPTOR = 19;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.EnumerationLiteralImpl <em>Enumeration Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.EnumerationLiteralImpl
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getEnumerationLiteral()
	 * @generated
	 */
	int ENUMERATION_LITERAL = 22;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockCategoryImpl <em>Block Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockCategoryImpl
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getBlockCategory()
	 * @generated
	 */
	int BLOCK_CATEGORY = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_CATEGORY__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_CATEGORY__PARAMETERS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parents</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_CATEGORY__PARENTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_CATEGORY__URI = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Uri As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_CATEGORY__URI_AS_STRING = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Block Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_CATEGORY_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_PARAMETER_DESCRIPTOR__NAME = PARAMETER_DESCRIPTOR__NAME;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_PARAMETER_DESCRIPTOR__DEFAULT_VALUE = PARAMETER_DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expression Parameter Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_PARAMETER_DESCRIPTOR_FEATURE_COUNT = PARAMETER_DESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_PARAMETER_DESCRIPTOR__NAME = PARAMETER_DESCRIPTOR__NAME;

	/**
	 * The feature id for the '<em><b>Default Boolean Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_PARAMETER_DESCRIPTOR__DEFAULT_BOOLEAN_VALUE = PARAMETER_DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Parameter Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_PARAMETER_DESCRIPTOR_FEATURE_COUNT = PARAMETER_DESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.BooleanValue <em>Boolean Value</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.BooleanValue
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getBooleanValue()
	 * @generated
	 */
	int BOOLEAN_VALUE = 24;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.EnumerationLiteralOrder <em>Enumeration Literal Order</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.EnumerationLiteralOrder
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getEnumerationLiteralOrder()
	 * @generated
	 */
	int ENUMERATION_LITERAL_ORDER = 25;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.EnumerationOrder <em>Enumeration Order</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.EnumerationOrder
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getEnumerationOrder()
	 * @generated
	 */
	int ENUMERATION_ORDER = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_PARAMETER_DESCRIPTOR__NAME = PARAMETER_DESCRIPTOR__NAME;

	/**
	 * The feature id for the '<em><b>Owned Enumeration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_PARAMETER_DESCRIPTOR__OWNED_ENUMERATION = PARAMETER_DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inherited Enumerations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_PARAMETER_DESCRIPTOR__INHERITED_ENUMERATIONS = PARAMETER_DESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_PARAMETER_DESCRIPTOR__DEFAULT_LITERAL = PARAMETER_DESCRIPTOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_PARAMETER_DESCRIPTOR__EXCLUSIVE = PARAMETER_DESCRIPTOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Enumeration Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_PARAMETER_DESCRIPTOR__ENUMERATION_ORDER = PARAMETER_DESCRIPTOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_PARAMETER_DESCRIPTOR__LITERALS = PARAMETER_DESCRIPTOR_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Enumeration Parameter Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_PARAMETER_DESCRIPTOR_FEATURE_COUNT = PARAMETER_DESCRIPTOR_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.EnumerationImpl <em>Enumeration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.EnumerationImpl
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getEnumeration()
	 * @generated
	 */
	int ENUMERATION = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__OWNED_LITERALS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inherited Literals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__INHERITED_LITERALS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Literal Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__LITERAL_ORDER = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__LITERALS = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Enumeration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__VALUE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enumeration Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.semantic.blockdiagram.IOType <em>IO Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.semantic.blockdiagram.IOType
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getIOType()
	 * @generated
	 */
	int IO_TYPE = 23;

	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getURI()
	 * @generated
	 */
	int URI = 27;

	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.semantic.blockdiagram.BlockDiagram <em>Block Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Diagram</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagram
	 * @generated
	 */
	EClass getBlockDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link org.esmp.dsm.semantic.blockdiagram.BlockDiagram#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connections</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagram#getConnections()
	 * @see #getBlockDiagram()
	 * @generated
	 */
	EReference getBlockDiagram_Connections();

	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.semantic.blockdiagram.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.semantic.blockdiagram.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.esmp.dsm.semantic.blockdiagram.BlockDiagram#getBlocks <em>Blocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Blocks</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagram#getBlocks()
	 * @see #getBlockDiagram()
	 * @generated
	 */
	EReference getBlockDiagram_Blocks();

	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.semantic.blockdiagram.Block <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Block
	 * @generated
	 */
	EClass getBlock();

	/**
	 * Returns the meta object for the reference list '{@link org.esmp.dsm.semantic.blockdiagram.Block#getInputPorts <em>Input Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Input Ports</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Block#getInputPorts()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_InputPorts();

	/**
	 * Returns the meta object for the containment reference list '{@link org.esmp.dsm.semantic.blockdiagram.Block#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outputs</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Block#getOutputs()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_Outputs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.esmp.dsm.semantic.blockdiagram.Block#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Block#getInputs()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_Inputs();

	/**
	 * Returns the meta object for the reference list '{@link org.esmp.dsm.semantic.blockdiagram.Block#getOutputPorts <em>Output Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Output Ports</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Block#getOutputPorts()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_OutputPorts();

	/**
	 * Returns the meta object for the reference '{@link org.esmp.dsm.semantic.blockdiagram.Block#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Block#getType()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.semantic.blockdiagram.Block#isVirtual <em>Virtual</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Virtual</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Block#isVirtual()
	 * @see #getBlock()
	 * @generated
	 */
	EAttribute getBlock_Virtual();

	/**
	 * Returns the meta object for the container reference '{@link org.esmp.dsm.semantic.blockdiagram.Block#getBlockDiagram <em>Block Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Block Diagram</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Block#getBlockDiagram()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_BlockDiagram();

	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.semantic.blockdiagram.ParameterableElement <em>Parameterable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameterable Element</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.ParameterableElement
	 * @generated
	 */
	EClass getParameterableElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.esmp.dsm.semantic.blockdiagram.ParameterableElement#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.ParameterableElement#getParameters()
	 * @see #getParameterableElement()
	 * @generated
	 */
	EReference getParameterableElement_Parameters();

	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.semantic.blockdiagram.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the reference '{@link org.esmp.dsm.semantic.blockdiagram.Port#getBlock <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Block</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Port#getBlock()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Block();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.semantic.blockdiagram.Port#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Port#getIndex()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Index();

	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.semantic.blockdiagram.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Connection
	 * @generated
	 */
	EClass getConnection();

	/**
	 * Returns the meta object for the reference '{@link org.esmp.dsm.semantic.blockdiagram.Connection#getSourcePort <em>Source Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Port</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Connection#getSourcePort()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_SourcePort();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.semantic.blockdiagram.Connection#isVirtual <em>Virtual</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Virtual</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Connection#isVirtual()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Virtual();

	/**
	 * Returns the meta object for the reference '{@link org.esmp.dsm.semantic.blockdiagram.Connection#getTargetPort <em>Target Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Port</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Connection#getTargetPort()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_TargetPort();

	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.semantic.blockdiagram.InputPort <em>Input Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Port</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.InputPort
	 * @generated
	 */
	EClass getInputPort();

	/**
	 * Returns the meta object for the reference '{@link org.esmp.dsm.semantic.blockdiagram.InputPort#getIncomingConnection <em>Incoming Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Incoming Connection</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.InputPort#getIncomingConnection()
	 * @see #getInputPort()
	 * @generated
	 */
	EReference getInputPort_IncomingConnection();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.semantic.blockdiagram.InputPort#isDirectFeedthrough <em>Direct Feedthrough</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direct Feedthrough</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.InputPort#isDirectFeedthrough()
	 * @see #getInputPort()
	 * @generated
	 */
	EAttribute getInputPort_DirectFeedthrough();

	/**
	 * Returns the meta object for the container reference '{@link org.esmp.dsm.semantic.blockdiagram.InputPort#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Input</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.InputPort#getInput()
	 * @see #getInputPort()
	 * @generated
	 */
	EReference getInputPort_Input();

	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.semantic.blockdiagram.OutputPort <em>Output Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Port</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.OutputPort
	 * @generated
	 */
	EClass getOutputPort();

	/**
	 * Returns the meta object for the container reference '{@link org.esmp.dsm.semantic.blockdiagram.OutputPort#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Output</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.OutputPort#getOutput()
	 * @see #getOutputPort()
	 * @generated
	 */
	EReference getOutputPort_Output();

	/**
	 * Returns the meta object for the reference list '{@link org.esmp.dsm.semantic.blockdiagram.OutputPort#getOutgoingConnections <em>Outgoing Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Connections</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.OutputPort#getOutgoingConnections()
	 * @see #getOutputPort()
	 * @generated
	 */
	EReference getOutputPort_OutgoingConnections();

	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.semantic.blockdiagram.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.semantic.blockdiagram.Parameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Parameter#getValue()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Value();

	/**
	 * Returns the meta object for the reference '{@link org.esmp.dsm.semantic.blockdiagram.Parameter#getDescriptor <em>Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Descriptor</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Parameter#getDescriptor()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Descriptor();

	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.semantic.blockdiagram.Input <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Input
	 * @generated
	 */
	EClass getInput();

	/**
	 * Returns the meta object for the containment reference list '{@link org.esmp.dsm.semantic.blockdiagram.Input#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ports</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Input#getPorts()
	 * @see #getInput()
	 * @generated
	 */
	EReference getInput_Ports();

	/**
	 * Returns the meta object for the reference '{@link org.esmp.dsm.semantic.blockdiagram.Input#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Specification</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Input#getSpecification()
	 * @see #getInput()
	 * @generated
	 */
	EReference getInput_Specification();

	/**
	 * Returns the meta object for the container reference '{@link org.esmp.dsm.semantic.blockdiagram.Input#getBlock <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Block</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Input#getBlock()
	 * @see #getInput()
	 * @generated
	 */
	EReference getInput_Block();

	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.semantic.blockdiagram.Output <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Output
	 * @generated
	 */
	EClass getOutput();

	/**
	 * Returns the meta object for the containment reference list '{@link org.esmp.dsm.semantic.blockdiagram.Output#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ports</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Output#getPorts()
	 * @see #getOutput()
	 * @generated
	 */
	EReference getOutput_Ports();

	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.semantic.blockdiagram.OutputSpecification <em>Output Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Specification</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.OutputSpecification
	 * @generated
	 */
	EClass getOutputSpecification();

	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.semantic.blockdiagram.IOSpecification <em>IO Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IO Specification</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.IOSpecification
	 * @generated
	 */
	EClass getIOSpecification();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.semantic.blockdiagram.IOSpecification#getMinimumPortCount <em>Minimum Port Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum Port Count</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.IOSpecification#getMinimumPortCount()
	 * @see #getIOSpecification()
	 * @generated
	 */
	EAttribute getIOSpecification_MinimumPortCount();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.semantic.blockdiagram.IOSpecification#getMaximumPortCount <em>Maximum Port Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Port Count</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.IOSpecification#getMaximumPortCount()
	 * @see #getIOSpecification()
	 * @generated
	 */
	EAttribute getIOSpecification_MaximumPortCount();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.semantic.blockdiagram.IOSpecification#isManyPorts <em>Many Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Many Ports</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.IOSpecification#isManyPorts()
	 * @see #getIOSpecification()
	 * @generated
	 */
	EAttribute getIOSpecification_ManyPorts();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.semantic.blockdiagram.IOSpecification#isVirtual <em>Virtual</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Virtual</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.IOSpecification#isVirtual()
	 * @see #getIOSpecification()
	 * @generated
	 */
	EAttribute getIOSpecification_Virtual();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.semantic.blockdiagram.IOSpecification#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.IOSpecification#getType()
	 * @see #getIOSpecification()
	 * @generated
	 */
	EAttribute getIOSpecification_Type();

	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.semantic.blockdiagram.ParameterDescriptorContainer <em>Parameter Descriptor Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Descriptor Container</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.ParameterDescriptorContainer
	 * @generated
	 */
	EClass getParameterDescriptorContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.esmp.dsm.semantic.blockdiagram.ParameterDescriptorContainer#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.ParameterDescriptorContainer#getParameters()
	 * @see #getParameterDescriptorContainer()
	 * @generated
	 */
	EReference getParameterDescriptorContainer_Parameters();

	/**
	 * Returns the meta object for the container reference '{@link org.esmp.dsm.semantic.blockdiagram.Output#getBlock <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Block</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Output#getBlock()
	 * @see #getOutput()
	 * @generated
	 */
	EReference getOutput_Block();

	/**
	 * Returns the meta object for the reference '{@link org.esmp.dsm.semantic.blockdiagram.Output#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Specification</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Output#getSpecification()
	 * @see #getOutput()
	 * @generated
	 */
	EReference getOutput_Specification();

	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.semantic.blockdiagram.BlockType <em>Block Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Type</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockType
	 * @generated
	 */
	EClass getBlockType();

	/**
	 * Returns the meta object for the reference list '{@link org.esmp.dsm.semantic.blockdiagram.BlockType#getCategories <em>Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Categories</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockType#getCategories()
	 * @see #getBlockType()
	 * @generated
	 */
	EReference getBlockType_Categories();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.semantic.blockdiagram.BlockType#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockType#getUri()
	 * @see #getBlockType()
	 * @generated
	 */
	EAttribute getBlockType_Uri();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.semantic.blockdiagram.BlockType#getUriAsString <em>Uri As String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri As String</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockType#getUriAsString()
	 * @see #getBlockType()
	 * @generated
	 */
	EAttribute getBlockType_UriAsString();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.semantic.blockdiagram.BlockType#isVirtual <em>Virtual</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Virtual</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockType#isVirtual()
	 * @see #getBlockType()
	 * @generated
	 */
	EAttribute getBlockType_Virtual();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.semantic.blockdiagram.BlockType#isStructural <em>Structural</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Structural</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockType#isStructural()
	 * @see #getBlockType()
	 * @generated
	 */
	EAttribute getBlockType_Structural();

	/**
	 * Returns the meta object for the containment reference list '{@link org.esmp.dsm.semantic.blockdiagram.BlockType#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockType#getInputs()
	 * @see #getBlockType()
	 * @generated
	 */
	EReference getBlockType_Inputs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.esmp.dsm.semantic.blockdiagram.BlockType#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outputs</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockType#getOutputs()
	 * @see #getBlockType()
	 * @generated
	 */
	EReference getBlockType_Outputs();

	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.semantic.blockdiagram.ParameterDescriptor <em>Parameter Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Descriptor</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.ParameterDescriptor
	 * @generated
	 */
	EClass getParameterDescriptor();

	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.semantic.blockdiagram.InputSpecification <em>Input Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Specification</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.InputSpecification
	 * @generated
	 */
	EClass getInputSpecification();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.semantic.blockdiagram.InputSpecification#getDirectFeedthroughExpression <em>Direct Feedthrough Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direct Feedthrough Expression</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.InputSpecification#getDirectFeedthroughExpression()
	 * @see #getInputSpecification()
	 * @generated
	 */
	EAttribute getInputSpecification_DirectFeedthroughExpression();

	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.semantic.blockdiagram.ExpressionParameterDescriptor <em>Expression Parameter Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Parameter Descriptor</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.ExpressionParameterDescriptor
	 * @generated
	 */
	EClass getExpressionParameterDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.semantic.blockdiagram.ExpressionParameterDescriptor#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.ExpressionParameterDescriptor#getDefaultValue()
	 * @see #getExpressionParameterDescriptor()
	 * @generated
	 */
	EAttribute getExpressionParameterDescriptor_DefaultValue();

	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor <em>Enumeration Parameter Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Parameter Descriptor</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor
	 * @generated
	 */
	EClass getEnumerationParameterDescriptor();

	/**
	 * Returns the meta object for the containment reference '{@link org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor#getOwnedEnumeration <em>Owned Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Enumeration</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor#getOwnedEnumeration()
	 * @see #getEnumerationParameterDescriptor()
	 * @generated
	 */
	EReference getEnumerationParameterDescriptor_OwnedEnumeration();

	/**
	 * Returns the meta object for the reference list '{@link org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor#getInheritedEnumerations <em>Inherited Enumerations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inherited Enumerations</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor#getInheritedEnumerations()
	 * @see #getEnumerationParameterDescriptor()
	 * @generated
	 */
	EReference getEnumerationParameterDescriptor_InheritedEnumerations();

	/**
	 * Returns the meta object for the reference list '{@link org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Literals</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor#getLiterals()
	 * @see #getEnumerationParameterDescriptor()
	 * @generated
	 */
	EReference getEnumerationParameterDescriptor_Literals();

	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.semantic.blockdiagram.Enumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Enumeration
	 * @generated
	 */
	EClass getEnumeration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.esmp.dsm.semantic.blockdiagram.Enumeration#getOwnedLiterals <em>Owned Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Literals</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Enumeration#getOwnedLiterals()
	 * @see #getEnumeration()
	 * @generated
	 */
	EReference getEnumeration_OwnedLiterals();

	/**
	 * Returns the meta object for the reference list '{@link org.esmp.dsm.semantic.blockdiagram.Enumeration#getInheritedLiterals <em>Inherited Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inherited Literals</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Enumeration#getInheritedLiterals()
	 * @see #getEnumeration()
	 * @generated
	 */
	EReference getEnumeration_InheritedLiterals();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.semantic.blockdiagram.Enumeration#getLiteralOrder <em>Literal Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Literal Order</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Enumeration#getLiteralOrder()
	 * @see #getEnumeration()
	 * @generated
	 */
	EAttribute getEnumeration_LiteralOrder();

	/**
	 * Returns the meta object for the reference list '{@link org.esmp.dsm.semantic.blockdiagram.Enumeration#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Literals</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.Enumeration#getLiterals()
	 * @see #getEnumeration()
	 * @generated
	 */
	EReference getEnumeration_Literals();

	/**
	 * Returns the meta object for the reference '{@link org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor#getDefaultLiteral <em>Default Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Literal</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor#getDefaultLiteral()
	 * @see #getEnumerationParameterDescriptor()
	 * @generated
	 */
	EReference getEnumerationParameterDescriptor_DefaultLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor#isExclusive <em>Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exclusive</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor#isExclusive()
	 * @see #getEnumerationParameterDescriptor()
	 * @generated
	 */
	EAttribute getEnumerationParameterDescriptor_Exclusive();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor#getEnumerationOrder <em>Enumeration Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enumeration Order</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor#getEnumerationOrder()
	 * @see #getEnumerationParameterDescriptor()
	 * @generated
	 */
	EAttribute getEnumerationParameterDescriptor_EnumerationOrder();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.URI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>URI</em>'.
	 * @see org.eclipse.emf.common.util.URI
	 * @model instanceClass="org.eclipse.emf.common.util.URI"
	 * @generated
	 */
	EDataType getURI();

	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.semantic.blockdiagram.BooleanParameterDescriptor <em>Boolean Parameter Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Parameter Descriptor</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.BooleanParameterDescriptor
	 * @generated
	 */
	EClass getBooleanParameterDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.semantic.blockdiagram.BooleanParameterDescriptor#getDefaultBooleanValue <em>Default Boolean Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Boolean Value</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.BooleanParameterDescriptor#getDefaultBooleanValue()
	 * @see #getBooleanParameterDescriptor()
	 * @generated
	 */
	EAttribute getBooleanParameterDescriptor_DefaultBooleanValue();

	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.semantic.blockdiagram.EnumerationLiteral <em>Enumeration Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Literal</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.EnumerationLiteral
	 * @generated
	 */
	EClass getEnumerationLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.semantic.blockdiagram.EnumerationLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.EnumerationLiteral#getValue()
	 * @see #getEnumerationLiteral()
	 * @generated
	 */
	EAttribute getEnumerationLiteral_Value();

	/**
	 * Returns the meta object for enum '{@link org.esmp.dsm.semantic.blockdiagram.IOType <em>IO Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>IO Type</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.IOType
	 * @generated
	 */
	EEnum getIOType();

	/**
	 * Returns the meta object for enum '{@link org.esmp.dsm.semantic.blockdiagram.BooleanValue <em>Boolean Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Boolean Value</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.BooleanValue
	 * @generated
	 */
	EEnum getBooleanValue();

	/**
	 * Returns the meta object for enum '{@link org.esmp.dsm.semantic.blockdiagram.EnumerationLiteralOrder <em>Enumeration Literal Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enumeration Literal Order</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.EnumerationLiteralOrder
	 * @generated
	 */
	EEnum getEnumerationLiteralOrder();

	/**
	 * Returns the meta object for enum '{@link org.esmp.dsm.semantic.blockdiagram.EnumerationOrder <em>Enumeration Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enumeration Order</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.EnumerationOrder
	 * @generated
	 */
	EEnum getEnumerationOrder();

	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.semantic.blockdiagram.BlockCategory <em>Block Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Category</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockCategory
	 * @generated
	 */
	EClass getBlockCategory();

	/**
	 * Returns the meta object for the reference list '{@link org.esmp.dsm.semantic.blockdiagram.BlockCategory#getParents <em>Parents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parents</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockCategory#getParents()
	 * @see #getBlockCategory()
	 * @generated
	 */
	EReference getBlockCategory_Parents();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.semantic.blockdiagram.BlockCategory#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockCategory#getUri()
	 * @see #getBlockCategory()
	 * @generated
	 */
	EAttribute getBlockCategory_Uri();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.semantic.blockdiagram.BlockCategory#getUriAsString <em>Uri As String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri As String</em>'.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockCategory#getUriAsString()
	 * @see #getBlockCategory()
	 * @generated
	 */
	EAttribute getBlockCategory_UriAsString();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BlockDiagramFactory getBlockDiagramFactory();

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
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramImpl <em>Block Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramImpl
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getBlockDiagram()
		 * @generated
		 */
		EClass BLOCK_DIAGRAM = eINSTANCE.getBlockDiagram();

		/**
		 * The meta object literal for the '<em><b>Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_DIAGRAM__CONNECTIONS = eINSTANCE.getBlockDiagram_Connections();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.NamedElementImpl
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '<em><b>Blocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_DIAGRAM__BLOCKS = eINSTANCE.getBlockDiagram_Blocks();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockImpl <em>Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockImpl
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getBlock()
		 * @generated
		 */
		EClass BLOCK = eINSTANCE.getBlock();

		/**
		 * The meta object literal for the '<em><b>Input Ports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__INPUT_PORTS = eINSTANCE.getBlock_InputPorts();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__OUTPUTS = eINSTANCE.getBlock_Outputs();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__INPUTS = eINSTANCE.getBlock_Inputs();

		/**
		 * The meta object literal for the '<em><b>Output Ports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__OUTPUT_PORTS = eINSTANCE.getBlock_OutputPorts();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__TYPE = eINSTANCE.getBlock_Type();

		/**
		 * The meta object literal for the '<em><b>Virtual</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK__VIRTUAL = eINSTANCE.getBlock_Virtual();

		/**
		 * The meta object literal for the '<em><b>Block Diagram</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__BLOCK_DIAGRAM = eINSTANCE.getBlock_BlockDiagram();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.ParameterableElementImpl <em>Parameterable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.ParameterableElementImpl
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getParameterableElement()
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
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.PortImpl
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Block</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__BLOCK = eINSTANCE.getPort_Block();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__INDEX = eINSTANCE.getPort_Index();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.ConnectionImpl <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.ConnectionImpl
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getConnection()
		 * @generated
		 */
		EClass CONNECTION = eINSTANCE.getConnection();

		/**
		 * The meta object literal for the '<em><b>Source Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__SOURCE_PORT = eINSTANCE.getConnection_SourcePort();

		/**
		 * The meta object literal for the '<em><b>Virtual</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__VIRTUAL = eINSTANCE.getConnection_Virtual();

		/**
		 * The meta object literal for the '<em><b>Target Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__TARGET_PORT = eINSTANCE.getConnection_TargetPort();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.InputPortImpl <em>Input Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.InputPortImpl
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getInputPort()
		 * @generated
		 */
		EClass INPUT_PORT = eINSTANCE.getInputPort();

		/**
		 * The meta object literal for the '<em><b>Incoming Connection</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_PORT__INCOMING_CONNECTION = eINSTANCE.getInputPort_IncomingConnection();

		/**
		 * The meta object literal for the '<em><b>Direct Feedthrough</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT_PORT__DIRECT_FEEDTHROUGH = eINSTANCE.getInputPort_DirectFeedthrough();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_PORT__INPUT = eINSTANCE.getInputPort_Input();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.OutputPortImpl <em>Output Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.OutputPortImpl
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getOutputPort()
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
		 * The meta object literal for the '<em><b>Outgoing Connections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_PORT__OUTGOING_CONNECTIONS = eINSTANCE.getOutputPort_OutgoingConnections();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.ParameterImpl
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__VALUE = eINSTANCE.getParameter_Value();

		/**
		 * The meta object literal for the '<em><b>Descriptor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__DESCRIPTOR = eINSTANCE.getParameter_Descriptor();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.InputImpl <em>Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.InputImpl
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getInput()
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
		 * The meta object literal for the '<em><b>Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT__SPECIFICATION = eINSTANCE.getInput_Specification();

		/**
		 * The meta object literal for the '<em><b>Block</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT__BLOCK = eINSTANCE.getInput_Block();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.OutputImpl <em>Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.OutputImpl
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getOutput()
		 * @generated
		 */
		EClass OUTPUT = eINSTANCE.getOutput();

		/**
		 * The meta object literal for the '<em><b>Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT__PORTS = eINSTANCE.getOutput_Ports();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.OutputSpecificationImpl <em>Output Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.OutputSpecificationImpl
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getOutputSpecification()
		 * @generated
		 */
		EClass OUTPUT_SPECIFICATION = eINSTANCE.getOutputSpecification();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.IOSpecificationImpl <em>IO Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.IOSpecificationImpl
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getIOSpecification()
		 * @generated
		 */
		EClass IO_SPECIFICATION = eINSTANCE.getIOSpecification();

		/**
		 * The meta object literal for the '<em><b>Minimum Port Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IO_SPECIFICATION__MINIMUM_PORT_COUNT = eINSTANCE.getIOSpecification_MinimumPortCount();

		/**
		 * The meta object literal for the '<em><b>Maximum Port Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IO_SPECIFICATION__MAXIMUM_PORT_COUNT = eINSTANCE.getIOSpecification_MaximumPortCount();

		/**
		 * The meta object literal for the '<em><b>Many Ports</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IO_SPECIFICATION__MANY_PORTS = eINSTANCE.getIOSpecification_ManyPorts();

		/**
		 * The meta object literal for the '<em><b>Virtual</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IO_SPECIFICATION__VIRTUAL = eINSTANCE.getIOSpecification_Virtual();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IO_SPECIFICATION__TYPE = eINSTANCE.getIOSpecification_Type();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.ParameterDescriptorContainerImpl <em>Parameter Descriptor Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.ParameterDescriptorContainerImpl
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getParameterDescriptorContainer()
		 * @generated
		 */
		EClass PARAMETER_DESCRIPTOR_CONTAINER = eINSTANCE.getParameterDescriptorContainer();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_DESCRIPTOR_CONTAINER__PARAMETERS = eINSTANCE.getParameterDescriptorContainer_Parameters();

		/**
		 * The meta object literal for the '<em><b>Block</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT__BLOCK = eINSTANCE.getOutput_Block();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT__SPECIFICATION = eINSTANCE.getOutput_Specification();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockTypeImpl <em>Block Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockTypeImpl
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getBlockType()
		 * @generated
		 */
		EClass BLOCK_TYPE = eINSTANCE.getBlockType();

		/**
		 * The meta object literal for the '<em><b>Categories</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_TYPE__CATEGORIES = eINSTANCE.getBlockType_Categories();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK_TYPE__URI = eINSTANCE.getBlockType_Uri();

		/**
		 * The meta object literal for the '<em><b>Uri As String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK_TYPE__URI_AS_STRING = eINSTANCE.getBlockType_UriAsString();

		/**
		 * The meta object literal for the '<em><b>Virtual</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK_TYPE__VIRTUAL = eINSTANCE.getBlockType_Virtual();

		/**
		 * The meta object literal for the '<em><b>Structural</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK_TYPE__STRUCTURAL = eINSTANCE.getBlockType_Structural();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_TYPE__INPUTS = eINSTANCE.getBlockType_Inputs();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_TYPE__OUTPUTS = eINSTANCE.getBlockType_Outputs();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.ParameterDescriptorImpl <em>Parameter Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.ParameterDescriptorImpl
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getParameterDescriptor()
		 * @generated
		 */
		EClass PARAMETER_DESCRIPTOR = eINSTANCE.getParameterDescriptor();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.InputSpecificationImpl <em>Input Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.InputSpecificationImpl
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getInputSpecification()
		 * @generated
		 */
		EClass INPUT_SPECIFICATION = eINSTANCE.getInputSpecification();

		/**
		 * The meta object literal for the '<em><b>Direct Feedthrough Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT_SPECIFICATION__DIRECT_FEEDTHROUGH_EXPRESSION = eINSTANCE.getInputSpecification_DirectFeedthroughExpression();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.ExpressionParameterDescriptorImpl <em>Expression Parameter Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.ExpressionParameterDescriptorImpl
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getExpressionParameterDescriptor()
		 * @generated
		 */
		EClass EXPRESSION_PARAMETER_DESCRIPTOR = eINSTANCE.getExpressionParameterDescriptor();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION_PARAMETER_DESCRIPTOR__DEFAULT_VALUE = eINSTANCE.getExpressionParameterDescriptor_DefaultValue();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.EnumerationParameterDescriptorImpl <em>Enumeration Parameter Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.EnumerationParameterDescriptorImpl
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getEnumerationParameterDescriptor()
		 * @generated
		 */
		EClass ENUMERATION_PARAMETER_DESCRIPTOR = eINSTANCE.getEnumerationParameterDescriptor();

		/**
		 * The meta object literal for the '<em><b>Owned Enumeration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION_PARAMETER_DESCRIPTOR__OWNED_ENUMERATION = eINSTANCE.getEnumerationParameterDescriptor_OwnedEnumeration();

		/**
		 * The meta object literal for the '<em><b>Inherited Enumerations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION_PARAMETER_DESCRIPTOR__INHERITED_ENUMERATIONS = eINSTANCE.getEnumerationParameterDescriptor_InheritedEnumerations();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION_PARAMETER_DESCRIPTOR__LITERALS = eINSTANCE.getEnumerationParameterDescriptor_Literals();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.EnumerationImpl <em>Enumeration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.EnumerationImpl
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getEnumeration()
		 * @generated
		 */
		EClass ENUMERATION = eINSTANCE.getEnumeration();

		/**
		 * The meta object literal for the '<em><b>Owned Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION__OWNED_LITERALS = eINSTANCE.getEnumeration_OwnedLiterals();

		/**
		 * The meta object literal for the '<em><b>Inherited Literals</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION__INHERITED_LITERALS = eINSTANCE.getEnumeration_InheritedLiterals();

		/**
		 * The meta object literal for the '<em><b>Literal Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION__LITERAL_ORDER = eINSTANCE.getEnumeration_LiteralOrder();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION__LITERALS = eINSTANCE.getEnumeration_Literals();

		/**
		 * The meta object literal for the '<em><b>Default Literal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION_PARAMETER_DESCRIPTOR__DEFAULT_LITERAL = eINSTANCE.getEnumerationParameterDescriptor_DefaultLiteral();

		/**
		 * The meta object literal for the '<em><b>Exclusive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_PARAMETER_DESCRIPTOR__EXCLUSIVE = eINSTANCE.getEnumerationParameterDescriptor_Exclusive();

		/**
		 * The meta object literal for the '<em><b>Enumeration Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_PARAMETER_DESCRIPTOR__ENUMERATION_ORDER = eINSTANCE.getEnumerationParameterDescriptor_EnumerationOrder();

		/**
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getURI()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getURI();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.BooleanParameterDescriptorImpl <em>Boolean Parameter Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BooleanParameterDescriptorImpl
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getBooleanParameterDescriptor()
		 * @generated
		 */
		EClass BOOLEAN_PARAMETER_DESCRIPTOR = eINSTANCE.getBooleanParameterDescriptor();

		/**
		 * The meta object literal for the '<em><b>Default Boolean Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_PARAMETER_DESCRIPTOR__DEFAULT_BOOLEAN_VALUE = eINSTANCE.getBooleanParameterDescriptor_DefaultBooleanValue();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.EnumerationLiteralImpl <em>Enumeration Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.EnumerationLiteralImpl
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getEnumerationLiteral()
		 * @generated
		 */
		EClass ENUMERATION_LITERAL = eINSTANCE.getEnumerationLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_LITERAL__VALUE = eINSTANCE.getEnumerationLiteral_Value();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.IOType <em>IO Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.IOType
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getIOType()
		 * @generated
		 */
		EEnum IO_TYPE = eINSTANCE.getIOType();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.BooleanValue <em>Boolean Value</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.BooleanValue
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getBooleanValue()
		 * @generated
		 */
		EEnum BOOLEAN_VALUE = eINSTANCE.getBooleanValue();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.EnumerationLiteralOrder <em>Enumeration Literal Order</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.EnumerationLiteralOrder
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getEnumerationLiteralOrder()
		 * @generated
		 */
		EEnum ENUMERATION_LITERAL_ORDER = eINSTANCE.getEnumerationLiteralOrder();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.EnumerationOrder <em>Enumeration Order</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.EnumerationOrder
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getEnumerationOrder()
		 * @generated
		 */
		EEnum ENUMERATION_ORDER = eINSTANCE.getEnumerationOrder();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockCategoryImpl <em>Block Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockCategoryImpl
		 * @see org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramPackageImpl#getBlockCategory()
		 * @generated
		 */
		EClass BLOCK_CATEGORY = eINSTANCE.getBlockCategory();

		/**
		 * The meta object literal for the '<em><b>Parents</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_CATEGORY__PARENTS = eINSTANCE.getBlockCategory_Parents();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK_CATEGORY__URI = eINSTANCE.getBlockCategory_Uri();

		/**
		 * The meta object literal for the '<em><b>Uri As String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK_CATEGORY__URI_AS_STRING = eINSTANCE.getBlockCategory_UriAsString();

	}

} //BlockDiagramPackage
