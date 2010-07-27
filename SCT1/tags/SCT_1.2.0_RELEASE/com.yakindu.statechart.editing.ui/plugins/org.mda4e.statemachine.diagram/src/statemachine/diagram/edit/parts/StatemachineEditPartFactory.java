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
package statemachine.diagram.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import statemachine.diagram.part.StatemachineVisualIDRegistry;

/**
 * @generated
 */
public class StatemachineEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (StatemachineVisualIDRegistry.getVisualID(view)) {

			case StatechartEditPart.VISUAL_ID:
				return new StatechartEditPart(view);

			case RegionEditPart.VISUAL_ID:
				return new RegionEditPart(view);

			case RegionPriorityEditPart.VISUAL_ID:
				return new RegionPriorityEditPart(view);

			case StateEditPart.VISUAL_ID:
				return new StateEditPart(view);

			case StateNameEditPart.VISUAL_ID:
				return new StateNameEditPart(view);

			case StateEntryEditPart.VISUAL_ID:
				return new StateEntryEditPart(view);

			case StateDoEditPart.VISUAL_ID:
				return new StateDoEditPart(view);

			case StateExitEditPart.VISUAL_ID:
				return new StateExitEditPart(view);

			case Region2EditPart.VISUAL_ID:
				return new Region2EditPart(view);

			case RegionPriority2EditPart.VISUAL_ID:
				return new RegionPriority2EditPart(view);

			case PseudostateEditPart.VISUAL_ID:
				return new PseudostateEditPart(view);

			case FinalStateEditPart.VISUAL_ID:
				return new FinalStateEditPart(view);

			case Pseudostate2EditPart.VISUAL_ID:
				return new Pseudostate2EditPart(view);

			case Pseudostate3EditPart.VISUAL_ID:
				return new Pseudostate3EditPart(view);

			case Pseudostate4EditPart.VISUAL_ID:
				return new Pseudostate4EditPart(view);

			case Pseudostate5EditPart.VISUAL_ID:
				return new Pseudostate5EditPart(view);

			case RegionRegionCompartmentEditPart.VISUAL_ID:
				return new RegionRegionCompartmentEditPart(view);

			case StateStateCompartmentEditPart.VISUAL_ID:
				return new StateStateCompartmentEditPart(view);

			case RegionRegionCompartment2EditPart.VISUAL_ID:
				return new RegionRegionCompartment2EditPart(view);

			case TransitionEditPart.VISUAL_ID:
				return new TransitionEditPart(view);

			case TransitionExpressionEditPart.VISUAL_ID:
				return new TransitionExpressionEditPart(view);

			case TransitionPriorityEditPart.VISUAL_ID:
				return new TransitionPriorityEditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
		if (source.getFigure() instanceof WrappingLabel)
			return new TextCellEditorLocator((WrappingLabel) source.getFigure());
		else {
			return new LabelCellEditorLocator((Label) source.getFigure());
		}
	}

	/**
	 * @generated
	 */
	static private class TextCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private WrappingLabel wrapLabel;

		/**
		 * @generated
		 */
		public TextCellEditorLocator(WrappingLabel wrapLabel) {
			this.wrapLabel = wrapLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getWrapLabel() {
			return wrapLabel;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getWrapLabel().getTextBounds().getCopy();
			getWrapLabel().translateToAbsolute(rect);
			if (getWrapLabel().isTextWrapOn()
					&& getWrapLabel().getText().length() > 0) {
				rect.setSize(new Dimension(text.computeSize(rect.width,
						SWT.DEFAULT)));
			} else {
				int avr = FigureUtilities.getFontMetrics(text.getFont())
						.getAverageCharWidth();
				rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
						SWT.DEFAULT)).expand(avr * 2, 0));
			}
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}

	/**
	 * @generated
	 */
	private static class LabelCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private Label label;

		/**
		 * @generated
		 */
		public LabelCellEditorLocator(Label label) {
			this.label = label;
		}

		/**
		 * @generated
		 */
		public Label getLabel() {
			return label;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getLabel().getTextBounds().getCopy();
			getLabel().translateToAbsolute(rect);
			int avr = FigureUtilities.getFontMetrics(text.getFont())
					.getAverageCharWidth();
			rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
					SWT.DEFAULT)).expand(avr * 2, 0));
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
