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

import org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor;
import org.eclipselabs.damos.mscript.functionmodel.FunctionDescriptor;
import org.eclipselabs.damos.mscript.internal.functionmodel.util.InternalFunctionModelUtil;

/**
 * @author Andreas Unger
 *
 */
public class EquationCompoundHelper {

	public Collection<List<EquationDescriptor>> getEquationCompounds(FunctionDescriptor functionDescriptor) {
		List<EquationDescriptor> backlog = new LinkedList<EquationDescriptor>(functionDescriptor.getEquationDescriptors());
		Collection<List<EquationDescriptor>> equationCompounds = new LinkedList<List<EquationDescriptor>>();
		while (!backlog.isEmpty()) {
			List<EquationDescriptor> equationDescriptors = getNextEquationCompound(backlog);
			equationCompounds.add(equationDescriptors);
		}
		return equationCompounds;
	}
	
	private List<EquationDescriptor> getNextEquationCompound(List<EquationDescriptor> backlog) {
		List<EquationDescriptor> equationCompound = new LinkedList<EquationDescriptor>();
		equationCompound.add(backlog.remove(0));
		
		boolean changed;
		do {
			changed = false;
			for (Iterator<EquationDescriptor> backlogIt = backlog.iterator(); backlogIt.hasNext();) {
				EquationDescriptor backlogEquationDescriptor = backlogIt.next();
				boolean append = false;

				for (ListIterator<EquationDescriptor> it = equationCompound.listIterator(); it.hasNext();) {
					EquationDescriptor next = it.next();
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
