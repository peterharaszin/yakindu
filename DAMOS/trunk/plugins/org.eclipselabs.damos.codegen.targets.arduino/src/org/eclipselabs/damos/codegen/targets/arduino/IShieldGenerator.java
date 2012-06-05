/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger. All rights reserved.
 ****************************************************************************/

package org.eclipselabs.damos.codegen.targets.arduino;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.IComponentGenerator;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.dconfig.Binding;
import org.eclipselabs.damos.execution.ComponentNode;

/**
 * @author Andreas Unger
 *
 */
public interface IShieldGenerator {

	IComponentGenerator createBoundaryComponentGenerator(IGeneratorContext context, ComponentNode node, Binding binding);

	void generate(IGeneratorContext context, IProgressMonitor monitor) throws CoreException;

}
