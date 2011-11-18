/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.computationmodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModelFactory;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModelPackage;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointOperation;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointOperationKind;
import org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormatKind;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormatMapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComputationModelPackageImpl extends EPackageImpl implements ComputationModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass floatingPointFormatEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numberFormatEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fixedPointFormatEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fixedPointOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computationModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numberFormatMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum floatingPointFormatKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum fixedPointOperationKindEEnum = null;

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
	 * @see org.eclipselabs.damos.mscript.computationmodel.ComputationModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ComputationModelPackageImpl() {
		super(eNS_URI, ComputationModelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ComputationModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ComputationModelPackage init() {
		if (isInited) return (ComputationModelPackage)EPackage.Registry.INSTANCE.getEPackage(ComputationModelPackage.eNS_URI);

		// Obtain or create and register package
		ComputationModelPackageImpl theComputationModelPackage = (ComputationModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ComputationModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ComputationModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		MscriptPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theComputationModelPackage.createPackageContents();

		// Initialize created meta-data
		theComputationModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theComputationModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ComputationModelPackage.eNS_URI, theComputationModelPackage);
		return theComputationModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFloatingPointFormat() {
		return floatingPointFormatEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFloatingPointFormat_Kind() {
		return (EAttribute)floatingPointFormatEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumberFormat() {
		return numberFormatEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumberFormat_Name() {
		return (EAttribute)numberFormatEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFixedPointFormat() {
		return fixedPointFormatEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFixedPointFormat_IntegerLength() {
		return (EAttribute)fixedPointFormatEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFixedPointFormat_FractionLength() {
		return (EAttribute)fixedPointFormatEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFixedPointFormat_WordSize() {
		return (EAttribute)fixedPointFormatEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFixedPointFormat_Operations() {
		return (EReference)fixedPointFormatEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFixedPointOperation() {
		return fixedPointOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFixedPointOperation_Kind() {
		return (EAttribute)fixedPointOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFixedPointOperation_IntermediateWordSize() {
		return (EAttribute)fixedPointOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFixedPointOperation_Saturate() {
		return (EAttribute)fixedPointOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComputationModel() {
		return computationModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputationModel_NumberFormats() {
		return (EReference)computationModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputationModel_NumberFormatMappings() {
		return (EReference)computationModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComputationModel_QualifiedName() {
		return (EAttribute)computationModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumberFormatMapping() {
		return numberFormatMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumberFormatMapping_TypeSpecifier() {
		return (EReference)numberFormatMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumberFormatMapping_NumberFormat() {
		return (EReference)numberFormatMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFloatingPointFormatKind() {
		return floatingPointFormatKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFixedPointOperationKind() {
		return fixedPointOperationKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputationModelFactory getComputationModelFactory() {
		return (ComputationModelFactory)getEFactoryInstance();
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
		floatingPointFormatEClass = createEClass(FLOATING_POINT_FORMAT);
		createEAttribute(floatingPointFormatEClass, FLOATING_POINT_FORMAT__KIND);

		numberFormatEClass = createEClass(NUMBER_FORMAT);
		createEAttribute(numberFormatEClass, NUMBER_FORMAT__NAME);

		fixedPointFormatEClass = createEClass(FIXED_POINT_FORMAT);
		createEAttribute(fixedPointFormatEClass, FIXED_POINT_FORMAT__INTEGER_LENGTH);
		createEAttribute(fixedPointFormatEClass, FIXED_POINT_FORMAT__FRACTION_LENGTH);
		createEAttribute(fixedPointFormatEClass, FIXED_POINT_FORMAT__WORD_SIZE);
		createEReference(fixedPointFormatEClass, FIXED_POINT_FORMAT__OPERATIONS);

		fixedPointOperationEClass = createEClass(FIXED_POINT_OPERATION);
		createEAttribute(fixedPointOperationEClass, FIXED_POINT_OPERATION__KIND);
		createEAttribute(fixedPointOperationEClass, FIXED_POINT_OPERATION__INTERMEDIATE_WORD_SIZE);
		createEAttribute(fixedPointOperationEClass, FIXED_POINT_OPERATION__SATURATE);

		computationModelEClass = createEClass(COMPUTATION_MODEL);
		createEAttribute(computationModelEClass, COMPUTATION_MODEL__QUALIFIED_NAME);
		createEReference(computationModelEClass, COMPUTATION_MODEL__NUMBER_FORMATS);
		createEReference(computationModelEClass, COMPUTATION_MODEL__NUMBER_FORMAT_MAPPINGS);

		numberFormatMappingEClass = createEClass(NUMBER_FORMAT_MAPPING);
		createEReference(numberFormatMappingEClass, NUMBER_FORMAT_MAPPING__TYPE_SPECIFIER);
		createEReference(numberFormatMappingEClass, NUMBER_FORMAT_MAPPING__NUMBER_FORMAT);

		// Create enums
		floatingPointFormatKindEEnum = createEEnum(FLOATING_POINT_FORMAT_KIND);
		fixedPointOperationKindEEnum = createEEnum(FIXED_POINT_OPERATION_KIND);
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
		MscriptPackage theMscriptPackage = (MscriptPackage)EPackage.Registry.INSTANCE.getEPackage(MscriptPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		floatingPointFormatEClass.getESuperTypes().add(this.getNumberFormat());
		fixedPointFormatEClass.getESuperTypes().add(this.getNumberFormat());

		// Initialize classes and features; add operations and parameters
		initEClass(floatingPointFormatEClass, FloatingPointFormat.class, "FloatingPointFormat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFloatingPointFormat_Kind(), this.getFloatingPointFormatKind(), "kind", null, 1, 1, FloatingPointFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(numberFormatEClass, NumberFormat.class, "NumberFormat", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNumberFormat_Name(), ecorePackage.getEString(), "name", null, 0, 1, NumberFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(numberFormatEClass, ecorePackage.getEBoolean(), "isEquivalentTo", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNumberFormat(), "other", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(fixedPointFormatEClass, FixedPointFormat.class, "FixedPointFormat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFixedPointFormat_IntegerLength(), ecorePackage.getEInt(), "integerLength", "1", 1, 1, FixedPointFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFixedPointFormat_FractionLength(), ecorePackage.getEInt(), "fractionLength", null, 1, 1, FixedPointFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFixedPointFormat_WordSize(), ecorePackage.getEInt(), "wordSize", null, 1, 1, FixedPointFormat.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getFixedPointFormat_Operations(), this.getFixedPointOperation(), null, "operations", null, 0, -1, FixedPointFormat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(fixedPointFormatEClass, this.getFixedPointOperation(), "getOperation", 0, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getFixedPointOperationKind(), "kind", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(fixedPointOperationEClass, FixedPointOperation.class, "FixedPointOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFixedPointOperation_Kind(), this.getFixedPointOperationKind(), "kind", null, 1, 1, FixedPointOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFixedPointOperation_IntermediateWordSize(), ecorePackage.getEInt(), "intermediateWordSize", null, 1, 1, FixedPointOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFixedPointOperation_Saturate(), ecorePackage.getEBoolean(), "saturate", null, 1, 1, FixedPointOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(computationModelEClass, ComputationModel.class, "ComputationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComputationModel_QualifiedName(), ecorePackage.getEString(), "qualifiedName", null, 0, 1, ComputationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputationModel_NumberFormats(), this.getNumberFormat(), null, "numberFormats", null, 0, -1, ComputationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComputationModel_NumberFormatMappings(), this.getNumberFormatMapping(), null, "numberFormatMappings", null, 0, -1, ComputationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(computationModelEClass, this.getNumberFormat(), "getNumberFormat", 0, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theMscriptPackage.getDataType(), "dataType", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(numberFormatMappingEClass, NumberFormatMapping.class, "NumberFormatMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNumberFormatMapping_TypeSpecifier(), theMscriptPackage.getDataTypeSpecifier(), null, "typeSpecifier", null, 0, 1, NumberFormatMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getNumberFormatMapping_NumberFormat(), this.getNumberFormat(), null, "numberFormat", null, 0, 1, NumberFormatMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(floatingPointFormatKindEEnum, FloatingPointFormatKind.class, "FloatingPointFormatKind");
		addEEnumLiteral(floatingPointFormatKindEEnum, FloatingPointFormatKind.BINARY16);
		addEEnumLiteral(floatingPointFormatKindEEnum, FloatingPointFormatKind.BINARY32);
		addEEnumLiteral(floatingPointFormatKindEEnum, FloatingPointFormatKind.BINARY64);
		addEEnumLiteral(floatingPointFormatKindEEnum, FloatingPointFormatKind.BINARY128);
		addEEnumLiteral(floatingPointFormatKindEEnum, FloatingPointFormatKind.DECIMAL32);
		addEEnumLiteral(floatingPointFormatKindEEnum, FloatingPointFormatKind.DECIMAL64);
		addEEnumLiteral(floatingPointFormatKindEEnum, FloatingPointFormatKind.DECIMAL128);

		initEEnum(fixedPointOperationKindEEnum, FixedPointOperationKind.class, "FixedPointOperationKind");
		addEEnumLiteral(fixedPointOperationKindEEnum, FixedPointOperationKind.CONSTRUCT);
		addEEnumLiteral(fixedPointOperationKindEEnum, FixedPointOperationKind.CAST);
		addEEnumLiteral(fixedPointOperationKindEEnum, FixedPointOperationKind.ADD);
		addEEnumLiteral(fixedPointOperationKindEEnum, FixedPointOperationKind.SUBTRACT);
		addEEnumLiteral(fixedPointOperationKindEEnum, FixedPointOperationKind.MULTIPLY);
		addEEnumLiteral(fixedPointOperationKindEEnum, FixedPointOperationKind.DIVIDE);

		// Create resource
		createResource(eNS_URI);
	}

} //ComputationModelPackageImpl
