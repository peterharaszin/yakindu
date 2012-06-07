/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipselabs.damos.dml.CategorizedElement;
import org.eclipselabs.damos.dml.Category;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.internal.operations.CategorizedElementOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Categorized Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.impl.CategorizedElementImpl#getBelongingCategories <em>Belonging Categories</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CategorizedElementImpl extends EObjectImpl implements CategorizedElement {
	/**
	 * The cached value of the '{@link #getBelongingCategories() <em>Belonging Categories</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBelongingCategories()
	 * @generated
	 * @ordered
	 */
	protected EList<Category> belongingCategories;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CategorizedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.CATEGORIZED_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Category> getBelongingCategories() {
		if (belongingCategories == null) {
			belongingCategories = new EObjectResolvingEList<Category>(Category.class, this, DMLPackage.CATEGORIZED_ELEMENT__BELONGING_CATEGORIES);
		}
		return belongingCategories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean belongsTo(String categoryName) {
		return CategorizedElementOperations.belongsTo(this, categoryName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DMLPackage.CATEGORIZED_ELEMENT__BELONGING_CATEGORIES:
				return getBelongingCategories();
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
			case DMLPackage.CATEGORIZED_ELEMENT__BELONGING_CATEGORIES:
				getBelongingCategories().clear();
				getBelongingCategories().addAll((Collection<? extends Category>)newValue);
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
			case DMLPackage.CATEGORIZED_ELEMENT__BELONGING_CATEGORIES:
				getBelongingCategories().clear();
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
			case DMLPackage.CATEGORIZED_ELEMENT__BELONGING_CATEGORIES:
				return belongingCategories != null && !belongingCategories.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CategorizedElementImpl
