/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.dconfig.conversion;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipselabs.damos.mscript.conversion.MscriptTerminalConverters;

/**
 * @author Andreas Unger
 *
 */
public class DconfigTerminalConverters extends MscriptTerminalConverters {
	
	@ValueConverter(rule = "ValidIDWithoutIJ")
	public IValueConverter<String> ValidIDWithoutIJ() {
		return ValidID();
	}

	@ValueConverter(rule = "QualifiedNameWithoutIJ")
	public IValueConverter<String> QualifiedNameWithoutIJ() {
		return QualifiedName();
	}

}
