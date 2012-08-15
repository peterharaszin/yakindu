package org.eclipselabs.damos.dmltext.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipselabs.damos.mscript.Declaration;
import org.eclipselabs.damos.mscript.DeclarationContainer;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.UnitDeclaration;
import org.eclipselabs.damos.mscript.UnitSymbol;
import org.eclipselabs.damos.mscript.scoping.MscriptScopeProvider;

public class DMLTextScopeProvider extends MscriptScopeProvider {

	public IScope scope_UnitFactor_symbol(DeclarationContainer context, EReference reference) {
		List<UnitSymbol> unitSymbols = new ArrayList<UnitSymbol>();
		for (Declaration d : context.getDeclarations()) {
			if (d instanceof UnitDeclaration) {
				unitSymbols.addAll(((UnitDeclaration) d).getSymbols());
			}
		}
		Iterable<IEObjectDescription> parentElements = getDelegate().getScope(context, reference).getAllElements();
		Iterable<IEObjectDescription> filteredParentElements = Scopes.selectCompatible(parentElements, MscriptPackage.eINSTANCE.getUnitSymbol());
		return Scopes.scopeFor(unitSymbols, new SimpleScope(filteredParentElements));
	}

}
