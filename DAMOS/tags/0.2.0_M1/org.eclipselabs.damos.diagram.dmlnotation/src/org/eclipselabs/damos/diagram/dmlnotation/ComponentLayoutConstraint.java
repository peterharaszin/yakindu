/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.diagram.dmlnotation;

import org.eclipse.gmf.runtime.notation.Bounds;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Layout Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.diagram.dmlnotation.ComponentLayoutConstraint#isFlipped <em>Flipped</em>}</li>
 *   <li>{@link org.eclipselabs.damos.diagram.dmlnotation.ComponentLayoutConstraint#getRotation <em>Rotation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.diagram.dmlnotation.DMLNotationPackage#getComponentLayoutConstraint()
 * @model
 * @generated
 */
public interface ComponentLayoutConstraint extends Bounds {
	/**
	 * Returns the value of the '<em><b>Flipped</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flipped</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flipped</em>' attribute.
	 * @see #setFlipped(boolean)
	 * @see org.eclipselabs.damos.diagram.dmlnotation.DMLNotationPackage#getComponentLayoutConstraint_Flipped()
	 * @model
	 * @generated
	 */
	boolean isFlipped();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.diagram.dmlnotation.ComponentLayoutConstraint#isFlipped <em>Flipped</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flipped</em>' attribute.
	 * @see #isFlipped()
	 * @generated
	 */
	void setFlipped(boolean value);

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
	 * @see org.eclipselabs.damos.diagram.dmlnotation.DMLNotationPackage#getComponentLayoutConstraint_Rotation()
	 * @model
	 * @generated
	 */
	int getRotation();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.diagram.dmlnotation.ComponentLayoutConstraint#getRotation <em>Rotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotation</em>' attribute.
	 * @see #getRotation()
	 * @generated
	 */
	void setRotation(int value);

} // ComponentLayoutConstraint
