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

import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;

/**
 * A connection locator to locate
 * {@link org.topcased.modeler.figures.IEdgeObjectOffsetFigure} relative to
 * their edge figure. This default implementation locates figures relative to
 * the middle of the connection.<br>
 * Creation : 25 oct. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public class EdgeObjectOffsetLocator extends ConnectionLocator
{
    /* The edge object figure */
    private IEdgeObjectOffsetFigure figure;

    /**
     * @param connection
     */
    public EdgeObjectOffsetLocator(IEdgeObjectOffsetFigure edgeObjectFigure)
    {
        super(edgeObjectFigure.getConnection());
        figure = edgeObjectFigure;
    }

    public EdgeObjectOffsetLocator(IEdgeObjectOffsetFigure edgeObjectFigure, int alignement)
    {
        this(edgeObjectFigure);
        setAlignment(alignement);
    }

    protected Point getReferencePoint()
    {
        Point connectionPoint = super.getReferencePoint();
        Dimension offset = figure.getOffset().getCopy();
        getConnection().translateToAbsolute(offset);
        connectionPoint.translate(offset);
        return connectionPoint;
    }
}
