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

package org.eclipselabs.damos.diagram.ui.preferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.gef.rulers.RulerProvider;
import org.eclipse.gmf.runtime.diagram.ui.preferences.DiagramPreferenceInitializer;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipselabs.damos.diagram.ui.DiagramUIPlugin;
import org.eclipselabs.damos.diagram.ui.internal.registry.DefaultCommonBlockRegistry;

/**
 * @author Andreas Unger
 *
 */
public class BlockDiagramPreferenceInitializer extends DiagramPreferenceInitializer implements IPreferenceConstants, org.eclipselabs.damos.diagram.ui.preferences.IPreferenceConstants {

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

		initializeDefaultCommonBlocks();
	}

	/**
	 * 
	 */
	private void initializeDefaultCommonBlocks() {
		List<String> blockTypes = new ArrayList<String>(DefaultCommonBlockRegistry.getInstance().getBlockTypes());
		Collections.sort(blockTypes, new Comparator<String>() {

			public int compare(String s1, String s2) {
				s1 = s1.substring(s1.lastIndexOf('.') + 1);
				s2 = s2.substring(s2.lastIndexOf('.') + 1);
				return s1.compareTo(s2);
			}
			
		});

		StringBuilder sb = new StringBuilder();
		for (String blockType : blockTypes) {
			if (sb.length() > 0) {
				sb.append(",");
			}
			sb.append(blockType);
		}
		IEclipsePreferences node = new InstanceScope().getNode(DiagramUIPlugin.PLUGIN_ID);
		node.put(COMMON_BLOCKS, sb.toString());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.preferences.DiagramPreferenceInitializer#getPreferenceStore()
	 */
	protected IPreferenceStore getPreferenceStore() {
		return DiagramUIPlugin.getDefault().getPreferenceStore();
	}

}
