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
package org.mda4e.statemachine.contribution.providers;

import java.util.Iterator;
import java.util.UUID;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.mda4e.statemachine.contribution.commands.CmdResetIDs;
import org.mda4e.statemachine.contribution.tools.StaticMethods;

import statemachine.diagram.part.StatemachineDiagramEditor;
import statemachine.diagram.part.StatemachineDocumentProvider;

public class OurStatemachineDocumentProvider extends
		StatemachineDocumentProvider {

	public static final String ID = "org.mda4e.statemachine.contribution.providers.OurStatemachineDocumentProvider";

	private void resetID(IProgressMonitor monitor) throws ExecutionException {
		IWorkbenchPage page = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		StatemachineDiagramEditor editor = getEditor(page);
		if (editor != null){
			new CmdResetIDs(editor, "Reset ID", null).execute(
					monitor, null);
		}
	}

	/**
	 * Method for resolve 
	 * @author Benjamin Schwertfeger
	 * @param page
	 * @return
	 */
	private StatemachineDiagramEditor getEditor(IWorkbenchPage page) {
		if (page.getActiveEditor() instanceof StatemachineDiagramEditor) {
			return (StatemachineDiagramEditor) page.getActiveEditor();
		}
		for (IEditorReference editor : page.getEditorReferences()) {
			if (editor.getEditor(true) instanceof StatemachineDiagramEditor) {
				boolean found = false;
				for (Iterator<?> iter = getConnectedElements(); iter.hasNext();) {
					try {
					if (iter.next().equals(editor.getEditorInput())) {
						found = true;
					}
					} catch (PartInitException e){}
				}
				if (found) {
					return (StatemachineDiagramEditor) editor.getEditor(true);
				}
			}
		}
		return null;
	}

	private void setProperties(IProgressMonitor monitor)
			throws ExecutionException {
		final String name;
		int last;
		IWorkbenchPage page = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		final StatemachineDiagramEditor editor = getEditor(page);
		if (editor != null) {
			last = editor.getEditorInput().getName().indexOf('.', 0);
			name = editor.getEditorInput().getName().substring(0, last);

			new AbstractTransactionalCommand(editor.getEditingDomain(),
					"Set UUID", null) {
				protected CommandResult doExecuteWithResult(
						IProgressMonitor arg0, IAdaptable arg1)
						throws ExecutionException {

					StaticMethods.getStatechart(editor).setUUID(
							UUID.randomUUID().toString());
					StaticMethods.getStatechart(editor).setName(name);
					return CommandResult.newOKCommandResult();
				}
			}.execute(monitor, null);
		}
	}

	@Override
	protected void doSaveDocument(IProgressMonitor monitor, Object element,
			IDocument document, boolean overwrite) throws CoreException {
		try {
			resetID(monitor);
			setProperties(monitor);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		super.doSaveDocument(monitor, element, document, overwrite);
	}
}// OurStatemachineDocumentProvider