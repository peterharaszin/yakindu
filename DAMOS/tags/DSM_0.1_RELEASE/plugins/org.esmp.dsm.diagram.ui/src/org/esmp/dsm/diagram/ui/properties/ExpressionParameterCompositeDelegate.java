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

package org.esmp.dsm.diagram.ui.properties;

import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.esmp.dsm.diagram.core.internal.commands.SetParameterValueCommand;
import org.esmp.dsm.semantic.blockdiagram.Parameter;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionParameterCompositeDelegate extends TextPropertyCompositeDelegate implements IParameterCompositeDelegate {

	private Parameter parameter;
	
	/**
	 * 
	 */
	public ExpressionParameterCompositeDelegate(TabbedPropertySheetWidgetFactory widgetFactory, Parameter parameter) {
		super(widgetFactory);
		this.parameter = parameter;
	}
	
	/**
	 * @return the parameter
	 */
	protected Parameter getParameter() {
		return parameter;
	}
	
	public void refreshParameter() {
		getControl().setText(parameter.getValue());
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.ui.properties.TextPropertySectionDelegate#updatePropertyValue(org.eclipse.swt.widgets.Control)
	 */
	protected void updatePropertyValue() {
		executeOperation(new SetParameterValueCommand(parameter, getControl().getText()));
	}

	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.ui.properties.AbstractLabeledPropertySectionDelegate#getLabelText()
	 */
	protected String getLabelText() {
		return parameter.getName() + ":";
	}

}
