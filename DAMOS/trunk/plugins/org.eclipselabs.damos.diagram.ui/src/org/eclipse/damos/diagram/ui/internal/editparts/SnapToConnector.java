/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.diagram.ui.internal.editparts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.damos.diagram.ui.editparts.ComponentEditPart;
import org.eclipse.damos.diagram.ui.internal.figures.FigureUtil;
import org.eclipse.damos.diagram.ui.internal.figures.IConnectorFigure;
import org.eclipse.damos.diagram.ui.internal.geometry.PointListEx;
import org.eclipse.damos.dml.InputConnector;
import org.eclipse.damos.dml.OutputConnector;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;

/**
 * @author Andreas Unger
 *
 */
public class SnapToConnector extends SnapToHelper {
	
	public static final String KEY_GUIDE_LOCATIONS = "SnapToConnector.GuideLocations";

	private static final int THRESHOLD = 100;
	
	private GraphicalEditPart container;
	
	private List<Point> inputWestLocations;
	private List<Point> inputEastLocations;
	private List<Point> inputNorthLocations;
	private List<Point> inputSouthLocations;
	private List<Point> outputWestLocations;
	private List<Point> outputEastLocations;
	private List<Point> outputNorthLocations;
	private List<Point> outputSouthLocations;

	/**
	 * 
	 */
	public SnapToConnector(GraphicalEditPart container) {
		this.container = container;
	}
	
	protected List<IConnectorEditPart> generateSnapPartsList(IGraphicalEditPart exclusion) {
		List<IConnectorEditPart> children = new ArrayList<IConnectorEditPart>();
		addChildrenToSnapPartsList(exclusion, container.getRoot().getContents(), children);
		return children;
	}
	
	private void addChildrenToSnapPartsList(IGraphicalEditPart exclusion, EditPart container, List<IConnectorEditPart> parts) {
		for (Object child : container.getChildren()) {
			if (child != exclusion) {
				if (child instanceof IConnectorEditPart) {
					IConnectorEditPart connectorEditPart = (IConnectorEditPart) child;
					if (connectorEditPart.getConnectorFigure().isShowing()) {
						parts.add(connectorEditPart);
					}
				} else {
					addChildrenToSnapPartsList(exclusion, (EditPart) child, parts);
				}
			}
		}
	}

	protected void populateCache(List<IConnectorEditPart> parts) {
		inputWestLocations = new ArrayList<Point>();
		inputEastLocations = new ArrayList<Point>();
		inputNorthLocations = new ArrayList<Point>();
		inputSouthLocations = new ArrayList<Point>();
		outputWestLocations = new ArrayList<Point>();
		outputEastLocations = new ArrayList<Point>();
		outputNorthLocations = new ArrayList<Point>();
		outputSouthLocations = new ArrayList<Point>();

		for (IConnectorEditPart part : parts) {
			IConnectorFigure connectorFigure = part.getConnectorFigure();
			Point terminalLocation = connectorFigure.getTerminalLocation();
			if (terminalLocation != null) {
				terminalLocation = new PrecisionPoint(terminalLocation);

				makeAbsolute(connectorFigure, terminalLocation);
				makeRelative(container.getContentPane(), terminalLocation);
				
				populateTerminalLocation(part, terminalLocation);
			}
		}
	}

	/**
	 * @param part
	 * @param connectorFigure
	 * @param terminalLocation
	 */
	private void populateTerminalLocation(IConnectorEditPart part, Point terminalLocation) {
		IConnectorFigure connectorFigure = part.getConnectorFigure();
		if (part.getConnector() instanceof InputConnector) {
			switch (FigureUtil.rotationToOrientation(connectorFigure.getRotation())) {
			case NORTH:
				inputNorthLocations.add(terminalLocation);
				break;
			case SOUTH:
				inputSouthLocations.add(terminalLocation);
				break;
			case WEST:
				inputWestLocations.add(terminalLocation);
				break;
			case EAST:
				inputEastLocations.add(terminalLocation);
				break;
			}
		} else if (part.getConnector() instanceof OutputConnector) {
			switch (FigureUtil.rotationToOrientation(connectorFigure.getRotation())) {
			case NORTH:
				outputNorthLocations.add(terminalLocation);
				break;
			case SOUTH:
				outputSouthLocations.add(terminalLocation);
				break;
			case WEST:
				outputWestLocations.add(terminalLocation);
				break;
			case EAST:
				outputEastLocations.add(terminalLocation);
				break;
			}
		}
	}
	
	/**
	 * Returns the rectangular contribution for the given editpart.  This is the rectangle
	 * with which snapping is performed.
	 * @param part the child
	 * @return the rectangular guide for that part
	 */
	protected Rectangle getFigureBounds(GraphicalEditPart part) {
		IFigure fig = part.getFigure();
		if (fig instanceof HandleBounds) {
			return ((HandleBounds) fig).getHandleBounds();
		}
		return fig.getBounds();
	}
	
	protected int calculateCorrection(PrecisionRectangle correction, ComponentEditPart target, PrecisionRectangle baseRect, Map<String, Object> extendedData) {
		List<PointList> horizontalGuides = new ArrayList<PointList>();
		List<PointList> verticalGuides = new ArrayList<PointList>();
		
		int correctX = Integer.MAX_VALUE;
		int correctY = Integer.MAX_VALUE;

		Point delta = new Point(baseRect.x - getFigureBounds(target).x, baseRect.y - getFigureBounds(target).y);
		
		for (Object o : target.getChildren()) {
			if (o instanceof IConnectorEditPart) {
				IConnectorEditPart connectorEditPart = (IConnectorEditPart) o;
				IConnectorFigure connectorFigure = (IConnectorFigure) connectorEditPart.getFigure();
				
				Point terminalLocation = connectorFigure.getTerminalLocation();
				if (terminalLocation == null) {
					continue;
				}
				
				if (connectorEditPart.getConnector() instanceof InputConnector) {
					switch (FigureUtil.rotationToOrientation(connectorFigure.getRotation())) {
					case NORTH:
						correctX = getNorthCorrect(correctX, terminalLocation, delta, outputSouthLocations, verticalGuides);
						break;
					case SOUTH:
						correctX = getSouthCorrect(correctX, terminalLocation, delta, outputNorthLocations, verticalGuides);
						break;
					case WEST:
						correctY = getWestCorrect(correctY, terminalLocation, delta, outputEastLocations, horizontalGuides);
						break;
					case EAST:
						correctY = getEastCorrect(correctY, terminalLocation, delta, outputWestLocations, horizontalGuides);
						break;
					}
				} else if (connectorEditPart.getConnector() instanceof OutputConnector) {
					switch (FigureUtil.rotationToOrientation(connectorFigure.getRotation())) {
					case NORTH:
						correctX = getNorthCorrect(correctX, terminalLocation, delta, inputSouthLocations, verticalGuides);
						break;
					case SOUTH:
						correctX = getSouthCorrect(correctX, terminalLocation, delta, inputNorthLocations, verticalGuides);
						break;
					case WEST:
						correctY = getWestCorrect(correctY, terminalLocation, delta, inputEastLocations, horizontalGuides);
						break;
					case EAST:
						correctY = getEastCorrect(correctY, terminalLocation, delta, inputWestLocations, horizontalGuides);
						break;
					}
				}
			}
		}
		
		int snapOrientation = 0;

		if (Math.abs(correctX) < THRESHOLD) {
			correction.setPreciseX(correction.preciseX() + correctX);
			snapOrientation |= HORIZONTAL;
		}
		if (Math.abs(correctY) < THRESHOLD) {
			correction.setPreciseY(correction.preciseY() + correctY);
			snapOrientation |= VERTICAL;
		}
		
		List<PointList> guides = new ArrayList<PointList>(horizontalGuides.size() + verticalGuides.size());
		guides.addAll(horizontalGuides);
		guides.addAll(verticalGuides);
		extendedData.put(KEY_GUIDE_LOCATIONS, guides);
		
		return snapOrientation;
	}
	 
	protected int getWestCorrect(int correct, Point terminalLocation, Point delta, List<Point> eastLocations, List<PointList> guides) {
		Point newTerminalLocation = terminalLocation.getTranslated(delta);
		Point closest = null;
		for (Point p : eastLocations) {
			if (p.x <= newTerminalLocation.x) {
				if (closest == null) {
					closest = p;
				} else {
					int currentMag = Math.abs(p.y - newTerminalLocation.y);
					int closestMag = Math.abs(closest.y - newTerminalLocation.y);
					if (currentMag < closestMag || currentMag == closestMag && p.x > closest.x) {
						closest = p;
					}
				}
			}
		}
		if (closest != null) {
			int newCorrect = closest.y - newTerminalLocation.y;
			int newMag = Math.abs(newCorrect);
			if (newMag < THRESHOLD) {
				if (newMag < Math.abs(correct)) {
					correct = newCorrect;
					guides.clear();
				}
				if (newCorrect == correct) {
					guides.add(new PointListEx(terminalLocation.x, closest.y, closest.x, closest.y));
				}
			}
		}
		return correct;
	}

	protected int getEastCorrect(int correct, Point terminalLocation, Point delta, List<Point> westLocations, List<PointList> guides) {
		Point newTerminalLocation = terminalLocation.getTranslated(delta);
		Point closest = null;
		for (Point p : westLocations) {
			if (p.x >= newTerminalLocation.x) {
				if (closest == null) {
					closest = p;
				} else {
					int currentMag = Math.abs(p.y - newTerminalLocation.y);
					int closestMag = Math.abs(closest.y - newTerminalLocation.y);
					if (currentMag < closestMag || currentMag == closestMag && p.x < closest.x) {
						closest = p;
					}
				}
			}
		}
		if (closest != null) {
			int newCorrect = closest.y - newTerminalLocation.y;
			int newMag = Math.abs(newCorrect);
			if (newMag < THRESHOLD) {
				if (newMag < Math.abs(correct)) {
					correct = newCorrect;
					guides.clear();
				}
				if (newCorrect == correct) {
					guides.add(new PointListEx(terminalLocation.x, closest.y, closest.x, closest.y));
				}
			}
		}
		return correct;
	}

	protected int getNorthCorrect(int correct, Point terminalLocation, Point delta, List<Point> southLocations, List<PointList> guides) {
		Point newTerminalLocation = terminalLocation.getTranslated(delta);
		Point closest = null;
		for (Point p : southLocations) {
			if (p.y <= newTerminalLocation.y) {
				if (closest == null) {
					closest = p;
				} else {
					int currentMag = Math.abs(p.x - newTerminalLocation.x);
					int closestMag = Math.abs(closest.x - newTerminalLocation.x);
					if (currentMag < closestMag || currentMag == closestMag && p.y > closest.y) {
						closest = p;
					}
				}
			}
		}
		if (closest != null) {
			int newCorrect = closest.x - newTerminalLocation.x;
			int newMag = Math.abs(newCorrect);
			if (newMag < THRESHOLD) {
				if (newMag < Math.abs(correct)) {
					correct = newCorrect;
					guides.clear();
				}
				if (newCorrect == correct) {
					guides.add(new PointListEx(closest.x, terminalLocation.y, closest.x, closest.y));
				}
			}
		}
		return correct;
	}

	protected int getSouthCorrect(int correct, Point terminalLocation, Point delta, List<Point> northLocations, List<PointList> guides) {
		Point newTerminalLocation = terminalLocation.getTranslated(delta);
		Point closest = null;
		for (Point p : northLocations) {
			if (p.y >= newTerminalLocation.y) {
				if (closest == null) {
					closest = p;
				} else {
					int currentMag = Math.abs(p.x - newTerminalLocation.x);
					int closestMag = Math.abs(closest.x - newTerminalLocation.x);
					if (currentMag < closestMag || currentMag == closestMag && p.y < closest.y) {
						closest = p;
					}
				}
			}
		}
		if (closest != null) {
			int newCorrect = closest.x - newTerminalLocation.x;
			int newMag = Math.abs(newCorrect);
			if (newMag < THRESHOLD) {
				if (newMag < Math.abs(correct)) {
					correct = newCorrect;
					guides.clear();
				}
				if (newCorrect == correct) {
					guides.add(new PointListEx(closest.x, terminalLocation.y, closest.x, closest.y));
				}
			}
		}
		return correct;
	}

	@SuppressWarnings("unchecked")
	public int snapRectangle(Request request, int snapOrientation, PrecisionRectangle baseRect, PrecisionRectangle result) {
		if (!RequestConstants.REQ_MOVE.equals(request.getType()) && !RequestConstants.REQ_DROP.equals(request.getType())
				|| !(request instanceof GroupRequest)) {
			return snapOrientation;
		}
		
		GroupRequest groupRequest = (GroupRequest) request;
		
		if (groupRequest.getEditParts().size() != 1 || !(groupRequest.getEditParts().get(0) instanceof ComponentEditPart)) {
			return snapOrientation;
		}
		
		ComponentEditPart target = (ComponentEditPart) groupRequest.getEditParts().get(0);
		
		baseRect = baseRect.getPreciseCopy();
		makeRelative(container.getContentPane(), baseRect);
		PrecisionRectangle correction = new PrecisionRectangle();
		makeRelative(container.getContentPane(), correction);

		// Recalculate snapping locations if needed
		if (inputWestLocations == null
				|| inputEastLocations == null
				|| inputNorthLocations == null
				|| inputSouthLocations == null
				|| outputWestLocations == null
				|| outputEastLocations == null
				|| outputNorthLocations == null
				|| outputSouthLocations == null) {
			populateCache(generateSnapPartsList(target));
		}
		
		snapOrientation &= ~calculateCorrection(correction, target, baseRect, (Map<String, Object>) request.getExtendedData());
		
		makeAbsolute(container.getContentPane(), correction);
		result.setPreciseX(correction.preciseX());
		result.setPreciseY(correction.preciseY());
		result.setPreciseWidth(correction.preciseWidth());
		result.setPreciseHeight(correction.preciseHeight());
		
		return snapOrientation;
	}

}
