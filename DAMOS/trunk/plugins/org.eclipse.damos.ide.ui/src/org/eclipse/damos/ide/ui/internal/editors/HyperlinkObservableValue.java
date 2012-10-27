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

package org.eclipse.damos.ide.ui.internal.editors;

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Hyperlink;

public class HyperlinkObservableValue extends AbstractObservableValue {
	
	private Hyperlink hyperlink;
	private String value;
	
	private IHyperlinkListener hyperlinkListener = new HyperlinkAdapter() {
		
		public void linkActivated(HyperlinkEvent e) {
			fireValueChange(new ValueDiff() {
				
				@Override
				public Object getOldValue() {
					return null;
				}
				
				@Override
				public Object getNewValue() {
					return value;
				}
				
			});
		}
		
	};

	/**
	 * 
	 */
	public HyperlinkObservableValue(Hyperlink hyperlink) {
		this(hyperlink, hyperlink.getText());
	}

	/**
	 * 
	 */
	public HyperlinkObservableValue(Hyperlink hyperlink, String value) {
		this.hyperlink = hyperlink;
		this.value = value;
		hyperlink.addHyperlinkListener(hyperlinkListener);
	}
	
	/**
	 * 
	 */
	public HyperlinkObservableValue(String value) {
		this.value = value;
	}
	
	public Object getValueType() {
		return null;
	}
	
	@Override
	protected Object doGetValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.databinding.observable.AbstractObservable#dispose()
	 */
	@Override
	public void dispose() {
		hyperlink.removeHyperlinkListener(hyperlinkListener);
		super.dispose();
	}

}