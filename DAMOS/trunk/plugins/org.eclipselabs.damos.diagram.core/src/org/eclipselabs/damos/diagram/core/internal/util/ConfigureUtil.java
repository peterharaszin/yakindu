/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.diagram.core.internal.util;

import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.OpaqueSampleTimeSpecification;
import org.eclipselabs.damos.dml.SynchronousTimingConstraint;

/**
 * @author Andreas Unger
 *
 */
public class ConfigureUtil {

	public static void setSampleTime(Component component, String stringSampleTime) {
		OpaqueSampleTimeSpecification sampleTimeSpecification = DMLFactory.eINSTANCE.createOpaqueSampleTimeSpecification();
		sampleTimeSpecification.setSampleTime(stringSampleTime);
		SynchronousTimingConstraint synchronousTimingConstraint = DMLFactory.eINSTANCE.createSynchronousTimingConstraint();
		synchronousTimingConstraint.setSampleTime(sampleTimeSpecification);
		component.setTimingConstraint(synchronousTimingConstraint);
	}

}
