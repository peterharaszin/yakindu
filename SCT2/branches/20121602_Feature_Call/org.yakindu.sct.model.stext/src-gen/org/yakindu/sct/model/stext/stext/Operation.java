/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.model.stext.stext;

import org.eclipse.emf.common.util.EList;

import org.yakindu.base.types.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.Operation#getParamTypes <em>Param Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends OperationDefinition
{
  /**
   * Returns the value of the '<em><b>Param Types</b></em>' reference list.
   * The list contents are of type {@link org.yakindu.base.types.Type}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Param Types</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Param Types</em>' reference list.
   * @see org.yakindu.sct.model.stext.stext.StextPackage#getOperation_ParamTypes()
   * @model
   * @generated
   */
  EList<Type> getParamTypes();

} // Operation
