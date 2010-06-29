/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.esmp.dsm.codegen.c;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.internal.xtend.type.impl.java.JavaBeansMetaModel;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.Output;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;
import org.esmp.dsm.execution.executiongraph.ExecutionGraphPackage;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;

/**
 * @author Andreas Unger
 *
 */
public class XpandBlockCGenerator extends BlockCGenerator {

	private static final String TEMPLATE_NAME_ATTRIBUTE = "template";
	private String templateName;
	
	/**
	 * @param configurationElement
	 */
	public XpandBlockCGenerator(IConfigurationElement configurationElement) {
		super(configurationElement);
		templateName = getRequiredAttribute(configurationElement, TEMPLATE_NAME_ATTRIBUTE);
	}

	public void generate(CCodegenContext context) {
		getXpandFacade(context).evaluate(templateName, getTarget(), context);
	}
	
	protected XpandFacade getXpandFacade(CCodegenContext context) {
		XpandFacade facade = (XpandFacade) context.getData().get(XpandFacade.class);
		if (facade == null) {
			IPath wsPath = ResourcesPlugin.getWorkspace().getRoot().getLocation();
			
			Outlet headerOutlet = new Outlet(wsPath.append(context.getHeaderFolder()).toPortableString());
			headerOutlet.setName("HEADER");
			headerOutlet.setOverwrite(true);

			Outlet sourceOutlet = new Outlet(wsPath.append(context.getSourceFolder()).toPortableString());
			sourceOutlet.setName("SOURCE");
			sourceOutlet.setOverwrite(true);
			
			Output output = new OutputImpl();
			output.addOutlet(sourceOutlet);
			output.addOutlet(headerOutlet);
			
			XpandExecutionContextImpl executionContext = new XpandExecutionContextImpl(output, null);
			EmfRegistryMetaModel metamodel = new EmfRegistryMetaModel() {

				protected EPackage[] allPackages() {
					return getRequiredEPackages();
				}
		        
		    };
			executionContext.registerMetaModel(metamodel);
			executionContext.registerMetaModel(new JavaBeansMetaModel());

			facade = XpandFacade.create(executionContext);
			context.getData().put(XpandFacade.class, facade);
		}
		return facade;
	}
	
	protected EPackage[] getRequiredEPackages() {
		return new EPackage[] {
				ExecutionGraphPackage.eINSTANCE,
				BlockDiagramPackage.eINSTANCE,
				EcorePackage.eINSTANCE };
	}

	private String getRequiredAttribute(IConfigurationElement configurationElement, String name) {
		String value = configurationElement.getAttribute(name);
		if (value == null) {
			throw new IllegalArgumentException("Missing '" + name + "' attribute");
		}
		return value;
	}

}
