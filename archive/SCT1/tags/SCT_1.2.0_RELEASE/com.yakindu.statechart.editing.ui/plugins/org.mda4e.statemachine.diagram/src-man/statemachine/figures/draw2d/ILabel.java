/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package statemachine.figures.draw2d;

import org.eclipse.draw2d.IFigure;

/**
 * The generic representation of a label : a figure
 * which we can set and get some text.
 */
public interface ILabel extends IFigure {

	/**
	 * Set the new text to the label
	 * 
	 * @param s the new text
	 */
	void setText(String s);
	
	/**
	 * Get the text of the label
	 * 
	 * @return the text of the label
	 */
	String getText();
	
}
