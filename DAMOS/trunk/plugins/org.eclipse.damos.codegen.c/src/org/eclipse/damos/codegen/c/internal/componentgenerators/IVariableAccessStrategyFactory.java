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
package org.eclipse.damos.codegen.c.internal.componentgenerators;

import org.eclipse.damos.codegen.c.IComponentGeneratorContext;
import org.eclipse.damos.codegen.c.internal.componentgenerators.IVariableAccessStrategyFactory.Default;
import org.eclipse.damos.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipse.damos.mscript.computation.ComputationModel;
import org.eclipse.damos.mscript.interpreter.IStaticEvaluationResult;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Andreas Unger
 *
 */
@ImplementedBy(Default.class)
public interface IVariableAccessStrategyFactory {

	IVariableAccessStrategy create(IComponentGeneratorContext context, ComputationModel computationModel, IStaticEvaluationResult staticEvaluationResult);
	
	class Default implements IVariableAccessStrategyFactory {

		@Inject
		private Injector injector;
		
		@Override
		public IVariableAccessStrategy create(IComponentGeneratorContext context, ComputationModel computationModel,
				IStaticEvaluationResult staticEvaluationResult) {
			IVariableAccessStrategy variableAccessStrategy = new VariableAccessStrategy(context, computationModel, staticEvaluationResult);
			injector.injectMembers(variableAccessStrategy);
			return variableAccessStrategy;
		}
		
	}
	
}
