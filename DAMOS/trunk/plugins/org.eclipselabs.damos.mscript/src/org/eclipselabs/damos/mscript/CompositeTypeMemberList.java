/**
 */
package org.eclipselabs.damos.mscript;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Type Member List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.CompositeTypeMemberList#getTypeSpecifier <em>Type Specifier</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.CompositeTypeMemberList#getMembers <em>Members</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getCompositeTypeMemberList()
 * @model
 * @generated
 */
public interface CompositeTypeMemberList extends EObject {
	/**
	 * Returns the value of the '<em><b>Type Specifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Specifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Specifier</em>' containment reference.
	 * @see #setTypeSpecifier(TypeSpecifier)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getCompositeTypeMemberList_TypeSpecifier()
	 * @model containment="true"
	 * @generated
	 */
	TypeSpecifier getTypeSpecifier();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.CompositeTypeMemberList#getTypeSpecifier <em>Type Specifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Specifier</em>' containment reference.
	 * @see #getTypeSpecifier()
	 * @generated
	 */
	void setTypeSpecifier(TypeSpecifier value);

	/**
	 * Returns the value of the '<em><b>Members</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.CompositeTypeMember}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.mscript.CompositeTypeMember#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getCompositeTypeMemberList_Members()
	 * @see org.eclipselabs.damos.mscript.CompositeTypeMember#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<CompositeTypeMember> getMembers();

} // CompositeTypeMemberList
