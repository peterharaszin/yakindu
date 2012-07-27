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

package org.eclipselabs.damos.mscript.interpreter;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.interpreter.value.IArrayValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.util.TypeUtil;
import org.junit.Test;

/**
 * @author Andreas Unger
 *
 */
public class NumericExpressionEvaluatorTest extends AbstractExpressionEvaluatorTest {
	
	@Test
	public void createVector() {
		IValue value = evaluate("{ 1, 2.1, 3 }");
		
		assertTrue(value instanceof IArrayValue);
		IArrayValue arrayValue = (IArrayValue) value;
		
		assertEquals("Array must have 1 dimension", 1, arrayValue.getDataType().getDimensionality());
		assertEquals("Array size must be 3", 3, TypeUtil.getArraySize(arrayValue.getDataType()));

		assertValueEquals(1.0, arrayValue.get(0), 1e-10);
		assertValueEquals(2.1, arrayValue.get(1), 1e-10);
		assertValueEquals(3.0, arrayValue.get(2), 1e-10);
	}

	@Test
	public void createRange() {
		IValue value = evaluate("1:1.5:4");
		
		assertTrue(value instanceof IArrayValue);
		IArrayValue arrayValue = (IArrayValue) value;
		
		assertEquals("Array must have 1 dimension", 1, arrayValue.getDataType().getDimensionality());
		assertEquals("Array size must be 3", 3, TypeUtil.getArraySize(arrayValue.getDataType()));

		assertValueEquals(1.0, arrayValue.get(0), 1e-10);
		assertValueEquals(2.5, arrayValue.get(1), 1e-10);
		assertValueEquals(4.0, arrayValue.get(2), 1e-10);
	}

	@Test
	public void createMatrix() {
		IValue value = evaluate("{ { 1, 2, 3 }, { 4, 5.1, 6 } }");
		
		assertTrue(value instanceof IArrayValue);
		IArrayValue arrayValue = (IArrayValue) value;
		
		assertTrue(arrayValue.getDataType() instanceof ArrayType);
		assertTrue(arrayValue.getDataType().getElementType() instanceof RealType);
		assertEquals("Array must have 2 dimensions", 2, arrayValue.getDataType().getDimensionality());
		assertEquals("Row size must be 2", 2, TypeUtil.getArrayRowSize(arrayValue.getDataType()));
		assertEquals("Column size must be 3", 3, TypeUtil.getArrayColumnSize(arrayValue.getDataType()));
		
		assertValueEquals(1.0, arrayValue.get(0, 0), 1e-10);
		assertValueEquals(2.0, arrayValue.get(0, 1), 1e-10);
		assertValueEquals(3.0, arrayValue.get(0, 2), 1e-10);
		assertValueEquals(4.0, arrayValue.get(1, 0), 1e-10);
		assertValueEquals(5.1, arrayValue.get(1, 1), 1e-10);
		assertValueEquals(6.0, arrayValue.get(1, 2), 1e-10);
	}
	
	@Test
	public void constructVector() {
		IValue value = evaluate("{ 1, 2.1, 3 }.map(i -> i * 10 * i)", true);
		
		assertTrue(value instanceof IArrayValue);
		IArrayValue arrayValue = (IArrayValue) value;
		
		assertEquals("Array must have 1 dimension", 1, arrayValue.getDataType().getDimensionality());
		assertEquals("Array size must be 3", 3, TypeUtil.getArraySize(arrayValue.getDataType()));

		assertValueEquals(10.0, arrayValue.get(0), 1e-10);
		assertValueEquals(44.1, arrayValue.get(1), 1e-10);
		assertValueEquals(90.0, arrayValue.get(2), 1e-10);
	}

	@Test
	public void constructMatrix() {
		IValue value = evaluate("(1:2).map(i -> (3:5).map(j -> i * j * 1.0))", true);
		
		assertTrue(value instanceof IArrayValue);
		IArrayValue arrayValue = (IArrayValue) value;
		
		assertEquals("Array must have 2 dimensions", 2, arrayValue.getDataType().getDimensionality());
		assertEquals("Row size must be 2", 2, TypeUtil.getArrayRowSize(arrayValue.getDataType()));
		assertEquals("Column size must be 3", 3, TypeUtil.getArrayColumnSize(arrayValue.getDataType()));

		assertValueEquals(3.0, arrayValue.get(0, 0), 1e-10);
		assertValueEquals(4.0, arrayValue.get(0, 1), 1e-10);
		assertValueEquals(5.0, arrayValue.get(0, 2), 1e-10);
		assertValueEquals(6.0, arrayValue.get(1, 0), 1e-10);
		assertValueEquals(8.0, arrayValue.get(1, 1), 1e-10);
		assertValueEquals(10.0, arrayValue.get(1, 2), 1e-10);
	}

	@Test
	public void addScalarScalar() {
		IValue value = evaluate("2 + 3.1");
		
		assertTrue(value instanceof ISimpleNumericValue);
		assertValueEquals(5.1, value, 1e-10);
	}
	
	@Test
	public void addVectorVector() {
		IValue value = evaluate("{ 1, 2.1, 3 } + { 4, 5, 6 }");
		
		assertTrue(value instanceof IArrayValue);
		IArrayValue arrayValue = (IArrayValue) value;
		
		assertTrue(arrayValue.getDataType() instanceof ArrayType);
		assertTrue(arrayValue.getDataType().getElementType() instanceof RealType);
		assertEquals("Array must have 1 dimension", 1, arrayValue.getDataType().getDimensionality());
		assertEquals("Size must be 3", 3, TypeUtil.getArraySize(arrayValue.getDataType()));
		
		assertValueEquals(5.0, arrayValue.get(0), 1e-10);
		assertValueEquals(7.1, arrayValue.get(1), 1e-10);
		assertValueEquals(9, arrayValue.get(2), 1e-10);
	}

	@Test
	public void addMatrixMatrix() {
		IValue value = evaluate("{ { 1, 2.1, 3 }, { 4, 5, 6 } } + { { 7, 8, 9 }, { 10, 11, 12 } }");
		
		assertTrue(value instanceof IArrayValue);
		IArrayValue arrayValue = (IArrayValue) value;
		
		assertTrue(arrayValue.getDataType() instanceof ArrayType);
		assertTrue(arrayValue.getDataType().getElementType() instanceof RealType);
		assertEquals("Array must have 2 dimensions", 2, arrayValue.getDataType().getDimensionality());
		assertEquals("Row size must be 2", 2, TypeUtil.getArrayRowSize(arrayValue.getDataType()));
		assertEquals("Column size must be 3", 3, TypeUtil.getArrayColumnSize(arrayValue.getDataType()));
		
		assertValueEquals(8.0, arrayValue.get(0, 0), 1e-10);
		assertValueEquals(10.1, arrayValue.get(0, 1), 1e-10);
		assertValueEquals(12.0, arrayValue.get(0, 2), 1e-10);
		assertValueEquals(14.0, arrayValue.get(1, 0), 1e-10);
		assertValueEquals(16.0, arrayValue.get(1, 1), 1e-10);
		assertValueEquals(18.0, arrayValue.get(1, 2), 1e-10);
	}

	@Test
	public void multiplyScalarMatrix() {
		IValue value = evaluate("10 * { { 1, 2, 3 }, { 4, 5.1, 6 } }");
		
		assertTrue(value instanceof IArrayValue);
		IArrayValue arrayValue = (IArrayValue) value;
		
		assertTrue(arrayValue.getDataType() instanceof ArrayType);
		assertTrue(arrayValue.getDataType().getElementType() instanceof RealType);
		assertEquals("Array must have 2 dimensions", 2, arrayValue.getDataType().getDimensionality());
		assertEquals("Row size must be 2", 2, TypeUtil.getArrayRowSize(arrayValue.getDataType()));
		assertEquals("Column size must be 3", 3, TypeUtil.getArrayColumnSize(arrayValue.getDataType()));
		
		assertValueEquals(10.0, arrayValue.get(0, 0), 1e-10);
		assertValueEquals(20.0, arrayValue.get(0, 1), 1e-10);
		assertValueEquals(30.0, arrayValue.get(0, 2), 1e-10);
		assertValueEquals(40.0, arrayValue.get(1, 0), 1e-10);
		assertValueEquals(51.0, arrayValue.get(1, 1), 1e-10);
		assertValueEquals(60.0, arrayValue.get(1, 2), 1e-10);
	}

	@Test
	public void multiplyMatrixScalar() {
		IValue value = evaluate("{ { 1, 2, 3 }, { 4, 5.1, 6 } } * 10");
		
		assertTrue(value instanceof IArrayValue);
		IArrayValue arrayValue = (IArrayValue) value;
		
		assertTrue(arrayValue.getDataType() instanceof ArrayType);
		assertTrue(arrayValue.getDataType().getElementType() instanceof RealType);
		assertEquals("Array must have 2 dimensions", 2, arrayValue.getDataType().getDimensionality());
		assertEquals("Row size must be 2", 2, TypeUtil.getArrayRowSize(arrayValue.getDataType()));
		assertEquals("Column size must be 3", 3, TypeUtil.getArrayColumnSize(arrayValue.getDataType()));
		
		assertValueEquals(10.0, arrayValue.get(0, 0), 1e-10);
		assertValueEquals(20.0, arrayValue.get(0, 1), 1e-10);
		assertValueEquals(30.0, arrayValue.get(0, 2), 1e-10);
		assertValueEquals(40.0, arrayValue.get(1, 0), 1e-10);
		assertValueEquals(51.0, arrayValue.get(1, 1), 1e-10);
		assertValueEquals(60.0, arrayValue.get(1, 2), 1e-10);
	}
	
	@Test
	public void multiplyScalarVector() {
		IValue value = evaluate("10 * { 4, 5.1, 6 }");
		
		assertTrue(value instanceof IArrayValue);
		IArrayValue arrayValue = (IArrayValue) value;
		
		assertTrue(arrayValue.getDataType() instanceof ArrayType);
		assertTrue(arrayValue.getDataType().getElementType() instanceof RealType);
		assertEquals("Array must have 1 dimension", 1, arrayValue.getDataType().getDimensionality());
		assertEquals("Size must be 3", 3, TypeUtil.getArraySize(arrayValue.getDataType()));
		
		assertValueEquals(40.0, arrayValue.get(0), 1e-10);
		assertValueEquals(51.0, arrayValue.get(1), 1e-10);
		assertValueEquals(60.0, arrayValue.get(2), 1e-10);
	}

	@Test
	public void multiplyVectorScalar() {
		IValue value = evaluate("{ 4, 5.1, 6 } * 10");
		
		assertTrue(value instanceof IArrayValue);
		IArrayValue arrayValue = (IArrayValue) value;
		
		assertTrue(arrayValue.getDataType() instanceof ArrayType);
		assertTrue(arrayValue.getDataType().getElementType() instanceof RealType);
		assertEquals("Array must have 1 dimension", 1, arrayValue.getDataType().getDimensionality());
		assertEquals("Size must be 3", 3, TypeUtil.getArraySize(arrayValue.getDataType()));
		
		assertValueEquals(40.0, arrayValue.get(0), 1e-10);
		assertValueEquals(51.0, arrayValue.get(1), 1e-10);
		assertValueEquals(60.0, arrayValue.get(2), 1e-10);
	}

	@Test
	public void multiplyVectorVector() {
		IValue value = evaluate("{ 1, 2, 3 } * { 4, 5.1, 6 }");
		
		assertTrue(value instanceof ISimpleNumericValue);
		ISimpleNumericValue numericValue = (ISimpleNumericValue) value;
		
		assertValueEquals(32.2, numericValue, 1e-10);
	}

	@Test
	public void multiplyVectorMatrix() {
		IValue value = evaluate("{ 1, 2, 3 } * { { 4, 5.1 }, { 7, 8 }, { 9, 10 } }");
		
		assertTrue(value instanceof IArrayValue);
		IArrayValue arrayValue = (IArrayValue) value;
		
		assertTrue(arrayValue.getDataType() instanceof ArrayType);
		assertTrue(arrayValue.getDataType().getElementType() instanceof RealType);
		assertEquals("Array must have 1 dimension", 1, arrayValue.getDataType().getDimensionality());
		assertEquals("Size must be 2", 2, TypeUtil.getArraySize(arrayValue.getDataType()));
		
		assertValueEquals(45, arrayValue.get(0), 1e-10);
		assertValueEquals(51.1, arrayValue.get(1), 1e-10);
	}

	@Test
	public void multiplyMatrixVector() {
		IValue value = evaluate("{ { 4, 5.1 }, { 7, 8 }, { 9, 10 } } * { 2, 3 }");
		
		assertTrue(value instanceof IArrayValue);
		IArrayValue arrayValue = (IArrayValue) value;
		
		assertTrue(arrayValue.getDataType() instanceof ArrayType);
		assertTrue(arrayValue.getDataType().getElementType() instanceof RealType);
		assertEquals("Array must have 1 dimension", 1, arrayValue.getDataType().getDimensionality());
		assertEquals("Size must be 3", 3, TypeUtil.getArraySize(arrayValue.getDataType()));
		
		assertValueEquals(23.3, arrayValue.get(0), 1e-10);
		assertValueEquals(38.0, arrayValue.get(1), 1e-10);
		assertValueEquals(48.0, arrayValue.get(2), 1e-10);
	}

	@Test
	public void multiplyMatrixMatrix() {
		IValue value = evaluate("{ { 1, 2, 3 }, { 4, 5.1, 6 }, { 7, 8, 9 }, { 10, 11, 12 } } * { { 13, 14 }, { 15, 16 }, { 17, 18 } }");
		
		assertTrue(value instanceof IArrayValue);
		IArrayValue arrayValue = (IArrayValue) value;
		
		assertTrue(arrayValue.getDataType() instanceof ArrayType);
		assertTrue(arrayValue.getDataType().getElementType() instanceof RealType);
		assertEquals("Array must have 2 dimensions", 2, arrayValue.getDataType().getDimensionality());
		assertEquals("Row size must be 4", 4, TypeUtil.getArrayRowSize(arrayValue.getDataType()));
		assertEquals("Column size must be 2", 2, TypeUtil.getArrayColumnSize(arrayValue.getDataType()));
		
		assertValueEquals(94.0, arrayValue.get(0, 0), 1e-10);
		assertValueEquals(100.0, arrayValue.get(0, 1), 1e-10);
		assertValueEquals(230.5, arrayValue.get(1, 0), 1e-10);
		assertValueEquals(245.6, arrayValue.get(1, 1), 1e-10);
		assertValueEquals(364.0, arrayValue.get(2, 0), 1e-10);
		assertValueEquals(388.0, arrayValue.get(2, 1), 1e-10);
		assertValueEquals(499.0, arrayValue.get(3, 0), 1e-10);
		assertValueEquals(532.0, arrayValue.get(3, 1), 1e-10);
	}
	
	@Test
	public void elementAccessVector() {
		IValue value = evaluate("{ 1.0, 2, 3 }[1]");
		
		assertTrue(value instanceof ISimpleNumericValue);
		ISimpleNumericValue numericValue = (ISimpleNumericValue) value;
		
		assertValueEquals(2.0, numericValue, 1e-10);
	}

	@Test
	public void elementAccessMatrix() {
		IValue value = evaluate("{ { 1.0, 2, 3 }, { 4, 5, 6 } }[1, 1]");
		
		assertTrue(value instanceof ISimpleNumericValue);
		ISimpleNumericValue numericValue = (ISimpleNumericValue) value;
		
		assertValueEquals(5.0, numericValue, 1e-10);
	}
	
	@Test
	public void sliceVector() {
		IValue value = evaluate("{ 1, 2.1, 3, 4, 5, 6 }[{ 1, 4, 2 }]");
		
		assertTrue(value instanceof IArrayValue);
		IArrayValue arrayValue = (IArrayValue) value;
		
		assertTrue(arrayValue.getDataType() instanceof ArrayType);
		assertTrue(arrayValue.getDataType().getElementType() instanceof RealType);
		assertEquals("Array must have 1 dimension", 1, arrayValue.getDataType().getDimensionality());
		assertEquals("Size must be 3", 3, TypeUtil.getArraySize(arrayValue.getDataType()));

		assertValueEquals(2.1, arrayValue.get(0), 1e-10);
		assertValueEquals(5.0, arrayValue.get(1), 1e-10);
		assertValueEquals(3.0, arrayValue.get(2), 1e-10);
	}

	@Test
	public void sliceMatrix() {
		IValue value = evaluate("{ { 1, 2.1, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }[{ 0, 2 }, { 1, 2 }]");
		
		assertTrue(value instanceof IArrayValue);
		IArrayValue arrayValue = (IArrayValue) value;
		
		assertTrue(arrayValue.getDataType() instanceof ArrayType);
		assertTrue(arrayValue.getDataType().getElementType() instanceof RealType);
		assertEquals("Array must have 2 dimensions", 2, arrayValue.getDataType().getDimensionality());
		assertEquals("Row size must be 2", 2, TypeUtil.getArrayRowSize(arrayValue.getDataType()));
		assertEquals("Column size must be 2", 2, TypeUtil.getArrayColumnSize(arrayValue.getDataType()));

		assertValueEquals(2.1, arrayValue.get(0, 0), 1e-10);
		assertValueEquals(3.0, arrayValue.get(0, 1), 1e-10);
		assertValueEquals(8.0, arrayValue.get(1, 0), 1e-10);
		assertValueEquals(9.0, arrayValue.get(1, 1), 1e-10);
	}

	@Test
	public void divideVectorScalar() {
		IValue value = evaluate("{ 4, 5.1, 6 } / 10");
		
		assertTrue(value instanceof IArrayValue);
		IArrayValue arrayValue = (IArrayValue) value;
		
		assertTrue(arrayValue.getDataType() instanceof ArrayType);
		assertTrue(arrayValue.getDataType().getElementType() instanceof RealType);
		assertEquals("Array must have 1 dimension", 1, arrayValue.getDataType().getDimensionality());
		assertEquals("Size must be 3", 3, TypeUtil.getArraySize(arrayValue.getDataType()));
		
		assertValueEquals(0.4, arrayValue.get(0), 1e-10);
		assertValueEquals(0.51, arrayValue.get(1), 1e-10);
		assertValueEquals(0.6, arrayValue.get(2), 1e-10);
	}

	@Test
	public void divideMatrixScalar() {
		IValue value = evaluate("{ { 1, 2, 3 }, { 4, 5.1, 6 } } / 10");
		
		assertTrue(value instanceof IArrayValue);
		IArrayValue arrayValue = (IArrayValue) value;
		
		assertTrue(arrayValue.getDataType() instanceof ArrayType);
		assertTrue(arrayValue.getDataType().getElementType() instanceof RealType);
		assertEquals("Array must have 2 dimensions", 2, arrayValue.getDataType().getDimensionality());
		assertEquals("Row size must be 2", 2, TypeUtil.getArrayRowSize(arrayValue.getDataType()));
		assertEquals("Column size must be 3", 3, TypeUtil.getArrayColumnSize(arrayValue.getDataType()));
		
		assertValueEquals(0.1, arrayValue.get(0, 0), 1e-10);
		assertValueEquals(0.2, arrayValue.get(0, 1), 1e-10);
		assertValueEquals(0.3, arrayValue.get(0, 2), 1e-10);
		assertValueEquals(0.4, arrayValue.get(1, 0), 1e-10);
		assertValueEquals(0.51, arrayValue.get(1, 1), 1e-10);
		assertValueEquals(0.6, arrayValue.get(1, 2), 1e-10);
	}

	private void assertValueEquals(double expected, IValue actual, double delta) {
		assertTrue("Value must be ISimpleNumericValue", actual instanceof ISimpleNumericValue);
		assertEquals(expected, ((ISimpleNumericValue) actual).doubleValue(), delta);
	}
	
//	private void assertValueEquals(long expected, IValue actual) {
//		assertTrue("Value must be ISimpleNumericValue", actual instanceof ISimpleNumericValue);
//		assertEquals(expected, ((ISimpleNumericValue) actual).doubleValue());
//	}

}
