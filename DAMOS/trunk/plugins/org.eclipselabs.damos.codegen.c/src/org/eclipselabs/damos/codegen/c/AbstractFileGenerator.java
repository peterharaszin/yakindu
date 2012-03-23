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

import java.util.ArrayList;
import java.util.List;

import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationUtil;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.dml.Inport;
import org.eclipselabs.damos.dml.Outport;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.Node;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractFileGenerator implements IFileGenerator {

	protected void writeExecutionFunctionSignature(IGeneratorContext context, Appendable appendable) {
		PrintAppendable out = new PrintAppendable(appendable);
		String prefix = GeneratorConfigurationUtil.getPrefix(context.getConfiguration());
		
		boolean hasInput = !getInportNodes(context).isEmpty();
		boolean hasOutput = !getOutportNodes(context).isEmpty();
		
		out.printf("void %sexecute(", prefix);
		if (hasInput || hasOutput) {
			if (hasInput) {
				out.printf("const %sInput *input", prefix);
				if (hasOutput) {
					out.print(", ");
				}
			}
			if (hasOutput) {
				out.printf("%sOutput *output", prefix);
			}
		} else {
			out.print("void");
		}
		out.print(")");
	}
	
	protected List<ComponentNode> getInportNodes(IGeneratorContext context) {
		List<ComponentNode> inportNodes = new ArrayList<ComponentNode>();
		for (Node node : context.getExecutionFlow().getGraph().getNodes()) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				if (componentNode.getComponent() instanceof Inport) {
					inportNodes.add(componentNode);
				}
			}
		}
		return inportNodes;
	}

	protected List<ComponentNode> getOutportNodes(IGeneratorContext context) {
		List<ComponentNode> outportNodes = new ArrayList<ComponentNode>();
		for (Node node : context.getExecutionFlow().getGraph().getNodes()) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				if (componentNode.getComponent() instanceof Outport) {
					outportNodes.add(componentNode);
				}
			}
		}
		return outportNodes;
	}

}
