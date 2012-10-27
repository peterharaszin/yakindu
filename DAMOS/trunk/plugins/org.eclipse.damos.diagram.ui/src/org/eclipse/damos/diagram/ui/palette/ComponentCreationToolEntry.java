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

package org.eclipse.damos.diagram.ui.palette;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.ui.IEditorPart;

/**
 * @author Andreas Unger
 * 
 */
public class ComponentCreationToolEntry extends CombinedTemplateCreationEntry {

	private IEditorPart editor;
	private EditingDomain editingDomain;

	public ComponentCreationToolEntry(IEditorPart editor, String label, String shortDescription) {
		super(label, shortDescription, null, null, null, null);

		IEditingDomainProvider editingDomainProvider = (IEditingDomainProvider) editor.getAdapter(IEditingDomainProvider.class);
		if (editingDomainProvider == null) {
			throw new IllegalArgumentException("Editor does not provide editing domain");
		}

		this.editor = editor;
		this.editingDomain = editingDomainProvider.getEditingDomain();
		
		setTemplate(this);
	}
	
	/**
	 * @return the editor
	 */
	protected IEditorPart getEditor() {
		return editor;
	}
	
	/**
	 * @return the editingDomain
	 */
	protected EditingDomain getEditingDomain() {
		return editingDomain;
	}

}
