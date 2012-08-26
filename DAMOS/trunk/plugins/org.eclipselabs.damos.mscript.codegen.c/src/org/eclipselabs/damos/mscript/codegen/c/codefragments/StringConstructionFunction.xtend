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

import java.util.ArrayList
import java.util.Collection
import java.util.List
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorConfiguration
import org.eclipselabs.damos.mscript.codegen.c.Include
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineNumericType
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineStringType
import org.eclipselabs.damos.mscript.computation.FixedPointFormat

import static org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.*

/**
 * @author Andreas Unger
 *
 */
class StringConstructionFunction extends AbstractCodeFragment {

	val IMscriptGeneratorConfiguration configuration
	val List<IStringSegment> stringSegments
	val boolean plain
	
	String typeName
	String name
	
	String stringTableName
	
	CharSequence functionSignature
	
	new(IMscriptGeneratorConfiguration configuration, List<? extends IStringSegment> stringSegments, boolean plain) {
		this.configuration = configuration
		this.stringSegments = new ArrayList<IStringSegment>(stringSegments)
		this.plain = plain
	}
	
	/**
	 * @return the name
	 */
	def String getName() {
		return name
	}
	
	override void initialize(ICodeFragmentContext context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, [it instanceof StringTypeDeclaration])
		addDependency(IMPLEMENTATION_DEPENDS_ON, [it instanceof StringTable])

		val codeFragmentCollector = context.codeFragmentCollector
		val stringTypeDeclaration = codeFragmentCollector.addCodeFragment(new StringTypeDeclaration(configuration.stringBufferSize), monitor)
		val stringTable = codeFragmentCollector.addCodeFragment(new StringTable(), monitor)

		typeName = stringTypeDeclaration.name
		name = context.globalNameProvider.newGlobalName("newString")
		
		stringTableName = stringTable.name
		
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
	
	override Collection<Include> getImplementationIncludes() {
		return new ArrayList<Include>() => [
			add(new Include("inttypes.h"))
			add(new Include("stdio.h"))
		]
	}

	override CharSequence generateImplementation(boolean internal) {
		var index = 0
		'''
			«IF internal»static «ENDIF»«functionSignature» {
				«typeName» result;
				int i = 0;
				
				«FOR s : stringSegments»
					«generateStringSegment(s, index = index + 1)»
				«ENDFOR»
				
				result.data[i] = '\0';
				
				return result;
			}
		'''
	}
	
	def private dispatch CharSequence generateStringSegment(ConstantStringSegment s, int index) '''
		if (i < «configuration.stringBufferSize - 1») {
			result.data[i++] = 0x80 | s«index»;
		}
	'''

	def private dispatch CharSequence generateStringSegment(ExpressionStringSegment s, int index) '''
		«IF !plain»
			if (i < «configuration.stringBufferSize - 1») {
				result.data[i++] = 0x80 | indent«index»;
			}
		«ENDIF»
		«IF s.static_»
			result.data[i++] = 0x80 | s«index»;
		«ELSE»
			«generateExpressionStringSegment(s.dataType, index)»
		«ENDIF»
		«IF !plain»
			if (i < «configuration.stringBufferSize - 1») {
				result.data[i++] = 0x03;
			}
		«ENDIF»
	'''
	
	def private dispatch CharSequence generateExpressionStringSegment(MachineStringType type, int index) '''
		{
			int j;
			for (j = 0; i < «configuration.stringBufferSize - 1» && s«index»[j] != '\0'; ++j) {
				result.data[i++] = s«index»[j];
			}
		}
	'''
	
	def private dispatch CharSequence generateExpressionStringSegment(MachineNumericType type, int index) '''
		i += snprintf(result.data + i, «configuration.stringBufferSize» - i, "%" PRId«getWordSize(type)», s«index»);
		if (i > «configuration.stringBufferSize - 1») {
			i = «configuration.stringBufferSize - 1»;
		}
	'''
	
	def private int getWordSize(MachineNumericType type) {
		if (type.numberFormat instanceof FixedPointFormat) {
			return (type.numberFormat as FixedPointFormat).wordSize
		}
		return 0
	}

	def private CharSequence generateFunctionSignature(ICodeFragmentCollector codeFragmentCollector) {
		var index = 0
		'''«typeName» «name»(«FOR s : stringSegments SEPARATOR ", "»«generateFunctionParameter(codeFragmentCollector, s, index = index + 1)»«ENDFOR»)'''
	}
	
	def private dispatch CharSequence generateFunctionParameter(ICodeFragmentCollector codeFragmentCollector, ConstantStringSegment s, int index) '''
		«s.generateDataType(codeFragmentCollector, this)»s«index»'''
	
	def private dispatch CharSequence generateFunctionParameter(ICodeFragmentCollector codeFragmentCollector, ExpressionStringSegment s, int index) '''
		«IF !plain»int indent«index», «ENDIF»«s.generateDataType(codeFragmentCollector, this)»s«index»'''

	override int hashCode() {
		return ^class.hashCode.bitwiseXor(stringSegments.hashCode).bitwiseXor(if (plain) 1 else 0)
	}
	
	override boolean equals(Object obj) {
		if (obj instanceof StringConstructionFunction) {
			val other = obj as StringConstructionFunction
			return other.plain == plain && other.stringSegments == stringSegments
		}
		return false
	}
	
}
