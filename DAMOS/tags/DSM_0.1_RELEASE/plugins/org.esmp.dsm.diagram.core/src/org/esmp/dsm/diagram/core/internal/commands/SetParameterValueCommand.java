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

package org.esmp.dsm.diagram.core.internal.commands;

import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;
import org.esmp.dsm.semantic.blockdiagram.Parameter;

/**
 * @author Andreas Unger
 *
 */
public class SetParameterValueCommand extends SetValueCommand {

	public SetParameterValueCommand(Parameter parameter, String newExpression) {
		super(new SetRequest(
				TransactionUtil.getEditingDomain(parameter),
				parameter,
				BlockDiagramPackage.eINSTANCE.getParameter_Value(),
				newExpression));
		setLabel("'" + parameter.getName() + "' Parameter Change");
	}

}
