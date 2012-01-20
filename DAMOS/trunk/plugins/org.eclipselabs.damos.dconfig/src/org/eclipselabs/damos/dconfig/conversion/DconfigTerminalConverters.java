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
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;
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

	@ValueConverter(rule = "ValidDouble")
	public IValueConverter<Double> ValidDouble() {
		return new IValueConverter<Double>() {
			
			public Double toValue(String string, INode node) {
				if (Strings.isEmpty(string)) {
					return Double.valueOf(0.0);
				}
				try {
					return Double.valueOf(string);
				} catch (NumberFormatException e) {
					throw new ValueConverterException("Couldn't convert '" + string + "' to ValidDouble", node, e);
				}
			}

			public String toString(Double value) {
				return value.toString();
			}

		};
	}

}
