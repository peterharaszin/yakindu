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
import org.eclipselabs.damos.dmltext.MscriptValueSpecification;
import org.eclipselabs.damos.dmltext.internal.util.TextAdapter;
import org.eclipselabs.damos.dmltext.util.DMLTextUtil;

/**
 * @author Andreas Unger
 *
 */
public class MscriptValueSpecificationOperations {

	public static String stringValue(MscriptValueSpecification mscriptValueSpecification) {
		return DMLTextUtil.getText(mscriptValueSpecification);
	}

	public static MscriptValueSpecification copy(MscriptValueSpecification mscriptValueSpecification) {
		MscriptValueSpecification copy = EcoreUtil.copy(mscriptValueSpecification);
		copy.eAdapters().add(new TextAdapter(mscriptValueSpecification.stringValue()));
		return copy;
	}

}
