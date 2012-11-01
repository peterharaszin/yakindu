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

/**
 * @author Andreas Unger
 *
 */
class StructGenerator {

	def CharSequence generate(String name, CharSequence content, boolean internal) '''
		typedef struct {
			«content»
		} «name»;
	'''
	
	def CharSequence generateMemberAccess(String name, boolean pointerReference) '''
		«name»«IF pointerReference»->«ELSE».«ENDIF»'''

}
