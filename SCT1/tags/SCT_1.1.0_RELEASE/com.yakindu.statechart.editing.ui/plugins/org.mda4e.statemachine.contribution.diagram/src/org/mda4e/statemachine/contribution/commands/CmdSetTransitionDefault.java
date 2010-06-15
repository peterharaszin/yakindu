/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.mda4e.statemachine.contribution.commands;


import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.Color;
import org.mda4e.statemachine.contribution.part.OurStatemachineDiagramEditorPlugin;
import org.mda4e.statemachine.contribution.tools.Constants;

import statemachine.diagram.edit.parts.TransitionEditPart;

/**
 * @author m.muehlbrandt<p>
 * 
 *
 */
public class CmdSetTransitionDefault extends AbstractTransactionalCommand {

	private TransitionEditPart selectedElement;
	private IPreferenceStore store;
	
	public CmdSetTransitionDefault(TransactionalEditingDomain domain, String label, TransitionEditPart selectedElement) {
		super(domain, label, null);
		this.selectedElement=selectedElement;
		store = OurStatemachineDiagramEditorPlugin.getInstance().getPreferenceStore();
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		changePolyline((PolylineConnectionEx)selectedElement.getFigure());
		return null;
	}
	
	private void changePolyline(PolylineConnectionEx line){
		line.setLineWidth(store.getInt(Constants.P_TRANSITION_LINE_WIDTH));
		line.setForegroundColor(new Color(null,PreferenceConverter.getColor(store, Constants.P_TRANSITION_COLOR)));
		//line.setSmoothness(store.getInt(Constants.P_TRANSITION_SMOTHNESS));
	}
}
