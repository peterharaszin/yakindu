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

package org.eclipselabs.damos.mscript.conversion;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.impl.QualifiedNameValueConverter;

/**
 * @author Andreas Unger
 *
 */
public class MscriptQualifiedNameValueConverter extends QualifiedNameValueConverter {

	private final Set<String> ruleNames = new HashSet<String>();
	
	{
		ruleNames.add("N");
		ruleNames.add("IJ");
		ruleNames.add("E");
		ruleNames.add("EXP");
		ruleNames.add("EXPIJ");
		ruleNames.add("ID");
	}
	
	private final Set<String> keywordValues = new HashSet<String>();
	
	{
		keywordValues.add("unit");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.conversion.impl.QualifiedNameValueConverter#isDelegateRuleCall(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected boolean isDelegateRuleCall(EObject grammarElement) {
		if (grammarElement instanceof RuleCall) {
			RuleCall ruleCall = (RuleCall) grammarElement;
			return ruleNames.contains(ruleCall.getRule().getName());
		}
		if (grammarElement instanceof Keyword) {
			Keyword keyword = (Keyword) grammarElement;
			return keywordValues.contains(keyword.getValue());
		}
		return false;
	}
	
}
