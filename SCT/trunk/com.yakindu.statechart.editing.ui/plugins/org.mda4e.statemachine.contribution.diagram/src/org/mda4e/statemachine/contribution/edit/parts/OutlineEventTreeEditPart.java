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

import org.eclipse.gef.editparts.AbstractTreeEditPart;

import statemachine.Event;

public class OutlineEventTreeEditPart extends AbstractTreeEditPart{
	
	public OutlineEventTreeEditPart(Event event){
		super(event);
		//adapter = getAdapter();
	}
	
	/*
	public void activate() {
		if (!isActive()) {
			super.activate();
			((OutlineTreeRoot) getModel()).eAdapters().add(adapter);
		}
	}

	public void deactivate() {
		if (isActive()) {
			super.deactivate();
			((VarContainer) getModel()).removePropertyChangeListener(adapter);
		}
	}
	*/
	
	public String getText(){
		return getCastedModel().getName();
	}
	
	private Event getCastedModel(){
		return (Event) getModel();
	}
	/*
	private Adapter getAdapter(){
		return new Adapter(){

			@Override
			public Notifier getTarget() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean isAdapterForType(Object arg0) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void notifyChanged(Notification arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setTarget(Notifier arg0) {
				// TODO Auto-generated method stub
				
			}
		};
	}*/
}