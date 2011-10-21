/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package de.itemis.xtext.utils.gmf.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;

/**
 * Implementation of Resource that handles different kind of model mixins, i.e.
 * textual.
 * 
 * @author andreas muelder
 * 
 */
public class InjectMembersResource extends GMFResource implements
		IInjectMembersResourceAnnotations {

	private static final boolean isDebug = false;

	private boolean parsing = false;
	
	private String languageName;

	List<org.eclipse.emf.common.util.Diagnostic> diagnostics = new ArrayList<org.eclipse.emf.common.util.Diagnostic>();

	private List<IMemberInjectionService> services;

	public InjectMembersResource(URI uri) {
		super(uri);
		services = new ArrayList<IMemberInjectionService>();
	}

	public List<org.eclipse.emf.common.util.Diagnostic> getDiagnostics() {
		return diagnostics;
	}

	@Override
	public void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {

		super.doLoad(inputStream, options);
		parseAll();
	}

	private void parseAll() {
		parsing = true;
		diagnostics.clear();
		long t = System.currentTimeMillis();
		TreeIterator<EObject> iter = getAllContents();
		while (iter.hasNext()) {
			EObject currentObject = iter.next();
			EAnnotation eAnnotation = currentObject.eClass().getEAnnotation(
					INJECT_MEMBERS);
			if (eAnnotation != null) {
				IMemberInjectionService service = receiveInjectionService(currentObject);
				reparse(service, currentObject);
			}
		}
		if (isDebug)
			System.out.println("Reparsing Took "
					+ (System.currentTimeMillis() - t));
		parsing = false;
	}

	@Override
	public void attached(EObject eObject) {
		super.attached(eObject);
		if (isLoading() || isParsing())
			return;
		EAnnotation eAnnotation = eObject.eClass().getEAnnotation(
				INJECT_MEMBERS);
		if (eAnnotation != null) {
			reparse(receiveInjectionService(eObject), eObject);
		}
	}

	@Override
	public void detached(EObject eObject) {
		super.detached(eObject);
		Adapter existingAdapter = EcoreUtil.getExistingAdapter(eObject,
				ReparseAdapter.class);
		if (existingAdapter != null) {
			eObject.eAdapters().remove(existingAdapter);
		}
	}

	private IMemberInjectionService receiveInjectionService(
			EObject currentObject) {
		// first come first serve
		for (IMemberInjectionService service : services) {
			if (service.isServiceFor(currentObject)) {
				return service;
			}
		}
		throw new IllegalStateException("No service found for object "
				+ currentObject);
	}

	private void reparse(IMemberInjectionService service, EObject currentObject) {
		service.injectMembers(currentObject);
		registerReparseAdapter(service, currentObject);
		diagnostics.addAll(service.getDiagnostics());
	}

	/**
	 * Adds a reparseAdapter that observes the source feature and reparses the
	 * model element in case of changes.
	 * 
	 * @param object
	 */
	private void registerReparseAdapter(IMemberInjectionService service,
			EObject object) {
		Adapter existingAdapter = EcoreUtil.getExistingAdapter(object,
				ReparseAdapter.class);
		if (existingAdapter == null) {
			object.eAdapters().add(
					new ReparseAdapter(object, service.getSourceFeature(),
							service));
		}
	}

	public List<IMemberInjectionService> getServices() {
		return services;
	}

	public void setServices(List<IMemberInjectionService> services) {
		this.services = services;
	}

	/**
	 * ReparseAdapter listens for feature changes and reparses the whole model.
	 * 
	 * @author andreas muelder
	 * 
	 */
	private final class ReparseAdapter extends AdapterImpl {
		public final EStructuralFeature expressionFeature;

		private ReparseAdapter(EObject currentObject,
				EStructuralFeature expressionFeature,
				IMemberInjectionService service) {
			this.expressionFeature = expressionFeature;
		}

		@Override
		public void notifyChanged(Notification msg) {
			if (msg.getFeature() == expressionFeature) {
				parseAll();
			}
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return ReparseAdapter.class == type;
		}
	}
	

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public boolean isParsing() {
		return parsing;
	}
}