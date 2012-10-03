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

package org.eclipse.damos.codegen.c;

import java.util.Collection;

import org.eclipse.damos.dconfig.Configuration;
import org.eclipse.damos.execution.ExecutionFlow;
import org.eclipse.damos.mscript.codegen.c.ICodeFragment;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector;

/**
 * @author Andreas Unger
 *
 */
public interface IGeneratorContext extends ICodeFragmentCollector {

	Configuration getConfiguration();
	ExecutionFlow getExecutionFlow();
	Collection<ICodeFragment> getCodeFragments();
	
}
