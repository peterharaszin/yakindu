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

package org.eclipselabs.damos.diagram.ui.internal.properties;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.diagram.ui.properties.AbstractTextPropertySection;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.ContinuousTimingConstraint;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.OpaqueSampleTimeSpecification;
import org.eclipselabs.damos.dml.SynchronousTimingConstraint;

/**
 * @author Andreas Unger
 *
 */
public class TimingConstraintPropertySection extends AbstractTextPropertySection {

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractBasicTextPropertySection#getPropertyChangeCommandName()
	 */
	protected String getPropertyChangeCommandName() {
		return "Change Sample Time";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractBasicTextPropertySection#getPropertyNameLabel()
	 */
	protected String getPropertyNameLabel() {
		return "Sample Time:";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractBasicTextPropertySection#getPropertyValueString()
	 */
	protected String getPropertyValueString() {
		Component component = getComponent();
		if (component.getTimingConstraint() == null) {
			return "-1";
		}
		if (component.getTimingConstraint() instanceof ContinuousTimingConstraint) {
			return "0";
		}
		if (component.getTimingConstraint() instanceof SynchronousTimingConstraint) {
			SynchronousTimingConstraint synchronousTimingConstraint = (SynchronousTimingConstraint) component.getTimingConstraint();
			return synchronousTimingConstraint.getSampleTime().stringSampleTime();
		}
		return "";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractBasicTextPropertySection#setPropertyValue(org.eclipse.emf.ecore.EObject, java.lang.Object)
	 */
	protected void setPropertyValue(EObject object, Object value) {
		Component component = getComponent();
		if (component != null) {
			double sampleTime = -1;
			try {
			sampleTime = Double.parseDouble((String) value);
			} catch (NumberFormatException e) {
				// Use default value (-1)
			}
			if (sampleTime == -1) {
				component.setTimingConstraint(null);
			} else if (sampleTime == 0) {
				component.setTimingConstraint(DMLFactory.eINSTANCE.createContinuousTimingConstraint());
			} else {
				OpaqueSampleTimeSpecification sampleTimeSpecification = DMLFactory.eINSTANCE.createOpaqueSampleTimeSpecification();
				sampleTimeSpecification.setSampleTime(Double.toString(sampleTime));
				SynchronousTimingConstraint synchronousTimingConstraint = DMLFactory.eINSTANCE.createSynchronousTimingConstraint();
				synchronousTimingConstraint.setSampleTime(sampleTimeSpecification);
				component.setTimingConstraint(synchronousTimingConstraint);
			}
		}
	}
	
	private Component getComponent() {
		EObject eObject = getEObject();
		if (eObject instanceof Component) {
			return (Component) eObject;
		}
		return null;
	}

}
