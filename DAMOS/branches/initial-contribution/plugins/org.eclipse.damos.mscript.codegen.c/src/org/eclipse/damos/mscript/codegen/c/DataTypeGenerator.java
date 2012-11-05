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
import org.eclipse.damos.mscript.codegen.c.datatype.MachineDataTypes;
import org.eclipse.damos.mscript.computation.ComputationModel;

/**
 * @author Andreas Unger
 *
 */
public class DataTypeGenerator {

	public CharSequence generateDataType(IMscriptGeneratorConfiguration configuration, CharSequence variableName, ICodeFragmentCollector codeFragmentCollector, Type type, ICodeFragment dependentCodeFragment) {
		return MachineDataTypes.create(configuration, type).generateDataType(variableName, codeFragmentCollector, dependentCodeFragment);
	}
	
	public CharSequence generateIndexDataType(ComputationModel computationModel, long maximumIndex) {
		if (maximumIndex <= 0xffL) {
			return "uint_fast8_t";
		}
		if (maximumIndex <= 0xffffL) {
			return "uint_fast16_t";
		}
		if (maximumIndex <= 0xffffffffL) {
			return "uint_fast32_t";
		}
		return "uint_fast64_t";
	}

}
