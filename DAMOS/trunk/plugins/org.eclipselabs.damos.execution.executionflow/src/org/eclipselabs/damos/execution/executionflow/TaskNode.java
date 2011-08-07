/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionflow;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.TaskNode#getInputNodes <em>Input Nodes</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.TaskNode#getLatchNodes <em>Latch Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getTaskNode()
 * @model
 * @generated
 */
public interface TaskNode extends Subgraph {

	/**
	 * Returns the value of the '<em><b>Input Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.executionflow.TaskInputNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.execution.executionflow.TaskInputNode#getTaskNode <em>Task Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Nodes</em>' containment reference list.
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getTaskNode_InputNodes()
	 * @see org.eclipselabs.damos.execution.executionflow.TaskInputNode#getTaskNode
	 * @model opposite="taskNode" containment="true"
	 * @generated
	 */
	EList<TaskInputNode> getInputNodes();

	/**
	 * Returns the value of the '<em><b>Latch Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.executionflow.LatchNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.execution.executionflow.LatchNode#getTaskNodes <em>Task Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Latch Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Latch Nodes</em>' reference list.
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getTaskNode_LatchNodes()
	 * @see org.eclipselabs.damos.execution.executionflow.LatchNode#getTaskNodes
	 * @model opposite="taskNodes"
	 * @generated
	 */
	EList<LatchNode> getLatchNodes();
} // TaskNode
