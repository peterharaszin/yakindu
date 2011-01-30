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

package org.eclipselabs.damos.diagram.ui.properties;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipselabs.damos.diagram.ui.internal.util.PropertySectionUtil;

/**
 * @author Andreas Unger
 *
 */
public abstract class LabeledPropertyCompositeDelegate extends PropertyCompositeDelegate {

	/**
	 * @param widgetFactory
	 */
	public LabeledPropertyCompositeDelegate(TabbedPropertySheetWidgetFactory widgetFactory) {
		super(widgetFactory);
	}

	protected CLabel createLabelWidget(Composite parent, Control control) {
		CLabel label = getWidgetFactory().createCLabel(parent, getLabelText());
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(control, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(control, 0, SWT.CENTER);
		label.setLayoutData(data);
		return label;
	}
	
	protected int calculateMinimumLabelWidth(GC gc) {
		return PropertySectionUtil.calculateMinimumLabelWidth(gc);
	}

	protected int getStandardLabelWidth(Composite parent, String[] labels) {
		GC gc = new GC(parent);
		return PropertySectionUtil.calculateStandardLabelWidth(gc, labels, calculateMinimumLabelWidth(gc));
	}

	protected String[] getPropertyNameStringsArray() {
		return new String[] { getLabelText() };
	}

}
