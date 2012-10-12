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

package org.eclipse.damos.mscript.internal.builtin;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.damos.mscript.FunctionCall;
import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.damos.mscript.internal.MscriptPlugin;
import org.eclipse.damos.mscript.interpreter.IExpressionEvaluationContext;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.interpreter.value.InvalidValue;
import org.eclipse.damos.mscript.util.SyntaxStatus;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractSingleParameterFunction extends AbstractBuiltinFunction {

	public IValue call(IExpressionEvaluationContext context, FunctionCall functionCall, boolean staticOnly) {
		if (functionCall.getArguments().size() != 1) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Missing input parameter", functionCall, MscriptPackage.eINSTANCE.getFeatureReference_Feature()));
			}
			return InvalidValue.SINGLETON;
		}
		IValue value = evaluate(context, functionCall.getArguments().get(0));
		return call(context, functionCall, value, staticOnly);
	}
	
	protected abstract IValue call(IExpressionEvaluationContext context, FunctionCall functionCall, IValue argument, boolean staticOnly);

}
