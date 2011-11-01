/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.simulation.simulationmodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModelPackage;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModelFactory;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage;
import org.eclipselabs.damos.simulation.simulationmodel.SolverArgument;
import org.eclipselabs.damos.simulation.simulationmodel.SolverConfiguration;
import org.eclipselabs.damos.simulation.simulationmodel.SolverConfigurationDefinition;
import org.eclipselabs.damos.simulation.simulationmodel.SolverParameter;
import org.eclipselabs.damos.simulation.simulationmodel.SolverType;
import org.eclipselabs.damos.simulation.simulationmodel.util.SimulationModelValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimulationModelPackageImpl extends EPackageImpl implements SimulationModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simulationModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass solverTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass solverConfigurationDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass solverParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass solverConfigurationEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass solverArgumentEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SimulationModelPackageImpl() {
		super(eNS_URI, SimulationModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SimulationModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SimulationModelPackage init() {
		if (isInited) return (SimulationModelPackage)EPackage.Registry.INSTANCE.getEPackage(SimulationModelPackage.eNS_URI);

		// Obtain or create and register package
		SimulationModelPackageImpl theSimulationModelPackage = (SimulationModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SimulationModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SimulationModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ExecutionModelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSimulationModelPackage.createPackageContents();

		// Initialize created meta-data
		theSimulationModelPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theSimulationModelPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return SimulationModelValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theSimulationModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SimulationModelPackage.eNS_URI, theSimulationModelPackage);
		return theSimulationModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimulationModel() {
		return simulationModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimulationModel_ExecutionModel() {
		return (EReference)simulationModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimulationModel_TopLevelFragment() {
		return (EReference)simulationModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimulationModel_SimulationTime() {
		return (EReference)simulationModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimulationModel_SolverConfiguration() {
		return (EReference)simulationModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimulationModel_QualifiedName() {
		return (EAttribute)simulationModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSolverType() {
		return solverTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSolverType_QualifiedName() {
		return (EAttribute)solverTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSolverType_ConfigurationDefinition() {
		return (EReference)solverTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSolverConfigurationDefinition() {
		return solverConfigurationDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSolverConfigurationDefinition_Parameters() {
		return (EReference)solverConfigurationDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSolverParameter() {
		return solverParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSolverParameter_ConfigurationDefinition() {
		return (EReference)solverParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSolverParameter_Name() {
		return (EAttribute)solverParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSolverConfiguration() {
		return solverConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSolverConfiguration_Type() {
		return (EReference)solverConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSolverConfiguration_Arguments() {
		return (EReference)solverConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSolverArgument() {
		return solverArgumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSolverArgument_Configuration() {
		return (EReference)solverArgumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSolverArgument_Parameter() {
		return (EReference)solverArgumentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSolverArgument_Value() {
		return (EReference)solverArgumentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulationModelFactory getSimulationModelFactory() {
		return (SimulationModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		simulationModelEClass = createEClass(SIMULATION_MODEL);
		createEAttribute(simulationModelEClass, SIMULATION_MODEL__QUALIFIED_NAME);
		createEReference(simulationModelEClass, SIMULATION_MODEL__EXECUTION_MODEL);
		createEReference(simulationModelEClass, SIMULATION_MODEL__TOP_LEVEL_FRAGMENT);
		createEReference(simulationModelEClass, SIMULATION_MODEL__SIMULATION_TIME);
		createEReference(simulationModelEClass, SIMULATION_MODEL__SOLVER_CONFIGURATION);

		solverTypeEClass = createEClass(SOLVER_TYPE);
		createEAttribute(solverTypeEClass, SOLVER_TYPE__QUALIFIED_NAME);
		createEReference(solverTypeEClass, SOLVER_TYPE__CONFIGURATION_DEFINITION);

		solverConfigurationDefinitionEClass = createEClass(SOLVER_CONFIGURATION_DEFINITION);
		createEReference(solverConfigurationDefinitionEClass, SOLVER_CONFIGURATION_DEFINITION__PARAMETERS);

		solverParameterEClass = createEClass(SOLVER_PARAMETER);
		createEReference(solverParameterEClass, SOLVER_PARAMETER__CONFIGURATION_DEFINITION);
		createEAttribute(solverParameterEClass, SOLVER_PARAMETER__NAME);

		solverConfigurationEClass = createEClass(SOLVER_CONFIGURATION);
		createEReference(solverConfigurationEClass, SOLVER_CONFIGURATION__TYPE);
		createEReference(solverConfigurationEClass, SOLVER_CONFIGURATION__ARGUMENTS);

		solverArgumentEClass = createEClass(SOLVER_ARGUMENT);
		createEReference(solverArgumentEClass, SOLVER_ARGUMENT__CONFIGURATION);
		createEReference(solverArgumentEClass, SOLVER_ARGUMENT__PARAMETER);
		createEReference(solverArgumentEClass, SOLVER_ARGUMENT__VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ExecutionModelPackage theExecutionModelPackage = (ExecutionModelPackage)EPackage.Registry.INSTANCE.getEPackage(ExecutionModelPackage.eNS_URI);
		DMLPackage theDMLPackage = (DMLPackage)EPackage.Registry.INSTANCE.getEPackage(DMLPackage.eNS_URI);
		MscriptPackage theMscriptPackage = (MscriptPackage)EPackage.Registry.INSTANCE.getEPackage(MscriptPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(simulationModelEClass, SimulationModel.class, "SimulationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimulationModel_QualifiedName(), ecorePackage.getEString(), "qualifiedName", null, 0, 1, SimulationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimulationModel_ExecutionModel(), theExecutionModelPackage.getExecutionModel(), null, "executionModel", null, 0, 1, SimulationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimulationModel_TopLevelFragment(), theDMLPackage.getFragment(), null, "topLevelFragment", null, 0, 1, SimulationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimulationModel_SimulationTime(), theMscriptPackage.getExpression(), null, "simulationTime", null, 0, 1, SimulationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimulationModel_SolverConfiguration(), this.getSolverConfiguration(), null, "solverConfiguration", null, 0, 1, SimulationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(solverTypeEClass, SolverType.class, "SolverType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSolverType_QualifiedName(), ecorePackage.getEString(), "qualifiedName", null, 0, 1, SolverType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSolverType_ConfigurationDefinition(), this.getSolverConfigurationDefinition(), null, "configurationDefinition", null, 0, 1, SolverType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(solverConfigurationDefinitionEClass, SolverConfigurationDefinition.class, "SolverConfigurationDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSolverConfigurationDefinition_Parameters(), this.getSolverParameter(), this.getSolverParameter_ConfigurationDefinition(), "parameters", null, 0, -1, SolverConfigurationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(solverConfigurationDefinitionEClass, this.getSolverParameter(), "getParameter", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(solverParameterEClass, SolverParameter.class, "SolverParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSolverParameter_ConfigurationDefinition(), this.getSolverConfigurationDefinition(), this.getSolverConfigurationDefinition_Parameters(), "configurationDefinition", null, 1, 1, SolverParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSolverParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, SolverParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(solverConfigurationEClass, SolverConfiguration.class, "SolverConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSolverConfiguration_Type(), this.getSolverType(), null, "type", null, 0, 1, SolverConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSolverConfiguration_Arguments(), this.getSolverArgument(), this.getSolverArgument_Configuration(), "arguments", null, 0, -1, SolverConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(solverConfigurationEClass, this.getSolverArgument(), "getArgument", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(solverConfigurationEClass, theMscriptPackage.getExpression(), "getArgumentValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(solverArgumentEClass, SolverArgument.class, "SolverArgument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSolverArgument_Configuration(), this.getSolverConfiguration(), this.getSolverConfiguration_Arguments(), "configuration", null, 0, 1, SolverArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSolverArgument_Parameter(), this.getSolverParameter(), null, "parameter", null, 0, 1, SolverArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSolverArgument_Value(), theMscriptPackage.getExpression(), null, "value", null, 0, 1, SolverArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";		
		addAnnotation
		  (simulationModelEClass, 
		   source, 
		   new String[] {
			 "constraints", "ValidSimulationTime"
		   });
	}

} //SimulationModelPackageImpl
