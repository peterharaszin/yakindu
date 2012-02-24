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
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;

import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder
 * 
 */
public class InjectMembersResource extends GMFResource implements
		IInjectMembersResourceAnnotations {

	private boolean parsing = false;

	private boolean debug = true;

	private String languageName;

	@Inject
	private InjectMembersLazyLinker linker;

	public void doLinking() {
		System.out.println("Linking model");
		long t = System.currentTimeMillis();
		TreeIterator<EObject> allContents = getAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			EAnnotation eAnnotation = next.eClass().getEAnnotation(
					INJECT_MEMBERS);
			if (eAnnotation != null) {
				linkObject(next);
			}
		}
		if (debug)
			System.out.println("Linking model took "
					+ (System.currentTimeMillis() - t));
	}

	private void linkObject(EObject model) {
		final ListBasedDiagnosticConsumer consumer = new ListBasedDiagnosticConsumer();
		linker.linkModel(model, consumer);
		List<org.eclipse.xtext.diagnostics.Diagnostic> errors = consumer
				.getResult(Severity.ERROR);
		for (Diagnostic diagnostic : errors) {
			diagnostics.add(new BasicDiagnostic(
					org.eclipse.emf.common.util.Diagnostic.ERROR, "source", 0,
					diagnostic.getMessage(), new Object[] { model }));
		}
		List<org.eclipse.xtext.diagnostics.Diagnostic> warnings = consumer
				.getResult(Severity.WARNING);
		for (Diagnostic diagnostic : warnings) {
			diagnostics.add(new BasicDiagnostic(
					org.eclipse.emf.common.util.Diagnostic.WARNING, "source",
					0, diagnostic.getMessage(), new Object[] { model }));
		}
	}

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
		System.out.println("Parse all");
		parsing = true;
		diagnostics.clear();
		TreeIterator<EObject> iter = getAllContents();
		List<EObject> toParse = new ArrayList<EObject>();
		while (iter.hasNext()) {
			EObject currentObject = iter.next();
			EAnnotation eAnnotation = currentObject.eClass().getEAnnotation(
					INJECT_MEMBERS);
			if (eAnnotation != null) {
				toParse.add(currentObject);
			}
		}
		for (EObject eObject : toParse) {
			reparse(eObject);
		}
		for(EObject eObject : toParse){
			registerReparseAdapter(eObject);
		}
		doLinking();
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
			reparse(eObject);
			registerReparseAdapter(eObject);
		}
	}

	@Override
	public void detached(EObject eObject) {
		super.detached(eObject);
		Adapter existingAdapter = getReparseAdapter(eObject);
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

	private void reparse(EObject currentObject) {
		diagnostics.clear();
		IMemberInjectionService service = receiveInjectionService(currentObject);
		service.injectMembers(currentObject);
		diagnostics.addAll(service.getDiagnostics());
	}

	private void registerReparseAdapter(EObject object) {
		Adapter existingAdapter = getReparseAdapter(object);
		if (existingAdapter == null) {
			object.eAdapters().add(new ReparseAdapter());
		}
	}

	private ReparseAdapter getReparseAdapter(EObject object) {
		Adapter existingAdapter = EcoreUtil.getExistingAdapter(object,
				ReparseAdapter.class);
		return (ReparseAdapter) existingAdapter;
	}

	public List<IMemberInjectionService> getServices() {
		return services;
	}

	public void setServices(List<IMemberInjectionService> services) {
		this.services = services;
	}

	private final class ReparseAdapter extends AdapterImpl {
		

		private boolean trackModification = true;

		@Override
		public void notifyChanged(Notification msg) {
			if (msg.getNewValue() != null && trackModification) {
				trackModification = false;
				reparse((EObject) this.getTarget());
				doLinking();
				trackModification = true;
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