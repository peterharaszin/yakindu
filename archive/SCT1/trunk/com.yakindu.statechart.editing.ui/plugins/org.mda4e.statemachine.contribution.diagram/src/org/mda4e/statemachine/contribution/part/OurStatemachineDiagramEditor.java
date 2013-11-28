/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.mda4e.statemachine.contribution.part;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.mda4e.statemachine.contribution.edit.parts.OurTreeEditpartFactory;
import org.mda4e.statemachine.contribution.providers.OurStatemachineDocumentProvider;

import statemachine.diagram.part.StatemachineDiagramEditor;

public class OurStatemachineDiagramEditor extends StatemachineDiagramEditor {

	public static final String ID = "org.mda4e.statemachine.contribution.part.OurStatemachineDiagramEditorID";
	
	public OurStatemachineDiagramEditor() {
		super();
	}

	protected void setDocumentProvider(IEditorInput input) {
		if (input instanceof IFileEditorInput
				|| input instanceof URIEditorInput) {
			setDocumentProvider(new OurStatemachineDocumentProvider());
		} else {
			super.setDocumentProvider(input);
		}
	}
	
	protected EditPartFactory getOutlineViewEditPartFactory(){
		return new OurTreeEditpartFactory();
	}
	
}
