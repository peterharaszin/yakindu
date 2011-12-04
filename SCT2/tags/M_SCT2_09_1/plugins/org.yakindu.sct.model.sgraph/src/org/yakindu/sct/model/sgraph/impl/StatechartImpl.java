/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sgraph.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.ExpressionElement;
import org.yakindu.sct.model.sgraph.Reaction;
import org.yakindu.sct.model.sgraph.ReactiveElement;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.ScopedElement;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Statechart</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StatechartImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StatechartImpl#getReactions <em>Reactions</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StatechartImpl#getLocalReactions <em>Local Reactions</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StatechartImpl#getScopes <em>Scopes</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StatechartImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StatechartImpl#getRegions <em>Regions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StatechartImpl extends NamedElementImpl implements Statechart {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2011 committers of YAKINDU and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\nContributors:\r\ncommitters of YAKINDU - initial API and implementation\r\n";

	/**
	 * The default value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected String expression = EXPRESSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getScopes() <em>Scopes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScopes()
	 * @generated
	 * @ordered
	 */
	protected EList<Scope> scopes;

	/**
	 * The default value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected static final String NAMESPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected String namespace = NAMESPACE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRegions() <em>Regions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegions()
	 * @generated
	 * @ordered
	 */
	protected EList<Region> regions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatechartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SGraphPackage.Literals.STATECHART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(String newExpression) {
		String oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SGraphPackage.STATECHART__EXPRESSION, oldExpression, expression));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Reaction> getReactions() {
		EList<Reaction> result = new BasicEList<Reaction>();
		result.addAll(getLocalReactions());
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Reaction> getLocalReactions() {
		EList<Reaction> result = new BasicEList<Reaction>();
		EList<Scope> scopes = getScopes();
		for (Scope scope : scopes) {
			EList<Declaration> declarations = scope.getDeclarations();
			for (Declaration declaration : declarations) {
				if (declaration instanceof Reaction) {
					result.add((Reaction) declaration);
				}
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Scope> getScopes() {
		if (scopes == null) {
			scopes = new EObjectContainmentEList<Scope>(Scope.class, this, SGraphPackage.STATECHART__SCOPES);
		}
		return scopes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespace(String newNamespace) {
		String oldNamespace = namespace;
		namespace = newNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SGraphPackage.STATECHART__NAMESPACE, oldNamespace, namespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Region> getRegions() {
		if (regions == null) {
			regions = new EObjectContainmentEList<Region>(Region.class, this, SGraphPackage.STATECHART__REGIONS);
		}
		return regions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SGraphPackage.STATECHART__SCOPES:
				return ((InternalEList<?>)getScopes()).basicRemove(otherEnd, msgs);
			case SGraphPackage.STATECHART__REGIONS:
				return ((InternalEList<?>)getRegions()).basicRemove(otherEnd, msgs);
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
			case SGraphPackage.STATECHART__EXPRESSION:
				return getExpression();
			case SGraphPackage.STATECHART__REACTIONS:
				return getReactions();
			case SGraphPackage.STATECHART__LOCAL_REACTIONS:
				return getLocalReactions();
			case SGraphPackage.STATECHART__SCOPES:
				return getScopes();
			case SGraphPackage.STATECHART__NAMESPACE:
				return getNamespace();
			case SGraphPackage.STATECHART__REGIONS:
				return getRegions();
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
			case SGraphPackage.STATECHART__EXPRESSION:
				setExpression((String)newValue);
				return;
			case SGraphPackage.STATECHART__SCOPES:
				getScopes().clear();
				getScopes().addAll((Collection<? extends Scope>)newValue);
				return;
			case SGraphPackage.STATECHART__NAMESPACE:
				setNamespace((String)newValue);
				return;
			case SGraphPackage.STATECHART__REGIONS:
				getRegions().clear();
				getRegions().addAll((Collection<? extends Region>)newValue);
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
			case SGraphPackage.STATECHART__EXPRESSION:
				setExpression(EXPRESSION_EDEFAULT);
				return;
			case SGraphPackage.STATECHART__SCOPES:
				getScopes().clear();
				return;
			case SGraphPackage.STATECHART__NAMESPACE:
				setNamespace(NAMESPACE_EDEFAULT);
				return;
			case SGraphPackage.STATECHART__REGIONS:
				getRegions().clear();
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
			case SGraphPackage.STATECHART__EXPRESSION:
				return EXPRESSION_EDEFAULT == null ? expression != null : !EXPRESSION_EDEFAULT.equals(expression);
			case SGraphPackage.STATECHART__REACTIONS:
				return !getReactions().isEmpty();
			case SGraphPackage.STATECHART__LOCAL_REACTIONS:
				return !getLocalReactions().isEmpty();
			case SGraphPackage.STATECHART__SCOPES:
				return scopes != null && !scopes.isEmpty();
			case SGraphPackage.STATECHART__NAMESPACE:
				return NAMESPACE_EDEFAULT == null ? namespace != null : !NAMESPACE_EDEFAULT.equals(namespace);
			case SGraphPackage.STATECHART__REGIONS:
				return regions != null && !regions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ExpressionElement.class) {
			switch (derivedFeatureID) {
				case SGraphPackage.STATECHART__EXPRESSION: return SGraphPackage.EXPRESSION_ELEMENT__EXPRESSION;
				default: return -1;
			}
		}
		if (baseClass == ReactiveElement.class) {
			switch (derivedFeatureID) {
				case SGraphPackage.STATECHART__REACTIONS: return SGraphPackage.REACTIVE_ELEMENT__REACTIONS;
				case SGraphPackage.STATECHART__LOCAL_REACTIONS: return SGraphPackage.REACTIVE_ELEMENT__LOCAL_REACTIONS;
				default: return -1;
			}
		}
		if (baseClass == ScopedElement.class) {
			switch (derivedFeatureID) {
				case SGraphPackage.STATECHART__SCOPES: return SGraphPackage.SCOPED_ELEMENT__SCOPES;
				case SGraphPackage.STATECHART__NAMESPACE: return SGraphPackage.SCOPED_ELEMENT__NAMESPACE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ExpressionElement.class) {
			switch (baseFeatureID) {
				case SGraphPackage.EXPRESSION_ELEMENT__EXPRESSION: return SGraphPackage.STATECHART__EXPRESSION;
				default: return -1;
			}
		}
		if (baseClass == ReactiveElement.class) {
			switch (baseFeatureID) {
				case SGraphPackage.REACTIVE_ELEMENT__REACTIONS: return SGraphPackage.STATECHART__REACTIONS;
				case SGraphPackage.REACTIVE_ELEMENT__LOCAL_REACTIONS: return SGraphPackage.STATECHART__LOCAL_REACTIONS;
				default: return -1;
			}
		}
		if (baseClass == ScopedElement.class) {
			switch (baseFeatureID) {
				case SGraphPackage.SCOPED_ELEMENT__SCOPES: return SGraphPackage.STATECHART__SCOPES;
				case SGraphPackage.SCOPED_ELEMENT__NAMESPACE: return SGraphPackage.STATECHART__NAMESPACE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (expression: ");
		result.append(expression);
		result.append(", namespace: ");
		result.append(namespace);
		result.append(')');
		return result.toString();
	}

} //StatechartImpl
