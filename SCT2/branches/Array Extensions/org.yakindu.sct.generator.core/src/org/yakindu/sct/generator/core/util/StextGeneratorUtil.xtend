package org.yakindu.sct.generator.core.util

import org.yakindu.base.expressions.expressions.ArrayInitializationExpression
import org.yakindu.base.expressions.expressions.Literal
import org.yakindu.base.expressions.expressions.StringLiteral
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.IntLiteral
import org.yakindu.base.expressions.expressions.RealLiteral

class StextGeneratorUtil {
	
	def static String createArrayListString(ArrayInitializationExpression expression) {
		var initValues = "";
		var dimValues = "";
		if (expression == null) return initValues
		if (!expression.values.nullOrEmpty) {
			for (index : expression.values) {
				initValues = initValues + getValueForLiteral(index) 
				if (!index.equals(expression.values.last)) initValues = initValues + ', ' 
			}
			return '{' + initValues + '}'
		}
		else {
			for (dimArray : expression.dim) {
				dimValues = dimValues + createArrayListString(dimArray as ArrayInitializationExpression)
				if (!dimArray.equals(expression.dim.last)) dimValues = dimValues + ', ' 
			}
			return '{' + dimValues + '}'
		}
	}
	
	def static Object getValueForLiteral(Literal literal) {
		if (literal instanceof StringLiteral) {
			(literal as StringLiteral).value
		} else if (literal instanceof BoolLiteral) {
			(literal as BoolLiteral).value
		} else if (literal instanceof IntLiteral) {
			(literal as IntLiteral).value
		} else if (literal instanceof RealLiteral) {
			(literal as RealLiteral).value
		}
	}
	
}