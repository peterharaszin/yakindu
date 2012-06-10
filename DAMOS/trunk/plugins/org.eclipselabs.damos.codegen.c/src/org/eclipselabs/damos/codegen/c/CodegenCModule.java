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

import org.eclipselabs.damos.codegen.IGenerator;
import org.eclipselabs.damos.codegen.c.codefragments.ContextStruct;
import org.eclipselabs.damos.codegen.c.codefragments.ContextVariable;
import org.eclipselabs.damos.codegen.c.codefragments.ExecuteFunction;
import org.eclipselabs.damos.codegen.c.codefragments.InitializeFunction;
import org.eclipselabs.damos.codegen.c.codefragments.InputStruct;
import org.eclipselabs.damos.codegen.c.codefragments.OutputStruct;
import org.eclipselabs.damos.codegen.c.codefragments.TaskFunction;
import org.eclipselabs.damos.codegen.c.codefragments.TaskInfoArray;
import org.eclipselabs.damos.codegen.c.codefragments.TaskMessageStruct;
import org.eclipselabs.damos.codegen.c.codefragments.factories.IContextStructFactory;
import org.eclipselabs.damos.codegen.c.codefragments.factories.IContextVariableFactory;
import org.eclipselabs.damos.codegen.c.codefragments.factories.IExecuteFunctionFactory;
import org.eclipselabs.damos.codegen.c.codefragments.factories.IInitializeFunctionFactory;
import org.eclipselabs.damos.codegen.c.codefragments.factories.IInputStructFactory;
import org.eclipselabs.damos.codegen.c.codefragments.factories.IOutputStructFactory;
import org.eclipselabs.damos.codegen.c.codefragments.factories.ITaskFunctionFactory;
import org.eclipselabs.damos.codegen.c.codefragments.factories.ITaskInfoArrayFactory;
import org.eclipselabs.damos.codegen.c.codefragments.factories.ITaskMessageStructFactory;
import org.eclipselabs.damos.mscript.codegen.c.CHeader;
import org.eclipselabs.damos.mscript.codegen.c.CHeaderGenerator;
import org.eclipselabs.damos.mscript.codegen.c.CSource;
import org.eclipselabs.damos.mscript.codegen.c.CSourceGenerator;
import org.eclipselabs.damos.mscript.codegen.c.ICModuleGenerator;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

/**
 * @author Andreas Unger
 *
 */
public class CodegenCModule extends AbstractModule {

	@Override
	protected void configure() {
		bindIGenerator();
		bindIGraphGenerator();
		bindICompoundGenerator();
		bindITaskGenerator();
		bindICModuleGenerator();
		
		buildIInputStructFactory();
		buildIOutputStructFactory();
		buildIContextStructFactory();
		buildIContextVariableFactory();
		buildITaskFunctionFactory();
		buildITaskInfoArrayFactory();
		buildITaskMessageStructFactory();
		buildIInitializeFunctionFactory();
		buildIExecuteFunctionFactory();
	}

	protected void bindIGenerator() {
		bind(IGenerator.class).to(Generator.class);
	}

	protected void bindIGraphGenerator() {
		bind(IGraphGenerator.class).to(GraphGenerator.class);
	}

	protected void bindICompoundGenerator() {
		bind(ICompoundGenerator.class).to(CompoundGenerator.class);
	}

	protected void bindITaskGenerator() {
		bind(ITaskGenerator.class).to(TaskGenerator.class);
	}

	protected void bindICModuleGenerator() {
		bind(ICModuleGenerator.class).annotatedWith(CHeader.class).to(CHeaderGenerator.class);
		bind(ICModuleGenerator.class).annotatedWith(CSource.class).to(CSourceGenerator.class);
	}

	protected void buildIInputStructFactory() {
		install(new FactoryModuleBuilder().implement(ICodeFragment.class, InputStruct.class).build(IInputStructFactory.class));
	}

	protected void buildIOutputStructFactory() {
		install(new FactoryModuleBuilder().implement(ICodeFragment.class, OutputStruct.class).build(IOutputStructFactory.class));
	}

	protected void buildIContextStructFactory() {
		install(new FactoryModuleBuilder().implement(ICodeFragment.class, ContextStruct.class).build(IContextStructFactory.class));
	}

	protected void buildIContextVariableFactory() {
		install(new FactoryModuleBuilder().implement(ICodeFragment.class, ContextVariable.class).build(IContextVariableFactory.class));
	}
	
	protected void buildITaskFunctionFactory() {
		install(new FactoryModuleBuilder().implement(ICodeFragment.class, TaskFunction.class).build(ITaskFunctionFactory.class));
	}

	protected void buildITaskInfoArrayFactory() {
		install(new FactoryModuleBuilder().implement(ICodeFragment.class, TaskInfoArray.class).build(ITaskInfoArrayFactory.class));
	}

	protected void buildITaskMessageStructFactory() {
		install(new FactoryModuleBuilder().implement(ICodeFragment.class, TaskMessageStruct.class).build(ITaskMessageStructFactory.class));
	}

	protected void buildIInitializeFunctionFactory() {
		install(new FactoryModuleBuilder().implement(ICodeFragment.class, InitializeFunction.class).build(IInitializeFunctionFactory.class));
	}

	protected void buildIExecuteFunctionFactory() {
		install(new FactoryModuleBuilder().implement(ICodeFragment.class, ExecuteFunction.class).build(IExecuteFunctionFactory.class));
	}

}
