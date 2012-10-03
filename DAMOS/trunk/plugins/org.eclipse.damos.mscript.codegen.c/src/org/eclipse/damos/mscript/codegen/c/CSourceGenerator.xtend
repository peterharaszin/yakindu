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

package org.eclipse.damos.mscript.codegen.c

import java.util.Collection
import java.util.Set
import java.util.TreeSet

/**
 * @author Andreas Unger
 *
 */
class CSourceGenerator implements ICModuleGenerator {

	override generate(CModule it) {
		return doGenerate(it, includes);
	}

	def private doGenerate(CModule it, Collection<Include> includes) '''
		«IF sourceComment != null»
			«sourceComment»
		«ENDIF»
		«FOR include : includes AFTER "\n"»
			«include»
		«ENDFOR»
		#include "«name».h"
		«FOR otherModule : moduleSet.modules.filter(e | e != it && it.dependsOn(e)) AFTER "\n"»
			#include "«otherModule.name».h"
		«ENDFOR»
		«generateInternalForwardDeclarations()»
		«generateImplementations(false)»
		«generateImplementations(true)»
	'''

	def private generateInternalForwardDeclarations(CModule it) '''
		«FOR entry : entries.filter(e | e.internal && e.codeFragment.contributesInternalForwardDeclaration) BEFORE "\n" SEPARATOR "\n"»
			«entry.codeFragment.generateForwardDeclaration(true)»
		«ENDFOR»
	'''
	
	def private generateImplementations(CModule it, boolean contributesInternalForwardDeclaration) '''
		«FOR entry : entries.filter(e | e.codeFragment.contributesImplementation && e.codeFragment.contributesInternalForwardDeclaration == contributesInternalForwardDeclaration) BEFORE "\n" SEPARATOR "\n"»
			«entry.codeFragment.generateImplementation(entry.internal)»
		«ENDFOR»
	'''
	
	/**
	 * @param module
	 * @return
	 */
	def private Collection<Include> getIncludes(CModule it) {
		// Add internal forward declaration includes
		val Set<Include> includes = new TreeSet<Include>();
		for (entry : entries) {
			val codeFragment = entry.codeFragment;
			if (entry.internal && codeFragment.contributesInternalForwardDeclaration) {
				for (include : codeFragment.forwardDeclarationIncludes) {
					includes += include;
				}
			}
		}

		// Add implementation includes
		for (entry : entries) {
			for (include : entry.codeFragment.implementationIncludes) {
				includes += include;
			}
		}
		
		return includes;
	}

}
