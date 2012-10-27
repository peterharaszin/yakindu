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

package org.eclipse.damos.diagram.ui.internal.providers;

/**
 * @author Andreas Unger
 *
 */
public class EditPartProviderDelegate extends AbstractViewEditPartProviderDelegate {

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.internal.services.AbstractNotationMappingService#getExtensionPointName()
	 */
	protected String getExtensionPointName() {
		return "blockEditParts";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.internal.services.AbstractNotationMappingService#getNotationName()
	 */
	protected String getTag() {
		return "editPart";
	}

}
