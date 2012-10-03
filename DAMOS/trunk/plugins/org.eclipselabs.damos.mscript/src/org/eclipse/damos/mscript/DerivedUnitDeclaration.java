/**
 */
package org.eclipse.damos.mscript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Derived Unit Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.DerivedUnitDeclaration#getDefinition <em>Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.mscript.MscriptPackage#getDerivedUnitDeclaration()
 * @model
 * @generated
 */
public interface DerivedUnitDeclaration extends UnitDeclaration {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' containment reference.
	 * @see #setDefinition(Unit)
	 * @see org.eclipse.damos.mscript.MscriptPackage#getDerivedUnitDeclaration_Definition()
	 * @model containment="true"
	 * @generated
	 */
	Unit getDefinition();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.DerivedUnitDeclaration#getDefinition <em>Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' containment reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(Unit value);

} // DerivedUnitDeclaration
