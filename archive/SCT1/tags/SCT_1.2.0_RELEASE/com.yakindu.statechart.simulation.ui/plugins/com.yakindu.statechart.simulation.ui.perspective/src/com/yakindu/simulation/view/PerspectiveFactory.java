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
package com.yakindu.simulation.view;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class PerspectiveFactory implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.addActionSet("org.eclipse.debug.ui.launchActionSet");
		//layout.addView("org.mda4e.statemachine.contribution.dataElementExplorer", IPageLayout.BOTTOM, 0.80f, "org.eclipse.ui.editorss");
		layout.addView("org.eclipse.ui.navigator.ProjectExplorer", IPageLayout.LEFT, 0.15f, "org.eclipse.ui.editorss");
		layout.addView("com.yakindu.simulation.view.statemachine.StatemachineView", IPageLayout.RIGHT, 0.80f, "org.eclipse.ui.editorss");
		layout.addView ("org.eclipse.ui.views.ContentOutline", IPageLayout.BOTTOM, 0.60f, "com.yakindu.simulation.view.statemachine.StatemachineView");
		layout.addView("org.eclipse.debug.ui.DebugView", IPageLayout.TOP, 0.15f, "org.eclipse.ui.editorss");
		layout.addView("org.mda4e.statemachine.contribution.dataElementExplorer", IPageLayout.BOTTOM, 0.80f, "org.eclipse.ui.editorss");
		layout.addView("org.eclipse.ui.views.PropertySheet", IPageLayout.RIGHT, 0.50f, "org.mda4e.statemachine.contribution.dataElementExplorer");
		layout.addNewWizardShortcut("org.yakindu.simulation.launch.projectWizard");
	}

}
