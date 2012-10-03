package org.eclipse.damos.dscript.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.damos.mscript.TopLevelContainer;
import org.eclipse.damos.mscript.TopLevelDeclaration;
import org.eclipse.damos.mscript.UnitDeclaration;
import org.eclipse.damos.mscript.UnitSymbol;
import org.eclipse.damos.mscript.scoping.MscriptScopeProvider;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;

public class DscriptScopeProvider extends MscriptScopeProvider {

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
