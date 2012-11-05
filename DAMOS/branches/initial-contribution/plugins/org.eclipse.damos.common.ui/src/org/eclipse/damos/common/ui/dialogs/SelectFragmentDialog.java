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

package org.eclipse.damos.common.ui.dialogs;

import org.eclipse.damos.common.ui.viewers.FragmentLabelProvider;
import org.eclipse.damos.common.ui.viewers.FragmentListContentProvider;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Andreas Unger
 * 
 */
public class SelectFragmentDialog extends Dialog {

	private String title;
	private String message;
	private Fragment rootFragment;
	private ResourceSet resourceSet;
	
	private Fragment selectedFragment;
	private ComboViewer fragmentViewer;

	public SelectFragmentDialog(Shell parentShell, String title, String message, Fragment rootFragment) {
		super(parentShell);
		this.title = title;
		this.message = message;
		this.rootFragment = rootFragment;
	}
	
	public SelectFragmentDialog(Shell parentShell, String title, String message, ResourceSet resourceSet) {
		this(parentShell, title, message, (Fragment) null);
		this.resourceSet = resourceSet;
	}

	public static Fragment open(Shell parentShell, String title, String message, Fragment rootFragment) {
		SelectFragmentDialog d = new SelectFragmentDialog(parentShell, title, message, rootFragment);
		d.open();
		return d.getSelectedFragment();
	}

	public static Fragment open(Shell parentShell, String title, String message, ResourceSet resourceSet) {
		SelectFragmentDialog d = new SelectFragmentDialog(parentShell, title, message, resourceSet);
		d.open();
		return d.getSelectedFragment();
	}

	/**
	 * @return the destinationFragment
	 */
	public Fragment getSelectedFragment() {
		return selectedFragment;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	@Override
	protected void okPressed() {
		selectedFragment = (Fragment) ((IStructuredSelection) fragmentViewer.getSelection()).getFirstElement();
		super.okPressed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#cancelPressed()
	 */
	@Override
	protected void cancelPressed() {
		selectedFragment = null;
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
		shell.setText(title);
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
		fragmentViewer.getControl().setFocus();
		fragmentViewer.getCombo().select(0);
	}

	/*
	 * (non-Javadoc) Method declared on Dialog.
	 */
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);

		Label label = new Label(composite, SWT.WRAP);
		label.setText(message);
		GridData data = new GridData(GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL | GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_CENTER);
		data.widthHint = convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);
		label.setLayoutData(data);
		label.setFont(parent.getFont());

		fragmentViewer = new ComboViewer(composite, SWT.SINGLE | SWT.BORDER);
		fragmentViewer.getCombo().setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		fragmentViewer.setLabelProvider(new FragmentLabelProvider());
		fragmentViewer.setContentProvider(new FragmentListContentProvider(rootFragment));
		if (resourceSet != null) {
			fragmentViewer.setInput(resourceSet);
		} else {
			fragmentViewer.setInput(DMLUtil.getResourceSet(rootFragment));
		}

		applyDialogFont(composite);
		return composite;
	}

}
