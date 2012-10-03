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

package org.eclipse.damos.library.base.ui.providers;

import org.eclipse.damos.dml.BlockType;
import org.eclipse.damos.dml.Parameter;
import org.eclipse.damos.dml.ui.editpane.IParameterEditPaneProvider;
import org.eclipse.damos.dml.ui.editpane.IValueSpecificationEditPane;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.damos.library.base.ui.editpanes.AudioFileURIEditPane;
import org.eclipse.damos.library.base.util.AudioFileSinkConstants;

/**
 * @author Andreas Unger
 *
 */
public class AudioFileSinkEditPaneProvider implements IParameterEditPaneProvider {

	private static final String BLOCK_TYPE_QUALIFIED_NAME = "damos.blocks.AudioFileSink";
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.dml.ui.editpane.IParameterEditPaneProvider#createEditPane(org.eclipse.damos.dml.Parameter)
	 */
	public IValueSpecificationEditPane createEditPane(Parameter parameter) {
		BlockType blockType = DMLUtil.getOwner(parameter, BlockType.class);
		if (blockType != null && BLOCK_TYPE_QUALIFIED_NAME.equals(blockType.getQualifiedName()) && AudioFileSinkConstants.PARAMETER__FILE_URI.equals(parameter.getName())) {
			return new AudioFileURIEditPane();
		}
		return null;
	}
	
}
