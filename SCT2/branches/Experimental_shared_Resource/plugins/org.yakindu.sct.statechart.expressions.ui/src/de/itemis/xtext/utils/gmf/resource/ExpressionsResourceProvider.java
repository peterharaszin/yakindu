package de.itemis.xtext.utils.gmf.resource;


import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionManager;
import org.eclipse.xtext.resource.impl.DefaultResourceServiceProvider;

/**
 * 
 * @author andreas.muelder@itemis.de
 * 
 */
public class ExpressionsResourceProvider extends
DefaultResourceServiceProvider implements IResourceServiceProvider {

	@Override
	public IResourceDescription.Manager getResourceDescriptionManager() {
		return new DefaultResourceDescriptionManager() {
			public IResourceDescription getResourceDescription(Resource resource) {
				return new ExpressionsResourceDescription(resource);
			}
		};
	}

	@Override
	public boolean canHandle(URI uri) {
		return uri.fileExtension().endsWith("sct");
	}

}
