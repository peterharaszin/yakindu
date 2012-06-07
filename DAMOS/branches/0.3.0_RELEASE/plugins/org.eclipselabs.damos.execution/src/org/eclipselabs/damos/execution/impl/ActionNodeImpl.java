/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.damos.execution.ActionNode;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.ExecutionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.impl.ActionNodeImpl#getChoiceNode <em>Choice Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActionNodeImpl extends CompoundNodeImpl implements ActionNode {
	/**
	 * The cached value of the '{@link #getChoiceNode() <em>Choice Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChoiceNode()
	 * @generated
	 * @ordered
	 */
	protected ComponentNode choiceNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionPackage.Literals.ACTION_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentNode getChoiceNode() {
		if (choiceNode != null && choiceNode.eIsProxy()) {
			InternalEObject oldChoiceNode = (InternalEObject)choiceNode;
			choiceNode = (ComponentNode)eResolveProxy(oldChoiceNode);
			if (choiceNode != oldChoiceNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionPackage.ACTION_NODE__CHOICE_NODE, oldChoiceNode, choiceNode));
			}
		}
		return choiceNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentNode basicGetChoiceNode() {
		return choiceNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChoiceNode(ComponentNode newChoiceNode) {
		ComponentNode oldChoiceNode = choiceNode;
		choiceNode = newChoiceNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionPackage.ACTION_NODE__CHOICE_NODE, oldChoiceNode, choiceNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExecutionPackage.ACTION_NODE__CHOICE_NODE:
				if (resolve) return getChoiceNode();
				return basicGetChoiceNode();
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
			case ExecutionPackage.ACTION_NODE__CHOICE_NODE:
				setChoiceNode((ComponentNode)newValue);
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
			case ExecutionPackage.ACTION_NODE__CHOICE_NODE:
				setChoiceNode((ComponentNode)null);
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
			case ExecutionPackage.ACTION_NODE__CHOICE_NODE:
				return choiceNode != null;
		}
		return super.eIsSet(featureID);
	}

} //ActionNodeImpl
