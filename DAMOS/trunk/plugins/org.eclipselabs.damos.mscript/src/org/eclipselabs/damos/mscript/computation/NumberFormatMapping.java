/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.computation;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.mscript.TypeSpecifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Number Format Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.computation.NumberFormatMapping#getTypeSpecifier <em>Type Specifier</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.computation.NumberFormatMapping#getNumberFormat <em>Number Format</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.computation.ComputationModelPackage#getNumberFormatMapping()
 * @model
 * @generated
 */
public interface NumberFormatMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Type Specifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Specifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Specifier</em>' containment reference.
	 * @see #setTypeSpecifier(TypeSpecifier)
	 * @see org.eclipselabs.damos.mscript.computation.ComputationModelPackage#getNumberFormatMapping_TypeSpecifier()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	TypeSpecifier getTypeSpecifier();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.computation.NumberFormatMapping#getTypeSpecifier <em>Type Specifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Specifier</em>' containment reference.
	 * @see #getTypeSpecifier()
	 * @generated
	 */
	void setTypeSpecifier(TypeSpecifier value);

	/**
	 * Returns the value of the '<em><b>Number Format</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Format</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Format</em>' containment reference.
	 * @see #setNumberFormat(NumberFormat)
	 * @see org.eclipselabs.damos.mscript.computation.ComputationModelPackage#getNumberFormatMapping_NumberFormat()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	NumberFormat getNumberFormat();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.computation.NumberFormatMapping#getNumberFormat <em>Number Format</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Format</em>' containment reference.
	 * @see #getNumberFormat()
	 * @generated
	 */
	void setNumberFormat(NumberFormat value);

} // NumberFormatMapping
