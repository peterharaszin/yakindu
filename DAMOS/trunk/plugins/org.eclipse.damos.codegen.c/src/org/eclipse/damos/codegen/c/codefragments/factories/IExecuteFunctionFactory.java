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

import org.eclipse.damos.codegen.c.codefragments.ExecuteFunction;
import org.eclipse.damos.codegen.c.codefragments.factories.IExecuteFunctionFactory.Default;
import org.eclipse.damos.mscript.codegen.c.ICodeFragment;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Andreas Unger
 *
 */
@ImplementedBy(Default.class)
public interface IExecuteFunctionFactory {

	ICodeFragment create();
	
	class Default implements IExecuteFunctionFactory {

		@Inject
		private Injector injector;

		public ICodeFragment create() {
			ExecuteFunction executeFunction = new ExecuteFunction();
			injector.injectMembers(executeFunction);
			return executeFunction;
		}
		
	}
	
}
