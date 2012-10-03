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

package org.eclipse.damos.codegen.c;

import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.execution.Graph;
import org.eclipse.damos.mscript.codegen.c.Include;

/**
 * @author Andreas Unger
 *
 */
public interface IGraphGenerator {
	
	Collection<Include> getImplementationIncludes(IGeneratorContext context, Graph graph);

	CharSequence generateGraph(IGeneratorContext context, Graph graph, IProgressMonitor monitor);

	boolean contributesOutputVariableDeclarations(IGeneratorContext context, Graph graph);
			
	CharSequence generateOutputVariableDeclarations(IGeneratorContext context, Graph graph, IProgressMonitor monitor);

}