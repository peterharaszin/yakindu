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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.AbstractComponentGenerator;
import org.eclipselabs.damos.codegen.c.internal.util.CompoundGeneratorUtil;
import org.eclipselabs.damos.codegen.c.util.GeneratorUtil;
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
	
	@Override
	public CharSequence generateComputeOutputsCode(IProgressMonitor monitor) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		Choice choice = (Choice) getComponent();
		
		String incomingVariableName = GeneratorUtil.getIncomingVariableName(getConfiguration(), getNode(), choice.getFirstInputPort());
		String choiceResult = CompoundGeneratorUtil.getChoiceVariableName(getConfiguration(), getNode());
		
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
					out.print(new ExpressionGenerator().generate(new MscriptGeneratorContext(computationModel, new StaticEvaluationContext(), variableAccessStrategy, getContext().getCodeFragmentCollector()), condition.getExpression()));
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
		return sb;
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
