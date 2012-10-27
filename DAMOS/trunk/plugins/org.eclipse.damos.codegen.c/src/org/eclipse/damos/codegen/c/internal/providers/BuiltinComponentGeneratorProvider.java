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

package org.eclipse.damos.codegen.c.internal.providers;

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

/**
 * @author Andreas Unger
 *
 */
public class BuiltinComponentGeneratorProvider implements IComponentGeneratorProvider {

	public IComponentGenerator createGenerator(ComponentNode node) {
		Component component = node.getComponent();
		if (component instanceof Inport) {
			return new InportGenerator();
		}
		if (component instanceof Outport) {
			return new OutportGenerator();
		}
		if (component instanceof Choice) {
			return new ChoiceGenerator();
		}
		if (component instanceof Join) {
			return new JoinGenerator();
		}
		if (component instanceof Memory) {
			return new MemoryGenerator();
		}
		if (component instanceof Latch) {
			return new LatchGenerator();
		}
		return null;
	}

}
