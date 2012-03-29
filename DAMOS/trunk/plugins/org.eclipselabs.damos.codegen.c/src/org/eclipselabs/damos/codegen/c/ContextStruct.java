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
import org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationUtil;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.Node;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentDependency;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class ContextStruct extends PrimaryCodeFragment {

	private final ITaskGenerator taskGenerator;
	
	private String content;
	
	/**
	 * 
	 */
	@Inject
	ContextStruct(ITaskGenerator taskGenerator) {
		this.taskGenerator = taskGenerator;
	}
	
	protected void doInitialize(IGeneratorContext context, IProgressMonitor monitor) throws IOException {
		addDependency(new ICodeFragmentDependency.Stub() {
		
			@Override
			public boolean forwardDeclarationDependsOn(ICodeFragment other) {
				return other instanceof TaskMessageStruct;
			}

		});
		
		if (!context.getExecutionFlow().getTaskGraphs().isEmpty()) {
			context.addCodeFragment(new TaskMessageStruct(), monitor);
		}

		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);

		String prefix = GeneratorConfigurationUtil.getPrefix(context.getConfiguration());
		
		for (Node node : context.getExecutionFlow().getAllNodes()) {
			if (!(node instanceof ComponentNode)) {
				continue;
			}
			ComponentNode componentNode = (ComponentNode) node;
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
			if (generator.contributesContextCode()) {
				String typeName = InternalGeneratorUtil.getPrefix(context.getConfiguration(), node) + componentNode.getComponent().getName() + "_Context";
				generator.writeContextCode(out, typeName, monitor);
				out.append("\n");
			}
		}
		
		out.println("typedef struct {");
		taskGenerator.writeTaskContexts(context, out, monitor);
		for (Node node : context.getExecutionFlow().getAllNodes()) {
			if (!(node instanceof ComponentNode)) {
				continue;
			}
			ComponentNode componentNode = (ComponentNode) node;
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
			if (generator.contributesContextCode()) {
				out.printf("%s%s_Context %s;\n", InternalGeneratorUtil.getPrefix(context.getConfiguration(), node), componentNode.getComponent().getName(), InternalGeneratorUtil.getPrefix(context.getConfiguration(), node) + componentNode.getComponent().getName());
			}
		}

		out.printf("} %sContext;\n", prefix);
		
		content = sb.toString();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragment#writeForwardDeclaration(java.lang.Appendable, boolean)
	 */
	public void writeForwardDeclaration(Appendable appendable, boolean internal) throws IOException {
		appendable.append(content);
	}
	
}
