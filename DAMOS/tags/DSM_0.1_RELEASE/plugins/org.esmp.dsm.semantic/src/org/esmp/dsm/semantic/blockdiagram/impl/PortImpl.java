/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;
import org.esmp.dsm.semantic.blockdiagram.Port;
import org.esmp.dsm.semantic.blockdiagram.internal.operations.PortOperations;
import org.esmp.dsm.semantic.blockdiagram.util.BlockDiagramUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.PortImpl#getBlock <em>Block</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.PortImpl#getIndex <em>Index</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PortImpl extends ParameterableElementImpl implements Port {
	/**
	 * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int INDEX_EDEFAULT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BlockDiagramPackage.Literals.PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block getBlock() {
		Block block = basicGetBlock();
		return block != null && block.eIsProxy() ? (Block)eResolveProxy((InternalEObject)block) : block;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Block basicGetBlock() {
		return PortOperations.getBlock(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getIndex() {
		return BlockDiagramUtil.getIndex(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BlockDiagramPackage.PORT__BLOCK:
				if (resolve) return getBlock();
				return basicGetBlock();
			case BlockDiagramPackage.PORT__INDEX:
				return getIndex();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BlockDiagramPackage.PORT__BLOCK:
				return basicGetBlock() != null;
			case BlockDiagramPackage.PORT__INDEX:
				return getIndex() != INDEX_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //PortImpl
