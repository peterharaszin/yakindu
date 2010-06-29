/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;
import org.esmp.dsm.semantic.blockdiagram.Input;
import org.esmp.dsm.semantic.blockdiagram.InputPort;
import org.esmp.dsm.semantic.blockdiagram.InputSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.InputImpl#getSpecification <em>Specification</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.InputImpl#getBlock <em>Block</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.InputImpl#getPorts <em>Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InputImpl extends EObjectImpl implements Input {
	/**
	 * The cached value of the '{@link #getSpecification() <em>Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecification()
	 * @generated
	 * @ordered
	 */
	protected InputSpecification specification;

	/**
	 * The cached value of the '{@link #getPorts() <em>Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<InputPort> ports;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BlockDiagramPackage.Literals.INPUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputPort> getPorts() {
		if (ports == null) {
			ports = new EObjectContainmentWithInverseEList<InputPort>(InputPort.class, this, BlockDiagramPackage.INPUT__PORTS, BlockDiagramPackage.INPUT_PORT__INPUT);
		}
		return ports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputSpecification getSpecification() {
		if (specification != null && specification.eIsProxy()) {
			InternalEObject oldSpecification = (InternalEObject)specification;
			specification = (InputSpecification)eResolveProxy(oldSpecification);
			if (specification != oldSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BlockDiagramPackage.INPUT__SPECIFICATION, oldSpecification, specification));
			}
		}
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputSpecification basicGetSpecification() {
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecification(InputSpecification newSpecification) {
		InputSpecification oldSpecification = specification;
		specification = newSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlockDiagramPackage.INPUT__SPECIFICATION, oldSpecification, specification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block getBlock() {
		if (eContainerFeatureID() != BlockDiagramPackage.INPUT__BLOCK) return null;
		return (Block)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBlock(Block newBlock, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newBlock, BlockDiagramPackage.INPUT__BLOCK, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlock(Block newBlock) {
		if (newBlock != eInternalContainer() || (eContainerFeatureID() != BlockDiagramPackage.INPUT__BLOCK && newBlock != null)) {
			if (EcoreUtil.isAncestor(this, newBlock))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newBlock != null)
				msgs = ((InternalEObject)newBlock).eInverseAdd(this, BlockDiagramPackage.BLOCK__INPUTS, Block.class, msgs);
			msgs = basicSetBlock(newBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlockDiagramPackage.INPUT__BLOCK, newBlock, newBlock));
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
			case BlockDiagramPackage.INPUT__BLOCK:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetBlock((Block)otherEnd, msgs);
			case BlockDiagramPackage.INPUT__PORTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPorts()).basicAdd(otherEnd, msgs);
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
			case BlockDiagramPackage.INPUT__BLOCK:
				return basicSetBlock(null, msgs);
			case BlockDiagramPackage.INPUT__PORTS:
				return ((InternalEList<?>)getPorts()).basicRemove(otherEnd, msgs);
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
			case BlockDiagramPackage.INPUT__BLOCK:
				return eInternalContainer().eInverseRemove(this, BlockDiagramPackage.BLOCK__INPUTS, Block.class, msgs);
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
			case BlockDiagramPackage.INPUT__SPECIFICATION:
				if (resolve) return getSpecification();
				return basicGetSpecification();
			case BlockDiagramPackage.INPUT__BLOCK:
				return getBlock();
			case BlockDiagramPackage.INPUT__PORTS:
				return getPorts();
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
			case BlockDiagramPackage.INPUT__SPECIFICATION:
				setSpecification((InputSpecification)newValue);
				return;
			case BlockDiagramPackage.INPUT__BLOCK:
				setBlock((Block)newValue);
				return;
			case BlockDiagramPackage.INPUT__PORTS:
				getPorts().clear();
				getPorts().addAll((Collection<? extends InputPort>)newValue);
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
			case BlockDiagramPackage.INPUT__SPECIFICATION:
				setSpecification((InputSpecification)null);
				return;
			case BlockDiagramPackage.INPUT__BLOCK:
				setBlock((Block)null);
				return;
			case BlockDiagramPackage.INPUT__PORTS:
				getPorts().clear();
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
			case BlockDiagramPackage.INPUT__SPECIFICATION:
				return specification != null;
			case BlockDiagramPackage.INPUT__BLOCK:
				return getBlock() != null;
			case BlockDiagramPackage.INPUT__PORTS:
				return ports != null && !ports.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InputImpl
