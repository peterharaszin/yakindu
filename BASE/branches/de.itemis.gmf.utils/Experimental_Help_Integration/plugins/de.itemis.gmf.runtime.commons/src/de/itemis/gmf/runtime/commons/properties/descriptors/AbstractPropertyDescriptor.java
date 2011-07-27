/**
 * Copyright (c) 2011 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package de.itemis.gmf.runtime.commons.properties.descriptors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.jface.dialogs.IDialogLabelKeys;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * Abstract base class for all implementers of {@link IFormPropertyDescriptor}.
 * 
 * @author andreas muelder
 * 
 */
public abstract class AbstractPropertyDescriptor implements
		IFormPropertyDescriptor {

	private final EAttribute feature;
	private final String labelName;

	private Control control;

	// Use interface constant?
	public final static String HELP_CONTEXT_NONE = "";
	private String helpContextId = HELP_CONTEXT_NONE;
	
	public String getHelpContextId() {
		return helpContextId;
	}

	public void setHelpContextId(String helpContextId) {
		this.helpContextId = helpContextId;
	}

	protected abstract Control createControl(Composite parent);

	public void initControl(Composite parent) {
		control = createControl(parent);
	}

	public AbstractPropertyDescriptor(EAttribute feature, String labelName) {
		this.feature = feature;
		this.labelName = labelName;
	}

	public AbstractPropertyDescriptor(EAttribute feature, String labelName, String helpContextId) {
		this.helpContextId = helpContextId;
		this.feature = feature;
		this.labelName = labelName;
	}
	
	public EAttribute getEAttribute() {
		return feature;
	}

	public Label createLabel(Composite parent) {
		FormToolkit toolkit = new FormToolkit(parent.getDisplay());
		Label label = toolkit.createLabel(parent, labelName);
		applyLayout(label);
		return label;
	}

	/**
	 * Hook method, clients may override if another layouting is needed
	 */
	protected void applyLayout(Control control) {
		GridDataFactory.fillDefaults().applyTo(control);
	}

	public Control getControl() {
		return control;
	}
	
	public void addHelp(Composite parent) {
		FormToolkit toolkit = new FormToolkit(parent.getDisplay());
		Button helpButton = toolkit.createButton(parent,"", SWT.PUSH) ;
		helpButton.setToolTipText(JFaceResources.getString(IDialogLabelKeys.HELP_LABEL_KEY));
		helpButton.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_LCL_LINKTO_HELP));
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.TOP).applyTo(helpButton);
		//applyLayout(helpButton);
		applyHelpContext(helpButton);
		helpButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				PlatformUI.getWorkbench().getHelpSystem().displayDynamicHelp();
			}
		});
	}

	protected void applyHelpContext(Control control) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(control, getHelpContextId());
		
	}
}
