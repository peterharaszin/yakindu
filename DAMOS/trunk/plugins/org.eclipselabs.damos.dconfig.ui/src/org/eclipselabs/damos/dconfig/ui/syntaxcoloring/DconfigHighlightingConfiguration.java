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

	public static final String PROPERTY_CLASS_ID = "propertyClass";
	public static final String MODEL_ELEMENT_ID = "modelElement";

	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(PROPERTY_CLASS_ID, "Property Class", propertyClassTextStyle());
		acceptor.acceptDefaultHighlighting(MODEL_ELEMENT_ID, "Model Element", modelElementTextStyle());
	}

	public TextStyle propertyClassTextStyle() {
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

}
