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
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineRecordType

/**
 * @author Andreas Unger
 *
 */
class RecordTypeDeclaration extends AbstractCodeFragment {

	val MachineRecordType recordType

	String name
	CharSequence declaration
	
	new(MachineRecordType recordType) {
		this.recordType = recordType
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
		
		name = globalNameProvider.newGlobalName("Record")
		
		declaration = '''
			typedef struct {
				«FOR member : recordType.getMembers»
					«member.getType.generateDataType(member.getName, codeFragmentCollector, this)»;
				«ENDFOR»
			} «name»;
		'''
	}
	
	override CharSequence generateForwardDeclaration(boolean internal) {
		return declaration
	}
	
	override int hashCode() {
		return ^class.hashCode.bitwiseXor(recordType.^class.hashCode)
	}
	
	override boolean equals(Object obj) {
		if (obj instanceof RecordTypeDeclaration) {
			val other = obj as RecordTypeDeclaration
			return other.recordType == recordType
		}
		return false
	}

}
