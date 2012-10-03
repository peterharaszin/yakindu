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

package org.eclipse.damos.mscript.codegen.c.codefragments

import java.util.Collection
import java.util.Collections
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.damos.mscript.codegen.c.AbstractCodeFragment
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentContext
import org.eclipse.damos.mscript.codegen.c.Include

import static org.eclipse.damos.mscript.codegen.c.ICodeFragment.*

/**
 * @author Andreas Unger
 *
 */
class StringIteratorInitializeRawFunction extends AbstractCodeFragment {

	val int stringBufferSize
	
	String name
	
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
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, [it instanceof StringIteratorDeclaration])
		addDependency(IMPLEMENTATION_DEPENDS_ON, [it instanceof StringIteratorNextFunction])

		val codeFragmentCollector = context.codeFragmentCollector
		val stringIteratorNextFunction = codeFragmentCollector.addCodeFragment(new StringIteratorNextFunction(), monitor)

		name = context.globalNameProvider.newGlobalName("StringIterator_initializeRaw")
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
	
	override Collection<Include> getImplementationIncludes() {
		return Collections::singletonList(new Include("stdlib.h"));
	}

	override CharSequence generateImplementation(boolean internal) '''
		«IF internal»static «ENDIF»«functionSignature» {
			it->state = 0;
			it->pos = string;
			it->stringTablePos = NULL;
			it->indentationStringTablePos = NULL;
			it->indentationPos = indentationBuffer;
			it->indentationEnd = indentationBuffer;
			it->indentationBuffer = indentationBuffer;
			it->indentationBufferEnd = indentationBuffer != NULL ? indentationBuffer + indentationBufferSize : NULL;
			it->previous = '\0';
			it->next = «stringIteratorNextFunctionName»;
		}
	'''
	
	def private CharSequence generateFunctionSignature(ICodeFragmentCollector codeFragmentCollector) '''
		void «name»(Damos_StringIterator *it, const char *string, int *indentationBuffer, size_t indentationBufferSize)'''
	
	override int hashCode() {
		return ^class.hashCode
	}
	
	override boolean equals(Object obj) {
		if (obj instanceof StringIteratorInitializeRawFunction) {
			return true
		}
		return false
	}
	
}
