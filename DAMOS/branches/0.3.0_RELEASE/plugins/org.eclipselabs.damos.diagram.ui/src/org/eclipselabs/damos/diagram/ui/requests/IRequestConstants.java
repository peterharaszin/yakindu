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

package org.eclipselabs.damos.diagram.ui.requests;

/**
 * @author Andreas Unger
 *
 * @noextend
 * @noimplement
 */
public interface IRequestConstants extends org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants {

	public static final String REQ_FLIP_COMPONENT = "flipComponent";
	public static final String REQ_ROTATE_COMPONENT = "rotateComponent";
	public static final String REQ_RESET_FLIP_AND_ROTATE_COMPONENT = "resetFlipAndRotateComponent";
	
	public static final String REQ_ADD_INPUT_PORT = "addInputPort";
	public static final String REQ_REMOVE_INPUT_PORT = "removeInputPort";
	public static final String REQ_ADD_OUTPUT_PORT = "addOutputPort";
	public static final String REQ_REMOVE_OUTPUT_PORT = "removeOutputPort";
		
}
