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

import com.google.inject.Inject
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext

/**
 * @author Andreas Unger
 *
 */
class StringIteratorDeclaration extends AbstractCodeFragment {

	@Inject
	new() {
	}
	
	/**
	 * @return the name
	 */
	def String getName() {
		return name
	}
	
	override initialize(ICodeFragmentContext context, IProgressMonitor monitor) {
	}
	
	override CharSequence generateForwardDeclaration(boolean internal) '''
		#ifndef DAMOS_STRING_ITERATOR
		#define DAMOS_STRING_ITERATOR
		
		typedef struct Damos_StringIterator_ {
			int state;
			const char *pos;
			const char *stringTablePos;
			const char *indentationStringTablePos;
			int *indentationPos;
			int *indentationEnd;
			int *indentationBuffer;
			int *indentationBufferEnd;
			char previous;
			char (*next)(struct Damos_StringIterator_ *self);
		} Damos_StringIterator;

		#endif /* DAMOS_STRING_ITERATOR */
	'''
	
	override int hashCode() {
		return ^class.hashCode
	}
	
	override boolean equals(Object obj) {
		if (obj instanceof StringIteratorDeclaration) {
			return true
		}
		return false
	}

}
