/**
 * Copyright (c) 2014 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 *  
 */
package org.yakindu.base.expressions.types;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.yakindu.base.expressions.expressions.BoolLiteral;
import org.yakindu.base.expressions.expressions.ExpressionsPackage;
import org.yakindu.base.expressions.expressions.IntLiteral;
import org.yakindu.base.expressions.expressions.RealLiteral;
import org.yakindu.base.expressions.expressions.StringLiteral;
import org.yakindu.base.expressions.expressions.TypeCastExpression;
import org.yakindu.base.types.Boolean;
import org.yakindu.base.types.Integer;
import org.yakindu.base.types.PrimitiveType;
import org.yakindu.base.types.Real;
import org.yakindu.base.types.String;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypesFactory;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.base.types.Void;

import com.google.inject.Singleton;

import de.itemis.xtext.typesystem.DefaultTypesystem;
import de.itemis.xtext.typesystem.trace.TypeCalculationTrace;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@Singleton
public abstract class ExpressionsTypeSystem extends DefaultTypesystem {

	protected TypesPackage typeLang = TypesPackage.eINSTANCE;
	protected TypesFactory typeFactory = TypesFactory.eINSTANCE;
	protected ExpressionsPackage expPackage = ExpressionsPackage.eINSTANCE;

	public Boolean BOOLEAN;
	public Integer INTEGER;
	public Real REAL;
	public String STRING;
	public Void VOID;

	private List<Type> types;
	private Resource typeResource;

	public ExpressionsTypeSystem() {
		typeResource = new ResourceImpl();
		types = new ArrayList<Type>();
	}

	@Override
	protected final synchronized void initialize() {
		try {
			initializeTypes();
			initializeExpressions();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Type> getTypes() {
		ensureInitialized();
		return types;
	}

	public void addType(Type type) {
		if (type.eResource() == null)
			typeResource.getContents().add(type);
		getTypes().add(type);
	}

	protected void initializeTypes() throws Exception {
		BOOLEAN = typeFactory.createBoolean();
		BOOLEAN.setName("boolean");
		addType(BOOLEAN);

		INTEGER = typeFactory.createInteger();
		INTEGER.setName("integer");
		addType(INTEGER);

		REAL = typeFactory.createReal();
		REAL.setName("real");
		addType(REAL);

		STRING = typeFactory.createString();
		STRING.setName("string");
		addType(STRING);

		VOID = typeFactory.createVoid();
		VOID.setName("void");
		addType(VOID);

		useCloneAsType(typeLang.getBoolean());
		useCloneAsType(typeLang.getInteger());
		useCloneAsType(typeLang.getReal());
		useCloneAsType(typeLang.getString());
		declareSubtype(typeLang.getInteger(), typeLang.getReal());
	}

	protected void initializeExpressions() throws Exception {
		initializeAssignmentExpression();
		initializeConditionalExpression();
		initializeLogicalOrExpression();
		initializeLogicalAndExpression();
		initializeLogicalNotExpression();
		initializeLogicalRelationExpression();
		initializeBitwiseXorExpression();
		initializeBitwiseOrExpression();
		initializeBitwiseAndExpression();
		initializeShiftExpression();
		initializeNumericalAddSubtractExpression();
		initializeNumericalMultiplyDivideExpression();
		initializeNumericalUnaryExpression();
		initializePrimitiveValueExpression();
		initializeElementReferenceExpression();
		initializeFeatureCall();
		initializeParenthesizedExpression();
	}

	protected void initializeParenthesizedExpression() throws Exception {
		useTypeOfFeature(expPackage.getParenthesizedExpression(), expPackage.getParenthesizedExpression_Expression());
	}

	protected void initializeFeatureCall() throws Exception {
		useTypeOfFeature(expPackage.getFeatureCall(), expPackage.getFeatureCall_Feature());
	}

	protected void initializeElementReferenceExpression() throws Exception {
		useTypeOfFeature(expPackage.getElementReferenceExpression(),
				expPackage.getElementReferenceExpression_Reference());
	}

	protected void initializeNumericalUnaryExpression() throws Exception {
		ensureFeatureType(expPackage.getNumericalUnaryExpression(), expPackage.getNumericalUnaryExpression_Operand(),
				typeLang.getInteger(), typeLang.getReal());
	}

	protected void initializePrimitiveValueExpression() throws Exception {
		useTypeOfFeature(expPackage.getPrimitiveValueExpression(), expPackage.getPrimitiveValueExpression_Value());
	}

	protected void initializeNumericalMultiplyDivideExpression() throws Exception {
		ensureFeatureType(expPackage.getNumericalMultiplyDivideExpression(),
				expPackage.getNumericalMultiplyDivideExpression_LeftOperand(), typeLang.getInteger(),
				typeLang.getReal());
		ensureFeatureType(expPackage.getNumericalMultiplyDivideExpression(),
				expPackage.getNumericalMultiplyDivideExpression_RightOperand(), typeLang.getInteger(),
				typeLang.getReal());
		computeCommonType(expPackage.getNumericalMultiplyDivideExpression(),
				expPackage.getNumericalMultiplyDivideExpression_LeftOperand(),
				expPackage.getNumericalMultiplyDivideExpression_RightOperand());
	}

	protected void initializeNumericalAddSubtractExpression() throws Exception {
		ensureFeatureType(expPackage.getNumericalAddSubtractExpression(),
				expPackage.getNumericalAddSubtractExpression_LeftOperand(), typeLang.getInteger(), typeLang.getReal());
		ensureFeatureType(expPackage.getNumericalAddSubtractExpression(),
				expPackage.getNumericalAddSubtractExpression_RightOperand(), typeLang.getInteger(), typeLang.getReal());
		computeCommonType(expPackage.getNumericalAddSubtractExpression(),
				expPackage.getNumericalAddSubtractExpression_LeftOperand(),
				expPackage.getNumericalAddSubtractExpression_RightOperand());

	}

	protected void initializeShiftExpression() throws Exception {
		ensureFeatureType(expPackage.getShiftExpression(), expPackage.getShiftExpression_LeftOperand(),
				typeLang.getInteger());
		ensureFeatureType(expPackage.getShiftExpression(), expPackage.getShiftExpression_RightOperand(),
				typeLang.getInteger());
	}

	protected void initializeBitwiseAndExpression() throws Exception {
		ensureFeatureType(expPackage.getBitwiseAndExpression(), expPackage.getBitwiseAndExpression_LeftOperand(),
				typeLang.getInteger());
		ensureFeatureType(expPackage.getBitwiseAndExpression(), expPackage.getBitwiseAndExpression_RightOperand(),
				typeLang.getInteger());
	}

	protected void initializeBitwiseOrExpression() throws Exception {
		ensureFeatureType(expPackage.getBitwiseOrExpression(), expPackage.getBitwiseOrExpression_LeftOperand(),
				typeLang.getInteger());
		ensureFeatureType(expPackage.getBitwiseOrExpression(), expPackage.getBitwiseOrExpression_RightOperand(),
				typeLang.getInteger());
	}

	protected void initializeBitwiseXorExpression() throws Exception {
		ensureFeatureType(expPackage.getBitwiseXorExpression(), expPackage.getBitwiseXorExpression_LeftOperand(),
				typeLang.getInteger(), typeLang.getReal());
		ensureFeatureType(expPackage.getBitwiseXorExpression(), expPackage.getBitwiseXorExpression_RightOperand(),
				typeLang.getInteger(), typeLang.getReal());
	}

	protected void initializeLogicalNotExpression() throws Exception {
		ensureFeatureType(expPackage.getLogicalNotExpression(), expPackage.getLogicalNotExpression_Operand(),
				typeLang.getBoolean());
	}

	protected void initializeLogicalRelationExpression() throws Exception {
		useFixedType(expPackage.getLogicalRelationExpression(), typeLang.getBoolean());
		ensureUnorderedCompatibility(expPackage.getLogicalRelationExpression(),
				expPackage.getLogicalRelationExpression_LeftOperand(),
				expPackage.getLogicalRelationExpression_RightOperand());
	}

	protected void initializeLogicalAndExpression() throws Exception {
		ensureFeatureType(expPackage.getLogicalAndExpression(), expPackage.getLogicalAndExpression_LeftOperand(),
				typeLang.getBoolean());
		ensureFeatureType(expPackage.getLogicalAndExpression(), expPackage.getLogicalAndExpression_RightOperand(),
				typeLang.getBoolean());
		useFixedType(expPackage.getLogicalAndExpression(), typeLang.getBoolean());
	}

	protected void initializeLogicalOrExpression() throws Exception {
		ensureFeatureType(expPackage.getLogicalOrExpression(), expPackage.getLogicalOrExpression_LeftOperand(),
				typeLang.getBoolean());
		ensureFeatureType(expPackage.getLogicalOrExpression(), expPackage.getLogicalOrExpression_RightOperand(),
				typeLang.getBoolean());
		useFixedType(expPackage.getLogicalOrExpression(), typeLang.getBoolean());
	}

	protected void initializeAssignmentExpression() throws Exception {
		useTypeOfFeature(expPackage.getAssignmentExpression(), expPackage.getAssignmentExpression_VarRef());
		ensureOrderedCompatibility(expPackage.getAssignmentExpression(), expPackage.getAssignmentExpression_VarRef(),
				expPackage.getAssignmentExpression_Expression());
	}

	protected void initializeConditionalExpression() throws Exception {
		ensureOrderedCompatibility(expPackage.getConditionalExpression(),
				expPackage.getConditionalExpression_TrueCase(), expPackage.getConditionalExpression_FalseCase());
		computeCommonType(expPackage.getConditionalExpression(), expPackage.getConditionalExpression_TrueCase(),
				expPackage.getConditionalExpression_FalseCase());
	}
	
	public EObject type(TypeCastExpression exp, TypeCalculationTrace trace) {
		return exp.getType();
	}
	

	public EObject type(IntLiteral l, TypeCalculationTrace trace) {
		return INTEGER;
	}

	public EObject type(BoolLiteral l, TypeCalculationTrace trace) {
		return BOOLEAN;
	}

	public EObject type(RealLiteral l, TypeCalculationTrace trace) {
		return REAL;
	}

	public EObject type(StringLiteral l, TypeCalculationTrace trace) {
		return STRING;
	}

	@Override
	public java.lang.String typeString(Object type) {
		if (type instanceof PrimitiveType) {
			return "'" + ((PrimitiveType) type).getName() + "'";
		}
		return super.typeString(type);
	}

}
