/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.notation.blockdiagramnotation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.gmf.runtime.notation.impl.BoundsImpl;

import org.esmp.dsm.notation.blockdiagramnotation.BlockDiagramNotationPackage;
import org.esmp.dsm.notation.blockdiagramnotation.BlockLayoutConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block Layout Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.esmp.dsm.notation.blockdiagramnotation.impl.BlockLayoutConstraintImpl#isFlipped <em>Flipped</em>}</li>
 *   <li>{@link org.esmp.dsm.notation.blockdiagramnotation.impl.BlockLayoutConstraintImpl#getRotation <em>Rotation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BlockLayoutConstraintImpl extends BoundsImpl implements BlockLayoutConstraint {
	/**
	 * The default value of the '{@link #isFlipped() <em>Flipped</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFlipped()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FLIPPED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFlipped() <em>Flipped</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFlipped()
	 * @generated
	 * @ordered
	 */
	protected boolean flipped = FLIPPED_EDEFAULT;

	/**
	 * The default value of the '{@link #getRotation() <em>Rotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRotation()
	 * @generated
	 * @ordered
	 */
	protected static final int ROTATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRotation() <em>Rotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRotation()
	 * @generated
	 * @ordered
	 */
	protected int rotation = ROTATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockLayoutConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BlockDiagramNotationPackage.Literals.BLOCK_LAYOUT_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFlipped() {
		return flipped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlipped(boolean newFlipped) {
		boolean oldFlipped = flipped;
		flipped = newFlipped;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlockDiagramNotationPackage.BLOCK_LAYOUT_CONSTRAINT__FLIPPED, oldFlipped, flipped));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRotation() {
		return rotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotation(int newRotation) {
		int oldRotation = rotation;
		rotation = newRotation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlockDiagramNotationPackage.BLOCK_LAYOUT_CONSTRAINT__ROTATION, oldRotation, rotation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BlockDiagramNotationPackage.BLOCK_LAYOUT_CONSTRAINT__FLIPPED:
				return isFlipped();
			case BlockDiagramNotationPackage.BLOCK_LAYOUT_CONSTRAINT__ROTATION:
				return getRotation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BlockDiagramNotationPackage.BLOCK_LAYOUT_CONSTRAINT__FLIPPED:
				setFlipped((Boolean)newValue);
				return;
			case BlockDiagramNotationPackage.BLOCK_LAYOUT_CONSTRAINT__ROTATION:
				setRotation((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BlockDiagramNotationPackage.BLOCK_LAYOUT_CONSTRAINT__FLIPPED:
				setFlipped(FLIPPED_EDEFAULT);
				return;
			case BlockDiagramNotationPackage.BLOCK_LAYOUT_CONSTRAINT__ROTATION:
				setRotation(ROTATION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BlockDiagramNotationPackage.BLOCK_LAYOUT_CONSTRAINT__FLIPPED:
				return flipped != FLIPPED_EDEFAULT;
			case BlockDiagramNotationPackage.BLOCK_LAYOUT_CONSTRAINT__ROTATION:
				return rotation != ROTATION_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (flipped: ");
		result.append(flipped);
		result.append(", rotation: ");
		result.append(rotation);
		result.append(')');
		return result.toString();
	}

} //BlockLayoutConstraintImpl
