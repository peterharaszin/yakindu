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
	
	private final int ruleAnyOther;
	
	private boolean inMultiLineString;
	private int inDynamicStringCounter;
	
	/**
	 * 
	 */
	public MscriptLexerDelegate(int ruleAnyOther) {
		this.ruleAnyOther = ruleAnyOther;
	}
	
	public Token nextToken(Token nextToken) {
		if (nextToken != null) {
			if ("\"\"\"".equals(nextToken.getText())) {
				inMultiLineString = !inMultiLineString;
				inDynamicStringCounter = 0;
			} else if (inMultiLineString) {
				if (inDynamicStringCounter == 0) {
					if ("${".equals(nextToken.getText())) {
						++inDynamicStringCounter;
					}
				} else if (inDynamicStringCounter > 0) {
					if ("{".equals(nextToken.getText())) {
						++inDynamicStringCounter;
					} else if ("}".equals(nextToken.getText())) {
						--inDynamicStringCounter;
					}
				}
			}
		}
		return nextToken;
	}
	
	public boolean mTokens(CharStream input, RecognizerSharedState state) {
		if (inMultiLineString && inDynamicStringCounter == 0) {
			if (!(input.LA(1) == '"' && input.LA(2) == '"' && input.LA(3) == '"') && !(input.LA(1) == '$' && input.LA(2) == '{')) {
				input.consume();
				state.channel = BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
				state.type = ruleAnyOther;
				return false;
			}
		}
		return true;
	}

}
