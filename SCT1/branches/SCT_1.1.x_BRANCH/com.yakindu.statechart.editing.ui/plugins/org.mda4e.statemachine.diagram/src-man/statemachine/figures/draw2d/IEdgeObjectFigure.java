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

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;

/**
 * An interface defining the structure of an
 * {@link org.topcased.modeler.di.model.EdgeObject} figure.<br>
 * Creation : 24 oct. 2005
 * 
 * @author <a href="mailto:thomas@anyware-tech.com">Thomas Friol</a>
 */
public interface IEdgeObjectFigure extends IFigure
{
    /**
     * Get the owner connexion figure
     * 
     * @return a connection figure
     */
    Connection getConnection();

    /**
     * Test wheter this edge object figure is empty or not
     * 
     * @return a boolean
     */
    boolean isEmpty();

    /**
     * Test wheter this edge object figure is editable or not
     * 
     * @return a boolean
     */
    boolean isEditable();
}
