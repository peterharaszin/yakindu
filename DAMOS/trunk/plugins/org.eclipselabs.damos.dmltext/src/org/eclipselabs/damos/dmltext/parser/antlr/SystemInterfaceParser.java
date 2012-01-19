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

package org.eclipselabs.damos.dmltext.parser.antlr;


/**
 * @author Andreas Unger
 *
 */
public class SystemInterfaceParser extends DMLTextParser {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dmltext.parser.antlr.DMLTextParser#getDefaultRuleName()
	 */
	@Override
	protected String getDefaultRuleName() {
		return getGrammarAccess().getMscriptSystemInterfaceRule().getName();
	}
	
}
