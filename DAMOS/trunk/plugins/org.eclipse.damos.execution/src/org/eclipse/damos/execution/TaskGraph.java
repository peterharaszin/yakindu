/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.execution;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.execution.TaskGraph#getInputNodes <em>Input Nodes</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.TaskGraph#getLatchNodes <em>Latch Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.execution.ExecutionPackage#getTaskGraph()
 * @model
 * @generated
 */
public interface TaskGraph extends Graph {

	/**
	 * Returns the value of the '<em><b>Input Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.execution.TaskInputNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.execution.TaskInputNode#getTaskGraph <em>Task Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Nodes</em>' containment reference list.
	 * @see org.eclipse.damos.execution.ExecutionPackage#getTaskGraph_InputNodes()
	 * @see org.eclipse.damos.execution.TaskInputNode#getTaskGraph
	 * @model opposite="taskGraph" containment="true"
	 * @generated
	 */
	EList<TaskInputNode> getInputNodes();

	/**
	 * Returns the value of the '<em><b>Latch Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.damos.execution.LatchNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.execution.LatchNode#getTaskNodes <em>Task Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Latch Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Latch Nodes</em>' reference list.
	 * @see org.eclipse.damos.execution.ExecutionPackage#getTaskGraph_LatchNodes()
	 * @see org.eclipse.damos.execution.LatchNode#getTaskNodes
	 * @model opposite="taskNodes"
	 * @generated
	 */
	EList<LatchNode> getLatchNodes();
} // TaskNode
