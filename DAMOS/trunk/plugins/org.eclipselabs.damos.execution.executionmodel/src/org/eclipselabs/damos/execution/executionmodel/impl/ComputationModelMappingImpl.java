/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.execution.executionmodel.ComputationModelMapping;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModelPackage;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Computation Model Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executionmodel.impl.ComputationModelMappingImpl#getFragment <em>Fragment</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionmodel.impl.ComputationModelMappingImpl#getComputationModel <em>Computation Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComputationModelMappingImpl extends EObjectImpl implements ComputationModelMapping {
	/**
	 * The cached value of the '{@link #getFragment() <em>Fragment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFragment()
	 * @generated
	 * @ordered
	 */
	protected Fragment fragment;

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
	protected ComputationModelMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionModelPackage.Literals.COMPUTATION_MODEL_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fragment getFragment() {
		if (fragment != null && fragment.eIsProxy()) {
			InternalEObject oldFragment = (InternalEObject)fragment;
			fragment = (Fragment)eResolveProxy(oldFragment);
			if (fragment != oldFragment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionModelPackage.COMPUTATION_MODEL_MAPPING__FRAGMENT, oldFragment, fragment));
			}
		}
		return fragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fragment basicGetFragment() {
		return fragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFragment(Fragment newFragment) {
		Fragment oldFragment = fragment;
		fragment = newFragment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionModelPackage.COMPUTATION_MODEL_MAPPING__FRAGMENT, oldFragment, fragment));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionModelPackage.COMPUTATION_MODEL_MAPPING__COMPUTATION_MODEL, oldComputationModel, computationModel));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionModelPackage.COMPUTATION_MODEL_MAPPING__COMPUTATION_MODEL, oldComputationModel, computationModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExecutionModelPackage.COMPUTATION_MODEL_MAPPING__FRAGMENT:
				if (resolve) return getFragment();
				return basicGetFragment();
			case ExecutionModelPackage.COMPUTATION_MODEL_MAPPING__COMPUTATION_MODEL:
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
			case ExecutionModelPackage.COMPUTATION_MODEL_MAPPING__FRAGMENT:
				setFragment((Fragment)newValue);
				return;
			case ExecutionModelPackage.COMPUTATION_MODEL_MAPPING__COMPUTATION_MODEL:
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
			case ExecutionModelPackage.COMPUTATION_MODEL_MAPPING__FRAGMENT:
				setFragment((Fragment)null);
				return;
			case ExecutionModelPackage.COMPUTATION_MODEL_MAPPING__COMPUTATION_MODEL:
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
			case ExecutionModelPackage.COMPUTATION_MODEL_MAPPING__FRAGMENT:
				return fragment != null;
			case ExecutionModelPackage.COMPUTATION_MODEL_MAPPING__COMPUTATION_MODEL:
				return computationModel != null;
		}
		return super.eIsSet(featureID);
	}

} //ComputationModelMappingImpl
