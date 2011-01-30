/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
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
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipselabs.damos.diagram.core.internal.commands.ConfigureOutportCommand;
import org.eclipselabs.damos.dml.DMLPackage;

/**
 * @author Andreas Unger
 *
 */
public class OutportEditHelper extends AbstractEditHelper {

	protected ICommand getConfigureCommand(ConfigureRequest request) {
		return new ConfigureOutportCommand(request, DMLPackage.Literals.OUTPORT);
	}

}
