/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.execution.executiongraph.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.esmp.dsm.execution.executiongraph.ExecutionEdge;
import org.esmp.dsm.execution.executiongraph.ExecutionGraphPackage;
import org.esmp.dsm.execution.executiongraph.ExecutionNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.esmp.dsm.execution.executiongraph.impl.ExecutionEdgeImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.esmp.dsm.execution.executiongraph.impl.ExecutionEdgeImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionEdgeImpl extends EObjectImpl implements ExecutionEdge {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected ExecutionNode source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected ExecutionNode target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionGraphPackage.Literals.EXECUTION_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionNode getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (ExecutionNode)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionGraphPackage.EXECUTION_EDGE__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionNode basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(ExecutionNode newSource, NotificationChain msgs) {
		ExecutionNode oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExecutionGraphPackage.EXECUTION_EDGE__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(ExecutionNode newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, ExecutionGraphPackage.EXECUTION_NODE__OUTGOING_EDGES, ExecutionNode.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, ExecutionGraphPackage.EXECUTION_NODE__OUTGOING_EDGES, ExecutionNode.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionGraphPackage.EXECUTION_EDGE__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionNode getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (ExecutionNode)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionGraphPackage.EXECUTION_EDGE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionNode basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(ExecutionNode newTarget, NotificationChain msgs) {
		ExecutionNode oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExecutionGraphPackage.EXECUTION_EDGE__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(ExecutionNode newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, ExecutionGraphPackage.EXECUTION_NODE__INCOMING_EDGES, ExecutionNode.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, ExecutionGraphPackage.EXECUTION_NODE__INCOMING_EDGES, ExecutionNode.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionGraphPackage.EXECUTION_EDGE__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExecutionGraphPackage.EXECUTION_EDGE__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, ExecutionGraphPackage.EXECUTION_NODE__OUTGOING_EDGES, ExecutionNode.class, msgs);
				return basicSetSource((ExecutionNode)otherEnd, msgs);
			case ExecutionGraphPackage.EXECUTION_EDGE__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, ExecutionGraphPackage.EXECUTION_NODE__INCOMING_EDGES, ExecutionNode.class, msgs);
				return basicSetTarget((ExecutionNode)otherEnd, msgs);
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
			case ExecutionGraphPackage.EXECUTION_EDGE__SOURCE:
				return basicSetSource(null, msgs);
			case ExecutionGraphPackage.EXECUTION_EDGE__TARGET:
				return basicSetTarget(null, msgs);
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
			case ExecutionGraphPackage.EXECUTION_EDGE__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case ExecutionGraphPackage.EXECUTION_EDGE__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
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
			case ExecutionGraphPackage.EXECUTION_EDGE__SOURCE:
				setSource((ExecutionNode)newValue);
				return;
			case ExecutionGraphPackage.EXECUTION_EDGE__TARGET:
				setTarget((ExecutionNode)newValue);
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
			case ExecutionGraphPackage.EXECUTION_EDGE__SOURCE:
				setSource((ExecutionNode)null);
				return;
			case ExecutionGraphPackage.EXECUTION_EDGE__TARGET:
				setTarget((ExecutionNode)null);
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
			case ExecutionGraphPackage.EXECUTION_EDGE__SOURCE:
				return source != null;
			case ExecutionGraphPackage.EXECUTION_EDGE__TARGET:
				return target != null;
		}
		return super.eIsSet(featureID);
	}

} //ExecutionEdgeImpl
