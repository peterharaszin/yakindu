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

import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.execution.ComponentNode;

/**
 * @author Andreas Unger
 *
 */
public interface ITargetGenerator {

	Configuration createConfiguration(Configuration baseConfiguration, IProgressMonitor monitor) throws CoreException;

	Collection<String> getImplementationIncludes(IGeneratorContext context);
	
	IComponentGenerator createBoundaryComponentGenerator(IGeneratorContext context, ComponentNode node);

	void generate(IGeneratorContext context, IProgressMonitor monitor) throws CoreException;
	
}
