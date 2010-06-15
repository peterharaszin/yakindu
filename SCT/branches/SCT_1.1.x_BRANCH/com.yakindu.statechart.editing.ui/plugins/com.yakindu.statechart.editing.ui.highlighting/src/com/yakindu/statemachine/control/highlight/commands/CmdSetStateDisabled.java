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
package com.yakindu.statemachine.control.highlight.commands;

import java.util.List;


import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.Color;
import org.mda4e.statemachine.contribution.edit.parts.OurStateEditPart;
import org.mda4e.statemachine.contribution.part.OurStatemachineDiagramEditorPlugin;
import org.mda4e.statemachine.contribution.tools.Constants;

/**
 * @author m.muehlbrandt<p>
 * Dieses Kommando setzt einen State inaktiv. Wird vom CommunicationProxy w�hrend
 * der Simulation benutzt.
 *
 */
public class CmdSetStateDisabled extends AbstractTransactionalCommand {

	private OurStateEditPart selectedElement;
	private IPreferenceStore store;
	
	public CmdSetStateDisabled(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles, OurStateEditPart selectedElement) {
		super(domain, label, affectedFiles);
		this.selectedElement=selectedElement;
		store = OurStatemachineDiagramEditorPlugin.getInstance().getPreferenceStore();
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		selectedElement.getPrimaryShape().setBackgroundColor(new Color(null,PreferenceConverter.getColor(store, Constants.P_STATE_BACKGROUND_COLOR)));
		return null;
	}

}
