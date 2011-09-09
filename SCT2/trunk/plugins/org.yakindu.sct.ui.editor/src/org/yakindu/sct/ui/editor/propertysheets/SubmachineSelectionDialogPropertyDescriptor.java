/**
 * Copyright (c) 2011 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *         itemis AG - initial API and implementation
 *
 */
package org.yakindu.sct.ui.editor.propertysheets;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.ui.editor.dialogs.SelectSubmachineDialog;

import de.itemis.gmf.runtime.commons.properties.descriptors.IFormPropertyDescriptor;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SubmachineSelectionDialogPropertyDescriptor implements
		IFormPropertyDescriptor {

	private final class UpdateLabelAdapter extends AdapterImpl {
		@Override
		public void notifyChanged(Notification msg) {
			if (msg.getFeature() == SGraphPackage.Literals.STATE__SUBSTATECHART) {
				updateLabel(submachine);
			}
		}
	}

	private State submachine;
	private Label label;
	private UpdateLabelAdapter updateLabelAdapter;

	public void updateModelBinding(EObject eObject) {
		this.submachine = (State) eObject;
		updateLabel(submachine);
		if (updateLabelAdapter == null) {
			updateLabelAdapter = new UpdateLabelAdapter();
			submachine.eAdapters().add(updateLabelAdapter);
		}

	}

	private void updateLabel(State state) {
		Statechart substatechart = submachine.getSubstatechart();
		if (substatechart != null) {
			label.setText(substatechart.eResource().getURI().toString());
		}
	}

	public void createLabelColumn(Composite parent) {
		FormToolkit toolkit = new FormToolkit(parent.getDisplay());
		Label label = toolkit.createLabel(parent, "Submachine:");
		GridDataFactory.fillDefaults().applyTo(label);
		toolkit.dispose();

	}

	public void createControlColumn(final Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(composite);
		composite.setBackground(ColorConstants.white);
		GridLayout layout = new GridLayout(2, false);
		layout.marginLeft = 0;
		layout.marginRight = 0;
		composite.setLayout(layout);
		label = new Label(composite, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(label);
		Button openDialog = new Button(composite, SWT.FLAT);
		GridDataFactory.fillDefaults().hint(SWT.DEFAULT, 10)
				.applyTo(openDialog);
		openDialog.setText("...");
		openDialog.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				SelectSubmachineDialog dialog = new SelectSubmachineDialog(
						parent.getShell());
				if (Dialog.OK == dialog.open()) {
					Statechart selectedSubmachine = dialog
							.getSelectedSubmachine();
					if (selectedSubmachine != null) {
						SetValueCommand command = new SetValueCommand(
								new SetRequest(
										submachine,
										SGraphPackage.Literals.STATE__SUBSTATECHART,
										selectedSubmachine));
						try {
							OperationHistoryFactory.getOperationHistory()
									.execute(command,
											new NullProgressMonitor(), null);
						} catch (ExecutionException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});

	}

	public void createHelpColumn(Composite parent) {
		// No help provided
	}

	public void dispose() {
		submachine.eAdapters().remove(updateLabelAdapter);
	}
}
