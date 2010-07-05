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

import org.eclipse.gef.rulers.RulerProvider;
import org.eclipse.gmf.runtime.diagram.ui.preferences.DiagramPreferenceInitializer;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipselabs.damos.diagram.ui.DSMDiagramUIPlugin;

/**
 * @author Andreas Unger
 *
 */
public class BlockDiagramPreferenceInitializer extends DiagramPreferenceInitializer {

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.preferences.DiagramPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		super.initializeDefaultPreferences();
		IPreferenceStore store = getPreferenceStore();
		if (store.getInt(IPreferenceConstants.PREF_RULER_UNITS) == RulerProvider.UNIT_CENTIMETERS) {
			store.setDefault(IPreferenceConstants.PREF_GRID_SPACING, 0.2);
		}
		store.setDefault(IPreferenceConstants.PREF_SNAP_TO_GEOMETRY, true);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.preferences.DiagramPreferenceInitializer#getPreferenceStore()
	 */
	protected IPreferenceStore getPreferenceStore() {
		return DSMDiagramUIPlugin.getDefault().getPreferenceStore();
	}

}
