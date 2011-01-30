package org.eclipselabs.damos.codegen.c.ui.internal.handlers;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipselabs.damos.codegen.c.cgenmodel.CGenModel;
import org.eclipselabs.damos.codegen.c.generator.Generator;

public class GenerateCCodeHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		final CGenModel cGenModel = getCGenModel(event);
		
		if (cGenModel == null) {
			throw new ExecutionException("Selected object must be C generator model");
		}
		
		ProgressMonitorDialog d = new ProgressMonitorDialog(HandlerUtil.getActiveShell(event));
		try {
			d.run(true, true, new IRunnableWithProgress() {
				
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					Generator generator = new Generator();
					try {
						generator.generate(cGenModel, monitor);
					} catch (CoreException e) {
						StatusManager.getManager().handle(e.getStatus(), StatusManager.SHOW);
					}
				}
				
			});
		} catch (Exception e) {
			throw new ExecutionException("Generation failed", e);
		}
		return null;
	}
	
	private CGenModel getCGenModel(ExecutionEvent event) {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.getFirstElement() instanceof CGenModel) {
				return (CGenModel) structuredSelection.getFirstElement();
			}
		}
		return null;
	}

}
