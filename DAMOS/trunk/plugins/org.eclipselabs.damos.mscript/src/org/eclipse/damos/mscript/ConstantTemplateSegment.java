/**
 */
package org.eclipse.damos.mscript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constant String Segment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.ConstantTemplateSegment#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.ConstantTemplateSegment#getNormalizedText <em>Normalized Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.mscript.MscriptPackage#getConstantTemplateSegment()
 * @model
 * @generated
 */
public interface ConstantTemplateSegment extends TemplateSegment {
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
	 * @see org.eclipse.damos.mscript.MscriptPackage#getConstantTemplateSegment_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.ConstantTemplateSegment#getText <em>Text</em>}' attribute.
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
	 * @see org.eclipse.damos.mscript.MscriptPackage#getConstantTemplateSegment_NormalizedText()
	 * @model transient="true"
	 * @generated
	 */
	String getNormalizedText();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.ConstantTemplateSegment#getNormalizedText <em>Normalized Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Normalized Text</em>' attribute.
	 * @see #getNormalizedText()
	 * @generated
	 */
	void setNormalizedText(String value);

} // ConstantStringSegment
