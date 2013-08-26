/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.sruntime.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.yakindu.base.base.BasePackage;

import org.yakindu.base.types.ITypeSystem.InferredType;

import org.yakindu.sct.model.sgraph.SGraphPackage;

import org.yakindu.sct.simulation.core.sruntime.CompositeSlot;
import org.yakindu.sct.simulation.core.sruntime.RuntimeContext;
import org.yakindu.sct.simulation.core.sruntime.RuntimeEvent;
import org.yakindu.sct.simulation.core.sruntime.RuntimeSlot;
import org.yakindu.sct.simulation.core.sruntime.RuntimeVariable;
import org.yakindu.sct.simulation.core.sruntime.SRuntimeFactory;
import org.yakindu.sct.simulation.core.sruntime.SRuntimePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SRuntimePackageImpl extends EPackageImpl implements SRuntimePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass runtimeContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass runtimeEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass runtimeSlotEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass runtimeVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeSlotEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType inferredTypeEDataType = null;

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
	 * @see org.yakindu.sct.simulation.core.sruntime.SRuntimePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SRuntimePackageImpl() {
		super(eNS_URI, SRuntimeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SRuntimePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SRuntimePackage init() {
		if (isInited) return (SRuntimePackage)EPackage.Registry.INSTANCE.getEPackage(SRuntimePackage.eNS_URI);

		// Obtain or create and register package
		SRuntimePackageImpl theSRuntimePackage = (SRuntimePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SRuntimePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SRuntimePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		SGraphPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSRuntimePackage.createPackageContents();

		// Initialize created meta-data
		theSRuntimePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSRuntimePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SRuntimePackage.eNS_URI, theSRuntimePackage);
		return theSRuntimePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuntimeContext() {
		return runtimeContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuntimeContext_Slots() {
		return (EReference)runtimeContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuntimeContext_ActiveStates() {
		return (EReference)runtimeContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuntimeContext_Events() {
		return (EReference)runtimeContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuntimeContext_Variables() {
		return (EReference)runtimeContextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuntimeEvent() {
		return runtimeEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuntimeEvent_Raised() {
		return (EAttribute)runtimeEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuntimeEvent_Scheduled() {
		return (EAttribute)runtimeEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuntimeSlot() {
		return runtimeSlotEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuntimeSlot_Type() {
		return (EAttribute)runtimeSlotEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuntimeSlot_Value() {
		return (EAttribute)runtimeSlotEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuntimeVariable() {
		return runtimeVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeSlot() {
		return compositeSlotEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeSlot_Slots() {
		return (EReference)compositeSlotEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getInferredType() {
		return inferredTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SRuntimeFactory getSRuntimeFactory() {
		return (SRuntimeFactory)getEFactoryInstance();
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
		runtimeContextEClass = createEClass(RUNTIME_CONTEXT);
		createEReference(runtimeContextEClass, RUNTIME_CONTEXT__SLOTS);
		createEReference(runtimeContextEClass, RUNTIME_CONTEXT__ACTIVE_STATES);
		createEReference(runtimeContextEClass, RUNTIME_CONTEXT__EVENTS);
		createEReference(runtimeContextEClass, RUNTIME_CONTEXT__VARIABLES);

		runtimeEventEClass = createEClass(RUNTIME_EVENT);
		createEAttribute(runtimeEventEClass, RUNTIME_EVENT__RAISED);
		createEAttribute(runtimeEventEClass, RUNTIME_EVENT__SCHEDULED);

		runtimeSlotEClass = createEClass(RUNTIME_SLOT);
		createEAttribute(runtimeSlotEClass, RUNTIME_SLOT__TYPE);
		createEAttribute(runtimeSlotEClass, RUNTIME_SLOT__VALUE);

		runtimeVariableEClass = createEClass(RUNTIME_VARIABLE);

		compositeSlotEClass = createEClass(COMPOSITE_SLOT);
		createEReference(compositeSlotEClass, COMPOSITE_SLOT__SLOTS);

		// Create data types
		inferredTypeEDataType = createEDataType(INFERRED_TYPE);
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
		BasePackage theBasePackage = (BasePackage)EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI);
		SGraphPackage theSGraphPackage = (SGraphPackage)EPackage.Registry.INSTANCE.getEPackage(SGraphPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		runtimeContextEClass.getESuperTypes().add(theBasePackage.getNamedElement());
		runtimeEventEClass.getESuperTypes().add(this.getRuntimeSlot());
		runtimeSlotEClass.getESuperTypes().add(theBasePackage.getNamedElement());
		runtimeVariableEClass.getESuperTypes().add(this.getRuntimeSlot());
		compositeSlotEClass.getESuperTypes().add(this.getRuntimeSlot());

		// Initialize classes and features; add operations and parameters
		initEClass(runtimeContextEClass, RuntimeContext.class, "RuntimeContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRuntimeContext_Slots(), this.getRuntimeSlot(), null, "slots", null, 0, -1, RuntimeContext.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuntimeContext_ActiveStates(), theSGraphPackage.getRegularState(), null, "activeStates", null, 0, -1, RuntimeContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuntimeContext_Events(), this.getRuntimeEvent(), null, "events", null, 0, -1, RuntimeContext.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getRuntimeContext_Variables(), this.getRuntimeVariable(), null, "variables", null, 0, -1, RuntimeContext.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		addEOperation(runtimeContextEClass, this.getRuntimeEvent(), "getRaisedEvents", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(runtimeContextEClass, this.getRuntimeEvent(), "getScheduledEvents", 0, -1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(runtimeContextEClass, this.getRuntimeVariable(), "getVariable", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(runtimeContextEClass, this.getRuntimeEvent(), "getEvent", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(runtimeEventEClass, RuntimeEvent.class, "RuntimeEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRuntimeEvent_Raised(), ecorePackage.getEBoolean(), "raised", null, 0, 1, RuntimeEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuntimeEvent_Scheduled(), ecorePackage.getEBoolean(), "scheduled", null, 0, 1, RuntimeEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(runtimeSlotEClass, RuntimeSlot.class, "RuntimeSlot", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRuntimeSlot_Type(), this.getInferredType(), "type", null, 0, 1, RuntimeSlot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuntimeSlot_Value(), ecorePackage.getEJavaObject(), "value", null, 0, 1, RuntimeSlot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(runtimeVariableEClass, RuntimeVariable.class, "RuntimeVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compositeSlotEClass, CompositeSlot.class, "CompositeSlot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeSlot_Slots(), this.getRuntimeSlot(), null, "slots", null, 0, -1, CompositeSlot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(inferredTypeEDataType, InferredType.class, "InferredType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //SRuntimePackageImpl
