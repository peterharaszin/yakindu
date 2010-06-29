/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.notation.blockdiagramnotation;

import org.eclipse.gmf.runtime.notation.Bounds;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block Layout Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.esmp.dsm.notation.blockdiagramnotation.BlockLayoutConstraint#isFlipped <em>Flipped</em>}</li>
 *   <li>{@link org.esmp.dsm.notation.blockdiagramnotation.BlockLayoutConstraint#getRotation <em>Rotation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.esmp.dsm.notation.blockdiagramnotation.BlockDiagramNotationPackage#getBlockLayoutConstraint()
 * @model
 * @generated
 */
public interface BlockLayoutConstraint extends Bounds {
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
	 * @see org.esmp.dsm.notation.blockdiagramnotation.BlockDiagramNotationPackage#getBlockLayoutConstraint_Flipped()
	 * @model
	 * @generated
	 */
	boolean isFlipped();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.notation.blockdiagramnotation.BlockLayoutConstraint#isFlipped <em>Flipped</em>}' attribute.
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
	 * @see org.esmp.dsm.notation.blockdiagramnotation.BlockDiagramNotationPackage#getBlockLayoutConstraint_Rotation()
	 * @model
	 * @generated
	 */
	int getRotation();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.notation.blockdiagramnotation.BlockLayoutConstraint#getRotation <em>Rotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotation</em>' attribute.
	 * @see #getRotation()
	 * @generated
	 */
	void setRotation(int value);

} // BlockLayoutConstraint
