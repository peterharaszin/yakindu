/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagram;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;
import org.esmp.dsm.semantic.blockdiagram.Connection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramImpl#getBlocks <em>Blocks</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockDiagramImpl#getConnections <em>Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BlockDiagramImpl extends NamedElementImpl implements BlockDiagram {
	/**
	 * The cached value of the '{@link #getBlocks() <em>Blocks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlocks()
	 * @generated
	 * @ordered
	 */
	protected EList<Block> blocks;

	/**
	 * The cached value of the '{@link #getConnections() <em>Connections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<Connection> connections;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected BlockDiagramImpl() {
		super();
		eAdapters().add(new BlockDiagramContentAdapter(this));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BlockDiagramPackage.Literals.BLOCK_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Connection> getConnections() {
		if (connections == null) {
			connections = new EObjectContainmentEList<Connection>(Connection.class, this, BlockDiagramPackage.BLOCK_DIAGRAM__CONNECTIONS);
		}
		return connections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Block> getBlocks() {
		if (blocks == null) {
			blocks = new EObjectContainmentWithInverseEList<Block>(Block.class, this, BlockDiagramPackage.BLOCK_DIAGRAM__BLOCKS, BlockDiagramPackage.BLOCK__BLOCK_DIAGRAM);
		}
		return blocks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BlockDiagramPackage.BLOCK_DIAGRAM__BLOCKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBlocks()).basicAdd(otherEnd, msgs);
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
			case BlockDiagramPackage.BLOCK_DIAGRAM__BLOCKS:
				return ((InternalEList<?>)getBlocks()).basicRemove(otherEnd, msgs);
			case BlockDiagramPackage.BLOCK_DIAGRAM__CONNECTIONS:
				return ((InternalEList<?>)getConnections()).basicRemove(otherEnd, msgs);
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
			case BlockDiagramPackage.BLOCK_DIAGRAM__BLOCKS:
				return getBlocks();
			case BlockDiagramPackage.BLOCK_DIAGRAM__CONNECTIONS:
				return getConnections();
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
			case BlockDiagramPackage.BLOCK_DIAGRAM__BLOCKS:
				getBlocks().clear();
				getBlocks().addAll((Collection<? extends Block>)newValue);
				return;
			case BlockDiagramPackage.BLOCK_DIAGRAM__CONNECTIONS:
				getConnections().clear();
				getConnections().addAll((Collection<? extends Connection>)newValue);
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
			case BlockDiagramPackage.BLOCK_DIAGRAM__BLOCKS:
				getBlocks().clear();
				return;
			case BlockDiagramPackage.BLOCK_DIAGRAM__CONNECTIONS:
				getConnections().clear();
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
			case BlockDiagramPackage.BLOCK_DIAGRAM__BLOCKS:
				return blocks != null && !blocks.isEmpty();
			case BlockDiagramPackage.BLOCK_DIAGRAM__CONNECTIONS:
				return connections != null && !connections.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BlockDiagramImpl
