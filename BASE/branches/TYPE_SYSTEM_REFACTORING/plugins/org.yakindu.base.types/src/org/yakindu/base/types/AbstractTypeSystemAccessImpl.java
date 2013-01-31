package org.yakindu.base.types;

import java.util.ArrayList;
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

}