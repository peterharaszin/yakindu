/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.codegen.c.internal.providers;

import org.eclipselabs.damos.codegen.c.IComponentGenerator;
import org.eclipselabs.damos.codegen.c.IComponentGeneratorProvider;
import org.eclipselabs.damos.codegen.c.internal.generators.ChoiceGenerator;
import org.eclipselabs.damos.codegen.c.internal.generators.InportGenerator;
import org.eclipselabs.damos.codegen.c.internal.generators.JoinGenerator;
import org.eclipselabs.damos.codegen.c.internal.generators.LatchGenerator;
import org.eclipselabs.damos.codegen.c.internal.generators.MemoryGenerator;
import org.eclipselabs.damos.codegen.c.internal.generators.OutportGenerator;
import org.eclipselabs.damos.dml.Choice;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Inport;
import org.eclipselabs.damos.dml.Join;
import org.eclipselabs.damos.dml.Latch;
import org.eclipselabs.damos.dml.Memory;
import org.eclipselabs.damos.dml.Outport;
import org.eclipselabs.damos.execution.ComponentNode;

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
