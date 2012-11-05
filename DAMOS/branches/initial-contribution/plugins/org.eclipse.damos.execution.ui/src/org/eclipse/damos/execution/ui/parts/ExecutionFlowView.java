/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.execution.ui.parts;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.damos.execution.ExecutionFlow;
import org.eclipse.damos.execution.Graph;
import org.eclipse.damos.execution.transform.ExecutionFlowBuilder;
import org.eclipse.damos.execution.ui.ExecutionUIPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.HorizontalTreeLayoutAlgorithm;

/**
 * @author Andreas Unger
 *
 */
public class ExecutionFlowView extends ViewPart {

	private GraphViewer viewer;
	
	private final IAction focusOnAction = new Action("Foc&us on...") {

		public void run() {
			FocusOnDialog d = new FocusOnDialog(getSite().getShell());
			if (d.open() == Dialog.OK && d.getFragment() != null) {
				setFragment(d.getFragment());
			}
		}

	};
	
	private final IAction backAction = new Action("Back", PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_BACK)) {
		
		public void run() {
			EObject eObject = (EObject) viewer.getInput();
			if (eObject == null) {
				return;
			}
			
			EObject container = eObject.eContainer();
			ExecutionFlow executionFlow = DMLUtil.getOwner(container, ExecutionFlow.class);
			if (container == executionFlow.getGraph()) {
				container = executionFlow;
			}
			setInput(container);
		}
		
	};
	
	private final IAction refreshAction = new Action("Re&fresh", AbstractUIPlugin.imageDescriptorFromPlugin(ExecutionUIPlugin.PLUGIN_ID, "icons/full/elcl16/refresh_nav.gif")) {
		
		public void run() {
			if (fragment == null || viewer.getInput() == null) {
				return;
			}
			URI fragmentURI = EcoreUtil.getURI(fragment);
			
			unloadFragment();
			
			ResourceSet resourceSet = new ResourceSetImpl();
			try {
				EObject eObject = resourceSet.getEObject(fragmentURI, true);
				if (eObject instanceof Fragment) {
					setFragment((Fragment) eObject);
				}
			} catch (RuntimeException e) {
				if (e.getCause() instanceof CoreException) {
					ErrorDialog.openError(getSite().getShell(), "Refresh", "Refresh failed", ((CoreException) e.getCause()).getStatus());
				} else {
					MessageDialog.openError(getSite().getShell(), "Refresh", "Refresh failed: " + e.getMessage());
				}
				setFragment(null);
			}
		}
		
	};

	private final IAction saveAsAction = new Action("Save As...", PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_SAVEAS_EDIT)) {
		
		public void run() {
			EObject eObject = (EObject) viewer.getInput();
			if (eObject == null) {
				return;
			}
			
			SaveAsDialog d = new SaveAsDialog(getSite().getShell());
			Path fragmentPath = new Path(fragment.eResource().getURI().toPlatformString(true));
			IPath defaultPath = fragmentPath.removeFileExtension().addFileExtension("xmi");
			d.setOriginalFile(ResourcesPlugin.getWorkspace().getRoot().getFile(defaultPath));
			if (d.open() == Window.OK) {
				IPath path = d.getResult();
				if (path != null) {
					URI uri = URI.createPlatformResourceURI(path.toString(), true);
					ResourceSet resourceSet = new ResourceSetImpl();
					try {
						Resource resource = resourceSet.createResource(uri);
						resource.getContents().add(EcoreUtil.copy(eObject));
						resource.save(Collections.emptyMap());
					} catch (IOException e) {
						MessageDialog.openError(getSite().getShell(), "Save &As", "Saving failed: " + e.getMessage());
					} finally {
						for (Resource resource : resourceSet.getResources()) {
							resource.unload();
						}
					}
				}
			}
		}
		
	};

	private Fragment fragment;

	private void unloadFragment() {
		if (fragment != null) {
			for (Resource resource : fragment.eResource().getResourceSet().getResources()) {
				resource.unload();
			}
			fragment = null;
		}
	}

	/**
	 * @param fragment
	 */
	private void setFragment(Fragment fragment) {
		unloadFragment();
		this.fragment = fragment;
		if (fragment != null) {
			try {
				ExecutionFlow executionFlow = new ExecutionFlowBuilder().build(fragment, new NullProgressMonitor());
				setInput(executionFlow);
			} catch (CoreException e) {
				setInput(null);
				unloadFragment();
				ErrorDialog.openError(getSite().getShell(), "Execution Flow", "Loading execution flow failed", e.getStatus());
			}
		} else {
			setInput(null);
		}
	}
	
	private void setInput(EObject eObject) {
		viewer.setInput(eObject);
		backAction.setEnabled(eObject != null && (eObject.eContainer() instanceof ExecutionFlow || eObject.eContainer() instanceof Graph));
		refreshAction.setEnabled(eObject != null);
		saveAsAction.setEnabled(eObject != null);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		viewer = new GraphViewer(parent, SWT.NONE);
		
		viewer.setLayoutAlgorithm(new HorizontalTreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING));
		viewer.setContentProvider(new ExecutionFlowContentProvider());
		viewer.setLabelProvider(new ExecutionFlowLabelProvider());
		viewer.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED);
		
		final MenuManager menuManager = new MenuManager();
		final Menu menu = menuManager.createContextMenu(viewer.getControl());
		menuManager.setRemoveAllWhenShown(true);
		menuManager.addMenuListener(new IMenuListener() {

			public void menuAboutToShow(IMenuManager manager) {
				IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
				if (selection.size() == 1) {
					final Object element = selection.getFirstElement();
					if (element instanceof Graph) {
						ILabelProvider labelProvider = (ILabelProvider) viewer.getLabelProvider();
						IAction focusOnElementAction = new Action("Focus on '" + labelProvider.getText(element) + "'") {

							public void run() {
								setInput((EObject) element);
							}

						};
						menuManager.add(focusOnElementAction);
					}
				}
				menuManager.add(focusOnAction);
			}

		});
		viewer.getControl().setMenu(menu);

		backAction.setEnabled(false);
		getViewSite().getActionBars().getToolBarManager().add(backAction);
		getViewSite().getActionBars().getToolBarManager().add(new Separator());
		
		refreshAction.setEnabled(false);
		getViewSite().getActionBars().getMenuManager().add(refreshAction);
		getViewSite().getActionBars().getToolBarManager().add(refreshAction);

		saveAsAction.setEnabled(false);
		getViewSite().getActionBars().getMenuManager().add(saveAsAction);
		getViewSite().getActionBars().getToolBarManager().add(saveAsAction);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#dispose()
	 */
	@Override
	public void dispose() {
		unloadFragment();
		super.dispose();
	}

}
