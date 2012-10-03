/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.execution;

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
 *   <li>{@link org.eclipse.damos.execution.Graph#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.Graph#getInitialNodes <em>Initial Nodes</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.Graph#getEdges <em>Edges</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.execution.ExecutionPackage#getGraph()
 * @model
 * @generated
 */
public interface Graph extends EObject {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.execution.Node}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.execution.Node#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.eclipse.damos.execution.ExecutionPackage#getGraph_Nodes()
	 * @see org.eclipse.damos.execution.Node#getGraph
	 * @model opposite="graph" containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Initial Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.damos.execution.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Nodes</em>' reference list.
	 * @see org.eclipse.damos.execution.ExecutionPackage#getGraph_InitialNodes()
	 * @model
	 * @generated
	 */
	EList<Node> getInitialNodes();

	/**
	 * Returns the value of the '<em><b>Edges</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.execution.Edge}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.execution.Edge#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' containment reference list.
	 * @see org.eclipse.damos.execution.ExecutionPackage#getGraph_Edges()
	 * @see org.eclipse.damos.execution.Edge#getGraph
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
	 * @model kind="operation" dataType="org.eclipse.damos.execution.Iterable<org.eclipse.damos.execution.Node>" required="true"
	 * @generated
	 */
	Iterable<Node> getAllNodes();

} // Graph
