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

package org.eclipse.damos.dconfig.ui;

import org.eclipse.damos.dconfig.parser.antlr.DconfigLexer;
import org.eclipse.damos.dconfig.ui.contentassist.antlr.DconfigContentAssistLexer;
import org.eclipse.damos.dconfig.ui.syntaxcoloring.DconfigHighlightingConfiguration;
import org.eclipse.damos.dconfig.ui.syntaxcoloring.DconfigSemanticHighlightingCalculator;
import org.eclipse.damos.mscript.ui.autoedit.MscriptAutoEditStrategyProvider;
import org.eclipse.damos.mscript.ui.syntaxcoloring.MscriptAntlrTokenToAttributeIdMapper;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.ui.LexerUIBindings;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ui.shared.Access;

import com.google.inject.Binder;
import com.google.inject.Provider;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used within the IDE.
 */
public class DconfigUiModule extends org.eclipse.damos.dconfig.ui.AbstractDconfigUiModule {
	
	public DconfigUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	public Class<? extends DefaultAntlrTokenToAttributeIdMapper> bindDefaultAntlrTokenToAttributeIdMapper() {
		return MscriptAntlrTokenToAttributeIdMapper.class;
	}
	
	@Override
	public Class<? extends AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
		return MscriptAutoEditStrategyProvider.class;
	}	
	
	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return DconfigHighlightingConfiguration.class;
	}
	
	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return DconfigSemanticHighlightingCalculator.class;
	}
	
	@Override
	public Provider<IAllContainersState> provideIAllContainersState() {
		return Access.getWorkspaceProjectsState();
	}

	@Override
	public void configureContentAssistLexer(Binder binder) {
		binder.bind(Lexer.class).annotatedWith(com.google.inject.name.Names.named(LexerUIBindings.CONTENT_ASSIST)).to(DconfigContentAssistLexer.class);
	}
	
	@Override
	public void configureHighlightingLexer(Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class).annotatedWith(Names.named(LexerUIBindings.HIGHLIGHTING)).to(DconfigLexer.class);
	}

	public void configureBindingScope(Binder binder) {
		binder.bind(String.class).annotatedWith(Names.named(XtextEditor.KEY_BINDING_SCOPE)).toInstance("org.eclipse.damos.mscript.ui.mscriptEditorScope");
	}

}
