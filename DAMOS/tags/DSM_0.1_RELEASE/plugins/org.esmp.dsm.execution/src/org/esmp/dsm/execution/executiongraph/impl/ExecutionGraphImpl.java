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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.esmp.dsm.execution.executiongraph.ExecutionEdge;
import org.esmp.dsm.execution.executiongraph.ExecutionGraph;
import org.esmp.dsm.execution.executiongraph.ExecutionGraphPackage;
import org.esmp.dsm.execution.executiongraph.ExecutionNode;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagram;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.esmp.dsm.execution.executiongraph.impl.ExecutionGraphImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.esmp.dsm.execution.executiongraph.impl.ExecutionGraphImpl#getInitialNodes <em>Initial Nodes</em>}</li>
 *   <li>{@link org.esmp.dsm.execution.executiongraph.impl.ExecutionGraphImpl#getEdges <em>Edges</em>}</li>
 *   <li>{@link org.esmp.dsm.execution.executiongraph.impl.ExecutionGraphImpl#getBlockDiagram <em>Block Diagram</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionGraphImpl extends EObjectImpl implements ExecutionGraph {
	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<ExecutionNode> nodes;

	/**
	 * The cached value of the '{@link #getInitialNodes() <em>Initial Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<ExecutionNode> initialNodes;

	/**
	 * The cached value of the '{@link #getEdges() <em>Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<ExecutionEdge> edges;

	/**
	 * The cached value of the '{@link #getBlockDiagram() <em>Block Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockDiagram()
	 * @generated
	 * @ordered
	 */
	protected BlockDiagram blockDiagram;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionGraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionGraphPackage.Literals.EXECUTION_GRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExecutionNode> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<ExecutionNode>(ExecutionNode.class, this, ExecutionGraphPackage.EXECUTION_GRAPH__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExecutionNode> getInitialNodes() {
		if (initialNodes == null) {
			initialNodes = new EObjectResolvingEList<ExecutionNode>(ExecutionNode.class, this, ExecutionGraphPackage.EXECUTION_GRAPH__INITIAL_NODES);
		}
		return initialNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExecutionEdge> getEdges() {
		if (edges == null) {
			edges = new EObjectContainmentEList<ExecutionEdge>(ExecutionEdge.class, this, ExecutionGraphPackage.EXECUTION_GRAPH__EDGES);
		}
		return edges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockDiagram getBlockDiagram() {
		if (blockDiagram != null && blockDiagram.eIsProxy()) {
			InternalEObject oldBlockDiagram = (InternalEObject)blockDiagram;
			blockDiagram = (BlockDiagram)eResolveProxy(oldBlockDiagram);
			if (blockDiagram != oldBlockDiagram) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionGraphPackage.EXECUTION_GRAPH__BLOCK_DIAGRAM, oldBlockDiagram, blockDiagram));
			}
		}
		return blockDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockDiagram basicGetBlockDiagram() {
		return blockDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlockDiagram(BlockDiagram newBlockDiagram) {
		BlockDiagram oldBlockDiagram = blockDiagram;
		blockDiagram = newBlockDiagram;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionGraphPackage.EXECUTION_GRAPH__BLOCK_DIAGRAM, oldBlockDiagram, blockDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ExecutionNode getNode(URI blockURI) {
		for (ExecutionNode node : getNodes()) {
			if (EcoreUtil.getURI(node.getBlock()).equals(blockURI)) {
				return node;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExecutionGraphPackage.EXECUTION_GRAPH__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case ExecutionGraphPackage.EXECUTION_GRAPH__EDGES:
				return ((InternalEList<?>)getEdges()).basicRemove(otherEnd, msgs);
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
			case ExecutionGraphPackage.EXECUTION_GRAPH__NODES:
				return getNodes();
			case ExecutionGraphPackage.EXECUTION_GRAPH__INITIAL_NODES:
				return getInitialNodes();
			case ExecutionGraphPackage.EXECUTION_GRAPH__EDGES:
				return getEdges();
			case ExecutionGraphPackage.EXECUTION_GRAPH__BLOCK_DIAGRAM:
				if (resolve) return getBlockDiagram();
				return basicGetBlockDiagram();
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
			case ExecutionGraphPackage.EXECUTION_GRAPH__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends ExecutionNode>)newValue);
				return;
			case ExecutionGraphPackage.EXECUTION_GRAPH__INITIAL_NODES:
				getInitialNodes().clear();
				getInitialNodes().addAll((Collection<? extends ExecutionNode>)newValue);
				return;
			case ExecutionGraphPackage.EXECUTION_GRAPH__EDGES:
				getEdges().clear();
				getEdges().addAll((Collection<? extends ExecutionEdge>)newValue);
				return;
			case ExecutionGraphPackage.EXECUTION_GRAPH__BLOCK_DIAGRAM:
				setBlockDiagram((BlockDiagram)newValue);
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
			case ExecutionGraphPackage.EXECUTION_GRAPH__NODES:
				getNodes().clear();
				return;
			case ExecutionGraphPackage.EXECUTION_GRAPH__INITIAL_NODES:
				getInitialNodes().clear();
				return;
			case ExecutionGraphPackage.EXECUTION_GRAPH__EDGES:
				getEdges().clear();
				return;
			case ExecutionGraphPackage.EXECUTION_GRAPH__BLOCK_DIAGRAM:
				setBlockDiagram((BlockDiagram)null);
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
			case ExecutionGraphPackage.EXECUTION_GRAPH__NODES:
				return nodes != null && !nodes.isEmpty();
			case ExecutionGraphPackage.EXECUTION_GRAPH__INITIAL_NODES:
				return initialNodes != null && !initialNodes.isEmpty();
			case ExecutionGraphPackage.EXECUTION_GRAPH__EDGES:
				return edges != null && !edges.isEmpty();
			case ExecutionGraphPackage.EXECUTION_GRAPH__BLOCK_DIAGRAM:
				return blockDiagram != null;
		}
		return super.eIsSet(featureID);
	}

} //ExecutionGraphImpl
