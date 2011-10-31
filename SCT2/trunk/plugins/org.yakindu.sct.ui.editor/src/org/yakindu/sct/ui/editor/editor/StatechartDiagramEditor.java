/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.editor;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.ViewportAwareConnectionLayerClippingStrategy;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.gmf.runtime.common.ui.services.marker.MarkerNavigationService;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.help.IWorkbenchHelpSystem;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.breadcrumb.BreadcrumbDiagramEditor;
import org.yakindu.sct.ui.editor.utils.IYakinduSctHelpContextIds;
import org.yakindu.sct.ui.editor.validation.ValidationAction;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author martin esser
 */
public class StatechartDiagramEditor extends BreadcrumbDiagramEditor implements
		IGotoMarker {

	public static final String ID = "org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor";

	// Listenes the ResourceSet for semantic changes
	private ResourceSetListener validationListener = new ResourceSetListenerImpl() {
		@Override
		public void resourceSetChanged(ResourceSetChangeEvent event) {
			validate();
		}
	};

	public StatechartDiagramEditor() {
		super(true);
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		super.init(site, input);
		getEditingDomain().addResourceSetListener(validationListener);
		checkXtextNature();
	}

	private void checkXtextNature() {
		IProject project = getEditorInput().getFile().getProject();
		if (project != null && !XtextProjectHelper.hasNature(project)
				&& project.isAccessible() && !project.isHidden()) {
			String title = "Add Xtext Nature";
			String message = "Do you want to add the Xtext nature to the project '"
					+ project.getName() + "'?";

			MessageDialog dialog = new MessageDialog(
					getEditorSite().getShell(), title, null, message,
					MessageDialog.QUESTION, new String[] {
							IDialogConstants.YES_LABEL,
							IDialogConstants.NO_LABEL,
							IDialogConstants.CANCEL_LABEL }, 0);
			int open = dialog.open();
			if (open == 0) {
				toggleNature(project);
			}
		}
	}

	public void toggleNature(IProject project) {
		try {
			IProjectDescription description = project.getDescription();
			String[] natures = description.getNatureIds();

			for (int i = 0; i < natures.length; ++i) {
				if (XtextProjectHelper.NATURE_ID.equals(natures[i])) {
					// Remove the nature
					String[] newNatures = new String[natures.length - 1];
					System.arraycopy(natures, 0, newNatures, 0, i);
					System.arraycopy(natures, i + 1, newNatures, i,
							natures.length - i - 1);
					description.setNatureIds(newNatures);
					project.setDescription(description, null);
					return;
				}
			}

			// Add the nature
			String[] newNatures = new String[natures.length + 1];
			System.arraycopy(natures, 0, newNatures, 0, natures.length);
			newNatures[natures.length] = XtextProjectHelper.NATURE_ID;
			description.setNatureIds(newNatures);
			project.setDescription(description, null);
		} catch (CoreException e) {
			DiagramActivator
					.getDefault()
					.getLog()
					.log(new Status(IStatus.ERROR, DiagramActivator.PLUGIN_ID,
							"Xtext nature can't be added", e));
		}
	}

	@Override
	protected void sanityCheckState(IEditorInput input) {
		super.sanityCheckState(input);
		validate();
	}

	protected void validate() {
		if (getDiagram() != null) {
			ValidationAction.validate(getDiagramEditPart(), getDiagram());
		}
	}

	public void gotoMarker(IMarker marker) {
		MarkerNavigationService.getInstance().gotoMarker(this, marker);
	}

	@Override
	protected PreferencesHint getPreferencesHint() {
		return DiagramActivator.DIAGRAM_PREFERENCES_HINT;
	}

	@Override
	protected void createGraphicalViewer(Composite parent) {
		super.createGraphicalViewer(parent);
		// Tag the viewer with the desired help context id
		IWorkbenchHelpSystem helpSystem = PlatformUI.getWorkbench()
				.getHelpSystem();
		helpSystem.setHelp(getGraphicalViewer().getControl(),
				IYakinduSctHelpContextIds.SC_EDITOR_GRAPHICAL_VIEWER);
	}

	@Override
	public String getContributorId() {
		return ID;
	}

	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		RootEditPart rootEditPart = getDiagramGraphicalViewer()
				.getRootEditPart();
		// set clipping strategy for connection layer
		if (rootEditPart instanceof LayerManager) {
			ConnectionLayer connectionLayer = (ConnectionLayer) ((LayerManager) rootEditPart)
					.getLayer(LayerConstants.CONNECTION_LAYER);
			connectionLayer
					.setClippingStrategy(new ViewportAwareConnectionLayerClippingStrategy(
							connectionLayer));
		}
	}

	@Override
	public void dispose() {
		getEditingDomain().removeResourceSetListener(validationListener);
		super.dispose();
	}
}
