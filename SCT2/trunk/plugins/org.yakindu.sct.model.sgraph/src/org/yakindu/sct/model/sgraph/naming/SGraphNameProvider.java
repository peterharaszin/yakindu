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
package org.yakindu.sct.model.sgraph.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.util.Strings;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.ScopedElement;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Inject;

/**
 * NameProvider for SGraph elements like statecharts, scopes and declarations.
 * 
 * @author benjamin schwertfeger
 * 
 */
public class SGraphNameProvider extends DefaultDeclarativeQualifiedNameProvider {
	@Inject
	IQualifiedNameConverter nameConverter;

	QualifiedName qualifiedName(Statechart ele) {
		String scName = ele.getName();
		if (Strings.isEmpty(scName)) {
			return null;
		}
		QualifiedName name = nameConverter.toQualifiedName(scName);
		if (!Strings.isEmpty(ele.getNamespace())) {
			name = nameConverter.toQualifiedName(ele.getNamespace()).append(
					name);
		}
		return name;
	}

	QualifiedName qualifiedName(Scope ele) {
		QualifiedName name = null;
		String nameString = SimpleAttributeResolver.NAME_RESOLVER.apply(ele);
		if (!Strings.isEmpty(nameString)) {
			name = nameConverter.toQualifiedName(nameString);
		}

		QualifiedName namespace = getNamespace(ele);
		if (namespace != null && name != null) {
			name = namespace.append(name);
		}
		return name;
	}

	QualifiedName qualifiedName(Declaration ele) {
		QualifiedName name = null;
		if (!Strings.isEmpty(ele.getName())) {
			name = nameConverter.toQualifiedName(ele.getName());
		}
		QualifiedName namespace = getNamespace(ele);
		if (namespace != null && name != null) {
			name = namespace.append(name);
		}
		return name;
	}

	protected QualifiedName getNamespace(EObject child) {
		QualifiedName name = null;
		if (!(child instanceof ScopedElement)) {
			ScopedElement interfaceScope = EcoreUtil2.getContainerOfType(child,
					ScopedElement.class);
			if (interfaceScope != null
					&& !Strings.isEmpty(interfaceScope.getNamespace())) {
				name = nameConverter.toQualifiedName(interfaceScope
						.getNamespace());
			}
		}
		return name;
	}
}
