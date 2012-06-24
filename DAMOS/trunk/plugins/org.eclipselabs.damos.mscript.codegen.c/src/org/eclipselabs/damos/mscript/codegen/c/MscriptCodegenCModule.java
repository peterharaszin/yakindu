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

package org.eclipselabs.damos.mscript.codegen.c;

import org.eclipselabs.damos.mscript.codegen.c.codefragments.ArrayConstructionFunction;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ArrayLiteralDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ArrayTypeDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ScalarVectorMultiplyFunction;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.StructConstructionFunction;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.StructLiteralDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.StructTypeDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.factories.IArrayConstructionFunctionFactory;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.factories.IArrayLiteralDeclarationFactory;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.factories.IArrayTypeDeclarationFactory;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.factories.IScalarMultiplyFunctionFactory;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.factories.IStructConstructionFunctionFactory;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.factories.IStructLiteralDeclarationFactory;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.factories.IStructTypeDeclarationFactory;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

/**
 * @author Andreas Unger
 *
 */
public class MscriptCodegenCModule extends AbstractModule {

	@Override
	protected void configure() {
		bindICModuleGenerator();
		bindICompoundStatementGenerator();
		bindIExpressionGenerator();
		
		buildIArrayConstructionFunctionFactory();
		buildIArrayLiteralDeclarationFactory();
		buildIArrayTypeDeclarationFactory();
		buildIScalarMultiplyFunctionFactory();
		buildIStructConstructionFunctionFactory();
		buildIStructLiteralDeclarationFactory();
		buildIStructTypeDeclarationFactory();
	}

	protected void bindICModuleGenerator() {
		bind(ICModuleGenerator.class).annotatedWith(CHeader.class).to(CHeaderGenerator.class);
		bind(ICModuleGenerator.class).annotatedWith(CSource.class).to(CSourceGenerator.class);
	}

	protected void bindICompoundStatementGenerator() {
		bind(ICompoundStatementGenerator.class).to(CompoundStatementGenerator.class);
	}

	protected void bindIExpressionGenerator() {
		bind(IExpressionGenerator.class).to(ExpressionGenerator.class);
	}

	protected void buildIArrayConstructionFunctionFactory() {
		install(new FactoryModuleBuilder().implement(ICodeFragment.class, ArrayConstructionFunction.class).build(IArrayConstructionFunctionFactory.class));
	}

	protected void buildIArrayLiteralDeclarationFactory() {
		install(new FactoryModuleBuilder().implement(ICodeFragment.class, ArrayLiteralDeclaration.class).build(IArrayLiteralDeclarationFactory.class));
	}

	protected void buildIArrayTypeDeclarationFactory() {
		install(new FactoryModuleBuilder().implement(ICodeFragment.class, ArrayTypeDeclaration.class).build(IArrayTypeDeclarationFactory.class));
	}

	protected void buildIScalarMultiplyFunctionFactory() {
		install(new FactoryModuleBuilder().implement(ICodeFragment.class, ScalarVectorMultiplyFunction.class).build(IScalarMultiplyFunctionFactory.class));
	}

	protected void buildIStructConstructionFunctionFactory() {
		install(new FactoryModuleBuilder().implement(ICodeFragment.class, StructConstructionFunction.class).build(IStructConstructionFunctionFactory.class));
	}

	protected void buildIStructLiteralDeclarationFactory() {
		install(new FactoryModuleBuilder().implement(ICodeFragment.class, StructLiteralDeclaration.class).build(IStructLiteralDeclarationFactory.class));
	}

	protected void buildIStructTypeDeclarationFactory() {
		install(new FactoryModuleBuilder().implement(ICodeFragment.class, StructTypeDeclaration.class).build(IStructTypeDeclarationFactory.class));
	}

}
