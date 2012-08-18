/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit Product</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.UnitProduct#getFactors <em>Factors</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getUnitProduct()
 * @model abstract="true"
 * @generated
 */
public interface UnitProduct extends EObject {
	/**
	 * Returns the value of the '<em><b>Factors</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.UnitFactor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Factors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Factors</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getUnitProduct_Factors()
	 * @model containment="true"
	 * @generated
	 */
	EList<UnitFactor> getFactors();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model symbolNameRequired="true"
	 * @generated
	 */
	UnitFactor getFactor(String symbolName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model symbolRequired="true"
	 * @generated
	 */
	UnitFactor getFactor(UnitSymbol symbol);

} // UnitProduct
