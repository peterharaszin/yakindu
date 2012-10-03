/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.diagram.ui.preferences;

import java.util.List;

import org.eclipse.gef.rulers.RulerProvider;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.preferences.DiagramPreferenceInitializer;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class BlockDiagramPreferenceInitializer extends DiagramPreferenceInitializer implements IPreferenceConstants, org.eclipse.damos.diagram.ui.preferences.IPreferenceConstants {

	private final PreferencesHint preferencesHint;
	private final IDefaultCommonBlockTypesProvider defaultCommonBlockTypesProvider;
	
	/**
	 * 
	 */
	@Inject
	BlockDiagramPreferenceInitializer(PreferencesHint preferencesHint, IDefaultCommonBlockTypesProvider defaultCommonBlockTypesProvider) {
		this.preferencesHint = preferencesHint;
		this.defaultCommonBlockTypesProvider = defaultCommonBlockTypesProvider;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.preferences.DiagramPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		super.initializeDefaultPreferences();
		IPreferenceStore store = getPreferenceStore();
		if (store.getInt(PREF_RULER_UNITS) == RulerProvider.UNIT_CENTIMETERS) {
			store.setDefault(PREF_GRID_SPACING, 0.2);
		}
		store.setDefault(PREF_SNAP_TO_GEOMETRY, true);

		initializeDefaultCommonBlockTypes();
	}

	/**
	 * 
	 */
	private void initializeDefaultCommonBlockTypes() {
		List<String> blockTypes = defaultCommonBlockTypesProvider.getBlockTypes();
		StringBuilder sb = new StringBuilder();
		for (String blockType : blockTypes) {
			if (sb.length() > 0) {
				sb.append(",");
			}
			sb.append(blockType);
		}
		IPreferenceStore store = getPreferenceStore();
		store.setDefault(COMMON_BLOCKS, sb.toString());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.preferences.DiagramPreferenceInitializer#getPreferenceStore()
	 */
	protected IPreferenceStore getPreferenceStore() {
		return (IPreferenceStore) preferencesHint.getPreferenceStore();
	}

}
