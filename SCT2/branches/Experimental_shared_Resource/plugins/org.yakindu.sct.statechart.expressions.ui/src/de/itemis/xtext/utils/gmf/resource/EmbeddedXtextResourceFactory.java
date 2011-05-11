package de.itemis.xtext.utils.gmf.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.parser.IParser;

import com.google.inject.Inject;

import de.itemis.xtext.utils.gmf.experimental.EmbeddedXtextResource;

/**
 * 
 * @author andreas muelder
 * 
 */
public class EmbeddedXtextResourceFactory extends XMIResourceFactoryImpl {

	@Inject
	private IParser parser;
	@Inject
	private ILinker linker;

	public EmbeddedXtextResourceFactory() {
	}

	@Override
	public Resource createResource(URI uri) {
		EmbeddedXtextResource resource = new EmbeddedXtextResource(uri);
		resource.setParser(parser);
		resource.setLinker(linker);
		resource.setURI(uri);
		return resource;
	}
}
