package org.yakindu.sct.ui.editor.utils;

import org.yakindu.sct.ui.editor.DiagramActivator;

/**
 * Help context ids for the YAKINDU Statechart editor and associated views.
 * <p>
 * This interface contains constants only; it is not intended to be implemented
 * or extended.
 */
public interface IYakinduSctHelpContextIds {

	public static final String PREFIX = DiagramActivator.PLUGIN_ID + '.';

	// Diagram viewer
	public static final String SC_EDITOR_GRAPHICAL_VIEWER = PREFIX + "sc_editor_graphical_viewer"; //$NON-NLS-1$
	
	// Property sheets and EditParts
	public static final String SC_PROPERTIES_ENTRY_ENTRYKIND = PREFIX + "sc_properties_entry_entrykind"; //$NON-NLS-1$
	public static final String SC_PROPERTIES_STATE_EXPRESSION = PREFIX + "sc_properties_state_expression"; //$NON-NLS-1$
	public static final String SC_PROPERTIES_STATECHART_EXPRESSION = PREFIX + "sc_properties_statechart_expression"; //$NON-NLS-1$
	public static final String SC_PROPERTIES_TRANSITION_EXPRESSION = PREFIX + "sc_properties_transition_expression"; //$NON-NLS-1$
}
