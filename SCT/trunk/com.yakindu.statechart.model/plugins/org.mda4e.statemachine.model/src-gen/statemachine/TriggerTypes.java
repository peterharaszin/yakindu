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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Trigger Types</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see statemachine.StatemachinePackage#getTriggerTypes()
 * @model
 * @generated
 */
public enum TriggerTypes implements Enumerator {
	/**
	 * The '<em><b>Either</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EITHER_VALUE
	 * @generated
	 * @ordered
	 */
	EITHER(0, "either", "either"),

	/**
	 * The '<em><b>Rising</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RISING_VALUE
	 * @generated
	 * @ordered
	 */
	RISING(1, "rising", "rising"),

	/**
	 * The '<em><b>Falling</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FALLING_VALUE
	 * @generated
	 * @ordered
	 */
	FALLING(2, "falling", "falling"),

	/**
	 * The '<em><b>Function Call</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FUNCTION_CALL_VALUE
	 * @generated
	 * @ordered
	 */
	FUNCTION_CALL(3, "functionCall", "functionCall");

	/**
	 * The '<em><b>Either</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Either</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EITHER
	 * @model name="either"
	 * @generated
	 * @ordered
	 */
	public static final int EITHER_VALUE = 0;

	/**
	 * The '<em><b>Rising</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Rising</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RISING
	 * @model name="rising"
	 * @generated
	 * @ordered
	 */
	public static final int RISING_VALUE = 1;

	/**
	 * The '<em><b>Falling</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Falling</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FALLING
	 * @model name="falling"
	 * @generated
	 * @ordered
	 */
	public static final int FALLING_VALUE = 2;

	/**
	 * The '<em><b>Function Call</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Function Call</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FUNCTION_CALL
	 * @model name="functionCall"
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTION_CALL_VALUE = 3;

	/**
	 * An array of all the '<em><b>Trigger Types</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TriggerTypes[] VALUES_ARRAY =
		new TriggerTypes[] {
			EITHER,
			RISING,
			FALLING,
			FUNCTION_CALL,
		};

	/**
	 * A public read-only list of all the '<em><b>Trigger Types</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TriggerTypes> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Trigger Types</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TriggerTypes get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TriggerTypes result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Trigger Types</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TriggerTypes getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TriggerTypes result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Trigger Types</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TriggerTypes get(int value) {
		switch (value) {
			case EITHER_VALUE: return EITHER;
			case RISING_VALUE: return RISING;
			case FALLING_VALUE: return FALLING;
			case FUNCTION_CALL_VALUE: return FUNCTION_CALL;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TriggerTypes(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //TriggerTypes
