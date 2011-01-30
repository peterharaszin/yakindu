package org.eclipselabs.damos.diagram.ui.internal.handlers;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.Inlet;
import org.eclipselabs.damos.dml.Inport;
import org.eclipselabs.damos.dml.Outlet;
import org.eclipselabs.damos.dml.Outport;
import org.eclipselabs.damos.dml.SystemInterface;

public class ExtractInterfaceHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (!structuredSelection.isEmpty()) {
				Object element = structuredSelection.getFirstElement();
				if (element instanceof Fragment) {
					Fragment fragment = (Fragment) element;
					SaveAsDialog d = new SaveAsDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
					IFile defaultFile = getDefaultTargetFile(fragment);
					if (defaultFile != null) {
						d.setOriginalFile(defaultFile);
					}
					d.open();
					IPath path = d.getResult();
					if (path != null) {
						createInterfaceFile(path, fragment); 
					}
				}
			}
		}
		return null;
	}

	/**
	 * @param fragment
	 * @param d
	 */
	private IFile getDefaultTargetFile(Fragment fragment) {
		IFile file = null;
		if (fragment.eResource() != null) {
			Resource resource = fragment.eResource();
			if (resource.getURI() != null) {
				URI uri = resource.getURI();
				if (uri.isPlatformResource()) {
					IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
					file = root.getFile(new Path(uri.toPlatformString(false)).removeFileExtension()
							.addFileExtension("interface").addFileExtension("dml"));
				}
			}
		}
		return file;
	}
	
	private void createInterfaceFile(IPath path, Fragment fragment) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IFile file = root.getFile(path);
		SystemInterface systemInterface = DMLFactory.eINSTANCE.createSystemInterface();
		systemInterface.setName(fragment.getName());
		for (Component component : fragment.getAllComponents()) {
			if (component instanceof Inport) {
				Inport inport = (Inport) component;
				Inlet inlet = DMLFactory.eINSTANCE.createInlet();
				inlet.setName(inport.getName());
				if (inport.getDataType() != null) {
					inlet.setDataType(EcoreUtil.copy(inport.getDataType()));
				}
				systemInterface.getInlets().add(inlet);
			} else if (component instanceof Outport) {
				Outport outport = (Outport) component;
				Outlet outlet = DMLFactory.eINSTANCE.createOutlet();
				outlet.setName(component.getName());
				systemInterface.getOutlets().add(outlet);
				if (outport.getDataType() != null) {
					outlet.setDataType(EcoreUtil.copy(outport.getDataType()));
				}
			}
		}
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createPlatformResourceURI(file.getFullPath().toString(), true));
		resource.getContents().add(systemInterface);
		try {
			resource.save(null);
		} catch (IOException e) {
			MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Save File", "Saving file '" + file.getName() + "' failed.");
		}
	}
	
}
