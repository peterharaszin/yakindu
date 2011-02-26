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
import org.eclipselabs.damos.execution.executionflow.Subgraph;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subgraph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.impl.SubgraphImpl#getIncomingEdges <em>Incoming Edges</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.impl.SubgraphImpl#getOutgoingEdges <em>Outgoing Edges</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.impl.SubgraphImpl#getEnclosingSubsystems <em>Enclosing Subsystems</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.impl.SubgraphImpl#getIncomingDataFlows <em>Incoming Data Flows</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.impl.SubgraphImpl#getOutgoingDataFlows <em>Outgoing Data Flows</em>}</li>
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
		return ExecutionFlowPackage.Literals.SUBGRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getIncomingEdges() {
		if (incomingEdges == null) {
			incomingEdges = new EObjectWithInverseResolvingEList<Edge>(Edge.class, this, ExecutionFlowPackage.SUBGRAPH__INCOMING_EDGES, ExecutionFlowPackage.EDGE__TARGET);
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
			outgoingEdges = new EObjectWithInverseResolvingEList<Edge>(Edge.class, this, ExecutionFlowPackage.SUBGRAPH__OUTGOING_EDGES, ExecutionFlowPackage.EDGE__SOURCE);
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
			enclosingSubsystems = new EObjectResolvingEList<Subsystem>(Subsystem.class, this, ExecutionFlowPackage.SUBGRAPH__ENCLOSING_SUBSYSTEMS);
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
			incomingDataFlows = new EObjectWithInverseResolvingEList<DataFlowTargetEnd>(DataFlowTargetEnd.class, this, ExecutionFlowPackage.SUBGRAPH__INCOMING_DATA_FLOWS, ExecutionFlowPackage.DATA_FLOW_TARGET_END__NODE);
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
			outgoingDataFlows = new EObjectWithInverseResolvingEList<DataFlowSourceEnd>(DataFlowSourceEnd.class, this, ExecutionFlowPackage.SUBGRAPH__OUTGOING_DATA_FLOWS, ExecutionFlowPackage.DATA_FLOW_SOURCE_END__NODE);
		}
		return outgoingDataFlows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlowTargetEnd getIncomingDataFlow(InputConnector target) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlowSourceEnd getOutgoingDataFlow(OutputConnector source) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case ExecutionFlowPackage.SUBGRAPH__INCOMING_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingEdges()).basicAdd(otherEnd, msgs);
			case ExecutionFlowPackage.SUBGRAPH__OUTGOING_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingEdges()).basicAdd(otherEnd, msgs);
			case ExecutionFlowPackage.SUBGRAPH__INCOMING_DATA_FLOWS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingDataFlows()).basicAdd(otherEnd, msgs);
			case ExecutionFlowPackage.SUBGRAPH__OUTGOING_DATA_FLOWS:
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
			case ExecutionFlowPackage.SUBGRAPH__INCOMING_EDGES:
				return ((InternalEList<?>)getIncomingEdges()).basicRemove(otherEnd, msgs);
			case ExecutionFlowPackage.SUBGRAPH__OUTGOING_EDGES:
				return ((InternalEList<?>)getOutgoingEdges()).basicRemove(otherEnd, msgs);
			case ExecutionFlowPackage.SUBGRAPH__INCOMING_DATA_FLOWS:
				return ((InternalEList<?>)getIncomingDataFlows()).basicRemove(otherEnd, msgs);
			case ExecutionFlowPackage.SUBGRAPH__OUTGOING_DATA_FLOWS:
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
			case ExecutionFlowPackage.SUBGRAPH__INCOMING_EDGES:
				return getIncomingEdges();
			case ExecutionFlowPackage.SUBGRAPH__OUTGOING_EDGES:
				return getOutgoingEdges();
			case ExecutionFlowPackage.SUBGRAPH__ENCLOSING_SUBSYSTEMS:
				return getEnclosingSubsystems();
			case ExecutionFlowPackage.SUBGRAPH__INCOMING_DATA_FLOWS:
				return getIncomingDataFlows();
			case ExecutionFlowPackage.SUBGRAPH__OUTGOING_DATA_FLOWS:
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
			case ExecutionFlowPackage.SUBGRAPH__INCOMING_EDGES:
				getIncomingEdges().clear();
				getIncomingEdges().addAll((Collection<? extends Edge>)newValue);
				return;
			case ExecutionFlowPackage.SUBGRAPH__OUTGOING_EDGES:
				getOutgoingEdges().clear();
				getOutgoingEdges().addAll((Collection<? extends Edge>)newValue);
				return;
			case ExecutionFlowPackage.SUBGRAPH__ENCLOSING_SUBSYSTEMS:
				getEnclosingSubsystems().clear();
				getEnclosingSubsystems().addAll((Collection<? extends Subsystem>)newValue);
				return;
			case ExecutionFlowPackage.SUBGRAPH__INCOMING_DATA_FLOWS:
				getIncomingDataFlows().clear();
				getIncomingDataFlows().addAll((Collection<? extends DataFlowTargetEnd>)newValue);
				return;
			case ExecutionFlowPackage.SUBGRAPH__OUTGOING_DATA_FLOWS:
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
			case ExecutionFlowPackage.SUBGRAPH__INCOMING_EDGES:
				getIncomingEdges().clear();
				return;
			case ExecutionFlowPackage.SUBGRAPH__OUTGOING_EDGES:
				getOutgoingEdges().clear();
				return;
			case ExecutionFlowPackage.SUBGRAPH__ENCLOSING_SUBSYSTEMS:
				getEnclosingSubsystems().clear();
				return;
			case ExecutionFlowPackage.SUBGRAPH__INCOMING_DATA_FLOWS:
				getIncomingDataFlows().clear();
				return;
			case ExecutionFlowPackage.SUBGRAPH__OUTGOING_DATA_FLOWS:
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
			case ExecutionFlowPackage.SUBGRAPH__INCOMING_EDGES:
				return incomingEdges != null && !incomingEdges.isEmpty();
			case ExecutionFlowPackage.SUBGRAPH__OUTGOING_EDGES:
				return outgoingEdges != null && !outgoingEdges.isEmpty();
			case ExecutionFlowPackage.SUBGRAPH__ENCLOSING_SUBSYSTEMS:
				return enclosingSubsystems != null && !enclosingSubsystems.isEmpty();
			case ExecutionFlowPackage.SUBGRAPH__INCOMING_DATA_FLOWS:
				return incomingDataFlows != null && !incomingDataFlows.isEmpty();
			case ExecutionFlowPackage.SUBGRAPH__OUTGOING_DATA_FLOWS:
				return outgoingDataFlows != null && !outgoingDataFlows.isEmpty();
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
				case ExecutionFlowPackage.SUBGRAPH__INCOMING_EDGES: return ExecutionFlowPackage.NODE__INCOMING_EDGES;
				case ExecutionFlowPackage.SUBGRAPH__OUTGOING_EDGES: return ExecutionFlowPackage.NODE__OUTGOING_EDGES;
				case ExecutionFlowPackage.SUBGRAPH__ENCLOSING_SUBSYSTEMS: return ExecutionFlowPackage.NODE__ENCLOSING_SUBSYSTEMS;
				case ExecutionFlowPackage.SUBGRAPH__INCOMING_DATA_FLOWS: return ExecutionFlowPackage.NODE__INCOMING_DATA_FLOWS;
				case ExecutionFlowPackage.SUBGRAPH__OUTGOING_DATA_FLOWS: return ExecutionFlowPackage.NODE__OUTGOING_DATA_FLOWS;
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
				case ExecutionFlowPackage.NODE__INCOMING_EDGES: return ExecutionFlowPackage.SUBGRAPH__INCOMING_EDGES;
				case ExecutionFlowPackage.NODE__OUTGOING_EDGES: return ExecutionFlowPackage.SUBGRAPH__OUTGOING_EDGES;
				case ExecutionFlowPackage.NODE__ENCLOSING_SUBSYSTEMS: return ExecutionFlowPackage.SUBGRAPH__ENCLOSING_SUBSYSTEMS;
				case ExecutionFlowPackage.NODE__INCOMING_DATA_FLOWS: return ExecutionFlowPackage.SUBGRAPH__INCOMING_DATA_FLOWS;
				case ExecutionFlowPackage.NODE__OUTGOING_DATA_FLOWS: return ExecutionFlowPackage.SUBGRAPH__OUTGOING_DATA_FLOWS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //SubgraphImpl
