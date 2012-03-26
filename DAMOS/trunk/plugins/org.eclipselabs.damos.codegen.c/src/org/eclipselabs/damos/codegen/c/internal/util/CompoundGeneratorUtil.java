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

package org.eclipselabs.damos.codegen.c.internal.util;

import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.execution.ComponentNode;

/**
 * @author Andreas Unger
 *
 */
public class CompoundGeneratorUtil {

	public static String getChoiceVariableName(Configuration configuration, ComponentNode componentNode) {
		return String.format("%s%s_result", InternalGeneratorUtil.getPrefix(configuration, componentNode), componentNode.getComponent().getName());
	}

	public static String getMemoryPreviousValueVariableName(Configuration configuration, ComponentNode componentNode) {
		return String.format("%s%s_previousValue", InternalGeneratorUtil.getPrefix(configuration, componentNode), componentNode.getComponent().getName());
	}

}
