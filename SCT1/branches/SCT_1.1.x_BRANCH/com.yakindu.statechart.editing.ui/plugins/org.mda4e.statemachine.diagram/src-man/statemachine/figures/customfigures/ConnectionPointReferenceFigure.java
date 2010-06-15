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

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;

import statemachine.figures.draw2d.PortFigure;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated NOT
 */
public class ConnectionPointReferenceFigure extends PortFigure
{
    private boolean isEntryPoint;

    private boolean isExitPoint;

    /**
     * Constructor <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param isEntryPoint define whether the ConnectionPointReference is
     *        associated with at least one EntryPoint.
     * @param isExitPoint define whether the ConnectionPointReference is
     *        associated with at least one ExitPoint.
     * 
     * @generated NOT
     */
    public ConnectionPointReferenceFigure(boolean isEntryPoint, boolean isExitPoint)
    {
        super();

        this.isEntryPoint = isEntryPoint;
        this.isExitPoint = isExitPoint;
    }

    /**
     * @see org.eclipse.draw2d.IFigure#getPreferredSize(int, int)
     */
    public Dimension getPreferredSize(int wHint, int hHint)
    {
        return new Dimension(20, 20);
    }

    /**
     * @see org.topcased.draw2d.figures.PortFigure#outlineShape(org.eclipse.draw2d.Graphics)
     */
    protected void outlineShape(Graphics graphics)
    {
        if (isEntryPoint || isExitPoint)
        {
            graphics.drawOval(getBounds());

            if (isExitPoint)
            {

                // Calculate the intersection coordinates.
                int x = (int) (bounds.width / (2 * Math.sqrt(2)));
                int y = (int) (bounds.height / (2 * Math.sqrt(2)));

                // Draw the cross
                graphics.drawLine(bounds.getCenter().translate(x, -y), bounds.getCenter().translate(-x, y));
                graphics.drawLine(bounds.getCenter().translate(-x, -y), bounds.getCenter().translate(x, y));
            }
        }
        else
        {
            super.outlineShape(graphics);
        }
    }

    /**
     * @see org.topcased.draw2d.figures.PortFigure#fillShape(org.eclipse.draw2d.Graphics)
     */
    protected void fillShape(Graphics graphics)
    {
        if (isEntryPoint || isExitPoint)
        {
            graphics.fillOval(getBounds());
        }
        else
        {
            super.fillShape(graphics);
        }
    }

    /**
     * @param isEntryPoint Specify whether the shape should draw as an
     *        EntryPoint.
     */
    public void setEntryPoint(boolean isEntryPoint)
    {
        this.isEntryPoint = isEntryPoint;
    }

    /**
     * @param isExitPoint Specify whether the shape should drawn as an
     *        ExitPoint.
     */
    public void setExitPoint(boolean isExitPoint)
    {
        this.isExitPoint = isExitPoint;
    }
}