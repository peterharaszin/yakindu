package org.yakindu.sct.model.stext.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.Strings;
import org.yakindu.sct.model.sgraph.naming.SGraphNameProvider;
import org.yakindu.sct.model.stext.stext.InterfaceScope;

import com.google.inject.Inject;

public class StextNameProvider extends SGraphNameProvider {
	@Inject
	IQualifiedNameConverter nameConverter;

	QualifiedName qualifiedName(InterfaceScope ele) {
		QualifiedName name = null;
		if (!Strings.isEmpty(ele.getName())) {
			name = nameConverter.toQualifiedName(ele.getName());
		} else if (ele.getName() == null) {
			// Default interface
			name = nameConverter.toQualifiedName("default");
		}

		QualifiedName namespace = getNamespace(ele);
		if (namespace != null && name != null) {
			name = namespace.append(name);
		}
		return name;
	}

	protected QualifiedName getNamespace(EObject child) {
		QualifiedName name = super.getNamespace(child);
		if (!(child instanceof InterfaceScope)) {
			InterfaceScope interfaceScope = EcoreUtil2.getContainerOfType(
					child, InterfaceScope.class);
			if (interfaceScope != null
					&& getFullyQualifiedName(interfaceScope) != null) {
				name = getFullyQualifiedName(interfaceScope);
			}
		}
		return name;
	}
}
