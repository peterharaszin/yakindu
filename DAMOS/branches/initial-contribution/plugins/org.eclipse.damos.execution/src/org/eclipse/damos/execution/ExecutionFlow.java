/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.execution;

import java.lang.Iterable;

import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.mscript.util.ISampleInterval;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.execution.ExecutionFlow#getTopLevelFragment <em>Top Level Fragment</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.ExecutionFlow#getGraph <em>Graph</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.ExecutionFlow#getDataFlows <em>Data Flows</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.ExecutionFlow#getAsynchronousZoneCount <em>Asynchronous Zone Count</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.ExecutionFlow#getTaskGraphs <em>Task Graphs</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.ExecutionFlow#getFundamentalSampleInterval <em>Fundamental Sample Interval</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.execution.ExecutionPackage#getExecutionFlow()
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
	 * @see org.eclipse.damos.execution.ExecutionPackage#getExecutionFlow_TopLevelFragment()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Fragment getTopLevelFragment();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.execution.ExecutionFlow#getTopLevelFragment <em>Top Level Fragment</em>}' reference.
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
	 * @see org.eclipse.damos.execution.ExecutionPackage#getExecutionFlow_Graph()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Graph getGraph();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.execution.ExecutionFlow#getGraph <em>Graph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph</em>' containment reference.
	 * @see #getGraph()
	 * @generated
	 */
	void setGraph(Graph value);

	/**
	 * Returns the value of the '<em><b>Data Flows</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.execution.DataFlow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Flows</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Flows</em>' containment reference list.
	 * @see org.eclipse.damos.execution.ExecutionPackage#getExecutionFlow_DataFlows()
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
	 * @see org.eclipse.damos.execution.ExecutionPackage#getExecutionFlow_AsynchronousZoneCount()
	 * @model required="true"
	 * @generated
	 */
	int getAsynchronousZoneCount();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.execution.ExecutionFlow#getAsynchronousZoneCount <em>Asynchronous Zone Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Asynchronous Zone Count</em>' attribute.
	 * @see #getAsynchronousZoneCount()
	 * @generated
	 */
	void setAsynchronousZoneCount(int value);

	/**
	 * Returns the value of the '<em><b>Task Graphs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.execution.TaskGraph}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Graphs</em>' containment reference list.
	 * @see org.eclipse.damos.execution.ExecutionPackage#getExecutionFlow_TaskGraphs()
	 * @model containment="true"
	 * @generated
	 */
	EList<TaskGraph> getTaskGraphs();

	/**
	 * Returns the value of the '<em><b>Fundamental Sample Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fundamental Sample Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fundamental Sample Interval</em>' attribute.
	 * @see #setFundamentalSampleInterval(ISampleInterval)
	 * @see org.eclipse.damos.execution.ExecutionPackage#getExecutionFlow_FundamentalSampleInterval()
	 * @model dataType="org.eclipse.damos.execution.ISampleInterval"
	 * @generated
	 */
	ISampleInterval getFundamentalSampleInterval();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.execution.ExecutionFlow#getFundamentalSampleInterval <em>Fundamental Sample Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fundamental Sample Interval</em>' attribute.
	 * @see #getFundamentalSampleInterval()
	 * @generated
	 */
	void setFundamentalSampleInterval(ISampleInterval value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	TreeIterator<Node> getAllNodesIterator();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.eclipse.damos.execution.Iterable<org.eclipse.damos.execution.Node>" required="true"
	 * @generated
	 */
	Iterable<Node> getAllNodes();

} // ExecutionFlow
