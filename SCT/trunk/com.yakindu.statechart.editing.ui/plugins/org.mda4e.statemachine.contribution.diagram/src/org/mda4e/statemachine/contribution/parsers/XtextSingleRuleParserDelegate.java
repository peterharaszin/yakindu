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
package org.mda4e.statemachine.contribution.parsers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;

import com.google.inject.Module;

public class XtextSingleRuleParserDelegate extends XtextParserDelegate
		implements IParser {

	private String parserRuleToApply;

	public XtextSingleRuleParserDelegate(Module module, EClass class1,
			EStructuralFeature structuralFeature, Class<? extends AbstractAntlrParser> parserClass,
			String parserRuleToApply) {
		super(module, class1, structuralFeature, parserClass);
		this.parserRuleToApply = parserRuleToApply;
	}

	public IParserEditStatus isValidEditString(IAdaptable element,
			String editString) {
		return getParseResult(parserRuleToApply, editString);
	}

}
