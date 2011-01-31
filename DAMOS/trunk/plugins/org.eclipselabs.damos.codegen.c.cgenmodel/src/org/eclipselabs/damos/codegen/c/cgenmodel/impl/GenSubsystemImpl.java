/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.codegen.c.cgenmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenSubsystem;
import org.eclipselabs.damos.dml.Subsystem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Subsystem</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenSubsystemImpl#getSubsystem <em>Subsystem</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenSubsystemImpl extends GenSystemImpl implements GenSubsystem {
	/**
	 * The cached value of the '{@link #getSubsystem() <em>Subsystem</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubsystem()
	 * @generated
	 * @ordered
	 */
	protected Subsystem subsystem;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenSubsystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CGenModelPackage.Literals.GEN_SUBSYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subsystem getSubsystem() {
		if (subsystem != null && subsystem.eIsProxy()) {
			InternalEObject oldSubsystem = (InternalEObject)subsystem;
			subsystem = (Subsystem)eResolveProxy(oldSubsystem);
			if (subsystem != oldSubsystem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CGenModelPackage.GEN_SUBSYSTEM__SUBSYSTEM, oldSubsystem, subsystem));
			}
		}
		return subsystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subsystem basicGetSubsystem() {
		return subsystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubsystem(Subsystem newSubsystem) {
		Subsystem oldSubsystem = subsystem;
		subsystem = newSubsystem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGenModelPackage.GEN_SUBSYSTEM__SUBSYSTEM, oldSubsystem, subsystem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CGenModelPackage.GEN_SUBSYSTEM__SUBSYSTEM:
				if (resolve) return getSubsystem();
				return basicGetSubsystem();
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
			case CGenModelPackage.GEN_SUBSYSTEM__SUBSYSTEM:
				setSubsystem((Subsystem)newValue);
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
			case CGenModelPackage.GEN_SUBSYSTEM__SUBSYSTEM:
				setSubsystem((Subsystem)null);
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
			case CGenModelPackage.GEN_SUBSYSTEM__SUBSYSTEM:
				return subsystem != null;
		}
		return super.eIsSet(featureID);
	}

} //GenSubsystemImpl
