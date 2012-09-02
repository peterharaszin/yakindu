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

package org.eclipselabs.damos.dscript.ui;

import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.LanguageSpecific;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser;
import org.eclipselabs.damos.dscript.ui.contentassist.antlr.BlockTypeContentAssistParser;
import org.eclipselabs.damos.dscript.ui.editor.BlockTypeURIEditorOpener;

import com.google.inject.Binder;

/**
 * @author Andreas Unger
 *
 */
public class BlockTypeUiModule extends DscriptUiModule {

	/**
	 * @param plugin
	 */
	public BlockTypeUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dscript.ui.AbstractDscriptUiModule#bindIContentAssistParser()
	 */
	@Override
	public Class<? extends IContentAssistParser> bindIContentAssistParser() {
		return BlockTypeContentAssistParser.class;
	}
	
	@Override
	public void configureLanguageSpecificURIEditorOpener(Binder binder) {
		if (PlatformUI.isWorkbenchRunning()) {
			binder.bind(IURIEditorOpener.class).annotatedWith(LanguageSpecific.class)
					.to(BlockTypeURIEditorOpener.class);
		}
	}

}
