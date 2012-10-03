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

package org.eclipse.damos.common.ui.util;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Control;

/**
 * @author Andreas Unger
 *
 */
public class UIUtil {
	
	public static int getToggleButtonIndentInPixels(Control control) {
		return getMediumIndentInPixels(control);
	}

	public static int getIndentInPixels(Control control) {
		return convertHorizontalDLUsToPixels(control, IDialogConstants.INDENT);
	}
	
	public static int getMediumIndentInPixels(Control control) {
		return convertHorizontalDLUsToPixels(control, (IDialogConstants.INDENT + IDialogConstants.SMALL_INDENT) / 2);
	}

	public static int getSmallIndentInPixels(Control control) {
		return convertHorizontalDLUsToPixels(control, IDialogConstants.SMALL_INDENT);
	}

	public static int convertHorizontalDLUsToPixels(Control control, int dlus) {
		return Dialog.convertHorizontalDLUsToPixels(getFontMetrics(control), dlus);
	}
	
	public static int convertVerticalDLUsToPixels(Control control, int dlus) {
		return Dialog.convertVerticalDLUsToPixels(getFontMetrics(control), dlus);
	}

	public static FontMetrics getFontMetrics(Control control) {
		GC gc = new GC(control);
		gc.setFont(control.getFont());
		FontMetrics fontMetrics = gc.getFontMetrics();
		gc.dispose();
		return fontMetrics;
	}
	
}
