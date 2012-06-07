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

package org.eclipselabs.damos.library.base.ui.providers.sources;

import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.dml.Parameter;
import org.eclipselabs.damos.dml.ui.editpane.IParameterEditPaneProvider;
import org.eclipselabs.damos.dml.ui.editpane.IValueSpecificationEditPane;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.library.base.ui.editpanes.AudioFileURIEditPane;
import org.eclipselabs.damos.library.base.util.sources.AudioFileSourceConstants;

/**
 * @author Andreas Unger
 *
 */
public class AudioFileSourceEditPaneProvider implements IParameterEditPaneProvider {

	private static final String BLOCK_TYPE_QUALIFIED_NAME = "damos.library.base.sources.AudioFileSource";
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.ui.editpane.IParameterEditPaneProvider#createEditPane(org.eclipselabs.damos.dml.Parameter)
	 */
	public IValueSpecificationEditPane createEditPane(Parameter parameter) {
		BlockType blockType = DMLUtil.getOwner(parameter, BlockType.class);
		if (blockType != null && BLOCK_TYPE_QUALIFIED_NAME.equals(blockType.getQualifiedName()) && AudioFileSourceConstants.PARAMETER__FILE_URI.equals(parameter.getName())) {
			return new AudioFileURIEditPane();
		}
		return null;
	}
	
}
