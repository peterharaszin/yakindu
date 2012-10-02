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
public interface IExpressionVisitor<R, P> {

	R visit(P p, LetExpression letExpression);
	R visit(P p, IfExpression ifExpression);
	R visit(P p, InspectExpression inspectExpression);
	R visit(P p, RangeExpression rangeExpression);
	R visit(P p, ImpliesExpression impliesExpression);
	R visit(P p, LogicalOrExpression logicalOrExpression);
	R visit(P p, LogicalAndExpression logicalAndExpression);
	R visit(P p, EqualityExpression equalityExpression);
	R visit(P p, RelationalExpression relationalExpression);
	R visit(P p, TypeTestExpression typeTestExpression);
	R visit(P p, AdditiveExpression additiveExpression);
	R visit(P p, MultiplicativeExpression multiplicativeExpression);
	R visit(P p, UnaryExpression unaryExpression);
	R visit(P p, ArrayConstructionOperator arrayConstructionOperator);
	R visit(P p, ArrayConcatenationOperator arrayConcatenationOperator);
	R visit(P p, RecordConstructionOperator recordConstructionOperator);
	R visit(P p, UnionConstructionOperator unionConstructionOperator);
	R visit(P p, UnitConstructionOperator unitConstructionOperator);
	R visit(P p, PowerExpression powerExpression);
	R visit(P p, ParenthesizedExpression parenthesizedExpression);
	R visit(P p, ArrayElementAccess arrayElementAccess);
	R visit(P p, FeatureReference featureReference);
	R visit(P p, MemberVariableAccess memberVariableAccess);
	R visit(P p, FunctionCall functionCall);
	R visit(P p, EndExpression endExpression);
	R visit(P p, RealLiteral realLiteral);
	R visit(P p, IntegerLiteral integerLiteral);
	R visit(P p, BooleanLiteral booleanLiteral);
	R visit(P p, StringLiteral stringLiteral);
	R visit(P p, TemplateExpression templateExpression);
	R visit(P p, LambdaExpression lambdaExpression);
	R visit(P p, AlgorithmExpression algorithmExpression);
	R visit(P p, SwitchExpression switchExpression);
	R visit(P p, InvalidExpression invalidExpression);
	
}
