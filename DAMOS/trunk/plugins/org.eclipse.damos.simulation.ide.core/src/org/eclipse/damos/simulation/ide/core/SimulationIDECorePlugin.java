/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.simulation.ide.core;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.damos.mscript.MscriptRuntimeModule;
import org.eclipse.damos.mscript.parser.antlr.MscriptParser;
import org.eclipse.xtext.linking.ILinker;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class SimulationIDECorePlugin extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.damos.simulation.ide.core";

	// The shared instance
	private static SimulationIDECorePlugin plugin;
	
	private MscriptParser mscriptParser;
	
	private ILinker linker;

	/**
	 * The constructor
	 */
	public SimulationIDECorePlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		Injector injector = Guice.createInjector(new MscriptRuntimeModule());
		mscriptParser = injector.getInstance(MscriptParser.class);
		linker = injector.getInstance(ILinker.class);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		mscriptParser = null;
		linker = null;
		plugin = null;
		super.stop(context);
	}
	
	/**
	 * @return the mscriptParser
	 */
	public MscriptParser getMscriptParser() {
		return mscriptParser;
	}
	
	/**
	 * @return the linker
	 */
	public ILinker getLinker() {
		return linker;
	}
	
	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static SimulationIDECorePlugin getDefault() {
		return plugin;
	}

}
