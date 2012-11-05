/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.diagram.dmlnotation;

import org.eclipse.gmf.runtime.notation.Bounds;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flippable Bounds</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.diagram.dmlnotation.FlippableBounds#isFlipped <em>Flipped</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.diagram.dmlnotation.DMLNotationPackage#getFlippableBounds()
 * @model
 * @generated
 */
public interface FlippableBounds extends Bounds {
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
	 * @see org.eclipse.damos.diagram.dmlnotation.DMLNotationPackage#getFlippableBounds_Flipped()
	 * @model
	 * @generated
	 */
	boolean isFlipped();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.diagram.dmlnotation.FlippableBounds#isFlipped <em>Flipped</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flipped</em>' attribute.
	 * @see #isFlipped()
	 * @generated
	 */
	void setFlipped(boolean value);

} // FlippableBounds
