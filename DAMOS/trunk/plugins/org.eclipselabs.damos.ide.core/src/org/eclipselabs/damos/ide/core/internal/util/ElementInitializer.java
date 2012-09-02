package org.eclipselabs.damos.ide.core.internal.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipselabs.damos.dml.ActionLink;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Latch;
import org.eclipselabs.damos.dml.SynchronousTimingConstraint;
import org.eclipselabs.damos.dml.ValueSpecification;
import org.eclipselabs.damos.dml.util.IElementInitializer;
import org.eclipselabs.damos.dscript.DscriptValueSpecification;
import org.eclipselabs.damos.dscript.util.DscriptUtil;
import org.eclipselabs.damos.mscript.util.TypeUtil;

public class ElementInitializer implements IElementInitializer {

	public boolean initialize(ResourceSet resourceSet, EObject element, EStructuralFeature feature, Object hint) {
		if (element instanceof SynchronousTimingConstraint
				&& feature == DMLPackage.eINSTANCE.getSynchronousTimingConstraint_SampleTime()) {
			SynchronousTimingConstraint stc = (SynchronousTimingConstraint) element;
			DscriptValueSpecification valueSpecification = DscriptUtil.createValueSpecification(1, TypeUtil.createUnit(resourceSet, "s"));
			stc.setSampleTime(valueSpecification);
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
