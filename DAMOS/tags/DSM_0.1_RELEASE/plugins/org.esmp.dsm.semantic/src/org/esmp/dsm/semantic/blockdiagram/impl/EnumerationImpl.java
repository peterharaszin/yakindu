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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;
import org.esmp.dsm.semantic.blockdiagram.Enumeration;
import org.esmp.dsm.semantic.blockdiagram.EnumerationLiteral;
import org.esmp.dsm.semantic.blockdiagram.EnumerationLiteralOrder;
import org.esmp.dsm.semantic.blockdiagram.internal.operations.EnumerationOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.EnumerationImpl#getOwnedLiterals <em>Owned Literals</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.EnumerationImpl#getInheritedLiterals <em>Inherited Literals</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.EnumerationImpl#getLiteralOrder <em>Literal Order</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.EnumerationImpl#getLiterals <em>Literals</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.EnumerationImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumerationImpl extends NamedElementImpl implements Enumeration {
	/**
	 * The cached value of the '{@link #getOwnedLiterals() <em>Owned Literals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedLiterals()
	 * @generated
	 * @ordered
	 */
	protected EList<EnumerationLiteral> ownedLiterals;

	/**
	 * The cached value of the '{@link #getInheritedLiterals() <em>Inherited Literals</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritedLiterals()
	 * @generated
	 * @ordered
	 */
	protected EList<EnumerationLiteral> inheritedLiterals;

	/**
	 * The default value of the '{@link #getLiteralOrder() <em>Literal Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiteralOrder()
	 * @generated
	 * @ordered
	 */
	protected static final EnumerationLiteralOrder LITERAL_ORDER_EDEFAULT = EnumerationLiteralOrder.INHERITED_FIRST;

	/**
	 * The cached value of the '{@link #getLiteralOrder() <em>Literal Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiteralOrder()
	 * @generated
	 * @ordered
	 */
	protected EnumerationLiteralOrder literalOrder = LITERAL_ORDER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumerationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BlockDiagramPackage.Literals.ENUMERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EnumerationLiteral> getOwnedLiterals() {
		if (ownedLiterals == null) {
			ownedLiterals = new EObjectContainmentEList<EnumerationLiteral>(EnumerationLiteral.class, this, BlockDiagramPackage.ENUMERATION__OWNED_LITERALS);
		}
		return ownedLiterals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EnumerationLiteral> getInheritedLiterals() {
		if (inheritedLiterals == null) {
			inheritedLiterals = new EObjectResolvingEList<EnumerationLiteral>(EnumerationLiteral.class, this, BlockDiagramPackage.ENUMERATION__INHERITED_LITERALS);
		}
		return inheritedLiterals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationLiteralOrder getLiteralOrder() {
		return literalOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiteralOrder(EnumerationLiteralOrder newLiteralOrder) {
		EnumerationLiteralOrder oldLiteralOrder = literalOrder;
		literalOrder = newLiteralOrder == null ? LITERAL_ORDER_EDEFAULT : newLiteralOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlockDiagramPackage.ENUMERATION__LITERAL_ORDER, oldLiteralOrder, literalOrder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<EnumerationLiteral> getLiterals() {
		return EnumerationOperations.getLiterals(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getName() {
		return EnumerationOperations.getName(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetName() {
		return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BlockDiagramPackage.ENUMERATION__OWNED_LITERALS:
				return ((InternalEList<?>)getOwnedLiterals()).basicRemove(otherEnd, msgs);
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
			case BlockDiagramPackage.ENUMERATION__OWNED_LITERALS:
				return getOwnedLiterals();
			case BlockDiagramPackage.ENUMERATION__INHERITED_LITERALS:
				return getInheritedLiterals();
			case BlockDiagramPackage.ENUMERATION__LITERAL_ORDER:
				return getLiteralOrder();
			case BlockDiagramPackage.ENUMERATION__LITERALS:
				return getLiterals();
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
			case BlockDiagramPackage.ENUMERATION__OWNED_LITERALS:
				getOwnedLiterals().clear();
				getOwnedLiterals().addAll((Collection<? extends EnumerationLiteral>)newValue);
				return;
			case BlockDiagramPackage.ENUMERATION__INHERITED_LITERALS:
				getInheritedLiterals().clear();
				getInheritedLiterals().addAll((Collection<? extends EnumerationLiteral>)newValue);
				return;
			case BlockDiagramPackage.ENUMERATION__LITERAL_ORDER:
				setLiteralOrder((EnumerationLiteralOrder)newValue);
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
			case BlockDiagramPackage.ENUMERATION__OWNED_LITERALS:
				getOwnedLiterals().clear();
				return;
			case BlockDiagramPackage.ENUMERATION__INHERITED_LITERALS:
				getInheritedLiterals().clear();
				return;
			case BlockDiagramPackage.ENUMERATION__LITERAL_ORDER:
				setLiteralOrder(LITERAL_ORDER_EDEFAULT);
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
			case BlockDiagramPackage.ENUMERATION__OWNED_LITERALS:
				return ownedLiterals != null && !ownedLiterals.isEmpty();
			case BlockDiagramPackage.ENUMERATION__INHERITED_LITERALS:
				return inheritedLiterals != null && !inheritedLiterals.isEmpty();
			case BlockDiagramPackage.ENUMERATION__LITERAL_ORDER:
				return literalOrder != LITERAL_ORDER_EDEFAULT;
			case BlockDiagramPackage.ENUMERATION__LITERALS:
				return !getLiterals().isEmpty();
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
		result.append(" (literalOrder: ");
		result.append(literalOrder);
		result.append(')');
		return result.toString();
	}

} //EnumerationImpl
