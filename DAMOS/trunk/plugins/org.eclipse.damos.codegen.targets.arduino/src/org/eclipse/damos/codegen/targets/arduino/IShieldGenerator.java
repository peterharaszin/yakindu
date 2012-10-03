/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger. All rights reserved.
 ****************************************************************************/

package org.eclipse.damos.codegen.targets.arduino;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.codegen.c.IComponentGenerator;
import org.eclipse.damos.codegen.c.IGeneratorContext;
import org.eclipse.damos.dconfig.Binding;
import org.eclipse.damos.execution.ComponentNode;

/**
 * @author Andreas Unger
 *
 */
public interface IShieldGenerator {

	IComponentGenerator createBoundaryComponentGenerator(IGeneratorContext context, ComponentNode node, Binding binding);

	void generate(IGeneratorContext context, IProgressMonitor monitor) throws CoreException;

}
