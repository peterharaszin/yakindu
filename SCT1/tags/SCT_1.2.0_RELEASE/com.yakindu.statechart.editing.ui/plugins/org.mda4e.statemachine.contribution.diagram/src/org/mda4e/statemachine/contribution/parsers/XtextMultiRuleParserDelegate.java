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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;

import com.google.inject.Module;

public class XtextMultiRuleParserDelegate extends XtextParserDelegate {

	private String[] parserRulesToApply;
	private ParseStringTokenizer editStringTokenizer;

	// provides tokens, which are checked by individual rules (has to provide
	// exactly as many tokens (which may be null)
	// as parser rules are present)

	public XtextMultiRuleParserDelegate(Module module, EClass class1,
			EStructuralFeature structuralFeature, Class<? extends AbstractAntlrParser> parserClass,
			String[] parserRulesToApply,
			ParseStringTokenizer editStringTokenizer) {
		super(module, class1, structuralFeature, parserClass);
		this.parserRulesToApply = parserRulesToApply;
		this.editStringTokenizer = editStringTokenizer;
	}

	public IParserEditStatus isValidEditString(IAdaptable element,
			String editString) {
		IParserEditStatus status = ParserEditStatus.EDITABLE_STATUS;
		editStringTokenizer.init(editString);
		for (String parserRuleToApply : parserRulesToApply) {
			String nextEditToken = editStringTokenizer.nextElement();
			if (nextEditToken != null && !nextEditToken.equals("")) {
				// apply parser rule
				status = getParseResult(parserRuleToApply, nextEditToken);
				if (status.getSeverity() == IStatus.ERROR
						|| status.getSeverity() == IStatus.WARNING) {
					return status;
				}
			}
		}
		return status;
	}

}
