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

package org.eclipse.damos.mscript.codegen.c;

import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.codegen.c.datatype.MachineDataTypeFactory;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class DataTypeGenerator {

	@Inject
	private MachineDataTypeFactory machineDataTypeFactory;
	
	public CharSequence generateDataType(IMscriptGeneratorConfiguration configuration, CharSequence variableName, ICodeFragmentCollector codeFragmentCollector, Type type, ICodeFragment dependentCodeFragment) {
		return machineDataTypeFactory.create(configuration, type).generateDataType(variableName, codeFragmentCollector, dependentCodeFragment);
	}
	
}
