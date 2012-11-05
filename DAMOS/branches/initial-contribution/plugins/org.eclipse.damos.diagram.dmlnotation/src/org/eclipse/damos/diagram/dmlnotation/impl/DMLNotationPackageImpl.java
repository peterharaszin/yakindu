/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.diagram.dmlnotation.impl;

import org.eclipse.damos.diagram.dmlnotation.DMLNotationFactory;
import org.eclipse.damos.diagram.dmlnotation.DMLNotationPackage;
import org.eclipse.damos.diagram.dmlnotation.FlippableBounds;
import org.eclipse.damos.diagram.dmlnotation.RotatableBounds;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.gmf.runtime.notation.NotationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DMLNotationPackageImpl extends EPackageImpl implements DMLNotationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flippableBoundsEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rotatableBoundsEClass = null;
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
	 * @see org.eclipse.damos.diagram.dmlnotation.DMLNotationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DMLNotationPackageImpl() {
		super(eNS_URI, DMLNotationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DMLNotationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DMLNotationPackage init() {
		if (isInited) return (DMLNotationPackage)EPackage.Registry.INSTANCE.getEPackage(DMLNotationPackage.eNS_URI);

		// Obtain or create and register package
		DMLNotationPackageImpl theDMLNotationPackage = (DMLNotationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DMLNotationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DMLNotationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		NotationPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDMLNotationPackage.createPackageContents();

		// Initialize created meta-data
		theDMLNotationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDMLNotationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DMLNotationPackage.eNS_URI, theDMLNotationPackage);
		return theDMLNotationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlippableBounds() {
		return flippableBoundsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFlippableBounds_Flipped() {
		return (EAttribute)flippableBoundsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRotatableBounds() {
		return rotatableBoundsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRotatableBounds_Rotation() {
		return (EAttribute)rotatableBoundsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DMLNotationFactory getDMLNotationFactory() {
		return (DMLNotationFactory)getEFactoryInstance();
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
		flippableBoundsEClass = createEClass(FLIPPABLE_BOUNDS);
		createEAttribute(flippableBoundsEClass, FLIPPABLE_BOUNDS__FLIPPED);

		rotatableBoundsEClass = createEClass(ROTATABLE_BOUNDS);
		createEAttribute(rotatableBoundsEClass, ROTATABLE_BOUNDS__ROTATION);
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
		NotationPackage theNotationPackage = (NotationPackage)EPackage.Registry.INSTANCE.getEPackage(NotationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		flippableBoundsEClass.getESuperTypes().add(theNotationPackage.getBounds());
		rotatableBoundsEClass.getESuperTypes().add(this.getFlippableBounds());

		// Initialize classes and features; add operations and parameters
		initEClass(flippableBoundsEClass, FlippableBounds.class, "FlippableBounds", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFlippableBounds_Flipped(), ecorePackage.getEBoolean(), "flipped", null, 0, 1, FlippableBounds.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rotatableBoundsEClass, RotatableBounds.class, "RotatableBounds", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRotatableBounds_Rotation(), ecorePackage.getEInt(), "rotation", null, 0, 1, RotatableBounds.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //DMLNotationPackageImpl
