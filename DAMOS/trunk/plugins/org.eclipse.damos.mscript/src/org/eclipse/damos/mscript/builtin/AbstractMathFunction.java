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

package org.eclipse.damos.mscript.builtin;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.damos.mscript.FunctionCall;
import org.eclipse.damos.mscript.IntegerType;
import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.damos.mscript.NumericType;
import org.eclipse.damos.mscript.RealType;
import org.eclipse.damos.mscript.internal.MscriptPlugin;
import org.eclipse.damos.mscript.interpreter.IExpressionEvaluationContext;
import org.eclipse.damos.mscript.interpreter.value.AnyValue;
import org.eclipse.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.interpreter.value.InvalidValue;
import org.eclipse.damos.mscript.util.SyntaxStatus;
import org.eclipse.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractMathFunction extends AbstractSingleParameterFunction {

	public IValue call(IExpressionEvaluationContext context, FunctionCall functionCall, IValue argument, boolean staticOnly) {
		if (!(argument.getDataType() instanceof RealType || argument.getDataType() instanceof IntegerType)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Input parameter must be real value", functionCall, MscriptPackage.eINSTANCE.getFeatureReference_Feature()));
			}
			return InvalidValue.SINGLETON;
		}
		
		if (!((NumericType) argument.getDataType()).getUnit().isEquivalentTo(TypeUtil.createUnit(), true)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Input parameter must be dimensionless", functionCall, MscriptPackage.eINSTANCE.getFeatureReference_Feature()));
			}
			return InvalidValue.SINGLETON;
		}

		RealType dataType = TypeUtil.createRealType();

		if (argument instanceof AnyValue) {
			return new AnyValue(context.getComputationContext(), dataType);
		}

		argument = argument.convert(dataType);

		if (argument instanceof ISimpleNumericValue) {
			ISimpleNumericValue numericValue = (ISimpleNumericValue) argument;
			return compute(numericValue);
		}
		
		return InvalidValue.SINGLETON;
	}
	
	protected abstract IValue compute(ISimpleNumericValue x);

}
