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
import org.esmp.dsm.semantic.blockdiagram.Output;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;
import org.esmp.dsm.semantic.blockdiagram.OutputSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Output</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.OutputImpl#getSpecification <em>Specification</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.OutputImpl#getBlock <em>Block</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.OutputImpl#getPorts <em>Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutputImpl extends EObjectImpl implements Output {
	/**
	 * The cached value of the '{@link #getSpecification() <em>Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecification()
	 * @generated
	 * @ordered
	 */
	protected OutputSpecification specification;

	/**
	 * The cached value of the '{@link #getPorts() <em>Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputPort> ports;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutputImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BlockDiagramPackage.Literals.OUTPUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputPort> getPorts() {
		if (ports == null) {
			ports = new EObjectContainmentWithInverseEList<OutputPort>(OutputPort.class, this, BlockDiagramPackage.OUTPUT__PORTS, BlockDiagramPackage.OUTPUT_PORT__OUTPUT);
		}
		return ports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block getBlock() {
		if (eContainerFeatureID() != BlockDiagramPackage.OUTPUT__BLOCK) return null;
		return (Block)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBlock(Block newBlock, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newBlock, BlockDiagramPackage.OUTPUT__BLOCK, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlock(Block newBlock) {
		if (newBlock != eInternalContainer() || (eContainerFeatureID() != BlockDiagramPackage.OUTPUT__BLOCK && newBlock != null)) {
			if (EcoreUtil.isAncestor(this, newBlock))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newBlock != null)
				msgs = ((InternalEObject)newBlock).eInverseAdd(this, BlockDiagramPackage.BLOCK__OUTPUTS, Block.class, msgs);
			msgs = basicSetBlock(newBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlockDiagramPackage.OUTPUT__BLOCK, newBlock, newBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputSpecification getSpecification() {
		if (specification != null && specification.eIsProxy()) {
			InternalEObject oldSpecification = (InternalEObject)specification;
			specification = (OutputSpecification)eResolveProxy(oldSpecification);
			if (specification != oldSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BlockDiagramPackage.OUTPUT__SPECIFICATION, oldSpecification, specification));
			}
		}
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputSpecification basicGetSpecification() {
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecification(OutputSpecification newSpecification) {
		OutputSpecification oldSpecification = specification;
		specification = newSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlockDiagramPackage.OUTPUT__SPECIFICATION, oldSpecification, specification));
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
			case BlockDiagramPackage.OUTPUT__BLOCK:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetBlock((Block)otherEnd, msgs);
			case BlockDiagramPackage.OUTPUT__PORTS:
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
			case BlockDiagramPackage.OUTPUT__BLOCK:
				return basicSetBlock(null, msgs);
			case BlockDiagramPackage.OUTPUT__PORTS:
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
			case BlockDiagramPackage.OUTPUT__BLOCK:
				return eInternalContainer().eInverseRemove(this, BlockDiagramPackage.BLOCK__OUTPUTS, Block.class, msgs);
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
			case BlockDiagramPackage.OUTPUT__SPECIFICATION:
				if (resolve) return getSpecification();
				return basicGetSpecification();
			case BlockDiagramPackage.OUTPUT__BLOCK:
				return getBlock();
			case BlockDiagramPackage.OUTPUT__PORTS:
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
			case BlockDiagramPackage.OUTPUT__SPECIFICATION:
				setSpecification((OutputSpecification)newValue);
				return;
			case BlockDiagramPackage.OUTPUT__BLOCK:
				setBlock((Block)newValue);
				return;
			case BlockDiagramPackage.OUTPUT__PORTS:
				getPorts().clear();
				getPorts().addAll((Collection<? extends OutputPort>)newValue);
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
			case BlockDiagramPackage.OUTPUT__SPECIFICATION:
				setSpecification((OutputSpecification)null);
				return;
			case BlockDiagramPackage.OUTPUT__BLOCK:
				setBlock((Block)null);
				return;
			case BlockDiagramPackage.OUTPUT__PORTS:
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
			case BlockDiagramPackage.OUTPUT__SPECIFICATION:
				return specification != null;
			case BlockDiagramPackage.OUTPUT__BLOCK:
				return getBlock() != null;
			case BlockDiagramPackage.OUTPUT__PORTS:
				return ports != null && !ports.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OutputImpl
