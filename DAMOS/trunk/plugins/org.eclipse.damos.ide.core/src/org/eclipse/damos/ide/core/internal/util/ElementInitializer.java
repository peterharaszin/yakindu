/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.ide.core.internal.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.damos.dml.ActionLink;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Latch;
import org.eclipse.damos.dml.SynchronousTimingConstraint;
import org.eclipse.damos.dml.ValueSpecification;
import org.eclipse.damos.dml.util.IElementInitializer;
import org.eclipse.damos.dscript.DscriptValueSpecification;
import org.eclipse.damos.dscript.util.DscriptUtil;
import org.eclipse.damos.mscript.util.TypeUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class ElementInitializer implements IElementInitializer {

	public boolean initialize(ResourceSet resourceSet, EObject element, EStructuralFeature feature, Object hint) {
		if (element instanceof SynchronousTimingConstraint
				&& feature == DMLPackage.eINSTANCE.getSynchronousTimingConstraint_SampleInterval()) {
			SynchronousTimingConstraint stc = (SynchronousTimingConstraint) element;
			DscriptValueSpecification valueSpecification = DscriptUtil.createValueSpecification(1, TypeUtil.createUnit(resourceSet, "s"), "1(s)");
			stc.setSampleInterval(valueSpecification);
			return true;
		}
		
		if (element instanceof ActionLink && feature == DMLPackage.eINSTANCE.getActionLink_Condition()) {
			ActionLink actionLink = (ActionLink) element;
			List<ActionLink> actionLinks = new ArrayList<ActionLink>(actionLink.getChoice().getActionLinks());
	    	actionLinks.remove(actionLink);
			
	    	switch (actionLinks.size()) {
	    	case 0:
	    		actionLink.setCondition(DscriptUtil.createValueSpecification(true));
	    		break;
	    	case 1:
	    		ValueSpecification conditionSpecification = actionLinks.get(0).getCondition();
	    		if (conditionSpecification != null) {
					String condition = conditionSpecification.stringValue();
					if (Boolean.TRUE.toString().equals(condition)) {
						actionLink.setCondition(DscriptUtil.createValueSpecification(false));
		    		} else if (Boolean.FALSE.toString().equals(condition)) {
		    			actionLink.setCondition(DscriptUtil.createValueSpecification(true));
		    		}
	    		}
	    		break;
	    	}
	    	
	    	return true;
		}
		
		if (element instanceof Latch && feature == DMLPackage.eINSTANCE.getLatch_InitialValue()) {
			Latch latch = (Latch) element;
			latch.setInitialValue(DscriptUtil.createValueSpecification(0));
			return true;
		}
		
		return false;
	}

}
