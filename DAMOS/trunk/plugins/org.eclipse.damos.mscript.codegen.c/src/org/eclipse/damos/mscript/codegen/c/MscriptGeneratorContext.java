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

package org.eclipse.damos.mscript.codegen.c;

import org.eclipse.damos.mscript.interpreter.StaticFunctionInfo;
import org.eclipse.damos.mscript.util.ISampleInterval;

/**
 * @author Andreas Unger
 *
 */
public class MscriptGeneratorContext implements IMscriptGeneratorContext {

	private final IMscriptGeneratorConfiguration configuration;
	private final StaticFunctionInfo functionInfo;
	private final ISampleInterval sampleInterval;
	private final IVariableAccessStrategy variableAccessStrategy;
	private final ICodeFragmentCollector codeFragmentCollector;
	
	/**
	 * 
	 */
	public MscriptGeneratorContext(IMscriptGeneratorConfiguration configuration, StaticFunctionInfo functionInfo, ISampleInterval sampleInterval, IVariableAccessStrategy variableAccessStrategy, ICodeFragmentCollector codeFragmentCollector) {
		this.configuration = configuration;
		this.functionInfo = functionInfo;
		this.sampleInterval = sampleInterval;
		this.variableAccessStrategy = variableAccessStrategy;
		this.codeFragmentCollector = codeFragmentCollector;
	}

	public IMscriptGeneratorConfiguration getConfiguration() {
		return configuration;
	}

	public StaticFunctionInfo getFunctionInfo() {
		return functionInfo;
	}
	
	public ISampleInterval getSampleInterval() {
		return sampleInterval;
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
