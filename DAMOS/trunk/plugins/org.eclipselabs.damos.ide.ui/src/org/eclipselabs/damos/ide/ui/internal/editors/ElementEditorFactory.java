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

package org.eclipselabs.damos.ide.ui.internal.editors;

import org.eclipselabs.damos.dml.ui.AbstractElementEditorFactory;
import org.eclipselabs.damos.dml.ui.IDataTypeSpecificationEditor;
import org.eclipselabs.damos.dml.ui.IValueSpecificationEditor;

/**
 * @author Andreas Unger
 *
 */
public class ElementEditorFactory extends AbstractElementEditorFactory {

	@Override
	public IValueSpecificationEditor createValueSpecificationEditor() {
		return new ValueSpecificationEditor();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.ui.AbstractElementEditorFactory#createDataTypeSpecificationEditor()
	 */
	@Override
	public IDataTypeSpecificationEditor createDataTypeSpecificationEditor() {
		return new DataTypeSpecificationEditor();
	}
	
}
