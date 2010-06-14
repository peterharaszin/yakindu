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
package com.yakindu.simulation.perspective;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuAdapter;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.yakindu.simulation.perspective.messages.Messages;

public class ToggleNatureContribution extends ContributionItem {

	public ToggleNatureContribution() {
	}

	public ToggleNatureContribution(String id) {
		super(id);
	}

	@Override
	public void fill(Menu menu, int index) {
		final MenuItem menuItem = new MenuItem(menu, SWT.CHECK, index);
		menuItem.setText(Messages.toggleMenu);
		menuItem.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				run();
			}
		});
		menu.addMenuListener(new MenuAdapter(){
			@Override
			public void menuShown(MenuEvent e) {
				updateState(menuItem);
			}
		});
	}
	
	protected void updateState(MenuItem menuItem){
		Collection<IProject> projects = getSelectedProjects();
		boolean enabled = projects.size()>0;
		menuItem.setEnabled(enabled);
		try {
			menuItem.setSelection(enabled &&
					projects.iterator().next().hasNature(YakinduNature.ID));
		} catch (CoreException e) {
			menuItem.setSelection(enabled && false);
		}
	}
	
	protected Collection<IProject> getSelectedProjects(){
		Collection<IProject> projects = new HashSet<IProject>();
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		ISelection selection = window.getActivePage().getSelection();
		if (selection instanceof IStructuredSelection){
			for (Iterator<?> iter = ((IStructuredSelection)selection).iterator();iter.hasNext();){
				Object elem = iter.next();
				if (!(elem instanceof IResource)){
					if (!(elem instanceof IAdaptable)){
						continue;
					}
					elem = ((IAdaptable)elem).getAdapter(IResource.class);
					if (!(elem instanceof IResource)){
						continue;
					}
				}
				if (!(elem instanceof IProject)){
					elem = ((IResource)elem).getProject();
					if (!(elem instanceof IProject))
						continue;
				}
				projects.add((IProject)elem);
			}
		}
		return projects;
	}
	
	protected void run(){
		Collection<IProject> projects = getSelectedProjects();
		for (IProject project: projects){
			if (YakinduNature.hasNature(project)){
				YakinduNature.removeNature(project);
			} else {
				YakinduNature.addNature(project);
			}
		}
		//TODO: complete activation
	}
}
