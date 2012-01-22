package org.eclipselabs.damos.codegen.ui.internal.handlers;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipselabs.damos.codegen.IGenerator;
import org.eclipselabs.damos.codegen.registry.IGeneratorDescriptor;
import org.eclipselabs.damos.codegen.registry.IGeneratorRegistry;
import org.eclipselabs.damos.codegen.ui.CodegenUIPlugin;
import org.eclipselabs.damos.dconfig.Configuration;

public class GenerateCodeHandler extends AbstractHandler {

	private static final String MESSAGE_DIALOG_TITLE = "Code Generation";
	private static final String ERROR_MESSAGE = "Code Generation failed";

	public Object execute(final ExecutionEvent event) throws ExecutionException {
		ProgressMonitorDialog d = new ProgressMonitorDialog(HandlerUtil.getActiveShell(event));
		try {
			d.run(true, true, new IRunnableWithProgress() {
				
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					try {
						Configuration configuration = getGenModel(event);
						
						if (configuration == null) {
							throw new CoreException(new Status(IStatus.ERROR, CodegenUIPlugin.PLUGIN_ID, "Selected object must contain configuration model"));
						}
						
						String generatorId = configuration.getPropertySelectionName("damos.codegen.generator");
						if (generatorId == null) {
							throw new CoreException(new Status(IStatus.ERROR, CodegenUIPlugin.PLUGIN_ID, "Configuration does not specify generator"));
						}
						
						IGeneratorDescriptor generatorDescriptor = IGeneratorRegistry.INSTANCE.getGenerator(generatorId);
						if (generatorDescriptor == null) {
							throw new CoreException(new Status(IStatus.ERROR, CodegenUIPlugin.PLUGIN_ID, "Generator " + generatorId + " not found"));
						}
						
						IGenerator generator = generatorDescriptor.createGenerator();
						if (generator == null) {
							throw new CoreException(new Status(IStatus.ERROR, CodegenUIPlugin.PLUGIN_ID, "Generator " + generatorId + " could not be created"));
						}

						generator.generate(configuration, monitor);
					} catch (CoreException e) {
						throw new InvocationTargetException(e);
					}
				}
				
			});
		} catch (InvocationTargetException e) {
			IStatus status;
			if (e.getTargetException() instanceof CoreException) {
				CoreException targetException = (CoreException) e.getTargetException();
				status = targetException.getStatus();
			} else {
				status = new Status(IStatus.ERROR, CodegenUIPlugin.PLUGIN_ID, ERROR_MESSAGE, e.getTargetException());
			}
			ErrorDialog.openError(HandlerUtil.getActiveShell(event), MESSAGE_DIALOG_TITLE, ERROR_MESSAGE, status);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		return null;
	}
	
	private Configuration getGenModel(ExecutionEvent event) {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Object firstElement = structuredSelection.getFirstElement();
			if (firstElement instanceof Configuration) {
				return (Configuration) firstElement;
			}
			if (firstElement instanceof IFile) {
				IFile file = (IFile) firstElement;
				URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
				ResourceSet resourceSet = new ResourceSetImpl();
				Resource resource = resourceSet.getResource(uri, true);
				for (EObject o : resource.getContents()) {
					if (o instanceof Configuration) {
						return (Configuration) o;
					}
				}
			}
		}
		return null;
	}

}
