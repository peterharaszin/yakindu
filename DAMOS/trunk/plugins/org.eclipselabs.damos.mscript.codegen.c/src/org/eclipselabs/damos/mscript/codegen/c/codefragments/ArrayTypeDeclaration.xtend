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

/**
 * @author Andreas Unger
 *
 */
class ArrayTypeDeclaration extends AbstractCodeFragment {

	val MachineArrayType arrayType

	CharSequence elementType
	String name
	
	@Inject
	new(@Assisted MachineArrayType arrayType) {
		this.arrayType = arrayType
	}
	
	/**
	 * @return the name
	 */
	def String getName() {
		return name
	}
	
	override initialize(ICodeFragmentContext context, IProgressMonitor monitor) {
		elementType = arrayType.elementType.generateDataType(context.codeFragmentCollector, this)
		val preferredName = switch (arrayType.dimensionality) {
		case 1:
			"Vector"
		case 2:
			"Matrix"
		default:
			"Array"
		}
		name = context.globalNameProvider.newGlobalName(preferredName)
	}
	
	override CharSequence generateForwardDeclaration(boolean internal) '''
		typedef struct { «elementType» data«FOR size : arrayType.dimensionSizes»[«size»]«ENDFOR»; } «name»;
		«IF !internal»
			«IF arrayType.dimensionality == 1»
				#define «name.toUpperCase()»_SIZE «arrayType.getDimensionSize(0)»
			«ELSEIF arrayType.dimensionality == 2»
				#define «name.toUpperCase()»_ROW_SIZE «arrayType.getDimensionSize(0)»
				#define «name.toUpperCase()»_COLUMN_SIZE «arrayType.getDimensionSize(1)»
			«ELSE»
				«FOR i : 0 .. arrayType.dimensionality - 1»
					#define «name.toUpperCase()»_SIZE«i» «arrayType.getDimensionSize(i)»
				«ENDFOR»
			«ENDIF»
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
		return false
	}

}
