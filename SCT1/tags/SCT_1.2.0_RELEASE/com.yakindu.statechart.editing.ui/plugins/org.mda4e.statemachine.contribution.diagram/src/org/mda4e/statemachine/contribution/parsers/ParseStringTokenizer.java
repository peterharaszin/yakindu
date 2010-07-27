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
package org.mda4e.statemachine.contribution.parsers;

import java.util.Enumeration;

public abstract class ParseStringTokenizer implements Enumeration<String> {

	public String[] editTokens;
	public int index = -1;

	public void init(String editString) {
		this.index = -1;
		this.editTokens = parseTokens(editString);
	}

	protected abstract String[] parseTokens(String editString);

	public boolean hasMoreElements() {
		return index < editTokens.length;
	}

	public String nextElement() {
		return editTokens[++index];
	}

}