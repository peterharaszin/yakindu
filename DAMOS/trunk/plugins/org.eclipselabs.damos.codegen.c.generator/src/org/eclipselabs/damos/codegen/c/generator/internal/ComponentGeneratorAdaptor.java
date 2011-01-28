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

package org.eclipselabs.damos.codegen.c.generator.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipselabs.damos.codegen.c.cgenmodel.CGenModel;
import org.eclipselabs.damos.codegen.c.generator.CodegenCGeneratorPlugin;
import org.eclipselabs.damos.codegen.c.generator.GeneratorContext;
import org.eclipselabs.damos.codegen.c.generator.IComponentGenerator;
import org.eclipselabs.damos.codegen.c.generator.IGeneratorContext;
import org.eclipselabs.damos.codegen.c.generator.ComponentGeneratorStatus;
import org.eclipselabs.damos.codegen.c.generator.internal.registry.ComponentGeneratorProviderRegistry;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.execution.engine.ComponentSignatureResolver;
import org.eclipselabs.damos.execution.engine.ComponentSignatureResolverResult;
import org.eclipselabs.damos.execution.executiongraph.ExecutionGraph;
import org.eclipselabs.damos.execution.executiongraph.Node;

/**
 * @author Andreas Unger
 *
 */
public class ComponentGeneratorAdaptor {

	private ComponentSignatureResolver signatureResolver = new ComponentSignatureResolver();
	
	public void adaptGenerators(CGenModel genModel, ExecutionGraph executionGraph, IProgressMonitor monitor) throws CoreException {
		ComponentSignatureResolverResult signatureResolverResult = signatureResolver.resolve(executionGraph.getTopLevelFragment(), true);
		if (!signatureResolverResult.getStatus().isOK()) {
			throw new CoreException(signatureResolverResult.getStatus());
		}
		
		IGeneratorContext context = new GeneratorContext(genModel);
		
		List<Component> missingGeneratorComponents = new ArrayList<Component>();
		
		for (Node node : executionGraph.getNodes()) {
			Component component = node.getComponent();
			IComponentGenerator generator;
			generator = ComponentGeneratorProviderRegistry.getInstance().createGenerator(component);
			if (generator != null) {
				generator.setContext(context);
				generator.setComponent(component);
				generator.setSignature(signatureResolverResult.getSignatures().get(component));
				node.eAdapters().add(new ComponentGeneratorAdapter(generator));
			} else {
				missingGeneratorComponents.add(component);
			}
		}
		
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
					IStatus.ERROR, CodegenCGeneratorPlugin.PLUGIN_ID, 0, sb.toString(), null, missingGeneratorComponents));
		}
	}

}
