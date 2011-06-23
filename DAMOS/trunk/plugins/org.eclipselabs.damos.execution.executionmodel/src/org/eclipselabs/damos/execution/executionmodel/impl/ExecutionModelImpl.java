/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.execution.executionmodel.ComputationModelMapping;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModel;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModelPackage;
import org.eclipselabs.damos.execution.executionmodel.internal.operations.ExecutionModelOperations;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executionmodel.impl.ExecutionModelImpl#getComputationModelMappings <em>Computation Model Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionModelImpl extends EObjectImpl implements ExecutionModel {
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
	public EList<ComputationModelMapping> getComputationModelMappings() {
		if (computationModelMappings == null) {
			computationModelMappings = new EObjectContainmentEList<ComputationModelMapping>(ComputationModelMapping.class, this, ExecutionModelPackage.EXECUTION_MODEL__COMPUTATION_MODEL_MAPPINGS);
		}
		return computationModelMappings;
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
			case ExecutionModelPackage.EXECUTION_MODEL__COMPUTATION_MODEL_MAPPINGS:
				return getComputationModelMappings();
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
			case ExecutionModelPackage.EXECUTION_MODEL__COMPUTATION_MODEL_MAPPINGS:
				getComputationModelMappings().clear();
				getComputationModelMappings().addAll((Collection<? extends ComputationModelMapping>)newValue);
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
			case ExecutionModelPackage.EXECUTION_MODEL__COMPUTATION_MODEL_MAPPINGS:
				getComputationModelMappings().clear();
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
			case ExecutionModelPackage.EXECUTION_MODEL__COMPUTATION_MODEL_MAPPINGS:
				return computationModelMappings != null && !computationModelMappings.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExecutionModelImpl
