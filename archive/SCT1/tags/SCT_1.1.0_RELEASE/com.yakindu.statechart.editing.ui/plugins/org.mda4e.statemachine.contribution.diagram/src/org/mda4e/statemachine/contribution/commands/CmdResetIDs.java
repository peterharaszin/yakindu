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

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.mda4e.statemachine.contribution.tools.StaticMethods;

import statemachine.Node;
import statemachine.Region;
import statemachine.State;
import statemachine.Transition;
import statemachine.diagram.part.StatemachineDiagramEditor;

public class CmdResetIDs extends AbstractTransactionalCommand {

	StatemachineDiagramEditor editor;
	
	public CmdResetIDs(StatemachineDiagramEditor editor, String label, List<IFile> affectedFiles) {
		super(editor.getEditingDomain(), label, affectedFiles);
		this.editor = editor;
	}
	
	private int resetStateID(EList<Region> list,int startID){
		int id=startID;
		
		if (list!=null) {
			//�ber Regions iterieren
			for (int i=0;i<list.size();i++){
				Region region = (Region) list.get(i);
				//�ber Nodes iterieren
				for (int j=0;j<region.getState().size();j++){
					Node node = (Node) region.getState().get(j);
					node.setId(id);
					id++;
					if (region.getState().get(j) instanceof State) {
						State state = (State) region.getState().get(j);
						id=resetStateID(state.getRegion(),id);
					}
				}//end for f�r States
			}//end for f�r Regions
		}//end der Abbruchbedingung der Rekursion
		return id;
	}
	
	private int resetTransitionID(EList <Transition> list, int startID){
		int id=startID;
		if (list != null){
			for (int i=0;i<list.size();i++){
				Transition transition = list.get(i);
				transition.setId(id);
				id++;
			}
		}
		return id;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		resetTransitionID(StaticMethods.getStatechart(editor).getTransition(), resetStateID(StaticMethods.getStatechart(editor).getRegion(), 0));
		return CommandResult.newOKCommandResult();
	}
}