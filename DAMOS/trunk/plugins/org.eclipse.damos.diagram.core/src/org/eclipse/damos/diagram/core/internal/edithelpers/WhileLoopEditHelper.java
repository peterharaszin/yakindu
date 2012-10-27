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

package org.eclipse.damos.diagram.core.internal.edithelpers;

import org.eclipse.damos.diagram.core.internal.commands.ConfigureWhileLoopCommand;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;

/**
 * @author Andreas Unger
 *
 */
public class WhileLoopEditHelper extends ActionEditHelper {

	protected ICommand getConfigureCommand(ConfigureRequest request) {
		return new ConfigureWhileLoopCommand(request, DMLPackage.eINSTANCE.getWhileLoop());
	}

}
