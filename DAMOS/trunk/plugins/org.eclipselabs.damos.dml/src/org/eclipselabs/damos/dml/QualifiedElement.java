/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.QualifiedElement#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.QualifiedElement#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.QualifiedElement#getQualifier <em>Qualifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dml.DMLPackage#getQualifiedElement()
 * @model abstract="true"
 * @generated
 */
public interface QualifiedElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualified Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualified Name</em>' attribute.
	 * @see #isSetQualifiedName()
	 * @see #unsetQualifiedName()
	 * @see #setQualifiedName(String)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getQualifiedElement_QualifiedName()
	 * @model unsettable="true" required="true" ordered="false"
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.QualifiedElement#getQualifiedName <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Name</em>' attribute.
	 * @see #isSetQualifiedName()
	 * @see #unsetQualifiedName()
	 * @see #getQualifiedName()
	 * @generated
	 */
	void setQualifiedName(String value);

	/**
	 * Unsets the value of the '{@link org.eclipselabs.damos.dml.QualifiedElement#getQualifiedName <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetQualifiedName()
	 * @see #getQualifiedName()
	 * @see #setQualifiedName(String)
	 * @generated
	 */
	void unsetQualifiedName();

	/**
	 * Returns whether the value of the '{@link org.eclipselabs.damos.dml.QualifiedElement#getQualifiedName <em>Qualified Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Qualified Name</em>' attribute is set.
	 * @see #unsetQualifiedName()
	 * @see #getQualifiedName()
	 * @see #setQualifiedName(String)
	 * @generated
	 */
	boolean isSetQualifiedName();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see org.eclipselabs.damos.dml.DMLPackage#getQualifiedElement_Name()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Returns the value of the '<em><b>Qualifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualifier</em>' attribute.
	 * @see org.eclipselabs.damos.dml.DMLPackage#getQualifiedElement_Qualifier()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	String getQualifier();

} // QualifiedElement
