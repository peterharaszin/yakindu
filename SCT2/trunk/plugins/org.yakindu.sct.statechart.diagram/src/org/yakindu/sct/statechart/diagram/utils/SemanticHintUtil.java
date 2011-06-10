/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.statechart.diagram.utils;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.model.sct.statechart.Choice;
import org.yakindu.model.sct.statechart.Entry;
import org.yakindu.model.sct.statechart.Exit;
import org.yakindu.model.sct.statechart.FinalState;
import org.yakindu.model.sct.statechart.Junction;
import org.yakindu.model.sct.statechart.Region;
import org.yakindu.model.sct.statechart.State;
import org.yakindu.model.sct.statechart.Transition;
import org.yakindu.model.sct.statechart.util.StatechartSwitch;
import org.yakindu.sct.statechart.diagram.providers.SemanticHints;

/**
 * 
 * @author andreas muelder
 * 
 */
public final class SemanticHintUtil implements SemanticHints {

	private SemanticHintUtil() {
	}

	/**
	 * Returns the semantic hint for a given semantic Element
	 * 
	 * @param semanticElement
	 * @return
	 */
	public static String getSemanticHint(EObject semanticElement) {
		return new StatechartSwitch<String>() {

			@Override
			public String caseTransition(Transition object) {
				return TRANSITION;
			}

			@Override
			public String caseState(State object) {
				return STATE;
			}

			@Override
			public String caseRegion(Region object) {
				return REGION;
			}

			@Override
			public String caseJunction(Junction object) {
				return JUNCTION;
			}

			@Override
			public String caseEntry(Entry object) {
				return ENTRY;
			}

			@Override
			public String caseFinalState(FinalState object) {
				return FINALSTATE;
			}

			public String caseExit(Exit object) {
				return EXIT;
			};

			@Override
			public String caseChoice(Choice object) {
				return CHOICE;
			};

		}.doSwitch(semanticElement);
	}
}
