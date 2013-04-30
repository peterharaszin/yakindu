/**
  Copyright (c) 2012 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Markus Muehlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.java;

import static org.yakindu.sct.generator.core.util.GeneratorUtils.isDumpSexec;

import org.yakindu.sct.generator.core.impl.GenericJavaBasedGenerator;
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess;
import org.yakindu.sct.generator.java.types.JavaTypeSystemAccess;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.util.Modules;

public class JavaCodeGenerator extends GenericJavaBasedGenerator {

	@Override
	public void runGenerator(Statechart statechart, GeneratorEntry entry) {
		JavaGenerator delegate = getInjector(entry).getInstance(
				JavaGenerator.class);

		ExecutionFlow flow = createExecutionFlow(statechart, entry);

		if (isDumpSexec(entry)) {
			dumpSexec(entry, flow);
		}

		delegate.generate(flow, entry, getFileSystemAccess(entry));
	}

	@Override
	protected Module createModule(GeneratorEntry entry) {
		Module module = super.createModule(entry);
		return Modules.override(module).with(new Module() {
			public void configure(Binder binder) {
				binder.bind(ICodegenTypeSystemAccess.class).to(
						JavaTypeSystemAccess.class);
			}
		});
	}
}
