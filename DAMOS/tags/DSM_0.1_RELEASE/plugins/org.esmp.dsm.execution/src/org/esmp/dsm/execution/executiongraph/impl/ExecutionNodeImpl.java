/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.execution.executiongraph.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.esmp.dsm.execution.executiongraph.ExecutionEdge;
import org.esmp.dsm.execution.executiongraph.ExecutionGraphPackage;
import org.esmp.dsm.execution.executiongraph.ExecutionNode;
import org.esmp.dsm.semantic.blockdiagram.Block;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.esmp.dsm.execution.executiongraph.impl.ExecutionNodeImpl#getIncomingEdges <em>Incoming Edges</em>}</li>
 *   <li>{@link org.esmp.dsm.execution.executiongraph.impl.ExecutionNodeImpl#getOutgoingEdges <em>Outgoing Edges</em>}</li>
 *   <li>{@link org.esmp.dsm.execution.executiongraph.impl.ExecutionNodeImpl#getBlock <em>Block</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionNodeImpl extends EObjectImpl implements ExecutionNode {
	/**
	 * The cached value of the '{@link #getIncomingEdges() <em>Incoming Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<ExecutionEdge> incomingEdges;

	/**
	 * The cached value of the '{@link #getOutgoingEdges() <em>Outgoing Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<ExecutionEdge> outgoingEdges;

	/**
	 * The cached value of the '{@link #getBlock() <em>Block</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlock()
	 * @generated
	 * @ordered
	 */
	protected Block block;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionGraphPackage.Literals.EXECUTION_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExecutionEdge> getIncomingEdges() {
		if (incomingEdges == null) {
			incomingEdges = new EObjectWithInverseResolvingEList<ExecutionEdge>(ExecutionEdge.class, this, ExecutionGraphPackage.EXECUTION_NODE__INCOMING_EDGES, ExecutionGraphPackage.EXECUTION_EDGE__TARGET);
		}
		return incomingEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExecutionEdge> getOutgoingEdges() {
		if (outgoingEdges == null) {
			outgoingEdges = new EObjectWithInverseResolvingEList<ExecutionEdge>(ExecutionEdge.class, this, ExecutionGraphPackage.EXECUTION_NODE__OUTGOING_EDGES, ExecutionGraphPackage.EXECUTION_EDGE__SOURCE);
		}
		return outgoingEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block getBlock() {
		if (block != null && block.eIsProxy()) {
			InternalEObject oldBlock = (InternalEObject)block;
			block = (Block)eResolveProxy(oldBlock);
			if (block != oldBlock) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionGraphPackage.EXECUTION_NODE__BLOCK, oldBlock, block));
			}
		}
		return block;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block basicGetBlock() {
		return block;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlock(Block newBlock) {
		Block oldBlock = block;
		block = newBlock;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionGraphPackage.EXECUTION_NODE__BLOCK, oldBlock, block));
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
			case ExecutionGraphPackage.EXECUTION_NODE__INCOMING_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingEdges()).basicAdd(otherEnd, msgs);
			case ExecutionGraphPackage.EXECUTION_NODE__OUTGOING_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingEdges()).basicAdd(otherEnd, msgs);
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
			case ExecutionGraphPackage.EXECUTION_NODE__INCOMING_EDGES:
				return ((InternalEList<?>)getIncomingEdges()).basicRemove(otherEnd, msgs);
			case ExecutionGraphPackage.EXECUTION_NODE__OUTGOING_EDGES:
				return ((InternalEList<?>)getOutgoingEdges()).basicRemove(otherEnd, msgs);
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
			case ExecutionGraphPackage.EXECUTION_NODE__INCOMING_EDGES:
				return getIncomingEdges();
			case ExecutionGraphPackage.EXECUTION_NODE__OUTGOING_EDGES:
				return getOutgoingEdges();
			case ExecutionGraphPackage.EXECUTION_NODE__BLOCK:
				if (resolve) return getBlock();
				return basicGetBlock();
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
			case ExecutionGraphPackage.EXECUTION_NODE__INCOMING_EDGES:
				getIncomingEdges().clear();
				getIncomingEdges().addAll((Collection<? extends ExecutionEdge>)newValue);
				return;
			case ExecutionGraphPackage.EXECUTION_NODE__OUTGOING_EDGES:
				getOutgoingEdges().clear();
				getOutgoingEdges().addAll((Collection<? extends ExecutionEdge>)newValue);
				return;
			case ExecutionGraphPackage.EXECUTION_NODE__BLOCK:
				setBlock((Block)newValue);
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
			case ExecutionGraphPackage.EXECUTION_NODE__INCOMING_EDGES:
				getIncomingEdges().clear();
				return;
			case ExecutionGraphPackage.EXECUTION_NODE__OUTGOING_EDGES:
				getOutgoingEdges().clear();
				return;
			case ExecutionGraphPackage.EXECUTION_NODE__BLOCK:
				setBlock((Block)null);
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
			case ExecutionGraphPackage.EXECUTION_NODE__INCOMING_EDGES:
				return incomingEdges != null && !incomingEdges.isEmpty();
			case ExecutionGraphPackage.EXECUTION_NODE__OUTGOING_EDGES:
				return outgoingEdges != null && !outgoingEdges.isEmpty();
			case ExecutionGraphPackage.EXECUTION_NODE__BLOCK:
				return block != null;
		}
		return super.eIsSet(featureID);
	}

} //ExecutionNodeImpl
