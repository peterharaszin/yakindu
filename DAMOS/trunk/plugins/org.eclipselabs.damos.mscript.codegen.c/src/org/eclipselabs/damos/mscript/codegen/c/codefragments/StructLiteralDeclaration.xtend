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
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorConfiguration
import org.eclipselabs.damos.mscript.codegen.c.LiteralGenerator
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataTypes
import org.eclipselabs.damos.mscript.interpreter.value.StructValue

import static org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.*

/**
 * @author Andreas Unger
 *
 */
class StructLiteralDeclaration extends AbstractCodeFragment {

	val LiteralGenerator literalGenerator = new LiteralGenerator(new DataTypeGenerator())
	
	val IMscriptGeneratorConfiguration configuration
	val StructValue structValue
	
	String typeName
	String name
	
	CharSequence body
	
	new(IMscriptGeneratorConfiguration configuration, StructValue value) {
		this.configuration = configuration
		this.structValue = value
	}
	
	/**
	 * @return the name
	 */
	def String getName() {
		return name
	}
	
	override void initialize(ICodeFragmentContext context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, [it instanceof StructTypeDeclaration])

		val codeFragmentCollector = context.codeFragmentCollector
		var structTypeDeclaration = new StructTypeDeclaration(MachineDataTypes::create(configuration, structValue.dataType))
		structTypeDeclaration = codeFragmentCollector.addCodeFragment(structTypeDeclaration, monitor)

		typeName = structTypeDeclaration.name
		name = context.globalNameProvider.newGlobalName("structure")
		body = literalGenerator.generateInitializer(configuration.computationModel, codeFragmentCollector, structValue)
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
