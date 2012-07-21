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
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineStructType

/**
 * @author Andreas Unger
 *
 */
class StructTypeDeclaration extends AbstractCodeFragment {

	val MachineStructType structType

	String name
	CharSequence declaration
	
	new(MachineStructType structType) {
		this.structType = structType
	}
	
	/**
	 * @return the name
	 */
	def String getName() {
		return name
	}
	
	override void initialize(ICodeFragmentContext context, IProgressMonitor monitor) {
		val codeFragmentCollector = context.getCodeFragmentCollector()
		
		val globalNameProvider = context.getGlobalNameProvider()
		
		name = globalNameProvider.newGlobalName("Struct")
		
		declaration = '''
			typedef struct {
				«FOR member : structType.members»
					«member.type.generateDataType(member.name, codeFragmentCollector, this)»;
				«ENDFOR»
			} «name»;
		'''
	}
	
	override CharSequence generateForwardDeclaration(boolean internal) {
		return declaration
	}
	
	override int hashCode() {
		return ^class.hashCode.bitwiseXor(structType.^class.hashCode)
	}
	
	override boolean equals(Object obj) {
		if (obj instanceof StructTypeDeclaration) {
			val other = obj as StructTypeDeclaration
			return other.structType == structType
		}
		return false
	}

}
