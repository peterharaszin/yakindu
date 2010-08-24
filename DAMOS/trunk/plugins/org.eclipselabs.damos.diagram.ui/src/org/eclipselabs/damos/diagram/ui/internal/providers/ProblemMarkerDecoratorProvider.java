package org.eclipselabs.damos.diagram.ui.internal.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipselabs.damos.dml.FragmentElement;

public class ProblemMarkerDecoratorProvider extends AbstractProvider implements IDecoratorProvider {

	private static final String DECORATOR_ID = "problemMarker";
	
	public void createDecorators(IDecoratorTarget decoratorTarget) {
		EObject element = getTargetElement(decoratorTarget);
		if (element != null) {
			decoratorTarget.installDecorator(DECORATOR_ID, new ProblemMarkerDecorator(decoratorTarget));
		}
	}

	public boolean provides(IOperation operation) {
		if (!(operation instanceof CreateDecoratorsOperation)) {
			return false;
		}
		IDecoratorTarget decoratorTarget = ((CreateDecoratorsOperation) operation).getDecoratorTarget();
		return getTargetElement(decoratorTarget) != null && getTargetElement(decoratorTarget) instanceof FragmentElement;

	}

	private EObject getTargetElement(IDecoratorTarget decoratorTarget) {
		EditPart editPart = (EditPart) decoratorTarget.getAdapter(EditPart.class);
		if (editPart instanceof GraphicalEditPart && ((GraphicalEditPart) editPart).getPrimaryView() == ((GraphicalEditPart) editPart).getNotationView()) {
			return ((GraphicalEditPart) editPart).resolveSemanticElement();
		}
		if (editPart instanceof ConnectionEditPart) {
			return ((ConnectionEditPart) editPart).resolveSemanticElement();
		}
		return null;
	}

}
