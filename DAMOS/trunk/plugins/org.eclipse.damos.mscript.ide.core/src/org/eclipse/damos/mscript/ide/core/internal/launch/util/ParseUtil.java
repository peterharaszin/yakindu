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

package org.eclipse.damos.mscript.ide.core.internal.launch.util;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.ExpressionList;
import org.eclipse.damos.mscript.InvalidType;
import org.eclipse.damos.mscript.ide.core.IDECorePlugin;
import org.eclipse.damos.mscript.interpreter.ExpressionEvaluationContext;
import org.eclipse.damos.mscript.interpreter.ExpressionEvaluator;
import org.eclipse.damos.mscript.interpreter.IExpressionEvaluator;
import org.eclipse.damos.mscript.interpreter.IInterpreterContext;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.parser.antlr.MscriptParser;
import org.eclipse.xtext.parser.IParseResult;

/**
 * @author Andreas Unger
 *
 */
public class ParseUtil {

	public static List<IValue> parseValues(IInterpreterContext interpreterContext, String valuesString) {
		List<IValue> values = new ArrayList<IValue>();
		
		if (valuesString == null || valuesString.trim().length() == 0) {
			return values;
		}
		
		MscriptParser parser = IDECorePlugin.getDefault().getMscriptParser();
		
		IParseResult parseResult = parser.parse(parser.getGrammarAccess().getExpressionListRule(), new StringReader(valuesString));
		if (parseResult.hasSyntaxErrors()) {
			return null;
		}
		ExpressionList expressionList = (ExpressionList) parseResult.getRootASTElement();
		
		IExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
		
		for (Expression expression : expressionList.getExpressions()) {
			IValue value = expressionEvaluator.evaluate(new ExpressionEvaluationContext(interpreterContext), expression);
			if (value instanceof InvalidType) {
				return null;
			}
			values.add(value);
		}
	
		return values;
	}

}
