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

import java.io.IOException;

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
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#dependsOn(org.eclipselabs.damos.mscript.codegen.c.ICodeFragment)
	 */
	@Override
	public boolean dependsOn(ICodeFragment other) {
		return other instanceof ContextStruct;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.PrimaryCodeFragment#doInitialize(org.eclipselabs.damos.codegen.c.IGeneratorContext, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected void doInitialize(IGeneratorContext context, IProgressMonitor monitor) throws IOException {
		prefix = GeneratorConfigurationUtil.getPrefix(context.getConfiguration());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#contributesInternalForwardDeclaration()
	 */
	@Override
	public boolean contributesInternalForwardDeclaration() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragment#writeForwardDeclaration(java.lang.Appendable, boolean)
	 */
	public void writeForwardDeclaration(Appendable appendable, boolean internal) throws IOException {
		appendable.append("extern ");
		writeImplementation(appendable, false);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#contributesImplementation()
	 */
	@Override
	public boolean contributesImplementation() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#writeImplementation(java.lang.Appendable, boolean)
	 */
	@Override
	public void writeImplementation(Appendable appendable, boolean internal) throws IOException {
		PrintAppendable out = new PrintAppendable(appendable);
		if (internal) {
			out.print("static ");
		}
		out.printf("%sContext %scontext;\n", prefix, prefix);
	}

}
