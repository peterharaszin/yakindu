/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.functionmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.mscript.Compound;
import org.eclipselabs.damos.mscript.FunctionDefinition;
import org.eclipselabs.damos.mscript.functionmodel.ComputationCompound;
import org.eclipselabs.damos.mscript.functionmodel.FunctionInstance;
import org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.impl.FunctionInstanceImpl#getFunctionDefinition <em>Function Definition</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.impl.FunctionInstanceImpl#getInitializationCompound <em>Initialization Compound</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.impl.FunctionInstanceImpl#getComputationCompounds <em>Computation Compounds</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionInstanceImpl extends EObjectImpl implements FunctionInstance {
	/**
	 * The cached value of the '{@link #getFunctionDefinition() <em>Function Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionDefinition()
	 * @generated
	 * @ordered
	 */
	protected FunctionDefinition functionDefinition;

	/**
	 * The cached value of the '{@link #getInitializationCompound() <em>Initialization Compound</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializationCompound()
	 * @generated
	 * @ordered
	 */
	protected Compound initializationCompound;

	/**
	 * The cached value of the '{@link #getComputationCompounds() <em>Computation Compounds</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComputationCompounds()
	 * @generated
	 * @ordered
	 */
	protected EList<ComputationCompound> computationCompounds;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionModelPackage.Literals.FUNCTION_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDefinition getFunctionDefinition() {
		if (functionDefinition != null && functionDefinition.eIsProxy()) {
			InternalEObject oldFunctionDefinition = (InternalEObject)functionDefinition;
			functionDefinition = (FunctionDefinition)eResolveProxy(oldFunctionDefinition);
			if (functionDefinition != oldFunctionDefinition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FunctionModelPackage.FUNCTION_INSTANCE__FUNCTION_DEFINITION, oldFunctionDefinition, functionDefinition));
			}
		}
		return functionDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDefinition basicGetFunctionDefinition() {
		return functionDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctionDefinition(FunctionDefinition newFunctionDefinition) {
		FunctionDefinition oldFunctionDefinition = functionDefinition;
		functionDefinition = newFunctionDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionModelPackage.FUNCTION_INSTANCE__FUNCTION_DEFINITION, oldFunctionDefinition, functionDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Compound getInitializationCompound() {
		return initializationCompound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitializationCompound(Compound newInitializationCompound, NotificationChain msgs) {
		Compound oldInitializationCompound = initializationCompound;
		initializationCompound = newInitializationCompound;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FunctionModelPackage.FUNCTION_INSTANCE__INITIALIZATION_COMPOUND, oldInitializationCompound, newInitializationCompound);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitializationCompound(Compound newInitializationCompound) {
		if (newInitializationCompound != initializationCompound) {
			NotificationChain msgs = null;
			if (initializationCompound != null)
				msgs = ((InternalEObject)initializationCompound).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FunctionModelPackage.FUNCTION_INSTANCE__INITIALIZATION_COMPOUND, null, msgs);
			if (newInitializationCompound != null)
				msgs = ((InternalEObject)newInitializationCompound).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FunctionModelPackage.FUNCTION_INSTANCE__INITIALIZATION_COMPOUND, null, msgs);
			msgs = basicSetInitializationCompound(newInitializationCompound, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionModelPackage.FUNCTION_INSTANCE__INITIALIZATION_COMPOUND, newInitializationCompound, newInitializationCompound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComputationCompound> getComputationCompounds() {
		if (computationCompounds == null) {
			computationCompounds = new EObjectContainmentEList<ComputationCompound>(ComputationCompound.class, this, FunctionModelPackage.FUNCTION_INSTANCE__COMPUTATION_COMPOUNDS);
		}
		return computationCompounds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FunctionModelPackage.FUNCTION_INSTANCE__INITIALIZATION_COMPOUND:
				return basicSetInitializationCompound(null, msgs);
			case FunctionModelPackage.FUNCTION_INSTANCE__COMPUTATION_COMPOUNDS:
				return ((InternalEList<?>)getComputationCompounds()).basicRemove(otherEnd, msgs);
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
			case FunctionModelPackage.FUNCTION_INSTANCE__FUNCTION_DEFINITION:
				if (resolve) return getFunctionDefinition();
				return basicGetFunctionDefinition();
			case FunctionModelPackage.FUNCTION_INSTANCE__INITIALIZATION_COMPOUND:
				return getInitializationCompound();
			case FunctionModelPackage.FUNCTION_INSTANCE__COMPUTATION_COMPOUNDS:
				return getComputationCompounds();
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
			case FunctionModelPackage.FUNCTION_INSTANCE__FUNCTION_DEFINITION:
				setFunctionDefinition((FunctionDefinition)newValue);
				return;
			case FunctionModelPackage.FUNCTION_INSTANCE__INITIALIZATION_COMPOUND:
				setInitializationCompound((Compound)newValue);
				return;
			case FunctionModelPackage.FUNCTION_INSTANCE__COMPUTATION_COMPOUNDS:
				getComputationCompounds().clear();
				getComputationCompounds().addAll((Collection<? extends ComputationCompound>)newValue);
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
			case FunctionModelPackage.FUNCTION_INSTANCE__FUNCTION_DEFINITION:
				setFunctionDefinition((FunctionDefinition)null);
				return;
			case FunctionModelPackage.FUNCTION_INSTANCE__INITIALIZATION_COMPOUND:
				setInitializationCompound((Compound)null);
				return;
			case FunctionModelPackage.FUNCTION_INSTANCE__COMPUTATION_COMPOUNDS:
				getComputationCompounds().clear();
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
			case FunctionModelPackage.FUNCTION_INSTANCE__FUNCTION_DEFINITION:
				return functionDefinition != null;
			case FunctionModelPackage.FUNCTION_INSTANCE__INITIALIZATION_COMPOUND:
				return initializationCompound != null;
			case FunctionModelPackage.FUNCTION_INSTANCE__COMPUTATION_COMPOUNDS:
				return computationCompounds != null && !computationCompounds.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FunctionInstanceImpl
