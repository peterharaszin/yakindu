/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.simulation.simulationmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModel;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simulation Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelImpl#getExecutionModel <em>Execution Model</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelImpl#getTopLevelFragment <em>Top Level Fragment</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelImpl#getSimulationTime <em>Simulation Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimulationModelImpl extends EObjectImpl implements SimulationModel {
	/**
	 * The cached value of the '{@link #getExecutionModel() <em>Execution Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionModel()
	 * @generated
	 * @ordered
	 */
	protected ExecutionModel executionModel;

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
	 * The default value of the '{@link #getSimulationTime() <em>Simulation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimulationTime()
	 * @generated
	 * @ordered
	 */
	protected static final double SIMULATION_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSimulationTime() <em>Simulation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimulationTime()
	 * @generated
	 * @ordered
	 */
	protected double simulationTime = SIMULATION_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimulationModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulationModelPackage.Literals.SIMULATION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionModel getExecutionModel() {
		if (executionModel != null && executionModel.eIsProxy()) {
			InternalEObject oldExecutionModel = (InternalEObject)executionModel;
			executionModel = (ExecutionModel)eResolveProxy(oldExecutionModel);
			if (executionModel != oldExecutionModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimulationModelPackage.SIMULATION_MODEL__EXECUTION_MODEL, oldExecutionModel, executionModel));
			}
		}
		return executionModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionModel basicGetExecutionModel() {
		return executionModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutionModel(ExecutionModel newExecutionModel) {
		ExecutionModel oldExecutionModel = executionModel;
		executionModel = newExecutionModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationModelPackage.SIMULATION_MODEL__EXECUTION_MODEL, oldExecutionModel, executionModel));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimulationModelPackage.SIMULATION_MODEL__TOP_LEVEL_FRAGMENT, oldTopLevelFragment, topLevelFragment));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationModelPackage.SIMULATION_MODEL__TOP_LEVEL_FRAGMENT, oldTopLevelFragment, topLevelFragment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSimulationTime() {
		return simulationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimulationTime(double newSimulationTime) {
		double oldSimulationTime = simulationTime;
		simulationTime = newSimulationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationModelPackage.SIMULATION_MODEL__SIMULATION_TIME, oldSimulationTime, simulationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimulationModelPackage.SIMULATION_MODEL__EXECUTION_MODEL:
				if (resolve) return getExecutionModel();
				return basicGetExecutionModel();
			case SimulationModelPackage.SIMULATION_MODEL__TOP_LEVEL_FRAGMENT:
				if (resolve) return getTopLevelFragment();
				return basicGetTopLevelFragment();
			case SimulationModelPackage.SIMULATION_MODEL__SIMULATION_TIME:
				return getSimulationTime();
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
			case SimulationModelPackage.SIMULATION_MODEL__EXECUTION_MODEL:
				setExecutionModel((ExecutionModel)newValue);
				return;
			case SimulationModelPackage.SIMULATION_MODEL__TOP_LEVEL_FRAGMENT:
				setTopLevelFragment((Fragment)newValue);
				return;
			case SimulationModelPackage.SIMULATION_MODEL__SIMULATION_TIME:
				setSimulationTime((Double)newValue);
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
			case SimulationModelPackage.SIMULATION_MODEL__EXECUTION_MODEL:
				setExecutionModel((ExecutionModel)null);
				return;
			case SimulationModelPackage.SIMULATION_MODEL__TOP_LEVEL_FRAGMENT:
				setTopLevelFragment((Fragment)null);
				return;
			case SimulationModelPackage.SIMULATION_MODEL__SIMULATION_TIME:
				setSimulationTime(SIMULATION_TIME_EDEFAULT);
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
			case SimulationModelPackage.SIMULATION_MODEL__EXECUTION_MODEL:
				return executionModel != null;
			case SimulationModelPackage.SIMULATION_MODEL__TOP_LEVEL_FRAGMENT:
				return topLevelFragment != null;
			case SimulationModelPackage.SIMULATION_MODEL__SIMULATION_TIME:
				return simulationTime != SIMULATION_TIME_EDEFAULT;
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
		result.append(" (simulationTime: ");
		result.append(simulationTime);
		result.append(')');
		return result.toString();
	}

} //SimulationModelImpl
