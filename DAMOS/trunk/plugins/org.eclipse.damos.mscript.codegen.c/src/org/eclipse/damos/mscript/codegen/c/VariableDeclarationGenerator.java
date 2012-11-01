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

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class VariableDeclarationGenerator {
	
	@Inject
	private DataTypeGenerator dataTypeGenerator;
	
	public CharSequence generateVariableDeclaration(IMscriptGeneratorConfiguration configuration, ICodeFragmentCollector codeFragmentCollector, Type type, CharSequence name, boolean pointer, ICodeFragment dependentCodeFragment) {
		return dataTypeGenerator.generateDataType(configuration, pointer ? (getPointerSymbol() + name) : name, codeFragmentCollector, type, dependentCodeFragment);
	}

	public CharSequence generateVariableDeclaration(CharSequence type, CharSequence name, boolean constant, boolean pointer) {
		StringBuilder sb = new StringBuilder();
		if (constant) {
			sb.append(generateConstantPrefix());
		}
		sb.append(type);
		sb.append(" ");
		if (pointer) {
			sb.append(getPointerSymbol());
		}
		sb.append(name);
		return sb;
	}
	
	protected CharSequence generateConstantPrefix() {
		return "const ";
	}

	protected String getPointerSymbol() {
		return "*";
	}

}
