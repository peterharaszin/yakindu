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

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipselabs.damos.mscript.util.TypeUtil;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Andreas Unger
 *
 */
public class NumericTypeTest {
	
	private static final String M = "m";

	private ResourceSet resourceSet;
	
	@Before
	public void setUp() {
		resourceSet = new ResourceSetImpl();
	}
	
	@Test
	public void addSubtractScalarScalar() {
		assertCommutative(ADD, SUBTRACT, real(), real(), real());
		assertCommutative(ADD, SUBTRACT, real(M), real(M), real(M));
		assertInvalid(ADD, SUBTRACT, real(M), real());

		assertCommutative(ADD, SUBTRACT, integer(), integer(), integer());
		assertCommutative(ADD, SUBTRACT, integer(M), integer(M), integer(M));
		assertInvalid(ADD, SUBTRACT, integer(M), integer());

		assertCommutative(ADD, SUBTRACT, real(), integer(), real());
		assertCommutative(ADD, SUBTRACT, real(M), integer(M), real(M));
		assertInvalid(ADD, SUBTRACT, real(M), integer());
	}
	
	@Test
	public void addSubtractScalarVector() {
		assertInvalid(ADD, SUBTRACT, real(), real(3));
		assertInvalid(ADD, SUBTRACT, real(M), real(3, M));
		assertInvalid(ADD, SUBTRACT, real(M), real(3));
	}
	
	@Test
	public void addSubtractScalarMatrix() {
		assertInvalid(ADD, SUBTRACT, real(), real(3, 2));
		assertInvalid(ADD, SUBTRACT, real(M), real(3, 2, M));
		assertInvalid(ADD, SUBTRACT, real(M), real(3, 2));
	}

	@Test
	public void addSubstractVectorVector() {
		assertCommutative(ADD, SUBTRACT, real(3), real(3), real(3));
		assertCommutative(ADD, SUBTRACT, real(3, M), real(3, M), real(3, M));
		assertInvalid(ADD, SUBTRACT, real(3), real(2));
		assertInvalid(ADD, SUBTRACT, real(3, M), real(2));
	}
	
	@Test
	public void addSubtractMatrixMatrix() {
		assertCommutative(ADD, SUBTRACT, real(3, 2), real(3, 2), real(3, 2));
		assertCommutative(ADD, SUBTRACT, real(3, 2, M), real(3, 2, M), real(3, 2, M));
		assertInvalid(ADD, SUBTRACT, real(3, 2), real(2, 2));
		assertInvalid(ADD, SUBTRACT, real(3, 2, M), real(2, 2));
	}
	
	@Test
	public void elementWiseAddSubtractScalarScalar() {
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(), real(), real());
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(M), real(M), real(M));
		assertInvalid(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(M), real());
	}
	
	@Test
	public void elementWiseAddSubtractScalarVector() {
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(), real(3), real(3));
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(M), real(3, M), real(3, M));
		assertInvalid(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(M), real(3));
	}
	
	@Test
	public void elementWiseAddSubtractScalarMatrix() {
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(), real(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(M), real(3, 2, M), real(3, 2, M));
		assertInvalid(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(M), real(3, 2));
	}

	@Test
	public void elementWiseAddSubtractVectorVector() {
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(3), real(3), real(3));
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(3, M), real(3, M), real(3, M));
		assertInvalid(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(3), real(2));
		assertInvalid(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(3, M), real(2));
	}
	
	@Test
	public void elementWiseAddSubtractMatrixMatrix() {
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(3, 2), real(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(3, 2, M), real(3, 2, M), real(3, 2, M));
		assertInvalid(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(3, 2), real(2, 2));
		assertInvalid(ELEMENT_WISE_ADD, ELEMENT_WISE_SUBTRACT, real(3, 2, M), real(2, 2));
	}

	@Test
	public void multiplyScalarScalar() {
		assertCommutative(MULTIPLY, real(), real(), real());
		assertCommutative(MULTIPLY, real(M), real(M), real(M, M));
		assertCommutative(MULTIPLY, real(M), real(), real(M));

		assertCommutative(MULTIPLY, integer(), integer(), integer());
		assertCommutative(MULTIPLY, integer(M), integer(M), integer(M, M));
		assertCommutative(MULTIPLY, integer(M), integer(), integer(M));

		assertCommutative(MULTIPLY, integer(), real(), real());
		assertCommutative(MULTIPLY, integer(M), real(M), real(M, M));
		assertCommutative(MULTIPLY, integer(M), real(), real(M));
	}
	
	@Test
	public void multiplyScalarVector() {
		assertCommutative(MULTIPLY, real(), real(3), real(3));
		assertCommutative(MULTIPLY, real(M), real(3, M), real(3, M, M));
		assertCommutative(MULTIPLY, real(M), real(3), real(3, M));
	}
	
	@Test
	public void multiplyScalarMatrix() {
		assertCommutative(MULTIPLY, real(), real(3, 2), real(3, 2));
		assertCommutative(MULTIPLY, real(M), real(3, 2, M), real(3, 2, M, M));
		assertCommutative(MULTIPLY, real(M), real(3, 2), real(3, 2, M));
	}

	@Test
	public void elementWiseMultiplyScalarScalar() {
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(), real(), real());
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(M), real(M), real(M, M));
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(M), real(), real(M));
	}
	
	@Test
	public void elementWiseMultiplyScalarVector() {
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(), real(3), real(3));
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(M), real(3, M), real(3, M, M));
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(M), real(3), real(3, M));
	}
	
	@Test
	public void elementWiseMultiplyScalarMatrix() {
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(), real(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(M), real(3, 2, M), real(3, 2, M, M));
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(M), real(3, 2), real(3, 2, M));
	}

	@Test
	public void elementWiseMultiplyVectorVector() {
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(3), real(3), real(3));
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(3, M), real(3, M), real(3, M, M));
		assertInvalid(ELEMENT_WISE_MULTIPLY, real(3), real(2));
		assertInvalid(ELEMENT_WISE_MULTIPLY, real(3, M), real(2));
	}
	
	@Test
	public void elementWiseMultiplyMatrixMatrix() {
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(3, 2), real(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_MULTIPLY, real(3, 2, M), real(3, 2, M), real(3, 2, M, M));
		assertInvalid(ELEMENT_WISE_MULTIPLY, real(3, 2), real(2, 2));
		assertInvalid(ELEMENT_WISE_MULTIPLY, real(3, 2, M), real(2, 2));
	}

	@Test
	public void multiplyVectorVector() {
		assertCommutative(MULTIPLY, real(3), real(3), real());
		assertCommutative(MULTIPLY, real(3, M), real(3, M), real(M, M));
		assertCommutative(MULTIPLY, real(3, M), real(3), real(M));
		assertInvalid(MULTIPLY, real(3), real(2));
		assertInvalid(MULTIPLY, real(3, M), real(2));
	}

	@Test
	public void multiplyVectorMatrix() {
		assertNonCommutative(MULTIPLY, real(3), real(3, 2), real(2));
		assertNonCommutative(MULTIPLY, real(3, M), real(3, 2, M), real(2, M, M));
		assertNonCommutative(MULTIPLY, real(3, M), real(3, 2), real(2, M));
		assertInvalid(MULTIPLY, real(3), real(2, 2));
		assertInvalid(MULTIPLY, real(3, M), real(2, 2));
	}

	@Test
	public void multiplyMatrixVector() {
		assertNonCommutative(MULTIPLY, real(3, 2), real(2), real(3));
		assertNonCommutative(MULTIPLY, real(3, 2, M), real(2, M), real(3, M, M));
		assertNonCommutative(MULTIPLY, real(3, 2), real(2, M), real(3, M));
		assertInvalid(MULTIPLY, real(2, 2), real(3));
		assertInvalid(MULTIPLY, real(2, 2), real(3, M));
	}

	@Test
	public void multiplyMatrixMatrix() {
		assertNonCommutative(MULTIPLY, real(3, 2), real(2, 4), real(3, 4));
		assertNonCommutative(MULTIPLY, real(3, 2, M), real(2, 4, M), real(3, 4, M, M));
		assertNonCommutative(MULTIPLY, real(3, 2), real(2, 4, M), real(3, 4, M));
		assertInvalid(MULTIPLY, real(3, 2), real(3, 2));
		assertInvalid(MULTIPLY, real(3, 2), real(3, 2, M));
	}

	@Test
	public void divideScalarScalar() {
		assertCommutative(DIVIDE, real(), real(), real());
		assertCommutative(DIVIDE, real(M), real(M), real());

		assertCommutative(DIVIDE, integer(), integer(), real());
		assertCommutative(DIVIDE, integer(M), integer(M), real());

		assertCommutative(DIVIDE, real(), integer(), real());
		assertCommutative(DIVIDE, real(M), integer(M), real());
	}

	@Test
	public void moduloScalarScalar() {
		assertCommutative(MODULO, real(), real(), real());
		assertCommutative(MODULO, real(M), real(M), real(M));
		assertInvalid(MODULO, real(M), real());

		// integer % integer results always in integer, e.g. 5 % 3 = 2
		assertCommutative(MODULO, integer(), integer(), integer());
		assertCommutative(MODULO, integer(M), integer(M), integer(M));
		assertInvalid(MODULO, integer(M), integer());

		assertCommutative(MODULO, real(), integer(), real());
		assertCommutative(MODULO, real(M), integer(M), real(M));
		assertInvalid(MODULO, real(M), integer());

		assertCommutative(MODULO, integer(), real(), real());
		assertCommutative(MODULO, integer(M), real(M), real(M));
		assertInvalid(MODULO, integer(M), real());
	}

	@Test
	public void divideVectorScalar() {
		assertNonCommutative(DIVIDE, real(3), real(), real(3));
		assertNonCommutative(DIVIDE, real(3, M), real(M), real(3));

		assertNonCommutative(DIVIDE, integer(3), integer(), real(3));
		assertNonCommutative(DIVIDE, integer(3, M), integer(M), real(3));

		assertNonCommutative(DIVIDE, real(3), integer(), real(3));
		assertNonCommutative(DIVIDE, real(3, M), integer(M), real(3));
	}

	@Test
	public void moduloVectorScalar() {
		assertNonCommutative(MODULO, real(3), real(), real(3));
		assertNonCommutative(MODULO, real(3, M), real(M), real(3, M));
		assertInvalid(MODULO, real(3, M), real());

		// integer % integer results always in integer, e.g. 5 % 3 = 2
		assertNonCommutative(MODULO, integer(3), integer(), integer(3));
		assertNonCommutative(MODULO, integer(3, M), integer(M), integer(3, M));
		assertInvalid(MODULO, integer(3, M), integer());

		assertNonCommutative(MODULO, real(3), integer(), real(3));
		assertNonCommutative(MODULO, real(3, M), integer(M), real(3, M));
		assertInvalid(MODULO, real(3, M), integer());

		assertNonCommutative(MODULO, integer(3), real(), real(3));
		assertNonCommutative(MODULO, integer(3, M), real(M), real(3, M));
		assertInvalid(MODULO, integer(3, M), real());
	}

	@Test
	public void divideMatrixScalar() {
		assertNonCommutative(DIVIDE, real(3, 2), real(), real(3, 2));
		assertNonCommutative(DIVIDE, real(3, 2, M), real(M), real(3, 2));

		assertNonCommutative(DIVIDE, integer(3, 2), integer(), real(3, 2));
		assertNonCommutative(DIVIDE, integer(3, 2, M), integer(M), real(3, 2));

		assertNonCommutative(DIVIDE, real(3, 2), integer(), real(3, 2));
		assertNonCommutative(DIVIDE, real(3, 2, M), integer(M), real(3, 2));
	}

	@Test
	public void moduloMatrixScalar() {
		assertNonCommutative(MODULO, real(3, 2), real(), real(3, 2));
		assertNonCommutative(MODULO, real(3, 2, M), real(M), real(3, 2, M));
		assertInvalid(MODULO, real(3, 2, M), real());

		// integer % integer results always in integer, e.g. 5 % 3 = 2
		assertNonCommutative(MODULO, integer(3, 2), integer(), integer(3, 2));
		assertNonCommutative(MODULO, integer(3, 2, M), integer(M), integer(3, 2, M));
		assertInvalid(MODULO, integer(3, 2, M), integer());

		assertNonCommutative(MODULO, real(3, 2), integer(), real(3, 2));
		assertNonCommutative(MODULO, real(3, 2, M), integer(M), real(3, 2, M));
		assertInvalid(MODULO, real(3, 2, M), integer());

		assertNonCommutative(MODULO, integer(3, 2), real(), real(3, 2));
		assertNonCommutative(MODULO, integer(3, 2, M), real(M), real(3, 2, M));
		assertInvalid(MODULO, integer(3, 2, M), real());
	}

	@Test
	public void elementWiseDivideScalarScalar() {
		assertCommutative(ELEMENT_WISE_DIVIDE, real(), real(), real());
		assertCommutative(ELEMENT_WISE_DIVIDE, real(M), real(M), real());

		assertCommutative(ELEMENT_WISE_DIVIDE, integer(), integer(), real());
		assertCommutative(ELEMENT_WISE_DIVIDE, integer(M), integer(M), real());

		assertCommutative(ELEMENT_WISE_DIVIDE, real(), integer(), real());
		assertCommutative(ELEMENT_WISE_DIVIDE, real(M), integer(M), real());
	}

	@Test
	public void elementWiseModuloScalarScalar() {
		assertCommutative(ELEMENT_WISE_MODULO, real(), real(), real());
		assertCommutative(ELEMENT_WISE_MODULO, real(M), real(M), real(M));
		assertInvalid(ELEMENT_WISE_MODULO, real(M), real());

		// integer % integer results always in integer, e.g. 5 % 3 = 2
		assertCommutative(ELEMENT_WISE_MODULO, integer(), integer(), integer());
		assertCommutative(ELEMENT_WISE_MODULO, integer(M), integer(M), integer(M));
		assertInvalid(ELEMENT_WISE_MODULO, integer(M), integer());

		assertCommutative(ELEMENT_WISE_MODULO, real(), integer(), real());
		assertCommutative(ELEMENT_WISE_MODULO, real(M), integer(M), real(M));
		assertInvalid(ELEMENT_WISE_MODULO, real(M), integer());

		assertCommutative(ELEMENT_WISE_MODULO, integer(), real(), real());
		assertCommutative(ELEMENT_WISE_MODULO, integer(M), real(M), real(M));
		assertInvalid(ELEMENT_WISE_MODULO, integer(M), real());
	}

	@Test
	public void elementWiseDivideScalarVector() {
		assertCommutative(ELEMENT_WISE_DIVIDE, real(), real(3), real(3));
		assertCommutative(ELEMENT_WISE_DIVIDE, real(M), real(3, M), real(3));

		assertCommutative(ELEMENT_WISE_DIVIDE, integer(), integer(3), real(3));
		assertCommutative(ELEMENT_WISE_DIVIDE, integer(M), integer(3, M), real(3));

		assertCommutative(ELEMENT_WISE_DIVIDE, real(), integer(3), real(3));
		assertCommutative(ELEMENT_WISE_DIVIDE, real(M), integer(3, M), real(3));
	}

	@Test
	public void elementWiseModuloScalarVector() {
		assertCommutative(ELEMENT_WISE_MODULO, real(), real(3), real(3));
		assertCommutative(ELEMENT_WISE_MODULO, real(M), real(3, M), real(3, M));
		assertInvalid(ELEMENT_WISE_MODULO, real(M), real(3));

		// integer % integer results always in integer, e.g. 5 % 3 = 2
		assertCommutative(ELEMENT_WISE_MODULO, integer(), integer(3), integer(3));
		assertCommutative(ELEMENT_WISE_MODULO, integer(M), integer(3, M), integer(3, M));
		assertInvalid(ELEMENT_WISE_MODULO, integer(M), integer(3));

		assertCommutative(ELEMENT_WISE_MODULO, real(), integer(3), real(3));
		assertCommutative(ELEMENT_WISE_MODULO, real(M), integer(3, M), real(3, M));
		assertInvalid(ELEMENT_WISE_MODULO, real(M), integer(3));

		assertCommutative(ELEMENT_WISE_MODULO, integer(), real(3), real(3));
		assertCommutative(ELEMENT_WISE_MODULO, integer(M), real(3, M), real(3, M));
		assertInvalid(ELEMENT_WISE_MODULO, integer(M), real(3));
	}

	@Test
	public void elementWiseDivideScalarMatrix() {
		assertCommutative(ELEMENT_WISE_DIVIDE, real(), real(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_DIVIDE, real(M), real(3, 2, M), real(3, 2));

		assertCommutative(ELEMENT_WISE_DIVIDE, integer(), integer(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_DIVIDE, integer(M), integer(3, 2, M), real(3, 2));

		assertCommutative(ELEMENT_WISE_DIVIDE, real(), integer(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_DIVIDE, real(M), integer(3, 2, M), real(3, 2));
	}

	@Test
	public void elementWiseModuloScalarMatrix() {
		assertCommutative(ELEMENT_WISE_MODULO, real(), real(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_MODULO, real(M), real(3, 2, M), real(3, 2, M));
		assertInvalid(ELEMENT_WISE_MODULO, real(M), real(3, 2));

		// integer % integer results always in integer, e.g. 5 % 3 = 2
		assertCommutative(ELEMENT_WISE_MODULO, integer(), integer(3, 2), integer(3, 2));
		assertCommutative(ELEMENT_WISE_MODULO, integer(M), integer(3, 2, M), integer(3, 2, M));
		assertInvalid(ELEMENT_WISE_MODULO, integer(M), integer(3, 2));

		assertCommutative(ELEMENT_WISE_MODULO, real(), integer(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_MODULO, real(M), integer(3, 2, M), real(3, 2, M));
		assertInvalid(ELEMENT_WISE_MODULO, real(M), integer(3, 2));

		assertCommutative(ELEMENT_WISE_MODULO, integer(), real(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_MODULO, integer(M), real(3, 2, M), real(3, 2, M));
		assertInvalid(ELEMENT_WISE_MODULO, integer(M), real(3, 2));
	}

	@Test
	public void elementWiseDivideVectorVector() {
		assertCommutative(ELEMENT_WISE_DIVIDE, real(3), real(3), real(3));
		assertCommutative(ELEMENT_WISE_DIVIDE, real(3, M), real(3, M), real(3));
		assertInvalid(ELEMENT_WISE_DIVIDE, real(3, M), real(2, M));

		assertCommutative(ELEMENT_WISE_DIVIDE, integer(3), integer(3), real(3));
		assertCommutative(ELEMENT_WISE_DIVIDE, integer(3, M), integer(3, M), real(3));
		assertInvalid(ELEMENT_WISE_DIVIDE, integer(3, M), integer(2, M));

		assertCommutative(ELEMENT_WISE_DIVIDE, real(3), integer(3), real(3));
		assertCommutative(ELEMENT_WISE_DIVIDE, real(3, M), integer(3, M), real(3));
		assertInvalid(ELEMENT_WISE_DIVIDE, real(3, M), integer(2, M));
	}

	@Test
	public void elementWiseModuloVectorVector() {
		assertCommutative(ELEMENT_WISE_MODULO, real(3), real(3), real(3));
		assertCommutative(ELEMENT_WISE_MODULO, real(3, M), real(3, M), real(3, M));
		assertInvalid(ELEMENT_WISE_MODULO, real(3, M), real(3));
		assertInvalid(ELEMENT_WISE_MODULO, real(3, M), real(2, M));

		// integer % integer results always in integer, e.g. 5 % 3 = 2
		assertCommutative(ELEMENT_WISE_MODULO, integer(3), integer(3), integer(3));
		assertCommutative(ELEMENT_WISE_MODULO, integer(3, M), integer(3, M), integer(3, M));
		assertInvalid(ELEMENT_WISE_MODULO, integer(3, M), integer(3));
		assertInvalid(ELEMENT_WISE_MODULO, integer(3, M), integer(2, M));

		assertCommutative(ELEMENT_WISE_MODULO, real(3), integer(3), real(3));
		assertCommutative(ELEMENT_WISE_MODULO, real(3, M), integer(3, M), real(3, M));
		assertInvalid(ELEMENT_WISE_MODULO, real(3, M), integer(3));
		assertInvalid(ELEMENT_WISE_MODULO, real(3, M), integer(2, M));

		assertCommutative(ELEMENT_WISE_MODULO, integer(3), real(3), real(3));
		assertCommutative(ELEMENT_WISE_MODULO, integer(3, M), real(3, M), real(3, M));
		assertInvalid(ELEMENT_WISE_MODULO, integer(3, M), real(3));
		assertInvalid(ELEMENT_WISE_MODULO, integer(3, M), real(2, M));
	}

	@Test
	public void elementWiseDivideMatrixMatrix() {
		assertCommutative(ELEMENT_WISE_DIVIDE, real(3, 2), real(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_DIVIDE, real(3, 2, M), real(3, 2, M), real(3, 2));
		assertInvalid(ELEMENT_WISE_DIVIDE, real(3, 2, M), real(2, 2, M));

		assertCommutative(ELEMENT_WISE_DIVIDE, integer(3, 2), integer(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_DIVIDE, integer(3, 2, M), integer(3, 2, M), real(3, 2));
		assertInvalid(ELEMENT_WISE_DIVIDE, integer(3, 2, M), integer(2, 2, M));

		assertCommutative(ELEMENT_WISE_DIVIDE, real(3, 2), integer(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_DIVIDE, real(3, 2, M), integer(3, 2, M), real(3, 2));
		assertInvalid(ELEMENT_WISE_DIVIDE, real(3, 2, M), integer(2, 2, M));
	}

	@Test
	public void elementWiseModuloMatrixMatrix() {
		assertCommutative(ELEMENT_WISE_MODULO, real(3, 2), real(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_MODULO, real(3, 2, M), real(3, 2, M), real(3, 2, M));
		assertInvalid(ELEMENT_WISE_MODULO, real(3, 2, M), real(3, 2));
		assertInvalid(ELEMENT_WISE_MODULO, real(3, 2, M), real(2, 2, M));

		// integer % integer results always in integer, e.g. 5 % 3 = 2
		assertCommutative(ELEMENT_WISE_MODULO, integer(3, 2), integer(3, 2), integer(3, 2));
		assertCommutative(ELEMENT_WISE_MODULO, integer(3, 2, M), integer(3, 2, M), integer(3, 2, M));
		assertInvalid(ELEMENT_WISE_MODULO, integer(3, 2, M), integer(3, 2));
		assertInvalid(ELEMENT_WISE_MODULO, integer(3, 2, M), integer(2, 2, M));

		assertCommutative(ELEMENT_WISE_MODULO, real(3, 2), integer(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_MODULO, real(3, 2, M), integer(3, 2, M), real(3, 2, M));
		assertInvalid(ELEMENT_WISE_MODULO, real(3, 2, M), integer(3, 2));
		assertInvalid(ELEMENT_WISE_MODULO, real(3, 2, M), integer(2, 2, M));

		assertCommutative(ELEMENT_WISE_MODULO, integer(3, 2), real(3, 2), real(3, 2));
		assertCommutative(ELEMENT_WISE_MODULO, integer(3, 2, M), real(3, 2, M), real(3, 2, M));
		assertInvalid(ELEMENT_WISE_MODULO, integer(3, 2, M), real(3, 2));
		assertInvalid(ELEMENT_WISE_MODULO, integer(3, 2, M), real(2, M));
	}

	private void assertInvalid(OperatorKind operator, Type type1, Type type2) {
		assertTrue(type1.evaluate(operator, type2) instanceof InvalidType);
		assertTrue(type2.evaluate(operator, type1) instanceof InvalidType);
	}

	private void assertInvalid(OperatorKind operator1, OperatorKind operator2, Type type1, Type type2) {
		assertTrue(type1.evaluate(operator1, type2) instanceof InvalidType);
		assertTrue(type2.evaluate(operator1, type1) instanceof InvalidType);
		assertTrue(type1.evaluate(operator2, type2) instanceof InvalidType);
		assertTrue(type2.evaluate(operator2, type1) instanceof InvalidType);
	}

	private void assertCommutative(OperatorKind operator, Type type1, Type type2, Type resultType) {
		assertTrue(type1.evaluate(operator, type2).isEquivalentTo(resultType));
		assertTrue(type2.evaluate(operator, type1).isEquivalentTo(resultType));
	}
	
	private void assertCommutative(OperatorKind operator1, OperatorKind operator2, Type type1, Type type2, Type resultType) {
		assertTrue(type1.evaluate(operator1, type2).isEquivalentTo(resultType));
		assertTrue(type2.evaluate(operator1, type1).isEquivalentTo(resultType));
		assertTrue(type1.evaluate(operator2, type2).isEquivalentTo(resultType));
		assertTrue(type2.evaluate(operator2, type1).isEquivalentTo(resultType));
	}

	private void assertNonCommutative(OperatorKind operator, Type type1, Type type2, Type resultType) {
		assertTrue(type1.evaluate(operator, type2).isEquivalentTo(resultType));
		assertTrue(type2.evaluate(operator, type1) instanceof InvalidType);
	}

//	private void assertNonCommutative(OperatorKind operator, DataType type1, DataType type2, DataType resultType1, DataType resultType2) {
//		assertTrue(type1.evaluate(operator, type2).isEquivalentTo(resultType1));
//		assertTrue(type2.evaluate(operator, type1).isEquivalentTo(resultType2));
//	}
//
//	private void assertNonCommutative(OperatorKind operator1, OperatorKind operator2, DataType type1, DataType type2, DataType resultType) {
//		assertTrue(type1.evaluate(operator1, type2).isEquivalentTo(resultType));
//		assertTrue(type2.evaluate(operator1, type1) instanceof InvalidType);
//		assertTrue(type1.evaluate(operator2, type2).isEquivalentTo(resultType));
//		assertTrue(type2.evaluate(operator2, type1) instanceof InvalidType);
//	}

	private Type real(String... symbols) {
		return TypeUtil.createRealType(resourceSet, symbols);
	}

	private Type real(int size, String... symbols) {
		return TypeUtil.createArrayType(real(symbols), size);
	}

	private Type real(int rowSize, int columnSize, String... symbols) {
		return TypeUtil.createArrayType(real(symbols), rowSize, columnSize);
	}

	private Type integer(String... symbols) {
		return TypeUtil.createIntegerType(resourceSet, symbols);
	}

	private Type integer(int size, String... symbols) {
		return TypeUtil.createArrayType(integer(symbols), size);
	}

	private Type integer(int rowSize, int columnSize, String... symbols) {
		return TypeUtil.createArrayType(integer(symbols), rowSize, columnSize);
	}

}
