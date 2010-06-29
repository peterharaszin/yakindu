/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.InputSpecification#getDirectFeedthroughExpression <em>Direct Feedthrough Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getInputSpecification()
 * @model
 * @generated
 */
public interface InputSpecification extends IOSpecification {
	/**
	 * Returns the value of the '<em><b>Direct Feedthrough Expression</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direct Feedthrough Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direct Feedthrough Expression</em>' attribute.
	 * @see #setDirectFeedthroughExpression(String)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getInputSpecification_DirectFeedthroughExpression()
	 * @model default="true" required="true" ordered="false"
	 * @generated
	 */
	String getDirectFeedthroughExpression();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.InputSpecification#getDirectFeedthroughExpression <em>Direct Feedthrough Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direct Feedthrough Expression</em>' attribute.
	 * @see #getDirectFeedthroughExpression()
	 * @generated
	 */
	void setDirectFeedthroughExpression(String value);

} // InputSpecification
