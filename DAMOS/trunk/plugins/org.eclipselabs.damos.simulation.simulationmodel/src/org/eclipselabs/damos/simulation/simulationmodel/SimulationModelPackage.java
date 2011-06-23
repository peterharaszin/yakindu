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
	 * The feature id for the '<em><b>Solver Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__SOLVER_ID = 3;

	/**
	 * The feature id for the '<em><b>Solver Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__SOLVER_CONFIGURATION = 4;

	/**
	 * The number of structural features of the '<em>Simulation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL_FEATURE_COUNT = 5;


	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.simulation.simulationmodel.impl.SolverConfigurationImpl <em>Solver Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SolverConfigurationImpl
	 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelPackageImpl#getSolverConfiguration()
	 * @generated
	 */
	int SOLVER_CONFIGURATION = 1;

	/**
	 * The number of structural features of the '<em>Solver Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLVER_CONFIGURATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.simulation.simulationmodel.impl.FixedStepSizeSolverConfigurationImpl <em>Fixed Step Size Solver Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.FixedStepSizeSolverConfigurationImpl
	 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelPackageImpl#getFixedStepSizeSolverConfiguration()
	 * @generated
	 */
	int FIXED_STEP_SIZE_SOLVER_CONFIGURATION = 2;

	/**
	 * The feature id for the '<em><b>Step Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_STEP_SIZE_SOLVER_CONFIGURATION__STEP_SIZE = SOLVER_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Fixed Step Size Solver Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_STEP_SIZE_SOLVER_CONFIGURATION_FEATURE_COUNT = SOLVER_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.simulation.simulationmodel.impl.AdaptiveStepSizeSolverConfigurationImpl <em>Adaptive Step Size Solver Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.AdaptiveStepSizeSolverConfigurationImpl
	 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelPackageImpl#getAdaptiveStepSizeSolverConfiguration()
	 * @generated
	 */
	int ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION = 3;

	/**
	 * The feature id for the '<em><b>Minimum Step Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__MINIMUM_STEP_SIZE = SOLVER_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Maximum Step Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__MAXIMUM_STEP_SIZE = SOLVER_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initial Step Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__INITIAL_STEP_SIZE = SOLVER_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Absolute Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__ABSOLUTE_TOLERANCE = SOLVER_CONFIGURATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__RELATIVE_TOLERANCE = SOLVER_CONFIGURATION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Adaptive Step Size Solver Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION_FEATURE_COUNT = SOLVER_CONFIGURATION_FEATURE_COUNT + 5;


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
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.simulation.simulationmodel.SimulationModel#getSolverId <em>Solver Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Solver Id</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModel#getSolverId()
	 * @see #getSimulationModel()
	 * @generated
	 */
	EAttribute getSimulationModel_SolverId();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.simulation.simulationmodel.SimulationModel#getSolverConfiguration <em>Solver Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Solver Configuration</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModel#getSolverConfiguration()
	 * @see #getSimulationModel()
	 * @generated
	 */
	EReference getSimulationModel_SolverConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverConfiguration <em>Solver Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Solver Configuration</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SolverConfiguration
	 * @generated
	 */
	EClass getSolverConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.simulation.simulationmodel.FixedStepSizeSolverConfiguration <em>Fixed Step Size Solver Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fixed Step Size Solver Configuration</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.FixedStepSizeSolverConfiguration
	 * @generated
	 */
	EClass getFixedStepSizeSolverConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.simulation.simulationmodel.FixedStepSizeSolverConfiguration#getStepSize <em>Step Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Size</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.FixedStepSizeSolverConfiguration#getStepSize()
	 * @see #getFixedStepSizeSolverConfiguration()
	 * @generated
	 */
	EAttribute getFixedStepSizeSolverConfiguration_StepSize();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration <em>Adaptive Step Size Solver Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adaptive Step Size Solver Configuration</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration
	 * @generated
	 */
	EClass getAdaptiveStepSizeSolverConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration#getMinimumStepSize <em>Minimum Step Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum Step Size</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration#getMinimumStepSize()
	 * @see #getAdaptiveStepSizeSolverConfiguration()
	 * @generated
	 */
	EAttribute getAdaptiveStepSizeSolverConfiguration_MinimumStepSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration#getMaximumStepSize <em>Maximum Step Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Step Size</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration#getMaximumStepSize()
	 * @see #getAdaptiveStepSizeSolverConfiguration()
	 * @generated
	 */
	EAttribute getAdaptiveStepSizeSolverConfiguration_MaximumStepSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration#getInitialStepSize <em>Initial Step Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Step Size</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration#getInitialStepSize()
	 * @see #getAdaptiveStepSizeSolverConfiguration()
	 * @generated
	 */
	EAttribute getAdaptiveStepSizeSolverConfiguration_InitialStepSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration#getAbsoluteTolerance <em>Absolute Tolerance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Absolute Tolerance</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration#getAbsoluteTolerance()
	 * @see #getAdaptiveStepSizeSolverConfiguration()
	 * @generated
	 */
	EAttribute getAdaptiveStepSizeSolverConfiguration_AbsoluteTolerance();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration#getRelativeTolerance <em>Relative Tolerance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relative Tolerance</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration#getRelativeTolerance()
	 * @see #getAdaptiveStepSizeSolverConfiguration()
	 * @generated
	 */
	EAttribute getAdaptiveStepSizeSolverConfiguration_RelativeTolerance();

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

		/**
		 * The meta object literal for the '<em><b>Solver Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMULATION_MODEL__SOLVER_ID = eINSTANCE.getSimulationModel_SolverId();

		/**
		 * The meta object literal for the '<em><b>Solver Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_MODEL__SOLVER_CONFIGURATION = eINSTANCE.getSimulationModel_SolverConfiguration();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.simulation.simulationmodel.impl.SolverConfigurationImpl <em>Solver Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SolverConfigurationImpl
		 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelPackageImpl#getSolverConfiguration()
		 * @generated
		 */
		EClass SOLVER_CONFIGURATION = eINSTANCE.getSolverConfiguration();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.simulation.simulationmodel.impl.FixedStepSizeSolverConfigurationImpl <em>Fixed Step Size Solver Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.FixedStepSizeSolverConfigurationImpl
		 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelPackageImpl#getFixedStepSizeSolverConfiguration()
		 * @generated
		 */
		EClass FIXED_STEP_SIZE_SOLVER_CONFIGURATION = eINSTANCE.getFixedStepSizeSolverConfiguration();

		/**
		 * The meta object literal for the '<em><b>Step Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_STEP_SIZE_SOLVER_CONFIGURATION__STEP_SIZE = eINSTANCE.getFixedStepSizeSolverConfiguration_StepSize();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.simulation.simulationmodel.impl.AdaptiveStepSizeSolverConfigurationImpl <em>Adaptive Step Size Solver Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.AdaptiveStepSizeSolverConfigurationImpl
		 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelPackageImpl#getAdaptiveStepSizeSolverConfiguration()
		 * @generated
		 */
		EClass ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION = eINSTANCE.getAdaptiveStepSizeSolverConfiguration();

		/**
		 * The meta object literal for the '<em><b>Minimum Step Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__MINIMUM_STEP_SIZE = eINSTANCE.getAdaptiveStepSizeSolverConfiguration_MinimumStepSize();

		/**
		 * The meta object literal for the '<em><b>Maximum Step Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__MAXIMUM_STEP_SIZE = eINSTANCE.getAdaptiveStepSizeSolverConfiguration_MaximumStepSize();

		/**
		 * The meta object literal for the '<em><b>Initial Step Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__INITIAL_STEP_SIZE = eINSTANCE.getAdaptiveStepSizeSolverConfiguration_InitialStepSize();

		/**
		 * The meta object literal for the '<em><b>Absolute Tolerance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__ABSOLUTE_TOLERANCE = eINSTANCE.getAdaptiveStepSizeSolverConfiguration_AbsoluteTolerance();

		/**
		 * The meta object literal for the '<em><b>Relative Tolerance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__RELATIVE_TOLERANCE = eINSTANCE.getAdaptiveStepSizeSolverConfiguration_RelativeTolerance();

	}

} //SimulationModelPackage
