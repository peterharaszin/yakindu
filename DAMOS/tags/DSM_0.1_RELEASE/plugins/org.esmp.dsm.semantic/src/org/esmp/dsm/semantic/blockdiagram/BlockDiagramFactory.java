/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage
 * @generated
 */
public interface BlockDiagramFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BlockDiagramFactory eINSTANCE = org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Block Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block Diagram</em>'.
	 * @generated
	 */
	BlockDiagram createBlockDiagram();

	/**
	 * Returns a new object of class '<em>Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block</em>'.
	 * @generated
	 */
	Block createBlock();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	Parameter createParameter();

	/**
	 * Returns a new object of class '<em>Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection</em>'.
	 * @generated
	 */
	Connection createConnection();

	/**
	 * Returns a new object of class '<em>Input Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Port</em>'.
	 * @generated
	 */
	InputPort createInputPort();

	/**
	 * Returns a new object of class '<em>Output Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Port</em>'.
	 * @generated
	 */
	OutputPort createOutputPort();

	/**
	 * Returns a new object of class '<em>Input</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input</em>'.
	 * @generated
	 */
	Input createInput();

	/**
	 * Returns a new object of class '<em>Output</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output</em>'.
	 * @generated
	 */
	Output createOutput();

	/**
	 * Returns a new object of class '<em>Output Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Specification</em>'.
	 * @generated
	 */
	OutputSpecification createOutputSpecification();

	/**
	 * Returns a new object of class '<em>Input Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Specification</em>'.
	 * @generated
	 */
	InputSpecification createInputSpecification();

	/**
	 * Returns a new object of class '<em>Block Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block Type</em>'.
	 * @generated
	 */
	BlockType createBlockType();

	/**
	 * Returns a new object of class '<em>Expression Parameter Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression Parameter Descriptor</em>'.
	 * @generated
	 */
	ExpressionParameterDescriptor createExpressionParameterDescriptor();

	/**
	 * Returns a new object of class '<em>Enumeration Parameter Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration Parameter Descriptor</em>'.
	 * @generated
	 */
	EnumerationParameterDescriptor createEnumerationParameterDescriptor();

	/**
	 * Returns a new object of class '<em>Enumeration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration</em>'.
	 * @generated
	 */
	Enumeration createEnumeration();

	/**
	 * Returns a new object of class '<em>Boolean Parameter Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Parameter Descriptor</em>'.
	 * @generated
	 */
	BooleanParameterDescriptor createBooleanParameterDescriptor();

	/**
	 * Returns a new object of class '<em>Enumeration Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration Literal</em>'.
	 * @generated
	 */
	EnumerationLiteral createEnumerationLiteral();

	/**
	 * Returns a new object of class '<em>Block Category</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block Category</em>'.
	 * @generated
	 */
	BlockCategory createBlockCategory();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BlockDiagramPackage getBlockDiagramPackage();

} //BlockDiagramFactory
