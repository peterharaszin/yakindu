/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.function.impl;

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
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.function.EquationDescription;
import org.eclipselabs.damos.mscript.function.EquationPart;
import org.eclipselabs.damos.mscript.function.EquationSide;
import org.eclipselabs.damos.mscript.function.FunctionModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equation Side</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.function.impl.EquationSideImpl#getEquationDescription <em>Equation Description</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.function.impl.EquationSideImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.function.impl.EquationSideImpl#getParts <em>Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EquationSideImpl extends EObjectImpl implements EquationSide {
	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression expression;
	/**
	 * The cached value of the '{@link #getParts() <em>Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParts()
	 * @generated
	 * @ordered
	 */
	protected EList<EquationPart> parts;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EquationSideImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionModelPackage.Literals.EQUATION_SIDE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquationDescription getEquationDescription() {
		if (eContainerFeatureID() != FunctionModelPackage.EQUATION_SIDE__EQUATION_DESCRIPTION) return null;
		return (EquationDescription)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEquationDescription(EquationDescription newEquationDescription, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newEquationDescription, FunctionModelPackage.EQUATION_SIDE__EQUATION_DESCRIPTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEquationDescription(EquationDescription newEquationDescription) {
		if (newEquationDescription != eInternalContainer() || (eContainerFeatureID() != FunctionModelPackage.EQUATION_SIDE__EQUATION_DESCRIPTION && newEquationDescription != null)) {
			if (EcoreUtil.isAncestor(this, newEquationDescription))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newEquationDescription != null)
				msgs = ((InternalEObject)newEquationDescription).eInverseAdd(this, FunctionModelPackage.EQUATION_DESCRIPTION__SIDES, EquationDescription.class, msgs);
			msgs = basicSetEquationDescription(newEquationDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionModelPackage.EQUATION_SIDE__EQUATION_DESCRIPTION, newEquationDescription, newEquationDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExpression() {
		if (expression != null && expression.eIsProxy()) {
			InternalEObject oldExpression = (InternalEObject)expression;
			expression = (Expression)eResolveProxy(oldExpression);
			if (expression != oldExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FunctionModelPackage.EQUATION_SIDE__EXPRESSION, oldExpression, expression));
			}
		}
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression basicGetExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(Expression newExpression) {
		Expression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionModelPackage.EQUATION_SIDE__EXPRESSION, oldExpression, expression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EquationPart> getParts() {
		if (parts == null) {
			parts = new EObjectContainmentWithInverseEList<EquationPart>(EquationPart.class, this, FunctionModelPackage.EQUATION_SIDE__PARTS, FunctionModelPackage.EQUATION_PART__SIDE);
		}
		return parts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EquationSide getOtherSide() {
		EquationDescription descriptor = getEquationDescription();
		return descriptor.getLeftHandSide() == this ? descriptor.getRightHandSide() : descriptor.getLeftHandSide();
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
			case FunctionModelPackage.EQUATION_SIDE__EQUATION_DESCRIPTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetEquationDescription((EquationDescription)otherEnd, msgs);
			case FunctionModelPackage.EQUATION_SIDE__PARTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParts()).basicAdd(otherEnd, msgs);
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
			case FunctionModelPackage.EQUATION_SIDE__EQUATION_DESCRIPTION:
				return basicSetEquationDescription(null, msgs);
			case FunctionModelPackage.EQUATION_SIDE__PARTS:
				return ((InternalEList<?>)getParts()).basicRemove(otherEnd, msgs);
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
			case FunctionModelPackage.EQUATION_SIDE__EQUATION_DESCRIPTION:
				return eInternalContainer().eInverseRemove(this, FunctionModelPackage.EQUATION_DESCRIPTION__SIDES, EquationDescription.class, msgs);
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
			case FunctionModelPackage.EQUATION_SIDE__EQUATION_DESCRIPTION:
				return getEquationDescription();
			case FunctionModelPackage.EQUATION_SIDE__EXPRESSION:
				if (resolve) return getExpression();
				return basicGetExpression();
			case FunctionModelPackage.EQUATION_SIDE__PARTS:
				return getParts();
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
			case FunctionModelPackage.EQUATION_SIDE__EQUATION_DESCRIPTION:
				setEquationDescription((EquationDescription)newValue);
				return;
			case FunctionModelPackage.EQUATION_SIDE__EXPRESSION:
				setExpression((Expression)newValue);
				return;
			case FunctionModelPackage.EQUATION_SIDE__PARTS:
				getParts().clear();
				getParts().addAll((Collection<? extends EquationPart>)newValue);
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
			case FunctionModelPackage.EQUATION_SIDE__EQUATION_DESCRIPTION:
				setEquationDescription((EquationDescription)null);
				return;
			case FunctionModelPackage.EQUATION_SIDE__EXPRESSION:
				setExpression((Expression)null);
				return;
			case FunctionModelPackage.EQUATION_SIDE__PARTS:
				getParts().clear();
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
			case FunctionModelPackage.EQUATION_SIDE__EQUATION_DESCRIPTION:
				return getEquationDescription() != null;
			case FunctionModelPackage.EQUATION_SIDE__EXPRESSION:
				return expression != null;
			case FunctionModelPackage.EQUATION_SIDE__PARTS:
				return parts != null && !parts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EquationSideImpl
