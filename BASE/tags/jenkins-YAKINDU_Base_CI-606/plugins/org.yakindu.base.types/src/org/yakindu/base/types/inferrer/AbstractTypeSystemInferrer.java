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
package org.yakindu.base.types.inferrer;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.yakindu.base.types.ITypeSystemRegistry;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer.ITypeTraceAcceptor.TypeTrace;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer.ITypeTraceAcceptor.TypeTrace.Severity;
import org.yakindu.base.types.typesystem.ITypeSystem;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.inject.Inject;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractTypeSystemInferrer implements ITypeSystemInferrer {

	private static final String METHOD_NAME = "infer";
	@Inject
	private ITypeSystem typeSystem;
	@Inject
	private ITypeSystemRegistry registry;

	private ITypeTraceAcceptor acceptor;

	private PolymorphicDispatcher<Object> dispatcher;

	private LoadingCache<EObject, Type> typeCache;

	public AbstractTypeSystemInferrer() {
		initDispatcher();
		initTypeCache();
	}

	protected Type getType(String name) {
		return typeSystem.getType(name);
	}

	protected Type getCommonType(EObject object1, EObject object2) {
		return typeSystem.getCommonType(inferTypeDispatch(object1), inferTypeDispatch(object2));
	}

	@Override
	public final Type inferType(EObject object, ITypeTraceAcceptor acceptor) {
		this.acceptor = (acceptor != null ? acceptor : new ListBasedTypeTraceAcceptor());
		info("infering type for object " + object);
		Type result = inferTypeDispatch(object);
		typeCache.invalidateAll();
		return result;
	}

	protected Type inferTypeDispatch(EObject object) {
		try {
			return typeCache.get(object);
		} catch (IllegalStateException e) {
			// Prevents recursive inference
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void initTypeCache() {
		typeCache = CacheBuilder.newBuilder().maximumSize(1000).build(new CacheLoader<EObject, Type>() {
			public Type load(EObject key) {
				Iterable<ITypeSystem> allTypeSystems = registry.getAllTypeSystems();
				for (ITypeSystem iTypeSystem : allTypeSystems) {
					Collection<Type> types = iTypeSystem.getTypes();
					for (Type type : types) {
						if (key instanceof Type && typeSystem.isSame((Type) key, type))
							return type;
					}
				}
				return (Type) (EObject) dispatcher.invoke(key);
			}
		});
	}

	protected void initDispatcher() {
		dispatcher = new PolymorphicDispatcher<Object>(METHOD_NAME, 1, 1, Collections.singletonList(this),
				new PolymorphicDispatcher.ErrorHandler<Object>() {
					@Override
					public Object handle(Object[] params, Throwable throwable) {
						if (throwable instanceof NoSuchMethodError) {
							warning("No infer method for type " + Arrays.toString(params));
						} else {
							error(throwable.getMessage());
						}
						return null;
					}
				});
	}

	protected void assertIsType(Type currentType, String msg, Type... candidates) {
		if (currentType == null)
			return;
		boolean same = false;
		for (Type type : candidates) {
			if (typeSystem.isSame(currentType, type)) {
				same = true;
			}
		}
		if (!same) {
			error(msg != null ? msg : "Expected one of " + Arrays.toString(candidates) + " but was " + currentType);
		}
	}

	protected void assertNotType(Type currentType, String msg, Type... candidates) {
		if (currentType == null)
			return;
		for (Type type : candidates) {
			if (typeSystem.isSame(currentType, type)) {
				error(msg != null ? msg : "Expected one of " + Arrays.toString(candidates) + " but was " + currentType);
			}
		}
	}

	protected void assertSame(Type type1, Type type2, String msg) {
		if (type1 == null || type2 == null)
			return;
		if (!typeSystem.isSame(type1, type2)) {
			error(msg != null ? msg : "Types not the same : " + type1 + " and " + type2);
		}
	}

	protected void assertCompatible(Type type1, Type type2, String msg) {
		if (type1 == null || type2 == null)
			return;
		if (!typeSystem.haveCommonType(type1, type2)) {
			error(msg != null ? msg : "Incompatible types " + type1 + " and " + type2);
		}
	}

	protected void assertAssignable(Type varType, Type valueType, String msg) {
		if (varType == null || valueType == null)
			return;
		if (!typeSystem.isSuperType(valueType, varType)) {
			error(msg != null ? msg : "Incompatible types " + varType + " and " + valueType);
		}
	}

	protected void info(String msg) {
		acceptor.accept(new TypeTrace(Severity.INFO, msg));
	}

	protected void warning(String msg) {
		acceptor.accept(new TypeTrace(Severity.WARNING, msg));
	}

	protected void error(String msg) {
		acceptor.accept(new TypeTrace(Severity.ERROR, msg));
	}
}
