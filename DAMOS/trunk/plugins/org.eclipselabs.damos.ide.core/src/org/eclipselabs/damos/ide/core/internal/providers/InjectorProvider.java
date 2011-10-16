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

package org.eclipselabs.damos.ide.core.internal.providers;

import org.eclipse.emf.ecore.EClass;
import org.eclipselabs.damos.dml.registry.IInjectorProvider;
import org.eclipselabs.damos.dmltext.DMLTextRuntimeModule;
import org.eclipselabs.damos.ide.core.IDEModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.util.Modules;

/**
 * @author Andreas Unger
 *
 */
public class InjectorProvider implements IInjectorProvider {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.registry.IInjectorProvider#getInjector(org.eclipse.emf.ecore.EObject)
	 */
	public Injector getInjector(EClass context) {
		return Guice.createInjector(Modules.override(new DMLTextRuntimeModule()).with(new IDEModule()));
	}

}
