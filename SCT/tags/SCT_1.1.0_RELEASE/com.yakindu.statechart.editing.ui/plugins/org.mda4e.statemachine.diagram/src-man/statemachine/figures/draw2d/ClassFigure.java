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

import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.ToolbarLayout;

/**
 * A Figure that will represent a Class. The header is an EditableLabel, the
 * contentPane is a vertical ToolbarLayout
 * 
 * Created 21 June 2005
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ClassFigure extends Figure implements IContainerFigure, ILabelFigure
{
    private ILabel header;

    private IFigure contentPane;

    /**
     * Constructor
     */
    public ClassFigure()
    {
        drawFigure();
    }

    /**
     * Initialize ToolbarLayout and its children Figures Suclasses may overrides
     * this to provides their own background figure.
     */
    protected void drawFigure()
    {
        ToolbarLayout layout = new ToolbarLayout();
        setLayoutManager(layout);
        setBorder(new CompoundBorder(new LineBorder(), new MarginBorder(1)));
        setOpaque(true);

        header = createLabel();
        add(header);

        contentPane = new Figure();
        contentPane.setLayoutManager(new ToolbarLayout());
        add(contentPane);
    }

    /**
     * Create the main label of the class figure
     * @return the main label
     */
    protected ILabel createLabel()
    {
        EditableLabel lbl = new EditableLabel();
       // lbl.setLabelAlignment(PositionConstants.LEFT);
        return lbl;
    }

    /**
     * Return the Header figure
     * 
     * @return returns the label used to edit the name
     * @deprecated use getLabel() instead
     */
    public IFigure getHeader()
    {
        return header;
    }

    /**
     * @see org.topcased.draw2d.figures.ILabelFigure#getLabel()
     */
    public ILabel getLabel()
    {
        return header;
    }

    /**
     * @see org.topcased.draw2d.figures.IContainerFigure#getContentPane()
     */
    public IFigure getContentPane()
    {
        return contentPane;
    }

    /**
     * Set the Header figure
     * 
     * @param newHeader the new Header Figure
     * @deprecated
     */
    public void setHeader(IFigure newHeader)
    {
        header = (ILabel) newHeader;
    }

    /**
     * Set the label figure
     * 
     * @param newLabel the new label Figure
     */
    protected void setLabel(ILabel newLabel)
    {
        header = newLabel;
    }

    /**
     * Set the contentPane figure
     * 
     * @param newContentPane the new contentPane Figure
     */
    protected void setContentPane(IFigure newContentPane)
    {
        contentPane = newContentPane;
    }

}
