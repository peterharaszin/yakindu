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

package org.eclipselabs.damos.dmltext.internal.operations;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification;
import org.eclipselabs.damos.dmltext.internal.util.TextAdapter;
import org.eclipselabs.damos.dmltext.util.DMLTextUtil;

/**
 * @author Andreas Unger
 *
 */
public class MscriptDataTypeSpecificationOperations {

	public static MscriptDataTypeSpecification copy(MscriptDataTypeSpecification mscriptDataTypeSpecification) {
		MscriptDataTypeSpecification copy = EcoreUtil.copy(mscriptDataTypeSpecification);
		copy.eAdapters().add(new TextAdapter(DMLTextUtil.getText(mscriptDataTypeSpecification)));
		return copy;
	}

}
