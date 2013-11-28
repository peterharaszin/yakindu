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

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.swt.SWT;

import statemachine.figures.draw2d.IContainerFigure;
import statemachine.figures.layouts.BorderAttachedLayout;
import statemachine.figures.layouts.RegionLayout;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated NOT
 */
public class RegionFigure extends Figure implements IContainerFigure
{
    /**
     * Constructor <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public RegionFigure()
    {
        setLayoutManager(new BorderAttachedLayout());
    }

    /**
     * @see org.eclipse.draw2d.Figure#paintBorder(org.eclipse.draw2d.Graphics)
     */
    protected void paintBorder(Graphics graphics)
    {
        graphics.pushState();

        // The Region separation is drawn only when at least one Region is
        // present and that it is not the first one
        if (getParent().getChildren().size() > 1 && !this.equals(getParent().getChildren().get(0)))
        {
            graphics.setLineStyle(SWT.LINE_DASH);

            // Draw the separation depending on the orientation of the
            // RegionLayout
            if (((RegionLayout) getParent().getLayoutManager()).isHorizontal())
            {
                graphics.drawLine(bounds.getTopLeft(), bounds.getBottomLeft());
            }
            else
            {
                graphics.drawLine(bounds.getTopLeft(), bounds.getTopRight());
            }
        }

        graphics.popState();
    }

    /**
     * Return the contentPane figure
     * 
     * @return the Container Figure
     */
    public IFigure getContentPane()
    {
        return this;
    }

}