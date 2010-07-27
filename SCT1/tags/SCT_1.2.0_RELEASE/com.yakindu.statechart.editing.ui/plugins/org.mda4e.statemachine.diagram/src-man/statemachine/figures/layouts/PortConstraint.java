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
package statemachine.figures.layouts;

import org.eclipse.draw2d.geometry.Rectangle;

/**
 * The constraint of a Figure contained by a BorderAttachedLayout. The
 * constraint consist of the bounds of the figure and an attachment to the
 * border of the container figure.
 * 
 * Creation : 14 oct. 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class PortConstraint
{
    private Rectangle rectConstraints;

    private int attachment;

    /**
     * The Constructor
     * 
     * @param rect
     * @param attach
     */
    public PortConstraint(Rectangle rect, int attach)
    {
        rectConstraints = rect;
        attachment = attach;
    }

    /**
     * @return Returns the attachment.
     */
    public int getAttachment()
    {
        return attachment;
    }

    /**
     * @param attach The attachment to set.
     */
    public void setAttachment(int attach)
    {
        this.attachment = attach;
    }

    /**
     * @return Returns the rectConstraints.
     */
    public Rectangle getRectConstraints()
    {
        return rectConstraints;
    }

    /**
     * @param constraints The rectConstraints to set.
     */
    public void setRectConstraints(Rectangle constraints)
    {
        this.rectConstraints = constraints;
    }

}
