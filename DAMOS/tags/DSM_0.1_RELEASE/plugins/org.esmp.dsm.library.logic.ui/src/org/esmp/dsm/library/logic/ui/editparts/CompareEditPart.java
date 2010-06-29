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

package org.esmp.dsm.library.logic.ui.editparts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;
import org.esmp.dsm.diagram.ui.editparts.LabeledRectangularBlockEditPart;
import org.esmp.dsm.library.logic.util.CompareConstants;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.Parameter;
import org.esmp.dsm.semantic.blockdiagram.util.BlockDiagramUtil;

/**
 * @author Andreas Unger
 *
 */
public class CompareEditPart extends LabeledRectangularBlockEditPart {

	/**
	 * @param view
	 */
	public CompareEditPart(View view) {
		super(view);
	}

	protected String getLabel() {
		String operator = "";
		Block block = (Block) resolveSemanticElement();
		if (block != null) {
			operator = BlockDiagramUtil.getParameterValue(block, CompareConstants.PARAMETER__OPERATOR, operator);
		}
		return operator;
	}
	
	protected void handleNotificationEvent(Notification notification) {
		Object notifier = notification.getNotifier();
		if (notifier instanceof Parameter) {
			String parameterName = ((Parameter) notifier).getName();
			if (CompareConstants.PARAMETER__OPERATOR.equals(parameterName)) {
				refreshLabel();
			}
		}
		super.handleNotificationEvent(notification);
	}

}
