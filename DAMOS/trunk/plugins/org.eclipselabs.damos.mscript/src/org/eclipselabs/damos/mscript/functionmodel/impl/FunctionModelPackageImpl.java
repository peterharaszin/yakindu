/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.functionmodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.functionmodel.ComputationCompound;
import org.eclipselabs.damos.mscript.functionmodel.EquationDescription;
import org.eclipselabs.damos.mscript.functionmodel.EquationPart;
import org.eclipselabs.damos.mscript.functionmodel.EquationSide;
import org.eclipselabs.damos.mscript.functionmodel.FunctionDescription;
import org.eclipselabs.damos.mscript.functionmodel.FunctionInstance;
import org.eclipselabs.damos.mscript.functionmodel.FunctionModelFactory;
import org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage;
import org.eclipselabs.damos.mscript.functionmodel.VariableDescription;
import org.eclipselabs.damos.mscript.functionmodel.VariableKind;
import org.eclipselabs.damos.mscript.functionmodel.VariableStep;
import org.eclipselabs.damos.mscript.functionmodel.util.FunctionModelValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FunctionModelPackageImpl extends EPackageImpl implements FunctionModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equationDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equationSideEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equationPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computationCompoundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum variableKindEEnum = null;

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
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FunctionModelPackageImpl() {
		super(eNS_URI, FunctionModelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link FunctionModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FunctionModelPackage init() {
		if (isInited) return (FunctionModelPackage)EPackage.Registry.INSTANCE.getEPackage(FunctionModelPackage.eNS_URI);

		// Obtain or create and register package
		FunctionModelPackageImpl theFunctionModelPackage = (FunctionModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FunctionModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FunctionModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		MscriptPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theFunctionModelPackage.createPackageContents();

		// Initialize created meta-data
		theFunctionModelPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theFunctionModelPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return FunctionModelValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theFunctionModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FunctionModelPackage.eNS_URI, theFunctionModelPackage);
		return theFunctionModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionDescription() {
		return functionDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionDescription_Declaration() {
		return (EReference)functionDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionDescription_EquationDescriptions() {
		return (EReference)functionDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionDescription_VariableDescriptions() {
		return (EReference)functionDescriptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEquationDescription() {
		return equationDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquationDescription_FunctionDescription() {
		return (EReference)equationDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquationDescription_Equation() {
		return (EReference)equationDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquationDescription_Sides() {
		return (EReference)equationDescriptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquationDescription_LeftHandSide() {
		return (EReference)equationDescriptionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquationDescription_RightHandSide() {
		return (EReference)equationDescriptionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEquationSide() {
		return equationSideEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquationSide_EquationDescription() {
		return (EReference)equationSideEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquationSide_Expression() {
		return (EReference)equationSideEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquationSide_Parts() {
		return (EReference)equationSideEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEquationPart() {
		return equationPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquationPart_Side() {
		return (EReference)equationPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquationPart_VariableReference() {
		return (EReference)equationPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquationPart_VariableStep() {
		return (EReference)equationPartEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableDescription() {
		return variableDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableDescription_FunctionDescription() {
		return (EReference)variableDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableDescription_Name() {
		return (EAttribute)variableDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableDescription_Kind() {
		return (EAttribute)variableDescriptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableDescription_Steps() {
		return (EReference)variableDescriptionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableStep() {
		return variableStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableStep_VariableDescription() {
		return (EReference)variableStepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableStep_Index() {
		return (EAttribute)variableStepEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableStep_Initial() {
		return (EAttribute)variableStepEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableStep_Derivative() {
		return (EAttribute)variableStepEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableStep_UsingEquationParts() {
		return (EReference)variableStepEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionInstance() {
		return functionInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionInstance_Declaration() {
		return (EReference)functionInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionInstance_InitializationCompound() {
		return (EReference)functionInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionInstance_ComputationCompounds() {
		return (EReference)functionInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComputationCompound() {
		return computationCompoundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputationCompound_Inputs() {
		return (EReference)computationCompoundEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputationCompound_Outputs() {
		return (EReference)computationCompoundEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputationCompound_Derivatives() {
		return (EReference)computationCompoundEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVariableKind() {
		return variableKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionModelFactory getFunctionModelFactory() {
		return (FunctionModelFactory)getEFactoryInstance();
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
		functionDescriptionEClass = createEClass(FUNCTION_DESCRIPTION);
		createEReference(functionDescriptionEClass, FUNCTION_DESCRIPTION__DECLARATION);
		createEReference(functionDescriptionEClass, FUNCTION_DESCRIPTION__EQUATION_DESCRIPTIONS);
		createEReference(functionDescriptionEClass, FUNCTION_DESCRIPTION__VARIABLE_DESCRIPTIONS);

		equationDescriptionEClass = createEClass(EQUATION_DESCRIPTION);
		createEReference(equationDescriptionEClass, EQUATION_DESCRIPTION__FUNCTION_DESCRIPTION);
		createEReference(equationDescriptionEClass, EQUATION_DESCRIPTION__EQUATION);
		createEReference(equationDescriptionEClass, EQUATION_DESCRIPTION__SIDES);
		createEReference(equationDescriptionEClass, EQUATION_DESCRIPTION__LEFT_HAND_SIDE);
		createEReference(equationDescriptionEClass, EQUATION_DESCRIPTION__RIGHT_HAND_SIDE);

		equationSideEClass = createEClass(EQUATION_SIDE);
		createEReference(equationSideEClass, EQUATION_SIDE__EQUATION_DESCRIPTION);
		createEReference(equationSideEClass, EQUATION_SIDE__EXPRESSION);
		createEReference(equationSideEClass, EQUATION_SIDE__PARTS);

		equationPartEClass = createEClass(EQUATION_PART);
		createEReference(equationPartEClass, EQUATION_PART__SIDE);
		createEReference(equationPartEClass, EQUATION_PART__VARIABLE_REFERENCE);
		createEReference(equationPartEClass, EQUATION_PART__VARIABLE_STEP);

		variableDescriptionEClass = createEClass(VARIABLE_DESCRIPTION);
		createEReference(variableDescriptionEClass, VARIABLE_DESCRIPTION__FUNCTION_DESCRIPTION);
		createEAttribute(variableDescriptionEClass, VARIABLE_DESCRIPTION__NAME);
		createEAttribute(variableDescriptionEClass, VARIABLE_DESCRIPTION__KIND);
		createEReference(variableDescriptionEClass, VARIABLE_DESCRIPTION__STEPS);

		variableStepEClass = createEClass(VARIABLE_STEP);
		createEReference(variableStepEClass, VARIABLE_STEP__VARIABLE_DESCRIPTION);
		createEAttribute(variableStepEClass, VARIABLE_STEP__INDEX);
		createEAttribute(variableStepEClass, VARIABLE_STEP__INITIAL);
		createEAttribute(variableStepEClass, VARIABLE_STEP__DERIVATIVE);
		createEReference(variableStepEClass, VARIABLE_STEP__USING_EQUATION_PARTS);

		functionInstanceEClass = createEClass(FUNCTION_INSTANCE);
		createEReference(functionInstanceEClass, FUNCTION_INSTANCE__DECLARATION);
		createEReference(functionInstanceEClass, FUNCTION_INSTANCE__INITIALIZATION_COMPOUND);
		createEReference(functionInstanceEClass, FUNCTION_INSTANCE__COMPUTATION_COMPOUNDS);

		computationCompoundEClass = createEClass(COMPUTATION_COMPOUND);
		createEReference(computationCompoundEClass, COMPUTATION_COMPOUND__INPUTS);
		createEReference(computationCompoundEClass, COMPUTATION_COMPOUND__OUTPUTS);
		createEReference(computationCompoundEClass, COMPUTATION_COMPOUND__DERIVATIVES);

		// Create enums
		variableKindEEnum = createEEnum(VARIABLE_KIND);
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
		computationCompoundEClass.getESuperTypes().add(theMscriptPackage.getCompoundStatement());

		// Initialize classes and features; add operations and parameters
		initEClass(functionDescriptionEClass, FunctionDescription.class, "FunctionDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionDescription_Declaration(), theMscriptPackage.getFunctionDeclaration(), null, "declaration", null, 1, 1, FunctionDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionDescription_EquationDescriptions(), this.getEquationDescription(), this.getEquationDescription_FunctionDescription(), "equationDescriptions", null, 0, -1, FunctionDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionDescription_VariableDescriptions(), this.getVariableDescription(), this.getVariableDescription_FunctionDescription(), "variableDescriptions", null, 0, -1, FunctionDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(functionDescriptionEClass, this.getVariableDescription(), "getVariableDescription", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(functionDescriptionEClass, ecorePackage.getEBoolean(), "hasNoDuplicateEquations", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(functionDescriptionEClass, ecorePackage.getEBoolean(), "hasNoCyclicEquations", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(functionDescriptionEClass, ecorePackage.getEBoolean(), "hasEquationsForEachOutput", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(functionDescriptionEClass, ecorePackage.getEBoolean(), "hasEquationsForEachVariableStep", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(equationDescriptionEClass, EquationDescription.class, "EquationDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEquationDescription_FunctionDescription(), this.getFunctionDescription(), this.getFunctionDescription_EquationDescriptions(), "functionDescription", null, 1, 1, EquationDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquationDescription_Equation(), theMscriptPackage.getEquation(), null, "equation", null, 1, 1, EquationDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquationDescription_Sides(), this.getEquationSide(), this.getEquationSide_EquationDescription(), "sides", null, 2, 2, EquationDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquationDescription_LeftHandSide(), this.getEquationSide(), null, "leftHandSide", null, 1, 1, EquationDescription.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getEquationDescription_RightHandSide(), this.getEquationSide(), null, "rightHandSide", null, 1, 1, EquationDescription.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = addEOperation(equationDescriptionEClass, ecorePackage.getEBoolean(), "isLeftHandSideValid", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(equationDescriptionEClass, ecorePackage.getEBoolean(), "isRightHandSideValid", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(equationSideEClass, EquationSide.class, "EquationSide", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEquationSide_EquationDescription(), this.getEquationDescription(), this.getEquationDescription_Sides(), "equationDescription", null, 1, 1, EquationSide.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquationSide_Expression(), theMscriptPackage.getExpression(), null, "expression", null, 1, 1, EquationSide.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquationSide_Parts(), this.getEquationPart(), this.getEquationPart_Side(), "parts", null, 0, -1, EquationSide.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(equationSideEClass, this.getEquationSide(), "getOtherSide", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(equationPartEClass, EquationPart.class, "EquationPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEquationPart_Side(), this.getEquationSide(), this.getEquationSide_Parts(), "side", null, 0, 1, EquationPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquationPart_VariableReference(), theMscriptPackage.getFeatureReference(), null, "variableReference", null, 1, 1, EquationPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquationPart_VariableStep(), this.getVariableStep(), this.getVariableStep_UsingEquationParts(), "variableStep", null, 1, 1, EquationPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableDescriptionEClass, VariableDescription.class, "VariableDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableDescription_FunctionDescription(), this.getFunctionDescription(), this.getFunctionDescription_VariableDescriptions(), "functionDescription", null, 1, 1, VariableDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariableDescription_Name(), ecorePackage.getEString(), "name", null, 0, 1, VariableDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariableDescription_Kind(), this.getVariableKind(), "kind", null, 0, 1, VariableDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableDescription_Steps(), this.getVariableStep(), this.getVariableStep_VariableDescription(), "steps", null, 0, -1, VariableDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(variableDescriptionEClass, this.getVariableStep(), "getStep", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "initial", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "derivative", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(variableDescriptionEClass, this.getVariableStep(), "getMinimumStep", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(variableDescriptionEClass, this.getVariableStep(), "getMaximumStep", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(variableStepEClass, VariableStep.class, "VariableStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableStep_VariableDescription(), this.getVariableDescription(), this.getVariableDescription_Steps(), "variableDescription", null, 0, 1, VariableStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariableStep_Index(), ecorePackage.getEInt(), "index", null, 0, 1, VariableStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariableStep_Initial(), ecorePackage.getEBoolean(), "initial", null, 0, 1, VariableStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariableStep_Derivative(), ecorePackage.getEBoolean(), "derivative", null, 0, 1, VariableStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableStep_UsingEquationParts(), this.getEquationPart(), this.getEquationPart_VariableStep(), "usingEquationParts", null, 0, -1, VariableStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionInstanceEClass, FunctionInstance.class, "FunctionInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionInstance_Declaration(), theMscriptPackage.getFunctionDeclaration(), null, "declaration", null, 1, 1, FunctionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionInstance_InitializationCompound(), theMscriptPackage.getCompoundStatement(), null, "initializationCompound", null, 0, 1, FunctionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionInstance_ComputationCompounds(), this.getComputationCompound(), null, "computationCompounds", null, 0, -1, FunctionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(computationCompoundEClass, ComputationCompound.class, "ComputationCompound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComputationCompound_Inputs(), theMscriptPackage.getInputParameterDeclaration(), null, "inputs", null, 0, -1, ComputationCompound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputationCompound_Outputs(), theMscriptPackage.getOutputParameterDeclaration(), null, "outputs", null, 0, -1, ComputationCompound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputationCompound_Derivatives(), theMscriptPackage.getVariableDeclaration(), null, "derivatives", null, 0, -1, ComputationCompound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(variableKindEEnum, VariableKind.class, "VariableKind");
		addEEnumLiteral(variableKindEEnum, VariableKind.UNKNOWN);
		addEEnumLiteral(variableKindEEnum, VariableKind.STATIC_PARAMETER);
		addEEnumLiteral(variableKindEEnum, VariableKind.INPUT_PARAMETER);
		addEEnumLiteral(variableKindEEnum, VariableKind.OUTPUT_PARAMETER);
		addEEnumLiteral(variableKindEEnum, VariableKind.STATE_VARIABLE);
		addEEnumLiteral(variableKindEEnum, VariableKind.CONSTANT);
		addEEnumLiteral(variableKindEEnum, VariableKind.FUNCTION_OBJECT);

		// Create resource
		createResource(eNS_URI);
	}

} //FunctionModelPackageImpl
