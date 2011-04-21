package org.eclipselabs.damos.codegen.c.ui.internal.handlers;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenModel;
import org.eclipselabs.damos.codegen.c.generator.Generator;

public class GenerateCCodeHandler extends AbstractHandler {

	private static final String ERROR_MESSAGE = "C Code Generation failed";

	public Object execute(ExecutionEvent event) throws ExecutionException {
		final GenModel cGenModel = getGenModel(event);
		
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
						throw new InvocationTargetException(e);
					}
				}
				
			});
		} catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof CoreException) {
				CoreException targetException = (CoreException) e.getTargetException();
				ErrorDialog.openError(HandlerUtil.getActiveShell(event), "C Code Generation", ERROR_MESSAGE, targetException.getStatus());
			} else {
				throw new ExecutionException(ERROR_MESSAGE, e);
			}
		} catch (InterruptedException e) {
			throw new ExecutionException(ERROR_MESSAGE, e);
		}
		return null;
	}
	
	private GenModel getGenModel(ExecutionEvent event) {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.getFirstElement() instanceof GenModel) {
				return (GenModel) structuredSelection.getFirstElement();
			}
		}
		return null;
	}

}
