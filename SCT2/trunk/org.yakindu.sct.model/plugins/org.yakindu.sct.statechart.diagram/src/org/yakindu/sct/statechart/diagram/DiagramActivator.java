/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.statechart.diagram;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipselabs.xtfo.demo.rcp.partialEditing.EmbeddedXtextEditorModule;
import org.osgi.framework.BundleContext;
import org.yakindu.sct.statechart.ExpressionsRuntimeModule;
import org.yakindu.sct.statechart.ui.ExpressionsUiModule;
import org.yakindu.sct.statechart.ui.internal.ExpressionsActivator;
import org.yakindu.sct.statechart.xtextintegration.editors.XTextCellEditor;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public class DiagramActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.yakindu.sct.statechart.diagram";

	public static final PreferencesHint DIAGRAM_PREFERENCES_HINT = new PreferencesHint(
			PLUGIN_ID);

	// The shared instance
	private static DiagramActivator plugin;

	/**
	 * The constructor
	 */
	public DiagramActivator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static DiagramActivator getDefault() {
		return plugin;
	}
	
	public Injector getDslInjectorForEmbedded() {
		//FIXME
		Injector injector =  Guice.createInjector(Modules.override(
				Modules.override(
						Modules.override(new ExpressionsRuntimeModule()).with(
								new ExpressionsUiModule(DiagramActivator.getDefault()
										))).with(
						new SharedStateModule())).with(new EmbeddedXtextEditorModule()));
		XTextCellEditor.injector = injector;
		return injector;
	}
}
