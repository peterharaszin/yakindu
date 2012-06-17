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

package org.eclipselabs.damos.mscript;

import static junit.framework.Assert.assertTrue;
import static org.eclipselabs.damos.mscript.OperatorKind.ADD;
import static org.eclipselabs.damos.mscript.OperatorKind.ELEMENT_WISE_ADD;
import static org.eclipselabs.damos.mscript.OperatorKind.ELEMENT_WISE_SUBTRACT;
import static org.eclipselabs.damos.mscript.OperatorKind.SUBTRACT;

import org.eclipselabs.damos.mscript.util.TypeUtil;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Andreas Unger
 *
 */
public class NumericTypeTest {
	
	private static final String KG = "kg";
	
	@Test
	public void addSubtractScalarScalar() {
		assertCommutative(ADD, SUBTRACT, real(), real(), real());
		assertCommutative(ADD, SUBTRACT, real(KG), real(KG), real(KG));
		assertInvalid(ADD, SUBTRACT, real(KG), real());
	}
	
	@Test
	public void addSubtractScalarVector() {
		assertInvalid(ADD, SUBTRACT, real(), real(3));
		assertInvalid(ADD, SUBTRACT, real(KG), real(3, KG));
		assertInvalid(ADD, SUBTRACT, real(KG), real(3));
	}
	
	@Test
	public void addSubtractScalarMatrix() {
		assertInvalid(ADD, SUBTRACT, real(), real(3, 2));
		assertInvalid(ADD, SUBTRACT, real(KG), real(3, 2, KG));
		assertInvalid(ADD, SUBTRACT, real(KG), real(3, 2));
	}

	@Test
	public void addSubstractVectorVector() {
		assertCommutative(ADD, SUBTRACT, real(3), real(3), real(3));
		assertCommutative(ADD, SUBTRACT, real(3, KG), real(3, KG), real(3, KG));
		assertInvalid(ADD, SUBTRACT, real(3), real(2));
		assertInvalid(ADD, SUBTRACT, real(3, KG), real(2));
	}
	
	@Test
	public void addSubtractMatrixMatrix() {
		assertCommutative(ADD, SUBTRACT, real(3, 2), real(3, 2), real(3, 2));
		assertCommutative(ADD, SUBTRACT, real(3, 2, KG), real(3, 2, KG), real(3, 2, KG));
		assertInvalid(ADD, SUBTRACT, real(3, 2), real(2, 2));
		assertInvalid(ADD, SUBTRACT, real(3, 2, KG), real(2, 2));
	}
	
	@Test
	public void elementWiseAddSubtractScalarScalar() {
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(), real(), real());
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(KG), real(KG), real(KG));
		assertInvalid(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(KG), real());
	}
	
	@Ignore
	@Test
	public void elementWiseAddSubtractScalarVector() {
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(), real(3), real(3));
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(KG), real(3, KG), real(3, KG));
		assertInvalid(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(KG), real(3));
	}
	
	@Ignore
	@Test
	public void elementWiseAddSubtractScalarMatrix() {
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(), real(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(KG), real(3, 2, KG), real(3, 2, KG));
		assertInvalid(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(KG), real(3, 2));
	}

	@Ignore
	@Test
	public void elementWiseAddSubstractVectorVector() {
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(3), real(3), real(3));
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(3, KG), real(3, KG), real(3, KG));
		assertInvalid(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(3), real(2));
		assertInvalid(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(3, KG), real(2));
	}
	
	@Ignore
	@Test
	public void elementWiseAddSubtractMatrixMatrix() {
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(3, 2), real(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(3, 2, KG), real(3, 2, KG), real(3, 2, KG));
		assertInvalid(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(3, 2), real(2, 2));
		assertInvalid(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(3, 2, KG), real(2, 2));
	}

//	private void evaluateInvalid(OperatorKind operator, DataType type1, DataType type2) {
//		assertTrue(type1.evaluate(operator, type2) instanceof InvalidDataType);
//		assertTrue(type2.evaluate(operator, type1) instanceof InvalidDataType);
//	}

	private void assertInvalid(OperatorKind operator1, OperatorKind operator2, DataType type1, DataType type2) {
		assertTrue(type1.evaluate(operator1, type2) instanceof InvalidDataType);
		assertTrue(type2.evaluate(operator1, type1) instanceof InvalidDataType);
		assertTrue(type1.evaluate(operator2, type2) instanceof InvalidDataType);
		assertTrue(type2.evaluate(operator2, type1) instanceof InvalidDataType);
	}

//	private void assertCommutative(OperatorKind operator, DataType type1, DataType type2, DataType resultType) {
//		assertTrue(type1.evaluate(operator, type2).isEquivalentTo(resultType));
//		assertTrue(type2.evaluate(operator, type1).isEquivalentTo(resultType));
//	}
	
	private void assertCommutative(OperatorKind operator1, OperatorKind operator2, DataType type1, DataType type2, DataType resultType) {
		assertTrue(type1.evaluate(operator1, type2).isEquivalentTo(resultType));
		assertTrue(type2.evaluate(operator1, type1).isEquivalentTo(resultType));
		assertTrue(type1.evaluate(operator2, type2).isEquivalentTo(resultType));
		assertTrue(type2.evaluate(operator2, type1).isEquivalentTo(resultType));
	}

//	private void assertNonCommutative(OperatorKind operator, DataType type1, DataType type2, DataType resultType) {
//		assertTrue(type1.evaluate(operator, type2).isEquivalentTo(resultType));
//		assertTrue(type2.evaluate(operator, type1) instanceof InvalidDataType);
//	}

//	private void assertNonCommutative(OperatorKind operator1, OperatorKind operator2, DataType type1, DataType type2, DataType resultType) {
//		assertTrue(type1.evaluate(operator1, type2).isEquivalentTo(resultType));
//		assertTrue(type2.evaluate(operator1, type1) instanceof InvalidDataType);
//		assertTrue(type1.evaluate(operator2, type2).isEquivalentTo(resultType));
//		assertTrue(type2.evaluate(operator2, type1) instanceof InvalidDataType);
//	}

	private DataType real(String... symbols) {
		return TypeUtil.createRealType(symbols);
	}

	private DataType real(int size, String... symbols) {
		return TypeUtil.createArrayType(real(symbols), size);
	}

	private DataType real(int rowSize, int columnSize, String... symbols) {
		return TypeUtil.createArrayType(real(symbols), rowSize, columnSize);
	}

}
