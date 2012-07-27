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

package org.eclipselabs.damos.mscript.interpreter;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.InvalidType;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.internal.MscriptPlugin;
import org.eclipselabs.damos.mscript.interpreter.value.AnyValue;
import org.eclipselabs.damos.mscript.interpreter.value.IArrayValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.InvalidValue;
import org.eclipselabs.damos.mscript.interpreter.value.MatrixValue;
import org.eclipselabs.damos.mscript.interpreter.value.Values;
import org.eclipselabs.damos.mscript.interpreter.value.VectorValue;
import org.eclipselabs.damos.mscript.util.SyntaxStatus;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionEvaluatorHelper {

	public IValue createArrayValue(IExpressionEvaluationContext context, IValue[] elements, boolean anyValue, EObject syntaxElement) {
		if (anyValue) {
			for (int i = 0; i < elements.length; ++i) {
				if (!(elements[i] instanceof AnyValue)) {
					elements[i] = new AnyValue(context.getComputationContext(), elements[i].getDataType());
				}
			}
		}

		ArrayType arrayType = createArrayType(elements);

		if (arrayType == null) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Incompatible array elements", syntaxElement));
			}
			return InvalidValue.SINGLETON;
		}

		// Vector
		if (arrayType.getDimensionality() == 1) {
			context.processValue(arrayType.getDimensions().get(0).getSize(), Values.valueOf(context.getComputationContext(), TypeUtil.createIntegerType(), elements.length));
	
			if (anyValue) {
				return new AnyValue(context.getComputationContext(), arrayType);
			}
	
			return new VectorValue(context.getComputationContext(), arrayType, elements);
		}
		
		// Matrix
		int rowSize = TypeUtil.getArrayRowSize(arrayType);
		context.processValue(arrayType.getDimensions().get(0).getSize(), Values.valueOf(context.getComputationContext(), TypeUtil.createIntegerType(), rowSize));
		int columnSize = TypeUtil.getArrayColumnSize(arrayType);
		context.processValue(arrayType.getDimensions().get(1).getSize(), Values.valueOf(context.getComputationContext(), TypeUtil.createIntegerType(), columnSize));
		
		if (anyValue) {
			return new AnyValue(context.getComputationContext(), arrayType);
		}

		IValue[][] values = new IValue[rowSize][columnSize];
		for (int i = 0; i < rowSize; ++i) {
			for (int j = 0; j < columnSize; ++j) {
				values[i][j] = ((IArrayValue) elements[i]).get(j);
			}
		}
		return new MatrixValue(context.getComputationContext(), arrayType, values);
	}

	private ArrayType createArrayType(IValue[] elements) {
		Type elementType = null;

		for (IValue elementValue : elements) {
			Type type = elementValue.getDataType();

			if (type == null || type instanceof InvalidType) {
				return null;
			}

			if (elementType != null && !elementType.isEquivalentTo(type)) {
				Type leftHandDataType = TypeUtil.getLeftHandDataType(elementType, type);
				if (leftHandDataType == null) {
					return null;
				}
				type = leftHandDataType;
			}

			elementType = type;
		}
		
		if (elementType instanceof ArrayType) {
			ArrayType elementArrayType = (ArrayType) elementType;
			if (elementArrayType.getDimensionality() != 1) {
				// We do not support tensors yet
				return null;
			}
			return TypeUtil.createArrayType(EcoreUtil.copy(elementArrayType.getElementType()), elements.length, TypeUtil.getArraySize(elementArrayType));
		}

		return TypeUtil.createArrayType(EcoreUtil.copy(elementType), elements.length);
	}

}
