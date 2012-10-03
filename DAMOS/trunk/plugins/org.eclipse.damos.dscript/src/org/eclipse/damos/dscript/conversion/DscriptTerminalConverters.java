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

package org.eclipse.damos.dscript.conversion;

import org.eclipse.damos.mscript.conversion.MscriptTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

/**
 * @author Andreas Unger
 *
 */
public class DscriptTerminalConverters extends MscriptTerminalConverters {

	/**
	 * 
	 */
	private static final String UNLIMITED = "*";

	@ValueConverter(rule = "UpperBoundLiteral")
	public IValueConverter<Integer> UpperBoundLiteral() {
		return new IValueConverter<Integer>() {
			
			public Integer toValue(String string, INode node) {
				if (Strings.isEmpty(string)) {
					return Integer.valueOf(-1);
				}
				try {
					return UNLIMITED.equals(string) ? Integer.valueOf(-1) : Integer.valueOf(string);
				} catch (NumberFormatException e) {
					throw new ValueConverterException("Couldn't convert '" + string + "' to int", node, e);
				}
			}

			public String toString(Integer value) {
				return Integer.valueOf(-1).equals(value) ? UNLIMITED : value.toString();
			}

		};
	}

}
