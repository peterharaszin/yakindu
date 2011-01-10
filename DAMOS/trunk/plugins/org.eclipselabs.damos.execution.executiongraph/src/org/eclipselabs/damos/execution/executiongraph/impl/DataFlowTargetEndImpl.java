/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executiongraph.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.execution.executiongraph.DataFlow;
import org.eclipselabs.damos.execution.executiongraph.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage;
import org.eclipselabs.damos.execution.executiongraph.Node;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Flow Target End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.impl.DataFlowTargetEndImpl#getNode <em>Node</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.impl.DataFlowTargetEndImpl#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.impl.DataFlowTargetEndImpl#getDataFlow <em>Data Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataFlowTargetEndImpl extends DataFlowEndImpl implements DataFlowTargetEnd {
	/**
	 * The cached value of the '{@link #getNode() <em>Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode()
	 * @generated
	 * @ordered
	 */
	protected Node node;

	/**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected InputPort port;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataFlowTargetEndImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionGraphPackage.Literals.DATA_FLOW_TARGET_END;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getNode() {
		if (node != null && node.eIsProxy()) {
			InternalEObject oldNode = (InternalEObject)node;
			node = (Node)eResolveProxy(oldNode);
			if (node != oldNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionGraphPackage.DATA_FLOW_TARGET_END__NODE, oldNode, node));
			}
		}
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetNode() {
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNode(Node newNode, NotificationChain msgs) {
		Node oldNode = node;
		node = newNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExecutionGraphPackage.DATA_FLOW_TARGET_END__NODE, oldNode, newNode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNode(Node newNode) {
		if (newNode != node) {
			NotificationChain msgs = null;
			if (node != null)
				msgs = ((InternalEObject)node).eInverseRemove(this, ExecutionGraphPackage.NODE__INCOMING_DATA_FLOWS, Node.class, msgs);
			if (newNode != null)
				msgs = ((InternalEObject)newNode).eInverseAdd(this, ExecutionGraphPackage.NODE__INCOMING_DATA_FLOWS, Node.class, msgs);
			msgs = basicSetNode(newNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionGraphPackage.DATA_FLOW_TARGET_END__NODE, newNode, newNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPort getPort() {
		if (port != null && port.eIsProxy()) {
			InternalEObject oldPort = (InternalEObject)port;
			port = (InputPort)eResolveProxy(oldPort);
			if (port != oldPort) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionGraphPackage.DATA_FLOW_TARGET_END__PORT, oldPort, port));
			}
		}
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPort basicGetPort() {
		return port;
	}

	public void setPort(InputPort newPort) {
		setPortGen(newPort);
		inoutputIndex = DMLUtil.indexOf(newPort.getInput());
		portIndex = newPort.getIndex();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPortGen(InputPort newPort) {
		InputPort oldPort = port;
		port = newPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionGraphPackage.DATA_FLOW_TARGET_END__PORT, oldPort, port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlow getDataFlow() {
		if (eContainerFeatureID() != ExecutionGraphPackage.DATA_FLOW_TARGET_END__DATA_FLOW) return null;
		return (DataFlow)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataFlow(DataFlow newDataFlow, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDataFlow, ExecutionGraphPackage.DATA_FLOW_TARGET_END__DATA_FLOW, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataFlow(DataFlow newDataFlow) {
		if (newDataFlow != eInternalContainer() || (eContainerFeatureID() != ExecutionGraphPackage.DATA_FLOW_TARGET_END__DATA_FLOW && newDataFlow != null)) {
			if (EcoreUtil.isAncestor(this, newDataFlow))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDataFlow != null)
				msgs = ((InternalEObject)newDataFlow).eInverseAdd(this, ExecutionGraphPackage.DATA_FLOW__TARGET_ENDS, DataFlow.class, msgs);
			msgs = basicSetDataFlow(newDataFlow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionGraphPackage.DATA_FLOW_TARGET_END__DATA_FLOW, newDataFlow, newDataFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExecutionGraphPackage.DATA_FLOW_TARGET_END__NODE:
				if (node != null)
					msgs = ((InternalEObject)node).eInverseRemove(this, ExecutionGraphPackage.NODE__INCOMING_DATA_FLOWS, Node.class, msgs);
				return basicSetNode((Node)otherEnd, msgs);
			case ExecutionGraphPackage.DATA_FLOW_TARGET_END__DATA_FLOW:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDataFlow((DataFlow)otherEnd, msgs);
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
			case ExecutionGraphPackage.DATA_FLOW_TARGET_END__NODE:
				return basicSetNode(null, msgs);
			case ExecutionGraphPackage.DATA_FLOW_TARGET_END__DATA_FLOW:
				return basicSetDataFlow(null, msgs);
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
			case ExecutionGraphPackage.DATA_FLOW_TARGET_END__DATA_FLOW:
				return eInternalContainer().eInverseRemove(this, ExecutionGraphPackage.DATA_FLOW__TARGET_ENDS, DataFlow.class, msgs);
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
			case ExecutionGraphPackage.DATA_FLOW_TARGET_END__NODE:
				if (resolve) return getNode();
				return basicGetNode();
			case ExecutionGraphPackage.DATA_FLOW_TARGET_END__PORT:
				if (resolve) return getPort();
				return basicGetPort();
			case ExecutionGraphPackage.DATA_FLOW_TARGET_END__DATA_FLOW:
				return getDataFlow();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExecutionGraphPackage.DATA_FLOW_TARGET_END__NODE:
				setNode((Node)newValue);
				return;
			case ExecutionGraphPackage.DATA_FLOW_TARGET_END__PORT:
				setPort((InputPort)newValue);
				return;
			case ExecutionGraphPackage.DATA_FLOW_TARGET_END__DATA_FLOW:
				setDataFlow((DataFlow)newValue);
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
			case ExecutionGraphPackage.DATA_FLOW_TARGET_END__NODE:
				setNode((Node)null);
				return;
			case ExecutionGraphPackage.DATA_FLOW_TARGET_END__PORT:
				setPort((InputPort)null);
				return;
			case ExecutionGraphPackage.DATA_FLOW_TARGET_END__DATA_FLOW:
				setDataFlow((DataFlow)null);
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
			case ExecutionGraphPackage.DATA_FLOW_TARGET_END__NODE:
				return node != null;
			case ExecutionGraphPackage.DATA_FLOW_TARGET_END__PORT:
				return port != null;
			case ExecutionGraphPackage.DATA_FLOW_TARGET_END__DATA_FLOW:
				return getDataFlow() != null;
		}
		return super.eIsSet(featureID);
	}

} //DataFlowTargetEndImpl
