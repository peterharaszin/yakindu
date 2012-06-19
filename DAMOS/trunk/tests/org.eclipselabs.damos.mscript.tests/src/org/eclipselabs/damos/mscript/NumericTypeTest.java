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
import static org.eclipselabs.damos.mscript.OperatorKind.DIVIDE;
import static org.eclipselabs.damos.mscript.OperatorKind.ELEMENT_WISE_ADD;
import static org.eclipselabs.damos.mscript.OperatorKind.ELEMENT_WISE_DIVIDE;
import static org.eclipselabs.damos.mscript.OperatorKind.ELEMENT_WISE_MODULO;
import static org.eclipselabs.damos.mscript.OperatorKind.ELEMENT_WISE_MULTIPLY;
import static org.eclipselabs.damos.mscript.OperatorKind.ELEMENT_WISE_SUBTRACT;
import static org.eclipselabs.damos.mscript.OperatorKind.MODULO;
import static org.eclipselabs.damos.mscript.OperatorKind.MULTIPLY;
import static org.eclipselabs.damos.mscript.OperatorKind.SUBTRACT;

import org.eclipselabs.damos.mscript.util.TypeUtil;
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

		assertCommutative(ADD, SUBTRACT, integer(), integer(), integer());
		assertCommutative(ADD, SUBTRACT, integer(KG), integer(KG), integer(KG));
		assertInvalid(ADD, SUBTRACT, integer(KG), integer());

		assertCommutative(ADD, SUBTRACT, real(), integer(), real());
		assertCommutative(ADD, SUBTRACT, real(KG), integer(KG), real(KG));
		assertInvalid(ADD, SUBTRACT, real(KG), integer());
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
	
	@Test
	public void elementWiseAddSubtractScalarVector() {
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(), real(3), real(3));
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(KG), real(3, KG), real(3, KG));
		assertInvalid(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(KG), real(3));
	}
	
	@Test
	public void elementWiseAddSubtractScalarMatrix() {
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(), real(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(KG), real(3, 2, KG), real(3, 2, KG));
		assertInvalid(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(KG), real(3, 2));
	}

	@Test
	public void elementWiseAddSubtractVectorVector() {
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(3), real(3), real(3));
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(3, KG), real(3, KG), real(3, KG));
		assertInvalid(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(3), real(2));
		assertInvalid(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(3, KG), real(2));
	}
	
	@Test
	public void elementWiseAddSubtractMatrixMatrix() {
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(3, 2), real(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(3, 2, KG), real(3, 2, KG), real(3, 2, KG));
		assertInvalid(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(3, 2), real(2, 2));
		assertInvalid(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(3, 2, KG), real(2, 2));
	}

	@Test
	public void multiplyScalarScalar() {
		assertCommutative(MULTIPLY, real(), real(), real());
		assertCommutative(MULTIPLY, real(KG), real(KG), real(KG, KG));
		assertCommutative(MULTIPLY, real(KG), real(), real(KG));

		assertCommutative(MULTIPLY, integer(), integer(), integer());
		assertCommutative(MULTIPLY, integer(KG), integer(KG), integer(KG, KG));
		assertCommutative(MULTIPLY, integer(KG), integer(), integer(KG));

		assertCommutative(MULTIPLY, integer(), real(), real());
		assertCommutative(MULTIPLY, integer(KG), real(KG), real(KG, KG));
		assertCommutative(MULTIPLY, integer(KG), real(), real(KG));
	}
	
	@Test
	public void multiplyScalarVector() {
		assertCommutative(MULTIPLY, real(), real(3), real(3));
		assertCommutative(MULTIPLY, real(KG), real(3, KG), real(3, KG, KG));
		assertCommutative(MULTIPLY, real(KG), real(3), real(3, KG));
	}
	
	@Test
	public void multiplyScalarMatrix() {
		assertCommutative(MULTIPLY, real(), real(3, 2), real(3, 2));
		assertCommutative(MULTIPLY, real(KG), real(3, 2, KG), real(3, 2, KG, KG));
		assertCommutative(MULTIPLY, real(KG), real(3, 2), real(3, 2, KG));
	}

	@Test
	public void elementWiseMultiplyScalarScalar() {
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(), real(), real());
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(KG), real(KG), real(KG, KG));
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(KG), real(), real(KG));
	}
	
	@Test
	public void elementWiseMultiplyScalarVector() {
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(), real(3), real(3));
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(KG), real(3, KG), real(3, KG, KG));
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(KG), real(3), real(3, KG));
	}
	
	@Test
	public void elementWiseMultiplyScalarMatrix() {
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(), real(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(KG), real(3, 2, KG), real(3, 2, KG, KG));
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(KG), real(3, 2), real(3, 2, KG));
	}

	@Test
	public void elementWiseMultiplyVectorVector() {
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(3), real(3), real(3));
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(3, KG), real(3, KG), real(3, KG, KG));
		assertInvalid(ELEMENT_WISE_MULTIPLY, real(3), real(2));
		assertInvalid(ELEMENT_WISE_MULTIPLY, real(3, KG), real(2));
	}
	
	@Test
	public void elementWiseMultiplyMatrixMatrix() {
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(3, 2), real(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(3, 2, KG), real(3, 2, KG), real(3, 2, KG, KG));
		assertInvalid(ELEMENT_WISE_MULTIPLY, real(3, 2), real(2, 2));
		assertInvalid(ELEMENT_WISE_MULTIPLY, real(3, 2, KG), real(2, 2));
	}

	@Test
	public void multiplyVectorVector() {
		assertCommutative(MULTIPLY, real(3), real(3), real());
		assertCommutative(MULTIPLY, real(3, KG), real(3, KG), real(KG, KG));
		assertCommutative(MULTIPLY, real(3, KG), real(3), real(KG));
		assertInvalid(MULTIPLY, real(3), real(2));
		assertInvalid(MULTIPLY, real(3, KG), real(2));
	}

	@Test
	public void multiplyVectorMatrix() {
		assertNonCommutative(MULTIPLY, real(3), real(3, 2), real(2));
		assertNonCommutative(MULTIPLY, real(3, KG), real(3, 2, KG), real(2, KG, KG));
		assertNonCommutative(MULTIPLY, real(3, KG), real(3, 2), real(2, KG));
		assertInvalid(MULTIPLY, real(3), real(2, 2));
		assertInvalid(MULTIPLY, real(3, KG), real(2, 2));
	}

	@Test
	public void multiplyMatrixVector() {
		assertNonCommutative(MULTIPLY, real(3, 2), real(2), real(3));
		assertNonCommutative(MULTIPLY, real(3, 2, KG), real(2, KG), real(3, KG, KG));
		assertNonCommutative(MULTIPLY, real(3, 2), real(2, KG), real(3, KG));
		assertInvalid(MULTIPLY, real(2, 2), real(3));
		assertInvalid(MULTIPLY, real(2, 2), real(3, KG));
	}

	@Test
	public void multiplyMatrixMatrix() {
		assertNonCommutative(MULTIPLY, real(3, 2), real(2, 4), real(3, 4));
		assertNonCommutative(MULTIPLY, real(3, 2, KG), real(2, 4, KG), real(3, 4, KG, KG));
		assertNonCommutative(MULTIPLY, real(3, 2), real(2, 4, KG), real(3, 4, KG));
		assertInvalid(MULTIPLY, real(3, 2), real(3, 2));
		assertInvalid(MULTIPLY, real(3, 2), real(3, 2, KG));
	}

	@Test
	public void divideScalarScalar() {
		assertCommutative(DIVIDE, real(), real(), real());
		assertCommutative(DIVIDE, real(KG), real(KG), real());

		assertCommutative(DIVIDE, integer(), integer(), real());
		assertCommutative(DIVIDE, integer(KG), integer(KG), real());

		assertCommutative(DIVIDE, real(), integer(), real());
		assertCommutative(DIVIDE, real(KG), integer(KG), real());
	}

	@Test
	public void moduloScalarScalar() {
		assertCommutative(MODULO, real(), real(), real());
		assertCommutative(MODULO, real(KG), real(KG), real(KG));
		assertInvalid(MODULO, real(KG), real());

		// integer % integer results always in integer, e.g. 5 % 3 = 2
		assertCommutative(MODULO, integer(), integer(), integer());
		assertCommutative(MODULO, integer(KG), integer(KG), integer(KG));
		assertInvalid(MODULO, integer(KG), integer());

		assertCommutative(MODULO, real(), integer(), real());
		assertCommutative(MODULO, real(KG), integer(KG), real(KG));
		assertInvalid(MODULO, real(KG), integer());

		assertCommutative(MODULO, integer(), real(), real());
		assertCommutative(MODULO, integer(KG), real(KG), real(KG));
		assertInvalid(MODULO, integer(KG), real());
	}

	@Test
	public void divideVectorScalar() {
		assertNonCommutative(DIVIDE, real(3), real(), real(3));
		assertNonCommutative(DIVIDE, real(3, KG), real(KG), real(3));

		assertNonCommutative(DIVIDE, integer(3), integer(), real(3));
		assertNonCommutative(DIVIDE, integer(3, KG), integer(KG), real(3));

		assertNonCommutative(DIVIDE, real(3), integer(), real(3));
		assertNonCommutative(DIVIDE, real(3, KG), integer(KG), real(3));
	}

	@Test
	public void moduloVectorScalar() {
		assertNonCommutative(MODULO, real(3), real(), real(3));
		assertNonCommutative(MODULO, real(3, KG), real(KG), real(3, KG));
		assertInvalid(MODULO, real(3, KG), real());

		// integer % integer results always in integer, e.g. 5 % 3 = 2
		assertNonCommutative(MODULO, integer(3), integer(), integer(3));
		assertNonCommutative(MODULO, integer(3, KG), integer(KG), integer(3, KG));
		assertInvalid(MODULO, integer(3, KG), integer());

		assertNonCommutative(MODULO, real(3), integer(), real(3));
		assertNonCommutative(MODULO, real(3, KG), integer(KG), real(3, KG));
		assertInvalid(MODULO, real(3, KG), integer());

		assertNonCommutative(MODULO, integer(3), real(), real(3));
		assertNonCommutative(MODULO, integer(3, KG), real(KG), real(3, KG));
		assertInvalid(MODULO, integer(3, KG), real());
	}

	@Test
	public void divideMatrixScalar() {
		assertNonCommutative(DIVIDE, real(3, 2), real(), real(3, 2));
		assertNonCommutative(DIVIDE, real(3, 2, KG), real(KG), real(3, 2));

		assertNonCommutative(DIVIDE, integer(3, 2), integer(), real(3, 2));
		assertNonCommutative(DIVIDE, integer(3, 2, KG), integer(KG), real(3, 2));

		assertNonCommutative(DIVIDE, real(3, 2), integer(), real(3, 2));
		assertNonCommutative(DIVIDE, real(3, 2, KG), integer(KG), real(3, 2));
	}

	@Test
	public void moduloMatrixScalar() {
		assertNonCommutative(MODULO, real(3, 2), real(), real(3, 2));
		assertNonCommutative(MODULO, real(3, 2, KG), real(KG), real(3, 2, KG));
		assertInvalid(MODULO, real(3, 2, KG), real());

		// integer % integer results always in integer, e.g. 5 % 3 = 2
		assertNonCommutative(MODULO, integer(3, 2), integer(), integer(3, 2));
		assertNonCommutative(MODULO, integer(3, 2, KG), integer(KG), integer(3, 2, KG));
		assertInvalid(MODULO, integer(3, 2, KG), integer());

		assertNonCommutative(MODULO, real(3, 2), integer(), real(3, 2));
		assertNonCommutative(MODULO, real(3, 2, KG), integer(KG), real(3, 2, KG));
		assertInvalid(MODULO, real(3, 2, KG), integer());

		assertNonCommutative(MODULO, integer(3, 2), real(), real(3, 2));
		assertNonCommutative(MODULO, integer(3, 2, KG), real(KG), real(3, 2, KG));
		assertInvalid(MODULO, integer(3, 2, KG), real());
	}

	@Test
	public void elementWiseDivideScalarScalar() {
		assertCommutative(ELEMENT_WISE_DIVIDE, real(), real(), real());
		assertCommutative(ELEMENT_WISE_DIVIDE, real(KG), real(KG), real());

		assertCommutative(ELEMENT_WISE_DIVIDE, integer(), integer(), real());
		assertCommutative(ELEMENT_WISE_DIVIDE, integer(KG), integer(KG), real());

		assertCommutative(ELEMENT_WISE_DIVIDE, real(), integer(), real());
		assertCommutative(ELEMENT_WISE_DIVIDE, real(KG), integer(KG), real());
	}

	@Test
	public void elementWiseModuloScalarScalar() {
		assertCommutative(ELEMENT_WISE_MODULO, real(), real(), real());
		assertCommutative(ELEMENT_WISE_MODULO, real(KG), real(KG), real(KG));
		assertInvalid(ELEMENT_WISE_MODULO, real(KG), real());

		// integer % integer results always in integer, e.g. 5 % 3 = 2
		assertCommutative(ELEMENT_WISE_MODULO, integer(), integer(), integer());
		assertCommutative(ELEMENT_WISE_MODULO, integer(KG), integer(KG), integer(KG));
		assertInvalid(ELEMENT_WISE_MODULO, integer(KG), integer());

		assertCommutative(ELEMENT_WISE_MODULO, real(), integer(), real());
		assertCommutative(ELEMENT_WISE_MODULO, real(KG), integer(KG), real(KG));
		assertInvalid(ELEMENT_WISE_MODULO, real(KG), integer());

		assertCommutative(ELEMENT_WISE_MODULO, integer(), real(), real());
		assertCommutative(ELEMENT_WISE_MODULO, integer(KG), real(KG), real(KG));
		assertInvalid(ELEMENT_WISE_MODULO, integer(KG), real());
	}

	@Test
	public void elementWiseDivideScalarVector() {
		assertCommutative(ELEMENT_WISE_DIVIDE, real(), real(3), real(3));
		assertCommutative(ELEMENT_WISE_DIVIDE, real(KG), real(3, KG), real(3));

		assertCommutative(ELEMENT_WISE_DIVIDE, integer(), integer(3), real(3));
		assertCommutative(ELEMENT_WISE_DIVIDE, integer(KG), integer(3, KG), real(3));

		assertCommutative(ELEMENT_WISE_DIVIDE, real(), integer(3), real(3));
		assertCommutative(ELEMENT_WISE_DIVIDE, real(KG), integer(3, KG), real(3));
	}

	@Test
	public void elementWiseModuloScalarVector() {
		assertCommutative(ELEMENT_WISE_MODULO, real(), real(3), real(3));
		assertCommutative(ELEMENT_WISE_MODULO, real(KG), real(3, KG), real(3, KG));
		assertInvalid(ELEMENT_WISE_MODULO, real(KG), real(3));

		// integer % integer results always in integer, e.g. 5 % 3 = 2
		assertCommutative(ELEMENT_WISE_MODULO, integer(), integer(3), integer(3));
		assertCommutative(ELEMENT_WISE_MODULO, integer(KG), integer(3, KG), integer(3, KG));
		assertInvalid(ELEMENT_WISE_MODULO, integer(KG), integer(3));

		assertCommutative(ELEMENT_WISE_MODULO, real(), integer(3), real(3));
		assertCommutative(ELEMENT_WISE_MODULO, real(KG), integer(3, KG), real(3, KG));
		assertInvalid(ELEMENT_WISE_MODULO, real(KG), integer(3));

		assertCommutative(ELEMENT_WISE_MODULO, integer(), real(3), real(3));
		assertCommutative(ELEMENT_WISE_MODULO, integer(KG), real(3, KG), real(3, KG));
		assertInvalid(ELEMENT_WISE_MODULO, integer(KG), real(3));
	}

	@Test
	public void elementWiseDivideScalarMatrix() {
		assertCommutative(ELEMENT_WISE_DIVIDE, real(), real(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_DIVIDE, real(KG), real(3, 2, KG), real(3, 2));

		assertCommutative(ELEMENT_WISE_DIVIDE, integer(), integer(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_DIVIDE, integer(KG), integer(3, 2, KG), real(3, 2));

		assertCommutative(ELEMENT_WISE_DIVIDE, real(), integer(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_DIVIDE, real(KG), integer(3, 2, KG), real(3, 2));
	}

	@Test
	public void elementWiseModuloScalarMatrix() {
		assertCommutative(ELEMENT_WISE_MODULO, real(), real(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_MODULO, real(KG), real(3, 2, KG), real(3, 2, KG));
		assertInvalid(ELEMENT_WISE_MODULO, real(KG), real(3, 2));

		// integer % integer results always in integer, e.g. 5 % 3 = 2
		assertCommutative(ELEMENT_WISE_MODULO, integer(), integer(3, 2), integer(3, 2));
		assertCommutative(ELEMENT_WISE_MODULO, integer(KG), integer(3, 2, KG), integer(3, 2, KG));
		assertInvalid(ELEMENT_WISE_MODULO, integer(KG), integer(3, 2));

		assertCommutative(ELEMENT_WISE_MODULO, real(), integer(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_MODULO, real(KG), integer(3, 2, KG), real(3, 2, KG));
		assertInvalid(ELEMENT_WISE_MODULO, real(KG), integer(3, 2));

		assertCommutative(ELEMENT_WISE_MODULO, integer(), real(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_MODULO, integer(KG), real(3, 2, KG), real(3, 2, KG));
		assertInvalid(ELEMENT_WISE_MODULO, integer(KG), real(3, 2));
	}

	@Test
	public void elementWiseDivideVectorVector() {
		assertCommutative(ELEMENT_WISE_DIVIDE, real(3), real(3), real(3));
		assertCommutative(ELEMENT_WISE_DIVIDE, real(3, KG), real(3, KG), real(3));
		assertInvalid(ELEMENT_WISE_DIVIDE, real(3, KG), real(2, KG));

		assertCommutative(ELEMENT_WISE_DIVIDE, integer(3), integer(3), real(3));
		assertCommutative(ELEMENT_WISE_DIVIDE, integer(3, KG), integer(3, KG), real(3));
		assertInvalid(ELEMENT_WISE_DIVIDE, integer(3, KG), integer(2, KG));

		assertCommutative(ELEMENT_WISE_DIVIDE, real(3), integer(3), real(3));
		assertCommutative(ELEMENT_WISE_DIVIDE, real(3, KG), integer(3, KG), real(3));
		assertInvalid(ELEMENT_WISE_DIVIDE, real(3, KG), integer(2, KG));
	}

	@Test
	public void elementWiseModuloVectorVector() {
		assertCommutative(ELEMENT_WISE_MODULO, real(3), real(3), real(3));
		assertCommutative(ELEMENT_WISE_MODULO, real(3, KG), real(3, KG), real(3, KG));
		assertInvalid(ELEMENT_WISE_MODULO, real(3, KG), real(3));
		assertInvalid(ELEMENT_WISE_MODULO, real(3, KG), real(2, KG));

		// integer % integer results always in integer, e.g. 5 % 3 = 2
		assertCommutative(ELEMENT_WISE_MODULO, integer(3), integer(3), integer(3));
		assertCommutative(ELEMENT_WISE_MODULO, integer(3, KG), integer(3, KG), integer(3, KG));
		assertInvalid(ELEMENT_WISE_MODULO, integer(3, KG), integer(3));
		assertInvalid(ELEMENT_WISE_MODULO, integer(3, KG), integer(2, KG));

		assertCommutative(ELEMENT_WISE_MODULO, real(3), integer(3), real(3));
		assertCommutative(ELEMENT_WISE_MODULO, real(3, KG), integer(3, KG), real(3, KG));
		assertInvalid(ELEMENT_WISE_MODULO, real(3, KG), integer(3));
		assertInvalid(ELEMENT_WISE_MODULO, real(3, KG), integer(2, KG));

		assertCommutative(ELEMENT_WISE_MODULO, integer(3), real(3), real(3));
		assertCommutative(ELEMENT_WISE_MODULO, integer(3, KG), real(3, KG), real(3, KG));
		assertInvalid(ELEMENT_WISE_MODULO, integer(3, KG), real(3));
		assertInvalid(ELEMENT_WISE_MODULO, integer(3, KG), real(2, KG));
	}

	@Test
	public void elementWiseDivideMatrixMatrix() {
		assertCommutative(ELEMENT_WISE_DIVIDE, real(3, 2), real(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_DIVIDE, real(3, 2, KG), real(3, 2, KG), real(3, 2));
		assertInvalid(ELEMENT_WISE_DIVIDE, real(3, 2, KG), real(2, 2, KG));

		assertCommutative(ELEMENT_WISE_DIVIDE, integer(3, 2), integer(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_DIVIDE, integer(3, 2, KG), integer(3, 2, KG), real(3, 2));
		assertInvalid(ELEMENT_WISE_DIVIDE, integer(3, 2, KG), integer(2, 2, KG));

		assertCommutative(ELEMENT_WISE_DIVIDE, real(3, 2), integer(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_DIVIDE, real(3, 2, KG), integer(3, 2, KG), real(3, 2));
		assertInvalid(ELEMENT_WISE_DIVIDE, real(3, 2, KG), integer(2, 2, KG));
	}

	@Test
	public void elementWiseModuloMatrixMatrix() {
		assertCommutative(ELEMENT_WISE_MODULO, real(3, 2), real(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_MODULO, real(3, 2, KG), real(3, 2, KG), real(3, 2, KG));
		assertInvalid(ELEMENT_WISE_MODULO, real(3, 2, KG), real(3, 2));
		assertInvalid(ELEMENT_WISE_MODULO, real(3, 2, KG), real(2, 2, KG));

		// integer % integer results always in integer, e.g. 5 % 3 = 2
		assertCommutative(ELEMENT_WISE_MODULO, integer(3, 2), integer(3, 2), integer(3, 2));
		assertCommutative(ELEMENT_WISE_MODULO, integer(3, 2, KG), integer(3, 2, KG), integer(3, 2, KG));
		assertInvalid(ELEMENT_WISE_MODULO, integer(3, 2, KG), integer(3, 2));
		assertInvalid(ELEMENT_WISE_MODULO, integer(3, 2, KG), integer(2, 2, KG));

		assertCommutative(ELEMENT_WISE_MODULO, real(3, 2), integer(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_MODULO, real(3, 2, KG), integer(3, 2, KG), real(3, 2, KG));
		assertInvalid(ELEMENT_WISE_MODULO, real(3, 2, KG), integer(3, 2));
		assertInvalid(ELEMENT_WISE_MODULO, real(3, 2, KG), integer(2, 2, KG));

		assertCommutative(ELEMENT_WISE_MODULO, integer(3, 2), real(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_MODULO, integer(3, 2, KG), real(3, 2, KG), real(3, 2, KG));
		assertInvalid(ELEMENT_WISE_MODULO, integer(3, 2, KG), real(3, 2));
		assertInvalid(ELEMENT_WISE_MODULO, integer(3, 2, KG), real(2, KG));
	}

	private void assertInvalid(OperatorKind operator, DataType type1, DataType type2) {
		assertTrue(type1.evaluate(operator, type2) instanceof InvalidDataType);
		assertTrue(type2.evaluate(operator, type1) instanceof InvalidDataType);
	}

	private void assertInvalid(OperatorKind operator1, OperatorKind operator2, DataType type1, DataType type2) {
		assertTrue(type1.evaluate(operator1, type2) instanceof InvalidDataType);
		assertTrue(type2.evaluate(operator1, type1) instanceof InvalidDataType);
		assertTrue(type1.evaluate(operator2, type2) instanceof InvalidDataType);
		assertTrue(type2.evaluate(operator2, type1) instanceof InvalidDataType);
	}

	private void assertCommutative(OperatorKind operator, DataType type1, DataType type2, DataType resultType) {
		assertTrue(type1.evaluate(operator, type2).isEquivalentTo(resultType));
		assertTrue(type2.evaluate(operator, type1).isEquivalentTo(resultType));
	}
	
	private void assertCommutative(OperatorKind operator1, OperatorKind operator2, DataType type1, DataType type2, DataType resultType) {
		assertTrue(type1.evaluate(operator1, type2).isEquivalentTo(resultType));
		assertTrue(type2.evaluate(operator1, type1).isEquivalentTo(resultType));
		assertTrue(type1.evaluate(operator2, type2).isEquivalentTo(resultType));
		assertTrue(type2.evaluate(operator2, type1).isEquivalentTo(resultType));
	}

	private void assertNonCommutative(OperatorKind operator, DataType type1, DataType type2, DataType resultType) {
		assertTrue(type1.evaluate(operator, type2).isEquivalentTo(resultType));
		assertTrue(type2.evaluate(operator, type1) instanceof InvalidDataType);
	}

//	private void assertNonCommutative(OperatorKind operator, DataType type1, DataType type2, DataType resultType1, DataType resultType2) {
//		assertTrue(type1.evaluate(operator, type2).isEquivalentTo(resultType1));
//		assertTrue(type2.evaluate(operator, type1).isEquivalentTo(resultType2));
//	}
//
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

	private DataType integer(String... symbols) {
		return TypeUtil.createIntegerType(symbols);
	}

	private DataType integer(int size, String... symbols) {
		return TypeUtil.createArrayType(integer(symbols), size);
	}

	private DataType integer(int rowSize, int columnSize, String... symbols) {
		return TypeUtil.createArrayType(integer(symbols), rowSize, columnSize);
	}

}
