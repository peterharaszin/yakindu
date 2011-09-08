/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.model.stext.stext;

import org.eclipse.emf.common.util.EList;

import org.yakindu.sct.model.sgraph.Effect;
import org.yakindu.sct.model.sgraph.Statement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reaction Effect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.ReactionEffect#getActions <em>Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getReactionEffect()
 * @model
 * @generated
 */
public interface ReactionEffect extends Effect
{
  /**
   * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
   * The list contents are of type {@link org.yakindu.sct.model.sgraph.Statement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actions</em>' containment reference list.
   * @see org.yakindu.sct.model.stext.stext.StextPackage#getReactionEffect_Actions()
   * @model containment="true"
   * @generated
   */
  EList<Statement> getActions();

} // ReactionEffect
