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

package org.eclipse.damos.common.markers;

import org.eclipse.damos.common.CommonPlugin;

/**
 * @author Andreas Unger
 *
 * @noextend
 * @noimplement
 */
public interface IMarkerConstants {

	String PROBLEM_MARKER_ID = CommonPlugin.PLUGIN_ID + ".damosProblem";
	String ATTRIBUTE__FRAGMENT_URI = CommonPlugin.PLUGIN_ID + ".fragmentURI";
	String SOURCE = CommonPlugin.PLUGIN_ID + ".source";
	String CODE = CommonPlugin.PLUGIN_ID + ".code";
	
}
