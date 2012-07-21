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
import org.eclipselabs.damos.mscript.interpreter.value.IArrayValue

/**
 * @author Andreas Unger
 *
 */
class ArrayLiteralDeclaration extends AbstractCodeFragment {

	val DataTypeGenerator dataTypeGenerator = new DataTypeGenerator()
	val LiteralGenerator literalGenerator = new LiteralGenerator(dataTypeGenerator)
	
	val IMscriptGeneratorConfiguration configuration
	val IArrayValue arrayValue
	
	String name
	CharSequence type
	CharSequence body

	new(IMscriptGeneratorConfiguration configuration, IArrayValue value) {
		this.configuration = configuration
		this.arrayValue = value
	}
	
	/**
	 * @return the name
	 */
	def String getName() {
		return name
	}
	
	override void initialize(ICodeFragmentContext context, IProgressMonitor monitor) {
		val codeFragmentCollector = context.codeFragmentCollector
		val arrayType = MachineDataTypes::create(configuration, arrayValue.dataType)
		
		val preferredName = switch (arrayType.dimensionality) {
		case 1:
			"vector"
		case 2:
			"matrix"
		default:
			"array"
		}

		name = context.globalNameProvider.newGlobalName(preferredName)
		type = arrayType.generateDataType(name, codeFragmentCollector, this)
		body = literalGenerator.generateInitializer(configuration.computationModel, codeFragmentCollector, arrayValue)
	}
	
	override boolean contributesInternalForwardDeclaration() {
		return false
	}
	
	override CharSequence generateForwardDeclaration(boolean internal) '''
		extern const «type»;
	'''
	
	override boolean contributesImplementation() {
		return true
	}
	
	override CharSequence generateImplementation(boolean internal) '''
		«IF internal»static «ENDIF»const «type» = «body»;
	'''

	override int hashCode() {
		return ^class.hashCode // TODO: get hash from value
	}
	
	override boolean equals(Object obj) {
		// TODO: check equals using value
		return false
	}

}
