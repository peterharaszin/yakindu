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

package org.eclipselabs.damos.codegen.c.util;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.codegen.c.IComponentGenerator;
import org.eclipselabs.damos.codegen.c.internal.ComponentGeneratorAdapter;
import org.eclipselabs.damos.execution.ComponentNode;

/**
 * @author Andreas Unger
 *
 */
public class GeneratorNodeExtensions {

	public static IComponentGenerator getComponentGenerator(ComponentNode node) {
		ComponentGeneratorAdapter adapter = (ComponentGeneratorAdapter) EcoreUtil.getAdapter(node.eAdapters(), ComponentGeneratorAdapter.class);
		return adapter != null ? adapter.getGenerator() : null;
	}

}
