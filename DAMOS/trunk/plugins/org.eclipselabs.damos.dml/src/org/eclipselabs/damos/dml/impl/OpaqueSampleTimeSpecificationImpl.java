/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.OpaqueSampleTimeSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Opaque Sample Time Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.impl.OpaqueSampleTimeSpecificationImpl#getSampleTime <em>Sample Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OpaqueSampleTimeSpecificationImpl extends SampleTimeSpecificationImpl implements OpaqueSampleTimeSpecification {
	/**
	 * The default value of the '{@link #getSampleTime() <em>Sample Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSampleTime()
	 * @generated
	 * @ordered
	 */
	protected static final String SAMPLE_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSampleTime() <em>Sample Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSampleTime()
	 * @generated
	 * @ordered
	 */
	protected String sampleTime = SAMPLE_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OpaqueSampleTimeSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.OPAQUE_SAMPLE_TIME_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSampleTime() {
		return sampleTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSampleTime(String newSampleTime) {
		String oldSampleTime = sampleTime;
		sampleTime = newSampleTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.OPAQUE_SAMPLE_TIME_SPECIFICATION__SAMPLE_TIME, oldSampleTime, sampleTime));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getText() {
		return getSampleTime();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setText(String text) {
		setSampleTime(text);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.impl.SampleTimeSpecificationImpl#stringSampleTime()
	 */
	@Override
	public String stringSampleTime() {
		return getSampleTime();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DMLPackage.OPAQUE_SAMPLE_TIME_SPECIFICATION__SAMPLE_TIME:
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
			case DMLPackage.OPAQUE_SAMPLE_TIME_SPECIFICATION__SAMPLE_TIME:
				setSampleTime((String)newValue);
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
			case DMLPackage.OPAQUE_SAMPLE_TIME_SPECIFICATION__SAMPLE_TIME:
				setSampleTime(SAMPLE_TIME_EDEFAULT);
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
			case DMLPackage.OPAQUE_SAMPLE_TIME_SPECIFICATION__SAMPLE_TIME:
				return SAMPLE_TIME_EDEFAULT == null ? sampleTime != null : !SAMPLE_TIME_EDEFAULT.equals(sampleTime);
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

} //OpaqueSampleTimeSpecificationImpl
