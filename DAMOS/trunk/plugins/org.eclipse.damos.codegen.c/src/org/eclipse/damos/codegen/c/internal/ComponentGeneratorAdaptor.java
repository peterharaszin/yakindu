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

package org.eclipse.damos.codegen.c.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.damos.codegen.c.CodegenCPlugin;
import org.eclipse.damos.codegen.c.ComponentGeneratorStatus;
import org.eclipse.damos.codegen.c.IComponentGenerator;
import org.eclipse.damos.codegen.c.IGeneratorContext;
import org.eclipse.damos.codegen.c.ITargetGenerator;
import org.eclipse.damos.codegen.c.internal.registry.ComponentGeneratorProviderRegistry;
import org.eclipse.damos.codegen.c.internal.registry.TargetGeneratorDescriptor;
import org.eclipse.damos.codegen.c.internal.registry.TargetGeneratorRegistry;
import org.eclipse.damos.dconfig.util.PropertyPath;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.execution.CompoundNode;
import org.eclipse.damos.execution.Graph;
import org.eclipse.damos.execution.Node;
import org.eclipse.damos.execution.TaskGraph;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Andreas Unger
 *
 */
@Singleton
public class ComponentGeneratorAdaptor {

	@Inject
	private ComponentGeneratorProviderRegistry componentGeneratorProviderRegistry;
	
	private static final PropertyPath TARGET_PROPERTY_PATH = PropertyPath.create("damos.codegen.target");
	
	public void adaptGenerators(IGeneratorContext context, IProgressMonitor monitor) throws CoreException {
		List<Component> missingGeneratorComponents = new ArrayList<Component>();
		
		for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
			adaptGenerators(context, taskGraph, missingGeneratorComponents);
		}
		adaptGenerators(context, context.getExecutionFlow().getGraph(), missingGeneratorComponents);
		
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
	private void adaptGenerators(IGeneratorContext context, Graph graph, List<Component> missingGeneratorComponents) {
		for (Node node : graph.getNodes()) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				Component component = componentNode.getComponent();
				IComponentGenerator generator = null;
				if (component.isBoundary()) {
					ITargetGenerator targetGenerator = getTargetGenerator(context);
					if (targetGenerator != null) {
						generator = targetGenerator.createBoundaryComponentGenerator(context, componentNode);
					}
				} else {
					generator = componentGeneratorProviderRegistry.createGenerator(componentNode);
				}
				if (generator != null) {
					node.eAdapters().add(new ComponentGeneratorAdapter(generator));
				} else {
					missingGeneratorComponents.add(component);
				}
			} else if (node instanceof CompoundNode) {
				adaptGenerators(context, (CompoundNode) node, missingGeneratorComponents);
			}
		}
	}
	
	private ITargetGenerator getTargetGenerator(IGeneratorContext context) {
		String targetId = context.getConfiguration().getPropertySelectionName(TARGET_PROPERTY_PATH);
		if (targetId != null) {
			TargetGeneratorDescriptor targetGeneratorDescriptor = TargetGeneratorRegistry.getInstance().getGenerator(targetId);
			if (targetGeneratorDescriptor != null) {
				return targetGeneratorDescriptor.createGenerator();
			}
		}
		return null;
	}
	
}
