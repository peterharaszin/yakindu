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

package org.eclipselabs.damos.mscript.ui.syntaxcoloring;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;

/**
 * @author Andreas Unger
 *
 */
public class MscriptAntlrTokenToAttributeIdMapper extends DefaultAntlrTokenToAttributeIdMapper {

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper#calculateId(java.lang.String, int)
	 */
	@Override
	protected String calculateId(String tokenName, int tokenType) {
		if("RULE_INT".equals(tokenName)) {
			return DefaultHighlightingConfiguration.NUMBER_ID;
		}
		if("'\"\"\"'".equals(tokenName) || "RULE_CONSTANT_STRING".equals(tokenName)) {
			return MscriptHighlightingConfiguration.MULTI_LINE_STRING_ID;
		}
		return super.calculateId(tokenName, tokenType);
	}
	
}
