package com.yakindu.statechart.workflow.ui.popup.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import com.yakindu.statechart.workflow.StartWorkflow;

public class WorkflowInitDialogAction extends AbstractHandler {

	private Shell shell;
	private TreeSelection selection;


	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		selection = getSelectedObject(event);
		shell = getShell();
		
		IFile file = (IFile) selection.getFirstElement();
		
		StartWorkflow workflow = new StartWorkflow(shell, file);
		workflow.start();
		return null;
	}

	private static TreeSelection getSelectedObject(final ExecutionEvent event) {
		final ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection != null && selection instanceof TreeSelection
				&& !((TreeSelection) selection).isEmpty()) {

			return (TreeSelection) selection;
		}
		return null;
	}

	private static Shell getShell() {
		if (Display.getCurrent() != null) {
			if (Display.getCurrent().getActiveShell() != null) {
				return Display.getCurrent().getActiveShell();
			}
			return new Shell(Display.getCurrent());
		}
		return null;
	}

}
