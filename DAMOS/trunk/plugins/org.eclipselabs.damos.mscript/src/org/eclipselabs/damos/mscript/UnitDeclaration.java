/**
 */
package org.eclipselabs.damos.mscript;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.UnitDeclaration#getSymbols <em>Symbols</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getUnitDeclaration()
 * @model abstract="true"
 * @generated
 */
public interface UnitDeclaration extends Declaration {
	/**
	 * Returns the value of the '<em><b>Symbols</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.UnitSymbol}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.mscript.UnitSymbol#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbols</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbols</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getUnitDeclaration_Symbols()
	 * @see org.eclipselabs.damos.mscript.UnitSymbol#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<UnitSymbol> getSymbols();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model prefixRequired="true"
	 * @generated
	 */
	UnitSymbol getSymbol(UnitPrefix prefix);

} // UnitDeclaration
