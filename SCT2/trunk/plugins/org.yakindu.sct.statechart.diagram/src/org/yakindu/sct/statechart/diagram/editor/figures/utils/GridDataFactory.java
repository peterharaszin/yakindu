package org.yakindu.sct.statechart.diagram.editor.figures.utils;

import org.eclipse.draw2d.GridData;

/**
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public class GridDataFactory {

	private final GridData data;

	private GridDataFactory() {
		data = new GridData();
	}

	/**
	 * Creates a GridDataFactory initialized with defaults. Initial values are:
	 * 
	 * align(SWT.FILL, SWT.FILL) exclude(false) grab(false, false) span(1,1)
	 */
	public static GridDataFactory fillDefaults() {
		return new GridDataFactory().fillDefaultsInternal();
	}

	private GridDataFactory fillDefaultsInternal() {
		align(GridData.FILL, GridData.FILL);
		grab(false, false);
		span(1, 1);
		data.horizontalIndent = 1;
		return this;
	}

	public GridDataFactory span(int horizontalSpan, int verticalSpan) {
		data.horizontalSpan = horizontalSpan;
		data.verticalSpan = verticalSpan;
		return this;
	}

	public GridDataFactory align(int verticalAlignment, int horizontalAlignment) {
		data.verticalAlignment = verticalAlignment;
		data.horizontalAlignment = horizontalAlignment;
		return this;
	}

	public GridDataFactory grab(boolean horizontal, boolean vertical) {
		data.grabExcessHorizontalSpace = horizontal;
		data.grabExcessVerticalSpace = vertical;
		return this;
	}

	public GridData getData() {
		return data;
	}

}
