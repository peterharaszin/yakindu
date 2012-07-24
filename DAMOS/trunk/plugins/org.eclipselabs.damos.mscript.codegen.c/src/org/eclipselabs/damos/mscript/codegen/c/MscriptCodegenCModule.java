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

package org.eclipselabs.damos.mscript.codegen.c;

import com.google.inject.AbstractModule;

/**
 * @author Andreas Unger
 *
 */
public class MscriptCodegenCModule extends AbstractModule {

	@Override
	protected void configure() {
		bindICModuleGenerator();
		bindICompoundStatementGenerator();
		bindIExpressionGenerator();
		bindIOperationGeneratorProvider();
	}

	protected void bindICModuleGenerator() {
		bind(ICModuleGenerator.class).annotatedWith(CHeader.class).to(CHeaderGenerator.class);
		bind(ICModuleGenerator.class).annotatedWith(CSource.class).to(CSourceGenerator.class);
	}

	protected void bindICompoundStatementGenerator() {
		bind(IStatementGenerator.class).to(StatementGenerator.class);
	}

	protected void bindIExpressionGenerator() {
		bind(IExpressionGenerator.class).to(ExpressionGenerator.class);
	}

	protected void bindIOperationGeneratorProvider() {
		bind(IOperationGeneratorProvider.class).to(OperationGeneratorProvider.class);
	}

}
