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

package org.eclipse.damos.diagram.ui.editparts;

import org.eclipse.damos.diagram.ui.figures.PortFigure;
import org.eclipse.damos.dml.BlockInoutput;
import org.eclipse.damos.dml.Port;
import org.eclipse.damos.dml.util.DMLUtil;

/**
 * @author Andreas Unger
 *
 */
public class NamedBlockPortHelper {
	
	private PortEditPart editPart;
	
	/**
	 * 
	 */
	public NamedBlockPortHelper(PortEditPart editPart) {
		this.editPart = editPart;
	}

	public void refreshName() {
		Port port = (Port) editPart.resolveSemanticElement();
		if (port != null) {
			BlockInoutput inoutput = (BlockInoutput) port.getInoutput();
			String name = DMLUtil.safeFormatName(inoutput);
			if (inoutput.getDefinition().isManyPorts()) {
				name += " " + Integer.toString(port.getIndex() + 1);
			}
			((PortFigure) editPart.getFigure()).setText(name);
		}
	}

}
