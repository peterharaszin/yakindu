/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;
import org.esmp.dsm.semantic.blockdiagram.Connection;
import org.esmp.dsm.semantic.blockdiagram.Input;
import org.esmp.dsm.semantic.blockdiagram.InputPort;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.InputPortImpl#getIncomingConnection <em>Incoming Connection</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.InputPortImpl#isDirectFeedthrough <em>Direct Feedthrough</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.InputPortImpl#getInput <em>Input</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InputPortImpl extends PortImpl implements InputPort {
	/**
	 * The cached value of the '{@link #getIncomingConnection() <em>Incoming Connection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingConnection()
	 * @generated
	 * @ordered
	 */
	protected Connection incomingConnection;
	/**
	 * The default value of the '{@link #isDirectFeedthrough() <em>Direct Feedthrough</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDirectFeedthrough()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DIRECT_FEEDTHROUGH_EDEFAULT = false;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BlockDiagramPackage.Literals.INPUT_PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection getIncomingConnection() {
		if (incomingConnection != null && incomingConnection.eIsProxy()) {
			InternalEObject oldIncomingConnection = (InternalEObject)incomingConnection;
			incomingConnection = (Connection)eResolveProxy(oldIncomingConnection);
			if (incomingConnection != oldIncomingConnection) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BlockDiagramPackage.INPUT_PORT__INCOMING_CONNECTION, oldIncomingConnection, incomingConnection));
			}
		}
		return incomingConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection basicGetIncomingConnection() {
		return incomingConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIncomingConnection(Connection newIncomingConnection, NotificationChain msgs) {
		Connection oldIncomingConnection = incomingConnection;
		incomingConnection = newIncomingConnection;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BlockDiagramPackage.INPUT_PORT__INCOMING_CONNECTION, oldIncomingConnection, newIncomingConnection);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncomingConnection(Connection newIncomingConnection) {
		if (newIncomingConnection != incomingConnection) {
			NotificationChain msgs = null;
			if (incomingConnection != null)
				msgs = ((InternalEObject)incomingConnection).eInverseRemove(this, BlockDiagramPackage.CONNECTION__TARGET_PORT, Connection.class, msgs);
			if (newIncomingConnection != null)
				msgs = ((InternalEObject)newIncomingConnection).eInverseAdd(this, BlockDiagramPackage.CONNECTION__TARGET_PORT, Connection.class, msgs);
			msgs = basicSetIncomingConnection(newIncomingConnection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlockDiagramPackage.INPUT_PORT__INCOMING_CONNECTION, newIncomingConnection, newIncomingConnection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isDirectFeedthrough() {
		try {
			return getBlock().getOutputPorts().size() > 0 && Boolean.parseBoolean(getInput().getSpecification().getDirectFeedthroughExpression());
		} catch (NumberFormatException e) {
			// return default
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Input getInput() {
		if (eContainerFeatureID() != BlockDiagramPackage.INPUT_PORT__INPUT) return null;
		return (Input)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInput(Input newInput, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInput, BlockDiagramPackage.INPUT_PORT__INPUT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInput(Input newInput) {
		if (newInput != eInternalContainer() || (eContainerFeatureID() != BlockDiagramPackage.INPUT_PORT__INPUT && newInput != null)) {
			if (EcoreUtil.isAncestor(this, newInput))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInput != null)
				msgs = ((InternalEObject)newInput).eInverseAdd(this, BlockDiagramPackage.INPUT__PORTS, Input.class, msgs);
			msgs = basicSetInput(newInput, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlockDiagramPackage.INPUT_PORT__INPUT, newInput, newInput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BlockDiagramPackage.INPUT_PORT__INCOMING_CONNECTION:
				if (incomingConnection != null)
					msgs = ((InternalEObject)incomingConnection).eInverseRemove(this, BlockDiagramPackage.CONNECTION__TARGET_PORT, Connection.class, msgs);
				return basicSetIncomingConnection((Connection)otherEnd, msgs);
			case BlockDiagramPackage.INPUT_PORT__INPUT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInput((Input)otherEnd, msgs);
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
			case BlockDiagramPackage.INPUT_PORT__INCOMING_CONNECTION:
				return basicSetIncomingConnection(null, msgs);
			case BlockDiagramPackage.INPUT_PORT__INPUT:
				return basicSetInput(null, msgs);
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
			case BlockDiagramPackage.INPUT_PORT__INPUT:
				return eInternalContainer().eInverseRemove(this, BlockDiagramPackage.INPUT__PORTS, Input.class, msgs);
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
			case BlockDiagramPackage.INPUT_PORT__INCOMING_CONNECTION:
				if (resolve) return getIncomingConnection();
				return basicGetIncomingConnection();
			case BlockDiagramPackage.INPUT_PORT__DIRECT_FEEDTHROUGH:
				return isDirectFeedthrough();
			case BlockDiagramPackage.INPUT_PORT__INPUT:
				return getInput();
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
			case BlockDiagramPackage.INPUT_PORT__INCOMING_CONNECTION:
				setIncomingConnection((Connection)newValue);
				return;
			case BlockDiagramPackage.INPUT_PORT__INPUT:
				setInput((Input)newValue);
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
			case BlockDiagramPackage.INPUT_PORT__INCOMING_CONNECTION:
				setIncomingConnection((Connection)null);
				return;
			case BlockDiagramPackage.INPUT_PORT__INPUT:
				setInput((Input)null);
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
			case BlockDiagramPackage.INPUT_PORT__INCOMING_CONNECTION:
				return incomingConnection != null;
			case BlockDiagramPackage.INPUT_PORT__DIRECT_FEEDTHROUGH:
				return isDirectFeedthrough() != DIRECT_FEEDTHROUGH_EDEFAULT;
			case BlockDiagramPackage.INPUT_PORT__INPUT:
				return getInput() != null;
		}
		return super.eIsSet(featureID);
	}

} //InputPortImpl
