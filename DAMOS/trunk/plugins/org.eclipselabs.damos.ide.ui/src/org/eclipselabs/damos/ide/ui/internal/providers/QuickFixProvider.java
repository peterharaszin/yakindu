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

package org.eclipselabs.damos.ide.ui.internal.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.dml.util.DMLValidator;
import org.eclipselabs.damos.ide.core.validation.Problem;
import org.eclipselabs.damos.ide.ui.IDEUIPlugin;
import org.eclipselabs.damos.ide.ui.internal.quickfix.BlockTypeMovedQuickFix;
import org.eclipselabs.damos.ide.ui.internal.quickfix.BlockTypeRenamedQuickFix;
import org.eclipselabs.damos.ide.ui.internal.quickfix.CompositeQuickFixFactory;
import org.eclipselabs.damos.ide.ui.internal.quickfix.SetDataTypeQuickFix;
import org.eclipselabs.damos.ide.ui.internal.quickfix.SystemInterfaceMovedQuickFix;
import org.eclipselabs.damos.ide.ui.internal.quickfix.SystemInterfaceRenamedQuickFix;
import org.eclipselabs.damos.ide.ui.quickfix.IQuickFix;
import org.eclipselabs.damos.ide.ui.quickfix.IQuickFixProvider;

/**
 * @author Andreas Unger
 *
 */
public class QuickFixProvider implements IQuickFixProvider {
	
	private static final List<IQuickFix> INOUTPORT__HAS_DATA_TYPE = new ArrayList<IQuickFix>();
	
	static {
		INOUTPORT__HAS_DATA_TYPE.add(new SetDataTypeQuickFix.Real());
		INOUTPORT__HAS_DATA_TYPE.add(new SetDataTypeQuickFix.Integer());
		INOUTPORT__HAS_DATA_TYPE.add(new SetDataTypeQuickFix.Boolean());
	};
	
	private static final CompositeQuickFixFactory BLOCK__VALID_BLOCK_TYPE_REFERENCE = new CompositeQuickFixFactory();
	
	static {
		BLOCK__VALID_BLOCK_TYPE_REFERENCE.add(BlockTypeRenamedQuickFix.FACTORY);
		BLOCK__VALID_BLOCK_TYPE_REFERENCE.add(BlockTypeMovedQuickFix.FACTORY);
	}
	
	private static final CompositeQuickFixFactory SUBSYSTEM__VALID_INTERFACE_REFERENCE = new CompositeQuickFixFactory();
	
	static {
		SUBSYSTEM__VALID_INTERFACE_REFERENCE.add(SystemInterfaceRenamedQuickFix.FACTORY);
		SUBSYSTEM__VALID_INTERFACE_REFERENCE.add(SystemInterfaceMovedQuickFix.FACTORY);
	}

	public Collection<IQuickFix> getQuickFixes(Problem problem) {
		try {
			if (DMLValidator.DIAGNOSTIC_SOURCE.equals(problem.getSource())) {
				switch (problem.getCode()) {
				case DMLValidator.INOUTPORT__HAS_DATA_TYPE:
					return INOUTPORT__HAS_DATA_TYPE;
				case DMLValidator.BLOCK__VALID_BLOCK_TYPE_REFERENCE:
					return BLOCK__VALID_BLOCK_TYPE_REFERENCE.createQuickFixes(problem);
				case DMLValidator.SUBSYSTEM__VALID_INTERFACE_REFERENCE:
					return SUBSYSTEM__VALID_INTERFACE_REFERENCE.createQuickFixes(problem);
					
				}
			}
		} catch (InstantiationException e) {
			IDEUIPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, IDEUIPlugin.PLUGIN_ID, "Class instantiation failed", e));
		} catch (IllegalAccessException e) {
			IDEUIPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, IDEUIPlugin.PLUGIN_ID, "Illegal class access", e));
		}
		return null;
	}

}
