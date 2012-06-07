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
import org.eclipselabs.damos.mscript.codegen.c.Include;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class ExecuteFunction extends PrimaryCodeFragment {
	
	private final IGraphGenerator graphGenerator;
	
	private String functionSignature;
	private final StringBuilder content = new StringBuilder();
	
	private Collection<Include> implementationIncludes = new ArrayList<Include>();
	
	{
		implementationIncludes.add(new Include("math.h"));
	}
	
	/**
	 * 
	 */
	@Inject
	ExecuteFunction(IGraphGenerator graphGenerator) {
		this.graphGenerator = graphGenerator;
	}
	
	protected void doInitialize(IGeneratorContext context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, new IDependencyRule() {
			
			public boolean applies(ICodeFragment other) {
				return other instanceof InputStruct || other instanceof OutputStruct;
			}
			
		});
		addDependency(IMPLEMENTATION_DEPENDS_ON, new IDependencyRule() {
			
			public boolean applies(ICodeFragment other) {
				return other instanceof ContextVariable;
			}
	
		});
		
		PrintAppendable out = new PrintAppendable(content);
		
		Graph graph = context.getExecutionFlow().getGraph();
	
		implementationIncludes.addAll(graphGenerator.getImplementationIncludes(context, graph));
		
		functionSignature = getFunctionSignature(context);
		
		out.print(functionSignature);
		out.print(" {\n");
		
		try {
			graphGenerator.writeOutputVariableDeclarations(context, out, graph, monitor);
		} catch (IOException e) {
			// TODO REMOVE
			e.printStackTrace();
		}
		out.println();
		try {
			graphGenerator.writeGraph(context, out, graph, monitor);
		} catch (IOException e) {
			// TODO REMOVE
			e.printStackTrace();
		}
		
		out.println("}");
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#getForwardDeclarationIncludes()
	 */
	@Override
	public Collection<Include> getForwardDeclarationIncludes() {
		return Collections.singleton(new Include("stdint.h"));
	}
	
	public CharSequence generateForwardDeclaration(boolean internal) {
		StringBuilder sb = new StringBuilder();
		if (internal) {
			sb.append("static ");
		}
		sb.append(functionSignature);
		sb.append(";\n");
		return sb;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#contributesImplementation()
	 */
	@Override
	public boolean contributesImplementation() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#getImplementationIncludes()
	 */
	@Override
	public Collection<Include> getImplementationIncludes() {
		return implementationIncludes;
	}
	
	@Override
	public CharSequence generateImplementation(boolean internal) {
		StringBuilder sb = new StringBuilder();
		if (internal) {
			sb.append("static ");
		}
		sb.append(content);
		return sb;
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
