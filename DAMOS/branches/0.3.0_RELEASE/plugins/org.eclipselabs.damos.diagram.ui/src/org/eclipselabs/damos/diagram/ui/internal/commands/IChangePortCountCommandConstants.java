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

package org.eclipselabs.damos.diagram.ui.internal.commands;

/**
 * @author Andreas Unger
 *
 * @noextend
 * @noimplement
 */
public interface IChangePortCountCommandConstants {

	String PARAMETER__KIND = "org.eclipselabs.damos.diagram.ui.commands.changePortCount.kind";
	String PARAMETER__KIND__INPUT = "input";
	String PARAMETER__KIND__OUTPUT = "output";
	String PARAMETER__ACTION = "org.eclipselabs.damos.diagram.ui.commands.changePortCount.action";
	String PARAMETER__ACTION__ADD = "add";
	String PARAMETER__ACTION__REMOVE = "remove";
	String PARAMETER__NAME = "org.eclipselabs.damos.diagram.ui.commands.changePortCount.name";
	
}
