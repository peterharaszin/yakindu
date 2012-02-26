/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.stext.scoping;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.base.types.scope.TypeLibrariesExtensionPointScopeHelper;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * This Global Scope provider exposes only Statecharts as global objects to
 * prevent crossreferencing of Events and Variables between Statecharts.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class STextGlobalScopeProvider extends DefaultGlobalScopeProvider {


	@Inject
	private TypeLibrariesExtensionPointScopeHelper typeScopeHelper;

	public IScope getScope(Resource context, EReference reference,
			Predicate<IEObjectDescription> filter) {
	
		IScope globalScope = super.getScope(context, reference, filter);
		// add types from type libraries, in case the type of the reference refers to Type
		if (reference.getEReferenceType().isSuperTypeOf(TypesPackage.eINSTANCE.getType())) {
			return typeScopeHelper.createExtensionScope(globalScope);
		}
		return globalScope;
	}
}
