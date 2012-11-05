/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.execution.impl;

import org.eclipse.damos.dml.Connector;
import org.eclipse.damos.execution.ConnectorInfo;
import org.eclipse.damos.execution.DataFlow;
import org.eclipse.damos.execution.DataFlowEnd;
import org.eclipse.damos.execution.ExecutionPackage;
import org.eclipse.damos.execution.Node;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Flow End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.execution.impl.DataFlowEndImpl#getConnectorInfo <em>Connector Info</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DataFlowEndImpl extends EObjectImpl implements DataFlowEnd {
	/**
	 * The cached value of the '{@link #getConnectorInfo() <em>Connector Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectorInfo()
	 * @generated
	 * @ordered
	 */
	protected ConnectorInfo connectorInfo;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataFlowEndImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionPackage.Literals.DATA_FLOW_END;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectorInfo getConnectorInfo() {
		return connectorInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConnectorInfo(ConnectorInfo newConnectorInfo, NotificationChain msgs) {
		ConnectorInfo oldConnectorInfo = connectorInfo;
		connectorInfo = newConnectorInfo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExecutionPackage.DATA_FLOW_END__CONNECTOR_INFO, oldConnectorInfo, newConnectorInfo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectorInfo(ConnectorInfo newConnectorInfo) {
		if (newConnectorInfo != connectorInfo) {
			NotificationChain msgs = null;
			if (connectorInfo != null)
				msgs = ((InternalEObject)connectorInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExecutionPackage.DATA_FLOW_END__CONNECTOR_INFO, null, msgs);
			if (newConnectorInfo != null)
				msgs = ((InternalEObject)newConnectorInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExecutionPackage.DATA_FLOW_END__CONNECTOR_INFO, null, msgs);
			msgs = basicSetConnectorInfo(newConnectorInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionPackage.DATA_FLOW_END__CONNECTOR_INFO, newConnectorInfo, newConnectorInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Node getNode() {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DataFlow getDataFlow() {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Connector getConnector() {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExecutionPackage.DATA_FLOW_END__CONNECTOR_INFO:
				return basicSetConnectorInfo(null, msgs);
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
			case ExecutionPackage.DATA_FLOW_END__CONNECTOR_INFO:
				return getConnectorInfo();
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
			case ExecutionPackage.DATA_FLOW_END__CONNECTOR_INFO:
				setConnectorInfo((ConnectorInfo)newValue);
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
			case ExecutionPackage.DATA_FLOW_END__CONNECTOR_INFO:
				setConnectorInfo((ConnectorInfo)null);
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
			case ExecutionPackage.DATA_FLOW_END__CONNECTOR_INFO:
				return connectorInfo != null;
		}
		return super.eIsSet(featureID);
	}

} //DataFlowEndImpl
