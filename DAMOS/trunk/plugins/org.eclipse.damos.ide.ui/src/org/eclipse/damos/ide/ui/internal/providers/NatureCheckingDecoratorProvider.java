package org.eclipse.damos.ide.ui.internal.providers;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.ide.ui.IDEUIPlugin;
import org.eclipse.damos.ide.ui.internal.util.DamosProjectUtil;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.ui.XtextProjectHelper;

public class NatureCheckingDecoratorProvider extends AbstractProvider implements IDecoratorProvider {

	public boolean provides(IOperation operation) {
		if (!(operation instanceof CreateDecoratorsOperation)) {
			return false;
		}
		
		IDecoratorTarget decoratorTarget = ((CreateDecoratorsOperation) operation).getDecoratorTarget();
		DiagramEditPart diagramEditPart = (DiagramEditPart) decoratorTarget.getAdapter(DiagramEditPart.class);
		if (diagramEditPart != null) {
			return diagramEditPart.getAdapter(Fragment.class) != null;
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider#createDecorators(org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget)
	 */
	public void createDecorators(IDecoratorTarget decoratorTarget) {
		final IProject project = getProject(decoratorTarget);
		if (project != null) {
			try {
				IProjectNature nature = project.getNature(XtextProjectHelper.NATURE_ID);
				if (nature == null) {
					final Shell shell = getShell(decoratorTarget);
					if (shell != null) {
						shell.getDisplay().asyncExec(new Runnable() {
							
							public void run() {
								if (!shell.isDisposed()) {
									String message = "The project '%s' does not have a required project nature applied. Various features like model validation will not work without the project nature. It is strongly recommended to add the project nature.\n\nDo you want to add the required project nature?";
									if (MessageDialog.openQuestion(shell, "Damos", String.format(message, project.getName()))) {
										try {
											DamosProjectUtil.applyProjectNature(project, XtextProjectHelper.NATURE_ID);
										} catch (CoreException e) {
											ErrorDialog.openError(shell, "Damos", "Adding project nature failed", e.getStatus());
										}
									}
								}
							}
							
						});
					}
				}
			} catch (CoreException e) {
				IDEUIPlugin.getDefault().getLog().log(e.getStatus());
			}
		}
	}
	
	private IProject getProject(IDecoratorTarget decoratorTarget) {
		Fragment fragment = (Fragment) decoratorTarget.getAdapter(Fragment.class);
		if (fragment != null) {
			Resource resource = fragment.eResource();
			if (resource != null) {
				IPath path = new Path(resource.getURI().toPlatformString(true));
				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
				if (file.exists()) {
					final IProject project = file.getProject();
					if (project != null && project.isOpen()) {
						return project;
					}
				}
			}
		}
		return null;
	}
	
	private Shell getShell(IDecoratorTarget decoratorTarget) {
		EditPart editPart = (EditPart) decoratorTarget.getAdapter(EditPart.class);
		if (editPart instanceof IGraphicalEditPart) {
			EditPartViewer viewer = ((IGraphicalEditPart) editPart).getViewer();
			return viewer.getControl().getShell();
		}
		return null;
	}

}
