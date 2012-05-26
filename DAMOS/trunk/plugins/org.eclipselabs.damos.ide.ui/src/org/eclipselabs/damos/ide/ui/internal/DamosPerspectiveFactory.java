package org.eclipselabs.damos.ide.ui.internal;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class DamosPerspectiveFactory implements IPerspectiveFactory {
	
	private static final String ID_FRAGMENT_EXPLORER_VIEW = "org.eclipselabs.damos.ide.ui.fragmentExplorerView";
	private static final String ID_BLOCK_LIBRARY_VIEW = "org.eclipselabs.damos.ide.ui.blockLibraryView";
	private static final String ID_LAUNCH_ACTION_SET = "org.eclipse.debug.ui.launchActionSet";

	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		
		layout.addView(IPageLayout.ID_PROJECT_EXPLORER, IPageLayout.LEFT, 0.25f, editorArea);
		layout.addView(ID_BLOCK_LIBRARY_VIEW, IPageLayout.BOTTOM, 0.5f, IPageLayout.ID_PROJECT_EXPLORER);
		layout.addView(IPageLayout.ID_PROP_SHEET, IPageLayout.BOTTOM, 0.75f, editorArea);
		layout.addView(IPageLayout.ID_OUTLINE, IPageLayout.RIGHT, 0.75f, editorArea);
		layout.addView(ID_FRAGMENT_EXPLORER_VIEW, IPageLayout.BOTTOM, 0.5f, IPageLayout.ID_OUTLINE);
		
		layout.addActionSet(ID_LAUNCH_ACTION_SET);
	}

}
