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

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated NOT
 */
public class PseudostateShallowHistoryFigure extends Ellipse
{
    /**
     * Constructor <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PseudostateShallowHistoryFigure()
    {

        super();
        this.setSize(new Dimension(20,20));
        this.setForegroundColor(org.eclipse.draw2d.ColorConstants.black);
        this.setBackgroundColor(org.eclipse.draw2d.ColorConstants.white);
    }

    /**
     * @see org.eclipse.draw2d.Ellipse#outlineShape(org.eclipse.draw2d.Graphics)
     */
    protected void outlineShape(Graphics graphics)
    {
        super.outlineShape(graphics);

        // draw the 'H' letter
        graphics.drawLine(
                bounds.getCenter().getTranslated((int) (-bounds.width * 0.15), (int) (-bounds.height * 0.25)),
                bounds.getCenter().getTranslated((int) (-bounds.width * 0.15), (int) (bounds.height * 0.25)));
        graphics.drawLine(bounds.getCenter().getTranslated((int) (bounds.width * 0.15), (int) (-bounds.height * 0.25)),
                bounds.getCenter().getTranslated((int) (bounds.width * 0.15), (int) (bounds.height * 0.25)));
        graphics.drawLine(bounds.getCenter().getTranslated((int) (-bounds.width * 0.15), 0),
                bounds.getCenter().getTranslated((int) (bounds.width * 0.15), 0));
    }
    
	/**
	 * @generated
	 */
	private boolean myUseLocalCoordinates = false;

	/**
	 * @generated
	 */
	protected boolean useLocalCoordinates() {
		return myUseLocalCoordinates;
	}

	/**
	 * @generated
	 */
	protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
		myUseLocalCoordinates = useLocalCoordinates;
	}
}