/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Latch Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.LatchNode#getTaskNodes <em>Task Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.execution.ExecutionPackage#getLatchNode()
 * @model
 * @generated
 */
public interface LatchNode extends ComponentNode {
	/**
	 * Returns the value of the '<em><b>Task Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.TaskGraph}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.execution.TaskGraph#getLatchNodes <em>Latch Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Nodes</em>' reference list.
	 * @see org.eclipselabs.damos.execution.ExecutionPackage#getLatchNode_TaskNodes()
	 * @see org.eclipselabs.damos.execution.TaskGraph#getLatchNodes
	 * @model opposite="latchNodes"
	 * @generated
	 */
	EList<TaskGraph> getTaskNodes();

} // LatchNode
