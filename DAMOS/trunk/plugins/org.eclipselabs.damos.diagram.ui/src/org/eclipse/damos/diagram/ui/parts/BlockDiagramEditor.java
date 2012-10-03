/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.diagram.ui.parts;

import org.eclipse.core.resources.IFile;
import org.eclipse.damos.common.ecore.util.WorkspaceSynchronizer;
import org.eclipse.damos.diagram.ui.internal.dnd.LocalTransferDropTargetListener;
import org.eclipse.damos.diagram.ui.internal.dnd.ResourceTransferDropTargetListener;
import org.eclipse.damos.diagram.ui.internal.dnd.ToolTransferDropTargetListener;
import org.eclipse.damos.diagram.ui.internal.palette.PaletteViewerProvider;
import org.eclipse.damos.dml.ui.properties.ContributorId;
import org.eclipse.damos.dml.util.FragmentSelectionManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.editor.FileDiagramEditorWithFlyoutPalette;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;

import com.google.inject.Inject;

public class BlockDiagramEditor extends FileDiagramEditorWithFlyoutPalette {

	private final String contributorId;
	private final PreferencesHint preferencesHint;
	private WorkspaceSynchronizer workspaceSynchronizer;
	
	/**
	 * 
	 */
	@Inject
	BlockDiagramEditor(@ContributorId String contributorId, PreferencesHint preferencesHint) {
		this.contributorId = contributorId;
		this.preferencesHint = preferencesHint;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor#getContributorId()
	 */
	public String getContributorId() {
		return contributorId;
	}
	
	protected PreferencesHint getPreferencesHint() {
		return preferencesHint;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor#getAdapter(java.lang.Class)
	 */
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class type) {
		if (type == FragmentSelectionManager.class) {
			return getDiagramEditPart().getAdapter(type);
		}
		return super.getAdapter(type);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorWithFlyOutPalette#createPaletteViewerProvider()
	 */
	@Override
	protected PaletteViewerProvider createPaletteViewerProvider() {
		DefaultEditDomain editDomain = getEditDomain();
		editDomain.setPaletteRoot(createPaletteRoot(null));
		return new PaletteViewerProvider(editDomain);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor#init(org.eclipse.ui.IEditorSite, org.eclipse.ui.IEditorInput)
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		workspaceSynchronizer = new WorkspaceSynchronizer(getEditingDomain(), getResource());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor#configureGraphicalViewer()
	 */
	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		getGraphicalViewer().addDropTargetListener(new ToolTransferDropTargetListener(getGraphicalViewer()));
		getGraphicalViewer().addDropTargetListener(new LocalTransferDropTargetListener(getGraphicalViewer(), getEditingDomain(), getPreferencesHint()));
		getGraphicalViewer().addDropTargetListener(new ResourceTransferDropTargetListener(getGraphicalViewer(), getEditingDomain(), getPreferencesHint()));
	}
	
	private Resource getResource() {
		IFile file = getFile();
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		Resource resource = getEditingDomain().getResourceSet().getResource(uri, false);
		return resource;
	}

	/**
	 * @return
	 */
	private IFile getFile() {
		IFileEditorInput input = (IFileEditorInput) getEditorInput();
		IFile file = input.getFile();
		return file;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor#dispose()
	 */
	@Override
	public void dispose() {
		if (workspaceSynchronizer != null) {
			workspaceSynchronizer.dispose();
			workspaceSynchronizer = null;
		}
		super.dispose();
	}
	
}
