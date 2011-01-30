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

import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * @author Andreas Unger
 *
 */
public abstract class TextPropertyCompositeDelegate extends TextualPropertyCompositeDelegate {

	private Text textWidget;

	/**
	 * @param widgetFactory
	 */
	public TextPropertyCompositeDelegate(TabbedPropertySheetWidgetFactory widgetFactory) {
		super(widgetFactory);
	}

	protected Composite doCreateComposite(Composite parent) {
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		textWidget = createTextWidget(composite);
		createLabelWidget(composite, textWidget);
		return composite;
	}
	
	protected Text createTextWidget(Composite parent) {
		Text text = getWidgetFactory().createText(parent, StringStatics.BLANK);
		
		FormData data = new FormData();
		data.left = new FormAttachment(0, getStandardLabelWidth(parent, getPropertyNameStringsArray()));
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, 0);
		text.setLayoutData(data);
		
		return text;
	}

	public Text getControl() {
		return textWidget;
	}
	
}
