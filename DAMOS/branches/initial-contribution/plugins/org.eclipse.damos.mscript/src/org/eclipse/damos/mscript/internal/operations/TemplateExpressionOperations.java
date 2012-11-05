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

package org.eclipse.damos.mscript.internal.operations;

import java.util.Iterator;

import org.eclipse.damos.mscript.ConstantTemplateSegment;
import org.eclipse.damos.mscript.ExpressionTemplateSegment;
import org.eclipse.damos.mscript.TemplateExpression;
import org.eclipse.damos.mscript.TemplateSegment;

/**
 * @author Andreas Unger
 *
 */
public class TemplateExpressionOperations {
	
	public static void normalizeSegments(TemplateExpression templateExpression) {
		int indentationSize = computeIndentationSize(templateExpression);

		int[] index = new int[1];
		boolean first = true;
		
		boolean whiteSpaceOnly = false;
		boolean hasNewLine = false;
		StringBuilder line = null;
		
		for (Iterator<TemplateSegment> it = templateExpression.getSegments().iterator(); it.hasNext();) {
			TemplateSegment templateSegment = it.next();
			if (templateSegment instanceof ConstantTemplateSegment) {
				line = null;
				whiteSpaceOnly = false;
				
				ConstantTemplateSegment constantTemplateSegment = (ConstantTemplateSegment) templateSegment;
				String text = constantTemplateSegment.getText();
				
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
						if (c == '\r') {
							// Remove '\r'
							continue;
						}
						line.append(c);
						if (c == '\n') {
							hasNewLine = true;
							break;
						}
						if (!Character.isWhitespace(c)) {
							whiteSpaceOnly = false;
						}
					}
					if (index[0] == text.length() && whiteSpaceOnly && !it.hasNext() && hasNewLine) {
						break;
					}
					sb.append(line);
					index[0] += indentationSize;
				}
				
				constantTemplateSegment.setNormalizedText(sb.toString());
			} else if (templateSegment instanceof ExpressionTemplateSegment) {
				ExpressionTemplateSegment expressionTemplateSegment = (ExpressionTemplateSegment) templateSegment;
				String indentation = "";
				if (whiteSpaceOnly && line != null && line.length() > 0 && line.charAt(line.length() - 1) != '\n') {
					indentation = line.toString();
				}
				expressionTemplateSegment.setIndentation(indentation);
			}
			first = false;
		}
	}
	
	private static int computeIndentationSize(TemplateExpression templateExpression) {
		int[] index = new int[1];
		int indentation = Integer.MAX_VALUE;
		boolean first = true;
		
		boolean whiteSpaceOnly = true;
		
		for (Iterator<TemplateSegment> it = templateExpression.getSegments().iterator(); it.hasNext();) {
			TemplateSegment templateSegment = it.next();
			if (templateSegment instanceof ConstantTemplateSegment) {
				ConstantTemplateSegment constantTemplateSegment = (ConstantTemplateSegment) templateSegment;
				String text = constantTemplateSegment.getText();
				
				if (whiteSpaceOnly) {
					for (int i = 0; i < text.length(); ++i) {
						if (!Character.isWhitespace(text.charAt(i))) {
							whiteSpaceOnly = false;
							break;
						}
					}
				}

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
			} else if (templateSegment instanceof ExpressionTemplateSegment) {
				ExpressionTemplateSegment expressionTemplateSegment = (ExpressionTemplateSegment) templateSegment;
				if (expressionTemplateSegment.getExpression() != null) {
					whiteSpaceOnly = false;
				}
				if (first) {
					return 0;
				}
			}
			first = false;
		}
		
		if (whiteSpaceOnly || indentation == Integer.MAX_VALUE) {
			return 0;
		}
		
		return indentation;
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
