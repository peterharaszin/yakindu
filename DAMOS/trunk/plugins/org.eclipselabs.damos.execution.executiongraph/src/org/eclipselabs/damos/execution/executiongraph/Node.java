/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executiongraph;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.Subsystem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.Node#getIncomingLinks <em>Incoming Links</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.Node#getOutgoingLinks <em>Outgoing Links</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.Node#getComponent <em>Component</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.Node#getOutgoingDataFlows <em>Outgoing Data Flows</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.Node#getIncomingDataFlows <em>Incoming Data Flows</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.Node#getEnclosingSubsystems <em>Enclosing Subsystems</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends EObject {
	/**
	 * Returns the value of the '<em><b>Incoming Links</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.executiongraph.Link}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.execution.executiongraph.Link#getTargetNode <em>Target Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Links</em>' reference list.
	 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage#getNode_IncomingLinks()
	 * @see org.eclipselabs.damos.execution.executiongraph.Link#getTargetNode
	 * @model opposite="targetNode"
	 * @generated
	 */
	EList<Link> getIncomingLinks();

	/**
	 * Returns the value of the '<em><b>Outgoing Links</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.executiongraph.Link}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.execution.executiongraph.Link#getSourceNode <em>Source Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Links</em>' reference list.
	 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage#getNode_OutgoingLinks()
	 * @see org.eclipselabs.damos.execution.executiongraph.Link#getSourceNode
	 * @model opposite="sourceNode"
	 * @generated
	 */
	EList<Link> getOutgoingLinks();

	/**
	 * Returns the value of the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component</em>' reference.
	 * @see #setComponent(Component)
	 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage#getNode_Component()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Component getComponent();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.execution.executiongraph.Node#getComponent <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component</em>' reference.
	 * @see #getComponent()
	 * @generated
	 */
	void setComponent(Component value);

	/**
	 * Returns the value of the '<em><b>Outgoing Data Flows</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.executiongraph.DataFlowSourceEnd}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.execution.executiongraph.DataFlowSourceEnd#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Data Flows</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Data Flows</em>' reference list.
	 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage#getNode_OutgoingDataFlows()
	 * @see org.eclipselabs.damos.execution.executiongraph.DataFlowSourceEnd#getNode
	 * @model opposite="node"
	 * @generated
	 */
	EList<DataFlowSourceEnd> getOutgoingDataFlows();

	/**
	 * Returns the value of the '<em><b>Incoming Data Flows</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.executiongraph.DataFlowTargetEnd}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.execution.executiongraph.DataFlowTargetEnd#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Data Flows</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Data Flows</em>' reference list.
	 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage#getNode_IncomingDataFlows()
	 * @see org.eclipselabs.damos.execution.executiongraph.DataFlowTargetEnd#getNode
	 * @model opposite="node"
	 * @generated
	 */
	EList<DataFlowTargetEnd> getIncomingDataFlows();

	/**
	 * Returns the value of the '<em><b>Enclosing Subsystems</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.dml.Subsystem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enclosing Subsystems</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enclosing Subsystems</em>' reference list.
	 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage#getNode_EnclosingSubsystems()
	 * @model
	 * @generated
	 */
	EList<Subsystem> getEnclosingSubsystems();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" inputPortRequired="true" inputPortOrdered="false"
	 * @generated
	 */
	DataFlowTargetEnd getIncomingDataFlow(InputPort inputPort);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" outputPortRequired="true" outputPortOrdered="false"
	 * @generated
	 */
	DataFlowSourceEnd getOutgoingDataFlow(OutputPort outputPort);

} // Node
