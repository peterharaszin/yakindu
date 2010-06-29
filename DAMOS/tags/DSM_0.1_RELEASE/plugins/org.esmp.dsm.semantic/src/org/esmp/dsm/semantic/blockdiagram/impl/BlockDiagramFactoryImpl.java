/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
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
import org.esmp.dsm.semantic.blockdiagram.IOType;
import org.esmp.dsm.semantic.blockdiagram.Input;
import org.esmp.dsm.semantic.blockdiagram.InputPort;
import org.esmp.dsm.semantic.blockdiagram.InputSpecification;
import org.esmp.dsm.semantic.blockdiagram.Output;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;
import org.esmp.dsm.semantic.blockdiagram.OutputSpecification;
import org.esmp.dsm.semantic.blockdiagram.Parameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BlockDiagramFactoryImpl extends EFactoryImpl implements BlockDiagramFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BlockDiagramFactory init() {
		try {
			BlockDiagramFactory theBlockDiagramFactory = (BlockDiagramFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.esmp.org/dsm/BlockDiagram/1.0.0"); 
			if (theBlockDiagramFactory != null) {
				return theBlockDiagramFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BlockDiagramFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockDiagramFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case BlockDiagramPackage.BLOCK_DIAGRAM: return createBlockDiagram();
			case BlockDiagramPackage.BLOCK: return createBlock();
			case BlockDiagramPackage.PARAMETER: return createParameter();
			case BlockDiagramPackage.INPUT_PORT: return createInputPort();
			case BlockDiagramPackage.CONNECTION: return createConnection();
			case BlockDiagramPackage.OUTPUT_PORT: return createOutputPort();
			case BlockDiagramPackage.OUTPUT: return createOutput();
			case BlockDiagramPackage.OUTPUT_SPECIFICATION: return createOutputSpecification();
			case BlockDiagramPackage.INPUT: return createInput();
			case BlockDiagramPackage.INPUT_SPECIFICATION: return createInputSpecification();
			case BlockDiagramPackage.BLOCK_TYPE: return createBlockType();
			case BlockDiagramPackage.BLOCK_CATEGORY: return createBlockCategory();
			case BlockDiagramPackage.EXPRESSION_PARAMETER_DESCRIPTOR: return createExpressionParameterDescriptor();
			case BlockDiagramPackage.BOOLEAN_PARAMETER_DESCRIPTOR: return createBooleanParameterDescriptor();
			case BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR: return createEnumerationParameterDescriptor();
			case BlockDiagramPackage.ENUMERATION: return createEnumeration();
			case BlockDiagramPackage.ENUMERATION_LITERAL: return createEnumerationLiteral();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case BlockDiagramPackage.IO_TYPE:
				return createIOTypeFromString(eDataType, initialValue);
			case BlockDiagramPackage.BOOLEAN_VALUE:
				return createBooleanValueFromString(eDataType, initialValue);
			case BlockDiagramPackage.ENUMERATION_LITERAL_ORDER:
				return createEnumerationLiteralOrderFromString(eDataType, initialValue);
			case BlockDiagramPackage.ENUMERATION_ORDER:
				return createEnumerationOrderFromString(eDataType, initialValue);
			case BlockDiagramPackage.URI:
				return createURIFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case BlockDiagramPackage.IO_TYPE:
				return convertIOTypeToString(eDataType, instanceValue);
			case BlockDiagramPackage.BOOLEAN_VALUE:
				return convertBooleanValueToString(eDataType, instanceValue);
			case BlockDiagramPackage.ENUMERATION_LITERAL_ORDER:
				return convertEnumerationLiteralOrderToString(eDataType, instanceValue);
			case BlockDiagramPackage.ENUMERATION_ORDER:
				return convertEnumerationOrderToString(eDataType, instanceValue);
			case BlockDiagramPackage.URI:
				return convertURIToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockDiagram createBlockDiagram() {
		BlockDiagramImpl blockDiagram = new BlockDiagramImpl();
		return blockDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block createBlock() {
		BlockImpl block = new BlockImpl();
		return block;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection createConnection() {
		ConnectionImpl connection = new ConnectionImpl();
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPort createInputPort() {
		InputPortImpl inputPort = new InputPortImpl();
		return inputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputPort createOutputPort() {
		OutputPortImpl outputPort = new OutputPortImpl();
		return outputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Input createInput() {
		InputImpl input = new InputImpl();
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Output createOutput() {
		OutputImpl output = new OutputImpl();
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputSpecification createOutputSpecification() {
		OutputSpecificationImpl outputSpecification = new OutputSpecificationImpl();
		return outputSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputSpecification createInputSpecification() {
		InputSpecificationImpl inputSpecification = new InputSpecificationImpl();
		return inputSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockType createBlockType() {
		BlockTypeImpl blockType = new BlockTypeImpl();
		return blockType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionParameterDescriptor createExpressionParameterDescriptor() {
		ExpressionParameterDescriptorImpl expressionParameterDescriptor = new ExpressionParameterDescriptorImpl();
		return expressionParameterDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationParameterDescriptor createEnumerationParameterDescriptor() {
		EnumerationParameterDescriptorImpl enumerationParameterDescriptor = new EnumerationParameterDescriptorImpl();
		return enumerationParameterDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enumeration createEnumeration() {
		EnumerationImpl enumeration = new EnumerationImpl();
		return enumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI createURIFromString(EDataType eDataType, String initialValue) {
		return (URI)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertURIToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanParameterDescriptor createBooleanParameterDescriptor() {
		BooleanParameterDescriptorImpl booleanParameterDescriptor = new BooleanParameterDescriptorImpl();
		return booleanParameterDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationLiteral createEnumerationLiteral() {
		EnumerationLiteralImpl enumerationLiteral = new EnumerationLiteralImpl();
		return enumerationLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IOType createIOTypeFromString(EDataType eDataType, String initialValue) {
		IOType result = IOType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIOTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanValue createBooleanValueFromString(EDataType eDataType, String initialValue) {
		BooleanValue result = BooleanValue.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBooleanValueToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationLiteralOrder createEnumerationLiteralOrderFromString(EDataType eDataType, String initialValue) {
		EnumerationLiteralOrder result = EnumerationLiteralOrder.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnumerationLiteralOrderToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationOrder createEnumerationOrderFromString(EDataType eDataType, String initialValue) {
		EnumerationOrder result = EnumerationOrder.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnumerationOrderToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockCategory createBlockCategory() {
		BlockCategoryImpl blockCategory = new BlockCategoryImpl();
		return blockCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockDiagramPackage getBlockDiagramPackage() {
		return (BlockDiagramPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BlockDiagramPackage getPackage() {
		return BlockDiagramPackage.eINSTANCE;
	}

} //BlockDiagramFactoryImpl
