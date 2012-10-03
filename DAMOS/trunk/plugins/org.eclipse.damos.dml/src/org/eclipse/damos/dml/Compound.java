/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compound</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.Compound#getMembers <em>Members</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dml.DMLPackage#getCompound()
 * @model abstract="true"
 * @generated
 */
public interface Compound extends FragmentElement, CompoundMember {
	/**
	 * Returns the value of the '<em><b>Members</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.dml.CompoundMember}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members</em>' containment reference list.
	 * @see org.eclipse.damos.dml.DMLPackage#getCompound_Members()
	 * @model containment="true"
	 * @generated
	 */
	EList<CompoundMember> getMembers();

} // Compound
