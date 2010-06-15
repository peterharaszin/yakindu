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
 * A representation of the model object '<em><b>Pseudostate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link statemachine.Pseudostate#getPseudoType <em>Pseudo Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see statemachine.StatemachinePackage#getPseudostate()
 * @model
 * @generated
 */
public interface Pseudostate extends Node {
	/**
	 * Returns the value of the '<em><b>Pseudo Type</b></em>' attribute.
	 * The literals are from the enumeration {@link statemachine.PseudoTypes}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pseudo Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pseudo Type</em>' attribute.
	 * @see statemachine.PseudoTypes
	 * @see #setPseudoType(PseudoTypes)
	 * @see statemachine.StatemachinePackage#getPseudostate_PseudoType()
	 * @model required="true"
	 * @generated
	 */
	PseudoTypes getPseudoType();

	/**
	 * Sets the value of the '{@link statemachine.Pseudostate#getPseudoType <em>Pseudo Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pseudo Type</em>' attribute.
	 * @see statemachine.PseudoTypes
	 * @see #getPseudoType()
	 * @generated
	 */
	void setPseudoType(PseudoTypes value);

} // Pseudostate
