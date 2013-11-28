/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
/**
 * 
 */
package com.yakindu.statechart.transformation.uml2;

import java.net.URI;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.utils.AbstractEMFWorkflowComponent;
import org.eclipse.emf.mwe.utils.Writer;

import statemachine.Statechart;

/**
 * The StatechartWriter is a more advanced writer than the {@link org.eclipse.mwe.emf.Writer} as it allows
 * to write into more than one file (Under the hood it uses the {@link org.eclipse.mwe.emf.Writer}). The
 * API is still the same. Instead of a file you are specifying a directory by setting the {@link URI} attribute.
 * The filename is determined by the state chart name. Therefore the state chart name has to be
 * unique in the model.
 *  
 * @author dschmidt
 * 
 */
public class StatechartWriter extends AbstractEMFWorkflowComponent {
	
	private static final String COMPONENT_NAME = "YAKINDU Statechart Writer";
	
	@SuppressWarnings("unchecked")
	public void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		Object slotContent = ctx.get(getModelSlot());

		if (!(slotContent instanceof Collection<?>)) {
			issues.addError("Expected a Collection, found "
					+ slotContent.getClass());
		}

		Collection<Statechart> statecharts = (Collection<Statechart>) slotContent;

		// check if all state charts have a different name
		Set<String> nameInUse = new HashSet<String>();
		for (Statechart sc : statecharts) {
			if (nameInUse.contains(sc.getName())) {
				issues.addError("Every state chart needs a unique name!");
			}
			nameInUse.add(sc.getName());
		}

		Writer writer = new Writer();
		for (Statechart sc : statecharts) {
			ctx.set(getModelSlot(), sc);
			writer.setModelSlot(getModelSlot());
			writer.setResourceSet(getResourceSet());
			writer.setUri(getUri() + sc.getName() + ".statemachine");
			writer.checkConfiguration(issues);
			writer.invoke(ctx, monitor, issues);
		}
		
		// put back the original slotContant
		ctx.set(getModelSlot(), slotContent);
	}
	
	@Override
	public String getLogMessage() {
		return "Writing state charts to " + uri;
	}

	public String getComponentName() {
		return COMPONENT_NAME;
	}
}
