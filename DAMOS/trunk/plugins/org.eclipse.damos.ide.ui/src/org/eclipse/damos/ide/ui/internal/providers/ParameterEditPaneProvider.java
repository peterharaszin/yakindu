/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.ide.ui.internal.providers;

import org.eclipse.damos.dml.DataTypeSpecification;
import org.eclipse.damos.dml.Parameter;
import org.eclipse.damos.dml.PrimitiveTypeSpecification;
import org.eclipse.damos.dml.ui.editpane.DefaultParameterEditPaneProvider;
import org.eclipse.damos.dml.ui.editpane.IValueSpecificationEditPane;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Andreas Unger
 *
 */
public class ParameterEditPaneProvider extends DefaultParameterEditPaneProvider {

	@Inject
	private Provider<IValueSpecificationEditPane> editorProvider;
	
	public IValueSpecificationEditPane createEditPane(Parameter parameter) {
		DataTypeSpecification dataType = parameter.getDataType();
		if (dataType instanceof PrimitiveTypeSpecification) {
			return super.createEditPane(parameter);
		}
		return editorProvider.get();
	}

}
