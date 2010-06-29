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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.BooleanParameterDescriptor;
import org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor;
import org.esmp.dsm.semantic.blockdiagram.ExpressionParameterDescriptor;
import org.esmp.dsm.semantic.blockdiagram.Parameter;

/**
 * @author Andreas Unger
 *
 */
public class ParametersPropertySectionDelegate {

	protected Map<Parameter, IParameterCompositeDelegate> compositeDelegates = new HashMap<Parameter, IParameterCompositeDelegate>();

	public void createControls(Composite parent, TabbedPropertySheetWidgetFactory widgetFactory, Block block) {
		compositeDelegates.clear();
		for (Parameter parameter : block.getParameters()) {
			IParameterCompositeDelegate compositeDelegate = createCompositeDelegate(parameter, widgetFactory);
			if (compositeDelegate != null) {
				Composite composite = compositeDelegate.createComposite(parent);
				composite.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));
				compositeDelegates.put(parameter, compositeDelegate);
			}
		}
	}
	
	protected IParameterCompositeDelegate createCompositeDelegate(Parameter parameter, TabbedPropertySheetWidgetFactory widgetFactory) {
		if (parameter.getDescriptor() instanceof ExpressionParameterDescriptor) {
			return new ExpressionParameterCompositeDelegate(widgetFactory, parameter);
		} else if (parameter.getDescriptor() instanceof EnumerationParameterDescriptor) {
			return new EnumerationParameterCompositeDelegate(widgetFactory, parameter);
		} else if (parameter.getDescriptor() instanceof BooleanParameterDescriptor) {
			return new BooleanParameterCompositeDelegate(widgetFactory, parameter);
		}
		return null;
	}
	
	public void refreshParameters(Block block) {
		for (Parameter parameter : block.getParameters()) {
			refreshParameter(parameter);
		}
	}
	
	protected void refreshParameter(Parameter parameter) {
		IParameterCompositeDelegate compositeDelegate = compositeDelegates.get(parameter);
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
