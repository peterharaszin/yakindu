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

package org.eclipselabs.damos.mscript.codegen.c.codefragments;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.damos.mscript.interpreter.StaticFunctionInfo;

/**
 * @author Andreas Unger
 *
 */
public class FunctionContextMemberVariable extends AbstractContextStructPart {

	private final String name;
	private final ContextStruct contextStruct;
	
	/**
	 * 
	 */
	public FunctionContextMemberVariable(String name, ContextStruct contextStruct) {
		this.name = name;
		this.contextStruct = contextStruct;
	}
	
	public static FunctionContextMemberVariable initialize(IMscriptGeneratorContext context, ComputeFunction newFunctionDefinition, StaticFunctionInfo newStaticFunctionInfo, StaticFunctionInfo oldStaticFunctionInfo) {
		if (!newStaticFunctionInfo.getFunctionDescription().isStateful()) {
			return null;
		}
		ICodeFragmentCollector codeFragmentCollector = context.getCodeFragmentCollector();
		ContextStruct contextStruct = codeFragmentCollector.addCodeFragment(new ContextStruct(oldStaticFunctionInfo, false /* TODO */), new NullProgressMonitor());
		String name = contextStruct.newUniqueName(newStaticFunctionInfo.getFunctionDescription().getDeclaration().getName() + "_context");
		FunctionContextMemberVariable part = new FunctionContextMemberVariable(name, newFunctionDefinition.getContextStruct());
		contextStruct.addPart(part);
		return part;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.codefragments.AbstractContextStructPart#getDeclarationCodeFragments()
	 */
	@Override
	public Collection<ICodeFragment> getDeclarationCodeFragments() {
		return Collections.<ICodeFragment>singleton(contextStruct);
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	public CharSequence generate() {
		return contextStruct.getName() + " " + name + ";\n";
	}

}
