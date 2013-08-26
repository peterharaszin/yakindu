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

import org.eclipse.emf.common.util.EList;

import org.yakindu.base.base.NamedElement;

import org.yakindu.sct.model.sgraph.RegularState;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Runtime Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.RuntimeContext#getSlots <em>Slots</em>}</li>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.RuntimeContext#getActiveStates <em>Active States</em>}</li>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.RuntimeContext#getEvents <em>Events</em>}</li>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.RuntimeContext#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.simulation.core.sruntime.SRuntimePackage#getRuntimeContext()
 * @model
 * @generated
 */
public interface RuntimeContext extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Slots</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.sct.simulation.core.sruntime.RuntimeSlot}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slots</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slots</em>' containment reference list.
	 * @see org.yakindu.sct.simulation.core.sruntime.SRuntimePackage#getRuntimeContext_Slots()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	EList<RuntimeSlot> getSlots();

	/**
	 * Returns the value of the '<em><b>Active States</b></em>' reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.sgraph.RegularState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active States</em>' reference list.
	 * @see org.yakindu.sct.simulation.core.sruntime.SRuntimePackage#getRuntimeContext_ActiveStates()
	 * @model
	 * @generated
	 */
	EList<RegularState> getActiveStates();

	/**
	 * Returns the value of the '<em><b>Events</b></em>' reference list.
	 * The list contents are of type {@link org.yakindu.sct.simulation.core.sruntime.RuntimeEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Events</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Events</em>' reference list.
	 * @see org.yakindu.sct.simulation.core.sruntime.SRuntimePackage#getRuntimeContext_Events()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<RuntimeEvent> getEvents();

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' reference list.
	 * The list contents are of type {@link org.yakindu.sct.simulation.core.sruntime.RuntimeVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' reference list.
	 * @see org.yakindu.sct.simulation.core.sruntime.SRuntimePackage#getRuntimeContext_Variables()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<RuntimeVariable> getVariables();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<RuntimeEvent> getRaisedEvents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<RuntimeEvent> getScheduledEvents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	RuntimeVariable getVariable(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	RuntimeEvent getEvent(String name);

} // RuntimeContext
