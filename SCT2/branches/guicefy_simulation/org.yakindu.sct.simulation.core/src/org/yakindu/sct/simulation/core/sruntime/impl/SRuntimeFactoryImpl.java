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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.yakindu.base.types.ITypeSystem.InferredType;
import org.yakindu.sct.simulation.core.sruntime.*;
import org.yakindu.sct.simulation.core.sruntime.RuntimeContext;
import org.yakindu.sct.simulation.core.sruntime.RuntimeEvent;
import org.yakindu.sct.simulation.core.sruntime.RuntimeVariable;
import org.yakindu.sct.simulation.core.sruntime.SRuntimeFactory;
import org.yakindu.sct.simulation.core.sruntime.SRuntimePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SRuntimeFactoryImpl extends EFactoryImpl implements SRuntimeFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SRuntimeFactory init() {
		try {
			SRuntimeFactory theSRuntimeFactory = (SRuntimeFactory)EPackage.Registry.INSTANCE.getEFactory(SRuntimePackage.eNS_URI);
			if (theSRuntimeFactory != null) {
				return theSRuntimeFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SRuntimeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SRuntimeFactoryImpl() {
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
			case SRuntimePackage.RUNTIME_CONTEXT: return createRuntimeContext();
			case SRuntimePackage.RUNTIME_EVENT: return createRuntimeEvent();
			case SRuntimePackage.RUNTIME_VARIABLE: return createRuntimeVariable();
			case SRuntimePackage.COMPOSITE_SLOT: return createCompositeSlot();
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
			case SRuntimePackage.INFERRED_TYPE:
				return createInferredTypeFromString(eDataType, initialValue);
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
			case SRuntimePackage.INFERRED_TYPE:
				return convertInferredTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeContext createRuntimeContext() {
		RuntimeContextImpl runtimeContext = new RuntimeContextImpl();
		return runtimeContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeEvent createRuntimeEvent() {
		RuntimeEventImpl runtimeEvent = new RuntimeEventImpl();
		return runtimeEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeVariable createRuntimeVariable() {
		RuntimeVariableImpl runtimeVariable = new RuntimeVariableImpl();
		return runtimeVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeSlot createCompositeSlot() {
		CompositeSlotImpl compositeSlot = new CompositeSlotImpl();
		return compositeSlot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InferredType createInferredTypeFromString(EDataType eDataType, String initialValue) {
		return (InferredType)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInferredTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SRuntimePackage getSRuntimePackage() {
		return (SRuntimePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SRuntimePackage getPackage() {
		return SRuntimePackage.eINSTANCE;
	}

} //SRuntimeFactoryImpl
