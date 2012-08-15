/**
 */
package org.eclipselabs.damos.mscript;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Unit Prefix</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getUnitPrefix()
 * @model
 * @generated
 */
public enum UnitPrefix implements Enumerator {
	/**
	 * The '<em><b>None</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONE_VALUE
	 * @generated
	 * @ordered
	 */
	NONE(0, "None", ""),

	/**
	 * The '<em><b>Deca</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECA_VALUE
	 * @generated
	 * @ordered
	 */
	DECA(1, "Deca", "da"),

	/**
	 * The '<em><b>Hecto</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HECTO_VALUE
	 * @generated
	 * @ordered
	 */
	HECTO(2, "Hecto", "h"),

	/**
	 * The '<em><b>Kilo</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KILO_VALUE
	 * @generated
	 * @ordered
	 */
	KILO(3, "Kilo", "k"),

	/**
	 * The '<em><b>Mega</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEGA_VALUE
	 * @generated
	 * @ordered
	 */
	MEGA(6, "Mega", "M"),

	/**
	 * The '<em><b>Giga</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GIGA_VALUE
	 * @generated
	 * @ordered
	 */
	GIGA(9, "Giga", "G"),

	/**
	 * The '<em><b>Tera</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TERA_VALUE
	 * @generated
	 * @ordered
	 */
	TERA(12, "Tera", "T"),

	/**
	 * The '<em><b>Peta</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PETA_VALUE
	 * @generated
	 * @ordered
	 */
	PETA(15, "Peta", "P"),

	/**
	 * The '<em><b>Exa</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXA_VALUE
	 * @generated
	 * @ordered
	 */
	EXA(18, "Exa", "E"),

	/**
	 * The '<em><b>Zetta</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZETTA_VALUE
	 * @generated
	 * @ordered
	 */
	ZETTA(21, "Zetta", "Z"),

	/**
	 * The '<em><b>Yotta</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #YOTTA_VALUE
	 * @generated
	 * @ordered
	 */
	YOTTA(24, "Yotta", "Y"),

	/**
	 * The '<em><b>Deci</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECI_VALUE
	 * @generated
	 * @ordered
	 */
	DECI(-1, "Deci", "d"),

	/**
	 * The '<em><b>Centi</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CENTI_VALUE
	 * @generated
	 * @ordered
	 */
	CENTI(-2, "Centi", "c"),

	/**
	 * The '<em><b>Milli</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MILLI_VALUE
	 * @generated
	 * @ordered
	 */
	MILLI(-3, "Milli", "m"),

	/**
	 * The '<em><b>Micro</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MICRO_VALUE
	 * @generated
	 * @ordered
	 */
	MICRO(-6, "Micro", "u"),

	/**
	 * The '<em><b>Nano</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NANO_VALUE
	 * @generated
	 * @ordered
	 */
	NANO(-9, "Nano", "n"),

	/**
	 * The '<em><b>Pico</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PICO_VALUE
	 * @generated
	 * @ordered
	 */
	PICO(-12, "Pico", "p"),

	/**
	 * The '<em><b>Femto</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FEMTO_VALUE
	 * @generated
	 * @ordered
	 */
	FEMTO(-15, "Femto", "f"),

	/**
	 * The '<em><b>Atto</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ATTO_VALUE
	 * @generated
	 * @ordered
	 */
	ATTO(-18, "Atto", "a"),

	/**
	 * The '<em><b>Zepto</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZEPTO_VALUE
	 * @generated
	 * @ordered
	 */
	ZEPTO(-21, "Zepto", "z"),

	/**
	 * The '<em><b>Yocto</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #YOCTO_VALUE
	 * @generated
	 * @ordered
	 */
	YOCTO(-24, "Yocto", "y");

	/**
	 * The '<em><b>None</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>None</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NONE
	 * @model name="None" literal=""
	 * @generated
	 * @ordered
	 */
	public static final int NONE_VALUE = 0;

	/**
	 * The '<em><b>Deca</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Deca</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DECA
	 * @model name="Deca" literal="da"
	 * @generated
	 * @ordered
	 */
	public static final int DECA_VALUE = 1;

	/**
	 * The '<em><b>Hecto</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Hecto</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HECTO
	 * @model name="Hecto" literal="h"
	 * @generated
	 * @ordered
	 */
	public static final int HECTO_VALUE = 2;

	/**
	 * The '<em><b>Kilo</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Kilo</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KILO
	 * @model name="Kilo" literal="k"
	 * @generated
	 * @ordered
	 */
	public static final int KILO_VALUE = 3;

	/**
	 * The '<em><b>Mega</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mega</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEGA
	 * @model name="Mega" literal="M"
	 * @generated
	 * @ordered
	 */
	public static final int MEGA_VALUE = 6;

	/**
	 * The '<em><b>Giga</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Giga</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GIGA
	 * @model name="Giga" literal="G"
	 * @generated
	 * @ordered
	 */
	public static final int GIGA_VALUE = 9;

	/**
	 * The '<em><b>Tera</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Tera</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TERA
	 * @model name="Tera" literal="T"
	 * @generated
	 * @ordered
	 */
	public static final int TERA_VALUE = 12;

	/**
	 * The '<em><b>Peta</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Peta</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PETA
	 * @model name="Peta" literal="P"
	 * @generated
	 * @ordered
	 */
	public static final int PETA_VALUE = 15;

	/**
	 * The '<em><b>Exa</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Exa</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXA
	 * @model name="Exa" literal="E"
	 * @generated
	 * @ordered
	 */
	public static final int EXA_VALUE = 18;

	/**
	 * The '<em><b>Zetta</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Zetta</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZETTA
	 * @model name="Zetta" literal="Z"
	 * @generated
	 * @ordered
	 */
	public static final int ZETTA_VALUE = 21;

	/**
	 * The '<em><b>Yotta</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Yotta</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #YOTTA
	 * @model name="Yotta" literal="Y"
	 * @generated
	 * @ordered
	 */
	public static final int YOTTA_VALUE = 24;

	/**
	 * The '<em><b>Deci</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Deci</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DECI
	 * @model name="Deci" literal="d"
	 * @generated
	 * @ordered
	 */
	public static final int DECI_VALUE = -1;

	/**
	 * The '<em><b>Centi</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Centi</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CENTI
	 * @model name="Centi" literal="c"
	 * @generated
	 * @ordered
	 */
	public static final int CENTI_VALUE = -2;

	/**
	 * The '<em><b>Milli</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Milli</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MILLI
	 * @model name="Milli" literal="m"
	 * @generated
	 * @ordered
	 */
	public static final int MILLI_VALUE = -3;

	/**
	 * The '<em><b>Micro</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Micro</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MICRO
	 * @model name="Micro" literal="u"
	 * @generated
	 * @ordered
	 */
	public static final int MICRO_VALUE = -6;

	/**
	 * The '<em><b>Nano</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Nano</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NANO
	 * @model name="Nano" literal="n"
	 * @generated
	 * @ordered
	 */
	public static final int NANO_VALUE = -9;

	/**
	 * The '<em><b>Pico</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Pico</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PICO
	 * @model name="Pico" literal="p"
	 * @generated
	 * @ordered
	 */
	public static final int PICO_VALUE = -12;

	/**
	 * The '<em><b>Femto</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Femto</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FEMTO
	 * @model name="Femto" literal="f"
	 * @generated
	 * @ordered
	 */
	public static final int FEMTO_VALUE = -15;

	/**
	 * The '<em><b>Atto</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Atto</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ATTO
	 * @model name="Atto" literal="a"
	 * @generated
	 * @ordered
	 */
	public static final int ATTO_VALUE = -18;

	/**
	 * The '<em><b>Zepto</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Zepto</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZEPTO
	 * @model name="Zepto" literal="z"
	 * @generated
	 * @ordered
	 */
	public static final int ZEPTO_VALUE = -21;

	/**
	 * The '<em><b>Yocto</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Yocto</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #YOCTO
	 * @model name="Yocto" literal="y"
	 * @generated
	 * @ordered
	 */
	public static final int YOCTO_VALUE = -24;

	/**
	 * An array of all the '<em><b>Unit Prefix</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final UnitPrefix[] VALUES_ARRAY =
		new UnitPrefix[] {
			NONE,
			DECA,
			HECTO,
			KILO,
			MEGA,
			GIGA,
			TERA,
			PETA,
			EXA,
			ZETTA,
			YOTTA,
			DECI,
			CENTI,
			MILLI,
			MICRO,
			NANO,
			PICO,
			FEMTO,
			ATTO,
			ZEPTO,
			YOCTO,
		};

	/**
	 * A public read-only list of all the '<em><b>Unit Prefix</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<UnitPrefix> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Unit Prefix</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UnitPrefix get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UnitPrefix result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Unit Prefix</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UnitPrefix getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			UnitPrefix result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Unit Prefix</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UnitPrefix get(int value) {
		switch (value) {
			case NONE_VALUE: return NONE;
			case DECA_VALUE: return DECA;
			case HECTO_VALUE: return HECTO;
			case KILO_VALUE: return KILO;
			case MEGA_VALUE: return MEGA;
			case GIGA_VALUE: return GIGA;
			case TERA_VALUE: return TERA;
			case PETA_VALUE: return PETA;
			case EXA_VALUE: return EXA;
			case ZETTA_VALUE: return ZETTA;
			case YOTTA_VALUE: return YOTTA;
			case DECI_VALUE: return DECI;
			case CENTI_VALUE: return CENTI;
			case MILLI_VALUE: return MILLI;
			case MICRO_VALUE: return MICRO;
			case NANO_VALUE: return NANO;
			case PICO_VALUE: return PICO;
			case FEMTO_VALUE: return FEMTO;
			case ATTO_VALUE: return ATTO;
			case ZEPTO_VALUE: return ZEPTO;
			case YOCTO_VALUE: return YOCTO;
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
	private UnitPrefix(int value, String name, String literal) {
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
	
} //UnitPrefix
