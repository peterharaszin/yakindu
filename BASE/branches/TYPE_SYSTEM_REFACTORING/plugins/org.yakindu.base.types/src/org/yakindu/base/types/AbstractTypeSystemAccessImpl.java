package org.yakindu.base.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractTypeSystemAccessImpl implements ITypeSystemAccess {

	@Override
	public String getTargetLanguageTypeName(Type type) {
		return type.getName();
	}

	@Override
	public final List<Type> getTypes() {
		List<Type> types = new ArrayList<Type>();
		types.addAll(getPrimitiveTypes());
		types.addAll(getDataTypes());
		return types;
	}
	
	public List<PrimitiveType> getBooleanTypes(Collection<? extends Type> types) {
		List<PrimitiveType> newTypes = new ArrayList<PrimitiveType>();
		for (Type t : types) {
			if (t instanceof PrimitiveType && isBoolean(t)) {
				newTypes.add((PrimitiveType) t);
			}
		}
		return newTypes;
	}

	public List<Type> getNumericalTypes(Collection<? extends Type> types) {
		List<Type> newTypes = new ArrayList<Type>();
		for (Type t : types) {
			if (t instanceof PrimitiveType && (isReal(t) || isInteger(t))) {
				newTypes.add(t);
			}
		}
		return newTypes;
	}

	
	public List<PrimitiveType> getVoidTypes(Collection<? extends Type> types) {
		List<PrimitiveType> newTypes = new ArrayList<PrimitiveType>();
		for (Type t : types) {
			if (t instanceof PrimitiveType && isVoid(t)) {
				newTypes.add((PrimitiveType) t);
			}
		}
		return newTypes;
	}

	
	public List<PrimitiveType> getIntegerTypes(Collection<? extends Type> types) {
		List<PrimitiveType> newTypes = new ArrayList<PrimitiveType>();
		for (Type t : types) {
			if (t instanceof PrimitiveType && isInteger(t)) {
				newTypes.add((PrimitiveType) t);
			}
		}
		return newTypes;
	}

	
	public List<PrimitiveType> getRealTypes(Collection<? extends Type> types) {
		List<PrimitiveType> newTypes = new ArrayList<PrimitiveType>();
		for (Type t : types) {
			if (t instanceof PrimitiveType && isReal(t)) {
				newTypes.add((PrimitiveType) t);
			}
		}
		return newTypes;
	}

	
	public List<PrimitiveType> getStringTypes(Collection<? extends Type> types) {
		List<PrimitiveType> newTypes = new ArrayList<PrimitiveType>();
		for (Type t : types) {
			if (t instanceof PrimitiveType && isString(t)) {
				newTypes.add((PrimitiveType) t);
			}
		}
		return newTypes;
	}

}