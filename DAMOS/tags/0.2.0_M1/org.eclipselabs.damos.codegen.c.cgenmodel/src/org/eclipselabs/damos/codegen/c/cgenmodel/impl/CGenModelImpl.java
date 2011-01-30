/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.codegen.c.cgenmodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipselabs.damos.codegen.c.cgenmodel.CGenModel;
import org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage;

import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CGen Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.impl.CGenModelImpl#getExecutionModel <em>Execution Model</em>}</li>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.impl.CGenModelImpl#getTopLevelFragment <em>Top Level Fragment</em>}</li>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.impl.CGenModelImpl#getTargetFolder <em>Target Folder</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CGenModelImpl extends EObjectImpl implements CGenModel {
	/**
	 * The cached value of the '{@link #getExecutionModel() <em>Execution Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionModel()
	 * @generated
	 * @ordered
	 */
	protected ExecutionModel executionModel;

	/**
	 * The cached value of the '{@link #getTopLevelFragment() <em>Top Level Fragment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopLevelFragment()
	 * @generated
	 * @ordered
	 */
	protected Fragment topLevelFragment;

	/**
	 * The default value of the '{@link #getTargetFolder() <em>Target Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetFolder()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_FOLDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetFolder() <em>Target Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetFolder()
	 * @generated
	 * @ordered
	 */
	protected String targetFolder = TARGET_FOLDER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGenModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CGenModelPackage.Literals.CGEN_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionModel getExecutionModel() {
		if (executionModel != null && executionModel.eIsProxy()) {
			InternalEObject oldExecutionModel = (InternalEObject)executionModel;
			executionModel = (ExecutionModel)eResolveProxy(oldExecutionModel);
			if (executionModel != oldExecutionModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CGenModelPackage.CGEN_MODEL__EXECUTION_MODEL, oldExecutionModel, executionModel));
			}
		}
		return executionModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionModel basicGetExecutionModel() {
		return executionModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutionModel(ExecutionModel newExecutionModel) {
		ExecutionModel oldExecutionModel = executionModel;
		executionModel = newExecutionModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGenModelPackage.CGEN_MODEL__EXECUTION_MODEL, oldExecutionModel, executionModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fragment getTopLevelFragment() {
		if (topLevelFragment != null && topLevelFragment.eIsProxy()) {
			InternalEObject oldTopLevelFragment = (InternalEObject)topLevelFragment;
			topLevelFragment = (Fragment)eResolveProxy(oldTopLevelFragment);
			if (topLevelFragment != oldTopLevelFragment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CGenModelPackage.CGEN_MODEL__TOP_LEVEL_FRAGMENT, oldTopLevelFragment, topLevelFragment));
			}
		}
		return topLevelFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fragment basicGetTopLevelFragment() {
		return topLevelFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopLevelFragment(Fragment newTopLevelFragment) {
		Fragment oldTopLevelFragment = topLevelFragment;
		topLevelFragment = newTopLevelFragment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGenModelPackage.CGEN_MODEL__TOP_LEVEL_FRAGMENT, oldTopLevelFragment, topLevelFragment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetFolder() {
		return targetFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetFolder(String newTargetFolder) {
		String oldTargetFolder = targetFolder;
		targetFolder = newTargetFolder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGenModelPackage.CGEN_MODEL__TARGET_FOLDER, oldTargetFolder, targetFolder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CGenModelPackage.CGEN_MODEL__EXECUTION_MODEL:
				if (resolve) return getExecutionModel();
				return basicGetExecutionModel();
			case CGenModelPackage.CGEN_MODEL__TOP_LEVEL_FRAGMENT:
				if (resolve) return getTopLevelFragment();
				return basicGetTopLevelFragment();
			case CGenModelPackage.CGEN_MODEL__TARGET_FOLDER:
				return getTargetFolder();
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
			case CGenModelPackage.CGEN_MODEL__EXECUTION_MODEL:
				setExecutionModel((ExecutionModel)newValue);
				return;
			case CGenModelPackage.CGEN_MODEL__TOP_LEVEL_FRAGMENT:
				setTopLevelFragment((Fragment)newValue);
				return;
			case CGenModelPackage.CGEN_MODEL__TARGET_FOLDER:
				setTargetFolder((String)newValue);
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
			case CGenModelPackage.CGEN_MODEL__EXECUTION_MODEL:
				setExecutionModel((ExecutionModel)null);
				return;
			case CGenModelPackage.CGEN_MODEL__TOP_LEVEL_FRAGMENT:
				setTopLevelFragment((Fragment)null);
				return;
			case CGenModelPackage.CGEN_MODEL__TARGET_FOLDER:
				setTargetFolder(TARGET_FOLDER_EDEFAULT);
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
			case CGenModelPackage.CGEN_MODEL__EXECUTION_MODEL:
				return executionModel != null;
			case CGenModelPackage.CGEN_MODEL__TOP_LEVEL_FRAGMENT:
				return topLevelFragment != null;
			case CGenModelPackage.CGEN_MODEL__TARGET_FOLDER:
				return TARGET_FOLDER_EDEFAULT == null ? targetFolder != null : !TARGET_FOLDER_EDEFAULT.equals(targetFolder);
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
		result.append(" (targetFolder: ");
		result.append(targetFolder);
		result.append(')');
		return result.toString();
	}

} //CGenModelImpl
