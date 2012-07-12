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
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext

import static org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.*

/**
 * @author Andreas Unger
 *
 */
class StringEqualToFunction extends AbstractCodeFragment {

	val int stringBufferSize
	
	String name
	
	String stringIteratorInitializeRawFunctionName
	String stringIteratorNextFunctionName
	
	CharSequence functionSignature
	
	new(int stringBufferSize) {
		this.stringBufferSize = stringBufferSize
	}
	
	/**
	 * @return the name
	 */
	def String getName() {
		return name
	}
	
	override void initialize(ICodeFragmentContext context, IProgressMonitor monitor) {
		addDependency(IMPLEMENTATION_DEPENDS_ON, [it instanceof StringIteratorInitializeRawFunction || it instanceof StringIteratorNextFunction])

		val codeFragmentCollector = context.codeFragmentCollector
		val stringIteratorInitializeRawFunction = codeFragmentCollector.addCodeFragment(new StringIteratorInitializeRawFunction(stringBufferSize), monitor)
		val stringIteratorNextFunction = codeFragmentCollector.addCodeFragment(new StringIteratorNextFunction(), monitor)

		name = context.globalNameProvider.newGlobalName("StringEqualTo")
		stringIteratorInitializeRawFunctionName = stringIteratorInitializeRawFunction.name
		stringIteratorNextFunctionName = stringIteratorNextFunction.name
		
		functionSignature = generateFunctionSignature(codeFragmentCollector)
	}
	
	override boolean contributesInternalForwardDeclaration() {
		return false
	}
	
	override CharSequence generateForwardDeclaration(boolean internal) '''
		«IF internal»static «ENDIF»«functionSignature»;
	'''
	
	override boolean contributesImplementation() {
		return true
	}
	
	override CharSequence generateImplementation(boolean internal) '''
		«IF internal»static «ENDIF»«functionSignature» {
			Damos_StringIterator it1;
			Damos_StringIterator it2;
			
			int indentationBuffer1[«stringBufferSize»];
			int indentationBuffer2[«stringBufferSize»];
			
			«stringIteratorInitializeRawFunctionName»(&it1, string1, indentationBuffer1, «stringBufferSize»);
			«stringIteratorInitializeRawFunctionName»(&it2, string2, indentationBuffer2, «stringBufferSize»);
			
			char c1;
			char c2;
			do {
				c1 = «stringIteratorNextFunctionName»(&it1);
				c2 = «stringIteratorNextFunctionName»(&it2);
				if (c1 != c2) {
					return 0;
				}
			} while (c1 != '\0');
			
			return 1;
		}
	'''
	
	def private CharSequence generateFunctionSignature(ICodeFragmentCollector codeFragmentCollector) '''
		uint_fast8_t «name»(const char *string1, const char *string2)'''
	
	override int hashCode() {
		return ^class.hashCode
	}
	
	override boolean equals(Object obj) {
		if (obj instanceof StringEqualToFunction) {
			return true
		}
		return false
	}
	
}
