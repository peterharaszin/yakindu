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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.NamedElement;
import org.yakindu.sct.model.sgraph.Reaction;
import org.yakindu.sct.model.sgraph.ReactiveElement;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.ScopedElement;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>State</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StateImpl#getReactions <em>Reactions</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StateImpl#getLocalReactions <em>Local Reactions</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StateImpl#getScopes <em>Scopes</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StateImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StateImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StateImpl#getParentRegion <em>Parent Region</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StateImpl#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StateImpl#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StateImpl#getSubRegions <em>Sub Regions</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StateImpl#isOrthogonal <em>Orthogonal</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StateImpl#getSubstatechart <em>Substatechart</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StateImpl#getSubstatechartId <em>Substatechart Id</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StateImpl#isSubmachine <em>Submachine</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StateImpl#isSimple <em>Simple</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StateImpl#isComposite <em>Composite</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StateImpl#isLeaf <em>Leaf</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateImpl extends ExpressionElementImpl implements State {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2011 committers of YAKINDU and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\nContributors:\r\ncommitters of YAKINDU - initial API and implementation\r\n";

	/**
	 * The cached value of the '{@link #getScopes() <em>Scopes</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getScopes()
	 * @generated
	 * @ordered
	 */
	protected EList<Scope> scopes;

	/**
	 * The default value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected static final String NAMESPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected String namespace = NAMESPACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIncomingTransitions() <em>Incoming Transitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> incomingTransitions;

	/**
	 * The cached value of the '{@link #getOutgoingTransitions() <em>Outgoing Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> outgoingTransitions;

	/**
	 * The cached value of the '{@link #getSubRegions() <em>Sub Regions</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSubRegions()
	 * @generated
	 * @ordered
	 */
	protected EList<Region> subRegions;

	/**
	 * The default value of the '{@link #isOrthogonal() <em>Orthogonal</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isOrthogonal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ORTHOGONAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #getSubstatechart() <em>Substatechart</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSubstatechart()
	 * @generated
	 * @ordered
	 */
	protected Statechart substatechart;

	/**
	 * The default value of the '{@link #getSubstatechartId() <em>Substatechart Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubstatechartId()
	 * @generated
	 * @ordered
	 */
	protected static final String SUBSTATECHART_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubstatechartId() <em>Substatechart Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubstatechartId()
	 * @generated
	 * @ordered
	 */
	protected String substatechartId = SUBSTATECHART_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #isSubmachine() <em>Submachine</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSubmachine()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SUBMACHINE_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isSimple() <em>Simple</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSimple()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SIMPLE_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isComposite() <em>Composite</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isComposite()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMPOSITE_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isLeaf() <em>Leaf</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isLeaf()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LEAF_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected StateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SGraphPackage.Literals.STATE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Reaction> getReactions() {
		EList<Reaction> result = new BasicEList<Reaction>();
		result.addAll(getOutgoingTransitions());
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Scope> getScopes() {
		if (scopes == null) {
			scopes = new EObjectContainmentEList<Scope>(Scope.class, this, SGraphPackage.STATE__SCOPES);
		}
		return scopes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespace(String newNamespace) {
		String oldNamespace = namespace;
		namespace = newNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SGraphPackage.STATE__NAMESPACE, oldNamespace, namespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SGraphPackage.STATE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Region getParentRegion() {
		if (eContainerFeatureID() != SGraphPackage.STATE__PARENT_REGION) return null;
		return (Region)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentRegion(Region newParentRegion, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentRegion, SGraphPackage.STATE__PARENT_REGION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentRegion(Region newParentRegion) {
		if (newParentRegion != eInternalContainer() || (eContainerFeatureID() != SGraphPackage.STATE__PARENT_REGION && newParentRegion != null)) {
			if (EcoreUtil.isAncestor(this, newParentRegion))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentRegion != null)
				msgs = ((InternalEObject)newParentRegion).eInverseAdd(this, SGraphPackage.REGION__VERTICES, Region.class, msgs);
			msgs = basicSetParentRegion(newParentRegion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SGraphPackage.STATE__PARENT_REGION, newParentRegion, newParentRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getIncomingTransitions() {
		if (incomingTransitions == null) {
			incomingTransitions = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, SGraphPackage.STATE__INCOMING_TRANSITIONS, SGraphPackage.TRANSITION__TARGET);
		}
		return incomingTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getOutgoingTransitions() {
		if (outgoingTransitions == null) {
			outgoingTransitions = new EObjectContainmentWithInverseEList<Transition>(Transition.class, this, SGraphPackage.STATE__OUTGOING_TRANSITIONS, SGraphPackage.TRANSITION__SOURCE);
		}
		return outgoingTransitions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Region> getSubRegions() {
		if (subRegions == null) {
			subRegions = new EObjectContainmentEList<Region>(Region.class, this, SGraphPackage.STATE__SUB_REGIONS);
		}
		return subRegions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isOrthogonal() {
		return getSubRegions().size() > 1;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Statechart getSubstatechart() {
		if (substatechart != null && substatechart.eIsProxy()) {
			InternalEObject oldSubstatechart = (InternalEObject)substatechart;
			substatechart = (Statechart)eResolveProxy(oldSubstatechart);
			if (substatechart != oldSubstatechart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SGraphPackage.STATE__SUBSTATECHART, oldSubstatechart, substatechart));
			}
		}
		return substatechart;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Statechart basicGetSubstatechart() {
		return substatechart;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubstatechart(Statechart newSubstatechart) {
		Statechart oldSubstatechart = substatechart;
		substatechart = newSubstatechart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SGraphPackage.STATE__SUBSTATECHART, oldSubstatechart, substatechart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubstatechartId() {
		return substatechartId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubstatechartId(String newSubstatechartId) {
		String oldSubstatechartId = substatechartId;
		substatechartId = newSubstatechartId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SGraphPackage.STATE__SUBSTATECHART_ID, oldSubstatechartId, substatechartId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isSubmachine() {
		return substatechart != null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isSimple() {
		return !isComposite() && !isSubmachine();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isComposite() {
		return getSubRegions().size() > 0;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isLeaf() {
		if (isSubmachine())
			return false;
		EList<Region> subRegions = getSubRegions();
		for (Region region : subRegions) {
			if (region.getVertices().size() > 0)
				return false;
		}
		return true;
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
			case SGraphPackage.STATE__PARENT_REGION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentRegion((Region)otherEnd, msgs);
			case SGraphPackage.STATE__INCOMING_TRANSITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingTransitions()).basicAdd(otherEnd, msgs);
			case SGraphPackage.STATE__OUTGOING_TRANSITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingTransitions()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SGraphPackage.STATE__SCOPES:
				return ((InternalEList<?>)getScopes()).basicRemove(otherEnd, msgs);
			case SGraphPackage.STATE__PARENT_REGION:
				return basicSetParentRegion(null, msgs);
			case SGraphPackage.STATE__INCOMING_TRANSITIONS:
				return ((InternalEList<?>)getIncomingTransitions()).basicRemove(otherEnd, msgs);
			case SGraphPackage.STATE__OUTGOING_TRANSITIONS:
				return ((InternalEList<?>)getOutgoingTransitions()).basicRemove(otherEnd, msgs);
			case SGraphPackage.STATE__SUB_REGIONS:
				return ((InternalEList<?>)getSubRegions()).basicRemove(otherEnd, msgs);
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
			case SGraphPackage.STATE__PARENT_REGION:
				return eInternalContainer().eInverseRemove(this, SGraphPackage.REGION__VERTICES, Region.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SGraphPackage.STATE__REACTIONS:
				return getReactions();
			case SGraphPackage.STATE__LOCAL_REACTIONS:
				return getLocalReactions();
			case SGraphPackage.STATE__SCOPES:
				return getScopes();
			case SGraphPackage.STATE__NAMESPACE:
				return getNamespace();
			case SGraphPackage.STATE__NAME:
				return getName();
			case SGraphPackage.STATE__PARENT_REGION:
				return getParentRegion();
			case SGraphPackage.STATE__INCOMING_TRANSITIONS:
				return getIncomingTransitions();
			case SGraphPackage.STATE__OUTGOING_TRANSITIONS:
				return getOutgoingTransitions();
			case SGraphPackage.STATE__SUB_REGIONS:
				return getSubRegions();
			case SGraphPackage.STATE__ORTHOGONAL:
				return isOrthogonal();
			case SGraphPackage.STATE__SUBSTATECHART:
				if (resolve) return getSubstatechart();
				return basicGetSubstatechart();
			case SGraphPackage.STATE__SUBSTATECHART_ID:
				return getSubstatechartId();
			case SGraphPackage.STATE__SUBMACHINE:
				return isSubmachine();
			case SGraphPackage.STATE__SIMPLE:
				return isSimple();
			case SGraphPackage.STATE__COMPOSITE:
				return isComposite();
			case SGraphPackage.STATE__LEAF:
				return isLeaf();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SGraphPackage.STATE__SCOPES:
				getScopes().clear();
				getScopes().addAll((Collection<? extends Scope>)newValue);
				return;
			case SGraphPackage.STATE__NAMESPACE:
				setNamespace((String)newValue);
				return;
			case SGraphPackage.STATE__NAME:
				setName((String)newValue);
				return;
			case SGraphPackage.STATE__PARENT_REGION:
				setParentRegion((Region)newValue);
				return;
			case SGraphPackage.STATE__INCOMING_TRANSITIONS:
				getIncomingTransitions().clear();
				getIncomingTransitions().addAll((Collection<? extends Transition>)newValue);
				return;
			case SGraphPackage.STATE__OUTGOING_TRANSITIONS:
				getOutgoingTransitions().clear();
				getOutgoingTransitions().addAll((Collection<? extends Transition>)newValue);
				return;
			case SGraphPackage.STATE__SUB_REGIONS:
				getSubRegions().clear();
				getSubRegions().addAll((Collection<? extends Region>)newValue);
				return;
			case SGraphPackage.STATE__SUBSTATECHART:
				setSubstatechart((Statechart)newValue);
				return;
			case SGraphPackage.STATE__SUBSTATECHART_ID:
				setSubstatechartId((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SGraphPackage.STATE__SCOPES:
				getScopes().clear();
				return;
			case SGraphPackage.STATE__NAMESPACE:
				setNamespace(NAMESPACE_EDEFAULT);
				return;
			case SGraphPackage.STATE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SGraphPackage.STATE__PARENT_REGION:
				setParentRegion((Region)null);
				return;
			case SGraphPackage.STATE__INCOMING_TRANSITIONS:
				getIncomingTransitions().clear();
				return;
			case SGraphPackage.STATE__OUTGOING_TRANSITIONS:
				getOutgoingTransitions().clear();
				return;
			case SGraphPackage.STATE__SUB_REGIONS:
				getSubRegions().clear();
				return;
			case SGraphPackage.STATE__SUBSTATECHART:
				setSubstatechart((Statechart)null);
				return;
			case SGraphPackage.STATE__SUBSTATECHART_ID:
				setSubstatechartId(SUBSTATECHART_ID_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SGraphPackage.STATE__REACTIONS:
				return !getReactions().isEmpty();
			case SGraphPackage.STATE__LOCAL_REACTIONS:
				return !getLocalReactions().isEmpty();
			case SGraphPackage.STATE__SCOPES:
				return scopes != null && !scopes.isEmpty();
			case SGraphPackage.STATE__NAMESPACE:
				return NAMESPACE_EDEFAULT == null ? namespace != null : !NAMESPACE_EDEFAULT.equals(namespace);
			case SGraphPackage.STATE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SGraphPackage.STATE__PARENT_REGION:
				return getParentRegion() != null;
			case SGraphPackage.STATE__INCOMING_TRANSITIONS:
				return incomingTransitions != null && !incomingTransitions.isEmpty();
			case SGraphPackage.STATE__OUTGOING_TRANSITIONS:
				return outgoingTransitions != null && !outgoingTransitions.isEmpty();
			case SGraphPackage.STATE__SUB_REGIONS:
				return subRegions != null && !subRegions.isEmpty();
			case SGraphPackage.STATE__ORTHOGONAL:
				return isOrthogonal() != ORTHOGONAL_EDEFAULT;
			case SGraphPackage.STATE__SUBSTATECHART:
				return substatechart != null;
			case SGraphPackage.STATE__SUBSTATECHART_ID:
				return SUBSTATECHART_ID_EDEFAULT == null ? substatechartId != null : !SUBSTATECHART_ID_EDEFAULT.equals(substatechartId);
			case SGraphPackage.STATE__SUBMACHINE:
				return isSubmachine() != SUBMACHINE_EDEFAULT;
			case SGraphPackage.STATE__SIMPLE:
				return isSimple() != SIMPLE_EDEFAULT;
			case SGraphPackage.STATE__COMPOSITE:
				return isComposite() != COMPOSITE_EDEFAULT;
			case SGraphPackage.STATE__LEAF:
				return isLeaf() != LEAF_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ReactiveElement.class) {
			switch (derivedFeatureID) {
				case SGraphPackage.STATE__REACTIONS: return SGraphPackage.REACTIVE_ELEMENT__REACTIONS;
				case SGraphPackage.STATE__LOCAL_REACTIONS: return SGraphPackage.REACTIVE_ELEMENT__LOCAL_REACTIONS;
				default: return -1;
			}
		}
		if (baseClass == ScopedElement.class) {
			switch (derivedFeatureID) {
				case SGraphPackage.STATE__SCOPES: return SGraphPackage.SCOPED_ELEMENT__SCOPES;
				case SGraphPackage.STATE__NAMESPACE: return SGraphPackage.SCOPED_ELEMENT__NAMESPACE;
				default: return -1;
			}
		}
		if (baseClass == NamedElement.class) {
			switch (derivedFeatureID) {
				case SGraphPackage.STATE__NAME: return SGraphPackage.NAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == Vertex.class) {
			switch (derivedFeatureID) {
				case SGraphPackage.STATE__PARENT_REGION: return SGraphPackage.VERTEX__PARENT_REGION;
				case SGraphPackage.STATE__INCOMING_TRANSITIONS: return SGraphPackage.VERTEX__INCOMING_TRANSITIONS;
				case SGraphPackage.STATE__OUTGOING_TRANSITIONS: return SGraphPackage.VERTEX__OUTGOING_TRANSITIONS;
				default: return -1;
			}
		}
		if (baseClass == RegularState.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ReactiveElement.class) {
			switch (baseFeatureID) {
				case SGraphPackage.REACTIVE_ELEMENT__REACTIONS: return SGraphPackage.STATE__REACTIONS;
				case SGraphPackage.REACTIVE_ELEMENT__LOCAL_REACTIONS: return SGraphPackage.STATE__LOCAL_REACTIONS;
				default: return -1;
			}
		}
		if (baseClass == ScopedElement.class) {
			switch (baseFeatureID) {
				case SGraphPackage.SCOPED_ELEMENT__SCOPES: return SGraphPackage.STATE__SCOPES;
				case SGraphPackage.SCOPED_ELEMENT__NAMESPACE: return SGraphPackage.STATE__NAMESPACE;
				default: return -1;
			}
		}
		if (baseClass == NamedElement.class) {
			switch (baseFeatureID) {
				case SGraphPackage.NAMED_ELEMENT__NAME: return SGraphPackage.STATE__NAME;
				default: return -1;
			}
		}
		if (baseClass == Vertex.class) {
			switch (baseFeatureID) {
				case SGraphPackage.VERTEX__PARENT_REGION: return SGraphPackage.STATE__PARENT_REGION;
				case SGraphPackage.VERTEX__INCOMING_TRANSITIONS: return SGraphPackage.STATE__INCOMING_TRANSITIONS;
				case SGraphPackage.VERTEX__OUTGOING_TRANSITIONS: return SGraphPackage.STATE__OUTGOING_TRANSITIONS;
				default: return -1;
			}
		}
		if (baseClass == RegularState.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (namespace: ");
		result.append(namespace);
		result.append(", name: ");
		result.append(name);
		result.append(", substatechartId: ");
		result.append(substatechartId);
		result.append(')');
		return result.toString();
	}

} // StateImpl
