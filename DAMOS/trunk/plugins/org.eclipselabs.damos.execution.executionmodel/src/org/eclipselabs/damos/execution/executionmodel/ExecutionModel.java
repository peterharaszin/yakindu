/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionmodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executionmodel.ExecutionModel#getSampleTime <em>Sample Time</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionmodel.ExecutionModel#getComputationModel <em>Computation Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.execution.executionmodel.ExecutionModelPackage#getExecutionModel()
 * @model
 * @generated
 */
public interface ExecutionModel extends EObject {
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
	 * Returns the value of the '<em><b>Computation Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Computation Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Computation Model</em>' reference.
	 * @see #setComputationModel(ComputationModel)
	 * @see org.eclipselabs.damos.execution.executionmodel.ExecutionModelPackage#getExecutionModel_ComputationModel()
	 * @model
	 * @generated
	 */
	ComputationModel getComputationModel();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.execution.executionmodel.ExecutionModel#getComputationModel <em>Computation Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Computation Model</em>' reference.
	 * @see #getComputationModel()
	 * @generated
	 */
	void setComputationModel(ComputationModel value);

} // ExecutionModel
