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
 * Hebt eine Transition farblich hervor wenn sie gefeuert wird.
 *
 */
public class CmdFireTransition extends AbstractTransactionalCommand {

	private TransitionEditPart selectedElement;
	private IPreferenceStore store;
	private final int time = Constants.transitionHighlightTime/3;
	
	public CmdFireTransition(TransactionalEditingDomain domain, String label, TransitionEditPart selectedElement) {
		super(domain, label, null);
		this.selectedElement=selectedElement;
		store = OurStatemachineDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
	
	private void waiting(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		//((PolylineConnectionEx)selectedElement.getFigure()).setLineWidth(Constants.lineWidths[widthIndex]);
		((PolylineConnectionEx)selectedElement.getFigure()).setLineWidth(store.getInt(Constants.P_TRANSITION_LINE_WIDTH)+2);
		((PolylineConnectionEx)selectedElement.getFigure()).setForegroundColor(new Color(null,PreferenceConverter.getColor(store, Constants.P_TRANSITION_ACTIVE_COLOR)));
		
		new Thread( new Runnable()
		{
			public void run() {
				waiting(time);
				((PolylineConnectionEx)selectedElement.getFigure()).setLineWidth(store.getInt(Constants.P_TRANSITION_LINE_WIDTH)+1);
				waiting(time);
				((PolylineConnectionEx)selectedElement.getFigure()).setLineWidth(store.getInt(Constants.P_TRANSITION_LINE_WIDTH));
				waiting(time);
				((PolylineConnectionEx)selectedElement.getFigure()).setForegroundColor(new Color(null,PreferenceConverter.getColor(store, Constants.P_TRANSITION_COLOR)));
			}
		}).start();
		
		return null;
	}

}
