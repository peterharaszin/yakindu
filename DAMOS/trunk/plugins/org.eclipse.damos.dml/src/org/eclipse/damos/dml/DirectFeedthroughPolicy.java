/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Direct Feedthrough Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.DirectFeedthroughPolicy#getInputDefinition <em>Input Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dml.DMLPackage#getDirectFeedthroughPolicy()
 * @model abstract="true"
 * @generated
 */
public interface DirectFeedthroughPolicy extends EObject {
	/**
	 * Returns the value of the '<em><b>Input Definition</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.dml.InputDefinition#getDirectFeedthroughPolicy <em>Direct Feedthrough Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Definition</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Definition</em>' container reference.
	 * @see #setInputDefinition(InputDefinition)
	 * @see org.eclipse.damos.dml.DMLPackage#getDirectFeedthroughPolicy_InputDefinition()
	 * @see org.eclipse.damos.dml.InputDefinition#getDirectFeedthroughPolicy
	 * @model opposite="directFeedthroughPolicy" required="true" transient="false" ordered="false"
	 * @generated
	 */
	InputDefinition getInputDefinition();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dml.DirectFeedthroughPolicy#getInputDefinition <em>Input Definition</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Definition</em>' container reference.
	 * @see #getInputDefinition()
	 * @generated
	 */
	void setInputDefinition(InputDefinition value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean computeDirectFeedthrough();

} // DirectFeedthroughPolicy
