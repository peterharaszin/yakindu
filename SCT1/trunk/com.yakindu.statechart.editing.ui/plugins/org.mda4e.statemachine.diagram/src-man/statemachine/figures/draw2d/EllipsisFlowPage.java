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
package statemachine.figures.draw2d;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.text.FlowPage;

/**
 * This FlowPage displays an ellipsis text (...) when the inner text vertical overflows
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class EllipsisFlowPage extends FlowPage
{
    
    private static final String ELLIPSIS = "...";
    /**
     * @see org.eclipse.draw2d.text.BlockFlow#paintBorder(org.eclipse.draw2d.Graphics)
     */
    public void paintBorder(Graphics graphics)
    {
        super.paintBorder(graphics);
        
        int requiredHeight = getBlockBox().getHeight();
        int availableHeight = getBounds().height;
        if (requiredHeight > availableHeight)
        {
            Dimension ellipsisDim = FigureUtilities.getStringExtents(ELLIPSIS, graphics.getFont());
            Rectangle bottomRectangle = new Rectangle(getBounds().x, getBounds().y + getBounds().height - ellipsisDim.height, getBounds().width, ellipsisDim.height);
            graphics.fillRectangle(bottomRectangle);
            graphics.drawText(ELLIPSIS, bottomRectangle.getTopLeft());
        }
    }
}
