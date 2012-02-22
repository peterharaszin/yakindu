package org.eclipselabs.damos.dconfig.ui.contentassist;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipselabs.damos.dconfig.Binding;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.dml.util.DMLUtil;

import com.google.common.base.Predicate;

public class DconfigProposalProvider extends AbstractDconfigProposalProvider {

	@Override
	public void completeConfiguration_BaseConfiguration(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		Configuration configuration = DMLUtil.getOwner(model, Configuration.class);
		if (configuration != null) {
			final URI uri = EcoreUtil.getURI(configuration);
			if (uri != null) {
				lookupCrossReference(((CrossReference) assignment.getTerminal()), context, acceptor, new Predicate<IEObjectDescription>() {
		
					public boolean apply(IEObjectDescription input) {
						return !uri.equals(input.getEObjectURI());
					}
					
				});
				return;
			}
		}
		super.completeConfiguration_BaseConfiguration(model, assignment, context, acceptor);
	}
	
	@Override
	public void completeComponentReference_Component(final EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (DMLUtil.getOwner(model, Binding.class) != null) {
			lookupCrossReference(((CrossReference) assignment.getTerminal()), context, acceptor, new Predicate<IEObjectDescription>() {

				public boolean apply(IEObjectDescription input) {
					EObject eObject = input.getEObjectOrProxy();
					if (eObject.eIsProxy()) {
						EcoreUtil.resolve(eObject, model);
						if (eObject.eIsProxy()) {
							return false;
						}
					}
					return eObject instanceof Component && ((Component) eObject).isBoundary() || eObject instanceof Subsystem;
				}
				
			});
		} else {
			super.completeComponentReference_Component(model, assignment, context, acceptor);
		}
	}
	
}
