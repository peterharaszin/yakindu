/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModel;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModelPackage;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executionmodel.impl.ExecutionModelImpl#getSampleTime <em>Sample Time</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionmodel.impl.ExecutionModelImpl#getComputationModel <em>Computation Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionModelImpl extends EObjectImpl implements ExecutionModel {
	/**
	 * The default value of the '{@link #getSampleTime() <em>Sample Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSampleTime()
	 * @generated
	 * @ordered
	 */
	protected static final double SAMPLE_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSampleTime() <em>Sample Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSampleTime()
	 * @generated
	 * @ordered
	 */
	protected double sampleTime = SAMPLE_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getComputationModel() <em>Computation Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComputationModel()
	 * @generated
	 * @ordered
	 */
	protected ComputationModel computationModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionModelPackage.Literals.EXECUTION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSampleTime() {
		return sampleTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSampleTime(double newSampleTime) {
		double oldSampleTime = sampleTime;
		sampleTime = newSampleTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionModelPackage.EXECUTION_MODEL__SAMPLE_TIME, oldSampleTime, sampleTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputationModel getComputationModel() {
		if (computationModel != null && computationModel.eIsProxy()) {
			InternalEObject oldComputationModel = (InternalEObject)computationModel;
			computationModel = (ComputationModel)eResolveProxy(oldComputationModel);
			if (computationModel != oldComputationModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionModelPackage.EXECUTION_MODEL__COMPUTATION_MODEL, oldComputationModel, computationModel));
			}
		}
		return computationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputationModel basicGetComputationModel() {
		return computationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComputationModel(ComputationModel newComputationModel) {
		ComputationModel oldComputationModel = computationModel;
		computationModel = newComputationModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionModelPackage.EXECUTION_MODEL__COMPUTATION_MODEL, oldComputationModel, computationModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExecutionModelPackage.EXECUTION_MODEL__SAMPLE_TIME:
				return getSampleTime();
			case ExecutionModelPackage.EXECUTION_MODEL__COMPUTATION_MODEL:
				if (resolve) return getComputationModel();
				return basicGetComputationModel();
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
			case ExecutionModelPackage.EXECUTION_MODEL__SAMPLE_TIME:
				setSampleTime((Double)newValue);
				return;
			case ExecutionModelPackage.EXECUTION_MODEL__COMPUTATION_MODEL:
				setComputationModel((ComputationModel)newValue);
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
			case ExecutionModelPackage.EXECUTION_MODEL__SAMPLE_TIME:
				setSampleTime(SAMPLE_TIME_EDEFAULT);
				return;
			case ExecutionModelPackage.EXECUTION_MODEL__COMPUTATION_MODEL:
				setComputationModel((ComputationModel)null);
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
			case ExecutionModelPackage.EXECUTION_MODEL__SAMPLE_TIME:
				return sampleTime != SAMPLE_TIME_EDEFAULT;
			case ExecutionModelPackage.EXECUTION_MODEL__COMPUTATION_MODEL:
				return computationModel != null;
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
		result.append(" (sampleTime: ");
		result.append(sampleTime);
		result.append(')');
		return result.toString();
	}

} //ExecutionModelImpl
