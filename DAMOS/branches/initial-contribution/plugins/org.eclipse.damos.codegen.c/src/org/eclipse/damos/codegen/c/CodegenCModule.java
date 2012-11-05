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

package org.eclipse.damos.codegen.c;

import org.eclipse.damos.codegen.IGenerator;
import org.eclipse.damos.mscript.codegen.c.MscriptCodegenCModule;

/**
 * @author Andreas Unger
 *
 */
public class CodegenCModule extends MscriptCodegenCModule {

	@Override
	protected void configure() {
		super.configure();
		bindIGenerator();
		bindIGraphGenerator();
		bindICompoundGenerator();
		bindITaskGenerator();
	}

	protected void bindIGenerator() {
		bind(IGenerator.class).to(Generator.class);
	}

	protected void bindIGraphGenerator() {
		bind(IGraphGenerator.class).to(GraphGenerator.class);
	}

	protected void bindICompoundGenerator() {
		bind(ICompoundGenerator.class).to(CompoundGenerator.class);
	}

	protected void bindITaskGenerator() {
		bind(ITaskGenerator.class).to(TaskGenerator.class);
	}

}
