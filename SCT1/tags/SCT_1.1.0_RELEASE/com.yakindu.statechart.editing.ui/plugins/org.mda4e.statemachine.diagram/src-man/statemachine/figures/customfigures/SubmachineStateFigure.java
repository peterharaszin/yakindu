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

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;

import statemachine.figures.draw2d.ComposedLabel;
import statemachine.figures.draw2d.EditableLabel;
import statemachine.figures.draw2d.IContainerFigure;
import statemachine.figures.draw2d.ILabel;
import statemachine.figures.draw2d.ILabelFigure;
import statemachine.figures.draw2d.Label;
import statemachine.figures.layouts.BorderAttachedLayout;
import statemachine.figures.layouts.CenterLayout;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated NOT
 */
public class SubmachineStateFigure extends Shape implements IContainerFigure, ILabelFigure
{
    /** The width and height radii applied to each corner. */
    protected Dimension corner = new Dimension(20, 20);

    private ILabel label;

    private IFigure contentPane;

    /**
     * Constructor <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SubmachineStateFigure()
    {
        LayoutManager layout = new StackLayout();
        setLayoutManager(layout);

        label = new ComposedLabel(new Label(), new ComposedLabel(null, new EditableLabel(), new Label(" :"), true),
                new Label(), false);
        IFigure lblContainer = createLabelContainer(label);
        add(lblContainer);

        contentPane = new Figure();
        contentPane.setLayoutManager(new BorderAttachedLayout());
        add(contentPane);

        setOpaque(true);
    }

    /**
     * Initialize the label container at the top of the figure
     * 
     * @param lbl the label
     * @return the label container
     */
    private IFigure createLabelContainer(ILabel lbl)
    {
        Figure lblContainer = new Figure();

        lblContainer.setLayoutManager(new BorderLayout());
        // Add margin
        lblContainer.setBorder(new MarginBorder(15));
        // Add a subcontainer with centerlayout to fit the label size
        Figure subContainer = new Figure();
        subContainer.setLayoutManager(new CenterLayout());
        subContainer.add(lbl);
        lblContainer.add(subContainer, new Integer(PositionConstants.TOP));

        return lblContainer;
    }

    /**
     * @see org.eclipse.draw2d.Shape#outlineShape(org.eclipse.draw2d.Graphics)
     */
    protected void outlineShape(Graphics graphics)
    {
        graphics.drawRoundRectangle(getBounds().getExpanded(-10, -10), corner.width, corner.height);
    }

    /**
     * @see org.eclipse.draw2d.Shape#fillShape(org.eclipse.draw2d.Graphics)
     */
    protected void fillShape(Graphics graphics)
    {
        graphics.fillRoundRectangle(getBounds().getExpanded(-10, -10), corner.width, corner.height);
    }

    /**
     * Return the contentPane figure
     * 
     * @return the Container Figure
     */
    public IFigure getContentPane()
    {
        return contentPane;
    }

    /**
     * @see org.topcased.draw2d.figures.ILabelFigure#getLabel()
     */
    public ILabel getLabel()
    {
        return label;
    }

}