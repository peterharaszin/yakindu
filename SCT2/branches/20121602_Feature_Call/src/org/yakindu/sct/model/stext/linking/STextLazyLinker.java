package org.yakindu.sct.model.stext.linking;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.linking.lazy.LazyLinker;
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement;

public class STextLazyLinker extends LazyLinker {

	@Override
	protected void clearReference(EObject obj, EReference ref) {
		// If the CompositeNodeWithSemanticElement adapter exists, we know that
		// this is an Xtext model element.
		if (EcoreUtil.getAdapter(obj.eAdapters(),
				CompositeNodeWithSemanticElement.class) != null) {
			super.clearReference(obj, ref);
		}

	}
}
