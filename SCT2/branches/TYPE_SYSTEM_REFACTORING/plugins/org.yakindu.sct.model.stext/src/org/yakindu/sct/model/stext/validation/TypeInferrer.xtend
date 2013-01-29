/**
 * Copyright (c) 2011 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 *  
 */
package org.yakindu.sct.model.stext.validation

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.types.Event
import org.yakindu.base.types.Feature
import org.yakindu.base.types.ITypeSystemAccess
import org.yakindu.base.types.Property
import org.yakindu.base.types.Type
import org.yakindu.sct.model.sgraph.Statement
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.AssignmentExpression
import org.yakindu.sct.model.stext.stext.BitwiseAndExpression
import org.yakindu.sct.model.stext.stext.BitwiseOrExpression
import org.yakindu.sct.model.stext.stext.BitwiseXorExpression
import org.yakindu.sct.model.stext.stext.BoolLiteral
import org.yakindu.sct.model.stext.stext.ConditionalExpression
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.model.stext.stext.Expression
import org.yakindu.sct.model.stext.stext.FeatureCall
import org.yakindu.sct.model.stext.stext.HexLiteral
import org.yakindu.sct.model.stext.stext.IntLiteral
import org.yakindu.sct.model.stext.stext.LogicalAndExpression
import org.yakindu.sct.model.stext.stext.LogicalNotExpression
import org.yakindu.sct.model.stext.stext.LogicalOrExpression
import org.yakindu.sct.model.stext.stext.LogicalRelationExpression
import org.yakindu.sct.model.stext.stext.NumericalAddSubtractExpression
import org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression
import org.yakindu.sct.model.stext.stext.NumericalUnaryExpression
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.ParenthesizedExpression
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression
import org.yakindu.sct.model.stext.stext.RealLiteral
import org.yakindu.sct.model.stext.stext.RelationalOperator
import org.yakindu.sct.model.stext.stext.ShiftExpression
import org.yakindu.sct.model.stext.stext.StringLiteral
import org.yakindu.sct.model.stext.stext.UnaryOperator
import java.util.Collection
import org.yakindu.sct.model.stext.stext.EnumLiteral

/**
 * 
 * The TypeInferrer checks an expression AST for type conformance
 * 
 * @author andreas muelder - Initial contribution and API
 * @author Alexander Nyßen - Adopted to changes in type system
 *  
 */
class TypeInferrer implements org.yakindu.sct.model.stext.validation.ITypeInferrer, org.yakindu.sct.model.stext.validation.TypeInferrerCache$ICacheableTypeAnalyzer {
	
	@Inject protected extension
	ITypeSystemAccess ts
	 
	@Inject 
	org.yakindu.sct.model.stext.validation.TypeInferrerCache cache
	
	override Collection<? extends Type>getTypes(Statement stmt) {
		if (stmt == null) {
			return <Type>newArrayList()
		}
		cache.get(stmt, this)
	}
	
	def dispatch Collection<? extends Type> inferType(Expression expr) {
		throw new RuntimeException("Unsupported expression type" + expr)
	}
	
	def dispatch Collection<? extends Type> inferType(Statement stmt){
		throw new RuntimeException("Unsupported statement type" + stmt)
	}
	
	def dispatch Collection<? extends Type> inferType(AssignmentExpression assignment){
		var valueTypes = assignment.expression.getTypes
		var varTypes = assignment.varRef.getTypes
		var types = assign(varTypes, valueTypes)
		if(types.empty){
			error("Can not assign a value of type " + valueTypes.map(t | t.name).join(",") + " to a variable of type " + varTypes.map(t | t.name).join(","))
			return <Type>newArrayList() 
		}
		return types
	}
	/**
	 * Check Event value assignments
	 */
	def dispatch Collection<? extends Type> inferType(EventRaisingExpression eventRaising){
		var eventTypes = eventRaising.event.getTypes
		if(eventRaising.value == null){
			if(getVoidTypes(eventTypes).empty){
				error("Need to assign a value to an event of type " + eventTypes.map(t | t.name).join(","));
				return <Type>newArrayList() 
			}
			return voidTypes
		}
		var valueTypes = eventRaising.value.getTypes
		var types = assign(eventTypes, valueTypes)
		if(types.empty){
			error("Can not assign a value of type " + valueTypes.map(t | t.name).join(",") + " to an event of type " + eventTypes.map(t | t.name).join(","))
			return <Type>newArrayList() 
		}
		return types
	}
	
	def dispatch Collection<? extends Type> inferType(LogicalAndExpression expression){
		return assertBooleanTypes(expression.leftOperand.getTypes,
			expression.rightOperand.getTypes,'&&')
	}
	def dispatch Collection<? extends Type> inferType(LogicalOrExpression expression){
		return assertBooleanTypes(expression.leftOperand.getTypes,
			expression.rightOperand.getTypes,'||')
	}
	
	def assertBooleanTypes(Collection<? extends Type> left, Collection<? extends Type> right, String operator) {
		return combine(assertBooleanTypes(left, operator), assertBooleanTypes(right, operator));
	}
	def dispatch Collection<? extends Type> inferType(LogicalNotExpression expression){
		val types = expression.operand.getTypes;
		return assertBooleanTypes(types, '!');
	}
	
	def dispatch Collection<? extends Type> inferType(BitwiseAndExpression expression){
		return combine(assertIntegerTypes(expression.leftOperand.getTypes, '&'), assertIntegerTypes(expression.rightOperand.getTypes, '&'));
	}
	
	def dispatch Collection<? extends Type> inferType(BitwiseOrExpression expression){
		return combine(assertIntegerTypes(expression.leftOperand.getTypes, '|'), assertIntegerTypes(expression.rightOperand.getTypes, '|'));
	}
	
	def dispatch Collection<? extends Type> inferType(BitwiseXorExpression expression){
		return combine(assertIntegerTypes(expression.leftOperand.getTypes, '^'), assertIntegerTypes(expression.rightOperand.getTypes, '^'));
	}
	
	def dispatch inferType(LogicalRelationExpression expression){ 
		val leftTypes = expression.leftOperand.getTypes
		val rightTypes = expression.rightOperand.getTypes
		val combined = combine(leftTypes, rightTypes)
		if(!getBooleanTypes(combined).empty){
			//If both types are boolean, only relational operators Equals and not_Equals are allowed
			if(expression.operator != RelationalOperator::EQUALS && expression.operator != RelationalOperator::NOT_EQUALS){
				error("operator '" + expression.operator?.literal + "' can not be applied to boolean values!")
				return <Type>newArrayList()
			}
			else{
				return combined
			}
		} else {
			if(combined.empty){
				error("Incompatible operands " + leftTypes.map(t | t.name).join(",") + " and " + rightTypes.map(t | t.name).join(",") + " for operator '" + expression.operator.literal+"'")
				return <Type>newArrayList()
			}
			return booleanTypes
		}
	}
	
	def assertNumericalTypes(Collection<? extends Type> left, Collection<? extends Type> right, String operator) {
		return combine(assertNumericalTypes(left, operator), assertNumericalTypes(right, operator));
	}
	
	def dispatch Collection<? extends Type> inferType(NumericalAddSubtractExpression expression){
		return assertNumericalTypes(expression.leftOperand.getTypes, 
			expression.rightOperand.getTypes, expression.operator.literal
		)
	}
	def dispatch Collection<? extends Type> inferType(NumericalMultiplyDivideExpression expression){
		return assertNumericalTypes(expression.leftOperand.getTypes, 
			expression.rightOperand.getTypes, expression.operator.literal
		)
	}
	def dispatch Collection<? extends Type> inferType(NumericalUnaryExpression expression){
		val types = expression.operand.getTypes
		if(expression.operator == UnaryOperator::COMPLEMENT){
			return assertIntegerTypes(types, expression.operator.literal)
		}
		return assertNumericalTypes(types, expression.operator.literal)
	}	
	
	def dispatch Collection<? extends Type> inferType(PrimitiveValueExpression expression){
		return expression.value.literalTypes;
	}
	
	def dispatch Collection<? extends Type> inferType(ActiveStateReferenceExpression expression){
		return booleanTypes
	}
	
	def dispatch Collection<? extends Type> inferType(ShiftExpression expression){
		val leftTypes = assertIntegerTypes(expression.leftOperand.types, expression.operator.literal)
		val rightTypes = assertIntegerTypes(expression.rightOperand.types, expression.operator.literal)
		return combine(leftTypes, rightTypes)
	}
	
	def dispatch inferType(ConditionalExpression expression){
		assertBooleanTypes(expression.condition.types, '?');
		val trueTypes = expression.trueCase.types
		val falseTypes = expression.falseCase.types
		val types = combine(trueTypes, falseTypes)
		if(types.empty){
			error("True and false case of a conditional have to be of compatible types!")
		}
		return types;
	} 
	
	def dispatch Collection<? extends Type> inferType(FeatureCall featureCall){
		if(featureCall.feature instanceof Event /*ntDefinition*/ 
			&& !(featureCall.eContainer instanceof EventRaisingExpression) 
			&& !(featureCall.eContainer instanceof EventValueReferenceExpression)
		){
			return getBooleanTypes()
		}
		if (featureCall.feature instanceof Feature) {
			val type = (featureCall.feature as Feature).type
			if(type != null){
				return <Type>newArrayList(type)
			}
			return voidTypes
		}
		else if (featureCall.feature !=null) {
			error("Type of FeatureCall is unknown: "+featureCall)			
			return <Type>newArrayList()
		} 
		return voidTypes
	}
	 
	def dispatch Collection<? extends Type> inferType(ElementReferenceExpression expression){
		return expression.reference.inferType(expression)
	}
	
	def dispatch Collection<? extends Type> inferType(EObject object, ElementReferenceExpression expression) {
		return voidTypes
	}
	def dispatch Collection<? extends Type> inferType(Property /*VariableDefinition*/ definition, ElementReferenceExpression expression) {
		if(definition.type != null){
			return <Type>newArrayList(definition.type)
		}
		return voidTypes
	}

	def dispatch Collection<? extends Type> inferType(Event /*Definition*/ definition, ElementReferenceExpression expression) {
		if(expression.eContainer instanceof EventRaisingExpression
				|| expression.eContainer instanceof EventValueReferenceExpression){
			if(definition.type != null){
				return newArrayList(definition.type)
			}
			return voidTypes
		}
		return booleanTypes
	}

	def dispatch Collection<? extends Type> inferType(OperationDefinition definition, ElementReferenceExpression expression) {
		if(definition.type != null){
			return <Type>newArrayList(definition.type)
		}
		return voidTypes
	}
	
	def dispatch Collection<? extends Type> inferType(EventValueReferenceExpression expression){
		return getTypes(expression.value)
	}
	
	def dispatch Collection<? extends Type> inferType(ParenthesizedExpression e){
		return getTypes(e.expression)
	}
	
	def dispatch Collection<? extends Type> getLiteralTypes(HexLiteral literal){
		return integerTypes
	}
	
	def dispatch Collection<? extends Type> getLiteralTypes(IntLiteral literal){
		return integerTypes
	}
	
	def dispatch Collection<? extends Type> getLiteralTypes(BoolLiteral bool){
		return booleanTypes
	}
	
	def dispatch Collection<? extends Type> getLiteralTypes(RealLiteral literal){
		return realTypes
	}
	
	def dispatch Collection<? extends Type> getLiteralTypes(StringLiteral literal){
		return stringTypes
	}
	
	def dispatch Collection<? extends Type> getLiteralTypes(EnumLiteral literal){
		return <Type>newArrayList(literal.type);
	}
	
	def Collection<? extends Type> assertIntegerTypes(Collection<? extends Type> types, String operator){
		var integerTypes = getIntegerTypes(types)
		if(integerTypes.empty){
			error("operator '" +operator+"' can only be applied to integer values!")
		}
		return integerTypes
	}
	
	def Collection<? extends Type> assertRealTypes(Collection<? extends Type> types, String operator){
		var realTypes = getRealTypes(types)
		if(realTypes.empty){
			error("operator '" +operator+"' can only be applied to real values!")
		}
		return types
	}
	
	def Collection<? extends Type> assertNumericalTypes(Collection<? extends Type> types, String operator){
		var numberTypes = <Type>newArrayList()
		numberTypes.addAll(getIntegerTypes(types))
		numberTypes.addAll(getRealTypes(types))
		if(numberTypes.empty){
			error("operator '" +operator+"' can only be applied to numbers!")
		}
		return numberTypes
	}
	
	def Collection<? extends Type> assertBooleanTypes(Collection<? extends Type> types, String operator){
		var booleanTypes = getBooleanTypes(types);
		if(booleanTypes.empty){
			error("operator '" + operator + "' can only be applied to boolean values!")
		}
		return booleanTypes
	}
	
	def Collection<? extends Type> getNumericalTypes(Collection<? extends Type> types){
		var integerTypes = <Type>newArrayList()
		for(Type t: types){
			if(t.integer || t.real){
				integerTypes.add(t)
			}
		}
		return integerTypes;
	}
	
	def Collection<? extends Type> getRealTypes(Collection<? extends Type> types){
		var realTypes = <Type>newArrayList()
		for(Type t: types){
			if(t.real){
				realTypes.add(t)
			}
		}
		return realTypes;
	}
	
	def Collection<? extends Type> getIntegerTypes(Collection<? extends Type> types){
		var integerTypes = <Type>newArrayList()
		for(Type t: types){
			if(t.integer){
				integerTypes.add(t)
			}
		}
		return integerTypes;
	}
	
	def Collection<? extends Type> getBooleanTypes(Collection<? extends Type> types){
		var booleanTypes = <Type>newArrayList()
		for(Type t: types){
			if(t.boolean){
				booleanTypes.add(t)
			}
		}
		return booleanTypes;
	}
	 
	def error(String msg){
		throw new TypeCheckException(msg)
	}
	
	def Collection<? extends Type> getVoidTypes(){
		ts.primitiveTypes.filter(t | ts.isVoid(t)).toList
	}
	
	def Collection<? extends Type> getBooleanTypes(){
		ts.primitiveTypes.filter(t | ts.isBoolean(t)).toList
	}
	
	def Collection<? extends Type> getIntegerTypes(){
		ts.primitiveTypes.filter(t | ts.isInteger(t)).toList
	}
	
	def Collection<? extends Type> getRealTypes(){
		ts.primitiveTypes.filter(t | ts.isReal(t)).toList
	}
	
	def Collection<? extends Type> getStringTypes(){
		ts.primitiveTypes.filter(t | ts.isString(t)).toList
	}

}