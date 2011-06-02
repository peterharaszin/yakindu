/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.statechart.diagram.propertysheets;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.yakindu.model.sct.statechart.ExpressionElement;
import org.yakindu.model.sct.statechart.StatechartPackage;
import org.yakindu.sct.statechart.diagram.extensions.Extensions;
import org.yakindu.sct.statechart.diagram.extensions.IExpressionsProvider;

import de.itemis.xtext.utils.jface.viewers.XtextCellEditor;

/**
 * Creates an {@link XtextCellEditor} for all {@link ExpressionElement}s for the
 * Property Page. The Language provider is loaded via
 * org.yakindu.sct.statechart.diagram.expressions extension point.
 * 
 * 
 * 
 * @author muelder
 * 
 */
public class ExpressionElementPropertySource extends PropertySource {

	private static final String EXPRESSIONS_EXTENSION = "org.yakindu.sct.statechart.diagram.expressions";

	private final ExpressionElement element;

	public ExpressionElementPropertySource(Object object,
			IItemPropertySource itemPropertySource) {
		super(object, itemPropertySource);
		element = (ExpressionElement) object;
	}

	@Override
	protected IPropertyDescriptor createPropertyDescriptor(
			IItemPropertyDescriptor itemPropertyDescriptor) {
		if (itemPropertyDescriptor.getFeature(object) instanceof EAttribute) {
			EAttribute attribute = (EAttribute) itemPropertyDescriptor
					.getFeature(object);
			if (StatechartPackage.Literals.EXPRESSION_ELEMENT__EXPRESSION
					.equals(attribute)) {
				return new PropertyDescriptor(object, itemPropertyDescriptor) {
					@Override
					public CellEditor createPropertyEditor(Composite composite) {
						final XtextCellEditor xTextEditor = new XtextCellEditor(
								getExpressionsProvider().getStyle());
						getExpressionsProvider().getInjector().injectMembers(
								xTextEditor);
						xTextEditor.setContext(((EObject)object).eResource());
						xTextEditor.create(composite);
						return xTextEditor;

					}
				};
			}
		}
		;
		return super.createPropertyDescriptor(itemPropertyDescriptor);
	}

	protected IExpressionsProvider getExpressionsProvider() {
		Extensions<IExpressionsProvider> extensions = new Extensions<IExpressionsProvider>(
				EXPRESSIONS_EXTENSION);
		IExpressionsProvider registeredProvider = extensions
				.getRegisteredProvider(element);
		return registeredProvider;
	}

}