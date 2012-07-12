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

import java.util.ArrayList
import java.util.List
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext
import org.eclipselabs.damos.mscript.codegen.c.internal.util.StringUtil

/**
 * @author Andreas Unger
 *
 */
class StringTable extends AbstractCodeFragment {

	val List<String> strings = new ArrayList<String>()
	
	String name
	
	/**
	 * @return the name
	 */
	def String getName() {
		return name
	}
	
	def int addString(String newString) {
		val s = StringUtil::escape(newString)
		var i = 0
		for (string : strings) {
			if (string == s) {
				return i
			}
			i = i + 1
		}
		strings += s
		return i
	}
	
	override initialize(ICodeFragmentContext context, IProgressMonitor monitor) {
		name = context.globalNameProvider.newGlobalName("StringTable")
	}
	
	override boolean contributesInternalForwardDeclaration() {
		return false
	}
	
	override CharSequence generateForwardDeclaration(boolean internal) '''
		extern const char *«name»[«strings.size»];
	'''
	
	override boolean contributesImplementation() {
		return true
	}
	
	override CharSequence generateImplementation(boolean internal) '''
		«IF internal»static «ENDIF»const char *«name»[«strings.size»] = {
			«FOR string : strings SEPARATOR ",\n"»"«string»"«ENDFOR»
		};
	'''

	override int hashCode() {
		return ^class.hashCode
	}
	
	override boolean equals(Object obj) {
		if (obj instanceof StringTable) {
			return true
		}
		return false
	}

}
