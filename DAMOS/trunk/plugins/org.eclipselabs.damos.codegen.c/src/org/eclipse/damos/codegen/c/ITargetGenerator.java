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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.dconfig.Configuration;
import org.eclipse.damos.execution.ComponentNode;

/**
 * @author Andreas Unger
 *
 */
public interface ITargetGenerator {

	Configuration createConfiguration(Configuration baseConfiguration, IProgressMonitor monitor) throws CoreException;

	IComponentGenerator createBoundaryComponentGenerator(IGeneratorContext context, ComponentNode node);

	void generate(IGeneratorContext context, IProgressMonitor monitor) throws CoreException;
	
}
