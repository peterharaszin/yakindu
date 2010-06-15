/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.mda4e.statemachine.contribution.providers;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.Label;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.mda4e.statemachine.contribution.parsers.XtextParserDelegate;

import statemachine.diagram.part.StatemachineDiagramEditor;

public class ParserValidationDecoratorProvider extends AbstractProvider
		implements IDecoratorProvider {

	private static final String KEY = "parserValidationStatus"; //$NON-NLS-1$

	public ParserValidationDecoratorProvider() {
		super();
	}

	public void createDecorators(final IDecoratorTarget decoratorTarget) {
		EditPart editPart = (EditPart) decoratorTarget
				.getAdapter(EditPart.class);
		if (editPart instanceof GraphicalEditPart
				|| editPart instanceof AbstractConnectionEditPart) {
			EditDomain ed = editPart.getViewer().getEditDomain();
			if (!(ed instanceof DiagramEditDomain)) {
				return;
			}
			IEditorPart ep = ((DiagramEditDomain) ed).getEditorPart();
			if (ep instanceof StatemachineDiagramEditor) {
				decoratorTarget.installDecorator(KEY, new AbstractDecorator(
						decoratorTarget) {

					private Adapter changeListener = new Adapter() {

						public Notifier getTarget() {
							return null;
						}

						public boolean isAdapterForType(Object type) {
							return false;
						}

						public void notifyChanged(Notification notification) {
							refresh();
						}

						public void setTarget(Notifier newTarget) {
						}

					};

					public void activate() {
						getSelectedElement(decoratorTarget).eAdapters().add(
								changeListener);
					}

					public void refresh() {
						removeDecoration();
						IParser parser = new ExpressionLanguageParserProvider()
								.getParser(decoratorTarget);
						if (parser instanceof XtextParserDelegate) {
							((XtextParserDelegate) parser).setSelectedElement(getSelectedElement(decoratorTarget));
						}
						String editString = parser
								.getEditString(decoratorTarget, 0);
						IParserEditStatus parserStatus = parser
								.isValidEditString(decoratorTarget, editString);
						if (parserStatus.getSeverity() == IParserEditStatus.ERROR
								|| parserStatus.getSeverity() == IParserEditStatus.WARNING) {
							setDecoration(getDecoratorTarget()
									.addShapeDecoration(
											getImage(parserStatus.getSeverity()),
											IDecoratorTarget.Direction.EAST, 0,
											true));
							getDecoration().setToolTip(
									new Label("Parsing Problem: "
											+ parserStatus.getMessage()));
						}
					}

					@Override
					public void deactivate() {
						getSelectedElement(decoratorTarget).eAdapters().remove(
								changeListener);
						super.deactivate();
					}

				});
			}
		}
	}

	protected Image getImage(int severity) {
		String imageName = ISharedImages.IMG_OBJS_ERROR_TSK;
		switch (severity) {
		case IStatus.ERROR:
			imageName = ISharedImages.IMG_OBJS_ERROR_TSK;
			break;
		case IStatus.WARNING:
			imageName = ISharedImages.IMG_OBJS_WARN_TSK;
			break;
		default:
			imageName = ISharedImages.IMG_OBJS_INFO_TSK;
		}
		return PlatformUI.getWorkbench().getSharedImages().getImage(imageName);
	}

	public boolean provides(IOperation operation) {
		if (!(operation instanceof CreateDecoratorsOperation)) {
			return false;
		}
		IDecoratorTarget decoratorTarget = ((CreateDecoratorsOperation) operation)
				.getDecoratorTarget();
		return new ExpressionLanguageParserProvider().getParser(decoratorTarget) != null;
	}

	private static EObject getSelectedElement(IDecoratorTarget decoratorTarget) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) decoratorTarget
				.getAdapter(IGraphicalEditPart.class);
		return editPart.resolveSemanticElement();
	}
}
