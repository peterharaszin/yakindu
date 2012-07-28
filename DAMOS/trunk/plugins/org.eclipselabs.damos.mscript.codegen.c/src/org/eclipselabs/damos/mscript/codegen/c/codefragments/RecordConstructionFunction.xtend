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

import java.util.HashSet
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineRecordType

import static org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.*

/**
 * @author Andreas Unger
 *
 */
class RecordConstructionFunction extends AbstractCodeFragment {

	static val String PREFERRED_VARIABLE_NAME = "s"
	
	val MachineRecordType recordType
	
	String typeName
	String name
	
	CharSequence functionSignature
	
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
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, [it instanceof RecordTypeDeclaration])

		val codeFragmentCollector = context.codeFragmentCollector
		val recordTypeDeclaration = codeFragmentCollector.addCodeFragment(new org.eclipselabs.damos.mscript.codegen.c.codefragments.RecordTypeDeclaration(recordType), monitor);

		typeName = recordTypeDeclaration.name
		name = context.globalNameProvider.newGlobalName("newRecord")
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
	
	override CharSequence generateImplementation(boolean internal) {
		var v = variableName
		
		'''
			«IF internal»static «ENDIF»«functionSignature» {
				«typeName» «v»;
				«FOR member : recordType.getMembers»
					«v».«member.getName» = «member.getName»;
				«ENDFOR»
				return «v»;
			}
		'''
	}
	
	def private CharSequence generateFunctionSignature(ICodeFragmentCollector codeFragmentCollector) '''
		«typeName» «name»(«FOR member : recordType.getMembers SEPARATOR ", "»«member.getType.generateDataType(member.getName, codeFragmentCollector, this)»«ENDFOR»)'''
	
	def private String getVariableName() {
		val names = new HashSet<String>(recordType.getMembers.map([it.getName]))
		var name = PREFERRED_VARIABLE_NAME
		var i = 2
		while (names.contains(name)) {
			name = PREFERRED_VARIABLE_NAME + i
			i = i + 1
		}
		return name
	}
	
	override int hashCode() {
		return ^class.hashCode.bitwiseXor(recordType.hashCode)
	}
	
	override boolean equals(Object obj) {
		if (obj instanceof RecordConstructionFunction) {
			val other = obj as RecordConstructionFunction
			return other.recordType == recordType
		}
		return false
	}

}
