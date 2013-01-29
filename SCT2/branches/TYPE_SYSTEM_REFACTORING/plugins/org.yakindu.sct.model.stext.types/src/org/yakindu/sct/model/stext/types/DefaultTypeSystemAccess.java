/**
 * Copyright (c) 2012 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.yakindu.base.types.AbstractTypeSystemAccessImpl;
import org.yakindu.base.types.DataType;
import org.yakindu.base.types.EnumerationType;
import org.yakindu.base.types.ITypeSystemAccess;
import org.yakindu.base.types.PrimitiveType;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypesFactory;

/**
 * TODO: add caching of primitive types
 * 
 * @author Alexander Nyßen - Initial contribution and API
 * 
 */
public class DefaultTypeSystemAccess extends AbstractTypeSystemAccessImpl
		implements ITypeSystemAccess {

	/**
	 * Dummy resource. Xtext linker expects types to be contained in a resource.
	 */
	private Resource resource;
	private PrimitiveType voidType;
	private PrimitiveType stringType;
	private PrimitiveType realType;
	private PrimitiveType integerType;
	private PrimitiveType booleanType;

	// public boolean isAssignable(Type varType, Type valType) {
	// if (varType == null && valType == null)
	// return true;
	// if (varType instanceof PrimitiveType && isVoid((PrimitiveType) varType)
	// && valType == null)
	// return true;
	// Type combine = combine(varType, valType);
	// if (combine == null) {
	// return false;
	// }
	// if (varType.getName().equals(combine.getName())) {
	// return true;
	// }
	// if ((varType instanceof PrimitiveType && isInteger((PrimitiveType)
	// varType))
	// && (valType instanceof PrimitiveType && isInteger((PrimitiveType)
	// valType))) {
	// return true;
	// }
	// if ((varType instanceof PrimitiveType && isReal((PrimitiveType) varType))
	// && (valType instanceof PrimitiveType && (isInteger((PrimitiveType)
	// valType) || isReal((PrimitiveType) valType)))) {
	// return true;
	// }
	// return false;
	// }

	private Resource getResource() {
		if (resource == null) {
			resource = new ResourceImpl();
			// use old uri for backwards compatibility
			resource.setURI(URI
					.createURI("platform:/plugin/org.yakindu.sct.model.stext/libraries/Primitives.types"));
		}
		return resource;
	}

	public PrimitiveType getBoolean() {
		if (booleanType == null) {
			booleanType = TypesFactory.eINSTANCE.createPrimitiveType();
			booleanType.setName("boolean");
			getResource().getContents().add(booleanType);
		}
		return booleanType;
	}

	public PrimitiveType getInteger() {
		if (integerType == null) {
			integerType = TypesFactory.eINSTANCE.createPrimitiveType();
			integerType.setName("integer");
			getResource().getContents().add(integerType);
		}
		return integerType;
	}

	public PrimitiveType getReal() {
		if (realType == null) {
			realType = TypesFactory.eINSTANCE.createPrimitiveType();
			realType.setName("real");
			getResource().getContents().add(realType);
		}
		return realType;
	}

	public PrimitiveType getString() {
		if (stringType == null) {
			stringType = TypesFactory.eINSTANCE.createPrimitiveType();
			stringType.setName("string");
			getResource().getContents().add(stringType);
		}
		return stringType;
	}

	public PrimitiveType getVoid() {
		if (voidType == null) {
			voidType = TypesFactory.eINSTANCE.createPrimitiveType();
			voidType.setName("void");
			getResource().getContents().add(voidType);
		}
		return voidType;
	}

	// public Type combine(Type typeOne, Type typeTwo) {
	// if (typeOne == null || typeTwo == null) {
	// return null;
	// }
	// if (typeOne.equals(typeTwo)
	// || typeOne.getName().equals(typeTwo.getName())) {
	// return typeOne;
	// }
	// if (typeOne instanceof PrimitiveType
	// && isInteger((PrimitiveType) typeOne)
	// && typeTwo instanceof PrimitiveType
	// && isReal((PrimitiveType) typeTwo)) {
	// return typeTwo;
	// }
	// if (typeOne instanceof PrimitiveType && isReal((PrimitiveType) typeOne)
	// && typeTwo instanceof PrimitiveType
	// && isInteger((PrimitiveType) typeTwo)) {
	// return typeOne;
	// }
	// // TODO
	// // List<Type> typesOne = allSuperTypes(typeOne);
	// // List<Type> typesTwo = allSuperTypes(typeTwo);
	// // List<Type> superType = typesOne.findFirst(t | typesTwo.contains(t));
	// // if (superType != null) {
	// // return superType;
	// // }
	//
	// return null;
	// }

	@Override
	public List<DataType> getDataTypes() {
		// no custom types by default
		return Collections.EMPTY_LIST;
	}

	@Override
	public final List<PrimitiveType> getPrimitiveTypes() {
		List<PrimitiveType> types = new ArrayList<PrimitiveType>();
		types.addAll(getVoidTypes());
		types.addAll(getBooleanTypes());
		types.addAll(getIntegerTypes());
		types.addAll(getRealTypes());
		types.addAll(getStringTypes());
		types.addAll(getEnumerationTypes());
		return types;
	}

	@Override
	public List<EnumerationType> getEnumerationTypes() {
		// no enum types by default
		return Collections.EMPTY_LIST;
	}

	@Override
	public String getTargetLanguageTypeName(Type type) {
		// default implementation is probably not meaningful. Has to be
		// overwritten by code generator.
		return type.getName();
	}

	public List<PrimitiveType> getVoidTypes() {
		return Collections.singletonList(getVoid());
	}

	public List<PrimitiveType> getBooleanTypes() {
		return Collections.singletonList(getBoolean());
	}

	public List<PrimitiveType> getIntegerTypes() {
		return Collections.singletonList(getInteger());
	}

	public List<PrimitiveType> getRealTypes() {
		return Collections.singletonList(getReal());
	}

	public List<PrimitiveType> getStringTypes() {
		return Collections.singletonList(getString());
	}

	@Override
	public boolean isVoid(Type type) {
		return type != null && type.getName() != null && type.getName().equals(getVoid().getName());
	}

	@Override
	public boolean isBoolean(Type type) {
		return type != null && type.getName() != null && type.getName().equals(getBoolean().getName());
	}

	@Override
	public boolean isInteger(Type type) {
		return type != null && type.getName() != null && type.getName().equals(getInteger().getName());
	}

	@Override
	public boolean isReal(Type type) {
		return type != null && type.getName() != null && type.getName().equals(getReal().getName());
	}

	@Override
	public boolean isString(Type type) {
		return type != null && type.getName() != null && type.getName().equals(getString().getName());
	}

}
