/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executiongraph.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.execution.executiongraph.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.executiongraph.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage;
import org.eclipselabs.damos.execution.executiongraph.Link;
import org.eclipselabs.damos.execution.executiongraph.Node;
import org.eclipselabs.damos.execution.executiongraph.internal.operations.NodeOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.impl.NodeImpl#getIncomingLinks <em>Incoming Links</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.impl.NodeImpl#getOutgoingLinks <em>Outgoing Links</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.impl.NodeImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.impl.NodeImpl#getOutgoingDataFlows <em>Outgoing Data Flows</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.impl.NodeImpl#getIncomingDataFlows <em>Incoming Data Flows</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.impl.NodeImpl#getEnclosingSubsystems <em>Enclosing Subsystems</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeImpl extends EObjectImpl implements Node {
	/**
	 * The cached value of the '{@link #getIncomingLinks() <em>Incoming Links</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<Link> incomingLinks;

	/**
	 * The cached value of the '{@link #getOutgoingLinks() <em>Outgoing Links</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<Link> outgoingLinks;

	/**
	 * The cached value of the '{@link #getComponent() <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponent()
	 * @generated
	 * @ordered
	 */
	protected Component component;

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
	 * The cached value of the '{@link #getIncomingDataFlows() <em>Incoming Data Flows</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingDataFlows()
	 * @generated
	 * @ordered
	 */
	protected EList<DataFlowTargetEnd> incomingDataFlows;

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
		return ExecutionGraphPackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Link> getIncomingLinks() {
		if (incomingLinks == null) {
			incomingLinks = new EObjectWithInverseResolvingEList<Link>(Link.class, this, ExecutionGraphPackage.NODE__INCOMING_LINKS, ExecutionGraphPackage.LINK__TARGET_NODE);
		}
		return incomingLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Link> getOutgoingLinks() {
		if (outgoingLinks == null) {
			outgoingLinks = new EObjectWithInverseResolvingEList<Link>(Link.class, this, ExecutionGraphPackage.NODE__OUTGOING_LINKS, ExecutionGraphPackage.LINK__SOURCE_NODE);
		}
		return outgoingLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getComponent() {
		if (component != null && component.eIsProxy()) {
			InternalEObject oldComponent = (InternalEObject)component;
			component = (Component)eResolveProxy(oldComponent);
			if (component != oldComponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionGraphPackage.NODE__COMPONENT, oldComponent, component));
			}
		}
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component basicGetComponent() {
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponent(Component newComponent) {
		Component oldComponent = component;
		component = newComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionGraphPackage.NODE__COMPONENT, oldComponent, component));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataFlowSourceEnd> getOutgoingDataFlows() {
		if (outgoingDataFlows == null) {
			outgoingDataFlows = new EObjectWithInverseResolvingEList<DataFlowSourceEnd>(DataFlowSourceEnd.class, this, ExecutionGraphPackage.NODE__OUTGOING_DATA_FLOWS, ExecutionGraphPackage.DATA_FLOW_SOURCE_END__NODE);
		}
		return outgoingDataFlows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataFlowTargetEnd> getIncomingDataFlows() {
		if (incomingDataFlows == null) {
			incomingDataFlows = new EObjectWithInverseResolvingEList<DataFlowTargetEnd>(DataFlowTargetEnd.class, this, ExecutionGraphPackage.NODE__INCOMING_DATA_FLOWS, ExecutionGraphPackage.DATA_FLOW_TARGET_END__NODE);
		}
		return incomingDataFlows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Subsystem> getEnclosingSubsystems() {
		if (enclosingSubsystems == null) {
			enclosingSubsystems = new EObjectResolvingEList<Subsystem>(Subsystem.class, this, ExecutionGraphPackage.NODE__ENCLOSING_SUBSYSTEMS);
		}
		return enclosingSubsystems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlowTargetEnd getIncomingDataFlow(InputPort inputPort) {
		return NodeOperations.getIncomingDataFlow(this, inputPort);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlowSourceEnd getOutgoingDataFlow(OutputPort outputPort) {
		return NodeOperations.getOutgoingDataFlow(this, outputPort);
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
			case ExecutionGraphPackage.NODE__INCOMING_LINKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingLinks()).basicAdd(otherEnd, msgs);
			case ExecutionGraphPackage.NODE__OUTGOING_LINKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingLinks()).basicAdd(otherEnd, msgs);
			case ExecutionGraphPackage.NODE__OUTGOING_DATA_FLOWS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingDataFlows()).basicAdd(otherEnd, msgs);
			case ExecutionGraphPackage.NODE__INCOMING_DATA_FLOWS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingDataFlows()).basicAdd(otherEnd, msgs);
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
			case ExecutionGraphPackage.NODE__INCOMING_LINKS:
				return ((InternalEList<?>)getIncomingLinks()).basicRemove(otherEnd, msgs);
			case ExecutionGraphPackage.NODE__OUTGOING_LINKS:
				return ((InternalEList<?>)getOutgoingLinks()).basicRemove(otherEnd, msgs);
			case ExecutionGraphPackage.NODE__OUTGOING_DATA_FLOWS:
				return ((InternalEList<?>)getOutgoingDataFlows()).basicRemove(otherEnd, msgs);
			case ExecutionGraphPackage.NODE__INCOMING_DATA_FLOWS:
				return ((InternalEList<?>)getIncomingDataFlows()).basicRemove(otherEnd, msgs);
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
			case ExecutionGraphPackage.NODE__INCOMING_LINKS:
				return getIncomingLinks();
			case ExecutionGraphPackage.NODE__OUTGOING_LINKS:
				return getOutgoingLinks();
			case ExecutionGraphPackage.NODE__COMPONENT:
				if (resolve) return getComponent();
				return basicGetComponent();
			case ExecutionGraphPackage.NODE__OUTGOING_DATA_FLOWS:
				return getOutgoingDataFlows();
			case ExecutionGraphPackage.NODE__INCOMING_DATA_FLOWS:
				return getIncomingDataFlows();
			case ExecutionGraphPackage.NODE__ENCLOSING_SUBSYSTEMS:
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
			case ExecutionGraphPackage.NODE__INCOMING_LINKS:
				getIncomingLinks().clear();
				getIncomingLinks().addAll((Collection<? extends Link>)newValue);
				return;
			case ExecutionGraphPackage.NODE__OUTGOING_LINKS:
				getOutgoingLinks().clear();
				getOutgoingLinks().addAll((Collection<? extends Link>)newValue);
				return;
			case ExecutionGraphPackage.NODE__COMPONENT:
				setComponent((Component)newValue);
				return;
			case ExecutionGraphPackage.NODE__OUTGOING_DATA_FLOWS:
				getOutgoingDataFlows().clear();
				getOutgoingDataFlows().addAll((Collection<? extends DataFlowSourceEnd>)newValue);
				return;
			case ExecutionGraphPackage.NODE__INCOMING_DATA_FLOWS:
				getIncomingDataFlows().clear();
				getIncomingDataFlows().addAll((Collection<? extends DataFlowTargetEnd>)newValue);
				return;
			case ExecutionGraphPackage.NODE__ENCLOSING_SUBSYSTEMS:
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
			case ExecutionGraphPackage.NODE__INCOMING_LINKS:
				getIncomingLinks().clear();
				return;
			case ExecutionGraphPackage.NODE__OUTGOING_LINKS:
				getOutgoingLinks().clear();
				return;
			case ExecutionGraphPackage.NODE__COMPONENT:
				setComponent((Component)null);
				return;
			case ExecutionGraphPackage.NODE__OUTGOING_DATA_FLOWS:
				getOutgoingDataFlows().clear();
				return;
			case ExecutionGraphPackage.NODE__INCOMING_DATA_FLOWS:
				getIncomingDataFlows().clear();
				return;
			case ExecutionGraphPackage.NODE__ENCLOSING_SUBSYSTEMS:
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
			case ExecutionGraphPackage.NODE__INCOMING_LINKS:
				return incomingLinks != null && !incomingLinks.isEmpty();
			case ExecutionGraphPackage.NODE__OUTGOING_LINKS:
				return outgoingLinks != null && !outgoingLinks.isEmpty();
			case ExecutionGraphPackage.NODE__COMPONENT:
				return component != null;
			case ExecutionGraphPackage.NODE__OUTGOING_DATA_FLOWS:
				return outgoingDataFlows != null && !outgoingDataFlows.isEmpty();
			case ExecutionGraphPackage.NODE__INCOMING_DATA_FLOWS:
				return incomingDataFlows != null && !incomingDataFlows.isEmpty();
			case ExecutionGraphPackage.NODE__ENCLOSING_SUBSYSTEMS:
				return enclosingSubsystems != null && !enclosingSubsystems.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NodeImpl
