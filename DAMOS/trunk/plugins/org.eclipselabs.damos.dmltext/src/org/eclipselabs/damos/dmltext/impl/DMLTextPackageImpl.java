/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dmltext.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dmltext.DMLTextFactory;
import org.eclipselabs.damos.dmltext.DMLTextPackage;
import org.eclipselabs.damos.dmltext.MscriptBlockType;
import org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification;
import org.eclipselabs.damos.dmltext.MscriptSystemInterface;
import org.eclipselabs.damos.dmltext.MscriptValueSpecification;
import org.eclipselabs.damos.dmltext.Root;
import org.eclipselabs.damos.mscript.MscriptPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DMLTextPackageImpl extends EPackageImpl implements DMLTextPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mscriptBlockTypeEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mscriptSystemInterfaceEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mscriptDataTypeSpecificationEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mscriptValueSpecificationEClass = null;
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
	 * @see org.eclipselabs.damos.dmltext.DMLTextPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DMLTextPackageImpl() {
		super(eNS_URI, DMLTextFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DMLTextPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DMLTextPackage init() {
		if (isInited) return (DMLTextPackage)EPackage.Registry.INSTANCE.getEPackage(DMLTextPackage.eNS_URI);

		// Obtain or create and register package
		DMLTextPackageImpl theDMLTextPackage = (DMLTextPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DMLTextPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DMLTextPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DMLPackage.eINSTANCE.eClass();
		MscriptPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDMLTextPackage.createPackageContents();

		// Initialize created meta-data
		theDMLTextPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDMLTextPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DMLTextPackage.eNS_URI, theDMLTextPackage);
		return theDMLTextPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoot() {
		return rootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoot_BlockTypes() {
		return (EReference)rootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoot_SystemInterfaces() {
		return (EReference)rootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMscriptBlockType() {
		return mscriptBlockTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMscriptBlockType_ImportDeclarations() {
		return (EReference)mscriptBlockTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMscriptSystemInterface() {
		return mscriptSystemInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMscriptSystemInterface_ImportDeclarations() {
		return (EReference)mscriptSystemInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMscriptDataTypeSpecification() {
		return mscriptDataTypeSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMscriptDataTypeSpecification_TypeSpecifier() {
		return (EReference)mscriptDataTypeSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMscriptDataTypeSpecification_Type() {
		return (EReference)mscriptDataTypeSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMscriptValueSpecification() {
		return mscriptValueSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMscriptValueSpecification_Expression() {
		return (EReference)mscriptValueSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DMLTextFactory getDMLTextFactory() {
		return (DMLTextFactory)getEFactoryInstance();
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
		rootEClass = createEClass(ROOT);
		createEReference(rootEClass, ROOT__BLOCK_TYPES);
		createEReference(rootEClass, ROOT__SYSTEM_INTERFACES);

		mscriptBlockTypeEClass = createEClass(MSCRIPT_BLOCK_TYPE);
		createEReference(mscriptBlockTypeEClass, MSCRIPT_BLOCK_TYPE__IMPORT_DECLARATIONS);

		mscriptSystemInterfaceEClass = createEClass(MSCRIPT_SYSTEM_INTERFACE);
		createEReference(mscriptSystemInterfaceEClass, MSCRIPT_SYSTEM_INTERFACE__IMPORT_DECLARATIONS);

		mscriptDataTypeSpecificationEClass = createEClass(MSCRIPT_DATA_TYPE_SPECIFICATION);
		createEReference(mscriptDataTypeSpecificationEClass, MSCRIPT_DATA_TYPE_SPECIFICATION__TYPE_SPECIFIER);
		createEReference(mscriptDataTypeSpecificationEClass, MSCRIPT_DATA_TYPE_SPECIFICATION__TYPE);

		mscriptValueSpecificationEClass = createEClass(MSCRIPT_VALUE_SPECIFICATION);
		createEReference(mscriptValueSpecificationEClass, MSCRIPT_VALUE_SPECIFICATION__EXPRESSION);
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
		DMLPackage theDMLPackage = (DMLPackage)EPackage.Registry.INSTANCE.getEPackage(DMLPackage.eNS_URI);
		MscriptPackage theMscriptPackage = (MscriptPackage)EPackage.Registry.INSTANCE.getEPackage(MscriptPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		mscriptBlockTypeEClass.getESuperTypes().add(theDMLPackage.getBlockType());
		mscriptBlockTypeEClass.getESuperTypes().add(theMscriptPackage.getTopLevelContainer());
		mscriptSystemInterfaceEClass.getESuperTypes().add(theDMLPackage.getSystemInterface());
		mscriptDataTypeSpecificationEClass.getESuperTypes().add(theDMLPackage.getDataTypeSpecification());
		mscriptValueSpecificationEClass.getESuperTypes().add(theDMLPackage.getValueSpecification());

		// Initialize classes and features; add operations and parameters
		initEClass(rootEClass, Root.class, "Root", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoot_BlockTypes(), theDMLPackage.getBlockType(), null, "blockTypes", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_SystemInterfaces(), theDMLPackage.getSystemInterface(), null, "systemInterfaces", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mscriptBlockTypeEClass, MscriptBlockType.class, "MscriptBlockType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMscriptBlockType_ImportDeclarations(), theMscriptPackage.getImportDeclaration(), null, "importDeclarations", null, 0, -1, MscriptBlockType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mscriptSystemInterfaceEClass, MscriptSystemInterface.class, "MscriptSystemInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMscriptSystemInterface_ImportDeclarations(), theMscriptPackage.getImportDeclaration(), null, "importDeclarations", null, 0, -1, MscriptSystemInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mscriptDataTypeSpecificationEClass, MscriptDataTypeSpecification.class, "MscriptDataTypeSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMscriptDataTypeSpecification_TypeSpecifier(), theMscriptPackage.getTypeSpecifier(), null, "typeSpecifier", null, 0, 1, MscriptDataTypeSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMscriptDataTypeSpecification_Type(), theMscriptPackage.getType(), null, "type", null, 0, 1, MscriptDataTypeSpecification.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(mscriptValueSpecificationEClass, MscriptValueSpecification.class, "MscriptValueSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMscriptValueSpecification_Expression(), theMscriptPackage.getExpression(), null, "expression", null, 0, 1, MscriptValueSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //DMLTextPackageImpl
