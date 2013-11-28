/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.mda4e.statemachine.contribution.preferences;


import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gmf.runtime.diagram.ui.figures.DiagramColorConstants;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.mda4e.statemachine.contribution.part.OurStatemachineDiagramEditorPlugin;
import org.mda4e.statemachine.contribution.tools.Constants;

/**
 * This class represents a preference page that is contributed to the
 * Preferences dialog. By subclassing <samp>FieldEditorPreferencePage</samp>,
 * we can use the field support built into JFace that allows us to create a page
 * that is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the
 * preference store that belongs to the main plug-in class. That way,
 * preferences can be accessed directly via the preference store.
 */

public class AppearancePreferences extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage{
	
	private ColorFieldEditor regionBackgroundColorEditor;
	private ColorFieldEditor regionForegroundColorEditor;
	private ColorFieldEditor stateActiveColorEditor;
	private ColorFieldEditor stateBackgroundColorEditor;
	private ColorFieldEditor stateForegroundColorEditor;
	private ColorFieldEditor transitionColorEditor;
	private ColorFieldEditor transitionActiveColorEditor;
	private ComboFieldEditor transitionLineWidthComboEditor;
	//private ComboFieldEditor transitionSmoothnessComboEditor;


	public AppearancePreferences() {
		super(GRID);
		setPreferenceStore(OurStatemachineDiagramEditorPlugin.getInstance().getPreferenceStore());
		setDescription("MDA4E Statechart Editor Appearance Options");
	}

	/**
	 * Sets the default values of the preferences.
	 */
	public static void initializeDefaults(IPreferenceStore store) {
		Color regionBackgroundColor = new Color(null,207,247,189);
        PreferenceConverter.setDefault(store, Constants.P_REGION_BACKGROUND_COLOR, regionBackgroundColor.getRGB());
        
        Color regionForegroundColor = new Color(null,150,150,150);//DiagramColorConstants.lightBlue;
        PreferenceConverter.setDefault(store, Constants.P_REGION_FOREGROUND_COLOR, regionForegroundColor.getRGB());
		
		Color stateBackgroundColor = DiagramColorConstants.diagramLightYellow;//new Color(null,247, 174, 0);
        PreferenceConverter.setDefault(store, Constants.P_STATE_BACKGROUND_COLOR, stateBackgroundColor.getRGB());
        
        Color stateForegroundColor =  ColorConstants.gray;//DiagramColorConstants.lightBlue;
        PreferenceConverter.setDefault(store, Constants.P_STATE_FOREGROUND_COLOR, stateForegroundColor.getRGB());
        
		Color stateActiveColor = DiagramColorConstants.red;
        PreferenceConverter.setDefault(store, Constants.P_STATE_ACTIVE_COLOR, stateActiveColor.getRGB());
        
        Color transitionColor = DiagramColorConstants.black;
        PreferenceConverter.setDefault(store, Constants.P_TRANSITION_COLOR, transitionColor.getRGB());
        
        Color transitionActiveColor = DiagramColorConstants.red;
        PreferenceConverter.setDefault(store, Constants.P_TRANSITION_ACTIVE_COLOR, transitionActiveColor.getRGB());
        
        store.setDefault(Constants.P_TRANSITION_LINE_WIDTH, "1");
        store.setDefault(Constants.P_TRANSITION_SMOTHNESS, "32");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */

	
	public void createFieldEditors() {
		
		regionBackgroundColorEditor = new ColorFieldEditor(Constants.P_REGION_BACKGROUND_COLOR,
				  "Region Background Color:",
				  getFieldEditorParent());
		addField(regionBackgroundColorEditor);

		regionForegroundColorEditor = new ColorFieldEditor(Constants.P_REGION_FOREGROUND_COLOR,
				  										  "Region Foreground Color:",
				  										  getFieldEditorParent());
		addField(regionForegroundColorEditor);
		
		stateBackgroundColorEditor = new ColorFieldEditor(Constants.P_STATE_BACKGROUND_COLOR,
														  "State Background Color:",
														  getFieldEditorParent());
		addField(stateBackgroundColorEditor);
		
		stateForegroundColorEditor = new ColorFieldEditor(Constants.P_STATE_FOREGROUND_COLOR,
				  										  "State Foreground Color:",
				  										  getFieldEditorParent());
		addField(stateForegroundColorEditor);
		
		stateActiveColorEditor = new ColorFieldEditor(Constants.P_STATE_ACTIVE_COLOR,
																"Active State Color:",
																getFieldEditorParent());
        addField(stateActiveColorEditor);
        
        transitionColorEditor = new ColorFieldEditor(Constants.P_TRANSITION_COLOR,
													 "Transition Color:",
													 getFieldEditorParent());
        addField(transitionColorEditor);
        
        transitionActiveColorEditor = new ColorFieldEditor(Constants.P_TRANSITION_ACTIVE_COLOR,
				 										   "Active Transition Color:",
				 										   getFieldEditorParent());
        addField(transitionActiveColorEditor);
        
        transitionLineWidthComboEditor = new ComboFieldEditor( Constants.P_TRANSITION_LINE_WIDTH,
				"Transition Line Width:",				
				new String[][] {
				{"1", "1"},
				{"2", "2"},
				{"3", "3"}}
				,getFieldEditorParent());
        
		addField(transitionLineWidthComboEditor);
		
		 
       /* transitionSmoothnessComboEditor = new ComboFieldEditor( Constants.P_TRANSITION_SMOTHNESS,
				"Transition Smoothness:",				
				new String[][] {
				{"none", "0"},
				{"less", "16"},
				{"normal", "32"},
				{"more", "64"}}
				,getFieldEditorParent());
        
		addField(transitionSmoothnessComboEditor);
		*/
    }

	public void init(IWorkbench workbench) {
	}
}



