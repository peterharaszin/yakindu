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

import org.eclipse.damos.mscript.codegen.c.internal.DefaultVariableAccessStrategy;
import org.eclipse.damos.mscript.interpreter.StaticFunctionInfo;

/**
 * @author Andreas Unger
 *
 */
public class MscriptGeneratorContext implements IMscriptGeneratorContext {

	private final IMscriptGeneratorConfiguration configuration;
	private final StaticFunctionInfo functionInfo;
	private final double sampleTime;
	private final IVariableAccessStrategy variableAccessStrategy;
	private final ICodeFragmentCollector codeFragmentCollector;
	
	/**
	 * 
	 */
	public MscriptGeneratorContext(IMscriptGeneratorConfiguration configuration, StaticFunctionInfo functionInfo, double sampleTime, ICodeFragmentCollector codeFragmentCollector) {
		this(configuration, functionInfo, sampleTime, null, codeFragmentCollector);
	}
	
	/**
	 * 
	 */
	public MscriptGeneratorContext(IMscriptGeneratorConfiguration configuration, StaticFunctionInfo functionInfo, double sampleTime, IVariableAccessStrategy variableAccessStrategy, ICodeFragmentCollector codeFragmentCollector) {
		this.configuration = configuration;
		this.functionInfo = functionInfo;
		this.sampleTime = sampleTime;
		this.variableAccessStrategy = variableAccessStrategy != null ? variableAccessStrategy : new DefaultVariableAccessStrategy(this);
		this.codeFragmentCollector = codeFragmentCollector;
	}

	public IMscriptGeneratorConfiguration getConfiguration() {
		return configuration;
	}

	public StaticFunctionInfo getFunctionInfo() {
		return functionInfo;
	}
	
	public double getSampleTime() {
		return sampleTime;
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
