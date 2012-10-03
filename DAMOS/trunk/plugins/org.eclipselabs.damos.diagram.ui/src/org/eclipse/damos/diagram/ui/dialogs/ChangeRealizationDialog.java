/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.diagram.ui.dialogs;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.damos.common.ui.viewers.FragmentLabelProvider;
import org.eclipse.damos.common.ui.viewers.FragmentTreeContentProvider;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;

/**
 * @author Andreas Unger
 * 
 */
public class ChangeRealizationDialog extends Dialog {

	private EditingDomain editingDomain;
	private Collection<Fragment> excludingFragments;
	private Fragment oldRealizingFragment;
	private Fragment newRealizingFragment;
	
	private Button checkbox;
	private Button searchButton;
	private Label fragmentLabel;
	private TreeViewer fragmentViewer;

	public ChangeRealizationDialog(Shell parentShell, EditingDomain editingDomain, Collection<Fragment> excludingFragments, Fragment oldRealizingFragment) {
		super(parentShell);
		this.editingDomain = editingDomain;
		this.excludingFragments = excludingFragments;
		this.oldRealizingFragment = oldRealizingFragment;
	}

	/**
	 * @return the destinationFragment
	 */
	public Fragment getNewRealizingFragment() {
		return newRealizingFragment;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	@Override
	protected void okPressed() {
		if (checkbox.getSelection()) {
			newRealizingFragment = (Fragment) ((IStructuredSelection) fragmentViewer.getSelection()).getFirstElement();
		}
		super.okPressed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#cancelPressed()
	 */
	@Override
	protected void cancelPressed() {
		newRealizingFragment = null;
		super.cancelPressed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets
	 * .Shell)
	 */
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Change Subsystem Realization");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse
	 * .swt.widgets.Composite)
	 */
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
		if (oldRealizingFragment != null) {
			fragmentViewer.getTree().setFocus();
		} else {
			checkbox.setFocus();
		}
	}

	/*
	 * (non-Javadoc) Method declared on Dialog.
	 */
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		((GridLayout) composite.getLayout()).numColumns = 2;
		
		checkbox = new Button(composite, SWT.CHECK);
		checkbox.setText("Provide subsystem realization");
		checkbox.setSelection(oldRealizingFragment != null);
		GridDataFactory.defaultsFor(checkbox).span(2, 1).applyTo(checkbox);
		checkbox.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				updateWidgetStates(checkbox.getSelection());
				updateOkButtonState();
			}
			
		});

		fragmentLabel = new Label(composite, SWT.NONE);
		fragmentLabel.setText("Realizing fragment:");
		GridDataFactory.defaultsFor(fragmentLabel)
				.indent(convertHorizontalDLUsToPixels(2 * IDialogConstants.SMALL_INDENT), 0)
				.span(2, 1)
				.applyTo(fragmentLabel);

		fragmentViewer = new TreeViewer(composite, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		GridDataFactory.defaultsFor(fragmentViewer.getTree())
				.indent(convertHorizontalDLUsToPixels(2 * IDialogConstants.SMALL_INDENT), 0)
				.grab(true, false)
				.align(SWT.FILL, SWT.FILL)
				.hint(convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH) / 2, convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH) / 2)
				.applyTo(fragmentViewer.getTree());
		fragmentViewer.setLabelProvider(new FragmentLabelProvider());
		fragmentViewer.setContentProvider(new FragmentTreeContentProvider() {

			protected boolean includeFragment(Fragment fragment) {
				return !excludingFragments.contains(fragment);
			}
			
		});
		fragmentViewer.setInput(editingDomain.getResourceSet());

		searchButton = new Button(composite, SWT.PUSH);
		searchButton.setText("Load...");
		GridDataFactory.defaultsFor(searchButton).align(SWT.CENTER, SWT.BEGINNING).applyTo(searchButton);
		searchButton.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				IPath path = openSearchFragmentResourceDialog();
				if (path != null) {
					editingDomain.getResourceSet().getResource(URI.createPlatformResourceURI(path.toString(), false), true);
				}
			}
			
		});

		if (oldRealizingFragment != null) {
			fragmentViewer.setSelection(new StructuredSelection(oldRealizingFragment));
		} else {
			updateWidgetStates(false);
		}

		fragmentViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			public void selectionChanged(SelectionChangedEvent event) {
				updateOkButtonState();
			}
			
		});

		applyDialogFont(composite);
		return composite;
	}
	
	private void updateWidgetStates(boolean enabled) {
		searchButton.setEnabled(enabled);
		fragmentLabel.setEnabled(enabled);
		fragmentViewer.getTree().setEnabled(enabled);
	}
	
	private void updateOkButtonState() {
		getButton(IDialogConstants.OK_ID).setEnabled(!checkbox.getSelection() || !fragmentViewer.getSelection().isEmpty());
	}
	
	private IPath openSearchFragmentResourceDialog() {
		FilteredResourcesSelectionDialog d = new FilteredResourcesSelectionDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				false,
				ResourcesPlugin.getWorkspace().getRoot(),
				IResource.FILE);
		d.setTitle("Select Block Diagram");
		d.setMessage("Select block diagram to load (*, ?, or camel case):");
		d.setInitialPattern("*.blockdiagram");
		
		if (d.open() == Dialog.OK) {
			Object firstResult = d.getFirstResult();
			if (firstResult instanceof IFile) {
				IFile file = (IFile) firstResult;
				return file.getFullPath();
			}
		}
		return null;
	}

}
