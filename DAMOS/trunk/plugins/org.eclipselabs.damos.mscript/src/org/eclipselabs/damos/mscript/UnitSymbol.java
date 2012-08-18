/**
 */
package org.eclipselabs.damos.mscript;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit Symbol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.UnitSymbol#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.UnitSymbol#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.UnitSymbol#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.UnitSymbol#getScale <em>Scale</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getUnitSymbol()
 * @model
 * @generated
 */
public interface UnitSymbol extends EObject {
	
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.mscript.UnitDeclaration#getSymbols <em>Symbols</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(UnitDeclaration)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getUnitSymbol_Owner()
	 * @see org.eclipselabs.damos.mscript.UnitDeclaration#getSymbols
	 * @model opposite="symbols" transient="false"
	 * @generated
	 */
	UnitDeclaration getOwner();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.UnitSymbol#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(UnitDeclaration value);

	/**
	 * Returns the value of the '<em><b>Prefix</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipselabs.damos.mscript.UnitPrefix}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prefix</em>' attribute.
	 * @see org.eclipselabs.damos.mscript.UnitPrefix
	 * @see #setPrefix(UnitPrefix)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getUnitSymbol_Prefix()
	 * @model
	 * @generated
	 */
	UnitPrefix getPrefix();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.UnitSymbol#getPrefix <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefix</em>' attribute.
	 * @see org.eclipselabs.damos.mscript.UnitPrefix
	 * @see #getPrefix()
	 * @generated
	 */
	void setPrefix(UnitPrefix value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getUnitSymbol_Name()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getName();

	/**
	 * Returns the value of the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale</em>' attribute.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getUnitSymbol_Scale()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	int getScale();

} // UnitSymbol
