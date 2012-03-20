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
import org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationUtil;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.dml.Action;
import org.eclipselabs.damos.dml.ActionLink;
import org.eclipselabs.damos.dml.Choice;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.InputConnector;
import org.eclipselabs.damos.dml.Memory;
import org.eclipselabs.damos.dml.WhileLoop;
import org.eclipselabs.damos.execution.ActionNode;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.CompoundNode;
import org.eclipselabs.damos.execution.Graph;
import org.eclipselabs.damos.execution.Node;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class DefaultCompoundGenerator implements ICompoundGenerator {

	private final IGraphGenerator graphGenerator;
	
	/**
	 * 
	 */
	@Inject
	DefaultCompoundGenerator(IGraphGenerator graphGenerator) {
		this.graphGenerator = graphGenerator;
	}

	public void writeChoiceVariableDeclarations(IGeneratorContext context, Appendable appendable, Graph graph, IProgressMonitor monitor) {
		PrintAppendable out = new PrintAppendable(appendable);
		boolean hasChoices = false;
		for (Node node : graph.getAllNodes()) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				Component component = componentNode.getComponent();
				
				if (component instanceof Choice) {
					out.printf("uint_fast8_t %s;\n", InternalGeneratorUtil.getChoiceVariableName(context.getConfiguration(), componentNode));
					hasChoices = true;
				}
			}
		}
		
		if (hasChoices) {
			out.println();
		}
	}

	public void writeCompoundCode(IGeneratorContext context, Appendable appendable, CompoundNode compoundNode, IProgressMonitor monitor) throws IOException {
		if (compoundNode instanceof ActionNode) {
			PrintAppendable out = new PrintAppendable(appendable);
			
			ActionNode actionNode = (ActionNode) compoundNode;
			Action action = (Action) actionNode.getCompound();
			
			if (actionNode.getChoiceNode() != null) {
				Choice choice = (Choice) actionNode.getChoiceNode().getComponent();
				int index = getActionIndex(choice, action);
				out.printf("if (%s%s_result == %d) ", InternalGeneratorUtil.getPrefix(context.getConfiguration(), compoundNode), choice.getName(), index);
			}
			
			out.print("{\n");
			
			for (Node node : compoundNode.getNodes()) {
				if (node instanceof ComponentNode) {
					ComponentNode componentNode = (ComponentNode) node;
					if (componentNode.getComponent() instanceof Memory) {
						Memory memory = (Memory) componentNode.getComponent();
						IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
						String cDataType = MscriptGeneratorUtil.getCDataType(GeneratorConfigurationUtil.getComputationModel(context.getConfiguration(), componentNode), generator.getContext().getComponentSignature().getOutputDataType(memory.getFirstOutputPort()));
						
						String initializer = InternalGeneratorUtil.getIncomingVariableName(context.getConfiguration(), componentNode, memory.getFirstInputPort());
						
						out.printf("%s %s = %s;\n", cDataType, InternalGeneratorUtil.getMemoryPreviousValueVariableName(context.getConfiguration(), componentNode), initializer);
					}
				}
			}

			if (action instanceof WhileLoop) {
				out.print("do {\n");
			}
			
			graphGenerator.writeGraph(context, appendable, compoundNode, monitor);
			
			if (action instanceof WhileLoop) {
				WhileLoop whileLoop = (WhileLoop) action;

				InputConnector inputConnector = whileLoop.getCondition();
				String condition = InternalGeneratorUtil.getIncomingVariableName(context.getConfiguration(), actionNode, inputConnector);
				if (condition == null) {
					condition = "0";
				}
				
				out.printf("} while (%s);\n", condition);
			}

			out.print("}\n");
		}
	}

	private int getActionIndex(Choice choice, Action action) {
		int index = 0;
		for (ActionLink actionLink : choice.getActionLinks()) {
			if (actionLink.getAction() == action) {
				break;
			}
			++index;
		}
		return index;
	}

}
