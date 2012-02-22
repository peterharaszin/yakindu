/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dconfig;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selection Property Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.SelectionPropertyBody#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.SelectionPropertyBody#getBindings <em>Bindings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getSelectionPropertyBody()
 * @model
 * @generated
 */
public interface SelectionPropertyBody extends PropertyContainer {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.dconfig.SelectionProperty#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(SelectionProperty)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getSelectionPropertyBody_Owner()
	 * @see org.eclipselabs.damos.dconfig.SelectionProperty#getBody
	 * @model opposite="body" transient="false"
	 * @generated
	 */
	SelectionProperty getOwner();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.SelectionPropertyBody#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(SelectionProperty value);

	/**
	 * Returns the value of the '<em><b>Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.dconfig.Binding}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bindings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bindings</em>' containment reference list.
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getSelectionPropertyBody_Bindings()
	 * @model containment="true"
	 * @generated
	 */
	EList<Binding> getBindings();

} // SelectionPropertyBody
