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
import org.eclipse.gmf.runtime.diagram.ui.properties.views.TextChangeHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * @author Andreas Unger
 *
 */
public abstract class TextualPropertyCompositeDelegate extends LabeledPropertyCompositeDelegate {

	/**
	 * A helper to listen for events that indicate that a text field has been
	 * changed.
	 */
	private TextChangeHelper listener = new TextChangeHelper() {
		boolean textModified = false;
		/**
		 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
		 */
		public void handleEvent(Event event) {
			if (event.type == SWT.KeyDown) {
				textModified = true;
			}
			super.handleEvent(event);
		}
		
		public void textChanged(Control control) {
			if (textModified) {
				IWorkbenchPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
				StatusLineUtil.outputErrorMessage(part, StringStatics.BLANK);

				updatePropertyValue();

				textModified = false;
			}
		}		
	};

	/**
	 * @param widgetFactory
	 */
	public TextualPropertyCompositeDelegate(TabbedPropertySheetWidgetFactory widgetFactory) {
		super(widgetFactory);
	}

	public Composite createComposite(Composite parent) {
		Composite composite = doCreateComposite(parent);
		listener.startListeningTo(getControl());
		listener.startListeningForEnter(getControl());
		return composite;
	}
	
	protected abstract Composite doCreateComposite(Composite parent);
	
	public abstract Control getControl();
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.properties.AbstractPropertySectionDelegate#dispose()
	 */
	public void dispose() {
		listener.stopListeningTo(getControl());
	}
	
}
