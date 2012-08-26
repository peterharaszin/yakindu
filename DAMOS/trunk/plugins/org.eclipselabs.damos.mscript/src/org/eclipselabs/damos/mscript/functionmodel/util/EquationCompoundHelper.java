/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.mscript.functionmodel.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.eclipselabs.damos.mscript.functionmodel.EquationDescription;
import org.eclipselabs.damos.mscript.functionmodel.FunctionDescription;
import org.eclipselabs.damos.mscript.internal.functionmodel.util.InternalFunctionModelUtil;

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
				EquationDescription backlogEquationDescriptor = backlogIt.next();
				boolean append = false;

				for (ListIterator<EquationDescription> it = equationCompound.listIterator(); it.hasNext();) {
					EquationDescription next = it.next();
					if (InternalFunctionModelUtil.isDefinedBy(next, backlogEquationDescriptor)) {
						it.previous();
						it.add(backlogEquationDescriptor);
						it.next();
						backlogIt.remove();
						changed = true;
						append = false;
						break;
					} else if (InternalFunctionModelUtil.isDefinedBy(backlogEquationDescriptor, next)) {
						append = true;
					}
				}
				
				if (append) {
					equationCompound.add(backlogEquationDescriptor);
					backlogIt.remove();
					changed = true;
				}
			}
		} while (changed);
		
		return equationCompound;
	}
	
}
