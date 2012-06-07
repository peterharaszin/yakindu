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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationUtil;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.Node;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.Include;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class ContextStruct extends PrimaryCodeFragment {

	private final ITaskGenerator taskGenerator;
	
	private String content;
	
	private Collection<Include> forwardDeclarationIncludes = new ArrayList<Include>();
	
	/**
	 * 
	 */
	@Inject
	ContextStruct(ITaskGenerator taskGenerator) {
		this.taskGenerator = taskGenerator;
	}
	
	protected void doInitialize(IGeneratorContext context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, new IDependencyRule() {
			
			public boolean applies(ICodeFragment other) {
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
				Collection<Include> includes = generator.getContextCodeIncludes();
				if (includes != null) {
					forwardDeclarationIncludes.addAll(includes);
				}
				if (generator.getContextTypeName() == null) {
					out.print(generator.generateContextCode(getContextTypeName(context, componentNode), monitor));
					out.print("\n");
				}
			}
		}
		
		out.println("typedef struct {");
		out.print(taskGenerator.generateTaskContexts(context, monitor));
		for (Node node : context.getExecutionFlow().getAllNodes()) {
			if (!(node instanceof ComponentNode)) {
				continue;
			}
			ComponentNode componentNode = (ComponentNode) node;
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
			if (generator.contributesContextCode()) {
				CharSequence typeName = generator.getContextTypeName();
				if (typeName == null) {
					typeName = getContextTypeName(context, componentNode);
				}
				out.printf("%s %s;\n", typeName, InternalGeneratorUtil.getPrefix(context.getConfiguration(), node) + componentNode.getComponent().getName());
			}
		}
	
		out.printf("} %sContext;\n", prefix);
		
		content = sb.toString();
	}

	@Override
	public Collection<Include> getForwardDeclarationIncludes() {
		return forwardDeclarationIncludes;
	}
	
	public CharSequence generateForwardDeclaration(boolean internal) {
		return content;
	}

	/**
	 * @param context
	 * @param node
	 * @param componentNode
	 * @return
	 */
	private String getContextTypeName(IGeneratorContext context, ComponentNode componentNode) {
		return InternalGeneratorUtil.getPrefix(context.getConfiguration(), componentNode) + componentNode.getComponent().getName() + "_Context";
	}
	
}
