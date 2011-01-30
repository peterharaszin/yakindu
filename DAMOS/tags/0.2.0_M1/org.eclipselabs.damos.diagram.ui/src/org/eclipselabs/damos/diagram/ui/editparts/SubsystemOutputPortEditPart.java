/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.diagram.ui.editparts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.figures.PortFigure;
import org.eclipselabs.damos.dml.Outlet;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.SubsystemOutput;

/**
 * @author Andreas Unger
 *
 */
public class SubsystemOutputPortEditPart extends OutputPortEditPart {

	/**
	 * @param view
	 */
	public SubsystemOutputPortEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.editparts.PortEditPart#refreshVisuals()
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshName();
	}
	
	protected void refreshName() {
		EObject element = resolveSemanticElement();
		if (element instanceof OutputPort) {
			OutputPort outputPort = (OutputPort) element;
			if (outputPort.getOutput() instanceof SubsystemOutput) {
				Outlet outlet = ((SubsystemOutput) outputPort.getOutput()).getOutlet();
				if (outlet != null) {
					((PortFigure) getFigure()).setText(outlet != null ? outlet.getName() : "");
				}
			}
		}
	}

}
