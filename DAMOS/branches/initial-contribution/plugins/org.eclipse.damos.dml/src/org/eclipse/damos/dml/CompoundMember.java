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
 * A representation of the model object '<em><b>Compound Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.CompoundMember#getOwningCompound <em>Owning Compound</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dml.DMLPackage#getCompoundMember()
 * @model abstract="true"
 * @generated
 */
public interface CompoundMember extends EObject {

	/**
	 * Returns the value of the '<em><b>Owning Compound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Compound</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Compound</em>' reference.
	 * @see org.eclipse.damos.dml.DMLPackage#getCompoundMember_OwningCompound()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Compound getOwningCompound();
} // CompoundMember
