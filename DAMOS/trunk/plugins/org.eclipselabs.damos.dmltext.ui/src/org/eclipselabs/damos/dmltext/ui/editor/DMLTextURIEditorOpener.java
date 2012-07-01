/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.dmltext.ui.editor;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.ui.editor.LanguageSpecificURIEditorOpener;
import org.eclipse.xtext.ui.editor.XtextReadonlyEditorInput;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public abstract class DMLTextURIEditorOpener extends LanguageSpecificURIEditorOpener {

	private static final Logger logger = Logger.getLogger(LanguageSpecificURIEditorOpener.class);

	@Inject
	private IStorage2UriMapper mapper;

	@Inject(optional = true)
	private IWorkbench workbench;

	@Override
	public IEditorPart open(URI uri, EReference crossReference, int indexInList, boolean select) {
		Iterator<Pair<IStorage, IProject>> storages = mapper.getStorages(uri.trimFragment()).iterator();
		if (storages != null && storages.hasNext()) {
			try {
				IStorage storage = storages.next().getFirst();
				IEditorInput editorInput = (storage instanceof IFile) ? new FileEditorInput((IFile) storage)
						: new XtextReadonlyEditorInput(storage);
				IWorkbenchPage activePage = workbench.getActiveWorkbenchWindow().getActivePage();
				IEditorPart editor = IDE.openEditor(activePage, editorInput, getEditorId());
				selectAndReveal(editor, uri, crossReference, indexInList, select);
				return EditorUtils.getXtextEditor(editor);
			} catch (WrappedException e) {
				logger.error("Error while opening editor part for EMF URI '" + uri + "'", e.getCause());
			} catch (PartInitException partInitException) {
				logger.error("Error while opening editor part for EMF URI '" + uri + "'", partInitException);
			}
		}
		return null;
	}
	
	protected abstract String getEditorId();
	
}
