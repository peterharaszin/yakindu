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
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineArrayType
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel

/**
 * @author Andreas Unger
 *
 */
class ArrayTypeDeclaration extends AbstractCodeFragment {

	val ComputationModel computationModel
	val MachineArrayType arrayType

	CharSequence elementType
	String name
	
	@Inject
	new(@Assisted ComputationModel computationModel, @Assisted MachineArrayType arrayType) {
		this.computationModel = computationModel
		this.arrayType = arrayType
	}
	
	/**
	 * @return the name
	 */
	def String getName() {
		return name
	}
	
	override initialize(ICodeFragmentContext context, IProgressMonitor monitor) {
		elementType = arrayType.elementType.generateDataType(computationModel, context.codeFragmentCollector, this)
		name = context.globalNameProvider.newGlobalName("Array")
	}
	
	override CharSequence generateForwardDeclaration(boolean internal) '''
		typedef struct { «elementType» data[«arrayType.getDimension(0)»]; } «name»;
		«IF !internal»
			#define «name.toUpperCase()»_SIZE «arrayType.getDimension(0)»
		«ENDIF»
	'''
	
	override int hashCode() {
		return ^class.hashCode.bitwiseXor(arrayType.hashCode)
	}
	
	override boolean equals(Object obj) {
		if (obj instanceof ArrayTypeDeclaration) {
			val other = obj as ArrayTypeDeclaration
			return other.arrayType == arrayType
		}
		return false;
	}

}
