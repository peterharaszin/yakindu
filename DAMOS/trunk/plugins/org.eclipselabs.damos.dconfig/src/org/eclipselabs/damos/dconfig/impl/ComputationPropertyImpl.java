/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dconfig.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.damos.dconfig.ComputationProperty;
import org.eclipselabs.damos.dconfig.DconfigPackage;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Computation Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.ComputationPropertyImpl#getComputationModel <em>Computation Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComputationPropertyImpl extends PropertyImpl implements ComputationProperty {
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
		if (computationModel != null && computationModel.eIsProxy()) {
			InternalEObject oldComputationModel = (InternalEObject)computationModel;
			computationModel = (ComputationModel)eResolveProxy(oldComputationModel);
			if (computationModel != oldComputationModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DconfigPackage.COMPUTATION_PROPERTY__COMPUTATION_MODEL, oldComputationModel, computationModel));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.COMPUTATION_PROPERTY__COMPUTATION_MODEL, oldComputationModel, computationModel));
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
