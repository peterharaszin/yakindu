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
	String eNS_URI = "http://www.eclipselabs.org/damos/2011/SimulationModel";

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
	 * The feature id for the '<em><b>Solver Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL__SOLVER_CONFIGURATION = 3;

	/**
	 * The number of structural features of the '<em>Simulation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATION_MODEL_FEATURE_COUNT = 4;


	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.simulation.simulationmodel.impl.SolverTypeImpl <em>Solver Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SolverTypeImpl
	 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelPackageImpl#getSolverType()
	 * @generated
	 */
	int SOLVER_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLVER_TYPE__QUALIFIED_NAME = 0;

	/**
	 * The feature id for the '<em><b>Configuration Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLVER_TYPE__CONFIGURATION_DEFINITION = 1;

	/**
	 * The number of structural features of the '<em>Solver Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLVER_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.simulation.simulationmodel.impl.SolverConfigurationDefinitionImpl <em>Solver Configuration Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SolverConfigurationDefinitionImpl
	 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelPackageImpl#getSolverConfigurationDefinition()
	 * @generated
	 */
	int SOLVER_CONFIGURATION_DEFINITION = 2;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLVER_CONFIGURATION_DEFINITION__PARAMETERS = 0;

	/**
	 * The number of structural features of the '<em>Solver Configuration Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLVER_CONFIGURATION_DEFINITION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.simulation.simulationmodel.impl.SolverParameterImpl <em>Solver Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SolverParameterImpl
	 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelPackageImpl#getSolverParameter()
	 * @generated
	 */
	int SOLVER_PARAMETER = 3;

	/**
	 * The feature id for the '<em><b>Configuration Definition</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLVER_PARAMETER__CONFIGURATION_DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLVER_PARAMETER__NAME = 1;

	/**
	 * The number of structural features of the '<em>Solver Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLVER_PARAMETER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.simulation.simulationmodel.impl.SolverConfigurationImpl <em>Solver Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SolverConfigurationImpl
	 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelPackageImpl#getSolverConfiguration()
	 * @generated
	 */
	int SOLVER_CONFIGURATION = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLVER_CONFIGURATION__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLVER_CONFIGURATION__ARGUMENTS = 1;

	/**
	 * The number of structural features of the '<em>Solver Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLVER_CONFIGURATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.simulation.simulationmodel.impl.SolverArgumentImpl <em>Solver Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SolverArgumentImpl
	 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelPackageImpl#getSolverArgument()
	 * @generated
	 */
	int SOLVER_ARGUMENT = 5;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLVER_ARGUMENT__CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLVER_ARGUMENT__PARAMETER = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLVER_ARGUMENT__VALUE = 2;

	/**
	 * The number of structural features of the '<em>Solver Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLVER_ARGUMENT_FEATURE_COUNT = 3;

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
	 * Returns the meta object for class '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverType <em>Solver Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Solver Type</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SolverType
	 * @generated
	 */
	EClass getSolverType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverType#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SolverType#getQualifiedName()
	 * @see #getSolverType()
	 * @generated
	 */
	EAttribute getSolverType_QualifiedName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverType#getConfigurationDefinition <em>Configuration Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Configuration Definition</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SolverType#getConfigurationDefinition()
	 * @see #getSolverType()
	 * @generated
	 */
	EReference getSolverType_ConfigurationDefinition();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverConfigurationDefinition <em>Solver Configuration Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Solver Configuration Definition</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SolverConfigurationDefinition
	 * @generated
	 */
	EClass getSolverConfigurationDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverConfigurationDefinition#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SolverConfigurationDefinition#getParameters()
	 * @see #getSolverConfigurationDefinition()
	 * @generated
	 */
	EReference getSolverConfigurationDefinition_Parameters();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverParameter <em>Solver Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Solver Parameter</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SolverParameter
	 * @generated
	 */
	EClass getSolverParameter();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverParameter#getConfigurationDefinition <em>Configuration Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Configuration Definition</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SolverParameter#getConfigurationDefinition()
	 * @see #getSolverParameter()
	 * @generated
	 */
	EReference getSolverParameter_ConfigurationDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SolverParameter#getName()
	 * @see #getSolverParameter()
	 * @generated
	 */
	EAttribute getSolverParameter_Name();

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
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverConfiguration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SolverConfiguration#getType()
	 * @see #getSolverConfiguration()
	 * @generated
	 */
	EReference getSolverConfiguration_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverConfiguration#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SolverConfiguration#getArguments()
	 * @see #getSolverConfiguration()
	 * @generated
	 */
	EReference getSolverConfiguration_Arguments();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverArgument <em>Solver Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Solver Argument</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SolverArgument
	 * @generated
	 */
	EClass getSolverArgument();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverArgument#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Configuration</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SolverArgument#getConfiguration()
	 * @see #getSolverArgument()
	 * @generated
	 */
	EReference getSolverArgument_Configuration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverArgument#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SolverArgument#getParameter()
	 * @see #getSolverArgument()
	 * @generated
	 */
	EReference getSolverArgument_Parameter();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverArgument#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SolverArgument#getValue()
	 * @see #getSolverArgument()
	 * @generated
	 */
	EReference getSolverArgument_Value();

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
		 * The meta object literal for the '<em><b>Solver Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATION_MODEL__SOLVER_CONFIGURATION = eINSTANCE.getSimulationModel_SolverConfiguration();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.simulation.simulationmodel.impl.SolverTypeImpl <em>Solver Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SolverTypeImpl
		 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelPackageImpl#getSolverType()
		 * @generated
		 */
		EClass SOLVER_TYPE = eINSTANCE.getSolverType();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOLVER_TYPE__QUALIFIED_NAME = eINSTANCE.getSolverType_QualifiedName();

		/**
		 * The meta object literal for the '<em><b>Configuration Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLVER_TYPE__CONFIGURATION_DEFINITION = eINSTANCE.getSolverType_ConfigurationDefinition();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.simulation.simulationmodel.impl.SolverConfigurationDefinitionImpl <em>Solver Configuration Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SolverConfigurationDefinitionImpl
		 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelPackageImpl#getSolverConfigurationDefinition()
		 * @generated
		 */
		EClass SOLVER_CONFIGURATION_DEFINITION = eINSTANCE.getSolverConfigurationDefinition();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLVER_CONFIGURATION_DEFINITION__PARAMETERS = eINSTANCE.getSolverConfigurationDefinition_Parameters();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.simulation.simulationmodel.impl.SolverParameterImpl <em>Solver Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SolverParameterImpl
		 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelPackageImpl#getSolverParameter()
		 * @generated
		 */
		EClass SOLVER_PARAMETER = eINSTANCE.getSolverParameter();

		/**
		 * The meta object literal for the '<em><b>Configuration Definition</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLVER_PARAMETER__CONFIGURATION_DEFINITION = eINSTANCE.getSolverParameter_ConfigurationDefinition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOLVER_PARAMETER__NAME = eINSTANCE.getSolverParameter_Name();

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
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLVER_CONFIGURATION__TYPE = eINSTANCE.getSolverConfiguration_Type();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLVER_CONFIGURATION__ARGUMENTS = eINSTANCE.getSolverConfiguration_Arguments();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.simulation.simulationmodel.impl.SolverArgumentImpl <em>Solver Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SolverArgumentImpl
		 * @see org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelPackageImpl#getSolverArgument()
		 * @generated
		 */
		EClass SOLVER_ARGUMENT = eINSTANCE.getSolverArgument();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLVER_ARGUMENT__CONFIGURATION = eINSTANCE.getSolverArgument_Configuration();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLVER_ARGUMENT__PARAMETER = eINSTANCE.getSolverArgument_Parameter();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLVER_ARGUMENT__VALUE = eINSTANCE.getSolverArgument_Value();

	}

} //SimulationModelPackage
