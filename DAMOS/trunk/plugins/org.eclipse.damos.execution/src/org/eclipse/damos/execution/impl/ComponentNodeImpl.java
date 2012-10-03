/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.execution.impl;

import org.eclipse.damos.dml.Component;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.execution.ExecutionPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.execution.impl.ComponentNodeImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.impl.ComponentNodeImpl#getSampleTime <em>Sample Time</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.impl.ComponentNodeImpl#getAsynchronousZone <em>Asynchronous Zone</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentNodeImpl extends NodeImpl implements ComponentNode {
	/**
	 * The cached value of the '{@link #getComponent() <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponent()
	 * @generated
	 * @ordered
	 */
	protected Component component;

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
	 * The default value of the '{@link #getAsynchronousZone() <em>Asynchronous Zone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsynchronousZone()
	 * @generated
	 * @ordered
	 */
	protected static final int ASYNCHRONOUS_ZONE_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getAsynchronousZone() <em>Asynchronous Zone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsynchronousZone()
	 * @generated
	 * @ordered
	 */
	protected int asynchronousZone = ASYNCHRONOUS_ZONE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionPackage.Literals.COMPONENT_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getComponent() {
		if (component != null && component.eIsProxy()) {
			InternalEObject oldComponent = (InternalEObject)component;
			component = (Component)eResolveProxy(oldComponent);
			if (component != oldComponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionPackage.COMPONENT_NODE__COMPONENT, oldComponent, component));
			}
		}
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component basicGetComponent() {
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponent(Component newComponent) {
		Component oldComponent = component;
		component = newComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionPackage.COMPONENT_NODE__COMPONENT, oldComponent, component));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionPackage.COMPONENT_NODE__SAMPLE_TIME, oldSampleTime, sampleTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAsynchronousZone() {
		return asynchronousZone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAsynchronousZone(int newAsynchronousZone) {
		int oldAsynchronousZone = asynchronousZone;
		asynchronousZone = newAsynchronousZone;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionPackage.COMPONENT_NODE__ASYNCHRONOUS_ZONE, oldAsynchronousZone, asynchronousZone));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExecutionPackage.COMPONENT_NODE__COMPONENT:
				if (resolve) return getComponent();
				return basicGetComponent();
			case ExecutionPackage.COMPONENT_NODE__SAMPLE_TIME:
				return getSampleTime();
			case ExecutionPackage.COMPONENT_NODE__ASYNCHRONOUS_ZONE:
				return getAsynchronousZone();
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
			case ExecutionPackage.COMPONENT_NODE__COMPONENT:
				setComponent((Component)newValue);
				return;
			case ExecutionPackage.COMPONENT_NODE__SAMPLE_TIME:
				setSampleTime((Double)newValue);
				return;
			case ExecutionPackage.COMPONENT_NODE__ASYNCHRONOUS_ZONE:
				setAsynchronousZone((Integer)newValue);
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
			case ExecutionPackage.COMPONENT_NODE__COMPONENT:
				setComponent((Component)null);
				return;
			case ExecutionPackage.COMPONENT_NODE__SAMPLE_TIME:
				setSampleTime(SAMPLE_TIME_EDEFAULT);
				return;
			case ExecutionPackage.COMPONENT_NODE__ASYNCHRONOUS_ZONE:
				setAsynchronousZone(ASYNCHRONOUS_ZONE_EDEFAULT);
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
			case ExecutionPackage.COMPONENT_NODE__COMPONENT:
				return component != null;
			case ExecutionPackage.COMPONENT_NODE__SAMPLE_TIME:
				return sampleTime != SAMPLE_TIME_EDEFAULT;
			case ExecutionPackage.COMPONENT_NODE__ASYNCHRONOUS_ZONE:
				return asynchronousZone != ASYNCHRONOUS_ZONE_EDEFAULT;
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
		result.append(", asynchronousZone: ");
		result.append(asynchronousZone);
		result.append(')');
		return result.toString();
	}

} //ComponentNodeImpl
