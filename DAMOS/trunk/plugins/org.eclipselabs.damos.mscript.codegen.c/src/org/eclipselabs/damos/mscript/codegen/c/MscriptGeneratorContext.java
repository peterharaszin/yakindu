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
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult;

/**
 * @author Andreas Unger
 *
 */
public class MscriptGeneratorContext implements IMscriptGeneratorContext {

	private IMscriptGeneratorConfiguration configuration;
	private IStaticEvaluationResult staticEvaluationResult;
	private IVariableAccessStrategy variableAccessStrategy;
	private ICodeFragmentCollector codeFragmentCollector;
	
	/**
	 * 
	 */
	public MscriptGeneratorContext(IMscriptGeneratorConfiguration configuration, IStaticEvaluationResult staticEvaluationResult, ICodeFragmentCollector codeFragmentCollector) {
		this(configuration, staticEvaluationResult, new DefaultVariableAccessStrategy(staticEvaluationResult), codeFragmentCollector);
	}
	
	/**
	 * 
	 */
	public MscriptGeneratorContext(IMscriptGeneratorConfiguration configuration, IStaticEvaluationResult staticEvaluationResult, IVariableAccessStrategy variableAccessStrategy, ICodeFragmentCollector codeFragmentCollector) {
		this.configuration = configuration;
		this.staticEvaluationResult = staticEvaluationResult;
		this.variableAccessStrategy = variableAccessStrategy;
		this.codeFragmentCollector = codeFragmentCollector;
	}

	public IMscriptGeneratorConfiguration getConfiguration() {
		return configuration;
	}

	/**
	 * @return the staticEvaluationResult
	 */
	public IStaticEvaluationResult getStaticEvaluationResult() {
		return staticEvaluationResult;
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

}
