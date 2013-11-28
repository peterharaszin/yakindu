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

import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;

import statemachine.figures.draw2d.EdgeObjectOffsetEditableLabel;
import statemachine.figures.draw2d.EdgeObjectOffsetLocator;
import statemachine.figures.draw2d.IEdgeObjectFigure;
import statemachine.figures.draw2d.IEdgeObjectOffsetFigure;
import statemachine.figures.draw2d.IGraphEdgeFigure;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class TransitionFigure extends PolylineConnectionEx implements IGraphEdgeFigure, HandleBounds
{

    private IEdgeObjectFigure nameEdgeObject;

    private Locator nameLocator;

    /**
     * The constructor <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public TransitionFigure()
    {
        super();

        nameEdgeObject = new EdgeObjectOffsetEditableLabel(this);
        nameLocator = new EdgeObjectOffsetLocator((IEdgeObjectOffsetFigure) nameEdgeObject);
        add(nameEdgeObject, nameLocator);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the object figure
     * @generated
     */
    public IEdgeObjectFigure getNameEdgeObjectFigure()
    {
        return nameEdgeObject;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.topcased.modeler.figures.IGraphEdgeFigure#getLocator(org.topcased.modeler.figures.IEdgeObjectFigure)
     * @generated
     */
    public Locator getLocator(IEdgeObjectFigure edgeObjectfigure)
    {
        if (edgeObjectfigure == nameEdgeObject)
        {
            return nameLocator;
        }

        return null;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.gef.handles.HandleBounds#getHandleBounds()
     * @generated
     */
    public Rectangle getHandleBounds()
    {
        return getPoints().getBounds();
    }
}