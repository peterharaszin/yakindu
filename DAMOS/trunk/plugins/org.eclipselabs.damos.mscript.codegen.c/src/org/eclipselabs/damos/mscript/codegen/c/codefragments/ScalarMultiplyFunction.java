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

package org.eclipselabs.damos.mscript.codegen.c.codefragments;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.MultiplicativeOperator;
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipselabs.damos.mscript.codegen.c.IMultiplicativeExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.InlineMultiplicativeExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.NumericExpressionInfo;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;

/**
 * @author Andreas Unger
 *
 */
public class ScalarMultiplyFunction extends AbstractCodeFragment {
	
	private final IMultiplicativeExpressionGenerator multiplicativeExpressionGenerator = new InlineMultiplicativeExpressionGenerator();

	private final ComputationModel computationModel;
	private final DataType scalarType;
	private final DataType elementType;
	private final ArrayType resultType;
	
	private String scalarTypeString;
	private String elementTypeString;
	private String resultTypeString;
	
	private NumberFormat scalarNumberFormat;
	private NumberFormat elementNumberFormat;
	private NumberFormat resultElementNumberFormat;
	
	private String name;
	
	private String functionBody;
	
	/**
	 * 
	 */
	public ScalarMultiplyFunction(ComputationModel computationModel, DataType scalarType, DataType elementType, ArrayType resultType) {
		this.computationModel = computationModel;
		this.scalarType = scalarType;
		this.elementType = elementType;
		this.resultType = resultType;

		scalarNumberFormat = computationModel.getNumberFormat(scalarType);
		elementNumberFormat = computationModel.getNumberFormat(elementType);
		resultElementNumberFormat = computationModel.getNumberFormat(resultType.getElementType());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#dependsOn(org.eclipselabs.damos.mscript.codegen.c.ICodeFragment)
	 */
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public void initialize(IAdaptable context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, new IDependencyRule() {
			
			public boolean applies(ICodeFragment other) {
				return other instanceof ArrayTypeDeclaration;
			}
			
		});
		
		ICodeFragmentCollector codeFragmentCollector = (ICodeFragmentCollector) context.getAdapter(ICodeFragmentCollector.class);

		scalarTypeString = MscriptGeneratorUtil.getCDataType(computationModel, (ICodeFragmentCollector) context.getAdapter(ICodeFragmentCollector.class), scalarType, this);
		elementTypeString = MscriptGeneratorUtil.getCDataType(computationModel, (ICodeFragmentCollector) context.getAdapter(ICodeFragmentCollector.class), elementType, this);
		resultTypeString = MscriptGeneratorUtil.getCDataType(computationModel, (ICodeFragmentCollector) context.getAdapter(ICodeFragmentCollector.class), resultType, this);
		
		IGlobalNameProvider globalNameProvider = (IGlobalNameProvider) context.getAdapter(IGlobalNameProvider.class);
		name = globalNameProvider.getName("scalarMultiply");
		
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		
		out.println(" {");
		out.printf("%s result;\n", resultTypeString);
		out.println("int i;");
		out.println("for (i = 0; i < size; ++i) {");
		out.print("result.data[i] = ");

		NumericExpressionInfo leftOperand = NumericExpressionInfo.create(scalarNumberFormat, "scalar");
		NumericExpressionInfo rightOperand = NumericExpressionInfo.create(elementNumberFormat, "vector[i]");
		out.print(multiplicativeExpressionGenerator.generate(codeFragmentCollector, MultiplicativeOperator.MULTIPLY, resultElementNumberFormat, leftOperand, rightOperand));
		
		out.println(";");
		out.println("}");
		out.println("return result;");
		out.println("}");
		
		functionBody = sb.toString();
	}
	
	public CharSequence generateForwardDeclaration(boolean internal) {
		StringBuilder sb = new StringBuilder();
		sb.append(generateFunctionSignature(internal));
		sb.append(";\n");
		return sb;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#contributesImplementation()
	 */
	@Override
	public boolean contributesImplementation() {
		return true;
	}
	
	@Override
	public CharSequence generateImplementation(boolean internal) {
		StringBuilder sb = new StringBuilder();
		sb.append(generateFunctionSignature(internal));
		sb.append(functionBody);
		return sb;
	}
	
	private CharSequence generateFunctionSignature(boolean internal) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		if (internal) {
			out.print("static ");
		}
		out.printf("%s %s(%s scalar, const %s vector[], int size)", resultTypeString, name, scalarTypeString, elementTypeString);
		return sb;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return getClass().hashCode() ^ scalarNumberFormat.getClass().hashCode()
				^ elementNumberFormat.getClass().hashCode() ^ resultElementNumberFormat.getClass().hashCode();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ScalarMultiplyFunction) {
			ScalarMultiplyFunction other = (ScalarMultiplyFunction) obj;
			return other.scalarNumberFormat.isEquivalentTo(scalarNumberFormat) && other.elementNumberFormat.isEquivalentTo(elementNumberFormat) && other.resultElementNumberFormat.isEquivalentTo(resultElementNumberFormat);
		}
		return false;
	}
	
}
