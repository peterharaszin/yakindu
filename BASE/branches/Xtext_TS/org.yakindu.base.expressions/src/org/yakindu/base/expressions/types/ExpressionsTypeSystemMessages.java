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

	public static final String COMPATIBLE_OPERATOR_2 = "Operator '%s' may only be applied on compatible types, not on %s and %s.";
	public static final String NUMERIC_OPERATOR_1 = "Operator '%s' may only be applied on numeric types, not on %s.";
	public static final String INTEGER_OPERATOR_1 = "Operator '%s' may only be applied on integer types, not on %s.";
	public static final String BOOLEAN_OPERATOR_1 = "Operator '%s' may only be applied on boolean types, not on %s.";
}
