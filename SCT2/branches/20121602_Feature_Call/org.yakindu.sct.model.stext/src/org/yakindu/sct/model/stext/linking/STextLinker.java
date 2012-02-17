package org.yakindu.sct.model.stext.linking;

import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.diagnostics.IDiagnosticProducer;

import de.itemis.xtext.utils.gmf.resource.InjectMembersLazyLinker;

public class STextLinker extends InjectMembersLazyLinker {
	@Override
	protected void ensureModelLinked(EObject model,
			final IDiagnosticProducer producer) {
		// The order of link resolution have to be changed here.
		// The FeatureCall is a container of the TypedElementReference,
		// but the child have to be resolved to determine the correct
		// for the FeatureCall
		List<EObject> contents = model.eContents();
		for (EObject current : contents) {
			EAnnotation eAnnotation = current.eClass().getEAnnotation(
					INJECT_MEMBERS);
			if (eAnnotation == null) {
				ensureModelLinked(current, producer);
				ensureLinked(current, producer);
			}
		}
		ensureLinked(model, producer);
	}
}
