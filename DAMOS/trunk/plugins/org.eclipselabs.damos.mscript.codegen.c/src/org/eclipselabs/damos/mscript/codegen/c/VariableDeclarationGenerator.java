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

package org.eclipselabs.damos.mscript.codegen.c;

import org.eclipselabs.damos.mscript.DataType;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class VariableDeclarationGenerator {
	
	private final DataTypeGenerator dataTypeGenerator;
	
	@Inject
	public VariableDeclarationGenerator(DataTypeGenerator dataTypeGenerator) {
		this.dataTypeGenerator = dataTypeGenerator;
	}

	public CharSequence generateVariableDeclaration(IMscriptGeneratorConfiguration configuration, ICodeFragmentCollector codeFragmentCollector, DataType dataType, CharSequence name, boolean pointer, ICodeFragment dependentCodeFragment) {
		return dataTypeGenerator.generateDataType(configuration, pointer ? ("*" + name) : name, codeFragmentCollector, dataType, dependentCodeFragment);
	}

}
