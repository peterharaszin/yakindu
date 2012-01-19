/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionflow;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.dml.InputConnector;
import org.eclipselabs.damos.dml.OutputConnector;
import org.eclipselabs.damos.dml.util.SystemPath;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.Node#getGraph <em>Graph</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.Node#getIncomingEdges <em>Incoming Edges</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.Node#getOutgoingEdges <em>Outgoing Edges</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.Node#getIncomingDataFlows <em>Incoming Data Flows</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.Node#getOutgoingDataFlows <em>Outgoing Data Flows</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.Node#getSystemPath <em>System Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getNode()
 * @model abstract="true"
 * @generated
 */
public interface Node extends EObject {
	/**
	 * Returns the value of the '<em><b>Graph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.execution.executionflow.Graph#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph</em>' container reference.
	 * @see #setGraph(Graph)
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getNode_Graph()
	 * @see org.eclipselabs.damos.execution.executionflow.Graph#getNodes
	 * @model opposite="nodes" transient="false"
	 * @generated
	 */
	Graph getGraph();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.execution.executionflow.Node#getGraph <em>Graph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph</em>' container reference.
	 * @see #getGraph()
	 * @generated
	 */
	void setGraph(Graph value);

	/**
	 * Returns the value of the '<em><b>Incoming Edges</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.executionflow.Edge}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.execution.executionflow.Edge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Edges</em>' reference list.
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getNode_IncomingEdges()
	 * @see org.eclipselabs.damos.execution.executionflow.Edge#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Edge> getIncomingEdges();

	/**
	 * Returns the value of the '<em><b>Outgoing Edges</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.executionflow.Edge}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.execution.executionflow.Edge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Edges</em>' reference list.
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getNode_OutgoingEdges()
	 * @see org.eclipselabs.damos.execution.executionflow.Edge#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Edge> getOutgoingEdges();

	/**
	 * Returns the value of the '<em><b>Incoming Data Flows</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Data Flows</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Data Flows</em>' reference list.
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getNode_IncomingDataFlows()
	 * @see org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd#getNode
	 * @model opposite="node"
	 * @generated
	 */
	EList<DataFlowTargetEnd> getIncomingDataFlows();

	/**
	 * Returns the value of the '<em><b>Outgoing Data Flows</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Data Flows</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Data Flows</em>' reference list.
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getNode_OutgoingDataFlows()
	 * @see org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd#getNode
	 * @model opposite="node"
	 * @generated
	 */
	EList<DataFlowSourceEnd> getOutgoingDataFlows();

	/**
	 * Returns the value of the '<em><b>System Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Path</em>' attribute.
	 * @see #setSystemPath(SystemPath)
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getNode_SystemPath()
	 * @model dataType="org.eclipselabs.damos.execution.executionflow.SystemPath"
	 * @generated
	 */
	SystemPath getSystemPath();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.execution.executionflow.Node#getSystemPath <em>System Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Path</em>' attribute.
	 * @see #getSystemPath()
	 * @generated
	 */
	void setSystemPath(SystemPath value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" targetRequired="true" targetOrdered="false"
	 * @generated
	 */
	DataFlowTargetEnd getIncomingDataFlow(InputConnector target);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" sourceRequired="true" sourceOrdered="false"
	 * @generated
	 */
	DataFlowSourceEnd getOutgoingDataFlow(OutputConnector source);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Node> getDrivingNodes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Node> getDrivenNodes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<DataFlowSourceEnd> getDrivingEnds();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<DataFlowTargetEnd> getDrivenEnds();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model graphRequired="true"
	 * @generated
	 */
	boolean isEnclosedBy(Graph graph);

} // Node
