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
 *   <li>{@link org.eclipse.damos.dml.impl.SynchronousTimingConstraintImpl#getSampleInterval <em>Sample Interval</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SynchronousTimingConstraintImpl extends TimingConstraintImpl implements SynchronousTimingConstraint {
	/**
	 * The cached value of the '{@link #getSampleInterval() <em>Sample Interval</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSampleInterval()
	 * @generated
	 * @ordered
	 */
	protected ValueSpecification sampleInterval;
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
	public ValueSpecification getSampleInterval() {
		return sampleInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSampleInterval(ValueSpecification newSampleInterval, NotificationChain msgs) {
		ValueSpecification oldSampleInterval = sampleInterval;
		sampleInterval = newSampleInterval;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DMLPackage.SYNCHRONOUS_TIMING_CONSTRAINT__SAMPLE_INTERVAL, oldSampleInterval, newSampleInterval);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSampleInterval(ValueSpecification newSampleInterval) {
		if (newSampleInterval != sampleInterval) {
			NotificationChain msgs = null;
			if (sampleInterval != null)
				msgs = ((InternalEObject)sampleInterval).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DMLPackage.SYNCHRONOUS_TIMING_CONSTRAINT__SAMPLE_INTERVAL, null, msgs);
			if (newSampleInterval != null)
				msgs = ((InternalEObject)newSampleInterval).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DMLPackage.SYNCHRONOUS_TIMING_CONSTRAINT__SAMPLE_INTERVAL, null, msgs);
			msgs = basicSetSampleInterval(newSampleInterval, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.SYNCHRONOUS_TIMING_CONSTRAINT__SAMPLE_INTERVAL, newSampleInterval, newSampleInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DMLPackage.SYNCHRONOUS_TIMING_CONSTRAINT__SAMPLE_INTERVAL:
				return basicSetSampleInterval(null, msgs);
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
			case DMLPackage.SYNCHRONOUS_TIMING_CONSTRAINT__SAMPLE_INTERVAL:
				return getSampleInterval();
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
			case DMLPackage.SYNCHRONOUS_TIMING_CONSTRAINT__SAMPLE_INTERVAL:
				setSampleInterval((ValueSpecification)newValue);
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
			case DMLPackage.SYNCHRONOUS_TIMING_CONSTRAINT__SAMPLE_INTERVAL:
				setSampleInterval((ValueSpecification)null);
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
			case DMLPackage.SYNCHRONOUS_TIMING_CONSTRAINT__SAMPLE_INTERVAL:
				return sampleInterval != null;
		}
		return super.eIsSet(featureID);
	}

} //SynchronousTimingConstraintImpl
