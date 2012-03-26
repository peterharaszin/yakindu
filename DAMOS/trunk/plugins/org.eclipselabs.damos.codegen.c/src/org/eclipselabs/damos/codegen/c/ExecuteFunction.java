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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationUtil;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.execution.Graph;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class ExecuteFunction extends PrimaryCodeFragment {
	
	private final IGraphGenerator graphGenerator;
	
	private String functionSignature;
	private final StringBuilder content = new StringBuilder();
	
	private Collection<String> implementationIncludes = new ArrayList<String>();
	
	{
		implementationIncludes.add("math.h");
	}
	
	/**
	 * 
	 */
	@Inject
	ExecuteFunction(IGraphGenerator graphGenerator) {
		this.graphGenerator = graphGenerator;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#getForwardDeclarationIncludes()
	 */
	@Override
	public Collection<String> getForwardDeclarationIncludes() {
		return Collections.singleton("stdint.h");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#getImplementationIncludes()
	 */
	@Override
	public Collection<String> getImplementationIncludes() {
		return implementationIncludes;
	}
	
	protected void doInitialize(IGeneratorContext context, IProgressMonitor monitor) throws IOException {
		PrintAppendable out = new PrintAppendable(content);
		
		Graph graph = context.getExecutionFlow().getGraph();

		functionSignature = getFunctionSignature(context);
		
		out.append(functionSignature);
		out.print(" {\n");
		
		graphGenerator.writeOutputVariableDeclarations(context, out, graph, monitor);
		out.println();
		graphGenerator.writeGraph(context, out, graph, monitor);
		
		out.println("}");
		
		ITargetGenerator targetGenerator = GeneratorConfigurationUtil.getTargetGenerator(context.getConfiguration());
		if (targetGenerator != null) {
			Collection<String> includes = targetGenerator.getImplementationIncludes();
			if (includes != null) {
				implementationIncludes.addAll(includes);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#dependsOn(org.eclipselabs.damos.mscript.codegen.c.ICodeFragment)
	 */
	@Override
	public boolean dependsOn(ICodeFragment other) {
		return other instanceof ContextVariable || other instanceof InputStruct || other instanceof OutputStruct;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragment#writeForwardDeclaration(java.lang.Appendable, boolean)
	 */
	public void writeForwardDeclaration(Appendable appendable, boolean internal) throws IOException {
		if (internal) {
			appendable.append("static ");
		}
		appendable.append(functionSignature);
		appendable.append(";\n");
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
		if (internal) {
			appendable.append("static ");
		}
		appendable.append(content);
	}

	protected String getFunctionSignature(IGeneratorContext context) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		String prefix = GeneratorConfigurationUtil.getPrefix(context.getConfiguration());
		
		boolean hasInput = !InternalGeneratorUtil.getInportNodes(context).isEmpty();
		boolean hasOutput = !InternalGeneratorUtil.getOutportNodes(context).isEmpty();
		
		out.printf("void %sexecute(", prefix);
		if (hasInput || hasOutput) {
			if (hasInput) {
				out.printf("const %sInput *input", prefix);
				if (hasOutput) {
					out.print(", ");
				}
			}
			if (hasOutput) {
				out.printf("%sOutput *output", prefix);
			}
		} else {
			out.print("void");
		}
		out.print(")");
		
		return sb.toString();
	}

}
