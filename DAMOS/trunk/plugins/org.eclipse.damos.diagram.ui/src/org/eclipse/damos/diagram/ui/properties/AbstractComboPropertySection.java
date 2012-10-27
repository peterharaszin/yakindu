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
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractComboPropertySection extends AbstractModelerPropertySection {

	private ComboPropertyCompositeDelegate delegate;

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#createControls(org.eclipse.swt.widgets.Composite, org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		delegate = new ComboPropertyCompositeDelegate(getWidgetFactory()) {
			
			protected int calculateMinimumLabelWidth(GC gc) {
				return isStandalone() ? 0 : super.calculateMinimumLabelWidth(gc);
			}
			
			protected boolean isEditable() {
				return AbstractComboPropertySection.this.isEditable();
			}
			
			protected String getLabelText() {
				return getPropertyNameLabel();
			}

			protected void updatePropertyValue() {
				AbstractComboPropertySection.this.updatePropertyValue();
			}
						
			protected List<String> getPropertyValueStrings() {
				return AbstractComboPropertySection.this.getPropertyValueStrings();
			}
			
		};
		delegate.createComposite(parent);
	}
	
	protected CCombo getControl() {
		return delegate.getControl();
	}

	/**
	 * User changed the value in the combo box - update the model
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
	 * @return - a default implementation returns text of the combo widget as
	 *         a new value for the property. Subclasses can override.
	 */
	protected Object computeNewPropertyValue() {
		return delegate.getControl().getText();
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
	 * Refresh UI body - referesh will surround this with read action block
	 */
	protected void refreshUI() {
		if (propertyValueStringsChanged()) {
			getControl().removeAll();
			for (String value : getPropertyValueStrings()) {
				getControl().add(value);
			}
		}
		int index = getPropertyValueIndex();
		delegate.getControl().select(index);
		if (index < 0) {
			delegate.getControl().setText(getPropertyValue());
		}
	}
		
	protected boolean isStandalone() {
		return false;
	}

	protected boolean isEditable() {
		return false;
	}

	protected int getSelectionIndex() {
		return delegate.getControl().getSelectionIndex();
	}
	
	/**
	 * @return - name of the property to place in the label widget
	 */
	protected abstract String getPropertyNameLabel();
	
	protected boolean propertyValueStringsChanged() {
		return false;
	}

	protected abstract List<String> getPropertyValueStrings();
	
	protected String getPropertyValue() {
		return "";
	}

	/**
	 * @return the index of the property value
	 */
	protected abstract int getPropertyValueIndex();

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

}
