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
package org.mda4e.statemachine.contribution.model;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.IStorageEditorInput;

import statemachine.Transition;

public class XTextStorageEditorInput implements IStorageEditorInput {
	
	private Transition transition;
	
	public XTextStorageEditorInput(Transition transition){
		this.transition = transition;
	}
	
	public IStorage getStorage() throws CoreException {
		if (transition.getExpression()!=null)
			return new XTextStorage(transition.getExpression());
		else 
			return new XTextStorage("");
	}

	public boolean exists() {
		return false;
	}

	public ImageDescriptor getImageDescriptor() {
		return ImageDescriptor.getMissingImageDescriptor();
	}

	public String getName() {
		return "XTextEditor for expressions";
	}

	public IPersistableElement getPersistable() {
		return null;
	}

	public String getToolTipText() {
		return "Greetings to MDA4E Team!!!";
	}

	@SuppressWarnings("unchecked") //Suppress ok because return of null
	public Object getAdapter(Class adapter) {
		return null;
	}
}