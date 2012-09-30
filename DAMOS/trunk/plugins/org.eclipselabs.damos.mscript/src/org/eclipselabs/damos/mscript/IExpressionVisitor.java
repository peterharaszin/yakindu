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

package org.eclipselabs.damos.mscript;

/**
 * @author Andreas Unger
 *
 */
public interface IExpressionVisitor<R, C> {

	R visit(C context, LetExpression letExpression);
	R visit(C context, IfExpression ifExpression);
	R visit(C context, InspectExpression inspectExpression);
	R visit(C context, RangeExpression rangeExpression);
	R visit(C context, ImpliesExpression impliesExpression);
	R visit(C context, LogicalOrExpression logicalOrExpression);
	R visit(C context, LogicalAndExpression logicalAndExpression);
	R visit(C context, EqualityExpression equalityExpression);
	R visit(C context, RelationalExpression relationalExpression);
	R visit(C context, TypeTestExpression typeTestExpression);
	R visit(C context, AdditiveExpression additiveExpression);
	R visit(C context, MultiplicativeExpression multiplicativeExpression);
	R visit(C context, UnaryExpression unaryExpression);
	R visit(C context, ArrayConstructionOperator arrayConstructionOperator);
	R visit(C context, ArrayConcatenationOperator arrayConcatenationOperator);
	R visit(C context, RecordConstructionOperator recordConstructionOperator);
	R visit(C context, UnionConstructionOperator unionConstructionOperator);
	R visit(C context, UnitConstructionOperator unitConstructionOperator);
	R visit(C context, PowerExpression powerExpression);
	R visit(C context, ParenthesizedExpression parenthesizedExpression);
	R visit(C context, ArrayElementAccess arrayElementAccess);
	R visit(C context, FeatureReference featureReference);
	R visit(C context, MemberVariableAccess memberVariableAccess);
	R visit(C context, FunctionCall functionCall);
	R visit(C context, EndExpression endExpression);
	R visit(C context, RealLiteral realLiteral);
	R visit(C context, IntegerLiteral integerLiteral);
	R visit(C context, BooleanLiteral booleanLiteral);
	R visit(C context, StringLiteral stringLiteral);
	R visit(C context, TemplateExpression templateExpression);
	R visit(C context, LambdaExpression lambdaExpression);
	R visit(C context, AlgorithmExpression algorithmExpression);
	R visit(C context, SwitchExpression switchExpression);
	R visit(C context, InvalidExpression invalidExpression);
	
}
