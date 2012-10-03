/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml.impl;

import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.SynchronousTimingConstraint;
import org.eclipse.damos.dml.ValueSpecification;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Synchronous Timing Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.impl.SynchronousTimingConstraintImpl#getSampleTime <em>Sample Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SynchronousTimingConstraintImpl extends TimingConstraintImpl implements SynchronousTimingConstraint {
	/**
	 * The cached value of the '{@link #getSampleTime() <em>Sample Time</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSampleTime()
	 * @generated
	 * @ordered
	 */
	protected ValueSpecification sampleTime;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SynchronousTimingConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.SYNCHRONOUS_TIMING_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueSpecification getSampleTime() {
		return sampleTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSampleTime(ValueSpecification newSampleTime, NotificationChain msgs) {
		ValueSpecification oldSampleTime = sampleTime;
		sampleTime = newSampleTime;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DMLPackage.SYNCHRONOUS_TIMING_CONSTRAINT__SAMPLE_TIME, oldSampleTime, newSampleTime);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSampleTime(ValueSpecification newSampleTime) {
		if (newSampleTime != sampleTime) {
			NotificationChain msgs = null;
			if (sampleTime != null)
				msgs = ((InternalEObject)sampleTime).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DMLPackage.SYNCHRONOUS_TIMING_CONSTRAINT__SAMPLE_TIME, null, msgs);
			if (newSampleTime != null)
				msgs = ((InternalEObject)newSampleTime).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DMLPackage.SYNCHRONOUS_TIMING_CONSTRAINT__SAMPLE_TIME, null, msgs);
			msgs = basicSetSampleTime(newSampleTime, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.SYNCHRONOUS_TIMING_CONSTRAINT__SAMPLE_TIME, newSampleTime, newSampleTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DMLPackage.SYNCHRONOUS_TIMING_CONSTRAINT__SAMPLE_TIME:
				return basicSetSampleTime(null, msgs);
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
			case DMLPackage.SYNCHRONOUS_TIMING_CONSTRAINT__SAMPLE_TIME:
				return getSampleTime();
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
			case DMLPackage.SYNCHRONOUS_TIMING_CONSTRAINT__SAMPLE_TIME:
				setSampleTime((ValueSpecification)newValue);
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
			case DMLPackage.SYNCHRONOUS_TIMING_CONSTRAINT__SAMPLE_TIME:
				setSampleTime((ValueSpecification)null);
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
			case DMLPackage.SYNCHRONOUS_TIMING_CONSTRAINT__SAMPLE_TIME:
				return sampleTime != null;
		}
		return super.eIsSet(featureID);
	}

} //SynchronousTimingConstraintImpl
