/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionflow.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage;
import org.eclipselabs.damos.execution.executionflow.TaskInputNode;
import org.eclipselabs.damos.execution.executionflow.TaskNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task Input Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.impl.TaskInputNodeImpl#getTaskNode <em>Task Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskInputNodeImpl extends NodeImpl implements TaskInputNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskInputNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionFlowPackage.Literals.TASK_INPUT_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskNode getTaskNode() {
		if (eContainerFeatureID() != ExecutionFlowPackage.TASK_INPUT_NODE__TASK_NODE) return null;
		return (TaskNode)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTaskNode(TaskNode newTaskNode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTaskNode, ExecutionFlowPackage.TASK_INPUT_NODE__TASK_NODE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaskNode(TaskNode newTaskNode) {
		if (newTaskNode != eInternalContainer() || (eContainerFeatureID() != ExecutionFlowPackage.TASK_INPUT_NODE__TASK_NODE && newTaskNode != null)) {
			if (EcoreUtil.isAncestor(this, newTaskNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTaskNode != null)
				msgs = ((InternalEObject)newTaskNode).eInverseAdd(this, ExecutionFlowPackage.TASK_NODE__INPUT_NODES, TaskNode.class, msgs);
			msgs = basicSetTaskNode(newTaskNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionFlowPackage.TASK_INPUT_NODE__TASK_NODE, newTaskNode, newTaskNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExecutionFlowPackage.TASK_INPUT_NODE__TASK_NODE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTaskNode((TaskNode)otherEnd, msgs);
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
			case ExecutionFlowPackage.TASK_INPUT_NODE__TASK_NODE:
				return basicSetTaskNode(null, msgs);
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
			case ExecutionFlowPackage.TASK_INPUT_NODE__TASK_NODE:
				return eInternalContainer().eInverseRemove(this, ExecutionFlowPackage.TASK_NODE__INPUT_NODES, TaskNode.class, msgs);
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
			case ExecutionFlowPackage.TASK_INPUT_NODE__TASK_NODE:
				return getTaskNode();
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
			case ExecutionFlowPackage.TASK_INPUT_NODE__TASK_NODE:
				setTaskNode((TaskNode)newValue);
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
			case ExecutionFlowPackage.TASK_INPUT_NODE__TASK_NODE:
				setTaskNode((TaskNode)null);
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
			case ExecutionFlowPackage.TASK_INPUT_NODE__TASK_NODE:
				return getTaskNode() != null;
		}
		return super.eIsSet(featureID);
	}

} //TaskInputNodeImpl
