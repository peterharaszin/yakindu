/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.execution.impl;

import java.util.Collection;

import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.execution.DataFlow;
import org.eclipse.damos.execution.ExecutionFlow;
import org.eclipse.damos.execution.ExecutionPackage;
import org.eclipse.damos.execution.Graph;
import org.eclipse.damos.execution.Node;
import org.eclipse.damos.execution.TaskGraph;
import org.eclipse.damos.execution.internal.operations.ExecutionFlowOperations;
import org.eclipse.damos.mscript.util.ISampleInterval;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.execution.impl.ExecutionFlowImpl#getTopLevelFragment <em>Top Level Fragment</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.impl.ExecutionFlowImpl#getGraph <em>Graph</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.impl.ExecutionFlowImpl#getDataFlows <em>Data Flows</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.impl.ExecutionFlowImpl#getAsynchronousZoneCount <em>Asynchronous Zone Count</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.impl.ExecutionFlowImpl#getTaskGraphs <em>Task Graphs</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.impl.ExecutionFlowImpl#getFundamentalSampleInterval <em>Fundamental Sample Interval</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionFlowImpl extends EObjectImpl implements ExecutionFlow {
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
	 * The cached value of the '{@link #getGraph() <em>Graph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraph()
	 * @generated
	 * @ordered
	 */
	protected Graph graph;

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
	 * The default value of the '{@link #getAsynchronousZoneCount() <em>Asynchronous Zone Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsynchronousZoneCount()
	 * @generated
	 * @ordered
	 */
	protected static final int ASYNCHRONOUS_ZONE_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAsynchronousZoneCount() <em>Asynchronous Zone Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsynchronousZoneCount()
	 * @generated
	 * @ordered
	 */
	protected int asynchronousZoneCount = ASYNCHRONOUS_ZONE_COUNT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTaskGraphs() <em>Task Graphs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskGraphs()
	 * @generated
	 * @ordered
	 */
	protected EList<TaskGraph> taskGraphs;

	/**
	 * The default value of the '{@link #getFundamentalSampleInterval() <em>Fundamental Sample Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFundamentalSampleInterval()
	 * @generated
	 * @ordered
	 */
	protected static final ISampleInterval FUNDAMENTAL_SAMPLE_INTERVAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFundamentalSampleInterval() <em>Fundamental Sample Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFundamentalSampleInterval()
	 * @generated
	 * @ordered
	 */
	protected ISampleInterval fundamentalSampleInterval = FUNDAMENTAL_SAMPLE_INTERVAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionFlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionPackage.Literals.EXECUTION_FLOW;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionPackage.EXECUTION_FLOW__TOP_LEVEL_FRAGMENT, oldTopLevelFragment, topLevelFragment));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionPackage.EXECUTION_FLOW__TOP_LEVEL_FRAGMENT, oldTopLevelFragment, topLevelFragment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getGraph() {
		return graph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGraph(Graph newGraph, NotificationChain msgs) {
		Graph oldGraph = graph;
		graph = newGraph;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExecutionPackage.EXECUTION_FLOW__GRAPH, oldGraph, newGraph);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraph(Graph newGraph) {
		if (newGraph != graph) {
			NotificationChain msgs = null;
			if (graph != null)
				msgs = ((InternalEObject)graph).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExecutionPackage.EXECUTION_FLOW__GRAPH, null, msgs);
			if (newGraph != null)
				msgs = ((InternalEObject)newGraph).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExecutionPackage.EXECUTION_FLOW__GRAPH, null, msgs);
			msgs = basicSetGraph(newGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionPackage.EXECUTION_FLOW__GRAPH, newGraph, newGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataFlow> getDataFlows() {
		if (dataFlows == null) {
			dataFlows = new EObjectContainmentEList<DataFlow>(DataFlow.class, this, ExecutionPackage.EXECUTION_FLOW__DATA_FLOWS);
		}
		return dataFlows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAsynchronousZoneCount() {
		return asynchronousZoneCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAsynchronousZoneCount(int newAsynchronousZoneCount) {
		int oldAsynchronousZoneCount = asynchronousZoneCount;
		asynchronousZoneCount = newAsynchronousZoneCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionPackage.EXECUTION_FLOW__ASYNCHRONOUS_ZONE_COUNT, oldAsynchronousZoneCount, asynchronousZoneCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TaskGraph> getTaskGraphs() {
		if (taskGraphs == null) {
			taskGraphs = new EObjectContainmentEList<TaskGraph>(TaskGraph.class, this, ExecutionPackage.EXECUTION_FLOW__TASK_GRAPHS);
		}
		return taskGraphs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISampleInterval getFundamentalSampleInterval() {
		return fundamentalSampleInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFundamentalSampleInterval(ISampleInterval newFundamentalSampleInterval) {
		ISampleInterval oldFundamentalSampleInterval = fundamentalSampleInterval;
		fundamentalSampleInterval = newFundamentalSampleInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionPackage.EXECUTION_FLOW__FUNDAMENTAL_SAMPLE_INTERVAL, oldFundamentalSampleInterval, fundamentalSampleInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TreeIterator<Node> getAllNodesIterator() {
		return ExecutionFlowOperations.getAllNodesIterator(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Iterable<Node> getAllNodes() {
		return ExecutionFlowOperations.getAllNodes(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExecutionPackage.EXECUTION_FLOW__GRAPH:
				return basicSetGraph(null, msgs);
			case ExecutionPackage.EXECUTION_FLOW__DATA_FLOWS:
				return ((InternalEList<?>)getDataFlows()).basicRemove(otherEnd, msgs);
			case ExecutionPackage.EXECUTION_FLOW__TASK_GRAPHS:
				return ((InternalEList<?>)getTaskGraphs()).basicRemove(otherEnd, msgs);
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
			case ExecutionPackage.EXECUTION_FLOW__TOP_LEVEL_FRAGMENT:
				if (resolve) return getTopLevelFragment();
				return basicGetTopLevelFragment();
			case ExecutionPackage.EXECUTION_FLOW__GRAPH:
				return getGraph();
			case ExecutionPackage.EXECUTION_FLOW__DATA_FLOWS:
				return getDataFlows();
			case ExecutionPackage.EXECUTION_FLOW__ASYNCHRONOUS_ZONE_COUNT:
				return getAsynchronousZoneCount();
			case ExecutionPackage.EXECUTION_FLOW__TASK_GRAPHS:
				return getTaskGraphs();
			case ExecutionPackage.EXECUTION_FLOW__FUNDAMENTAL_SAMPLE_INTERVAL:
				return getFundamentalSampleInterval();
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
			case ExecutionPackage.EXECUTION_FLOW__TOP_LEVEL_FRAGMENT:
				setTopLevelFragment((Fragment)newValue);
				return;
			case ExecutionPackage.EXECUTION_FLOW__GRAPH:
				setGraph((Graph)newValue);
				return;
			case ExecutionPackage.EXECUTION_FLOW__DATA_FLOWS:
				getDataFlows().clear();
				getDataFlows().addAll((Collection<? extends DataFlow>)newValue);
				return;
			case ExecutionPackage.EXECUTION_FLOW__ASYNCHRONOUS_ZONE_COUNT:
				setAsynchronousZoneCount((Integer)newValue);
				return;
			case ExecutionPackage.EXECUTION_FLOW__TASK_GRAPHS:
				getTaskGraphs().clear();
				getTaskGraphs().addAll((Collection<? extends TaskGraph>)newValue);
				return;
			case ExecutionPackage.EXECUTION_FLOW__FUNDAMENTAL_SAMPLE_INTERVAL:
				setFundamentalSampleInterval((ISampleInterval)newValue);
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
			case ExecutionPackage.EXECUTION_FLOW__TOP_LEVEL_FRAGMENT:
				setTopLevelFragment((Fragment)null);
				return;
			case ExecutionPackage.EXECUTION_FLOW__GRAPH:
				setGraph((Graph)null);
				return;
			case ExecutionPackage.EXECUTION_FLOW__DATA_FLOWS:
				getDataFlows().clear();
				return;
			case ExecutionPackage.EXECUTION_FLOW__ASYNCHRONOUS_ZONE_COUNT:
				setAsynchronousZoneCount(ASYNCHRONOUS_ZONE_COUNT_EDEFAULT);
				return;
			case ExecutionPackage.EXECUTION_FLOW__TASK_GRAPHS:
				getTaskGraphs().clear();
				return;
			case ExecutionPackage.EXECUTION_FLOW__FUNDAMENTAL_SAMPLE_INTERVAL:
				setFundamentalSampleInterval(FUNDAMENTAL_SAMPLE_INTERVAL_EDEFAULT);
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
			case ExecutionPackage.EXECUTION_FLOW__TOP_LEVEL_FRAGMENT:
				return topLevelFragment != null;
			case ExecutionPackage.EXECUTION_FLOW__GRAPH:
				return graph != null;
			case ExecutionPackage.EXECUTION_FLOW__DATA_FLOWS:
				return dataFlows != null && !dataFlows.isEmpty();
			case ExecutionPackage.EXECUTION_FLOW__ASYNCHRONOUS_ZONE_COUNT:
				return asynchronousZoneCount != ASYNCHRONOUS_ZONE_COUNT_EDEFAULT;
			case ExecutionPackage.EXECUTION_FLOW__TASK_GRAPHS:
				return taskGraphs != null && !taskGraphs.isEmpty();
			case ExecutionPackage.EXECUTION_FLOW__FUNDAMENTAL_SAMPLE_INTERVAL:
				return FUNDAMENTAL_SAMPLE_INTERVAL_EDEFAULT == null ? fundamentalSampleInterval != null : !FUNDAMENTAL_SAMPLE_INTERVAL_EDEFAULT.equals(fundamentalSampleInterval);
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
		result.append(" (asynchronousZoneCount: ");
		result.append(asynchronousZoneCount);
		result.append(", fundamentalSampleInterval: ");
		result.append(fundamentalSampleInterval);
		result.append(')');
		return result.toString();
	}

} //ExecutionFlowImpl
