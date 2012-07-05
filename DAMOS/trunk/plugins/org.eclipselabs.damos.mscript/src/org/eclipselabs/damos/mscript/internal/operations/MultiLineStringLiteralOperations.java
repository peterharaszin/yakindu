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

package org.eclipselabs.damos.mscript.internal.operations;

import java.util.Iterator;

import org.eclipselabs.damos.mscript.ConstantStringSegment;
import org.eclipselabs.damos.mscript.DynamicStringSegment;
import org.eclipselabs.damos.mscript.MultiLineStringLiteral;
import org.eclipselabs.damos.mscript.StringSegment;

/**
 * @author Andreas Unger
 *
 */
public class MultiLineStringLiteralOperations {
	
	public static void normalizeSegments(MultiLineStringLiteral stringLiteral) {
		int indentationSize = computeIndentationSize(stringLiteral);

		int[] index = new int[1];
		boolean first = true;
		
		boolean whiteSpaceOnly = false;
		StringBuilder line = null;
		
		for (Iterator<StringSegment> it = stringLiteral.getSegments().iterator(); it.hasNext();) {
			StringSegment stringSegment = it.next();
			if (stringSegment instanceof ConstantStringSegment) {
				line = null;
				whiteSpaceOnly = false;
				
				ConstantStringSegment constantStringSegment = (ConstantStringSegment) stringSegment;
				String text = constantStringSegment.getText();
				
				StringBuilder sb = new StringBuilder();
				
				index[0] = 0;

				if (first) {
					if (startsWithNewLine(text, index)) {
						index[0] += indentationSize;
					} else {
						index[0] = 0;
					}
				}

				while (index[0] < text.length()) {
					whiteSpaceOnly = true;
					line = new StringBuilder();
					while (index[0] < text.length()) {
						char c = text.charAt(index[0]++);
						line.append(c);
						if (c == '\n') {
							break;
						}
						if (!Character.isWhitespace(c)) {
							whiteSpaceOnly = false;
						}
					}
					if (index[0] == text.length() && whiteSpaceOnly && !it.hasNext()) {
						break;
					}
					sb.append(line);
					index[0] += indentationSize;
				}
				
				constantStringSegment.setNormalizedText(sb.toString());
			} else if (stringSegment instanceof DynamicStringSegment) {
				DynamicStringSegment dynamicStringSegment = (DynamicStringSegment) stringSegment;
				String indentation = "";
				if (whiteSpaceOnly && line != null && line.length() > 0 && line.charAt(line.length() - 1) != '\n') {
					indentation = line.toString();
				}
				dynamicStringSegment.setIndentation(indentation);
			}
			first = false;
		}
	}
	
	private static int computeIndentationSize(MultiLineStringLiteral stringLiteral) {
		int[] index = new int[1];
		int indentation = Integer.MAX_VALUE;
		boolean first = true;
		for (Iterator<StringSegment> it = stringLiteral.getSegments().iterator(); it.hasNext();) {
			StringSegment stringSegment = it.next();
			if (stringSegment instanceof ConstantStringSegment) {
				ConstantStringSegment constantStringSegment = (ConstantStringSegment) stringSegment;
				String text = constantStringSegment.getText();

				index[0] = 0;

				if (first && !startsWithNewLine(text, index)) {
					return 0;
				}
				
				if (index[0] == 0) {
					proceedToEndOfLine(text, index);
				}

				while (index[0] < text.length()) {
					int spaceCount = getPrecedingSpaceCount(text, index);

					// Ignore last line
					if (!it.hasNext() && text.length() > 0 && text.charAt(index[0] - 1) != '\n' && Character.isWhitespace(text.charAt(index[0] - 1))) {
						break;
					}
					
					if (spaceCount < indentation) {
						indentation = spaceCount;
					}
					
					proceedToEndOfLine(text, index);
				}
			} else if (stringSegment instanceof DynamicStringSegment) {
				if (first) {
					return 0;
				}
			}
			first = false;
		}
		return indentation == Integer.MAX_VALUE ? 0 : indentation;
	}

	/**
	 * @param text
	 * @param index
	 */
	private static void proceedToEndOfLine(String text, int[] index) {
		while (index[0] < text.length()) {
			char c = text.charAt(index[0]++);
			if (c == '\n') {
				break;
			}
		}
	}
	
	private static int getPrecedingSpaceCount(String text, int[] index) {
		int count = 0;
		while (index[0] < text.length()) {
			char c = text.charAt(index[0]++);
			
			if (c == '\r') {
				continue;
			}
			
			if (c == '\n' || !Character.isWhitespace(c)) {
				return count;
			}
			
			++count;
		}
		return count;
	}
	
	private static boolean startsWithNewLine(String text, int[] index) {
		while (index[0] < text.length()) {
			char c = text.charAt(index[0]++);
			
			if (!Character.isWhitespace(c)) {
				return false;
			}
			
			if (c == '\n') {
				return true;
			}
		}
		return false;
	}
	
}
