/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.mscript.EnumerationDeclaration;
import org.eclipselabs.damos.mscript.EnumerationLiteralDeclaration;
import org.eclipselabs.damos.mscript.MscriptPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumeration Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.EnumerationDeclarationImpl#getLiteralDeclarations <em>Literal Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumerationDeclarationImpl extends DeclarationImpl implements EnumerationDeclaration {
	/**
	 * The cached value of the '{@link #getLiteralDeclarations() <em>Literal Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiteralDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<EnumerationLiteralDeclaration> literalDeclarations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumerationDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.ENUMERATION_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EnumerationLiteralDeclaration> getLiteralDeclarations() {
		if (literalDeclarations == null) {
			literalDeclarations = new EObjectContainmentEList<EnumerationLiteralDeclaration>(EnumerationLiteralDeclaration.class, this, MscriptPackage.ENUMERATION_DECLARATION__LITERAL_DECLARATIONS);
		}
		return literalDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MscriptPackage.ENUMERATION_DECLARATION__LITERAL_DECLARATIONS:
				return ((InternalEList<?>)getLiteralDeclarations()).basicRemove(otherEnd, msgs);
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
			case MscriptPackage.ENUMERATION_DECLARATION__LITERAL_DECLARATIONS:
				return getLiteralDeclarations();
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
			case MscriptPackage.ENUMERATION_DECLARATION__LITERAL_DECLARATIONS:
				getLiteralDeclarations().clear();
				getLiteralDeclarations().addAll((Collection<? extends EnumerationLiteralDeclaration>)newValue);
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
			case MscriptPackage.ENUMERATION_DECLARATION__LITERAL_DECLARATIONS:
				getLiteralDeclarations().clear();
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
			case MscriptPackage.ENUMERATION_DECLARATION__LITERAL_DECLARATIONS:
				return literalDeclarations != null && !literalDeclarations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EnumerationDefinitionImpl
