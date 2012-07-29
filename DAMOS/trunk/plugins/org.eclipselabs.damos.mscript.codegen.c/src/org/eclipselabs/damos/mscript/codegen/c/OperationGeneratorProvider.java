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

import java.util.ArrayList;
import java.util.List;

import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.codegen.c.operationgenerators.AlgorithmExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.operationgenerators.ArrayElementWiseOperationGenerator;
import org.eclipselabs.damos.mscript.codegen.c.operationgenerators.ArrayScalarMultiplyGenerator;
import org.eclipselabs.damos.mscript.codegen.c.operationgenerators.DefaultOperationGenerator;
import org.eclipselabs.damos.mscript.codegen.c.operationgenerators.FoldFunctionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.operationgenerators.InspectExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.operationgenerators.MapFunctionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.operationgenerators.MatrixMultiplyGenerator;
import org.eclipselabs.damos.mscript.codegen.c.operationgenerators.MatrixVectorMultiplyGenerator;
import org.eclipselabs.damos.mscript.codegen.c.operationgenerators.UnionConstructionOperatorGenerator;
import org.eclipselabs.damos.mscript.codegen.c.operationgenerators.VectorMatrixMultiplyGenerator;

/**
 * @author Andreas Unger
 *
 */
public class OperationGeneratorProvider implements IOperationGeneratorProvider {
	
	private static final List<IOperationGenerator> GENERATORS = new ArrayList<IOperationGenerator>();
	
	static {
		GENERATORS.add(new ArrayElementWiseOperationGenerator());
		GENERATORS.add(new ArrayScalarMultiplyGenerator());
		GENERATORS.add(new MatrixMultiplyGenerator());
		GENERATORS.add(new MatrixVectorMultiplyGenerator());
		GENERATORS.add(new VectorMatrixMultiplyGenerator());
		GENERATORS.add(new FoldFunctionGenerator());
		GENERATORS.add(new MapFunctionGenerator());
		GENERATORS.add(new AlgorithmExpressionGenerator());
		GENERATORS.add(new InspectExpressionGenerator());
		GENERATORS.add(new UnionConstructionOperatorGenerator());
		GENERATORS.add(new DefaultOperationGenerator());
	}

	public IOperationGenerator getGenerator(IMscriptGeneratorContext context, Type resultDataType, Expression expression) {
		for (IOperationGenerator generator : GENERATORS) {
			if (generator.canHandle(context, resultDataType, expression)) {
				return generator;
			}
		}
		return null;
	}

}
