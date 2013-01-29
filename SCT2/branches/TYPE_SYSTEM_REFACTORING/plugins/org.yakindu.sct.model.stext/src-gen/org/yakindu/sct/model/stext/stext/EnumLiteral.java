/**
 */
package org.yakindu.sct.model.stext.stext;

import org.yakindu.base.types.EnumerationType;
import org.yakindu.base.types.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.EnumLiteral#getType <em>Type</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.EnumLiteral#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getEnumLiteral()
 * @model
 * @generated
 */
public interface EnumLiteral extends Literal
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(EnumerationType)
   * @see org.yakindu.sct.model.stext.stext.StextPackage#getEnumLiteral_Type()
   * @model
   * @generated
   */
  EnumerationType getType();

  /**
   * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.EnumLiteral#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(EnumerationType value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' reference.
   * @see #setValue(Enumerator)
   * @see org.yakindu.sct.model.stext.stext.StextPackage#getEnumLiteral_Value()
   * @model
   * @generated
   */
  Enumerator getValue();

  /**
   * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.EnumLiteral#getValue <em>Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Enumerator value);

} // EnumLiteral
