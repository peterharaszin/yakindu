/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.Block#getInputPorts <em>Input Ports</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.Block#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.Block#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.Block#getOutputPorts <em>Output Ports</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.Block#getType <em>Type</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.Block#isVirtual <em>Virtual</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.Block#getBlockDiagram <em>Block Diagram</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getBlock()
 * @model
 * @generated
 */
public interface Block extends NamedElement, ParameterableElement {

	/**
	 * Returns the value of the '<em><b>Input Ports</b></em>' reference list.
	 * The list contents are of type {@link org.esmp.dsm.semantic.blockdiagram.InputPort}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Ports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Ports</em>' reference list.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getBlock_InputPorts()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<InputPort> getInputPorts();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' containment reference list.
	 * The list contents are of type {@link org.esmp.dsm.semantic.blockdiagram.Output}.
	 * It is bidirectional and its opposite is '{@link org.esmp.dsm.semantic.blockdiagram.Output#getBlock <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' containment reference list.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getBlock_Outputs()
	 * @see org.esmp.dsm.semantic.blockdiagram.Output#getBlock
	 * @model opposite="block" containment="true"
	 * @generated
	 */
	EList<Output> getOutputs();

	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link org.esmp.dsm.semantic.blockdiagram.Input}.
	 * It is bidirectional and its opposite is '{@link org.esmp.dsm.semantic.blockdiagram.Input#getBlock <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' containment reference list.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getBlock_Inputs()
	 * @see org.esmp.dsm.semantic.blockdiagram.Input#getBlock
	 * @model opposite="block" containment="true"
	 * @generated
	 */
	EList<Input> getInputs();

	/**
	 * Returns the value of the '<em><b>Output Ports</b></em>' reference list.
	 * The list contents are of type {@link org.esmp.dsm.semantic.blockdiagram.OutputPort}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Ports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Ports</em>' reference list.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getBlock_OutputPorts()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<OutputPort> getOutputPorts();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(BlockType)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getBlock_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	BlockType getType();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.Block#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(BlockType value);

	/**
	 * Returns the value of the '<em><b>Virtual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Virtual</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Virtual</em>' attribute.
	 * @see #setVirtual(boolean)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getBlock_Virtual()
	 * @model required="true" transient="true" ordered="false"
	 * @generated
	 */
	boolean isVirtual();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.Block#isVirtual <em>Virtual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Virtual</em>' attribute.
	 * @see #isVirtual()
	 * @generated
	 */
	void setVirtual(boolean value);

	/**
	 * Returns the value of the '<em><b>Block Diagram</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.esmp.dsm.semantic.blockdiagram.BlockDiagram#getBlocks <em>Blocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block Diagram</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block Diagram</em>' container reference.
	 * @see #setBlockDiagram(BlockDiagram)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getBlock_BlockDiagram()
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagram#getBlocks
	 * @model opposite="blocks" required="true" transient="false" ordered="false"
	 * @generated
	 */
	BlockDiagram getBlockDiagram();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.Block#getBlockDiagram <em>Block Diagram</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block Diagram</em>' container reference.
	 * @see #getBlockDiagram()
	 * @generated
	 */
	void setBlockDiagram(BlockDiagram value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" nameRequired="true" nameOrdered="false"
	 * @generated
	 */
	Input getInput(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" nameRequired="true" nameOrdered="false"
	 * @generated
	 */
	Output getOutput(String name);

} // Block
