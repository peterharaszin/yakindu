/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.execution.executionmodel.ExecutionModelFactory
 * @model kind="package"
 * @generated
 */
public interface ExecutionModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "executionmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/damos/ExecutionModel/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "executionmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExecutionModelPackage eINSTANCE = org.eclipselabs.damos.execution.executionmodel.impl.ExecutionModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.execution.executionmodel.impl.ExecutionModelImpl <em>Execution Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.execution.executionmodel.impl.ExecutionModelImpl
	 * @see org.eclipselabs.damos.execution.executionmodel.impl.ExecutionModelPackageImpl#getExecutionModel()
	 * @generated
	 */
	int EXECUTION_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Computation Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_MODEL__COMPUTATION_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Sample Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_MODEL__SAMPLE_TIME = 1;

	/**
	 * The number of structural features of the '<em>Execution Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_MODEL_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.execution.executionmodel.ExecutionModel <em>Execution Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Model</em>'.
	 * @see org.eclipselabs.damos.execution.executionmodel.ExecutionModel
	 * @generated
	 */
	EClass getExecutionModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.execution.executionmodel.ExecutionModel#getSampleTime <em>Sample Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sample Time</em>'.
	 * @see org.eclipselabs.damos.execution.executionmodel.ExecutionModel#getSampleTime()
	 * @see #getExecutionModel()
	 * @generated
	 */
	EAttribute getExecutionModel_SampleTime();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.execution.executionmodel.ExecutionModel#getComputationModel <em>Computation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Computation Model</em>'.
	 * @see org.eclipselabs.damos.execution.executionmodel.ExecutionModel#getComputationModel()
	 * @see #getExecutionModel()
	 * @generated
	 */
	EReference getExecutionModel_ComputationModel();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExecutionModelFactory getExecutionModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.execution.executionmodel.impl.ExecutionModelImpl <em>Execution Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.execution.executionmodel.impl.ExecutionModelImpl
		 * @see org.eclipselabs.damos.execution.executionmodel.impl.ExecutionModelPackageImpl#getExecutionModel()
		 * @generated
		 */
		EClass EXECUTION_MODEL = eINSTANCE.getExecutionModel();

		/**
		 * The meta object literal for the '<em><b>Sample Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_MODEL__SAMPLE_TIME = eINSTANCE.getExecutionModel_SampleTime();

		/**
		 * The meta object literal for the '<em><b>Computation Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_MODEL__COMPUTATION_MODEL = eINSTANCE.getExecutionModel_ComputationModel();

	}

} //ExecutionModelPackage
