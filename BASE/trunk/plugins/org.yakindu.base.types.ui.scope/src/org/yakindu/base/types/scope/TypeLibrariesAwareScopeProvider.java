package org.yakindu.base.types.scope;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.yakindu.base.types.TypesPackage;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

public class TypeLibrariesAwareScopeProvider extends DefaultGlobalScopeProvider {

	@Inject
	private TypeLibrariesExtensionPointScopeHelper helper;

	@Override
	protected IScope getScope(IScope parent, Resource context,
			boolean ignoreCase, EClass type,
			Predicate<IEObjectDescription> filter) {
		if (type == TypesPackage.Literals.TYPE) {
			parent = helper.createExtensionScope(parent);
		}
		return super.getScope(parent, context, ignoreCase, type, filter);
	}

}
