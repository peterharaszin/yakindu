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

package org.eclipselabs.damos.codegen.c.generator.internal.util;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenModel;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenSubsystem;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenSystem;
import org.eclipselabs.damos.codegen.c.generator.IComponentGenerator;
import org.eclipselabs.damos.codegen.c.generator.internal.ComponentGeneratorAdapter;
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.execution.executionflow.TaskInputNode;
import org.eclipselabs.damos.execution.executionflow.TaskGraph;

/**
 * @author Andreas Unger
 *
 */
public class InternalGeneratorUtil {

	public static IComponentGenerator getComponentGenerator(ComponentNode node) {
		ComponentGeneratorAdapter adapter = (ComponentGeneratorAdapter) EcoreUtil.getAdapter(node.eAdapters(), ComponentGeneratorAdapter.class);
		return adapter != null ? adapter.getGenerator() : null;
	}
	
	public static String getPrefix(GenModel genModel, Node node) {
		String prefix = "";

		GenSystem genSystem = null;

		if (node.getEnclosingSubsystems().isEmpty()) {
			genSystem = genModel.getGenTopLevelSystem();
		} else {
			for (TreeIterator<EObject> it = genModel.getGenTopLevelSystem().eAllContents(); it.hasNext();) {
				EObject next = it.next();
				if (next instanceof GenSubsystem) {
					GenSubsystem genSubsystem = (GenSubsystem) next;
					if (genSubsystem.getSubsystem() == node.getEnclosingSubsystems().get(0)) {
						genSystem = genSubsystem;
						break;
					}
				}
			}
		}
		
		if (genSystem != null) {
			if (genSystem.getPrefix() != null) {
				prefix = genSystem.getPrefix();
			}
		}
		
		return prefix;
	}
	
	public static String getTaskName(GenModel genModel, TaskGraph taskGraph) {
		return InternalGeneratorUtil.getPrefix(genModel, taskGraph.getInitialNodes().get(0)) + ((ComponentNode) taskGraph.getInitialNodes().get(0)).getComponent().getName() + "_Task";
	}
	
	public static String getTaskInputVariableName(GenModel genModel, TaskInputNode inputNode) {
		TaskGraph taskGraph = inputNode.getTaskGraph();
		String taskInputVariableName = getTaskName(genModel, taskGraph) + "_input";
		if (taskGraph.getInputNodes().size() > 1) {
			taskInputVariableName += taskGraph.getInputNodes().indexOf(inputNode);
		}
		return taskInputVariableName;
	}

	public static String uncapitalize(String s) {
		if (s == null) {
			return "";
		}
		if (s.length() == 0) {
			return s;
		}
		return s.substring(0, 1).toLowerCase() + s.substring(1);
	}

	public static String capitalize(String s) {
		if (s == null) {
			return "";
		}
		if (s.length() == 0) {
			return s;
		}
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}
	
	public static String getOutputPortName(OutputPort outputPort) {
		StringBuilder sb = new StringBuilder();
		Output output = outputPort.getOutput();
		if (output instanceof BlockOutput) {
			BlockOutput blockOutput = (BlockOutput) output;
			sb.append(blockOutput.getDefinition().getName());
		} else {
			sb.append("output");
			if (output.getComponent().getOutputs().size() > 1) {
				sb.append(DMLUtil.indexOf(output));
				sb.append("_");
			}
		}
		if (output.getPorts().size() > 1) {
			sb.append(outputPort.getIndex());
		}
		return sb.toString();
	}

}
