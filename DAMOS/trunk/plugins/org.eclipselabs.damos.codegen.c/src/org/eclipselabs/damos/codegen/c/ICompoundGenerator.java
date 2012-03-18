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
import org.eclipselabs.damos.execution.executionflow.CompoundNode;
import org.eclipselabs.damos.execution.executionflow.Graph;

/**
 * @author Andreas Unger
 *
 */
public interface ICompoundGenerator {

	void writeChoiceVariableDeclarations(IGeneratorContext context, Appendable appendable, Graph graph, IProgressMonitor monitor) throws IOException;

	void writeCompoundCode(IGeneratorContext context, Appendable appendable, CompoundNode compoundNode,
			IProgressMonitor monitor) throws IOException;

}
