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

package org.eclipselabs.damos.mscript.codegen.c

import java.util.Collection
import java.util.TreeSet

/**
 * @author Andreas Unger
 *
 */
class CHeaderGenerator implements ICModuleGenerator {

	override generate(CModule it) {
		val headerMacro = name.replaceAll("\\W", "_").toUpperCase() + "_H_";
		return doGenerate(it, headerMacro, includes);
	}
	
	def doGenerate(CModule it, String headerMacro, Collection<Include> includes) '''
		«IF headerComment != null»
			«headerComment»
		«ENDIF»
		#ifndef «headerMacro»
		#define «headerMacro»
		
		«FOR include : includes AFTER "\n"»
			«include»
		«ENDFOR»
		#ifdef __cplusplus
		extern "C" {
		#endif /* __cplusplus */
		
		«FOR entry : entries.filter(e | !e.internal) SEPARATOR "\n"»
			«entry.getCodeFragment().generateForwardDeclaration(false)»
		«ENDFOR»

		#ifdef __cplusplus
		}
		#endif /* __cplusplus */
		
		#endif /* «headerMacro» */
	'''

	/**
	 * @param module
	 * @return
	 */
	def Collection<Include> getIncludes(CModule it) {
		// Add external forward declaration includes
		val Collection<Include> includes = new TreeSet<Include>();
		for (entry : entries) {
			if (!entry.internal) {
				for (include : entry.codeFragment.forwardDeclarationIncludes) {
					includes += include;
				}
			}
		}
		return includes;
	}

}
