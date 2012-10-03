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

package org.eclipse.damos.ide.ui.internal.editors;

import java.io.StringReader;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.dml.DataTypeSpecification;
import org.eclipse.damos.dscript.parser.antlr.DataTypeSpecificationParser;
import org.eclipse.damos.dscript.util.DscriptUtil;
import org.eclipse.damos.ide.ui.IDEUIPlugin;
import org.eclipse.xtext.parser.IParseResult;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class DataTypeSpecificationUpdateValueStrategy extends UpdateValueStrategy {

	@Inject
	private DataTypeSpecificationParser parser;
	
	/* (non-Javadoc)
	 * @see org.eclipse.core.databinding.UpdateValueStrategy#convert(java.lang.Object)
	 */
	@Override
	public Object convert(Object value) {
		if (value == null) {
			return null;
		}
		if (value instanceof String) {
			IParseResult result = parser.parse(new StringReader((String) value));
			return result.getRootASTElement();
		}
		if (value instanceof DataTypeSpecification) {
			return DscriptUtil.getText((DataTypeSpecification) value);
		}
		throw new IllegalArgumentException();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.core.databinding.UpdateValueStrategy#validateAfterGet(java.lang.Object)
	 */
	@Override
	public IStatus validateAfterGet(Object value) {
		if (value instanceof String) {
			IParseResult result = parser.parse(new StringReader((String) value));
			if (result.hasSyntaxErrors()) {
				return new Status(IStatus.ERROR, IDEUIPlugin.PLUGIN_ID, "Syntax Error");
			}
		}
		return Status.OK_STATUS;
	}

}
