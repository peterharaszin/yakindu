/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Input Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.TaskInputNode#getTaskGraph <em>Task Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.execution.ExecutionPackage#getTaskInputNode()
 * @model
 * @generated
 */
public interface TaskInputNode extends Node {

	/**
	 * Returns the value of the '<em><b>Task Graph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.execution.TaskGraph#getInputNodes <em>Input Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Node</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Graph</em>' container reference.
	 * @see #setTaskGraph(TaskGraph)
	 * @see org.eclipselabs.damos.execution.ExecutionPackage#getTaskInputNode_TaskGraph()
	 * @see org.eclipselabs.damos.execution.TaskGraph#getInputNodes
	 * @model opposite="inputNodes" required="true" transient="false"
	 * @generated
	 */
	TaskGraph getTaskGraph();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.execution.TaskInputNode#getTaskGraph <em>Task Graph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Graph</em>' container reference.
	 * @see #getTaskGraph()
	 * @generated
	 */
	void setTaskGraph(TaskGraph value);
} // TaskInputNode
