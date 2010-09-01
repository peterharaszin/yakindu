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

import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipselabs.damos.common.util.NameUtil;
import org.eclipselabs.damos.diagram.core.internal.commands.SetArgumentValueCommand;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.ExpressionSpecification;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionParameterCompositeDelegate extends TextPropertyCompositeDelegate implements IParameterCompositeDelegate {

	private Argument argument;
	
	/**
	 * 
	 */
	public ExpressionParameterCompositeDelegate(TabbedPropertySheetWidgetFactory widgetFactory, Argument argument) {
		super(widgetFactory);
		this.argument = argument;
	}
	
	/**
	 * @return the parameter
	 */
	protected Argument getArgument() {
		return argument;
	}
	
	public void refreshParameter() {
		if (argument.isSetValue()) {
			getControl().setText(argument.getValue().stringValue());
		} else {
			getControl().setText("");
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.properties.TextPropertySectionDelegate#updatePropertyValue(org.eclipse.swt.widgets.Control)
	 */
	protected void updatePropertyValue() {
		ExpressionSpecification expressionSpec = DMLFactory.eINSTANCE.createExpressionSpecification();
		expressionSpec.setExpression(getControl().getText());
		executeOperation(new SetArgumentValueCommand(argument, expressionSpec));
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.properties.AbstractLabeledPropertySectionDelegate#getLabelText()
	 */
	protected String getLabelText() {
		return NameUtil.formatName(argument.getParameter().getName()) + ":";
	}

}
