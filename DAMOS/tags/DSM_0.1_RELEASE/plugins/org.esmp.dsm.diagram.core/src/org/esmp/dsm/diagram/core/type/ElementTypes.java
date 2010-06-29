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

package org.esmp.dsm.diagram.core.type;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

public class ElementTypes extends AbstractElementTypeEnumerator {

	public static final String BLOCK_DIAGRAM_ID = "org.esmp.dsm.diagram.blockDiagram"; //$NON-NLS-1$
	public static final IElementType BLOCK_DIAGRAM = getElementType(BLOCK_DIAGRAM_ID);

	public static final String CONNECTION_ID = "org.esmp.dsm.diagram.connection"; //$NON-NLS-1$
	public static final IElementType CONNECTION = getElementType(CONNECTION_ID);
	
	public static final String BLOCK_ID = "org.esmp.dsm.diagram.block"; //$NON-NLS-1$
	public static final IElementType BLOCK = getElementType(BLOCK_ID);

	public static final String INPUT_ID = "org.esmp.dsm.diagram.input"; //$NON-NLS-1$
	public static final IElementType INPUT = getElementType(INPUT_ID);

	public static final String OUTPUT_ID = "org.esmp.dsm.diagram.output"; //$NON-NLS-1$
	public static final IElementType OUTPUT = getElementType(OUTPUT_ID);

	public static final String PORT_ID = "org.esmp.dsm.diagram.port"; //$NON-NLS-1$
	public static final IElementType PORT = getElementType(PORT_ID);

	public static final String INPUT_PORT_ID = "org.esmp.dsm.diagram.inputPort"; //$NON-NLS-1$
	public static final IElementType INPUT_PORT = getElementType(INPUT_PORT_ID);

	public static final String OUTPUT_PORT_ID = "org.esmp.dsm.diagram.outputPort"; //$NON-NLS-1$
	public static final IElementType OUTPUT_PORT = getElementType(OUTPUT_PORT_ID);

	public static final String PARAMETER_ID = "org.esmp.dsm.diagram.parameter"; //$NON-NLS-1$
	public static final IElementType PARAMETER = getElementType(PARAMETER_ID);

}
