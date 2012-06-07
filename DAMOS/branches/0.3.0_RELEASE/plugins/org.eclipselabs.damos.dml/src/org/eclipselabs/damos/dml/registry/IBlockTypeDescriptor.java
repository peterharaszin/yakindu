/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.dml.registry;

import org.eclipse.emf.common.util.URI;

/**
 * @author Andreas Unger
 *
 * @noextend
 * @noimplement
 */
public interface IBlockTypeDescriptor {

	/**
	 * @return the name
	 */
	String getQualifiedName();

	/**
	 * @return the display name
	 */
	String getName();

	/**
	 * @return the uri
	 */
	URI getURI();

	/**
	 * @return the group
	 */
	IBlockGroupDescriptor getGroup();

}