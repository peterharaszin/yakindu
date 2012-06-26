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

package org.eclipselabs.damos.mscript.codegen.c;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ArrayLiteralDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.StructLiteralDeclaration;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;
import org.eclipselabs.damos.mscript.interpreter.value.IArrayValue;
import org.eclipselabs.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.MatrixValue;
import org.eclipselabs.damos.mscript.interpreter.value.StructValue;
import org.eclipselabs.damos.mscript.interpreter.value.VectorValue;
import org.eclipselabs.damos.mscript.util.TypeUtil;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class LiteralGenerator {
	
	@Inject
	public LiteralGenerator(DataTypeGenerator dataTypeGenerator) {
	}

	public CharSequence generateLiteral(ComputationModel computationModel, DataType dataType, double value) {
		NumberFormat numberFormat = computationModel.getNumberFormat(dataType);
		return generateLiteral(computationModel, numberFormat, value);
	}
	
	public CharSequence generateLiteral(ComputationModel computationModel, NumberFormat numberFormat, double value) {
		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			return String.format("INT%d_C(%d)", fixedPointFormat.getWordSize(), Math.round(value * Math.pow(2, fixedPointFormat.getFractionLength())));
		}
		if (numberFormat instanceof FloatingPointFormat) {
			FloatingPointFormat floatingPointFormat = (FloatingPointFormat) numberFormat;
			switch (floatingPointFormat.getKind()) {
			case BINARY32:
				return Double.toString(value) + "f";
			case BINARY64:
				return Double.toString(value);
			default:
				throw new IllegalArgumentException("Unknown number floating point kind " + floatingPointFormat.getKind().getName());
			}
		}
		throw new IllegalArgumentException("Unknown number format " + numberFormat.getClass().getCanonicalName());
	}

	public CharSequence generateLiteral(ComputationModel computationModel, DataType dataType, long value) {
		NumberFormat numberFormat = computationModel.getNumberFormat(dataType);
		return generateLiteral(computationModel, numberFormat, value);
	}

	public CharSequence generateLiteral(ComputationModel computationModel, NumberFormat numberFormat, long value) {
		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			value <<= fixedPointFormat.getFractionLength();
			return String.format("INT%d_C(%d)", fixedPointFormat.getWordSize(), value);
		}
		if (numberFormat instanceof FloatingPointFormat) {
			FloatingPointFormat floatingPointFormat = (FloatingPointFormat) numberFormat;
			switch (floatingPointFormat.getKind()) {
			case BINARY32:
				return Long.toString(value) + ".0f";
			case BINARY64:
				return Long.toString(value) + ".0";
			default:
				throw new IllegalArgumentException("Unknown number floating point kind " + floatingPointFormat.getKind().getName());
			}
		}
		throw new IllegalArgumentException("Unknown number format " + numberFormat.getClass().getCanonicalName());
	}

	public CharSequence generateLiteral(ComputationModel computationModel, ICodeFragmentCollector codeFragmentCollector, IValue value) {
		if (value instanceof IArrayValue) {
			ArrayLiteralDeclaration codeFragment = new ArrayLiteralDeclaration(computationModel, (IArrayValue) value);
			codeFragment = (ArrayLiteralDeclaration) codeFragmentCollector.addCodeFragment(codeFragment, new NullProgressMonitor());
			return codeFragment.getName();
		}
		if (value instanceof StructValue) {
			StructLiteralDeclaration codeFragment = new StructLiteralDeclaration(computationModel, (StructValue) value);
			codeFragment = (StructLiteralDeclaration) codeFragmentCollector.addCodeFragment(codeFragment, new NullProgressMonitor());
			return codeFragment.getName();
		}
		return generateInitializer(computationModel, codeFragmentCollector, value);
	}

	public CharSequence generateInitializer(ComputationModel computationModel, ICodeFragmentCollector codeFragmentCollector, IValue value) {
		if (value instanceof ISimpleNumericValue) {
			ISimpleNumericValue numericTemplateArgument = (ISimpleNumericValue) value;
			if (value.getDataType() instanceof RealType) {
				return generateLiteral(computationModel, numericTemplateArgument.getDataType(), numericTemplateArgument.doubleValue());
			}
			if (value.getDataType() instanceof IntegerType) {
				return generateLiteral(computationModel, numericTemplateArgument.getDataType(), numericTemplateArgument.longValue());
			}
		} else if (value instanceof IBooleanValue) {
			IBooleanValue booleanTemplateArgument = (IBooleanValue) value;
			return booleanTemplateArgument.booleanValue() ? "1" : "0";
		} else if (value instanceof VectorValue) {
			return generateVectorInitializer(computationModel, codeFragmentCollector, (IArrayValue) value);
		} else if (value instanceof MatrixValue) {
			return generateMatrixInitializer(computationModel, codeFragmentCollector, (IArrayValue) value);
		} else if (value instanceof StructValue) {
			return generateStructInitializer(computationModel, codeFragmentCollector, (StructValue) value);
		}
		throw new IllegalArgumentException();
	}

	private CharSequence generateVectorInitializer(ComputationModel computationModel, ICodeFragmentCollector codeFragmentCollector, IArrayValue value) {
		int size = TypeUtil.getArraySize(value.getDataType());

		StringBuilder sb = new StringBuilder();
		sb.append("{ { ");
		for (int i = 0; i < size; ++i) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append(generateInitializer(computationModel, codeFragmentCollector, value.get(i)));
		}
		sb.append(" } }");
		
		return sb;
	}

	private CharSequence generateMatrixInitializer(ComputationModel computationModel, ICodeFragmentCollector codeFragmentCollector, IArrayValue value) {
		int rowSize = TypeUtil.getArrayRowSize(value.getDataType());
		int columnSize = TypeUtil.getArrayColumnSize(value.getDataType());

		StringBuilder sb = new StringBuilder();
		sb.append("{ { ");
		for (int i = 0; i < rowSize; ++i) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append("{ ");
			for (int j = 0; j < columnSize; ++j) {
				if (j > 0) {
					sb.append(", ");
				}
				sb.append(generateInitializer(computationModel, codeFragmentCollector, value.get(i, j)));
			}
			sb.append(" }");
		}
		sb.append(" } }");
		
		return sb;
	}

	private CharSequence generateStructInitializer(ComputationModel computationModel, ICodeFragmentCollector codeFragmentCollector, StructValue value) {
		StringBuilder sb = new StringBuilder();
		sb.append("{ ");
		for (int i = 0; i < value.getDataType().getMembers().size(); ++i) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append(generateInitializer(computationModel, codeFragmentCollector, value.get(i)));
		}
		sb.append(" }");
		return sb;
	}

}
