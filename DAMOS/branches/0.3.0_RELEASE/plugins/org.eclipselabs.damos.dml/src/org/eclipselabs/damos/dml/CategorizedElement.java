/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Categorized Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.CategorizedElement#getBelongingCategories <em>Belonging Categories</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dml.DMLPackage#getCategorizedElement()
 * @model abstract="true"
 * @generated
 */
public interface CategorizedElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Belonging Categories</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.dml.Category}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Belonging Categories</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Belonging Categories</em>' reference list.
	 * @see org.eclipselabs.damos.dml.DMLPackage#getCategorizedElement_BelongingCategories()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Category> getBelongingCategories();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" categoryNameRequired="true" categoryNameOrdered="false"
	 * @generated
	 */
	boolean belongsTo(String categoryName);

} // CategorizedElement
