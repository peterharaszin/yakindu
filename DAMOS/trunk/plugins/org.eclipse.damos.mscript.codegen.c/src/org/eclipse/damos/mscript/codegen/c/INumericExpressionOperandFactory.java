/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/
package org.eclipse.damos.mscript.codegen.c;

import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.codegen.c.INumericExpressionOperandFactory.Default;
import org.eclipse.damos.mscript.codegen.c.util.CastHelper;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
@ImplementedBy(Default.class)
public interface INumericExpressionOperandFactory {

	INumericExpressionOperand create(IMscriptGeneratorContext context, Expression expression);
	
	class Default implements INumericExpressionOperandFactory {
		
		@Inject
		private CastHelper castHelper;
		
		@Override
		public INumericExpressionOperand create(IMscriptGeneratorContext context, Expression expression) {
			return new NumericExpressionOperand(castHelper, context, expression);
		}
		
	}
	
}
