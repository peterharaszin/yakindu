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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipselabs.damos.diagram.core.internal.commands.SetArgumentValueCommand;
import org.eclipselabs.damos.diagram.ui.internal.util.PropertySectionUtil;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.ExpressionParameter;
import org.eclipselabs.damos.dml.ExpressionSpecification;
import org.eclipselabs.damos.dml.PredefinedExpressionEntry;

/**
 * @author Andreas Unger
 *
 */
public class PredefinedParameterCompositeDelegate extends ComboPropertyCompositeDelegate implements IParameterCompositeDelegate {

	private Argument argument;
	private List<String> propertyValueStrings;
	
	/**
	 * 
	 */
	public PredefinedParameterCompositeDelegate(TabbedPropertySheetWidgetFactory widgetFactory, Argument argument) {
		super(widgetFactory);
		this.argument = argument;
		if (!(argument.getParameter() instanceof ExpressionParameter) || getParameter().getPredefinedExpressions().isEmpty()) {
			throw new IllegalArgumentException();
		}
	}
	
	public void refreshParameter() {
		if (argument.isSetValue()) {
			boolean selected = false;
			String value = argument.getValue().stringValue();
			if (value != null) {
				PredefinedExpressionEntry entry = getParameter().getPredefinedExpression(value);
				if (entry != null) {
					getControl().select(getParameter().getPredefinedExpressions().indexOf(entry));
					selected = true;
				}
			}
			if (!selected) {
				getControl().setText(argument.getValue().stringValue());
			}
		} else {
			getControl().deselectAll();
			getControl().setText("");
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.properties.ComboPropertySectionDelegate#updatePropertyValue()
	 */
	protected void updatePropertyValue() {
		int index = getControl().getSelectionIndex();
		ExpressionSpecification expression = null;
		if (index >= 0 && index < getParameter().getPredefinedExpressions().size()) {
			PredefinedExpressionEntry entry = getParameter().getPredefinedExpressions().get(index);
			if (entry.getExpression() != null) {
				expression = (ExpressionSpecification) EcoreUtil.copy(entry.getExpression());
			}
		}
		if (expression == null) {
			expression = DMLFactory.eINSTANCE.createExpressionSpecification();
			expression.setExpression(getControl().getText());
		}
		executeOperation(new SetArgumentValueCommand(argument, expression));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.properties.AbstractLabeledPropertySectionDelegate#getLabelText()
	 */
	protected String getLabelText() {
		return PropertySectionUtil.formatName(argument.getParameter().getName()) + ":";
	}

	protected List<String> getPropertyValueStrings() {
		if (propertyValueStrings == null) {
			propertyValueStrings = new ArrayList<String>();
			for (PredefinedExpressionEntry expression : getParameter().getPredefinedExpressions()) {
				if (expression.isSetAlias()) {
					propertyValueStrings.add(expression.getAlias());
				} else if (expression.getExpression() != null && expression.getExpression().getExpression() != null) {
					propertyValueStrings.add(expression.getExpression().getExpression());
				} else {
					propertyValueStrings.add("");
				}
			}
		}
		return propertyValueStrings;
	}
	
	private ExpressionParameter getParameter() {
		return (ExpressionParameter) argument.getParameter();
	}
	
}
