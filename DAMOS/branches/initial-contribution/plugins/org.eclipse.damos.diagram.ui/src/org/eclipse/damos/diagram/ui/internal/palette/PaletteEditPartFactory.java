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

package org.eclipse.damos.diagram.ui.internal.palette;

import org.eclipse.damos.diagram.ui.internal.palette.editparts.LinkEditPart;
import org.eclipse.gef.EditPart;

/**
 * @author Andreas Unger
 *
 */
public class PaletteEditPartFactory extends org.eclipse.gef.ui.palette.PaletteEditPartFactory {

	@Override
	public EditPart createEditPart(EditPart parentEditPart, Object model) {
		if (model instanceof LinkEntry) {
			LinkEntry entry = (LinkEntry) model;
			return new LinkEditPart(entry);
		}
		return super.createEditPart(parentEditPart, model);
	}

}
