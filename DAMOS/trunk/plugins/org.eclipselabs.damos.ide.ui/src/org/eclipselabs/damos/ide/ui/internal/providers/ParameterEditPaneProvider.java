/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.ide.ui.internal.providers;

import org.eclipselabs.damos.dml.DataTypeSpecification;
import org.eclipselabs.damos.dml.Parameter;
import org.eclipselabs.damos.dml.PrimitiveTypeSpecification;
import org.eclipselabs.damos.dml.ui.editpane.IParameterEditPaneProvider;
import org.eclipselabs.damos.dml.ui.editpane.IValueSpecificationEditPane;
import org.eclipselabs.damos.dml.ui.editpane.StringValueSpecificationEditPane;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Andreas Unger
 *
 */
public class ParameterEditPaneProvider implements IParameterEditPaneProvider {

	@Inject
	private Provider<IValueSpecificationEditPane> editorProvider;
	
	public IValueSpecificationEditPane createEditor(Parameter parameter) {
		DataTypeSpecification dataType = parameter.getDataType();
		if (dataType instanceof PrimitiveTypeSpecification) {
			switch (((PrimitiveTypeSpecification) dataType).getKind()) {
			case STRING:
				return new StringValueSpecificationEditPane();
			}
		}
		return editorProvider.get();
	}

}
