package org.yakindu.base.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.base.types.Type;

public abstract class AbstractTypeSystemAccessImpl implements ITypeSystemAccess {

	@Override
	public Collection<Type> assign(Collection<? extends Type> leftTypes, Collection<? extends Type> rightTypes) {
		// combine, but retain left types only
		Collection<Type> combined = combine(leftTypes, rightTypes);
		List<Type> matched = new ArrayList<Type>();
		for(Type t1: leftTypes){
			for(Type t2: combined){
				if(EcoreUtil.equals(t1, t2)){
					matched.add(t1);
				}
			}
		}
		return matched;
	}

	@Override
	public Collection<Type> combine(Collection<? extends Type> leftTypes, Collection<? extends Type> rightTypes) {
		Set<Type> resultTypes = new HashSet<Type>();
		// add all common types to result set
		for (Type t1 : leftTypes) {
			for(Type t2 : rightTypes){
				if (EcoreUtil.equals(t1, t2)) {
					resultTypes.add(t1);
				}
			}
		}
		Set<Type> leftBacklog = new HashSet<Type>();
		leftBacklog.addAll(leftTypes);
		leftBacklog.removeAll(resultTypes);
		Set<Type> rightBacklog = new HashSet<Type>();
		rightBacklog.addAll(rightTypes);
		rightBacklog.removeAll(resultTypes);
	
		// we may add all void types (in case both lists contain any) as they
		// are all assumed to be compatible
		List<PrimitiveType> leftVoids = getVoidTypes(leftBacklog);
		List<PrimitiveType> rightVoids = getVoidTypes(rightBacklog);
		if (!leftVoids.isEmpty() && !rightVoids.isEmpty()) {
			resultTypes.addAll(leftVoids);
			resultTypes.addAll(rightVoids);
			leftBacklog.removeAll(leftVoids);
			rightBacklog.removeAll(rightVoids);
		}
	
		// we may add all boolean types (in case both lists contain any) as they
		// are all assumed to be compatible
		List<PrimitiveType> leftBooleans = getBooleanTypes(leftBacklog);
		List<PrimitiveType> rightBooleans = getBooleanTypes(rightBacklog);
		if (!leftBooleans.isEmpty() && !rightBooleans.isEmpty()) {
			resultTypes.addAll(leftBooleans);
			resultTypes.addAll(rightBooleans);
			leftBacklog.removeAll(leftBooleans);
			rightBacklog.removeAll(rightBooleans);
		}
	
		// we may add all string types (in case both lists contain any) as they
		// are all assumed to be compatible
		List<PrimitiveType> leftStrings = getStringTypes(leftBacklog);
		List<PrimitiveType> rightStrings = getStringTypes(rightBacklog);
		if (!leftStrings.isEmpty() && !rightStrings.isEmpty()) {
			resultTypes.addAll(leftStrings);
			resultTypes.addAll(rightStrings);
			leftBacklog.removeAll(leftStrings);
			rightBacklog.removeAll(rightStrings);
		}
	
		// we may add numerical types if they are regarded to be compatible (and
		// both lists contain any)
		List<Type> leftNumericals = getNumericalTypes(leftBacklog);
		List<Type> rightNumericals = getNumericalTypes(rightBacklog);
		if (!leftNumericals.isEmpty() && !rightNumericals.isEmpty()) {
			List<PrimitiveType> leftReals = getRealTypes(leftNumericals);
			List<PrimitiveType> rightReals = getRealTypes(rightNumericals);
			// if we have reals, we have to use the real types
			if (!leftReals.isEmpty() || !rightReals.isEmpty()) {
				resultTypes.addAll(leftReals);
				resultTypes.addAll(rightReals);
			} else {
				List<PrimitiveType> leftIntegers = getIntegerTypes(leftNumericals);
				List<PrimitiveType> rightIntegers = getIntegerTypes(rightNumericals);
				// integer and hex types
				if (!leftIntegers.isEmpty() && !rightIntegers.isEmpty()) {
					resultTypes.addAll(leftIntegers);
					resultTypes.addAll(rightIntegers);
				}
			}
		}
		return resultTypes;
	}

	@Override
	public List<PrimitiveType> getBooleanTypes(Collection<? extends Type> types) {
		List<PrimitiveType> newTypes = new ArrayList<PrimitiveType>();
		for (Type t : types) {
			if (t instanceof PrimitiveType && isBoolean(t)) {
				newTypes.add((PrimitiveType)t);
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

	@Override
	public List<PrimitiveType> getVoidTypes(Collection<? extends Type> types) {
		List<PrimitiveType> newTypes = new ArrayList<PrimitiveType>();
		for (Type t : types) {
			if (t instanceof PrimitiveType && isVoid(t)) {
				newTypes.add((PrimitiveType)t);
			}
		}
		return newTypes;
	}

	@Override
	public List<PrimitiveType> getIntegerTypes(Collection<? extends Type> types) {
		List<PrimitiveType> newTypes = new ArrayList<PrimitiveType>();
		for (Type t : types) {
			if (t instanceof PrimitiveType && isInteger(t)) {
				newTypes.add((PrimitiveType)t);
			}
		}
		return newTypes;
	}

	@Override
	public List<PrimitiveType> getRealTypes(Collection<? extends Type> types) {
		List<PrimitiveType> newTypes = new ArrayList<PrimitiveType>();
		for (Type t : types) {
			if (t instanceof PrimitiveType && isReal(t)) {
				newTypes.add((PrimitiveType)t);
			}
		}
		return newTypes;
	}

	@Override
	public List<PrimitiveType> getStringTypes(Collection<? extends Type> types) {
		List<PrimitiveType> newTypes = new ArrayList<PrimitiveType>();
		for (Type t : types) {
			if (t instanceof PrimitiveType && isString(t)) {
				newTypes.add((PrimitiveType)t);
			}
		}
		return newTypes;
	}
	
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

}