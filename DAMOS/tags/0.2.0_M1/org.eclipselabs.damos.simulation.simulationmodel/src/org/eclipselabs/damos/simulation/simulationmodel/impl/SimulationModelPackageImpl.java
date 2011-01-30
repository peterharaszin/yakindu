/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.simulation.simulationmodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModelPackage;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModelFactory;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage;

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
		return (EReference)simulationModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimulationModel_TopLevelFragment() {
		return (EReference)simulationModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimulationModel_SimulationTime() {
		return (EAttribute)simulationModelEClass.getEStructuralFeatures().get(2);
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
		createEReference(simulationModelEClass, SIMULATION_MODEL__EXECUTION_MODEL);
		createEReference(simulationModelEClass, SIMULATION_MODEL__TOP_LEVEL_FRAGMENT);
		createEAttribute(simulationModelEClass, SIMULATION_MODEL__SIMULATION_TIME);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(simulationModelEClass, SimulationModel.class, "SimulationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimulationModel_ExecutionModel(), theExecutionModelPackage.getExecutionModel(), null, "executionModel", null, 0, 1, SimulationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimulationModel_TopLevelFragment(), theDMLPackage.getFragment(), null, "topLevelFragment", null, 1, 1, SimulationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimulationModel_SimulationTime(), ecorePackage.getEDouble(), "simulationTime", null, 1, 1, SimulationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //SimulationModelPackageImpl
