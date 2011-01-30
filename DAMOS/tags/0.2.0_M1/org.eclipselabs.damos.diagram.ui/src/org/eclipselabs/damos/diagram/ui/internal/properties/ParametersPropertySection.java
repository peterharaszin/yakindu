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

package org.eclipselabs.damos.diagram.ui.internal.properties;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipselabs.damos.diagram.ui.properties.ParametersPropertySectionDelegate;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Component;

/**
 * @author Andreas Unger
 * 
 */
public class ParametersPropertySection extends AbstractModelerPropertySection {

	private Composite sectionComposite;
	private Component component;
	private ParametersPropertySectionDelegate delegate;
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection#createControls(org.eclipse.swt.widgets.Composite, org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		sectionComposite = getWidgetFactory().createPlainComposite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		sectionComposite.setLayout(layout);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	public void refresh() {
		executeAsReadAction(new Runnable() {
			public void run() {
				refreshUI();
			}
		});
	}
	
	protected void refreshUI() {
		IGraphicalEditPart editPart = (IGraphicalEditPart) getPrimarySelection();
		if (editPart != null) {
			EObject element = editPart.resolveSemanticElement();
			if (element instanceof Block) {
				Block block = (Block) element;
				if (delegate == null || this.component != block) {
					if (delegate != null) {
						delegate.dispose();
					}
					delegate = (ParametersPropertySectionDelegate) editPart.getAdapter(ParametersPropertySectionDelegate.class);

					for (Control control : sectionComposite.getChildren()) {
						control.dispose();
					}
					delegate.createControls(sectionComposite, getWidgetFactory(), block);
					sectionComposite.layout();
					
					this.component = block;
				}
				delegate.refreshParameters(block);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection#dispose()
	 */
	public void dispose() {
		super.dispose();
		if (delegate != null) {
			delegate.dispose();
			delegate = null;
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#shouldUseExtraSpace()
	 */
	public boolean shouldUseExtraSpace() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection#isCurrentSelection(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EObject)
	 */
	protected boolean isCurrentSelection(Notification notification, EObject element) {
		return element instanceof Argument;
	}
	
}
