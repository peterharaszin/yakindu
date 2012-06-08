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

package org.eclipselabs.damos.codegen.c.internal.generators

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipselabs.damos.mscript.VariableDeclaration
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil

/**
 * @author Andreas Unger
 *
 */
class BehavioredBlockContextCodeGenerator {

	def generateContextCode(IBehavioredBlockGeneratorContext context, CharSequence typeName, IProgressMonitor monitor) '''
		typedef struct {
			«FOR d : context.getFunctionInstance().getFunctionDeclaration().getInputParameterDeclarations()»
				«IF hasContext(context, d)»
					«generateContextStructureMember(context, monitor, d)»
				«ENDIF»
			«ENDFOR»
			«FOR d : context.getFunctionInstance().getFunctionDeclaration().getOutputParameterDeclarations()»
				«IF hasContext(context, d)»
					«generateContextStructureMember(context, monitor, d)»
				«ENDIF»
			«ENDFOR»
			«FOR d : context.getFunctionInstance().getFunctionDeclaration().getStateVariableDeclarations()»
				«generateContextStructureMember(context, monitor, d)»
			«ENDFOR»
		} «typeName»;
	'''
	
	def private generateContextStructureMember(IBehavioredBlockGeneratorContext context, IProgressMonitor monitor, VariableDeclaration variableDeclaration) {
		val name = variableDeclaration.getName();
		val dataType = context.getStaticEvaluationContext().getValue(variableDeclaration).getDataType();
		val cVariableDeclaration = MscriptGeneratorUtil::getCVariableDeclaration(context.getComputationModel(), context.getComponentGeneratorContext().getCodeFragmentCollector(), dataType, name, false, null);
		if (hasContext(context, variableDeclaration)) {
			val bufferSize = context.getStaticEvaluationContext().getCircularBufferSize(variableDeclaration);
			val indexCDataType = MscriptGeneratorUtil::getIndexCDataType(context.getComputationModel(), 2 * bufferSize);
			return '''
				«cVariableDeclaration»[«bufferSize»];
				«indexCDataType» «name»_index;
			''';
		}
		return '''«cVariableDeclaration»;''';
	}

	def private boolean hasContext(IBehavioredBlockGeneratorContext context, VariableDeclaration variableDeclaration) {
		return context.getStaticEvaluationContext().getCircularBufferSize(variableDeclaration) > 1;
	}

}
