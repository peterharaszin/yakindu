/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.diagram.dmlnotation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Layout Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.diagram.dmlnotation.RotatableBounds#getRotation <em>Rotation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.diagram.dmlnotation.DMLNotationPackage#getRotatableBounds()
 * @model
 * @generated
 */
public interface RotatableBounds extends FlippableBounds {
	/**
	 * Returns the value of the '<em><b>Rotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotation</em>' attribute.
	 * @see #setRotation(int)
	 * @see org.eclipselabs.damos.diagram.dmlnotation.DMLNotationPackage#getRotatableBounds_Rotation()
	 * @model
	 * @generated
	 */
	int getRotation();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.diagram.dmlnotation.RotatableBounds#getRotation <em>Rotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotation</em>' attribute.
	 * @see #getRotation()
	 * @generated
	 */
	void setRotation(int value);

} // ComponentLayoutConstraint
