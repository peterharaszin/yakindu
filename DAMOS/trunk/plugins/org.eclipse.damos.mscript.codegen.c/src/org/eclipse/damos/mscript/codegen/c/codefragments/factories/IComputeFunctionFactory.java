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
package org.eclipse.damos.mscript.codegen.c.codefragments.factories;

import org.eclipse.damos.mscript.codegen.c.ICodeFragment;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipse.damos.mscript.codegen.c.codefragments.ComputeFunction;
import org.eclipse.damos.mscript.codegen.c.codefragments.factories.IComputeFunctionFactory.Default;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Andreas Unger
 *
 */
@ImplementedBy(Default.class)
public interface IComputeFunctionFactory {

	ICodeFragment create(IMscriptGeneratorContext generatorContext);
	
	class Default implements IComputeFunctionFactory {
		
		@Inject
		private Injector injector;
		
		@Override
		public ICodeFragment create(IMscriptGeneratorContext generatorContext) {
			ICodeFragment codeFragment = new ComputeFunction(generatorContext);
			injector.injectMembers(codeFragment);
			return codeFragment;
		}
		
	}
	
}
