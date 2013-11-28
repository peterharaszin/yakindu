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

/**
 * @author m.muehlbrandt<p>
 *	TreeParents beherbergen TreeObjects. Mit TreeParents k�nnen TreeObjects zu Gruppen organisiert
 *	werden (Bsp. Oberpunkte Events und Variablen des DataExplorers).
 *	 
 */
public class TreeParent extends TreeObject {
	
	private ArrayList<TreeObject> children;
	
	public TreeParent(String name) {
		super(name);
		children = new ArrayList<TreeObject>();
	}
	
	public void addChild(TreeObject child) {
		children.add(child);
		child.setParent(this);
	}
	public void removeChild(TreeObject child) {
		children.remove(child);
		child.setParent(null);
	}
	public TreeObject [] getChildren() {
		return (TreeObject [])children.toArray(new TreeObject[children.size()]);
	}
	public boolean hasChildren() {
		return children.size()>0;
	}

}
