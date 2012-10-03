/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml.impl;

import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.DirectFeedthroughPolicy;
import org.eclipse.damos.dml.InputDefinition;
import org.eclipse.damos.dml.internal.operations.DirectFeedthroughPolicyOperations;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Direct Feedthrough Policy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.impl.DirectFeedthroughPolicyImpl#getInputDefinition <em>Input Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DirectFeedthroughPolicyImpl extends EObjectImpl implements DirectFeedthroughPolicy {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DirectFeedthroughPolicyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.DIRECT_FEEDTHROUGH_POLICY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputDefinition getInputDefinition() {
		if (eContainerFeatureID() != DMLPackage.DIRECT_FEEDTHROUGH_POLICY__INPUT_DEFINITION) return null;
		return (InputDefinition)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputDefinition(InputDefinition newInputDefinition, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInputDefinition, DMLPackage.DIRECT_FEEDTHROUGH_POLICY__INPUT_DEFINITION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputDefinition(InputDefinition newInputDefinition) {
		if (newInputDefinition != eInternalContainer() || (eContainerFeatureID() != DMLPackage.DIRECT_FEEDTHROUGH_POLICY__INPUT_DEFINITION && newInputDefinition != null)) {
			if (EcoreUtil.isAncestor(this, newInputDefinition))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInputDefinition != null)
				msgs = ((InternalEObject)newInputDefinition).eInverseAdd(this, DMLPackage.INPUT_DEFINITION__DIRECT_FEEDTHROUGH_POLICY, InputDefinition.class, msgs);
			msgs = basicSetInputDefinition(newInputDefinition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.DIRECT_FEEDTHROUGH_POLICY__INPUT_DEFINITION, newInputDefinition, newInputDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean computeDirectFeedthrough() {
		return DirectFeedthroughPolicyOperations.computeDirectFeedthrough(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DMLPackage.DIRECT_FEEDTHROUGH_POLICY__INPUT_DEFINITION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInputDefinition((InputDefinition)otherEnd, msgs);
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
			case DMLPackage.DIRECT_FEEDTHROUGH_POLICY__INPUT_DEFINITION:
				return basicSetInputDefinition(null, msgs);
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
			case DMLPackage.DIRECT_FEEDTHROUGH_POLICY__INPUT_DEFINITION:
				return eInternalContainer().eInverseRemove(this, DMLPackage.INPUT_DEFINITION__DIRECT_FEEDTHROUGH_POLICY, InputDefinition.class, msgs);
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
			case DMLPackage.DIRECT_FEEDTHROUGH_POLICY__INPUT_DEFINITION:
				return getInputDefinition();
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
			case DMLPackage.DIRECT_FEEDTHROUGH_POLICY__INPUT_DEFINITION:
				setInputDefinition((InputDefinition)newValue);
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
			case DMLPackage.DIRECT_FEEDTHROUGH_POLICY__INPUT_DEFINITION:
				setInputDefinition((InputDefinition)null);
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
			case DMLPackage.DIRECT_FEEDTHROUGH_POLICY__INPUT_DEFINITION:
				return getInputDefinition() != null;
		}
		return super.eIsSet(featureID);
	}

} //DirectFeedthroughPolicyImpl
