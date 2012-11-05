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

package org.eclipse.damos.dscript.ui.contentassist.antlr;

import java.util.Collection;

import org.antlr.runtime.RecognitionException;
import org.eclipse.damos.dscript.ui.contentassist.antlr.DscriptParser;
import org.eclipse.damos.dscript.ui.contentassist.antlr.internal.InternalDscriptParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

/**
 * @author Andreas Unger
 *
 */
public class SystemInterfaceContentAssistParser extends DscriptParser {

	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			InternalDscriptParser typedParser = (InternalDscriptParser) parser;
			typedParser.entryRuleDscriptSystemInterface();
			return typedParser.getFollowElements();
		} catch (RecognitionException ex) {
			throw new RuntimeException(ex);
		}
	}

}
