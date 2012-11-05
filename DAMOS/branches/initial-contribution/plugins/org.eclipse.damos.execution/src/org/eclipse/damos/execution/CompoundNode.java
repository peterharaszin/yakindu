/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.execution;

import org.eclipse.damos.dml.Compound;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compound Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.execution.CompoundNode#getCompound <em>Compound</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.execution.ExecutionPackage#getCompoundNode()
 * @model
 * @generated
 */
public interface CompoundNode extends Subgraph {
	/**
	 * Returns the value of the '<em><b>Compound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compound</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compound</em>' reference.
	 * @see #setCompound(Compound)
	 * @see org.eclipse.damos.execution.ExecutionPackage#getCompoundNode_Compound()
	 * @model required="true"
	 * @generated
	 */
	Compound getCompound();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.execution.CompoundNode#getCompound <em>Compound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compound</em>' reference.
	 * @see #getCompound()
	 * @generated
	 */
	void setCompound(Compound value);

} // CompoundNode
