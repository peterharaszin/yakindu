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
import org.eclipse.draw2d.geometry.Rectangle;

import statemachine.figures.draw2d.BorderedLabel;
import statemachine.figures.draw2d.ComposedLabel;
import statemachine.figures.draw2d.EditableLabel;
import statemachine.figures.draw2d.ILabel;
import statemachine.figures.draw2d.Label;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated NOT
 */
public class StateFigure extends BorderedLabel
{
    private static final int ROUND_CORNER = 20;

    /**
     * Constructor <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public StateFigure()
    {
        super();
    }

    /**
     * @see org.topcased.draw2d.figures.BorderedLabel#fillShape(org.eclipse.draw2d.Graphics)
     */
    protected void fillShape(Graphics graphics)
    {
        graphics.fillRoundRectangle(getBounds(), ROUND_CORNER, ROUND_CORNER);
    }

    /**
     * @see org.topcased.draw2d.figures.BorderedLabel#outlineShape(org.eclipse.draw2d.Graphics)
     */
    protected void outlineShape(Graphics graphics)
    {
        Rectangle r = getBounds();

        Rectangle outer = Rectangle.SINGLETON;
        outer.x = r.x + lineWidth / 2;
        outer.y = r.y + lineWidth / 2;
        outer.width = r.width - lineWidth;
        outer.height = r.height - lineWidth;

        graphics.drawRoundRectangle(outer, ROUND_CORNER, ROUND_CORNER);
    }

    /**
     * @see org.topcased.draw2d.figures.BorderedLabel#createLabel()
     */
    protected ILabel createLabel()
    {
        return new ComposedLabel(new Label(), new EditableLabel(), null, false);
    }
}