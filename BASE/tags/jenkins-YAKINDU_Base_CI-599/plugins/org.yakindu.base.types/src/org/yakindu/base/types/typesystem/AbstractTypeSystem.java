/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.types.typesystem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.base.types.Type;

/**
 * Abstract base implementation if {@link ITypeSystem}. Provides convenience
 * methods to determine type compatibility.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractTypeSystem implements ITypeSystem {

	private Map<String, Type> typeRegistry = new HashMap<String, Type>();
	private Map<Type, Type> extendsRegistry = new HashMap<Type, Type>();

	// Types must be contained in a resource to avoid dangling reference errors
	private Resource resource = new ResourceImpl();

	protected abstract void declareTypes();

	public AbstractTypeSystem() {
		declareTypes();
	}

	public Type getType(String type) {
		return typeRegistry.get(type);
	}

	public Type getSuperType(Type type) {
		return extendsRegistry.get(type);
	}

	public boolean isSuperType(Type subtype, Type supertype) {
		List<Type> typehierachy = new ArrayList<Type>();
		typehierachy.add(subtype);
		collectSupertypes(subtype, typehierachy);
		for (Type eObject : typehierachy) {
			if (isSame(eObject, supertype))
				return true;
		}
		return false;
	}

	private void collectSupertypes(Type subtypeClass, List<Type> typehierachy) {
		if (subtypeClass == null)
			return;
		Type superType = getSuperType(subtypeClass);
		if (superType != null) {
			typehierachy.add(superType);
			collectSupertypes(superType, typehierachy);
		}

	}

	public Collection<Type> getTypes() {
		return Collections.unmodifiableCollection(typeRegistry.values());
	}

	public void declareType(Type type, String name) {
		resource.getContents().add(type);
		typeRegistry.put(name, type);
	}

	public void declareSuperType(Type baseType, Type superType) {
		extendsRegistry.put(baseType, superType);
	}

	public boolean haveCommonType(Type type1, Type type2) {
		return getCommonType(type1, type2) != null;
	}

	public boolean isSame(Type type1, Type type2) {
		return EcoreUtil.equals(type1, type2);
	}

	public Type getCommonType(Type type1, Type type2) {
		if (isSame(type1, type2))
			return type1;
		if (isSuperType(type1, type2)) {
			return type2;
		}
		if (isSuperType(type2, type1))
			return type1;
		return null;
	}
}
