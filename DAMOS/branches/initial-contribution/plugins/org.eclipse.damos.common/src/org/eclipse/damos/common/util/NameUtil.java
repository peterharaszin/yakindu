/****************************************************************************
 * Copyright (c) 2002-2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.common.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Andreas Unger
 *
 */
public class NameUtil {

	public static String formatName(String name) {
		return format(capName(name), ' ');
	}
	
	private static String capName(String name) {
		return name.length() == 0 ? name : name.substring(0, 1).toUpperCase() + name.substring(1);
	}

	private static String format(String name, char separator) {
		StringBuffer result = new StringBuffer();

		for (Iterator<String> i = parseName(name, '_').iterator(); i.hasNext();) {
			String component = i.next();
			result.append(component);
			if (i.hasNext() && component.length() > 1) {
				result.append(separator);
			}
		}
		return result.toString();
	}

	private static List<String> parseName(String sourceName, char sourceSeparator) {
		List<String> result = new ArrayList<String>();
		StringBuffer currentWord = new StringBuffer();

		int length = sourceName.length();
		boolean lastIsLower = false;

		for (int index = 0; index < length; index++) {
			char curChar = sourceName.charAt(index);
			if (Character.isUpperCase(curChar) || (!lastIsLower && Character.isDigit(curChar)) || curChar == sourceSeparator) {
				if (lastIsLower || curChar == sourceSeparator) {
					result.add(currentWord.toString());
					currentWord = new StringBuffer();
				}
				lastIsLower = false;
			} else {
				if (!lastIsLower) {
					int currentWordLength = currentWord.length();
					if (currentWordLength > 1) {
						char lastChar = currentWord.charAt(--currentWordLength);
						currentWord.setLength(currentWordLength);
						result.add(currentWord.toString());
						currentWord = new StringBuffer();
						currentWord.append(lastChar);
					}
				}
				lastIsLower = true;
			}
			if (curChar != sourceSeparator) {
				currentWord.append(curChar);
			}
		}

		result.add(currentWord.toString());
		return result;
	}

}
