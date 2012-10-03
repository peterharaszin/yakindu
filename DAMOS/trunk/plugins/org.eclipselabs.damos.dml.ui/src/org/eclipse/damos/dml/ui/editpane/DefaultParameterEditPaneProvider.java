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
