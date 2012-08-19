/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.Unit;
import org.eclipselabs.damos.mscript.UnitFactor;
import org.eclipselabs.damos.mscript.UnitSymbol;
import org.eclipselabs.damos.mscript.internal.operations.UnitOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unit Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.UnitImpl#getScale <em>Scale</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.UnitImpl#isAny <em>Any</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.UnitImpl#getFactors <em>Factors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnitImpl extends MinimalEObjectImpl.Container implements Unit {
	/**
	 * The default value of the '{@link #getScale() <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScale()
	 * @generated
	 * @ordered
	 */
	protected static final int SCALE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getScale() <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScale()
	 * @generated
	 * @ordered
	 */
	protected int scale = SCALE_EDEFAULT;

	/**
	 * The default value of the '{@link #isAny() <em>Any</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAny()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ANY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAny() <em>Any</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAny()
	 * @generated
	 * @ordered
	 */
	protected boolean any = ANY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFactors() <em>Factors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactors()
	 * @generated
	 * @ordered
	 */
	protected EList<UnitFactor> factors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getScale() {
		return scale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScale(int newScale) {
		int oldScale = scale;
		scale = newScale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.UNIT__SCALE, oldScale, scale));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAny() {
		return any;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAny(boolean newAny) {
		boolean oldAny = any;
		any = newAny;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.UNIT__ANY, oldAny, any));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnitFactor> getFactors() {
		if (factors == null) {
			factors = new EObjectContainmentEList<UnitFactor>(UnitFactor.class, this, MscriptPackage.UNIT__FACTORS);
		}
		return factors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public UnitFactor getFactor(String symbolName) {
		for (UnitFactor factor : getFactors()) {
			UnitSymbol symbol = factor.getSymbol();
			if (symbol != null && symbolName.equals(symbol.getName())) {
				return factor;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public UnitFactor getFactor(UnitSymbol symbol) {
		for (UnitFactor factor : getFactors()) {
			if (symbol == factor.getSymbol()) {
				return factor;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Unit getNormalized() {
		return UnitOperations.getNormalized(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Unit evaluate(OperatorKind operator, Unit other) {
		return UnitOperations.evaluate(this, operator, other);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Unit evaluate(OperatorKind operator, int n) {
		return UnitOperations.evaluate(this, operator, n);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isEquivalentTo(Unit other, boolean ignoreScale) {
		return UnitOperations.isEquivalentTo(this, other, ignoreScale);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MscriptPackage.UNIT__FACTORS:
				return ((InternalEList<?>)getFactors()).basicRemove(otherEnd, msgs);
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
			case MscriptPackage.UNIT__SCALE:
				return getScale();
			case MscriptPackage.UNIT__ANY:
				return isAny();
			case MscriptPackage.UNIT__FACTORS:
				return getFactors();
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
			case MscriptPackage.UNIT__SCALE:
				setScale((Integer)newValue);
				return;
			case MscriptPackage.UNIT__ANY:
				setAny((Boolean)newValue);
				return;
			case MscriptPackage.UNIT__FACTORS:
				getFactors().clear();
				getFactors().addAll((Collection<? extends UnitFactor>)newValue);
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
			case MscriptPackage.UNIT__SCALE:
				setScale(SCALE_EDEFAULT);
				return;
			case MscriptPackage.UNIT__ANY:
				setAny(ANY_EDEFAULT);
				return;
			case MscriptPackage.UNIT__FACTORS:
				getFactors().clear();
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
			case MscriptPackage.UNIT__SCALE:
				return scale != SCALE_EDEFAULT;
			case MscriptPackage.UNIT__ANY:
				return any != ANY_EDEFAULT;
			case MscriptPackage.UNIT__FACTORS:
				return factors != null && !factors.isEmpty();
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
		result.append(" (scale: ");
		result.append(scale);
		result.append(", any: ");
		result.append(any);
		result.append(')');
		return result.toString();
	}

} //UnitExpressionImpl
