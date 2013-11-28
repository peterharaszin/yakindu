package com.yakindu.statechart.model.xtextindex;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import statemachine.DataElement;
import statemachine.Statechart;


public class StatemachineResourceDescription extends SimpleResourceDescription {

	
	public StatemachineResourceDescription(Resource resource) {
		super(resource);
	}

	protected boolean canHandle(EObject eObject) {
		return eObject instanceof Statechart || eObject instanceof DataElement;
	}

	@Override
	public String getSimpleName(EObject obj) {
		if (obj instanceof Statechart) {
			return ((Statechart) obj).getName();
		} else if (obj instanceof DataElement) {
			return ((DataElement) obj).getName();
		}
			
		return null;
	}


}
