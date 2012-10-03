/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.diagram.ui.preferences;

import java.util.Collections;
import java.util.List;

import org.eclipse.damos.diagram.ui.preferences.IDefaultCommonBlockTypesProvider.NullImpl;

import com.google.inject.ImplementedBy;

/**
 * @author Andreas Unger
 *
 */
@ImplementedBy(NullImpl.class)
public interface IDefaultCommonBlockTypesProvider {

	List<String> getBlockTypes();
	
	static class NullImpl implements IDefaultCommonBlockTypesProvider {
		
		public List<String> getBlockTypes() {
			return Collections.emptyList();
		}
		
	}
	
}
