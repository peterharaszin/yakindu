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
import org.eclipse.damos.mscript.codegen.c.codefragments.ContextStruct;
import org.eclipse.damos.mscript.codegen.c.codefragments.factories.IContextStructFactory.Default;
import org.eclipse.damos.mscript.interpreter.StaticFunctionInfo;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Andreas Unger
 *
 */
@ImplementedBy(Default.class)
public interface IContextStructFactory {

	ICodeFragment create(StaticFunctionInfo functionInfo, String name, boolean singleton);
	
	class Default implements IContextStructFactory {
		
		@Inject
		private Injector injector;
		
		public ICodeFragment create(StaticFunctionInfo functionInfo, String name, boolean singleton) {
			ContextStruct contextStruct = new ContextStruct(functionInfo, name, singleton);
			injector.injectMembers(contextStruct);
			return contextStruct;
		}
		
	}

}
