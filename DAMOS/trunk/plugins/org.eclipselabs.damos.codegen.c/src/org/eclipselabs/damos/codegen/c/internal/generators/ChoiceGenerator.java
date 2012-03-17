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

package org.eclipselabs.damos.codegen.c.internal.generators;

import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.AbstractComponentGenerator;
import org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.dml.ActionLink;
import org.eclipselabs.damos.dml.Choice;
import org.eclipselabs.damos.dmltext.MscriptValueSpecification;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.codegen.c.ExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipselabs.damos.mscript.codegen.c.MscriptGeneratorContext;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.interpreter.StaticEvaluationContext;

/**
 * @author Andreas Unger
 *
 */
public class ChoiceGenerator extends AbstractComponentGenerator {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#contributesComputeOutputsCode()
	 */
	@Override
	public boolean contributesComputeOutputsCode() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#writeComputeOutputsCode(java.lang.Appendable, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void writeComputeOutputsCode(Appendable appendable, IProgressMonitor monitor) throws IOException {
		PrintAppendable out = new PrintAppendable(appendable);
		Choice choice = (Choice) getComponent();
		
		String incomingVariableName = InternalGeneratorUtil.getIncomingVariableName(getConfiguration(), getNode(), choice.getFirstInputPort());
		String choiceResult = InternalGeneratorUtil.getChoiceVariableName(getConfiguration(), getNode());
		
		int i = 0;
		for (ActionLink actionLink : choice.getActionLinks()) {
			if (actionLink.getCondition() != null) {
				if (i > 0) {
					out.print("} else ");
				}
				out.printf("if (%s == (", incomingVariableName);
				
				if (actionLink.getCondition() instanceof MscriptValueSpecification) {
					MscriptValueSpecification condition = (MscriptValueSpecification) actionLink.getCondition();
					ComputationModel computationModel = getComputationModel();
					ActionLinkConditionVariableAccessStrategy variableAccessStrategy = new ActionLinkConditionVariableAccessStrategy();
					new ExpressionGenerator().generate(new MscriptGeneratorContext(out, computationModel, new StaticEvaluationContext(), variableAccessStrategy), condition.getExpression());
				} else {
					// TODO: Handle error
				}

				out.println(")) {");
				out.printf("%s = %d;\n", choiceResult, i);
				++i;
			}
		}
		i = 0;
		for (ActionLink actionLink : choice.getActionLinks()) {
			if (actionLink.getCondition() == null) {
				out.println("} else {");
				out.printf("%s = %d;\n", choiceResult, i);
			}
			++i;
		}
		out.println("}");
	}
	
	/**
	 * @author Andreas Unger
	 *
	 */
	private static final class ActionLinkConditionVariableAccessStrategy implements IVariableAccessStrategy {
		
		public String getVariableAccessString(VariableReference variableReference) {
			return "";
		}
		
	}

}
