/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionmodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Computation Model Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executionmodel.ComputationModelMapping#getFragment <em>Fragment</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionmodel.ComputationModelMapping#getComputationModel <em>Computation Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.execution.executionmodel.ExecutionModelPackage#getComputationModelMapping()
 * @model
 * @generated
 */
public interface ComputationModelMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Fragment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fragment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fragment</em>' reference.
	 * @see #setFragment(Fragment)
	 * @see org.eclipselabs.damos.execution.executionmodel.ExecutionModelPackage#getComputationModelMapping_Fragment()
	 * @model
	 * @generated
	 */
	Fragment getFragment();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.execution.executionmodel.ComputationModelMapping#getFragment <em>Fragment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fragment</em>' reference.
	 * @see #getFragment()
	 * @generated
	 */
	void setFragment(Fragment value);

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
	 * @see org.eclipselabs.damos.execution.executionmodel.ExecutionModelPackage#getComputationModelMapping_ComputationModel()
	 * @model
	 * @generated
	 */
	ComputationModel getComputationModel();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.execution.executionmodel.ComputationModelMapping#getComputationModel <em>Computation Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Computation Model</em>' reference.
	 * @see #getComputationModel()
	 * @generated
	 */
	void setComputationModel(ComputationModel value);

} // ComputationModelMapping
