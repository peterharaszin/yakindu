/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.DataTypeDeclaration;
import org.eclipselabs.damos.mscript.DeclaredTypeSpecifier;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.internal.operations.DeclaredTypeSpecifierOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declared Type Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.DeclaredTypeSpecifierImpl#getTypeDeclaration <em>Type Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeclaredTypeSpecifierImpl extends DataTypeSpecifierImpl implements DeclaredTypeSpecifier {
	/**
	 * The cached value of the '{@link #getTypeDeclaration() <em>Type Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeDeclaration()
	 * @generated
	 * @ordered
	 */
	protected DataTypeDeclaration typeDeclaration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeclaredTypeSpecifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.DECLARED_TYPE_SPECIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeDeclaration getTypeDeclaration() {
		if (typeDeclaration != null && typeDeclaration.eIsProxy()) {
			InternalEObject oldTypeDeclaration = (InternalEObject)typeDeclaration;
			typeDeclaration = (DataTypeDeclaration)eResolveProxy(oldTypeDeclaration);
			if (typeDeclaration != oldTypeDeclaration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MscriptPackage.DECLARED_TYPE_SPECIFIER__TYPE_DECLARATION, oldTypeDeclaration, typeDeclaration));
			}
		}
		return typeDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeDeclaration basicGetTypeDeclaration() {
		return typeDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeDeclaration(DataTypeDeclaration newTypeDeclaration) {
		DataTypeDeclaration oldTypeDeclaration = typeDeclaration;
		typeDeclaration = newTypeDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.DECLARED_TYPE_SPECIFIER__TYPE_DECLARATION, oldTypeDeclaration, typeDeclaration));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.impl.DataTypeSpecifierImpl#getType()
	 */
	@Override
	public DataType getType() {
		return DeclaredTypeSpecifierOperations.getType(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MscriptPackage.DECLARED_TYPE_SPECIFIER__TYPE_DECLARATION:
				if (resolve) return getTypeDeclaration();
				return basicGetTypeDeclaration();
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
			case MscriptPackage.DECLARED_TYPE_SPECIFIER__TYPE_DECLARATION:
				setTypeDeclaration((DataTypeDeclaration)newValue);
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
			case MscriptPackage.DECLARED_TYPE_SPECIFIER__TYPE_DECLARATION:
				setTypeDeclaration((DataTypeDeclaration)null);
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
			case MscriptPackage.DECLARED_TYPE_SPECIFIER__TYPE_DECLARATION:
				return typeDeclaration != null;
		}
		return super.eIsSet(featureID);
	}

} //DeclaredTypeSpecifierImpl
