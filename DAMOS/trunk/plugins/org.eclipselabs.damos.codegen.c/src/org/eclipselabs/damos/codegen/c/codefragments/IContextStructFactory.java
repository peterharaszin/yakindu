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

package org.eclipselabs.damos.codegen.c.codefragments;

import org.eclipselabs.damos.codegen.c.ITaskGenerator;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Andreas Unger
 *
 */
@ImplementedBy(IContextStructFactory.Default.class)
public interface IContextStructFactory {

	ICodeFragment create();
	
	class Default implements IContextStructFactory {

		private final Provider<ITaskGenerator> taskGeneratorProvider;
		
		@Inject
		Default(Provider<ITaskGenerator> taskGeneratorProvider) {
			this.taskGeneratorProvider = taskGeneratorProvider;
		}
		
		public ICodeFragment create() {
			return new ContextStruct(taskGeneratorProvider.get());
		}
		
	}
	
}
