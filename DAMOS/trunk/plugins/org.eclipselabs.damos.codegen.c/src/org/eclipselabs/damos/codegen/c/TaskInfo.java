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
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentDependency;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class TaskInfo extends PrimaryCodeFragment {

	private final IGraphGenerator graphGenerator;
	
	private Collection<String> forwardDeclarationIncludes;
	private Collection<String> implementationIncludes;
	
	private String forwardDeclaration;
	private String implementation;
	
	/**
	 * 
	 */
	@Inject
	TaskInfo(IGraphGenerator graphGenerator) {
		this.graphGenerator = graphGenerator;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#getForwardDeclarationIncludes()
	 */
	@Override
	public Collection<String> getForwardDeclarationIncludes() {
		return forwardDeclarationIncludes;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#getImplementationIncludes()
	 */
	@Override
	public Collection<String> getImplementationIncludes() {
		return implementationIncludes;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractDeclarationCodeFragment#doInitialize(org.eclipselabs.damos.codegen.c.IGeneratorContext, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected void doInitialize(IGeneratorContext context, IProgressMonitor monitor) throws IOException {
		addDependency(new ICodeFragmentDependency.Stub() {
			
			@Override
			public boolean forwardDeclarationDependsOn(ICodeFragment other) {
				return other instanceof ITaskInfoStruct;
			}
			
			/* (non-Javadoc)
			 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentDependency.Stub#implementationDependsOn(org.eclipselabs.damos.mscript.codegen.c.ICodeFragment)
			 */
			@Override
			public boolean implementationDependsOn(ICodeFragment other) {
				return other instanceof Task;
			}

		});
		context.addCodeFragment(new Task(graphGenerator), monitor);
		initializeForwardDeclaration(context);
		initializeImplementation(context);
	}

	private void initializeForwardDeclaration(IGeneratorContext context) throws IOException {
		String prefix = GeneratorConfigurationUtil.getPrefix(context.getConfiguration());
		IRuntimeEnvironmentAPI rteAPI = GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(context.getConfiguration());
	
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
	
		out.printf("#define %sTASK_COUNT %d\n", prefix.toUpperCase(), context.getExecutionFlow().getTaskGraphs().size());
		out.print("extern const ");
		rteAPI.writeTaskInfoStructName(context, out);
		out.printf(" %staskInfos[];\n", prefix);
	
		forwardDeclaration = sb.toString();
		forwardDeclarationIncludes = rteAPI.getForwardDeclarationIncludes();
	}

	private void initializeImplementation(IGeneratorContext context) throws IOException {
		String prefix = GeneratorConfigurationUtil.getPrefix(context.getConfiguration());
		IRuntimeEnvironmentAPI rteAPI = GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(context.getConfiguration());
		
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		
		out.print("const ");
		rteAPI.writeTaskInfoStructName(context, out);
		out.printf(" %staskInfos[] = {\n", prefix);
		boolean first = true;
		for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
			if (first) {
				first = false;
			} else {
				out.append(",\n");
			}
			out.append("{ ").append(TaskGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph)).append(" }");
		}
		out.println("\n};");
		
		implementation = sb.toString();
		implementationIncludes = rteAPI.getImplementationIncludes();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragment#writeForwardDeclaration(java.lang.Appendable, boolean)
	 */
	public void writeForwardDeclaration(Appendable appendable, boolean internal) throws IOException {
		appendable.append(forwardDeclaration);
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
		appendable.append(implementation);
	}

}
