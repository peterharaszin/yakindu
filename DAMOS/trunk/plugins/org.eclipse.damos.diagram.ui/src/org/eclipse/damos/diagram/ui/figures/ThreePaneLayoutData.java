/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.diagram.ui.figures;

import org.eclipse.swt.SWT;


/**
 * @author Andreas Unger
 *
 */
public class ThreePaneLayoutData {

	public static final int BODY = 0;
	public static final int HEADER = 1;
	public static final int FOOTER = 2;

	public int horizontalAlignment = SWT.CENTER;
	public int verticalAlignment = SWT.CENTER;
	
	public int contentType;

	/**
	 * 
	 */
	public ThreePaneLayoutData(int contentType) {
		this.contentType = contentType;
	}
	
	public ThreePaneLayoutData(int contentType, int horizontalAlignment, int verticalAlignment) {
		this.contentType = contentType;
		this.horizontalAlignment = horizontalAlignment;
		this.verticalAlignment = verticalAlignment;
	}

}
