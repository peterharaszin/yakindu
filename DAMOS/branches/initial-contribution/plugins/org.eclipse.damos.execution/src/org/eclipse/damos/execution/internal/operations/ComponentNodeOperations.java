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

package org.eclipse.damos.execution.internal.operations;

import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.damos.dml.util.SystemPath;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.execution.ExecutionFlow;

/**
 * @author Andreas Unger
 *
 */
public class ComponentNodeOperations {

	public static SystemPath getSystemPath(ComponentNode componentNode) {
		Fragment topLevelFragment = DMLUtil.getOwner(componentNode, ExecutionFlow.class).getTopLevelFragment();
		if (topLevelFragment == null) {
			return null;
		}
		return SystemPath.create(topLevelFragment, componentNode.getEnclosingSubsystems(), componentNode.getComponent());
	}

}
