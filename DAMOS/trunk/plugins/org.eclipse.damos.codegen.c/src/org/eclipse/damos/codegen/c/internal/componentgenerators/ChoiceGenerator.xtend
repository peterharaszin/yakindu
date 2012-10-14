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

package org.eclipse.damos.codegen.c.internal.componentgenerators

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.damos.codegen.c.AbstractComponentGenerator
import org.eclipse.damos.codegen.c.MscriptGeneratorConfiguration
import org.eclipse.damos.codegen.c.internal.util.CompoundGeneratorUtil
import org.eclipse.damos.codegen.c.util.GeneratorUtil
import org.eclipse.damos.dml.Choice
import org.eclipse.damos.dml.ValueSpecification
import org.eclipse.damos.dml.util.DMLUtil
import org.eclipse.damos.dscript.DscriptValueSpecification
import org.eclipse.damos.mscript.codegen.c.ExpressionGenerator
import org.eclipse.damos.mscript.codegen.c.IExpressionGenerator
import org.eclipse.damos.mscript.codegen.c.MscriptGeneratorContext
import org.eclipse.damos.mscript.interpreter.StaticFunctionInfo

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
		if (valueSpecification instanceof DscriptValueSpecification) {
			val condition = valueSpecification as DscriptValueSpecification
			val staticFunctionInfo = new StaticFunctionInfo(null)
			val mscriptGeneratorContext = new MscriptGeneratorContext(new MscriptGeneratorConfiguration(computationModel, configuration), staticFunctionInfo, context.node.sampleTime, new ChoiceVariableAccessStrategy(), context.codeFragmentCollector)
			return expressionGenerator.generate(mscriptGeneratorContext, condition.getExpression)
		}
		return "INVALID_EXPRESSION"
	}
	
}
