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

package org.esmp.dsm.codegen.c.internal.launching;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.eclipse.cdt.core.CCorePlugin;
import org.eclipse.cdt.core.ToolFactory;
import org.eclipse.cdt.core.formatter.CodeFormatter;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.internal.xtend.type.impl.java.JavaBeansMetaModel;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.Output;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;
import org.esmp.dsm.codegen.c.BlockCGenerator;
import org.esmp.dsm.codegen.c.CCodegenContext;
import org.esmp.dsm.codegen.c.DSMCodegenCPlugin;
import org.esmp.dsm.execution.executiongraph.ExecutionGraph;
import org.esmp.dsm.execution.executiongraph.ExecutionGraphPackage;
import org.esmp.dsm.execution.executiongraph.ExecutionNode;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;

/**
 * @author Andreas Unger
 *
 */
public class CCodegenJob extends WorkspaceJob {

	private ExecutionGraph executionGraph;
	private CCodegenContext context;

	/**
	 * @param name
	 */
	public CCodegenJob(ExecutionGraph executionGraph, CCodegenContext context) {
		super("Generating C Code");
		this.executionGraph = executionGraph;
		this.context = context;
	}

	public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
		List<ExecutionNode> nodes = executionGraph.getNodes();
		
		monitor.beginTask("Generating C code", nodes.size() + 1);
		
		generateMainFiles(monitor);
		
		for (ExecutionNode node : executionGraph.getNodes()) {
			if (node.getBlock().isVirtual() || node.getBlock().getType().isStructural()) {
				continue;
			}
			BlockCGenerator generator = (BlockCGenerator) EcoreUtil.getAdapter(node.getBlock().eAdapters(), BlockCGenerator.class);
			generator.generate(context);

			monitor.worked(1);
			if (monitor.isCanceled()) {
				return Status.CANCEL_STATUS;
			}
		}
		
		IContainer root = ResourcesPlugin.getWorkspace().getRoot();
		
		IFolder sourceFolder = root.getFolder(new Path(context.getSourceFolder()));
		sourceFolder.refreshLocal(IResource.DEPTH_INFINITE, monitor);
		formatSourceFiles(sourceFolder, monitor);
		
		if (!context.getSourceFolder().equals(context.getHeaderFolder())) {
			IFolder headerFolder = root.getFolder(new Path(context.getHeaderFolder()));
			headerFolder.refreshLocal(IResource.DEPTH_INFINITE, monitor);
			formatSourceFiles(headerFolder, monitor);
		}
		
		return Status.OK_STATUS;
	}
	
	private void generateMainFiles(IProgressMonitor monitor) throws CoreException {
		IPath wsPath = ResourcesPlugin.getWorkspace().getRoot().getLocation();

		Outlet headerOutlet = new Outlet(wsPath.append(context.getHeaderFolder()).toPortableString());
		headerOutlet.setName("HEADER");
		headerOutlet.setOverwrite(true);

		Outlet sourceOutlet = new Outlet(wsPath.append(context.getSourceFolder()).toPortableString());
		sourceOutlet.setName("SOURCE");
		sourceOutlet.setOverwrite(true);

		Output output = new OutputImpl();
		output.addOutlet(headerOutlet);
		output.addOutlet(sourceOutlet);
		
		XpandExecutionContextImpl executionContext = new XpandExecutionContextImpl(output, null);
		EmfRegistryMetaModel metamodel = new EmfRegistryMetaModel() {

			protected EPackage[] allPackages() {
				return new EPackage[] {
						ExecutionGraphPackage.eINSTANCE,
						BlockDiagramPackage.eINSTANCE,
						EcorePackage.eINSTANCE };
			}
	        
	    };
		executionContext.registerMetaModel(metamodel);
		executionContext.registerMetaModel(new JavaBeansMetaModel());

		XpandFacade facade = XpandFacade.create(executionContext);
		facade.evaluate("org::esmp::dsm::codegen::c::internal::templates::Main::main", executionGraph, context);
	}
	
	private void formatSourceFiles(IFolder folder, IProgressMonitor monitor) throws CoreException {
		CodeFormatter codeFormatter = ToolFactory.createCodeFormatter(null);
		for (IResource resource : folder.members()) {
			if (isSourceFile(resource)) {
				try {
					IFile file = (IFile) resource;
					
					InputStream is = file.getContents();
					byte[] buffer = new byte[is.available()];
					is.read(buffer);
					is.close();
					
					String source = new String(buffer);
					IDocument document = new Document(source);
					codeFormatter.format(CodeFormatter.K_TRANSLATION_UNIT, source, 0, source.length(), 0, null).apply(document);
					file.setContents(new ByteArrayInputStream(document.get().getBytes()), IFile.NONE, monitor);
				} catch (Exception e) {
					DSMCodegenCPlugin.getDefault().getLog().log(
							new Status(IStatus.ERROR, DSMCodegenCPlugin.PLUGIN_ID,
									"Formatting generated source file '" + resource.getFullPath() + "' failed", e));
				}
			}
		}
	}
	
	private boolean isSourceFile(IResource resource) throws CoreException {
		if (resource instanceof IFile) {
			IContentDescription contentDescription = ((IFile) resource).getContentDescription();
			if (contentDescription != null) {
				IContentType contentType = contentDescription.getContentType();
				if (contentType != null) {
					String contentId = contentType.getId();
					return CCorePlugin.CONTENT_TYPE_CHEADER.equals(contentId) || CCorePlugin.CONTENT_TYPE_CSOURCE.equals(contentId);
				}
			}
		}
		return false;
	}

}
