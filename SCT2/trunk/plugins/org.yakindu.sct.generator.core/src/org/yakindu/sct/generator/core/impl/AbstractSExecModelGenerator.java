/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.core.impl;

import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.FUNCTION_INLINING_FEATURE;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.FUNCTION_INLINING_FEATURE_INLINE_CHOICES;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.FUNCTION_INLINING_FEATURE_INLINE_ENTER_REGION;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.FUNCTION_INLINING_FEATURE_INLINE_ENTER_SEQUENCES;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.FUNCTION_INLINING_FEATURE_INLINE_ENTRIES;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.FUNCTION_INLINING_FEATURE_INLINE_ENTRY_ACTIONS;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.FUNCTION_INLINING_FEATURE_INLINE_EXIT_ACTIONS;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.FUNCTION_INLINING_FEATURE_INLINE_EXIT_REGION;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.FUNCTION_INLINING_FEATURE_INLINE_EXIT_SEQUENCES;
import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.FUNCTION_INLINING_FEATURE_INLINE_REACTIONS;
import static org.yakindu.sct.generator.core.util.GeneratorUtils.getBoolValue;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.transformation.FlowOptimizer;
import org.yakindu.sct.model.sexec.transformation.ModelSequencer;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Injector;

/**
 * abstract base class for all code generators that want to generate code based
 * on the {@link ExecutionFlow}
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractSExecModelGenerator extends
		AbstractSGraphModelGenerator {

	private static final String SEXEC_FILE_EXTENSION = "sexec";

	public AbstractSExecModelGenerator() {
		super();
	}

	@Override
	protected void runGenerator(Statechart statechart, GeneratorEntry entry) {
		if (this instanceof IExecutionFlowGenerator) {
			IExecutionFlowGenerator flowGenerator = (IExecutionFlowGenerator) this;
			flowGenerator.generate(createExecutionFlow(statechart, entry),
					entry, null);
		}
		super.runGenerator(statechart, entry);
	}

	/**
	 * Transforms the {@link Statechart} model to a {@link ExecutionFlow} model
	 */
	protected ExecutionFlow createExecutionFlow(Statechart statechart,
			GeneratorEntry entry) {
		Injector injector = getInjector(entry);
		ModelSequencer sequencer = injector.getInstance(ModelSequencer.class);
		ExecutionFlow flow = sequencer.transform(statechart);
		Assert.isNotNull(flow, "Error creation ExecutionFlow");

		FeatureConfiguration optimizeConfig = entry
				.getFeatureConfiguration(FUNCTION_INLINING_FEATURE);

		FlowOptimizer optimizer = injector.getInstance(FlowOptimizer.class);

		optimizer.inlineReactions(getBoolValue(optimizeConfig,
				FUNCTION_INLINING_FEATURE_INLINE_REACTIONS, true));
		optimizer.inlineExitActions(getBoolValue(optimizeConfig,
				FUNCTION_INLINING_FEATURE_INLINE_EXIT_ACTIONS, true));
		optimizer.inlineEntryActions(getBoolValue(optimizeConfig,
				FUNCTION_INLINING_FEATURE_INLINE_ENTRY_ACTIONS, true));
		optimizer.inlineEnterSequences(getBoolValue(optimizeConfig,
				FUNCTION_INLINING_FEATURE_INLINE_ENTER_SEQUENCES, true));
		optimizer.inlineExitSequences(getBoolValue(optimizeConfig,
				FUNCTION_INLINING_FEATURE_INLINE_EXIT_SEQUENCES, true));
		optimizer.inlineChoices(getBoolValue(optimizeConfig,
				FUNCTION_INLINING_FEATURE_INLINE_CHOICES, true));
		optimizer.inlineEntries(getBoolValue(optimizeConfig,
				FUNCTION_INLINING_FEATURE_INLINE_ENTRIES, true));
		optimizer.inlineEnterRegion(getBoolValue(optimizeConfig,
				FUNCTION_INLINING_FEATURE_INLINE_ENTER_REGION, true));
		optimizer.inlineExitRegion(getBoolValue(optimizeConfig,
				FUNCTION_INLINING_FEATURE_INLINE_EXIT_REGION, true));

		flow = optimizer.transform(flow);

		return flow;
	}

	protected void dumpSexec(GeneratorEntry entry, ExecutionFlow flow) {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet
				.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMIResourceFactoryImpl());
		URI fileURI = entry.getElementRef().eResource().getURI()
				.trimFileExtension().appendFileExtension(SEXEC_FILE_EXTENSION);
		Resource resource = resourceSet.createResource(fileURI);
		resource.getContents().add(flow);
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
		}
	}

}
