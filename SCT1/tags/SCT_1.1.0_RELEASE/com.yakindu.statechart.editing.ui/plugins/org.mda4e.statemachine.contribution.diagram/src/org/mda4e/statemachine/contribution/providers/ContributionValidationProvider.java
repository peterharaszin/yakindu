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
package org.mda4e.statemachine.contribution.providers;

import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.jface.action.IAction;
import org.mda4e.statemachine.contribution.part.ContributionValidateAction;

/**
 * Provider for validate action in ContributionValidateAction. 
 * @author schwertfeger
 *
 */
public class ContributionValidationProvider extends
		AbstractContributionItemProvider {
	
private static final String VALIDATE_ACTION_ID = "validateAction";

	@Override
	protected IAction createAction(String actionId,
			IWorkbenchPartDescriptor partDescriptor) {
		// TODO Auto-generated method stub
		if (VALIDATE_ACTION_ID.equals(actionId)) {
			return new ContributionValidateAction(partDescriptor.getPartPage());
		}
		return super.createAction(actionId, partDescriptor);
	}
}
