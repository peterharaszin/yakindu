/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.dscript;

import org.eclipse.xtext.Constants;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * @author Andreas Unger
 *
 */
public class BlockDiagramRuntimeModule extends DscriptRuntimeModule {

	public void configureFileExtensions(Binder binder) {
		binder.bind(String.class).annotatedWith(Names.named(Constants.FILE_EXTENSIONS)).toInstance("blockdiagram");
	}

}
