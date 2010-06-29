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

package org.esmp.dsm.diagram.core.internal.type;

import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;

/**
 * @author Andreas Unger
 *
 */
public interface IBlockElementType extends IMetamodelType {

	URI getBlockTypeURI();
	void setBlockTypeURI(URI blockTypeURI);
	
}
