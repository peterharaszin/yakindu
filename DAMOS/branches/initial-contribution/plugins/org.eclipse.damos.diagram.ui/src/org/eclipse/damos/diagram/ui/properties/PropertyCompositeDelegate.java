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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.diagram.ui.DiagramUIPlugin;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * @author Andreas Unger
 *
 */
public abstract class PropertyCompositeDelegate implements IPropertyCompositeDelegate {

	private TabbedPropertySheetWidgetFactory widgetFactory;
	
	/**
	 * 
	 */
	public PropertyCompositeDelegate(TabbedPropertySheetWidgetFactory widgetFactory) {
		this.widgetFactory = widgetFactory;
	}
	
	/**
	 * @return the widgetFactory
	 */
	protected TabbedPropertySheetWidgetFactory getWidgetFactory() {
		return widgetFactory;
	}
	
	public abstract Composite createComposite(Composite parent);
	
	protected abstract String getLabelText();

	protected abstract void updatePropertyValue();
		
	protected void executeOperation(IUndoableOperation operation) {
        IOperationHistory history = OperationHistoryFactory.getOperationHistory();
        try {
            IStatus status = history.execute(operation, new NullProgressMonitor(), null);
            if (status.getSeverity() > IStatus.WARNING) {
            	DiagramUIPlugin.getDefault().getLog().log(status);
            }
        } catch (ExecutionException e) {
        	DiagramUIPlugin.getDefault().getLog().log(new Status(
        			IStatus.ERROR,
        			DiagramUIPlugin.PLUGIN_ID,
        			"Operation execution failed", e));
        }
	}

	public void dispose() {
	}

}
