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
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

import statemachine.diagram.part.StatemachineDiagramEditor;

public class CmdEditorLock extends AbstractTransactionalCommand {
	
	private StatemachineDiagramEditor editor;
	
	public CmdEditorLock(String label, List<IFile> affectedFiles, StatemachineDiagramEditor editor) {
		super(editor.getEditingDomain(), label, affectedFiles);
		this.editor = editor;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor arg0,
			IAdaptable arg1) throws ExecutionException {
		List<?> children = editor.getDiagramEditPart().getChildren();
		for (int i=0;i<children.size();i++) {
			ShapeNodeEditPart region = (ShapeNodeEditPart)children.get(i);
			region.disableEditMode();
		}
		
		return CommandResult.newOKCommandResult();
	}

}
