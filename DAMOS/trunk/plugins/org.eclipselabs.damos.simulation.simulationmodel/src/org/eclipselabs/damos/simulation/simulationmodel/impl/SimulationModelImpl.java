/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.simulation.simulationmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModel;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage;
import org.eclipselabs.damos.simulation.simulationmodel.SolverConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simulation Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelImpl#getExecutionModel <em>Execution Model</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelImpl#getTopLevelFragment <em>Top Level Fragment</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelImpl#getSimulationTime <em>Simulation Time</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelImpl#getSolverConfiguration <em>Solver Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimulationModelImpl extends EObjectImpl implements SimulationModel {
	/**
	 * The default value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String qualifiedName = QUALIFIED_NAME_EDEFAULT;

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
	 * The cached value of the '{@link #getSimulationTime() <em>Simulation Time</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimulationTime()
	 * @generated
	 * @ordered
	 */
	protected Expression simulationTime;

	/**
	 * The cached value of the '{@link #getSolverConfiguration() <em>Solver Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolverConfiguration()
	 * @generated
	 * @ordered
	 */
	protected SolverConfiguration solverConfiguration;

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
	public Expression getSimulationTime() {
		return simulationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSimulationTime(Expression newSimulationTime, NotificationChain msgs) {
		Expression oldSimulationTime = simulationTime;
		simulationTime = newSimulationTime;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimulationModelPackage.SIMULATION_MODEL__SIMULATION_TIME, oldSimulationTime, newSimulationTime);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimulationTime(Expression newSimulationTime) {
		if (newSimulationTime != simulationTime) {
			NotificationChain msgs = null;
			if (simulationTime != null)
				msgs = ((InternalEObject)simulationTime).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SimulationModelPackage.SIMULATION_MODEL__SIMULATION_TIME, null, msgs);
			if (newSimulationTime != null)
				msgs = ((InternalEObject)newSimulationTime).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SimulationModelPackage.SIMULATION_MODEL__SIMULATION_TIME, null, msgs);
			msgs = basicSetSimulationTime(newSimulationTime, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationModelPackage.SIMULATION_MODEL__SIMULATION_TIME, newSimulationTime, newSimulationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolverConfiguration getSolverConfiguration() {
		return solverConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSolverConfiguration(SolverConfiguration newSolverConfiguration, NotificationChain msgs) {
		SolverConfiguration oldSolverConfiguration = solverConfiguration;
		solverConfiguration = newSolverConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimulationModelPackage.SIMULATION_MODEL__SOLVER_CONFIGURATION, oldSolverConfiguration, newSolverConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolverConfiguration(SolverConfiguration newSolverConfiguration) {
		if (newSolverConfiguration != solverConfiguration) {
			NotificationChain msgs = null;
			if (solverConfiguration != null)
				msgs = ((InternalEObject)solverConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SimulationModelPackage.SIMULATION_MODEL__SOLVER_CONFIGURATION, null, msgs);
			if (newSolverConfiguration != null)
				msgs = ((InternalEObject)newSolverConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SimulationModelPackage.SIMULATION_MODEL__SOLVER_CONFIGURATION, null, msgs);
			msgs = basicSetSolverConfiguration(newSolverConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationModelPackage.SIMULATION_MODEL__SOLVER_CONFIGURATION, newSolverConfiguration, newSolverConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQualifiedName() {
		return qualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualifiedName(String newQualifiedName) {
		String oldQualifiedName = qualifiedName;
		qualifiedName = newQualifiedName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationModelPackage.SIMULATION_MODEL__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SimulationModelPackage.SIMULATION_MODEL__SIMULATION_TIME:
				return basicSetSimulationTime(null, msgs);
			case SimulationModelPackage.SIMULATION_MODEL__SOLVER_CONFIGURATION:
				return basicSetSolverConfiguration(null, msgs);
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
			case SimulationModelPackage.SIMULATION_MODEL__QUALIFIED_NAME:
				return getQualifiedName();
			case SimulationModelPackage.SIMULATION_MODEL__EXECUTION_MODEL:
				if (resolve) return getExecutionModel();
				return basicGetExecutionModel();
			case SimulationModelPackage.SIMULATION_MODEL__TOP_LEVEL_FRAGMENT:
				if (resolve) return getTopLevelFragment();
				return basicGetTopLevelFragment();
			case SimulationModelPackage.SIMULATION_MODEL__SIMULATION_TIME:
				return getSimulationTime();
			case SimulationModelPackage.SIMULATION_MODEL__SOLVER_CONFIGURATION:
				return getSolverConfiguration();
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
			case SimulationModelPackage.SIMULATION_MODEL__QUALIFIED_NAME:
				setQualifiedName((String)newValue);
				return;
			case SimulationModelPackage.SIMULATION_MODEL__EXECUTION_MODEL:
				setExecutionModel((ExecutionModel)newValue);
				return;
			case SimulationModelPackage.SIMULATION_MODEL__TOP_LEVEL_FRAGMENT:
				setTopLevelFragment((Fragment)newValue);
				return;
			case SimulationModelPackage.SIMULATION_MODEL__SIMULATION_TIME:
				setSimulationTime((Expression)newValue);
				return;
			case SimulationModelPackage.SIMULATION_MODEL__SOLVER_CONFIGURATION:
				setSolverConfiguration((SolverConfiguration)newValue);
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
			case SimulationModelPackage.SIMULATION_MODEL__QUALIFIED_NAME:
				setQualifiedName(QUALIFIED_NAME_EDEFAULT);
				return;
			case SimulationModelPackage.SIMULATION_MODEL__EXECUTION_MODEL:
				setExecutionModel((ExecutionModel)null);
				return;
			case SimulationModelPackage.SIMULATION_MODEL__TOP_LEVEL_FRAGMENT:
				setTopLevelFragment((Fragment)null);
				return;
			case SimulationModelPackage.SIMULATION_MODEL__SIMULATION_TIME:
				setSimulationTime((Expression)null);
				return;
			case SimulationModelPackage.SIMULATION_MODEL__SOLVER_CONFIGURATION:
				setSolverConfiguration((SolverConfiguration)null);
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
			case SimulationModelPackage.SIMULATION_MODEL__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
			case SimulationModelPackage.SIMULATION_MODEL__EXECUTION_MODEL:
				return executionModel != null;
			case SimulationModelPackage.SIMULATION_MODEL__TOP_LEVEL_FRAGMENT:
				return topLevelFragment != null;
			case SimulationModelPackage.SIMULATION_MODEL__SIMULATION_TIME:
				return simulationTime != null;
			case SimulationModelPackage.SIMULATION_MODEL__SOLVER_CONFIGURATION:
				return solverConfiguration != null;
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
		result.append(" (qualifiedName: ");
		result.append(qualifiedName);
		result.append(')');
		return result.toString();
	}

} //SimulationModelImpl
