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
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated NOT
 */
public class PseudostateChoiceFigure extends Shape
{
    private IMapMode mapMode;


	/**
     * Constructor <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public PseudostateChoiceFigure()
    {
        this(null);
    }

    
    /**
     * Constructor <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public PseudostateChoiceFigure(IMapMode mapMode)
    {
        super();
        this.mapMode = mapMode;
        this.setBackgroundColor(org.eclipse.draw2d.ColorConstants.white);
        this.setSize(new Dimension(mapMode.DPtoLP(15),mapMode.DPtoLP(15)));
        this.setForegroundColor(org.eclipse.draw2d.ColorConstants.black);
        setLineWidth(2);
    }

    /**
     * @see org.eclipse.draw2d.Shape#fillShape(org.eclipse.draw2d.Graphics)
     */
    protected void fillShape(Graphics graphics)
    {
        PointList pl = new PointList();
        pl.addPoint(getBounds().getTop());
        pl.addPoint(getBounds().getRight());
        pl.addPoint(getBounds().getBottom());
        pl.addPoint(getBounds().getLeft());

        graphics.fillPolygon(pl);
    }

    /**
     * @see org.eclipse.draw2d.Shape#outlineShape(org.eclipse.draw2d.Graphics)
     */
    protected void outlineShape(Graphics graphics)
    {
        Rectangle f = Rectangle.SINGLETON;
        Rectangle r = getBounds();
        f.x = r.x + lineWidth / 2;
        f.y = r.y + lineWidth / 2;
        f.width = r.width - lineWidth;
        f.height = r.height - lineWidth;

        PointList pl = new PointList();
        pl.addPoint(f.getTop());
        pl.addPoint(f.getRight());
        pl.addPoint(f.getBottom());
        pl.addPoint(f.getLeft());

        graphics.drawPolygon(pl);
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