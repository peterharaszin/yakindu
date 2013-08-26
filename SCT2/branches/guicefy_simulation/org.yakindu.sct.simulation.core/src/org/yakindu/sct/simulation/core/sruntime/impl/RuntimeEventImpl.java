/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.sruntime.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.yakindu.sct.simulation.core.sruntime.RuntimeEvent;
import org.yakindu.sct.simulation.core.sruntime.SRuntimePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Runtime Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.impl.RuntimeEventImpl#isRaised <em>Raised</em>}</li>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.impl.RuntimeEventImpl#isScheduled <em>Scheduled</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuntimeEventImpl extends RuntimeSlotImpl implements RuntimeEvent {
	/**
	 * The default value of the '{@link #isRaised() <em>Raised</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRaised()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RAISED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRaised() <em>Raised</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRaised()
	 * @generated
	 * @ordered
	 */
	protected boolean raised = RAISED_EDEFAULT;

	/**
	 * The default value of the '{@link #isScheduled() <em>Scheduled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isScheduled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SCHEDULED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isScheduled() <em>Scheduled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isScheduled()
	 * @generated
	 * @ordered
	 */
	protected boolean scheduled = SCHEDULED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SRuntimePackage.Literals.RUNTIME_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRaised() {
		return raised;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRaised(boolean newRaised) {
		boolean oldRaised = raised;
		raised = newRaised;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SRuntimePackage.RUNTIME_EVENT__RAISED, oldRaised, raised));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isScheduled() {
		return scheduled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScheduled(boolean newScheduled) {
		boolean oldScheduled = scheduled;
		scheduled = newScheduled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SRuntimePackage.RUNTIME_EVENT__SCHEDULED, oldScheduled, scheduled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SRuntimePackage.RUNTIME_EVENT__RAISED:
				return isRaised();
			case SRuntimePackage.RUNTIME_EVENT__SCHEDULED:
				return isScheduled();
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
			case SRuntimePackage.RUNTIME_EVENT__RAISED:
				setRaised((Boolean)newValue);
				return;
			case SRuntimePackage.RUNTIME_EVENT__SCHEDULED:
				setScheduled((Boolean)newValue);
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
			case SRuntimePackage.RUNTIME_EVENT__RAISED:
				setRaised(RAISED_EDEFAULT);
				return;
			case SRuntimePackage.RUNTIME_EVENT__SCHEDULED:
				setScheduled(SCHEDULED_EDEFAULT);
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
			case SRuntimePackage.RUNTIME_EVENT__RAISED:
				return raised != RAISED_EDEFAULT;
			case SRuntimePackage.RUNTIME_EVENT__SCHEDULED:
				return scheduled != SCHEDULED_EDEFAULT;
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
		result.append(" (raised: ");
		result.append(raised);
		result.append(", scheduled: ");
		result.append(scheduled);
		result.append(')');
		return result.toString();
	}

} //RuntimeEventImpl
