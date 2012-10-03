/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dscript.impl;

import java.util.Collection;

import org.eclipse.damos.dml.BlockType;
import org.eclipse.damos.dml.SystemInterface;
import org.eclipse.damos.dscript.DscriptPackage;
import org.eclipse.damos.dscript.Root;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.dscript.impl.RootImpl#getBlockTypes <em>Block Types</em>}</li>
 *   <li>{@link org.eclipse.damos.dscript.impl.RootImpl#getSystemInterfaces <em>System Interfaces</em>}</li>
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
		return DscriptPackage.Literals.ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BlockType> getBlockTypes() {
		if (blockTypes == null) {
			blockTypes = new EObjectContainmentEList<BlockType>(BlockType.class, this, DscriptPackage.ROOT__BLOCK_TYPES);
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
			systemInterfaces = new EObjectContainmentEList<SystemInterface>(SystemInterface.class, this, DscriptPackage.ROOT__SYSTEM_INTERFACES);
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
			case DscriptPackage.ROOT__BLOCK_TYPES:
				return ((InternalEList<?>)getBlockTypes()).basicRemove(otherEnd, msgs);
			case DscriptPackage.ROOT__SYSTEM_INTERFACES:
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
			case DscriptPackage.ROOT__BLOCK_TYPES:
				return getBlockTypes();
			case DscriptPackage.ROOT__SYSTEM_INTERFACES:
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
			case DscriptPackage.ROOT__BLOCK_TYPES:
				getBlockTypes().clear();
				getBlockTypes().addAll((Collection<? extends BlockType>)newValue);
				return;
			case DscriptPackage.ROOT__SYSTEM_INTERFACES:
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
			case DscriptPackage.ROOT__BLOCK_TYPES:
				getBlockTypes().clear();
				return;
			case DscriptPackage.ROOT__SYSTEM_INTERFACES:
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
			case DscriptPackage.ROOT__BLOCK_TYPES:
				return blockTypes != null && !blockTypes.isEmpty();
			case DscriptPackage.ROOT__SYSTEM_INTERFACES:
				return systemInterfaces != null && !systemInterfaces.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RootImpl
