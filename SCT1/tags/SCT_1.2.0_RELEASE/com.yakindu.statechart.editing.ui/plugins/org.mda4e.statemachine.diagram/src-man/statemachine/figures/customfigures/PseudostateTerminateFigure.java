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
import org.eclipse.draw2d.Shape;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated NOT
 */
public class PseudostateTerminateFigure extends Shape
{
    /**
     * Constructor <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public PseudostateTerminateFigure()
    {
        super();
        setLineWidth(2);
        
    }

    /**
     * @see org.eclipse.draw2d.Shape#fillShape(org.eclipse.draw2d.Graphics)
     */
    protected void fillShape(Graphics graphics)
    {
        // Do nothing
    }

    /**
     * @see org.eclipse.draw2d.Shape#outlineShape(org.eclipse.draw2d.Graphics)
     */
    protected void outlineShape(Graphics graphics)
    {
        graphics.drawLine(bounds.getTopLeft(), bounds.getBottomRight());
        graphics.drawLine(bounds.getTopRight(), bounds.getBottomLeft());
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