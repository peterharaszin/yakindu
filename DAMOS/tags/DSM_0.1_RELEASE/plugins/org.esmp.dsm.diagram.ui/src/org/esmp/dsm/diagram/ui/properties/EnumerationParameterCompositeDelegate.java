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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.esmp.dsm.diagram.core.internal.commands.SetParameterValueCommand;
import org.esmp.dsm.semantic.blockdiagram.EnumerationLiteral;
import org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor;
import org.esmp.dsm.semantic.blockdiagram.Parameter;

/**
 * @author Andreas Unger
 *
 */
public class EnumerationParameterCompositeDelegate extends ComboPropertyCompositeDelegate implements IParameterCompositeDelegate {

	private Parameter parameter;
	private List<String> propertyValueStrings;
	
	/**
	 * 
	 */
	public EnumerationParameterCompositeDelegate(TabbedPropertySheetWidgetFactory widgetFactory, Parameter parameter) {
		super(widgetFactory);
		this.parameter = parameter;
	}
	
	public void refreshParameter() {
		boolean selected = false;
		if (parameter.getDescriptor() instanceof EnumerationParameterDescriptor) {
			EnumerationParameterDescriptor descriptor = (EnumerationParameterDescriptor) parameter.getDescriptor();
			String value = parameter.getValue();
			if (value != null) {
				EnumerationLiteral literal = descriptor.getLiteralByValue(value);
				if (literal != null) {
					getControl().select(descriptor.getLiterals().indexOf(literal));
					selected = true;
				}
			}
		}
		if (!selected) {
			getControl().setText(parameter.getValue());
		}
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.ui.properties.ComboPropertySectionDelegate#updatePropertyValue()
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

	protected List<String> getPropertyValueStrings() {
		if (propertyValueStrings == null) {
			propertyValueStrings = new ArrayList<String>();
			if (parameter.getDescriptor() instanceof EnumerationParameterDescriptor) {
				EnumerationParameterDescriptor descriptor = (EnumerationParameterDescriptor) parameter.getDescriptor();
				for (EnumerationLiteral literal : descriptor.getLiterals()) {
					propertyValueStrings.add(literal.getValue());
				}
			}
		}
		return propertyValueStrings;
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.ui.properties.ComboPropertyCompositeDelegate#isEditable()
	 */
	protected boolean isEditable() {
		return !(parameter.getDescriptor() instanceof EnumerationParameterDescriptor) || !((EnumerationParameterDescriptor) parameter.getDescriptor()).isExclusive();
	}

}
