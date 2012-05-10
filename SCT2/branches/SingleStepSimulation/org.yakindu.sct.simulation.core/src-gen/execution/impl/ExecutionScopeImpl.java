/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   committers of YAKINDU - initial API and implementation
 *  
 */
package execution.impl;

import execution.ExecutionEvent;
import execution.ExecutionPackage;
import execution.ExecutionScope;
import execution.ExecutionVariable;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scope</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link execution.impl.ExecutionScopeImpl#getDeclaredEvents <em>Declared Events</em>}</li>
 *   <li>{@link execution.impl.ExecutionScopeImpl#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionScopeImpl extends EObjectImpl implements ExecutionScope {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2012 committers of YAKINDU and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\nContributors:\r\n  committers of YAKINDU - initial API and implementation\r\n ";

	/**
	 * The cached value of the '{@link #getDeclaredEvents() <em>Declared Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaredEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<ExecutionEvent> declaredEvents;

	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected ExecutionVariable variables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionScopeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionPackage.Literals.EXECUTION_SCOPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExecutionEvent> getDeclaredEvents() {
		if (declaredEvents == null) {
			declaredEvents = new EObjectContainmentEList<ExecutionEvent>(ExecutionEvent.class, this, ExecutionPackage.EXECUTION_SCOPE__DECLARED_EVENTS);
		}
		return declaredEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionVariable getVariables() {
		if (variables != null && variables.eIsProxy()) {
			InternalEObject oldVariables = (InternalEObject)variables;
			variables = (ExecutionVariable)eResolveProxy(oldVariables);
			if (variables != oldVariables) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionPackage.EXECUTION_SCOPE__VARIABLES, oldVariables, variables));
			}
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionVariable basicGetVariables() {
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariables(ExecutionVariable newVariables) {
		ExecutionVariable oldVariables = variables;
		variables = newVariables;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionPackage.EXECUTION_SCOPE__VARIABLES, oldVariables, variables));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExecutionPackage.EXECUTION_SCOPE__DECLARED_EVENTS:
				return ((InternalEList<?>)getDeclaredEvents()).basicRemove(otherEnd, msgs);
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
			case ExecutionPackage.EXECUTION_SCOPE__DECLARED_EVENTS:
				return getDeclaredEvents();
			case ExecutionPackage.EXECUTION_SCOPE__VARIABLES:
				if (resolve) return getVariables();
				return basicGetVariables();
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
			case ExecutionPackage.EXECUTION_SCOPE__DECLARED_EVENTS:
				getDeclaredEvents().clear();
				getDeclaredEvents().addAll((Collection<? extends ExecutionEvent>)newValue);
				return;
			case ExecutionPackage.EXECUTION_SCOPE__VARIABLES:
				setVariables((ExecutionVariable)newValue);
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
			case ExecutionPackage.EXECUTION_SCOPE__DECLARED_EVENTS:
				getDeclaredEvents().clear();
				return;
			case ExecutionPackage.EXECUTION_SCOPE__VARIABLES:
				setVariables((ExecutionVariable)null);
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
			case ExecutionPackage.EXECUTION_SCOPE__DECLARED_EVENTS:
				return declaredEvents != null && !declaredEvents.isEmpty();
			case ExecutionPackage.EXECUTION_SCOPE__VARIABLES:
				return variables != null;
		}
		return super.eIsSet(featureID);
	}

} //ExecutionScopeImpl
