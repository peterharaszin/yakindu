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

package org.eclipse.damos.mscript.codegen.c;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.codegen.c.operationgenerators.AlgorithmExpressionGenerator;
import org.eclipse.damos.mscript.codegen.c.operationgenerators.ArrayElementWiseOperationGenerator;
import org.eclipse.damos.mscript.codegen.c.operationgenerators.ArrayScalarMultiplyGenerator;
import org.eclipse.damos.mscript.codegen.c.operationgenerators.DefaultOperationGenerator;
import org.eclipse.damos.mscript.codegen.c.operationgenerators.FoldFunctionGenerator;
import org.eclipse.damos.mscript.codegen.c.operationgenerators.InspectExpressionGenerator;
import org.eclipse.damos.mscript.codegen.c.operationgenerators.MapFunctionGenerator;
import org.eclipse.damos.mscript.codegen.c.operationgenerators.MatrixMultiplyGenerator;
import org.eclipse.damos.mscript.codegen.c.operationgenerators.MatrixVectorMultiplyGenerator;
import org.eclipse.damos.mscript.codegen.c.operationgenerators.UnionConstructionOperatorGenerator;
import org.eclipse.damos.mscript.codegen.c.operationgenerators.VectorMatrixMultiplyGenerator;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Andreas Unger
 *
 */
@Singleton
public class OperationGeneratorProvider implements IOperationGeneratorProvider {
	
	@Inject
	private ArrayElementWiseOperationGenerator arrayElementWiseOperationGenerator;
	
	@Inject
	private ArrayScalarMultiplyGenerator arrayScalarMultiplyGenerator;
	
	@Inject
	private MatrixMultiplyGenerator matrixMultiplyGenerator;
	
	@Inject
	private MatrixVectorMultiplyGenerator matrixVectorMultiplyGenerator;
	
	@Inject
	private VectorMatrixMultiplyGenerator vectorMatrixMultiplyGenerator;
	
	@Inject
	private FoldFunctionGenerator foldFunctionGenerator;
	
	@Inject
	private MapFunctionGenerator mapFunctionGenerator;
	
	@Inject
	private AlgorithmExpressionGenerator algorithmExpressionGenerator;
	
	@Inject
	private InspectExpressionGenerator inspectExpressionGenerator;
	
	@Inject
	private UnionConstructionOperatorGenerator unionConstructionOperatorGenerator;
	
	@Inject
	private DefaultOperationGenerator defaultOperationGenerator;
	
	private List<IOperationGenerator> generators;
	
	public IOperationGenerator getGenerator(IMscriptGeneratorContext context, Type resultDataType, Expression expression) {
		if (generators == null) {
			initializeGenerators();
		}
		for (IOperationGenerator generator : generators) {
			if (generator.canHandle(context, resultDataType, expression)) {
				return generator;
			}
		}
		return null;
	}
	
	private void initializeGenerators() {
		generators = new ArrayList<IOperationGenerator>();
		generators.add(arrayElementWiseOperationGenerator);
		generators.add(arrayScalarMultiplyGenerator);
		generators.add(matrixMultiplyGenerator);
		generators.add(matrixVectorMultiplyGenerator);
		generators.add(vectorMatrixMultiplyGenerator);
		generators.add(foldFunctionGenerator);
		generators.add(mapFunctionGenerator);
		generators.add(algorithmExpressionGenerator);
		generators.add(inspectExpressionGenerator);
		generators.add(unionConstructionOperatorGenerator);
		generators.add(defaultOperationGenerator);
	}

}
