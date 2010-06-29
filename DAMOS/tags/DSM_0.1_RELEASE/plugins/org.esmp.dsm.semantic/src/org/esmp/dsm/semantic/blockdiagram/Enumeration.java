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
 * A representation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.Enumeration#getOwnedLiterals <em>Owned Literals</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.Enumeration#getInheritedLiterals <em>Inherited Literals</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.Enumeration#getLiteralOrder <em>Literal Order</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.Enumeration#getLiterals <em>Literals</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getEnumeration()
 * @model
 * @generated
 */
public interface Enumeration extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owned Literals</b></em>' containment reference list.
	 * The list contents are of type {@link org.esmp.dsm.semantic.blockdiagram.EnumerationLiteral}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Literals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Literals</em>' containment reference list.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getEnumeration_OwnedLiterals()
	 * @model containment="true"
	 * @generated
	 */
	EList<EnumerationLiteral> getOwnedLiterals();

	/**
	 * Returns the value of the '<em><b>Inherited Literals</b></em>' reference list.
	 * The list contents are of type {@link org.esmp.dsm.semantic.blockdiagram.EnumerationLiteral}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherited Literals</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherited Literals</em>' reference list.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getEnumeration_InheritedLiterals()
	 * @model
	 * @generated
	 */
	EList<EnumerationLiteral> getInheritedLiterals();

	/**
	 * Returns the value of the '<em><b>Literal Order</b></em>' attribute.
	 * The default value is <code>"InheritedFirst"</code>.
	 * The literals are from the enumeration {@link org.esmp.dsm.semantic.blockdiagram.EnumerationLiteralOrder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal Order</em>' attribute.
	 * @see org.esmp.dsm.semantic.blockdiagram.EnumerationLiteralOrder
	 * @see #setLiteralOrder(EnumerationLiteralOrder)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getEnumeration_LiteralOrder()
	 * @model default="InheritedFirst" required="true" ordered="false"
	 * @generated
	 */
	EnumerationLiteralOrder getLiteralOrder();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.Enumeration#getLiteralOrder <em>Literal Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal Order</em>' attribute.
	 * @see org.esmp.dsm.semantic.blockdiagram.EnumerationLiteralOrder
	 * @see #getLiteralOrder()
	 * @generated
	 */
	void setLiteralOrder(EnumerationLiteralOrder value);

	/**
	 * Returns the value of the '<em><b>Literals</b></em>' reference list.
	 * The list contents are of type {@link org.esmp.dsm.semantic.blockdiagram.EnumerationLiteral}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literals</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literals</em>' reference list.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getEnumeration_Literals()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<EnumerationLiteral> getLiterals();

} // Enumeration
