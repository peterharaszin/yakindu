/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dconfig.impl;

import org.eclipse.damos.dconfig.ComputationProperty;
import org.eclipse.damos.dconfig.DconfigPackage;
import org.eclipse.damos.mscript.computation.ComputationModel;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Computation Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.dconfig.impl.ComputationPropertyImpl#getComputationModel <em>Computation Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComputationPropertyImpl extends PropertyImpl implements ComputationProperty {
	/**
	 * The cached value of the '{@link #getComputationModel() <em>Computation Model</em>}' containment reference.
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
	protected ComputationPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DconfigPackage.Literals.COMPUTATION_PROPERTY;
	}
	
	@Override
	public String getId() {
		return "computation";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputationModel getComputationModel() {
		return computationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComputationModel(ComputationModel newComputationModel, NotificationChain msgs) {
		ComputationModel oldComputationModel = computationModel;
		computationModel = newComputationModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DconfigPackage.COMPUTATION_PROPERTY__COMPUTATION_MODEL, oldComputationModel, newComputationModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComputationModel(ComputationModel newComputationModel) {
		if (newComputationModel != computationModel) {
			NotificationChain msgs = null;
			if (computationModel != null)
				msgs = ((InternalEObject)computationModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DconfigPackage.COMPUTATION_PROPERTY__COMPUTATION_MODEL, null, msgs);
			if (newComputationModel != null)
				msgs = ((InternalEObject)newComputationModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DconfigPackage.COMPUTATION_PROPERTY__COMPUTATION_MODEL, null, msgs);
			msgs = basicSetComputationModel(newComputationModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.COMPUTATION_PROPERTY__COMPUTATION_MODEL, newComputationModel, newComputationModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DconfigPackage.COMPUTATION_PROPERTY__COMPUTATION_MODEL:
				return basicSetComputationModel(null, msgs);
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
			case DconfigPackage.COMPUTATION_PROPERTY__COMPUTATION_MODEL:
				return getComputationModel();
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
			case DconfigPackage.COMPUTATION_PROPERTY__COMPUTATION_MODEL:
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
			case DconfigPackage.COMPUTATION_PROPERTY__COMPUTATION_MODEL:
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
			case DconfigPackage.COMPUTATION_PROPERTY__COMPUTATION_MODEL:
				return computationModel != null;
		}
		return super.eIsSet(featureID);
	}

} //ComputationPropertyImpl
