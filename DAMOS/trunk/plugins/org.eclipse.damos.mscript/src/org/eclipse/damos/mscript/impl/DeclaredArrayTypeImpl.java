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
package org.eclipse.damos.mscript.impl;

import org.eclipse.damos.mscript.DeclaredArrayType;
import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.TypeDeclaration;
import org.eclipse.damos.mscript.internal.operations.DeclaredArrayTypeOperations;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declared Array Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.impl.DeclaredArrayTypeImpl#getElementTypeDeclaration <em>Element Type Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeclaredArrayTypeImpl extends ArrayTypeImpl implements DeclaredArrayType {
	/**
	 * The cached value of the '{@link #getElementTypeDeclaration() <em>Element Type Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementTypeDeclaration()
	 * @generated
	 * @ordered
	 */
	protected TypeDeclaration elementTypeDeclaration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeclaredArrayTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.DECLARED_ARRAY_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeDeclaration getElementTypeDeclaration() {
		if (elementTypeDeclaration != null && elementTypeDeclaration.eIsProxy()) {
			InternalEObject oldElementTypeDeclaration = (InternalEObject)elementTypeDeclaration;
			elementTypeDeclaration = (TypeDeclaration)eResolveProxy(oldElementTypeDeclaration);
			if (elementTypeDeclaration != oldElementTypeDeclaration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MscriptPackage.DECLARED_ARRAY_TYPE__ELEMENT_TYPE_DECLARATION, oldElementTypeDeclaration, elementTypeDeclaration));
			}
		}
		return elementTypeDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeDeclaration basicGetElementTypeDeclaration() {
		return elementTypeDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementTypeDeclaration(TypeDeclaration newElementTypeDeclaration) {
		TypeDeclaration oldElementTypeDeclaration = elementTypeDeclaration;
		elementTypeDeclaration = newElementTypeDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.DECLARED_ARRAY_TYPE__ELEMENT_TYPE_DECLARATION, oldElementTypeDeclaration, elementTypeDeclaration));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.impl.ArrayTypeImpl#getElementType()
	 */
	@Override
	public Type getElementType() {
		return DeclaredArrayTypeOperations.getElementType(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MscriptPackage.DECLARED_ARRAY_TYPE__ELEMENT_TYPE_DECLARATION:
				if (resolve) return getElementTypeDeclaration();
				return basicGetElementTypeDeclaration();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MscriptPackage.DECLARED_ARRAY_TYPE__ELEMENT_TYPE_DECLARATION:
				setElementTypeDeclaration((TypeDeclaration)newValue);
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
			case MscriptPackage.DECLARED_ARRAY_TYPE__ELEMENT_TYPE_DECLARATION:
				setElementTypeDeclaration((TypeDeclaration)null);
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
			case MscriptPackage.DECLARED_ARRAY_TYPE__ELEMENT_TYPE_DECLARATION:
				return elementTypeDeclaration != null;
		}
		return super.eIsSet(featureID);
	}

} //DeclaredArrayTypeImpl
