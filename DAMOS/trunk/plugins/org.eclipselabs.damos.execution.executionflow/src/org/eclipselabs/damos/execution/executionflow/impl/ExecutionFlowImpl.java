/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionflow.impl;

import java.util.Collection;

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
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.execution.executionflow.DataFlow;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlow;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage;
import org.eclipselabs.damos.execution.executionflow.Graph;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.execution.executionflow.TaskGraph;
import org.eclipselabs.damos.execution.executionflow.internal.operations.ExecutionFlowOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowImpl#getTopLevelFragment <em>Top Level Fragment</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowImpl#getGraph <em>Graph</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowImpl#getDataFlows <em>Data Flows</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowImpl#getAsynchronousZoneCount <em>Asynchronous Zone Count</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowImpl#getTaskGraphs <em>Task Graphs</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.impl.ExecutionFlowImpl#getFundamentalSampleTime <em>Fundamental Sample Time</em>}</li>
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
	 * The default value of the '{@link #getFundamentalSampleTime() <em>Fundamental Sample Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFundamentalSampleTime()
	 * @generated
	 * @ordered
	 */
	protected static final double FUNDAMENTAL_SAMPLE_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getFundamentalSampleTime() <em>Fundamental Sample Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFundamentalSampleTime()
	 * @generated
	 * @ordered
	 */
	protected double fundamentalSampleTime = FUNDAMENTAL_SAMPLE_TIME_EDEFAULT;

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
		return ExecutionFlowPackage.Literals.EXECUTION_FLOW;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionFlowPackage.EXECUTION_FLOW__TOP_LEVEL_FRAGMENT, oldTopLevelFragment, topLevelFragment));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionFlowPackage.EXECUTION_FLOW__TOP_LEVEL_FRAGMENT, oldTopLevelFragment, topLevelFragment));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExecutionFlowPackage.EXECUTION_FLOW__GRAPH, oldGraph, newGraph);
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
				msgs = ((InternalEObject)graph).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExecutionFlowPackage.EXECUTION_FLOW__GRAPH, null, msgs);
			if (newGraph != null)
				msgs = ((InternalEObject)newGraph).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExecutionFlowPackage.EXECUTION_FLOW__GRAPH, null, msgs);
			msgs = basicSetGraph(newGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionFlowPackage.EXECUTION_FLOW__GRAPH, newGraph, newGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataFlow> getDataFlows() {
		if (dataFlows == null) {
			dataFlows = new EObjectContainmentEList<DataFlow>(DataFlow.class, this, ExecutionFlowPackage.EXECUTION_FLOW__DATA_FLOWS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionFlowPackage.EXECUTION_FLOW__ASYNCHRONOUS_ZONE_COUNT, oldAsynchronousZoneCount, asynchronousZoneCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TaskGraph> getTaskGraphs() {
		if (taskGraphs == null) {
			taskGraphs = new EObjectContainmentEList<TaskGraph>(TaskGraph.class, this, ExecutionFlowPackage.EXECUTION_FLOW__TASK_GRAPHS);
		}
		return taskGraphs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getFundamentalSampleTime() {
		return fundamentalSampleTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFundamentalSampleTime(double newFundamentalSampleTime) {
		double oldFundamentalSampleTime = fundamentalSampleTime;
		fundamentalSampleTime = newFundamentalSampleTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionFlowPackage.EXECUTION_FLOW__FUNDAMENTAL_SAMPLE_TIME, oldFundamentalSampleTime, fundamentalSampleTime));
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
			case ExecutionFlowPackage.EXECUTION_FLOW__GRAPH:
				return basicSetGraph(null, msgs);
			case ExecutionFlowPackage.EXECUTION_FLOW__DATA_FLOWS:
				return ((InternalEList<?>)getDataFlows()).basicRemove(otherEnd, msgs);
			case ExecutionFlowPackage.EXECUTION_FLOW__TASK_GRAPHS:
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
			case ExecutionFlowPackage.EXECUTION_FLOW__TOP_LEVEL_FRAGMENT:
				if (resolve) return getTopLevelFragment();
				return basicGetTopLevelFragment();
			case ExecutionFlowPackage.EXECUTION_FLOW__GRAPH:
				return getGraph();
			case ExecutionFlowPackage.EXECUTION_FLOW__DATA_FLOWS:
				return getDataFlows();
			case ExecutionFlowPackage.EXECUTION_FLOW__ASYNCHRONOUS_ZONE_COUNT:
				return getAsynchronousZoneCount();
			case ExecutionFlowPackage.EXECUTION_FLOW__TASK_GRAPHS:
				return getTaskGraphs();
			case ExecutionFlowPackage.EXECUTION_FLOW__FUNDAMENTAL_SAMPLE_TIME:
				return getFundamentalSampleTime();
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
			case ExecutionFlowPackage.EXECUTION_FLOW__TOP_LEVEL_FRAGMENT:
				setTopLevelFragment((Fragment)newValue);
				return;
			case ExecutionFlowPackage.EXECUTION_FLOW__GRAPH:
				setGraph((Graph)newValue);
				return;
			case ExecutionFlowPackage.EXECUTION_FLOW__DATA_FLOWS:
				getDataFlows().clear();
				getDataFlows().addAll((Collection<? extends DataFlow>)newValue);
				return;
			case ExecutionFlowPackage.EXECUTION_FLOW__ASYNCHRONOUS_ZONE_COUNT:
				setAsynchronousZoneCount((Integer)newValue);
				return;
			case ExecutionFlowPackage.EXECUTION_FLOW__TASK_GRAPHS:
				getTaskGraphs().clear();
				getTaskGraphs().addAll((Collection<? extends TaskGraph>)newValue);
				return;
			case ExecutionFlowPackage.EXECUTION_FLOW__FUNDAMENTAL_SAMPLE_TIME:
				setFundamentalSampleTime((Double)newValue);
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
			case ExecutionFlowPackage.EXECUTION_FLOW__TOP_LEVEL_FRAGMENT:
				setTopLevelFragment((Fragment)null);
				return;
			case ExecutionFlowPackage.EXECUTION_FLOW__GRAPH:
				setGraph((Graph)null);
				return;
			case ExecutionFlowPackage.EXECUTION_FLOW__DATA_FLOWS:
				getDataFlows().clear();
				return;
			case ExecutionFlowPackage.EXECUTION_FLOW__ASYNCHRONOUS_ZONE_COUNT:
				setAsynchronousZoneCount(ASYNCHRONOUS_ZONE_COUNT_EDEFAULT);
				return;
			case ExecutionFlowPackage.EXECUTION_FLOW__TASK_GRAPHS:
				getTaskGraphs().clear();
				return;
			case ExecutionFlowPackage.EXECUTION_FLOW__FUNDAMENTAL_SAMPLE_TIME:
				setFundamentalSampleTime(FUNDAMENTAL_SAMPLE_TIME_EDEFAULT);
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
			case ExecutionFlowPackage.EXECUTION_FLOW__TOP_LEVEL_FRAGMENT:
				return topLevelFragment != null;
			case ExecutionFlowPackage.EXECUTION_FLOW__GRAPH:
				return graph != null;
			case ExecutionFlowPackage.EXECUTION_FLOW__DATA_FLOWS:
				return dataFlows != null && !dataFlows.isEmpty();
			case ExecutionFlowPackage.EXECUTION_FLOW__ASYNCHRONOUS_ZONE_COUNT:
				return asynchronousZoneCount != ASYNCHRONOUS_ZONE_COUNT_EDEFAULT;
			case ExecutionFlowPackage.EXECUTION_FLOW__TASK_GRAPHS:
				return taskGraphs != null && !taskGraphs.isEmpty();
			case ExecutionFlowPackage.EXECUTION_FLOW__FUNDAMENTAL_SAMPLE_TIME:
				return fundamentalSampleTime != FUNDAMENTAL_SAMPLE_TIME_EDEFAULT;
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
		result.append(", fundamentalSampleTime: ");
		result.append(fundamentalSampleTime);
		result.append(')');
		return result.toString();
	}

} //ExecutionFlowImpl
