/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.dml.internal.operations;

import org.eclipse.damos.dml.CategorizedElement;
import org.eclipse.damos.dml.Category;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Categorized Element</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.CategorizedElement#belongsTo(java.lang.String) <em>Belongs To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CategorizedElementOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CategorizedElementOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  boolean belongsTo(CategorizedElement categorizedElement, String categoryName) {
		for (Category category : categorizedElement.getBelongingCategories()) {
			if (categoryName.equals(category.getName()) || category.belongsTo(categoryName)) {
				return true;
			}
		}
		return false;
	}

} // CategorizedElementOperations