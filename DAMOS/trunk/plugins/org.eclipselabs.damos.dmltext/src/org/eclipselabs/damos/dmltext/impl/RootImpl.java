/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dmltext.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.dml.SystemInterface;
import org.eclipselabs.damos.dmltext.DMLTextPackage;
import org.eclipselabs.damos.dmltext.Root;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dmltext.impl.RootImpl#getBlockTypes <em>Block Types</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dmltext.impl.RootImpl#getSystemInterfaces <em>System Interfaces</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RootImpl extends EObjectImpl implements Root {
	/**
	 * The cached value of the '{@link #getBlockTypes() <em>Block Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<BlockType> blockTypes;

	/**
	 * The cached value of the '{@link #getSystemInterfaces() <em>System Interfaces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<SystemInterface> systemInterfaces;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLTextPackage.Literals.ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BlockType> getBlockTypes() {
		if (blockTypes == null) {
			blockTypes = new EObjectContainmentEList<BlockType>(BlockType.class, this, DMLTextPackage.ROOT__BLOCK_TYPES);
		}
		return blockTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SystemInterface> getSystemInterfaces() {
		if (systemInterfaces == null) {
			systemInterfaces = new EObjectContainmentEList<SystemInterface>(SystemInterface.class, this, DMLTextPackage.ROOT__SYSTEM_INTERFACES);
		}
		return systemInterfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DMLTextPackage.ROOT__BLOCK_TYPES:
				return ((InternalEList<?>)getBlockTypes()).basicRemove(otherEnd, msgs);
			case DMLTextPackage.ROOT__SYSTEM_INTERFACES:
				return ((InternalEList<?>)getSystemInterfaces()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DMLTextPackage.ROOT__BLOCK_TYPES:
				return getBlockTypes();
			case DMLTextPackage.ROOT__SYSTEM_INTERFACES:
				return getSystemInterfaces();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DMLTextPackage.ROOT__BLOCK_TYPES:
				getBlockTypes().clear();
				getBlockTypes().addAll((Collection<? extends BlockType>)newValue);
				return;
			case DMLTextPackage.ROOT__SYSTEM_INTERFACES:
				getSystemInterfaces().clear();
				getSystemInterfaces().addAll((Collection<? extends SystemInterface>)newValue);
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
			case DMLTextPackage.ROOT__BLOCK_TYPES:
				getBlockTypes().clear();
				return;
			case DMLTextPackage.ROOT__SYSTEM_INTERFACES:
				getSystemInterfaces().clear();
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
			case DMLTextPackage.ROOT__BLOCK_TYPES:
				return blockTypes != null && !blockTypes.isEmpty();
			case DMLTextPackage.ROOT__SYSTEM_INTERFACES:
				return systemInterfaces != null && !systemInterfaces.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RootImpl
