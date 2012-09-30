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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.codegen.c.ITaskGenerator;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.AbstractContextStructPart;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ContextStruct;

/**
 * @author Andreas Unger
 *
 */
public class TaskContexts extends AbstractContextStructPart {

	private final CharSequence content;
	
	/**
	 * 
	 */
	private TaskContexts(CharSequence content) {
		this.content = content;
	}

	public CharSequence generate() {
		return content;
	}
	
	public static void initialize(ITaskGenerator taskGenerator, IGeneratorContext context, IProgressMonitor monitor) {
		CharSequence content = taskGenerator.generateTaskContexts(context, monitor);
		if (content.length() > 0) {
			ContextStruct contextStruct = context.addCodeFragment(new ContextStruct(GeneratorConfigurationExtensions.isSingleton(context.getConfiguration())), new NullProgressMonitor());
			contextStruct.addPart(new TaskContexts(content));
		}
	}

}
