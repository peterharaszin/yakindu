/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.codegen.c.generator.internal.util;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.codegen.c.generator.IComponentGenerator;
import org.eclipselabs.damos.codegen.c.generator.internal.ComponentGeneratorAdapter;
import org.eclipselabs.damos.execution.executiongraph.Node;

/**
 * @author Andreas Unger
 *
 */
public class InternalGeneratorUtil {

	public static IComponentGenerator getComponentGenerator(Node node) {
		ComponentGeneratorAdapter adapter = (ComponentGeneratorAdapter) EcoreUtil.getAdapter(node.eAdapters(), ComponentGeneratorAdapter.class);
		return adapter != null ? adapter.getGenerator() : null;
	}
	
}
