/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionflow;

import java.lang.Iterable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.Graph#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.Graph#getInitialNodes <em>Initial Nodes</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.Graph#getEdges <em>Edges</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getGraph()
 * @model
 * @generated
 */
public interface Graph extends EObject {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.executionflow.Node}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.execution.executionflow.Node#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getGraph_Nodes()
	 * @see org.eclipselabs.damos.execution.executionflow.Node#getGraph
	 * @model opposite="graph" containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Initial Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.executionflow.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Nodes</em>' reference list.
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getGraph_InitialNodes()
	 * @model
	 * @generated
	 */
	EList<Node> getInitialNodes();

	/**
	 * Returns the value of the '<em><b>Edges</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.executionflow.Edge}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.execution.executionflow.Edge#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' containment reference list.
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getGraph_Edges()
	 * @see org.eclipselabs.damos.execution.executionflow.Edge#getGraph
	 * @model opposite="graph" containment="true"
	 * @generated
	 */
	EList<Edge> getEdges();

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
	 * @model kind="operation" dataType="org.eclipselabs.damos.execution.executionflow.Iterable<org.eclipselabs.damos.execution.executionflow.Node>" required="true"
	 * @generated
	 */
	Iterable<Node> getAllNodes();

} // Graph
