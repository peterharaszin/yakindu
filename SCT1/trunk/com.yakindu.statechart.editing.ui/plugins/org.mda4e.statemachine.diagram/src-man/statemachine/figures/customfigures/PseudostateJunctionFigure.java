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
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated NOT
 */
public class PseudostateJunctionFigure extends Ellipse
{
    private IMapMode mapMode;

    
    
	public PseudostateJunctionFigure() {
		this(null);
	}

	/**
     * Constructor <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PseudostateJunctionFigure(IMapMode mapMode)
    {

        super();
        
        this.mapMode = mapMode;
        this.setOutline(false);
		this.setLineWidth(0);
		this.setBackgroundColor(org.eclipse.draw2d.ColorConstants.black);
		this.setSize(new Dimension(mapMode.DPtoLP(10), mapMode.DPtoLP(10)));
	
        this.setForegroundColor(org.eclipse.draw2d.ColorConstants.white);
		this.setBorder(new org.eclipse.draw2d.MarginBorder(2,2,2,2));
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