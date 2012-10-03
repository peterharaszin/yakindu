package org.eclipse.damos.ide.ui.internal;

import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class DamosPerspectiveFactory implements IPerspectiveFactory {
	
	private static final String ID_FRAGMENT_EXPLORER_VIEW = "org.eclipse.damos.ide.ui.fragmentExplorerView";
	private static final String ID_BLOCK_LIBRARY_VIEW = "org.eclipse.damos.ide.ui.blockLibraryView";
	private static final String ID_CONSOLE_FOLDER_VIEW = "org.eclipse.damos.ide.ui.consoleFolder";

	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		
		layout.addView(IPageLayout.ID_PROJECT_EXPLORER, IPageLayout.LEFT, 0.25f, editorArea);
		layout.addView(ID_BLOCK_LIBRARY_VIEW, IPageLayout.BOTTOM, 0.5f, IPageLayout.ID_PROJECT_EXPLORER);

		IFolderLayout consoleFolder = layout.createFolder(ID_CONSOLE_FOLDER_VIEW, IPageLayout.BOTTOM, 0.75f, editorArea);
		consoleFolder.addView(IPageLayout.ID_PROP_SHEET);
		consoleFolder.addView(IPageLayout.ID_TASK_LIST);
		consoleFolder.addView(IPageLayout.ID_PROBLEM_VIEW);

		layout.addView(IPageLayout.ID_OUTLINE, IPageLayout.RIGHT, 0.75f, editorArea);
		layout.addView(ID_FRAGMENT_EXPLORER_VIEW, IPageLayout.BOTTOM, 0.5f, IPageLayout.ID_OUTLINE);
		
		layout.addActionSet(IDebugUIConstants.LAUNCH_ACTION_SET);
	}

}
