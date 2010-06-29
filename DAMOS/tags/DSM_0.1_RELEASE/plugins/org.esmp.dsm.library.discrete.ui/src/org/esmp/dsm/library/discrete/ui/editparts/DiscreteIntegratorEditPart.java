/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.esmp.dsm.library.discrete.ui.editparts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;
import org.esmp.dsm.library.basic.ui.editparts.FractionBlockEditPart;
import org.esmp.dsm.library.discrete.util.DiscreteIntegratorConstants;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.Parameter;
import org.esmp.dsm.semantic.blockdiagram.util.BlockDiagramUtil;

/**
 * @author Andreas Unger
 *
 */
public class DiscreteIntegratorEditPart extends FractionBlockEditPart {

	/**
	 * @param view
	 */
	public DiscreteIntegratorEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.library.basic.ui.editparts.FractionBlockEditPart#getNumerator()
	 */
	protected String getNumerator() {
		Block block = (Block) resolveSemanticElement();
		if (block != null) {
			double gain = BlockDiagramUtil.getParameterValueAsDouble(block, DiscreteIntegratorConstants.PARAMETER__GAIN, 1);
			boolean accumulation = BlockDiagramUtil.getParameterValueAsBoolean(block, DiscreteIntegratorConstants.PARAMETER__ACCUMULATION, false);
			if (gain == 1 && accumulation) {
				return "1";
			}
			if (gain != 1 && accumulation) {
				return "K";
			}
			if (gain == 1 && !accumulation) {
				return "Ts";
			}
		}
		return "K Ts";
	}
		
	/* (non-Javadoc)
	 * @see org.esmp.dsm.library.basic.ui.editparts.FractionBlockEditPart#getDenominator()
	 */
	protected String getDenominator() {
		return "z-1";
	}

	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.ui.editparts.BlockEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 */
	protected void handleNotificationEvent(Notification notification) {
		Object notifier = notification.getNotifier();
		if (notifier instanceof Parameter) {
			String parameterName = ((Parameter) notifier).getName();
			if (DiscreteIntegratorConstants.PARAMETER__GAIN.equals(parameterName)
					|| DiscreteIntegratorConstants.PARAMETER__ACCUMULATION.equals(parameterName)) {
				refreshNumerator();
			}
		}
		super.handleNotificationEvent(notification);
	}

}
