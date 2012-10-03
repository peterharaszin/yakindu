/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.execution.impl;

import java.util.Collection;

import org.eclipse.damos.execution.ExecutionPackage;
import org.eclipse.damos.execution.LatchNode;
import org.eclipse.damos.execution.TaskGraph;
import org.eclipse.damos.execution.TaskInputNode;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.execution.impl.TaskGraphImpl#getInputNodes <em>Input Nodes</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.impl.TaskGraphImpl#getLatchNodes <em>Latch Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskGraphImpl extends GraphImpl implements TaskGraph {
	/**
	 * The cached value of the '{@link #getInputNodes() <em>Input Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<TaskInputNode> inputNodes;
	/**
	 * The cached value of the '{@link #getLatchNodes() <em>Latch Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatchNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<LatchNode> latchNodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskGraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionPackage.Literals.TASK_GRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TaskInputNode> getInputNodes() {
		if (inputNodes == null) {
			inputNodes = new EObjectContainmentWithInverseEList<TaskInputNode>(TaskInputNode.class, this, ExecutionPackage.TASK_GRAPH__INPUT_NODES, ExecutionPackage.TASK_INPUT_NODE__TASK_GRAPH);
		}
		return inputNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LatchNode> getLatchNodes() {
		if (latchNodes == null) {
			latchNodes = new EObjectWithInverseResolvingEList.ManyInverse<LatchNode>(LatchNode.class, this, ExecutionPackage.TASK_GRAPH__LATCH_NODES, ExecutionPackage.LATCH_NODE__TASK_NODES);
		}
		return latchNodes;
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
			case ExecutionPackage.TASK_GRAPH__INPUT_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInputNodes()).basicAdd(otherEnd, msgs);
			case ExecutionPackage.TASK_GRAPH__LATCH_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLatchNodes()).basicAdd(otherEnd, msgs);
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
			case ExecutionPackage.TASK_GRAPH__INPUT_NODES:
				return ((InternalEList<?>)getInputNodes()).basicRemove(otherEnd, msgs);
			case ExecutionPackage.TASK_GRAPH__LATCH_NODES:
				return ((InternalEList<?>)getLatchNodes()).basicRemove(otherEnd, msgs);
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
			case ExecutionPackage.TASK_GRAPH__INPUT_NODES:
				return getInputNodes();
			case ExecutionPackage.TASK_GRAPH__LATCH_NODES:
				return getLatchNodes();
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
			case ExecutionPackage.TASK_GRAPH__INPUT_NODES:
				getInputNodes().clear();
				getInputNodes().addAll((Collection<? extends TaskInputNode>)newValue);
				return;
			case ExecutionPackage.TASK_GRAPH__LATCH_NODES:
				getLatchNodes().clear();
				getLatchNodes().addAll((Collection<? extends LatchNode>)newValue);
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
			case ExecutionPackage.TASK_GRAPH__INPUT_NODES:
				getInputNodes().clear();
				return;
			case ExecutionPackage.TASK_GRAPH__LATCH_NODES:
				getLatchNodes().clear();
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
			case ExecutionPackage.TASK_GRAPH__INPUT_NODES:
				return inputNodes != null && !inputNodes.isEmpty();
			case ExecutionPackage.TASK_GRAPH__LATCH_NODES:
				return latchNodes != null && !latchNodes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TaskNodeImpl
