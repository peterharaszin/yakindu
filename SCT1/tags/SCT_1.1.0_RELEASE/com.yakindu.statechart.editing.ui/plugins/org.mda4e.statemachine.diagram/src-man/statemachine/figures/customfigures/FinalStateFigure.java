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
public class FinalStateFigure extends Ellipse
{
	protected IMapMode mapMode;
	
    /**
     * Constructor <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public FinalStateFigure()
    {
		super();
		org.eclipse.draw2d.BorderLayout myGenLayoutManager = new org.eclipse.draw2d.BorderLayout();

		this.setLayoutManager(myGenLayoutManager);

		this.setOutline(false);
		this.setLineWidth(0);
		this.setSize(new Dimension(20,20));
		this.setBackgroundColor(org.eclipse.draw2d.ColorConstants.black);
        this.setForegroundColor(org.eclipse.draw2d.ColorConstants.black);
		this.setBorder(new org.eclipse.draw2d.MarginBorder(2,2,2,2));
		// createContents();
	}

	/**
	 * @generated
	 */
	public void createContents() {

		int borderSize = mapMode.DPtoLP(2);
		this.setBorder(new org.eclipse.draw2d.MarginBorder(borderSize,borderSize,borderSize,borderSize));

		org.eclipse.draw2d.Ellipse fig_0 = new org.eclipse.draw2d.Ellipse();

		fig_0.setOutline(false);
		fig_0.setLineWidth(1);
		fig_0.setBackgroundColor(org.eclipse.draw2d.ColorConstants.white

		);
		
		borderSize = mapMode.DPtoLP(3);
		fig_0.setBorder(new org.eclipse.draw2d.MarginBorder(borderSize,borderSize,borderSize,borderSize));

		org.eclipse.draw2d.BorderLayout layouter0 = new org.eclipse.draw2d.BorderLayout();

		fig_0.setLayoutManager(layouter0);

		setFigurewhitecircle(fig_0);

		Object layData0 = org.eclipse.draw2d.BorderLayout.CENTER;

		this.add(fig_0, layData0);
		org.eclipse.draw2d.Ellipse fig_1 = new org.eclipse.draw2d.Ellipse();

		fig_1.setOutline(false);
		fig_1.setLineWidth(mapMode.DPtoLP(1));
		fig_1.setBackgroundColor(org.eclipse.draw2d.ColorConstants.black

		);

		Object layData1 = org.eclipse.draw2d.BorderLayout.CENTER;

		fig_0.add(fig_1, layData1);
	}

	/**
	 * @generated
	 */
	private org.eclipse.draw2d.Ellipse fWhitecircle;

	/**
	 * @generated
	 */
	public org.eclipse.draw2d.Ellipse getFigureWhitecircle() {
		return fWhitecircle;
	}

	/**
	 * @generated
	 */
	private void setFigurewhitecircle(org.eclipse.draw2d.Ellipse fig) {
		fWhitecircle = fig;
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

//	public IMapMode getMapMode() {
//		return mapMode;
//	}

	
	public void setMapMode(IMapMode mapMode) {
		this.mapMode = mapMode;
	}

	

}