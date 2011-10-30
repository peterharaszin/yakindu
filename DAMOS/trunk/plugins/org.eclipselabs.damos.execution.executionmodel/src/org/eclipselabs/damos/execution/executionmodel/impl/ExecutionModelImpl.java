/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.execution.executionmodel.ComputationModelMapping;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModel;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModelPackage;
import org.eclipselabs.damos.execution.executionmodel.internal.operations.ExecutionModelOperations;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executionmodel.impl.ExecutionModelImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionmodel.impl.ExecutionModelImpl#getComputationModelMappings <em>Computation Model Mappings</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionmodel.impl.ExecutionModelImpl#getRuntimeEnvironmentId <em>Runtime Environment Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionModelImpl extends EObjectImpl implements ExecutionModel {
	/**
	 * The default value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String qualifiedName = QUALIFIED_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getComputationModelMappings() <em>Computation Model Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComputationModelMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<ComputationModelMapping> computationModelMappings;

	/**
	 * The default value of the '{@link #getRuntimeEnvironmentId() <em>Runtime Environment Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuntimeEnvironmentId()
	 * @generated
	 * @ordered
	 */
	protected static final String RUNTIME_ENVIRONMENT_ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getRuntimeEnvironmentId() <em>Runtime Environment Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuntimeEnvironmentId()
	 * @generated
	 * @ordered
	 */
	protected String runtimeEnvironmentId = RUNTIME_ENVIRONMENT_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionModelPackage.Literals.EXECUTION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQualifiedName() {
		return qualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualifiedName(String newQualifiedName) {
		String oldQualifiedName = qualifiedName;
		qualifiedName = newQualifiedName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionModelPackage.EXECUTION_MODEL__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComputationModelMapping> getComputationModelMappings() {
		if (computationModelMappings == null) {
			computationModelMappings = new EObjectContainmentEList<ComputationModelMapping>(ComputationModelMapping.class, this, ExecutionModelPackage.EXECUTION_MODEL__COMPUTATION_MODEL_MAPPINGS);
		}
		return computationModelMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRuntimeEnvironmentId() {
		return runtimeEnvironmentId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuntimeEnvironmentId(String newRuntimeEnvironmentId) {
		String oldRuntimeEnvironmentId = runtimeEnvironmentId;
		runtimeEnvironmentId = newRuntimeEnvironmentId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionModelPackage.EXECUTION_MODEL__RUNTIME_ENVIRONMENT_ID, oldRuntimeEnvironmentId, runtimeEnvironmentId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ComputationModel getComputationModel(Fragment fragment) {
		return ExecutionModelOperations.getComputationModel(this, fragment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExecutionModelPackage.EXECUTION_MODEL__COMPUTATION_MODEL_MAPPINGS:
				return ((InternalEList<?>)getComputationModelMappings()).basicRemove(otherEnd, msgs);
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
			case ExecutionModelPackage.EXECUTION_MODEL__QUALIFIED_NAME:
				return getQualifiedName();
			case ExecutionModelPackage.EXECUTION_MODEL__COMPUTATION_MODEL_MAPPINGS:
				return getComputationModelMappings();
			case ExecutionModelPackage.EXECUTION_MODEL__RUNTIME_ENVIRONMENT_ID:
				return getRuntimeEnvironmentId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExecutionModelPackage.EXECUTION_MODEL__QUALIFIED_NAME:
				setQualifiedName((String)newValue);
				return;
			case ExecutionModelPackage.EXECUTION_MODEL__COMPUTATION_MODEL_MAPPINGS:
				getComputationModelMappings().clear();
				getComputationModelMappings().addAll((Collection<? extends ComputationModelMapping>)newValue);
				return;
			case ExecutionModelPackage.EXECUTION_MODEL__RUNTIME_ENVIRONMENT_ID:
				setRuntimeEnvironmentId((String)newValue);
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
			case ExecutionModelPackage.EXECUTION_MODEL__QUALIFIED_NAME:
				setQualifiedName(QUALIFIED_NAME_EDEFAULT);
				return;
			case ExecutionModelPackage.EXECUTION_MODEL__COMPUTATION_MODEL_MAPPINGS:
				getComputationModelMappings().clear();
				return;
			case ExecutionModelPackage.EXECUTION_MODEL__RUNTIME_ENVIRONMENT_ID:
				setRuntimeEnvironmentId(RUNTIME_ENVIRONMENT_ID_EDEFAULT);
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
			case ExecutionModelPackage.EXECUTION_MODEL__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
			case ExecutionModelPackage.EXECUTION_MODEL__COMPUTATION_MODEL_MAPPINGS:
				return computationModelMappings != null && !computationModelMappings.isEmpty();
			case ExecutionModelPackage.EXECUTION_MODEL__RUNTIME_ENVIRONMENT_ID:
				return RUNTIME_ENVIRONMENT_ID_EDEFAULT == null ? runtimeEnvironmentId != null : !RUNTIME_ENVIRONMENT_ID_EDEFAULT.equals(runtimeEnvironmentId);
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
		result.append(" (qualifiedName: ");
		result.append(qualifiedName);
		result.append(", runtimeEnvironmentId: ");
		result.append(runtimeEnvironmentId);
		result.append(')');
		return result.toString();
	}

} //ExecutionModelImpl
