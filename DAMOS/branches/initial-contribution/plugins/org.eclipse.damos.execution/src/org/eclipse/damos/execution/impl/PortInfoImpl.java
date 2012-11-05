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

import org.eclipse.damos.execution.ExecutionPackage;
import org.eclipse.damos.execution.PortInfo;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.execution.impl.PortInfoImpl#getInoutputIndex <em>Inoutput Index</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.impl.PortInfoImpl#getPortIndex <em>Port Index</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PortInfoImpl extends ConnectorInfoImpl implements PortInfo {
	/**
	 * The default value of the '{@link #getInoutputIndex() <em>Inoutput Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInoutputIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int INOUTPUT_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getInoutputIndex() <em>Inoutput Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInoutputIndex()
	 * @generated
	 * @ordered
	 */
	protected int inoutputIndex = INOUTPUT_INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getPortIndex() <em>Port Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int PORT_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPortIndex() <em>Port Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortIndex()
	 * @generated
	 * @ordered
	 */
	protected int portIndex = PORT_INDEX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionPackage.Literals.PORT_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getInoutputIndex() {
		return inoutputIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInoutputIndex(int newInoutputIndex) {
		int oldInoutputIndex = inoutputIndex;
		inoutputIndex = newInoutputIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionPackage.PORT_INFO__INOUTPUT_INDEX, oldInoutputIndex, inoutputIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPortIndex() {
		return portIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPortIndex(int newPortIndex) {
		int oldPortIndex = portIndex;
		portIndex = newPortIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionPackage.PORT_INFO__PORT_INDEX, oldPortIndex, portIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExecutionPackage.PORT_INFO__INOUTPUT_INDEX:
				return getInoutputIndex();
			case ExecutionPackage.PORT_INFO__PORT_INDEX:
				return getPortIndex();
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
			case ExecutionPackage.PORT_INFO__INOUTPUT_INDEX:
				setInoutputIndex((Integer)newValue);
				return;
			case ExecutionPackage.PORT_INFO__PORT_INDEX:
				setPortIndex((Integer)newValue);
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
			case ExecutionPackage.PORT_INFO__INOUTPUT_INDEX:
				setInoutputIndex(INOUTPUT_INDEX_EDEFAULT);
				return;
			case ExecutionPackage.PORT_INFO__PORT_INDEX:
				setPortIndex(PORT_INDEX_EDEFAULT);
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
			case ExecutionPackage.PORT_INFO__INOUTPUT_INDEX:
				return inoutputIndex != INOUTPUT_INDEX_EDEFAULT;
			case ExecutionPackage.PORT_INFO__PORT_INDEX:
				return portIndex != PORT_INDEX_EDEFAULT;
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
		result.append(" (inoutputIndex: ");
		result.append(inoutputIndex);
		result.append(", portIndex: ");
		result.append(portIndex);
		result.append(')');
		return result.toString();
	}

} //PortInfoImpl
