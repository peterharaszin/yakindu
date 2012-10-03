/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.PrimitiveTypeSpecification#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dml.DMLPackage#getPrimitiveTypeSpecification()
 * @model
 * @generated
 */
public interface PrimitiveTypeSpecification extends DataTypeSpecification {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.damos.dml.PrimitiveTypeKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.damos.dml.PrimitiveTypeKind
	 * @see #setKind(PrimitiveTypeKind)
	 * @see org.eclipse.damos.dml.DMLPackage#getPrimitiveTypeSpecification_Kind()
	 * @model
	 * @generated
	 */
	PrimitiveTypeKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dml.PrimitiveTypeSpecification#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.damos.dml.PrimitiveTypeKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(PrimitiveTypeKind value);

} // PrimitiveTypeSpecification
