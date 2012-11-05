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

package org.eclipse.damos.ide.ui.internal.quickfix;

import org.eclipse.damos.ide.core.validation.Problem;
import org.eclipse.damos.ide.ui.quickfix.IQuickFix;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * @author Andreas Unger
 *
 */
public interface IStatefulQuickFix extends IQuickFix {

	boolean initialize(Problem problem, TransactionalEditingDomain editingDomain);
	
}
