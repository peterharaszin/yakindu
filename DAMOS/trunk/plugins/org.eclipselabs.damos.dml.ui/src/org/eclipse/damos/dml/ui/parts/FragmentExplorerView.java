/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.dml.ui.parts;

import org.eclipse.damos.common.ui.viewers.FragmentTreeContentProvider;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.ui.viewers.FragmentTreeLabelProvider;
import org.eclipse.damos.dml.util.FragmentSelectionChangeEvent;
import org.eclipse.damos.dml.util.FragmentSelectionManager;
import org.eclipse.damos.dml.util.IFragmentSelectionChangeListener;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.part.MessagePage;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.PageBookView;

import com.google.inject.Inject;

public class FragmentExplorerView extends PageBookView {

	@Inject
	@FragmentExplorerViewId
	private String fragmentExplorerViewId;

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.PageBookView#createDefaultPage(org.eclipse.ui.part.PageBook)
	 */
	@Override
	protected IPage createDefaultPage(PageBook book) {
        MessagePage page = new MessagePage();
        initPage(page);
        page.createControl(book);
        page.setMessage("No fragments available.");
        return page;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.PageBookView#getBootstrapPart()
	 */
	@Override
	protected IWorkbenchPart getBootstrapPart() {
        IWorkbenchPage page = getSite().getPage();
        if (page != null) {
			return page.getActiveEditor();
		}
        return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.PageBookView#isImportant(org.eclipse.ui.IWorkbenchPart)
	 */
	@Override
	protected boolean isImportant(IWorkbenchPart part) {
		return (FragmentSelectionManager) part.getAdapter(FragmentSelectionManager.class) != null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.PageBookView#doCreatePage(org.eclipse.ui.IWorkbenchPart)
	 */
	@Override
	protected PageRec doCreatePage(IWorkbenchPart part) {
		FragmentSelectionManager fragmentManager = (FragmentSelectionManager) part.getAdapter(FragmentSelectionManager.class);
		Page page = new FragmentPage(fragmentManager);
		initPage(page);
		page.createControl(getPageBook());
		return new PageRec(part, page);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.PageBookView#doDestroyPage(org.eclipse.ui.IWorkbenchPart, org.eclipse.ui.part.PageBookView.PageRec)
	 */
	@Override
	protected void doDestroyPage(IWorkbenchPart part, PageRec pageRecord) {
        pageRecord.page.dispose();
        pageRecord.dispose();
	}
	
	private class FragmentPage extends Page {

		private FragmentSelectionManager fragmentManager;
		private TreeViewer treeViewer;
		
		private IFragmentSelectionChangeListener fragmentChangeListener = new IFragmentSelectionChangeListener() {
			
			public void fragmentSelectionChanged(FragmentSelectionChangeEvent event) {
				if (treeViewer != null) {
					treeViewer.refresh();
				}
			}
			
		};
		
		/**
		 * 
		 */
		public FragmentPage(FragmentSelectionManager fragmentManager) {
			this.fragmentManager = fragmentManager;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.ui.part.Page#createControl(org.eclipse.swt.widgets.Composite)
		 */
		@Override
		public void createControl(Composite parent) {
			treeViewer = new TreeViewer(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL);
			treeViewer.setLabelProvider(new FragmentTreeLabelProvider(fragmentManager, parent.getFont()));
			treeViewer.setContentProvider(new FragmentTreeContentProvider(fragmentManager.getSystem()));
			treeViewer.setInput(fragmentManager.getSystem().eResource().getResourceSet());
			treeViewer.addDoubleClickListener(new IDoubleClickListener() {
				
				public void doubleClick(DoubleClickEvent event) {
					if (event.getSelection() instanceof IStructuredSelection) {
						IStructuredSelection selection = (IStructuredSelection) event.getSelection();
						if (selection.getFirstElement() instanceof Fragment) {
							Fragment selectedFragment = (Fragment) selection.getFirstElement();
							if (selectedFragment != null) {
								fragmentManager.setSelectedFragment(selectedFragment);
							}
						}
					}
				}

			});
			
			MenuManager menuManager = new MenuManager();
			menuManager.add(new GroupMarker(IWorkbenchActionConstants.M_FILE));
			menuManager.add(new Separator());
			menuManager.add(new GroupMarker(IWorkbenchActionConstants.M_EDIT));
			menuManager.add(new Separator());
			menuManager.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
			Menu menu = menuManager.createContextMenu(treeViewer.getControl());
			treeViewer.getControl().setMenu(menu);

			getSite().registerContextMenu(fragmentExplorerViewId, menuManager, treeViewer);
			getSite().setSelectionProvider(treeViewer);
			fragmentManager.addFragmentSelectionChangeListener(fragmentChangeListener);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.ui.part.Page#getControl()
		 */
		@Override
		public Control getControl() {
			return treeViewer.getControl();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.ui.part.Page#setFocus()
		 */
		@Override
		public void setFocus() {
			treeViewer.getControl().setFocus();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.ui.part.Page#dispose()
		 */
		@Override
		public void dispose() {
			fragmentManager.removeFragmentSelectionChangeListener(fragmentChangeListener);
			super.dispose();
		}
		
	}
	
}
