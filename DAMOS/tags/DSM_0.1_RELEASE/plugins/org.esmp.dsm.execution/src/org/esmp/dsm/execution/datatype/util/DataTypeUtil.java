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

package org.esmp.dsm.execution.datatype.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.esmp.dsm.execution.datatype.DataTypeAdapter;
import org.esmp.dsm.expressions.DataType;

/**
 * @author Andreas Unger
 *
 */
public class DataTypeUtil {

	public static DataType getDataType(EObject o) {
		DataTypeAdapter dataTypeAdapter = (DataTypeAdapter) EcoreUtil.getAdapter(o.eAdapters(), DataTypeAdapter.class);
		if (dataTypeAdapter != null) {
			return dataTypeAdapter.getDataType();
		}
		return null;
	}
	
}
