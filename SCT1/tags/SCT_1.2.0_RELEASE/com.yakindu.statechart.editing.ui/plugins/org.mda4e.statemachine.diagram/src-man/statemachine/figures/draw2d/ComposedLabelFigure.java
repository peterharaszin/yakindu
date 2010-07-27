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


/**
 * This figure is an editable label which can be edited
 */
public class ComposedLabelFigure extends ComposedLabel implements ILabelFigure
{    
    /**
     * Constructor for a composed label whith several parts. Prefix and suffix
     * can be null
     * 
     * @param prefixLbl prefix part. If null, no prefix is added to the figure
     * @param mainFig main part
     * @param suffixLbl suffix part. If null, no suffix is added to the figure
     * @param isHorizontal orientation. If true, it's horizontal
     */
    public ComposedLabelFigure(ILabel prefixLbl, ILabel mainFig, ILabel suffixLbl, boolean isHorizontal)
    {
        super(prefixLbl, mainFig, suffixLbl, isHorizontal);
    }
    
    /**
     * @see org.topcased.draw2d.figures.ILabelFigure#getLabel()
     */
    public ILabel getLabel()
    {
        return this;
    }
}
