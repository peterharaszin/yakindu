/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.dml.ui.editpane;

import org.eclipse.damos.dml.Parameter;

/**
 * @author Andreas Unger
 *
 */
public class DefaultParameterEditPaneProvider implements IParameterEditPaneProvider {

	public IValueSpecificationEditPane createEditPane(Parameter parameter) {
//		DataTypeSpecification dataType = parameter.getDataType();
//		if (dataType instanceof PrimitiveTypeSpecification) {
//			switch (((PrimitiveTypeSpecification) dataType).getKind()) {
//			case STRING:
//				return new StringValueSpecificationEditPane();
//			}
//		}
		return new StringValueSpecificationEditPane();
	}

}
