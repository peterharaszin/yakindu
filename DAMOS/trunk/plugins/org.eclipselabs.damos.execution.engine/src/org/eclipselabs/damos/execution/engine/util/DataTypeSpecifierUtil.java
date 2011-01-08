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

package org.eclipselabs.damos.execution.engine.util;

import java.io.StringReader;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipselabs.damos.execution.engine.ExecutionEnginePlugin;
import org.eclipselabs.mscript.language.interpreter.DataTypeSpecifierEvaluator;
import org.eclipselabs.mscript.language.interpreter.IInterpreterContext;
import org.eclipselabs.mscript.language.parser.antlr.MscriptParser;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class DataTypeSpecifierUtil {

	public static DataType evaluateDataTypeSpecifierDataType(IInterpreterContext context, String dataTypeSpecifier) throws CoreException {
		MscriptParser parser = ExecutionEnginePlugin.getDefault().getMscriptParser();
		IParseResult result = parser.parse(
				parser.getGrammarAccess().getDataTypeSpecifierRule().getName(),
				new StringReader(dataTypeSpecifier));
		if (!result.getParseErrors().isEmpty()) {
			throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Parse error"));
		}
		return new DataTypeSpecifierEvaluator(context).doSwitch(result.getRootASTElement());
	}

}
