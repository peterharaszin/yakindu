/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Enumeration Order</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getEnumerationOrder()
 * @model
 * @generated
 */
public enum EnumerationOrder implements Enumerator {
	/**
	 * The '<em><b>Owned First</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OWNED_FIRST_VALUE
	 * @generated
	 * @ordered
	 */
	OWNED_FIRST(0, "OwnedFirst", "OwnedFirst"),

	/**
	 * The '<em><b>Inherited First</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INHERITED_FIRST_VALUE
	 * @generated
	 * @ordered
	 */
	INHERITED_FIRST(1, "InheritedFirst", "InheritedFirst");

	/**
	 * The '<em><b>Owned First</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Owned First</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OWNED_FIRST
	 * @model name="OwnedFirst"
	 * @generated
	 * @ordered
	 */
	public static final int OWNED_FIRST_VALUE = 0;

	/**
	 * The '<em><b>Inherited First</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Inherited First</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INHERITED_FIRST
	 * @model name="InheritedFirst"
	 * @generated
	 * @ordered
	 */
	public static final int INHERITED_FIRST_VALUE = 1;

	/**
	 * An array of all the '<em><b>Enumeration Order</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EnumerationOrder[] VALUES_ARRAY =
		new EnumerationOrder[] {
			OWNED_FIRST,
			INHERITED_FIRST,
		};

	/**
	 * A public read-only list of all the '<em><b>Enumeration Order</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EnumerationOrder> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Enumeration Order</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EnumerationOrder get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EnumerationOrder result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Enumeration Order</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EnumerationOrder getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EnumerationOrder result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Enumeration Order</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EnumerationOrder get(int value) {
		switch (value) {
			case OWNED_FIRST_VALUE: return OWNED_FIRST;
			case INHERITED_FIRST_VALUE: return INHERITED_FIRST;
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
	private EnumerationOrder(int value, String name, String literal) {
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
	
} //EnumerationOrder
