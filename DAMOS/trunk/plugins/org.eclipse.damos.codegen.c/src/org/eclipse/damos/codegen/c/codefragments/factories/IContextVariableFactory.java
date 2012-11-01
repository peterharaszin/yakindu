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

import org.eclipse.damos.codegen.c.codefragments.ContextVariable;
import org.eclipse.damos.codegen.c.codefragments.factories.IContextVariableFactory.Default;
import org.eclipse.damos.mscript.codegen.c.ICodeFragment;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Andreas Unger
 *
 */
@ImplementedBy(Default.class)
public interface IContextVariableFactory {

	ICodeFragment create();
	
	class Default implements IContextVariableFactory {

		@Inject
		private Injector injector;
		
		public ICodeFragment create() {
			ContextVariable contextVariable = new ContextVariable();
			injector.injectMembers(contextVariable);
			return contextVariable;
		}
		
	}
	
}
