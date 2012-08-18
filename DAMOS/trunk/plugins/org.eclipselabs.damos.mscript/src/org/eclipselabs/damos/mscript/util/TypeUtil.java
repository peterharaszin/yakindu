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

package org.eclipselabs.damos.mscript.util;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;
import org.eclipselabs.damos.mscript.AnonymousArrayType;
import org.eclipselabs.damos.mscript.ArrayDimension;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.IntegerLiteral;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.Module;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.Unit;
import org.eclipselabs.damos.mscript.UnitDeclaration;
import org.eclipselabs.damos.mscript.UnitFactor;
import org.eclipselabs.damos.mscript.UnitPrefix;
import org.eclipselabs.damos.mscript.UnitSymbol;
import org.eclipselabs.damos.mscript.scoping.MscriptGlobalScopeProvider;

/**
 * @author Andreas Unger
 *
 */
public class TypeUtil {
	
	public static final Type INVALID_TYPE = MscriptFactory.eINSTANCE.createInvalidType();
	public static final Type BOOLEAN_TYPE = MscriptFactory.eINSTANCE.createBooleanType();
	public static final Type STRING_TYPE = MscriptFactory.eINSTANCE.createStringType();
	public static final Type UNIT_TYPE = MscriptFactory.eINSTANCE.createUnitType();
	
	public static final String SECOND_UNIT = "s";

	public static RealType createRealType() {
		return createRealType(createUnit());
	}
	
	public static RealType createRealType(ResourceSet resourceSet, String... unitSymbolNames) {
		return createRealType(createUnit(resourceSet, unitSymbolNames));
	}

	public static RealType createRealType(Unit unit) {
		RealType realType = MscriptFactory.eINSTANCE.createRealType();
		realType.setUnit(unit);
		return realType;
	}

	public static IntegerType createIntegerType() {
		return createIntegerType(createUnit());
	}
	
	public static IntegerType createIntegerType(ResourceSet resourceSet, String... unitSymbolNames) {
		return createIntegerType(createUnit(resourceSet, unitSymbolNames));
	}

	public static IntegerType createIntegerType(Unit unit) {
		IntegerType integerType = MscriptFactory.eINSTANCE.createIntegerType();
		integerType.setUnit(unit);
		return integerType;
	}

	public static int getArraySize(ArrayType arrayType) {
		return getArrayRowSize(arrayType);
	}
	
	public static int getArrayRowSize(ArrayType arrayType) {
		if (arrayType.getDimensions().isEmpty()) {
			throw new IllegalArgumentException();
		}
		return getArrayDimensionSize(arrayType.getDimensions().get(0));
	}
	
	public static int getArrayColumnSize(ArrayType arrayType) {
		if (arrayType.getDimensions().size() < 2) {
			throw new IllegalArgumentException();
		}
		return getArrayDimensionSize(arrayType.getDimensions().get(1));
	}
	
	public static int getArrayDimensionSize(ArrayDimension arrayDimension) {
		Expression sizeExpression = arrayDimension.getSize();
		if (sizeExpression == null) {
			return -1;
		}
		if (sizeExpression instanceof IntegerLiteral) {
			return (int) ((IntegerLiteral) sizeExpression).getValue();
		}
		throw new IllegalArgumentException();
	}
	
	public static ArrayType createArrayType(Type elementType, int... sizes) {
		ArrayType arrayType = doCreateArrayType(elementType);
		for (int size : sizes) {
			addArrayDimension(arrayType, size);
		}
		return arrayType;
	}
	
	public static ArrayType createArrayType(Type elementType, Iterable<Integer> sizes) {
		ArrayType arrayType = doCreateArrayType(elementType);
		for (int size : sizes) {
			addArrayDimension(arrayType, size);
		}
		return arrayType;
	}

	public static ArrayType createArrayType(Type elementType, Collection<? extends ArrayDimension> dimensions) {
		ArrayType arrayType = doCreateArrayType(elementType);
		arrayType.getDimensions().addAll(dimensions);
		return arrayType;
	}

	private static ArrayType doCreateArrayType(Type elementType) {
		AnonymousArrayType arrayType = MscriptFactory.eINSTANCE.createAnonymousArrayType();
		arrayType.setElementType(elementType);
		return arrayType;
	}
	
	private static void addArrayDimension(ArrayType arrayType, int size) {
		ArrayDimension dimension = MscriptFactory.eINSTANCE.createArrayDimension();
		IntegerLiteral sizeExpression = MscriptFactory.eINSTANCE.createIntegerLiteral();
		sizeExpression.setUnit(TypeUtil.createUnit());
		sizeExpression.setValue(size);
		dimension.setSize(sizeExpression);
		arrayType.getDimensions().add(dimension);
	}
	
	@SuppressWarnings("unchecked")
	public static boolean equalArrayDimensions(ArrayType arrayType1, ArrayType arrayType2) {
		return new EqualityHelper().equals(
				(List<EObject>) (List<?>) arrayType1.getDimensions(),
				(List<EObject>) (List<?>) arrayType2.getDimensions());
	}
	
	public static Unit evaluateUnit(Unit unit, OperatorKind operator, Unit other) {
		if (unit == null) {
			return EcoreUtil.copy(other);
		}
		if (unit.getNumerator() == null) {
			MscriptFactory.eINSTANCE.createInvalidType();
		}
		return unit.evaluate(operator, other);
	}

	public static Unit evaluateUnit(Unit unit, OperatorKind operator, int n) {
		if (unit.getNumerator() == null) {
			MscriptFactory.eINSTANCE.createInvalidType();
		}
		return unit.evaluate(operator, n);
	}

	public static Unit createUnit() {
		return createUnit(0);
	}

	public static Unit createUnit(ResourceSet resourceSet, String... symbolNames) {
		return createUnit(resourceSet, 0, symbolNames);
	}
	
	public static Unit createUnit(int scale) {
		Unit unit = MscriptFactory.eINSTANCE.createUnit();
		unit.setNumerator(MscriptFactory.eINSTANCE.createUnitNumerator());
		unit.setScale(scale);
		return unit;
	}
	
	public static Unit createUnit(ResourceSet resourceSet, int scale, String... symbolNames) {
		Resource resource = resourceSet.getResource(URI.createURI(MscriptGlobalScopeProvider.LIBRARY_URI), true);
		Module module = (Module) EcoreUtil.getObjectByType(resource.getContents(), MscriptPackage.eINSTANCE.getModule());
		if (module == null) {
			return null;
		}
		
		Unit unit = createUnit(scale);
		for (String symbolName : symbolNames) {
			UnitSymbol symbol = findUnitSymbol(module, symbolName);
			if (symbol == null) {
				continue;
			}
			UnitFactor factor = unit.getNumerator().getFactor(symbol);
			if (factor != null) {
				factor.setExponent(factor.getExponent() + 1);
			} else {
				factor = MscriptFactory.eINSTANCE.createUnitFactor();
				factor.setSymbol(symbol);
				unit.getNumerator().getFactors().add(factor);
			}
		}
		
		return unit;
	}
	
	private static UnitSymbol findUnitSymbol(Module module, String name) {
		for (EObject eObject : module.getDeclarations()) {
			if (eObject instanceof UnitDeclaration) {
				UnitDeclaration unitDeclaration = (UnitDeclaration) eObject;
				if (name.equals(unitDeclaration.getName())) {
					for (UnitSymbol unitSymbol : unitDeclaration.getSymbols()) {
						if (unitSymbol.getPrefix() == UnitPrefix.NONE) {
							return unitSymbol;
						}
					}
				}
			}
		}
		return null;
	}
		
	public static Type getLeftHandDataType(Type dataType1, Type dataType2) {
		if (dataType1.isAssignableFrom(dataType2)) {
			return dataType1;
		} else if (dataType2.isAssignableFrom(dataType1)) {
			return dataType2;
		}
		return null;
	}
	
	public static boolean isNumericArray(Type type) {
		if (!(type instanceof ArrayType)) {
			return false;
		}
		return ((ArrayType) type).isNumeric();
	}
	
	public static boolean isNumericVector(Type type) {
		if (type instanceof ArrayType) {
			ArrayType arrayType = (ArrayType) type;
			return arrayType.isNumericVector();
		}
		return false;
	}
	
	public static boolean isNumericMatrix(Type type) {
		if (type instanceof ArrayType) {
			ArrayType arrayType = (ArrayType) type;
			return arrayType.isNumericMatrix();
		}
		return false;
	}

}
