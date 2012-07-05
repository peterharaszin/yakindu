/**
 */
package org.eclipselabs.damos.mscript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constant String Segment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.ConstantStringSegment#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.ConstantStringSegment#getNormalizedText <em>Normalized Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getConstantStringSegment()
 * @model
 * @generated
 */
public interface ConstantStringSegment extends StringSegment {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getConstantStringSegment_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.ConstantStringSegment#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Normalized Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Normalized Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Normalized Text</em>' attribute.
	 * @see #setNormalizedText(String)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getConstantStringSegment_NormalizedText()
	 * @model transient="true"
	 * @generated
	 */
	String getNormalizedText();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.ConstantStringSegment#getNormalizedText <em>Normalized Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Normalized Text</em>' attribute.
	 * @see #getNormalizedText()
	 * @generated
	 */
	void setNormalizedText(String value);

} // ConstantStringSegment
