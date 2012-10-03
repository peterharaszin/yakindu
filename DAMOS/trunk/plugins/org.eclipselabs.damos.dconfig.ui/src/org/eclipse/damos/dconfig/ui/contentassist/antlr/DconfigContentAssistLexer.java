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

package org.eclipse.damos.dconfig.ui.contentassist.antlr;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.eclipse.damos.dconfig.ui.contentassist.antlr.internal.InternalDconfigLexer;
import org.eclipse.damos.mscript.parser.antlr.MscriptLexerDelegate;

/**
 * @author Andreas Unger
 *
 */
public class DconfigContentAssistLexer extends InternalDconfigLexer {

	private final MscriptLexerDelegate delegate = new MscriptLexerDelegate(RULE_CONSTANT_STRING);
	
	public Token nextToken() {
		return delegate.nextToken(super.nextToken());
	}
	
	@Override
	public void mTokens() throws RecognitionException {
		if (delegate.mTokens(input, state)) {
			super.mTokens();
		}
	}

}
