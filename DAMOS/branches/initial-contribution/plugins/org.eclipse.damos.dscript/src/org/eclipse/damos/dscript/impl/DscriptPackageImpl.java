/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dscript.impl;

import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dscript.BehaviorDeclaration;
import org.eclipse.damos.dscript.DscriptBlockType;
import org.eclipse.damos.dscript.DscriptDataTypeSpecification;
import org.eclipse.damos.dscript.DscriptFactory;
import org.eclipse.damos.dscript.DscriptInputDefinition;
import org.eclipse.damos.dscript.DscriptOutputDefinition;
import org.eclipse.damos.dscript.DscriptPackage;
import org.eclipse.damos.dscript.DscriptParameter;
import org.eclipse.damos.dscript.DscriptSystemInterface;
import org.eclipse.damos.dscript.DscriptValueSpecification;
import org.eclipse.damos.dscript.ImplicitInputParameterDeclaration;
import org.eclipse.damos.dscript.ImplicitOutputParameterDeclaration;
import org.eclipse.damos.dscript.InputMessageParameterDeclaration;
import org.eclipse.damos.dscript.OutputMessageParameterDeclaration;
import org.eclipse.damos.dscript.Root;
import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DscriptPackageImpl extends EPackageImpl implements DscriptPackage {
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
	private EClass dscriptBlockTypeEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dscriptInputDefinitionEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dscriptOutputDefinitionEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dscriptParameterEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorDeclarationEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implicitInputParameterDeclarationEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implicitOutputParameterDeclarationEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputMessageParameterDeclarationEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputMessageParameterDeclarationEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dscriptSystemInterfaceEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dscriptDataTypeSpecificationEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dscriptValueSpecificationEClass = null;
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
	 * @see org.eclipse.damos.dscript.DscriptPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DscriptPackageImpl() {
		super(eNS_URI, DscriptFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DscriptPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DscriptPackage init() {
		if (isInited) return (DscriptPackage)EPackage.Registry.INSTANCE.getEPackage(DscriptPackage.eNS_URI);

		// Obtain or create and register package
		DscriptPackageImpl theDscriptPackage = (DscriptPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DscriptPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DscriptPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DMLPackage.eINSTANCE.eClass();
		MscriptPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDscriptPackage.createPackageContents();

		// Initialize created meta-data
		theDscriptPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDscriptPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DscriptPackage.eNS_URI, theDscriptPackage);
		return theDscriptPackage;
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
	public EClass getDscriptBlockType() {
		return dscriptBlockTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDscriptBlockType_ImportDeclarations() {
		return (EReference)dscriptBlockTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDscriptBlockType_Behavior() {
		return (EReference)dscriptBlockTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDscriptInputDefinition() {
		return dscriptInputDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDscriptOutputDefinition() {
		return dscriptOutputDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDscriptParameter() {
		return dscriptParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorDeclaration() {
		return behaviorDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorDeclaration_BlockType() {
		return (EReference)behaviorDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorDeclaration_AllImplicitInputParameterDeclarations() {
		return (EReference)behaviorDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorDeclaration_AllImplicitOutputParameterDeclarations() {
		return (EReference)behaviorDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplicitInputParameterDeclaration() {
		return implicitInputParameterDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplicitOutputParameterDeclaration() {
		return implicitOutputParameterDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputMessageParameterDeclaration() {
		return inputMessageParameterDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputMessageParameterDeclaration() {
		return outputMessageParameterDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDscriptSystemInterface() {
		return dscriptSystemInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDscriptSystemInterface_ImportDeclarations() {
		return (EReference)dscriptSystemInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDscriptDataTypeSpecification() {
		return dscriptDataTypeSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDscriptDataTypeSpecification_TypeSpecifier() {
		return (EReference)dscriptDataTypeSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDscriptDataTypeSpecification_Type() {
		return (EReference)dscriptDataTypeSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDscriptValueSpecification() {
		return dscriptValueSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDscriptValueSpecification_Expression() {
		return (EReference)dscriptValueSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DscriptFactory getDscriptFactory() {
		return (DscriptFactory)getEFactoryInstance();
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

		dscriptBlockTypeEClass = createEClass(DSCRIPT_BLOCK_TYPE);
		createEReference(dscriptBlockTypeEClass, DSCRIPT_BLOCK_TYPE__IMPORT_DECLARATIONS);
		createEReference(dscriptBlockTypeEClass, DSCRIPT_BLOCK_TYPE__BEHAVIOR);

		dscriptInputDefinitionEClass = createEClass(DSCRIPT_INPUT_DEFINITION);

		dscriptOutputDefinitionEClass = createEClass(DSCRIPT_OUTPUT_DEFINITION);

		dscriptParameterEClass = createEClass(DSCRIPT_PARAMETER);

		behaviorDeclarationEClass = createEClass(BEHAVIOR_DECLARATION);
		createEReference(behaviorDeclarationEClass, BEHAVIOR_DECLARATION__BLOCK_TYPE);
		createEReference(behaviorDeclarationEClass, BEHAVIOR_DECLARATION__ALL_IMPLICIT_INPUT_PARAMETER_DECLARATIONS);
		createEReference(behaviorDeclarationEClass, BEHAVIOR_DECLARATION__ALL_IMPLICIT_OUTPUT_PARAMETER_DECLARATIONS);

		implicitInputParameterDeclarationEClass = createEClass(IMPLICIT_INPUT_PARAMETER_DECLARATION);

		implicitOutputParameterDeclarationEClass = createEClass(IMPLICIT_OUTPUT_PARAMETER_DECLARATION);

		inputMessageParameterDeclarationEClass = createEClass(INPUT_MESSAGE_PARAMETER_DECLARATION);

		outputMessageParameterDeclarationEClass = createEClass(OUTPUT_MESSAGE_PARAMETER_DECLARATION);

		dscriptSystemInterfaceEClass = createEClass(DSCRIPT_SYSTEM_INTERFACE);
		createEReference(dscriptSystemInterfaceEClass, DSCRIPT_SYSTEM_INTERFACE__IMPORT_DECLARATIONS);

		dscriptDataTypeSpecificationEClass = createEClass(DSCRIPT_DATA_TYPE_SPECIFICATION);
		createEReference(dscriptDataTypeSpecificationEClass, DSCRIPT_DATA_TYPE_SPECIFICATION__TYPE_SPECIFIER);
		createEReference(dscriptDataTypeSpecificationEClass, DSCRIPT_DATA_TYPE_SPECIFICATION__TYPE);

		dscriptValueSpecificationEClass = createEClass(DSCRIPT_VALUE_SPECIFICATION);
		createEReference(dscriptValueSpecificationEClass, DSCRIPT_VALUE_SPECIFICATION__EXPRESSION);
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
		dscriptBlockTypeEClass.getESuperTypes().add(theDMLPackage.getBlockType());
		dscriptBlockTypeEClass.getESuperTypes().add(theMscriptPackage.getTopLevelContainer());
		dscriptInputDefinitionEClass.getESuperTypes().add(theDMLPackage.getInputDefinition());
		dscriptInputDefinitionEClass.getESuperTypes().add(theMscriptPackage.getInputParameterDeclaration());
		dscriptOutputDefinitionEClass.getESuperTypes().add(theDMLPackage.getOutputDefinition());
		dscriptOutputDefinitionEClass.getESuperTypes().add(theMscriptPackage.getOutputParameterDeclaration());
		dscriptParameterEClass.getESuperTypes().add(theDMLPackage.getParameter());
		dscriptParameterEClass.getESuperTypes().add(theMscriptPackage.getInputParameterDeclaration());
		behaviorDeclarationEClass.getESuperTypes().add(theMscriptPackage.getFunctionDeclaration());
		implicitInputParameterDeclarationEClass.getESuperTypes().add(theMscriptPackage.getInputParameterDeclaration());
		implicitOutputParameterDeclarationEClass.getESuperTypes().add(theMscriptPackage.getOutputParameterDeclaration());
		inputMessageParameterDeclarationEClass.getESuperTypes().add(this.getImplicitInputParameterDeclaration());
		outputMessageParameterDeclarationEClass.getESuperTypes().add(this.getImplicitOutputParameterDeclaration());
		dscriptSystemInterfaceEClass.getESuperTypes().add(theDMLPackage.getSystemInterface());
		dscriptDataTypeSpecificationEClass.getESuperTypes().add(theDMLPackage.getDataTypeSpecification());
		dscriptValueSpecificationEClass.getESuperTypes().add(theDMLPackage.getValueSpecification());

		// Initialize classes and features; add operations and parameters
		initEClass(rootEClass, Root.class, "Root", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoot_BlockTypes(), theDMLPackage.getBlockType(), null, "blockTypes", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoot_SystemInterfaces(), theDMLPackage.getSystemInterface(), null, "systemInterfaces", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dscriptBlockTypeEClass, DscriptBlockType.class, "DscriptBlockType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDscriptBlockType_ImportDeclarations(), theMscriptPackage.getImportDeclaration(), null, "importDeclarations", null, 0, -1, DscriptBlockType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDscriptBlockType_Behavior(), this.getBehaviorDeclaration(), this.getBehaviorDeclaration_BlockType(), "behavior", null, 0, 1, DscriptBlockType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dscriptInputDefinitionEClass, DscriptInputDefinition.class, "DscriptInputDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dscriptOutputDefinitionEClass, DscriptOutputDefinition.class, "DscriptOutputDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dscriptParameterEClass, DscriptParameter.class, "DscriptParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(behaviorDeclarationEClass, BehaviorDeclaration.class, "BehaviorDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorDeclaration_BlockType(), this.getDscriptBlockType(), this.getDscriptBlockType_Behavior(), "blockType", null, 0, 1, BehaviorDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorDeclaration_AllImplicitInputParameterDeclarations(), this.getImplicitInputParameterDeclaration(), null, "allImplicitInputParameterDeclarations", null, 0, -1, BehaviorDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorDeclaration_AllImplicitOutputParameterDeclarations(), this.getImplicitOutputParameterDeclaration(), null, "allImplicitOutputParameterDeclarations", null, 0, -1, BehaviorDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(implicitInputParameterDeclarationEClass, ImplicitInputParameterDeclaration.class, "ImplicitInputParameterDeclaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(implicitOutputParameterDeclarationEClass, ImplicitOutputParameterDeclaration.class, "ImplicitOutputParameterDeclaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inputMessageParameterDeclarationEClass, InputMessageParameterDeclaration.class, "InputMessageParameterDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(outputMessageParameterDeclarationEClass, OutputMessageParameterDeclaration.class, "OutputMessageParameterDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dscriptSystemInterfaceEClass, DscriptSystemInterface.class, "DscriptSystemInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDscriptSystemInterface_ImportDeclarations(), theMscriptPackage.getImportDeclaration(), null, "importDeclarations", null, 0, -1, DscriptSystemInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dscriptDataTypeSpecificationEClass, DscriptDataTypeSpecification.class, "DscriptDataTypeSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDscriptDataTypeSpecification_TypeSpecifier(), theMscriptPackage.getTypeSpecifier(), null, "typeSpecifier", null, 0, 1, DscriptDataTypeSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDscriptDataTypeSpecification_Type(), theMscriptPackage.getType(), null, "type", null, 0, 1, DscriptDataTypeSpecification.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(dscriptValueSpecificationEClass, DscriptValueSpecification.class, "DscriptValueSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDscriptValueSpecification_Expression(), theMscriptPackage.getExpression(), null, "expression", null, 0, 1, DscriptValueSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //DscriptPackageImpl
