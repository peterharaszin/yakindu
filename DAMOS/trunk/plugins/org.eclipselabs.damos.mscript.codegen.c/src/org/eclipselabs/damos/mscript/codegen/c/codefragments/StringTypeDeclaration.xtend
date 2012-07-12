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

package org.eclipselabs.damos.mscript.codegen.c.codefragments

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext

/**
 * @author Andreas Unger
 *
 */
class StringTypeDeclaration extends AbstractCodeFragment {

	val int stringBufferSize
	
	String name
	
	new(int stringBufferSize) {
		this.stringBufferSize = stringBufferSize
	}
	
	/**
	 * @return the name
	 */
	def String getName() {
		return name
	}
	
	override initialize(ICodeFragmentContext context, IProgressMonitor monitor) {
		name = context.globalNameProvider.newGlobalName("String")
	}
	
	override postProcess(ICodeFragmentContext context, IProgressMonitor monitor) {
		val codeFragmentCollector = context.codeFragmentCollector
		codeFragmentCollector.addCodeFragment(new StringIteratorDeclaration(), monitor)
		codeFragmentCollector.addCodeFragment(new StringIteratorNextFunction(), monitor)
		codeFragmentCollector.addCodeFragment(new StringIteratorInitializeFunction(stringBufferSize), monitor)
	}
	
	override CharSequence generateForwardDeclaration(boolean internal) '''
		typedef struct { char data[«stringBufferSize»]; } «name»;
	'''
	
	override int hashCode() {
		return ^class.hashCode
	}
	
	override boolean equals(Object obj) {
		if (obj instanceof StringTypeDeclaration) {
			return true
		}
		return false
	}

}
