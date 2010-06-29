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

package org.esmp.dsm.diagram.ui.internal.editparts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.esmp.dsm.diagram.ui.editparts.BlockEditPart;
import org.esmp.dsm.diagram.ui.editparts.InputPortEditPart;
import org.esmp.dsm.diagram.ui.editparts.OutputPortEditPart;
import org.esmp.dsm.diagram.ui.editparts.PortEditPart;
import org.esmp.dsm.diagram.ui.figures.PortFigure;
import org.esmp.dsm.diagram.ui.internal.geometry.PointListEx;

/**
 * @author Andreas Unger
 *
 */
public class SnapToPort extends SnapToHelper {
	
	public static final String KEY_GUIDE_LOCATIONS = "SnapToPort.GuideLocations";

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
	public SnapToPort(GraphicalEditPart container) {
		this.container = container;
	}
	
	protected List<BlockEditPart> generateSnapPartsList(BlockEditPart exclusion) {
		List<BlockEditPart> children = new ArrayList<BlockEditPart>();

		for (Object o : container.getChildren()) {
			GraphicalEditPart child = (GraphicalEditPart) o;
			if (child != exclusion && child instanceof BlockEditPart && child.getFigure().isVisible()) {
				children.add((BlockEditPart) child);
			}
		}

		return children;
	}

	protected void populateCache(List<BlockEditPart> parts) {
		inputWestLocations = new ArrayList<Point>();
		inputEastLocations = new ArrayList<Point>();
		inputNorthLocations = new ArrayList<Point>();
		inputSouthLocations = new ArrayList<Point>();
		outputWestLocations = new ArrayList<Point>();
		outputEastLocations = new ArrayList<Point>();
		outputNorthLocations = new ArrayList<Point>();
		outputSouthLocations = new ArrayList<Point>();

		for (BlockEditPart part : parts) {
			for (Object o : part.getChildren()) {
				if (o instanceof PortEditPart) {
					PortFigure portFigure = (PortFigure) ((PortEditPart) o).getFigure();
					Point terminalLocation = portFigure.getTerminalLocation();
					if (terminalLocation != null) {
						terminalLocation = terminalLocation.getCopy();
						if (o instanceof InputPortEditPart) {
							switch (portFigure.getOrientation()) {
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
						} else if (o instanceof OutputPortEditPart) {
							switch (portFigure.getOrientation()) {
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
				}
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
	
	protected int calculateCorrection(PrecisionRectangle correction, BlockEditPart target, PrecisionRectangle baseRect, Map<String, Object> extendedData) {
		List<PointList> horizontalGuides = new ArrayList<PointList>();
		List<PointList> verticalGuides = new ArrayList<PointList>();
		
		int correctX = Integer.MAX_VALUE;
		int correctY = Integer.MAX_VALUE;

		Point delta = new Point(baseRect.x - getFigureBounds(target).x, baseRect.y - getFigureBounds(target).y);
		
		for (Object o : target.getChildren()) {
			if (o instanceof PortEditPart) {
				PortFigure portFigure = (PortFigure) ((PortEditPart) o).getFigure();
				
				Point terminalLocation = portFigure.getTerminalLocation();
				if (terminalLocation == null) {
					continue;
				}
				
				if (o instanceof InputPortEditPart) {
					switch (portFigure.getOrientation()) {
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
				} else if (o instanceof OutputPortEditPart) {
					switch (portFigure.getOrientation()) {
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
			correction.preciseX += correctX;
			snapOrientation |= HORIZONTAL;
		}
		if (Math.abs(correctY) < THRESHOLD) {
			correction.preciseY += correctY;
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
		
		if (groupRequest.getEditParts().size() != 1 || !(groupRequest.getEditParts().get(0) instanceof BlockEditPart)) {
			return snapOrientation;
		}
		
		BlockEditPart target = (BlockEditPart) groupRequest.getEditParts().get(0);
		
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
		
		correction.updateInts();
		makeAbsolute(container.getContentPane(), correction);
		result.preciseX = correction.preciseX;
		result.preciseY = correction.preciseY;
		result.preciseWidth = correction.preciseWidth;
		result.preciseHeight = correction.preciseHeight;
		result.updateInts();
		
		return snapOrientation;
	}

}
