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

import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.conversion.impl.IDValueConverter;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Andreas Unger
 *
 */
public class MscriptIDValueConverter extends IDValueConverter {

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.conversion.impl.AbstractIDValueConverter#toEscapedString(java.lang.String)
	 */
	@Override
	protected String toEscapedString(String value) {
		if (mustEscape(value)) {
			return "_" + value;
		}
		return value;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.conversion.impl.AbstractIDValueConverter#toValue(java.lang.String, org.eclipse.xtext.nodemodel.INode)
	 */
	@Override
	public String toValue(String string, INode node) {
		if (string == null) {
			return null;
		}
		return string.startsWith("_") ? string.substring(1) : string;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter#assertTokens(java.lang.Object, org.antlr.runtime.TokenSource, java.lang.String)
	 */
	@Override
	protected void assertTokens(String value, TokenSource tokenSource, String escapedString) {
		// do nothing
	}
	
}
