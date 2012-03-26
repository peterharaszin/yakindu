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

package org.eclipselabs.damos.codegen.c;

import org.eclipselabs.damos.codegen.IGenerator;

import com.google.inject.AbstractModule;

/**
 * @author Andreas Unger
 *
 */
public class CodegenCModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IGenerator.class).to(DefaultGenerator.class);
		bind(IGraphGenerator.class).to(DefaultGraphGenerator.class);
		bind(ICompoundGenerator.class).to(DefaultCompoundGenerator.class);
		bind(ITaskGenerator.class).to(DefaultTaskGenerator.class);
	}

}
