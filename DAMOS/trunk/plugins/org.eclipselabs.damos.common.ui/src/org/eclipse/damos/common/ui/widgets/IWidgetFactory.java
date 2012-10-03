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

package org.eclipse.damos.common.ui.widgets;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Hyperlink;

/**
 * @author Andreas Unger
 *
 * @noextend
 * @noimplement
 */
public interface IWidgetFactory {

	Composite createComposite(Composite parent);
	Composite createComposite(Composite parent, int style);
	
	Text createText(Composite parent, String value);
	Text createText(Composite parent, String value, int style);
	
	Label createLabel(Composite parent, String text);
	Label createLabel(Composite parent, String text, int style);
	
	Hyperlink createHyperlink(Composite parent, String text, int style);
	
	Button createButton(Composite parent, String text, int style);
	
}
