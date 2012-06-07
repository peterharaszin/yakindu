package org.eclipselabs.damos.dconfig.internal.registry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;

/**
 * @author Andreas Unger
 *
 */
public class DefinitionRegistry {

	private static final DefinitionRegistry INSTANCE = new DefinitionRegistry();

	private List<URI> definitionResourceURIs = new ArrayList<URI>();
	
	/**
	 * 
	 */
	protected DefinitionRegistry() {
		initializeFromStorage();
	}

	/**
	 * @return the instance
	 */
	public static DefinitionRegistry getInstance() {
		return INSTANCE;
	}
	
	/**
	 * @return the providers
	 */
	public Collection<URI> getDefinitionResourceURIs() {
		return definitionResourceURIs;
	}
	
	public void registerDefinitionResourceURI(URI uri) {
		definitionResourceURIs.add(uri);
	}
	
	public void unregisterDefinitionResourceURI(URI uri) {
		definitionResourceURIs.remove(uri);
	}

	private void initializeFromStorage() {
		DefinitionRegistryReader reader = new DefinitionRegistryReader();
		reader.registerProviders(this);
	}

}
