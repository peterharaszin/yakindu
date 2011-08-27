/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionflow.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage;
import org.eclipselabs.damos.execution.executionflow.LatchNode;
import org.eclipselabs.damos.execution.executionflow.TaskGraph;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Latch Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.impl.LatchNodeImpl#getTaskNodes <em>Task Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LatchNodeImpl extends ComponentNodeImpl implements LatchNode {
	/**
	 * The cached value of the '{@link #getTaskNodes() <em>Task Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<TaskGraph> taskNodes;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LatchNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionFlowPackage.Literals.LATCH_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TaskGraph> getTaskNodes() {
		if (taskNodes == null) {
			taskNodes = new EObjectWithInverseResolvingEList.ManyInverse<TaskGraph>(TaskGraph.class, this, ExecutionFlowPackage.LATCH_NODE__TASK_NODES, ExecutionFlowPackage.TASK_GRAPH__LATCH_NODES);
		}
		return taskNodes;
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
			case ExecutionFlowPackage.LATCH_NODE__TASK_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTaskNodes()).basicAdd(otherEnd, msgs);
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
			case ExecutionFlowPackage.LATCH_NODE__TASK_NODES:
				return ((InternalEList<?>)getTaskNodes()).basicRemove(otherEnd, msgs);
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
			case ExecutionFlowPackage.LATCH_NODE__TASK_NODES:
				return getTaskNodes();
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
			case ExecutionFlowPackage.LATCH_NODE__TASK_NODES:
				getTaskNodes().clear();
				getTaskNodes().addAll((Collection<? extends TaskGraph>)newValue);
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
			case ExecutionFlowPackage.LATCH_NODE__TASK_NODES:
				getTaskNodes().clear();
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
			case ExecutionFlowPackage.LATCH_NODE__TASK_NODES:
				return taskNodes != null && !taskNodes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LatchNodeImpl
