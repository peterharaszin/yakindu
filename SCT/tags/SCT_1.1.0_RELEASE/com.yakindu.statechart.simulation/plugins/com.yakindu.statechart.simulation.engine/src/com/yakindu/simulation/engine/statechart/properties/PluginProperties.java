/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.simulation.engine.statechart.properties;

import org.eclipse.osgi.util.NLS;

/**
 * The class <code>PluginProperties</code> allows the access to the
 * plugin*.properties files.
 * 
 * @author Philipp Richter
 */
public class PluginProperties {

	/** Defines the bundle name of the plug-in properties file. */
	private static final String BUNDLE_NAME =
			"com.yakindu.simulation.engine.statechart.properties.plugin";

	/** */
	public static String plugin_id;
	/** */
	public static String category_parent_name;
	/** */
	public static String category_parent_id;
	/** */
	public static String category_name;
	/** */
	public static String category_id;
	/** */
	public static String bundle_name;
	/** */
	public static String project_name;
	/** */
	public static String simulationcontrols_name;

	static {
		NLS.initializeMessages(BUNDLE_NAME, PluginProperties.class);
	}

	/**
	 * 
	 */
	private PluginProperties() {

		// Only helper class. Prevent from initialization
	}
}
