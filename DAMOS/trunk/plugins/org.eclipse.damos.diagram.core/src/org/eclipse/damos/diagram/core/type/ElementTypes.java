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

package org.eclipse.damos.diagram.core.type;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

public class ElementTypes extends AbstractElementTypeEnumerator {

	public static final String FRAGMENT_ID = "org.eclipse.damos.diagram.fragment"; //$NON-NLS-1$
	public static final IElementType FRAGMENT = getElementType(FRAGMENT_ID);

	public static final String INPUT_ID = "org.eclipse.damos.diagram.input"; //$NON-NLS-1$
	public static final IElementType INPUT = getElementType(INPUT_ID);

	public static final String OUTPUT_ID = "org.eclipse.damos.diagram.output"; //$NON-NLS-1$
	public static final IElementType OUTPUT = getElementType(OUTPUT_ID);

	public static final String INPUT_PORT_ID = "org.eclipse.damos.diagram.inputPort"; //$NON-NLS-1$
	public static final IElementType INPUT_PORT = getElementType(INPUT_PORT_ID);

	public static final String OUTPUT_PORT_ID = "org.eclipse.damos.diagram.outputPort"; //$NON-NLS-1$
	public static final IElementType OUTPUT_PORT = getElementType(OUTPUT_PORT_ID);

	public static final String CONNECTION_ID = "org.eclipse.damos.diagram.connection"; //$NON-NLS-1$
	public static final IElementType CONNECTION = getElementType(CONNECTION_ID);
	
	public static final String ACTION_LINK_ID = "org.eclipse.damos.diagram.actionLink"; //$NON-NLS-1$
	public static final IElementType ACTION_LINK = getElementType(ACTION_LINK_ID);

	public static final String SUBSYSTEM_ID = "org.eclipse.damos.diagram.subsystem"; //$NON-NLS-1$
	public static final IElementType SUBSYSTEM = getElementType(SUBSYSTEM_ID);

	public static final String INPORT_ID = "org.eclipse.damos.diagram.inport"; //$NON-NLS-1$
	public static final IElementType INPORT = getElementType(INPORT_ID);

	public static final String OUTPORT_ID = "org.eclipse.damos.diagram.outport"; //$NON-NLS-1$
	public static final IElementType OUTPORT = getElementType(OUTPORT_ID);

	public static final String CHOICE_ID = "org.eclipse.damos.diagram.choice"; //$NON-NLS-1$
	public static final IElementType CHOICE = getElementType(CHOICE_ID);

	public static final String JOIN_ID = "org.eclipse.damos.diagram.join"; //$NON-NLS-1$
	public static final IElementType JOIN = getElementType(JOIN_ID);

	public static final String ACTION_ID = "org.eclipse.damos.diagram.action"; //$NON-NLS-1$
	public static final IElementType ACTION = getElementType(ACTION_ID);

	public static final String WHILE_LOOP_ID = "org.eclipse.damos.diagram.whileLoop"; //$NON-NLS-1$
	public static final IElementType WHILE_LOOP = getElementType(WHILE_LOOP_ID);

	public static final String MEMORY_ID = "org.eclipse.damos.diagram.memory"; //$NON-NLS-1$
	public static final IElementType MEMORY = getElementType(MEMORY_ID);

	public static final String LATCH_ID = "org.eclipse.damos.diagram.latch"; //$NON-NLS-1$
	public static final IElementType LATCH = getElementType(LATCH_ID);

	public static final String BLOCK_ID = "org.eclipse.damos.diagram.block"; //$NON-NLS-1$
	public static final IElementType BLOCK = getElementType(BLOCK_ID);

	public static final String BLOCK_INPUT_ID = "org.eclipse.damos.diagram.blockInput"; //$NON-NLS-1$
	public static final IElementType BLOCK_INPUT = getElementType(BLOCK_INPUT_ID);

	public static final String BLOCK_OUTPUT_ID = "org.eclipse.damos.diagram.blockOutput"; //$NON-NLS-1$
	public static final IElementType BLOCK_OUTPUT = getElementType(BLOCK_OUTPUT_ID);

	public static final String BLOCK_INPUT_PORT_ID = "org.eclipse.damos.diagram.blockInputPort"; //$NON-NLS-1$
	public static final IElementType BLOCK_INPUT_PORT = getElementType(BLOCK_INPUT_PORT_ID);

	public static final String BLOCK_OUTPUT_PORT_ID = "org.eclipse.damos.diagram.blockOutputPort"; //$NON-NLS-1$
	public static final IElementType BLOCK_OUTPUT_PORT = getElementType(BLOCK_OUTPUT_PORT_ID);

	public static final String ARGUMENT_ID = "org.eclipse.damos.diagram.argument"; //$NON-NLS-1$
	public static final IElementType ARGUMENT = getElementType(ARGUMENT_ID);

}
