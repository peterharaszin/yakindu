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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Runtime Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.RuntimeEvent#isRaised <em>Raised</em>}</li>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.RuntimeEvent#isScheduled <em>Scheduled</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.simulation.core.sruntime.SRuntimePackage#getRuntimeEvent()
 * @model
 * @generated
 */
public interface RuntimeEvent extends RuntimeSlot {
	/**
	 * Returns the value of the '<em><b>Raised</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raised</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raised</em>' attribute.
	 * @see #setRaised(boolean)
	 * @see org.yakindu.sct.simulation.core.sruntime.SRuntimePackage#getRuntimeEvent_Raised()
	 * @model
	 * @generated
	 */
	boolean isRaised();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.simulation.core.sruntime.RuntimeEvent#isRaised <em>Raised</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raised</em>' attribute.
	 * @see #isRaised()
	 * @generated
	 */
	void setRaised(boolean value);

	/**
	 * Returns the value of the '<em><b>Scheduled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scheduled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scheduled</em>' attribute.
	 * @see #setScheduled(boolean)
	 * @see org.yakindu.sct.simulation.core.sruntime.SRuntimePackage#getRuntimeEvent_Scheduled()
	 * @model
	 * @generated
	 */
	boolean isScheduled();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.simulation.core.sruntime.RuntimeEvent#isScheduled <em>Scheduled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scheduled</em>' attribute.
	 * @see #isScheduled()
	 * @generated
	 */
	void setScheduled(boolean value);

} // RuntimeEvent
