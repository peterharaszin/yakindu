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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;
import org.esmp.dsm.semantic.blockdiagram.Enumeration;
import org.esmp.dsm.semantic.blockdiagram.EnumerationLiteral;
import org.esmp.dsm.semantic.blockdiagram.EnumerationOrder;
import org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumeration Parameter Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.EnumerationParameterDescriptorImpl#getOwnedEnumeration <em>Owned Enumeration</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.EnumerationParameterDescriptorImpl#getInheritedEnumerations <em>Inherited Enumerations</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.EnumerationParameterDescriptorImpl#getDefaultLiteral <em>Default Literal</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.EnumerationParameterDescriptorImpl#isExclusive <em>Exclusive</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.EnumerationParameterDescriptorImpl#getEnumerationOrder <em>Enumeration Order</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.EnumerationParameterDescriptorImpl#getLiterals <em>Literals</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumerationParameterDescriptorImpl extends ParameterDescriptorImpl implements EnumerationParameterDescriptor {
	/**
	 * The cached value of the '{@link #getOwnedEnumeration() <em>Owned Enumeration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedEnumeration()
	 * @generated
	 * @ordered
	 */
	protected Enumeration ownedEnumeration;

	/**
	 * The cached value of the '{@link #getInheritedEnumerations() <em>Inherited Enumerations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritedEnumerations()
	 * @generated
	 * @ordered
	 */
	protected EList<Enumeration> inheritedEnumerations;

	/**
	 * The cached value of the '{@link #getDefaultLiteral() <em>Default Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultLiteral()
	 * @generated
	 * @ordered
	 */
	protected EnumerationLiteral defaultLiteral;

	/**
	 * The default value of the '{@link #isExclusive() <em>Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExclusive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXCLUSIVE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isExclusive() <em>Exclusive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExclusive()
	 * @generated
	 * @ordered
	 */
	protected boolean exclusive = EXCLUSIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnumerationOrder() <em>Enumeration Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumerationOrder()
	 * @generated
	 * @ordered
	 */
	protected static final EnumerationOrder ENUMERATION_ORDER_EDEFAULT = EnumerationOrder.OWNED_FIRST;

	/**
	 * The cached value of the '{@link #getEnumerationOrder() <em>Enumeration Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumerationOrder()
	 * @generated
	 * @ordered
	 */
	protected EnumerationOrder enumerationOrder = ENUMERATION_ORDER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumerationParameterDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BlockDiagramPackage.Literals.ENUMERATION_PARAMETER_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enumeration getOwnedEnumeration() {
		return ownedEnumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedEnumeration(Enumeration newOwnedEnumeration, NotificationChain msgs) {
		Enumeration oldOwnedEnumeration = ownedEnumeration;
		ownedEnumeration = newOwnedEnumeration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__OWNED_ENUMERATION, oldOwnedEnumeration, newOwnedEnumeration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedEnumeration(Enumeration newOwnedEnumeration) {
		if (newOwnedEnumeration != ownedEnumeration) {
			NotificationChain msgs = null;
			if (ownedEnumeration != null)
				msgs = ((InternalEObject)ownedEnumeration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__OWNED_ENUMERATION, null, msgs);
			if (newOwnedEnumeration != null)
				msgs = ((InternalEObject)newOwnedEnumeration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__OWNED_ENUMERATION, null, msgs);
			msgs = basicSetOwnedEnumeration(newOwnedEnumeration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__OWNED_ENUMERATION, newOwnedEnumeration, newOwnedEnumeration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Enumeration> getInheritedEnumerations() {
		if (inheritedEnumerations == null) {
			inheritedEnumerations = new EObjectResolvingEList<Enumeration>(Enumeration.class, this, BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__INHERITED_ENUMERATIONS);
		}
		return inheritedEnumerations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<EnumerationLiteral> getLiterals() {
		EList<EnumerationLiteral> literals = new BasicEList<EnumerationLiteral>();
		if (getEnumerationOrder() == EnumerationOrder.OWNED_FIRST && getOwnedEnumeration() != null) {
			literals.addAll(getOwnedEnumeration().getLiterals());
		}
		for (Enumeration enumeration : getInheritedEnumerations()) {
			literals.addAll(enumeration.getLiterals());
		}
		if (getEnumerationOrder() == EnumerationOrder.INHERITED_FIRST && getOwnedEnumeration() != null) {
			literals.addAll(getOwnedEnumeration().getLiterals());
		}
		return literals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationLiteral getDefaultLiteral() {
		if (defaultLiteral != null && defaultLiteral.eIsProxy()) {
			InternalEObject oldDefaultLiteral = (InternalEObject)defaultLiteral;
			defaultLiteral = (EnumerationLiteral)eResolveProxy(oldDefaultLiteral);
			if (defaultLiteral != oldDefaultLiteral) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__DEFAULT_LITERAL, oldDefaultLiteral, defaultLiteral));
			}
		}
		return defaultLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationLiteral basicGetDefaultLiteral() {
		return defaultLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultLiteral(EnumerationLiteral newDefaultLiteral) {
		EnumerationLiteral oldDefaultLiteral = defaultLiteral;
		defaultLiteral = newDefaultLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__DEFAULT_LITERAL, oldDefaultLiteral, defaultLiteral));
	}

	public String getDefaultValue() {
		EnumerationLiteral defaultLiteral = getDefaultLiteral();
		if (defaultLiteral != null) { 
			return defaultLiteral.getValue();
		}
		return "";
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExclusive() {
		return exclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExclusive(boolean newExclusive) {
		boolean oldExclusive = exclusive;
		exclusive = newExclusive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__EXCLUSIVE, oldExclusive, exclusive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationOrder getEnumerationOrder() {
		return enumerationOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnumerationOrder(EnumerationOrder newEnumerationOrder) {
		EnumerationOrder oldEnumerationOrder = enumerationOrder;
		enumerationOrder = newEnumerationOrder == null ? ENUMERATION_ORDER_EDEFAULT : newEnumerationOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__ENUMERATION_ORDER, oldEnumerationOrder, enumerationOrder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EnumerationLiteral getLiteral(String name) {
		for (EnumerationLiteral literal : getLiterals()) {
			if (name.equals(literal.getName())) {
				return literal;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EnumerationLiteral getLiteralByValue(String value) {
		for (EnumerationLiteral literal : getLiterals()) {
			if (value.equals(literal.getValue())) {
				return literal;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__OWNED_ENUMERATION:
				return basicSetOwnedEnumeration(null, msgs);
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
			case BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__OWNED_ENUMERATION:
				return getOwnedEnumeration();
			case BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__INHERITED_ENUMERATIONS:
				return getInheritedEnumerations();
			case BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__DEFAULT_LITERAL:
				if (resolve) return getDefaultLiteral();
				return basicGetDefaultLiteral();
			case BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__EXCLUSIVE:
				return isExclusive();
			case BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__ENUMERATION_ORDER:
				return getEnumerationOrder();
			case BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__LITERALS:
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
			case BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__OWNED_ENUMERATION:
				setOwnedEnumeration((Enumeration)newValue);
				return;
			case BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__INHERITED_ENUMERATIONS:
				getInheritedEnumerations().clear();
				getInheritedEnumerations().addAll((Collection<? extends Enumeration>)newValue);
				return;
			case BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__DEFAULT_LITERAL:
				setDefaultLiteral((EnumerationLiteral)newValue);
				return;
			case BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__EXCLUSIVE:
				setExclusive((Boolean)newValue);
				return;
			case BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__ENUMERATION_ORDER:
				setEnumerationOrder((EnumerationOrder)newValue);
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
			case BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__OWNED_ENUMERATION:
				setOwnedEnumeration((Enumeration)null);
				return;
			case BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__INHERITED_ENUMERATIONS:
				getInheritedEnumerations().clear();
				return;
			case BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__DEFAULT_LITERAL:
				setDefaultLiteral((EnumerationLiteral)null);
				return;
			case BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__EXCLUSIVE:
				setExclusive(EXCLUSIVE_EDEFAULT);
				return;
			case BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__ENUMERATION_ORDER:
				setEnumerationOrder(ENUMERATION_ORDER_EDEFAULT);
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
			case BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__OWNED_ENUMERATION:
				return ownedEnumeration != null;
			case BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__INHERITED_ENUMERATIONS:
				return inheritedEnumerations != null && !inheritedEnumerations.isEmpty();
			case BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__DEFAULT_LITERAL:
				return defaultLiteral != null;
			case BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__EXCLUSIVE:
				return exclusive != EXCLUSIVE_EDEFAULT;
			case BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__ENUMERATION_ORDER:
				return enumerationOrder != ENUMERATION_ORDER_EDEFAULT;
			case BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR__LITERALS:
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
		result.append(" (exclusive: ");
		result.append(exclusive);
		result.append(", enumerationOrder: ");
		result.append(enumerationOrder);
		result.append(')');
		return result.toString();
	}

} //EnumerationParameterDescriptorImpl
