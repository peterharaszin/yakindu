/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml.impl;

import org.eclipse.damos.dml.Connection;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.Inoutput;
import org.eclipse.damos.dml.Output;
import org.eclipse.damos.dml.OutputPort;
import org.eclipse.damos.dml.SignalSpecification;
import org.eclipse.damos.dml.internal.operations.OutputPortOperations;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Output Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.impl.OutputPortImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.impl.OutputPortImpl#getSignal <em>Signal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutputPortImpl extends PortImpl implements OutputPort {
	/**
	 * The cached value of the '{@link #getSignal() <em>Signal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignal()
	 * @generated
	 * @ordered
	 */
	protected SignalSpecification signal;

	/**
	 * This is true if the Signal containment reference has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean signalESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutputPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.OUTPUT_PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Output getOutput() {
		if (eContainerFeatureID() != DMLPackage.OUTPUT_PORT__OUTPUT) return null;
		return (Output)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutput(Output newOutput, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOutput, DMLPackage.OUTPUT_PORT__OUTPUT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutput(Output newOutput) {
		if (newOutput != eInternalContainer() || (eContainerFeatureID() != DMLPackage.OUTPUT_PORT__OUTPUT && newOutput != null)) {
			if (EcoreUtil.isAncestor(this, newOutput))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOutput != null)
				msgs = ((InternalEObject)newOutput).eInverseAdd(this, DMLPackage.OUTPUT__PORTS, Output.class, msgs);
			msgs = basicSetOutput(newOutput, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.OUTPUT_PORT__OUTPUT, newOutput, newOutput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SignalSpecification getSignal() {
		return signal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSignal(SignalSpecification newSignal, NotificationChain msgs) {
		SignalSpecification oldSignal = signal;
		signal = newSignal;
		boolean oldSignalESet = signalESet;
		signalESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DMLPackage.OUTPUT_PORT__SIGNAL, oldSignal, newSignal, !oldSignalESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignal(SignalSpecification newSignal) {
		if (newSignal != signal) {
			NotificationChain msgs = null;
			if (signal != null)
				msgs = ((InternalEObject)signal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DMLPackage.OUTPUT_PORT__SIGNAL, null, msgs);
			if (newSignal != null)
				msgs = ((InternalEObject)newSignal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DMLPackage.OUTPUT_PORT__SIGNAL, null, msgs);
			msgs = basicSetSignal(newSignal, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldSignalESet = signalESet;
			signalESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.OUTPUT_PORT__SIGNAL, newSignal, newSignal, !oldSignalESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicUnsetSignal(NotificationChain msgs) {
		SignalSpecification oldSignal = signal;
		signal = null;
		boolean oldSignalESet = signalESet;
		signalESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, DMLPackage.OUTPUT_PORT__SIGNAL, oldSignal, null, oldSignalESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSignal() {
		if (signal != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)signal).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DMLPackage.OUTPUT_PORT__SIGNAL, null, msgs);
			msgs = basicUnsetSignal(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldSignalESet = signalESet;
			signalESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, DMLPackage.OUTPUT_PORT__SIGNAL, null, null, oldSignalESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSignal() {
		return signalESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Connection> getOutgoingConnections() {
		return OutputPortOperations.getOutgoingConnections(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Connection> getOutgoingConnections(Fragment context) {
		return OutputPortOperations.getOutgoingConnections(this, context);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.dml.impl.PortImpl#getInoutput()
	 */
	@Override
	public Inoutput getInoutput() {
		return getOutput();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DMLPackage.OUTPUT_PORT__OUTPUT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOutput((Output)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DMLPackage.OUTPUT_PORT__OUTPUT:
				return basicSetOutput(null, msgs);
			case DMLPackage.OUTPUT_PORT__SIGNAL:
				return basicUnsetSignal(msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case DMLPackage.OUTPUT_PORT__OUTPUT:
				return eInternalContainer().eInverseRemove(this, DMLPackage.OUTPUT__PORTS, Output.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DMLPackage.OUTPUT_PORT__OUTPUT:
				return getOutput();
			case DMLPackage.OUTPUT_PORT__SIGNAL:
				return getSignal();
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
			case DMLPackage.OUTPUT_PORT__OUTPUT:
				setOutput((Output)newValue);
				return;
			case DMLPackage.OUTPUT_PORT__SIGNAL:
				setSignal((SignalSpecification)newValue);
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
			case DMLPackage.OUTPUT_PORT__OUTPUT:
				setOutput((Output)null);
				return;
			case DMLPackage.OUTPUT_PORT__SIGNAL:
				unsetSignal();
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
			case DMLPackage.OUTPUT_PORT__OUTPUT:
				return getOutput() != null;
			case DMLPackage.OUTPUT_PORT__SIGNAL:
				return isSetSignal();
		}
		return super.eIsSet(featureID);
	}

} //OutputPortImpl
