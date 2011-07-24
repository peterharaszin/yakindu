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

package org.eclipselabs.damos.ide.ui;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * @author Andreas Unger
 *
 */
public class IDEUIModule extends AbstractModule {

	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		configureBlockLibraryViewId();
		configureFragmentExplorerViewId();
		configureBlockDiagramFileExtension();
	}
	
	protected void configureBlockLibraryViewId() {
		bind(String.class).annotatedWith(Names.named("blockLibraryViewId")).toInstance("org.eclipselabs.damos.ide.ui.blockLibraryView");
	}

	protected void configureFragmentExplorerViewId() {
		bind(String.class).annotatedWith(Names.named("fragmentExplorerViewId")).toInstance("org.eclipselabs.damos.ide.ui.fragmentExplorerView");
	}
	
	protected void configureBlockDiagramFileExtension() {
		bind(String.class).annotatedWith(Names.named("blockDiagramFileExtension")).toInstance("blockdiagram");
	}

}
