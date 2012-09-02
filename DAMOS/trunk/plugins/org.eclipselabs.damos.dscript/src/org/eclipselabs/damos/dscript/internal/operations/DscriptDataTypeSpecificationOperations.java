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

package org.eclipselabs.damos.dscript.internal.operations;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dscript.DscriptDataTypeSpecification;
import org.eclipselabs.damos.dscript.internal.util.TextAdapter;
import org.eclipselabs.damos.dscript.util.DscriptUtil;

/**
 * @author Andreas Unger
 *
 */
public class DscriptDataTypeSpecificationOperations {

	public static DscriptDataTypeSpecification copy(DscriptDataTypeSpecification dscriptDataTypeSpecification) {
		DscriptDataTypeSpecification copy = EcoreUtil.copy(dscriptDataTypeSpecification);
		copy.eAdapters().add(new TextAdapter(DscriptUtil.getText(dscriptDataTypeSpecification)));
		return copy;
	}

}
