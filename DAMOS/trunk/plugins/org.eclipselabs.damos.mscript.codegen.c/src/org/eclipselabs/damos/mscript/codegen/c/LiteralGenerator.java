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

import java.util.Collections;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ArrayLiteralDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ConstantStringSegment;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.StringConstructionFunction;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.StringTable;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.RecordLiteralDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.util.StringTableUtil;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;
import org.eclipselabs.damos.mscript.interpreter.value.IArrayValue;
import org.eclipselabs.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.MatrixValue;
import org.eclipselabs.damos.mscript.interpreter.value.StringValue;
import org.eclipselabs.damos.mscript.interpreter.value.RecordValue;
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

	public CharSequence generateLiteral(ComputationModel computationModel, Type type, double value) {
		NumberFormat numberFormat = computationModel.getNumberFormat(type);
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

	public CharSequence generateLiteral(ComputationModel computationModel, Type type, long value) {
		NumberFormat numberFormat = computationModel.getNumberFormat(type);
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

	public CharSequence generateLiteral(IMscriptGeneratorConfiguration configuration, ICodeFragmentCollector codeFragmentCollector, IValue value) {
		if (value instanceof IArrayValue) {
			ArrayLiteralDeclaration codeFragment = new ArrayLiteralDeclaration(configuration, (IArrayValue) value);
			codeFragment = codeFragmentCollector.addCodeFragment(codeFragment, new NullProgressMonitor());
			return codeFragment.getName();
		}
		if (value instanceof RecordValue) {
			RecordLiteralDeclaration codeFragment = new RecordLiteralDeclaration(configuration, (RecordValue) value);
			codeFragment = codeFragmentCollector.addCodeFragment(codeFragment, new NullProgressMonitor());
			return codeFragment.getName();
		}
		if (value instanceof StringValue) {
			NullProgressMonitor monitor = new NullProgressMonitor();
			StringConstructionFunction codeFragment = new StringConstructionFunction(configuration, Collections.singletonList(new ConstantStringSegment()), true);
			codeFragment = codeFragmentCollector.addCodeFragment(codeFragment, monitor);
			StringTable stringTable = codeFragmentCollector.addCodeFragment(new StringTable(), monitor);
			StringBuilder sb = new StringBuilder();
			sb.append(codeFragment.getName());
			sb.append("(");
			sb.append(stringTable.addString(((StringValue) value).toString()));
			sb.append(")");
			return sb;
		}
		return generateInitializer(configuration.getComputationModel(), codeFragmentCollector, value);
	}

	public CharSequence generateInitializer(ComputationModel computationModel, ICodeFragmentCollector codeFragmentCollector, IValue value) {
		if (value instanceof ISimpleNumericValue) {
			ISimpleNumericValue numericStaticArgument = (ISimpleNumericValue) value;
			if (value.getDataType() instanceof RealType) {
				return generateLiteral(computationModel, numericStaticArgument.getDataType(), numericStaticArgument.doubleValue());
			}
			if (value.getDataType() instanceof IntegerType) {
				return generateLiteral(computationModel, numericStaticArgument.getDataType(), numericStaticArgument.longValue());
			}
		} else if (value instanceof IBooleanValue) {
			IBooleanValue booleanStaticArgument = (IBooleanValue) value;
			return booleanStaticArgument.booleanValue() ? "1" : "0";
		} else if (value instanceof StringValue) {
			return generateStringInitializer(computationModel, codeFragmentCollector, (StringValue) value);
		} else if (value instanceof VectorValue) {
			return generateVectorInitializer(computationModel, codeFragmentCollector, (IArrayValue) value);
		} else if (value instanceof MatrixValue) {
			return generateMatrixInitializer(computationModel, codeFragmentCollector, (IArrayValue) value);
		} else if (value instanceof RecordValue) {
			return generateStructInitializer(computationModel, codeFragmentCollector, (RecordValue) value);
		}
		throw new IllegalArgumentException();
	}

	private CharSequence generateStringInitializer(ComputationModel computationModel, ICodeFragmentCollector codeFragmentCollector, StringValue value) {
		StringTable stringTable = new StringTable();
		stringTable = (StringTable) codeFragmentCollector.addCodeFragment(stringTable, new NullProgressMonitor());
		
		int index = stringTable.addString(value.toString());

		StringBuilder sb = new StringBuilder();
		sb.append("{ { ");
		for (int maskedIndex : StringTableUtil.maskIndex(index)) {
			sb.append(maskedIndex);
			sb.append(", ");
		}
		sb.append("} }");
		
		return sb;
	}

	private CharSequence generateVectorInitializer(ComputationModel computationModel, ICodeFragmentCollector codeFragmentCollector, IArrayValue value) {
		int size = TypeUtil.getArraySize(value.getDataType());

		StringBuilder sb = new StringBuilder();
		sb.append("{ ");
		for (int i = 0; i < size; ++i) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append(generateInitializer(computationModel, codeFragmentCollector, value.get(i)));
		}
		sb.append(" }");
		
		return sb;
	}

	private CharSequence generateMatrixInitializer(ComputationModel computationModel, ICodeFragmentCollector codeFragmentCollector, IArrayValue value) {
		int rowSize = TypeUtil.getArrayRowSize(value.getDataType());
		int columnSize = TypeUtil.getArrayColumnSize(value.getDataType());

		StringBuilder sb = new StringBuilder();
		sb.append("{ ");
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
		sb.append(" }");
		
		return sb;
	}

	private CharSequence generateStructInitializer(ComputationModel computationModel, ICodeFragmentCollector codeFragmentCollector, RecordValue value) {
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
