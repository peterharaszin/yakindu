/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.damos.dscript.impl;

import java.util.Collection;

import org.eclipse.damos.dml.InoutputDefinition;
import org.eclipse.damos.dml.InputDefinition;
import org.eclipse.damos.dml.OutputDefinition;
import org.eclipse.damos.dml.Parameter;
import org.eclipse.damos.dscript.BehaviorDeclaration;
import org.eclipse.damos.dscript.DscriptBlockType;
import org.eclipse.damos.dscript.DscriptInputDefinition;
import org.eclipse.damos.dscript.DscriptOutputDefinition;
import org.eclipse.damos.dscript.DscriptPackage;
import org.eclipse.damos.dscript.DscriptParameter;
import org.eclipse.damos.dscript.ImplicitInputParameterDeclaration;
import org.eclipse.damos.dscript.ImplicitOutputParameterDeclaration;
import org.eclipse.damos.dscript.InputMessageParameterDeclaration;
import org.eclipse.damos.dscript.OutputMessageParameterDeclaration;
import org.eclipse.damos.mscript.FunctionKind;
import org.eclipse.damos.mscript.InputParameterDeclaration;
import org.eclipse.damos.mscript.OutputParameterDeclaration;
import org.eclipse.damos.mscript.impl.FunctionDeclarationImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.dscript.impl.BehaviorDeclarationImpl#getBlockType <em>Block Type</em>}</li>
 *   <li>{@link org.eclipse.damos.dscript.impl.BehaviorDeclarationImpl#getAllImplicitInputParameterDeclarations <em>All Implicit Input Parameter Declarations</em>}</li>
 *   <li>{@link org.eclipse.damos.dscript.impl.BehaviorDeclarationImpl#getAllImplicitOutputParameterDeclarations <em>All Implicit Output Parameter Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BehaviorDeclarationImpl extends FunctionDeclarationImpl implements BehaviorDeclaration {
	/**
	 * The cached value of the '{@link #getAllImplicitInputParameterDeclarations() <em>All Implicit Input Parameter Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllImplicitInputParameterDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<ImplicitInputParameterDeclaration> allImplicitInputParameterDeclarations;
	/**
	 * The cached value of the '{@link #getAllImplicitOutputParameterDeclarations() <em>All Implicit Output Parameter Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllImplicitOutputParameterDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<ImplicitOutputParameterDeclaration> allImplicitOutputParameterDeclarations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehaviorDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DscriptPackage.Literals.BEHAVIOR_DECLARATION;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DscriptBlockType getBlockType() {
		if (eContainerFeatureID() != DscriptPackage.BEHAVIOR_DECLARATION__BLOCK_TYPE) return null;
		return (DscriptBlockType)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBlockType(DscriptBlockType newBlockType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newBlockType, DscriptPackage.BEHAVIOR_DECLARATION__BLOCK_TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlockType(DscriptBlockType newBlockType) {
		if (newBlockType != eInternalContainer() || (eContainerFeatureID() != DscriptPackage.BEHAVIOR_DECLARATION__BLOCK_TYPE && newBlockType != null)) {
			if (EcoreUtil.isAncestor(this, newBlockType))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newBlockType != null)
				msgs = ((InternalEObject)newBlockType).eInverseAdd(this, DscriptPackage.DSCRIPT_BLOCK_TYPE__BEHAVIOR, DscriptBlockType.class, msgs);
			msgs = basicSetBlockType(newBlockType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DscriptPackage.BEHAVIOR_DECLARATION__BLOCK_TYPE, newBlockType, newBlockType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ImplicitInputParameterDeclaration> getAllImplicitInputParameterDeclarations() {
		if (allImplicitInputParameterDeclarations == null) {
			allImplicitInputParameterDeclarations = new EObjectContainmentEList<ImplicitInputParameterDeclaration>(ImplicitInputParameterDeclaration.class, this, DscriptPackage.BEHAVIOR_DECLARATION__ALL_IMPLICIT_INPUT_PARAMETER_DECLARATIONS);
		}
		return allImplicitInputParameterDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ImplicitOutputParameterDeclaration> getAllImplicitOutputParameterDeclarations() {
		if (allImplicitOutputParameterDeclarations == null) {
			allImplicitOutputParameterDeclarations = new EObjectContainmentEList<ImplicitOutputParameterDeclaration>(ImplicitOutputParameterDeclaration.class, this, DscriptPackage.BEHAVIOR_DECLARATION__ALL_IMPLICIT_OUTPUT_PARAMETER_DECLARATIONS);
		}
		return allImplicitOutputParameterDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DscriptPackage.BEHAVIOR_DECLARATION__BLOCK_TYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetBlockType((DscriptBlockType)otherEnd, msgs);
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
			case DscriptPackage.BEHAVIOR_DECLARATION__BLOCK_TYPE:
				return basicSetBlockType(null, msgs);
			case DscriptPackage.BEHAVIOR_DECLARATION__ALL_IMPLICIT_INPUT_PARAMETER_DECLARATIONS:
				return ((InternalEList<?>)getAllImplicitInputParameterDeclarations()).basicRemove(otherEnd, msgs);
			case DscriptPackage.BEHAVIOR_DECLARATION__ALL_IMPLICIT_OUTPUT_PARAMETER_DECLARATIONS:
				return ((InternalEList<?>)getAllImplicitOutputParameterDeclarations()).basicRemove(otherEnd, msgs);
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
			case DscriptPackage.BEHAVIOR_DECLARATION__BLOCK_TYPE:
				return eInternalContainer().eInverseRemove(this, DscriptPackage.DSCRIPT_BLOCK_TYPE__BEHAVIOR, DscriptBlockType.class, msgs);
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
			case DscriptPackage.BEHAVIOR_DECLARATION__BLOCK_TYPE:
				return getBlockType();
			case DscriptPackage.BEHAVIOR_DECLARATION__ALL_IMPLICIT_INPUT_PARAMETER_DECLARATIONS:
				return getAllImplicitInputParameterDeclarations();
			case DscriptPackage.BEHAVIOR_DECLARATION__ALL_IMPLICIT_OUTPUT_PARAMETER_DECLARATIONS:
				return getAllImplicitOutputParameterDeclarations();
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
			case DscriptPackage.BEHAVIOR_DECLARATION__BLOCK_TYPE:
				setBlockType((DscriptBlockType)newValue);
				return;
			case DscriptPackage.BEHAVIOR_DECLARATION__ALL_IMPLICIT_INPUT_PARAMETER_DECLARATIONS:
				getAllImplicitInputParameterDeclarations().clear();
				getAllImplicitInputParameterDeclarations().addAll((Collection<? extends ImplicitInputParameterDeclaration>)newValue);
				return;
			case DscriptPackage.BEHAVIOR_DECLARATION__ALL_IMPLICIT_OUTPUT_PARAMETER_DECLARATIONS:
				getAllImplicitOutputParameterDeclarations().clear();
				getAllImplicitOutputParameterDeclarations().addAll((Collection<? extends ImplicitOutputParameterDeclaration>)newValue);
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
			case DscriptPackage.BEHAVIOR_DECLARATION__BLOCK_TYPE:
				setBlockType((DscriptBlockType)null);
				return;
			case DscriptPackage.BEHAVIOR_DECLARATION__ALL_IMPLICIT_INPUT_PARAMETER_DECLARATIONS:
				getAllImplicitInputParameterDeclarations().clear();
				return;
			case DscriptPackage.BEHAVIOR_DECLARATION__ALL_IMPLICIT_OUTPUT_PARAMETER_DECLARATIONS:
				getAllImplicitOutputParameterDeclarations().clear();
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
			case DscriptPackage.BEHAVIOR_DECLARATION__BLOCK_TYPE:
				return getBlockType() != null;
			case DscriptPackage.BEHAVIOR_DECLARATION__ALL_IMPLICIT_INPUT_PARAMETER_DECLARATIONS:
				return allImplicitInputParameterDeclarations != null && !allImplicitInputParameterDeclarations.isEmpty();
			case DscriptPackage.BEHAVIOR_DECLARATION__ALL_IMPLICIT_OUTPUT_PARAMETER_DECLARATIONS:
				return allImplicitOutputParameterDeclarations != null && !allImplicitOutputParameterDeclarations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.impl.FunctionDeclarationImpl#getName()
	 */
	@Override
	public String getName() {
		return getBlockType().getName();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.impl.FunctionDeclarationImpl#getKind()
	 */
	@Override
	public FunctionKind getKind() {
		switch (getBlockType().getTiming()) {
		case SYNCHRONOUS:
			return FunctionKind.SYNCHRONOUS;
		case CONTINUOUS:
			return FunctionKind.CONTINUOUS;
		default:
			return FunctionKind.STANDARD;
		}
	}
	
	@Override
	public EList<InputParameterDeclaration> getInputParameterDeclarations() {
		DscriptBlockType blockType = getBlockType();
		EList<InputParameterDeclaration> result = new BasicEList<InputParameterDeclaration>();
		
		if (containsSockets(blockType.getInputDefinitions())) {
			for (ImplicitInputParameterDeclaration parameterDeclaration : getAllImplicitInputParameterDeclarations()) {
				if (parameterDeclaration instanceof InputMessageParameterDeclaration) {
					result.add(parameterDeclaration);
				}
			}
		}
		
		for (InputDefinition inputDefinition : blockType.getInputDefinitions()) {
			if (inputDefinition instanceof DscriptInputDefinition && !inputDefinition.isSocket()) {
				result.add((DscriptInputDefinition) inputDefinition);
			}
		}

		for (InputDefinition inputDefinition : blockType.getInputDefinitions()) {
			for (Parameter parameter : inputDefinition.getParameters()) {
				if (parameter instanceof DscriptParameter) {
					result.add((DscriptParameter) parameter);
				}
			}
		}

		for (OutputDefinition outputDefinition : blockType.getOutputDefinitions()) {
			for (Parameter parameter : outputDefinition.getParameters()) {
				if (parameter instanceof DscriptParameter) {
					result.add((DscriptParameter) parameter);
				}
			}
		}

		for (Parameter parameter : blockType.getParameters()) {
			if (parameter instanceof DscriptParameter) {
				result.add((DscriptParameter) parameter);
			}
		}

		return result;
	}
	
	@Override
	public EList<OutputParameterDeclaration> getOutputParameterDeclarations() {
		DscriptBlockType blockType = getBlockType();
		EList<OutputParameterDeclaration> result = new BasicEList<OutputParameterDeclaration>();
		
		if (containsSockets(blockType.getOutputDefinitions())) {
			for (ImplicitOutputParameterDeclaration parameterDeclaration : getAllImplicitOutputParameterDeclarations()) {
				if (parameterDeclaration instanceof OutputMessageParameterDeclaration) {
					result.add(parameterDeclaration);
				}
			}
		}

		for (OutputDefinition outputDefinition : blockType.getOutputDefinitions()) {
			if (outputDefinition instanceof DscriptOutputDefinition && !outputDefinition.isSocket()) {
				result.add((DscriptOutputDefinition) outputDefinition);
			}
		}

		return result;
	}
	
	private boolean containsSockets(EList<? extends InoutputDefinition> inoutputDefinitions) {
		for (InoutputDefinition inoutputDefinition : inoutputDefinitions) {
			if (inoutputDefinition.isSocket()) {
				return true;
			}
		}
		return false;
	}
	
} //BehaviorDeclarationImpl
