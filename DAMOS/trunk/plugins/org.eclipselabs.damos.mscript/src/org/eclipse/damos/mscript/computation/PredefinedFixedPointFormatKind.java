/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.mscript.computation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Predefined Fixed Point Format Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.damos.mscript.computation.ComputationPackage#getPredefinedFixedPointFormatKind()
 * @model
 * @generated
 */
public enum PredefinedFixedPointFormatKind implements Enumerator {
	/**
	 * The '<em><b>None</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONE_VALUE
	 * @generated
	 * @ordered
	 */
	NONE(0, "None", "None"),

	/**
	 * The '<em><b>Int8</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INT8_VALUE
	 * @generated
	 * @ordered
	 */
	INT8(1, "Int8", "Int8"),

	/**
	 * The '<em><b>Int16</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INT16_VALUE
	 * @generated
	 * @ordered
	 */
	INT16(2, "Int16", "Int16"),

	/**
	 * The '<em><b>Int32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INT32_VALUE
	 * @generated
	 * @ordered
	 */
	INT32(3, "Int32", "Int32"),

	/**
	 * The '<em><b>Int64</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INT64_VALUE
	 * @generated
	 * @ordered
	 */
	INT64(4, "Int64", "Int64"),

	/**
	 * The '<em><b>Int128</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INT128_VALUE
	 * @generated
	 * @ordered
	 */
	INT128(5, "Int128", "Int128"),

	/**
	 * The '<em><b>UInt8</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UINT8_VALUE
	 * @generated
	 * @ordered
	 */
	UINT8(6, "UInt8", "UInt8"),

	/**
	 * The '<em><b>UInt16</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UINT16_VALUE
	 * @generated
	 * @ordered
	 */
	UINT16(7, "UInt16", "UInt16"),

	/**
	 * The '<em><b>UInt32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UINT32_VALUE
	 * @generated
	 * @ordered
	 */
	UINT32(8, "UInt32", "UInt32"),

	/**
	 * The '<em><b>UInt64</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UINT64_VALUE
	 * @generated
	 * @ordered
	 */
	UINT64(9, "UInt64", "UInt64"),

	/**
	 * The '<em><b>UInt128</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UINT128_VALUE
	 * @generated
	 * @ordered
	 */
	UINT128(10, "UInt128", "UInt128"),

	/**
	 * The '<em><b>Fract8</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRACT8_VALUE
	 * @generated
	 * @ordered
	 */
	FRACT8(11, "Fract8", "Fract8"),

	/**
	 * The '<em><b>Fract16</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRACT16_VALUE
	 * @generated
	 * @ordered
	 */
	FRACT16(12, "Fract16", "Fract16"),

	/**
	 * The '<em><b>Fract32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRACT32_VALUE
	 * @generated
	 * @ordered
	 */
	FRACT32(13, "Fract32", "Fract32"),

	/**
	 * The '<em><b>Fract64</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRACT64_VALUE
	 * @generated
	 * @ordered
	 */
	FRACT64(14, "Fract64", "Fract64"),

	/**
	 * The '<em><b>Fract128</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRACT128_VALUE
	 * @generated
	 * @ordered
	 */
	FRACT128(15, "Fract128", "Fract128");

	/**
	 * The '<em><b>None</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>None</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NONE
	 * @model name="None"
	 * @generated
	 * @ordered
	 */
	public static final int NONE_VALUE = 0;

	/**
	 * The '<em><b>Int8</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Int8</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INT8
	 * @model name="Int8"
	 * @generated
	 * @ordered
	 */
	public static final int INT8_VALUE = 1;

	/**
	 * The '<em><b>Int16</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Int16</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INT16
	 * @model name="Int16"
	 * @generated
	 * @ordered
	 */
	public static final int INT16_VALUE = 2;

	/**
	 * The '<em><b>Int32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Int32</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INT32
	 * @model name="Int32"
	 * @generated
	 * @ordered
	 */
	public static final int INT32_VALUE = 3;

	/**
	 * The '<em><b>Int64</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Int64</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INT64
	 * @model name="Int64"
	 * @generated
	 * @ordered
	 */
	public static final int INT64_VALUE = 4;

	/**
	 * The '<em><b>Int128</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Int128</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INT128
	 * @model name="Int128"
	 * @generated
	 * @ordered
	 */
	public static final int INT128_VALUE = 5;

	/**
	 * The '<em><b>UInt8</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UInt8</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UINT8
	 * @model name="UInt8"
	 * @generated
	 * @ordered
	 */
	public static final int UINT8_VALUE = 6;

	/**
	 * The '<em><b>UInt16</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UInt16</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UINT16
	 * @model name="UInt16"
	 * @generated
	 * @ordered
	 */
	public static final int UINT16_VALUE = 7;

	/**
	 * The '<em><b>UInt32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UInt32</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UINT32
	 * @model name="UInt32"
	 * @generated
	 * @ordered
	 */
	public static final int UINT32_VALUE = 8;

	/**
	 * The '<em><b>UInt64</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UInt64</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UINT64
	 * @model name="UInt64"
	 * @generated
	 * @ordered
	 */
	public static final int UINT64_VALUE = 9;

	/**
	 * The '<em><b>UInt128</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UInt128</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UINT128
	 * @model name="UInt128"
	 * @generated
	 * @ordered
	 */
	public static final int UINT128_VALUE = 10;

	/**
	 * The '<em><b>Fract8</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Fract8</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FRACT8
	 * @model name="Fract8"
	 * @generated
	 * @ordered
	 */
	public static final int FRACT8_VALUE = 11;

	/**
	 * The '<em><b>Fract16</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Fract16</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FRACT16
	 * @model name="Fract16"
	 * @generated
	 * @ordered
	 */
	public static final int FRACT16_VALUE = 12;

	/**
	 * The '<em><b>Fract32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Fract32</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FRACT32
	 * @model name="Fract32"
	 * @generated
	 * @ordered
	 */
	public static final int FRACT32_VALUE = 13;

	/**
	 * The '<em><b>Fract64</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Fract64</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FRACT64
	 * @model name="Fract64"
	 * @generated
	 * @ordered
	 */
	public static final int FRACT64_VALUE = 14;

	/**
	 * The '<em><b>Fract128</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Fract128</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FRACT128
	 * @model name="Fract128"
	 * @generated
	 * @ordered
	 */
	public static final int FRACT128_VALUE = 15;

	/**
	 * An array of all the '<em><b>Predefined Fixed Point Format Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final PredefinedFixedPointFormatKind[] VALUES_ARRAY =
		new PredefinedFixedPointFormatKind[] {
			NONE,
			INT8,
			INT16,
			INT32,
			INT64,
			INT128,
			UINT8,
			UINT16,
			UINT32,
			UINT64,
			UINT128,
			FRACT8,
			FRACT16,
			FRACT32,
			FRACT64,
			FRACT128,
		};

	/**
	 * A public read-only list of all the '<em><b>Predefined Fixed Point Format Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<PredefinedFixedPointFormatKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Predefined Fixed Point Format Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PredefinedFixedPointFormatKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PredefinedFixedPointFormatKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Predefined Fixed Point Format Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PredefinedFixedPointFormatKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PredefinedFixedPointFormatKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Predefined Fixed Point Format Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PredefinedFixedPointFormatKind get(int value) {
		switch (value) {
			case NONE_VALUE: return NONE;
			case INT8_VALUE: return INT8;
			case INT16_VALUE: return INT16;
			case INT32_VALUE: return INT32;
			case INT64_VALUE: return INT64;
			case INT128_VALUE: return INT128;
			case UINT8_VALUE: return UINT8;
			case UINT16_VALUE: return UINT16;
			case UINT32_VALUE: return UINT32;
			case UINT64_VALUE: return UINT64;
			case UINT128_VALUE: return UINT128;
			case FRACT8_VALUE: return FRACT8;
			case FRACT16_VALUE: return FRACT16;
			case FRACT32_VALUE: return FRACT32;
			case FRACT64_VALUE: return FRACT64;
			case FRACT128_VALUE: return FRACT128;
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
	private PredefinedFixedPointFormatKind(int value, String name, String literal) {
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
	
} //PredefinedFixedPointFormatKind
