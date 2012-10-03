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

package org.eclipse.damos.diagram.ui.properties;

import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.common.ui.util.StatusLineUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * @author Andreas Unger
 *
 */
public abstract class CheckboxPropertyCompositeDelegate extends PropertyCompositeDelegate {

	private Button checkboxWidget;
	
	/**
	 * @param widgetFactory
	 */
	public CheckboxPropertyCompositeDelegate(TabbedPropertySheetWidgetFactory widgetFactory) {
		super(widgetFactory);
	}

	public Composite createComposite(Composite parent) {
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		checkboxWidget = createCheckboxWidget(composite);
		checkboxWidget.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				IWorkbenchPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
				StatusLineUtil.outputErrorMessage(part, StringStatics.BLANK);
				updatePropertyValue();
			}
		});
		return composite;
	}
	
	protected Button createCheckboxWidget(Composite parent) {
		Button checkboxWidget = getWidgetFactory().createButton(parent, getLabelText(), SWT.CHECK);
		
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.top = new FormAttachment(0, 0);
		checkboxWidget.setLayoutData(data);
		
		return checkboxWidget;
	}
	
	/**
	 * @return the checkboxWidget
	 */
	public Button getCheckboxWidget() {
		return checkboxWidget;
	}
	
}
