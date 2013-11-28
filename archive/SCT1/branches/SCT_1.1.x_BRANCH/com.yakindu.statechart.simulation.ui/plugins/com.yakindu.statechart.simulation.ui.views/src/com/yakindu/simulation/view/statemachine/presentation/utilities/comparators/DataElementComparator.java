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
package com.yakindu.simulation.view.statemachine.presentation.utilities.comparators;

import java.io.Serializable;
import java.util.Comparator;

import statemachine.DataElement;

/**
 * This comparator allows the comparison of two {@link DataElement} objects with
 * the help of the names. For more details see the description of the method
 * {@link #compare(DataElement, DataElement)}.
 * 
 * @author Philipp Richter
 */
public class DataElementComparator implements Comparator<DataElement>,
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8815892807499681819L;

	/**
	 * Allows to compare two {@link DataElement}s with the help of the names.
	 * The comparison is case insensitive. If two names are equal lower case
	 * characters are "smaller" than upper case characters.
	 * 
	 * @param element1 defines the first <code>DataElement</code> which shall be
	 *            compared with <code>element2</code>
	 * @param element2 defines the second <code>DataElement</code>
	 * 
	 * @return The result is a negative integer, zero, or a positive integer as
	 *         the first argument is less than, equal to, or greater than the
	 *         second.
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(final DataElement element1, final DataElement element2) {

		int result = 0;

		result =
				element1.getName().toLowerCase().compareTo(
					element2.getName().toLowerCase());

		// if the names are equal, compare case sensitive
		// Lower cases are preferred
		if (result == 0) {
			result = element1.getName().compareTo(element2.getName()) * -1;
		}

		return result;
	}
}
