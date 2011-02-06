/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionmodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.execution.executionmodel.ComputationModelMapping;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModel;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModelFactory;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModelPackage;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExecutionModelPackageImpl extends EPackageImpl implements ExecutionModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computationModelMappingEClass = null;

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
	 * @see org.eclipselabs.damos.execution.executionmodel.ExecutionModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExecutionModelPackageImpl() {
		super(eNS_URI, ExecutionModelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ExecutionModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExecutionModelPackage init() {
		if (isInited) return (ExecutionModelPackage)EPackage.Registry.INSTANCE.getEPackage(ExecutionModelPackage.eNS_URI);

		// Obtain or create and register package
		ExecutionModelPackageImpl theExecutionModelPackage = (ExecutionModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExecutionModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExecutionModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ComputationModelPackage.eINSTANCE.eClass();
		DMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theExecutionModelPackage.createPackageContents();

		// Initialize created meta-data
		theExecutionModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExecutionModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExecutionModelPackage.eNS_URI, theExecutionModelPackage);
		return theExecutionModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutionModel() {
		return executionModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionModel_ComputationModelMappings() {
		return (EReference)executionModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionModel_SampleTime() {
		return (EAttribute)executionModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComputationModelMapping() {
		return computationModelMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputationModelMapping_Fragment() {
		return (EReference)computationModelMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputationModelMapping_ComputationModel() {
		return (EReference)computationModelMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionModelFactory getExecutionModelFactory() {
		return (ExecutionModelFactory)getEFactoryInstance();
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
		executionModelEClass = createEClass(EXECUTION_MODEL);
		createEReference(executionModelEClass, EXECUTION_MODEL__COMPUTATION_MODEL_MAPPINGS);
		createEAttribute(executionModelEClass, EXECUTION_MODEL__SAMPLE_TIME);

		computationModelMappingEClass = createEClass(COMPUTATION_MODEL_MAPPING);
		createEReference(computationModelMappingEClass, COMPUTATION_MODEL_MAPPING__FRAGMENT);
		createEReference(computationModelMappingEClass, COMPUTATION_MODEL_MAPPING__COMPUTATION_MODEL);
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
		ComputationModelPackage theComputationModelPackage = (ComputationModelPackage)EPackage.Registry.INSTANCE.getEPackage(ComputationModelPackage.eNS_URI);
		DMLPackage theDMLPackage = (DMLPackage)EPackage.Registry.INSTANCE.getEPackage(DMLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(executionModelEClass, ExecutionModel.class, "ExecutionModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecutionModel_ComputationModelMappings(), this.getComputationModelMapping(), null, "computationModelMappings", null, 0, -1, ExecutionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionModel_SampleTime(), ecorePackage.getEDouble(), "sampleTime", null, 1, 1, ExecutionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(executionModelEClass, theComputationModelPackage.getComputationModel(), "getComputationModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDMLPackage.getFragment(), "fragment", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(computationModelMappingEClass, ComputationModelMapping.class, "ComputationModelMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComputationModelMapping_Fragment(), theDMLPackage.getFragment(), null, "fragment", null, 1, 1, ComputationModelMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputationModelMapping_ComputationModel(), theComputationModelPackage.getComputationModel(), null, "computationModel", null, 1, 1, ComputationModelMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ExecutionModelPackageImpl
