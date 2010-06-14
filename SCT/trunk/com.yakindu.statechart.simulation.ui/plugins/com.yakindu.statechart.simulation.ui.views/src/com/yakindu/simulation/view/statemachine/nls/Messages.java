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
package com.yakindu.simulation.view.statemachine.nls;

import org.eclipse.osgi.util.NLS;

/**
 * <code>Messages</code> provides all needed messages of this plug-in. All
 * messages returns in the national language, if available.
 * 
 * @author Philipp Richter
 */
public class Messages extends NLS {

	/** */
	private static final String BUNDLE_NAME =
			"com.yakindu.simulation.view.statemachine.nls.messages";

	/** */
	public static String TableView_defaultcategory;
	/** */
	public static String TableView_defaultitem;
	/** */
	public static String TableView_defaultvalue;
	/** */
	public static String TableView_valuechangeerror;
	/** */
	public static String TableView_eventchangeerror;
	/** */
	public static String TableView_valueiswrong;
	/** */
	public static String TableView_valueiswrongdescription;
	/** */
	public static String TableView_fireevent;
	/** */
	public static String TableView_changeerror;
	/** */
	public static String TableView_deactivateevent;
	/** */
	public static String StatemachineView_category;
	/** */
	public static String StatemachineView_item;
	/** */
	public static String StatemachineView_value;
	/** */
	public static String StatemachineView_tooltip;
	/** */
	public static String StatemachineView_input;
	/** */
	public static String StatemachineView_event;
	/** */
	public static String StatemachineView_dynamic;
	/** */
	public static String StatemachineView_local;
	/** */
	public static String StatemachineView_output;
	/** */
	public static String StatemachineView_noentry;
	/** */
	public static String StatemachineView_itemnotfound;
	/** */
	public static String ViewController_engineisunknown;
	/** */
	public static String ViewController_statechartisunknown;
	/** */
	public static String ViewController_instance;
	/** */
	public static String ContextProvider_viewhelp;
	/** */
	public static String ShowNewEngineAction_text;
	/** */
	public static String ShowNewEngineAction_tooltip;
	/** */
	public static String ShowNewEngineAction_description;
	
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}
