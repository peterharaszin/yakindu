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

import com.google.inject.Inject
import com.google.inject.assistedinject.Assisted
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorConfiguration
import org.eclipselabs.damos.mscript.codegen.c.LiteralGenerator
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataTypes
import org.eclipselabs.damos.mscript.interpreter.value.IArrayValue

import static org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.*

/**
 * @author Andreas Unger
 *
 */
class ArrayLiteralDeclaration extends AbstractCodeFragment {

	val LiteralGenerator literalGenerator = new LiteralGenerator(new DataTypeGenerator())
	
	val IMscriptGeneratorConfiguration configuration
	val IArrayValue arrayValue
	
	String name
	String typeName
	CharSequence body

	@Inject
	new(@Assisted IMscriptGeneratorConfiguration configuration, @Assisted IArrayValue value) {
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
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, [it instanceof ArrayTypeDeclaration])
		
		val codeFragmentCollector = context.codeFragmentCollector
		val arrayType = MachineDataTypes::create(configuration, arrayValue.dataType)
		val arrayTypeDeclaration = codeFragmentCollector.addCodeFragment(new ArrayTypeDeclaration(arrayType), monitor)
		
		val preferredName = switch (arrayType.dimensionality) {
		case 1:
			"vector"
		case 2:
			"matrix"
		default:
			"array"
		}

		typeName = arrayTypeDeclaration.name
		name = context.globalNameProvider.newGlobalName(preferredName)
		body = literalGenerator.generateInitializer(configuration.computationModel, codeFragmentCollector, arrayValue)
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
