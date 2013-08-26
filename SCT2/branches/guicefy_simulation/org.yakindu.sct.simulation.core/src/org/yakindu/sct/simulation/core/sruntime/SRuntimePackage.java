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
package org.yakindu.sct.simulation.core.sruntime;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.yakindu.base.base.BasePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.yakindu.sct.simulation.core.sruntime.SRuntimeFactory
 * @model kind="package"
 * @generated
 */
public interface SRuntimePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sruntime";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.yakindu.org/sct/sruntime/2.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sruntime";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SRuntimePackage eINSTANCE = org.yakindu.sct.simulation.core.sruntime.impl.SRuntimePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.yakindu.sct.simulation.core.sruntime.impl.RuntimeContextImpl <em>Runtime Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.simulation.core.sruntime.impl.RuntimeContextImpl
	 * @see org.yakindu.sct.simulation.core.sruntime.impl.SRuntimePackageImpl#getRuntimeContext()
	 * @generated
	 */
	int RUNTIME_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_CONTEXT__NAME = BasePackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Slots</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_CONTEXT__SLOTS = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Active States</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_CONTEXT__ACTIVE_STATES = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Events</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_CONTEXT__EVENTS = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_CONTEXT__VARIABLES = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Runtime Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_CONTEXT_FEATURE_COUNT = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.simulation.core.sruntime.impl.RuntimeSlotImpl <em>Runtime Slot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.simulation.core.sruntime.impl.RuntimeSlotImpl
	 * @see org.yakindu.sct.simulation.core.sruntime.impl.SRuntimePackageImpl#getRuntimeSlot()
	 * @generated
	 */
	int RUNTIME_SLOT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_SLOT__NAME = BasePackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_SLOT__TYPE = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_SLOT__VALUE = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Runtime Slot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_SLOT_FEATURE_COUNT = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.simulation.core.sruntime.impl.RuntimeEventImpl <em>Runtime Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.simulation.core.sruntime.impl.RuntimeEventImpl
	 * @see org.yakindu.sct.simulation.core.sruntime.impl.SRuntimePackageImpl#getRuntimeEvent()
	 * @generated
	 */
	int RUNTIME_EVENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_EVENT__NAME = RUNTIME_SLOT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_EVENT__TYPE = RUNTIME_SLOT__TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_EVENT__VALUE = RUNTIME_SLOT__VALUE;

	/**
	 * The feature id for the '<em><b>Raised</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_EVENT__RAISED = RUNTIME_SLOT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scheduled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_EVENT__SCHEDULED = RUNTIME_SLOT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Runtime Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_EVENT_FEATURE_COUNT = RUNTIME_SLOT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.simulation.core.sruntime.impl.RuntimeVariableImpl <em>Runtime Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.simulation.core.sruntime.impl.RuntimeVariableImpl
	 * @see org.yakindu.sct.simulation.core.sruntime.impl.SRuntimePackageImpl#getRuntimeVariable()
	 * @generated
	 */
	int RUNTIME_VARIABLE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_VARIABLE__NAME = RUNTIME_SLOT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_VARIABLE__TYPE = RUNTIME_SLOT__TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_VARIABLE__VALUE = RUNTIME_SLOT__VALUE;

	/**
	 * The number of structural features of the '<em>Runtime Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_VARIABLE_FEATURE_COUNT = RUNTIME_SLOT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.simulation.core.sruntime.impl.CompositeSlotImpl <em>Composite Slot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.simulation.core.sruntime.impl.CompositeSlotImpl
	 * @see org.yakindu.sct.simulation.core.sruntime.impl.SRuntimePackageImpl#getCompositeSlot()
	 * @generated
	 */
	int COMPOSITE_SLOT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SLOT__NAME = RUNTIME_SLOT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SLOT__TYPE = RUNTIME_SLOT__TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SLOT__VALUE = RUNTIME_SLOT__VALUE;

	/**
	 * The feature id for the '<em><b>Slots</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SLOT__SLOTS = RUNTIME_SLOT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Slot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SLOT_FEATURE_COUNT = RUNTIME_SLOT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '<em>Inferred Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.types.ITypeSystem.InferredType
	 * @see org.yakindu.sct.simulation.core.sruntime.impl.SRuntimePackageImpl#getInferredType()
	 * @generated
	 */
	int INFERRED_TYPE = 5;


	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.simulation.core.sruntime.RuntimeContext <em>Runtime Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Runtime Context</em>'.
	 * @see org.yakindu.sct.simulation.core.sruntime.RuntimeContext
	 * @generated
	 */
	EClass getRuntimeContext();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.simulation.core.sruntime.RuntimeContext#getSlots <em>Slots</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Slots</em>'.
	 * @see org.yakindu.sct.simulation.core.sruntime.RuntimeContext#getSlots()
	 * @see #getRuntimeContext()
	 * @generated
	 */
	EReference getRuntimeContext_Slots();

	/**
	 * Returns the meta object for the reference list '{@link org.yakindu.sct.simulation.core.sruntime.RuntimeContext#getActiveStates <em>Active States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Active States</em>'.
	 * @see org.yakindu.sct.simulation.core.sruntime.RuntimeContext#getActiveStates()
	 * @see #getRuntimeContext()
	 * @generated
	 */
	EReference getRuntimeContext_ActiveStates();

	/**
	 * Returns the meta object for the reference list '{@link org.yakindu.sct.simulation.core.sruntime.RuntimeContext#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Events</em>'.
	 * @see org.yakindu.sct.simulation.core.sruntime.RuntimeContext#getEvents()
	 * @see #getRuntimeContext()
	 * @generated
	 */
	EReference getRuntimeContext_Events();

	/**
	 * Returns the meta object for the reference list '{@link org.yakindu.sct.simulation.core.sruntime.RuntimeContext#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Variables</em>'.
	 * @see org.yakindu.sct.simulation.core.sruntime.RuntimeContext#getVariables()
	 * @see #getRuntimeContext()
	 * @generated
	 */
	EReference getRuntimeContext_Variables();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.simulation.core.sruntime.RuntimeEvent <em>Runtime Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Runtime Event</em>'.
	 * @see org.yakindu.sct.simulation.core.sruntime.RuntimeEvent
	 * @generated
	 */
	EClass getRuntimeEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.simulation.core.sruntime.RuntimeEvent#isRaised <em>Raised</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Raised</em>'.
	 * @see org.yakindu.sct.simulation.core.sruntime.RuntimeEvent#isRaised()
	 * @see #getRuntimeEvent()
	 * @generated
	 */
	EAttribute getRuntimeEvent_Raised();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.simulation.core.sruntime.RuntimeEvent#isScheduled <em>Scheduled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scheduled</em>'.
	 * @see org.yakindu.sct.simulation.core.sruntime.RuntimeEvent#isScheduled()
	 * @see #getRuntimeEvent()
	 * @generated
	 */
	EAttribute getRuntimeEvent_Scheduled();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.simulation.core.sruntime.RuntimeSlot <em>Runtime Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Runtime Slot</em>'.
	 * @see org.yakindu.sct.simulation.core.sruntime.RuntimeSlot
	 * @generated
	 */
	EClass getRuntimeSlot();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.simulation.core.sruntime.RuntimeSlot#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.yakindu.sct.simulation.core.sruntime.RuntimeSlot#getType()
	 * @see #getRuntimeSlot()
	 * @generated
	 */
	EAttribute getRuntimeSlot_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.simulation.core.sruntime.RuntimeSlot#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.yakindu.sct.simulation.core.sruntime.RuntimeSlot#getValue()
	 * @see #getRuntimeSlot()
	 * @generated
	 */
	EAttribute getRuntimeSlot_Value();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.simulation.core.sruntime.RuntimeVariable <em>Runtime Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Runtime Variable</em>'.
	 * @see org.yakindu.sct.simulation.core.sruntime.RuntimeVariable
	 * @generated
	 */
	EClass getRuntimeVariable();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.simulation.core.sruntime.CompositeSlot <em>Composite Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Slot</em>'.
	 * @see org.yakindu.sct.simulation.core.sruntime.CompositeSlot
	 * @generated
	 */
	EClass getCompositeSlot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.simulation.core.sruntime.CompositeSlot#getSlots <em>Slots</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Slots</em>'.
	 * @see org.yakindu.sct.simulation.core.sruntime.CompositeSlot#getSlots()
	 * @see #getCompositeSlot()
	 * @generated
	 */
	EReference getCompositeSlot_Slots();

	/**
	 * Returns the meta object for data type '{@link org.yakindu.base.types.ITypeSystem.InferredType <em>Inferred Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Inferred Type</em>'.
	 * @see org.yakindu.base.types.ITypeSystem.InferredType
	 * @model instanceClass="org.yakindu.base.types.ITypeSystem.InferredType"
	 * @generated
	 */
	EDataType getInferredType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SRuntimeFactory getSRuntimeFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.yakindu.sct.simulation.core.sruntime.impl.RuntimeContextImpl <em>Runtime Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.simulation.core.sruntime.impl.RuntimeContextImpl
		 * @see org.yakindu.sct.simulation.core.sruntime.impl.SRuntimePackageImpl#getRuntimeContext()
		 * @generated
		 */
		EClass RUNTIME_CONTEXT = eINSTANCE.getRuntimeContext();

		/**
		 * The meta object literal for the '<em><b>Slots</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUNTIME_CONTEXT__SLOTS = eINSTANCE.getRuntimeContext_Slots();

		/**
		 * The meta object literal for the '<em><b>Active States</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUNTIME_CONTEXT__ACTIVE_STATES = eINSTANCE.getRuntimeContext_ActiveStates();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUNTIME_CONTEXT__EVENTS = eINSTANCE.getRuntimeContext_Events();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUNTIME_CONTEXT__VARIABLES = eINSTANCE.getRuntimeContext_Variables();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.simulation.core.sruntime.impl.RuntimeEventImpl <em>Runtime Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.simulation.core.sruntime.impl.RuntimeEventImpl
		 * @see org.yakindu.sct.simulation.core.sruntime.impl.SRuntimePackageImpl#getRuntimeEvent()
		 * @generated
		 */
		EClass RUNTIME_EVENT = eINSTANCE.getRuntimeEvent();

		/**
		 * The meta object literal for the '<em><b>Raised</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUNTIME_EVENT__RAISED = eINSTANCE.getRuntimeEvent_Raised();

		/**
		 * The meta object literal for the '<em><b>Scheduled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUNTIME_EVENT__SCHEDULED = eINSTANCE.getRuntimeEvent_Scheduled();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.simulation.core.sruntime.impl.RuntimeSlotImpl <em>Runtime Slot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.simulation.core.sruntime.impl.RuntimeSlotImpl
		 * @see org.yakindu.sct.simulation.core.sruntime.impl.SRuntimePackageImpl#getRuntimeSlot()
		 * @generated
		 */
		EClass RUNTIME_SLOT = eINSTANCE.getRuntimeSlot();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUNTIME_SLOT__TYPE = eINSTANCE.getRuntimeSlot_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUNTIME_SLOT__VALUE = eINSTANCE.getRuntimeSlot_Value();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.simulation.core.sruntime.impl.RuntimeVariableImpl <em>Runtime Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.simulation.core.sruntime.impl.RuntimeVariableImpl
		 * @see org.yakindu.sct.simulation.core.sruntime.impl.SRuntimePackageImpl#getRuntimeVariable()
		 * @generated
		 */
		EClass RUNTIME_VARIABLE = eINSTANCE.getRuntimeVariable();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.simulation.core.sruntime.impl.CompositeSlotImpl <em>Composite Slot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.simulation.core.sruntime.impl.CompositeSlotImpl
		 * @see org.yakindu.sct.simulation.core.sruntime.impl.SRuntimePackageImpl#getCompositeSlot()
		 * @generated
		 */
		EClass COMPOSITE_SLOT = eINSTANCE.getCompositeSlot();

		/**
		 * The meta object literal for the '<em><b>Slots</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_SLOT__SLOTS = eINSTANCE.getCompositeSlot_Slots();

		/**
		 * The meta object literal for the '<em>Inferred Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.types.ITypeSystem.InferredType
		 * @see org.yakindu.sct.simulation.core.sruntime.impl.SRuntimePackageImpl#getInferredType()
		 * @generated
		 */
		EDataType INFERRED_TYPE = eINSTANCE.getInferredType();

	}

} //SRuntimePackage
