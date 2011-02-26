/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionflow.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.dml.InputConnector;
import org.eclipselabs.damos.dml.OutputConnector;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.executionflow.Edge;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.execution.executionflow.internal.operations.NodeOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.impl.NodeImpl#getIncomingEdges <em>Incoming Edges</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.impl.NodeImpl#getOutgoingEdges <em>Outgoing Edges</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.impl.NodeImpl#getEnclosingSubsystems <em>Enclosing Subsystems</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.impl.NodeImpl#getIncomingDataFlows <em>Incoming Data Flows</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.impl.NodeImpl#getOutgoingDataFlows <em>Outgoing Data Flows</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class NodeImpl extends EObjectImpl implements Node {
	/**
	 * The cached value of the '{@link #getIncomingEdges() <em>Incoming Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> incomingEdges;

	/**
	 * The cached value of the '{@link #getOutgoingEdges() <em>Outgoing Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> outgoingEdges;

	/**
	 * The cached value of the '{@link #getEnclosingSubsystems() <em>Enclosing Subsystems</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnclosingSubsystems()
	 * @generated
	 * @ordered
	 */
	protected EList<Subsystem> enclosingSubsystems;

	/**
	 * The cached value of the '{@link #getIncomingDataFlows() <em>Incoming Data Flows</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingDataFlows()
	 * @generated
	 * @ordered
	 */
	protected EList<DataFlowTargetEnd> incomingDataFlows;

	/**
	 * The cached value of the '{@link #getOutgoingDataFlows() <em>Outgoing Data Flows</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingDataFlows()
	 * @generated
	 * @ordered
	 */
	protected EList<DataFlowSourceEnd> outgoingDataFlows;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionFlowPackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getIncomingEdges() {
		if (incomingEdges == null) {
			incomingEdges = new EObjectWithInverseResolvingEList<Edge>(Edge.class, this, ExecutionFlowPackage.NODE__INCOMING_EDGES, ExecutionFlowPackage.EDGE__TARGET);
		}
		return incomingEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getOutgoingEdges() {
		if (outgoingEdges == null) {
			outgoingEdges = new EObjectWithInverseResolvingEList<Edge>(Edge.class, this, ExecutionFlowPackage.NODE__OUTGOING_EDGES, ExecutionFlowPackage.EDGE__SOURCE);
		}
		return outgoingEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Subsystem> getEnclosingSubsystems() {
		if (enclosingSubsystems == null) {
			enclosingSubsystems = new EObjectResolvingEList<Subsystem>(Subsystem.class, this, ExecutionFlowPackage.NODE__ENCLOSING_SUBSYSTEMS);
		}
		return enclosingSubsystems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataFlowTargetEnd> getIncomingDataFlows() {
		if (incomingDataFlows == null) {
			incomingDataFlows = new EObjectWithInverseResolvingEList<DataFlowTargetEnd>(DataFlowTargetEnd.class, this, ExecutionFlowPackage.NODE__INCOMING_DATA_FLOWS, ExecutionFlowPackage.DATA_FLOW_TARGET_END__NODE);
		}
		return incomingDataFlows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataFlowSourceEnd> getOutgoingDataFlows() {
		if (outgoingDataFlows == null) {
			outgoingDataFlows = new EObjectWithInverseResolvingEList<DataFlowSourceEnd>(DataFlowSourceEnd.class, this, ExecutionFlowPackage.NODE__OUTGOING_DATA_FLOWS, ExecutionFlowPackage.DATA_FLOW_SOURCE_END__NODE);
		}
		return outgoingDataFlows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DataFlowTargetEnd getIncomingDataFlow(InputConnector target) {
		return NodeOperations.getIncomingDataFlow(this, target);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DataFlowSourceEnd getOutgoingDataFlow(OutputConnector source) {
		return NodeOperations.getOutgoingDataFlow(this, source);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExecutionFlowPackage.NODE__INCOMING_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingEdges()).basicAdd(otherEnd, msgs);
			case ExecutionFlowPackage.NODE__OUTGOING_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingEdges()).basicAdd(otherEnd, msgs);
			case ExecutionFlowPackage.NODE__INCOMING_DATA_FLOWS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingDataFlows()).basicAdd(otherEnd, msgs);
			case ExecutionFlowPackage.NODE__OUTGOING_DATA_FLOWS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingDataFlows()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExecutionFlowPackage.NODE__INCOMING_EDGES:
				return ((InternalEList<?>)getIncomingEdges()).basicRemove(otherEnd, msgs);
			case ExecutionFlowPackage.NODE__OUTGOING_EDGES:
				return ((InternalEList<?>)getOutgoingEdges()).basicRemove(otherEnd, msgs);
			case ExecutionFlowPackage.NODE__INCOMING_DATA_FLOWS:
				return ((InternalEList<?>)getIncomingDataFlows()).basicRemove(otherEnd, msgs);
			case ExecutionFlowPackage.NODE__OUTGOING_DATA_FLOWS:
				return ((InternalEList<?>)getOutgoingDataFlows()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExecutionFlowPackage.NODE__INCOMING_EDGES:
				return getIncomingEdges();
			case ExecutionFlowPackage.NODE__OUTGOING_EDGES:
				return getOutgoingEdges();
			case ExecutionFlowPackage.NODE__ENCLOSING_SUBSYSTEMS:
				return getEnclosingSubsystems();
			case ExecutionFlowPackage.NODE__INCOMING_DATA_FLOWS:
				return getIncomingDataFlows();
			case ExecutionFlowPackage.NODE__OUTGOING_DATA_FLOWS:
				return getOutgoingDataFlows();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExecutionFlowPackage.NODE__INCOMING_EDGES:
				getIncomingEdges().clear();
				getIncomingEdges().addAll((Collection<? extends Edge>)newValue);
				return;
			case ExecutionFlowPackage.NODE__OUTGOING_EDGES:
				getOutgoingEdges().clear();
				getOutgoingEdges().addAll((Collection<? extends Edge>)newValue);
				return;
			case ExecutionFlowPackage.NODE__ENCLOSING_SUBSYSTEMS:
				getEnclosingSubsystems().clear();
				getEnclosingSubsystems().addAll((Collection<? extends Subsystem>)newValue);
				return;
			case ExecutionFlowPackage.NODE__INCOMING_DATA_FLOWS:
				getIncomingDataFlows().clear();
				getIncomingDataFlows().addAll((Collection<? extends DataFlowTargetEnd>)newValue);
				return;
			case ExecutionFlowPackage.NODE__OUTGOING_DATA_FLOWS:
				getOutgoingDataFlows().clear();
				getOutgoingDataFlows().addAll((Collection<? extends DataFlowSourceEnd>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ExecutionFlowPackage.NODE__INCOMING_EDGES:
				getIncomingEdges().clear();
				return;
			case ExecutionFlowPackage.NODE__OUTGOING_EDGES:
				getOutgoingEdges().clear();
				return;
			case ExecutionFlowPackage.NODE__ENCLOSING_SUBSYSTEMS:
				getEnclosingSubsystems().clear();
				return;
			case ExecutionFlowPackage.NODE__INCOMING_DATA_FLOWS:
				getIncomingDataFlows().clear();
				return;
			case ExecutionFlowPackage.NODE__OUTGOING_DATA_FLOWS:
				getOutgoingDataFlows().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ExecutionFlowPackage.NODE__INCOMING_EDGES:
				return incomingEdges != null && !incomingEdges.isEmpty();
			case ExecutionFlowPackage.NODE__OUTGOING_EDGES:
				return outgoingEdges != null && !outgoingEdges.isEmpty();
			case ExecutionFlowPackage.NODE__ENCLOSING_SUBSYSTEMS:
				return enclosingSubsystems != null && !enclosingSubsystems.isEmpty();
			case ExecutionFlowPackage.NODE__INCOMING_DATA_FLOWS:
				return incomingDataFlows != null && !incomingDataFlows.isEmpty();
			case ExecutionFlowPackage.NODE__OUTGOING_DATA_FLOWS:
				return outgoingDataFlows != null && !outgoingDataFlows.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NodeImpl
