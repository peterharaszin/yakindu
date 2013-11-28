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
import org.eclipse.draw2d.IFigure;

import statemachine.figures.layouts.RegionLayout;

/**
 * The figure to display a State Machine Diagram. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * 
 * @generated NOT
 */
public class STMDiagramFigure extends UMLDiagramFigure
{
    /**
     * Default constructor
     */
    public STMDiagramFigure()
    {
        super();
    }

    /**
     * @see org.topcased.modeler.uml.figure.UMLDiagramFigure#getPrefixText()
     */
    protected String getPrefixText()
    {
        return "state machine ";
    }

    /**
     * @see org.topcased.draw2d.figures.ContainerFigure#createContainer()
     */
    protected IFigure createContainer()
    {
        Figure container = new Figure();
        container.setLayoutManager(new RegionLayout());
        return container;
    }
}
