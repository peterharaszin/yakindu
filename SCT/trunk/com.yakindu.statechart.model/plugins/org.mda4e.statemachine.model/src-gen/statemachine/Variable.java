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
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link statemachine.Variable#getDataType <em>Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see statemachine.StatemachinePackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends DataElement {
	/**
	 * Returns the value of the '<em><b>Data Type</b></em>' attribute.
	 * The literals are from the enumeration {@link statemachine.DataTypes}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type</em>' attribute.
	 * @see statemachine.DataTypes
	 * @see #setDataType(DataTypes)
	 * @see statemachine.StatemachinePackage#getVariable_DataType()
	 * @model required="true"
	 * @generated
	 */
	DataTypes getDataType();

	/**
	 * Sets the value of the '{@link statemachine.Variable#getDataType <em>Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Type</em>' attribute.
	 * @see statemachine.DataTypes
	 * @see #getDataType()
	 * @generated
	 */
	void setDataType(DataTypes value);

} // Variable
