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
package statemachine.figures.customfigures;

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;

import statemachine.figures.draw2d.ComposedLabel;
import statemachine.figures.draw2d.EditableLabel;
import statemachine.figures.draw2d.ILabel;
import statemachine.figures.draw2d.Label;
import statemachine.figures.layouts.RegionLayout;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class CompositeStateFigure extends statemachine.figures.draw2d.ContainerFigure
{
    /**
     * Constructor <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public CompositeStateFigure()
    {
        super();
    }

    /**
     * @see org.topcased.draw2d.figures.ContainerFigure#createContainer()
     */
    protected IFigure createContainer()
    {
        final int ROUND_CORNER = 20;

        RoundedRectangle container = new RoundedRectangle();
        container.setCornerDimensions(new Dimension(ROUND_CORNER, ROUND_CORNER));
        container.setOpaque(true);
        container.setLayoutManager(new RegionLayout(false));
        return container;
    }

    /**
     * @see org.topcased.draw2d.figures.ContainerFigure#createLabel()
     */
    protected ILabel createLabel()
    {
        ILabel label = new EditableLabel();
        ((EditableLabel) label).setAlignment(PositionConstants.LEFT);

        ComposedLabel composedLabel = new ComposedLabel(new Label(), label, null, false);
        composedLabel.setBorder(new CompositeStateHeaderBorder());
        return composedLabel;
    }

    /**
     * A Border at the left, top and right of the label
     */
    public static class CompositeStateHeaderBorder extends AbstractBorder
    {

        private static final Insets INSETS = new Insets(1, 3, 3, 3);

        /**
         * The Constructor
         */
        public CompositeStateHeaderBorder()
        {
            // Do nothing
        }

        /**
         * @see org.eclipse.draw2d.Border#getInsets(org.eclipse.draw2d.IFigure)
         */
        public Insets getInsets(IFigure figure)
        {
            return INSETS;
        }

        /**
         * Draw the 3 borders
         * 
         * @see org.eclipse.draw2d.Border#paint(org.eclipse.draw2d.IFigure,
         *      org.eclipse.draw2d.Graphics, org.eclipse.draw2d.geometry.Insets)
         */
        public void paint(IFigure figure, Graphics graphics, Insets insets)
        {
            graphics.pushState();

            graphics.setLineWidth(2);
            graphics.drawRectangle(getPaintRectangle(figure, insets).getExpanded(-1, -1));

            graphics.popState();
        }
    }

    /**
     * Change the orientation of the children Region Figures
     * 
     * @param isVertical Indicate whether Regions should be arranged vertically
     */
    public void setVerticalLayout(boolean isVertical)
    {
        ((RegionLayout) getContentPane().getLayoutManager()).setVertical(isVertical);
        invalidateTree();
    }

}