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

package org.eclipse.damos.diagram.ui.internal.handlers;

import org.eclipse.jface.dialogs.IInputValidator;

class QualifiedNameValidator implements IInputValidator {

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IInputValidator#isValid(java.lang.String)
	 */
	public String isValid(String newText) {
		if (!RenameFragmentHandler.QUALIFIED_NAME_PATTERN.matcher(newText).matches() || newText.contains("__")) {
			return "Invalid qualified name";
		}
		return null;
	}
	
}