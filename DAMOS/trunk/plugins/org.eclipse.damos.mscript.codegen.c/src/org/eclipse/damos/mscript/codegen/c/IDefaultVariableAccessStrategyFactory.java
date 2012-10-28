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

import org.eclipse.damos.mscript.codegen.c.IDefaultVariableAccessStrategyFactory.Default;
import org.eclipse.damos.mscript.codegen.c.internal.DefaultVariableAccessStrategy;
import org.eclipse.damos.mscript.interpreter.StaticFunctionInfo;
import org.eclipse.damos.mscript.util.ISampleInterval;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Andreas Unger
 *
 */
@ImplementedBy(Default.class)
public interface IDefaultVariableAccessStrategyFactory {

	IVariableAccessStrategy create(IMscriptGeneratorConfiguration configuration, StaticFunctionInfo functionInfo, ISampleInterval sampleInterval);
	
	class Default implements IDefaultVariableAccessStrategyFactory {

		@Inject
		private Injector injector;
		
		@Override
		public IVariableAccessStrategy create(IMscriptGeneratorConfiguration configuration, StaticFunctionInfo functionInfo, ISampleInterval sampleInterval) {
			IVariableAccessStrategy variableAccessStrategy = new DefaultVariableAccessStrategy(configuration, functionInfo, sampleInterval);
			injector.injectMembers(variableAccessStrategy);
			return variableAccessStrategy;
		}
		
	}

}
