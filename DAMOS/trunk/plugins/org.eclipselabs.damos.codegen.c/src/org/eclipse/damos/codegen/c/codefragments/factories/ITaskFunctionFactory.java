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

package org.eclipse.damos.codegen.c.codefragments.factories;

import org.eclipse.damos.codegen.c.IGraphGenerator;
import org.eclipse.damos.codegen.c.codefragments.TaskFunction;
import org.eclipse.damos.codegen.c.codefragments.factories.ITaskFunctionFactory.Default;
import org.eclipse.damos.mscript.codegen.c.ICodeFragment;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
@ImplementedBy(Default.class)
public interface ITaskFunctionFactory {

	ICodeFragment create();
	
	static class Default implements ITaskFunctionFactory {

		private final IGraphGenerator graphGenerator;

		@Inject
		Default(IGraphGenerator graphGenerator) {
			this.graphGenerator = graphGenerator;
		}

		public ICodeFragment create() {
			return new TaskFunction(graphGenerator);
		}
		
	}
	
}
