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
 * A representation of the model object '<em><b>Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.Unit#getScale <em>Scale</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.Unit#isAny <em>Any</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.Unit#getFactors <em>Factors</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getUnit()
 * @model
 * @generated
 */
public interface Unit extends EObject {
	/**
	 * Returns the value of the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale</em>' attribute.
	 * @see #setScale(int)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getUnit_Scale()
	 * @model required="true"
	 * @generated
	 */
	int getScale();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.Unit#getScale <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale</em>' attribute.
	 * @see #getScale()
	 * @generated
	 */
	void setScale(int value);

	/**
	 * Returns the value of the '<em><b>Any</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wildcard</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Any</em>' attribute.
	 * @see #setAny(boolean)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getUnit_Any()
	 * @model required="true"
	 * @generated
	 */
	boolean isAny();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.Unit#isAny <em>Any</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Any</em>' attribute.
	 * @see #isAny()
	 * @generated
	 */
	void setAny(boolean value);

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
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getUnit_Factors()
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Unit getNormalized();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model operatorRequired="true"
	 * @generated
	 */
	Unit evaluate(OperatorKind operator, Unit other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model operatorRequired="true" nRequired="true"
	 * @generated
	 */
	Unit evaluate(OperatorKind operator, int n);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" otherRequired="true" ignoreScaleRequired="true"
	 * @generated
	 */
	boolean isEquivalentTo(Unit other, boolean ignoreScale);

} // Unit
