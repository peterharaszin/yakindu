/**
 * Copyright (c) 2014 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 *  
 */
package org.yakindu.base.expressions.types;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface ExpressionsTypeSystemMessages {

	public static final String ARITHMETIC_OPERATORS_1 = "Arithmetic operator may only be applied on numeric types, not on %s";
//	public static final String ARITHMETIC_OPERATORS_2 = ARITHMETIC_OPERATORS_1+" and %s";

	public static final String BITWISE_OPERATOR_1 = "Bitwise operator may only be applied on integer types, not on %s";
//	public static final String BITWISE_OPERATOR_2 = BITWISE_OPERATOR_1 + " and %s";

	public static final String LOGICAL_OPERATORS_1 = "Logical operator may only be applied on boolean types, not on %s";
//	public static final String LOGICAL_OPERATORS_2 = LOGICAL_OPERATORS_1+ " and %s";
//
	public static final String COMPARSION_OPERATOR_2 = "Comparison operator may only be applied on compatible types, not on %s and %s";
//
	public static final String ASSIGNMENT_OPERATOR_2 = "Assignment operator may only be applied on compatible types, not on %s and %s";
//	public static final String ASSIGNMENT_AND_EQUALITY_OPERATIONS_MAY_ONLY_BE_APPLIED_ON_TYPES_OF_THE_SAME_KIND = "Assignment and equality operations may only be applied on types of the same kind, not on %s and %s.";
//
//	public static String NO_VALID_TYPE_CAN_BE_INFERRED_FOR_CONDITIONAL_EXPRESSION_BECAUSE_FIRST_OPERAND_NOT_BOOLEAN = "No valid type can be inferred for conditional expression, because type of first operand is not boolean.";
//
//	public static String CANNOT_CAST_FROM_TO = "Cannot cast from %s to %s.";
}
