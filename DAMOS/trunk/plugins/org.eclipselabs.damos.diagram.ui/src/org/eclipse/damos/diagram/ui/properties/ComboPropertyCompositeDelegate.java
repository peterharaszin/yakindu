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

import java.util.List;

import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.common.ui.util.StatusLineUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * @author Andreas Unger
 *
 */
public abstract class ComboPropertyCompositeDelegate extends TextualPropertyCompositeDelegate {

	private CCombo comboWidget;
	
	/**
	 * @param widgetFactory
	 */
	public ComboPropertyCompositeDelegate(TabbedPropertySheetWidgetFactory widgetFactory) {
		super(widgetFactory);
	}

	protected Composite doCreateComposite(Composite parent) {
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		comboWidget = createComboWidget(composite);
		comboWidget.setEditable(isEditable());
		comboWidget.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				IWorkbenchPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
				StatusLineUtil.outputErrorMessage(part, StringStatics.BLANK);
				updatePropertyValue();
			}
		});
		createLabelWidget(composite, comboWidget);
		return composite;
	}
	
	protected CCombo createComboWidget(Composite parent) {
		CCombo combo = getWidgetFactory().createCCombo(parent, SWT.BORDER | SWT.READ_ONLY);
		
		FormData data = new FormData();
		data.left = new FormAttachment(0, getStandardLabelWidth(parent, getPropertyNameStringsArray()));
		data.top = new FormAttachment(0, 0);
		combo.setLayoutData(data);
		
		for (String value : getPropertyValueStrings()) {
			combo.add(value);
		}
		
		return combo;
	}
	
	/**
	 * @return the comboWidget
	 */
	public CCombo getControl() {
		return comboWidget;
	}
	
	protected abstract List<String> getPropertyValueStrings();

	/**
	 * @return
	 */
	protected boolean isEditable() {
		return false;
	}

}
