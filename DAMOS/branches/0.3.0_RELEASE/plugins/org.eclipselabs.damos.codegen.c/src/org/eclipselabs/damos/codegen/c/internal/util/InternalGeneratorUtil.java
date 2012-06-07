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

package org.eclipselabs.damos.codegen.c.internal.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.codegen.c.IComponentGenerator;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.codegen.c.internal.ComponentGeneratorAdapter;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dconfig.util.PropertyPath;
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.Inport;
import org.eclipselabs.damos.dml.Outport;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.dml.util.SystemPath;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.Node;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.StringLiteral;

/**
 * @author Andreas Unger
 *
 */
public class InternalGeneratorUtil {
	
	private static final PropertyPath PREFIX_PROPERTY_PATH = PropertyPath.create("damos.codegen.c.prefix");

	public static IComponentGenerator getComponentGenerator(ComponentNode node) {
		ComponentGeneratorAdapter adapter = (ComponentGeneratorAdapter) EcoreUtil.getAdapter(node.eAdapters(), ComponentGeneratorAdapter.class);
		return adapter != null ? adapter.getGenerator() : null;
	}
	
	public static String getPrefix(Configuration configuration) {
		Expression prefixValue = configuration.getPropertyValue(SystemPath.create(configuration.getContextFragment()), PREFIX_PROPERTY_PATH);
		if (prefixValue instanceof StringLiteral) {
			return ((StringLiteral) prefixValue).getValue();
		}
		return "";
	}

	public static String getPrefix(Configuration configuration, Node node) {
		Expression prefixValue = configuration.getPropertyValue(node.getSystemPath(), PREFIX_PROPERTY_PATH);
		if (prefixValue instanceof StringLiteral) {
			return ((StringLiteral) prefixValue).getValue();
		}
		return "";
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

	public static List<ComponentNode> getInportNodes(IGeneratorContext context) {
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

	public static List<ComponentNode> getOutportNodes(IGeneratorContext context) {
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
