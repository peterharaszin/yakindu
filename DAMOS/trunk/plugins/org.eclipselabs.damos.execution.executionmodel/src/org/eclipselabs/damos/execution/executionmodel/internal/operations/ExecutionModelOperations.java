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

package org.eclipselabs.damos.execution.executionmodel.internal.operations;

import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.execution.executionmodel.ComputationModelMapping;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModel;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;

/**
 * @author Andreas Unger
 *
 */
public class ExecutionModelOperations {

	public static ComputationModel getComputationModel(ExecutionModel executionModel, Fragment fragment) {
		for (ComputationModelMapping mapping : executionModel.getComputationModelMappings()) {
			if (mapping.getFragment() == fragment) {
				return mapping.getComputationModel();
			}
		}
		return null;
	}
	
}
