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

package org.eclipse.damos.mscript.codegen.c;

import org.eclipse.damos.mscript.interpreter.StaticFunctionInfo;

/**
 * @author Andreas Unger
 *
 * @noextend
 * @noimplement
 */
public interface IMscriptGeneratorContext {

	IMscriptGeneratorConfiguration getConfiguration();
	StaticFunctionInfo getFunctionInfo();
	double getSampleTime();
	IVariableAccessStrategy getVariableAccessStrategy();
	ICodeFragmentCollector getCodeFragmentCollector();
	
}
