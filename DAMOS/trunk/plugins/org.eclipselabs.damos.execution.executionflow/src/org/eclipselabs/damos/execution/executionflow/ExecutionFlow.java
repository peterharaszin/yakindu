/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionflow;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.dml.Fragment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.ExecutionFlow#getTopLevelFragment <em>Top Level Fragment</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.ExecutionFlow#getGraph <em>Graph</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.ExecutionFlow#getDataFlows <em>Data Flows</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.ExecutionFlow#getAsynchronousZoneCount <em>Asynchronous Zone Count</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.ExecutionFlow#getTaskNodes <em>Task Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getExecutionFlow()
 * @model
 * @generated
 */
public interface ExecutionFlow extends EObject {
	/**
	 * Returns the value of the '<em><b>Top Level Fragment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top Level Fragment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top Level Fragment</em>' reference.
	 * @see #setTopLevelFragment(Fragment)
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getExecutionFlow_TopLevelFragment()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Fragment getTopLevelFragment();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.execution.executionflow.ExecutionFlow#getTopLevelFragment <em>Top Level Fragment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top Level Fragment</em>' reference.
	 * @see #getTopLevelFragment()
	 * @generated
	 */
	void setTopLevelFragment(Fragment value);

	/**
	 * Returns the value of the '<em><b>Graph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph</em>' containment reference.
	 * @see #setGraph(Graph)
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getExecutionFlow_Graph()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Graph getGraph();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.execution.executionflow.ExecutionFlow#getGraph <em>Graph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph</em>' containment reference.
	 * @see #getGraph()
	 * @generated
	 */
	void setGraph(Graph value);

	/**
	 * Returns the value of the '<em><b>Data Flows</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.executionflow.DataFlow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Flows</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Flows</em>' containment reference list.
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getExecutionFlow_DataFlows()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<DataFlow> getDataFlows();

	/**
	 * Returns the value of the '<em><b>Asynchronous Zone Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Asynchronous Zone Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Asynchronous Zone Count</em>' attribute.
	 * @see #setAsynchronousZoneCount(int)
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getExecutionFlow_AsynchronousZoneCount()
	 * @model required="true"
	 * @generated
	 */
	int getAsynchronousZoneCount();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.execution.executionflow.ExecutionFlow#getAsynchronousZoneCount <em>Asynchronous Zone Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Asynchronous Zone Count</em>' attribute.
	 * @see #getAsynchronousZoneCount()
	 * @generated
	 */
	void setAsynchronousZoneCount(int value);

	/**
	 * Returns the value of the '<em><b>Task Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.executionflow.TaskNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Nodes</em>' containment reference list.
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getExecutionFlow_TaskNodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<TaskNode> getTaskNodes();

} // ExecutionFlow
