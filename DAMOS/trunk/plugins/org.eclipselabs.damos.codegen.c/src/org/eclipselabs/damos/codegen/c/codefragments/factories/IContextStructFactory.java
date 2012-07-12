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

import org.eclipselabs.damos.codegen.c.ITaskGenerator;
import org.eclipselabs.damos.codegen.c.codefragments.ContextStruct;
import org.eclipselabs.damos.codegen.c.codefragments.factories.IContextStructFactory.Default;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
@ImplementedBy(Default.class)
public interface IContextStructFactory {

	ICodeFragment create();
	
	class Default implements IContextStructFactory {
		
		private final ITaskGenerator taskGenerator;
		private final ITaskMessageStructFactory taskMessageStructFactory;

		@Inject
		Default(ITaskGenerator taskGenerator, ITaskMessageStructFactory taskMessageStructFactory) {
			this.taskGenerator = taskGenerator;
			this.taskMessageStructFactory = taskMessageStructFactory;
		}

		public ICodeFragment create() {
			return new ContextStruct(taskGenerator, taskMessageStructFactory);
		}
		
	}

}
