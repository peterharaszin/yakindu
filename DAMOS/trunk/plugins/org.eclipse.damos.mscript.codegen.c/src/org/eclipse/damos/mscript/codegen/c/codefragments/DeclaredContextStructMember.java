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

package org.eclipse.damos.mscript.codegen.c.codefragments;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.damos.mscript.codegen.c.ICodeFragment;

/**
 * @author Andreas Unger
 *
 */
public class DeclaredContextStructMember extends AbstractContextStructMember {

	private final String variableName;
	private final String typeName;
	private final ICodeFragment declarationCodeFragment;
	
	/**
	 * 
	 */
	public DeclaredContextStructMember(String variableName, String typeName, ICodeFragment declarationCodeFragment) {
		this.variableName = variableName;
		this.typeName = typeName;
		this.declarationCodeFragment = declarationCodeFragment;
	}
	
	public Collection<ICodeFragment> getDeclarationCodeFragments() {
		return Collections.<ICodeFragment>singleton(declarationCodeFragment);
	}

	/**
	 * @return the variableName
	 */
	public String getVariableName() {
		return variableName;
	}
	
	/**
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}
	
	public CharSequence generate() {
		return typeName + " " + variableName + ";\n";
	}
	
}
