/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.InputDefinition#getDirectFeedthroughPolicy <em>Direct Feedthrough Policy</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dml.DMLPackage#getInputDefinition()
 * @model
 * @generated
 */
public interface InputDefinition extends InoutputDefinition {
	/**
	 * Returns the value of the '<em><b>Direct Feedthrough Policy</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.dml.DirectFeedthroughPolicy#getInputDefinition <em>Input Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direct Feedthrough Policy</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direct Feedthrough Policy</em>' containment reference.
	 * @see #setDirectFeedthroughPolicy(DirectFeedthroughPolicy)
	 * @see org.eclipse.damos.dml.DMLPackage#getInputDefinition_DirectFeedthroughPolicy()
	 * @see org.eclipse.damos.dml.DirectFeedthroughPolicy#getInputDefinition
	 * @model opposite="inputDefinition" containment="true" ordered="false"
	 * @generated
	 */
	DirectFeedthroughPolicy getDirectFeedthroughPolicy();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dml.InputDefinition#getDirectFeedthroughPolicy <em>Direct Feedthrough Policy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direct Feedthrough Policy</em>' containment reference.
	 * @see #getDirectFeedthroughPolicy()
	 * @generated
	 */
	void setDirectFeedthroughPolicy(DirectFeedthroughPolicy value);

} // InputDefinition
