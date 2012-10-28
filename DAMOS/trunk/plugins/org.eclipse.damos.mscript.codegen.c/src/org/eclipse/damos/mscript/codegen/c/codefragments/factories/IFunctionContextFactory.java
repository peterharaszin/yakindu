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

import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipse.damos.mscript.codegen.c.codefragments.FunctionContext;
import org.eclipse.damos.mscript.codegen.c.codefragments.IContextStructMember;
import org.eclipse.damos.mscript.codegen.c.codefragments.factories.IFunctionContextFactory.Default;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Andreas Unger
 *
 */
@ImplementedBy(Default.class)
public interface IFunctionContextFactory {

	IContextStructMember create(IMscriptGeneratorContext generatorContext);
	
	class Default implements IFunctionContextFactory {
		
		@Inject
		private Injector injector;
		
		@Override
		public IContextStructMember create(IMscriptGeneratorContext generatorContext) {
			IContextStructMember functionContext = new FunctionContext(generatorContext);
			injector.injectMembers(functionContext);
			return functionContext;
		}
		
	}
	
}
