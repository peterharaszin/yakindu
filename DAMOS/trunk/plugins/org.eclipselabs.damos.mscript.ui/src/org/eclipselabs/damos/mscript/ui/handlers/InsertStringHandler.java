/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipselabs.damos.mscript.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;

/**
 * Handler to allow easy typing of guillemet characters on windows
 * and linux, too.
 */
public abstract class InsertStringHandler extends AbstractHandler {

	public static char LEFT_GUILLEMET = '\u00ab';
	public static char RIGHT_GUILLEMET = '\u00bb';

	private char replaceChar;

	protected InsertStringHandler(char replaceChar) {
		this.replaceChar = replaceChar;
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		XtextEditor editor = EditorUtils.getActiveXtextEditor(event);
		if (editor != null) {
			// Hack, would be nicer with document edits, but this way we don't loose auto edit
			StyledText textWidget = editor.getInternalSourceViewer().getTextWidget();
			Event e = new Event();
			e.character = replaceChar;
			e.type = SWT.KeyDown;
			e.doit = true;
			textWidget.notifyListeners(SWT.KeyDown, e);
		}
		return null;
	}

	public static class LeftGuillemet extends InsertStringHandler {
		
		public LeftGuillemet() {
			super(LEFT_GUILLEMET);
		}
		
	}

	public static class RightGuillemet extends InsertStringHandler {
		
		public RightGuillemet() {
			super(RIGHT_GUILLEMET);
		}
		
	}

}
