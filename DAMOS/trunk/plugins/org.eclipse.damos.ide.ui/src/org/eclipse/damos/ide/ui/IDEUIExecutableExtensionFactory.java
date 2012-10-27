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

package org.eclipse.damos.ide.ui;

import static com.google.inject.util.Modules.override;

import org.eclipse.damos.common.inject.AbstractGuiceAwareExecutableExtensionFactory;
import org.eclipse.damos.dscript.DscriptRuntimeModule;
import org.eclipse.damos.dscript.ui.DscriptUiModule;
import org.eclipse.damos.ide.core.IDEModule;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.osgi.framework.Bundle;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Andreas Unger
 *
 */
public class IDEUIExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	/* (non-Javadoc)
	 * @see org.eclipse.damos.common.inject.AbstractGuiceAwareExecutableExtensionFactory#getBundle()
	 */
	@Override
	protected Bundle getBundle() {
		return IDEUIPlugin.getDefault().getBundle();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.common.inject.AbstractGuiceAwareExecutableExtensionFactory#getInjector()
	 */
	@Override
	protected Injector getInjector() {
		return Guice.createInjector(override(override(override(new DscriptRuntimeModule()).with(new SharedStateModule()))
				.with(new DscriptUiModule(IDEUIPlugin.getDefault()))).with(override(new IDEModule()).with(new IDEUIModule())));
	}

}
