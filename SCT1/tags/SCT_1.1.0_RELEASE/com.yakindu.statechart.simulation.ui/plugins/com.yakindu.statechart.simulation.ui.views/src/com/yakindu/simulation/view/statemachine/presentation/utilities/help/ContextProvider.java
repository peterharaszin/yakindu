/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.simulation.view.statemachine.presentation.utilities.help;

import org.eclipse.help.IContext;
import org.eclipse.help.IContextProvider;
import org.eclipse.help.IHelpResource;

import com.yakindu.simulation.view.statemachine.nls.Messages;
import com.yakindu.simulation.view.statemachine.presentation.StatemachineView;

/**
 * Provides the dynamic context help of the {@link StatemachineView}.
 * 
 * @author Philipp Richter
 */
public class ContextProvider implements IContextProvider {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.help.IContextProvider#getContext(java.lang.Object)
	 */
	public IContext getContext(final Object target) {

		return new IContext() {

			public IHelpResource[] getRelatedTopics() {

				return null;
			}

			public String getText() {

				return Messages.ContextProvider_viewhelp;
			}
		};
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.help.IContextProvider#getContextChangeMask()
	 */
	public int getContextChangeMask() {

		return NONE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.help.IContextProvider#getSearchExpression(java.lang.Object)
	 */
	public String getSearchExpression(final Object target) {

		return null;
	}

}
