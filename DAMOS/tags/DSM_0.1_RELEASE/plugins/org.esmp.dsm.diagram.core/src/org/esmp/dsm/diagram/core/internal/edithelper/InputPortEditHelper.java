/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.esmp.dsm.diagram.core.internal.edithelper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.esmp.dsm.diagram.core.internal.commands.ConfigureInputPortCommand;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;

/**
 * @author Andreas Unger
 *
 */
public class InputPortEditHelper extends PortEditHelper {

	protected ICommand getConfigureCommand(ConfigureRequest request) {
		return new ConfigureInputPortCommand(request, BlockDiagramPackage.eINSTANCE.getInputPort());
	}

}
