/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.simulation.simulationmodel;

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
 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelFactory
 * @model kind="package"
 * @generated
 */
public interface SimulationModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "simulationmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/damos/SimulationModel/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "simulationmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimulationModelPackage eINSTANCE = org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelImpl <em>Simulation Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelImpl
	 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelPackageImpl#getSimulationModel()
	 * @generated
	 */
	int SIMULATION_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Execution Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__EXECUTION_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Top Level Fragment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__TOP_LEVEL_FRAGMENT = 1;

	/**
	 * The feature id for the '<em><b>Simulation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__SIMULATION_TIME = 2;

	/**
	 * The number of structural features of the '<em>Simulation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.simulation.simulationmodel.SimulationModel <em>Simulation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulation Model</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModel
	 * @generated
	 */
	EClass getSimulationModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.simulation.simulationmodel.SimulationModel#getExecutionModel <em>Execution Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Execution Model</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModel#getExecutionModel()
	 * @see #getSimulationModel()
	 * @generated
	 */
	EReference getSimulationModel_ExecutionModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.simulation.simulationmodel.SimulationModel#getTopLevelFragment <em>Top Level Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Top Level Fragment</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModel#getTopLevelFragment()
	 * @see #getSimulationModel()
	 * @generated
	 */
	EReference getSimulationModel_TopLevelFragment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.simulation.simulationmodel.SimulationModel#getSimulationTime <em>Simulation Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simulation Time</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModel#getSimulationTime()
	 * @see #getSimulationModel()
	 * @generated
	 */
	EAttribute getSimulationModel_SimulationTime();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SimulationModelFactory getSimulationModelFactory();

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
		 * The meta object literal for the '{@link org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelImpl <em>Simulation Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelImpl
		 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelPackageImpl#getSimulationModel()
		 * @generated
		 */
		EClass SIMULATION_MODEL = eINSTANCE.getSimulationModel();

		/**
		 * The meta object literal for the '<em><b>Execution Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_MODEL__EXECUTION_MODEL = eINSTANCE.getSimulationModel_ExecutionModel();

		/**
		 * The meta object literal for the '<em><b>Top Level Fragment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_MODEL__TOP_LEVEL_FRAGMENT = eINSTANCE.getSimulationModel_TopLevelFragment();

		/**
		 * The meta object literal for the '<em><b>Simulation Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION_MODEL__SIMULATION_TIME = eINSTANCE.getSimulationModel_SimulationTime();

	}

} //SimulationModelPackage
