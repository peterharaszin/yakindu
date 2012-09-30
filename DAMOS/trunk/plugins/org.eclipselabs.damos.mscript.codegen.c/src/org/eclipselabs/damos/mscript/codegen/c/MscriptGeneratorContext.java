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

package org.eclipselabs.damos.mscript.codegen.c;

import org.eclipselabs.damos.mscript.codegen.c.internal.DefaultVariableAccessStrategy;
import org.eclipselabs.damos.mscript.interpreter.StaticFunctionInfo;

/**
 * @author Andreas Unger
 *
 */
public class MscriptGeneratorContext implements IMscriptGeneratorContext {

	private final IMscriptGeneratorConfiguration configuration;
	private final StaticFunctionInfo functionInfo;
	private final IVariableAccessStrategy variableAccessStrategy;
	private final ICodeFragmentCollector codeFragmentCollector;
	
	/**
	 * 
	 */
	public MscriptGeneratorContext(IMscriptGeneratorConfiguration configuration, StaticFunctionInfo functionInfo, ICodeFragmentCollector codeFragmentCollector) {
		this(configuration, functionInfo, new DefaultVariableAccessStrategy(functionInfo), codeFragmentCollector);
	}
	
	/**
	 * 
	 */
	public MscriptGeneratorContext(IMscriptGeneratorConfiguration configuration, StaticFunctionInfo functionInfo, IVariableAccessStrategy variableAccessStrategy, ICodeFragmentCollector codeFragmentCollector) {
		this.configuration = configuration;
		this.functionInfo = functionInfo;
		this.variableAccessStrategy = variableAccessStrategy;
		this.codeFragmentCollector = codeFragmentCollector;
	}

	public IMscriptGeneratorConfiguration getConfiguration() {
		return configuration;
	}

	public StaticFunctionInfo getFunctionInfo() {
		return functionInfo;
	}

	/**
	 * @return the variableAccessStrategy
	 */
	public IVariableAccessStrategy getVariableAccessStrategy() {
		return variableAccessStrategy;
	}
	
	public ICodeFragmentCollector getCodeFragmentCollector() {
		return codeFragmentCollector;
	}
	
	/**
	 * @return the staticFunctionInfo
	 */
	public StaticFunctionInfo getStaticFunctionInfo() {
		return functionInfo;
	}

}
