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
 * A representation of the model object '<em><b>Enumeration Parameter Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor#getOwnedEnumeration <em>Owned Enumeration</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor#getInheritedEnumerations <em>Inherited Enumerations</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor#getDefaultLiteral <em>Default Literal</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor#isExclusive <em>Exclusive</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor#getEnumerationOrder <em>Enumeration Order</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor#getLiterals <em>Literals</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getEnumerationParameterDescriptor()
 * @model
 * @generated
 */
public interface EnumerationParameterDescriptor extends ParameterDescriptor {
	/**
	 * Returns the value of the '<em><b>Owned Enumeration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Enumeration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Enumeration</em>' containment reference.
	 * @see #setOwnedEnumeration(Enumeration)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getEnumerationParameterDescriptor_OwnedEnumeration()
	 * @model containment="true"
	 * @generated
	 */
	Enumeration getOwnedEnumeration();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor#getOwnedEnumeration <em>Owned Enumeration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Enumeration</em>' containment reference.
	 * @see #getOwnedEnumeration()
	 * @generated
	 */
	void setOwnedEnumeration(Enumeration value);

	/**
	 * Returns the value of the '<em><b>Inherited Enumerations</b></em>' reference list.
	 * The list contents are of type {@link org.esmp.dsm.semantic.blockdiagram.Enumeration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherited Enumerations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherited Enumerations</em>' reference list.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getEnumerationParameterDescriptor_InheritedEnumerations()
	 * @model
	 * @generated
	 */
	EList<Enumeration> getInheritedEnumerations();

	/**
	 * Returns the value of the '<em><b>Literals</b></em>' reference list.
	 * The list contents are of type {@link org.esmp.dsm.semantic.blockdiagram.EnumerationLiteral}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literals</em>' reference list.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getEnumerationParameterDescriptor_Literals()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<EnumerationLiteral> getLiterals();

	/**
	 * Returns the value of the '<em><b>Default Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Literal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Literal</em>' reference.
	 * @see #setDefaultLiteral(EnumerationLiteral)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getEnumerationParameterDescriptor_DefaultLiteral()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EnumerationLiteral getDefaultLiteral();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor#getDefaultLiteral <em>Default Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Literal</em>' reference.
	 * @see #getDefaultLiteral()
	 * @generated
	 */
	void setDefaultLiteral(EnumerationLiteral value);

	/**
	 * Returns the value of the '<em><b>Exclusive</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exclusive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exclusive</em>' attribute.
	 * @see #setExclusive(boolean)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getEnumerationParameterDescriptor_Exclusive()
	 * @model default="true" required="true" ordered="false"
	 * @generated
	 */
	boolean isExclusive();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor#isExclusive <em>Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exclusive</em>' attribute.
	 * @see #isExclusive()
	 * @generated
	 */
	void setExclusive(boolean value);

	/**
	 * Returns the value of the '<em><b>Enumeration Order</b></em>' attribute.
	 * The default value is <code>"OwnedFirst"</code>.
	 * The literals are from the enumeration {@link org.esmp.dsm.semantic.blockdiagram.EnumerationOrder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumeration Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumeration Order</em>' attribute.
	 * @see org.esmp.dsm.semantic.blockdiagram.EnumerationOrder
	 * @see #setEnumerationOrder(EnumerationOrder)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getEnumerationParameterDescriptor_EnumerationOrder()
	 * @model default="OwnedFirst" required="true" ordered="false"
	 * @generated
	 */
	EnumerationOrder getEnumerationOrder();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor#getEnumerationOrder <em>Enumeration Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enumeration Order</em>' attribute.
	 * @see org.esmp.dsm.semantic.blockdiagram.EnumerationOrder
	 * @see #getEnumerationOrder()
	 * @generated
	 */
	void setEnumerationOrder(EnumerationOrder value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" nameRequired="true" nameOrdered="false"
	 * @generated
	 */
	EnumerationLiteral getLiteral(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" valueRequired="true" valueOrdered="false"
	 * @generated
	 */
	EnumerationLiteral getLiteralByValue(String value);

} // EnumerationParameterDescriptor
