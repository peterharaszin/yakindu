package org.yakindu.sct.generator.base.util;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.SexecPackage;
import org.yakindu.sct.model.sexec.transformation.ModelSequencer;
import org.yakindu.sct.model.sexec.transformation.SequencerModule;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.stext.StextPackage;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class GeneratorBaseUtil {

	/**
	 * Loads a {@link Statechart} model via the registered resource for a given
	 * {@link URI}
	 */
	public static Statechart loadStatechart(URI uri) throws IOException {
		Factory factory = ResourceFactoryRegistryImpl.INSTANCE.getFactory(uri);
		Resource resource = factory.createResource(uri);
		resource.load(Collections.emptyMap());
		Statechart statechart = (Statechart) resource.getContents().get(0);
		Assert.isNotNull(statechart);
		return statechart;

	}

	/**
	 * Transforms the {@link Statechart} model to a {@link ExecutionFlow} model
	 */
	public static ExecutionFlow createExecutionFlowModel(Statechart statechart) {
		Injector injector = Guice.createInjector(new SequencerModule());
		ModelSequencer sequencer = injector.getInstance(ModelSequencer.class);
		ExecutionFlow flow = sequencer.transform(statechart);
		Assert.isNotNull(flow);
		return flow;
	}

	/**
	 * Invokes the Template engine to generate resources
	 */
	public static void generate(ExecutionFlow flow, String templatePath,
			IProject project, String targetFolder) throws CoreException {

		String absoluteTargetFolder = ResourcesPlugin.getWorkspace().getRoot()
				.getLocation().toOSString()
				+ File.separator
				+ project.getFullPath().toOSString()
				+ File.separator + targetFolder;

		OutputImpl output = new OutputImpl();
		Outlet outlet = new Outlet(absoluteTargetFolder);
		outlet.setOverwrite(true);
		output.addOutlet(outlet);

		XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(
				output, null, Collections.<String, Variable> emptyMap(), null,
				null);
		EmfRegistryMetaModel metamodel = new EmfRegistryMetaModel() {
			@Override
			protected EPackage[] allPackages() {
				return new EPackage[] { SGraphPackage.eINSTANCE,
						StextPackage.eINSTANCE, EcorePackage.eINSTANCE,
						SexecPackage.eINSTANCE };
			}
		};
		execCtx.registerMetaModel(metamodel);
		// generate
		XpandFacade facade = XpandFacade.create(execCtx);
		facade.evaluate(templatePath, flow);
		// refresh the project to get external updates:
		project.refreshLocal(IResource.DEPTH_INFINITE,
				new NullProgressMonitor());
	}
}
