/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.mda4e.statemachine.contribution.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.mda4e.statemachine.contribution.parsers.ParseStringTokenizer;
import org.mda4e.statemachine.contribution.parsers.XtextMultiRuleParserDelegate;
import org.mda4e.statemachine.contribution.parsers.XtextSingleRuleParserDelegate;

import statemachine.StatemachinePackage;
import statemachine.diagram.edit.parts.StateDoEditPart;
import statemachine.diagram.edit.parts.StateEntryEditPart;
import statemachine.diagram.edit.parts.StateExitEditPart;
import statemachine.diagram.edit.parts.TransitionExpressionEditPart;
import statemachine.diagram.providers.StatemachineParserProvider;

import com.google.inject.Module;
import com.yakindu.statechart.model.expressions.StatechartExpressionsRuntimeModule;
import com.yakindu.statechart.model.expressions.parser.antlr.StatechartExpressionsParser;

public class ExpressionLanguageParserProvider extends
		StatemachineParserProvider implements IParserProvider {

	private static Module runtimeModule = new StatechartExpressionsRuntimeModule();
	
	public ExpressionLanguageParserProvider() {
	}	

	@Override
	protected IParser getParser(int visualID) {
		try {
			switch (visualID) {
			case StateEntryEditPart.VISUAL_ID:
				return new XtextSingleRuleParserDelegate(
						runtimeModule,
						StatemachinePackage.Literals.STATE,
						StatemachinePackage.Literals.STATE__ENTRY,
						StatechartExpressionsParser.class,
						"ActionExpression");
			case StateDoEditPart.VISUAL_ID:
				return new XtextSingleRuleParserDelegate(
						runtimeModule,
						StatemachinePackage.Literals.STATE,
						StatemachinePackage.Literals.STATE__DO,
						StatechartExpressionsParser.class,
						"ActionExpression");
			case StateExitEditPart.VISUAL_ID:
				return new XtextSingleRuleParserDelegate(
						runtimeModule,
						StatemachinePackage.Literals.STATE,
						StatemachinePackage.Literals.STATE__EXIT,
						StatechartExpressionsParser.class,
						"ActionExpression");
				// case RegionPriority2EditPart.VISUAL_ID:
				// return getRegionPriority_5001Parser();
			case TransitionExpressionEditPart.VISUAL_ID:
				return new XtextMultiRuleParserDelegate(
						runtimeModule,
						StatemachinePackage.Literals.TRANSITION,
						StatemachinePackage.Literals.TRANSITION__EXPRESSION,
						StatechartExpressionsParser.class,
						new String[] {
								"TriggerExpression",
								"GuardExpression",
								"ActionExpression"},
						new ParseStringTokenizer() {

							@Override
							protected String[] parseTokens(String editString) {
								String triggerExpression = com.yakindu.statechart.model.JavaExtensions
										.extractTriggerExpressionString(editString);
								String guardExpression = com.yakindu.statechart.model.JavaExtensions
										.extractGuardExpressionString(editString);
								String actionExpression = com.yakindu.statechart.model.JavaExtensions
										.extractActionExpressionString(editString);
								return new String[] { triggerExpression,
										guardExpression, actionExpression };
							}
						});
				// case TransitionPriorityEditPart.VISUAL_ID:
				// return getTransitionPriority_6002Parser();

			default:
				return super.getParser(visualID);
			}
		} catch (SecurityException e) {
			e.printStackTrace();

		}
		return super.getParser(visualID);
	}
}
