/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.ui.help;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.eclipse.jface.internal.text.html.BrowserInformationControl;
import org.eclipse.jface.text.AbstractReusableInformationControlCreator;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.editors.text.EditorsUI;
import org.yakindu.sct.model.stext.ui.internal.STextActivator;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import de.itemis.utils.jface.viewers.help.HelpHoverProvider;

/**
 * Overrides the loadStylesheet method to load a custom stylesheet from this
 * plugin. The HoverControlCreator is overridden too, because we don't want to
 * have the status line visible. (Not possible to set the bg color of the status
 * line)
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class CustomCSSHelpHoverProvider extends HelpHoverProvider {

	@Inject
	@Named("stylesheet")
	private String styleSheetFileName;

	private HoverControlCreator hoverControlCreator;

	protected String loadStyleSheet() {
		URL styleSheetURL = STextActivator.getInstance().getBundle()
				.getEntry(styleSheetFileName); //$NON-NLS-1$
		if (styleSheetURL != null) {
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new InputStreamReader(
						styleSheetURL.openStream()));
				StringBuffer buffer = new StringBuffer(1500);
				String line = reader.readLine();
				while (line != null) {
					buffer.append(line);
					buffer.append('\n');
					line = reader.readLine();
				}
				return buffer.toString();
			} catch (IOException ex) {
				return ""; //$NON-NLS-1$
			} finally {
				try {
					if (reader != null)
						reader.close();
				} catch (IOException e) {
				}
			}
		}
		return null;
	}

	public IInformationControlCreator getHoverControlCreator() {
		if (hoverControlCreator == null)
			hoverControlCreator = new HoverControlCreator(
					getInformationPresenterControlCreator());
		return hoverControlCreator;
	}

	public final class HoverControlCreator extends
			AbstractReusableInformationControlCreator {

		private final IInformationControlCreator fInformationPresenterControlCreator;

		public HoverControlCreator(
				IInformationControlCreator informationPresenterControlCreator) {
			fInformationPresenterControlCreator = informationPresenterControlCreator;
		}

		@Override
		public IInformationControl doCreateInformationControl(Shell parent) {
			String tooltipAffordanceString = EditorsUI
					.getTooltipAffordanceString();
			if (BrowserInformationControl.isAvailable(parent)) {
				String font = "org.eclipse.jdt.ui.javadocfont";
				BrowserInformationControl iControl = new BrowserInformationControl(
						parent, font, false) {
					@Override
					public IInformationControlCreator getInformationPresenterControlCreator() {
						return fInformationPresenterControlCreator;
					}
				};
				addLinkListener(iControl);
				return iControl;
			} else {
				return new DefaultInformationControl(parent,
						tooltipAffordanceString);
			}
		}

	}
}
