/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.codegen.c.cgenmodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelFactory;
import org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenModel;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenSubsystem;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenSystem;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenTopLevelSystem;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CGenModelPackageImpl extends EPackageImpl implements CGenModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genModelEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genSystemEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genTopLevelSystemEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genSubsystemEClass = null;
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
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CGenModelPackageImpl() {
		super(eNS_URI, CGenModelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CGenModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CGenModelPackage init() {
		if (isInited) return (CGenModelPackage)EPackage.Registry.INSTANCE.getEPackage(CGenModelPackage.eNS_URI);

		// Obtain or create and register package
		CGenModelPackageImpl theCGenModelPackage = (CGenModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CGenModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CGenModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ExecutionModelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCGenModelPackage.createPackageContents();

		// Initialize created meta-data
		theCGenModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCGenModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CGenModelPackage.eNS_URI, theCGenModelPackage);
		return theCGenModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenModel() {
		return genModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenModel_GenTopLevelSystem() {
		return (EReference)genModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenModel_ExecutionModel() {
		return (EReference)genModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenModel_SourceDirectory() {
		return (EAttribute)genModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenModel_HeaderDirectory() {
		return (EAttribute)genModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenModel_MainSourceFile() {
		return (EAttribute)genModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenModel_MainHeaderFile() {
		return (EAttribute)genModelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenModel_Singleton() {
		return (EAttribute)genModelEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenSystem() {
		return genSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenSystem_GenSubsystems() {
		return (EReference)genSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGenSystem_Prefix() {
		return (EAttribute)genSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenTopLevelSystem() {
		return genTopLevelSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenTopLevelSystem_Fragment() {
		return (EReference)genTopLevelSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenSubsystem() {
		return genSubsystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenSubsystem_EnclosingGenSystem() {
		return (EReference)genSubsystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenSubsystem_Subsystem() {
		return (EReference)genSubsystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGenModelFactory getCGenModelFactory() {
		return (CGenModelFactory)getEFactoryInstance();
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
		genModelEClass = createEClass(GEN_MODEL);
		createEReference(genModelEClass, GEN_MODEL__EXECUTION_MODEL);
		createEReference(genModelEClass, GEN_MODEL__GEN_TOP_LEVEL_SYSTEM);
		createEAttribute(genModelEClass, GEN_MODEL__SOURCE_DIRECTORY);
		createEAttribute(genModelEClass, GEN_MODEL__HEADER_DIRECTORY);
		createEAttribute(genModelEClass, GEN_MODEL__MAIN_SOURCE_FILE);
		createEAttribute(genModelEClass, GEN_MODEL__MAIN_HEADER_FILE);
		createEAttribute(genModelEClass, GEN_MODEL__SINGLETON);

		genSystemEClass = createEClass(GEN_SYSTEM);
		createEReference(genSystemEClass, GEN_SYSTEM__GEN_SUBSYSTEMS);
		createEAttribute(genSystemEClass, GEN_SYSTEM__PREFIX);

		genTopLevelSystemEClass = createEClass(GEN_TOP_LEVEL_SYSTEM);
		createEReference(genTopLevelSystemEClass, GEN_TOP_LEVEL_SYSTEM__FRAGMENT);

		genSubsystemEClass = createEClass(GEN_SUBSYSTEM);
		createEReference(genSubsystemEClass, GEN_SUBSYSTEM__ENCLOSING_GEN_SYSTEM);
		createEReference(genSubsystemEClass, GEN_SUBSYSTEM__SUBSYSTEM);
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
		genTopLevelSystemEClass.getESuperTypes().add(this.getGenSystem());
		genSubsystemEClass.getESuperTypes().add(this.getGenSystem());

		// Initialize classes and features; add operations and parameters
		initEClass(genModelEClass, GenModel.class, "GenModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenModel_ExecutionModel(), theExecutionModelPackage.getExecutionModel(), null, "executionModel", null, 1, 1, GenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenModel_GenTopLevelSystem(), this.getGenTopLevelSystem(), null, "genTopLevelSystem", null, 1, 1, GenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenModel_SourceDirectory(), ecorePackage.getEString(), "sourceDirectory", null, 1, 1, GenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenModel_HeaderDirectory(), ecorePackage.getEString(), "headerDirectory", null, 0, 1, GenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenModel_MainSourceFile(), ecorePackage.getEString(), "mainSourceFile", null, 0, 1, GenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenModel_MainHeaderFile(), ecorePackage.getEString(), "mainHeaderFile", null, 0, 1, GenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenModel_Singleton(), ecorePackage.getEBoolean(), "singleton", null, 0, 1, GenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(genSystemEClass, GenSystem.class, "GenSystem", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenSystem_GenSubsystems(), this.getGenSubsystem(), this.getGenSubsystem_EnclosingGenSystem(), "genSubsystems", null, 0, -1, GenSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGenSystem_Prefix(), ecorePackage.getEString(), "prefix", null, 0, 1, GenSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(genTopLevelSystemEClass, GenTopLevelSystem.class, "GenTopLevelSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenTopLevelSystem_Fragment(), theDMLPackage.getFragment(), null, "fragment", null, 1, 1, GenTopLevelSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(genSubsystemEClass, GenSubsystem.class, "GenSubsystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenSubsystem_EnclosingGenSystem(), this.getGenSystem(), this.getGenSystem_GenSubsystems(), "enclosingGenSystem", null, 1, 1, GenSubsystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGenSubsystem_Subsystem(), theDMLPackage.getSubsystem(), null, "subsystem", null, 1, 1, GenSubsystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //CGenModelPackageImpl
