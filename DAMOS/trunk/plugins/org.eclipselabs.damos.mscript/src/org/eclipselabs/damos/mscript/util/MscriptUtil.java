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

package org.eclipselabs.damos.mscript.util;

import org.eclipselabs.damos.mscript.Definition;
import org.eclipselabs.damos.mscript.FunctionDefinition;
import org.eclipselabs.damos.mscript.Module;

/**
 * @author Andreas Unger
 *
 */
public class MscriptUtil {

	public static FunctionDefinition getFunctionDefinition(Module module, String qualifiedName) {
		for (Definition definition : module.getDefinitions()) {
			if (definition instanceof FunctionDefinition) {
				FunctionDefinition functionDefinition = (FunctionDefinition) definition;
				if (qualifiedName.equals(functionDefinition.getName())) {
					return functionDefinition;
				}
			}
		}
		return null;
	}
		
}
