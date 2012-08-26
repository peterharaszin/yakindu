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
import org.eclipselabs.damos.mscript.function.FunctionDescription;
import org.eclipselabs.damos.mscript.function.FunctionModelPackage;
import org.eclipselabs.damos.mscript.function.VariableDescription;
import org.eclipselabs.damos.mscript.function.VariableKind;
import org.eclipselabs.damos.mscript.function.VariableStep;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.function.impl.VariableDescriptionImpl#getFunctionDescription <em>Function Description</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.function.impl.VariableDescriptionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.function.impl.VariableDescriptionImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.function.impl.VariableDescriptionImpl#getSteps <em>Steps</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableDescriptionImpl extends EObjectImpl implements VariableDescription {
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
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final VariableKind KIND_EDEFAULT = VariableKind.UNKNOWN;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected VariableKind kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSteps() <em>Steps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteps()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableStep> steps;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionModelPackage.Literals.VARIABLE_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDescription getFunctionDescription() {
		if (eContainerFeatureID() != FunctionModelPackage.VARIABLE_DESCRIPTION__FUNCTION_DESCRIPTION) return null;
		return (FunctionDescription)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFunctionDescription(FunctionDescription newFunctionDescription, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFunctionDescription, FunctionModelPackage.VARIABLE_DESCRIPTION__FUNCTION_DESCRIPTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctionDescription(FunctionDescription newFunctionDescription) {
		if (newFunctionDescription != eInternalContainer() || (eContainerFeatureID() != FunctionModelPackage.VARIABLE_DESCRIPTION__FUNCTION_DESCRIPTION && newFunctionDescription != null)) {
			if (EcoreUtil.isAncestor(this, newFunctionDescription))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFunctionDescription != null)
				msgs = ((InternalEObject)newFunctionDescription).eInverseAdd(this, FunctionModelPackage.FUNCTION_DESCRIPTION__VARIABLE_DESCRIPTIONS, FunctionDescription.class, msgs);
			msgs = basicSetFunctionDescription(newFunctionDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionModelPackage.VARIABLE_DESCRIPTION__FUNCTION_DESCRIPTION, newFunctionDescription, newFunctionDescription));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionModelPackage.VARIABLE_DESCRIPTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(VariableKind newKind) {
		VariableKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionModelPackage.VARIABLE_DESCRIPTION__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableStep> getSteps() {
		if (steps == null) {
			steps = new EObjectContainmentWithInverseEList<VariableStep>(VariableStep.class, this, FunctionModelPackage.VARIABLE_DESCRIPTION__STEPS, FunctionModelPackage.VARIABLE_STEP__VARIABLE_DESCRIPTION);
		}
		return steps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public VariableStep getStep(int index, boolean initial, boolean derivative) {
		for (VariableStep step : getSteps()) {
			if (step.getIndex() == index && step.isInitial() == initial && step.isDerivative() == derivative) {
				return step;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public VariableStep getMinimumStep() {
		VariableStep minimumStep = null;
		for (VariableStep step : getSteps()) {
			if (minimumStep == null || step.getIndex() < minimumStep.getIndex()) {
				minimumStep = step;
			}
		}
		return minimumStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public VariableStep getMaximumStep() {
		VariableStep maxiumStep = null;
		for (VariableStep step : getSteps()) {
			if (maxiumStep == null || step.getIndex() > maxiumStep.getIndex()) {
				maxiumStep = step;
			}
		}
		return maxiumStep;
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
			case FunctionModelPackage.VARIABLE_DESCRIPTION__FUNCTION_DESCRIPTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFunctionDescription((FunctionDescription)otherEnd, msgs);
			case FunctionModelPackage.VARIABLE_DESCRIPTION__STEPS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSteps()).basicAdd(otherEnd, msgs);
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
			case FunctionModelPackage.VARIABLE_DESCRIPTION__FUNCTION_DESCRIPTION:
				return basicSetFunctionDescription(null, msgs);
			case FunctionModelPackage.VARIABLE_DESCRIPTION__STEPS:
				return ((InternalEList<?>)getSteps()).basicRemove(otherEnd, msgs);
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
			case FunctionModelPackage.VARIABLE_DESCRIPTION__FUNCTION_DESCRIPTION:
				return eInternalContainer().eInverseRemove(this, FunctionModelPackage.FUNCTION_DESCRIPTION__VARIABLE_DESCRIPTIONS, FunctionDescription.class, msgs);
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
			case FunctionModelPackage.VARIABLE_DESCRIPTION__FUNCTION_DESCRIPTION:
				return getFunctionDescription();
			case FunctionModelPackage.VARIABLE_DESCRIPTION__NAME:
				return getName();
			case FunctionModelPackage.VARIABLE_DESCRIPTION__KIND:
				return getKind();
			case FunctionModelPackage.VARIABLE_DESCRIPTION__STEPS:
				return getSteps();
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
			case FunctionModelPackage.VARIABLE_DESCRIPTION__FUNCTION_DESCRIPTION:
				setFunctionDescription((FunctionDescription)newValue);
				return;
			case FunctionModelPackage.VARIABLE_DESCRIPTION__NAME:
				setName((String)newValue);
				return;
			case FunctionModelPackage.VARIABLE_DESCRIPTION__KIND:
				setKind((VariableKind)newValue);
				return;
			case FunctionModelPackage.VARIABLE_DESCRIPTION__STEPS:
				getSteps().clear();
				getSteps().addAll((Collection<? extends VariableStep>)newValue);
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
			case FunctionModelPackage.VARIABLE_DESCRIPTION__FUNCTION_DESCRIPTION:
				setFunctionDescription((FunctionDescription)null);
				return;
			case FunctionModelPackage.VARIABLE_DESCRIPTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FunctionModelPackage.VARIABLE_DESCRIPTION__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case FunctionModelPackage.VARIABLE_DESCRIPTION__STEPS:
				getSteps().clear();
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
			case FunctionModelPackage.VARIABLE_DESCRIPTION__FUNCTION_DESCRIPTION:
				return getFunctionDescription() != null;
			case FunctionModelPackage.VARIABLE_DESCRIPTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FunctionModelPackage.VARIABLE_DESCRIPTION__KIND:
				return kind != KIND_EDEFAULT;
			case FunctionModelPackage.VARIABLE_DESCRIPTION__STEPS:
				return steps != null && !steps.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //VariableDescriptionImpl
