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
import org.eclipse.damos.dml.Subsystem;
import org.eclipse.damos.dml.util.SystemPath;
import org.eclipse.damos.execution.DataFlowSourceEnd;
import org.eclipse.damos.execution.DataFlowTargetEnd;
import org.eclipse.damos.execution.Edge;
import org.eclipse.damos.execution.ExecutionPackage;
import org.eclipse.damos.execution.Graph;
import org.eclipse.damos.execution.Node;
import org.eclipse.damos.execution.Subgraph;
import org.eclipse.damos.execution.internal.operations.NodeOperations;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subgraph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.execution.impl.SubgraphImpl#getGraph <em>Graph</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.impl.SubgraphImpl#getIncomingEdges <em>Incoming Edges</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.impl.SubgraphImpl#getOutgoingEdges <em>Outgoing Edges</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.impl.SubgraphImpl#getIncomingDataFlows <em>Incoming Data Flows</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.impl.SubgraphImpl#getOutgoingDataFlows <em>Outgoing Data Flows</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.impl.SubgraphImpl#getEnclosingSubsystems <em>Enclosing Subsystems</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SubgraphImpl extends GraphImpl implements Subgraph {
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
	 * The cached value of the '{@link #getEnclosingSubsystems() <em>Enclosing Subsystems</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnclosingSubsystems()
	 * @generated
	 * @ordered
	 */
	protected EList<Subsystem> enclosingSubsystems;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubgraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionPackage.Literals.SUBGRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getGraph() {
		if (eContainerFeatureID() != ExecutionPackage.SUBGRAPH__GRAPH) return null;
		return (Graph)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGraph(Graph newGraph, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGraph, ExecutionPackage.SUBGRAPH__GRAPH, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraph(Graph newGraph) {
		if (newGraph != eInternalContainer() || (eContainerFeatureID() != ExecutionPackage.SUBGRAPH__GRAPH && newGraph != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionPackage.SUBGRAPH__GRAPH, newGraph, newGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getIncomingEdges() {
		if (incomingEdges == null) {
			incomingEdges = new EObjectWithInverseResolvingEList<Edge>(Edge.class, this, ExecutionPackage.SUBGRAPH__INCOMING_EDGES, ExecutionPackage.EDGE__TARGET);
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
			outgoingEdges = new EObjectWithInverseResolvingEList<Edge>(Edge.class, this, ExecutionPackage.SUBGRAPH__OUTGOING_EDGES, ExecutionPackage.EDGE__SOURCE);
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
			incomingDataFlows = new EObjectWithInverseResolvingEList<DataFlowTargetEnd>(DataFlowTargetEnd.class, this, ExecutionPackage.SUBGRAPH__INCOMING_DATA_FLOWS, ExecutionPackage.DATA_FLOW_TARGET_END__NODE);
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
			outgoingDataFlows = new EObjectWithInverseResolvingEList<DataFlowSourceEnd>(DataFlowSourceEnd.class, this, ExecutionPackage.SUBGRAPH__OUTGOING_DATA_FLOWS, ExecutionPackage.DATA_FLOW_SOURCE_END__NODE);
		}
		return outgoingDataFlows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Subsystem> getEnclosingSubsystems() {
		if (enclosingSubsystems == null) {
			enclosingSubsystems = new EObjectResolvingEList<Subsystem>(Subsystem.class, this, ExecutionPackage.SUBGRAPH__ENCLOSING_SUBSYSTEMS);
		}
		return enclosingSubsystems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SystemPath getSystemPath() {
		return NodeOperations.getSystemPath(this);
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
	 * @generated
	 */
	public EList<DataFlowSourceEnd> getDrivingEnds() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataFlowTargetEnd> getDrivenEnds() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case ExecutionPackage.SUBGRAPH__GRAPH:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGraph((Graph)otherEnd, msgs);
			case ExecutionPackage.SUBGRAPH__INCOMING_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingEdges()).basicAdd(otherEnd, msgs);
			case ExecutionPackage.SUBGRAPH__OUTGOING_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingEdges()).basicAdd(otherEnd, msgs);
			case ExecutionPackage.SUBGRAPH__INCOMING_DATA_FLOWS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingDataFlows()).basicAdd(otherEnd, msgs);
			case ExecutionPackage.SUBGRAPH__OUTGOING_DATA_FLOWS:
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
			case ExecutionPackage.SUBGRAPH__GRAPH:
				return basicSetGraph(null, msgs);
			case ExecutionPackage.SUBGRAPH__INCOMING_EDGES:
				return ((InternalEList<?>)getIncomingEdges()).basicRemove(otherEnd, msgs);
			case ExecutionPackage.SUBGRAPH__OUTGOING_EDGES:
				return ((InternalEList<?>)getOutgoingEdges()).basicRemove(otherEnd, msgs);
			case ExecutionPackage.SUBGRAPH__INCOMING_DATA_FLOWS:
				return ((InternalEList<?>)getIncomingDataFlows()).basicRemove(otherEnd, msgs);
			case ExecutionPackage.SUBGRAPH__OUTGOING_DATA_FLOWS:
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
			case ExecutionPackage.SUBGRAPH__GRAPH:
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
			case ExecutionPackage.SUBGRAPH__GRAPH:
				return getGraph();
			case ExecutionPackage.SUBGRAPH__INCOMING_EDGES:
				return getIncomingEdges();
			case ExecutionPackage.SUBGRAPH__OUTGOING_EDGES:
				return getOutgoingEdges();
			case ExecutionPackage.SUBGRAPH__INCOMING_DATA_FLOWS:
				return getIncomingDataFlows();
			case ExecutionPackage.SUBGRAPH__OUTGOING_DATA_FLOWS:
				return getOutgoingDataFlows();
			case ExecutionPackage.SUBGRAPH__ENCLOSING_SUBSYSTEMS:
				return getEnclosingSubsystems();
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
			case ExecutionPackage.SUBGRAPH__GRAPH:
				setGraph((Graph)newValue);
				return;
			case ExecutionPackage.SUBGRAPH__INCOMING_EDGES:
				getIncomingEdges().clear();
				getIncomingEdges().addAll((Collection<? extends Edge>)newValue);
				return;
			case ExecutionPackage.SUBGRAPH__OUTGOING_EDGES:
				getOutgoingEdges().clear();
				getOutgoingEdges().addAll((Collection<? extends Edge>)newValue);
				return;
			case ExecutionPackage.SUBGRAPH__INCOMING_DATA_FLOWS:
				getIncomingDataFlows().clear();
				getIncomingDataFlows().addAll((Collection<? extends DataFlowTargetEnd>)newValue);
				return;
			case ExecutionPackage.SUBGRAPH__OUTGOING_DATA_FLOWS:
				getOutgoingDataFlows().clear();
				getOutgoingDataFlows().addAll((Collection<? extends DataFlowSourceEnd>)newValue);
				return;
			case ExecutionPackage.SUBGRAPH__ENCLOSING_SUBSYSTEMS:
				getEnclosingSubsystems().clear();
				getEnclosingSubsystems().addAll((Collection<? extends Subsystem>)newValue);
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
			case ExecutionPackage.SUBGRAPH__GRAPH:
				setGraph((Graph)null);
				return;
			case ExecutionPackage.SUBGRAPH__INCOMING_EDGES:
				getIncomingEdges().clear();
				return;
			case ExecutionPackage.SUBGRAPH__OUTGOING_EDGES:
				getOutgoingEdges().clear();
				return;
			case ExecutionPackage.SUBGRAPH__INCOMING_DATA_FLOWS:
				getIncomingDataFlows().clear();
				return;
			case ExecutionPackage.SUBGRAPH__OUTGOING_DATA_FLOWS:
				getOutgoingDataFlows().clear();
				return;
			case ExecutionPackage.SUBGRAPH__ENCLOSING_SUBSYSTEMS:
				getEnclosingSubsystems().clear();
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
			case ExecutionPackage.SUBGRAPH__GRAPH:
				return getGraph() != null;
			case ExecutionPackage.SUBGRAPH__INCOMING_EDGES:
				return incomingEdges != null && !incomingEdges.isEmpty();
			case ExecutionPackage.SUBGRAPH__OUTGOING_EDGES:
				return outgoingEdges != null && !outgoingEdges.isEmpty();
			case ExecutionPackage.SUBGRAPH__INCOMING_DATA_FLOWS:
				return incomingDataFlows != null && !incomingDataFlows.isEmpty();
			case ExecutionPackage.SUBGRAPH__OUTGOING_DATA_FLOWS:
				return outgoingDataFlows != null && !outgoingDataFlows.isEmpty();
			case ExecutionPackage.SUBGRAPH__ENCLOSING_SUBSYSTEMS:
				return enclosingSubsystems != null && !enclosingSubsystems.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Node.class) {
			switch (derivedFeatureID) {
				case ExecutionPackage.SUBGRAPH__GRAPH: return ExecutionPackage.NODE__GRAPH;
				case ExecutionPackage.SUBGRAPH__INCOMING_EDGES: return ExecutionPackage.NODE__INCOMING_EDGES;
				case ExecutionPackage.SUBGRAPH__OUTGOING_EDGES: return ExecutionPackage.NODE__OUTGOING_EDGES;
				case ExecutionPackage.SUBGRAPH__INCOMING_DATA_FLOWS: return ExecutionPackage.NODE__INCOMING_DATA_FLOWS;
				case ExecutionPackage.SUBGRAPH__OUTGOING_DATA_FLOWS: return ExecutionPackage.NODE__OUTGOING_DATA_FLOWS;
				case ExecutionPackage.SUBGRAPH__ENCLOSING_SUBSYSTEMS: return ExecutionPackage.NODE__ENCLOSING_SUBSYSTEMS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Node.class) {
			switch (baseFeatureID) {
				case ExecutionPackage.NODE__GRAPH: return ExecutionPackage.SUBGRAPH__GRAPH;
				case ExecutionPackage.NODE__INCOMING_EDGES: return ExecutionPackage.SUBGRAPH__INCOMING_EDGES;
				case ExecutionPackage.NODE__OUTGOING_EDGES: return ExecutionPackage.SUBGRAPH__OUTGOING_EDGES;
				case ExecutionPackage.NODE__INCOMING_DATA_FLOWS: return ExecutionPackage.SUBGRAPH__INCOMING_DATA_FLOWS;
				case ExecutionPackage.NODE__OUTGOING_DATA_FLOWS: return ExecutionPackage.SUBGRAPH__OUTGOING_DATA_FLOWS;
				case ExecutionPackage.NODE__ENCLOSING_SUBSYSTEMS: return ExecutionPackage.SUBGRAPH__ENCLOSING_SUBSYSTEMS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //SubgraphImpl
