/**
 */
package org.yakindu.sct.simulation.core.sruntime.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.yakindu.base.base.impl.NamedElementImpl;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.util.DerivedSubsetEObjectEList;
import org.yakindu.sct.simulation.core.sruntime.RuntimeContext;
import org.yakindu.sct.simulation.core.sruntime.RuntimeEvent;
import org.yakindu.sct.simulation.core.sruntime.RuntimeSlot;
import org.yakindu.sct.simulation.core.sruntime.RuntimeVariable;
import org.yakindu.sct.simulation.core.sruntime.SRuntimePackage;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Runtime Context</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.impl.RuntimeContextImpl#getSlots <em>Slots</em>}</li>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.impl.RuntimeContextImpl#getActiveStates <em>Active States</em>}</li>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.impl.RuntimeContextImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.impl.RuntimeContextImpl#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuntimeContextImpl extends NamedElementImpl implements RuntimeContext {
	/**
	 * The cached value of the '{@link #getSlots() <em>Slots</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSlots()
	 * @generated
	 * @ordered
	 */
	protected EList<RuntimeSlot> slots;

	/**
	 * The cached value of the '{@link #getActiveStates() <em>Active States</em>}' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getActiveStates()
	 * @generated
	 * @ordered
	 */
	protected EList<RegularState> activeStates;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SRuntimePackage.Literals.RUNTIME_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RuntimeSlot> getSlots() {
		if (slots == null) {
			slots = new EObjectContainmentEList<RuntimeSlot>(RuntimeSlot.class, this, SRuntimePackage.RUNTIME_CONTEXT__SLOTS);
		}
		return slots;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RegularState> getActiveStates() {
		if (activeStates == null) {
			activeStates = new EObjectResolvingEList<RegularState>(RegularState.class, this, SRuntimePackage.RUNTIME_CONTEXT__ACTIVE_STATES);
		}
		return activeStates;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<RuntimeEvent> getEvents() {
		return new DerivedSubsetEObjectEList<RuntimeEvent>(RuntimeEvent.class, this,
				SRuntimePackage.RUNTIME_CONTEXT__EVENTS, SRuntimePackage.RUNTIME_CONTEXT__SLOTS);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<RuntimeVariable> getVariables() {
		return new DerivedSubsetEObjectEList<RuntimeVariable>(RuntimeVariable.class, this,
				SRuntimePackage.RUNTIME_CONTEXT__VARIABLES, SRuntimePackage.RUNTIME_CONTEXT__SLOTS);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT;
	 */
	public EList<RuntimeEvent> getRaisedEvents() {
		Iterable<RuntimeEvent> raisedEvents = Iterables.filter(getEvents(), new Predicate<RuntimeEvent>() {
			public boolean apply(RuntimeEvent input) {
				return input.isRaised();
			}
		});
		BasicEList<RuntimeEvent> result = new BasicEList<RuntimeEvent>();
		Iterables.addAll(result, raisedEvents);
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SRuntimePackage.RUNTIME_CONTEXT__SLOTS:
				return ((InternalEList<?>)getSlots()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SRuntimePackage.RUNTIME_CONTEXT__SLOTS:
				return getSlots();
			case SRuntimePackage.RUNTIME_CONTEXT__ACTIVE_STATES:
				return getActiveStates();
			case SRuntimePackage.RUNTIME_CONTEXT__EVENTS:
				return getEvents();
			case SRuntimePackage.RUNTIME_CONTEXT__VARIABLES:
				return getVariables();
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
			case SRuntimePackage.RUNTIME_CONTEXT__SLOTS:
				getSlots().clear();
				getSlots().addAll((Collection<? extends RuntimeSlot>)newValue);
				return;
			case SRuntimePackage.RUNTIME_CONTEXT__ACTIVE_STATES:
				getActiveStates().clear();
				getActiveStates().addAll((Collection<? extends RegularState>)newValue);
				return;
			case SRuntimePackage.RUNTIME_CONTEXT__EVENTS:
				getEvents().clear();
				getEvents().addAll((Collection<? extends RuntimeEvent>)newValue);
				return;
			case SRuntimePackage.RUNTIME_CONTEXT__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends RuntimeVariable>)newValue);
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
			case SRuntimePackage.RUNTIME_CONTEXT__SLOTS:
				getSlots().clear();
				return;
			case SRuntimePackage.RUNTIME_CONTEXT__ACTIVE_STATES:
				getActiveStates().clear();
				return;
			case SRuntimePackage.RUNTIME_CONTEXT__EVENTS:
				getEvents().clear();
				return;
			case SRuntimePackage.RUNTIME_CONTEXT__VARIABLES:
				getVariables().clear();
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
			case SRuntimePackage.RUNTIME_CONTEXT__SLOTS:
				return slots != null && !slots.isEmpty();
			case SRuntimePackage.RUNTIME_CONTEXT__ACTIVE_STATES:
				return activeStates != null && !activeStates.isEmpty();
			case SRuntimePackage.RUNTIME_CONTEXT__EVENTS:
				return !getEvents().isEmpty();
			case SRuntimePackage.RUNTIME_CONTEXT__VARIABLES:
				return !getVariables().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public EList<RuntimeEvent> getScheduledEvents() {
		// TODO Auto-generated method stub
		return null;
	}

	public RuntimeVariable getVariable(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public RuntimeEvent getEvent(String name) {
		// TODO Auto-generated method stub
		return null;
	}

} // RuntimeContextImpl
