/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.diagram.ui.editparts;

import org.eclipselabs.damos.common.util.NameUtil;
import org.eclipselabs.damos.diagram.ui.figures.PortFigure;
import org.eclipselabs.damos.dml.BlockInoutput;
import org.eclipselabs.damos.dml.Port;

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
			String name = NameUtil.formatName(inoutput.getName());
			if (inoutput.getDefinition().isManyPorts()) {
				name += " " + Integer.toString(port.getIndex() + 1);
			}
			((PortFigure) editPart.getFigure()).setText(name);
		}
	}

}
