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

package org.eclipse.damos.diagram.core.internal.commands;

import org.eclipse.damos.dml.Argument;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.ValueSpecification;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

/**
 * @author Andreas Unger
 *
 */
public class SetArgumentValueCommand extends SetValueCommand {

	public SetArgumentValueCommand(Argument argument, ValueSpecification value) {
		super(new SetRequest(
				TransactionUtil.getEditingDomain(argument),
				argument,
				DMLPackage.Literals.ARGUMENT__VALUE,
				value));
		setLabel("'" + argument.getParameter().getName() + "' Parameter Change");
	}

}
