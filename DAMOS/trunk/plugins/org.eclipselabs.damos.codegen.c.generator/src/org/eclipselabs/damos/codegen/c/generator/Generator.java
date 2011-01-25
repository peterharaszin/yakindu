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

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.codegen.c.cgenmodel.CGenModel;
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
import org.eclipselabs.damos.execution.executiongraph.ExecutionGraph;
import org.eclipselabs.damos.execution.executiongraph.Node;
import org.eclipselabs.damos.execution.executiongraph.construct.ExecutionGraphConstructor;
import org.eclipselabs.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class Generator {

	public void generate(final CGenModel genModel, final IProgressMonitor monitor) throws CoreException {
		final ExecutionGraph executionGraph = constructExecutionGraph(genModel, monitor);
		
		for (Node node : executionGraph.getNodes()) {
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
			generator.initialize();
		}
		
		IPath path = new Path(genModel.getTargetFolder());
		IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(path);
		
		IFile headerFile = folder.getFile("execute.h");
		new FileWriter() {
			
			@Override
			protected void write(Writer writer) throws CoreException {
				generateHeader(genModel, executionGraph, new PrintWriter(writer), monitor);
			}
			
		}.write(headerFile, monitor);

		IFile implementationFile = folder.getFile("execute.c");		
		new FileWriter() {
			
			@Override
			protected void write(Writer writer) throws CoreException {
				generateImplementation(genModel, executionGraph, new PrintWriter(writer), monitor);
			}
			
		}.write(implementationFile, monitor);
	}
	
	private ExecutionGraph constructExecutionGraph(CGenModel genModel, IProgressMonitor monitor) throws CoreException {
		ExecutionGraph executionGraph = new ExecutionGraphConstructor().construct(genModel.getExecutionModel().getTopLevelFragment(), monitor);
		new ComponentGeneratorAdaptor().adaptGenerators(genModel, executionGraph, monitor);
		return executionGraph;
	}
	
	private void generateHeader(CGenModel genModel, ExecutionGraph executionGraph, PrintWriter writer, IProgressMonitor monitor) throws CoreException {
		writer.println("#ifndef _EXECUTE_H");
		writer.println("#define _EXECUTE_H");
		writer.println();
		
		writer.println("#include <stdint.h>");

		writer.println("typedef struct {");
		for (Node node : executionGraph.getNodes()) {
			if (!(node.getComponent() instanceof Inport)) {
				continue;
			}
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
			IComponentSignature signature = generator.getSignature();
			OutputPort outputPort = node.getComponent().getFirstOutputPort();
			DataType dataType = signature.getOutputDataType(outputPort);
			writer.printf("%s;\n", MscriptGeneratorUtil.getCVariableDeclaration(genModel.getExecutionModel().getComputationModel(), dataType, StringUtils.uncapitalize(node.getComponent().getName()), false));
		}
		writer.println("} Input;");
		
		writer.println();

		writer.println("typedef struct {");
		for (Node node : executionGraph.getNodes()) {
			if (!(node.getComponent() instanceof Outport)) {
				continue;
			}
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
			IComponentSignature signature = generator.getSignature();
			OutputPort outputPort = node.getComponent().getFirstOutputPort();
			DataType dataType = signature.getOutputDataType(outputPort);
			writer.printf("%s;\n", MscriptGeneratorUtil.getCVariableDeclaration(genModel.getExecutionModel().getComputationModel(), dataType, StringUtils.uncapitalize(node.getComponent().getName()), false));
		}
		writer.println("} Output;");

		writer.println();
		writer.println("void initialize();");
		writer.println("void execute();");

		writer.println();
		writer.println("#endif /* _EXECUTE_H */");
	}
	
	private void generateImplementation(CGenModel genModel, ExecutionGraph executionGraph, PrintWriter writer, IProgressMonitor monitor) throws CoreException {
		writer.println("#include <math.h>");
		writer.println("#include <string.h>");
		writer.println("#include \"execute.h\"");

		writer.println();
		
		boolean hasContext = hasContext(executionGraph);
		if (hasContext) {
			for (Node node : executionGraph.getNodes()) {
				IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
				if (generator.contributesContextCode()) {
					generator.generateContextCode(writer, monitor);
				}
			}
			writer.println("typedef struct {");
			for (Node node : executionGraph.getNodes()) {
				IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
				if (generator.contributesContextCode()) {
					writer.printf("Context_%s %s;\n", node.getComponent().getName(), StringUtils.uncapitalize(node.getComponent().getName()));
				}
			}
			writer.println("} Context;\n");
			writer.println("static Context context;\n");
		}
		
		writer.print("void initialize() {\n");
		for (Node node : executionGraph.getNodes()) {
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
			if (generator.contributesInitializationCode()) {
				writer.printf("/* %s */\n", node.getComponent().getName());
				writer.println("{");
				generator.generateInitializationCode(writer, new VariableAccessor(node), monitor);
				writer.println("}\n");
			}
		}
		writer.print("}\n\n");

		writer.print("void execute(const Input *input, Output *output) {\n");
		
		for (Node node : executionGraph.getNodes()) {
			if (!(node.getComponent() instanceof Block)) {
				continue;
			}
			Block block = (Block) node.getComponent();
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
			for (Output output : block.getOutputs()) {
				BlockOutput blockOutput = (BlockOutput) output;
				int i = blockOutput.getDefinition().isManyPorts() ? 0 : -1;
				for (OutputPort outputPort : output.getPorts()) {
					String suffix = i >= 0 ? Integer.toString(i++) : "";
					String cDataType = MscriptGeneratorUtil.getCDataType(genModel.getExecutionModel().getComputationModel(), generator.getSignature().getOutputDataType(outputPort));
					writer.printf("%s %s_%s%s;\n", cDataType, StringUtils.uncapitalize(block.getName()), blockOutput.getDefinition().getName(), suffix);
				}
			}
		}
		writer.println();

		writer.print("/*\n * Compute outputs\n */\n\n");
		for (Node node : executionGraph.getNodes()) {
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
			if (generator.contributesComputeOutputsCode()) {
				writer.printf("/* %s */\n", node.getComponent().getName());
				writer.println("{");
				generator.generateComputeOutputsCode(writer, new VariableAccessor(node), monitor);
				writer.println("}\n");
			}
		}
		writer.print("\n/*\n * Update states\n */\n\n");
		for (Node node : executionGraph.getNodes()) {
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
			if (generator.contributesUpdateCode()) {
				writer.printf("/* %s */\n", node.getComponent().getName());
				writer.println("{");
				generator.generateUpdateCode(writer, new VariableAccessor(node), monitor);
				writer.println("}\n");
			}
		}
		writer.println("}");
	}
	
	private boolean hasContext(ExecutionGraph executionGraph) {
		for (Node node : executionGraph.getNodes()) {
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
			if (generator.contributesContextCode()) {
				return true;
			}
		}
		return false;
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
