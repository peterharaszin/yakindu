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
import org.eclipselabs.damos.mscript.il.InvalidExpression;

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
	public EReference getILFunctionDefinition_InitializationCompound() {
		return (EReference)ilFunctionDefinitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getILFunctionDefinition_ComputationCompounds() {
		return (EReference)ilFunctionDefinitionEClass.getEStructuralFeatures().get(4);
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
		createEReference(ilFunctionDefinitionEClass, IL_FUNCTION_DEFINITION__INITIALIZATION_COMPOUND);
		createEReference(ilFunctionDefinitionEClass, IL_FUNCTION_DEFINITION__COMPUTATION_COMPOUNDS);

		computationCompoundEClass = createEClass(COMPUTATION_COMPOUND);
		createEReference(computationCompoundEClass, COMPUTATION_COMPOUND__INPUTS);
		createEReference(computationCompoundEClass, COMPUTATION_COMPOUND__OUTPUTS);

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
		invalidExpressionEClass.getESuperTypes().add(theMscriptPackage.getExpression());

		// Initialize classes and features; add operations and parameters
		initEClass(ilFunctionDefinitionEClass, ILFunctionDefinition.class, "ILFunctionDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getILFunctionDefinition_FunctionDefinition(), theMscriptPackage.getFunctionDefinition(), null, "functionDefinition", null, 1, 1, ILFunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getILFunctionDefinition_Stateful(), ecorePackage.getEBoolean(), "stateful", null, 1, 1, ILFunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getILFunctionDefinition_Name(), ecorePackage.getEString(), "name", null, 1, 1, ILFunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getILFunctionDefinition_InitializationCompound(), theMscriptPackage.getCompound(), null, "initializationCompound", null, 0, 1, ILFunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getILFunctionDefinition_ComputationCompounds(), this.getComputationCompound(), null, "computationCompounds", null, 0, -1, ILFunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(computationCompoundEClass, ComputationCompound.class, "ComputationCompound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComputationCompound_Inputs(), theMscriptPackage.getInputParameterDeclaration(), null, "inputs", null, 0, -1, ComputationCompound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputationCompound_Outputs(), theMscriptPackage.getOutputParameterDeclaration(), null, "outputs", null, 0, -1, ComputationCompound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(invalidExpressionEClass, InvalidExpression.class, "InvalidExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ILPackageImpl
