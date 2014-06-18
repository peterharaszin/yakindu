/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.sexec.interpreter

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.AssignmentOperator
import org.yakindu.base.expressions.expressions.BitwiseAndExpression
import org.yakindu.base.expressions.expressions.BitwiseOrExpression
import org.yakindu.base.expressions.expressions.BitwiseXorExpression
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.ConditionalExpression
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.HexLiteral
import org.yakindu.base.expressions.expressions.IntLiteral
import org.yakindu.base.expressions.expressions.LogicalAndExpression
import org.yakindu.base.expressions.expressions.LogicalNotExpression
import org.yakindu.base.expressions.expressions.LogicalOrExpression
import org.yakindu.base.expressions.expressions.LogicalRelationExpression
import org.yakindu.base.expressions.expressions.NullLiteral
import org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression
import org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression
import org.yakindu.base.expressions.expressions.NumericalUnaryExpression
import org.yakindu.base.expressions.expressions.ParenthesizedExpression
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.RealLiteral
import org.yakindu.base.expressions.expressions.ShiftExpression
import org.yakindu.base.expressions.expressions.StringLiteral
import org.yakindu.base.types.Enumerator
import org.yakindu.base.types.Operation
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.simulation.core.sruntime.CompositeSlot
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext
import org.yakindu.sct.simulation.core.sruntime.ExecutionEvent
import org.yakindu.sct.simulation.core.sruntime.ExecutionVariable
import org.yakindu.base.expressions.expressions.ArrayInitializationExpression
import java.util.List
import java.util.ArrayList
import org.eclipse.emf.common.util.EList

/**
 * 
 * @author andreas muelder - Initial contribution and API 
 * @authos axel terfloth - additions
 * 
 */
class StextStatementInterpreter extends AbstractStatementInterpreter {

	@Inject
	extension IQualifiedNameProvider provider
	@Inject
	protected IOperationMockup operationDelegate
	@Inject
	protected extension IExecutionSlotResolver resolver

	protected ExecutionContext context

	override Object evaluateStatement(Expression statement, ExecutionContext context) {
		this.context = context
		statement.execute()
	}

	def dispatch Object execute(Expression statement) {
		null
	}

	def dispatch Object execute(AssignmentExpression assignment) {
		executeAssignment(assignment)
	}

	def Object executeAssignment(AssignmentExpression assignment) {
		var scopeVariable = context.resolve(assignment.varRef)
		var result = assignment.expression.execute
		
		if (scopeVariable.value instanceof List<?>){
			var arrayList = getArrayList(scopeVariable.value as List<Object>, getArraySelector(assignment), 0)
			arrayList.set(getArraySelector(assignment).last.execute as Integer, result)
		}
		else if (assignment.operator == AssignmentOperator::ASSIGN) {
			scopeVariable.value = result
		} 
		else {
			var operator = AbstractStatementInterpreter::assignFunctionMap.get(assignment.operator.getName())
			scopeVariable.value = evaluate(operator, scopeVariable.getValue, result)
		}
		scopeVariable.value
	}
	
	def List<Object> getArrayList(List<Object> arrayList, EList<Expression> selector, int index) {
		val dimSelector = selector.get(index).execute as Integer
		if (arrayList.get(dimSelector) instanceof List<?>){
			return getArrayList(arrayList.get(dimSelector) as List, selector, index+1)
		}
		return arrayList
	}
	
	def getArraySelector(AssignmentExpression expression) {
		if (expression.varRef instanceof FeatureCall){
			return (expression.varRef as FeatureCall).arraySelector
		}
		else if (expression.varRef instanceof ElementReferenceExpression){
			return (expression.varRef as ElementReferenceExpression).arraySelector
		}
	}

	def dispatch Object execute(EventRaisingExpression eventRaising) {
		var event = context.resolve(eventRaising.event)
		if (eventRaising.value != null) {
			event.value = eventRaising.value.execute
		}
		if (event instanceof ExecutionEvent) {
			(event as ExecutionEvent).raised = true
		}
		null
	}

	def dispatch Object execute(ConditionalExpression expression) {
		if (expression.condition.execute as Boolean) {
			return expression.trueCase.execute
		} else {
			return expression.falseCase.execute
		}
	}

	def dispatch Object execute(ElementReferenceExpression expression) {
		var parameter = expression.args.map(it|execute)
		if (expression.operationCall) {
			if (operationDelegate.canExecute(expression.reference as Operation, parameter.toArray)) {
				return operationDelegate.execute((expression.reference as Operation), parameter.toArray)
			}
		}
		else if (expression.arrayAccess) {
			var arrayVariable = context.resolve(expression)
		    return getArrayValue(arrayVariable.value as List<Object>, expression.arraySelector, 0)
		} 
		
		val executionSlot = context.resolve(expression)
		if (executionSlot instanceof ExecutionVariable)
			return executionSlot.getValue
		if (executionSlot instanceof ExecutionEvent)
			return (executionSlot as ExecutionEvent).raised
		// reference to an element with complex type is not reflected in an execution variable but in a composite slot
		// TODO hide reference mechanism in resolver
		if (executionSlot instanceof CompositeSlot)
			return executionSlot
			
		return null
	}
	
	def Object getArrayValue(List<Object> arrayList, EList<Expression> selector, Integer index) {
		val arrayValue = try { 
			arrayList.get(selector.get(index).execute as Integer)
		} catch (ArrayIndexOutOfBoundsException ex) {
			//TODO: handle ArrayIndexOutOfBoundsException
		}
		if (arrayValue instanceof List<?>){
			return getArrayValue(arrayValue as List, selector, index+1);
		}
		return arrayValue
	}
	

	
	def dispatch Object execute(ArrayInitializationExpression expression) {
		createArrayList(expression, new ArrayList);
	}
	
	def List<Object> createArrayList(ArrayInitializationExpression expression, List<Object> arrayList) {
		if (!expression.values.nullOrEmpty) {
			for(value: expression.values){
				arrayList.add(value.valueLiteral)
			}
		   return arrayList
		}
		for (dimArray : expression.dim) {
			var List<Object> dimList = new ArrayList
			arrayList.add(createArrayList(dimArray as ArrayInitializationExpression, dimList))
		}
		return arrayList
	}
	

	def dispatch Object execute(EventValueReferenceExpression expression) {
		for (event : context.raisedEvents) {
			val executionSlot = context.resolve(expression.value)
			if (executionSlot instanceof ExecutionEvent && executionSlot.fqName == event.fqName) {
				return event.getValue;
			};
		}
		null;
	}

	def dispatch qname(FeatureCall e) {
		return e.feature.getFullyQualifiedName.toString
	}

	def dispatch qname(ElementReferenceExpression e) {
		e.reference.getFullyQualifiedName.toString
	}

	def dispatch Object execute(ActiveStateReferenceExpression expression) {
		var state = expression.value
		return context.allActiveStates.contains(state)
	}

	def dispatch Object execute(LogicalAndExpression expression) {
		var leftResult = execute(expression.leftOperand)
		if (!leftResult as Boolean)
			return false
		var rightResult = execute(expression.rightOperand)
		return leftResult as Boolean && rightResult as Boolean
	}

	def dispatch Object execute(LogicalOrExpression expression) {
		var leftResult = execute(expression.leftOperand)
		if (leftResult as Boolean)
			return true
		var rightResult = execute(expression.rightOperand)
		return leftResult as Boolean || rightResult as Boolean
	}

	def dispatch Object execute(LogicalNotExpression expression) {
		return ! (expression.operand.execute() as Boolean)
	}

	def dispatch Object execute(BitwiseAndExpression expression) {
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, CoreFunction::BIT_AND)
	}

	def dispatch Object execute(BitwiseOrExpression expression) {
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, CoreFunction::BIT_OR)
	}

	def dispatch Object execute(BitwiseXorExpression expression) {
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, CoreFunction::BIT_XOR)
	}

	def dispatch Object execute(LogicalRelationExpression expression) {
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, expression.operator.getName())
	}

	def dispatch Object execute(NumericalAddSubtractExpression expression) {
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, expression.operator.literal)
	}

	def dispatch Object execute(NumericalMultiplyDivideExpression expression) {
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, expression.operator.getName())
	}

	def dispatch Object execute(ShiftExpression expression) {
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, expression.operator.getName())
	}

	def dispatch Object execute(NumericalUnaryExpression expression) {
		executeUnaryCoreFunction(expression.operand, expression.operator.getName())
	}

	def executeBinaryCoreFunction(Expression leftStatement, Expression rightStatement, String operator) {
		var leftResult = leftStatement.execute()
		var rightResult = rightStatement.execute()
		return evaluate(operator, leftResult, rightResult)
	}

	def executeUnaryCoreFunction(Expression statement, String operator) {
		var result = statement.execute()
		return evaluate(operator, result);
	}

	def dispatch Object execute(FeatureCall call) {
		executeFeatureCall(call)
	}
	
	def executeFeatureCall(FeatureCall call) {
		if (call.operationCall) {
			var parameter = call.args.map(it|execute)
			if (operationDelegate.canExecute(call, parameter)) {
				return operationDelegate.execute(call, parameter)
			}
		} 
		else if (call.getFeature() instanceof Enumerator) {
			return call.getFeature();
		}
		
		else if (call.arrayAccess) {
			var arrayVariable = context.resolve(call)
		    var arrayList = arrayVariable.value as List<Object>
		    getArrayValue(arrayList, call.arraySelector, 0)
		} 
		
		else {
			var variableRef = context.resolve(call)
			if (variableRef instanceof ExecutionVariable || variableRef instanceof CompositeSlot) {
				return variableRef.getValue
			}
			if (variableRef instanceof ExecutionEvent)
				return (variableRef as ExecutionEvent).raised
				
			println("No feature found for " + call.feature.fqn + " -> returning null")
			return null;
		}
	}
	
	def String fqn(EObject obj) {
		obj.getFullyQualifiedName.toString
	}

	def dispatch Object execute(ParenthesizedExpression e) {
		e.expression.execute()
	}

	def dispatch Object execute(PrimitiveValueExpression expression) {
		return expression.value.valueLiteral
	}

	def dispatch valueLiteral(IntLiteral literal) {
		return literal.value
	}

	def dispatch valueLiteral(HexLiteral literal) {
		return literal.value
	}

	def dispatch valueLiteral(BoolLiteral bool) {
		return bool.value
	}

	def dispatch valueLiteral(RealLiteral literal) {
		return literal.value
	}

	def dispatch valueLiteral(StringLiteral literal) {
		return literal.value
	}
	def dispatch valueLiteral(NullLiteral literal) {
		return null
	}

}
