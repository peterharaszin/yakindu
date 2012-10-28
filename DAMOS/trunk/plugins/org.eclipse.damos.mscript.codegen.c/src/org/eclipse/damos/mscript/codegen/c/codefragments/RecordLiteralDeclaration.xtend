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

import com.google.inject.Inject
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.damos.mscript.codegen.c.AbstractCodeFragment
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentContext
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorConfiguration
import org.eclipse.damos.mscript.codegen.c.LiteralGenerator
import org.eclipse.damos.mscript.codegen.c.datatype.MachineDataTypes
import org.eclipse.damos.mscript.interpreter.value.RecordValue

import static org.eclipse.damos.mscript.codegen.c.ICodeFragment.*

/**
 * @author Andreas Unger
 *
 */
class RecordLiteralDeclaration extends AbstractCodeFragment {

	@Inject
	LiteralGenerator literalGenerator
	
	val IMscriptGeneratorConfiguration configuration
	val RecordValue recordValue
	
	String typeName
	String name
	
	CharSequence body
	
	new(IMscriptGeneratorConfiguration configuration, RecordValue value) {
		this.configuration = configuration
		this.recordValue = value
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
		var recordTypeDeclaration = new org.eclipse.damos.mscript.codegen.c.codefragments.RecordTypeDeclaration(MachineDataTypes::create(configuration, recordValue.getDataType))
		recordTypeDeclaration = codeFragmentCollector.addCodeFragment(recordTypeDeclaration, monitor)

		typeName = recordTypeDeclaration.name
		name = context.globalNameProvider.newGlobalName("record")
		body = literalGenerator.generateInitializer(configuration.computationModel, codeFragmentCollector, recordValue)
	}

	override boolean contributesInternalForwardDeclaration() {
		return false
	}
	
	override CharSequence generateForwardDeclaration(boolean internal) '''
		extern const «typeName» «name»;
	'''
	
	override boolean contributesImplementation() {
		return true
	}
	
	override CharSequence generateImplementation(boolean internal) '''
		«IF internal»static «ENDIF»const «typeName» «name» = «body»;
	'''
	
	override int hashCode() {
		return ^class.hashCode // TODO: get hash from value
	}
	
	override boolean equals(Object obj) {
		// TODO: check equals using value
		return false
	}

}
