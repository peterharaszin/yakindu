/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.diagram.ui.internal.providers;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * @author Andreas Unger
 *
 */
public class FileBlockTypeProvider extends AbstractFileBlockTypeProvider {
	/**
	 * 
	 */
	private final IFile file;

	/**
	 * @param editingDomain
	 * @param file
	 */
	public FileBlockTypeProvider(EditingDomain editingDomain, IFile file) {
		super(editingDomain);
		this.file = file;
	}

	protected IFile getFile() {
		return file;
	}
}