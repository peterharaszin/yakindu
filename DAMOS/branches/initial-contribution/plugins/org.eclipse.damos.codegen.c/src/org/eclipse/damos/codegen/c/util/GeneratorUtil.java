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

package org.eclipse.damos.codegen.c.util;

import org.eclipse.damos.codegen.c.internal.VariableAccessor;
import org.eclipse.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipse.damos.dconfig.Configuration;
import org.eclipse.damos.dml.InputConnector;
import org.eclipse.damos.dml.OutputPort;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.execution.DataFlowSourceEnd;
import org.eclipse.damos.execution.DataFlowTargetEnd;
import org.eclipse.damos.execution.Node;

/**
 * @author Andreas Unger
 *
 */
public class GeneratorUtil {

	public static String getIncomingVariableName(Configuration configuration, Node node, InputConnector inputConnector) {
		DataFlowTargetEnd targetEnd = node.getIncomingDataFlow(inputConnector);
		if (targetEnd != null) {
			DataFlowSourceEnd sourceEnd = targetEnd.getDataFlow().getSourceEnd();
			Node sourceNode = sourceEnd.getNode();
			if (sourceNode instanceof ComponentNode && sourceEnd.getConnector() instanceof OutputPort) {
				OutputPort outputPort = (OutputPort) sourceEnd.getConnector();
				ComponentNode componentNode = (ComponentNode) sourceNode;
				return new VariableAccessor(configuration, componentNode).generateOutputVariableReference(outputPort, false);
			}
		}
		return null;
	}

	public static String getOutputVariableName(Configuration configuration, ComponentNode componentNode, OutputPort outputPort) {
		return String.format("%s%s_%s", GeneratorConfigurationExtensions.getPrefix(configuration, componentNode), componentNode.getComponent().getName(), InternalGeneratorUtil.getOutputPortName(outputPort));
	}

}
