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
package org.mda4e.statemachine.contribution.model;

import java.util.ArrayList;
import java.util.List;

public class OutlineTreeObject {
	
	private String name;
	private List <Object> children;
	public OutlineTreeObject(String name) {
		this.name = name;
		children = new ArrayList<Object>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List <Object> getChildren() {
		return children;
	}
}
