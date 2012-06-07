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
public class InitializeFunction extends PrimaryCodeFragment {
	
	private final ITaskGenerator taskGenerator;
	
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
	InitializeFunction(ITaskGenerator taskGenerator) {
		this.taskGenerator = taskGenerator;
	}
	
	protected void doInitialize(IGeneratorContext context, IProgressMonitor monitor) {
		addDependency(IMPLEMENTATION_DEPENDS_ON, new IDependencyRule() {
			
			public boolean applies(ICodeFragment other) {
				return other instanceof ContextVariable;
			}
	
		});
		PrintAppendable out = new PrintAppendable(content);
		String prefix = GeneratorConfigurationUtil.getPrefix(context.getConfiguration());
	
		functionSignature = "void " + prefix + "initialize(void)";
		
		out.print(functionSignature);
		out.print(" {\n");
		try {
			taskGenerator.writeInitializeTasks(context, out, monitor);
		} catch (IOException e) {
			// TODO REMOVE
			e.printStackTrace();
		}
		
		for (Node node : context.getExecutionFlow().getAllNodes()) {
			if (!(node instanceof ComponentNode)) {
				continue;
			}
			ComponentNode componentNode = (ComponentNode) node;
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
			if (generator.contributesInitializationCode()) {
				Collection<Include> includes = generator.getInitializationCodeIncludes();
				if (includes != null) {
					implementationIncludes.addAll(includes);
				}
				out.printf("/* %s */\n", componentNode.getComponent().getName());
				out.println("{");
				out.print(generator.generateInitializationCode(monitor));
				out.println("}\n");
			}
		}
		out.print("}\n");
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

}
