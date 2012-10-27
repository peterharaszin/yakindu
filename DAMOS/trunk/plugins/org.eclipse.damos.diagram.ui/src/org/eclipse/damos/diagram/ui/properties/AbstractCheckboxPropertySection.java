/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.diagram.ui.properties;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractCheckboxPropertySection extends AbstractModelerPropertySection {

	private CheckboxPropertyCompositeDelegate delegate;

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#createControls(org.eclipse.swt.widgets.Composite, org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		delegate = new CheckboxPropertyCompositeDelegate(getWidgetFactory()) {
			
			protected String getLabelText() {
				return getPropertyNameLabel();
			}

			protected void updatePropertyValue() {
				AbstractCheckboxPropertySection.this.updatePropertyValue();
			}
			
		};
		delegate.createComposite(parent);
	}
	
	/**
	 * User changed the value in the checkbox box - update the model
	 * 
	 * @param control <code>Control</code>
	 */
	@SuppressWarnings("unchecked")
	protected synchronized void updatePropertyValue() {
		final Object value = computeNewPropertyValue();
		ArrayList<ICommand> commands = new ArrayList<ICommand>();
		for (final EObject o : (List<EObject>) getEObjectList()) {
			commands.add(createCommand(getPropertyChangeCommandName(), o, new Runnable() {
				public void run() {
					setPropertyValue(o, value);
				}
			}));
		}

		executeAsCompositeCommand(getPropertyChangeCommandName(), commands);
		refresh();
	}

	/**
	 * @return - a default implementation returns text of the checkbox widget as
	 *         a new value for the property. Subclasses can override.
	 */
	protected Object computeNewPropertyValue() {
		return delegate.getCheckboxWidget().getSelection();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
	 */
	public void refresh() {
		executeAsReadAction(new Runnable() {
			public void run() {
				refreshUI();
			}
		});
	}

	/**
	 * Refresh UI body - refresh will surround this with read action block
	 */
	protected void refreshUI() {
		delegate.getCheckboxWidget().setSelection(getPropertyValueBoolean());
	}

	/**
	 * @return - name of the property to place in the label widget
	 */
	protected abstract String getPropertyNameLabel();

	/**
	 * @return the property value
	 */
	protected abstract boolean getPropertyValueBoolean();

	/**
	 * Set property value for the given object
	 * 
	 * @param object -
	 *            owner of the property
	 * @param value -
	 *            new value
	 */
	protected abstract void setPropertyValue(EObject object, Object value);

	/**
	 * @return - title of the command which will be executed to set the property
	 */
	protected abstract String getPropertyChangeCommandName();
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection#dispose()
	 */
	public void dispose() {
		super.dispose();
		if (delegate != null) {
			delegate.dispose();
		}
	}

}
