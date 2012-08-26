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

package org.eclipselabs.damos.codegen.c.internal.componentgenerators;

import org.eclipselabs.damos.codegen.c.IComponentGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorConfiguration;
import org.eclipselabs.damos.mscript.function.FunctionInstance;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult;

/**
 * @author Andreas Unger
 *
 */
public interface IBehavioredBlockGeneratorContext {

	IComponentGeneratorContext getContext();

	IStaticEvaluationResult getStaticEvaluationResult();
	
	IMscriptGeneratorConfiguration getMscriptGeneratorConfiguration();
	
	FunctionInstance getFunctionInstance();
	
}
