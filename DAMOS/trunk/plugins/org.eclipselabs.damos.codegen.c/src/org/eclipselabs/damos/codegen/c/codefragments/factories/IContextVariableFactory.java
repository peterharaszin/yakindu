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

package org.eclipselabs.damos.codegen.c.codefragments.factories;

import org.eclipselabs.damos.codegen.c.codefragments.ContextVariable;
import org.eclipselabs.damos.codegen.c.codefragments.factories.IContextVariableFactory.Default;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.factories.IContextStructFactory;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
@ImplementedBy(Default.class)
public interface IContextVariableFactory {

	ICodeFragment create();
	
	class Default implements IContextVariableFactory {

		private final IContextStructFactory contextStructFactory;
		
		@Inject
		Default(IContextStructFactory contextStructFactory) {
			this.contextStructFactory = contextStructFactory;
		}
		
		public ICodeFragment create() {
			return new ContextVariable(contextStructFactory);
		}
		
	}
	
}
