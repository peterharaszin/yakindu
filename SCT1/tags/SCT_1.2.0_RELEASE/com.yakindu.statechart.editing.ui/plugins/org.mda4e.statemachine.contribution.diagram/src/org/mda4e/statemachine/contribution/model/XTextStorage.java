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

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;

public class XTextStorage implements IStorage {

	private String input;
	
	public XTextStorage(String input){
		this.input = input;
	}
	
	public InputStream getContents() throws CoreException {
		byte[] bArray = input.getBytes();
		return new ByteArrayInputStream(bArray);
		

	}

	public IPath getFullPath() {
		return null;
	}

	public String getName() {
		return "XTextEditorStorageObject";
	}

	public boolean isReadOnly() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	@SuppressWarnings("unchecked") //Suppress ok because return of null
        public Object getAdapter(Class adapter) {
		return null;
	}

}
