/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.execution.impl;

import java.util.Collection;

import org.eclipse.damos.dml.InputConnector;
import org.eclipse.damos.dml.OutputConnector;
import org.eclipse.damos.dml.util.SystemPath;
import org.eclipse.damos.execution.DataFlowSourceEnd;
import org.eclipse.damos.execution.DataFlowTargetEnd;
import org.eclipse.damos.execution.Edge;
import org.eclipse.damos.execution.ExecutionPackage;
import org.eclipse.damos.execution.Graph;
import org.eclipse.damos.execution.Node;
import org.eclipse.damos.execution.internal.operations.NodeOperations;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.execution.impl.NodeImpl#getGraph <em>Graph</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.impl.NodeImpl#getIncomingEdges <em>Incoming Edges</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.impl.NodeImpl#getOutgoingEdges <em>Outgoing Edges</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.impl.NodeImpl#getIncomingDataFlows <em>Incoming Data Flows</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.impl.NodeImpl#getOutgoingDataFlows <em>Outgoing Data Flows</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.impl.NodeImpl#getSystemPath <em>System Path</em>}</li>
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
	 * The default value of the '{@link #getSystemPath() <em>System Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemPath()
	 * @generated
	 * @ordered
	 */
	protected static final SystemPath SYSTEM_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSystemPath() <em>System Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemPath()
	 * @generated
	 * @ordered
	 */
	protected SystemPath systemPath = SYSTEM_PATH_EDEFAULT;

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
		return ExecutionPackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getGraph() {
		if (eContainerFeatureID() != ExecutionPackage.NODE__GRAPH) return null;
		return (Graph)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGraph(Graph newGraph, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGraph, ExecutionPackage.NODE__GRAPH, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraph(Graph newGraph) {
		if (newGraph != eInternalContainer() || (eContainerFeatureID() != ExecutionPackage.NODE__GRAPH && newGraph != null)) {
			if (EcoreUtil.isAncestor(this, newGraph))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGraph != null)
				msgs = ((InternalEObject)newGraph).eInverseAdd(this, ExecutionPackage.GRAPH__NODES, Graph.class, msgs);
			msgs = basicSetGraph(newGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionPackage.NODE__GRAPH, newGraph, newGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getIncomingEdges() {
		if (incomingEdges == null) {
			incomingEdges = new EObjectWithInverseResolvingEList<Edge>(Edge.class, this, ExecutionPackage.NODE__INCOMING_EDGES, ExecutionPackage.EDGE__TARGET);
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
			outgoingEdges = new EObjectWithInverseResolvingEList<Edge>(Edge.class, this, ExecutionPackage.NODE__OUTGOING_EDGES, ExecutionPackage.EDGE__SOURCE);
		}
		return outgoingEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataFlowTargetEnd> getIncomingDataFlows() {
		if (incomingDataFlows == null) {
			incomingDataFlows = new EObjectWithInverseResolvingEList<DataFlowTargetEnd>(DataFlowTargetEnd.class, this, ExecutionPackage.NODE__INCOMING_DATA_FLOWS, ExecutionPackage.DATA_FLOW_TARGET_END__NODE);
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
			outgoingDataFlows = new EObjectWithInverseResolvingEList<DataFlowSourceEnd>(DataFlowSourceEnd.class, this, ExecutionPackage.NODE__OUTGOING_DATA_FLOWS, ExecutionPackage.DATA_FLOW_SOURCE_END__NODE);
		}
		return outgoingDataFlows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemPath getSystemPath() {
		return systemPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemPath(SystemPath newSystemPath) {
		SystemPath oldSystemPath = systemPath;
		systemPath = newSystemPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionPackage.NODE__SYSTEM_PATH, oldSystemPath, systemPath));
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
	 * @generated NOT
	 */
	public EList<Node> getDrivingNodes() {
		return NodeOperations.getDrivingNodes(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Node> getDrivenNodes() {
		return NodeOperations.getDrivenNodes(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<DataFlowSourceEnd> getDrivingEnds() {
		return NodeOperations.getDrivingEnds(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<DataFlowTargetEnd> getDrivenEnds() {
		return NodeOperations.getDrivenEnds(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isEnclosedBy(Graph graph) {
		return NodeOperations.isEnclosedBy(this, graph);
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
			case ExecutionPackage.NODE__GRAPH:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGraph((Graph)otherEnd, msgs);
			case ExecutionPackage.NODE__INCOMING_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingEdges()).basicAdd(otherEnd, msgs);
			case ExecutionPackage.NODE__OUTGOING_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingEdges()).basicAdd(otherEnd, msgs);
			case ExecutionPackage.NODE__INCOMING_DATA_FLOWS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingDataFlows()).basicAdd(otherEnd, msgs);
			case ExecutionPackage.NODE__OUTGOING_DATA_FLOWS:
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
			case ExecutionPackage.NODE__GRAPH:
				return basicSetGraph(null, msgs);
			case ExecutionPackage.NODE__INCOMING_EDGES:
				return ((InternalEList<?>)getIncomingEdges()).basicRemove(otherEnd, msgs);
			case ExecutionPackage.NODE__OUTGOING_EDGES:
				return ((InternalEList<?>)getOutgoingEdges()).basicRemove(otherEnd, msgs);
			case ExecutionPackage.NODE__INCOMING_DATA_FLOWS:
				return ((InternalEList<?>)getIncomingDataFlows()).basicRemove(otherEnd, msgs);
			case ExecutionPackage.NODE__OUTGOING_DATA_FLOWS:
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ExecutionPackage.NODE__GRAPH:
				return eInternalContainer().eInverseRemove(this, ExecutionPackage.GRAPH__NODES, Graph.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExecutionPackage.NODE__GRAPH:
				return getGraph();
			case ExecutionPackage.NODE__INCOMING_EDGES:
				return getIncomingEdges();
			case ExecutionPackage.NODE__OUTGOING_EDGES:
				return getOutgoingEdges();
			case ExecutionPackage.NODE__INCOMING_DATA_FLOWS:
				return getIncomingDataFlows();
			case ExecutionPackage.NODE__OUTGOING_DATA_FLOWS:
				return getOutgoingDataFlows();
			case ExecutionPackage.NODE__SYSTEM_PATH:
				return getSystemPath();
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
			case ExecutionPackage.NODE__GRAPH:
				setGraph((Graph)newValue);
				return;
			case ExecutionPackage.NODE__INCOMING_EDGES:
				getIncomingEdges().clear();
				getIncomingEdges().addAll((Collection<? extends Edge>)newValue);
				return;
			case ExecutionPackage.NODE__OUTGOING_EDGES:
				getOutgoingEdges().clear();
				getOutgoingEdges().addAll((Collection<? extends Edge>)newValue);
				return;
			case ExecutionPackage.NODE__INCOMING_DATA_FLOWS:
				getIncomingDataFlows().clear();
				getIncomingDataFlows().addAll((Collection<? extends DataFlowTargetEnd>)newValue);
				return;
			case ExecutionPackage.NODE__OUTGOING_DATA_FLOWS:
				getOutgoingDataFlows().clear();
				getOutgoingDataFlows().addAll((Collection<? extends DataFlowSourceEnd>)newValue);
				return;
			case ExecutionPackage.NODE__SYSTEM_PATH:
				setSystemPath((SystemPath)newValue);
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
			case ExecutionPackage.NODE__GRAPH:
				setGraph((Graph)null);
				return;
			case ExecutionPackage.NODE__INCOMING_EDGES:
				getIncomingEdges().clear();
				return;
			case ExecutionPackage.NODE__OUTGOING_EDGES:
				getOutgoingEdges().clear();
				return;
			case ExecutionPackage.NODE__INCOMING_DATA_FLOWS:
				getIncomingDataFlows().clear();
				return;
			case ExecutionPackage.NODE__OUTGOING_DATA_FLOWS:
				getOutgoingDataFlows().clear();
				return;
			case ExecutionPackage.NODE__SYSTEM_PATH:
				setSystemPath(SYSTEM_PATH_EDEFAULT);
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
			case ExecutionPackage.NODE__GRAPH:
				return getGraph() != null;
			case ExecutionPackage.NODE__INCOMING_EDGES:
				return incomingEdges != null && !incomingEdges.isEmpty();
			case ExecutionPackage.NODE__OUTGOING_EDGES:
				return outgoingEdges != null && !outgoingEdges.isEmpty();
			case ExecutionPackage.NODE__INCOMING_DATA_FLOWS:
				return incomingDataFlows != null && !incomingDataFlows.isEmpty();
			case ExecutionPackage.NODE__OUTGOING_DATA_FLOWS:
				return outgoingDataFlows != null && !outgoingDataFlows.isEmpty();
			case ExecutionPackage.NODE__SYSTEM_PATH:
				return SYSTEM_PATH_EDEFAULT == null ? systemPath != null : !SYSTEM_PATH_EDEFAULT.equals(systemPath);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (systemPath: ");
		result.append(systemPath);
		result.append(')');
		return result.toString();
	}

} //NodeImpl
