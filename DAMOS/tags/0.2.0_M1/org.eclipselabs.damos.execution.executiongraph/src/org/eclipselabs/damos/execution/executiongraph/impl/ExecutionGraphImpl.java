/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executiongraph.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.execution.executiongraph.DataFlow;
import org.eclipselabs.damos.execution.executiongraph.ExecutionGraph;
import org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage;
import org.eclipselabs.damos.execution.executiongraph.Link;
import org.eclipselabs.damos.execution.executiongraph.Node;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.impl.ExecutionGraphImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.impl.ExecutionGraphImpl#getInitialNodes <em>Initial Nodes</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.impl.ExecutionGraphImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.impl.ExecutionGraphImpl#getTopLevelFragment <em>Top Level Fragment</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.impl.ExecutionGraphImpl#getDataFlows <em>Data Flows</em>}</li>
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
	protected EList<Node> nodes;

	/**
	 * The cached value of the '{@link #getInitialNodes() <em>Initial Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> initialNodes;

	/**
	 * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<Link> links;

	/**
	 * The cached value of the '{@link #getTopLevelFragment() <em>Top Level Fragment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopLevelFragment()
	 * @generated
	 * @ordered
	 */
	protected Fragment topLevelFragment;

	/**
	 * The cached value of the '{@link #getDataFlows() <em>Data Flows</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataFlows()
	 * @generated
	 * @ordered
	 */
	protected EList<DataFlow> dataFlows;

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
	public EList<Node> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<Node>(Node.class, this, ExecutionGraphPackage.EXECUTION_GRAPH__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Node> getInitialNodes() {
		if (initialNodes == null) {
			initialNodes = new EObjectResolvingEList<Node>(Node.class, this, ExecutionGraphPackage.EXECUTION_GRAPH__INITIAL_NODES);
		}
		return initialNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Link> getLinks() {
		if (links == null) {
			links = new EObjectContainmentEList<Link>(Link.class, this, ExecutionGraphPackage.EXECUTION_GRAPH__LINKS);
		}
		return links;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fragment getTopLevelFragment() {
		if (topLevelFragment != null && topLevelFragment.eIsProxy()) {
			InternalEObject oldTopLevelFragment = (InternalEObject)topLevelFragment;
			topLevelFragment = (Fragment)eResolveProxy(oldTopLevelFragment);
			if (topLevelFragment != oldTopLevelFragment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionGraphPackage.EXECUTION_GRAPH__TOP_LEVEL_FRAGMENT, oldTopLevelFragment, topLevelFragment));
			}
		}
		return topLevelFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fragment basicGetTopLevelFragment() {
		return topLevelFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopLevelFragment(Fragment newTopLevelFragment) {
		Fragment oldTopLevelFragment = topLevelFragment;
		topLevelFragment = newTopLevelFragment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionGraphPackage.EXECUTION_GRAPH__TOP_LEVEL_FRAGMENT, oldTopLevelFragment, topLevelFragment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataFlow> getDataFlows() {
		if (dataFlows == null) {
			dataFlows = new EObjectContainmentEList<DataFlow>(DataFlow.class, this, ExecutionGraphPackage.EXECUTION_GRAPH__DATA_FLOWS);
		}
		return dataFlows;
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
			case ExecutionGraphPackage.EXECUTION_GRAPH__LINKS:
				return ((InternalEList<?>)getLinks()).basicRemove(otherEnd, msgs);
			case ExecutionGraphPackage.EXECUTION_GRAPH__DATA_FLOWS:
				return ((InternalEList<?>)getDataFlows()).basicRemove(otherEnd, msgs);
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
			case ExecutionGraphPackage.EXECUTION_GRAPH__LINKS:
				return getLinks();
			case ExecutionGraphPackage.EXECUTION_GRAPH__TOP_LEVEL_FRAGMENT:
				if (resolve) return getTopLevelFragment();
				return basicGetTopLevelFragment();
			case ExecutionGraphPackage.EXECUTION_GRAPH__DATA_FLOWS:
				return getDataFlows();
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
				getNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case ExecutionGraphPackage.EXECUTION_GRAPH__INITIAL_NODES:
				getInitialNodes().clear();
				getInitialNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case ExecutionGraphPackage.EXECUTION_GRAPH__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends Link>)newValue);
				return;
			case ExecutionGraphPackage.EXECUTION_GRAPH__TOP_LEVEL_FRAGMENT:
				setTopLevelFragment((Fragment)newValue);
				return;
			case ExecutionGraphPackage.EXECUTION_GRAPH__DATA_FLOWS:
				getDataFlows().clear();
				getDataFlows().addAll((Collection<? extends DataFlow>)newValue);
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
			case ExecutionGraphPackage.EXECUTION_GRAPH__LINKS:
				getLinks().clear();
				return;
			case ExecutionGraphPackage.EXECUTION_GRAPH__TOP_LEVEL_FRAGMENT:
				setTopLevelFragment((Fragment)null);
				return;
			case ExecutionGraphPackage.EXECUTION_GRAPH__DATA_FLOWS:
				getDataFlows().clear();
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
			case ExecutionGraphPackage.EXECUTION_GRAPH__LINKS:
				return links != null && !links.isEmpty();
			case ExecutionGraphPackage.EXECUTION_GRAPH__TOP_LEVEL_FRAGMENT:
				return topLevelFragment != null;
			case ExecutionGraphPackage.EXECUTION_GRAPH__DATA_FLOWS:
				return dataFlows != null && !dataFlows.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExecutionGraphImpl
