/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.statechart.model.expressions.statechartexpressions;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.yakindu.statechart.model.expressions.statechartexpressions.ActionExpression#getStatement <em>Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage#getActionExpression()
 * @model
 * @generated
 */
public interface ActionExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Statement</b></em>' containment reference list.
   * The list contents are of type {@link com.yakindu.statechart.model.expressions.statechartexpressions.Statement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statement</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statement</em>' containment reference list.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage#getActionExpression_Statement()
   * @model containment="true"
   * @generated
   */
  EList<Statement> getStatement();

} // ActionExpression
