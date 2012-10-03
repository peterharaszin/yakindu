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

package org.eclipse.damos.ide.ui.internal.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.dml.util.DMLValidator;
import org.eclipse.damos.ide.core.validation.Problem;
import org.eclipse.damos.ide.ui.IDEUIPlugin;
import org.eclipse.damos.ide.ui.internal.quickfix.BlockTypeMovedQuickFix;
import org.eclipse.damos.ide.ui.internal.quickfix.BlockTypeRenamedQuickFix;
import org.eclipse.damos.ide.ui.internal.quickfix.ComponentNameQuickFix;
import org.eclipse.damos.ide.ui.internal.quickfix.CompositeQuickFixFactory;
import org.eclipse.damos.ide.ui.internal.quickfix.QuickFixList;
import org.eclipse.damos.ide.ui.internal.quickfix.RealizingFragmentMovedQuickFix;
import org.eclipse.damos.ide.ui.internal.quickfix.RealizingFragmentRenamedQuickFix;
import org.eclipse.damos.ide.ui.internal.quickfix.RemoveSubsystemRealizationQuickFix;
import org.eclipse.damos.ide.ui.internal.quickfix.SetDataTypeQuickFix;
import org.eclipse.damos.ide.ui.internal.quickfix.StatefulQuickFixFactory;
import org.eclipse.damos.ide.ui.internal.quickfix.SynchronizeWithBlockTypeQuickFix;
import org.eclipse.damos.ide.ui.internal.quickfix.SynchronizeWithSystemInterfaceQuickFix;
import org.eclipse.damos.ide.ui.internal.quickfix.SystemInterfaceMovedQuickFix;
import org.eclipse.damos.ide.ui.internal.quickfix.SystemInterfaceRenamedQuickFix;
import org.eclipse.damos.ide.ui.quickfix.IQuickFix;
import org.eclipse.damos.ide.ui.quickfix.IQuickFixProvider;

/**
 * @author Andreas Unger
 *
 */
public class QuickFixProvider implements IQuickFixProvider {
	
	private static final StatefulQuickFixFactory COMPONENT_NAME = new StatefulQuickFixFactory();
	
	static {
		COMPONENT_NAME.add(ComponentNameQuickFix.class);
	}

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
	
	private static final List<IQuickFix> SYNCHRONIZE_WITH_BLOCK_TYPE = Collections.<IQuickFix>singletonList(new SynchronizeWithBlockTypeQuickFix());
	private static final List<IQuickFix> SYNCHRONIZE_WITH_SYSTEM_INTERFACE = Collections.<IQuickFix>singletonList(new SynchronizeWithSystemInterfaceQuickFix());
	
	private static final CompositeQuickFixFactory SUBSYSTEM_REALIZATION__VALID_REALIZING_FRAGMENT_REFERENCE = new CompositeQuickFixFactory();
	
	static {
		SUBSYSTEM_REALIZATION__VALID_REALIZING_FRAGMENT_REFERENCE.add(RealizingFragmentRenamedQuickFix.FACTORY);
		SUBSYSTEM_REALIZATION__VALID_REALIZING_FRAGMENT_REFERENCE.add(RealizingFragmentMovedQuickFix.FACTORY);
		SUBSYSTEM_REALIZATION__VALID_REALIZING_FRAGMENT_REFERENCE.add(QuickFixList.singleton(new RemoveSubsystemRealizationQuickFix()));
	}
	
	public Collection<IQuickFix> getQuickFixes(Problem problem) {
		try {
			if (DMLValidator.DIAGNOSTIC_SOURCE.equals(problem.getSource())) {
				switch (problem.getCode()) {
				case DMLValidator.COMPONENT__WELL_FORMED_NAME:
				case DMLValidator.COMPONENT__UNIQUE_COMPONENT_NAME:
					return COMPONENT_NAME.createQuickFixes(problem);
				case DMLValidator.INOUTPORT__HAS_DATA_TYPE:
					return INOUTPORT__HAS_DATA_TYPE;
				case DMLValidator.BLOCK__VALID_BLOCK_TYPE_REFERENCE:
					return BLOCK__VALID_BLOCK_TYPE_REFERENCE.createQuickFixes(problem);
				case DMLValidator.SUBSYSTEM__VALID_INTERFACE_REFERENCE:
					return SUBSYSTEM__VALID_INTERFACE_REFERENCE.createQuickFixes(problem);
				case DMLValidator.BLOCK__VALID_INPUT_DEFINITION_REFERENCES:	
				case DMLValidator.BLOCK__VALID_OUTPUT_DEFINITION_REFERENCES:	
				case DMLValidator.BLOCK__VALID_PARAMETER_REFERENCES:
					return SYNCHRONIZE_WITH_BLOCK_TYPE;
				case DMLValidator.SUBSYSTEM__VALID_INLET_REFERENCES:
				case DMLValidator.SUBSYSTEM__VALID_OUTLET_REFERENCES:
					return SYNCHRONIZE_WITH_SYSTEM_INTERFACE;
				case DMLValidator.SUBSYSTEM_REALIZATION__VALID_REALIZING_FRAGMENT_REFERENCE:
					return SUBSYSTEM_REALIZATION__VALID_REALIZING_FRAGMENT_REFERENCE.createQuickFixes(problem);
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
