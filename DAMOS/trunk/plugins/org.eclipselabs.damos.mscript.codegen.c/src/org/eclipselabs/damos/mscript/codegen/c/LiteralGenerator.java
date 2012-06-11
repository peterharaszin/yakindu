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
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;
import org.eclipselabs.damos.mscript.interpreter.value.IArrayValue;
import org.eclipselabs.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.StructValue;
import org.eclipselabs.damos.mscript.util.TypeUtil;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class LiteralGenerator {
	
	private final DataTypeGenerator dataTypeGenerator;
	
	@Inject
	public LiteralGenerator(DataTypeGenerator dataTypeGenerator) {
		this.dataTypeGenerator = dataTypeGenerator;
	}

	public CharSequence generateLiteral(ComputationModel computationModel, ICodeFragmentCollector codeFragmentCollector, DataType dataType, double value, ICodeFragment dependentCodeFragment) {
		NumberFormat numberFormat = computationModel.getNumberFormat(dataType);
		CharSequence cDataType = dataTypeGenerator.generateDataType(computationModel, codeFragmentCollector, dataType, dependentCodeFragment);
		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			return String.format("(%s) %d", cDataType, Math.round(value * Math.pow(2, fixedPointFormat.getFractionLength())));
		}
		return String.format("(%s) %s", cDataType, Double.toString(value));
	}

	public CharSequence generateLiteral(ComputationModel computationModel, ICodeFragmentCollector codeFragmentCollector, DataType dataType, long value, ICodeFragment dependentCodeFragment) {
		NumberFormat numberFormat = computationModel.getNumberFormat(dataType);
		CharSequence cDataType = dataTypeGenerator.generateDataType(computationModel, codeFragmentCollector, dataType, dependentCodeFragment);
		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			value <<= fixedPointFormat.getFractionLength();
		}
		return String.format("(%s) %d", cDataType, value);
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
				return generateLiteral(computationModel, codeFragmentCollector, numericTemplateArgument.getDataType(), numericTemplateArgument.doubleValue(), null);
			}
			if (value.getDataType() instanceof IntegerType) {
				return generateLiteral(computationModel, codeFragmentCollector, numericTemplateArgument.getDataType(), numericTemplateArgument.longValue(), null);
			}
		} else if (value instanceof IBooleanValue) {
			IBooleanValue booleanTemplateArgument = (IBooleanValue) value;
			return booleanTemplateArgument.booleanValue() ? "1" : "0";
		} else if (value instanceof IArrayValue) {
			return generateArrayInitializer(computationModel, codeFragmentCollector, (IArrayValue) value);
		} else if (value instanceof StructValue) {
			return generateStructInitializer(computationModel, codeFragmentCollector, (StructValue) value);
		}
		throw new IllegalArgumentException();
	}

	private CharSequence generateArrayInitializer(ComputationModel computationModel, ICodeFragmentCollector codeFragmentCollector, IArrayValue value) {
		StringBuilder sb = new StringBuilder();
		sb.append("{ { ");
		int size = TypeUtil.getArraySize(value.getDataType());
		for (int i = 0; i < size; ++i) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append(generateInitializer(computationModel, codeFragmentCollector, value.get(i)));
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
