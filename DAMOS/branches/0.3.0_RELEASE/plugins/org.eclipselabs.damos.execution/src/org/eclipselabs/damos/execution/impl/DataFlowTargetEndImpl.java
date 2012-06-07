/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.InputConnector;
import org.eclipselabs.damos.execution.DataFlow;
import org.eclipselabs.damos.execution.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.ExecutionPackage;
import org.eclipselabs.damos.execution.Node;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Flow Target End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.impl.DataFlowTargetEndImpl#getNode <em>Node</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.impl.DataFlowTargetEndImpl#getDataFlow <em>Data Flow</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.impl.DataFlowTargetEndImpl#getConnector <em>Connector</em>}</li>
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
	 * The cached value of the '{@link #getConnector() <em>Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnector()
	 * @generated
	 * @ordered
	 */
	protected InputConnector connector;

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
		return ExecutionPackage.Literals.DATA_FLOW_TARGET_END;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionPackage.DATA_FLOW_TARGET_END__NODE, oldNode, node));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExecutionPackage.DATA_FLOW_TARGET_END__NODE, oldNode, newNode);
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
				msgs = ((InternalEObject)node).eInverseRemove(this, ExecutionPackage.NODE__INCOMING_DATA_FLOWS, Node.class, msgs);
			if (newNode != null)
				msgs = ((InternalEObject)newNode).eInverseAdd(this, ExecutionPackage.NODE__INCOMING_DATA_FLOWS, Node.class, msgs);
			msgs = basicSetNode(newNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionPackage.DATA_FLOW_TARGET_END__NODE, newNode, newNode));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlow getDataFlow() {
		if (eContainerFeatureID() != ExecutionPackage.DATA_FLOW_TARGET_END__DATA_FLOW) return null;
		return (DataFlow)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataFlow(DataFlow newDataFlow, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDataFlow, ExecutionPackage.DATA_FLOW_TARGET_END__DATA_FLOW, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataFlow(DataFlow newDataFlow) {
		if (newDataFlow != eInternalContainer() || (eContainerFeatureID() != ExecutionPackage.DATA_FLOW_TARGET_END__DATA_FLOW && newDataFlow != null)) {
			if (EcoreUtil.isAncestor(this, newDataFlow))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDataFlow != null)
				msgs = ((InternalEObject)newDataFlow).eInverseAdd(this, ExecutionPackage.DATA_FLOW__TARGET_ENDS, DataFlow.class, msgs);
			msgs = basicSetDataFlow(newDataFlow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionPackage.DATA_FLOW_TARGET_END__DATA_FLOW, newDataFlow, newDataFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputConnector getConnector() {
		if (connector != null && connector.eIsProxy()) {
			InternalEObject oldConnector = (InternalEObject)connector;
			connector = (InputConnector)eResolveProxy(oldConnector);
			if (connector != oldConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionPackage.DATA_FLOW_TARGET_END__CONNECTOR, oldConnector, connector));
			}
		}
		return connector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputConnector basicGetConnector() {
		return connector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnector(InputConnector newConnector) {
		InputConnector oldConnector = connector;
		connector = newConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionPackage.DATA_FLOW_TARGET_END__CONNECTOR, oldConnector, connector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DataFlowSourceEnd getSourceEnd() {
		return getDataFlow().getSourceEnd();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExecutionPackage.DATA_FLOW_TARGET_END__NODE:
				if (node != null)
					msgs = ((InternalEObject)node).eInverseRemove(this, ExecutionPackage.NODE__INCOMING_DATA_FLOWS, Node.class, msgs);
				return basicSetNode((Node)otherEnd, msgs);
			case ExecutionPackage.DATA_FLOW_TARGET_END__DATA_FLOW:
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
			case ExecutionPackage.DATA_FLOW_TARGET_END__NODE:
				return basicSetNode(null, msgs);
			case ExecutionPackage.DATA_FLOW_TARGET_END__DATA_FLOW:
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
			case ExecutionPackage.DATA_FLOW_TARGET_END__DATA_FLOW:
				return eInternalContainer().eInverseRemove(this, ExecutionPackage.DATA_FLOW__TARGET_ENDS, DataFlow.class, msgs);
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
			case ExecutionPackage.DATA_FLOW_TARGET_END__NODE:
				if (resolve) return getNode();
				return basicGetNode();
			case ExecutionPackage.DATA_FLOW_TARGET_END__DATA_FLOW:
				return getDataFlow();
			case ExecutionPackage.DATA_FLOW_TARGET_END__CONNECTOR:
				if (resolve) return getConnector();
				return basicGetConnector();
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
			case ExecutionPackage.DATA_FLOW_TARGET_END__NODE:
				setNode((Node)newValue);
				return;
			case ExecutionPackage.DATA_FLOW_TARGET_END__DATA_FLOW:
				setDataFlow((DataFlow)newValue);
				return;
			case ExecutionPackage.DATA_FLOW_TARGET_END__CONNECTOR:
				setConnector((InputConnector)newValue);
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
			case ExecutionPackage.DATA_FLOW_TARGET_END__NODE:
				setNode((Node)null);
				return;
			case ExecutionPackage.DATA_FLOW_TARGET_END__DATA_FLOW:
				setDataFlow((DataFlow)null);
				return;
			case ExecutionPackage.DATA_FLOW_TARGET_END__CONNECTOR:
				setConnector((InputConnector)null);
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
			case ExecutionPackage.DATA_FLOW_TARGET_END__NODE:
				return node != null;
			case ExecutionPackage.DATA_FLOW_TARGET_END__DATA_FLOW:
				return getDataFlow() != null;
			case ExecutionPackage.DATA_FLOW_TARGET_END__CONNECTOR:
				return connector != null;
		}
		return super.eIsSet(featureID);
	}

} //DataFlowTargetEndImpl
