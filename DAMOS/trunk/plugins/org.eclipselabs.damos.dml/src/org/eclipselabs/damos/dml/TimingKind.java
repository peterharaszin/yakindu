/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Sample Time Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.dml.DMLPackage#getTimingKind()
 * @model
 * @generated
 */
public enum TimingKind implements Enumerator {
	/**
	 * The '<em><b>Unspecified</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED_VALUE
	 * @generated
	 * @ordered
	 */
	UNSPECIFIED(0, "Unspecified", "Unspecified"),

	/**
	 * The '<em><b>Any</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANY_VALUE
	 * @generated
	 * @ordered
	 */
	ANY(1, "Any", "Any"),

	/**
	 * The '<em><b>Continuous</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTINUOUS_VALUE
	 * @generated
	 * @ordered
	 */
	CONTINUOUS(2, "Continuous", "Continuous"),

	/**
	 * The '<em><b>Synchronous</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYNCHRONOUS_VALUE
	 * @generated
	 * @ordered
	 */
	SYNCHRONOUS(3, "Synchronous", "Synchronous"), /**
	 * The '<em><b>Asynchronous</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASYNCHRONOUS_VALUE
	 * @generated
	 * @ordered
	 */
	ASYNCHRONOUS(4, "Asynchronous", "Asynchronous"), /**
	 * The '<em><b>Discrete</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISCRETE_VALUE
	 * @generated
	 * @ordered
	 */
	DISCRETE(5, "Discrete", "Discrete");

	/**
	 * The '<em><b>Unspecified</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>None</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED
	 * @model name="Unspecified"
	 * @generated
	 * @ordered
	 */
	public static final int UNSPECIFIED_VALUE = 0;

	/**
	 * The '<em><b>Any</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Any</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANY
	 * @model name="Any"
	 * @generated
	 * @ordered
	 */
	public static final int ANY_VALUE = 1;

	/**
	 * The '<em><b>Continuous</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Continuous</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTINUOUS
	 * @model name="Continuous"
	 * @generated
	 * @ordered
	 */
	public static final int CONTINUOUS_VALUE = 2;

	/**
	 * The '<em><b>Synchronous</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Discrete</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SYNCHRONOUS
	 * @model name="Synchronous"
	 * @generated
	 * @ordered
	 */
	public static final int SYNCHRONOUS_VALUE = 3;

	/**
	 * The '<em><b>Asynchronous</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Asynchronous</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ASYNCHRONOUS
	 * @model name="Asynchronous"
	 * @generated
	 * @ordered
	 */
	public static final int ASYNCHRONOUS_VALUE = 4;

	/**
	 * The '<em><b>Discrete</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Discrete</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DISCRETE
	 * @model name="Discrete"
	 * @generated
	 * @ordered
	 */
	public static final int DISCRETE_VALUE = 5;

	/**
	 * An array of all the '<em><b>Timing Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TimingKind[] VALUES_ARRAY =
		new TimingKind[] {
			UNSPECIFIED,
			ANY,
			CONTINUOUS,
			SYNCHRONOUS,
			ASYNCHRONOUS,
			DISCRETE,
		};

	/**
	 * A public read-only list of all the '<em><b>Timing Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TimingKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Timing Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TimingKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TimingKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Timing Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TimingKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TimingKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Timing Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TimingKind get(int value) {
		switch (value) {
			case UNSPECIFIED_VALUE: return UNSPECIFIED;
			case ANY_VALUE: return ANY;
			case CONTINUOUS_VALUE: return CONTINUOUS;
			case SYNCHRONOUS_VALUE: return SYNCHRONOUS;
			case ASYNCHRONOUS_VALUE: return ASYNCHRONOUS;
			case DISCRETE_VALUE: return DISCRETE;
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
	private TimingKind(int value, String name, String literal) {
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
	
} //SampleTimeKind
