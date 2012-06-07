/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.BlockInputPort;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.InputDefinition;
import org.eclipselabs.damos.dml.internal.operations.BlockInputOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block Input</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.impl.BlockInputImpl#getDefinition <em>Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BlockInputImpl extends InputImpl implements BlockInput {
	/**
	 * The cached value of the '{@link #getDefinition() <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinition()
	 * @generated
	 * @ordered
	 */
	protected InputDefinition definition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockInputImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.BLOCK_INPUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputDefinition getDefinition() {
		if (definition != null && definition.eIsProxy()) {
			InternalEObject oldDefinition = (InternalEObject)definition;
			definition = (InputDefinition)eResolveProxy(oldDefinition);
			if (definition != oldDefinition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DMLPackage.BLOCK_INPUT__DEFINITION, oldDefinition, definition));
			}
		}
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputDefinition basicGetDefinition() {
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinition(InputDefinition newDefinition) {
		InputDefinition oldDefinition = definition;
		definition = newDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.BLOCK_INPUT__DEFINITION, oldDefinition, definition));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.impl.InputImpl#getName()
	 */
	@Override
	public String getName() {
		return getDefinition().getName();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.impl.InoutputImpl#canAddPort()
	 */
	@Override
	public boolean canAddPort() {
		int maximumPortCount = getDefinition().getMaximumPortCount();
		return maximumPortCount == -1 || getPorts().size() < maximumPortCount;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.impl.InoutputImpl#canRemovePort()
	 */
	@Override
	public boolean canRemovePort() {
		return getPorts().size() > getDefinition().getMinimumPortCount();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.impl.InputImpl#createPort()
	 */
	@Override
	public BlockInputPort createPort() {
		return BlockInputOperations.createPort(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean isDirectFeedthrough() {
		return BlockInputOperations.isDirectFeedthrough(this);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.impl.InoutputImpl#isTestPoint()
	 */
	@Override
	public boolean isTestPoint() {
		return getDefinition().isTestPoint();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.impl.InoutputImpl#isSocket()
	 */
	@Override
	public boolean isSocket() {
		return getDefinition().isSocket();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DMLPackage.BLOCK_INPUT__DEFINITION:
				if (resolve) return getDefinition();
				return basicGetDefinition();
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
			case DMLPackage.BLOCK_INPUT__DEFINITION:
				setDefinition((InputDefinition)newValue);
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
			case DMLPackage.BLOCK_INPUT__DEFINITION:
				setDefinition((InputDefinition)null);
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
			case DMLPackage.BLOCK_INPUT__DEFINITION:
				return definition != null;
		}
		return super.eIsSet(featureID);
	}

} //BlockInputImpl
