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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationUtil;
import org.eclipselabs.damos.codegen.c.util.GeneratorUtil;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Inoutport;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.CompoundNode;
import org.eclipselabs.damos.execution.Graph;
import org.eclipselabs.damos.execution.Node;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.codegen.c.Include;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class DefaultGraphGenerator implements IGraphGenerator {

	private final ICompoundGenerator compoundGenerator;
	private final ITaskGenerator taskGenerator;
	
	/**
	 * 
	 */
	@Inject
	DefaultGraphGenerator(ICompoundGenerator compoundGenerator, ITaskGenerator taskGenerator) {
		this.compoundGenerator = compoundGenerator;
		this.taskGenerator = taskGenerator;
	}
	
	public Collection<Include> getImplementationIncludes(IGeneratorContext context, Graph graph) {
		List<Include> allIncludes = new ArrayList<Include>();
		for (Node node : graph.getAllNodes()) {
			if (!(node instanceof ComponentNode)) {
				continue;
			}
			ComponentNode componentNode = (ComponentNode) node;
			Component component = componentNode.getComponent();
			
			if (component instanceof Inoutport) {
				continue;
			}
			
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
			if (generator.contributesComputeOutputsCode()) {
				Collection<Include> includes = generator.getComputeOutputsCodeIncludes();
				if (includes != null) {
					allIncludes.addAll(includes);
				}
			}
			if (generator.contributesUpdateCode()) {
				Collection<Include> includes = generator.getUpdateCodeIncludes();
				if (includes != null) {
					allIncludes.addAll(includes);
				}
			}
		}
		return allIncludes;
	}
	
	public void writeGraph(IGeneratorContext context, Appendable appendable, Graph graph, IProgressMonitor monitor)
			throws IOException {
		PrintAppendable writer = new PrintAppendable(appendable);
		
		compoundGenerator.writeChoiceVariableDeclarations(context, writer, graph, monitor);

		writer.print("/*\n * Compute outputs\n */\n\n");
		for (Node node : graph.getNodes()) {
			if (node instanceof CompoundNode) {
				compoundGenerator.writeCompoundCode(context, writer, (CompoundNode) node, monitor);
				writer.println();
				continue;
			} else if (!(node instanceof ComponentNode)) {
				continue;
			}
			ComponentNode componentNode = (ComponentNode) node;
			
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
			if (generator.contributesComputeOutputsCode()) {
				writer.printf("/* %s */\n", componentNode.getComponent().getName());
				writer.println("{");
				generator.writeComputeOutputsCode(writer, monitor);
				writer.println("}\n");
			}
			taskGenerator.writeLatchUpdate(context, appendable, componentNode, monitor);
			taskGenerator.writeMessageQueueSend(context, appendable, componentNode, monitor);
		}
		
		writer.print("\n/*\n * Update states\n */\n\n");
		for (Node node : graph.getNodes()) {
			if (!(node instanceof ComponentNode)) {
				continue;
			}
			ComponentNode componentNode = (ComponentNode) node;
			
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
			if (generator.contributesUpdateCode()) {
				writer.printf("/* %s */\n", componentNode.getComponent().getName());
				writer.println("{");
				generator.writeUpdateCode(writer, monitor);
				writer.println("}\n");
			}
		}
	}

	public void writeOutputVariableDeclarations(IGeneratorContext context, Appendable appendable, Graph graph, IProgressMonitor monitor) {
		PrintAppendable out = new PrintAppendable(appendable);
		for (Node node : graph.getAllNodes()) {
			if (!(node instanceof ComponentNode)) {
				continue;
			}
			ComponentNode componentNode = (ComponentNode) node;
			Component component = componentNode.getComponent();
			
			if (component instanceof Inoutport) {
				continue;
			}
			
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
			for (Output output : component.getOutputs()) {
				if (output.isTestPoint()) {
					continue;
				}
				for (OutputPort outputPort : output.getPorts()) {
					ComputationModel computationModel = GeneratorConfigurationUtil.getComputationModel(context.getConfiguration(), componentNode);
					DataType outputDataType = generator.getContext().getComponentSignature().getOutputDataType(outputPort);
					String cDataType = MscriptGeneratorUtil.getCDataType(computationModel, context, outputDataType, null);
					out.printf("%s %s;\n", cDataType, GeneratorUtil.getOutputVariableName(context.getConfiguration(), componentNode, outputPort));
				}
			}
		}
	}

}
