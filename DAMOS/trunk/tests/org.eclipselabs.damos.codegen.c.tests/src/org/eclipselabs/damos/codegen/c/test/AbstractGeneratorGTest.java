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

package org.eclipselabs.damos.codegen.c.test;

import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipselabs.damos.codegen.IGenerator;
import org.eclipselabs.damos.codegen.c.CodegenCModule;
import org.eclipselabs.damos.dconfig.DconfigFactory;
import org.eclipselabs.damos.dconfig.PropertyDeclaration;
import org.eclipselabs.damos.dconfig.SelectionProperty;
import org.eclipselabs.damos.dconfig.SimpleProperty;
import org.eclipselabs.damos.dconfig.SimplePropertyDeclaration;
import org.eclipselabs.damos.execution.test.AbstractExecutionTest;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.StringLiteral;
import org.junit.runner.RunWith;

import com.google.inject.Guice;

/**
 * @author Andreas Unger
 *
 */
@RunWith(GTestRunner.class)
public abstract class AbstractGeneratorGTest extends AbstractExecutionTest {
	
	protected final GTestHelper helper = new GTestHelper(this) {
		
		@Override
		protected void getSourceFiles(Collection<String> files) {
			super.getSourceFiles(files);
			files.add(getFileName(getTestProgram()) + ".c");
		}

	};

	protected void generate() {
		try {
			IGenerator generator = Guice.createInjector(new CodegenCModule()).getInstance(IGenerator.class);
			generator.generate(configuration, new NullProgressMonitor());
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void createConfiguration() {
		super.createConfiguration();
		SelectionProperty generatorSelection = createSelectionProperty("damos.codegen.generator", "damos.codegen.c.DefaultGenerator");
		
		SimpleProperty projectProperty = DconfigFactory.eINSTANCE.createSimpleProperty();
		for (PropertyDeclaration declaration : generatorSelection.getSelection().getPropertyDeclarations()) {
			if (declaration instanceof SimplePropertyDeclaration) {
				SimplePropertyDeclaration simplePropertyDeclaration = (SimplePropertyDeclaration) declaration;
				if ("projectName".equals(simplePropertyDeclaration.getName())) {
					projectProperty.setDeclaration(simplePropertyDeclaration);
					break;
				}
			}
		}
		StringLiteral stringLiteral = MscriptFactory.eINSTANCE.createStringLiteral();
		stringLiteral.setValue(helper.getTargetPath().toString());
		projectProperty.setValue(stringLiteral);
		
		generatorSelection.getBody().getProperties().add(projectProperty);
		configuration.getProperties().add(generatorSelection);
	}

	@Override
	protected String getTestQualifiedName() {
		return helper.getFileName(helper.getTestProgram());
	}

	protected void generateAndCompile() {
		generate();
		helper.compile();
	}
	
}
