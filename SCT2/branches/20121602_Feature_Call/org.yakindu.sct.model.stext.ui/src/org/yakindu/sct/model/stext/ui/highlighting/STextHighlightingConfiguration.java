package org.yakindu.sct.model.stext.ui.highlighting;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class STextHighlightingConfiguration implements
		IHighlightingConfiguration {

	public final static String HMI_CONCEPT = "HMI CONCEPT";
	public final static String WIDGET_TYPE = "WIDGET TYPE";

	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		acceptor.acceptDefaultHighlighting(HMI_CONCEPT, "Hmi Concepts",
				hmiConceptTextStyle());
		acceptor.acceptDefaultHighlighting(WIDGET_TYPE, "Widget Type",
				widgetTypeTextStyle());
	}

	public TextStyle hmiConceptTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setStyle(SWT.BOLD);
		textStyle.setColor(new RGB(127, 0, 85));
		return textStyle;
	}

	public TextStyle widgetTypeTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setStyle(SWT.ITALIC);
		textStyle.setColor(new RGB(0, 112, 16));
		return textStyle;
	}

}
