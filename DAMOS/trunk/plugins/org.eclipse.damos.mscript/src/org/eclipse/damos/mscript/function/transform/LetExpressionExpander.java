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

package org.eclipse.damos.mscript.function.transform;


import org.eclipse.damos.mscript.CompoundStatement;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.LetExpression;
import org.eclipse.damos.mscript.LetExpressionAssignment;
import org.eclipse.damos.mscript.LocalVariableDeclaration;
import org.eclipse.damos.mscript.MscriptFactory;
import org.eclipse.damos.mscript.VariableDeclaration;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.util.MscriptUtil;

/**
 * @author Andreas Unger
 *
 */
public class LetExpressionExpander extends AbstractExpressionTransformStrategy {

	public boolean canTransform(ITransformerContext context, Expression expression) {
		return expression instanceof LetExpression;
	}
	
	public void transform(ExpressionTransformResult result, Expression expression) {
		LetExpression letExpression = (LetExpression) expression;

		CompoundStatement compoundStatement = MscriptFactory.eINSTANCE.createCompoundStatement();
		result.getContext().getCompound().getStatements().add(compoundStatement);
		
		result.getContext().enterScope();
		result.getContext().setCompound(compoundStatement);

		for (LetExpressionAssignment assignment : letExpression.getAssignments()) {
			LocalVariableDeclaration localVariable = MscriptFactory.eINSTANCE.createLocalVariableDeclaration();
			VariableDeclaration variable = assignment.getVariables().get(0);
			
			result.getContext().addVariableDeclarationMapping(variable, localVariable);
			
			IValue partValue = result.getContext().getFunctionInfo().getValue(variable);
			result.getContext().getFunctionInfo().setValue(localVariable, partValue);
			localVariable.setName(MscriptUtil.findAvailableLocalVariableName(result.getContext().getCompound(), variable.getName()));
			
			InlineExpressionTarget target = new InlineExpressionTarget(result.getContext());
			result.getTransformer().transform(result.getContext(), assignment.getAssignedExpression(), target.asList());
			Expression assignedExpression = target.getAssignedExpression();
			
			localVariable.setInitializer(assignedExpression);
			compoundStatement.getStatements().add(localVariable);
		}

		result.getTransformer().transform(result.getContext(), letExpression.getTarget(), result.getTargets());
		
		result.getContext().leaveScope();
	}

}
