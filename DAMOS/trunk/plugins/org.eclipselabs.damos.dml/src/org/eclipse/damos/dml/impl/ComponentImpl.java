/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml.impl;

import java.util.Collection;

import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.Compound;
import org.eclipse.damos.dml.CompoundMember;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.INamedElement;
import org.eclipse.damos.dml.Input;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dml.Output;
import org.eclipse.damos.dml.OutputPort;
import org.eclipse.damos.dml.TimingConstraint;
import org.eclipse.damos.dml.internal.operations.ComponentOperations;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.impl.ComponentImpl#getOwningCompound <em>Owning Compound</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.impl.ComponentImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.impl.ComponentImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.impl.ComponentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.impl.ComponentImpl#getTimingConstraint <em>Timing Constraint</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ComponentImpl extends FragmentElementImpl implements Component {
	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Input> inputs;

	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Output> outputs;

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
	 * The cached value of the '{@link #getTimingConstraint() <em>Timing Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimingConstraint()
	 * @generated
	 * @ordered
	 */
	protected TimingConstraint timingConstraint;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Compound getOwningCompound() {
		Compound owningCompound = basicGetOwningCompound();
		return owningCompound != null && owningCompound.eIsProxy() ? (Compound)eResolveProxy((InternalEObject)owningCompound) : owningCompound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Compound basicGetOwningCompound() {
		EObject container = eInternalContainer();
		if (container instanceof Compound) {
			return (Compound) container;
		}
		return null;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.COMPONENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimingConstraint getTimingConstraint() {
		return timingConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimingConstraint(TimingConstraint newTimingConstraint, NotificationChain msgs) {
		TimingConstraint oldTimingConstraint = timingConstraint;
		timingConstraint = newTimingConstraint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DMLPackage.COMPONENT__TIMING_CONSTRAINT, oldTimingConstraint, newTimingConstraint);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimingConstraint(TimingConstraint newTimingConstraint) {
		if (newTimingConstraint != timingConstraint) {
			NotificationChain msgs = null;
			if (timingConstraint != null)
				msgs = ((InternalEObject)timingConstraint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DMLPackage.COMPONENT__TIMING_CONSTRAINT, null, msgs);
			if (newTimingConstraint != null)
				msgs = ((InternalEObject)newTimingConstraint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DMLPackage.COMPONENT__TIMING_CONSTRAINT, null, msgs);
			msgs = basicSetTimingConstraint(newTimingConstraint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.COMPONENT__TIMING_CONSTRAINT, newTimingConstraint, newTimingConstraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Input getInput(String name) {
		return ComponentOperations.getInput(this, name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Output getOutput(String name) {
		return ComponentOperations.getOutput(this, name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Input> getInputs() {
		if (inputs == null) {
			inputs = new EObjectContainmentWithInverseEList<Input>(Input.class, this, DMLPackage.COMPONENT__INPUTS, DMLPackage.INPUT__COMPONENT);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Output> getOutputs() {
		if (outputs == null) {
			outputs = new EObjectContainmentWithInverseEList<Output>(Output.class, this, DMLPackage.COMPONENT__OUTPUTS, DMLPackage.OUTPUT__COMPONENT);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<InputPort> getInputPorts() {
		return ComponentOperations.getInputPorts(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<OutputPort> getOutputPorts() {
		return ComponentOperations.getOutputPorts(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public InputPort getFirstInputPort() {
		return ComponentOperations.getFirstInputPort(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public InputPort getFirstInputPort(String inputName) {
		return ComponentOperations.getFirstInputPort(this, inputName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public OutputPort getFirstOutputPort() {
		return ComponentOperations.getFirstOutputPort(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public OutputPort getFirstOutputPort(String outputName) {
		return ComponentOperations.getFirstOutputPort(this, outputName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<InputPort> getPrimaryInputPorts() {
		return ComponentOperations.getPrimaryInputPorts(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<OutputPort> getPrimaryOutputPorts() {
		return ComponentOperations.getPrimaryOutputPorts(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Input> getInputSockets() {
		return ComponentOperations.getInputSockets(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Output> getOutputSockets() {
		return ComponentOperations.getOutputSockets(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSource() {
		return ComponentOperations.isSource(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSink() {
		return ComponentOperations.isSink(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isTimingConstraintApplicable(EClass eClass) {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isBoundary() {
		return false;
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
			case DMLPackage.COMPONENT__INPUTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInputs()).basicAdd(otherEnd, msgs);
			case DMLPackage.COMPONENT__OUTPUTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutputs()).basicAdd(otherEnd, msgs);
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
			case DMLPackage.COMPONENT__INPUTS:
				return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
			case DMLPackage.COMPONENT__OUTPUTS:
				return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
			case DMLPackage.COMPONENT__TIMING_CONSTRAINT:
				return basicSetTimingConstraint(null, msgs);
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
			case DMLPackage.COMPONENT__OWNING_COMPOUND:
				if (resolve) return getOwningCompound();
				return basicGetOwningCompound();
			case DMLPackage.COMPONENT__INPUTS:
				return getInputs();
			case DMLPackage.COMPONENT__OUTPUTS:
				return getOutputs();
			case DMLPackage.COMPONENT__NAME:
				return getName();
			case DMLPackage.COMPONENT__TIMING_CONSTRAINT:
				return getTimingConstraint();
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
			case DMLPackage.COMPONENT__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends Input>)newValue);
				return;
			case DMLPackage.COMPONENT__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends Output>)newValue);
				return;
			case DMLPackage.COMPONENT__NAME:
				setName((String)newValue);
				return;
			case DMLPackage.COMPONENT__TIMING_CONSTRAINT:
				setTimingConstraint((TimingConstraint)newValue);
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
			case DMLPackage.COMPONENT__INPUTS:
				getInputs().clear();
				return;
			case DMLPackage.COMPONENT__OUTPUTS:
				getOutputs().clear();
				return;
			case DMLPackage.COMPONENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DMLPackage.COMPONENT__TIMING_CONSTRAINT:
				setTimingConstraint((TimingConstraint)null);
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
			case DMLPackage.COMPONENT__OWNING_COMPOUND:
				return basicGetOwningCompound() != null;
			case DMLPackage.COMPONENT__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case DMLPackage.COMPONENT__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case DMLPackage.COMPONENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DMLPackage.COMPONENT__TIMING_CONSTRAINT:
				return timingConstraint != null;
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
		if (baseClass == CompoundMember.class) {
			switch (derivedFeatureID) {
				case DMLPackage.COMPONENT__OWNING_COMPOUND: return DMLPackage.COMPOUND_MEMBER__OWNING_COMPOUND;
				default: return -1;
			}
		}
		if (baseClass == INamedElement.class) {
			switch (derivedFeatureID) {
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
		if (baseClass == CompoundMember.class) {
			switch (baseFeatureID) {
				case DMLPackage.COMPOUND_MEMBER__OWNING_COMPOUND: return DMLPackage.COMPONENT__OWNING_COMPOUND;
				default: return -1;
			}
		}
		if (baseClass == INamedElement.class) {
			switch (baseFeatureID) {
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ComponentImpl
