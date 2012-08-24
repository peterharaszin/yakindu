package org.eclipselabs.damos.dmltext.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipselabs.damos.mscript.TopLevelContainer;
import org.eclipselabs.damos.mscript.TopLevelDeclaration;
import org.eclipselabs.damos.mscript.UnitDeclaration;
import org.eclipselabs.damos.mscript.UnitSymbol;
import org.eclipselabs.damos.mscript.scoping.MscriptScopeProvider;

public class DMLTextScopeProvider extends MscriptScopeProvider {

	public IScope scope_UnitFactor_symbol(TopLevelContainer context, EReference reference) {
		List<UnitSymbol> unitSymbols = new ArrayList<UnitSymbol>();
		for (TopLevelDeclaration d : context.getDeclarations()) {
			if (d instanceof UnitDeclaration) {
				unitSymbols.addAll(((UnitDeclaration) d).getSymbols());
			}
		}
		return Scopes.scopeFor(unitSymbols, super.scope_UnitSymbol(context, reference));
	}

}
