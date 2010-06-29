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
import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeFactory;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelTypeDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;

/**
 * @author Andreas Unger
 *
 */
public class BlockElementTypeFactory extends AbstractElementTypeFactory {

	public IMetamodelType createMetamodelType(IMetamodelTypeDescriptor descriptor) {
		return new BlockElementType(descriptor);
	}

	private static class BlockElementType extends MetamodelType implements IBlockElementType {

		private URI blockTypeURI;

		public BlockElementType(IMetamodelTypeDescriptor descriptor) {
			super(descriptor);
		}

		public URI getBlockTypeURI() {
			return blockTypeURI;
		}

		public void setBlockTypeURI(URI blockTypeURI) {
			this.blockTypeURI = blockTypeURI;
		}

	}

}
