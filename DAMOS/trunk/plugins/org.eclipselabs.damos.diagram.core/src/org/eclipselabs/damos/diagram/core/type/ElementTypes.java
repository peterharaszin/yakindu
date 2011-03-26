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

package org.eclipselabs.damos.diagram.core.type;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

public class ElementTypes extends AbstractElementTypeEnumerator {

	public static final String FRAGMENT_ID = "org.eclipselabs.damos.diagram.fragment"; //$NON-NLS-1$
	public static final IElementType FRAGMENT = getElementType(FRAGMENT_ID);

	public static final String CONNECTION_ID = "org.eclipselabs.damos.diagram.connection"; //$NON-NLS-1$
	public static final IElementType CONNECTION = getElementType(CONNECTION_ID);
	
	public static final String ACTION_LINK_ID = "org.eclipselabs.damos.diagram.actionLink"; //$NON-NLS-1$
	public static final IElementType ACTION_LINK = getElementType(ACTION_LINK_ID);

	public static final String SUBSYSTEM_ID = "org.eclipselabs.damos.diagram.subsystem"; //$NON-NLS-1$
	public static final IElementType SUBSYSTEM = getElementType(SUBSYSTEM_ID);

	public static final String INPORT_ID = "org.eclipselabs.damos.diagram.inport"; //$NON-NLS-1$
	public static final IElementType INPORT = getElementType(INPORT_ID);

	public static final String OUTPORT_ID = "org.eclipselabs.damos.diagram.outport"; //$NON-NLS-1$
	public static final IElementType OUTPORT = getElementType(OUTPORT_ID);

	public static final String CHOICE_ID = "org.eclipselabs.damos.diagram.choice"; //$NON-NLS-1$
	public static final IElementType CHOICE = getElementType(CHOICE_ID);

	public static final String JOIN_ID = "org.eclipselabs.damos.diagram.join"; //$NON-NLS-1$
	public static final IElementType JOIN = getElementType(JOIN_ID);

	public static final String ACTION_ID = "org.eclipselabs.damos.diagram.action"; //$NON-NLS-1$
	public static final IElementType ACTION = getElementType(ACTION_ID);

	public static final String WHILE_LOOP_ID = "org.eclipselabs.damos.diagram.whileLoop"; //$NON-NLS-1$
	public static final IElementType WHILE_LOOP = getElementType(WHILE_LOOP_ID);

	public static final String BLOCK_ID = "org.eclipselabs.damos.diagram.block"; //$NON-NLS-1$
	public static final IElementType BLOCK = getElementType(BLOCK_ID);

	public static final String BLOCK_INPUT_ID = "org.eclipselabs.damos.diagram.blockInput"; //$NON-NLS-1$
	public static final IElementType BLOCK_INPUT = getElementType(BLOCK_INPUT_ID);

	public static final String BLOCK_OUTPUT_ID = "org.eclipselabs.damos.diagram.blockOutput"; //$NON-NLS-1$
	public static final IElementType BLOCK_OUTPUT = getElementType(BLOCK_OUTPUT_ID);

	public static final String BLOCK_INPUT_PORT_ID = "org.eclipselabs.damos.diagram.blockInputPort"; //$NON-NLS-1$
	public static final IElementType BLOCK_INPUT_PORT = getElementType(BLOCK_INPUT_PORT_ID);

	public static final String BLOCK_OUTPUT_PORT_ID = "org.eclipselabs.damos.diagram.blockOutputPort"; //$NON-NLS-1$
	public static final IElementType BLOCK_OUTPUT_PORT = getElementType(BLOCK_OUTPUT_PORT_ID);

	public static final String ARGUMENT_ID = "org.eclipselabs.damos.diagram.argument"; //$NON-NLS-1$
	public static final IElementType ARGUMENT = getElementType(ARGUMENT_ID);

}
