/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.yakindu.base.types.ITypeSystemAccess;
import org.yakindu.base.types.Type;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.stext.stext.EventRaisingExpression;
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.test.util.AbstractSTextTest;
import org.yakindu.sct.model.stext.test.util.STextInjectorProvider;
import org.yakindu.sct.model.stext.test.util.STextTestScopeProvider;
import org.yakindu.sct.model.stext.validation.ITypeInferrer;
import org.yakindu.sct.model.stext.validation.TypeCheckException;

import com.google.inject.Inject;

/**
 * @author andreas muelder - Initial contribution and API
 * @author axel terfloth - additional tests
 * @author Alexander Nyßen - Adopted to changes in type system
 * 
 */
@RunWith(XtextRunner.class)
@InjectWith(STextInjectorProvider.class)
public class TypeInferrerTest extends AbstractSTextTest {

	@Inject
	private ITypeInferrer analyzer;
	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Inject
	private ITypeSystemAccess ts;

	// Unary
	@Test
	public void testUnarySuccess() {
		// int
		assertTrue(!ts.getIntegerTypes(getTypes("1")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("0x0F")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("-1")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("0")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("myInt")).isEmpty());
		// real
		assertTrue(!ts.getRealTypes(getTypes("1.0")).isEmpty());
		assertTrue(!ts.getRealTypes(getTypes("-1.0")).isEmpty());
		assertTrue(!ts.getRealTypes(getTypes("0.0")).isEmpty());
		assertTrue(!ts.getRealTypes(getTypes("myReal")).isEmpty());
		// string
		assertTrue(!ts.getStringTypes(getTypes("'42'")).isEmpty());
		assertTrue(!ts.getStringTypes(getTypes("myString")).isEmpty());
		// boolean
		assertTrue(!ts.getBooleanTypes(getTypes("true")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("false")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("myBool")).isEmpty());
		// event
		assertTrue(!ts.getBooleanTypes(getTypes("event1")).isEmpty());
	}

	// Add
	@Test
	public void testAddSuccess() {
		Statement statement = (Statement) super.parseExpression("1+2",
				super.internalScope(), Expression.class.getSimpleName());
		analyzer.getTypes(statement);
		assertTrue(!ts.getIntegerTypes(analyzer.getTypes(statement)).isEmpty());

		assertTrue(!ts.getIntegerTypes(getTypes("1 + 2")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("1 + 0x0F")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("0x0F + 0x0F")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("myInt + 0x0F")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("myInt + 2")).isEmpty());
		assertTrue(!ts.getRealTypes(getTypes("1.1 + 2")).isEmpty());
		assertTrue(!ts.getRealTypes(getTypes("2 + 1.0")).isEmpty());
		assertTrue(!ts.getRealTypes(getTypes("1 + 2 + 3.0")).isEmpty());
	}

	@Test
	public void testAddException1() {
		expectOperatorPlusException();
		getTypes("true + 5");
	}

	@Test
	public void testAddException2() {
		expectOperatorPlusException();
		getTypes("false + 5");
	}

	@Test
	public void testAddException3() {
		expectOperatorPlusException();
		getTypes("5 + false");
	}

	@Test
	public void testAddException4() {
		expectOperatorPlusException();
		getTypes("true + (3 * 5)");
	}

	@Test
	public void testAddException5() {
		expectOperatorPlusException();
		getTypes("(3 * 5) + true");
	}

	@Test
	public void testAddException6() {
		expectOperatorPlusException();
		getTypes("3.0 +  true");
	}

	@Test
	public void testAddException7() {
		expectOperatorPlusException();
		getTypes("3.0 + 'string'");
	}

	@Test
	public void testAddException8() {
		expectOperatorPlusException();
		getTypes("myInt + 'string'");
	}

	// substract
	@Test
	public void testSubstractSuccess() {
		assertTrue(!ts.getIntegerTypes(getTypes("1 - 2")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("0x0F - 2")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("0x0F - 0x0F")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("0x0F- myInt")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("myInt - 2")).isEmpty());
		assertTrue(!ts.getRealTypes(getTypes("1.0 - 2")).isEmpty());
		assertTrue(!ts.getRealTypes(getTypes("2 - 1.0")).isEmpty());
		assertTrue(!ts.getRealTypes(getTypes("myReal - 1.0")).isEmpty());
		assertTrue(!ts.getRealTypes(getTypes("1 - 2 - 3.0")).isEmpty());
	}

	@Test
	public void testSubstractException1() {
		expectOperatorSubstractException();
		getTypes("true - 5");
	}

	@Test
	public void testSubstractException2() {
		expectOperatorSubstractException();
		getTypes("false - 5");
	}

	@Test
	public void testSubstractException3() {
		expectOperatorSubstractException();
		getTypes("5 - false");
	}

	@Test
	public void testSubstractException4() {
		expectOperatorSubstractException();
		getTypes("true - (3 * 5)");
	}

	@Test
	public void testSubstractException5() {
		expectOperatorSubstractException();
		getTypes("(3 * 5) - true");
	}

	@Test
	public void testSubstractException6() {
		expectOperatorSubstractException();
		getTypes("3.0 -  true");
	}

	@Test
	public void testSubstractException7() {
		expectOperatorSubstractException();
		getTypes("3.0 -  'string'");
	}

	@Test
	public void testSubstractException8() {
		expectOperatorSubstractException();
		getTypes("myReal -  'string'");
	}

	// multiply
	@Test
	public void testMultiplySuccess() {
		assertTrue(!ts.getIntegerTypes(getTypes("1 * 2")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("1 * 0x0F")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("0x0F * myInt")).isEmpty());
		assertTrue(!ts.getRealTypes(getTypes("myInt * myReal")).isEmpty());
		assertTrue(!ts.getRealTypes(getTypes("1.0 * 2")).isEmpty());
		assertTrue(!ts.getRealTypes(getTypes("2 * 1.0")).isEmpty());
		assertTrue(!ts.getRealTypes(getTypes("1 * 2 * 3.0")).isEmpty());
	}

	@Test
	public void testMultiplyException1() {
		expectOperatorMultiplyException();
		getTypes("true * 5");
	}

	@Test
	public void testMultiplyException2() {
		expectOperatorMultiplyException();
		getTypes("false * 5");
	}

	@Test
	public void testMultiplyException3() {
		expectOperatorMultiplyException();
		getTypes("5 * false");
	}

	@Test
	public void testMultiplyException4() {
		expectOperatorMultiplyException();
		getTypes("true * (3 - 5)");
	}

	@Test
	public void testMultiplyException5() {
		expectOperatorMultiplyException();
		getTypes("(3 + 5) * true");
	}

	@Test
	public void testMultiplyException6() {
		expectOperatorMultiplyException();
		getTypes("3.0 *  true");
	}

	@Test
	public void testMultiplyException7() {
		expectOperatorMultiplyException();
		getTypes("3.0 *  'string'");
	}

	@Test
	public void testMultiplyException8() {
		expectOperatorMultiplyException();
		getTypes("myReal *  'string'");
	}

	// divide
	@Test
	public void testDivideSuccess() {
		assertTrue(!ts.getIntegerTypes(getTypes("1 / 2")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("1 / myInt")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("1 / 0x0F")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("0x0F / 0x0F")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("myInt / 0x0F")).isEmpty());
		assertTrue(!ts.getRealTypes(getTypes("1.0 / 2")).isEmpty());
		assertTrue(!ts.getRealTypes(getTypes("2 / 1.0")).isEmpty());
		assertTrue(!ts.getRealTypes(getTypes("1 / 2 / 3.0")).isEmpty());
	}

	@Test
	public void testDivideException1() {
		expectOperatorDivideException();
		getTypes("true / 5");
	}

	@Test
	public void testDivideException2() {
		expectOperatorDivideException();
		getTypes("false / 5");
	}

	@Test
	public void testDivideException3() {
		expectOperatorDivideException();
		getTypes("5 / false");
	}

	@Test
	public void testDivideException4() {
		expectOperatorDivideException();
		getTypes("true / (3 - 5)");
	}

	@Test
	public void testDivideException5() {
		expectOperatorDivideException();
		getTypes("(3 + 5) / true");
	}

	@Test
	public void testDivideException6() {
		expectOperatorDivideException();
		getTypes("3.0 /  true");
	}

	@Test
	public void testDivideException7() {
		expectOperatorDivideException();
		getTypes("3.0 /  'string'");
	}

	@Test
	public void testDivideException8() {
		expectOperatorDivideException();
		getTypes("3.0 /  myString");
	}

	// mod
	@Test
	public void testModSuccess() {
		assertTrue(!ts.getIntegerTypes(getTypes("1 % 2")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("1 % 0x0F")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("0x0F % 0x0F")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("myInt % 0x0F")).isEmpty());
		assertTrue(!ts.getRealTypes(getTypes("1.0 % 2")).isEmpty());
		assertTrue(!ts.getRealTypes(getTypes("2 % 1.0")).isEmpty());
		assertTrue(!ts.getRealTypes(getTypes("2 % myReal")).isEmpty());
		assertTrue(!ts.getRealTypes(getTypes("1 % 2 % 3.0")).isEmpty());
	}

	@Test
	public void testModException1() {
		expectOperatorModException();
		getTypes("true % 5");
	}

	@Test
	public void testModException2() {
		expectOperatorModException();
		getTypes("false % 5");
	}

	@Test
	public void testModException3() {
		expectOperatorModException();
		getTypes("5 % false");
	}

	@Test
	public void testModException4() {
		expectOperatorModException();
		getTypes("true % (3 - 5)");
	}

	@Test
	public void testModException5() {
		expectOperatorModException();
		getTypes("(3 + 5) % true");
	}

	@Test
	public void testModException6() {
		expectOperatorModException();
		getTypes("3.0 % true");
	}

	@Test
	public void testModException7() {
		expectOperatorModException();
		getTypes("3.0 % 'string'");
	}

	@Test
	public void testModException8() {
		expectOperatorModException();
		getTypes("3.0 % myString");
	}

	@Test
	public void testModException9() {
		expectOperatorModException();
		getTypes("3.0 % myString");
	}

	// Logical And Or Not
	@Test
	public void testLogicalSuccess() {
		assertTrue(!ts.getBooleanTypes(getTypes("true || false")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("true || myBool")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("true || false && true")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("true || true &&( false || true)")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("!true")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("!myBool")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("!event1")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("!true && !false")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("event1 && !event1")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("event1 || event1")).isEmpty());
	}

	@Test
	public void testLogicalException1() {
		expectLogicalAndException();
		getTypes("true && 5");
	}

	@Test
	public void testLogicalException2() {
		expectLogicalOrException();
		getTypes("false || 5");
	}

	@Test
	public void testLogicalException3() {
		expectLogicalAndException();
		getTypes("5 && false");
	}

	@Test
	public void testLogicalException4() {
		expectLogicalAndException();
		getTypes("true && (3 - 5)");
	}

	@Test
	public void testLogicalException5() {
		expectLogicalOrException();
		getTypes("(3 + 5) || true");
	}

	@Test
	public void testLogicalException6() {
		expectLogicalAndException();
		getTypes("3.0 &&  true");
	}

	@Test
	public void testLogicalException7() {
		expectLogicalNotException();
		getTypes("!3");
	}

	@Test
	public void testLogicalException8() {
		expectLogicalNotException();
		getTypes("!1.2");
	}

	@Test
	public void testLogicalException9() {
		expectLogicalNotException();
		getTypes("!'Test'");
	}

	@Test
	public void testLogicalException10() {
		expectLogicalNotException();
		getTypes("!myString");
	}

	@Test
	public void testLogicalException11() {
		expectLogicalAndException();
		getTypes("5 && event1");
	}

	// LogicalRelation
	@Test
	public void testLogicalRelationSuccess() {
		assertTrue(!ts.getBooleanTypes(getTypes("5 < 3")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("5.0 < 3")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("5.0 < myInt")).isEmpty());

		assertTrue(!ts.getBooleanTypes(getTypes("5 <= 3")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("5.0 <= 3")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("5.0 <= myInt")).isEmpty());

		assertTrue(!ts.getBooleanTypes(getTypes("5 > 3")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("5.0 >= 3")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("5.0 >= myInt")).isEmpty());

		assertTrue(!ts.getBooleanTypes(getTypes("5 == 3")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("'string' == 'string'")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("5.0 == 3")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("true == myBool")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("true == event1")).isEmpty());

		assertTrue(!ts.getBooleanTypes(getTypes("5 != 3")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("'string' != 'string'")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("5.0 != 3")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("true != myBool")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("true != event1")).isEmpty());
	}

	@Test
	public void testLogicalRelationSmallerException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '<'");
		getTypes("3.0 < true");
	}

	@Test
	public void testLogicalRelationSmallerException2() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands string and integer for operator '<'");
		getTypes("'string' < 5");
	}

	@Test
	public void testLogicalRelationSmallerException3() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '<'");
		getTypes("1.0 < false");
	}

	@Test
	public void testLogicalRelationSmallerException4() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '<'");
		getTypes("1.0 < event1");
	}

	@Test
	public void testLogicalRelationSmallerEqualsException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '<='");
		getTypes("3.0 <= true");
	}

	@Test
	public void testLogicalRelationSmallerEqualException2() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands string and integer for operator '<='");
		getTypes("'string' <= 5");
	}

	@Test
	public void testLogicalRelationSmallerEqualException3() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '<='");
		getTypes("1.0 <= false");
	}

	@Test
	public void testLogicalRelationSmallerEqualException4() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '<='");
		getTypes("1.0 <= event1");
	}

	@Test
	public void testLogicalRelationGreaterException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '>'");
		getTypes("3.0 > true");
	}

	@Test
	public void testLogicalRelationGreaterException2() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands string and integer for operator '>'");
		getTypes("'string' > 5");
	}

	@Test
	public void testLogicalRelationGreaterException3() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '>'");
		getTypes("1.0 > false");
	}

	@Test
	public void testLogicalRelationGreaterEqualsException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '>='");
		getTypes("3.0 >= true");
	}

	@Test
	public void testLogicalRelationGreaterEqualException2() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands string and integer for operator '>='");
		getTypes("'string' >= 5");
	}

	@Test
	public void testLogicalRelationGreaterEqualException3() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '>='");
		getTypes("1.0 >= false");
	}

	@Test
	public void testLogicalRelationEqualsException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '=='");
		getTypes("3.0 == true");
	}

	@Test
	public void testLogicalRelationEqualException2() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands string and integer for operator '=='");
		getTypes("'string' == 5");
	}

	@Test
	public void testLogicalRelationEqualException3() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '=='");
		getTypes("1.0 == false");
	}

	@Test
	public void testLogicalRelationNotEqualsException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '!='");
		getTypes("3.0 != true");
	}

	@Test
	public void testLogicalRelationNotEqualException2() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands string and integer for operator '!='");
		getTypes("'string' != 5");
	}

	@Test
	public void testLogicalRelationNotEqualException3() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Incompatible operands real and boolean for operator '!='");
		getTypes("1.0 != false");
	}

	@Test
	public void testAssignmentSuccess() {
		assertTrue(!ts.getIntegerTypes(getTypes("ABC.myInt = 42")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("myInt = 5 * 3")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("myInt = 0x0F * 3")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("myInt = myInt * 0x0F")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("myBool = true || false")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("myBool = event1")).isEmpty());
		assertTrue(!ts.getStringTypes(getTypes("myString = 'string'")).isEmpty());
		assertTrue(!ts.getRealTypes(getTypes("myReal = 2.0 - 7")).isEmpty());
	}

	@Test
	public void testAssignmentException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Can not assign a value of type boolean to a variable of type integer");
		getTypes("myInt = true");
	}

	@Test
	public void testAssignmentException2() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Can not assign a value of type boolean to a variable of type integer");
		getTypes("myInt = myBool");
	}

	/**
	 * the {@link STextTestScopeProvider} adds a dummy state named 'chart.r1.A'
	 * to the Scope.
	 */
	@Test
	public void testActiveSuccess() throws Exception {
		assertTrue(!ts.getBooleanTypes(getTypes("active(chart.r1.A)")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("!active(chart.r1.A)")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("true || active(chart.r1.A)")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("active(chart.r1.A) && false")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("myBool = active(chart.r1.A)")).isEmpty());
	}

	@Test
	public void testActiveException1() throws Exception {
		expectOperatorPlusException();
		getTypes("active(chart.r1.A) + 1");
	}

	@Test
	public void testActiveException2() throws Exception {
		expectOperatorSubstractException();
		getTypes("active(chart.r1.A) -1");
	}

	@Test
	public void testActiveException3() throws Exception {
		expectOperatorMultiplyException();
		getTypes("active(chart.r1.A) *1");
	}

	@Test
	public void testActiveException4() throws Exception {
		expectOperatorDivideException();
		getTypes("active(chart.r1.A) /1");
	}

	@Test
	public void testActiveException5() throws Exception {
		expectOperatorModException();
		getTypes("active(chart.r1.A) % true");
	}

	@Test
	public void testActiveException6() throws Exception {
		expectLogicalAndException();
		getTypes("active(chart.r1.A) && myInt");
	}

	@Test
	public void testActiveException7() throws Exception {
		expectLogicalOrException();
		getTypes("active(chart.r1.A) || myString");
	}

	@Test
	public void testActiveException8() throws Exception {
		expectLogicalNotException();
		getTypes("active(chart.r1.A) && !myString");
	}

	@Test
	public void testBitwiseLogicalRelationSuccess() {
		assertTrue(!ts.getIntegerTypes(getTypes(" 5 & 3")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes(" 5 | 3")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes(" 5 ^ 3")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes(" ~3")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("3 << 2")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("5 >> 2")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("myInt << 4")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("myInt >> 4")).isEmpty());
	}

	@Test
	public void testBitwiseAndException1() throws Exception {
		expectBitwiseAndException();
		getTypes(" 5 & true");
	}

	@Test
	public void testBitwiseAndException2() throws Exception {
		expectBitwiseAndException();
		getTypes(" 5 & 1.0");
	}

	@Test
	public void testBitwiseAndException3() throws Exception {
		expectBitwiseAndException();
		getTypes(" 5 & 'myString'");
	}

	@Test
	public void testBitwiseOrException1() throws Exception {
		expectBitwiseOrException();
		getTypes(" 5 | true");
	}

	@Test
	public void testBitwiseOrException2() throws Exception {
		expectBitwiseOrException();
		getTypes(" 5 | 1.0");
	}

	@Test
	public void testBitwiseOrException3() throws Exception {
		expectBitwiseOrException();
		getTypes(" 5 | myString");
	}

	@Test
	public void testBitwiseXorException1() throws Exception {
		expectBitwiseXorException();
		getTypes(" 5 ^ true");
	}

	@Test
	public void testBitwiseXorException2() throws Exception {
		expectBitwiseXorException();
		getTypes(" 5 ^ 7.0");
	}

	@Test
	public void testBitwiseXorException3() throws Exception {
		expectBitwiseXorException();
		getTypes(" 5 ^ myString");
	}

	@Test
	public void testBitwiseComplementException1() throws Exception {
		expectBitwiseComplementException();
		getTypes(" ~true");
	}

	@Test
	public void testBitwiseComplementException2() throws Exception {
		expectBitwiseComplementException();
		getTypes(" ~9.0 ");
	}

	@Test
	public void testBitwiseComplementException3() throws Exception {
		expectBitwiseComplementException();
		getTypes(" ~myString");
	}

	@Test
	public void testBitwiseLeftShiftException1() throws Exception {
		expectBitwiseLeftShiftException();
		getTypes(" 5 << true");
	}

	@Test
	public void testBitwiseLeftShiftException2() throws Exception {
		expectBitwiseLeftShiftException();
		getTypes(" 5 << 7.0");
	}

	@Test
	public void testBitwiseLeftShiftException3() throws Exception {
		expectBitwiseLeftShiftException();
		getTypes(" 5 << myString");
	}

	@Test
	public void testBitwiseRightShiftException1() throws Exception {
		expectBitwiseRightShiftException();
		getTypes(" 5 >> true");
	}

	@Test
	public void testBitwiseRightShiftException2() throws Exception {
		expectBitwiseRightShiftException();
		getTypes(" 5 >> 7.0");
	}

	@Test
	public void testBitwiseRightShiftException3() throws Exception {
		expectBitwiseRightShiftException();
		getTypes(" 5 >> myString");
	}

	@Test
	public void testComplexExpressionsSuccess() {
		assertTrue(!ts.getBooleanTypes(getTypes("((((3 * myInt) + 5) % 2) > 97) || false")).isEmpty());
		assertTrue(!ts.getBooleanTypes(getTypes("!true != myBool && (3 > (myReal * 5 + 3))")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("3 * 3 + 7 / (3 * myInt % 8)")).isEmpty());
	}

	@Test
	public void testEventRaisingSuccess() {

		Scope context = createValuedEventsScope();
		// int events
		EObject statement = super.parseExpression("raise intEvent : 42",
				context, EventRaisingExpression.class.getSimpleName());
		analyzer.getTypes((Statement) statement);
		// bool events
		statement = super.parseExpression("raise boolEvent : myBool", context,
				EventRaisingExpression.class.getSimpleName());
		analyzer.getTypes((Statement) statement);
		// real events
		statement = super.parseExpression("raise realEvent : 2.0 - 3.0",
				context, EventRaisingExpression.class.getSimpleName());
		analyzer.getTypes((Statement) statement);
		// string events
		statement = super.parseExpression("raise stringEvent : 'string'",
				context, EventRaisingExpression.class.getSimpleName());
		analyzer.getTypes((Statement) statement);
		// no valued Events
		statement = super.parseExpression("raise event1", internalScope(),
				EventRaisingExpression.class.getSimpleName());
		analyzer.getTypes((Statement) statement);

	}

	@Test
	public void testValueOfSuccess() {
		Scope context = createValuedEventsScope();
		// int events
		EObject statement = super.parseExpression("valueof(intEvent)", context,
				EventValueReferenceExpression.class.getSimpleName());
		assertTrue(!ts.getIntegerTypes(analyzer.getTypes((Statement) statement)).isEmpty());
		// bool events
		statement = super.parseExpression("valueof(boolEvent)", context,
				EventValueReferenceExpression.class.getSimpleName());
		assertTrue(!ts.getBooleanTypes(analyzer.getTypes((Statement) statement)).isEmpty());
		// real events
		statement = super.parseExpression("valueof(realEvent)", context,
				EventValueReferenceExpression.class.getSimpleName());
		assertTrue(!ts.getRealTypes(analyzer.getTypes((Statement) statement)).isEmpty());
		// string events
		statement = super.parseExpression("valueof(stringEvent)", context,
				EventValueReferenceExpression.class.getSimpleName());
		assertTrue(!ts.getStringTypes(analyzer.getTypes((Statement) statement)).isEmpty());
		// void events
		statement = super.parseExpression("valueof(voidEvent)", context,
				EventValueReferenceExpression.class.getSimpleName());
		assertTrue(!ts.getVoidTypes(analyzer.getTypes((Statement) statement)).isEmpty());
		// interface events
		assertTrue(!ts.getIntegerTypes(getTypes("valueof(ABC.myIntEvent)")).isEmpty());
	}

	@Test
	public void testEventIsRaisedSuccess() {
		EObject statement = super.parseExpression("myBool = abc",
				internalScope(), Expression.class.getSimpleName());
		analyzer.getTypes((Statement) statement);
		
		statement = super.parseExpression("ABC.myBool = ABC.event2",
				interfaceScope(), Expression.class.getSimpleName());
		assertTrue(!ts.getBooleanTypes(analyzer.getTypes((Statement) statement)).isEmpty());
	}

	@Test
	public void testEventRaisingException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Can not assign a value of type boolean to an event of type integer");
		EObject statement = super.parseExpression("raise intEvent : true",
				createValuedEventsScope(),
				EventRaisingExpression.class.getSimpleName());
		analyzer.getTypes((Statement) statement);
	}

	@Test
	public void testEventRaisingException2() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Can not assign a value of type boolean to an event of type integer");
		EObject statement = super.parseExpression("raise intEvent : myBool",
				createValuedEventsScope(),
				EventRaisingExpression.class.getSimpleName());
		analyzer.getTypes((Statement) statement);
	}

	@Test
	public void testEventRaisingException3() {
		Scope context = createValuedEventsScope();
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Need to assign a value to an event of type string");
		EObject statement = super.parseExpression("raise stringEvent", context,
				EventRaisingExpression.class.getSimpleName());
		analyzer.getTypes((Statement) statement);
	}

	@Test
	public void testOperationSuccess() {
		EObject statement = super.parseExpression("myInt = myOpp1()",
				internalScope(), Expression.class.getSimpleName());
		analyzer.getTypes((Statement) statement);
	}

	@Test
	public void testOperationException1() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("Can not assign a value of type integer to a variable of type boolean");
		EObject statement = super.parseExpression("myBool = myOpp1()",
				internalScope(), Expression.class.getSimpleName());
		analyzer.getTypes((Statement) statement);
	}

	@Test
	public void parenthesizedExpression() {
		assertTrue(!ts.getBooleanTypes(getTypes("( true || false )")).isEmpty());
		assertTrue(!ts.getIntegerTypes(getTypes("( 5 )")).isEmpty());
		assertTrue(!ts.getRealTypes(getTypes("( 7.5 / 1.2 )")).isEmpty());
		assertTrue(!ts.getStringTypes(getTypes("( 'abc' )")).isEmpty());
	}

	/**
	 * 
	 * exception.expect(TypeCheckException.class); exception .expectMessage(
	 * "Can not assign a value of type integer to a variable of type boolean");
	 * EObject statement = super.parseExpression("myBool = myOpp1()", null,
	 * VariableDefinition); analyzer.getTypes((Statement) statement);
	 * 
	 */

	/**
	 * Convenience from here...
	 */
	private void expectOperatorPlusException() {
		exception.expect(TypeCheckException.class);
		exception.expectMessage("operator '+' can only be applied to numbers!");
	}

	private void expectOperatorSubstractException() {
		exception.expect(TypeCheckException.class);
		exception.expectMessage("operator '-' can only be applied to numbers!");
	}

	private void expectOperatorMultiplyException() {
		exception.expect(TypeCheckException.class);
		exception.expectMessage("operator '*' can only be applied to numbers!");
	}

	private void expectOperatorDivideException() {
		exception.expect(TypeCheckException.class);
		exception.expectMessage("operator '/' can only be applied to numbers!");
	}

	private void expectOperatorModException() {
		exception.expect(TypeCheckException.class);
		exception.expectMessage("operator '%' can only be applied to numbers!");
	}

	private void expectLogicalAndException() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("operator '&&' can only be applied to boolean values!");
	}

	private void expectLogicalOrException() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("operator '||' can only be applied to boolean values!");
	}

	private void expectLogicalNotException() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("operator '!' can only be applied to boolean values!");
	}

	private void expectBitwiseAndException() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("operator '&' can only be applied to integer values!");

	}

	private void expectBitwiseOrException() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("operator '|' can only be applied to integer values!");

	}

	private void expectBitwiseXorException() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("operator '^' can only be applied to integer values!");

	}

	private void expectBitwiseComplementException() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("operator '~' can only be applied to integer values!");

	}

	private void expectBitwiseLeftShiftException() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("operator '<<' can only be applied to integer values!");

	}

	private void expectBitwiseRightShiftException() {
		exception.expect(TypeCheckException.class);
		exception
				.expectMessage("operator '>>' can only be applied to integer values!");

	}

	private Scope createValuedEventsScope() {
		return createInternalScope("internal: var myBool : boolean event intEvent : integer  event boolEvent : boolean event realEvent : real event stringEvent : string event voidEvent : void");
	}

	protected Collection<? extends Type> getTypes(String expression) {
		EObject statement = super.parseExpression(expression, Expression.class.getSimpleName(), super.internalScope(), super.interfaceScope());
		assertNotNull(statement);
		return analyzer.getTypes((Statement) statement);
	}

}
