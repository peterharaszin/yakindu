package org.yakindu.sct.statechart.expressions.ui.extensions.modules;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser;
import org.yakindu.sct.statechart.expressions.ui.extensions.parsers.StatechartContentAssistParser;
import org.yakindu.sct.statechart.ui.ExpressionsUiModule;

public class StatechartUIModule extends ExpressionsUiModule {

	public StatechartUIModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	@Override
	public Class<? extends IContentAssistParser> bindIContentAssistParser() {
		return StatechartContentAssistParser.class;
	}
}
