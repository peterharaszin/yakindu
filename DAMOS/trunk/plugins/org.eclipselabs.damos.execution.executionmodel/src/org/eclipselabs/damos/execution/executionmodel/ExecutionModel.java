/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionmodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executionmodel.ExecutionModel#getComputationModelMappings <em>Computation Model Mappings</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionmodel.ExecutionModel#getSampleTime <em>Sample Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.execution.executionmodel.ExecutionModelPackage#getExecutionModel()
 * @model
 * @generated
 */
public interface ExecutionModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Computation Model Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.executionmodel.ComputationModelMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Computation Model Mappings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Computation Model Mappings</em>' containment reference list.
	 * @see org.eclipselabs.damos.execution.executionmodel.ExecutionModelPackage#getExecutionModel_ComputationModelMappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComputationModelMapping> getComputationModelMappings();

	/**
	 * Returns the value of the '<em><b>Sample Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sample Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sample Time</em>' attribute.
	 * @see #setSampleTime(double)
	 * @see org.eclipselabs.damos.execution.executionmodel.ExecutionModelPackage#getExecutionModel_SampleTime()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getSampleTime();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.execution.executionmodel.ExecutionModel#getSampleTime <em>Sample Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sample Time</em>' attribute.
	 * @see #getSampleTime()
	 * @generated
	 */
	void setSampleTime(double value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model fragmentRequired="true"
	 * @generated
	 */
	ComputationModel getComputationModel(Fragment fragment);

} // ExecutionModel
