/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.Port#getBlock <em>Block</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.Port#getIndex <em>Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getPort()
 * @model abstract="true"
 * @generated
 */
public interface Port extends ParameterableElement {

	/**
	 * Returns the value of the '<em><b>Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block</em>' reference.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getPort_Block()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	Block getBlock();

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getPort_Index()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	int getIndex();

} // Port
