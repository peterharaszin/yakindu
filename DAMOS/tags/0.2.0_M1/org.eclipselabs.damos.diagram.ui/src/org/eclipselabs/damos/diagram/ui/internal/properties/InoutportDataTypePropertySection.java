/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.diagram.ui.internal.properties;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.diagram.ui.properties.AbstractComboPropertySection;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.DataTypeSpecification;
import org.eclipselabs.damos.dml.Inoutport;
import org.eclipselabs.damos.dml.OpaqueDataTypeSpecification;

/**
 * @author Andreas Unger
 *
 */
public class InoutportDataTypePropertySection extends AbstractComboPropertySection {
	
	private static final List<String> PROPERTY_VALUE_STRINGS = Arrays.asList(new String[] {
		"real",
		"int",
		"bool" });

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.properties.AbstractComboPropertySection#getPropertyChangeCommandName()
	 */
	protected String getPropertyChangeCommandName() {
		return "Change Data Type";
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.properties.AbstractComboPropertySection#getPropertyNameLabel()
	 */
	protected String getPropertyNameLabel() {
		return "Data Type:";
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.properties.AbstractComboPropertySection#isEditable()
	 */
	protected boolean isEditable() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.properties.AbstractComboPropertySection#getPropertyValue()
	 */
	protected String getPropertyValue() {
		return getDataType();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.properties.AbstractComboPropertySection#getPropertyValueIndex()
	 */
	protected int getPropertyValueIndex() {
		return getPropertyValueStrings().indexOf(getDataType());
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.properties.AbstractComboPropertySection#getPropertyValueStrings()
	 */
	protected List<String> getPropertyValueStrings() {
		return PROPERTY_VALUE_STRINGS;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.properties.AbstractComboPropertySection#setPropertyValue(org.eclipse.emf.ecore.EObject, java.lang.Object)
	 */
	protected void setPropertyValue(EObject object, Object value) {
		OpaqueDataTypeSpecification dataType = DMLFactory.eINSTANCE.createOpaqueDataTypeSpecification();
		dataType.setDataType((String) value);
		getInoutport().setDataType(dataType);
	}
	
	private Inoutport getInoutport() {
		EObject element = getEObject();
		if (element instanceof Inoutport) {
			return (Inoutport) element;
		}
		return null;
	}
	
	private String getDataType() {
		DataTypeSpecification dataType = getInoutport().getDataType();
		if (dataType instanceof OpaqueDataTypeSpecification) {
			OpaqueDataTypeSpecification dataTypeSpecification = (OpaqueDataTypeSpecification) dataType;
			if (dataTypeSpecification.getDataType() != null) {
				return dataTypeSpecification.getDataType();
			}
		}
		return "";
	}

}
