/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.ActionNode#getChoiceNode <em>Choice Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.execution.ExecutionPackage#getActionNode()
 * @model
 * @generated
 */
public interface ActionNode extends CompoundNode {
	/**
	 * Returns the value of the '<em><b>Choice Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Choice Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Choice Node</em>' reference.
	 * @see #setChoiceNode(ComponentNode)
	 * @see org.eclipselabs.damos.execution.ExecutionPackage#getActionNode_ChoiceNode()
	 * @model
	 * @generated
	 */
	ComponentNode getChoiceNode();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.execution.ActionNode#getChoiceNode <em>Choice Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Choice Node</em>' reference.
	 * @see #getChoiceNode()
	 * @generated
	 */
	void setChoiceNode(ComponentNode value);

} // ActionNode
