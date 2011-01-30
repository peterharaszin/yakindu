/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executiongraph;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.dml.Fragment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.ExecutionGraph#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.ExecutionGraph#getInitialNodes <em>Initial Nodes</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.ExecutionGraph#getLinks <em>Links</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.ExecutionGraph#getTopLevelFragment <em>Top Level Fragment</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.ExecutionGraph#getDataFlows <em>Data Flows</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage#getExecutionGraph()
 * @model
 * @generated
 */
public interface ExecutionGraph extends EObject {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.executiongraph.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage#getExecutionGraph_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Initial Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.executiongraph.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Nodes</em>' reference list.
	 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage#getExecutionGraph_InitialNodes()
	 * @model
	 * @generated
	 */
	EList<Node> getInitialNodes();

	/**
	 * Returns the value of the '<em><b>Links</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.executiongraph.Link}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' containment reference list.
	 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage#getExecutionGraph_Links()
	 * @model containment="true"
	 * @generated
	 */
	EList<Link> getLinks();

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
	 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage#getExecutionGraph_TopLevelFragment()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Fragment getTopLevelFragment();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.execution.executiongraph.ExecutionGraph#getTopLevelFragment <em>Top Level Fragment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top Level Fragment</em>' reference.
	 * @see #getTopLevelFragment()
	 * @generated
	 */
	void setTopLevelFragment(Fragment value);

	/**
	 * Returns the value of the '<em><b>Data Flows</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.executiongraph.DataFlow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Flows</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Flows</em>' containment reference list.
	 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage#getExecutionGraph_DataFlows()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<DataFlow> getDataFlows();

} // ExecutionGraph
