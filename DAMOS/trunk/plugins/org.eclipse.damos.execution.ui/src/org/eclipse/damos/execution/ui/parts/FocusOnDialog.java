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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.damos.common.ui.viewers.FragmentLabelProvider;
import org.eclipse.damos.common.ui.viewers.FragmentListContentProvider;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;

/**
 * @author Andreas Unger
 *
 */
public class FocusOnDialog extends Dialog {

	private static final String BLOCK_DIAGRAM_FILE_EXTENSION = "blockdiagram";

	private Text blockDiagramPathText;
	private ComboViewer fragmentViewer;
	
	private Fragment fragment;
	
	/**
	 * @param parentShell
	 */
	protected FocusOnDialog(Shell parentShell) {
		super(parentShell);
	}
	
	public Fragment getFragment() {
		return fragment;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	@Override
	protected void okPressed() {
		fragment = (Fragment) ((IStructuredSelection) fragmentViewer.getSelection()).getFirstElement();
		super.okPressed();
	}
	

	/* (non-Javadoc)
	 * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Focus On");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		
		Composite topLevel = new Composite(composite, SWT.NONE);
		topLevel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		GridLayout layout = new GridLayout(3, false);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		topLevel.setLayout(layout);
		topLevel.setFont(parent.getFont());
		
		Label label = new Label(topLevel, SWT.NONE);
		label.setText("Block diagram:");

		blockDiagramPathText = new Text(topLevel, SWT.SINGLE | SWT.BORDER);
		GridData gridData = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
		gridData.widthHint = convertWidthInCharsToPixels(60);
		blockDiagramPathText.setLayoutData(gridData);
		
		blockDiagramPathText.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent event) {
				updateBlockDiagramPath();
			}
			
		});
		
		Button browseBlockDiagramButton = new Button(topLevel, SWT.PUSH);
		browseBlockDiagramButton.setText("Browse...");
		browseBlockDiagramButton.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				browseBlockDiagram();
			}
			
		});

		label = new Label(topLevel, SWT.NONE);
		label.setText("Fragment:");

		fragmentViewer = new ComboViewer(topLevel, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
		fragmentViewer.getCombo().setLayoutData(gridData);
		fragmentViewer.setLabelProvider(new FragmentLabelProvider());
		fragmentViewer.setContentProvider(new FragmentListContentProvider());
		fragmentViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			public void selectionChanged(SelectionChangedEvent event) {
				validate();
			}
			
		});

		return composite;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#createButtonBar(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createButtonBar(Composite parent) {
		Control control = super.createButtonBar(parent);
		validate();
		return control;
	}
	
	private void updateBlockDiagramPath() {
		try {
			ResourceSet rs = new ResourceSetImpl();
			URI uri = URI.createPlatformResourceURI(blockDiagramPathText.getText(), false);
			rs.getResource(uri, true);
			fragmentViewer.setInput(rs);
			fragmentViewer.getCombo().select(0);
		} catch (Exception e) {
			fragmentViewer.setInput(null);
		}
		validate();
	}

	private void browseBlockDiagram() {
		FilteredResourcesSelectionDialog d = new FilteredResourcesSelectionDialog(
				getShell(),
				false,
				ResourcesPlugin.getWorkspace().getRoot(),
				IResource.FILE);
		d.setInitialPattern("*." + BLOCK_DIAGRAM_FILE_EXTENSION);
		d.open();
		Object firstResult = d.getFirstResult();
		if (firstResult instanceof IFile) {
			blockDiagramPathText.setText(((IFile) firstResult).getFullPath().makeRelative().toString());
		}
	}
	
	private void validate() {
		Object element = ((IStructuredSelection) fragmentViewer.getSelection()).getFirstElement();
		getButton(IDialogConstants.OK_ID).setEnabled(element instanceof Fragment);
	}

}
