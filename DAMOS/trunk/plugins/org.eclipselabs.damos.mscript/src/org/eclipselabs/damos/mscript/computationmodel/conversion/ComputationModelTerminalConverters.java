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

package org.eclipselabs.damos.mscript.computationmodel.conversion;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;
import org.eclipselabs.damos.mscript.conversion.MscriptTerminalConverters;

/**
 * @author Andreas Unger
 *
 */
public class ComputationModelTerminalConverters extends MscriptTerminalConverters {
	
	@ValueConverter(rule = "FractionLiteral")
	public IValueConverter<Integer> FractionLiteral() {
		return new IValueConverter<Integer>() {
			
			public Integer toValue(String string, INode node) {
				if (Strings.isEmpty(string)) {
					return Integer.valueOf(0);
				}
				try {
					return Integer.valueOf(string) - 1;
				} catch (NumberFormatException e) {
					throw new ValueConverterException("Couldn't convert '" + string + "' to int", node, e);
				}
			}

			public String toString(Integer value) {
				return Integer.valueOf(value + 1).toString();
			}

		};
	}

}
