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

package org.eclipse.damos.mscript.function.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.damos.mscript.function.EquationDescription;
import org.eclipse.damos.mscript.function.FunctionDescription;
import org.eclipse.damos.mscript.internal.function.util.InternalFunctionModelUtil;

/**
 * @author Andreas Unger
 *
 */
public class EquationCompoundHelper {

	public Collection<List<EquationDescription>> getEquationCompounds(FunctionDescription functionDescription) {
		List<EquationDescription> backlog = new LinkedList<EquationDescription>(functionDescription.getEquationDescriptions());
		Collection<List<EquationDescription>> equationCompounds = new LinkedList<List<EquationDescription>>();
		while (!backlog.isEmpty()) {
			List<EquationDescription> equationDescriptions = getNextEquationCompound(backlog);
			equationCompounds.add(equationDescriptions);
		}
		return equationCompounds;
	}
	
	private List<EquationDescription> getNextEquationCompound(List<EquationDescription> backlog) {
		List<EquationDescription> equationCompound = new LinkedList<EquationDescription>();
		equationCompound.add(backlog.remove(0));
		
		boolean changed;
		do {
			changed = false;
			for (Iterator<EquationDescription> backlogIt = backlog.iterator(); backlogIt.hasNext();) {
				EquationDescription backlogEquationDescription = backlogIt.next();
				boolean append = false;

				for (ListIterator<EquationDescription> it = equationCompound.listIterator(); it.hasNext();) {
					EquationDescription next = it.next();
					if (InternalFunctionModelUtil.isDefinedBy(next, backlogEquationDescription)) {
						it.previous();
						it.add(backlogEquationDescription);
						it.next();
						backlogIt.remove();
						changed = true;
						append = false;
						break;
					} else if (InternalFunctionModelUtil.isDefinedBy(backlogEquationDescription, next)) {
						append = true;
					}
				}
				
				if (append) {
					equationCompound.add(backlogEquationDescription);
					backlogIt.remove();
					changed = true;
				}
			}
		} while (changed);
		
		return equationCompound;
	}
	
}
