/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.codegen.c.cgenmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenSubsystem;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenSystem;
import org.eclipselabs.damos.dml.Subsystem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Subsystem</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenSubsystemImpl#getEnclosingGenSystem <em>Enclosing Gen System</em>}</li>
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
	public GenSystem getEnclosingGenSystem() {
		if (eContainerFeatureID() != CGenModelPackage.GEN_SUBSYSTEM__ENCLOSING_GEN_SYSTEM) return null;
		return (GenSystem)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEnclosingGenSystem(GenSystem newEnclosingGenSystem, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newEnclosingGenSystem, CGenModelPackage.GEN_SUBSYSTEM__ENCLOSING_GEN_SYSTEM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnclosingGenSystem(GenSystem newEnclosingGenSystem) {
		if (newEnclosingGenSystem != eInternalContainer() || (eContainerFeatureID() != CGenModelPackage.GEN_SUBSYSTEM__ENCLOSING_GEN_SYSTEM && newEnclosingGenSystem != null)) {
			if (EcoreUtil.isAncestor(this, newEnclosingGenSystem))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newEnclosingGenSystem != null)
				msgs = ((InternalEObject)newEnclosingGenSystem).eInverseAdd(this, CGenModelPackage.GEN_SYSTEM__GEN_SUBSYSTEMS, GenSystem.class, msgs);
			msgs = basicSetEnclosingGenSystem(newEnclosingGenSystem, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGenModelPackage.GEN_SUBSYSTEM__ENCLOSING_GEN_SYSTEM, newEnclosingGenSystem, newEnclosingGenSystem));
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CGenModelPackage.GEN_SUBSYSTEM__ENCLOSING_GEN_SYSTEM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetEnclosingGenSystem((GenSystem)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CGenModelPackage.GEN_SUBSYSTEM__ENCLOSING_GEN_SYSTEM:
				return basicSetEnclosingGenSystem(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case CGenModelPackage.GEN_SUBSYSTEM__ENCLOSING_GEN_SYSTEM:
				return eInternalContainer().eInverseRemove(this, CGenModelPackage.GEN_SYSTEM__GEN_SUBSYSTEMS, GenSystem.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CGenModelPackage.GEN_SUBSYSTEM__ENCLOSING_GEN_SYSTEM:
				return getEnclosingGenSystem();
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
			case CGenModelPackage.GEN_SUBSYSTEM__ENCLOSING_GEN_SYSTEM:
				setEnclosingGenSystem((GenSystem)newValue);
				return;
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
			case CGenModelPackage.GEN_SUBSYSTEM__ENCLOSING_GEN_SYSTEM:
				setEnclosingGenSystem((GenSystem)null);
				return;
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
			case CGenModelPackage.GEN_SUBSYSTEM__ENCLOSING_GEN_SYSTEM:
				return getEnclosingGenSystem() != null;
			case CGenModelPackage.GEN_SUBSYSTEM__SUBSYSTEM:
				return subsystem != null;
		}
		return super.eIsSet(featureID);
	}

} //GenSubsystemImpl
