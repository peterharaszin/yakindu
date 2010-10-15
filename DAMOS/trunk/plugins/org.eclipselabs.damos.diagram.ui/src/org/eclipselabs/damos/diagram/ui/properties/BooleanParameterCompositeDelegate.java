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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipselabs.damos.common.util.NameUtil;
import org.eclipselabs.damos.diagram.core.internal.commands.SetArgumentValueCommand;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.ExpressionParameter;
import org.eclipselabs.damos.dml.ExpressionSpecification;
import org.eclipselabs.damos.dml.PredefinedExpressionEntry;

/**
 * @author Andreas Unger
 *
 */
public class BooleanParameterCompositeDelegate extends CheckboxPropertyCompositeDelegate implements IParameterCompositeDelegate {

	private static final String YES = "yes";
	private static final String NO = "no";

	private Argument argument;
	private ExpressionSpecification yesExpression;
	private ExpressionSpecification noExpression;
	
	public BooleanParameterCompositeDelegate(TabbedPropertySheetWidgetFactory widgetFactory, Argument argument) {
		super(widgetFactory);
		this.argument = argument;
		if (!(argument.getParameter() instanceof ExpressionParameter) || getParameter().getPredefinedExpressions().size() != 2) {
			throw new IllegalArgumentException();
		}
		yesExpression = getPredefinedExpression(YES);
		noExpression = getPredefinedExpression(NO);
		if (yesExpression == null || noExpression == null) {
			throw new IllegalArgumentException();
		}
	}

	public void refreshParameter() {
		if (argument.isSetValue()) {
			String value = argument.getValue().stringValue();
			getCheckboxWidget().setSelection(yesExpression.getExpression().equals(value));
		} else {
			getCheckboxWidget().setSelection(false);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.properties.AbstractPropertySectionDelegate#getLabelText()
	 */
	protected String getLabelText() {
		return NameUtil.formatName(argument.getParameter().getName());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.properties.CheckboxPropertySectionDelegate#updatePropertyValue()
	 */
	protected void updatePropertyValue() {
		ExpressionSpecification expression = EcoreUtil.copy(getCheckboxWidget().getSelection() ? yesExpression : noExpression);
		executeOperation(new SetArgumentValueCommand(argument, expression));
	}
	
	private ExpressionParameter getParameter() {
		return (ExpressionParameter) argument.getParameter();
	}
	
	private ExpressionSpecification getPredefinedExpression(String alias) {
		if (alias == null) {
			return null;
		}
		alias = alias.toLowerCase();
		PredefinedExpressionEntry entry = getParameter().getPredefinedExpressionByAlias(alias);
		return entry != null ? entry.getExpression() : null;
	}
	
}
