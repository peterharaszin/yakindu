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
package org.eclipse.damos.dml.impl;

import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.DirectFeedthroughPolicy;
import org.eclipse.damos.dml.InputDefinition;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.impl.InputDefinitionImpl#getDirectFeedthroughPolicy <em>Direct Feedthrough Policy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InputDefinitionImpl extends InoutputDefinitionImpl implements InputDefinition {
	/**
	 * The cached value of the '{@link #getDirectFeedthroughPolicy() <em>Direct Feedthrough Policy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirectFeedthroughPolicy()
	 * @generated
	 * @ordered
	 */
	protected DirectFeedthroughPolicy directFeedthroughPolicy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.INPUT_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectFeedthroughPolicy getDirectFeedthroughPolicy() {
		return directFeedthroughPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDirectFeedthroughPolicy(DirectFeedthroughPolicy newDirectFeedthroughPolicy, NotificationChain msgs) {
		DirectFeedthroughPolicy oldDirectFeedthroughPolicy = directFeedthroughPolicy;
		directFeedthroughPolicy = newDirectFeedthroughPolicy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DMLPackage.INPUT_DEFINITION__DIRECT_FEEDTHROUGH_POLICY, oldDirectFeedthroughPolicy, newDirectFeedthroughPolicy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirectFeedthroughPolicy(DirectFeedthroughPolicy newDirectFeedthroughPolicy) {
		if (newDirectFeedthroughPolicy != directFeedthroughPolicy) {
			NotificationChain msgs = null;
			if (directFeedthroughPolicy != null)
				msgs = ((InternalEObject)directFeedthroughPolicy).eInverseRemove(this, DMLPackage.DIRECT_FEEDTHROUGH_POLICY__INPUT_DEFINITION, DirectFeedthroughPolicy.class, msgs);
			if (newDirectFeedthroughPolicy != null)
				msgs = ((InternalEObject)newDirectFeedthroughPolicy).eInverseAdd(this, DMLPackage.DIRECT_FEEDTHROUGH_POLICY__INPUT_DEFINITION, DirectFeedthroughPolicy.class, msgs);
			msgs = basicSetDirectFeedthroughPolicy(newDirectFeedthroughPolicy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.INPUT_DEFINITION__DIRECT_FEEDTHROUGH_POLICY, newDirectFeedthroughPolicy, newDirectFeedthroughPolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DMLPackage.INPUT_DEFINITION__DIRECT_FEEDTHROUGH_POLICY:
				if (directFeedthroughPolicy != null)
					msgs = ((InternalEObject)directFeedthroughPolicy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DMLPackage.INPUT_DEFINITION__DIRECT_FEEDTHROUGH_POLICY, null, msgs);
				return basicSetDirectFeedthroughPolicy((DirectFeedthroughPolicy)otherEnd, msgs);
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
			case DMLPackage.INPUT_DEFINITION__DIRECT_FEEDTHROUGH_POLICY:
				return basicSetDirectFeedthroughPolicy(null, msgs);
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
			case DMLPackage.INPUT_DEFINITION__DIRECT_FEEDTHROUGH_POLICY:
				return getDirectFeedthroughPolicy();
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
			case DMLPackage.INPUT_DEFINITION__DIRECT_FEEDTHROUGH_POLICY:
				setDirectFeedthroughPolicy((DirectFeedthroughPolicy)newValue);
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
			case DMLPackage.INPUT_DEFINITION__DIRECT_FEEDTHROUGH_POLICY:
				setDirectFeedthroughPolicy((DirectFeedthroughPolicy)null);
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
			case DMLPackage.INPUT_DEFINITION__DIRECT_FEEDTHROUGH_POLICY:
				return directFeedthroughPolicy != null;
		}
		return super.eIsSet(featureID);
	}

} //InputDefinitionImpl
