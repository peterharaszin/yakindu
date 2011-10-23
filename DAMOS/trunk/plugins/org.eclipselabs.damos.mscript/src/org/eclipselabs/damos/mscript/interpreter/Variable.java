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

package org.eclipselabs.damos.mscript.interpreter;

import java.util.ArrayList;

import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.il.VariableDeclaration;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.UninitializedValue;

/**
 * @author Andreas Unger
 *
 */
public class Variable implements IVariable {

	private VariableDeclaration declaration;
	
	private DataType dataType;
	
	private CircularBuffer<IValue> values = new CircularBuffer<IValue>();

	public Variable(IInterpreterContext interpreterContext, VariableDeclaration declaration) {
		this(interpreterContext, declaration, 1);
	}

	/**
	 * 
	 */
	public Variable(IInterpreterContext interpreterContext, VariableDeclaration declaration, int circularBufferSize) {
		this.declaration = declaration;
		IValue value = interpreterContext.getStaticEvaluationContext().getValue(declaration);
		if (value != null) {
			this.dataType = value.getDataType();
		}
		values.resize(circularBufferSize);
	}
	
	/**
	 * @return the declaration
	 */
	public VariableDeclaration getDeclaration() {
		return declaration;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.execution.IVariable#getValue()
	 */
	public IValue getValue(int stepIndex) {
		return values.get(stepIndex);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.execution.IVariable#setValue(org.eclipselabs.mscript.execution.value.IValue)
	 */
	public void setValue(int stepIndex, IValue value) {
		if (!(value instanceof UninitializedValue) && declaration != null && dataType != null) {
			value = value.convert(dataType);
		}
		values.set(stepIndex, value);
	}
	
	public void incrementStepIndex() {
		values.incrementLocation();
	}
	
	private static class CircularBuffer<E> extends ArrayList<E> {
		
		private int locationIndex;

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		/**
		 * 
		 */
		public CircularBuffer() {
			add(null);
		}
		
		public E get(int index) {
			return super.get(computeActualIndex(index));
		}
		
		public E set(int index, E element) {
			return super.set(computeActualIndex(index), element);
		}

		public void resize(int newSize) {
			int diff = newSize - size();
			if (diff == 0) {
				return;
			}
			if (diff < 0) {
				removeRange(newSize, size());
			} else {
				for (; diff > 0; --diff) {
					add(null);
				}
			}
		}
		
		public void incrementLocation() {
			++locationIndex;
			if (locationIndex >= size()) {
				locationIndex = 0;
			}
		}
		
		private int computeActualIndex(int index) {
			index = this.locationIndex + index;
			if (index < 0) {
				index = size() + index;
			} else if (index >= size()) {
				index -= size();
			} 
			return index;
		}

	}

}
