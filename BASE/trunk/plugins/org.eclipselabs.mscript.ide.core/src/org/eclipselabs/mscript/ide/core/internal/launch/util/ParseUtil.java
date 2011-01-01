/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.ide.core.internal.launch.util;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.ide.core.IDECorePlugin;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.ExpressionList;
import org.eclipselabs.mscript.language.interpreter.ExpressionValueEvaluator;
import org.eclipselabs.mscript.language.interpreter.IInterpreterContext;
import org.eclipselabs.mscript.language.parser.antlr.MscriptParser;
import org.eclipselabs.mscript.typesystem.InvalidDataType;

/**
 * @author Andreas Unger
 *
 */
public class ParseUtil {

	public static List<IValue> parseValues(IInterpreterContext interpreterContext, String valuesString) {
		List<IValue> values = new ArrayList<IValue>();
		
		if (StringUtils.isBlank(valuesString)) {
			return values;
		}
		
		MscriptParser parser = IDECorePlugin.getDefault().getMscriptParser();
		
		IParseResult parseResult = parser.parse(parser.getGrammarAccess().getExpressionListRule().getName(), new StringReader(valuesString));
		if (!parseResult.getParseErrors().isEmpty()) {
			return null;
		}
		ExpressionList expressionList = (ExpressionList) parseResult.getRootASTElement();
		
		ExpressionValueEvaluator expressionValueEvaluator = new ExpressionValueEvaluator(interpreterContext);
		
		for (Expression expression : expressionList.getExpressions()) {
			IValue value = expressionValueEvaluator.doSwitch(expression);
			if (value instanceof InvalidDataType) {
				return null;
			}
			values.add(value);
		}
	
		return values;
	}

}
