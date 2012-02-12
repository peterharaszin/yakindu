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

package org.eclipselabs.damos.ide.ui.internal.util;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipselabs.damos.ide.ui.IDEUIPlugin;

/**
 * @author Andreas Unger
 *
 */
public class IDEUtil {

	public static TransactionalEditingDomain findEditorEditingDomain(URI uri) {
		IPath path = new Path(uri.toPlatformString(true));
		IResource member = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
		if (!(member instanceof IFile)) {
			return null;
		}
		
		IFile file = (IFile) member;
		
		FileEditorInput editorInput = new FileEditorInput(file);
		for (IEditorReference editorReference : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences()) {
			try {
				if (editorInput.equals(editorReference.getEditorInput())) {
					IEditorPart editor = editorReference.getEditor(true);
					if (editor != null) {
						IEditingDomainProvider editingDomainProvider = (IEditingDomainProvider) editor.getAdapter(IEditingDomainProvider.class);
						if (editingDomainProvider != null && editingDomainProvider.getEditingDomain() instanceof TransactionalEditingDomain) {
							return (TransactionalEditingDomain) editingDomainProvider.getEditingDomain();
						}
					}
				}
			} catch (PartInitException e) {
				IDEUIPlugin.getDefault().getLog().log(e.getStatus());
			}
		}
		
		return null;
	}

}
