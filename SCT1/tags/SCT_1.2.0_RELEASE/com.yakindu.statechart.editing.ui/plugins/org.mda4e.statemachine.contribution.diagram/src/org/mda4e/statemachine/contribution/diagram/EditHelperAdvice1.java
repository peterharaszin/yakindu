/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.mda4e.statemachine.contribution.diagram;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.mda4e.statemachine.contribution.helper.TransitionHelper;

import statemachine.Transition;

public class EditHelperAdvice1 extends AbstractEditHelperAdvice {

	@Override
	protected EObject createType(EObject container, IElementType typeToCreate,
			IProgressMonitor progressMonitor) {
		return super.createType(container, typeToCreate, progressMonitor);
	}

	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		Transition t = (Transition) request.getElementToConfigure();
		Integer lowestPriority = TransitionHelper.getLowestPriority(t);
		t.setPriority(lowestPriority == null ? 0 : lowestPriority + 1);
		return null;
	}
}
