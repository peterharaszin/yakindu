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

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.inject.Inject;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractTypeSystemInferrer implements ITypeSystemInferrer {

	private static final String NO_INFER_METHOD = "No infer method for type(s) %s";
	private static final String ASSERT_IS_TYPE = "Expected one of %s, but was %s.";
	private static final String ASSERT_NOT_TYPE = "Expected type is not %s.";
	private static final String ASSERT_SAME = "Expected types %s and %s are same.";
	private static final String ASSERT_COMPATIBLE = "Incompatible types %s and %s.";

	private static final String METHOD_NAME = "infer";

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
		return registry.getType(name);
	}

	protected Type getCommonType(EObject object1, EObject object2) {
		return registry.getCommonType(inferTypeDispatch(object1), inferTypeDispatch(object2));
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
				if(key instanceof Type){
					Collection<Type> types = registry.getTypes();
					for (Type type : types) {
						if (registry.isSame((Type) key, type))
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
							warning(String.format(NO_INFER_METHOD, Arrays.toString(params)));
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
			if (registry.isSame(currentType, type)) {
				same = true;
			}
		}
		if (!same) {
			error(msg != null ? msg : String.format(ASSERT_IS_TYPE, Arrays.toString(candidates), currentType));
		}
	}

	protected void assertNotType(Type currentType, String msg, Type... candidates) {
		if (currentType == null)
			return;
		for (Type type : candidates) {
			if (registry.isSame(currentType, type)) {
				error(msg != null ? msg : String.format(ASSERT_NOT_TYPE, currentType));
			}
		}
	}

	protected void assertSame(Type type1, Type type2, String msg) {
		if (type1 == null || type2 == null)
			return;
		if (!registry.isSame(type1, type2)) {
			error(msg != null ? msg : String.format(ASSERT_SAME, type1, type2));
		}
	}

	protected void assertCompatible(Type type1, Type type2, String msg) {
		if (type1 == null || type2 == null)
			return;
		if (!registry.haveCommonType(type1, type2)) {
			error(msg != null ? msg : String.format(ASSERT_COMPATIBLE, type1, type2));
		}
	}

	protected void assertAssignable(Type varType, Type valueType, String msg) {
		if (varType == null || valueType == null)
			return;
		if (!registry.isSuperType(valueType, varType)) {
			error(msg != null ? msg : String.format(ASSERT_COMPATIBLE, varType, valueType));
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
