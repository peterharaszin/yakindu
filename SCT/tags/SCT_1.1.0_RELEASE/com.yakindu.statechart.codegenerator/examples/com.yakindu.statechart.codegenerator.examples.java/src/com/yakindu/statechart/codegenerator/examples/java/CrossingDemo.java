/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.statechart.codegenerator.examples.java;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import trafficlightwaiting.TrafficlightWaitingStatechart;

import com.yakindu.statechart.Event;

public class CrossingDemo {

	public static void main(String[] args) {
		// create display and shell
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(400, 400);
		shell.setText("Traffic Light Demo");
		GridLayout shellLayout = new GridLayout();
		shellLayout.numColumns = 1;
		shell.setLayout(shellLayout);

		// create state chart instance and start executing it cyclically
		final TrafficlightWaitingStatechart statechart = TrafficlightWaitingStatechart
				.createInstance();
		new Thread() {
			@Override
			public void run() {
				statechart.enter();
				while (true) {
					statechart.runCycle();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();

		// create crossing figure
		final CrossingFigure crossing = createCrossingFigure(shell, statechart);
		
		// create button composite to send events to the state chart
		createButtonComposite(statechart, shell);
		
		// open shell, repaint figure to update on state chart variable values
		shell.open();
		while (!shell.isDisposed()) {
			// update traffic light figure according to variables of state chart
			crossing.setTrafficLightStatus(statechart.getTl_green() > 0,
					statechart.getTl_yellow() > 0, statechart.getTl_red() > 0);
			crossing.setPedestrianLightStatus(statechart.getPed_request() > 0,
					statechart.getPed_green() > 0, statechart.getPed_red() > 0);
			crossing.repaint();
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	private static CrossingFigure createCrossingFigure(Shell shell,
			TrafficlightWaitingStatechart statechart) {
		LightweightSystem lws = createLightweightsystem(shell);

		CrossingFigure crossing = new CrossingFigure();
		lws.setContents(crossing);
		return crossing;
	}

	private static LightweightSystem createLightweightsystem(Shell shell) {
		FigureCanvas canvas = new FigureCanvas(shell);
		GridData canvasGridData = new GridData();
		canvasGridData.horizontalAlignment = GridData.FILL;
		canvasGridData.verticalAlignment = GridData.FILL;
		canvasGridData.grabExcessVerticalSpace = true;
		canvasGridData.grabExcessHorizontalSpace = true;
		canvas.setLayoutData(canvasGridData);
		LightweightSystem lws = new LightweightSystem(canvas);
		return lws;
	}

	private static void createButtonComposite(
			final TrafficlightWaitingStatechart statechart, Shell shell) {
		// create a composite to hold the buttons
		Composite buttonComposite = new Composite(shell, SWT.NO_SCROLL);
		GridData buttonCompositeGridData = new GridData();
		buttonCompositeGridData.horizontalAlignment = GridData.FILL;
		buttonCompositeGridData.grabExcessHorizontalSpace = true;
		buttonComposite.setLayoutData(buttonCompositeGridData);
		FillLayout buttonCompositeLayout = new FillLayout();
		buttonCompositeLayout.type = SWT.HORIZONTAL;
		buttonComposite.setLayout(new FillLayout());

		// create a button for each KEYPRESS event of the state chart
		Event[] events = new Event[] { TrafficlightWaitingStatechart.KEYPRESS1,
				TrafficlightWaitingStatechart.KEYPRESS2,
				TrafficlightWaitingStatechart.KEYPRESS3,
				TrafficlightWaitingStatechart.KEYPRESS4,
				TrafficlightWaitingStatechart.KEYPRESS5,
				TrafficlightWaitingStatechart.KEYPRESS6 };
		for (int i = 1; i <= events.length; i++) {
			final Event statechartEvent = events[i - 1];
			Button button = new Button(buttonComposite, SWT.PUSH);
			button.setText("key" + i);
			button.addListener(SWT.Selection, new Listener() {
				public void handleEvent(
						final org.eclipse.swt.widgets.Event event) {
					statechart.setEvent(statechartEvent);
				}
			});
		}
	}
}
