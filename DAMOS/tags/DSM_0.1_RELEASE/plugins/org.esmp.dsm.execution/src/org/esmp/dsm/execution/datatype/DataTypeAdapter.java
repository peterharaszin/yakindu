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

package org.esmp.dsm.execution.datatype;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.esmp.dsm.expressions.DataType;

/**
 * @author Andreas Unger
 *
 */
public class DataTypeAdapter extends AdapterImpl {

	private DataType dataType;
	
	/**
	 * 
	 */
	public DataTypeAdapter(DataType dataType) {
		this.dataType = dataType;
	}
	
	/**
	 * @return the dataType
	 */
	public DataType getDataType() {
		return dataType;
	}
	
	public boolean isAdapterForType(Object type) {
		return type == DataTypeAdapter.class;
	}
	
}
