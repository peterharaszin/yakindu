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

package org.eclipse.damos.dscript.parser.antlr;

import org.eclipse.damos.dscript.parser.antlr.DscriptParser;

/**
 * @author Andreas Unger
 *
 */
public class ValueSpecificationParser extends DscriptParser {

	/* (non-Javadoc)
	 * @see org.eclipse.damos.dscript.parser.antlr.DscriptParser#getDefaultRuleName()
	 */
	@Override
	protected String getDefaultRuleName() {
		return getGrammarAccess().getDscriptValueSpecificationRule().getName();
	}
	
}
