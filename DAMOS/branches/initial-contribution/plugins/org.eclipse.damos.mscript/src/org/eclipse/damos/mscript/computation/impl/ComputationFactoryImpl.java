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
package org.eclipse.damos.mscript.computation.impl;

import org.eclipse.damos.mscript.computation.ComputationFactory;
import org.eclipse.damos.mscript.computation.ComputationModel;
import org.eclipse.damos.mscript.computation.ComputationPackage;
import org.eclipse.damos.mscript.computation.FixedPointFormat;
import org.eclipse.damos.mscript.computation.FloatingPointFormat;
import org.eclipse.damos.mscript.computation.FloatingPointFormatKind;
import org.eclipse.damos.mscript.computation.NumberFormatMapping;
import org.eclipse.damos.mscript.computation.PredefinedFixedPointFormatKind;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComputationFactoryImpl extends EFactoryImpl implements ComputationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ComputationFactory init() {
		try {
			ComputationFactory theComputationFactory = (ComputationFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/damos/mscript/2011/Computation"); 
			if (theComputationFactory != null) {
				return theComputationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ComputationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ComputationPackage.COMPUTATION_MODEL: return createComputationModel();
			case ComputationPackage.NUMBER_FORMAT_MAPPING: return createNumberFormatMapping();
			case ComputationPackage.FIXED_POINT_FORMAT: return createFixedPointFormat();
			case ComputationPackage.FLOATING_POINT_FORMAT: return createFloatingPointFormat();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ComputationPackage.PREDEFINED_FIXED_POINT_FORMAT_KIND:
				return createPredefinedFixedPointFormatKindFromString(eDataType, initialValue);
			case ComputationPackage.FLOATING_POINT_FORMAT_KIND:
				return createFloatingPointFormatKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ComputationPackage.PREDEFINED_FIXED_POINT_FORMAT_KIND:
				return convertPredefinedFixedPointFormatKindToString(eDataType, instanceValue);
			case ComputationPackage.FLOATING_POINT_FORMAT_KIND:
				return convertFloatingPointFormatKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FloatingPointFormat createFloatingPointFormat() {
		FloatingPointFormatImpl floatingPointFormat = new FloatingPointFormatImpl();
		return floatingPointFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredefinedFixedPointFormatKind createPredefinedFixedPointFormatKindFromString(EDataType eDataType, String initialValue) {
		PredefinedFixedPointFormatKind result = PredefinedFixedPointFormatKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPredefinedFixedPointFormatKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedPointFormat createFixedPointFormat() {
		FixedPointFormatImpl fixedPointFormat = new FixedPointFormatImpl();
		return fixedPointFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputationModel createComputationModel() {
		ComputationModelImpl computationModel = new ComputationModelImpl();
		return computationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberFormatMapping createNumberFormatMapping() {
		NumberFormatMappingImpl numberFormatMapping = new NumberFormatMappingImpl();
		return numberFormatMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FloatingPointFormatKind createFloatingPointFormatKindFromString(EDataType eDataType, String initialValue) {
		FloatingPointFormatKind result = FloatingPointFormatKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFloatingPointFormatKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputationPackage getComputationPackage() {
		return (ComputationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ComputationPackage getPackage() {
		return ComputationPackage.eINSTANCE;
	}

} //ComputationModelFactoryImpl
