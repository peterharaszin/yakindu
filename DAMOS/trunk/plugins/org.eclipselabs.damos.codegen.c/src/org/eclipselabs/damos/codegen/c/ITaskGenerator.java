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

package org.eclipselabs.damos.codegen.c;

import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.execution.ComponentNode;

/**
 * @author Andreas Unger
 *
 */
public interface ITaskGenerator {

	void writeTaskInfoInclude(IGeneratorContext context, Appendable appendable, IProgressMonitor monitor) throws IOException;
	
	void writeMultitaskingIncludes(IGeneratorContext context, Appendable appendable, IProgressMonitor monitor) throws IOException;
	
	void writeExternVariables(IGeneratorContext context, Appendable appendable, IProgressMonitor monitor) throws IOException;
	
	void writeTaskStructs(IGeneratorContext context, Appendable appendable, IProgressMonitor monitor) throws IOException;

	void writeTaskContexts(IGeneratorContext context, Appendable appendable, IProgressMonitor monitor) throws IOException;

	void writeTasks(IGeneratorContext context, Appendable appendable, IProgressMonitor monitor) throws IOException;

	void writeInitializeTasks(IGeneratorContext context, Appendable appendable, IProgressMonitor monitor) throws IOException;

	void writeLatchUpdate(IGeneratorContext context, Appendable appendable, ComponentNode componentNode, IProgressMonitor monitor)
			throws IOException;

	void writeMessageQueueSend(IGeneratorContext context, Appendable appendable, ComponentNode componentNode, IProgressMonitor monitor)
			throws IOException;

}