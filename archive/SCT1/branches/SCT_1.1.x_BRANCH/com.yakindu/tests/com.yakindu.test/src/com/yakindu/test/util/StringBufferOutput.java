/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.test.util;

import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.OutputImpl;

public class StringBufferOutput extends OutputImpl {

	StringBuffer buffer = new StringBuffer();
	
	public StringBufferOutput() {
		// add a dummy outlet
		addOutlet(new Outlet());
	}

	public void write(String bytes) {
		buffer.append(bytes);
		super.write(bytes);
	}

	public String toString() {
		return buffer.toString();
	}
	
	public void clear(){
		buffer = new StringBuffer();
	}

}
