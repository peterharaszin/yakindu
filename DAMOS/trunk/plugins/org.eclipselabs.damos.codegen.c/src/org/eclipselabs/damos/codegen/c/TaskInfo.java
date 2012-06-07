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
import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.internal.util.TaskGeneratorUtil;
import org.eclipselabs.damos.codegen.c.rte.IRuntimeEnvironmentAPI;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationUtil;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.execution.TaskGraph;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.Include;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class TaskInfo extends PrimaryCodeFragment {

	private final IGraphGenerator graphGenerator;
	
	private Collection<Include> forwardDeclarationIncludes;
	private Collection<Include> implementationIncludes;
	
	private String forwardDeclaration;
	private String implementation;
	
	/**
	 * 
	 */
	@Inject
	TaskInfo(IGraphGenerator graphGenerator) {
		this.graphGenerator = graphGenerator;
	}
	
	@Override
	protected void doInitialize(IGeneratorContext context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, new IDependencyRule() {
			
			public boolean applies(ICodeFragment other) {
				return other instanceof ITaskInfoStruct;
			}
			
		});
		addDependency(IMPLEMENTATION_DEPENDS_ON, new IDependencyRule() {
			
			public boolean applies(ICodeFragment other) {
				return other instanceof Task;
			}
	
		});
		context.addCodeFragment(new Task(graphGenerator), monitor);
		initializeForwardDeclaration(context);
		initializeImplementation(context);
	}

	private void initializeForwardDeclaration(IGeneratorContext context) {
		String prefix = GeneratorConfigurationUtil.getPrefix(context.getConfiguration());
		IRuntimeEnvironmentAPI rteAPI = GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(context.getConfiguration());
	
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
	
		out.printf("#define %sTASK_COUNT %d\n", prefix.toUpperCase(), context.getExecutionFlow().getTaskGraphs().size());
		out.print("extern const ");
		try {
			rteAPI.writeTaskInfoStructName(context, out);
		} catch (IOException e) {
			// TODO REMOVE
			e.printStackTrace();
		}
		out.printf(" %staskInfos[];\n", prefix);
	
		forwardDeclaration = sb.toString();
		forwardDeclarationIncludes = rteAPI.getForwardDeclarationIncludes();
	}

	private void initializeImplementation(IGeneratorContext context) {
		String prefix = GeneratorConfigurationUtil.getPrefix(context.getConfiguration());
		IRuntimeEnvironmentAPI rteAPI = GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(context.getConfiguration());
		
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		
		out.print("const ");
		try {
			rteAPI.writeTaskInfoStructName(context, out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.printf(" %staskInfos[] = {\n", prefix);
		boolean first = true;
		for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
			if (first) {
				first = false;
			} else {
				out.print(",\n");
			}
			out.print("{ ").print(TaskGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph)).print(" }");
		}
		out.println("\n};");
		
		implementation = sb.toString();
		implementationIncludes = rteAPI.getImplementationIncludes();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#getForwardDeclarationIncludes()
	 */
	@Override
	public Collection<Include> getForwardDeclarationIncludes() {
		return forwardDeclarationIncludes;
	}
	
	public CharSequence generateForwardDeclaration(boolean internal) {
		return forwardDeclaration;
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
		return implementation;
	}

}
