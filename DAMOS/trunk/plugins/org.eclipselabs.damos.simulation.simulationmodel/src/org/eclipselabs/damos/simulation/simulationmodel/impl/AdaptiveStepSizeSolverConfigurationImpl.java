/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.simulation.simulationmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Adaptive Step Size Solver Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.impl.AdaptiveStepSizeSolverConfigurationImpl#getMinimumStepSize <em>Minimum Step Size</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.impl.AdaptiveStepSizeSolverConfigurationImpl#getMaximumStepSize <em>Maximum Step Size</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.impl.AdaptiveStepSizeSolverConfigurationImpl#getInitialStepSize <em>Initial Step Size</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.impl.AdaptiveStepSizeSolverConfigurationImpl#getAbsoluteTolerance <em>Absolute Tolerance</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.impl.AdaptiveStepSizeSolverConfigurationImpl#getRelativeTolerance <em>Relative Tolerance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AdaptiveStepSizeSolverConfigurationImpl extends SolverConfigurationImpl implements AdaptiveStepSizeSolverConfiguration {
	/**
	 * The default value of the '{@link #getMinimumStepSize() <em>Minimum Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumStepSize()
	 * @generated
	 * @ordered
	 */
	protected static final double MINIMUM_STEP_SIZE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMinimumStepSize() <em>Minimum Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumStepSize()
	 * @generated
	 * @ordered
	 */
	protected double minimumStepSize = MINIMUM_STEP_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumStepSize() <em>Maximum Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumStepSize()
	 * @generated
	 * @ordered
	 */
	protected static final double MAXIMUM_STEP_SIZE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMaximumStepSize() <em>Maximum Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumStepSize()
	 * @generated
	 * @ordered
	 */
	protected double maximumStepSize = MAXIMUM_STEP_SIZE_EDEFAULT;

	/**
	 * This is true if the Maximum Step Size attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean maximumStepSizeESet;

	/**
	 * The default value of the '{@link #getInitialStepSize() <em>Initial Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialStepSize()
	 * @generated
	 * @ordered
	 */
	protected static final double INITIAL_STEP_SIZE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getInitialStepSize() <em>Initial Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialStepSize()
	 * @generated
	 * @ordered
	 */
	protected double initialStepSize = INITIAL_STEP_SIZE_EDEFAULT;

	/**
	 * This is true if the Initial Step Size attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean initialStepSizeESet;

	/**
	 * The default value of the '{@link #getAbsoluteTolerance() <em>Absolute Tolerance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbsoluteTolerance()
	 * @generated
	 * @ordered
	 */
	protected static final double ABSOLUTE_TOLERANCE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAbsoluteTolerance() <em>Absolute Tolerance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbsoluteTolerance()
	 * @generated
	 * @ordered
	 */
	protected double absoluteTolerance = ABSOLUTE_TOLERANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRelativeTolerance() <em>Relative Tolerance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelativeTolerance()
	 * @generated
	 * @ordered
	 */
	protected static final double RELATIVE_TOLERANCE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRelativeTolerance() <em>Relative Tolerance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelativeTolerance()
	 * @generated
	 * @ordered
	 */
	protected double relativeTolerance = RELATIVE_TOLERANCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdaptiveStepSizeSolverConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulationModelPackage.Literals.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMinimumStepSize() {
		return minimumStepSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumStepSize(double newMinimumStepSize) {
		double oldMinimumStepSize = minimumStepSize;
		minimumStepSize = newMinimumStepSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__MINIMUM_STEP_SIZE, oldMinimumStepSize, minimumStepSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMaximumStepSize() {
		return maximumStepSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumStepSize(double newMaximumStepSize) {
		double oldMaximumStepSize = maximumStepSize;
		maximumStepSize = newMaximumStepSize;
		boolean oldMaximumStepSizeESet = maximumStepSizeESet;
		maximumStepSizeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__MAXIMUM_STEP_SIZE, oldMaximumStepSize, maximumStepSize, !oldMaximumStepSizeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaximumStepSize() {
		double oldMaximumStepSize = maximumStepSize;
		boolean oldMaximumStepSizeESet = maximumStepSizeESet;
		maximumStepSize = MAXIMUM_STEP_SIZE_EDEFAULT;
		maximumStepSizeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__MAXIMUM_STEP_SIZE, oldMaximumStepSize, MAXIMUM_STEP_SIZE_EDEFAULT, oldMaximumStepSizeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaximumStepSize() {
		return maximumStepSizeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInitialStepSize() {
		return initialStepSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialStepSize(double newInitialStepSize) {
		double oldInitialStepSize = initialStepSize;
		initialStepSize = newInitialStepSize;
		boolean oldInitialStepSizeESet = initialStepSizeESet;
		initialStepSizeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__INITIAL_STEP_SIZE, oldInitialStepSize, initialStepSize, !oldInitialStepSizeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInitialStepSize() {
		double oldInitialStepSize = initialStepSize;
		boolean oldInitialStepSizeESet = initialStepSizeESet;
		initialStepSize = INITIAL_STEP_SIZE_EDEFAULT;
		initialStepSizeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__INITIAL_STEP_SIZE, oldInitialStepSize, INITIAL_STEP_SIZE_EDEFAULT, oldInitialStepSizeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInitialStepSize() {
		return initialStepSizeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAbsoluteTolerance() {
		return absoluteTolerance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbsoluteTolerance(double newAbsoluteTolerance) {
		double oldAbsoluteTolerance = absoluteTolerance;
		absoluteTolerance = newAbsoluteTolerance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__ABSOLUTE_TOLERANCE, oldAbsoluteTolerance, absoluteTolerance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRelativeTolerance() {
		return relativeTolerance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelativeTolerance(double newRelativeTolerance) {
		double oldRelativeTolerance = relativeTolerance;
		relativeTolerance = newRelativeTolerance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__RELATIVE_TOLERANCE, oldRelativeTolerance, relativeTolerance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__MINIMUM_STEP_SIZE:
				return getMinimumStepSize();
			case SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__MAXIMUM_STEP_SIZE:
				return getMaximumStepSize();
			case SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__INITIAL_STEP_SIZE:
				return getInitialStepSize();
			case SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__ABSOLUTE_TOLERANCE:
				return getAbsoluteTolerance();
			case SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__RELATIVE_TOLERANCE:
				return getRelativeTolerance();
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
			case SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__MINIMUM_STEP_SIZE:
				setMinimumStepSize((Double)newValue);
				return;
			case SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__MAXIMUM_STEP_SIZE:
				setMaximumStepSize((Double)newValue);
				return;
			case SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__INITIAL_STEP_SIZE:
				setInitialStepSize((Double)newValue);
				return;
			case SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__ABSOLUTE_TOLERANCE:
				setAbsoluteTolerance((Double)newValue);
				return;
			case SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__RELATIVE_TOLERANCE:
				setRelativeTolerance((Double)newValue);
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
			case SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__MINIMUM_STEP_SIZE:
				setMinimumStepSize(MINIMUM_STEP_SIZE_EDEFAULT);
				return;
			case SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__MAXIMUM_STEP_SIZE:
				unsetMaximumStepSize();
				return;
			case SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__INITIAL_STEP_SIZE:
				unsetInitialStepSize();
				return;
			case SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__ABSOLUTE_TOLERANCE:
				setAbsoluteTolerance(ABSOLUTE_TOLERANCE_EDEFAULT);
				return;
			case SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__RELATIVE_TOLERANCE:
				setRelativeTolerance(RELATIVE_TOLERANCE_EDEFAULT);
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
			case SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__MINIMUM_STEP_SIZE:
				return minimumStepSize != MINIMUM_STEP_SIZE_EDEFAULT;
			case SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__MAXIMUM_STEP_SIZE:
				return isSetMaximumStepSize();
			case SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__INITIAL_STEP_SIZE:
				return isSetInitialStepSize();
			case SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__ABSOLUTE_TOLERANCE:
				return absoluteTolerance != ABSOLUTE_TOLERANCE_EDEFAULT;
			case SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__RELATIVE_TOLERANCE:
				return relativeTolerance != RELATIVE_TOLERANCE_EDEFAULT;
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
		result.append(" (minimumStepSize: ");
		result.append(minimumStepSize);
		result.append(", maximumStepSize: ");
		if (maximumStepSizeESet) result.append(maximumStepSize); else result.append("<unset>");
		result.append(", initialStepSize: ");
		if (initialStepSizeESet) result.append(initialStepSize); else result.append("<unset>");
		result.append(", absoluteTolerance: ");
		result.append(absoluteTolerance);
		result.append(", relativeTolerance: ");
		result.append(relativeTolerance);
		result.append(')');
		return result.toString();
	}

} //AdaptiveStepSizeSolverConfigurationImpl
