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

package org.eclipselabs.damos.codegen.c;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationUtil;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;

/**
 * @author Andreas Unger
 *
 */
public class ContextVariable extends PrimaryCodeFragment {
	
	private String prefix;
	
	@Override
	protected void doInitialize(IGeneratorContext context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, new IDependencyRule() {
			
			public boolean applies(ICodeFragment other) {
				return other instanceof ContextStruct;
			}

		});
		
		prefix = GeneratorConfigurationUtil.getPrefix(context.getConfiguration());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#contributesInternalForwardDeclaration()
	 */
	@Override
	public boolean contributesInternalForwardDeclaration() {
		return false;
	}
	
	public CharSequence generateForwardDeclaration(boolean internal) {
		StringBuilder sb = new StringBuilder();
		sb.append("extern ");
		sb.append(generateImplementation(false));
		return sb;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#contributesImplementation()
	 */
	@Override
	public boolean contributesImplementation() {
		return true;
	}
	
	@Override
	public CharSequence generateImplementation(boolean internal) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		if (internal) {
			out.print("static ");
		}
		out.printf("%sContext %scontext;\n", prefix, prefix);
		return sb;
	}

}
