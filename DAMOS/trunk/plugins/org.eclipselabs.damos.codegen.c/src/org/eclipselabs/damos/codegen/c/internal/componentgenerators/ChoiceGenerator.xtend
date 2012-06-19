/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.codegen.c.internal.componentgenerators

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipselabs.damos.codegen.c.AbstractComponentGenerator
import org.eclipselabs.damos.codegen.c.internal.util.CompoundGeneratorUtil
import org.eclipselabs.damos.codegen.c.util.GeneratorUtil
import org.eclipselabs.damos.dml.Choice
import org.eclipselabs.damos.dml.ValueSpecification
import org.eclipselabs.damos.dml.util.DMLUtil
import org.eclipselabs.damos.dmltext.MscriptValueSpecification
import org.eclipselabs.damos.mscript.codegen.c.ExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.IExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.MscriptGeneratorContext

/**
 * @author Andreas Unger
 *
 */
class ChoiceGenerator extends AbstractComponentGenerator {
	
	val IExpressionGenerator expressionGenerator = new ExpressionGenerator()

	override boolean contributesComputeOutputsCode() {
		return true
	}
	
	override CharSequence generateComputeOutputsCode(IProgressMonitor monitor) {
		val choice = component as Choice
		
		val incomingVariableName = GeneratorUtil::getIncomingVariableName(configuration, node, choice.firstInputPort)
		val choiceResult = CompoundGeneratorUtil::getChoiceVariableName(configuration, node)
		
		var actionLinks = choice.actionLinks.filter(l | l.condition != null)
		var defaultActionLink = choice.actionLinks.filter(l | l.condition == null).head
		
		'''
			«FOR actionLink : actionLinks»
				«IF actionLink != actionLinks.head»} else «ENDIF»if («incomingVariableName» == («generateValueSpecification(actionLink.condition)»)) {
					«choiceResult» = «DMLUtil::indexOf(actionLink)»;
			«ENDFOR»
			«IF defaultActionLink != null»
				} else {
					«choiceResult» = «DMLUtil::indexOf(defaultActionLink)»;
			«ENDIF»
			}
		'''
	}
	
	def private generateValueSpecification(ValueSpecification valueSpecification) {
		if (valueSpecification instanceof MscriptValueSpecification) {
			val condition = valueSpecification as MscriptValueSpecification
			val mscriptGeneratorContext = new MscriptGeneratorContext(computationModel, new org.eclipselabs.damos.mscript.interpreter.StaticEvaluationResult(), [v | ""], context.codeFragmentCollector)
			return expressionGenerator.generate(mscriptGeneratorContext, condition.expression)
		}
		return "INVALID_EXPRESSION"
	}
	
}
