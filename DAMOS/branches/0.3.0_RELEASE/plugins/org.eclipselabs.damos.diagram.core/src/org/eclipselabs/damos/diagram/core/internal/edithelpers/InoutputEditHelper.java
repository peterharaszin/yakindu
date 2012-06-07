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

package org.eclipselabs.damos.diagram.core.internal.edithelpers;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipselabs.damos.diagram.core.internal.commands.CreatePortCommand;
import org.eclipselabs.damos.dml.DMLPackage;

/**
 * @author Andreas Unger
 *
 */
public class InoutputEditHelper extends AbstractEditHelper {

	@Override
	protected ICommand getCreateCommand(CreateElementRequest req) {
		if (DMLPackage.eINSTANCE.getPort().isSuperTypeOf(req.getElementType().getEClass())) {
			return new CreatePortCommand(req);
		}
		return super.getCreateCommand(req);
	}

}
