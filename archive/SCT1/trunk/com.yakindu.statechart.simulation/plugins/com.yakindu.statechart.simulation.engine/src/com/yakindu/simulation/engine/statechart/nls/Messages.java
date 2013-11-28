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
package com.yakindu.simulation.engine.statechart.nls;

import org.eclipse.osgi.util.NLS;

/**
 * <code>Messages</code> provides all needed messages of this plug-in. All
 * messages are returned in the national language, if available.
 * 
 * @author Philipp Richter
 */
public class Messages extends NLS {

	/** Defines the bundle name of the messages file. */
	private static final String BUNDLE_NAME =
			"com.yakindu.simulation.engine.statechart.nls.messages";

	/** */
	public static String General_argumentisnull;
	/** */
	public static String General_unknown;
	/** */
	public static String General_state;
	/** */
	public static String General_pseudostate;
	/** */
	public static String StatechartSimulator_enginedisposed;
	/** */
	public static String StatechartSimulator_startfail;
	/** */
	public static String SimulationControls_controlcaption;
	/** */
	public static String SimulationControls_simstatecaption;
	/** */
	public static String SimulationControls_simrunning;
	/** */
	public static String SimulationControls_simpaused;
	/** */
	public static String SimulationControls_simstopped;
	/** */
	public static String SimulationControls_btnstarttooltip;
	/** */
	public static String SimulationControls_btnstoptooltip;
	/** */
	public static String SimulationControls_btnpausetooltip;
	/** */
	public static String SimulationControls_btnsingletooltip;
	/** */
	public static String SimulationControls_messagenull;
	/** */
	public static String SimulationControls_dialogtitle;
	/** */
	public static String StatechartSupportVerifier_verifiererror;
	/** */
	public static String StatechartSupportVerifier_statechartnotinit;
	/** */
	public static String StatechartSupportVerifier_unknownelement;
	/** */
	public static String StatechartSupportVerifier_unknownpseudostate;
	/** */
	public static String StatechartSupportVerifier_unknowntrigger;
	/** */
	public static String StatechartSupportVerifier_unknowndatatype;
	/** */
	public static String StatechartSupportVerifier_tomuchregions;
	/** */
	public static String StatechartSupportVerifier_sourceisnull;
	/** */
	public static String StatechartSupportVerifier_targetisnull;
	/** */
	public static String StatechartSupportVerifier_initialastarget;
	/** */
	public static String StatechartSupportVerifier_sourcetargetnotsameregion;
	/** */
	public static String StatechartSupportVerifier_statecharthasnoregion;
	/** */
	public static String SCSimulator_supporterrors;
	/** */
	public static String SCSimulator_nouuid;
	/** */
	public static String SCSimulator_noname;
	/** */
	public static String SCSimulator_noinitialstate;
	/** */
	public static String SCSimulator_initialstatewrongconnected;
	/** */
	public static String SCSimulator_initialstatenotconnected;
	/** */
	public static String SCSimulator_initialstatetranshasexpression;
	/** */
	public static String SCSimulator_infiniteloop;
	/** */
	public static String SCSimulator_nosubstate;
	/** */
	public static String SCSimulator_itemnamenull;
	/** */
	public static String SCSimulator_itemvaluenull;
	/** */
	public static String SCSimulator_eventnamenull;
	/** */
	public static String SCSimulator_eventvaluenull;
	/** */
	public static String SCSimulator_statemachinenotinitialized;
	/** */
	public static String SCSimulator_changestatenotinitialized;
	/** */
	public static String SCSimulator_unabletoparse;
	/** */
	public static String SCSimulator_triggernotdefined;
	/** */
	public static String SCSimulator_emptyelementfound;
	/** */
	public static String SCSimulator_notvalidelementname;
	/** */
	public static String SCSimulator_functionaselementname;
	/** */
	public static String SCSimulator_unknownerror;
	/** */
	public static String SCSimulator_disposed;
	/** */
	public static String SCSimulatorController_disposed;
	/** */
	public static String SCSimulatorController_timeevent;
	/** */
	public static String SCSimulatorController_intervalproblem;
	/** */
	public static String SCEngine_parametersnotset;
	/** */
	public static String SCEngine_nostatechart;
	/** */
	public static String SCEngine_statechartfilenotexist;
	/** */
	public static String TransitionExt_basictransisnull;
	/** */
	public static String TransitionExt_nosourcestate;
	/** */
	public static String TransitionExt_notargetstate;
	/** */
	public static String TransitionExt_invalidexpression;
	/** */
	public static String TransitionExt_invalidexpressionsquarebracket;
	/** */
	public static String TransitionExt_invalidafterevent;
	/** */
	public static String TransitionExt_onlyonetimetrigger;
	/** */
	public static String TransitionExt_twotriggershavesamename;
	/** */
	public static String TransitionExt_timetriggerasname;
	/** */
	public static String PseudostateNotImplemented_errormessage;
	/** */
	public static String MathFunctionCalculator_log;
	/** */
	public static String MathFunctionCalculator_log10;
	/** */
	public static String MathFunctionCalculator_sqrt;
	/** */
	public static String MathFunctionCalculator_arcsin;
	/** */
	public static String MathFunctionCalculator_arccos;
	/** */
	public static String MathFunctionCalculator_notsupported;
	/** */
	public static String MathFunctionCalculator_invalidvalue;
	/** */
	public static String MathFunctionCalculator_invalidfunction;
	/** */
	public static String Parser_expressionnotvalid;
	/** */
	public static String Parser_actionnotvalid;
	/** */
	public static String Parser_actionnotwellformed;
	/** */
	public static String Parser_variablenotfound;
	/** */
	public static String Parser_exporfunccouldnotsolve;
	/** */
	public static String Parser_expressioncouldnotsolve;
	/** */
	public static String Parser_functioncouldnotsolve;
	/** */
	public static String Parser_functionpartwrong;
	/** */
	public static String Parser_actioncouldnotsolve;
	/** */
	public static String Parser_source;
	/** */
	public static String Parser_unknownvariable;
	/** */
	public static String Parser_unknownevent;
	/** */
	public static String Parser_unknownerror;
	/** */
	public static String Parser_wrongnumberparenthesis;
	/** */
	public static String Parser_valuecouldnotconverted;
	/** */
	public static String Parser_wrongoperator;
	/** */
	public static String Parser_wrongexpressionpart;
	/** */
	public static String Parser_novariablesdefined;
	/** */
	public static String Parser_variablevalueisnull;
	/** */
	public static String Parser_powercannotsolve;
	/** */
	public static String TimeEventScheduler_wrongduration;
	/** */
	public static String SimulationParameterTab_timescaling;
	/** */
	public static String SimulationParameterTab_timescalingtooltip;
	/** */
	public static String SimulationParameterTab_timescalingerror;
	/** */
	public static String SimulationParameterTab_timescalinginfinityerror;
	/** */
	public static String SimulationParameterTab_schedulerinterval;
	/** */
	public static String SimulationParameterTab_schedulerintervaltooltip;
	/** */
	public static String SimulationParameterTab_schedulerintervalerror;
	/** */
	public static String SimulationParameterTab_schedulerintervalinfinityerror;
	
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}
