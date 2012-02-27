/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.codegen.c.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipselabs.damos.codegen.c.CodegenCPlugin;
import org.eclipselabs.damos.codegen.c.ComponentGeneratorStatus;
import org.eclipselabs.damos.codegen.c.IComponentGenerator;
import org.eclipselabs.damos.codegen.c.internal.registry.ComponentGeneratorProviderRegistry;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionflow.CompoundNode;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlow;
import org.eclipselabs.damos.execution.executionflow.Graph;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.execution.executionflow.TaskGraph;

/**
 * @author Andreas Unger
 *
 */
public class ComponentGeneratorAdaptor {

	public void adaptGenerators(Configuration configuration, ExecutionFlow executionFlow, IProgressMonitor monitor) throws CoreException {
		List<Component> missingGeneratorComponents = new ArrayList<Component>();
		
		for (TaskGraph taskGraph : executionFlow.getTaskGraphs()) {
			adaptGenerators(taskGraph, missingGeneratorComponents);
		}
		adaptGenerators(executionFlow.getGraph(), missingGeneratorComponents);
		
		if (!missingGeneratorComponents.isEmpty()) {
			StringBuilder sb = new StringBuilder("Missing component generator for ");
			boolean first = true;
			for (Component component : missingGeneratorComponents) {
				if (first) {
					first = false;
				} else {
					sb.append(", ");
				}
				sb.append("'");
				sb.append(component.getName());
				sb.append("'");
			}
			throw new CoreException(new ComponentGeneratorStatus(
					IStatus.ERROR, CodegenCPlugin.PLUGIN_ID, 0, sb.toString(), null, missingGeneratorComponents));
		}
	}

	/**
	 * @param graph
	 * @param signatures
	 * @param missingGeneratorComponents
	 */
	private void adaptGenerators(Graph graph, List<Component> missingGeneratorComponents) {
		for (Node node : graph.getNodes()) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				Component component = componentNode.getComponent();
				IComponentGenerator generator;
				generator = ComponentGeneratorProviderRegistry.getInstance().createGenerator(component);
				if (generator != null) {
					node.eAdapters().add(new ComponentGeneratorAdapter(generator));
				} else {
					missingGeneratorComponents.add(component);
				}
			} else if (node instanceof CompoundNode) {
				adaptGenerators((CompoundNode) node, missingGeneratorComponents);
			}
		}
	}
	
}
