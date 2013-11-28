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

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.ToolbarLayout;

/**
 * This figure creates a bodyFigure (a rectangle figure by default) and a label
 * associated with the body figure. The position of the label can be defined
 * (TOP, LEFT, BOTTOM or RIGHT) and the body figure customized overriding the
 * <code>createBodyFigure()</code> method.
 * 
 * Creation 20 juil. 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class GraphicWithLabelFigure extends Figure implements ILabelFigure
{
    private ILabel label;

    private IFigure bodyFigure;

    /**
     * Constructor - Create the label at the bottom of the body figure.
     */
    public GraphicWithLabelFigure()
    {
        this(PositionConstants.BOTTOM);
    }

    /**
     * Constructor
     * 
     * @param labelPosition the label position (from {@link PositionConstants} :
     *        PositionConstants.TOP, PositionConstants.BOTTOM,
     *        PositionConstants.LEFT or PositionConstants.RIGHT)
     */
    public GraphicWithLabelFigure(int labelPosition)
    {
        createContents(labelPosition);
    }

    /**
     * Creates the contents of the figure : by defauft, it creates a layout
     * manager, a label and a body
     * 
     * @param labelPosition the label position (from {@link PositionConstants})
     */
    protected void createContents(int labelPosition)
    {
        ToolbarLayout layout = new ToolbarLayout();
        layout.setStretchMinorAxis(false);
        layout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

        // Create the label and the body Figures
        bodyFigure = createBodyFigure();
        label = createLabel();

        switch (labelPosition)
        {
            case PositionConstants.LEFT:
                layout.setVertical(false);
                add(label);
                add(bodyFigure);
                break;
            case PositionConstants.TOP:
                add(label);
                add(bodyFigure);
                break;
            case PositionConstants.RIGHT:
                layout.setVertical(false);
                add(bodyFigure);
                add(label);
                break;
            case PositionConstants.BOTTOM:
            default:
                add(bodyFigure);
                add(label);
                break;
        }

        setLayoutManager(layout);
    }

    /**
     * Creates the label of the figure.<br>
     * <b>Subclasses can override this method to customize the appearance of the
     * label (for example you can return a {@link ComposedLabel} instead)</b>
     * 
     * @return the label of the figure
     */
    protected ILabel createLabel()
    {
        EditableLabel lbl = new EditableLabel();
       // lbl.setLabelAlignment(PositionConstants.LEFT);
        lbl.setBorder(new MarginBorder(5));
        return lbl;
    }

    /**
     * Create the figure displayed beside the label. It is a RectangleFigure by
     * default.<br>
     * <b>Subclasses can override this method to customize the appearance of the
     * body</b>
     * 
     * @return the figure
     */
    protected IFigure createBodyFigure()
    {
        return new RectangleFigure();
    }

    /**
     * @see org.topcased.draw2d.figures.ILabelFigure#getLabel()
     */
    public ILabel getLabel()
    {
        return label;
    }
    
    /**
     * Return the body figure.
     * 
     * @return IFigure the body figure
     */
    public IFigure getBodyFigure()
    {
        return bodyFigure;
    }
}
