/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.mscript.codegen.c.internal.util;

import java.util.Formatter;

/**
 * @author Andreas Unger
 *
 */
public class StringUtil {

	public static String escape(String s) {
		char[] chars = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; ++i) {
			char c = chars[i];
			switch (c) {
			case '\"':
				sb.append("\\\"");
				break;
			case '\'':
				sb.append("\\\'");
				break;
			case '\n':
				sb.append("\\n");
				break;
			case '\r':
				sb.append("\\r");
				break;
			case '\f':
				sb.append("\\f");
				break;
			case '\t':
				sb.append("\\t");
				break;
			case '\b':
				sb.append("\\b");
				break;
			case '\\':
				sb.append("\\\\");
				break;
			default:
				if (c < 0x20) {
					new Formatter(sb).format("\\x%02x", (int) c);
				} else {
					sb.append(c);
				}
				break;
			}
		}
		return sb.toString();
	}

}
