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

import java.beans.PropertyChangeListener;
import java.util.List;

import org.eclipse.draw2d.AncestorListener;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.CoordinateListener;
import org.eclipse.draw2d.EventDispatcher;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.FocusEvent;
import org.eclipse.draw2d.FocusListener;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.KeyEvent;
import org.eclipse.draw2d.KeyListener;
import org.eclipse.draw2d.LayoutListener;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.UpdateManager;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Translatable;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

/**
 * This is the Label class of eclipse draw2d with the generic
 * representation of the label (ILabel)
 */
public class Label extends WrappingLabel implements ILabel {

	/**
	 * The default contructor
	 */
	public Label() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param s the text of the label
	 */
	public Label(String s) {
		super(s);
	}
	
	/**
	 * Constructor
	 * 
	 * @param i the image of the label
	 */
    public Label(Image i)
    {
        super(i);
    }

	/**
	 * Constructor
	 * 
	 * @param s the text of the label
	 * @param i the image of the label
	 */
    public Label(String s, Image i)
    {
        super(s, i);
    }

	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setText(String s) {
		// TODO Auto-generated method stub
		
	}


	public void add(IFigure figure, Object constraint, int index) {
		// TODO Auto-generated method stub
		
	}

	public void addAncestorListener(AncestorListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void addCoordinateListener(CoordinateListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void addFigureListener(FigureListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void addFocusListener(FocusListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void addKeyListener(KeyListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void addLayoutListener(LayoutListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void addMouseListener(MouseListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void addMouseMotionListener(MouseMotionListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void addNotify() {
		// TODO Auto-generated method stub
		
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void addPropertyChangeListener(String property, PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	

	public boolean containsPoint(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	public void erase() {
		// TODO Auto-generated method stub
		
	}


	public IFigure findFigureAt(int x, int y, TreeSearch search) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public IFigure findMouseEventTargetAt(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	public Color getBackgroundColor() {
		// TODO Auto-generated method stub
		return null;
	}

	public Border getBorder() {
		// TODO Auto-generated method stub
		return null;
	}

	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EditPart> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	public Rectangle getClientArea(Rectangle rect) {
		// TODO Auto-generated method stub
		return null;
	}

	public Cursor getCursor() {
		// TODO Auto-generated method stub
		return null;
	}

	public Font getFont() {
		// TODO Auto-generated method stub
		return null;
	}

	public Color getForegroundColor() {
		// TODO Auto-generated method stub
		return null;
	}

	public Insets getInsets() {
		// TODO Auto-generated method stub
		return null;
	}

	public LayoutManager getLayoutManager() {
		// TODO Auto-generated method stub
		return null;
	}

	public Color getLocalBackgroundColor() {
		// TODO Auto-generated method stub
		return null;
	}

	public Color getLocalForegroundColor() {
		// TODO Auto-generated method stub
		return null;
	}

	public Dimension getMaximumSize() {
		// TODO Auto-generated method stub
		return null;
	}


	public Dimension getMinimumSize(int wHint, int hHint) {
		// TODO Auto-generated method stub
		return null;
	}

	

	public Dimension getPreferredSize(int wHint, int hHint) {
		// TODO Auto-generated method stub
		return null;
	}

	

	public IFigure getToolTip() {
		// TODO Auto-generated method stub
		return null;
	}

	public UpdateManager getUpdateManager() {
		// TODO Auto-generated method stub
		return null;
	}

	public void handleFocusGained(FocusEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void handleFocusLost(FocusEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void handleKeyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void handleKeyReleased(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void handleMouseDoubleClicked(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void handleMouseDragged(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void handleMouseEntered(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void handleMouseExited(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void handleMouseHover(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void handleMouseMoved(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void handleMousePressed(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void handleMouseReleased(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	public boolean hasFocus() {
		// TODO Auto-generated method stub
		return false;
	}

	public EventDispatcher internalGetEventDispatcher() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean intersects(Rectangle rect) {
		// TODO Auto-generated method stub
		return false;
	}

	public void invalidate() {
		// TODO Auto-generated method stub
		
	}

	public void invalidateTree() {
		// TODO Auto-generated method stub
		
	}

	public boolean isCoordinateSystem() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isFocusTraversable() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isMirrored() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isOpaque() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isRequestFocusEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isShowing() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	public void paint(Graphics graphics) {
		// TODO Auto-generated method stub
		
	}

	public void remove(IFigure figure) {
		// TODO Auto-generated method stub
		
	}

	public void removeAncestorListener(AncestorListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void removeCoordinateListener(CoordinateListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void removeFigureListener(FigureListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void removeFocusListener(FocusListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void removeKeyListener(KeyListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void removeLayoutListener(LayoutListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void removeMouseListener(MouseListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void removeMouseMotionListener(MouseMotionListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void removeNotify() {
		// TODO Auto-generated method stub
		
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void removePropertyChangeListener(String property, PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void repaint() {
		// TODO Auto-generated method stub
		
	}



	public void repaint(int x, int y, int w, int h) {
		// TODO Auto-generated method stub
		
	}

	

	public void revalidate() {
		// TODO Auto-generated method stub
		
	}

	public void setBackgroundColor(Color c) {
		// TODO Auto-generated method stub
		
	}

	public void setBorder(Border b) {
		// TODO Auto-generated method stub
		
	}

	public void setBounds(Rectangle rect) {
		// TODO Auto-generated method stub
		
	}

	public void setConstraint(IFigure child, Object constraint) {
		// TODO Auto-generated method stub
		
	}

	public void setCursor(Cursor cursor) {
		// TODO Auto-generated method stub
		
	}

	public void setEnabled(boolean value) {
		// TODO Auto-generated method stub
		
	}

	public void setFocusTraversable(boolean value) {
		// TODO Auto-generated method stub
		
	}

	public void setFont(Font f) {
		// TODO Auto-generated method stub
		
	}

	public void setForegroundColor(Color c) {
		// TODO Auto-generated method stub
		
	}

	public void setLayoutManager(LayoutManager lm) {
		// TODO Auto-generated method stub
		
	}

	public void setLocation(Point p) {
		// TODO Auto-generated method stub
		
	}

	public void setMaximumSize(Dimension size) {
		// TODO Auto-generated method stub
		
	}

	public void setMinimumSize(Dimension size) {
		// TODO Auto-generated method stub
		
	}

	public void setOpaque(boolean isOpaque) {
		// TODO Auto-generated method stub
		
	}

	public void setParent(IFigure parent) {
		// TODO Auto-generated method stub
		
	}

	public void setPreferredSize(Dimension size) {
		// TODO Auto-generated method stub
		
	}

	public void setRequestFocusEnabled(boolean requestFocusEnabled) {
		// TODO Auto-generated method stub
		
	}



	public void setSize(int w, int h) {
		// TODO Auto-generated method stub
		
	}

	public void setToolTip(IFigure figure) {
		// TODO Auto-generated method stub
		
	}

	public void setVisible(boolean visible) {
		// TODO Auto-generated method stub
		
	}



	public void translateFromParent(Translatable t) {
		// TODO Auto-generated method stub
		
	}



	public void translateToParent(Translatable t) {
		// TODO Auto-generated method stub
		
	}

	

	public void validate() {
		// TODO Auto-generated method stub
		
	}

}
