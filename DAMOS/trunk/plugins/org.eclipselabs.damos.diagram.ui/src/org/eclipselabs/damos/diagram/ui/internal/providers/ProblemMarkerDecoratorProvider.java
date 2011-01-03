package org.eclipselabs.damos.diagram.ui.internal.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
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
		EObject targetElement = getTargetElement(decoratorTarget);
		return  targetElement != null && targetElement instanceof FragmentElement;

	}

	private EObject getTargetElement(IDecoratorTarget decoratorTarget) {
		EditPart editPart = (EditPart) decoratorTarget.getAdapter(EditPart.class);
		if (editPart instanceof IGraphicalEditPart && !(editPart instanceof IBorderItemEditPart)) {
			return ((GraphicalEditPart) editPart).resolveSemanticElement();
		}
		return null;
	}

}
