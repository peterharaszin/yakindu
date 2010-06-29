/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.BlockCategory;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagram;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramFactory;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;
import org.esmp.dsm.semantic.blockdiagram.BlockType;
import org.esmp.dsm.semantic.blockdiagram.BooleanParameterDescriptor;
import org.esmp.dsm.semantic.blockdiagram.BooleanValue;
import org.esmp.dsm.semantic.blockdiagram.Connection;
import org.esmp.dsm.semantic.blockdiagram.Enumeration;
import org.esmp.dsm.semantic.blockdiagram.EnumerationLiteral;
import org.esmp.dsm.semantic.blockdiagram.EnumerationLiteralOrder;
import org.esmp.dsm.semantic.blockdiagram.EnumerationOrder;
import org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor;
import org.esmp.dsm.semantic.blockdiagram.ExpressionParameterDescriptor;
import org.esmp.dsm.semantic.blockdiagram.IOSpecification;
import org.esmp.dsm.semantic.blockdiagram.IOType;
import org.esmp.dsm.semantic.blockdiagram.Input;
import org.esmp.dsm.semantic.blockdiagram.InputPort;
import org.esmp.dsm.semantic.blockdiagram.InputSpecification;
import org.esmp.dsm.semantic.blockdiagram.NamedElement;
import org.esmp.dsm.semantic.blockdiagram.Output;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;
import org.esmp.dsm.semantic.blockdiagram.OutputSpecification;
import org.esmp.dsm.semantic.blockdiagram.Parameter;
import org.esmp.dsm.semantic.blockdiagram.ParameterDescriptor;
import org.esmp.dsm.semantic.blockdiagram.ParameterDescriptorContainer;
import org.esmp.dsm.semantic.blockdiagram.ParameterableElement;
import org.esmp.dsm.semantic.blockdiagram.Port;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BlockDiagramPackageImpl extends EPackageImpl implements BlockDiagramPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ioSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterDescriptorContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionParameterDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationParameterDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanParameterDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ioTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum booleanValueEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum enumerationLiteralOrderEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum enumerationOrderEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockCategoryEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BlockDiagramPackageImpl() {
		super(eNS_URI, BlockDiagramFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link BlockDiagramPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BlockDiagramPackage init() {
		if (isInited) return (BlockDiagramPackage)EPackage.Registry.INSTANCE.getEPackage(BlockDiagramPackage.eNS_URI);

		// Obtain or create and register package
		BlockDiagramPackageImpl theBlockDiagramPackage = (BlockDiagramPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BlockDiagramPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BlockDiagramPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theBlockDiagramPackage.createPackageContents();

		// Initialize created meta-data
		theBlockDiagramPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBlockDiagramPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BlockDiagramPackage.eNS_URI, theBlockDiagramPackage);
		return theBlockDiagramPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlockDiagram() {
		return blockDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockDiagram_Connections() {
		return (EReference)blockDiagramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockDiagram_Blocks() {
		return (EReference)blockDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlock() {
		return blockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlock_InputPorts() {
		return (EReference)blockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlock_Outputs() {
		return (EReference)blockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlock_Inputs() {
		return (EReference)blockEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlock_OutputPorts() {
		return (EReference)blockEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlock_Type() {
		return (EReference)blockEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlock_Virtual() {
		return (EAttribute)blockEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlock_BlockDiagram() {
		return (EReference)blockEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterableElement() {
		return parameterableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterableElement_Parameters() {
		return (EReference)parameterableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPort() {
		return portEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPort_Block() {
		return (EReference)portEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_Index() {
		return (EAttribute)portEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnection() {
		return connectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnection_SourcePort() {
		return (EReference)connectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnection_Virtual() {
		return (EAttribute)connectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnection_TargetPort() {
		return (EReference)connectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputPort() {
		return inputPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputPort_IncomingConnection() {
		return (EReference)inputPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInputPort_DirectFeedthrough() {
		return (EAttribute)inputPortEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputPort_Input() {
		return (EReference)inputPortEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputPort() {
		return outputPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputPort_Output() {
		return (EReference)outputPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputPort_OutgoingConnections() {
		return (EReference)outputPortEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Value() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameter_Descriptor() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInput() {
		return inputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInput_Ports() {
		return (EReference)inputEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInput_Specification() {
		return (EReference)inputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInput_Block() {
		return (EReference)inputEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutput() {
		return outputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutput_Ports() {
		return (EReference)outputEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputSpecification() {
		return outputSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIOSpecification() {
		return ioSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIOSpecification_MinimumPortCount() {
		return (EAttribute)ioSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIOSpecification_MaximumPortCount() {
		return (EAttribute)ioSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIOSpecification_ManyPorts() {
		return (EAttribute)ioSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIOSpecification_Virtual() {
		return (EAttribute)ioSpecificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIOSpecification_Type() {
		return (EAttribute)ioSpecificationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterDescriptorContainer() {
		return parameterDescriptorContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterDescriptorContainer_Parameters() {
		return (EReference)parameterDescriptorContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutput_Block() {
		return (EReference)outputEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutput_Specification() {
		return (EReference)outputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlockType() {
		return blockTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockType_Categories() {
		return (EReference)blockTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlockType_Uri() {
		return (EAttribute)blockTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlockType_UriAsString() {
		return (EAttribute)blockTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlockType_Virtual() {
		return (EAttribute)blockTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlockType_Structural() {
		return (EAttribute)blockTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockType_Inputs() {
		return (EReference)blockTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockType_Outputs() {
		return (EReference)blockTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterDescriptor() {
		return parameterDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputSpecification() {
		return inputSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInputSpecification_DirectFeedthroughExpression() {
		return (EAttribute)inputSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpressionParameterDescriptor() {
		return expressionParameterDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpressionParameterDescriptor_DefaultValue() {
		return (EAttribute)expressionParameterDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerationParameterDescriptor() {
		return enumerationParameterDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumerationParameterDescriptor_OwnedEnumeration() {
		return (EReference)enumerationParameterDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumerationParameterDescriptor_InheritedEnumerations() {
		return (EReference)enumerationParameterDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumerationParameterDescriptor_Literals() {
		return (EReference)enumerationParameterDescriptorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumeration() {
		return enumerationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumeration_OwnedLiterals() {
		return (EReference)enumerationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumeration_InheritedLiterals() {
		return (EReference)enumerationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumeration_LiteralOrder() {
		return (EAttribute)enumerationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumeration_Literals() {
		return (EReference)enumerationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumerationParameterDescriptor_DefaultLiteral() {
		return (EReference)enumerationParameterDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumerationParameterDescriptor_Exclusive() {
		return (EAttribute)enumerationParameterDescriptorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumerationParameterDescriptor_EnumerationOrder() {
		return (EAttribute)enumerationParameterDescriptorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getURI() {
		return uriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanParameterDescriptor() {
		return booleanParameterDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanParameterDescriptor_DefaultBooleanValue() {
		return (EAttribute)booleanParameterDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerationLiteral() {
		return enumerationLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumerationLiteral_Value() {
		return (EAttribute)enumerationLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIOType() {
		return ioTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBooleanValue() {
		return booleanValueEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEnumerationLiteralOrder() {
		return enumerationLiteralOrderEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEnumerationOrder() {
		return enumerationOrderEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlockCategory() {
		return blockCategoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockCategory_Parents() {
		return (EReference)blockCategoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlockCategory_Uri() {
		return (EAttribute)blockCategoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlockCategory_UriAsString() {
		return (EAttribute)blockCategoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockDiagramFactory getBlockDiagramFactory() {
		return (BlockDiagramFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		blockDiagramEClass = createEClass(BLOCK_DIAGRAM);
		createEReference(blockDiagramEClass, BLOCK_DIAGRAM__BLOCKS);
		createEReference(blockDiagramEClass, BLOCK_DIAGRAM__CONNECTIONS);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		blockEClass = createEClass(BLOCK);
		createEReference(blockEClass, BLOCK__INPUT_PORTS);
		createEReference(blockEClass, BLOCK__OUTPUTS);
		createEReference(blockEClass, BLOCK__INPUTS);
		createEReference(blockEClass, BLOCK__OUTPUT_PORTS);
		createEReference(blockEClass, BLOCK__TYPE);
		createEAttribute(blockEClass, BLOCK__VIRTUAL);
		createEReference(blockEClass, BLOCK__BLOCK_DIAGRAM);

		parameterableElementEClass = createEClass(PARAMETERABLE_ELEMENT);
		createEReference(parameterableElementEClass, PARAMETERABLE_ELEMENT__PARAMETERS);

		parameterEClass = createEClass(PARAMETER);
		createEAttribute(parameterEClass, PARAMETER__VALUE);
		createEReference(parameterEClass, PARAMETER__DESCRIPTOR);

		parameterDescriptorEClass = createEClass(PARAMETER_DESCRIPTOR);

		inputPortEClass = createEClass(INPUT_PORT);
		createEReference(inputPortEClass, INPUT_PORT__INCOMING_CONNECTION);
		createEAttribute(inputPortEClass, INPUT_PORT__DIRECT_FEEDTHROUGH);
		createEReference(inputPortEClass, INPUT_PORT__INPUT);

		portEClass = createEClass(PORT);
		createEReference(portEClass, PORT__BLOCK);
		createEAttribute(portEClass, PORT__INDEX);

		connectionEClass = createEClass(CONNECTION);
		createEReference(connectionEClass, CONNECTION__SOURCE_PORT);
		createEAttribute(connectionEClass, CONNECTION__VIRTUAL);
		createEReference(connectionEClass, CONNECTION__TARGET_PORT);

		outputPortEClass = createEClass(OUTPUT_PORT);
		createEReference(outputPortEClass, OUTPUT_PORT__OUTPUT);
		createEReference(outputPortEClass, OUTPUT_PORT__OUTGOING_CONNECTIONS);

		outputEClass = createEClass(OUTPUT);
		createEReference(outputEClass, OUTPUT__SPECIFICATION);
		createEReference(outputEClass, OUTPUT__BLOCK);
		createEReference(outputEClass, OUTPUT__PORTS);

		outputSpecificationEClass = createEClass(OUTPUT_SPECIFICATION);

		ioSpecificationEClass = createEClass(IO_SPECIFICATION);
		createEAttribute(ioSpecificationEClass, IO_SPECIFICATION__MINIMUM_PORT_COUNT);
		createEAttribute(ioSpecificationEClass, IO_SPECIFICATION__MAXIMUM_PORT_COUNT);
		createEAttribute(ioSpecificationEClass, IO_SPECIFICATION__MANY_PORTS);
		createEAttribute(ioSpecificationEClass, IO_SPECIFICATION__VIRTUAL);
		createEAttribute(ioSpecificationEClass, IO_SPECIFICATION__TYPE);

		parameterDescriptorContainerEClass = createEClass(PARAMETER_DESCRIPTOR_CONTAINER);
		createEReference(parameterDescriptorContainerEClass, PARAMETER_DESCRIPTOR_CONTAINER__PARAMETERS);

		inputEClass = createEClass(INPUT);
		createEReference(inputEClass, INPUT__SPECIFICATION);
		createEReference(inputEClass, INPUT__BLOCK);
		createEReference(inputEClass, INPUT__PORTS);

		inputSpecificationEClass = createEClass(INPUT_SPECIFICATION);
		createEAttribute(inputSpecificationEClass, INPUT_SPECIFICATION__DIRECT_FEEDTHROUGH_EXPRESSION);

		blockTypeEClass = createEClass(BLOCK_TYPE);
		createEReference(blockTypeEClass, BLOCK_TYPE__INPUTS);
		createEReference(blockTypeEClass, BLOCK_TYPE__OUTPUTS);
		createEReference(blockTypeEClass, BLOCK_TYPE__CATEGORIES);
		createEAttribute(blockTypeEClass, BLOCK_TYPE__URI);
		createEAttribute(blockTypeEClass, BLOCK_TYPE__URI_AS_STRING);
		createEAttribute(blockTypeEClass, BLOCK_TYPE__VIRTUAL);
		createEAttribute(blockTypeEClass, BLOCK_TYPE__STRUCTURAL);

		blockCategoryEClass = createEClass(BLOCK_CATEGORY);
		createEReference(blockCategoryEClass, BLOCK_CATEGORY__PARENTS);
		createEAttribute(blockCategoryEClass, BLOCK_CATEGORY__URI);
		createEAttribute(blockCategoryEClass, BLOCK_CATEGORY__URI_AS_STRING);

		expressionParameterDescriptorEClass = createEClass(EXPRESSION_PARAMETER_DESCRIPTOR);
		createEAttribute(expressionParameterDescriptorEClass, EXPRESSION_PARAMETER_DESCRIPTOR__DEFAULT_VALUE);

		booleanParameterDescriptorEClass = createEClass(BOOLEAN_PARAMETER_DESCRIPTOR);
		createEAttribute(booleanParameterDescriptorEClass, BOOLEAN_PARAMETER_DESCRIPTOR__DEFAULT_BOOLEAN_VALUE);

		enumerationParameterDescriptorEClass = createEClass(ENUMERATION_PARAMETER_DESCRIPTOR);
		createEReference(enumerationParameterDescriptorEClass, ENUMERATION_PARAMETER_DESCRIPTOR__OWNED_ENUMERATION);
		createEReference(enumerationParameterDescriptorEClass, ENUMERATION_PARAMETER_DESCRIPTOR__INHERITED_ENUMERATIONS);
		createEReference(enumerationParameterDescriptorEClass, ENUMERATION_PARAMETER_DESCRIPTOR__DEFAULT_LITERAL);
		createEAttribute(enumerationParameterDescriptorEClass, ENUMERATION_PARAMETER_DESCRIPTOR__EXCLUSIVE);
		createEAttribute(enumerationParameterDescriptorEClass, ENUMERATION_PARAMETER_DESCRIPTOR__ENUMERATION_ORDER);
		createEReference(enumerationParameterDescriptorEClass, ENUMERATION_PARAMETER_DESCRIPTOR__LITERALS);

		enumerationEClass = createEClass(ENUMERATION);
		createEReference(enumerationEClass, ENUMERATION__OWNED_LITERALS);
		createEReference(enumerationEClass, ENUMERATION__INHERITED_LITERALS);
		createEAttribute(enumerationEClass, ENUMERATION__LITERAL_ORDER);
		createEReference(enumerationEClass, ENUMERATION__LITERALS);

		enumerationLiteralEClass = createEClass(ENUMERATION_LITERAL);
		createEAttribute(enumerationLiteralEClass, ENUMERATION_LITERAL__VALUE);

		// Create enums
		ioTypeEEnum = createEEnum(IO_TYPE);
		booleanValueEEnum = createEEnum(BOOLEAN_VALUE);
		enumerationLiteralOrderEEnum = createEEnum(ENUMERATION_LITERAL_ORDER);
		enumerationOrderEEnum = createEEnum(ENUMERATION_ORDER);

		// Create data types
		uriEDataType = createEDataType(URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		blockDiagramEClass.getESuperTypes().add(this.getNamedElement());
		blockEClass.getESuperTypes().add(this.getNamedElement());
		blockEClass.getESuperTypes().add(this.getParameterableElement());
		parameterEClass.getESuperTypes().add(this.getNamedElement());
		parameterDescriptorEClass.getESuperTypes().add(this.getNamedElement());
		inputPortEClass.getESuperTypes().add(this.getPort());
		portEClass.getESuperTypes().add(this.getParameterableElement());
		outputPortEClass.getESuperTypes().add(this.getPort());
		outputSpecificationEClass.getESuperTypes().add(this.getIOSpecification());
		ioSpecificationEClass.getESuperTypes().add(this.getNamedElement());
		ioSpecificationEClass.getESuperTypes().add(this.getParameterDescriptorContainer());
		inputSpecificationEClass.getESuperTypes().add(this.getIOSpecification());
		blockTypeEClass.getESuperTypes().add(this.getNamedElement());
		blockTypeEClass.getESuperTypes().add(this.getParameterDescriptorContainer());
		blockCategoryEClass.getESuperTypes().add(this.getNamedElement());
		blockCategoryEClass.getESuperTypes().add(this.getParameterDescriptorContainer());
		expressionParameterDescriptorEClass.getESuperTypes().add(this.getParameterDescriptor());
		booleanParameterDescriptorEClass.getESuperTypes().add(this.getParameterDescriptor());
		enumerationParameterDescriptorEClass.getESuperTypes().add(this.getParameterDescriptor());
		enumerationEClass.getESuperTypes().add(this.getNamedElement());
		enumerationLiteralEClass.getESuperTypes().add(this.getNamedElement());

		// Initialize classes and features; add operations and parameters
		initEClass(blockDiagramEClass, BlockDiagram.class, "BlockDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlockDiagram_Blocks(), this.getBlock(), this.getBlock_BlockDiagram(), "blocks", null, 0, -1, BlockDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBlockDiagram_Connections(), this.getConnection(), null, "connections", null, 0, -1, BlockDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(blockEClass, Block.class, "Block", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlock_InputPorts(), this.getInputPort(), null, "inputPorts", null, 0, -1, Block.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getBlock_Outputs(), this.getOutput(), this.getOutput_Block(), "outputs", null, 0, -1, Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBlock_Inputs(), this.getInput(), this.getInput_Block(), "inputs", null, 0, -1, Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBlock_OutputPorts(), this.getOutputPort(), null, "outputPorts", null, 0, -1, Block.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getBlock_Type(), this.getBlockType(), null, "type", null, 1, 1, Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBlock_Virtual(), ecorePackage.getEBoolean(), "virtual", null, 1, 1, Block.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBlock_BlockDiagram(), this.getBlockDiagram(), this.getBlockDiagram_Blocks(), "blockDiagram", null, 1, 1, Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(blockEClass, this.getInput(), "getInput", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(blockEClass, this.getOutput(), "getOutput", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(parameterableElementEClass, ParameterableElement.class, "ParameterableElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterableElement_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, ParameterableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(parameterableElementEClass, this.getParameter(), "getParameter", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(parameterableElementEClass, ecorePackage.getEString(), "getParameterValue", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameter_Value(), ecorePackage.getEString(), "value", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getParameter_Descriptor(), this.getParameterDescriptor(), null, "descriptor", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(parameterDescriptorEClass, ParameterDescriptor.class, "ParameterDescriptor", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inputPortEClass, InputPort.class, "InputPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputPort_IncomingConnection(), this.getConnection(), this.getConnection_TargetPort(), "incomingConnection", null, 0, 1, InputPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getInputPort_DirectFeedthrough(), ecorePackage.getEBoolean(), "directFeedthrough", null, 1, 1, InputPort.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getInputPort_Input(), this.getInput(), this.getInput_Ports(), "input", null, 1, 1, InputPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(portEClass, Port.class, "Port", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPort_Block(), this.getBlock(), null, "block", null, 1, 1, Port.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPort_Index(), ecorePackage.getEInt(), "index", null, 1, 1, Port.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		initEClass(connectionEClass, Connection.class, "Connection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnection_SourcePort(), this.getOutputPort(), this.getOutputPort_OutgoingConnections(), "sourcePort", null, 1, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getConnection_Virtual(), ecorePackage.getEBoolean(), "virtual", null, 1, 1, Connection.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConnection_TargetPort(), this.getInputPort(), this.getInputPort_IncomingConnection(), "targetPort", null, 1, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(outputPortEClass, OutputPort.class, "OutputPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutputPort_Output(), this.getOutput(), this.getOutput_Ports(), "output", null, 1, 1, OutputPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOutputPort_OutgoingConnections(), this.getConnection(), this.getConnection_SourcePort(), "outgoingConnections", null, 0, -1, OutputPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(outputEClass, Output.class, "Output", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutput_Specification(), this.getOutputSpecification(), null, "specification", null, 1, 1, Output.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOutput_Block(), this.getBlock(), this.getBlock_Outputs(), "block", null, 1, 1, Output.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOutput_Ports(), this.getOutputPort(), this.getOutputPort_Output(), "ports", null, 1, -1, Output.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputSpecificationEClass, OutputSpecification.class, "OutputSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ioSpecificationEClass, IOSpecification.class, "IOSpecification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIOSpecification_MinimumPortCount(), ecorePackage.getEInt(), "minimumPortCount", "1", 1, 1, IOSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIOSpecification_MaximumPortCount(), ecorePackage.getEInt(), "maximumPortCount", "1", 1, 1, IOSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIOSpecification_ManyPorts(), ecorePackage.getEBoolean(), "manyPorts", null, 1, 1, IOSpecification.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIOSpecification_Virtual(), ecorePackage.getEBoolean(), "virtual", "false", 1, 1, IOSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIOSpecification_Type(), this.getIOType(), "type", "Scalar", 1, 1, IOSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(parameterDescriptorContainerEClass, ParameterDescriptorContainer.class, "ParameterDescriptorContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterDescriptorContainer_Parameters(), this.getParameterDescriptor(), null, "parameters", null, 0, -1, ParameterDescriptorContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputEClass, Input.class, "Input", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInput_Specification(), this.getInputSpecification(), null, "specification", null, 1, 1, Input.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInput_Block(), this.getBlock(), this.getBlock_Inputs(), "block", null, 1, 1, Input.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInput_Ports(), this.getInputPort(), this.getInputPort_Input(), "ports", null, 1, -1, Input.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputSpecificationEClass, InputSpecification.class, "InputSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInputSpecification_DirectFeedthroughExpression(), ecorePackage.getEString(), "directFeedthroughExpression", "true", 1, 1, InputSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(blockTypeEClass, BlockType.class, "BlockType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlockType_Inputs(), this.getInputSpecification(), null, "inputs", null, 0, -1, BlockType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBlockType_Outputs(), this.getOutputSpecification(), null, "outputs", null, 0, -1, BlockType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBlockType_Categories(), this.getBlockCategory(), null, "categories", null, 0, -1, BlockType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBlockType_Uri(), this.getURI(), "uri", null, 1, 1, BlockType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBlockType_UriAsString(), ecorePackage.getEString(), "uriAsString", null, 1, 1, BlockType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBlockType_Virtual(), ecorePackage.getEBoolean(), "virtual", "false", 1, 1, BlockType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBlockType_Structural(), ecorePackage.getEBoolean(), "structural", "false", 1, 1, BlockType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(blockTypeEClass, ecorePackage.getEBoolean(), "belongsTo", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getURI(), "categoryURI", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(blockTypeEClass, ecorePackage.getEBoolean(), "belongsTo", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "categoryURI", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(blockCategoryEClass, BlockCategory.class, "BlockCategory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlockCategory_Parents(), this.getBlockCategory(), null, "parents", null, 0, -1, BlockCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBlockCategory_Uri(), this.getURI(), "uri", null, 1, 1, BlockCategory.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBlockCategory_UriAsString(), ecorePackage.getEString(), "uriAsString", null, 1, 1, BlockCategory.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		op = addEOperation(blockCategoryEClass, ecorePackage.getEBoolean(), "belongsTo", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getURI(), "categoryURI", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(blockCategoryEClass, ecorePackage.getEBoolean(), "belongsTo", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "categoryURI", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(expressionParameterDescriptorEClass, ExpressionParameterDescriptor.class, "ExpressionParameterDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExpressionParameterDescriptor_DefaultValue(), ecorePackage.getEString(), "defaultValue", null, 1, 1, ExpressionParameterDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(booleanParameterDescriptorEClass, BooleanParameterDescriptor.class, "BooleanParameterDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanParameterDescriptor_DefaultBooleanValue(), this.getBooleanValue(), "defaultBooleanValue", "False", 1, 1, BooleanParameterDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(enumerationParameterDescriptorEClass, EnumerationParameterDescriptor.class, "EnumerationParameterDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumerationParameterDescriptor_OwnedEnumeration(), this.getEnumeration(), null, "ownedEnumeration", null, 0, 1, EnumerationParameterDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnumerationParameterDescriptor_InheritedEnumerations(), this.getEnumeration(), null, "inheritedEnumerations", null, 0, -1, EnumerationParameterDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnumerationParameterDescriptor_DefaultLiteral(), this.getEnumerationLiteral(), null, "defaultLiteral", null, 1, 1, EnumerationParameterDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEnumerationParameterDescriptor_Exclusive(), ecorePackage.getEBoolean(), "exclusive", "true", 1, 1, EnumerationParameterDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEnumerationParameterDescriptor_EnumerationOrder(), this.getEnumerationOrder(), "enumerationOrder", "OwnedFirst", 1, 1, EnumerationParameterDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEnumerationParameterDescriptor_Literals(), this.getEnumerationLiteral(), null, "literals", null, 0, -1, EnumerationParameterDescriptor.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = addEOperation(enumerationParameterDescriptorEClass, this.getEnumerationLiteral(), "getLiteral", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(enumerationParameterDescriptorEClass, this.getEnumerationLiteral(), "getLiteralByValue", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "value", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(enumerationEClass, Enumeration.class, "Enumeration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumeration_OwnedLiterals(), this.getEnumerationLiteral(), null, "ownedLiterals", null, 0, -1, Enumeration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnumeration_InheritedLiterals(), this.getEnumerationLiteral(), null, "inheritedLiterals", null, 0, -1, Enumeration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumeration_LiteralOrder(), this.getEnumerationLiteralOrder(), "literalOrder", "InheritedFirst", 1, 1, Enumeration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEnumeration_Literals(), this.getEnumerationLiteral(), null, "literals", null, 0, -1, Enumeration.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(enumerationLiteralEClass, EnumerationLiteral.class, "EnumerationLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumerationLiteral_Value(), ecorePackage.getEString(), "value", null, 1, 1, EnumerationLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(ioTypeEEnum, IOType.class, "IOType");
		addEEnumLiteral(ioTypeEEnum, IOType.SCALAR);
		addEEnumLiteral(ioTypeEEnum, IOType.LOGIC);
		addEEnumLiteral(ioTypeEEnum, IOType.MIXED);

		initEEnum(booleanValueEEnum, BooleanValue.class, "BooleanValue");
		addEEnumLiteral(booleanValueEEnum, BooleanValue.TRUE);
		addEEnumLiteral(booleanValueEEnum, BooleanValue.FALSE);
		addEEnumLiteral(booleanValueEEnum, BooleanValue.UNSPECIFIED);

		initEEnum(enumerationLiteralOrderEEnum, EnumerationLiteralOrder.class, "EnumerationLiteralOrder");
		addEEnumLiteral(enumerationLiteralOrderEEnum, EnumerationLiteralOrder.OWNED_FIRST);
		addEEnumLiteral(enumerationLiteralOrderEEnum, EnumerationLiteralOrder.INHERITED_FIRST);

		initEEnum(enumerationOrderEEnum, EnumerationOrder.class, "EnumerationOrder");
		addEEnumLiteral(enumerationOrderEEnum, EnumerationOrder.OWNED_FIRST);
		addEEnumLiteral(enumerationOrderEEnum, EnumerationOrder.INHERITED_FIRST);

		// Initialize data types
		initEDataType(uriEDataType, org.eclipse.emf.common.util.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// duplicates
		createDuplicatesAnnotations();
		// redefines
		createRedefinesAnnotations();
	}

	/**
	 * Initializes the annotations for <b>duplicates</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createDuplicatesAnnotations() {
		String source = "duplicates";		
		addAnnotation
		  (parameterEClass, 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (parameterDescriptorEClass, 
		   source, 
		   new String[] {
		   });			
		addAnnotation
		  (enumerationEClass, 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>redefines</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createRedefinesAnnotations() {
		String source = "redefines";				
		addAnnotation
		  (getExpressionParameterDescriptor_DefaultValue(), 
		   source, 
		   new String[] {
		   },
		   new org.eclipse.emf.common.util.URI[] {
			 org.eclipse.emf.common.util.URI.createURI(eNS_URI).appendFragment("//ParameterDescriptor/%duplicates%/defaultValue")
		   });	
	}

} //BlockDiagramPackageImpl
