package org.yakindu.sct.generator.core.impl;

import static org.yakindu.sct.generator.core.features.IXpandFeatureConstants.TEMPLATE_FEATURE;
import static org.yakindu.sct.generator.core.features.IXpandFeatureConstants.TEMPLATE_FEATURE_TEMPLATE_PATH;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.mwe.core.resources.ResourceLoader;
import org.eclipse.emf.mwe.core.resources.ResourceLoaderFactory;
import org.eclipse.emf.mwe.core.resources.ResourceLoaderImpl;
import org.yakindu.sct.generator.core.features.IXpandFeatureConstants;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.GeneratorEntry;

public class GenericXPandCodeGenerator extends AbstractXpandBasedCodeGenerator {

	private String templatePath;

	@Override
	protected void prepareGenerator(GeneratorEntry entry) {
		templatePath = entry.getFeatureConfiguration(TEMPLATE_FEATURE)
				.getParameterValue(TEMPLATE_FEATURE_TEMPLATE_PATH).getValue();
		ResourceLoaderFactory
				.setCurrentThreadResourceLoader(createResourceLoader(entry));
	}

	@Override
	protected void finishGenerator(GeneratorEntry entry) {
		ResourceLoaderFactory.setCurrentThreadResourceLoader(null);
	}

	/**
	 * create a {@link ResourceLoader} for the XPandFacade
	 */
	protected ResourceLoader createResourceLoader(final GeneratorEntry entry) {
		IProject project = getLookupRoot(entry);
		final ClassLoader classLoader = new WorkspaceClassLoaderFactory()
				.createClassLoader(project);
		return new ResourceLoaderImpl(classLoader);
	}

	/**
	 * resolve the project that defines the lookup path for the XpandFacade
	 * 
	 */
	protected IProject getLookupRoot(GeneratorEntry entry) {
		IProject project = null;
		FeatureConfiguration templateConfig = entry
				.getFeatureConfiguration(IXpandFeatureConstants.TEMPLATE_FEATURE);
		FeatureParameterValue projectName = templateConfig
				.getParameterValue(IXpandFeatureConstants.TEMPLATE_FEATURE_TEMPLATE_PROJECT);
		if (projectName != null) {
			project = ResourcesPlugin.getWorkspace().getRoot()
					.getProject(projectName.getValue());
		} else {
			URI uri = entry.getStatechart().eResource().getURI();
			project = ResourcesPlugin.getWorkspace().getRoot()
					.getFile(new Path(uri.toPlatformString(true))).getProject();
		}
		return project;
	}

	@Override
	public String getTemplatePath() {
		return templatePath;
	}

}
