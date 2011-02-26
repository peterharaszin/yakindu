/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.codegen.c.generator;

import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintWriter;
import java.io.Writer;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenModel;
import org.eclipselabs.damos.codegen.c.generator.internal.ComponentGeneratorAdaptor;
import org.eclipselabs.damos.codegen.c.generator.internal.VariableAccessor;
import org.eclipselabs.damos.codegen.c.generator.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.Inport;
import org.eclipselabs.damos.dml.Outport;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.execution.engine.IComponentSignature;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlow;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.execution.executionflow.construct.ExecutionFlowConstructor;
import org.eclipselabs.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModel;
import org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelUtil;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class Generator {

	public void generate(final GenModel genModel, final IProgressMonitor monitor) throws CoreException {
		final ExecutionFlow executionFlow = constructExecutionFlow(genModel, monitor);
		
		for (Node node : executionFlow.getGraph().getNodes()) {
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
			generator.initialize();
		}
		
		IPath headerPath = new Path(genModel.getHeaderDirectory());
		IFolder headerFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(headerPath);
		
		IFile headerFile = headerFolder.getFile(genModel.getMainHeaderFile());
		new FileWriter() {
			
			@Override
			protected void write(Writer writer) throws CoreException {
				generateHeaderFile(genModel, executionFlow, new PrintWriter(writer), monitor);
			}
			
		}.write(headerFile, monitor);

		
		IPath sourcePath = new Path(genModel.getSourceDirectory());
		IFolder sourceFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(sourcePath);
		IFile sourceFile = sourceFolder.getFile(genModel.getMainSourceFile());		
		new FileWriter() {
			
			@Override
			protected void write(Writer writer) throws CoreException {
				generateSourceFile(genModel, executionFlow, new PrintWriter(writer), monitor);
			}
			
		}.write(sourceFile, monitor);
	}
	
	private ExecutionFlow constructExecutionFlow(GenModel genModel, IProgressMonitor monitor) throws CoreException {
		ExecutionFlow executionFlow = new ExecutionFlowConstructor().construct(genModel.getGenTopLevelSystem().getFragment(), monitor);
		new ComponentGeneratorAdaptor().adaptGenerators(genModel, executionFlow, monitor);
		return executionFlow;
	}
	
	private void generateHeaderFile(GenModel genModel, ExecutionFlow executionFlow, PrintWriter writer, IProgressMonitor monitor) throws CoreException {
		String headerFileName = new Path(genModel.getMainHeaderFile()).lastSegment();
		String headerMacro = headerFileName.replaceAll("\\W", "_").toUpperCase() + "_";
		
		String prefix = genModel.getGenTopLevelSystem().getPrefix();
		if (prefix == null) {
			prefix = "";
		}
		
		writer.printf("#ifndef %s\n", headerMacro);
		writer.printf("#define %s\n", headerMacro);
		writer.println();
		
		writer.println("#include <stdint.h>");

		writer.println();

		writer.println("typedef struct {");
		for (Node node : executionFlow.getGraph().getNodes()) {
			if (!(node instanceof ComponentNode)) {
				continue;
			}
			ComponentNode componentNode = (ComponentNode) node;
			if (!(componentNode.getComponent() instanceof Inport)) {
				continue;
			}
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
			IComponentSignature signature = generator.getSignature();
			OutputPort outputPort = componentNode.getComponent().getFirstOutputPort();
			DataType dataType = signature.getOutputDataType(outputPort);
			writer.printf("%s;\n", MscriptGeneratorUtil.getCVariableDeclaration(getComputationModel(genModel, componentNode), dataType, InternalGeneratorUtil.uncapitalize(componentNode.getComponent().getName()), false));
		}
		writer.printf("} %sInput;\n", prefix);
		
		writer.println();

		writer.println("typedef struct {");
		for (Node node : executionFlow.getGraph().getNodes()) {
			if (!(node instanceof ComponentNode)) {
				continue;
			}
			ComponentNode componentNode = (ComponentNode) node;
			if (!(componentNode.getComponent() instanceof Outport)) {
				continue;
			}
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
			IComponentSignature signature = generator.getSignature();
			OutputPort outputPort = componentNode.getComponent().getFirstOutputPort();
			DataType dataType = signature.getOutputDataType(outputPort);
			writer.printf("%s;\n", MscriptGeneratorUtil.getCVariableDeclaration(getComputationModel(genModel, componentNode), dataType, InternalGeneratorUtil.uncapitalize(componentNode.getComponent().getName()), false));
		}
		writer.printf("} %sOutput;\n", prefix);

		writer.println();
		writer.printf("void %sinitialize(void);\n", prefix);
		writer.printf("void %sexecute(const %sInput *input, %sOutput *output);\n", prefix, prefix, prefix);

		writer.println();
		writer.printf("#endif /* %s */\n", headerMacro);
	}
	
	private void generateSourceFile(GenModel genModel, ExecutionFlow executionFlow, PrintWriter writer, IProgressMonitor monitor) throws CoreException {
		String prefix = genModel.getGenTopLevelSystem().getPrefix();
		if (prefix == null) {
			prefix = "";
		}

		writer.println("#include <math.h>");
		writer.println("#include <string.h>\n");
		writer.printf("#include \"%s\"\n", genModel.getMainHeaderFile());

		writer.println();
		
		boolean hasContext = hasContext(executionFlow);
		if (hasContext) {
			for (Node node : executionFlow.getGraph().getNodes()) {
				if (!(node instanceof ComponentNode)) {
					continue;
				}
				ComponentNode componentNode = (ComponentNode) node;
				IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
				if (generator.contributesContextCode()) {
					String typeName = InternalGeneratorUtil.getPrefix(genModel, node) + componentNode.getComponent().getName() + "_Context";
					generator.generateContextCode(writer, typeName, monitor);
				}
			}
			writer.println("typedef struct {");
			for (Node node : executionFlow.getGraph().getNodes()) {
				if (!(node instanceof ComponentNode)) {
					continue;
				}
				ComponentNode componentNode = (ComponentNode) node;
				IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
				if (generator.contributesContextCode()) {
					writer.printf("%s%s_Context %s;\n", InternalGeneratorUtil.getPrefix(genModel, node), componentNode.getComponent().getName(), InternalGeneratorUtil.getPrefix(genModel, node) + componentNode.getComponent().getName());
				}
			}
			writer.printf("} %sContext;\n\n", prefix);
			writer.printf("static %sContext %scontext;\n\n", prefix, prefix);
		}
		
		writer.printf("void %sinitialize(void) {\n", prefix);
		for (Node node : executionFlow.getGraph().getNodes()) {
			if (!(node instanceof ComponentNode)) {
				continue;
			}
			ComponentNode componentNode = (ComponentNode) node;
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
			if (generator.contributesInitializationCode()) {
				writer.printf("/* %s */\n", componentNode.getComponent().getName());
				writer.println("{");
				generator.generateInitializationCode(writer, new VariableAccessor(genModel, componentNode), monitor);
				writer.println("}\n");
			}
		}
		writer.print("}\n\n");

		writer.printf("void %sexecute(const %sInput *input, %sOutput *output) {\n", prefix, prefix, prefix);
		
		for (Node node : executionFlow.getGraph().getNodes()) {
			if (!(node instanceof ComponentNode)) {
				continue;
			}
			ComponentNode componentNode = (ComponentNode) node;
			if (!(componentNode.getComponent() instanceof Block)) {
				continue;
			}
			Block block = (Block) componentNode.getComponent();
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
			for (Output output : block.getOutputs()) {
				BlockOutput blockOutput = (BlockOutput) output;
				int i = blockOutput.getDefinition().isManyPorts() ? 0 : -1;
				for (OutputPort outputPort : output.getPorts()) {
					String suffix = i >= 0 ? Integer.toString(i++) : "";
					String cDataType = MscriptGeneratorUtil.getCDataType(getComputationModel(genModel, componentNode), generator.getSignature().getOutputDataType(outputPort));
					writer.printf("%s %s%s_%s%s;\n", cDataType, InternalGeneratorUtil.getPrefix(genModel, node), block.getName(), blockOutput.getDefinition().getName(), suffix);
				}
			}
		}
		writer.println();

		writer.print("/*\n * Compute outputs\n */\n\n");
		for (Node node : executionFlow.getGraph().getNodes()) {
			if (!(node instanceof ComponentNode)) {
				continue;
			}
			ComponentNode componentNode = (ComponentNode) node;
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
			if (generator.contributesComputeOutputsCode()) {
				writer.printf("/* %s */\n", componentNode.getComponent().getName());
				writer.println("{");
				generator.generateComputeOutputsCode(writer, new VariableAccessor(genModel, componentNode), monitor);
				writer.println("}\n");
			}
		}
		writer.print("\n/*\n * Update states\n */\n\n");
		for (Node node : executionFlow.getGraph().getNodes()) {
			if (!(node instanceof ComponentNode)) {
				continue;
			}
			ComponentNode componentNode = (ComponentNode) node;
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
			if (generator.contributesUpdateCode()) {
				writer.printf("/* %s */\n", componentNode.getComponent().getName());
				writer.println("{");
				generator.generateUpdateCode(writer, new VariableAccessor(genModel, componentNode), monitor);
				writer.println("}\n");
			}
		}
		writer.println("}");
	}
	
	private boolean hasContext(ExecutionFlow executionFlow) {
		for (Node node : executionFlow.getGraph().getNodes()) {
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
			if (generator.contributesContextCode()) {
				return true;
			}
		}
		return false;
	}
	
	private ComputationModel getComputationModel(GenModel genModel, ComponentNode node) {
		ComputationModel computationModel = genModel.getExecutionModel().getComputationModel(node.getComponent().getOwningFragment());
		if (computationModel == null) {
			computationModel = ComputationModelUtil.constructDefaultComputationModel();
		}
		return computationModel;
	}
		
	private static abstract class FileWriter {

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void write(final IFile targetFile, final IProgressMonitor monitor) throws CoreException {
			try {
				final PipedInputStream pipedInputStream = new PipedInputStream();
				PipedOutputStream pipedOutputStream = new PipedOutputStream(pipedInputStream);
				final Writer writer = new OutputStreamWriter(pipedOutputStream);
				
				Thread thread = new Thread() {
					
					@Override
					public void run() {
						try {
							if (targetFile.exists()) {
								targetFile.setContents(pipedInputStream, true, false, monitor);
							} else {
								targetFile.create(pipedInputStream, true, monitor);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					
				};
		
				thread.start();
				
				write(writer);
				writer.close();
				
				thread.join();
			} catch (Exception e) {
				throw new CoreException(new Status(IStatus.ERROR, CodegenCGeneratorPlugin.PLUGIN_ID, "Writing file '" + targetFile.getName() + "' failed", e));
			}
		}
		
		protected abstract void write(Writer writer) throws CoreException;
		
	}
	
}
