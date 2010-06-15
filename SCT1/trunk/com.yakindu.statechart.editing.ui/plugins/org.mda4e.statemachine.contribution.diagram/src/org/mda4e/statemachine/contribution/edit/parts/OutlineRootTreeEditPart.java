/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.mda4e.statemachine.contribution.edit.parts;

import java.util.ArrayList;
import java.util.List;


import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.editparts.AbstractTreeEditPart;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.mda4e.statemachine.contribution.model.OutlineTreeObject;

import statemachine.DataElement;
import statemachine.Event;
import statemachine.Statechart;
import statemachine.Variable;

public class OutlineRootTreeEditPart extends AbstractTreeEditPart {
	
	private Adapter adapter;
	
	public OutlineRootTreeEditPart(Statechart statechart){
		super(statechart);
		adapter = getAdapter();
	}
	
	public String getText(){
		if (getCastedModel().getName()!=null)
			return getCastedModel().getName();
		else return "";
	}
	
	
	public void activate() {
		if (!isActive()) {
			super.activate();
			getCastedModel().eAdapters().add(adapter);
		}
	}

	public void deactivate() {
		if (isActive()) {
			super.deactivate();
			getCastedModel().eAdapters().remove(adapter);
		}
	}
	
	
	private Statechart getCastedModel(){
		return (Statechart) getModel();
	}
	
	protected List <OutlineTreeObject> getModelChildren(){
		List <OutlineTreeObject> ret = new ArrayList<OutlineTreeObject>();
		ret.add(new OutlineTreeObject("Events"));
		ret.add(new OutlineTreeObject("Variables"));
		
		for (int i=0;i<getCastedModel().getDataElement().size();i++){
			if (getCastedModel().getDataElement().get(i) instanceof Event)
				ret.get(0).getChildren().add(getCastedModel().getDataElement().get(i));
			else if (getCastedModel().getDataElement().get(i) instanceof Variable)
				ret.get(1).getChildren().add(getCastedModel().getDataElement().get(i)); 
		}
		return ret;
	}
	
	protected void createEditPolicies() {
		// If this editpart is the root content of the viewer, then disallow
		// removal
		if (getParent() instanceof RootEditPart) {
			installEditPolicy(EditPolicy.COMPONENT_ROLE,
					new RootComponentEditPolicy());
		}
	}
	
	private Adapter getAdapter(){
		return new Adapter(){

			public Notifier getTarget() {
				// TODO Auto-generated method stub
				return null;
			}

			public boolean isAdapterForType(Object arg0) {
				// TODO Auto-generated method stub
				return false;
			}

			public void notifyChanged(Notification notification) {
				//System.out.println("Notification: " +notification.toString());
				switch (notification.getEventType()){
				case Notification.ADD:
				case Notification.REMOVE:{
					if (notification.getNewValue() instanceof DataElement) {
						refresh();
					}
						
					break;
				}
				case Notification.SET: {
					//System.out.println("SET: "+notification.getNewValue());
					if (notification.getNotifier() instanceof Statechart) {
						refresh();
					}
					break;
				}
				}//End-Switch
			}

			public void setTarget(Notifier arg0) {
				// TODO Auto-generated method stub
				
			}
		};
	}
}
