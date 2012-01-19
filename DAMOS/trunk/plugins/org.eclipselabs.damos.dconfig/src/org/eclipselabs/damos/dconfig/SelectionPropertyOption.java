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
 * A representation of the model object '<em><b>Selection Property Option</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.SelectionPropertyOption#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.SelectionPropertyOption#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.SelectionPropertyOption#getResourceDeclarations <em>Resource Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getSelectionPropertyOption()
 * @model
 * @generated
 */
public interface SelectionPropertyOption extends PropertyDeclarationContainer {
	/**
	 * Returns the value of the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualified Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualified Name</em>' attribute.
	 * @see #setQualifiedName(String)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getSelectionPropertyOption_QualifiedName()
	 * @model
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.SelectionPropertyOption#getQualifiedName <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Name</em>' attribute.
	 * @see #getQualifiedName()
	 * @generated
	 */
	void setQualifiedName(String value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(SelectionPropertyDeclaration)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getSelectionPropertyOption_Target()
	 * @model
	 * @generated
	 */
	SelectionPropertyDeclaration getTarget();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.SelectionPropertyOption#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(SelectionPropertyDeclaration value);

	/**
	 * Returns the value of the '<em><b>Resource Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.dconfig.ResourceDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Declarations</em>' containment reference list.
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getSelectionPropertyOption_ResourceDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ResourceDeclaration> getResourceDeclarations();

} // SelectionPropertyOption
