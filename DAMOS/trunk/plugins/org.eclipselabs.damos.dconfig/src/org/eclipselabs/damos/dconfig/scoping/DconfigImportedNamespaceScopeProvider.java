/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.dconfig.scoping;

import static java.util.Collections.singletonList;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.eclipse.xtext.util.Strings;
import org.eclipselabs.damos.dconfig.Configuration;

import com.google.inject.Inject;

public class DconfigImportedNamespaceScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Override
	protected List<ImportNormalizer> internalGetImportedNamespaceResolvers(EObject context, boolean ignoreCase) {
		if (!(context instanceof Configuration)) {
			return Collections.emptyList();
		}
		Configuration configuration = (Configuration) context;
		List<ImportNormalizer> resolvers = super.internalGetImportedNamespaceResolvers(context, ignoreCase);
		if (!Strings.isEmpty(configuration.getPackageName())) {
			resolvers.add(new ImportNormalizer(qualifiedNameConverter.toQualifiedName(configuration.getPackageName()), true,
					ignoreCase));
		}
		return resolvers;
	}

	protected ImportNormalizer createImportedNamespaceResolver(final String namespace, boolean ignoreCase) {
		if (Strings.isEmpty(namespace)) {
			return null;
		}
		QualifiedName importedNamespace = qualifiedNameConverter.toQualifiedName(namespace);
		if (importedNamespace == null || importedNamespace.getSegmentCount() < 1) {
			return null;
		}
		boolean hasWildCard = ignoreCase ? importedNamespace.getLastSegment().equalsIgnoreCase(getWildCard())
				: importedNamespace.getLastSegment().equals(getWildCard());
		if (hasWildCard) {
			if (importedNamespace.getSegmentCount() <= 1) {
				return null;
			}
			return createImportNormalizer(importedNamespace.skipLast(1), true, ignoreCase);
		}
		return createImportNormalizer(importedNamespace, false, ignoreCase);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider#getLocalElementsScope(org.eclipse.xtext.scoping.IScope, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EReference)
	 */
	@Override
	protected IScope getLocalElementsScope(IScope parent, EObject context, EReference reference) {
		IScope result = parent;
		ISelectable allDescriptions = getAllDescriptions(context.eResource());
		QualifiedName name = getQualifiedNameOfLocalElement(context);
		boolean ignoreCase = isIgnoreCase(reference);
		final List<ImportNormalizer> namespaceResolvers = getImportedNamespaceResolvers(context, ignoreCase);
		if (!namespaceResolvers.isEmpty()) {
			if (isRelativeImport() && name!=null) {
				ImportNormalizer localNormalizer = createImportNormalizer(name, true, ignoreCase); 
				result = createImportScope(result, singletonList(localNormalizer), allDescriptions, reference.getEReferenceType(), isIgnoreCase(reference));
			}
			result = createImportScope(result, namespaceResolvers, null, reference.getEReferenceType(), isIgnoreCase(reference));
		}
		if (name!=null) {
			ImportNormalizer localNormalizer = createImportNormalizer(name, true, ignoreCase); 
			result = createImportScope(result, singletonList(localNormalizer), allDescriptions, reference.getEReferenceType(), isIgnoreCase(reference));
		}
		return result;
	}

	@Override
	protected boolean isRelativeImport() {
		return false;
	}

	private ImportNormalizer createImportNormalizer(QualifiedName importedNamespace, boolean wildCard, boolean ignoreCase) {
		return new ImportNormalizer(importedNamespace, wildCard, ignoreCase) {
			
			@Override
			public QualifiedName deresolve(QualifiedName fullyQualifiedName) {
				QualifiedName qualifiedName = super.deresolve(fullyQualifiedName);
				if (qualifiedName != null && qualifiedName.getSegmentCount() != 1) {
					return null;
				}
				return qualifiedName;
			}
			
		};
	}

}
