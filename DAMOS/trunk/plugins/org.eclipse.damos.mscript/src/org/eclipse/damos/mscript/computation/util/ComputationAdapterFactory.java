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
/**
 */
package org.eclipse.damos.mscript.computation.util;

import org.eclipse.damos.mscript.computation.ComputationModel;
import org.eclipse.damos.mscript.computation.ComputationPackage;
import org.eclipse.damos.mscript.computation.FixedPointFormat;
import org.eclipse.damos.mscript.computation.FloatingPointFormat;
import org.eclipse.damos.mscript.computation.NumberFormat;
import org.eclipse.damos.mscript.computation.NumberFormatMapping;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.damos.mscript.computation.ComputationPackage
 * @generated
 */
public class ComputationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ComputationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ComputationPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComputationSwitch<Adapter> modelSwitch =
		new ComputationSwitch<Adapter>() {
			@Override
			public Adapter caseComputationModel(ComputationModel object) {
				return createComputationModelAdapter();
			}
			@Override
			public Adapter caseNumberFormatMapping(NumberFormatMapping object) {
				return createNumberFormatMappingAdapter();
			}
			@Override
			public Adapter caseNumberFormat(NumberFormat object) {
				return createNumberFormatAdapter();
			}
			@Override
			public Adapter caseFixedPointFormat(FixedPointFormat object) {
				return createFixedPointFormatAdapter();
			}
			@Override
			public Adapter caseFloatingPointFormat(FloatingPointFormat object) {
				return createFloatingPointFormatAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.mscript.computation.ComputationModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.mscript.computation.ComputationModel
	 * @generated
	 */
	public Adapter createComputationModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.mscript.computation.NumberFormatMapping <em>Number Format Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.mscript.computation.NumberFormatMapping
	 * @generated
	 */
	public Adapter createNumberFormatMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.mscript.computation.NumberFormat <em>Number Format</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.mscript.computation.NumberFormat
	 * @generated
	 */
	public Adapter createNumberFormatAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.mscript.computation.FixedPointFormat <em>Fixed Point Format</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.mscript.computation.FixedPointFormat
	 * @generated
	 */
	public Adapter createFixedPointFormatAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.mscript.computation.FloatingPointFormat <em>Floating Point Format</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.mscript.computation.FloatingPointFormat
	 * @generated
	 */
	public Adapter createFloatingPointFormatAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ComputationAdapterFactory
