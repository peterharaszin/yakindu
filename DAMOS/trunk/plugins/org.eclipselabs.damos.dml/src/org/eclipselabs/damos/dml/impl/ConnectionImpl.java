/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.InputConnector;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputConnector;
import org.eclipselabs.damos.dml.OutputPort;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.impl.ConnectionImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.ConnectionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.ConnectionImpl#getSourcePort <em>Source Port</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.ConnectionImpl#getTargetPort <em>Target Port</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionImpl extends FragmentElementImpl implements Connection {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected OutputConnector source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected InputConnector target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputConnector getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (OutputConnector)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DMLPackage.CONNECTION__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputConnector basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(OutputConnector newSource) {
		OutputConnector oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.CONNECTION__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputConnector getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (InputConnector)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DMLPackage.CONNECTION__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputConnector basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(InputConnector newTarget) {
		InputConnector oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.CONNECTION__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputPort getSourcePort() {
		OutputPort sourcePort = basicGetSourcePort();
		return sourcePort != null && sourcePort.eIsProxy() ? (OutputPort)eResolveProxy((InternalEObject)sourcePort) : sourcePort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public OutputPort basicGetSourcePort() {
		OutputConnector source = getSource();
		return source instanceof OutputPort ? (OutputPort) source : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSourcePort(OutputPort newSourcePort) {
		setSource(newSourcePort);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPort getTargetPort() {
		InputPort targetPort = basicGetTargetPort();
		return targetPort != null && targetPort.eIsProxy() ? (InputPort)eResolveProxy((InternalEObject)targetPort) : targetPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public InputPort basicGetTargetPort() {
		InputConnector target = getTarget();
		return target instanceof InputPort ? (InputPort) target : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setTargetPort(InputPort newTargetPort) {
		setTarget(newTargetPort);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("deprecation")
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DMLPackage.CONNECTION__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case DMLPackage.CONNECTION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case DMLPackage.CONNECTION__SOURCE_PORT:
				if (resolve) return getSourcePort();
				return basicGetSourcePort();
			case DMLPackage.CONNECTION__TARGET_PORT:
				if (resolve) return getTargetPort();
				return basicGetTargetPort();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DMLPackage.CONNECTION__SOURCE:
				setSource((OutputConnector)newValue);
				return;
			case DMLPackage.CONNECTION__TARGET:
				setTarget((InputConnector)newValue);
				return;
			case DMLPackage.CONNECTION__SOURCE_PORT:
				setSourcePort((OutputPort)newValue);
				return;
			case DMLPackage.CONNECTION__TARGET_PORT:
				setTargetPort((InputPort)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DMLPackage.CONNECTION__SOURCE:
				setSource((OutputConnector)null);
				return;
			case DMLPackage.CONNECTION__TARGET:
				setTarget((InputConnector)null);
				return;
			case DMLPackage.CONNECTION__SOURCE_PORT:
				setSourcePort((OutputPort)null);
				return;
			case DMLPackage.CONNECTION__TARGET_PORT:
				setTargetPort((InputPort)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("deprecation")
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DMLPackage.CONNECTION__SOURCE:
				return source != null;
			case DMLPackage.CONNECTION__TARGET:
				return target != null;
			case DMLPackage.CONNECTION__SOURCE_PORT:
				return basicGetSourcePort() != null;
			case DMLPackage.CONNECTION__TARGET_PORT:
				return basicGetTargetPort() != null;
		}
		return super.eIsSet(featureID);
	}

} //ConnectionImpl
