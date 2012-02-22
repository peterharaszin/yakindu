package org.eclipselabs.damos.dconfig.ui.syntaxcoloring;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipselabs.damos.mscript.ui.syntaxcoloring.MscriptHighlightingConfiguration;

/**
 * @author Andreas Unger
 *
 */
public class DconfigHighlightingConfiguration extends MscriptHighlightingConfiguration {

	public static final String SELECTION_PROPERTY_ID = "selectionProperty";
	public static final String MODEL_ELEMENT_ID = "modelElement";
	public static final String RESOURCE_ID = "resource";

	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(SELECTION_PROPERTY_ID, "Selection property", selectionPropertyTextStyle());
		acceptor.acceptDefaultHighlighting(MODEL_ELEMENT_ID, "Model element", modelElementTextStyle());
		acceptor.acceptDefaultHighlighting(RESOURCE_ID, "Resource", resourceTextStyle());
	}

	public TextStyle selectionPropertyTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0x3a, 0x39, 0x35));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	public TextStyle modelElementTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0x00, 0x50, 0x32));
		return textStyle;
	}

	public TextStyle resourceTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0xab, 0x30, 0x00));
		return textStyle;
	}

}
