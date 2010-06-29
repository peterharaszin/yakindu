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
 * A representation of the model object '<em><b>Block Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.BlockDiagram#getBlocks <em>Blocks</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.BlockDiagram#getConnections <em>Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getBlockDiagram()
 * @model
 * @generated
 */
public interface BlockDiagram extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Connections</b></em>' containment reference list.
	 * The list contents are of type {@link org.esmp.dsm.semantic.blockdiagram.Connection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connections</em>' containment reference list.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getBlockDiagram_Connections()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Connection> getConnections();

	/**
	 * Returns the value of the '<em><b>Blocks</b></em>' containment reference list.
	 * The list contents are of type {@link org.esmp.dsm.semantic.blockdiagram.Block}.
	 * It is bidirectional and its opposite is '{@link org.esmp.dsm.semantic.blockdiagram.Block#getBlockDiagram <em>Block Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blocks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blocks</em>' containment reference list.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getBlockDiagram_Blocks()
	 * @see org.esmp.dsm.semantic.blockdiagram.Block#getBlockDiagram
	 * @model opposite="blockDiagram" containment="true" ordered="false"
	 * @generated
	 */
	EList<Block> getBlocks();

} // BlockDiagram
