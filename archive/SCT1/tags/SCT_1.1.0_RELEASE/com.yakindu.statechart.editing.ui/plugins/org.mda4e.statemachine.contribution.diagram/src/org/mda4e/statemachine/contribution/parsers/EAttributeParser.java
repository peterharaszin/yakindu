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
package org.mda4e.statemachine.contribution.parsers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;

public abstract class EAttributeParser implements IParser {

	protected final EClass eClass;
	protected final EStructuralFeature eStructuralFeature;

	public EAttributeParser(EClass eClass, EStructuralFeature eStructuralFeature) {
		super();
		this.eClass = eClass;
		this.eStructuralFeature = eStructuralFeature;
	}

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEditString(IAdaptable element, int flags) {
		EObject eObject = (EObject) element.getAdapter(EObject.class);
		Object value = eObject.eGet(eStructuralFeature);
		if (value == null) {
			return "";
		} else {
			return value.toString();
		}
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		if (isValidEditString(element, newString).getCode() == IParserEditStatus.EDITABLE) {
			SetRequest request = new SetRequest((EObject) element
					.getAdapter(EObject.class), eStructuralFeature, newString);
			return new SetValueCommand(request);
		} else {
			return UnexecutableCommand.INSTANCE;
		}
	}

	public String getPrintString(IAdaptable element, int flags) {
		return getEditString(element, flags);
	}

	public boolean isAffectingEvent(Object event, int flags) {
		if (event instanceof Notification) {
			return ((Notification) event).getFeature().equals(
					eStructuralFeature);
		}
		return false;
	}

}