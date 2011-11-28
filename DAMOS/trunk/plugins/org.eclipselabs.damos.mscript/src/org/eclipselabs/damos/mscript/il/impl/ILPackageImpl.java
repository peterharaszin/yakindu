/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.il.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.il.ComputationCompound;
import org.eclipselabs.damos.mscript.il.ILFactory;
import org.eclipselabs.damos.mscript.il.ILFunctionDefinition;
import org.eclipselabs.damos.mscript.il.ILPackage;
import org.eclipselabs.damos.mscript.il.InputVariableDeclaration;
import org.eclipselabs.damos.mscript.il.InstanceVariableDeclaration;
import org.eclipselabs.damos.mscript.il.InvalidExpression;
import org.eclipselabs.damos.mscript.il.OutputVariableDeclaration;
import org.eclipselabs.damos.mscript.il.StatefulVariableDeclaration;
import org.eclipselabs.damos.mscript.il.TemplateVariableDeclaration;
import org.eclipselabs.damos.mscript.il.VariableDeclarationInfo;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ILPackageImpl extends EPackageImpl implements ILPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ilFunctionDefinitionEClass = null;

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
	private EClass variableDeclarationInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statefulVariableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateVariableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputVariableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputVariableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceVariableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invalidExpressionEClass = null;

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
	 * @see org.eclipselabs.damos.mscript.il.ILPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ILPackageImpl() {
		super(eNS_URI, ILFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ILPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ILPackage init() {
		if (isInited) return (ILPackage)EPackage.Registry.INSTANCE.getEPackage(ILPackage.eNS_URI);

		// Obtain or create and register package
		ILPackageImpl theILPackage = (ILPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ILPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ILPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		MscriptPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theILPackage.createPackageContents();

		// Initialize created meta-data
		theILPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theILPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ILPackage.eNS_URI, theILPackage);
		return theILPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getILFunctionDefinition() {
		return ilFunctionDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getILFunctionDefinition_FunctionDefinition() {
		return (EReference)ilFunctionDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getILFunctionDefinition_Stateful() {
		return (EAttribute)ilFunctionDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getILFunctionDefinition_Name() {
		return (EAttribute)ilFunctionDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getILFunctionDefinition_TemplateVariableDeclarations() {
		return (EReference)ilFunctionDefinitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getILFunctionDefinition_InputVariableDeclarations() {
		return (EReference)ilFunctionDefinitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getILFunctionDefinition_OutputVariableDeclarations() {
		return (EReference)ilFunctionDefinitionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getILFunctionDefinition_InstanceVariableDeclarations() {
		return (EReference)ilFunctionDefinitionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getILFunctionDefinition_InitializationCompound() {
		return (EReference)ilFunctionDefinitionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getILFunctionDefinition_ComputationCompounds() {
		return (EReference)ilFunctionDefinitionEClass.getEStructuralFeatures().get(8);
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
	public EClass getVariableDeclarationInfo() {
		return variableDeclarationInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableDeclarationInfo_VariableDeclaration() {
		return (EReference)variableDeclarationInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStatefulVariableDeclaration() {
		return statefulVariableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateVariableDeclaration() {
		return templateVariableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputVariableDeclaration() {
		return inputVariableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputVariableDeclaration() {
		return outputVariableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceVariableDeclaration() {
		return instanceVariableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvalidExpression() {
		return invalidExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ILFactory getILFactory() {
		return (ILFactory)getEFactoryInstance();
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
		ilFunctionDefinitionEClass = createEClass(IL_FUNCTION_DEFINITION);
		createEReference(ilFunctionDefinitionEClass, IL_FUNCTION_DEFINITION__FUNCTION_DEFINITION);
		createEAttribute(ilFunctionDefinitionEClass, IL_FUNCTION_DEFINITION__STATEFUL);
		createEAttribute(ilFunctionDefinitionEClass, IL_FUNCTION_DEFINITION__NAME);
		createEReference(ilFunctionDefinitionEClass, IL_FUNCTION_DEFINITION__TEMPLATE_VARIABLE_DECLARATIONS);
		createEReference(ilFunctionDefinitionEClass, IL_FUNCTION_DEFINITION__INPUT_VARIABLE_DECLARATIONS);
		createEReference(ilFunctionDefinitionEClass, IL_FUNCTION_DEFINITION__OUTPUT_VARIABLE_DECLARATIONS);
		createEReference(ilFunctionDefinitionEClass, IL_FUNCTION_DEFINITION__INSTANCE_VARIABLE_DECLARATIONS);
		createEReference(ilFunctionDefinitionEClass, IL_FUNCTION_DEFINITION__INITIALIZATION_COMPOUND);
		createEReference(ilFunctionDefinitionEClass, IL_FUNCTION_DEFINITION__COMPUTATION_COMPOUNDS);

		computationCompoundEClass = createEClass(COMPUTATION_COMPOUND);
		createEReference(computationCompoundEClass, COMPUTATION_COMPOUND__INPUTS);
		createEReference(computationCompoundEClass, COMPUTATION_COMPOUND__OUTPUTS);

		variableDeclarationInfoEClass = createEClass(VARIABLE_DECLARATION_INFO);
		createEReference(variableDeclarationInfoEClass, VARIABLE_DECLARATION_INFO__VARIABLE_DECLARATION);

		statefulVariableDeclarationEClass = createEClass(STATEFUL_VARIABLE_DECLARATION);

		templateVariableDeclarationEClass = createEClass(TEMPLATE_VARIABLE_DECLARATION);

		inputVariableDeclarationEClass = createEClass(INPUT_VARIABLE_DECLARATION);

		outputVariableDeclarationEClass = createEClass(OUTPUT_VARIABLE_DECLARATION);

		instanceVariableDeclarationEClass = createEClass(INSTANCE_VARIABLE_DECLARATION);

		invalidExpressionEClass = createEClass(INVALID_EXPRESSION);
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
		computationCompoundEClass.getESuperTypes().add(theMscriptPackage.getCompound());
		statefulVariableDeclarationEClass.getESuperTypes().add(this.getVariableDeclarationInfo());
		templateVariableDeclarationEClass.getESuperTypes().add(this.getVariableDeclarationInfo());
		inputVariableDeclarationEClass.getESuperTypes().add(this.getStatefulVariableDeclaration());
		outputVariableDeclarationEClass.getESuperTypes().add(this.getStatefulVariableDeclaration());
		instanceVariableDeclarationEClass.getESuperTypes().add(this.getStatefulVariableDeclaration());
		invalidExpressionEClass.getESuperTypes().add(theMscriptPackage.getExpression());

		// Initialize classes and features; add operations and parameters
		initEClass(ilFunctionDefinitionEClass, ILFunctionDefinition.class, "ILFunctionDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getILFunctionDefinition_FunctionDefinition(), theMscriptPackage.getFunctionDefinition(), null, "functionDefinition", null, 1, 1, ILFunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getILFunctionDefinition_Stateful(), ecorePackage.getEBoolean(), "stateful", null, 1, 1, ILFunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getILFunctionDefinition_Name(), ecorePackage.getEString(), "name", null, 1, 1, ILFunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getILFunctionDefinition_TemplateVariableDeclarations(), this.getTemplateVariableDeclaration(), null, "templateVariableDeclarations", null, 0, -1, ILFunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getILFunctionDefinition_InputVariableDeclarations(), this.getInputVariableDeclaration(), null, "inputVariableDeclarations", null, 0, -1, ILFunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getILFunctionDefinition_OutputVariableDeclarations(), this.getOutputVariableDeclaration(), null, "outputVariableDeclarations", null, 0, -1, ILFunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getILFunctionDefinition_InstanceVariableDeclarations(), this.getInstanceVariableDeclaration(), null, "instanceVariableDeclarations", null, 0, -1, ILFunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getILFunctionDefinition_InitializationCompound(), theMscriptPackage.getCompound(), null, "initializationCompound", null, 0, 1, ILFunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getILFunctionDefinition_ComputationCompounds(), this.getComputationCompound(), null, "computationCompounds", null, 0, -1, ILFunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(computationCompoundEClass, ComputationCompound.class, "ComputationCompound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComputationCompound_Inputs(), theMscriptPackage.getInputParameterDeclaration(), null, "inputs", null, 0, -1, ComputationCompound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputationCompound_Outputs(), theMscriptPackage.getOutputParameterDeclaration(), null, "outputs", null, 0, -1, ComputationCompound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableDeclarationInfoEClass, VariableDeclarationInfo.class, "VariableDeclarationInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableDeclarationInfo_VariableDeclaration(), theMscriptPackage.getVariableDeclaration(), null, "variableDeclaration", null, 0, 1, VariableDeclarationInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statefulVariableDeclarationEClass, StatefulVariableDeclaration.class, "StatefulVariableDeclaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(templateVariableDeclarationEClass, TemplateVariableDeclaration.class, "TemplateVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inputVariableDeclarationEClass, InputVariableDeclaration.class, "InputVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(outputVariableDeclarationEClass, OutputVariableDeclaration.class, "OutputVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(instanceVariableDeclarationEClass, InstanceVariableDeclaration.class, "InstanceVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(invalidExpressionEClass, InvalidExpression.class, "InvalidExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ILPackageImpl
