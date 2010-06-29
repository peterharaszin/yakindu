/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;
import org.esmp.dsm.semantic.blockdiagram.InputSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.InputSpecificationImpl#getDirectFeedthroughExpression <em>Direct Feedthrough Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InputSpecificationImpl extends IOSpecificationImpl implements InputSpecification {
	/**
	 * The default value of the '{@link #getDirectFeedthroughExpression() <em>Direct Feedthrough Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirectFeedthroughExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String DIRECT_FEEDTHROUGH_EXPRESSION_EDEFAULT = "true";

	/**
	 * The cached value of the '{@link #getDirectFeedthroughExpression() <em>Direct Feedthrough Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirectFeedthroughExpression()
	 * @generated
	 * @ordered
	 */
	protected String directFeedthroughExpression = DIRECT_FEEDTHROUGH_EXPRESSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BlockDiagramPackage.Literals.INPUT_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDirectFeedthroughExpression() {
		return directFeedthroughExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirectFeedthroughExpression(String newDirectFeedthroughExpression) {
		String oldDirectFeedthroughExpression = directFeedthroughExpression;
		directFeedthroughExpression = newDirectFeedthroughExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlockDiagramPackage.INPUT_SPECIFICATION__DIRECT_FEEDTHROUGH_EXPRESSION, oldDirectFeedthroughExpression, directFeedthroughExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BlockDiagramPackage.INPUT_SPECIFICATION__DIRECT_FEEDTHROUGH_EXPRESSION:
				return getDirectFeedthroughExpression();
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
			case BlockDiagramPackage.INPUT_SPECIFICATION__DIRECT_FEEDTHROUGH_EXPRESSION:
				setDirectFeedthroughExpression((String)newValue);
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
			case BlockDiagramPackage.INPUT_SPECIFICATION__DIRECT_FEEDTHROUGH_EXPRESSION:
				setDirectFeedthroughExpression(DIRECT_FEEDTHROUGH_EXPRESSION_EDEFAULT);
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
			case BlockDiagramPackage.INPUT_SPECIFICATION__DIRECT_FEEDTHROUGH_EXPRESSION:
				return DIRECT_FEEDTHROUGH_EXPRESSION_EDEFAULT == null ? directFeedthroughExpression != null : !DIRECT_FEEDTHROUGH_EXPRESSION_EDEFAULT.equals(directFeedthroughExpression);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (directFeedthroughExpression: ");
		result.append(directFeedthroughExpression);
		result.append(')');
		return result.toString();
	}

} //InputSpecificationImpl
