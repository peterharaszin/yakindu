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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.ExpressionParameter;
import org.eclipselabs.damos.dml.ParameterVisibilityKind;
import org.eclipselabs.damos.dml.PredefinedExpressionEntry;

/**
 * @author Andreas Unger
 *
 */
public class ParametersPropertySectionDelegate {

	private static final String YES = "yes";
	private static final String NO = "no";
	
	protected Map<Argument, IParameterCompositeDelegate> compositeDelegates = new HashMap<Argument, IParameterCompositeDelegate>();

	public void createControls(Composite parent, TabbedPropertySheetWidgetFactory widgetFactory, Block block) {
		compositeDelegates.clear();
		for (Argument argument : block.getArguments()) {
			IParameterCompositeDelegate compositeDelegate = createCompositeDelegate(argument, widgetFactory);
			if (compositeDelegate != null) {
				Composite composite = compositeDelegate.createComposite(parent);
				composite.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));
				compositeDelegates.put(argument, compositeDelegate);
			}
		}
	}
	
	protected IParameterCompositeDelegate createCompositeDelegate(Argument argument, TabbedPropertySheetWidgetFactory widgetFactory) {
		if (argument.getParameter() instanceof ExpressionParameter && argument.getParameter().getVisibility() == ParameterVisibilityKind.PUBLIC) {
			ExpressionParameter parameter = (ExpressionParameter) argument.getParameter();
			List<PredefinedExpressionEntry> predefinedExpressionEntries = parameter.getPredefinedExpressions();
			if (!predefinedExpressionEntries.isEmpty()) {
				if (predefinedExpressionEntries.size() == 2) {
					String alias1 = predefinedExpressionEntries.get(0).getAlias();
					if (alias1 != null) {
						alias1 = alias1.toLowerCase();
					}
					String alias2 = predefinedExpressionEntries.get(1).getAlias();
					if (alias2 != null) {
						alias2 = alias2.toLowerCase();
					}
					if (YES.equals(alias1) && NO.equals(alias2) || YES.equals(alias2) && NO.equals(alias1)) {
						return new BooleanParameterCompositeDelegate(widgetFactory, argument);
					}
				}
				return new PredefinedParameterCompositeDelegate(widgetFactory, argument);
			}
			return new ExpressionParameterCompositeDelegate(widgetFactory, argument);
		}
		return null;
	}
	
	public void refreshParameters(Block block) {
		for (Argument argument : block.getArguments()) {
			refreshParameter(argument);
		}
	}
	
	protected void refreshParameter(Argument argument) {
		IParameterCompositeDelegate compositeDelegate = compositeDelegates.get(argument);
		if (compositeDelegate != null) {
			compositeDelegate.refreshParameter();
		}
	}

	public void dispose() {
		for (IParameterCompositeDelegate compositeDelegate : compositeDelegates.values()) {
			compositeDelegate.dispose();
		}
	}

}
