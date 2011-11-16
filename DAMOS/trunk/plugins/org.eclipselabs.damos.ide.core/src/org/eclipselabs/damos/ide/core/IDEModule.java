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

package org.eclipselabs.damos.ide.core;

import org.eclipselabs.damos.dml.LanguageId;
import org.eclipselabs.damos.dml.util.IElementInitializer;
import org.eclipselabs.damos.ide.core.internal.util.ElementInitializer;

import com.google.inject.AbstractModule;

/**
 * @author Andreas Unger
 *
 */
public class IDEModule extends AbstractModule {

	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		configureLanguageId();
		configureIElementInitializer();
	}
	
	protected void configureLanguageId() {
		bind(String.class).annotatedWith(LanguageId.class).toInstance("org.eclipselabs.damos");
	}

	protected void configureIElementInitializer() {
		bind(IElementInitializer.class).to(ElementInitializer.class);
	}

}
