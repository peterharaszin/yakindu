/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.statechart.diagram.propertysheets;

import java.util.Arrays;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.yakindu.sct.statechart.diagram.DiagramActivator;


import de.itemis.xtext.gmf.integration.celleditors.XTextCellEditor;

/**
 * 
 * 
 * Creates an {@link XTextCellEditor} for the given {@link EAttribute}s of the
 * {@link PropertySource}.
 * 
 * @author andreas.muelder@itemis.de
 * 
 */
public class ExpressionsPropertySource extends PropertySource {

	private final EAttribute[] attributes;

	/**
	 * 
	 * @param object
	 * @param itemPropertySource
	 * @param attributes
	 */
	public ExpressionsPropertySource(Object object,
			IItemPropertySource itemPropertySource, EAttribute... attributes) {
		super(object, itemPropertySource);
		this.attributes = attributes;
	}

	@Override
	protected IPropertyDescriptor createPropertyDescriptor(
			IItemPropertyDescriptor itemPropertyDescriptor) {
		if (itemPropertyDescriptor.getFeature(object) instanceof EAttribute) {
			EAttribute attribute = (EAttribute) itemPropertyDescriptor
					.getFeature(object);
			if (Arrays.asList(attributes).contains(attribute)) {
				return new PropertyDescriptor(object, itemPropertyDescriptor) {
					@Override
					public CellEditor createPropertyEditor(Composite composite) {
						EObject eObject = (EObject) object;
						XTextCellEditor xTextEditor = new XTextCellEditor(
								composite, DiagramActivator.getXtextModule(),
								eObject.eResource().getResourceSet()
										.getResources());
						return xTextEditor;
					}
				};
			}
		}
		return super.createPropertyDescriptor(itemPropertyDescriptor);
	}

}