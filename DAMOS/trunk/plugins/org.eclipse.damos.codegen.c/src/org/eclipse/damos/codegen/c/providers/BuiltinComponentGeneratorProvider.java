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

package org.eclipse.damos.codegen.c.providers;

import org.eclipse.damos.codegen.c.IComponentGenerator;
import org.eclipse.damos.codegen.c.IComponentGeneratorProvider;
import org.eclipse.damos.codegen.c.internal.componentgenerators.ChoiceGenerator;
import org.eclipse.damos.codegen.c.internal.componentgenerators.InportGenerator;
import org.eclipse.damos.codegen.c.internal.componentgenerators.JoinGenerator;
import org.eclipse.damos.codegen.c.internal.componentgenerators.LatchGenerator;
import org.eclipse.damos.codegen.c.internal.componentgenerators.MemoryGenerator;
import org.eclipse.damos.codegen.c.internal.componentgenerators.OutportGenerator;
import org.eclipse.damos.dml.Choice;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.Inport;
import org.eclipse.damos.dml.Join;
import org.eclipse.damos.dml.Latch;
import org.eclipse.damos.dml.Memory;
import org.eclipse.damos.dml.Outport;
import org.eclipse.damos.execution.ComponentNode;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author Andreas Unger
 *
 */
@Singleton
public class BuiltinComponentGeneratorProvider implements IComponentGeneratorProvider {

	@Inject
	private Provider<InportGenerator> inportGeneratorProvider;
	
	@Inject
	private Provider<OutportGenerator> outportGeneratorProvider;

	@Inject
	private Provider<ChoiceGenerator> choiceGeneratorProvider;

	@Inject
	private Provider<JoinGenerator> joinGeneratorProvider;

	@Inject
	private Provider<MemoryGenerator> memoryGeneratorGeneratorProvider;

	@Inject
	private Provider<LatchGenerator> latchGeneratorProvider;

	public IComponentGenerator createGenerator(ComponentNode node) {
		Component component = node.getComponent();
		if (component instanceof Inport) {
			return inportGeneratorProvider.get();
		}
		if (component instanceof Outport) {
			return outportGeneratorProvider.get();
		}
		if (component instanceof Choice) {
			return choiceGeneratorProvider.get();
		}
		if (component instanceof Join) {
			return joinGeneratorProvider.get();
		}
		if (component instanceof Memory) {
			return memoryGeneratorGeneratorProvider.get();
		}
		if (component instanceof Latch) {
			return latchGeneratorProvider.get();
		}
		return null;
	}

}
