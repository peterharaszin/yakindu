package com.yakindu.statechart.model.xtextindex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public abstract class SimpleResourceDescription extends AbstractResourceDescription {

	private final class QualifiedEObjectDescription extends EObjectDescription  {
		private final String qualifiedName;
	
		private QualifiedEObjectDescription(String name, EObject element,
				Map<String, String> userData, String qualifiedName) {
			super(name, element, userData);
			this.qualifiedName = qualifiedName;
		}
	
		@Override
		public String getQualifiedName() {
			return qualifiedName;
		}
	}

	protected Resource resource;
	protected URI uri;

	public SimpleResourceDescription(Resource resource) {
		this.resource = resource;
		this.uri = getNormalizedURI(resource);
	}

	@Override
	protected List<IEObjectDescription> computeExportedObjects() {
		Iterator<EObject> contents = resource.getAllContents();
		List<IEObjectDescription> result = Lists.newArrayList();
		while (contents.hasNext()) {
			EObject eObject = contents.next();
			if (canHandle(eObject)) {
				if (eObject.eIsProxy()) {
					eObject = EcoreUtil.resolve(eObject, resource);
				}
				final String name = getSimpleName(eObject);
				if (name != null) {
					HashMap<String, String> userData = new HashMap<String, String>();
					result.add(new EObjectDescription(name, eObject, userData));
				}
			}
		}
		return result;
	}

	public Iterable<String> getImportedNames() {
		return Iterables.emptyIterable();
	}

	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		return Iterables.emptyIterable();
	}

	public URI getURI() {
		return uri;
	}

	public abstract String getSimpleName(EObject obj);

	protected abstract boolean canHandle(EObject eObject);

}
