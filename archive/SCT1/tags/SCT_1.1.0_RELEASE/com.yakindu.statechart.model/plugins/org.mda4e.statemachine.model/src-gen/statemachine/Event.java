/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package statemachine;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link statemachine.Event#getTrigger <em>Trigger</em>}</li>
 * </ul>
 * </p>
 *
 * @see statemachine.StatemachinePackage#getEvent()
 * @model
 * @generated
 */
public interface Event extends DataElement {
	/**
	 * Returns the value of the '<em><b>Trigger</b></em>' attribute.
	 * The literals are from the enumeration {@link statemachine.TriggerTypes}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger</em>' attribute.
	 * @see statemachine.TriggerTypes
	 * @see #setTrigger(TriggerTypes)
	 * @see statemachine.StatemachinePackage#getEvent_Trigger()
	 * @model
	 * @generated
	 */
	TriggerTypes getTrigger();

	/**
	 * Sets the value of the '{@link statemachine.Event#getTrigger <em>Trigger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger</em>' attribute.
	 * @see statemachine.TriggerTypes
	 * @see #getTrigger()
	 * @generated
	 */
	void setTrigger(TriggerTypes value);

} // Event
