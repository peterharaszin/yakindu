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

package org.eclipselabs.damos.mscript.parser.antlr;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;

/**
 * @author Andreas Unger
 *
 */
public class MscriptLexerDelegate {
	
	private final int constantStringRule;
	
	private boolean inTemplateExpression;
	private boolean inExpressionTemplateSegment;
	
	/**
	 * 
	 */
	public MscriptLexerDelegate(int constantStringRule) {
		this.constantStringRule = constantStringRule;
	}
	
	public Token nextToken(Token nextToken) {
		if (nextToken != null) {
			if ("\"\"\"".equals(nextToken.getText())) {
				inTemplateExpression = !inTemplateExpression;
				inExpressionTemplateSegment = false;
			} else if (inTemplateExpression) {
				if (!inExpressionTemplateSegment) {
					if ("\u00ab".equals(nextToken.getText())) {
						inExpressionTemplateSegment = true;
					}
				} else {
					if ("\u00bb".equals(nextToken.getText())) {
						inExpressionTemplateSegment = false;
					}
				}
			}
		}
		return nextToken;
	}
	
	public boolean mTokens(CharStream input, RecognizerSharedState state) {
		if (inTemplateExpression && !inExpressionTemplateSegment) {
			if (!(input.LA(1) == '"' && input.LA(2) == '"' && input.LA(3) == '"') && input.LA(1) != '\u00ab') {
				input.consume();
				state.channel = BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
				state.type = constantStringRule;
				return false;
			}
		}
		return true;
	}

}
