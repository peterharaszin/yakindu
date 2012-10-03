/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.dml.ui.internal.databinding;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.ITextualElement;
import org.eclipse.emf.ecore.EClass;

/**
 * @author Andreas Unger
 *
 */
public class TextualElementUpdateValueStrategy extends UpdateValueStrategy {

	private EClass eClass;
	
	/**
	 * 
	 */
	public TextualElementUpdateValueStrategy() {
	}

	/**
	 * 
	 */
	public TextualElementUpdateValueStrategy(EClass eClass) {
		if (!DMLPackage.eINSTANCE.getITextualElement().isSuperTypeOf(eClass)) {
			throw new IllegalArgumentException("Provided EClass must be subclass of ITextualElement");
		}
		if (eClass.isInterface()) {
			throw new IllegalArgumentException("Provided EClass must not be interface");
		}
		if (eClass.isAbstract()) {
			throw new IllegalArgumentException("Provided EClass must not be abstract");
		}
		this.eClass = eClass;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.core.databinding.UpdateValueStrategy#convert(java.lang.Object)
	 */
	@Override
	public Object convert(Object value) {
		if (value == null) {
			return null;
		}
		if (value instanceof String) {
			if (eClass == null) {
				throw new IllegalStateException("EClass not set");
			}
			ITextualElement textualElement = (ITextualElement) eClass.getEPackage().getEFactoryInstance().create(eClass);
			textualElement.setText((String) value);
			return textualElement;
		}
		if (value instanceof ITextualElement) {
			return ((ITextualElement) value).getText();
		}
		throw new IllegalArgumentException();
	}
	
}
