/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.mscript.internal.builtin;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.FunctionCall;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.internal.MscriptPlugin;
import org.eclipselabs.damos.mscript.interpreter.IExpressionEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.InvalidValue;
import org.eclipselabs.damos.mscript.interpreter.value.UnitValue;
import org.eclipselabs.damos.mscript.util.SyntaxStatus;

/**
 * @author Andreas Unger
 *
 */
public class UnitFunction extends AbstractSingleParameterFunction {

	@Override
	protected IValue call(IExpressionEvaluationContext context, FunctionCall functionCall, IValue argument, boolean staticOnly) {
		if (!context.isStaticScope()) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Unit function can only be used in static scope", functionCall, MscriptPackage.eINSTANCE.getFeatureReference_Feature()));
			}
			return InvalidValue.SINGLETON;
		}
		
		if (argument.getDataType() instanceof NumericType) {
			NumericType numericType = (NumericType) argument.getDataType();
			return new UnitValue(context.getComputationContext(), EcoreUtil.copy(numericType.getUnit()));
		}
		
		if (argument.getDataType() instanceof ArrayType) {
			ArrayType arrayType = (ArrayType) argument.getDataType();
			if (arrayType.getElementType() instanceof NumericType) {
				NumericType numericType = (NumericType) arrayType.getElementType();
				return new UnitValue(context.getComputationContext(), EcoreUtil.copy(numericType.getUnit()));
			}
		}

		if (context.getStatusCollector() != null) {
			context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Unit function argument must be numeric scalar or array value", functionCall.getArguments().get(0)));
		}
		return InvalidValue.SINGLETON;
	}

}
